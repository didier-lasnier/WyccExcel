package com.poi.actionuser;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.logging.log4j.*;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Shell;

import com.dlas.dao.MvtCsv;
import com.dlas.dao.beneficiaries;
import com.dlas.dao.H2db;
import com.dlas.dao.HsqlText;
import com.dlas.tools.CsvTools;
//import com.dlas.tools.CsvTools.ProgressBarDb;
import com.dlas.dao.LimitAggCsv;
import com.poi.dlas.WyccWorkbook;
import com.poi.dlas.managecsv;

public class Actionuser {
	static Logger logger = LogManager.getLogger("wycc");
	
	private PreparedStatement prepStmt;
	
	public PreparedStatement getPrepStmt() {
		return prepStmt;
	}

	public void setPrepStmt(PreparedStatement prepStmt) {
		this.prepStmt = prepStmt;
	}

	public void actionuser() {

	}

	public  void lanceLecture(String dir,String Filepath,DateTime StartD,DateTime EndD ) throws Exception {


			Shell shell = new Shell();
			IRunnableWithProgress op = new ProcessCsv("Database initialisation",new H2db(), dir,Filepath, StartD, EndD);
			
			new ProgressMonitorDialog(shell).run(false, true, op);
			
			shell.close();
			
			Shell shell1 = new Shell();
			MessageDialog.openInformation(shell1, "Info", "DONE ! \r The csv file "+Filepath +" is completely processed");
			shell1.close();


	}

	
	
	public void lireCSV(File theCSVfile, H2db dbconn,IProgressMonitor monitor) throws Exception {

		// Workbook wb;

		if (theCSVfile != null) {

//			hsqltext sqlstmt = new hsqltext();
//			PreparedStatement prepStmt = dbconn.connectiondb.prepareStatement(sqlstmt.insertmvt());
//			Shell shell = new Shell();
//			IRunnableWithProgress op = new ProgressBarDb("Database initialisation",dbconn, this);
//			
//			new ProgressMonitorDialog(shell).run(true, true, op);
//						shell.close();
			HsqlText sqlstmt = new HsqlText();
			

			this.setPrepStmt( dbconn.connectiondb.prepareStatement(sqlstmt.insertmvt()));
			logger.info("Select file csv : " + theCSVfile.getAbsolutePath());
			CsvTools csfile = new CsvTools();
			csfile.readcsvfile(this.getPrepStmt(), theCSVfile.getAbsolutePath(),monitor);
			this.getPrepStmt().close();
		}
		
	}

	public List readAggregate(List<MvtCsv> list){
		 List<LimitAggCsv> listagg=new ArrayList<>();
		 List<LimitAggCsv> listaggDistinct=null;
		 List<LimitAggCsv> listnotnull=null;
		 // on construit la liste  des plan
		 
		String[] nextLine;
		int i = 5;
		MvtCsv recordmodule = null;
		for (MvtCsv object : list) {
			if (i == 5) {
				recordmodule = object;
			} else if (i >= 7) {
				listagg.add(new LimitAggCsv(object.getCompany1(),object.getFormula1(),recordmodule.getCompany1(),object.getPolicynumber1(),0f));	
				listagg.add(new LimitAggCsv(object.getCompany2(),object.getFormula2(),recordmodule.getCompany2(),object.getPolicynumber2(),0f));
				listagg.add(new LimitAggCsv(object.getCompany3(),object.getFormula3(),recordmodule.getCompany3(),object.getPolicynumber3(),0f));
				listagg.add(new LimitAggCsv(object.getCompany4(),object.getFormula4(),recordmodule.getCompany4(),object.getPolicynumber4(),0f));
				listagg.add(new LimitAggCsv(object.getCompany5(),object.getFormula5(),recordmodule.getCompany5(),object.getPolicynumber5(),0f));
				listagg.add(new LimitAggCsv(object.getCompany6(),object.getFormula(),recordmodule.getCompany6(),object.getPolicynumber6(),0f));
				listagg.add(new LimitAggCsv(object.getCompany7(),object.getFormula7(),recordmodule.getCompany7(),object.getPolicynumber7(),0f));
				listagg.add(new LimitAggCsv(object.getCompany8(),object.getFormula8(),recordmodule.getCompany8(),object.getPolicynumber8(),0f));
			
			}
			i++;
		}
		// Get distinct only
        listaggDistinct = listagg.stream().distinct().collect(Collectors.toList());
        listnotnull = listaggDistinct.stream().filter(c -> c.getCompany()!= null && !c.getCompany().equals("") ).collect(Collectors.toList());

		
		return listnotnull;
	}
	
	public List readAggregate(List<MvtCsv> list,IProgressMonitor monitor ){
		 List<LimitAggCsv> listagg=new ArrayList<>();
		 List<LimitAggCsv> listaggDistinct=null;
		 List<LimitAggCsv> listnotnull=null;
		 // on construit la liste  des plan
		 
		String[] nextLine;
		int i = 5;
		MvtCsv recordmodule = null;
		for (MvtCsv object : list) {
			if (i == 5) {
				recordmodule = object;
			} else if (i >= 7) {
				monitor.setTaskName("Processing csv file.");
				monitor.subTask("Process line n# :  "+i);
				monitor.worked(1);
				
				listagg.add(new LimitAggCsv(object.getCompany1(),object.getFormula1(),recordmodule.getCompany1(),object.getPolicynumber1(),0f));	
				listagg.add(new LimitAggCsv(object.getCompany2(),object.getFormula2(),recordmodule.getCompany2(),object.getPolicynumber2(),0f));
				listagg.add(new LimitAggCsv(object.getCompany3(),object.getFormula3(),recordmodule.getCompany3(),object.getPolicynumber3(),0f));
				listagg.add(new LimitAggCsv(object.getCompany4(),object.getFormula4(),recordmodule.getCompany4(),object.getPolicynumber4(),0f));
				listagg.add(new LimitAggCsv(object.getCompany5(),object.getFormula5(),recordmodule.getCompany5(),object.getPolicynumber5(),0f));
				listagg.add(new LimitAggCsv(object.getCompany6(),object.getFormula(),recordmodule.getCompany6(),object.getPolicynumber6(),0f));
				listagg.add(new LimitAggCsv(object.getCompany7(),object.getFormula7(),recordmodule.getCompany7(),object.getPolicynumber7(),0f));
				listagg.add(new LimitAggCsv(object.getCompany8(),object.getFormula8(),recordmodule.getCompany8(),object.getPolicynumber8(),0f));
			
			}
			i++;
		}
		// Get distinct only
       listaggDistinct = listagg.stream().distinct().collect(Collectors.toList());
       listnotnull = listaggDistinct.stream().filter(c -> c.getCompany()!= null && !c.getCompany().equals("") ).collect(Collectors.toList());

		
		return listnotnull;
	}

	
	public void readcsvheader(List<MvtCsv> list) throws IOException, SQLException {
		// Build reader instance
		// Read data.csv
		// Default seperator is comma
		// Default quote character is double quote
		// Start reading from line number 2 (line numbers start from zero)
		

		String[] nextLine;
		int i = 5;
		MvtCsv recordmodule = null;
		for (MvtCsv object : list) {
			if (i == 5) {
				recordmodule = object;
			} else if (i >= 7) {


			}

			i++;
		}

	}

	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) 
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
	
	
	public  class ProgressBarDb implements IRunnableWithProgress {
		 private String       message;
		 private H2db         dbconn;
		 private Actionuser   actionuser;
		 
		 
		public ProgressBarDb(String message,H2db dbconn, Actionuser actionuser){
		
           this.message      = message;
           this.dbconn       = dbconn;
           this.actionuser   = actionuser;
        
          
		}
		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				
			    monitor.beginTask(message, IProgressMonitor.UNKNOWN);
			    monitor.worked(1);
				HsqlText sqlstmt = new HsqlText();
				
			  try {
				  actionuser.setPrepStmt( dbconn.connectiondb.prepareStatement(sqlstmt.insertmvt()));
				  monitor.worked(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			 monitor.done();
		}
		
	}

	
	public  class ProcessCsv implements IRunnableWithProgress {
		 private String       message;
		 private H2db         dbconn;
		 private String       filepath;
		 private DateTime     startD;
		 private DateTime     endD;
		 private String       dir;
		 
		 
		public ProcessCsv(String message,H2db dbconn,String dir,String Filepath,DateTime StartD,DateTime EndD){
		
          this.message      = message ;
          this.dbconn       = dbconn  ;
          this.filepath     = Filepath;
          this.startD       = StartD  ;
          this.endD         = EndD    ;
          this.dir          = dir     ;
       
         
		}
		
		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				
				monitor.beginTask(message, IProgressMonitor.UNKNOWN);
			    monitor.worked(1);
			    
		            File theOpenfile=new File(filepath);
		            File directory  =new File(dir);
		          	String fileCharSep = System.getProperty("file.separator");
		            managecsv csvdata = new managecsv();
		            
		            
		            Calendar instance = Calendar.getInstance();
					instance.set(Calendar.DAY_OF_MONTH, startD.getDay());
					instance.set(Calendar.MONTH, startD.getMonth());
					instance.set(Calendar.YEAR, startD.getYear());
					String StartDateStr  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(instance.getTime());
					
					instance = Calendar.getInstance();
					instance.set(Calendar.DAY_OF_MONTH, endD.getDay());
					instance.set(Calendar.MONTH, endD.getMonth());
					instance.set(Calendar.YEAR, endD.getYear());
					String EndDateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(instance.getTime());
					
					// on sauvegarde la lecture du csv dans un fichier temporaire
					File theSavefile;
					
					if (false) {
						// read file csv
						theOpenfile.getParent();
						logger.info("read file csv");
						List<String[]> csvrows = csvdata.getRowsFromFile(theOpenfile);
						System.out.print(dir + "tmp");
						theSavefile = null;
						try {
							theSavefile = File.createTempFile("tmp", null, new File(dir + "tmp"));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						String file = theSavefile.getAbsolutePath();
						logger.info("theSavefile Done : " + file);
						csvdata.setRowToFile(csvrows, theSavefile);
					}
					// Write the output to a file
					theSavefile=this.saveIntempFile (  theOpenfile, csvdata);
					
					H2db db = null;
					try {
						db = new H2db();
					} catch (SQLException e1) {
						logger.error(e1);
						e1.printStackTrace();
					}
					
					
					try {
						db.getDatabase(directory);
					} catch (IOException e1) {
						logger.error(e1);
						e1.printStackTrace();
					}
					
					HsqlText sqlstmt = new HsqlText();
					// Statement stmt = db.connectiondb.createStatement();
					PreparedStatement stmt = null;
					try {
						stmt = db.connectiondb.prepareStatement("DELETE FROM MVT");
					} catch (SQLException e1) {
						logger.error(e1);
						e1.printStackTrace();
					}
					logger.info("delete from mvt");
					try {
						stmt.executeUpdate();
					} catch (SQLException e1) {
						logger.error(e1);
						e1.printStackTrace();
					}
					try {
						stmt.close();
					} catch (SQLException e1) {
						logger.error(e1);
						e1.printStackTrace();
					}		
					
					logger.info("read csv file into from mvt");
					
					try {
						lireCSV(theOpenfile, db,monitor);
					} catch (Exception e1) {
						logger.error(e1);
						e1.printStackTrace();
					}
					
					try {
						stmt = db.connectiondb.prepareStatement("DELETE FROM MVT_NUM");
					} catch (SQLException e1) {
						logger.error(e1);
						e1.printStackTrace();
					} // db.connectiondb.createStatement();
					logger.info("delete from mvt_num");
					try {
						stmt.executeUpdate();
					} catch (SQLException e1) {
						logger.error(e1);
						e1.printStackTrace();
					}
					try {
						stmt.close();
					} catch (SQLException e1) {
						logger.error(e1);
						e1.printStackTrace();
					}

					// stmt = db.connectiondb.createStatement();
					try {
						stmt = db.connectiondb.prepareStatement(sqlstmt.insertmvtnum());
					} catch (SQLException e1) {
					    logger.error(e1);
						e1.printStackTrace();
					}
					logger.info("read csv file into from mvt");
				
					try {
						stmt.executeUpdate();// , null, 'charset=UTF-8 fieldSeparator=;')");
					} catch (Exception e) {
						logger.info(sqlstmt.insertmvtnum());
						e.printStackTrace();
					}
					try {
						stmt.close();
					} catch (SQLException e) {
						logger.error(e);
						e.printStackTrace();
					}

					// stmt = db.connectiondb.createStatement();
					try {
						stmt = db.connectiondb.prepareStatement("DELETE FROM PUBLIC.LISTMVTHIER");
					} catch (SQLException e) {
						logger.error(e);
						e.printStackTrace();
					}
					logger.info("delete from lismvthier");
					try {
						stmt.executeUpdate();
					} catch (SQLException e) {
						logger.error(e);
						e.printStackTrace();
					}
					try {
						stmt.close();
					} catch (SQLException e) {
						logger.error(e);
						e.printStackTrace();
					}

					PreparedStatement prepStmt = null;
					try {
						prepStmt = db.connectiondb.prepareStatement(sqlstmt.insertRootListMvthier(StartDateStr,EndDateStr));
					} catch (SQLException e) {
						logger.error(e);
						e.printStackTrace();
					}
					logger.info("insert from lismvthier");
					try {
						prepStmt.executeUpdate();
					} catch (SQLException e) {
						logger.error(e);
						e.printStackTrace();
					}
					try {
						prepStmt.close();
					} catch (SQLException e) {
						logger.error(e);
						e.printStackTrace();
					}
					int numberOfRows = 0;
					int lvl = 1;
					do {

						try {
							prepStmt = db.connectiondb.prepareStatement(sqlstmt.isLevelNListMvthier());
						} catch (SQLException e) {
							logger.error(e);
							e.printStackTrace();
						}
						try {
							prepStmt.setInt(1, lvl);
						} catch (SQLException e) {
							logger.error(e);
							e.printStackTrace();
						}
						ResultSet rs = null;
						try {
							rs = prepStmt.executeQuery();
						} catch (SQLException e) {
							logger.error(e);
							e.printStackTrace();
						}
						try {
							if (rs.next()) {
								numberOfRows = rs.getInt(1);
								prepStmt.close();
								if (numberOfRows > 0) {
									prepStmt = db.connectiondb.prepareStatement(sqlstmt.insertLevelNListMvthier(StartDateStr,EndDateStr));
									prepStmt.setInt(1, lvl + 1);
									prepStmt.setInt(2, lvl);
									prepStmt.executeUpdate();
									prepStmt.close();
								}
							} else {
								prepStmt.close();
								System.out.println("error: could not get the record counts");
							}
						} catch (SQLException e) {
							logger.error(e);
							e.printStackTrace();
						}
						lvl++;
					} while (numberOfRows != 0);

					try {
						stmt = db.connectiondb.prepareStatement("DELETE FROM BENEFICIARIES_TAB");
					} catch (SQLException e) {
						logger.error(e);
						e.printStackTrace();
					}
					logger.info("delete from beneficiaire");
					try {
						stmt.executeUpdate();
					} catch (SQLException e) {
						logger.error(e);
						e.printStackTrace();
					}
					try {
						stmt.close();
					} catch (SQLException e) {
						logger.error(e);
						e.printStackTrace();
					}

					try {
						stmt = db.connectiondb.prepareStatement(sqlstmt.insertbeneficiairies());
					} catch (SQLException e) {
						logger.error(e);
						e.printStackTrace();
					}
					logger.info("Insert Beneficiaries");
					try {
						stmt.executeUpdate();
					} catch (SQLException e) {
						logger.error(e);
						e.printStackTrace();
					}// , null, 'charset=UTF-8 fieldSeparator=;')");
					try {
						stmt.close();
					} catch (SQLException e) {
						logger.error(e);
						e.printStackTrace();
					}
					
					try {
						db.closeDbConnection(db.connectiondb);
					} catch (SQLException e) {
						logger.error(e);
						e.printStackTrace();
					}
					theSavefile.deleteOnExit();
					logger.info("DONE !");
					monitor.done();
			}
			
		private File saveIntempFile ( File theOpenfile,managecsv csvdata){
			// read file csv
            theOpenfile.getParent();

			logger.info("read file csv");
			List<String[]> csvrows = csvdata.getRowsFromFile(theOpenfile);
			System.out.print(dir + "tmp"); 
			
			// on sauvegarde la lecture du csv dans un fichier temporaire
			File theSavefile = null;
			try {
				theSavefile = File.createTempFile("tmp", null,
						new File(dir +  "tmp"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			String file = theSavefile.getAbsolutePath();
			logger.info("theSavefile Done : " + file);
			csvdata.setRowToFile(csvrows, theSavefile);
			return  theSavefile;
			}
		}
}

