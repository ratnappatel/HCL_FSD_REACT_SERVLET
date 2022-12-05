package com.gl.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gl.student.service.StudentService;

/**
 * Servlet implementation class StudentListServlet
 * First Page of Application will always been accessed via get 
 * request/because browsers default http-request method is get
 */
@WebServlet("/list")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService service;
	
	public void init()
	{
		service=new StudentService();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<head><title>Student Management Application</title></head>");
		HttpSession session=request.getSession(false);
		System.out.println(session);
		if(session!=null)
		{
			String name=(String)session.getAttribute("name");
			out.println("Welcome "+name+"&nbsp;");
			out.println("<form method='get' action='http://localhost:9099/StudentManagementApp/logout'>");
			out.println("<input type=submit value='Logout'></form>");
			
			
			out.println("<form method='post' action='http://localhost:9099/StudentManagementApp/AddStudent.html'>");
			out.println("<input type=submit value='Add New Student'><br><br></form>");
			out.println("<table border='5'><tr><th>Roll No</th><th>Student Name</th><th>Student Address</th><th>Mobile No</th><th>Actions</th</tr>");
			
			try 
			{
				ResultSet res=service.getAllStudents();
				while(res.next()) 
				{
					int rollno=res.getInt("rollno");
					out.println("<tr>");
					out.println("<td>"+rollno+"</td>");
					out.println("<td>"+res.getString("name")+"</td>");
					out.println("<td>"+res.getString("address")+"</td>");
					out.println("<td>"+res.getString("mobileno")+"</td>");
					out.println("<td><a href='http://localhost:9099/StudentManagementApp/edit?rollno="
					+rollno+"'>Edit</a>");
					out.println("<a href='http://localhost:9099/StudentManagementApp/delete?rollno="
					+rollno+"'>Delete</a></td>");
					out.println("</tr>");
				}
				out.println("</table>");
			} catch (SQLException e) {e.printStackTrace();}	
		}
		else
		{
			out.println("<p style='color:red'>You are not logged in Yet.</p>");
			out.println("To Login <a href='http://localhost:9099/StudentManagementApp/index.html'>Go here</a>");
		}
		
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		doGet(request,response);
	}
}
