package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.User;

public interface UserDAO {
	
	public List<User> CheckLoginInfo(String userName, String Password, int userType) throws SQLException;
}
