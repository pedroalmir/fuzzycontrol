/**
 * 
 */
package com.fuzzycontrol.core.controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fuzzycontrol.common.handler.View;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

/**
 * @author Pedro Almir
 *
 */
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		
		if(user != null){
			response.sendRedirect(View.INDEX);
		}else{
			String url = userService.createLoginURL(request.getRequestURI());
			request.setAttribute("loginURL", url);
			RequestDispatcher dispatcher = request.getRequestDispatcher(View.LOGIN_JSP);
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		
	}

}