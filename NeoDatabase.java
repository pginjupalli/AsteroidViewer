/**This class is a database for NearEarthObjects that reads a file to get information
 * 
 * @author Pooja Ginjupalli
 */

import java.util.*;
import org.json.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;

import big.data.DataSource;

public class NeoDatabase {
	private static final String API_KEY = "kVq6GPO2daJFevO8rDM7Aj36QJdXyCqapv4flLYW";
	private static final String API_ROOT = "https://api.nasa.gov/neo/rest/v1/neo/browse?";
	private ArrayList<NearEarthObject> meteors = new ArrayList<NearEarthObject>();
	
	/**Builds a query URL given a page number
	 * 
	 * @param pageNumber
	 * 	The page number indicating which page the User wishes to load
	 * 
	 * @return
	 * 	Returns a query URL
	 * 
	 * @Precondition:
	 * 	pageNumber is between 0 and 715 (inclusive)
	 * 
	 * @exception IllegalArgumentException
	 * 	Indicates pageNumber is less than 0 or greater than 715
	 */
	public String buildQueryURL(int pageNumber) throws IllegalArgumentException {
		if (pageNumber < 0 || pageNumber > 715)
			throw new IllegalArgumentException();
		return (API_ROOT + "page=" + pageNumber + "&api_key=" + API_KEY);
	}
	
	/**Opens a connection to the data source indicated by queryURL 
	 * and adds all NearEarthObjects found in the dataset
	 * 
	 * @param queryURL
	 * 	String containing the URL requesting a dataset from the NASA NeoW service
	 * 
	 * @Precondition:
	 * 	queryURL is a non-null string representing a valid API request to the NASA NeoW service
	 * 
	 * @Postcondition:
	 * 	All NearEarthObject records returned have been added to the database
	 * 
	 * @exception IllegalArgumentException
	 * 	Indicates queryURL is null
	 */
	public void addAll(String queryURL) throws IllegalArgumentException {
		if (queryURL == null)
			throw new IllegalArgumentException();
		
		DataSource ds = DataSource.connectJSON(queryURL);
	    ds.load();
	    
	    NearEarthObject[] meteors = ds.fetchArray("hw7.NearEarthObject",
	     		"near_earth_objects/neo_reference_id",
	     		"near_earth_objects/name",
	    		"near_earth_objects/absolute_magnitude_h", 
	    		"near_earth_objects/estimated_diameter/kilometers/estimated_diameter_min",
	    		"near_earth_objects/estimated_diameter/kilometers/estimated_diameter_max", 
	    		"near_earth_objects/is_potentially_hazardous_asteroid",
	    		"near_earth_objects/close_approach_data/epoch_date_close_approach", 
	    		"near_earth_objects/close_approach_data/miss_distance/kilometers",
	    		"near_earth_objects/close_approach_data/orbiting_body");
	    
	    for (NearEarthObject object : meteors) {
	    	this.meteors.add(object);
	    }
	}
	
	/**Sorts the database using the specified Comparator of NearEarthObjects
	 * 
	 * @param comp
	 * 	Comparator of NearEarthObjects which will be used to sort the database
	 * 
	 * @Precondition:
	 * 	comp is not null
	 * 
	 * @Postcondition:
	 * 	The database has been sorted based on the order specified by the inidcated Comparator of NearEarthObjects
	 * 
	 * @exception IllegalArgumentException
	 * 	Indicates comp is null
	 */
	public void sort(Comparator<NearEarthObject> comp) throws IllegalArgumentException {
		if (comp == null)
			throw new IllegalArgumentException();
		Collections.sort(meteors, comp);
	}
	
	/**Prints a table listing information regarding every NearEarthObject in the database
	 */
	public void printTable() {
		System.out.println("  ID   |           Name            | Mag. | Diameter | Danger | Close Date | Miss Dist | Orbits\r\n"
				+ "================================================================================================");
		
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		String date;
		String name;
		
		for (NearEarthObject m : meteors) {
			date = format.format(m.getClosestApproachDate());
			if (m.getName().length() > 26)
				name = m.getName().substring(0, 26);
			else
				name = m.getName();
			
			System.out.format("%-8s  %-26s  %-5s   %-8s  %-8s  %-7s  %-10s  %-7s\n",
				m.getReferenceID(), name, 
				String.format("%.1f", m.getAbsoluteMagnitude()), 
				String.format("%.3f", m.getAverageDiameter()), m.isDangerous(), date, 
				Math.round(m.getMissDistance()), m.getOrbitingBody());
		}
	}
	
	/**Determines if the database is currently empty
	 * 
	 * @return
	 * 	True is there is at least 1 object within the database, 
	 * 	False otherwise
	 */
	public boolean isEmpty() {
		return (meteors.isEmpty());
	}
 }
