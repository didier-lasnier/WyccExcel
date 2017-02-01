package com.poi.dlas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
import com.dlas.dao.wycccell;



//import au.com.ozblog.hibernate.h2.example.User;

import com.dlas.dao.ObjectDao;

import org.hibernate.HibernateException ;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


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
//			    h2db db=new h2db();
//			    db.getDatabase(directory);
//
//			    Statement stmt = db.connectiondb.createStatement();
				   ObjectDao myobj= new ObjectDao();
				   Session lasession = myobj.getSessionDao();


				  try {
				 // XSSFWorkbook workbook = this.currentworkbook; 
					  XSSFSheet sheet = this.currentworkbook.getSheetAt(0); 
				  
					  int firstSheet =0;
					  int firstrow =3;
					  
					 lasession.beginTransaction();
					 Query query = lasession.createSQLQuery("DELETE FROM SETTINGSCELL");
					 int result = query.executeUpdate();
					 lasession.getTransaction().commit();
					  for (int i=firstrow;i<=4;i++){
					  readData(this.currentworkbook,0,i,lasession);
					  }
					  lasession.close();
					  
				 // out.close();
				  this.currentworkbook.close();
				  	}
				  catch (Exception e) { 
					   e.printStackTrace(); 
					  }  
			  
//			     stmt.close();
//			    db.closeDbConnection(db.connectiondb);
			    
			  } catch (Exception e) { 
			   e.printStackTrace(); 
			  } 
		  
		   
		  
	}
	public void readXlsfile(XSSFWorkbook workbook,int sheetnumber ) {

		
	}
	
	public void readformula (){
		
		   ObjectDao myobj= new ObjectDao();
		   Session lasession = myobj.getSessionDao();
		// now lets pull events from the database and list them
		   lasession.beginTransaction();
			List resultdistinct = lasession.createQuery("select distinct cellrow from wycccell").list();
			lasession.getTransaction().commit();
			//lasession.close();
			for (int introw : (List<Integer>) resultdistinct){
				 System.out.println("****** : "+introw );
			}
			lasession.close();
			lasession = myobj.getSessionDao();
			
			 XSSFWorkbook newworkbook = new XSSFWorkbook(); 
			 XSSFSheet spreadsheet = newworkbook.createSheet("Total WYCC");
			
			 
		  for (int introw : (List<Integer>) resultdistinct){
			lasession.beginTransaction();
			Query query = lasession.createQuery("from wycccell where cellrow = :introw");
			query.setParameter("introw", introw);
			
			List result =query.list();
			lasession.getTransaction().commit();
			// on est sur une ligne on va la cree

			 XSSFRow row = spreadsheet.createRow(introw);

				for (wycccell event : (List<wycccell>) result) {
					XSSFCell cell = (XSSFCell) row.createCell(event.getCellcolumn());
					XSSFCellStyle style1 = newworkbook.createCellStyle();

					style1.setBorderBottom((short) event.getBorderbottom());
					style1.setBorderTop((short) event.getBordertop());
					style1.setBorderLeft((short) event.getBorterleft());
					style1.setBorderRight((short) event.getBorderright());
					style1.setDataFormat((short) event.getDataformat());
					//style1.setDataFormatString ( event.getDataformatstring());
					style1.setBottomBorderColor((short) event.getBordercolorbottom());
					style1.setBottomBorderColor((short) event.getBordercolortop());
					style1.setRightBorderColor((short) event.getBordercolorright());
					style1.setLeftBorderColor((short) event.getBordercolorleft());
					
					style1.setAlignment((short) event.getHalignement());
					style1.setVerticalAlignment((short) event.getValignement());
					
					style1.setFillBackgroundColor(HSSFColor.YELLOW.index);//(short) event.getBaxkgroundcolor());
					//style1.setFillForegroundColor ((short) event.getFrontgroundcolor());
					style1.setFillPattern(XSSFCellStyle.NO_FILL);//(short) event.getPattern());
					//style1.setIndention((short) event.getIndention());

						
					
					if (event.getformulecell() != null) {
					   
					   String laformule = event.getformulecell().replace("5", "%d");
					   //int occurance = StringUtils.countOccurrencesOf("a.b.c.d", ".");
					   int therow=event.getCellrow()+1;
					   laformule=String.format(laformule,therow,therow) ;
					   cell.setCellFormula(laformule);
					   //System.out.println(laformule+"****** : "+String.format(laformule,therow,therow) );
					}
					if (event.getvaleurcell() != null) {
						
						
						
						String lavaleur = event.getvaleurcell();
						
						if (event.gettypecell() == Cell.CELL_TYPE_NUMERIC ) {
							cell.setCellValue(Float.parseFloat(lavaleur));
						}
						else if (event.gettypecell() == Cell.CELL_TYPE_STRING )  {
							cell.setCellValue(lavaleur );
						}
						
						cell.setCellStyle(style1);	
					}
					
				}

		}
			String filepath = null;
			File theXlsfile = null;
		    File directory = new File (".");
		    String fileCharSep =System.getProperty("file.separator");
			FileDialog FileDialogOpen = new FileDialog();
			try {
				theXlsfile=FileDialogOpen.saveFileDialog(directory);
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
				out = new FileOutputStream( new File(filepath));
				newworkbook.write(out);
				out.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	     
		
		lasession.close();
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
	public void readData(XSSFWorkbook workbook,int sheetNumber,int fromRow ,Session lasession  ) throws SQLException{
		// on recupére la ligne
		
		XSSFRow currentRow = workbook.getSheetAt(sheetNumber).getRow(fromRow);
		int lastCell =  workbook.getSheetAt(sheetNumber).getRow(fromRow).getLastCellNum();
		// on détermine la derniére cellule
		// pour chaque ligne on boucle sur les cellules jusque qu'a la derniére colonne
		//on lit la cellule
		 Row row=workbook.getSheetAt(sheetNumber).getRow(fromRow);
		 int firstcell = row.getFirstCellNum();

		 for(int j=firstcell;j< lastCell;j++){ 
			 String cellText =null;
			 String cellformule=null;
			 int celltype;
			 Cell cell = row.getCell(j); 
			
			if (cell != null) {
				  celltype = cell.getCellType();
				if(cell.getCellType()==Cell.CELL_TYPE_STRING) {
				    logger.info("Row : "+fromRow+ " Column : "+j+" value : "+ cell.getStringCellValue() ); 
					cellText = cell.getStringCellValue();
						}
				else if (cell.getCellType()==Cell.CELL_TYPE_FORMULA ) {
					 cellformule=cell.getCellFormula();
				}
				
				else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA ){ 
				     
				     cellText  = String.valueOf(cell.getNumericCellValue()); 
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
				
	
				 //wycccell wycccell=new wycccell();
				 
				 wycccell wycccell=StylCellDao(cell,cellText,cellformule,celltype );
			
				 lasession.beginTransaction();
				 lasession.save(wycccell);
				 lasession.getTransaction().commit();
			}
		 }
		     
		
	}
	
	public wycccell StylCellDao (Cell thecell,String cellText ,String cellformule,int celltype){
		
			int sheetnum =0;
			
		return new wycccell(
				thecell.getRowIndex() , 
				thecell.getColumnIndex() , 
				sheetnum,
				thecell.getCellStyle().getAlignment() ,
				thecell.getCellStyle().getVerticalAlignment() ,
				thecell.getCellStyle().getBorderBottom() ,
				thecell.getCellStyle().getBorderTop() ,
				thecell.getCellStyle().getBorderLeft() ,
				thecell.getCellStyle().getBorderRight() ,
				thecell.getCellStyle().getDataFormat() ,
				thecell.getCellStyle().getDataFormatString(),
				thecell.getCellStyle().getFillBackgroundColor(),
				thecell.getCellStyle().getFillForegroundColor(),
				thecell.getCellStyle().getFillPattern(),
				thecell.getCellStyle().getIndex() ,
				thecell.getCellStyle().getIndention() ,
				thecell.getCellStyle().getBottomBorderColor() ,
				thecell.getCellStyle().getTopBorderColor() ,
				thecell.getCellStyle().getRightBorderColor() , 
				thecell.getCellStyle().getLeftBorderColor(),
				cellText,cellformule,celltype );
		
			
		}
	
}
