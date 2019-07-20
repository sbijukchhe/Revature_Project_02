package com.revature.dao;

import java.util.List;

import com.revature.entity.Users;

public interface UsersDAO {
	
	
	public List<Users> fetchUsers();
	public Users fetchUsersById(int userid);
	public Users fetchUsersByUsername(String username);
	public void addUsers(Users users);
	public void updateUsers(Users users);
	public boolean isMatchUsername(String userInput);
	public boolean isMatchPassword(String userInput, String userPwd);

}
