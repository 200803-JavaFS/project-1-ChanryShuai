package com.revature;

import java.util.List;

import com.revature.daos.UserDAO;
import com.revature.models.User;
import com.revature.models.UserRole;


public class Driver {
	
	public static UserDAO uDao = new UserDAO();
	
	public static void main(String[] args) {
		UserRole emp = new UserRole("employee");
		insertValues();
		List<User>  users = uDao.getAllEmps(emp);
		
		for(User u : users) {
			System.out.println(u);
		}
		
	}
	
	public static void insertValues() {
		UserRole emp = new UserRole("employee");
		UserRole man = new UserRole("financial manager");
		
		User user1 = new User("Chanry", "12345", "Chanry", "Shuai", "qyshuai@gmail.com", emp);
		User user2 = new User("JT", "20051225", "JingTeng", "Shuai", "jtshuai@gmail.com", emp);
		User user3 = new User("Yan", "yan", "Yan", "Wang","yxwang@gmail.com", emp);
		User user4 = new User("Picasso", "picasso", "Pablo", "Picasso", "ppicasso@gmail.com", man); 
		
		
		uDao.updateUser(user1);
		uDao.createUser(user2);
		uDao.createUser(user3);
		uDao.createUser(user4);
	}
	
	

}
