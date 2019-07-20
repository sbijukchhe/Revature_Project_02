package com.revature.service;

import java.util.List;

import com.revature.entity.Users;

public interface UsersService {

	public List<Users> getUsers();
	public Users getUsersById(int userid);
	public Users getUsersByUsername(String username);
	public void createUsers(Users users);
	public void updateUsers(Users users);
	public boolean isMatchUsername(String userInput);
	public boolean isMatchPassword(String userInput, String userPwd);
}
