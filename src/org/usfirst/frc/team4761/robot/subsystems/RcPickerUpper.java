package org.usfirst.frc.team4761.robot.subsystems;

import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
<<<<<<< HEAD:src/org/usfirst/frc/team4761/robot/subsystems/RcPickerUpper.java
public class RcPickerUpper extends Subsystem {
	private Servo servo = RobotMap.servo;
=======
public class RcArm extends Subsystem {
	private Servo servo = RobotMap.servo;
	private VictorSP winch = RobotMap.winch;
    private DoubleSolenoid pusher = RobotMap.pusher;
>>>>>>> aedfc96b7286aa5ee1311568489d39418552b142:src/org/usfirst/frc/team4761/robot/subsystems/RcArm.java

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
<<<<<<< HEAD:src/org/usfirst/frc/team4761/robot/subsystems/RcPickerUpper.java
    public void set (int angle) {
    	servo.set(angle);
    }
    
    public void open () {
    	servo.set(250); // Check this value
    }
    
    public void close () {
    	servo.set(0);
    }
}
=======
    public void winchIn () {
    	winch.set(1);
    }
    
    public void winchOut () {
    	winch.set(-1);
    }
    
    public void winchStop () {
    	winch.set(0);
    }
    
    public void servoToAngle (double angle) {
    	servo.setAngle(angle);
    }
    
    public void pusherIn () {
    	pusher.set(DoubleSolenoid.Value.kForward);
    }
    
    public void pusherOut () {
    	pusher.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void pusherStop () {
    	pusher.set(DoubleSolenoid.Value.kOff);
    }
}

>>>>>>> aedfc96b7286aa5ee1311568489d39418552b142:src/org/usfirst/frc/team4761/robot/subsystems/RcArm.java
