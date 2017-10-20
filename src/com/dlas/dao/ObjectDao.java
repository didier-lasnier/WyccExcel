package com.dlas.dao;

import com.dlas.dao.HibernateUtils;

import java.util.List;

import org.hibernate.Query;
//import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ObjectDao {
	private SessionFactory lafactory ;
	
	public ObjectDao() {
	};

	public Session getSessionDao() {

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session lasession = factory.openSession();
		return lasession;
	};

	public Session getSession(SessionFactory factory) {
		Session lasession = factory.openSession();
		return lasession;
	};

	public SessionFactory getLafactory() {
		return lafactory;
	}

	public void setLafactory(SessionFactory lafactory) {
		this.lafactory = lafactory;
	}

	public void setFactory(SessionFactory factory) {
		this.lafactory=factory;
	}
	
	
	public SessionFactory getFactory() {

		SessionFactory factory = HibernateUtils.getSessionFactory();
		return factory;
	};

	public void saveDao(Session session, Object object) {

		session.save(object);

	}

	public List<Object> getlistObjectDao(Session session) {
		try {
			Query query = session.createQuery("from SETTINGSCELL p");
			List querylist = query.list();
			return querylist;
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
				return queryList.get(0);
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
