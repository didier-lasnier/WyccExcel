package com.poi.actionuser;

import java.lang.reflect.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.dlas.dao.h2db;
import com.dlas.dao.hsqltext;

import com.poi.dlas.WyccWorkbook;
import com.poi.dlas.managecsv;

public class ReadFileXlsx {
	private String header[];
	private Object body[][];
	private String lastFileName = null;
	private String lastSheetName = null;

	static Logger logger = Logger.getLogger("wycc");

	public void ReadFileXlsx() {

	}

	/*
	 * public static void main (String[] arg){
	 * Tableau("/Volumes/LaCie/ProjetDev/JavaEclipse/ExcelJava/WYCC.xlsx","Test"
	 * ); }
	 */
	public void readxls(String filepath) throws InvalidFormatException {
//		File directory = new File(".");
//		String fileCharSep = System.getProperty("file.separator");
//
//		// Open csv file
//		new FileDialogOld();
//		// launch SAveDialog
//
//		FileDialogOld FileDialogOpen = new FileDialogOld();
		logger.info("Select file csv");
		File theOpenfile = null;
		try {
			//theOpenfile = FileDialogOpen.openFileDialog(directory);
			theOpenfile=new File(filepath);
			FileInputStream out = new FileInputStream(theOpenfile);
			// on a le dialogue des fichiers
			// org.apache.poi.ss.usermodel.Workbook wrkbk =
			// WorkbookFactory.create(theOpenfile);
			XSSFWorkbook wrkbk = new XSSFWorkbook(out);
			WyccWorkbook wyccwrkbk = new WyccWorkbook();
			wyccwrkbk.setWorkBook(wrkbk);
			wyccwrkbk.getWorkbook(theOpenfile);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

/*	public void generexls() throws InvalidFormatException, SQLException, IOException {
		File directory = new File(".");
		String fileCharSep = System.getProperty("file.separator");

		// Open csv file
		//new FileDialogOld();

		WyccWorkbook wyccwrkbk = new WyccWorkbook();

		wyccwrkbk.setBeneficiairies();
	}*/
	
	public void generexls(String filepath) throws InvalidFormatException, SQLException, IOException {
		WyccWorkbook wyccwrkbk = new WyccWorkbook();
		wyccwrkbk.setBeneficiairies(filepath);
	}


}
