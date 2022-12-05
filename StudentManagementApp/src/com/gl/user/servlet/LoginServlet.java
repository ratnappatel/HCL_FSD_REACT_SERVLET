package com.gl.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gl.student.pojo.User;
import com.gl.student.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service;
	public LoginServlet()
	{
		service=new UserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String uid=request.getParameter("uid");
		String password=request.getParameter("password");
		
		User user=new User();
		user.setId(Integer.parseInt(uid));
		user.setPassword(password);
		
		User u=service.getUser(user);
		if(u!=null)
		{
			HttpSession session=request.getSession(true);
			session.setAttribute("name", u.getName());
			response.sendRedirect("list");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			out.println("<p style='color:red'>Authentication Failed !</p>");
			rd.include(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
