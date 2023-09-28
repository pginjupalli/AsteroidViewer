/**This is a manager class that allows a User to view, sort, display databases
 * 
 * @author Pooja Ginjupalli\
 */

import java.util.Scanner;

public class NeoViewer {
	public static void main (String args[]) throws IllegalArgumentException {
		Scanner kb = new Scanner(System.in);
		NeoDatabase db = new NeoDatabase();
		ReferenceIDComparator rComp = new ReferenceIDComparator();
		DiameterComparator dComp = new DiameterComparator();
		ApproachDateComparator aComp = new ApproachDateComparator();
		MissDistanceComparator mComp = new MissDistanceComparator();
		
		String choice;
		String miniChoice;
		int pageNum;
		
		System.out.println("Welcome to NEO Viewer!\n");
		while (true) {
			System.out.println();
			System.out.print("Option Menu:\r\n"
					+ "    A) Add a page to the database\r\n"
					+ "    S) Sort the database \r\n"
					+ "    P) Print the database as a table.\r\n"
					+ "    Q) Quit\r\n"
					+ "  \r\n"
					+ "Select a menu option: ");
			choice = kb.nextLine().toUpperCase();
			System.out.println();
			
			switch (choice) {
			case "A":
				System.out.print("Enter the page to load: ");
				try {
					pageNum = Integer.parseInt(kb.nextLine().trim());
					db.addAll(db.buildQueryURL(pageNum));
				} catch (NumberFormatException e) {
					System.out.println("Invalid: Not an integer.");
					break;
				} catch (IllegalArgumentException e) {
					System.out.println("Invalid: Not a valid page number.");
					break;
				}
				System.out.println("Page loaded successfully!\n");
				break;
				
			case "S":
				if (db.isEmpty()) {
					System.out.println("Invalid: No database is loaded.");
					break;
				}
				System.out.print("  R) Sort by referenceID\r\n"
						+ "  D) Sort by diameter\r\n"
						+ "  A) Sort by approach date\r\n"
						+ "  M) Sort by miss distance\r\n"
						+ "  \r\n"
						+ "Select a menu option: ");
				miniChoice = kb.nextLine();
				System.out.println();
				
				if (miniChoice.equalsIgnoreCase("R")) {
					db.sort(rComp);
					System.out.println("Table sorted on reference ID.");
				} else if (miniChoice.equalsIgnoreCase("D")) {
					db.sort(dComp);
					System.out.println("Table sorted on diameter.");
				} else if (miniChoice.equalsIgnoreCase("A")) {
					db.sort(aComp);
					System.out.println("Table sorted on approach date.");
				} else if (miniChoice.equalsIgnoreCase("M")) {
					db.sort(mComp);
					System.out.println("Table sorted on miss distance.");
				} else {
					System.out.println("Invalid: Not a valid choice.");
				}
				break;
				
			case "P":
				if (db.isEmpty()) {
					System.out.println("Invalid: No database is loaded.");
					break;
				}
				db.printTable();
				break;
				
			case "Q":
				System.out.println("Program terminating normally...");
				System.exit(0);
				
			default:
				System.out.println("Invalid: Not a valid choice.");
			}
		}
		
	}
}
