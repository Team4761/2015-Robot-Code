package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Conveyor belt for moving RCs through the robot. Uses a Talon SRX speed
 * controller.
 */
public class LowerConveyorBelt extends Subsystem {
	private static TalonSRX speedController = RobotMap.lowerConveyorBeltMotor;
    
    public void initDefaultCommand() {
    }
    
    public void go(double speed) {
    	if(speed > 0) { //conveyor belt can only go one way
    		speedController.set(speed);
    	}
    }
}