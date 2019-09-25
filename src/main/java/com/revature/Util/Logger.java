package com.revature.util;

public class Logger {

	private static Logger logger =null;
	public static Logger getInstance()
	{
	    if(logger==null)
	    {
	        logger=new Logger();
	    }
	    return logger;
	}
	String level="INFO";
	public void info(Object message)
	{
	    if(level.equals("INFO"))
	    {
	        System.out.println(message);
	    }
	}
	public void debug(Object message)
	{
	    if(level.equals("DEBUG"))
	    {
	        System.out.println(message);
	    }
	}
	public void error(Object message)
	{
	    if(level.equals("ERROR"))
	    {
	        System.out.println(message);
	    }
	}
}
