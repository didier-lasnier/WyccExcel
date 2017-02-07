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
import com.dlas.dao.Wycccell;
import com.poi.actionuser.Explorateur;


//import au.com.ozblog.hibernate.h2.example.User;

import com.dlas.dao.ObjectDao;
import com.dlas.dao.beneficiairies;

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

				   ObjectDao myobj= new ObjectDao();
				   Session lasession = myobj.getSessionDao();


				  try {
					  XSSFSheet sheet = this.currentworkbook.getSheetAt(0); 
				  
					  int firstSheet =0;
					  int firstrow =3;
					  
					 lasession.beginTransaction();
					 Query query = lasession.createSQLQuery("DELETE FROM SETTINGSCELL");
					 int result = query.executeUpdate();
					 lasession.getTransaction().commit();
					 lasession.close();
					 
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

			    
			  } catch (Exception e) { 
			   e.printStackTrace(); 
			  } 	   
		  
	}
	public void readXlsfile(XSSFWorkbook workbook,int sheetnumber ) {

		
	}
	
	public void setBeneficiairies(){
			ObjectDao myobj= new ObjectDao();
			Session lasession = myobj.getSessionDao();
			lasession.beginTransaction();
			List resultdistinct = lasession.createQuery("from beneficiairies").list();
			lasession.getTransaction().commit();
			XSSFWorkbook newworkbook = new XSSFWorkbook(); 
			XSSFSheet spreadsheet = newworkbook.createSheet("Total WYCC");
			int introw=3;
			 for (beneficiairies event : (List<beneficiairies>) resultdistinct){
				 XSSFRow row = spreadsheet.createRow(introw);
				 Explorateur exp =new Explorateur();
				 exp.explorerMethodes(event);
				 
				 int j=0;
				 XSSFCell cell = (XSSFCell) row.createCell(j); 
				 cell.setCellValue(event.getWyccid() );
				 j++;
				 cell = (XSSFCell) row.createCell(j); 
				 cell.setCellValue(event.getPositioncrew() );
				 
				 j++;
				 cell = (XSSFCell) row.createCell(j); 
				 cell.setCellValue(event.getName() );
				 
				 j++;
				 cell = (XSSFCell) row.createCell(j); 
				 cell.setCellValue(event.getFirstname() );
				 
				 j++;
				 cell = (XSSFCell) row.createCell(j); 
				 cell.setCellValue(event.getStructurename() );
				 
				 j++;
				 cell = (XSSFCell) row.createCell(j); 
				 cell.setCellValue(event.getFamilycovered() );

				 j++;
				 cell = (XSSFCell) row.createCell(j); 
				 cell.setCellValue(event.getNationality() );

				 j++;
				 cell = (XSSFCell) row.createCell(j); 
				 cell.setCellValue(event.getCountry() );
				 
				 j++;
				 cell = (XSSFCell) row.createCell(j); 
				 cell.setCellValue(event.getChildren());
				 				 j++;
				 cell = (XSSFCell) row.createCell(j); 
				 cell.setCellValue(event.getStartmovement() );
				 
				 j++;
				 cell = (XSSFCell) row.createCell(j); 
				 cell.setCellValue(event.getEndmovement() );
				 
				 j++;
				 cell = (XSSFCell) row.createCell(j); 
				 cell.setCellValue(event.getMonthlysalary() );
				 
				 j++;
				 cell = (XSSFCell) row.createCell(j); 
				 cell.setCellValue(event.getSalaryCurrency() );
				 
				 j++;
				 cell = (XSSFCell) row.createCell(j); 
				 cell.setCellValue(event.getToinvoice() );
				 
/*				 for (int j=1;j<=event.ColumnCount();j++){
					 
					
				 }*/
				 
				 introw++;
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

				for (Wycccell event : (List<Wycccell>) result) {
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
	public void readData(XSSFWorkbook workbook,int sheetNumber,int fromRow ,Session lasession  ) throws SQLException, IOException{
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
			
				 Wycccell wycccell=StylCellDao(cell,cellText,cellformule,celltype );
				 
			     File directory = new File (".");
			     String fileCharSep =System.getProperty("file.separator");

		         h2db db=new h2db();
		         db.getDatabase(directory);
		         String  sqlstmt1 = "INSERT INTO PUBLIC.SETTINGSCELL (";
		         sqlstmt1 = sqlstmt1+" CELL_ID,";
		         sqlstmt1 = sqlstmt1+" BAXKGROUNDCOLOR,";
		         sqlstmt1 = sqlstmt1+" BODERBOTTOM,";
		         sqlstmt1 = sqlstmt1+" BODERCOLORBOTTEM,";
		         sqlstmt1 = sqlstmt1+" BORDERCOLORIGHT,";
		         sqlstmt1 = sqlstmt1+" BORDERCOLORRIGHT,";
		         sqlstmt1 = sqlstmt1+" BORDERCOLORTOP,";
		         sqlstmt1 = sqlstmt1+" BORDERRIGHT,";
		         sqlstmt1 = sqlstmt1+" BORDERTOP,";
		         sqlstmt1 = sqlstmt1+" BORDERLEFT,";
		         sqlstmt1 = sqlstmt1+" CELLCOLUMN,";
		         sqlstmt1 = sqlstmt1+" CELLROW,";
		         sqlstmt1 = sqlstmt1+" DATAFORMAT,";
		         sqlstmt1 = sqlstmt1+" DATAFORMATSTRING,";
		         sqlstmt1 = sqlstmt1+" FONTINDEX,";
		         sqlstmt1 = sqlstmt1+" FORMULECELL,";
		         sqlstmt1 = sqlstmt1+" HALIGNEMENT,";
		         sqlstmt1 = sqlstmt1+" INDENTION,";
		         sqlstmt1 = sqlstmt1+" PATTERN,";
		         sqlstmt1 = sqlstmt1+" SHEETNUM,";
		         sqlstmt1 = sqlstmt1+" VALEURCELL,";
		         sqlstmt1 = sqlstmt1+" VALIGNEMENT,";
		         sqlstmt1 = sqlstmt1+" TYPECELL,";
		         sqlstmt1 = sqlstmt1+" FRONTGROUNDCOLOR)";
		         sqlstmt1 = sqlstmt1+" VALUES (";
		        sqlstmt1 = sqlstmt1+" NULL,";
		         sqlstmt1 = sqlstmt1+" "+cell.getCellStyle().getFillBackgroundColor()+",";  
		         sqlstmt1 = sqlstmt1+" "+cell.getCellStyle().getBorderBottom()+",";        
		         sqlstmt1 = sqlstmt1+" "+cell.getCellStyle().getBottomBorderColor()+",";   
		         sqlstmt1 = sqlstmt1+" "+cell.getCellStyle().getBorderRight()+",";         
		         sqlstmt1 = sqlstmt1+" "+cell.getCellStyle().getRightBorderColor()+",";    
		         sqlstmt1 = sqlstmt1+" "+cell.getCellStyle().getTopBorderColor()+",";      
		         sqlstmt1 = sqlstmt1+" "+cell.getCellStyle().getBorderRight()+",";         
		         sqlstmt1 = sqlstmt1+" "+cell.getCellStyle().getBorderTop()+",";           
		         sqlstmt1 = sqlstmt1+" "+cell.getCellStyle().getBorderLeft()+",";          
		         sqlstmt1 = sqlstmt1+" "+cell.getColumnIndex()+",";                        
		         sqlstmt1 = sqlstmt1+" "+cell.getRowIndex()+",";                           
		         sqlstmt1 = sqlstmt1+" "+cell.getCellStyle().getDataFormat()+",";          
		         sqlstmt1 = sqlstmt1+" '"+cell.getCellStyle().getDataFormatString()+"',";    
		         sqlstmt1 = sqlstmt1+" "+cell.getCellStyle().getFontIndex()+",";           
		         sqlstmt1 = sqlstmt1+" '"+cellformule+"',";                                   
		         sqlstmt1 = sqlstmt1+" "+cell.getCellStyle().getAlignment()+",";           
		         sqlstmt1 = sqlstmt1+" "+cell.getCellStyle().getIndention()+",";           
		         sqlstmt1 = sqlstmt1+" "+cell.getCellStyle().getFillPattern()+",";         
		         sqlstmt1 = sqlstmt1+" "+cell.getCellStyle().getIndex()+",";               
		         sqlstmt1 = sqlstmt1+" '"+cellText+"',";                                      
		         sqlstmt1 = sqlstmt1+" "+cell.getCellStyle().getVerticalAlignment()+",";   
		         sqlstmt1 = sqlstmt1+" "+celltype+",";                            
		         sqlstmt1 = sqlstmt1+" "+cell.getCellStyle().getFillForegroundColor()+") ;"; 
		         
		         Statement stmt = db.connectiondb.createStatement();
		         stmt.executeUpdate(sqlstmt1);
		         stmt.close();
				 
				 
/*				 lasession.beginTransaction();
				//Query query = lasession.createQuery("insert into wycccell (id,baxkgroundcolor,boderbottom,bodercolorbottem,bordercoloright, bordercolorright, bordercolortop, borderright, bordertop, borderleft, cellcolumn, cellrow, dataformat, dataformatstring, fontindex, formulecell, halignement, indention, pattern, sheetnum, valeurcell, valignement, typecell, frontgroundcolor) SELECT NULL, :baxkgroundcolor, :boderbottom, :bodercolorbottem, :bordercoloright, :bordercolorright, :bordercolortop, :borderright, :bordertop, :borderleft, :cellcolumn, :cellrow, :dataformat, :dataformatstring, :fontindex, :formulecell, :halignement, :indention, :pattern, :sheetnum, :valeurcell, :valignement, :typecell, :frontgroundcolor FROM wyccceldual");
				Query query = lasession.createQuery("insert into wycccell (id,baxkgroundcolor) SELECT NULL, :baxkgroundcolor FROM wyccceldual");
	
				 query.setParameter("baxkgroundcolor",cell.getCellStyle().getFillBackgroundColor());//baxkgroundcolor);
				 query.setParameter("boderbottom",cell.getCellStyle().getBorderBottom());// boderbottom);
				 query.setParameter("bodercolorbottem",cell.getCellStyle().getBottomBorderColor()); //bodercolorbottem);
				 query.setParameter("bordercoloright",cell.getCellStyle().getRightBorderColor());//bordercoloright);
				 query.setParameter("bordercolorright",cell.getCellStyle().getBorderRight());//bordercolorright);
				 query.setParameter("bordercolortop",cell.getCellStyle().getTopBorderColor());//bordercolortop);
				 query.setParameter("borderright",cell.getCellStyle().getBorderRight());//borderright);
				 query.setParameter("bordertop",cell.getCellStyle().getBorderTop());//bordertop);
				 query.setParameter("borderleft",cell.getCellStyle().getBorderLeft());//borderleft);
				 query.setParameter("cellcolumn",cell.getColumnIndex());//cellcolumn);
				 query.setParameter("cellrow",cell.getRowIndex());//cellrow);
				 query.setParameter("dataformat",cell.getCellStyle().getDataFormat());//dataformat);
				 query.setParameter("dataformatstring",cell.getCellStyle().getDataFormatString());//dataformatstring);
				 query.setParameter("fontindex",cell.getCellStyle().getFontIndex());//fontindex);
				 query.setParameter("formulecell",cellformule);//formulecell);
				 query.setParameter("halignement",cell.getCellStyle().getAlignment());//halignement);
				 query.setParameter("indention",cell.getCellStyle().getIndention());//indention);
				 query.setParameter("pattern",cell.getCellStyle().getFillPattern());//pattern);
				 query.setParameter("sheetnum",cell.getCellStyle().getIndex());//sheetnum);
				 query.setParameter("valeurcell",cellText);//valeurcell);
				 query.setParameter("valignement",cell.getCellStyle().getVerticalAlignment());//valignement);
				 query.setParameter("typecell",celltype);
				 query.setParameter("frontgroundcolor",cell.getCellStyle().getFillForegroundColor());//frontgroundcolor);
				 List result =query.list();
				 lasession.getTransaction().commit();*/
			}
		 }
		     
		
	}
	
	public Wycccell StylCellDao (Cell thecell,String cellText ,String cellformule,int celltype){
		
			int sheetnum =0;
			
		return new Wycccell(
				
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
