package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class LiftReverse extends Lift {
	
	final DoubleSolenoid.Value dbSV = Lift.reverse;
	
	public LiftReverse(){}
}
