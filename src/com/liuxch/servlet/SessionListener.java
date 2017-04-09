package com.liuxch.servlet;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("session id is"+event.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {		
		HttpSession session = event.getSession();
		String username = (String) session.getAttribute("username");
		List list = (List) session.getServletContext().getAttribute("onlineUserList");
		list.remove(username);
	}

}
