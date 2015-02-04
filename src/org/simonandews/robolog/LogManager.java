package org.simonandews.robolog;

public class LogManager {
	private static Level minLevel = Level.INFO; //Minimum level is INFO by default

	/**
	 * Return the number of the level that is the current minimum level to 
	 * @return Minimum level
	 */
	public static Level getMinimumLevel() {
		return minLevel;
	}
	
	/**
	 * Sets the minimum level to view in the log.
	 * @param level Minimum level
	 */
	public static void setMinimumLevel(Level level) {
		minLevel = level;
	}
}