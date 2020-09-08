package com.revature.services;

import java.sql.Timestamp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.IReimbDAO;
import com.revature.daos.IUserDAO;
import com.revature.daos.ReimbDAO;
import com.revature.daos.UserDAO;
import com.revature.models.Reimb;
import com.revature.models.ReimbDTO;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;
import com.revature.models.User;

public class ReimbService {

	private static final Logger log = LogManager.getLogger(ReimbService.class);
	private static IUserDAO uDao = new UserDAO();
	private static IReimbDAO rDao = new ReimbDAO();

	public boolean insertReimb(ReimbDTO rd) {
		log.info("Submitting a new reimburesment ... ");

		Reimb r;
		ReimbStatus rs = new ReimbStatus("pending");
		ReimbType rt = new ReimbType(rd.getTypeString());
		Timestamp now = new Timestamp(System.currentTimeMillis());
		
		User u = uDao.getUserByName(rd.author_name);
		if (u != null) {
			r = new Reimb(rd.amount, now, null, rd.description, u, null, rs, rt);
			return rDao.addReimb(r);
		} else {
			log.info("Invalid user.");
			return false;
		}

	}
	
	public boolean updateReimbStatus(ReimbDTO rd) {
		log.info("Changing reimburesment status... ");
		
		Reimb r;
		ReimbStatus rs = new ReimbStatus(rd.getStatusString());
		ReimbType rt = new ReimbType(rd.getTypeString());
		Timestamp now = new Timestamp(System.currentTimeMillis());
		
		User sub = uDao.getUserByName(rd.author_name);
		User res = uDao.getUserByName(rd.resolver_name);
		
		if (sub != null && res!= null) {
			r = new Reimb(rd.amount, rd.submitted, now, rd.description, sub, res, rs, rt);
			return rDao.updateReimb(r);
		} else {
			log.info("Invalid user.");
			return false;
		}
	}

}
