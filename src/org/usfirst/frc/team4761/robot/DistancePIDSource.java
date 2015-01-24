package org.usfirst.frc.team4761.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDSource;

/**
 *
 */
public class DistancePIDSource implements PIDSource {
    private AnalogInput sensor = RobotMap.distanceSensor;
    
    private double toMilliVolts (double voltage) {
    	return voltage * 100;
    }
    
    public double getDistance () {
    	return (toMilliVolts(sensor.getVoltage()) / 4.885) * 5;
    }

	@Override
	public double pidGet () {
		return getDistance();
	}
}

