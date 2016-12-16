package com.web.Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class myListener
 *
 */
@WebListener
public class myListener implements HttpSessionListener {
	 private static int tSessions;
    /**
     * Default constructor. 
     */
    public myListener() {
        // TODO Auto-generated constructor stub
    }
    public static int GetSessions() {
        return tSessions;
      }
	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	tSessions++;
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	tSessions--;
    }
	
}
