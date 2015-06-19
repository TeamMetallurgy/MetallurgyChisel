package com.teammetallurgy.metallurgychisel.utils;

import org.apache.logging.log4j.Logger;

public class Log
{
    private static Logger logger;

    public static void setLogger(Logger newLogger)
    {
        Log.logger = newLogger;
    }

    public static void info(String message)
    {
        logger.info(message);
    }
}
