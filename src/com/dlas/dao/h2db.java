package com.dlas.dao;


import org.apache.log4j.Logger;
import org.h2.jdbcx.JdbcDataSource;
import org.hibernate.HibernateException ;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.io.File;
import java.io.IOException;
import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.List;

public class h2db {
	
	 public Connection connectiondb ;
	 
	 public h2db() throws SQLException {
	 }
	 
	 static Logger logger = Logger.getLogger("wycc");
	 
	 public Session getSession() throws IOException {
			SessionFactory sessionFactory;
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			Session session = sessionFactory.openSession();
		 
		 
		 return session;
		 
	 }
	 
	 public Connection getDatabase(File directory) throws IOException
	 {
		String fileCharSep =System.getProperty("file.separator");
		 directory.getCanonicalFile();
		 logger.info(directory.getCanonicalFile());
		 logger.info(directory.getAbsolutePath()+"******" );
		 
		 String connectionString="jdbc:h2:"+directory.getCanonicalPath()+fileCharSep+"db"+fileCharSep+"wyccdb";
		 logger.info(connectionString+"******" );
		 JdbcDataSource ds = new JdbcDataSource();
		 ds.setURL(connectionString);
		 ds.setUser("wycc");
		 ds.setPassword("wycc");
		 Connection conn=null;
		
			try {
				conn = ds.getConnection();
				this.connectiondb=conn;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //ds.getConnection();
			

			
			
			
			
		 return conn;
	 }
	 
	 public void closeDbConnection (Connection conn) throws SQLException {
		 conn.close();
	 }

}
