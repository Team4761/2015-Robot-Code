package org.usfirst.frc.team4761.robot.commands;

import org.simonandrews.robolog.Level;
import org.simonandrews.robolog.Logger;
import org.usfirst.frc.team4761.robot.AnalogAxisToDigital;
import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.GyroSensor;
import org.usfirst.frc.team4761.robot.sensors.MediumDistanceSensor;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * A command to utilize logging with simon's {@link org.simonandrews.robolog robolog library}.
 */
public class LogToFile extends Command {
	
	private ShortDistanceSensor outerConveyorBarrelDistanceSensor = RobotMap.outerConveyorBarrelDistanceSensor;
	private MediumDistanceSensor barrelSensor = RobotMap.barrelDistanceSensor;
	private Logger log = RobotMap.log;
	private AnalogAxisToDigital slowButton1 = new AnalogAxisToDigital(4, 1);
	private AnalogAxisToDigital slowButton2 = new AnalogAxisToDigital(5, 1);

	
	protected void initialize() {
		log.setLevel(Level.FATAL);
	}
	
	protected void execute() {
		/*log.dev("Slow Button 2: " + slowButton1.get());
		log.dev("Slow Button 2: " + slowButton2.get());
		log.dev("Raw Slow Button 1: " + Robot.oi.joysticks[1].getRawAxis(4));
		log.dev("Raw Slow Button 2: " + Robot.oi.joysticks[1].getRawAxis(5));*/
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		end();
	}
}
