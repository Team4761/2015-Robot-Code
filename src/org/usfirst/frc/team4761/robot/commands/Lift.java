package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class  Lift extends Command {

	DoubleSolenoid.Value dbSV;
	
	public static DoubleSolenoid.Value forward = DoubleSolenoid.Value.kForward;
	public static DoubleSolenoid.Value reverse = DoubleSolenoid.Value.kReverse;
	public static DoubleSolenoid.Value off = DoubleSolenoid.Value.kOff;
	
	
	DoubleSolenoid solenoid = RobotMap.elevatorS1;
	
	public Lift(){
		dbSV = forward;
	}
	
    public Lift(DoubleSolenoid.Value value) {
    	
    	dbSV = value;

        requires(Robot.elevator);
    }

    protected void initialize() {
    }

    protected void execute() {
    	solenoid.set(dbSV);
    	setTimeout(1); // Note! This makes it wait one second!
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	//solenoid.set(DoubleSolenoid.Value.kOff);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
