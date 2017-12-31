package ai.edbox.coreutils.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogUtils {
	private static Logger logger = null;
	static {
		logger = LogUtils.getLogger(LogUtils.class);
		logger.setLevel(Level.INFO);
		/*
		PropertyConfigurator.configure(System.getProperty( "LOG4J" ));*/
	}

	@SuppressWarnings("rawtypes")
	private static synchronized Logger getLogger(Class clazz) {
		Logger logger = Logger.getLogger(clazz.getName());
		return logger;
	}


	public static void info(String msg) {
		logger.info(msg);
	}

	public static void error (String msg) {
		logger.log(Level.WARNING,msg);
	}

	public static void error (String msg, Throwable t) {
		logger.log(Level.WARNING,msg, t);
	}   

	public static boolean isInfoEnabled () {
		return logger.isLoggable(Level.INFO);
	}

	public static boolean isDebugEnabled () {
		return logger.isLoggable(Level.FINER);
	}

	public static void info(Class<?> clazz, String msg) {
		LogUtils.getLogger(clazz).info(msg);
	}

	public static void debug(Class<?> clazz, String msg) {
		LogUtils.getLogger(clazz).log(Level.FINER,msg);
	}
	
	public static void debug( String msg) {
		logger.log(Level.FINER,msg);
	}

	public static void debug (Class<?> clazz, String msg, Throwable t) {
		LogUtils.getLogger(clazz).log(Level.FINER,msg, t);
	}   

	public static void error(Class<?> clazz, String msg) {
		LogUtils.getLogger(clazz).warning(msg);
	}

	public static void error (Class<?> clazz, String msg, Throwable t) {
		LogUtils.getLogger(clazz).log(Level.WARNING,msg, t);
	}   

	public static void trace(Class<?> clazz, String msg) {
		LogUtils.getLogger(clazz).log(Level.FINEST,msg);
	}

	public static void trace (Class<?> clazz, String msg, Throwable t) {
		LogUtils.getLogger(clazz).log(Level.FINEST,msg,t);
	}   
}
