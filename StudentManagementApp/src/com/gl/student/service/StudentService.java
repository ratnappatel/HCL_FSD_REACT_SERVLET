package com.gl.student.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.gl.student.dao.StudentDAO;
import com.gl.student.pojo.Student;

public class StudentService {
	private Connection con;
	private ResultSet res;
	private PreparedStatement pre;
	private Statement stat;
	private int ra;
	private boolean flag;
	public StudentService() 
	{
		this.con=StudentDAO.getConnection();
	}
	
	public boolean addStudent(Student s)
	{
		try 
		{
			pre=con.prepareStatement("insert into student values(?,?,?,?)");
			pre.setInt(1, s.getRollno());
			pre.setString(2,s.getName());
			pre.setString(3, s.getAddress());
			pre.setString(4, s.getMobileNo());
			
			ra=pre.executeUpdate();
			if(ra>0)
				flag=true;
			else
				flag=false;
		} 
		catch (Exception e) {e.printStackTrace();}
		return flag;
	}
	public boolean updateStudent(Student s)
	{
		try 
		{
			pre=con.prepareStatement("update student set address=?,mobileno=? where rollno=?");
			pre.setString(1,s.getAddress());
			pre.setString(2, s.getMobileNo());
			pre.setInt(3, s.getRollno());
			
			ra=pre.executeUpdate();
			if(ra>0)
				flag=true;
			else
				flag=false;			
		} 
		catch (Exception e) {e.printStackTrace();}
		return flag;
	}
	public Student getStudent(int rollno)
	{
		Student s=new Student();
		try 
		{
			pre=con.prepareStatement("select * from student where rollno=?");
			pre.setInt(1, rollno);
			res=pre.executeQuery();
			if(res!=null)
			{
				res.next();
				s.setRollno(res.getInt("rollno"));
				s.setName(res.getString("name"));
				s.setAddress(res.getString("address"));
				s.setMobileNo(res.getString("mobileno"));
			}
			else
				s=null;			
		} catch (Exception e) {e.printStackTrace();}
		return s;
	}
	public boolean deleteStudent(int rollno)

	{
		try
		{
			pre=con.prepareStatement("delete from student where rollno=?");
			pre.setInt(1,rollno);
			
			ra=pre.executeUpdate();
			if(ra>0)
				flag=true;
			else
				flag=false;
		} catch (Exception e) {e.printStackTrace();	}
		return flag;
	}
	public ResultSet getAllStudents()
	{
		try 
		{
			stat=con.createStatement();
			res=stat.executeQuery("select * from student");			
		}
		catch (Exception e) {e.printStackTrace();	}
		return res;
	}

}
