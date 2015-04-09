package org.usfirst.frc.team4761.robot.commands.led;

import org.usfirst.frc.team4761.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Runs a command on the LED system, using a command code from {@link
 * LedCommandCode the LED command code enum}.
 */
public class RunLedCommand extends Command {
	private int cmdCode;
    public RunLedCommand(LedCommandCode cmdCode) {
    	this.cmdCode = cmdCode.getCode();
    }
    protected void initialize() {
		setTimeout(5);
		RobotMap.arduino.transaction(new byte[]{(byte) cmdCode}, 1, null, 0);
    }
    protected boolean isFinished() {
        return false;
    }
    
	protected void execute() {}
    protected void end() {}
    protected void interrupted() {}
}
