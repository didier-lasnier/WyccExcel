package com.poi.actionuser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import com.dlas.dao.beneficiaries;
import com.poi.dlas.WyccWorkbook;

public class ReadFileXlsx {
	private String header[];
	private Object body[][];
	private String lastFileName = null;
	private String lastSheetName = null;
	private List<beneficiaries> result;

	static Logger logger = Logger.getLogger("wycc");

	public void ReadFileXlsx() {

	}

	/*
	 * public static void main (String[] arg){
	 * Tableau("/Volumes/LaCie/ProjetDev/JavaEclipse/ExcelJava/WYCC.xlsx","Test"
	 * ); }
	 */
	public void readxls(String filepath,String rootdir) throws InvalidFormatException {
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
			wyccwrkbk.getWorkbook(theOpenfile,rootdir);

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
	
	public void generexls(String filepath,String rootdirDb) throws InvalidFormatException, SQLException, IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException {
		WyccWorkbook wyccwrkbk = new WyccWorkbook();	
		Shell shell = new Shell();
		shell.setSize(100, 400);
		IRunnableWithProgress op1 = new WyccWorkbook.ProgressBarDb("Database initialisation", wyccwrkbk);
		new ProgressMonitorDialog(shell).run(true, true, op1);
		shell.close();
		
		 shell = new Shell();
		 shell.setSize(100, 400);
			
		result =wyccwrkbk.getResultdistinct();
		
		IRunnableWithProgress op = new WyccWorkbook.ProgressBarBeneficiaries(result.size(),"Processing Beneficiaries ",wyccwrkbk,filepath,rootdirDb,result);
		
		new ProgressMonitorDialog(shell).run(true, true, op);
		shell.close();
		
	}


}
