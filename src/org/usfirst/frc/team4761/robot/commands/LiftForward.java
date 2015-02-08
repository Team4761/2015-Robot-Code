package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class LiftForward extends Lift {
	
	final DoubleSolenoid.Value dbSV = Lift.forward;
	
	public LiftForward(){}
}
