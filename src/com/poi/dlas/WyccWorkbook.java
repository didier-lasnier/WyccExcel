package com.poi.dlas;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
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
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;

import com.dlas.dao.h2db;
import com.dlas.dao.hsqltext;

import org.hibernate.HibernateException ;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class WyccWorkbook {
      public  XSSFWorkbook currentworkbook;
      public  XSSFSheet currentSheet;
      
      public WyccWorkbook() {
    	  
      }

	public WyccWorkbook(File xlsfileWycc) {
		 try {
			this.currentworkbook= new XSSFWorkbook(xlsfileWycc);
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	
	 public XSSFWorkbook setWorkBook (XSSFWorkbook wrkbk ){
		 
		 return this.currentworkbook = wrkbk;
		 
		
		 
	 }
	 
	 public XSSFSheet setSheet(XSSFSheet wrkbkSheet){
		 this.currentSheet=wrkbkSheet;
		 return wrkbkSheet;
	 }
	 
	 public XSSFWorkbook getWorkBook ( ){
		return this.currentworkbook;
		
		 
	 }
	 
	 public XSSFSheet getSheet (){
			return this.currentSheet;
			
			 
		 }
	public static  Logger logger = Logger.getLogger("wycc");
	 
	public void createWorkbook (File xlsfileWycc) throws IOException, InvalidFormatException{
		
		//Workbook wb=SetworkBook( new XSSFWorkbook());
		setSheet (setWorkBook( new XSSFWorkbook( xlsfileWycc)).createSheet("Total WYCC"));
/*		 	Row row;
	        Cell cell;
	        int rownum = 1;
	        int colnum =1;
	        String data = "Test";
	       

		    PrintSetup printSetup = sheet.getPrintSetup();
	        printSetup.setLandscape(true);

	        //the following three statements are required only for HSSF
	        sheet.setAutobreaks(true);
	        printSetup.setFitHeight((short)1);
	        printSetup.setFitWidth((short)1);
	        
	        Row headerRow = sheet.createRow(0);
	        headerRow.setHeightInPoints(12.75f);
	        
	        cell = headerRow.createCell(0);
	        cell.setCellValue(data);*/
		
	        // Write the output to a file
	        String filepath = xlsfileWycc.getCanonicalPath();
	        //if(wb instanceof XSSFWorkbook) file += "x";
	        logger.info(filepath);
	        
	        Object[][] bookData = {
	                {"Head First Java", "Kathy Serria", 79},
	                {"Effective Java", "Joshua Bloch", 36},
	                {"Clean Code", "Robert martin", 42},
	                {"Thinking in Java", "Bruce Eckel", 35},
	        };
	 
	        int rowCount = 0;
	         
/*	        for (Object[] aBook : bookData) {
	            Row row = sheet.createRow(++rowCount);
	             
	            int columnCount = 0;
	             
	            for (Object field : aBook) {
	                Cell cell = row.createCell(++columnCount);
	                if (field instanceof String) {
	                    cell.setCellValue((String) field);
	                } else if (field instanceof Integer) {
	                    cell.setCellValue((Integer) field);
	                }
	            }
	             
	        }*/
	        
	        FileOutputStream out = new FileOutputStream(filepath);
	        this.getWorkBook().write(out);
	        out.close();
	        this.getWorkBook().close();
	}


	
	public  void getWorkbook ( File xlsfileWycc) throws IOException{
		  try { 
			  // file is not open 
			//  FileOutputStream out = new FileOutputStream(xlsfileWycc.getAbsolutePath() );
			    File directory = new File (".");
			     String fileCharSep =System.getProperty("file.separator");
			    h2db db=new h2db();
			    db.getDatabase(directory);

			    Statement stmt = db.connectiondb.createStatement();
			   


			    
				  try {
				 // XSSFWorkbook workbook = this.currentworkbook; 
					  XSSFSheet sheet = this.currentworkbook.getSheetAt(0); 
				  
					  int firstSheet =0;
					  int firstrow =0;
					  for (int i=firstrow;i<=5;i++){
					  readData(this.currentworkbook,0,i,stmt);
					  }
				 // out.close();
				  this.currentworkbook.close();
				  	}
				  catch (Exception e) { 
					   e.printStackTrace(); 
					  }  
			  
			   stmt.close();
			    db.closeDbConnection(db.connectiondb);
			    
			  } catch (Exception e) { 
			   e.printStackTrace(); 
			  } 
		  
		   
		  
	}
	public void readXlsfile(XSSFWorkbook workbook,int sheetnumber ) {

		
	}
	
	public int getRowCount(XSSFWorkbook workbook,String sheetName){ 
		  int index = workbook.getSheetIndex(sheetName); 
		  if(index==-1) 
		   return 0; 
		  else{ 
			  XSSFSheet sheet = workbook.getSheetAt(index); 
			  int number=sheet.getLastRowNum()+1; 
			  return number; 
		  	} 
		 } 
	
	public int getRowCount(XSSFWorkbook workbook,int sheetNumber){ 
		  String sheetName = workbook.getSheetName(sheetNumber); 
		  
		  if(sheetNumber==-1) 
		   return 0; 
		  else{ 
			  XSSFSheet sheet = workbook.getSheetAt(sheetNumber); 
			  int number=sheet.getLastRowNum()+1; 
			  return number; 
		  	} 
		 } 
	public void readData(XSSFWorkbook workbook,int sheetNumber,int fromRow ,Statement stmt  ) throws SQLException{
		// on recupére la ligne
		
		XSSFRow currentRow = workbook.getSheetAt(sheetNumber).getRow(fromRow);
		int lastCell =  workbook.getSheetAt(sheetNumber).getRow(fromRow).getLastCellNum();
		// on détermine la derniére cellule
		// pour chaque ligne on boucle sur les cellules jusque qu'a la derniére colonne
		//on lit la cellule
		 Row row=workbook.getSheetAt(sheetNumber).getRow(fromRow);
		 int firstcell = row.getFirstCellNum();
	 
		 for(int j=firstcell;j< lastCell;j++){ 
			// int First = row.getFirstCellNum();
			Cell cell = row.getCell(j); 
			
			if(cell.getCellType()==Cell.CELL_TYPE_STRING) 
			    logger.info("Row : "+fromRow+ " Column : "+j+" value : "+ cell.getStringCellValue() ); 
			   else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA ){ 
			     
			    String cellText  = String.valueOf(cell.getNumericCellValue()); 
			    if (HSSFDateUtil.isCellDateFormatted(cell)) { 
			            // format in form of M/D/YY 
			     double d = cell.getNumericCellValue(); 
			 
			     Calendar cal =Calendar.getInstance(); 
			     cal.setTime(HSSFDateUtil.getJavaDate(d)); 
			             cellText = 
			              (String.valueOf(cal.get(Calendar.YEAR))).substring(2); 
			            cellText = cal.get(Calendar.MONTH)+1 + "/" + 
			                       cal.get(Calendar.DAY_OF_MONTH) + "/" + 
			                       cellText; 
			             
			           // System.out.println(cellText); 
			 
			          } 
			 
			     
			     
			    logger.info( cellText); 
			   }else if(cell.getCellType()==Cell.CELL_TYPE_BLANK) 
				   logger.info("nothing"); 
			   else  
				   logger.info(String.valueOf(cell.getBooleanCellValue())); 
			
		 }
		 h2db  db = new h2db();
		 try {
			Session session =db.getSession();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String stylCell (Cell thecell ){
		String sqlstmt ="";
		String sepcol = ",";
		sqlstmt=sqlstmt+thecell.getSheet();
		sqlstmt=sqlstmt+thecell.getRowIndex()+sepcol;
		sqlstmt=sqlstmt+thecell.getColumnIndex()+sepcol;
		sqlstmt=sqlstmt+thecell.getCellStyle().getAlignment()+sepcol;
		sqlstmt=sqlstmt+thecell.getCellStyle().getBorderBottom()+sepcol;
		sqlstmt=sqlstmt+thecell.getCellStyle().getBorderLeft()+sepcol;
		sqlstmt=sqlstmt+thecell.getCellStyle().getBorderRight()+sepcol;	
		sqlstmt=sqlstmt+thecell.getCellStyle().getBorderTop()+sepcol;	
		sqlstmt=sqlstmt+thecell.getCellStyle().getDataFormat()+sepcol;	
		sqlstmt=sqlstmt+thecell.getCellStyle().getDataFormatString()+sepcol;	
		sqlstmt=sqlstmt+thecell.getCellStyle().getFillBackgroundColor()+sepcol;	
		sqlstmt=sqlstmt+thecell.getCellStyle().getFillPattern()+sepcol;	
		sqlstmt=sqlstmt+thecell.getCellStyle().getFontIndex()+sepcol;	
		sqlstmt=sqlstmt+thecell.getCellStyle().getIndention()+sepcol;
		sqlstmt=sqlstmt+thecell.getCellStyle().getIndex()+sepcol;
		sqlstmt=sqlstmt+thecell.getCellStyle().getLeftBorderColor()+sepcol;
		sqlstmt=sqlstmt+thecell.getCellStyle().getRightBorderColor()+sepcol;
		sqlstmt=sqlstmt+thecell.getCellStyle().getTopBorderColor()+sepcol;
		sqlstmt=sqlstmt+thecell.getCellStyle().getBottomBorderColor()+sepcol;
		sqlstmt=sqlstmt+thecell.getCellStyle().getVerticalAlignment()+sepcol;		
		
		return sqlstmt;
		}
	
	
}
