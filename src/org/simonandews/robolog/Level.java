package org.simonandews.robolog;

/**
 * Defines log urgency levels.
 * @author Simon Andrews
 */
public enum Level {
	/**
	 * Code debugging messages useful only to developers.
	 */
	DEV,
	/**
	 * General useful information.
	 */
	INFO,
	/**
	 * Something that may be named a problem.
	 */
	WARN,
	/**
	 * Something that is definitely a problem.
	 */
	ERROR,
	/**
	 * A problem that is so serious that the program cannot continue.
	 */
	FATAL
}
