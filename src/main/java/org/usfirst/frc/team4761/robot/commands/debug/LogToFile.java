package org.usfirst.frc.team4761.robot.commands.debug;

import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * A command that logs the IMU's yaw value to SmartDashboard
 */
public class LogToFile extends Command {
	private double rotation = 0;
	
	protected void initialize() {
        RobotMap.imu.zeroYaw();
        setTimeout(0.5);
	}
	
	protected void execute() {
		//log.dev("Distance Sensor 2: " + RobotMap.testDistanceSensor1.getDistance());
		//log.dev("Distance Sensor 3: " + RobotMap.testDistanceSensor2.getDistance());
		//log.dev("Distance Sensor: " + RobotMap.wallDistanceSensor.getDistance());
		//log.dev("Distance Sensor Voltage: " + RobotMap.wallDistanceSensor.getVoltage());
		SmartDashboard.putNumber("IMU_Yaw", RobotMap.imu.getYaw());
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
