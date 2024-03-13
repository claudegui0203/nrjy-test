package com.nrjd.common.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;

public class LogUtil {
    public static Logger Logger = org.apache.log4j.Logger.getLogger(LogUtil.class.getName());
    private static File file = null;

    private static void getLogConfiguration() {
        file = new File("src/main/resources/log4j.properties");
        if (! file.exists()) {
            file =  new File("log4j.properties");
        }
    }
    public static void startTestCase(String sTestCaseName) {
        Logger.info("Begin test case " + sTestCaseName + " running...");
    }

    public static void endTestCase(String sTestCaseName) {
        Logger.info("End test case " + sTestCaseName + " running...");
    }

    public static void info (String message) {
        if (file == null) {
            getLogConfiguration();
        }

        PropertyConfigurator.configure (file.getPath());
        Logger.info(message);
    }

    public static void warn(String message) {
        if (file == null) {
            getLogConfiguration();
        }

        PropertyConfigurator.configure(file.getPath());
        Logger.warn(message);
    }

    public static void error (String message) {
        if (file == null) {
            getLogConfiguration();
        }

        PropertyConfigurator.configure(file.getPath());
        Logger.error(message);
    }

    public static void fatal (String message) {
        if (file == null) {
            getLogConfiguration();
        }

        PropertyConfigurator.configure(file.getPath());
        Logger.fatal(message);
    }

    public static void debug (String message) {
        if (file == null) {
            getLogConfiguration();
        }

        PropertyConfigurator.configure(file.getPath());
        Logger.debug(message);
    }
}
