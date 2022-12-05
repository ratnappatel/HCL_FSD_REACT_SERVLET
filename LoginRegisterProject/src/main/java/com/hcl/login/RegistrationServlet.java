package com.hcl.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String fname=request.getParameter("name");
		String uname=request.getParameter("uname");
		String address=request.getParameter("address");
		String gender=request.getParameter("gender");
		String country=request.getParameter("country");
		String langs[]=request.getParameterValues("language");
		
		PrintWriter out=response.getWriter();
		out.println("Hi "+fname+",<br>Your Registration with User Name : "+uname);
		out.println("<br>completed successfully.");
		out.println("<br>Your Details is as Followed: ");
		out.println("<br><b>Address : </b>"+address);
		out.println("<br><b>Gender : </b>"+gender);
		out.println("<br><b>Country : </b>"+country);
		out.println("<br><b>Languages You May Speak In : </b>");
		for(int i=0;i<langs.length;i++)
			out.println(langs[i]+",");
		
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.sendRedirect("http://localhost:9099/ClientServerCommunication/input.html");
	}
}
