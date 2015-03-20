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
	private AnalogAxisToDigital slowButton = new AnalogAxisToDigital(1, 1);
	
	protected void initialize() {
		log.setLevel(Level.FATAL);
	}
	
	protected void execute() {
		//log.dev("Towards Conveyor: " + Double.toString(outerConveyorBarrelDistanceSensor.getDistance()));
		//log.dev("Towards Totes: " + Double.toString(outerConveyorToteDistanceSensor.getDistance()));
		//log.dev("Angle: " + Double.toString(GyroSensor.getDegrees()));
		//log.dev("Slider 1: " + Double.toString(Robot.oi.joysticks[1].getRawAxis(0)));
		//log.dev("Slider 1: " + Double.toString(Robot.oi.joysticks[1].getRawAxis(1)));
		//log.dev("Setpoint: " + Double.toString(Robot.driveTrain.gyroPidController.getSetpoint()));
		//log.dev("Barrel: " + Double.toString(barrelSensor.getDistance()));
		log.dev("Break Beam: " + RobotMap.breakBeamBegin.get());
		log.dev("Slow Button: " + slowButton.get());
		log.dev("Raw Slow Button: " + Robot.oi.joysticks[1].getRawAxis(1));
		//SmartDashboard.putNumber("Angle: ", GyroSensor.getDegrees());
		//SmartDashboard.putNumber("Distance from totes", outerConveyorToteDistanceSensor.getDistance());
		//SmartDashboard.putNumber("Distance from barrel", outerConveyorBarrelDistanceSensor.getDistance());
		//SmartDashboard.putNumber("Distance from barrel on conveyor", outerConveyorBarrelDistanceSensor.getDistance());
		//SmartDashboard.putNumber("Barrel: ", barrelSensor.getDistance());
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
