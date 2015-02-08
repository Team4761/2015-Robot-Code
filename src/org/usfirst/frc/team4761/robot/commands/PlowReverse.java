package org.usfirst.frc.team4761.robot.commands;

import org.usfirst.frc.team4761.robot.Robot;
import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class PlowReverse extends Command {
	
	DoubleSolenoid solenoid = RobotMap.plowerS2; 
	
	public PlowReverse(){
		requires(Robot.elevator);
	}
	
    protected void initialize() {
    	setTimeout(1);
    }

    protected void execute() {
    	solenoid.set(DoubleSolenoid.Value.kReverse);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {}

	protected void interrupted() {}
}
