package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.UsersDAO;
import com.revature.dao.UsersDAOImpl;
import com.revature.entity.Users;

@Service 
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersDAOImpl usersDAOImpl;
	
	
	@Override
	@Transactional
	// returns a list of users
	public List<Users> getUsers() {
		
		System.out.println("Getting all users from Service");
		
		List<Users> users = usersDAOImpl.fetchUsers();
		System.out.println("List of Users in service " + users);
		return users;
	}

	
	@Override
	@Transactional
	public Users getUsersById(int userid) {
		
		// returns a single user
		Users user = usersDAOImpl.fetchUsersById(userid);
		return user;
	}

	
	@Override
	@Transactional
	public Users getUsersByUsername(String username) {
		// returns a single user
		Users user = usersDAOImpl.fetchUsersByUsername(username);
		return user;
	}

	@Override
	@Transactional
	public void createUsers(Users users) {
		// adds a single user to a table
		usersDAOImpl.addUsers(users);
	}

	@Override
	@Transactional
	public void updateUsers(Users users) {
		// updates a single user
		usersDAOImpl.updateUsers(users);
		
	}

	@Override
	@Transactional
	public boolean isMatchUsername(String userInput) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public boolean isMatchPassword(String userInput, String userPwd) {
		// TODO Auto-generated method stub
		return false;
	}

}
