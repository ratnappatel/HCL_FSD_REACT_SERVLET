package com.hcl.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");
		
		PrintWriter out=res.getWriter();
		out.println("<center>");
		String uname=req.getParameter("uname");
		String password=req.getParameter("pwd");
		
		
		if(uname.equals("ratna") && password.equals("ratnapatel"))
		{
			out.println("Your login was successful.....");
			RequestDispatcher rd=req.getRequestDispatcher("/home");
			rd.forward(req, res);
		}
		else
		{
			out.println("<font style='color:red'>Sorry !! Username or Password Incorrect</font>");
			RequestDispatcher rd=req.getRequestDispatcher("/login.html");
			rd.include(req, res);
		}
		out.println("</center>");
			
	}

}
