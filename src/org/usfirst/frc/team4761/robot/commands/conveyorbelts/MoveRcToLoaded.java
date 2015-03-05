package org.usfirst.frc.team4761.robot.commands.conveyorbelts;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.ShortDistanceSensor;

import edu.wpi.first.wpilibj.command.Command;

public class MoveRcToLoaded extends Command {

	//ShortDistanceSensor loadSensor = RobotMap.conveyorDistanceSensor;
	
	protected void initialize() {
		requires(Robot.mainConveyorBelt);
	}

	protected void execute() {
		Robot.mainConveyorBelt.go(0.5);
	}

	protected boolean isFinished() {
		//if (loadSensor.getDistance() < 30)	// if the sensor reads less than 30cm, there is something on the conveyor belt
			return true;
		//return false;
	}

	protected void end() {
		// TODO Auto-generated method stub
		
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	

}
