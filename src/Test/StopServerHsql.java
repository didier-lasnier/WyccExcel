package Test;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.Connection;

import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.Server;
import org.hsqldb.server.ServerAcl.AclFormatException;

import com.dlas.gui.EcranAccueil;

public class StopServerHsql {
	public StopServerHsql(){
		
	}
	
	public static void test() throws IOException, ClassNotFoundException, AclFormatException{
		URL url = EcranAccueil.class.getProtectionDomain().getCodeSource().getLocation(); //Gets the path
	  	String jarPath = null;
			try {
				jarPath = URLDecoder.decode(url.getFile(), "UTF-8"); //Should fix it to be read correctly by the system
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			String directorypath = new File(jarPath).getParentFile().getPath(); //Path of the jar
			directorypath=directorypath+ File.separator;
			String fileCharSep = System.getProperty("file.separator");
			File directory=new File(directorypath);
		

			Connection conn = null;
	
			// String
			// connectionString="jdbc:h2:"+directory.getCanonicalPath()+fileCharSep+"db"+fileCharSep+"DBwycc";
			String connectionString = "jdbc:hsqldb:" + directory.getCanonicalPath() + fileCharSep + "db" + fileCharSep
					+ "hsql";
		 String dbName = "db";
		 Class.forName("org.hsqldb.jdbcDriver"); 
	     HsqlProperties hsqlProperties = new HsqlProperties(); 
	     hsqlProperties.setProperty("server.port", 3336); 
	     hsqlProperties.setProperty("server.database.0", "file:" + dbName); 
	     hsqlProperties.setProperty("server.dbname.0", dbName); 
	     hsqlProperties.setProperty("server.silent", true); 
	     hsqlProperties.setProperty("hsqldb.cache_file_scale", 128); 
	     hsqlProperties.setProperty("hsqldb.write_delay", false); 
	     hsqlProperties.setProperty("hsqldb.write_delay_millis", 0); 
	     Server server = new Server(); 
	     server.setProperties(hsqlProperties); 
	     server.setLogWriter(null); 
	     server.start(); 
	//     Connection connection = createConnection("localhost", dbName); 
	//     if (connection != null) { 
	//         this.readObjects(connection, dbName); 
	//         Statement statement = connection.createStatement(); 
	//         statement.execute("ALTER USER SA SET PASSWORD 'as2dbadmin'"); 
	//         ConsoleProgressBar.print(95); 
	//         statement.execute("SHUTDOWN COMPACT"); 
	//         ConsoleProgressBar.print(100); 
	//         System.out.println(); 
	//     } 
	//     connection.close(); 
	     server.shutdown(); 
	}
	 public static void main( String args[] ) throws ClassNotFoundException, IOException, AclFormatException {
		 test();
	 }
}
