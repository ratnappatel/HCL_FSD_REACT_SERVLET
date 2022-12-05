package com.gl.student.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gl.student.dao.StudentDAO;
import com.gl.student.pojo.User;

public class UserService {
	Connection con;
	boolean flag;
	PreparedStatement pre;
	int ra;
	ResultSet res;
	public UserService() {
		con=StudentDAO.getConnection();
	}
	public User getUser(User user)
	{
		User existing=null;
		try 
		{
			pre=con.prepareStatement("select * from users where id=? and password=?");
			pre.setInt(1,user.getId());
			pre.setString(2, user.getPassword());
			
			res=pre.executeQuery();
			if(res!=null)
			{
				existing=new User();
				res.next();
				existing.setName(res.getString("name"));
				existing.setPassword(res.getString("password"));
				existing.setId(res.getInt("id"));
			}
						
			
		} catch (Exception e) {e.printStackTrace();		}
		return existing;
	}

}
