package com.revature.daos;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.utils.HibernateUtil;

public class UserDAO implements IUserDAO {

	@Override
	public List<User> getAllEmps(UserRole userRole) {
		Session ses = HibernateUtil.getSession();
		List<User> list = ses.createQuery("FROM User WHERE userRole =" + userRole.getUserRoleId(), User.class).list();
		return list;
	}

	@Override
	public User getUserById(int id) {
		Session ses = HibernateUtil.getSession();

		User u = ses.get(User.class, id);
		return u;
	}

	@Override
	public User getUserByName(String username) {
		Session ses = HibernateUtil.getSession();
		
		List <User> ul = ses.createQuery("FROM User WHERE username ='" +username+"'", User.class).list();
		
		if (ul.size() > 0) {
			User u = ul.get(0);
			return u;
		} else {
			return null;
		}
	}

	@Override
	public boolean createUser(User user) {
		Session ses = HibernateUtil.getSession();

		try {
			ses.save(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateUser(User user) {
		Session ses = HibernateUtil.getSession();

		try {
			ses.merge(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteUser(int userId) {
		Session ses = HibernateUtil.getSession();

		try {
			ses.createQuery("DELETE FROM User WHERE userId =" + userId, User.class);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String getTypeByName(String username) {
		Session ses = HibernateUtil.getSession();

		List<User> ul = ses.createQuery("FROM User WHERE username ='" + username+"'", User.class).list();
		User u = ul.get(0);

		UserRole role = u.getUserRole();
		return role.getUserRole();
	}

}
