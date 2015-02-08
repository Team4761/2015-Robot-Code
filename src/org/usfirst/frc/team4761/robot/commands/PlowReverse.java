package org.usfirst.frc.team4761.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class PlowReverse extends Plow {

	DoubleSolenoid.Value dbSV = Plow.forward;
	
    public PlowReverse() {
    }
}
