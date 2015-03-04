package org.usfirst.frc.team4761.robot.commands.conveyorbelts;

import org.usfirst.frc.team4761.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveRcToElevator extends Command {

	//ShortDistanceSensor loadSensor = Robot.robotMap.conveyorDistanceSensor;
	
	protected void initialize() {
		requires(Robot.mainConveyorBelt);
	}

	protected void execute() {
		Robot.mainConveyorBelt.go(0.5);
	}

	protected boolean isFinished() {
		//if (loadSensor.getDistance() > 30)	// if the sensor reads greater than 30cm, there is nothing on the conveyor belt
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
