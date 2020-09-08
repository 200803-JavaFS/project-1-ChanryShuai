package com.revature.services;

import com.revature.daos.IUserDAO;
import com.revature.daos.UserDAO;
import com.revature.models.LoginDTO;
import com.revature.models.User;

public class LoginService {
	IUserDAO uDao = new UserDAO();

	public boolean login(LoginDTO l) {
		
		User utemp = uDao.getUserByName(l.username);
		int tempPass = l.password.hashCode();

		String hashedPW = Integer.toString(tempPass);
		
		if ((utemp!= null) && hashedPW.equals(utemp.getPassword())) {
			return true;
		} else {
		}
			return false;
	}
}