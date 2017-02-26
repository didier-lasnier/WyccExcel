package com.poi.dlas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;

import com.dlas.dao.h2db;

import com.dlas.dao.hsqltext;
import com.dlas.tools.Tools;
import com.dlas.dao.Wycccell;
import com.dlas.dao.Modul;
import com.poi.actionuser.Explorateur;

//import au.com.ozblog.hibernate.h2.example.User;

import com.dlas.dao.ObjectDao;
import com.dlas.dao.beneficiaries;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class WyccWorkbook {
	public XSSFWorkbook currentworkbook;
	public XSSFSheet currentSheet;

	public WyccWorkbook() {

	}

	public WyccWorkbook(File xlsfileWycc) {
		try {
			this.currentworkbook = new XSSFWorkbook(xlsfileWycc);
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public XSSFWorkbook setWorkBook(XSSFWorkbook wrkbk) {

		return this.currentworkbook = wrkbk;

	}

	public XSSFSheet setSheet(XSSFSheet wrkbkSheet) {
		this.currentSheet = wrkbkSheet;
		return wrkbkSheet;
	}

	public XSSFWorkbook getWorkBook() {
		return this.currentworkbook;

	}

	public XSSFSheet getSheet() {
		return this.currentSheet;

	}

	public static Logger logger = Logger.getLogger("wycc");

	public void createWorkbook(File xlsfileWycc) throws IOException, InvalidFormatException {

		// Workbook wb=SetworkBook( new XSSFWorkbook());
		setSheet(setWorkBook(new XSSFWorkbook(xlsfileWycc)).createSheet("Total WYCC"));
		/*
		 * Row row; Cell cell; int rownum = 1; int colnum =1; String data =
		 * "Test";
		 * 
		 * 
		 * PrintSetup printSetup = sheet.getPrintSetup();
		 * printSetup.setLandscape(true);
		 * 
		 * //the following three statements are required only for HSSF
		 * sheet.setAutobreaks(true); printSetup.setFitHeight((short)1);
		 * printSetup.setFitWidth((short)1);
		 * 
		 * Row headerRow = sheet.createRow(0);
		 * headerRow.setHeightInPoints(12.75f);
		 * 
		 * cell = headerRow.createCell(0); cell.setCellValue(data);
		 */

		// Write the output to a file
		String filepath = xlsfileWycc.getCanonicalPath();
		// if(wb instanceof XSSFWorkbook) file += "x";
		logger.info(filepath);

		Object[][] bookData = { { "Head First Java", "Kathy Serria", 79 }, { "Effective Java", "Joshua Bloch", 36 },
				{ "Clean Code", "Robert martin", 42 }, { "Thinking in Java", "Bruce Eckel", 35 }, };

		int rowCount = 0;

		/*
		 * for (Object[] aBook : bookData) { Row row =
		 * sheet.createRow(++rowCount);
		 * 
		 * int columnCount = 0;
		 * 
		 * for (Object field : aBook) { Cell cell =
		 * row.createCell(++columnCount); if (field instanceof String) {
		 * cell.setCellValue((String) field); } else if (field instanceof
		 * Integer) { cell.setCellValue((Integer) field); } }
		 * 
		 * }
		 */

		FileOutputStream out = new FileOutputStream(filepath);
		this.getWorkBook().write(out);
		out.close();
		this.getWorkBook().close();
	}

	public void getWorkbook(File xlsfileWycc) throws IOException {
		try {
			// file is not open
			// FileOutputStream out = new
			// FileOutputStream(xlsfileWycc.getAbsolutePath() );
			File directory = new File(".");
			String fileCharSep = System.getProperty("file.separator");

			ObjectDao myobj = new ObjectDao();
			Session lasession = myobj.getSessionDao();

			try {
				XSSFSheet sheet = this.currentworkbook.getSheetAt(0);

				int firstSheet = 0;
				int firstrow = 3;

				/*
				 * lasession.beginTransaction(); Query query =
				 * lasession.createSQLQuery("DELETE FROM SETTINGSCELL"); int
				 * result = query.executeUpdate();
				 * lasession.getTransaction().commit(); lasession.close();
				 */

				h2db db = new h2db();
				db.getDatabase(directory);
				String sqlstmt1 = "DELETE FROM PUBLIC.SETTINGSCELL";

				Statement stmt = db.connectiondb.createStatement();
				stmt.executeUpdate(sqlstmt1);
				stmt.close();

				for (int i = firstrow; i <= 4; i++) {
					readData(this.currentworkbook, 0, i, lasession);
				}

				firstrow = 12;
				for (int i = firstrow; i <= 13; i++) {
					readData(this.currentworkbook, 0, i, lasession);
				}
				lasession.close();

				this.currentworkbook.close();
				logger.info("DONE ! readData");
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void readXlsfile(XSSFWorkbook workbook, int sheetnumber) {

	}

	public void setBeneficiairies() throws SQLException, IOException {

		/*
		 * ObjectDao myobj= new ObjectDao(); Session lasession =
		 * myobj.getSessionDao(); lasession.beginTransaction(); List
		 * resultdistinct = lasession.createQuery("from beneficiaries").list();
		 * lasession.getTransaction().commit();
		 */

		File directory = new File(".");
		String fileCharSep = System.getProperty("file.separator");

		// List result=readformula();

		h2db db = new h2db();
		db.getDatabase(directory);
		String sqlstmt1 = "SELECT WYCC_ID, NAME, FIRST_NAME, LINE, STRUCTURE_NAME, FAMILY_COVERED, CHILDREN, NATIONALITY, COUNTRY,";
		sqlstmt1 = sqlstmt1
				+ " PERIOD_INSURANCE, POSITIONCREW, START_MOVEMENT, PREVMVT, ENDCOMP, END_MOVEMENT, NEXTMVT, NEXTCOMP,";
		sqlstmt1 = sqlstmt1 + " MONTHLY_SALARY, SALARY_CURRENCY, DRESTEJ, ERESTEJ, TO_INVOICE, JOUR,MOIS,";
		sqlstmt1 = sqlstmt1
				+ " company1,formule1, formule_name1,police_number1, total_amount_insured1, company2,formule2, formule_name2,police_number2, total_amount_insured2,";
		sqlstmt1 = sqlstmt1
				+ " company3,formule3, formule_name3,police_number3, total_amount_insured3, company4,formule4, formule_name4,police_number4, total_amount_insured4,";
		sqlstmt1 = sqlstmt1
				+ " company5,formule5, formule_name5,police_number5, total_amount_insured5, company6,formule6, formule_name6,police_number6, total_amount_insured6,";
		sqlstmt1 = sqlstmt1
				+ " company7,formule7, formule_name7,police_number7, total_amount_insured7, company8,formule8, formule_name8,police_number8, total_amount_insured8";
		sqlstmt1 = sqlstmt1 + " FROM PUBLIC.BENEFICIARIES_TAB";

		// Lire le header
		List result = readformula("MONTHLY", 0);

		XSSFWorkbook newworkbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = newworkbook.createSheet("Total WYCC");
		int introw = 3;
		XSSFRow row = spreadsheet.createRow(introw);
		int myIterator = 0;
		int start = 0;
		int end = 17;
		int myOffset = 57;
		setFormulaHeader(introw, result, newworkbook, row, myIterator, start, end, 0);
		start = 17;
		end = 73;
		for (myIterator = 1; myIterator <= 8; myIterator++) {
			setFormulaHeader(introw, result, newworkbook, row, myIterator, start, end, myOffset);
		}
		Statement stmt = db.connectiondb.createStatement();
		ResultSet rs = stmt.executeQuery(sqlstmt1);

		ObjectDao myobj = new ObjectDao();
		Session lasession = myobj.getSessionDao();

		introw = 4;
		Modul modul = new Modul();
		while (rs.next()) // for (beneficiairies event : (List<beneficiairies>)
							// resultdistinct)
		{
			row = spreadsheet.createRow(introw);
			XSSFCell cell = null;
			int j = 0;
			// position Colonne A
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getString("POSITIONCREW"));

			// Name Colonne B
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getString("NAME"));
			// first name Colonne C
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getString("FIRST_NAME"));
			// structure name vessel Colonne D
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getString("STRUCTURE_NAME"));
			// crew manning agency Colonne
			j++;
			// periode de couverture Colonne E
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getString("PERIOD_INSURANCE"));
			// Single Ou Family Colonne F
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getString("FAMILY_COVERED"));
			// Nationalité Colonne G
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getString("NATIONALITY"));
			// Pays Colonne H
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getString("COUNTRY"));
			// Nbre d'enfant Colonne I
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getDouble("CHILDREN"));
			// Debut de mouvement Colonne J
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getDate("START_MOVEMENT"));
			// Fin de mouvement Colonne K
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getDate("END_MOVEMENT"));
			// Salaire_Currency Colonne L
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getString("SALARY_CURRENCY"));

			// Nbre de mois Colonne O
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getFloat("MOIS"));

			// Salaire Mensuel Colonne M
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getFloat("MONTHLY_SALARY"));

			// nbre de jour Colonne N
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getFloat("JOUR"));

			// TO_INVOICE Colonne P
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getFloat("TO_INVOICE"));

			for (int i = 1; i <= 8; i++) {
				modul = getBenefits(lasession, rs.getString("COMPANY" + i), rs.getString("FORMULE" + i),
						rs.getString("formule_name" + i), rs.getString("FAMILY_COVERED"));
				if (modul != null) {
					result = readformula(modul.getCalculmode(), 1);
					setFormula(introw, result, newworkbook, row, i, modul);
				}
			}

			introw++;
		}
		stmt.close();

		String filepath = null;
		File theXlsfile = null;
		FileDialogOld FileDialogOpen = new FileDialogOld();
		try {
			theXlsfile = FileDialogOpen.saveFileDialog(directory);
		} catch (InvocationTargetException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			filepath = theXlsfile.getCanonicalPath();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileOutputStream out;

		try {
			out = new FileOutputStream(new File(filepath));
			newworkbook.write(out);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("DONE ! setBeneficiaire");

		// lasession.close();

	}

	public void setBeneficiairies(String filepath) throws SQLException, IOException {
        File directory = new File(".");
		String fileCharSep = System.getProperty("file.separator");

		// List result=readformula();

		h2db db = new h2db();
		db.getDatabase(directory);
		String sqlstmt1 = "SELECT WYCC_ID, NAME, FIRST_NAME, LINE, STRUCTURE_NAME, FAMILY_COVERED, CHILDREN, NATIONALITY, COUNTRY,";
		sqlstmt1 = sqlstmt1
				+ " PERIOD_INSURANCE, POSITIONCREW, START_MOVEMENT, PREVMVT, ENDCOMP, END_MOVEMENT, NEXTMVT, NEXTCOMP,";
		sqlstmt1 = sqlstmt1 + " MONTHLY_SALARY, SALARY_CURRENCY, DRESTEJ, ERESTEJ, TO_INVOICE, JOUR,MOIS,";
		sqlstmt1 = sqlstmt1
				+ " company1,formule1, formule_name1,police_number1, total_amount_insured1, company2,formule2, formule_name2,police_number2, total_amount_insured2,";
		sqlstmt1 = sqlstmt1
				+ " company3,formule3, formule_name3,police_number3, total_amount_insured3, company4,formule4, formule_name4,police_number4, total_amount_insured4,";
		sqlstmt1 = sqlstmt1
				+ " company5,formule5, formule_name5,police_number5, total_amount_insured5, company6,formule6, formule_name6,police_number6, total_amount_insured6,";
		sqlstmt1 = sqlstmt1
				+ " company7,formule7, formule_name7,police_number7, total_amount_insured7, company8,formule8, formule_name8,police_number8, total_amount_insured8";
		sqlstmt1 = sqlstmt1 + " FROM PUBLIC.BENEFICIARIES_TAB";

		// Lire le header
		List result = readformula("MONTHLY", 0);

		XSSFWorkbook newworkbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = newworkbook.createSheet("Total WYCC");
		int introw = 3;
		XSSFRow row = spreadsheet.createRow(introw);
		int myIterator = 0;
		int start = 0;
		int end = 17;
		int myOffset = 57;
		setFormulaHeader(introw, result, newworkbook, row, myIterator, start, end, 0);
		start = 17;
		end = 73;
		for (myIterator = 1; myIterator <= 8; myIterator++) {
			setFormulaHeader(introw, result, newworkbook, row, myIterator, start, end, myOffset);
		}
		Statement stmt = db.connectiondb.createStatement();
		ResultSet rs = stmt.executeQuery(sqlstmt1);

		ObjectDao myobj = new ObjectDao();
		Session lasession = myobj.getSessionDao();

		introw = 4;
		Modul modul = new Modul();
		while (rs.next()) // for (beneficiairies event : (List<beneficiairies>)
							// resultdistinct)
		{
			row = spreadsheet.createRow(introw);
			XSSFCell cell = null;
			int j = 0;
			// position Colonne A
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getString("POSITIONCREW"));

			// Name Colonne B
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getString("NAME"));
			// first name Colonne C
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getString("FIRST_NAME"));
			// structure name vessel Colonne D
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getString("STRUCTURE_NAME"));
			// crew manning agency Colonne
			j++;
			// periode de couverture Colonne E
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getString("PERIOD_INSURANCE"));
			// Single Ou Family Colonne F
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getString("FAMILY_COVERED"));
			// Nationalité Colonne G
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getString("NATIONALITY"));
			// Pays Colonne H
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getString("COUNTRY"));
			// Nbre d'enfant Colonne I
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getDouble("CHILDREN"));
			// Debut de mouvement Colonne J
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getDate("START_MOVEMENT"));
			// Fin de mouvement Colonne K
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getDate("END_MOVEMENT"));
			// Salaire_Currency Colonne L
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getString("SALARY_CURRENCY"));

			// Nbre de mois Colonne O
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getFloat("MOIS"));

			// Salaire Mensuel Colonne M
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getFloat("MONTHLY_SALARY"));

			// nbre de jour Colonne N
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getFloat("JOUR"));

			// TO_INVOICE Colonne P
			j++;
			cell = (XSSFCell) row.createCell(j);
			cell.setCellValue(rs.getFloat("TO_INVOICE"));

			for (int i = 1; i <= 8; i++) {
				modul = getBenefits(lasession, rs.getString("COMPANY" + i), rs.getString("FORMULE" + i),
						rs.getString("formule_name" + i), rs.getString("FAMILY_COVERED"));
				if (modul != null) {
					result = readformula(modul.getCalculmode(), 1);
					setFormula(introw, result, newworkbook, row, i, modul);
				}
			}

			introw++;
		}
		stmt.close();

		FileOutputStream out;

		try {
			out = new FileOutputStream(new File(filepath));
			newworkbook.write(out);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("DONE ! setBeneficiaire");

		// lasession.close();

	}

	
	public List readformula() {

		ObjectDao myobj = new ObjectDao();
		Session lasession = myobj.getSessionDao();
		// now lets pull events from the database and list them
		lasession.beginTransaction();
		List resultdistinct = lasession.createQuery("select distinct cellrow from Wycccell").list();
		lasession.getTransaction().commit();
		// lasession.close();
		for (int introw : (List<Integer>) resultdistinct) {
			logger.info("Lecture des données de la lignes : " + (introw + 1));

		}
		lasession.close();

		lasession = myobj.getSessionDao();
		int introw = (int) resultdistinct.get(1);
		// for (int introw : (List<Integer>) resultdistinct){
		lasession.beginTransaction();
		Query query = lasession.createQuery("from Wycccell where cellrow = :introw");
		query.setParameter("introw", introw);

		List result = query.list();
		lasession.getTransaction().commit();

		lasession.close();

		return result;
		// }
	}

	public List readformula(String param, int rowtoread) {

		ObjectDao myobj = new ObjectDao();
		Session lasession = myobj.getSessionDao();
		// now lets pull events from the database and list them
		// PROPER(FORMULECELL,col)
		lasession.beginTransaction();
		Query query = lasession.createQuery(
				"select distinct cellrow from Wycccell where calculmode = :calculmode order by cellrow asc");
		query.setString("calculmode", param);
		List resultdistinct = query.list();
		lasession.getTransaction().commit();
		// lasession.close();
		for (int introw : (List<Integer>) resultdistinct) {
			logger.info("Lecture des données de la lignes : " + (introw + 1));

		}
		lasession.close();

		lasession = myobj.getSessionDao();
		int introw = (int) resultdistinct.get(rowtoread);
		// for (int introw : (List<Integer>) resultdistinct){
		lasession.beginTransaction();
		query = lasession.createQuery("from Wycccell where cellrow = :introw");
		query.setParameter("introw", introw);

		List result = query.list();
		lasession.getTransaction().commit();

		lasession.close();

		return result;
		// }
	}

	public int getRowCount(XSSFWorkbook workbook, String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			XSSFSheet sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}
	}

	public int getRowCount(XSSFWorkbook workbook, int sheetNumber) {
		String sheetName = workbook.getSheetName(sheetNumber);

		if (sheetNumber == -1)
			return 0;
		else {
			XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}
	}

	public void readData(XSSFWorkbook workbook, int sheetNumber, int fromRow, Session lasession)
			throws SQLException, IOException {
		// on recupére la ligne

		XSSFRow currentRow = workbook.getSheetAt(sheetNumber).getRow(fromRow);
		int lastCell = workbook.getSheetAt(sheetNumber).getRow(fromRow).getLastCellNum();
		// on détermine la derniére cellule
		// pour chaque ligne on boucle sur les cellules jusque qu'a la derniére
		// colonne
		// on lit la cellule
		Row row = workbook.getSheetAt(sheetNumber).getRow(fromRow);
		int firstcell = row.getFirstCellNum();

		for (int j = firstcell; j < lastCell; j++) {
			String cellText = null;
			String cellformule = null;
			int celltype;
			Cell cell = row.getCell(j);

			if (cell != null) {
				celltype = cell.getCellType();
				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					logger.info("Row : " + fromRow + " Column : " + j + " value : " + cell.getStringCellValue());
					cellText = cell.getStringCellValue();
				} else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
					cellformule = cell.getCellFormula();
				}

				else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

					cellText = String.valueOf(cell.getNumericCellValue());
					if (HSSFDateUtil.isCellDateFormatted(cell)) {
						// format in form of M/D/YY
						double d = cell.getNumericCellValue();

						Calendar cal = Calendar.getInstance();
						cal.setTime(HSSFDateUtil.getJavaDate(d));
						cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
						cellText = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;

						// System.out.println(cellText);

					}

					logger.info(cellText);
				} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
					logger.info("nothing");
				else
					logger.info(String.valueOf(cell.getBooleanCellValue()));

				Wycccell wycccell = StylCellDao(cell, cellText, cellformule, celltype);

				File directory = new File(".");
				String fileCharSep = System.getProperty("file.separator");

				h2db db = new h2db();
				db.getDatabase(directory);
				String sqlstmt1 = "INSERT INTO PUBLIC.SETTINGSCELL (";
				sqlstmt1 = sqlstmt1 + " CELL_ID,";
				sqlstmt1 = sqlstmt1 + " BAXKGROUNDCOLOR,";
				sqlstmt1 = sqlstmt1 + " BODERBOTTOM,";
				sqlstmt1 = sqlstmt1 + " BODERCOLORBOTTEM,";
				sqlstmt1 = sqlstmt1 + " BORDERCOLORIGHT,";
				sqlstmt1 = sqlstmt1 + " BORDERCOLORRIGHT,";
				sqlstmt1 = sqlstmt1 + " BORDERCOLORTOP,";
				sqlstmt1 = sqlstmt1 + " BORDERRIGHT,";
				sqlstmt1 = sqlstmt1 + " BORDERTOP,";
				sqlstmt1 = sqlstmt1 + " BORDERLEFT,";
				sqlstmt1 = sqlstmt1 + " CELLCOLUMN,";
				sqlstmt1 = sqlstmt1 + " CELLROW,";
				sqlstmt1 = sqlstmt1 + " DATAFORMAT,";
				sqlstmt1 = sqlstmt1 + " DATAFORMATSTRING,";
				sqlstmt1 = sqlstmt1 + " FONTINDEX,";
				sqlstmt1 = sqlstmt1 + " FORMULECELL,";
				sqlstmt1 = sqlstmt1 + " HALIGNEMENT,";
				sqlstmt1 = sqlstmt1 + " INDENTION,";
				sqlstmt1 = sqlstmt1 + " PATTERN,";
				sqlstmt1 = sqlstmt1 + " SHEETNUM,";
				sqlstmt1 = sqlstmt1 + " VALEURCELL,";
				sqlstmt1 = sqlstmt1 + " VALIGNEMENT,";
				sqlstmt1 = sqlstmt1 + " TYPECELL,";
				sqlstmt1 = sqlstmt1 + " FRONTGROUNDCOLOR,";
				sqlstmt1 = sqlstmt1 + " CALCULMODE)";
				sqlstmt1 = sqlstmt1 + " VALUES (";
				sqlstmt1 = sqlstmt1 + " NULL,";
				sqlstmt1 = sqlstmt1 + " " + cell.getCellStyle().getFillBackgroundColor() + ",";
				sqlstmt1 = sqlstmt1 + " " + cell.getCellStyle().getBorderBottom() + ",";
				sqlstmt1 = sqlstmt1 + " " + cell.getCellStyle().getBottomBorderColor() + ",";
				sqlstmt1 = sqlstmt1 + " " + cell.getCellStyle().getBorderRight() + ",";
				sqlstmt1 = sqlstmt1 + " " + cell.getCellStyle().getRightBorderColor() + ",";
				sqlstmt1 = sqlstmt1 + " " + cell.getCellStyle().getTopBorderColor() + ",";
				sqlstmt1 = sqlstmt1 + " " + cell.getCellStyle().getBorderRight() + ",";
				sqlstmt1 = sqlstmt1 + " " + cell.getCellStyle().getBorderTop() + ",";
				sqlstmt1 = sqlstmt1 + " " + cell.getCellStyle().getBorderLeft() + ",";
				sqlstmt1 = sqlstmt1 + " " + cell.getColumnIndex() + ",";
				if (cell.getRowIndex() < 10) {
					sqlstmt1 = sqlstmt1 + " " + cell.getRowIndex() + ",";
				} else {
					sqlstmt1 = sqlstmt1 + " " + (cell.getRowIndex() - 7) + ",";
				}
				sqlstmt1 = sqlstmt1 + " " + cell.getCellStyle().getDataFormat() + ",";
				sqlstmt1 = sqlstmt1 + " '" + cell.getCellStyle().getDataFormatString() + "',";
				sqlstmt1 = sqlstmt1 + " " + cell.getCellStyle().getFontIndex() + ",";
				if (cellformule == null) {
					sqlstmt1 = sqlstmt1 + " null ,";
				} else {
					sqlstmt1 = sqlstmt1 + " '" + cellformule + "',";
				}
				sqlstmt1 = sqlstmt1 + " " + cell.getCellStyle().getAlignment() + ",";
				sqlstmt1 = sqlstmt1 + " " + cell.getCellStyle().getIndention() + ",";
				sqlstmt1 = sqlstmt1 + " " + cell.getCellStyle().getFillPattern() + ",";
				sqlstmt1 = sqlstmt1 + " " + cell.getCellStyle().getIndex() + ",";
				if (cellText == null) {
					sqlstmt1 = sqlstmt1 + " null ,";
				} else {
					sqlstmt1 = sqlstmt1 + " '" + cellText + "',";
				}
				sqlstmt1 = sqlstmt1 + " " + cell.getCellStyle().getVerticalAlignment() + ",";
				sqlstmt1 = sqlstmt1 + " " + celltype + ",";
				sqlstmt1 = sqlstmt1 + " " + cell.getCellStyle().getFillForegroundColor() + ",";
				if (cell.getRowIndex() < 10) {
					sqlstmt1 = sqlstmt1 + "'MONTHLY'";
				} else {
					sqlstmt1 = sqlstmt1 + "'DAILY'";
				}
				sqlstmt1 = sqlstmt1 + ") ;";

				Statement stmt = db.connectiondb.createStatement();
				stmt.executeUpdate(sqlstmt1);
				stmt.close();

			}
		}

	}

	public Wycccell StylCellDao(Cell thecell, String cellText, String cellformule, int celltype) {

		int sheetnum = 0;

		return new Wycccell(

				thecell.getRowIndex(), thecell.getColumnIndex(), sheetnum, thecell.getCellStyle().getAlignment(),
				thecell.getCellStyle().getVerticalAlignment(), thecell.getCellStyle().getBorderBottom(),
				thecell.getCellStyle().getBorderTop(), thecell.getCellStyle().getBorderLeft(),
				thecell.getCellStyle().getBorderRight(), thecell.getCellStyle().getDataFormat(),
				thecell.getCellStyle().getDataFormatString(), thecell.getCellStyle().getFillBackgroundColor(),
				thecell.getCellStyle().getFillForegroundColor(), thecell.getCellStyle().getFillPattern(),
				thecell.getCellStyle().getIndex(), thecell.getCellStyle().getIndention(),
				thecell.getCellStyle().getBottomBorderColor(), thecell.getCellStyle().getTopBorderColor(),
				thecell.getCellStyle().getRightBorderColor(), thecell.getCellStyle().getLeftBorderColor(), cellText,
				cellformule, celltype);

	}

	public void setFormula(int introw, List result, XSSFWorkbook newworkbook, XSSFRow row, int itera, Modul modul) {

		int offsetCol = 57;
		int nocol = 0;
		for (Wycccell event : (List<Wycccell>) result) {

			if (event.getCellcolumn() >= 17) {
				nocol = event.getCellcolumn() + (57 * (itera - 1));
				XSSFCell cell = (XSSFCell) row.createCell(nocol);
				XSSFCellStyle style1 = newworkbook.createCellStyle();

				style1.setBorderBottom((short) event.getBorderbottom());
				style1.setBorderTop((short) event.getBordertop());
				style1.setBorderLeft((short) event.getBorterleft());
				style1.setBorderRight((short) event.getBorderright());
				style1.setDataFormat((short) event.getDataformat());
				// style1.setDataFormatString ( event.getDataformatstring());
				style1.setBottomBorderColor((short) event.getBordercolorbottom());
				style1.setBottomBorderColor((short) event.getBordercolortop());
				style1.setRightBorderColor((short) event.getBordercolorright());
				style1.setLeftBorderColor((short) event.getBordercolorleft());

				style1.setAlignment((short) event.getHalignement());
				style1.setVerticalAlignment((short) event.getValignement());

				style1.setFillBackgroundColor(HSSFColor.YELLOW.index);// (short)
																		// event.getBaxkgroundcolor());
				// style1.setFillForegroundColor ((short)
				// event.getFrontgroundcolor());
				style1.setFillPattern(XSSFCellStyle.NO_FILL);// (short)
																// event.getPattern());
				// style1.setIndention((short) event.getIndention());

				if ((event.getFormulecell() != null)) {

					String laformule = event.getFormulecell();
					logger.info("Formule à parser : " + laformule);
					laformule = laformule.replace("5", "%d");
					laformule = laformule.replace("14", "%d");
					int therow = introw + 1;

					laformule = String.format(laformule, therow, therow, therow, therow, therow, therow, therow, therow,
							therow);
					Tools newformule = new Tools();
					String lanewformule = newformule.getNewNumColonne(laformule, "[$,A-Z]*", 26, 57 * (itera - 1));
					cell.setCellFormula(lanewformule);
				}

				String lavaleur = null;

				if ((event.getValeurcell() != null)) {

					if (nocol == (17 + (57 * (itera - 1)))) {
						lavaleur = modul.getModulcategory();
					} else if (nocol == (18 + (57 * (itera - 1)))) {
						lavaleur = modul.getModulfournisseur();
					} else if (nocol == (19 + (57 * (itera - 1)))) {
						lavaleur = modul.getModullabel();
					} else if (nocol == (23 + (57 * (itera - 1)))) {
						if (modul.getCalculmode().equals("MONTHLY")) {
							lavaleur = event.getValeurcell();
						} else if (modul.getCalculmode().equals("DAILY")) {
							lavaleur = modul.getModulprice();// valuecell;
							float myfloat = Float.parseFloat(lavaleur);
							cell.setCellValue(myfloat);
						}
					} else if (nocol == (24 + (57 * (itera - 1)))) {
						if (modul.getCalculmode().equals("MONTHLY")) {
							lavaleur = event.getValeurcell();
						} else if (modul.getCalculmode().equals("DAILY")) {
							float myfloat = modul.getForfaitpercentage() / 100;
							lavaleur = String.valueOf(myfloat);// valuecell;
							myfloat = Float.parseFloat(lavaleur);
							cell.setCellValue(myfloat);
						}
					} else if (nocol == (25 + (57 * (itera - 1)))) {
						if (modul.getCalculmode().equals("MONTHLY")) {
							lavaleur = event.getValeurcell();

						} else if (modul.getCalculmode().equals("DAILY")) {
							lavaleur = event.getValeurcell();
						}
					} else if (nocol == (26 + (57 * (itera - 1)))) {
						if (modul.getCalculmode().equals("MONTHLY")) {
							lavaleur = modul.getModulprice();// valuecell;
							float myfloat = Float.parseFloat(lavaleur);
							cell.setCellValue(myfloat);
						} else if (modul.getCalculmode().equals("DAILY")) {
							lavaleur = modul.getModulprice();// valuecell;
							float myfloat = Float.parseFloat(lavaleur);
							cell.setCellValue(myfloat);
						}
					}

					else {
						lavaleur = event.getValeurcell();
					}

					if (event.getTypecell() == Cell.CELL_TYPE_NUMERIC) {

						float myfloat = 0;
						try {
							myfloat = Float.parseFloat(lavaleur);

						} catch (Exception e) {
							// TODO Auto-generated catch block
							logger.info("valeur parsé en float " + lavaleur);
							logger.info("valeur colonne " + event.getCellcolumn());
							logger.info(e);
							e.printStackTrace();
						}

						cell.setCellValue(myfloat);
					} else if (event.getTypecell() == Cell.CELL_TYPE_STRING) {
						cell.setCellValue(lavaleur);
					}
					cell.setCellStyle(style1);
				}
			}
		}
	}

	public void setFormulaHeader(int introw, List result, XSSFWorkbook newworkbook, XSSFRow row, int myiterator,
			int start, int end, int myoffset) {

		for (Wycccell event : (List<Wycccell>) result.subList(start, end)) {

			XSSFCell cell = (XSSFCell) row.createCell(event.getCellcolumn() + (myoffset * (myiterator - 1)));
			XSSFCellStyle style1 = newworkbook.createCellStyle();

			style1.setBorderBottom((short) event.getBorderbottom());
			style1.setBorderTop((short) event.getBordertop());
			style1.setBorderLeft((short) event.getBorterleft());
			style1.setBorderRight((short) event.getBorderright());
			style1.setDataFormat((short) event.getDataformat());
			// style1.setDataFormatString ( event.getDataformatstring());
			style1.setBottomBorderColor((short) event.getBordercolorbottom());
			style1.setBottomBorderColor((short) event.getBordercolortop());
			style1.setRightBorderColor((short) event.getBordercolorright());
			style1.setLeftBorderColor((short) event.getBordercolorleft());

			style1.setAlignment((short) event.getHalignement());
			style1.setVerticalAlignment((short) event.getValignement());

			style1.setFillBackgroundColor(HSSFColor.YELLOW.index);// (short)
																	// event.getBaxkgroundcolor());
			// style1.setFillForegroundColor ((short)
			// event.getFrontgroundcolor());
			style1.setFillPattern(XSSFCellStyle.NO_FILL);// (short)
															// event.getPattern());
			// style1.setIndention((short) event.getIndention());

			String lavaleur = null;
			if ((event.getValeurcell() != null)) {

				lavaleur = event.getValeurcell();

				if (event.getTypecell() == Cell.CELL_TYPE_NUMERIC) {
					float myfloat = Float.parseFloat(lavaleur);
					cell.setCellValue(myfloat);
				} else if (event.getTypecell() == Cell.CELL_TYPE_STRING) {
					cell.setCellValue(lavaleur);
				}
			}
			cell.setCellStyle(style1);

		}

	}

	public Modul getBenefits(Session lasession, String modulFournisseur, String modulLabel, String modulCategory,
			String modulScope) {
		// Third benefits
		lasession.beginTransaction();
		Query query = lasession.createQuery(
				"from Modul where modulfournisseur=:modulfournisseur and modullabel = :modullabel and modulcategory= :modulcategory  and modulscope = :modulscope ");
		query.setString("modulfournisseur", modulFournisseur);
		query.setString("modullabel", modulLabel);
		query.setString("modulcategory", modulCategory);

		String modulscope = "";
		if (modulScope.equals("NO")) {
			modulscope = "Single";
		} else {
			modulscope = "Family";
		}
		// modulscope= "Single";
		query.setString("modulscope", modulscope);
		query.setMaxResults(1);
		Modul modul = (Modul) query.uniqueResult();
		lasession.getTransaction().commit();
		logger.info("modulfournisseur : " + modulFournisseur);
		logger.info("modullabel : " + modulLabel);
		logger.info("modulcategory : " + modulCategory);
		logger.info("modulscope : " + modulscope);
		return modul;
	}

}
