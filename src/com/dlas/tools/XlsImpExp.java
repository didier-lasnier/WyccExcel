package com.dlas.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.hibernate.Session;

import com.dlas.dao.ModulBoat;
import com.dlas.dao.ObjectDao;

public class XlsImpExp {
	private File                         filetoprocess;
	private XSSFWorkbook                 wrkbk;
	private Display                      display;
	
	
	public XlsImpExp() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	public File getFiletoprocess() {
		return filetoprocess;
	}

	public XSSFWorkbook getWrkbk() {
		return wrkbk;
	}

	public Display getDisplay() {
		return display;
	}


	public void setFiletoprocess(File filetoprocess) {
		this.filetoprocess = filetoprocess;
	}

	public void setWrkbk(XSSFWorkbook wrkbk) {
		this.wrkbk = wrkbk;
	}


	public void setDisplay(Display display) {
		this.display = display;
	}



	public void setFiletoprocess(String pathtoprocess) {
		this.filetoprocess = new File (pathtoprocess);
	}
	
	
	
	public void getFileXlstoImp(){
		File directory = new File(".");
		String fileCharSep = System.getProperty("file.separator");

		Shell shell = new Shell();
		FileDialog fd = new FileDialog(shell, SWT.OPEN);
		fd.setText("Choose a file");
		try {
			fd.setFilterPath(directory.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] filterExt = { "*.xlsx"};
		fd.setFilterExtensions(filterExt);
		String selected = fd.open();
		if (selected != null){
			this.setFiletoprocess(selected);
		}		
	}//getFileXlstoImp
	
	
	/**
	 * @param xlsfiletoread
	 */
	public void readxlsFileToList(File xlsfiletoread){
		// Read the current sheet.
		Integer currentsheet =0;
		// open a stream to read the xls file
		FileInputStream out;
		try {
			out = new FileInputStream(xlsfiletoread);
			this.setWrkbk( new XSSFWorkbook(out));	
			XSSFSheet sheet = this.getWrkbk().getSheetAt(currentsheet);
			
			Iterator<Row> iterator = sheet.iterator();
			ModulBoat modulboat = new ModulBoat();
			String[] header = new String[]{"Modulid","modul_fournisseur","modullabel","modulecategory","modulboat","modulpricesingle","modulpricefamily","forfaitpercentage","modulscope","invoiceperiod","calculmode","bankfee","surcom","policynumber","aggregateamount"};
     
			//String prmier=header[0];
			
			
			/*
			 * 
			 * 
			 *  ObjectDao myobj = new ObjectDao();
				Session lasession = myobj.getSessionDao();
				lasession.beginTransaction(); 
				 for ( ModulBoat modulboat : (List<ModulBoat>) m_modulboatmodels.getM_modulboats() ){
					 lasession.saveOrUpdate(modulboat);
				 }
				 if (deletemodulboat!= null) {
					 for ( ModulBoat modulboat : deletemodulboat){
						 lasession.delete(modulboat);
					 }
				 }
				  lasession.flush();
				  lasession.getTransaction().commit(); 
				  lasession.close();
				
			 * 
			 * */
			ObjectDao myobj = new ObjectDao();
			Session lasession = myobj.getSessionDao();
			lasession.beginTransaction(); 
			while (iterator.hasNext()) {
            	Row currentRow = iterator.next();
            	// First row contains header we pass.
            	// 
            	int counterrow =0;
            	if ( currentRow.getRowNum()>0 ) {
					Iterator<Cell> cellIterator = currentRow.iterator();
					while (cellIterator.hasNext()) {

						Cell currentCell = cellIterator.next();
						//getCellTypeEnum shown as deprecated for version 3.15
						//getCellTypeEnum ill be renamed to getCellType starting from version 4.0
/*
 * 
 * 						if (currentCell.getColumnIndex() ==0) {
							if (currentCell.getCellTypeEnum() == CellType.STRING) {
								System.out.print(currentCell.getStringCellValue() + "--");
							} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
								modulboat.setModulid(currentCell.getNumericCellValue());
								System.out.print(currentCell.getNumericCellValue() + "--");
							} else if (currentCell.getCellTypeEnum() == CellType.BLANK) {
								System.out.print("VIDE--");
							} else if (currentCell.getCellTypeEnum() == CellType.FORMULA) {
								System.out.print("FORMULE--");
							} 
						}

 * 						
 */
						//modulid
						if (currentCell.getColumnIndex() ==0) {
							if (currentCell.getCellTypeEnum() == CellType.STRING) {
								System.out.print(currentCell.getStringCellValue() + "--");
							} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
								modulboat.setModulid(currentCell.getNumericCellValue());
								System.out.print(currentCell.getNumericCellValue() + "--");
							} else if (currentCell.getCellTypeEnum() == CellType.BLANK) {
								System.out.print("VIDE--");
							} else if (currentCell.getCellTypeEnum() == CellType.FORMULA) {
								System.out.print("FORMULE--");
							} 
						}
	
						//modul_fournisseur
						if (currentCell.getColumnIndex() ==1) {
							if (currentCell.getCellTypeEnum() == CellType.STRING) {
								System.out.print(currentCell.getStringCellValue() + "--");
								modulboat.setModul_fournisseur(currentCell.getStringCellValue());
							} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
								
								System.out.print(currentCell.getNumericCellValue() + "--");
							} else if (currentCell.getCellTypeEnum() == CellType.BLANK) {
								System.out.print("VIDE--");
							} else if (currentCell.getCellTypeEnum() == CellType.FORMULA) {
								System.out.print("FORMULE--");
							} 
						}						
						
						//modullabel
						if (currentCell.getColumnIndex() ==2) {
							if (currentCell.getCellTypeEnum() == CellType.STRING) {
								System.out.print(currentCell.getStringCellValue() + "--");
								modulboat.setModullabel(currentCell.getStringCellValue());
							} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
								
								System.out.print(currentCell.getNumericCellValue() + "--");
							} else if (currentCell.getCellTypeEnum() == CellType.BLANK) {
								System.out.print("VIDE--");
							} else if (currentCell.getCellTypeEnum() == CellType.FORMULA) {
								System.out.print("FORMULE--");
							} 
						}
						
						//modulboat
						if (currentCell.getColumnIndex() ==3) {
							if (currentCell.getCellTypeEnum() == CellType.STRING) {
								System.out.print(currentCell.getStringCellValue() + "--");
								modulboat.setModulboat(currentCell.getStringCellValue());
							} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
								System.out.print(currentCell.getNumericCellValue() + "--");
							} else if (currentCell.getCellTypeEnum() == CellType.BLANK) {
								System.out.print("VIDE--");
							} else if (currentCell.getCellTypeEnum() == CellType.FORMULA) {
								System.out.print("FORMULE--");
							} 
						}
					
						
						//modulpricesingle
						if (currentCell.getColumnIndex() ==4) {
							if (currentCell.getCellTypeEnum() == CellType.STRING) {
								System.out.print(currentCell.getStringCellValue() + "--");
								
							} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
								modulboat.setModulpricesingle((float) currentCell.getNumericCellValue());
								System.out.print(currentCell.getNumericCellValue() + "--");
							} else if (currentCell.getCellTypeEnum() == CellType.BLANK) {
								System.out.print("VIDE--");
							} else if (currentCell.getCellTypeEnum() == CellType.FORMULA) {
								System.out.print("FORMULE--");
							} 
						}
						
						//modulpricefamily
						if (currentCell.getColumnIndex() ==5) {
							if (currentCell.getCellTypeEnum() == CellType.STRING) {
								System.out.print(currentCell.getStringCellValue() + "--");
								
							} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
								modulboat.setModulpricefamily((float) currentCell.getNumericCellValue());
								System.out.print(currentCell.getNumericCellValue() + "--");
							} else if (currentCell.getCellTypeEnum() == CellType.BLANK) {
								System.out.print("VIDE--");
							} else if (currentCell.getCellTypeEnum() == CellType.FORMULA) {
								System.out.print("FORMULE--");
							} 
						}	
						
						//modulscope
						if (currentCell.getColumnIndex() ==6) {
							if (currentCell.getCellTypeEnum() == CellType.STRING) {
								System.out.print(currentCell.getStringCellValue() + "--");
								modulboat.setModulscope(currentCell.getStringCellValue());
							} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
								
								System.out.print(currentCell.getNumericCellValue() + "--");
							} else if (currentCell.getCellTypeEnum() == CellType.BLANK) {
								System.out.print("VIDE--");
							} else if (currentCell.getCellTypeEnum() == CellType.FORMULA) {
								System.out.print("FORMULE--");
							} 
						}	
						
						//modulecategory
						if (currentCell.getColumnIndex() ==7) {
							if (currentCell.getCellTypeEnum() == CellType.STRING) {
								System.out.print(currentCell.getStringCellValue() + "--");
								modulboat.setModulecategory(currentCell.getStringCellValue());
							} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
								
								System.out.print(currentCell.getNumericCellValue() + "--");
							} else if (currentCell.getCellTypeEnum() == CellType.BLANK) {
								System.out.print("VIDE--");
							} else if (currentCell.getCellTypeEnum() == CellType.FORMULA) {
								System.out.print("FORMULE--");
							} 
						}


						

						
						
						//forfaitpercentage
						if (currentCell.getColumnIndex() ==8) {
							if (currentCell.getCellTypeEnum() == CellType.STRING) {
								System.out.print(currentCell.getStringCellValue() + "--");
								
							} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
								modulboat.setForfaitpercentage(currentCell.getNumericCellValue());
								System.out.print(currentCell.getNumericCellValue() + "--");
							} else if (currentCell.getCellTypeEnum() == CellType.BLANK) {
								System.out.print("VIDE--");
							} else if (currentCell.getCellTypeEnum() == CellType.FORMULA) {
								System.out.print("FORMULE--");
							} 
						}	
						
						//,"calculmode","bankfee","surcom"
						if (currentCell.getColumnIndex() ==9) {
							if (currentCell.getCellTypeEnum() == CellType.STRING) {
								System.out.print(currentCell.getStringCellValue() + "--");
								modulboat.setCalculmode(currentCell.getStringCellValue());
							} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
								
								System.out.print(currentCell.getNumericCellValue() + "--");
							} else if (currentCell.getCellTypeEnum() == CellType.BLANK) {
								System.out.print("VIDE--");
							} else if (currentCell.getCellTypeEnum() == CellType.FORMULA) {
								System.out.print("FORMULE--");
							} 
						}		

				
						
						//"bankfee"
						if (currentCell.getColumnIndex() ==10) {
							if (currentCell.getCellTypeEnum() == CellType.STRING) {
								System.out.print(currentCell.getStringCellValue() + "--");
								modulboat.setCalculmode(currentCell.getStringCellValue());
							} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
								modulboat.setBankfee(Float.parseFloat(currentCell.getStringCellValue()));
								
								System.out.print(currentCell.getNumericCellValue() + "--");
							} else if (currentCell.getCellTypeEnum() == CellType.BLANK) {
								System.out.print("VIDE--");
							} else if (currentCell.getCellTypeEnum() == CellType.FORMULA) {
								System.out.print("FORMULE--");
							} 
						}	
						
						//"surcom"
						if (currentCell.getColumnIndex() ==11) {
							if (currentCell.getCellTypeEnum() == CellType.STRING) {
								System.out.print(currentCell.getStringCellValue() + "--");
								modulboat.setCalculmode(currentCell.getStringCellValue());
							} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
								modulboat.setSurcom(Float.parseFloat(currentCell.getStringCellValue()));
								
								System.out.print(currentCell.getNumericCellValue() + "--");
							} else if (currentCell.getCellTypeEnum() == CellType.BLANK) {
								System.out.print("VIDE--");
							} else if (currentCell.getCellTypeEnum() == CellType.FORMULA) {
								System.out.print("FORMULE--");
							} 
						}	
						
						//"invoiceperiod"
						if (currentCell.getColumnIndex() ==12) {
							if (currentCell.getCellTypeEnum() == CellType.STRING) {
								System.out.print(currentCell.getStringCellValue() + "--");
								modulboat.setInvoiceperiod(currentCell.getStringCellValue());
							} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
								
								
								System.out.print(currentCell.getNumericCellValue() + "--");
							} else if (currentCell.getCellTypeEnum() == CellType.BLANK) {
								System.out.print("VIDE--");
							} else if (currentCell.getCellTypeEnum() == CellType.FORMULA) {
								System.out.print("FORMULE--");
							} 
						}							
								
						//"policynumber"
						if (currentCell.getColumnIndex() ==13) {
							if (currentCell.getCellTypeEnum() == CellType.STRING) {
								System.out.print(currentCell.getStringCellValue() + "--");
							} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
							
								
								System.out.print(currentCell.getNumericCellValue() + "--");
							} else if (currentCell.getCellTypeEnum() == CellType.BLANK) {
								System.out.print("VIDE--");
							} else if (currentCell.getCellTypeEnum() == CellType.FORMULA) {
								System.out.print("FORMULE--");
							} 
						}												
						
/*						Method fieldGetter = null;

						try {
							fieldGetter = modulboat.getClass().getMethod("set"+header[counterrow]);
						} catch (NoSuchMethodException | SecurityException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						String fCompany="";
						try {
							if (fieldGetter.invoke(modulboat) != null) {

								fieldGetter.invoke(modulboat,currentCell.getNumericCellValue()).toString();
							}
						} catch (IllegalAccessException | IllegalArgumentException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}*/
						
						
						
					} 
					 lasession.merge(modulboat);
				}
            	
            }
			  lasession.flush();
			  lasession.getTransaction().commit(); 
			  lasession.close();
            out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}//readxlsFileToList

	public void writexlsFileToList(File xlsfiletoread,List<ModulBoat> listmodulboat){	
		SXSSFWorkbook newworkbook = new SXSSFWorkbook(2);
		SXSSFSheet spreadsheet = newworkbook.createSheet("List of module");
		int counterrow=0;
		SXSSFCell cell = null;
		SXSSFRow row = null;
		int nbfield = ModulBoat.class.getDeclaredFields().length;
		String[] header = new String[]{"MODUL ID","MODUL FOURNISSEUR","MODUL LABEL","MODULE CATEGORY","MODUL BOAT","MODUL PRICE SINGLE","MODUL PRICE FAMILY","FORFAIT PERCENTAGE","MODUL SCOPE","INVOICE PERIOD","CALCUL MODE","BANK FEE","SUR COM","POLICY NUMBER","AGGREGATE AMOUNT"};
		
		 row = spreadsheet.createRow(counterrow);
		for (int ifield=0;ifield<nbfield;ifield++){
					cell= row.createCell(ifield);
					cell.setCellValue(header[ifield]);
			}
		counterrow++;
		for (ModulBoat mymodulboat : listmodulboat){
			 row = spreadsheet.createRow(counterrow);
			 int ifield=0;
			 

			cell= row.createCell(ifield);
			cell.setCellValue(mymodulboat.getModulid());
			
			ifield++;
			cell= row.createCell(ifield);
			cell.setCellValue(mymodulboat.getModul_fournisseur());
			
			
			ifield++;
			cell= row.createCell(ifield);
			if (mymodulboat.getModullabel()!=null) {
				cell.setCellValue(mymodulboat.getModullabel());
			}
			
			ifield++;
			cell= row.createCell(ifield);
			cell.setCellValue(mymodulboat.getModulboat());
			
			ifield++;
			cell= row.createCell(ifield);
			if (mymodulboat.getModulecategory()!=null) {
				cell.setCellValue(mymodulboat.getModulecategory());
			}
			ifield++;
			cell= row.createCell(ifield);
			if (mymodulboat.getModulpricesingle()!=null) {
				cell.setCellValue(mymodulboat.getModulpricesingle());
			}
			ifield++;
			cell= row.createCell(ifield);
			if (mymodulboat.getModulpricefamily()!=null) {
				cell.setCellValue(mymodulboat.getModulpricefamily());
			}
			ifield++;
			cell= row.createCell(ifield);
			if (mymodulboat.getForfaitpercentage()!=null) {
				cell.setCellValue(mymodulboat.getForfaitpercentage());
			}
			ifield++;
			cell= row.createCell(ifield);
			if (mymodulboat.getModulscope()!=null) {
				cell.setCellValue(mymodulboat.getModulscope());
			}
			ifield++;
			cell= row.createCell(ifield);
			
			if (mymodulboat.getInvoiceperiod()!=null) {
				cell.setCellValue(mymodulboat.getInvoiceperiod());
			}
			ifield++;
			cell= row.createCell(ifield);
			if (mymodulboat.getCalculmode()!=null) {
				cell.setCellValue(mymodulboat.getCalculmode());
			}
			ifield++;
			cell= row.createCell(ifield);
			if (mymodulboat.getBankfee()!=null) {
				cell.setCellValue(mymodulboat.getBankfee());
			}
			ifield++;
			cell= row.createCell(ifield);
			if (mymodulboat.getSurcom()!=null) {
				cell.setCellValue(mymodulboat.getSurcom());
			}
			ifield++;
			cell= row.createCell(ifield);
			if (mymodulboat.getPolicynumber()!=null) {
				cell.setCellValue(mymodulboat.getPolicynumber());
			}	
			ifield++;
			cell= row.createCell(ifield);
			if (mymodulboat.getAggregateamount()!=null) {
				cell.setCellValue(mymodulboat.getAggregateamount());
			}
			//}
			counterrow++;
			
		}
		
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(xlsfiletoread);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			newworkbook.write(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newworkbook.dispose();
		
	}
	public void xlsfileGetRow(XSSFSheet sheet, int fromrow){
		XSSFRow row = sheet.getRow(fromrow);
		int lastCell = row.getLastCellNum();
	}//xlsfileGetRow
	
	public void xlsfileGetCell(XSSFRow row, int cellcounter ){
		Cell cell = row.getCell(cellcounter);
		
	}

	public void getFileXlstoImp(String mode){
			File directory = new File(".");
			String fileCharSep = System.getProperty("file.separator");

		
			Shell shell = new Shell();
			FileDialog fd =null;
			if (mode.equals("open")) {
				 fd = new FileDialog(shell, SWT.OPEN);
			}
			else if (mode.equals("save")) {
				 fd = new FileDialog(shell, SWT.SAVE);
			}
				
			fd.setText("Choose a file");
			try {
				fd.setFilterPath(directory.getCanonicalPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String[] filterExt = { "*.xlsx" };
			fd.setFilterExtensions(filterExt);
			String selected = fd.open();
			if (selected != null) {
				this.setFiletoprocess(selected);
			} 
				
	}


}
