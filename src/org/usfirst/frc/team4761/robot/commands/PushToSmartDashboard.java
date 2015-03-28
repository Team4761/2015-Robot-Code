package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.RobotMap;
import org.usfirst.frc.team4761.robot.sensors.GyroSensor;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PushToSmartDashboard extends Command {

    public PushToSmartDashboard() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		SmartDashboard.putNumber("Angle: ", GyroSensor.getDegrees());
		SmartDashboard.putBoolean("Elevator Bottom: ", RobotMap.elevatorBottom.get());
		SmartDashboard.putBoolean("Elevator Accept Tote 1: ", RobotMap.elevatorAcceptTote1.get());
		SmartDashboard.putBoolean("Elevator Accept Tote 2: ", RobotMap.elevatorAcceptTote2.get());
		SmartDashboard.putBoolean("Break Beam Elevator Begin: ", RobotMap.breakBeamElevatorBegin.get());
		SmartDashboard.putBoolean("Break Beam Elevator End: ", RobotMap.breakBeamElevatorEnd.get());
		SmartDashboard.putBoolean("Break Beam Clear: ", RobotMap.breakBeamClear.get());
		SmartDashboard.putBoolean("Top of Stack: ", RobotMap.stackTop.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
