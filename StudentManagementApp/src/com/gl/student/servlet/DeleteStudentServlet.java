package com.gl.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gl.student.service.StudentService;

/**
 * Servlet implementation class DeleteStudentServlet
 */
@WebServlet("/delete")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private StudentService service;
   public void init()
   {
	   service=new StudentService();
   }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String rno=request.getParameter("rollno");
		int rollno=Integer.parseInt(rno);
		boolean flag=service.deleteStudent(rollno);
		RequestDispatcher rd=request.getRequestDispatcher("/list");
		if(flag)
		{
			rd.forward(request, response);
			System.out.println("Student DEtails Removed Successfully...");
		}
		else
		{
			out.println("<p style='color:red'>Student Record has not Deleted..</p>");
			rd.include(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
