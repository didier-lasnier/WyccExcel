package com.poi.actionuser;
import java.lang.reflect.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
import com.poi.dlas.FileDialog;
import com.poi.dlas.WyccWorkbook;
import com.poi.dlas.managecsv;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;



public class ReadFileXlsx {
    private String header[];
    private Object body[][];
    private String lastFileName = null;
    private String lastSheetName = null;
    
    
    
	 static Logger logger = Logger.getLogger("wycc");
	 
	  public void ReadFileXlsx(){

	  }
	  
	  
/* 	  public static  void main (String[] arg){
 		  Tableau("/Volumes/LaCie/ProjetDev/JavaEclipse/ExcelJava/WYCC.xlsx","Test");
 	  }*/
	  public void readxls() throws InvalidFormatException {
		     File directory = new File (".");
		     String fileCharSep =System.getProperty("file.separator");

		     //Open csv file
		     new FileDialog();
		     // launch SAveDialog
		     
		     FileDialog FileDialogOpen = new FileDialog();
		     logger.info("Select file csv");
		     File theOpenfile=null;
			     try {
					theOpenfile=FileDialogOpen.openFileDialog(directory);
					FileInputStream out =  new FileInputStream(  new File(theOpenfile.getCanonicalPath()));
					// on a le dialogue des fichiers
					//org.apache.poi.ss.usermodel.Workbook wrkbk = WorkbookFactory.create(theOpenfile);
					XSSFWorkbook wrkbk=new XSSFWorkbook(out);
					WyccWorkbook wyccwrkbk=new WyccWorkbook();
					wyccwrkbk.setWorkBook(wrkbk);
					wyccwrkbk.getWorkbook(theOpenfile);
					
				} 
			     catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			     catch (InterruptedException e) {
					// TODO Auto-generated catch block
					logger.info("Select file csv");
					logger.info(e);
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		     
	  }

/*	    
	    public static  void Tableau(String fileName, String sheetName)
	    {
	        try
	        {
//	            this.setLastFileName(fileName);
//	            this.setLastSheetName(sheetName);
	            FileInputStream file = new FileInputStream(fileName);
	            Workbook workbook = WorkbookFactory.create(file);
	            final Sheet sheet = workbook.getSheetAt((int) 0) ;//.getSheet(sheetName)
	            int top = 1;//sheet.getFirstRowNum();
	            int bottom = sheet.getLastRowNum();
	            Row line = sheet.getRow(top);
	            int start = line.getFirstCellNum();
	            int end = line.getLastCellNum();    
	            int length = end - start;
	            Cell cellule=line.getCell(0);
	            String lacell = cellule.getStringCellValue();
	            logger.info("Cellule"+lacell);
	            Gson gson = new GsonBuilder().serializeNulls().create();
	            Type fooType = new TypeToken<Cell>() {}.getType();
	            String leJson = gson.toJson(cellule, fooType);//new FileWriter("/Volumes/LaCie/ProjetDev/JavaEclipse/ExcelJava/WYCCJson.txt") );
	            logger.info(leJson);
	            
	            	             
	            while(length == 0)
	            {
	                top++;
	                line = sheet.getRow(top);
	                start = line.getFirstCellNum();
	                end = line.getLastCellNum();    
	                length = end - start;
	            }
	            int hight = bottom - top;
	            this.header =  new String[length];
	            this.body = new Object[hight][length];
	            for (int i = 0; i < length; i++)
	            {
	                header[i] = line.getCell(start + i).getStringCellValue();    
	            }
	            
	            for (int index = 0; index < hight; index++) 
	            {
	                line = sheet.getRow(index + top + 1);
	                for (int i = 0; i < length; i++)
	                {
	                    Cell cellule = line.getCell(start + i);
	                    switch (cellule.getCellType())
	                    {
	                        case Cell.CELL_TYPE_STRING : 
	                            this.body[index][i] = cellule.getStringCellValue();
	                            break;
	                        case Cell.CELL_TYPE_BOOLEAN : 
	                            this.body[index][i] = cellule.getBooleanCellValue();
	                            break;
	                        default :
	                            this.body[index][i] = cellule.getNumericCellValue();
	                    }
	                }
	            }
	            
	            
	            
	            workbook.close();
	            file.close();
	        }
	         catch (InvalidFormatException | IOException e) 
	        {
	             e.printStackTrace();
	        }
	    }
	    
	 */ 
}
