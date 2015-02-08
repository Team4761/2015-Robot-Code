package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Pneumatics powered subsystem that can move up an down on guide rails. Used
 * for moving RCs up and down, and putting them on top of piles.
 */
public class Elevator extends Subsystem {
    
    DoubleSolenoid s1 = RobotMap.elevatorS1;

    public void initDefaultCommand() {
    }
}

