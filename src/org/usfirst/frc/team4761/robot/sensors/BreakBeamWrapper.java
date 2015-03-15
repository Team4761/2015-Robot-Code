package org.usfirst.frc.team4761.robot.sensors;

/**
* Wrapper a distance sensor which is acting as a break-beam sensor.
*/
public class BreakBeamWrapper {
	private double threshold = 50;	// half a meter default threshold
	private DistanceSensor sensor;
	
	public BreakBeamWrapper(DistanceSensor sensor) {
		this.sensor = sensor;
	}
	/**
	 * Gets threshold distance
	 * @return Threshold distance in centimeters.
	 */
	public double getThreshold() {
		return threshold;
	}
	/**
	 * Sets the threshold distance
	 * @param threshold Distance in centimeters.
	 */
	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}
	/**
	 * Gets whether or not the distance sensor is detecting a distance less
	 * than the threshold.
	 * @return Past threshold? (t/f)
	 */
	public boolean get() {
		return sensor.getDistance() < threshold;
	}
}
