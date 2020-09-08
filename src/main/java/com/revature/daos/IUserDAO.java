package com.revature.daos;

import java.util.List;

import com.revature.models.User;
import com.revature.models.UserRole;

public interface IUserDAO  {
	
			public List <User> getAllEmps(UserRole userRole);
			
			public User getUserById(int id);
			
			public User getUserByName(String username);
			
			public boolean createUser(User user);
			
			public boolean updateUser(User user);
			
			public boolean deleteUser(int userId);
			
			public String getTypeByName(String username);

			
}
