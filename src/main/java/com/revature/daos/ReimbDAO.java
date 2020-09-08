package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;	

import com.revature.models.Reimb;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class ReimbDAO implements IReimbDAO {

	public ReimbDAO() {
		super();
	}

	@Override
	public List<Reimb> getAllReimbs() {
		Session ses = HibernateUtil.getSession();

		List<Reimb> rlist = ses.createQuery("FROM Reimb").list();
		return rlist;
	}

	@Override
	public List<Reimb> getReimbByAuthor(User author) {
		Session ses = HibernateUtil.getSession();

		List<Reimb> rlist = ses.createQuery("FROM Reimb WHERE author=" + author).list();
		return rlist;
	}

	@Override
	public List<Reimb> getReimbByStatus(ReimbStatus rStatus) {
		Session ses = HibernateUtil.getSession();
		
		List<Reimb> rlist = ses.createQuery("FROM Reimb WHERE rStatus=" + rStatus).list();
		return rlist;
	}

	@Override
	public List<Reimb> getReimbByType(ReimbType rType) {
		Session ses = HibernateUtil.getSession();

		List<Reimb> rlist = ses.createQuery("FROM Reimb WHERE rType=" + rType).list();
		return rlist;
	}

	@Override
	public Reimb getReimbById(int rId) {
		Session ses = HibernateUtil.getSession();

		Reimb r = ses.get(Reimb.class, rId);
		return r;
	}

	@Override
	public boolean addReimb(Reimb r) {
		Session ses = HibernateUtil.getSession();

		try {
			ses.save(r);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateReimb(Reimb r) {
		Session ses = HibernateUtil.getSession();

		try {
			ses.merge(r);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteReimb(int rId) {
		Session ses = HibernateUtil.getSession();

		try {
			ses.createQuery("DELETE FROM Reimb WHERE rId =" + rId);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

}
