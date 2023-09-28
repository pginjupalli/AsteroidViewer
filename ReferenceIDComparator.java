/**Used in Collections.sort() to sort a list of NearEarthObjects by referenceID in ascending order
 * 
 * @author Pooja Ginjupalli
 */

import java.util.Comparator;

public class ReferenceIDComparator implements Comparator<NearEarthObject>{
	
	/**Overrides the compare method to compare the referenceIDs of 2 NearEarthObjects
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
		return Integer.valueOf(o1.getReferenceID()).compareTo(Integer.valueOf(o2.getReferenceID()));
	}
}
