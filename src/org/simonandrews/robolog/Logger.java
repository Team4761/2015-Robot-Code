package org.simonandrews.robolog;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A class for doing logging stuff. You would make a new instance of it in your
 * own code and then use it to send log messages.
 * @author Simon Andrews
 * @author Jake Kinsella
 */
public class Logger {
	private String lName;
	private String msgFormat = "[%s] %s - %s";
	
	private File output = new File("/home/lvuser/log.txt");;
	
	private LoggingMode lMode = LoggingMode.CONSOLE;
	/**
	 * Logger. Can log messages.
	 * @param name Name of the logger. This should usually describe the type of
	 * logs it will be sending (e.g. If you were logging messages about a dog
	 * named Rufus, the name of his logger would be "Rufus").
	 */
	public Logger (String name) {
		lName = name;
	}
	
	/**
	 * Logger. Can log messages.
	 * @param name Name of the logger. This should usually describe the type of
	 * logs it will be sending (e.g. If you were logging messages about a dog
	 * named Rufus, the name of his logger would be "Rufus").
	 * @param mode The place where the logger should send logs to.
	 */
	public Logger (String name, LoggingMode mode) {
		lName = name;
		lMode = mode;
	}
	
	/**
	 * Logger. Can log messages.
	 * @param name Name of the logger. This should usually describe the type of
	 * logs it will be sending (e.g. If you were logging messages about a dog
	 * named Rufus, the name of his logger would be "Rufus").
	 * @param mode The place where the logger should send logs to.
	 * @param outputFile The location of the logging file
	 */
	public Logger (String name, LoggingMode mode, String outputFile) {
		lName = name;
		lMode = mode;
		output = new File(outputFile);
		try {
			new FileWriter(output.getPath(), false); // Overwrite old log files
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * Code debugging information that would only really be useful to
	 * developers.
	 * @param message Message to log
	 */
	public void dev (String message) {
		handleMessage(message, Level.DEV);
	}
	
	/**
	 * Just a regular old message. Can deliver good and bad news. Should be
	 * useful to non-developers.
	 * @param message Message to log
	 */
	public void info (String message) {
		handleMessage(message, Level.INFO);
	}
	
	/**
	 * Sends a warning to the log that something may be wrong. Not a serious
	 * issue, but should probably be fixed.
	 * @param message Message to log
	 */
	public void warn (String message) {
		handleMessage(message, Level.WARN);
	}
	
	/**
	 * Report a error. An error is a serious problem, but one one that the
	 * program will attempt to continue despite of.
	 * @param message Message to log
	 */
	public void error (String message) {
		handleMessage(message, Level.ERROR);
	}
	
	/**
	 * Report a fatal error. A fatal error is an error that the program can not
	 * recover from and must end because of.
	 * @param message Message to log
	 */
	public void fatal (String message) {
		handleMessage(message, Level.FATAL);
	}
	
	/**
	 * Private method used to take a log message, format it, and send it to
	 * it's proper destination (console, file, etc.)
	 * @param message Message to log
	 * @param level Level of the message
	 */
	private void handleMessage (String message, Level level) {
		if(LogManager.getMinimumLevel().ordinal() <= level.ordinal()) {
			String str = String.format(msgFormat, level, lName, message);
			switch (lMode) {
				case CONSOLE:
					System.out.println(str);
					break;
		
				case LOG:
					System.out.println(str);
					// No break so it will also log to a file
					
				case FILE:
					try {
						FileWriter fileWriter = new FileWriter(output.getPath(), true);
						BufferedWriter bw = new BufferedWriter(fileWriter);
						bw.write(str + "\n");
						bw.close();
					}
					catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	
	/**
	 * Gets the format of log strings.
	 * @return Log string formats
	 */
	public String getFormat () {
		return msgFormat;
	}
	
	/**
	 * Set the format of the log strings. The first %s is the level, the second
	 * is the name of the Logger instance, and the third is the message itself.
	 * For example "[%s] %s - %s" as the format will make log messages like 
	 * "[INFO] MyLogger - This is a log message."
	 * @param format
	 */
	public void setFormat (String format) {
		msgFormat = format;
	}
	
	/**
	 * Set the level of logging
	 * @param level the level you want to log at
	 */
	public void setLevel (Level level) {
		LogManager.setMinimumLevel(level);
	}
}
