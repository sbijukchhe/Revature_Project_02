package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.entity.Users;

@Repository("usersDAO")
public class UsersDAOImpl implements UsersDAO {

	@Autowired
	SessionFactory sessionFact;
	
	@Override
	public List<Users> fetchUsers() {
		
		System.out.println("dao getting all users");
		
		List<Users> userslist = new ArrayList<>();
		
		Session currentSession = sessionFact.getCurrentSession();
		Query query = currentSession.createQuery("From Users");
		userslist =  (ArrayList<Users>) query.list();
		System.out.println("Users List in dao " + userslist);
		return userslist;
	}

	@Override
	public Users fetchUsersById(int userid) {
		Session currentSession = sessionFact.getCurrentSession();
		Users users = currentSession.get(Users.class, userid);
		return users;
	}

	@Override
	public Users fetchUsersByUsername(String username) {
		Session currentSession = sessionFact.getCurrentSession();
		Users users = currentSession.get(Users.class, username);
		return users;
	}

	@Override
	public void addUsers(Users users) {
		Session currentSession = sessionFact.getCurrentSession();
		currentSession.save(users);
		System.out.println("data saved");
	}

	@Override
	public void updateUsers(Users users) {
		Session currentSession = sessionFact.getCurrentSession();
		currentSession.update(users);
		System.out.println("data saved");
	}

	@Override
	public boolean isMatchUsername(String userInput) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMatchPassword(String userInput, String userPwd) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
