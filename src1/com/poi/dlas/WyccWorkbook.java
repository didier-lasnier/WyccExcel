package com.poi.dlas;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.logging.log4j.*;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.XmlException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.dlas.dao.H2db;

import com.dlas.dao.beneficiaries;
import com.dlas.tools.SetBeneficiaries;
import com.dlas.tools.Tools;
import com.dlas.dao.Wycccell;
import com.dlas.dao.LimitAggCsv;
import com.dlas.dao.Modul;
import com.dlas.dao.ModulBoat;

//import au.com.ozblog.hibernate.h2.example.User;

import com.dlas.dao.ObjectDao;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class WyccWorkbook extends JPanel {
	public XSSFWorkbook currentworkbook;
	public XSSFSheet currentSheet;

	private String xldformuleaggaregate = "";
	private int OffsetColumn = 57;
	private int StartColumnformule = 17;
	private int EndColumnFormule = 73;
	private int countbeneficiaire;
	private int currentbeneficiaire;
	private List<beneficiaries> resultdistinct;

	public List<beneficiaries> getResultdistinct() {
		return resultdistinct;
	}

	public void setResultdistinct(List<beneficiaries> resultdistinct) {
		this.resultdistinct = resultdistinct;
	}

	public WyccWorkbook() {

	}

	public XSSFWorkbook getCurrentworkbook() {
		return currentworkbook;
	}

	public void setCurrentworkbook(XSSFWorkbook currentworkbook) {
		this.currentworkbook = currentworkbook;
	}

	public XSSFSheet getCurrentSheet() {
		return currentSheet;
	}

	public void setCurrentSheet(XSSFSheet currentSheet) {
		this.currentSheet = currentSheet;
	}

	public String getXldformuleaggaregate() {
		return xldformuleaggaregate;
	}

	public void setXldformuleaggaregate(String xldformuleaggaregate) {
		this.xldformuleaggaregate = xldformuleaggaregate;
	}

	public int getOffsetColumn() {
		return OffsetColumn;
	}

	public void setOffsetColumn(int offsetColumn) {
		OffsetColumn = offsetColumn;
	}

	public int getStartColumnformule() {
		return StartColumnformule;
	}

	public void setStartColumnformule(int startColumnformule) {
		StartColumnformule = startColumnformule;
	}

	public int getEndColumnFormule() {
		return EndColumnFormule;
	}

	public void setEndColumnFormule(int endColumnFormule) {
		EndColumnFormule = endColumnFormule;
	}

	public int getCountbeneficiaire() {
		return countbeneficiaire;
	}

	public void setCountbeneficiaire(int countbeneficiaire) {
		this.countbeneficiaire = countbeneficiaire;
	}

	public int getCurrentbeneficiaire() {
		return currentbeneficiaire;
	}

	public void setCurrentbeneficiaire(int currentbeneficiaire) {
		this.currentbeneficiaire = currentbeneficiaire;
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

	public static Logger logger = LogManager.getLogger(WyccWorkbook.class);

	public void createWorkbook(File xlsfileWycc) throws IOException, InvalidFormatException {

		// Workbook wb=SetworkBook( new XSSFWorkbook());
		setSheet(setWorkBook(new XSSFWorkbook(xlsfileWycc)).createSheet("Total WYCC"));

		// Write the output to a file
		String filepath = xlsfileWycc.getCanonicalPath();
		// if(wb instanceof XSSFWorkbook) file += "x";
		logger.info(filepath);

		int rowCount = 0;

		FileOutputStream out = new FileOutputStream(filepath);
		this.getWorkBook().write(out);
		out.close();
		this.getWorkBook().close();
	}

	public void getWorkbook(File xlsfileWycc, String rootdir) throws IOException {
		try {
			// file is not open
			// FileOutputStream out = new
			// FileOutputStream(xlsfileWycc.getAbsolutePath() );
			File directory = new File(rootdir);
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

				H2db db = new H2db();
				db.getDatabase(directory);
				String sqlstmt1 = "DELETE FROM PUBLIC.SETTINGSCELL";

				Statement stmt = db.connectiondb.createStatement();
				stmt.executeUpdate(sqlstmt1);
				stmt.close();

				for (int i = firstrow; i <= 4; i++) {
					readData(this.currentworkbook, 0, i, lasession);
				}

				firstrow = 11;
				for (int i = firstrow; i <= 12; i++) {
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

	public static void setBeneficiairies(SetBeneficiaries setBenef)
			throws SQLException, IOException, NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InvalidFormatException {

		// setBenef.getWb().setCurrentbeneficiaire(setBenef.getWb().getCurrentbeneficiaire()+1);

		setBenef.getMonitor()
				.subTask("Processing beneficiaries " + setBenef.getRs().getFirstname() + " "
						+ setBenef.getRs().getName() + " : " + setBenef.getWb().getCurrentbeneficiaire() + " of "
						+ setBenef.getWb().getCountbeneficiaire() + "...");

		setBenef.setRow(setBenef.getSpreadsheet().createRow(setBenef.getIntrow()));

		SXSSFCell cell = null;
		int j = 0;
		// position Colonne A

		cell = setBenef.getRow().createCell(j);
		if (setBenef.getRs().getPositioncrew() != null) {
			cell.setCellValue(setBenef.getRs().getPositioncrew());
		}
		// Name Colonne B
		j++;
		cell = setBenef.getRow().createCell(j);
		if (setBenef.getRs().getName() != null) {
			cell.setCellValue(setBenef.getRs().getName());
		}
		// first name Colonne C
		j++;
		cell = setBenef.getRow().createCell(j);
		if (setBenef.getRs().getFirstname() != null) {
			cell.setCellValue(setBenef.getRs().getFirstname());
		}
		// structure name vessel Colonne D
		j++;
		cell = setBenef.getRow().createCell(j);
		String fstrutcurename = "";
		if (setBenef.getRs().getStructurename() != null) {
			fstrutcurename = setBenef.getRs().getStructurename();
			cell.setCellValue(setBenef.getRs().getStructurename());
		}
		// crew manning agency Colonne
		j++;
		// periode de couverture Colonne E
		j++;
		cell = setBenef.getRow().createCell(j);
		if (setBenef.getRs().getPeriodeinsurance() != null) {
			cell.setCellValue(setBenef.getRs().getPeriodeinsurance());
		}
		// Single Ou Family Colonne F
		j++;
		cell = setBenef.getRow().createCell(j);
		if (setBenef.getRs().getFamilycovered() != null) {
			cell.setCellValue(setBenef.getRs().getFamilycovered());
		}
		// Nationalité Colonne G
		j++;
		cell = setBenef.getRow().createCell(j);
		if (setBenef.getRs().getNationality() != null) {
			cell.setCellValue(setBenef.getRs().getNationality());
		}
		// Pays Colonne H
		j++;
		cell = setBenef.getRow().createCell(j);
		if (setBenef.getRs().getCountry() != null) {
			cell.setCellValue(setBenef.getRs().getCountry());
		}
		// Nbre d'enfant Colonne I
		j++;
		cell = setBenef.getRow().createCell(j);
		if (setBenef.getRs().getChildren() != null) {
			cell.setCellValue(setBenef.getRs().getChildren());
		}
		// Debut de mouvement Colonne J
		j++;
		cell = setBenef.getRow().createCell(j);
		CellStyle cellStyle;
		if (setBenef.getRs().getStartmovement() != null) {
			cell.setCellValue(setBenef.getRs().getStartmovement());
		}
		cellStyle = setBenef.getNewworkbook().createCellStyle();
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
		cell.setCellStyle(cellStyle);

		// Fin de mouvement Colonne K
		j++;
		cell = setBenef.getRow().createCell(j);
		if (setBenef.getRs().getEndmovement() != null) {
			cell.setCellValue(setBenef.getRs().getEndmovement());
		}
		cell.setCellStyle(cellStyle);
		// Salaire_Currency Colonne L
		j++;
		cell = setBenef.getRow().createCell(j);
		if (setBenef.getRs().getSalarycurrency() != null) {
			cell.setCellValue(setBenef.getRs().getSalarycurrency());
		}
		// Nbre de mois Colonne M
		j++;
		cell = setBenef.getRow().createCell(j);
		if (setBenef.getRs().getMois() != null) {
			cell.setCellValue(setBenef.getRs().getMois());
		}

		// Salaire Mensuel Colonne N
		j++;
		cell = setBenef.getRow().createCell(j);

		if (setBenef.getRs().getMonthlysalary() != null) {
			cell.setCellValue(setBenef.getRs().getMonthlysalary());
		}
		// nbre de jour Colonne O
		j++;
		cell = setBenef.getRow().createCell(j);
		if (setBenef.getRs().getJour() != null) {
			cell.setCellValue(setBenef.getRs().getJour());
		}
		// TO_INVOICE Colonne P
		j++;
		cell = setBenef.getRow().createCell(j);
		if (setBenef.getRs().getToinvoice() != null) {
			cell.setCellValue(setBenef.getRs().getToinvoice());
		}
		setBenef.getWb().setXldformuleaggaregate("");

		setBenef.setCompteur(1);
		// On traite les modules. on repete les cellules de formule pour le
		// nombre de module possible.
		for (int i = 1; i <= setBenef.getNbmodule(); i++) {

			Boolean proceed = false;

			// on recupére certaine information du module en fonction des infos
			// du nom de la company, du nom du module, du nom de la formule et
			// de la couverure familliale

			Method fieldGetter = null;

			try {
				fieldGetter = setBenef.getRs().getClass().getMethod("getCompany" + i);
			} catch (NoSuchMethodException | SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String fCompany = "";
			try {
				if (fieldGetter.invoke(setBenef.getRs()) != null) {
					fCompany = fieldGetter.invoke(setBenef.getRs()).toString();
				}
			} catch (IllegalAccessException | IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {

				fieldGetter = setBenef.getRs().getClass().getMethod("getFormule" + i);
			} catch (NoSuchMethodException | SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String fFormule = "";
			try {

				if (fieldGetter.invoke(setBenef.getRs()) != null) {
					fFormule = fieldGetter.invoke(setBenef.getRs()).toString();
				}

			} catch (IllegalAccessException | IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				fieldGetter = setBenef.getRs().getClass().getMethod("getFormulename" + i);
			} catch (NoSuchMethodException | SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String fFormulename = "";
			try {
				if (fieldGetter.invoke(setBenef.getRs()) != null) {
					fFormulename = fieldGetter.invoke(setBenef.getRs()).toString();
				}
			} catch (IllegalAccessException | IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				fieldGetter = setBenef.getRs().getClass().getMethod("getPolicenumber" + i);
			} catch (NoSuchMethodException | SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String fpolicenumber = "";
			try {
				if (fieldGetter.invoke(setBenef.getRs()) != null) {
					fpolicenumber = fieldGetter.invoke(setBenef.getRs()).toString();
				}
			} catch (IllegalAccessException | IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String fFamilycovered = setBenef.getRs().getFamilycovered();

			setBenef.setModul(setBenef.getWb().getBenefits(setBenef.getLasession(), fCompany, fFormule, fFormulename,
					fFamilycovered));

			setBenef.setModulboat(setBenef.getWb().getboatBenefits(setBenef.getLasession(), fCompany, fFormule,
					fFormulename, fstrutcurename));

			Float Amount;
			try {
				if (setBenef.getModul() != null) {
					// en fonction du mode de calcul on recupére la valeur de
					Amount = setBenef.getModul().getModulprice();// Float.parseFloat(modul.getModulprice());
				} else {
					Amount = 0f;
				}

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				Amount = 0f;
			}
			// il faut recupérer les aggregate.
			// si la valeur est différente de zéro on prend la valeur saisie
			// sion on prend la valeur calculée.
			String aggregate = setBenef.getWb().readaggregate(setBenef.getLasession(), fCompany, fFormule, fFormulename,
					fpolicenumber);

			if (setBenef.getModul() != null) {
				if (setBenef.getSpreadsheet().getSheetName().equals("Total WYCC")) {
					proceed = true;
				}

				else if (setBenef.getSpreadsheet().getSheetName().equals(fCompany)) {
					proceed = true;
				} else {
					proceed = false;
				}

				if (proceed) {

					Session mysession = setBenef.getLasession();
					ModulBoat mymodulboat = setBenef.getModulboat();
					if (mymodulboat != null) {
						String mycaclulmode = mymodulboat.getCalculmode();
						setBenef.setResult(setBenef.getWb().readformula(mysession, mycaclulmode, 1));
					}

					setBenef.getWb().setFormula(setBenef.getIntrow(), setBenef.getResult(), setBenef.getNewworkbook(),
							setBenef.getRow(), setBenef.getCompteur(), setBenef.getModulboat(), aggregate);

					setBenef.setCompteur(setBenef.getCompteur() + 1);

				}

			}

		}

		setBenef.getMonitor().worked(1);

		j = (setBenef.getWb().getStartColumnformule() + (setBenef.getWb().getOffsetColumn() * setBenef.getNbmodule()));
		cell = setBenef.getRow().createCell(j);

		int stringlength = setBenef.getWb().getXldformuleaggaregate().length();
		if (stringlength > 0) {
			String form = setBenef.getWb().getXldformuleaggaregate().substring(0, stringlength - 1);
			setBenef.getWb().setXldformuleaggaregate(setBenef.getWb().getXldformuleaggaregate().substring(0,
					setBenef.getWb().getXldformuleaggaregate().length() - 1));
		}
		// xldformuleaggaregate=xldformuleaggaregate.substring(0,
		// xldformuleaggaregate.length()-1);
		logger.info(setBenef.getWb().getXldformuleaggaregate());
		cell.setCellFormula(setBenef.getWb().getXldformuleaggaregate());
		setBenef.setLastcellule(cell);
		if (setBenef.getIntrow() == 4) {
			setBenef.setFirstcellul(cell);
			setBenef.setAddressfirstcell("" + setBenef.getFirstcellul().getAddress());

		}

		// Check if the user pressed "cancel"
		if (setBenef.getMonitor().isCanceled()) {
			setBenef.getMonitor().done();
			return;
		}

		// setBenef.setIntrow(setBenef.getIntrow() +1);
	}

	public List<beneficiaries> getBeneficiaries() {
		ObjectDao myobj = new ObjectDao();
		Session lasession = myobj.getSessionDao();
		lasession.beginTransaction();
		Query query = lasession.createQuery("from beneficiaries");
		List<beneficiaries> resultdistinct = query.list();
		lasession.getTransaction().commit();
		return resultdistinct;
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

	public static List readformula(Session lasession, String param, int rowtoread) {

		// ObjectDao myobj = new ObjectDao();
		// Session lasession = myobj.getSessionDao();
		// now lets pull events from the database and list them
		// PROPER(FORMULECELL,col)
		lasession.beginTransaction();
		Query query = lasession.createQuery(
				"select distinct cellrow from Wycccell where calculmode = :calculmode order by cellrow asc");
		query.setString("calculmode", param);
		List resultdistinct = query.list();
		lasession.getTransaction().commit();
		// lasession.close();
		// for (int introw : (List<Integer>) resultdistinct) {
		// logger.info("Lecture des données de la lignes : " + (introw + 1));
		//
		// }

		// lasession = myobj.getSessionDao();
		int introw = (int) resultdistinct.get(rowtoread);
		// for (int introw : (List<Integer>) resultdistinct){
		lasession.beginTransaction();
		query = lasession.createQuery(
				"from Wycccell where cellrow = :introw and calculmode = :calculmode order by cellcolumn asc");
		query.setParameter("introw", introw);
		query.setString("calculmode", param);
		List result = query.list();
		lasession.getTransaction().commit();

		// lasession.close();

		return result;
		// }
	}

	public String readaggregate(Session lasession, String company, String formuma, String formulenumber,
			String policynumber) {

		List resultdistinct;
		String ValueReturn;
		try {
			// ObjectDao myobj = new ObjectDao();
			// lasession = myobj.getSessionDao();
			lasession.beginTransaction();
			Query query = lasession.createQuery(
					"select amount from BenefitDb where company = :company and formula=:formula and formulename=:formulename and policynumber=:policynumber order by aggregateid asc");
			query.setString("company", company);
			query.setString("formula", formuma);
			query.setString("formulename", formulenumber);
			query.setString("policynumber", policynumber);
			resultdistinct = query.list();
			lasession.getTransaction().commit();
			// lasession.close();
			ValueReturn = (String) resultdistinct.get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ValueReturn = "0";
		}

		return ValueReturn;
		// }
	}

	public String getAggregate(String company, String formuma, String formulenumber, String policynumber,Session lasession) {

		List resultdistinct;
		String ValueReturn;
		try {
			Query query = lasession.createQuery(
					"select amount from BenefitDb where company = :company and formula=:formula and formulename=:formulename and policynumber=:policynumber order by aggregateid asc");
			query.setString("company", company);
			query.setString("formula", formuma);
			query.setString("formulename", formulenumber);
			query.setString("policynumber", policynumber);
			resultdistinct = query.list();
			
			ValueReturn = (String) resultdistinct.get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ValueReturn = "0";
		}

		return ValueReturn;
		// }
	}

	public Session CreateDataSession ( ){
		
		ObjectDao myobj = new ObjectDao();
		Session lasession = myobj.getSessionDao();
		lasession.beginTransaction();
		return lasession;
	}
	
	public void closedataSession (Session lasession){
		lasession.getTransaction().commit();
		lasession.close();
	}
	
	public void closedataSessionwithcommit (Session lasession){
		lasession.close();
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

		XSSFRow row = workbook.getSheetAt(sheetNumber).getRow(fromRow);
		int lastCell = row.getLastCellNum();
		// on détermine la derniére cellule
		// pour chaque ligne on boucle sur les cellules jusque qu'a la derniére
		// colonne
		// on lit la cellule
		// Row row = workbook.getSheetAt(sheetNumber).getRow(fromRow);

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
					if (DateUtil.isCellDateFormatted(cell)) {
						// format in form of M/D/YY
						double d = cell.getNumericCellValue();

						Calendar cal = Calendar.getInstance();
						cal.setTime(DateUtil.getJavaDate(d));
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

				H2db db = new H2db();
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

	public void setFormula(int introw, List result, SXSSFWorkbook newworkbook, SXSSFRow row, int itera, Modul modul,
			String aggregate) {

		// offset de décalage lorsque un moule a été traité
		int offsetCol = OffsetColumn;
		// numéro de colonne à traiter.
		int nocol = 0;

		for (Wycccell event : (List<Wycccell>) result) {

			if (event.getCellcolumn() >= StartColumnformule && event.getCellcolumn() <= EndColumnFormule) {

				Float Amount;
				try {
					if (modul != null) {
						Amount = modul.getModulprice();// Float.parseFloat(modul.getModulprice());
					} else {
						Amount = 0f;
					}

				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					Amount = 0f;
				}

				nocol = event.getCellcolumn() + (OffsetColumn * (itera - 1));
				SXSSFCell cell = row.createCell(nocol);
				if (nocol == EndColumnFormule + (OffsetColumn * (itera - 1))) {

					String formuleagg = "";
					// modul.getForfaitpercentage();
					// on recupére le pourcentage et la valeur de l'aggregate
					if (modul.getForfaitpercentage() == 1) {
						formuleagg = cell.getAddress().toString();
					} else {

						formuleagg = "(if(" + cell.getAddress().toString() + ">(" + aggregate + "/12)," + aggregate
								+ "/12," + cell.getAddress().toString() + ")*" + Amount.toString() + ")";
					}

					logger.info("Iteration : " + itera + " - Num col : " + nocol + " - Total : " + xldformuleaggaregate
							+ " - ajout : " + formuleagg);
					xldformuleaggaregate = xldformuleaggaregate + formuleagg + "+";

				}
				CellStyle style1 = newworkbook.createCellStyle();

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
				style1.setFillPattern(CellStyle.NO_FILL);// (short)
															// event.getPattern());
				// style1.setIndention((short) event.getIndention());

				if ((event.getFormulecell() != null)) {

					String laformule = event.getFormulecell();
					// logger.info("Formule à parser : " + laformule);
					laformule = getFormuleRegex(laformule, "([$A-Z]+)([$0-9]+)", "([$0-9]+)");
					// logger.info("Formule parsée : " + laformule);
					// laformule = laformule.replace("5", "%d");
					// laformule = laformule.replace("14", "%d");
					int therow = introw;// + 1;

					laformule = String.format(laformule, therow, therow, therow, therow, therow, therow, therow, therow,
							therow);
					Tools newformule = new Tools();
					String lanewformule = Tools.getNewNumColonne(laformule, "[$A-Z]*", 26, OffsetColumn * (itera - 1));
					cell.setCellFormula(lanewformule);
				}

				String lavaleur = null;

				if ((event.getValeurcell() != null)) {

					if (nocol == (StartColumnformule + (OffsetColumn * (itera - 1)))) {
						lavaleur = modul.getModulcategory();
					} else if (nocol == (StartColumnformule + 1 + (OffsetColumn * (itera - 1)))) {
						lavaleur = modul.getModulfournisseur();
					} else if (nocol == (StartColumnformule + 2 + (OffsetColumn * (itera - 1)))) {
						lavaleur = modul.getModullabel();
					} else if (nocol == (StartColumnformule + 6 + (OffsetColumn * (itera - 1)))) {
						if (modul.getCalculmode().equals("MONTHLY")) {
							lavaleur = event.getValeurcell();
						} else if (modul.getCalculmode().equals("DAILY")) {
							lavaleur = modul.getModulprice().toString();// valuecell;
							float myfloat = Float.parseFloat(lavaleur);
							cell.setCellValue(myfloat);
						}
					} else if (nocol == (StartColumnformule + 7 + (OffsetColumn * (itera - 1)))) {
						if (modul.getCalculmode().equals("MONTHLY")) {
							lavaleur = event.getValeurcell();
						} else if (modul.getCalculmode().equals("DAILY")) {
							float myfloat = modul.getForfaitpercentage() / 100;
							lavaleur = String.valueOf(myfloat);// valuecell;
							myfloat = Float.parseFloat(lavaleur);
							cell.setCellValue(myfloat);
						}
					} else if (nocol == (StartColumnformule + 8 + (OffsetColumn * (itera - 1)))) {
						if (modul.getCalculmode().equals("MONTHLY")) {
							lavaleur = event.getValeurcell();

						} else if (modul.getCalculmode().equals("DAILY")) {
							lavaleur = event.getValeurcell();
						}
					} else if (nocol == (StartColumnformule + 9 + (OffsetColumn * (itera - 1)))) {
						if (modul.getCalculmode().equals("MONTHLY")) {
							lavaleur = modul.getModulprice().toString();// valuecell;
							float myfloat = Float.parseFloat(lavaleur);
							cell.setCellValue(myfloat);
						} else if (modul.getCalculmode().equals("DAILY")) {
							lavaleur = modul.getModulprice().toString();// valuecell;
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

			} // fin du if

		}

	}

	// méthode avec appel Modulboat

	public void setFormula(int introw, List result, SXSSFWorkbook newworkbook, SXSSFRow row, int itera, ModulBoat modul,
			String aggregate) {

		// offset de décalage lorsque un moule a été traité
		int offsetCol = OffsetColumn;
		// numéro de colonne à traiter.
		int nocol = 0;

		if (modul != null) {
			for (Wycccell event : (List<Wycccell>) result) {

				if (event.getCellcolumn() >= StartColumnformule && event.getCellcolumn() <= EndColumnFormule) {

					Float Amount;
					try {
						if (modul != null) {
							Amount = modul.getModulpricesingle();// Float.parseFloat(modul.getModulprice());
						} else {
							Amount = 0f;
						}

					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
						Amount = 0f;
					}

					nocol = event.getCellcolumn() + (OffsetColumn * (itera - 1));
					SXSSFCell cell = row.createCell(nocol);
					if (nocol == EndColumnFormule + (OffsetColumn * (itera - 1))) {

						String formuleagg = "";
						// modul.getForfaitpercentage();
						// on recupére le pourcentage et la valeur de l'aggregate
						
						if (modul.getForfaitpercentage() == 1) {
							formuleagg = cell.getAddress().toString();
						} else {
							Float aggregateamount = modul.getAggregateamount();
							if (aggregateamount!=null) {
								formuleagg = "(if(" + cell.getAddress().toString() + ">(" + aggregateamount + "/12)," + aggregateamount
										+ "/12," + cell.getAddress().toString() + ")*" + Amount.toString() + ")";
							}
							else {
								formuleagg =cell.getAddress().toString() + "*"+ Amount.toString() ;
							}
						}

						logger.info("Iteration : " + itera + " - Num col : " + nocol + " - Total : "
								+ xldformuleaggaregate + " - ajout : " + formuleagg);
						xldformuleaggaregate = xldformuleaggaregate + formuleagg + "+";

					}
					CellStyle style1 = newworkbook.createCellStyle();

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
					style1.setFillPattern(CellStyle.NO_FILL);// (short)
																// event.getPattern());
																// style1.setIndention((short) event.getIndention());

					if ((event.getFormulecell() != null)) {

						String laformule = event.getFormulecell();
						// logger.info("Formule à parser : " + laformule);
						laformule = getFormuleRegex(laformule, "([$A-Z]+)([$0-9]+)", "([$0-9]+)");
						// logger.info("Formule parsée : " + laformule);
						// laformule = laformule.replace("5", "%d");
						// laformule = laformule.replace("14", "%d");
						int therow = introw + 1;

						laformule = String.format(laformule, therow, therow, therow, therow, therow, therow, therow,
								therow, therow);
						Tools newformule = new Tools();
						String lanewformule = Tools.getNewNumColonne(laformule, "[$A-Z]*", 26,
								OffsetColumn * (itera - 1));
						cell.setCellFormula(lanewformule);
					}

					String lavaleur = null;

					if ((event.getValeurcell() != null)) {

						if (nocol == (StartColumnformule + (OffsetColumn * (itera - 1)))) {
							lavaleur = modul.getModulecategory();
						} else if (nocol == (StartColumnformule + 1 + (OffsetColumn * (itera - 1)))) {
							lavaleur = modul.getModul_fournisseur();
						} else if (nocol == (StartColumnformule + 2 + (OffsetColumn * (itera - 1)))) {
							lavaleur = modul.getModullabel();
						} else if (nocol == (StartColumnformule + 6 + (OffsetColumn * (itera - 1)))) {
							if (modul.getCalculmode().equals("MONTHLY")) {
								lavaleur = event.getValeurcell();
							} else if (modul.getCalculmode().equals("DAILY")) {
								lavaleur = modul.getModulpricesingle().toString();// valuecell;
								float myfloat = Float.parseFloat(lavaleur);
								cell.setCellValue(myfloat);
							}
						} else if (nocol == (StartColumnformule + 7 + (OffsetColumn * (itera - 1)))) {
							if (modul.getCalculmode().equals("MONTHLY")) {
								lavaleur = event.getValeurcell();
							} else if (modul.getCalculmode().equals("DAILY")) {
								Double myfloat = modul.getForfaitpercentage() / 100;
								lavaleur = String.valueOf(myfloat);// valuecell;
								myfloat = Double.parseDouble(lavaleur);
								cell.setCellValue(myfloat);
							}
						} else if (nocol == (StartColumnformule + 8 + (OffsetColumn * (itera - 1)))) {
							if (modul.getCalculmode().equals("MONTHLY")) {
								lavaleur = event.getValeurcell();

							} else if (modul.getCalculmode().equals("DAILY")) {
								lavaleur = event.getValeurcell();
							}
						} else if (nocol == (StartColumnformule + 9 + (OffsetColumn * (itera - 1)))) {
							if (modul.getCalculmode().equals("MONTHLY")) {
								lavaleur = modul.getModulpricesingle().toString();// valuecell;
								float myfloat = Float.parseFloat(lavaleur);
								cell.setCellValue(myfloat);
							} else if (modul.getCalculmode().equals("DAILY")) {
								lavaleur = modul.getModulpricesingle().toString();// valuecell;
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

				} // fin du if

			} // fin du for
		}

	}

	public void setFormulaHeader(int introw, List result, SXSSFWorkbook newworkbook, SXSSFRow row, int myiterator,
			int start, int end, int myoffset) {
		row.setHeight((short) 700);
		Boolean goon = false;
		for (Wycccell event : (List<Wycccell>) result.subList(start, end)) {

			SXSSFCell cell = row.createCell(event.getCellcolumn() + (myoffset * (myiterator - 1)));
			CellStyle style1 = newworkbook.createCellStyle();
			if (end <= 17) {
				style1.setFillForegroundColor(IndexedColors.AQUA.getIndex());
				style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			} else if (event.getCellcolumn() >= 18 && event.getCellcolumn() <= 25) {
				style1.setFillForegroundColor(IndexedColors.GREEN.getIndex());
				style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			}

			else if (event.getCellcolumn() >= 26 && event.getCellcolumn() <= 49) {
				style1.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
				style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			} else if (event.getCellcolumn() >= 50 && event.getCellcolumn() <= 73) {
				style1.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
				style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			}
			/*
			 * 
			 * style1.setBorderBottom((short) event.getBorderbottom());
			 * style1.setBorderTop((short) event.getBordertop());
			 * style1.setBorderLeft((short) event.getBorterleft());
			 * style1.setBorderRight((short) event.getBorderright());
			 * style1.setDataFormat((short) event.getDataformat()); //
			 * style1.setDataFormatString ( event.getDataformatstring());
			 * style1.setBottomBorderColor((short)
			 * event.getBordercolorbottom());
			 * style1.setBottomBorderColor((short) event.getBordercolortop());
			 * style1.setRightBorderColor((short) event.getBordercolorright());
			 * style1.setLeftBorderColor((short) event.getBordercolorleft());
			 * 
			 * style1.setAlignment((short) event.getHalignement());
			 * style1.setVerticalAlignment((short) event.getValignement());
			 * 
			 * style1.setFillBackgroundColor(HSSFColor.YELLOW.index);// (short)
			 * // event.getBaxkgroundcolor()); // style1.setFillForegroundColor
			 * ((short) // event.getFrontgroundcolor());
			 * style1.setFillPattern(XSSFCellStyle.NO_FILL);// (short) //
			 * event.getPattern()); // style1.setIndention((short)
			 * event.getIndention());
			 */

			String lavaleur = null;
			logger.info("Header Intervale [" + start + " - " + end + "] Colonne :" + event.getCellcolumn());
			if (event.getCellcolumn() >= start && event.getCellcolumn() <= end) {
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

		return modul;
	}

	public ModulBoat getboatBenefits(Session lasession, String modulFournisseur, String modulLabel,
			String modulCategory, String modulboat) {
		// Third benefits
		lasession.beginTransaction();
		Query query = lasession.createQuery(
				"from ModulBoat where modul_fournisseur=:modul_fournisseur and modullabel = :modullabel and modulecategory= :modulcategory  and modulboat = :modulboat ");
		query.setString("modul_fournisseur", modulFournisseur);
		query.setString("modullabel", modulLabel);
		query.setString("modulcategory", modulCategory);
		// modulscope= "Single";
		query.setString("modulboat", modulboat);
		query.setMaxResults(1);
		ModulBoat modul = (ModulBoat) query.uniqueResult();
		lasession.getTransaction().commit();

		return modul;
	}

	public String getFormuleRegex(String inFormule, String paternregex, String subpaternregex) {

		Pattern p = Pattern.compile(paternregex); // ("([$A-Z]+)([$0-9]+)") ;
		String s = inFormule;// "=(SI(BV26>(2011/12);2011/12;BV26)*0)+(SI(BV26>(2011/12);2011/12;BV26)*0)+(SI(EA26>(2012/12);2012/12;EA26)*0)+(SI(EA26>(2012/12);2012/12;EA26)*0)+(SI(GF26>(2003/12);2003/12;GF26)*0,501)+(SI(IK26>(2004/12);2004/12;IK26)*0,1253)+(SI(KP26>(2005/12);2005/12;KP26)*0,0619)+(SI(MU26>(2006/12);2006/12;MU26)*0,2108)+(SI(OZ26>(2007/12);2007/12;OZ26)*0,4525)+(SI(RE26>(2008/12);2008/12;RE26)*0,9044)"
								// ;

		// String s =
		// "(SI(BV26>(2011/12);2011/12;BV26)*0)+(SI(BV26>(2011/12);2011/12;BV26)*0)+(SI(EA26>(2012/12);2012/12;EA26)*0)+(SI(EA26>(2012/12);2012/12;EA26)*0)+(SI(GF26>(2003/12);2003/12;GF26)*0,501)+(SI(IK26>(2004/12);2004/12;IK26)*0,1253)+(SI(KP26>(2005/12);2005/12;KP26)*0,0619)+(SI(MU26>(2006/12);2006/12;MU26)*0,2108)+(SI(OZ26>(2007/12);2007/12;OZ26)*0,4525)+(SI(RE26>(2008/12);2008/12;RE26)*0,9044)"
		// ;
		// String s = "AX5/12*$Q$5";
		s = s.replace("$", "§");
		Matcher m = p.matcher(s);
		StringBuffer sb = new StringBuffer();
		String str = null;
		String str1 = null;
		while (m.find()) {
			String groupes = m.group();

			Pattern p1 = Pattern.compile("([0-9]+)");

			Matcher m1 = p1.matcher(groupes);
			StringBuffer sb1 = new StringBuffer();
			while (m1.find()) {
				m1.appendReplacement(sb1, "%d");
			}

			m1.appendTail(sb1);
			str1 = sb1.toString();
			if (m != null) {
				m.appendReplacement(sb, str1);
			}
			str = sb.toString();
		}
		m.appendTail(sb);
		String lafor = sb.toString();
		lafor = lafor.replace("§", "$");

		return lafor;
	}

	public static class ProgressBarDb implements IRunnableWithProgress {
		private String message;
		private WyccWorkbook wb;
		private List<beneficiaries> resultdistinct;

		public ProgressBarDb(String message, WyccWorkbook wb) {

			this.message = message;
			this.wb = wb;

		}

		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			monitor.beginTask(message, IProgressMonitor.UNKNOWN);
			wb.setResultdistinct(wb.getBeneficiaries());
			monitor.done();
		}

	}

	public static class ProgressBarBeneficiaries implements IRunnableWithProgress {
		private int workload;
		private String message;
		private WyccWorkbook wb;
		private String filepath;
		private String rootdirDb;
		private List<beneficiaries> resultdistinct;

		public ProgressBarBeneficiaries(int workload, String message, WyccWorkbook wb, String filepath,
				String rootdirDb, List<beneficiaries> resultdistinct) {
			this.workload = workload;
			this.message = message;
			this.wb = wb;
			this.filepath = filepath;
			this.rootdirDb = rootdirDb;
			this.resultdistinct = resultdistinct;

		}

		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			Tools mytools = new Tools();
			File directory = new File(rootdirDb);
			String fileCharSep = System.getProperty("file.separator");
			SXSSFCell lastcellule = null;
			SXSSFCell firstcellul = null;
			String addressfirstcell = null;
			String addresslastcell = null;
			ObjectDao myobj = new ObjectDao();
			Session lasession = myobj.getSessionDao();
			SXSSFRow row = null;
			beneficiaries rs1 = null;
			Modul modul = null;
			ModulBoat modulboat = null;
			Integer compteurbeneficiairies = 0;
			int keyindex = 0;
			int introw = 3;
			int nbmodule = 8; // definit le nombre de module à traiter.
			int myIterator = 1;
			// numero de colonne de cellule de départ des infos beneficiaires
			int start = 0;

			// numero de colonne de cellule de fin des infos beneficiaires
			int end = wb.getStartColumnformule();// StartColumnformule;
			// nombre de cellule comportant les formule de calcul à utiliser pou
			// un bénficiaire
			int myOffset = wb.getOffsetColumn();

			// Lire le header
			List result = readformula(lasession, "MONTHLY", 0);

			monitor.beginTask(message, workload);

			List<String> newList = Stream
					.of(resultdistinct.stream().map(beneficiaries::getCompany1).collect(Collectors.toList()),
							resultdistinct.stream().map(beneficiaries::getCompany1).collect(Collectors.toList()),
							resultdistinct.stream().map(beneficiaries::getCompany2).collect(Collectors.toList()),
							resultdistinct.stream().map(beneficiaries::getCompany3).collect(Collectors.toList()),
							resultdistinct.stream().map(beneficiaries::getCompany4).collect(Collectors.toList()),
							resultdistinct.stream().map(beneficiaries::getCompany5).collect(Collectors.toList()),
							resultdistinct.stream().map(beneficiaries::getCompany6).collect(Collectors.toList()),
							resultdistinct.stream().map(beneficiaries::getCompany7).collect(Collectors.toList()),
							resultdistinct.stream().map(beneficiaries::getCompany8).collect(Collectors.toList()))
					.flatMap(x -> x.stream()).collect(Collectors.toList());
			List<String> companys = newList.stream().distinct().collect(Collectors.toList());
			companys = companys.stream().filter(line -> !"".equals(line)).filter(line -> line != null)
					.collect(Collectors.toList());
			companys.add(0, "Total WYCC");

			SXSSFWorkbook newworkbook = new SXSSFWorkbook(2);
			HashMap<String, Integer> mspreadsheets = new HashMap<String, Integer>();
			HashMap<Integer, SetBeneficiaries> mSetBeneficiaries = new HashMap<Integer, SetBeneficiaries>();

			SXSSFSheet spreadsheet1 = null;
			for (String spreadsheetstr : companys) {
				spreadsheet1 = newworkbook.createSheet(spreadsheetstr);

				mspreadsheets.put(spreadsheetstr, keyindex);

				// mSetBeneficiaries.put(keyindex,new SetBeneficiaries( wb,
				// newworkbook, monitor, rs1,
				// spreadsheet1, row, introw, nbmodule, modul, lasession,
				// result,
				// lastcellule, firstcellul, addressfirstcell));

				mSetBeneficiaries.put(keyindex,
						new SetBeneficiaries(wb, newworkbook, monitor, rs1, spreadsheet1, row, introw, nbmodule, modul,
								lasession, result, lastcellule, firstcellul, addressfirstcell, 0, modulboat));

				// on positionne les entêtes
				row = mSetBeneficiaries.get(keyindex).getSpreadsheet().createRow(introw);

				wb.setFormulaHeader(introw, result, newworkbook, row, myIterator, start, end, 0);

				for (myIterator = 1; myIterator <= nbmodule; myIterator++) {

					wb.setFormulaHeader(introw, result, newworkbook, row, myIterator, wb.getStartColumnformule() + 1,
							wb.getEndColumnFormule(), myOffset);
				}

				keyindex++;
			}

			SXSSFSheet spreadsheet = mSetBeneficiaries.get(0).getSpreadsheet();

			/*
			 * on recupére la liste des beneficiaires
			 */
			wb.setCountbeneficiaire(resultdistinct.size());
			monitor.setTaskName("Processing beneficiaries.");
			monitor.subTask("Processing beneficiaries " + wb.getCurrentbeneficiaire() + " of "
					+ wb.getCountbeneficiaire() + "...");
			monitor.worked(1);

			/*
			 * pour chaque beneficiaires on génére les formules de calculs
			 */

			// on se positionne sur la ligne 5 de la feuille de calcul
			// ATTENTION LA NUMEROTATION DES LIGNES COMMENCE A ZERO

			introw = 4;

			wb.setCurrentbeneficiaire(0);
			modul = new Modul();
			modulboat = new ModulBoat();

			// SetBeneficiaries setbenef=new SetBeneficiaries( wb, newworkbook,
			// monitor, rs1,
			// spreadsheet, row, introw, nbmodule, modul, lasession, result,
			// lastcellule, firstcellul, addressfirstcell,1);

			SetBeneficiaries setbenef = new SetBeneficiaries(wb, newworkbook, monitor, rs1, spreadsheet1, row, introw,
					nbmodule, modul, lasession, result, lastcellule, firstcellul, addressfirstcell, 1, modulboat);

			for (beneficiaries rs : resultdistinct) {
				compteurbeneficiairies++;

				try {
					for (String lacompanie : companys) {
						// index=mspreadsheets.get(lacompanie);
						setbenef = mSetBeneficiaries.get(mspreadsheets.get(lacompanie));
						setbenef.setRs(rs);
						setbenef.setIntrow(setbenef.getIntrow() + 1);
						setbenef.setModul(modul);
						setbenef.setModulboat(modulboat);
						setbenef.getWb().setCurrentbeneficiaire(compteurbeneficiairies);
						setBeneficiairies(setbenef);
					}

				} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
						| InvalidFormatException | SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			for (String lacompanie : companys) {
				setbenef = mSetBeneficiaries.get(mspreadsheets.get(lacompanie));
				setbenef.setIntrow(setbenef.getIntrow() + 1);
				setbenef.setRow(setbenef.getSpreadsheet().createRow(setbenef.getIntrow()));
				int j = 0;
				SXSSFCell cell = null;
				cell = setbenef.getRow().createCell(j);
				cell.setCellValue("TOTAL :");

				j++;
				cell = setbenef.getRow().createCell(j);
				String lasomme = "SUM(" + setbenef.getAddressfirstcell() + ":" + setbenef.getLastcellule().getAddress()
						+ ")";
				cell.setCellFormula(lasomme);

				// Name namedCell = setbenef.getNewworkbook().createName();
				// namedCell.setNameName("Total");
				// String reference = "'Total WYCC'"+"!"+cell.getAddress(); //
				// area reference
				// namedCell.setRefersToFormula(reference);
			}

			// Flushed last line
			try {
				((SXSSFSheet) setbenef.getSpreadsheet()).flushRows(0);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// 1. create named range for a single cell using areareference

			// Close the db session
			mSetBeneficiaries.get(0).getLasession().close();
			// Write the finale file
			FileOutputStream out;

			try {
				out = new FileOutputStream(new File(filepath));
				mSetBeneficiaries.get(0).getNewworkbook().write(out);
				out.close();
				newworkbook.dispose();
			} catch (FileNotFoundException e) {
				mSetBeneficiaries.get(0).getNewworkbook().dispose();
				e.printStackTrace();
			} catch (IOException e) {
				mSetBeneficiaries.get(0).getNewworkbook().dispose();
				e.printStackTrace();
			}

			monitor.done();
			logger.info("DONE ! setBeneficiaire");
		}

	}

}
