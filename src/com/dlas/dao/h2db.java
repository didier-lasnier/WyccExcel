package com.dlas.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;

public class h2db {

	public Connection connectiondb;

	public h2db() throws SQLException {
	}

	static Logger logger = Logger.getLogger("wycc");

	public Session getSession() throws IOException {
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		return session;

	}

	public Connection getDatabase(File directory) throws IOException {
		String fileCharSep = System.getProperty("file.separator");
		directory.getCanonicalFile();
		logger.info(directory.getCanonicalFile());
		logger.info(directory.getAbsolutePath() + "******");

		Connection conn = null;

		// String
		// connectionString="jdbc:h2:"+directory.getCanonicalPath()+fileCharSep+"db"+fileCharSep+"DBwycc";
		String connectionString = "jdbc:hsqldb:" + directory.getCanonicalPath() + fileCharSep + "db" + fileCharSep
				+ "hsql";
		logger.info(connectionString + "******");
		System.out.print("Connection String : " +connectionString);
		// jdbcDataSource ds = new jdbcDataSource();
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			conn = DriverManager.getConnection(connectionString, "wycc", "wycc");
			this.connectiondb = conn;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ds.getConnection();

		return conn;
	}

	public void closeDbConnection(Connection conn) throws SQLException {
		conn.close();
	}

}
