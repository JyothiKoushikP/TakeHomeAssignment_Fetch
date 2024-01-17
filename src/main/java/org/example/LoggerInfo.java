package org.example;
import java.util.logging.Level;
import java.util.logging.Logger;

/* This Logger Class is used for logging and debugging purposes, (INFO, ERROR) */
public class LoggerInfo {

    private static final Logger logger = Logger.getLogger(LoggerInfo.class.getName());

    /* Log Metrics, Result (INFO_TYPE) */
    public static void logInfo(String message) {
        logger.log(Level.INFO, message);
    }

    /* Log Severe level Errors */
    public static void logError(String message, Throwable throwable) {
        logger.log(Level.SEVERE, message, throwable);
    }
}
