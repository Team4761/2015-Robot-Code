package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

/**
 * Just waits until a barrel is found
 */
public class CheckForBarrel extends Command {
	ShortDistanceSensor distanceSensor = RobotMap.barrelSensor;
	double distance;
	double lastDistance;
	public CheckForBarrel() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}
	
	protected void initialize() {
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		//TODO: Take care of spike at beginning.
		distance = getMovingAverage(distanceSensor.getDistance());
		if(distance < 25) { //at a barrel
			if(distance - lastDistance < 0) { //sensor at ideal grabbing spot
				return true;
			}
		}
		lastDistance = distance;
		return false;
	}
	
	protected void end() {
	}
	
	protected void interrupted() {
	}
	
	private double[] array = new double[3];
	private int count = 0;
	/**
	 * Get next number in simple moving average data. SMA is the unweighted
	 * mean of the previous <i>n</i> data. I'm bad at explaining this, so check
	 * <a href="https://en.wikipedia.org/wiki/Moving_average#Simple_moving_average">Wikipedia</a> 
	 * if you are confused.
	 * @param number Next number to work with
	 * @return SMA'd number
	 */
	private double getMovingAverage(double number) {
		//TODO: Filter out noise in the beginning. First couple number should be ignored.
		//TODO: tweak values to consistently produce a smooth graph.
		array[count % 3] = number;
		count++;
		return (array[0] + array[1] + array[2]) / 3;
	}
}
