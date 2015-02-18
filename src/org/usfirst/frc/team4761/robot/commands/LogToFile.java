package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.simonandrews.robolog.Level;
import org.simonandrews.robolog.Logger;
import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.GyroSensor;
import org.usfirst.frc.team4761.robot.sensors.MediumDistanceSensor;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

/**
 * A command to utilize logging with simon's {@link org.simonandrews.robolog robolog library}.
 */
public class LogToFile extends Command {
	
	private ShortDistanceSensor outerConveyorBarrelDistanceSensor = RobotMap.outerConveyorBarrelDistanceSensor;
	private MediumDistanceSensor outerConveyorToteDistanceSensor = RobotMap.outerConveyorToteDistanceSensor;
	private MediumDistanceSensor barrelSensor = RobotMap.barrelDistanceSensor;
	private Logger log = RobotMap.log;
	
	protected void initialize() {
		log.setLevel(Level.FATAL);
	}
	
	protected void execute() {
		//log.dev("Towards Conveyor: " + Double.toString(outerConveyorBarrelDistanceSensor.getDistance()));
		//log.dev("Towards Totes: " + Double.toString(outerConveyorToteDistanceSensor.getDistance()));
		log.dev("Angle: " + Double.toString(GyroSensor.getDegrees()));
		//log.dev("Setpoint: " + Double.toString(Robot.driveTrain.gyroPidController.getSetpoint()));
		log.dev("Barrel: " + Double.toString(barrelSensor.getDistance()));
		SmartDashboard.putNumber("Distance from totes", outerConveyorToteDistanceSensor.getDistance());
		SmartDashboard.putNumber("Distance from barrel on conveyor", outerConveyorBarrelDistanceSensor.getDistance());
		SmartDashboard.putNumber("Barrel: ", barrelSensor.getDistance());
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
