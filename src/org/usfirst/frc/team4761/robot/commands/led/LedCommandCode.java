package org.usfirst.frc.team4761.robot.commands.led;

/**
 * Defines byte values for different commands that can be run on the LED
 * system.
 */
public enum LedCommandCode {
	/**
	 * Wipes the current state of the LED.
	 */
	WIPE(73),
	/**
	 * Sets LED color to red.
	 */
	SET_RED(80),
	/**
	 * Sets LED color to green.
	 */
	SET_GREEN(82),
	EXPLODE(89);
	
	private int dataCode;
	private LedCommandCode(int dataCode) {
		this.dataCode = dataCode;
	}
	
	/**
	 * @return Data code for command.
	 */
	public int getCode() {
		return this.dataCode;
	}
}
