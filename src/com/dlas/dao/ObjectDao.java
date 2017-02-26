package com.dlas.dao;

import com.dlas.dao.hibernateutils;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
//import javax.management.Query;

//import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;

public class ObjectDao {
	public ObjectDao() {
	};

	public Session getSessionDao() {

		SessionFactory factory = hibernateutils.getSessionFactory();
		Session lasession = factory.openSession();
		return lasession;
	};

	public void saveDao(Session session, Object object) {

		session.save(object);

	}

	public List<Object> getlistObjectDao(Session session) {
		try {
			Query query = session.createQuery("from SETTINGSCELL p");
			List querylist = query.list();
			return (List<Object>) querylist;
		} catch (Exception e) {
			return null;
		}
	}

	public Object getDao(Session session, Object object, long idrow, long idcolumn) {

		try {

			Query query = session
					.createQuery("from SETTINGSCELL p where p.cellrow = :idrow and p.cellcolumn = :idcolumn");
			query.setParameter("idrow", idrow);
			query.setParameter("idcolumn", idcolumn);
			List queryList = query.list();
			if (queryList != null && queryList.isEmpty()) {
				return null;
			} else {
				return (Object) queryList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

	}

	public void insertDao(Session session, Object object) {

		session.save(object);

	}

	public void updateDao(Session session, Object object, long idrow, long idcolumn) {

		// session.save(object);
		session.save(object);

	}

	public void deleteDao(Session session, Object object, long id) {

		session.delete(object);

	}

}
