package org.usfirst.frc.team4761.robot.commands.debug;

import org.simonandrews.robolog.Level;
import org.simonandrews.robolog.Logger;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * A command to utilize logging with simon's {@link org.simonandrews.robolog robolog library}.
 */
public class LogToFile extends Command {
	private Logger log = RobotMap.log;
	private double rotation = 0;
	
	protected void initialize() {
		log.setLevel(Level.FATAL);
        //RobotMap.imu.zeroYaw();
        setTimeout(0.5);
	}
	
	protected void execute() {
		System.out.println("2: " + RobotMap.testDistanceSensor1.getDistance());
		//System.out.println(RobotMap.mousetrapFired.get());
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
