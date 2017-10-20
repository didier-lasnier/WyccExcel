package com.poi.actionuser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import org.eclipse.swt.widgets.Monitor;

import org.apache.logging.log4j.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import com.dlas.dao.beneficiaries;
import com.poi.dlas.WyccWorkbook;

public class ReadFileXlsx {
	private String header[];
	private Object body[][];
	private String lastFileName = null;
	private String lastSheetName = null;
	private List<beneficiaries> result;

	static Logger logger = LogManager.getLogger("wycc");

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
		final Display display = Display.getCurrent();		
		shell.setSize(50, 100);
		
		Monitor primary = display.getPrimaryMonitor();
	    Rectangle bounds = primary.getBounds();
	    Rectangle rect = shell.getBounds();
	    
	    int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    
	    shell.setLocation(x, y);
		IRunnableWithProgress op1 = new WyccWorkbook.ProgressBarDb("Database initialisation", wyccwrkbk);
		ProgressMonitorDialog porgressbar=new ProgressMonitorDialog(shell);	
		
		porgressbar.run(true, true, op1);

		 shell.setSize(50, 100);

		result =wyccwrkbk.getResultdistinct();
		
		IRunnableWithProgress op = new WyccWorkbook.ProgressBarBeneficiaries(result.size(),"Processing Beneficiaries ",wyccwrkbk,filepath,rootdirDb,result);
		
		porgressbar.run(true, true, op);
		shell.close();
		
	}


}
