package com.gl.user.listener;

import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class UserSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("Session Created:: ID="+event.getSession().getId());
		System.out.println("At "+new Date());

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("Session Destroyed:: ID="+event.getSession().getId());
		System.out.println("At "+new Date());

	}

}
