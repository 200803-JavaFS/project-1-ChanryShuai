package com.revature.daos;

import java.util.List;

import com.revature.models.Reimb;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;
import com.revature.models.User;

public interface IReimbDAO{
	
			public List <Reimb> getAllReimbs();
			
			//filtering functionalities
			public List <Reimb> getReimbByAuthor(User author);
		
			public List <Reimb> getReimbByStatus(ReimbStatus rStatus);
			
			public List <Reimb> getReimbByType(ReimbType rType);
			
			public Reimb getReimbById(int rId);
			
			//functionalities for changing/adding 
			public boolean addReimb(Reimb r);
			
			public boolean updateReimb(Reimb r);
			
			public boolean deleteReimb(int rId);
			
		}




