/**Used in Collections.sort() to sort a list of NearEarthObjects by miss distance in ascending order
 * 
 * @author Pooja Ginjupalli
 */
import java.util.Comparator;

public class MissDistanceComparator implements Comparator<NearEarthObject>{

	/**Overrides the compare method to compare the miss distances of 2 NearEarthObjects
	 * @param o1
	 * 	The first object to be compared
	 * 
	 * @param o2
	 * 	The second object to be compared
	 * 
	 * @return:
	 * 	An int indicating if the first object is before, after, or identical 
	 * 	to the second object
	 */
	public int compare(NearEarthObject o1, NearEarthObject o2) {
		return Double.valueOf(o1.getMissDistance()).compareTo(Double.valueOf(o2.getMissDistance()));
	}
}
