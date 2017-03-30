
/* ====================================================================
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
==================================================================== */

package com.poi.dlas;


import java.io.File;


import java.util.List;
import org.apache.log4j.Logger;
import java.sql.Statement;


import com.poi.dlas.managecsv;
import com.poi.dlas.WyccWorkbook;

import com.dlas.dao.*;

/**
 * A business plan demo Usage: BusinessPlan -xls|xlsx
 *
 * @author Yegor Kozlov
 */
public class WyccCsvFacturation {

	static Logger logger = Logger.getLogger("wycc");

/*	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		MenuWycc theMenu = new MenuWycc();
		// needed on mac os x

		System.setProperty("apple.laf.useScreenMenuBar", "true");

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MenuWycc.createAndShowGUI();

			}
		});
	}
*/
	public static void lanceLecture() throws Exception {

//		// Workbook wb;
//		File directory = new File(".");
//		String fileCharSep = System.getProperty("file.separator");
//
//		// Open csv file
//		new FileDialogOld();
//		// launch SAveDialog
//
//		FileDialogOld FileDialogOpen = new FileDialogOld();
//		logger.info("Select file csv");
//		File theOpenfile = null;
//		theOpenfile = FileDialogOpen.openFileDialog(directory);
//		if (theOpenfile != null) {
//			// read file csv
//			managecsv csvdata = new managecsv();
//			logger.info("read file csv");
//			List<String[]> csvrows = csvdata.getRowsFromFile(theOpenfile);
//
//			// new FileDialog();
//			// FileDialog FileDialogSave =new FileDialog(FileDialog.SAVEDIAG);
//
//			File theSavefile = File.createTempFile("tmp", null,
//					new File(directory.getAbsolutePath() + fileCharSep + "tmp"));
//			String file = theSavefile.getAbsolutePath();
//			logger.info("theSavefile Done : " + file);
//			csvdata.setRowToFile(csvrows, theSavefile);
//
//			// Write the output to a file
//			h2db db = new h2db();
//			db.getDatabase(directory);
//			hsqltext sqlstmt = new hsqltext();
//
//			Statement stmt = db.connectiondb.createStatement();
//
//			logger.info("delete from mvt");
//			stmt.executeUpdate("DELETE FROM MVT");
//			logger.info("read csv file into from mvt");
//			stmt.executeUpdate("INSERT INTO MVT  SELECT * FROM CSVREAD('" + file + "')");// ,
//																							// null,
//																							// 'charset=UTF-8
//																							// fieldSeparator=;')");
//
//			logger.info("delete from mvt_num");
//			stmt.executeUpdate("DELETE FROM MVT_NUM");
//			logger.info("read csv file into from mvt");
//			stmt.executeUpdate(sqlstmt.insertmvtnum());// , null, 'charset=UTF-8
//														// fieldSeparator=;')");
//
//			stmt.close();
//			db.closeDbConnection(db.connectiondb);
//			theSavefile.deleteOnExit();
//			logger.info("DONE !");
//
//		}
//
//		// System.exit(0);
	}

}