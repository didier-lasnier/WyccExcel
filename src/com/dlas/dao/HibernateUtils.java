package com.dlas.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.apache.logging.log4j.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
	private static SessionFactory sessionFactory;
	static Logger logger = LogManager.getLogger("wycc");

	public static SessionFactory getSessionFactory() {
		try {
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					.configure().build();
			Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			return metadata.getSessionFactoryBuilder().build();
		} finally {

		}
	}

	public static Session opensession() {
		Session lasession;

		try {
			SessionFactory factory = HibernateUtils.getSessionFactory();
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
