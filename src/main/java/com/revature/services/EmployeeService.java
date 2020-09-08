package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.IReimbDAO;
import com.revature.daos.IUserDAO;
import com.revature.daos.ReimbDAO;
import com.revature.daos.UserDAO;
import com.revature.models.Reimb;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;
import com.revature.models.User;
public class EmployeeService {
	
	private static final Logger log = LogManager.getLogger(EmployeeService.class);
	
	private static IReimbDAO rDao = new ReimbDAO();
	private static IUserDAO uDao = new UserDAO();
	
	public List<Reimb> getAllReimbs(){ 
		log.info("Getting All Reimburesments: ");
		return rDao.getAllReimbs();
	}
	
	public List<Reimb> getReimbByAuthor(User author){ 
		log.info("Getting All Reimburesments from: "+ author.getUsername());
		return rDao.getReimbByAuthor(author);
	}
	
	public List<Reimb> getReimbByStatus(ReimbStatus rStatus){
		log.info("Getting Reimburesments with Status: "+rStatus.getReimbStatus());
		return rDao.getReimbByStatus(rStatus);
	}
	
	public List<Reimb> getReimbByType(ReimbType rType){
		log.info("Getting Reimburesments of Type: "+rType.getReimbType());
		return rDao.getReimbByType(rType);
	}
	
	public Reimb getReimbById(int rId) {
		log.info("Getting Reimburesment: " +rId);
		return rDao.getReimbById(rId);
	}
	
	public User getUserByName(String username) {
		log.info("Getting User Info of: "+username);
		return uDao.getUserByName(username);
	}
	
	//for login attribute purposes
	public String getTypeByName (String username) {
		return uDao.getTypeByName(username);
	}
		
}
