/**This class represents an object that's near Earth and contains information regarding it
 * 
 * @author Pooja Ginjupalli
 */

import java.util.Date;

public class NearEarthObject {
	private int referenceID;
	private String name;
	private double absoluteMagnitude;
	private double averageDiameter;
	private boolean isDangerous;
	private Date closestApproachDate;
	private double missDistance;
	private String orbitingBody;
	
	/**Creates an instance of NearEarthObject
	 * 
	 * @param referenceID
	 * 	Unique the ID of the NEO
	 * @param name
	 * 	Unique name of the asteroid or orbital body
	 * @param absoluteMagnitude
	 * 	Absolute brightness of the asteroid or orbital body in the sky
	 * @param minDiameter
	 * 	Estimated minimum diameter of the asteroid or orbital body in kilometers
	 * @param maxDiameter
	 * 	Estimated maximum diameter of the asteroid or orbital body in kilometers
	 * @param isDangerous
	 * 	Boolean value indicating whether the astroid or orbital body is a potential impact threat
	 * @param closestDateTimestamp
	 * 	Unix timestamp representing the date of closest approach
	 * @param missDistance
	 * 	Distance in kilometers at which the asteroid or orbital body will pass by the Earth on the date of it's closest approach
	 * @param orbitingBody
	 * 	Planet or other orbital body which this NEO orbits
	 */
	public NearEarthObject(int referenceID, String name, double absoluteMagnitude, 
			double minDiameter, double maxDiameter, boolean isDangerous, long closestDateTimestamp, 
			double missDistance, String orbitingBody) {
		
		this.referenceID = referenceID;
		this.name = name;
		this.absoluteMagnitude = absoluteMagnitude;
		this.averageDiameter = (minDiameter + maxDiameter) / 2;
		this.isDangerous = isDangerous;
		this.closestApproachDate = new Date(closestDateTimestamp);
		this.missDistance = missDistance;
		this.orbitingBody = orbitingBody;
	}

	/**Returns the reference ID of this object
	 * 
	 * @return
	 * 	Returns the reference ID of this object
	 */
	public int getReferenceID() {
		return referenceID;
	}

	/**Sets the reference ID to the one passed
	 * 
	 * @param referenceID
	 * 	The new reference ID
	 */
	public void setReferenceID(int referenceID) {
		this.referenceID = referenceID;
	}

	/**Returns the name of this object
	 * 
	 * @return
	 * 	Returns the name of this object
	 */
	public String getName() {
		return name;
	}

	/**Sets the name to the one passed
	 * 
	 * @param name
	 * 	The new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**Returns the magnitude of this object
	 * 
	 * @return
	 * 	Returns the magnitude of this object
	 */
	public double getAbsoluteMagnitude() {
		return absoluteMagnitude;
	}

	/**Sets the magnitude to the one passed
	 * 
	 * @param absoluteMagnitude
	 * 	The magnitude
	 */
	public void setAbsoluteMagnitude(double absoluteMagnitude) {
		this.absoluteMagnitude = absoluteMagnitude;
	}

	/**Returns the average diameter of this object
	 * 
	 * @return
	 * 	Returns the average diameter of this object
	 */
	public double getAverageDiameter() {
		return averageDiameter;
	}

	/**Sets the average diameter to the one passed
	 * 
	 * @param averageDiatmeter
	 * 	The new average diameter
	 */
	public void setAverageDiameter(double averageDiameter) {
		this.averageDiameter = averageDiameter;
	}

	/**Returns whether or not the object is dangerous
	 * 
	 * @return
	 * 	Returns the danger of this object
	 */
	public boolean isDangerous() {
		return isDangerous;
	}

	/**Sets whether or not the object is dangerous to the one passed
	 * 
	 * @param isDangerous
	 * 	Whether or not the object is dangerous
	 */
	public void setDangerous(boolean isDangerous) {
		this.isDangerous = isDangerous;
	}

	/**Returns the approach date of this object
	 * 
	 * @return
	 * 	Returns the approach date of this object
	 */
	public Date getClosestApproachDate() {
		return closestApproachDate;
	}

	/**Sets the closest approach date to the one passed
	 * 
	 * @param closestApproachDate
	 * 	The new closest approach date
	 */
	public void setClosestApproachDate(Date closestApproachDate) {
		this.closestApproachDate = closestApproachDate;
	}

	/**Returns the miss distance of this object
	 * 
	 * @return
	 * 	Returns the miss distance of this object
	 */
	public double getMissDistance() {
		return missDistance;
	}

	/**Sets the miss distance to the one passed
	 * 
	 * @param missDistance
	 * 	The new miss distance
	 */
	public void setMissDistance(double missDistance) {
		this.missDistance = missDistance;
	}

	/**Returns the orbiting body of this object
	 * 
	 * @return
	 * 	Returns the orbiting body of this object
	 */
	public String getOrbitingBody() {
		return orbitingBody;
	}

	/**Sets the orbiting body to the one passed
	 * 
	 * @param orbitingBody
	 * 	The new orbiting body
	 */
	public void setOrbitingBody(String orbitingBody) {
		this.orbitingBody = orbitingBody;
	}
}
