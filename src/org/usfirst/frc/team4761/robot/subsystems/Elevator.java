package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {
    
    DoubleSolenoid s1 = RobotMap.elevatorS1;

    public void initDefaultCommand() {
    }
}

