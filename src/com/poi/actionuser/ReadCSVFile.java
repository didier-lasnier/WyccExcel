package com.poi.actionuser;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.*;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.dlas.dao.H2db;
import com.dlas.dao.HsqlText;
import com.dlas.gui.EcranAccueil;
import com.dlas.gui.model.Benefit;
import com.dlas.gui.model.Benefits;
import com.dlas.tools.CsvTools;
import com.poi.dlas.WyccWorkbook;
import com.poi.dlas.managecsv;

public class ReadCSVFile implements IRunnableWithProgress {
	 static  Logger            logger = LogManager.getLogger("wycc");
	 private EcranAccueil      window;
	 private String            message;
	 private H2db              dbconn;
	 private String            filepath;
	 private Timestamp          startD;
	 private Timestamp          endD;
	 private String            dir;
	 private Shell             shell;
	 private Benefits          benefits;
	 private PreparedStatement prepStmt;
	 private String            appDir;
	 private File              theOpenfile;
	 private File              theSavefile;
     private File              directory;
   	 private String            fileCharSep = System.getProperty("file.separator");
     private managecsv         csvdata = new managecsv();
     private H2db              db;
	 private String            StartDateStr;
	 private String            EndDateStr;
	 
	 

	public static Logger getLogger() {
		return logger;
	}

	public EcranAccueil getWindow() {
		return window;
	}

	public String getMessage() {
		return message;
	}

	public H2db getDbconn() {
		return dbconn;
	}

	public String getFilepath() {
		return filepath;
	}

	public Timestamp getStartD() {
		return startD;
	}

	public Timestamp getEndD() {
		return endD;
	}

	public String getDir() {
		return dir;
	}

	public Shell getShell() {
		return shell;
	}

	public Benefits getBenefits() {
		return benefits;
	}

	public String getAppDir() {
		return appDir;
	}

	public File getTheOpenfile() {
		return theOpenfile;
	}

	public File getTheSavefile() {
		return theSavefile;
	}

	public File getDirectory() {
		return directory;
	}

	public String getFileCharSep() {
		return fileCharSep;
	}

	public managecsv getCsvdata() {
		return csvdata;
	}

	public H2db getDb() {
		return db;
	}

	public String getStartDateStr() {
		return StartDateStr;
	}

	public String getEndDateStr() {
		return EndDateStr;
	}

	public static void setLogger(Logger logger) {
		ReadCSVFile.logger = logger;
	}

	public void setWindow(EcranAccueil window) {
		this.window = window;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDbconn(H2db dbconn) {
		this.dbconn = dbconn;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public void setStartD(Timestamp startD) {
		this.startD = startD;
	}

	public void setEndD(Timestamp endD) {
		this.endD = endD;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}

	public void setBenefits(Benefits benefits) {
		this.benefits = benefits;
	}

	public void setAppDir(String appDir) {
		this.appDir = appDir;
	}

	public void setTheOpenfile(File theOpenfile) {
		this.theOpenfile = theOpenfile;
	}

	public void setTheSavefile(File theSavefile) {
		this.theSavefile = theSavefile;
	}

	public void setDirectory(File directory) {
		this.directory = directory;
	}

	public void setFileCharSep(String fileCharSep) {
		this.fileCharSep = fileCharSep;
	}

	public void setCsvdata(managecsv csvdata) {
		this.csvdata = csvdata;
	}

	public void setDb(H2db db) {
		this.db = db;
	}

	public void setStartDateStr(String startDateStr) {
		StartDateStr = startDateStr;
	}

	public void setEndDateStr(String endDateStr) {
		EndDateStr = endDateStr;
	}

	public ReadCSVFile(EcranAccueil window, String message,   Timestamp startD,
			Timestamp endD, Shell shell, Benefits benefits,  String appDir,String filepath) {
		super();
		this.window = window;
		this.message = message;
		this.startD = startD;
		this.endD = endD;
		this.shell = shell;
		this.benefits = benefits;
		this.filepath=filepath;
		this.appDir = appDir;
		this.dir   = appDir;
		this.directory  =new File(appDir);
		this.csvdata = new managecsv();
	}

	public PreparedStatement getPrepStmt() {
		return prepStmt;
		
	}

	public void setPrepStmt(PreparedStatement prepStmt) {
		this.prepStmt = prepStmt;
	}

	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		monitor.beginTask(message, IProgressMonitor.UNKNOWN);
		logger.info("start run ReadCSVFile");
	    String StringFile =filepath;
		Benefit benefit = new Benefit();
		Actionuser actiouser = new Actionuser();
		
		 monitor.setTaskName("Processing csv file.");
		 monitor.worked(1);
		if (StringFile !=null) {
			benefits.addBenefits(StringFile, shell, benefit, window, monitor);
			//filepath = window.getFilepath();
			theOpenfile = new File(filepath);
			if (benefits.getBenefits().size() > 0) {
				this.inittialise(this.getStartD(),this.getEndD());
				theSavefile = this.saveIntempFile(theOpenfile, csvdata);
				
				WyccWorkbook wyccwb = new WyccWorkbook();
				Session lasession=wyccwb.CreateDataSession();
				this.deletmvt(lasession);
				lasession.getTransaction().commit();
				
				lasession.beginTransaction();
				try {
					lireCSV(theOpenfile, db,monitor,lasession);
					lasession.flush();
					lasession.clear();
				} catch (Exception e1) {
					logger.error(e1);
					e1.printStackTrace();
				}
				lasession.getTransaction().commit();
				//wyccwb.closedataSession(lasession);
				lasession.beginTransaction();
				deletMvtNum(lasession);
				lasession.getTransaction().commit();
				
				lasession.beginTransaction();
				insertmvtNum(lasession);
				lasession.getTransaction().commit();
				
				lasession.beginTransaction();
				deleteListHier(lasession);
				lasession.getTransaction().commit();
				
				
				lasession.beginTransaction();
				insertListHierLevelzero(lasession);
				lasession.getTransaction().commit();
				
				
				lasession.beginTransaction();
				try {
					   insertListHierLevelN(lasession);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				lasession.getTransaction().commit();
				
				
				lasession.beginTransaction();
			    deleteBeneifiaries(lasession);
			    lasession.getTransaction().commit();
			    
			    lasession.beginTransaction();
				insertBeneficiaries(lasession);
				wyccwb.closedataSession(lasession);
				
				
				theSavefile.deleteOnExit();
				logger.info("DONE !");
			} 
		}
		else {
			logger.info("the varaible stringFile is null");
		}
		monitor.done();
		
		
	}
	
	public String chooseFile(Shell s) throws IOException {
		
		
		File directory = new File(".");
		String fileCharSep = System.getProperty("file.separator");
		FileDialog fd = new FileDialog(s, SWT.OPEN);
		fd.setText("Choose a file");
		fd.setFilterPath(directory.getCanonicalPath());
		String[] filterExt = { "*.csv"};
		fd.setFilterExtensions(filterExt);
		String selected=fd.open();
		
		return selected;
	}
	
	public void inittialise (Timestamp startD,Timestamp endD){
	     
         theOpenfile=new File(filepath);
         directory  =new File(appDir);
      	 fileCharSep = System.getProperty("file.separator");
         csvdata = new managecsv();
        
        
        Calendar instance = Calendar.getInstance();
        
		try {
			
			instance.set(Calendar.DAY_OF_MONTH, startD.getDay());
			instance.set(Calendar.MONTH, startD.getMonth());
			instance.set(Calendar.YEAR, startD.getYear());
			
			 StartDateStr  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(instance.getTime());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("Erreur de gestion de date ");
			logger.error(e);
			e.printStackTrace();
		}
		
		instance = Calendar.getInstance();
		try {
			instance.set(Calendar.DAY_OF_MONTH, endD.getDay());
			instance.set(Calendar.MONTH, endD.getMonth());
			instance.set(Calendar.YEAR, endD.getYear());
			EndDateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(instance.getTime());
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		
		db=this.getdb();
		
		
	}
	
	private File saveIntempFile ( File theOpenfile,managecsv csvdata){
		// read file csv
        theOpenfile.getParent();

		logger.info("read file csv");
		List<String[]> csvrows = csvdata.getRowsFromFile(theOpenfile);
		System.out.print(dir + "tmp"); 
		
		// on sauvegarde la lecture du csv dans un fichier temporaire
		File theSavefile = null;
		try {
			theSavefile = File.createTempFile("tmp", null,
					new File(dir +  "tmp"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String file = theSavefile.getAbsolutePath();
		logger.info("theSavefile Done : " + file);
		csvdata.setRowToFile(csvrows, theSavefile);
		return  theSavefile;
		}
	
	private H2db getdb (){
		H2db db = null;
		try {
			db = new H2db();
		} catch (SQLException e1) {
			logger.error(e1);
			e1.printStackTrace();
		}
		
		
		try {
			db.getDatabase(directory);
		} catch (IOException e1) {
			logger.error(e1);
			e1.printStackTrace();
		}
		return db;
	}
	
	
	public void deletmvt (Session lasession) {
		Query query = lasession.createQuery(
				"DELETE FROM Mvt2");
		int result = query.executeUpdate();
		lasession.flush();
		lasession.clear();
	
	}
	
	public void deletMvtNum(Session lasession){
		Query query = lasession.createQuery( "DELETE FROM Mvt_Num");
		int result = query.executeUpdate();
		lasession.flush();
		lasession.clear();

	}
	
	public void insertmvtNum(Session lasession){
		HsqlText sqlstmt = new HsqlText();
		lasession.createSQLQuery(sqlstmt.insertmvtnum()).executeUpdate();

	}
	public void lireCSV(File theCSVfile, H2db dbconn,IProgressMonitor monitor, Session lasession) throws Exception {

		if (theCSVfile != null) {

			HsqlText sqlstmt = new HsqlText();
			

			//this.setPrepStmt( dbconn.connectiondb.prepareStatement(sqlstmt.insertmvt()));
			logger.info("Select file csv : " + theCSVfile.getAbsolutePath());
			CsvTools csfile = new CsvTools();
			csfile.readcsvfile(this.getPrepStmt(), theCSVfile.getAbsolutePath(),monitor,lasession);
			//this.getPrepStmt().close();
		}
	}
	
	public void deleteListHier(Session lasession){
		Query query = lasession.createQuery( "DELETE FROM ListMvtHier");
		int result = query.executeUpdate();
		lasession.flush();
		lasession.clear();

	}
	
	public void insertListHierLevelzero(Session lasession){
		
		
		
		HsqlText sqlstmt = new HsqlText();
		lasession.createSQLQuery(sqlstmt.insertRootListMvthier(StartDateStr,EndDateStr)).executeUpdate();

//		PreparedStatement prepStmt = null;
//		try {
//			prepStmt = db.connectiondb.prepareStatement(sqlstmt.insertRootListMvthier(StartDateStr,EndDateStr));
//		} catch (SQLException e) {
//			logger.error(e);
//			e.printStackTrace();
//		}
//		logger.info("insert from lismvthier");
//		try {
//			prepStmt.executeUpdate();
//		} catch (SQLException e) {
//			logger.error(e);
//			e.printStackTrace();
//		}
//		try {
//			prepStmt.close();
//		} catch (SQLException e) {
//			logger.error(e);
//			e.printStackTrace();
//		}
	}
	
	public void insertListHierLevelN(Session lasession) throws SQLException{
		Integer numberOfRows = 0;
		Float lvl =  1f;
		HsqlText sqlstmt = new HsqlText();
		
		
		Query query = null;
		do {
			
			query = lasession.createQuery(sqlstmt.isLevelNListMvthier());
			query.setParameter("nextmvt", lvl);
			numberOfRows = ((Long) query.uniqueResult()).intValue();

			if (numberOfRows > 0) {
				
				query = lasession.createQuery(sqlstmt.insertLevelNListMvthier(StartDateStr,EndDateStr));
				query.setParameter("lv1", lvl+1);
				query.setParameter("nextmvt", lvl);
				query.executeUpdate();
			}
			lvl++;
		} while (numberOfRows != 0);
		
		
	}
	
	public void deleteBeneifiaries(Session lasession){
		
		Query query = lasession.createQuery( "DELETE FROM beneficiaries");
		int result = query.executeUpdate();
		lasession.flush();
		lasession.clear();

	}
	
	
	public void insertBeneficiaries(Session lasession){
		HsqlText sqlstmt = new HsqlText();
		lasession.createSQLQuery(sqlstmt.insertbeneficiairies()).executeUpdate();
		   //sqlstmt.insertbeneficiairies();
		
		
	}
}
