package com.gl.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gl.student.pojo.Student;
import com.gl.student.service.StudentService;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/add")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     StudentService service;
    public AddStudentServlet() {
       service=new StudentService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		Student s=new Student();
		String rno=request.getParameter("rollno");
		int rollno=Integer.parseInt(rno);
		s.setRollno(rollno);
		s.setName(request.getParameter("name"));
		s.setAddress(request.getParameter("address"));
		s.setMobileNo(request.getParameter("mobileno"));
		
		boolean flag=service.addStudent(s);
		RequestDispatcher rd=request.getRequestDispatcher("list");
		if(flag)
			rd.forward(request, response);
		else
		{
			out.println("Record has not inserted..");
			rd.include(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
