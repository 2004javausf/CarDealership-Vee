package com.revature.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.User;
import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.util.ConnFactory;

public class UserDAOImpl implements UserDAO{
	public static ConnFactory cf = ConnFactory.getInstance();
	public List<User> CheckLoginInfo(String userName, String Password,int userType) throws SQLException {
		List<User> UserList = new ArrayList<User>();
		Connection conn=cf.getConnection();
		Statement stmt = conn.createStatement();
		String sql=null;
		if (userType == 1) {
			sql = "SELECT * FROM USER_INFO WHERE UPPER(USER_NAME)=UPPER('"+userName+"') AND USER_PASSWORD='"+Password+"' AND USER_TYPE_ID=1";
		}
		else {
			sql = "SELECT * FROM USER_INFO WHERE UPPER(USER_NAME)=UPPER('"+userName+"') AND USER_PASSWORD='"+Password+"'AND (USER_TYPE_ID>=2)";
		}
		ResultSet rs = stmt.executeQuery(sql);
		User u = null;
		while(rs.next()) {
			u=new User(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6));
			UserList.add(u);
		}
			
		return UserList;
		
	}

	

}
