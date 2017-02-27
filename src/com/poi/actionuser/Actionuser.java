package com.poi.actionuser;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.swt.widgets.DateTime;

import com.dlas.dao.h2db;
import com.dlas.dao.hsqltext;
import com.dlas.tools.CsvTools;
import com.poi.dlas.FileDialogOld;
import com.poi.dlas.WyccWorkbook;
import com.poi.dlas.managecsv;

public class Actionuser {
	static Logger logger = Logger.getLogger("wycc");

	public void actionuser() {

	}

	public static void lanceLecture(String Filepath,DateTime StartD,DateTime EndD ) throws Exception {

            File theOpenfile=new File(Filepath);
            Calendar instance = Calendar.getInstance();
			instance.set(Calendar.DAY_OF_MONTH, StartD.getDay());
			instance.set(Calendar.MONTH, StartD.getMonth());
			instance.set(Calendar.YEAR, StartD.getYear());
			String StartDateStr  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(instance.getTime());
			instance = Calendar.getInstance();
			instance.set(Calendar.DAY_OF_MONTH, EndD.getDay());
			instance.set(Calendar.MONTH, EndD.getMonth());
			instance.set(Calendar.YEAR, EndD.getYear());
			String EndDateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(instance.getTime());
			
			// read file csv
            theOpenfile.getParent();
			managecsv csvdata = new managecsv();
			logger.info("read file csv");
			List<String[]> csvrows = csvdata.getRowsFromFile(theOpenfile);

			File directory = new File(".");
			String fileCharSep = System.getProperty("file.separator");

			File theSavefile = File.createTempFile("tmp", null,
					new File(directory.getCanonicalPath() + fileCharSep + "tmp"));
			String file = theSavefile.getAbsolutePath();
			logger.info("theSavefile Done : " + file);
			csvdata.setRowToFile(csvrows, theSavefile);

			// Write the output to a file
			h2db db = new h2db();
			db.getDatabase(directory);
			hsqltext sqlstmt = new hsqltext();
			// Statement stmt = db.connectiondb.createStatement();
			PreparedStatement stmt = db.connectiondb.prepareStatement("DELETE FROM MVT");
			logger.info("delete from mvt");
			stmt.executeUpdate();
			stmt.close();

			if (1 == 1) {
				logger.info("read csv file into from mvt");
				lireCSV(theOpenfile, db);
			} else {
				// db.connectiondb.prepareStatement(sqlstmt.insertmvtnum());
				stmt = db.connectiondb.prepareStatement("INSERT INTO MVT  SELECT * FROM CSVREAD('" + file + "')");
				logger.info("read csv file into from mvt");
				stmt.executeUpdate();// , null, 'charset=UTF-8
										// fieldSeparator=;')");
				stmt.close();
			}

			stmt = db.connectiondb.prepareStatement("DELETE FROM MVT_NUM"); // db.connectiondb.createStatement();
			logger.info("delete from mvt_num");
			stmt.executeUpdate();
			stmt.close();

			// stmt = db.connectiondb.createStatement();
			stmt = db.connectiondb.prepareStatement(sqlstmt.insertmvtnum());
			logger.info("read csv file into from mvt");
			stmt.executeUpdate();// , null, 'charset=UTF-8 fieldSeparator=;')");
			stmt.close();

			// stmt = db.connectiondb.createStatement();
			stmt = db.connectiondb.prepareStatement("DELETE FROM PUBLIC.LISTMVTHIER");
			logger.info("delete from lismvthier");
			stmt.executeUpdate();
			stmt.close();

			PreparedStatement prepStmt = db.connectiondb.prepareStatement(sqlstmt.insertRootListMvthier(StartDateStr,EndDateStr));
			logger.info("insert from lismvthier");
			prepStmt.executeUpdate();
			prepStmt.close();
			int numberOfRows = 0;
			int lvl = 1;
			do {

				prepStmt = db.connectiondb.prepareStatement(sqlstmt.isLevelNListMvthier());
				prepStmt.setInt(1, lvl);
				ResultSet rs = prepStmt.executeQuery();
				if (rs.next()) {
					numberOfRows = rs.getInt(1);
					prepStmt.close();
					if (numberOfRows > 0) {
						prepStmt = db.connectiondb.prepareStatement(sqlstmt.insertLevelNListMvthier(StartDateStr,EndDateStr));
						prepStmt.setInt(1, lvl + 1);
						prepStmt.setInt(2, lvl);
						prepStmt.executeUpdate();
						prepStmt.close();
					}
				} else {
					prepStmt.close();
					System.out.println("error: could not get the record counts");
				}
				lvl++;
			} while (numberOfRows != 0);

			stmt = db.connectiondb.prepareStatement("DELETE FROM BENEFICIARIES_TAB");
			logger.info("delete from beneficiaire");
			stmt.executeUpdate();
			stmt.close();

			stmt = db.connectiondb.prepareStatement(sqlstmt.insertbeneficiairies());
			logger.info("Insert Beneficiaries");
			stmt.executeUpdate();// , null, 'charset=UTF-8 fieldSeparator=;')");
			stmt.close();
			
			db.closeDbConnection(db.connectiondb);
			theSavefile.deleteOnExit();
			logger.info("DONE !");



		// System.exit(0);
	}

	
	
	public static void lireCSV(File theCSVfile, h2db dbconn) throws Exception {

		// Workbook wb;

		if (theCSVfile != null) {

			hsqltext sqlstmt = new hsqltext();
			PreparedStatement prepStmt = dbconn.connectiondb.prepareStatement(sqlstmt.insertmvt());
			logger.info("Select file csv : " + theCSVfile.getAbsolutePath());
			CsvTools csfile = new CsvTools();
			csfile.readcsvfile(prepStmt, theCSVfile.getAbsolutePath());
			prepStmt.close();
		}
	}

}
