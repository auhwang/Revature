package com.revature.day5.logging;

import org.apache.log4j.Logger;

public class Driver {
	/*
	 * Logging
	 * -Documentation of steps and processes an application takes
	 * -Notes points of failure, and if the developer is kind, notes possible reasons of those failures
	 * 
	 * Logger
	 * -The tool that marks a point in execution and logs it
	 * Appender
	 * -Type of appender decides how the log will be saved/displayed
	 * Layout
	 * -Formatting log data
	 * 
	 * Severities
	 * -All
	 * -Trace - Most specific, logging nearly every action
	 * -Debug - More specific log
	 * -Info - Typical log stating key actions
	 * -Warn - Action with risk of error/fatal
	 * -Error - Something has gone wrong, may effect application
	 * -Fatal - System crash without hope to recover
	 * -None
	 */
	final static Logger logger = Logger.getLogger(Driver.class);
	public static void main(String[] args) {
		Driver d = new Driver();
		d.logStuff("eyyy");
	}
	public void logStuff(String message) {
		logger.trace(message);
		logger.debug(message);
		logger.info(message);
		logger.warn(message);
		logger.error(message);
		logger.fatal(message);
	}
}
