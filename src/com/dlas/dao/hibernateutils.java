package com.dlas.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.apache.log4j.Logger;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class hibernateutils {
	private static SessionFactory sessionFactory;
	static Logger logger = Logger.getLogger("wycc");

	public static SessionFactory getSessionFactory() {
		try {
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml").build();

			Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();

			return metadata.getSessionFactoryBuilder().build();
		} finally {

		}
	}

	public static Session opensession() {
		Session lasession;

		try {
			SessionFactory factory = hibernateutils.getSessionFactory();
			lasession = factory.openSession();
			return lasession;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}

	}

	public static void closesession(Session lasession) {

		try {
			lasession.close();
		} catch (Exception e) {
			logger.error(e);

		}
	}

}
