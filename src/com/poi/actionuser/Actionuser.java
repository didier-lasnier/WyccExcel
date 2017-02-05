package com.poi.actionuser;

import java.io.File;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.dlas.dao.h2db;
import com.dlas.dao.hsqltext;
import com.poi.dlas.FileDialog;
import com.poi.dlas.WyccWorkbook;
import com.poi.dlas.managecsv;

public class Actionuser {
	 static Logger logger = Logger.getLogger("wycc");

	public void actionuser() {
		
	}
	 public static void lanceLecture()  throws Exception {
		 
		  //   Workbook wb;
		     File directory = new File (".");
		     String fileCharSep =System.getProperty("file.separator");

		     //Open csv file
		     new FileDialog();
		     // launch SAveDialog
		     
		     FileDialog FileDialogOpen = new FileDialog();
		     logger.info("Select file csv");
		     File theOpenfile=null;
		     theOpenfile=FileDialogOpen.openFileDialog(directory);
		     if (theOpenfile!=null) 
		     {
		    	// read file csv
		         managecsv csvdata = new managecsv();
		         logger.info("read file csv");
		         List<String[]> csvrows= csvdata.getRowsFromFile (theOpenfile);

		         //   new FileDialog();
		         // FileDialog FileDialogSave =new FileDialog(FileDialog.SAVEDIAG);

		         File  theSavefile =File.createTempFile("tmp", null, new File (directory.getAbsolutePath()+fileCharSep+"tmp" ) );
		         String file = theSavefile.getAbsolutePath();
		         logger.info("theSavefile Done : " + file);
		         csvdata.setRowToFile(csvrows, theSavefile);

		         // Write the output to a file
		         h2db db=new h2db();
		         db.getDatabase(directory);
		         hsqltext sqlstmt = new hsqltext();

		         Statement stmt = db.connectiondb.createStatement();

		         logger.info("delete from mvt");
		         stmt.executeUpdate("DELETE FROM MVT");
		         stmt.close();
		         
		         stmt = db.connectiondb.createStatement();
		         logger.info("read csv file into from mvt");
		         stmt.executeUpdate("INSERT INTO MVT  SELECT * FROM CSVREAD('"+file+"')");//, null, 'charset=UTF-8 fieldSeparator=;')");
		         stmt.close();
		         
		         stmt = db.connectiondb.createStatement();
		         logger.info("delete from mvt_num");
		         stmt.executeUpdate("DELETE FROM MVT_NUM");
		         stmt.close();
		         
		         stmt = db.connectiondb.createStatement();		         
		         logger.info("read csv file into from mvt");
		         stmt.executeUpdate(sqlstmt.insertmvtnum());//, null, 'charset=UTF-8 fieldSeparator=;')");
		         stmt.close();
		         
		         stmt = db.connectiondb.createStatement();
		         logger.info("delete from beneficiaries_tab");
		         stmt.executeUpdate("DELETE FROM BENEFICIAIRIES_TAB");
		         stmt.close();
		         
		         stmt = db.connectiondb.createStatement();		         
		         logger.info("read csv file into from mvt");
		         stmt.executeUpdate(sqlstmt.insertbeneficiairies() );//, null, 'charset=UTF-8 fieldSeparator=;')");
		         stmt.close();
		         
		         db.closeDbConnection(db.connectiondb);
		         theSavefile.deleteOnExit();
		         logger.info("DONE !");
/*
		         File theXlsfile=FileDialogOpen.saveFileDialog(directory);


		         // on génére le fichier xls
		         WyccWorkbook myWrkBk = new WyccWorkbook();
		         myWrkBk.createWorkbook(theXlsfile);
		 */
		     }
		     
		     //System.exit(0);
		 }


	
}
