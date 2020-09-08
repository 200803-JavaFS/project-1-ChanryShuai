package com.revature.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static Session ses; //only gives one session, since this is a single-thread environment
	//Configuration.class creates SessionFactoru
	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	
	public static Session getSession() {
		if(ses == null) {//if there's no session
			ses = sf.openSession(); // SessionFactory would open a session
		}
		return ses; //this is a singleton design-pattern
	}
	
	public static void closeSes() {
		ses.close();
		ses = null;
	}

}
