package com.dlas.gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.concurrent.BlockingQueue;
import org.apache.logging.log4j.*;

import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hsqldb.server.Server;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;

import com.dlas.dao.ObjectDao;
import com.dlas.dao.beneficiaries;
import com.apple.eawt.AboutHandler;
import com.apple.eawt.AppEvent.AboutEvent;
import com.apple.eawt.Application;
import com.apple.mrj.MRJApplicationUtils;
import com.dlas.dao.BenefitDb;
import com.dlas.dao.H2db;
import com.dlas.gui.accueil.MacOSXControllerAbout;
import com.dlas.gui.accueil.MacOSXControllerPrefs;
import com.dlas.gui.accueil.MacOSXControllerQuit;
import com.dlas.gui.accueil.MenuAccueil;
import com.dlas.gui.accueil.MenuMsg;

import com.dlas.gui.model.Benefit;
import com.dlas.gui.model.Companies;
import com.dlas.windowmanager.WindowsManager;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.poi.actionuser.Actionuser;
import com.poi.actionuser.ReadCSVFile;
import com.poi.actionuser.ReadFileXlsx;
import com.poi.actionuser.Actionuser.ProcessCsv;
import com.dlas.gui.model.Benefits;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.wb.swt.SWTResourceManager;
import com.dlas.tools.ThreadUtilities;

//

public class EcranAccueil {
	
	private EcranAccueil window = this;
	private Button deleteCompanyButton;
	private Button AggregateButton;
	private Button SaveButton;
	private Table table_1;
	private Button editCompanyButton;
	private TableViewer m_benefitsViewer;
	private TableViewer m_companyViewer;
	private Companies m_companies = new Companies();
	private Benefits m_benefits = new Benefits();
	private Text m_amountText;
	private Text m_policynumberText;
	private Text m_formulenameText;
	private Text m_formulaText;
	private Text m_companyText;
	private Table table;
	protected static Shell shell;
	private Button newBenefitsButton;
	private Button deleteBenefitsButton;
	private DataBindingContext m_bindingContext;
	
	private DateTime startdate;
	private DateTime enddate;
	private String filepathtxt;
	private String filepath;
	private static String appDir;
	private List listCsv;
	private static String APP_NAME = "Wycc invoice";
	
	static JProgressBar barDo;
	
	static Display d;
	Shell s;
	static BlockingQueue<MenuMsg> queue;
	
//	public EcranAccueil() {
//		// TODO Auto-generated constructor stub
//	}
	
	public List getListCsv() {
		return listCsv;
	}


	public void setListCsv(List listCsv) {
		this.listCsv = listCsv;
	}
	
	
	
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	Logger logger = LogManager.getLogger("wycc");
	
	
	//public static void main(String[] args) {
	public EcranAccueil(Display display ) {
		
		MacOSXControllerAbout macControllerahout = new MacOSXControllerAbout();
		MacOSXControllerPrefs macControllerprefs = new MacOSXControllerPrefs();
		MacOSXControllerQuit macControllerquit = new MacOSXControllerQuit();
		
		 Application macApplication = Application.getApplication();
		 
		/*
		 *  On détermine le dossier d'execution du jar
		 * 
		 */
		URL url = EcranAccueil.class.getProtectionDomain().getCodeSource().getLocation(); //Gets the path
	  	String jarPath = null;
			try {
				jarPath = URLDecoder.decode(url.getFile(), "UTF-8"); //Should fix it to be read correctly by the system
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			appDir = new File(jarPath).getParentFile().getPath(); //Path of the jar
			appDir=appDir+ File.separator;

		 // ======================================================
	     // Create appender for log4j
	     // ======================================================
		    String log4jConfigFile = appDir   +"config"+ File.separator + "log4j.properties";
	 
        
		
	     // ======================================================
	     // Create the main Display object that represents the UI
	     // subsystem and contains the single UI handling thread
	     // ======================================================
	    

		d=display;
		 // ====================================================
	     // create a shell for the main window from the Display
	     // ====================================================
	    shell = new Shell(display, SWT.CLOSE);
	     // =====================
	     // Set the Window Title
	     // =====================
	     shell.setText("Main Shell");

		 String osName = System.getProperty("os.name").toLowerCase();
		 boolean isMacOs = osName.startsWith("mac os x");
		if (isMacOs)
		{
		
		  MRJApplicationUtils.registerAboutHandler(macControllerahout);
		  MRJApplicationUtils.registerPrefsHandler(macControllerprefs);
		  MRJApplicationUtils.registerQuitHandler(macControllerquit);
		  
		}
		macControllerquit.setD(d);
		macControllerquit.setS(shell);

	     
	     
		 shell.setBackground(SWTResourceManager.getColor(255, 255, 255));
		 shell.setSize(638, 382);

		//Menu menusy=display.getSystemMenu();
     	Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
     		
     		//d.asyncExec( new Runnable() {
			@Override
			public void run() {
				try {
					window.open();
					logger.info("Fermeture de l'écran accueil");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	class Open implements SelectionListener {
			
		@Override
		public void widgetSelected(SelectionEvent event) {
			widgetOpen(startdate,enddate);
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent event) {
		}
		
		public void widgetSelectedBtn(SelectionEvent event) {
			widgetOpen(startdate,enddate);
		}
		public void widgetOpen(DateTime StartD, DateTime EndD){
			File directory = new File(".");
			String fileCharSep = System.getProperty("file.separator");
			
			try {
				FileDialog fd = new FileDialog(shell, SWT.OPEN);
				fd.setText("Open");
				fd.setFilterPath(directory.getCanonicalPath());
				String[] filterExt = { "*.csv","*.txt" };
				fd.setFilterExtensions(filterExt);
				String selected = fd.open();
				
			if (selected !=null) {
				
				Actionuser a = new Actionuser();
				a.lanceLecture(appDir,selected, StartD, EndD);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	class Save implements SelectionListener {
		@Override
		public void widgetSelected(SelectionEvent event) {
			widgetSave();
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent event) {
		}
		
		public void widgetSelectedBtn(SelectionEvent event) {
			widgetSave();
		}

		public void widgetSave(){
			File directory = new File(".");
			String fileCharSep = System.getProperty("file.separator");
			FileDialog fd = new FileDialog(shell, SWT.SAVE);
			fd.setText("Save");
			try {
				fd.setFilterPath(directory.getCanonicalPath());
				String[] filterExt = { "*.xlsx" };
				fd.setFilterExtensions(filterExt);
				String selected = fd.open();
				
				if (selected !=null){
					ReadFileXlsx a = new ReadFileXlsx();
					try {
						a.generexls(selected, appDir);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	class Read implements SelectionListener {
		@Override
		public void widgetSelected(SelectionEvent event) {
			widgetRead();
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent event) {
		}
		
		public void widgetSelectedBtn(SelectionEvent e) {
			widgetRead();
		}
		public void widgetRead(){
			File directory = new File(".");
			String fileCharSep = System.getProperty("file.separator");
			try {
			FileDialog fd = new FileDialog(shell, SWT.OPEN);
			fd.setText("Choose a file");
			fd.setFilterPath(directory.getCanonicalPath());
			String[] filterExt = { "*.xlsx"};
			fd.setFilterExtensions(filterExt);
			String selected = fd.open();
			if (selected !=null) {
				ReadFileXlsx a = new ReadFileXlsx();
				try {
					a.readxls(selected,appDir);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void open() {
		final Display display = d; 	

		createContents();
		MenuAccueil menuaccueil=new MenuAccueil(shell,display,startdate,enddate,appDir);
		Display.setAppName(APP_NAME);
		shell.open();
		shell.layout();	
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
			    
		}
		display.dispose();
		logger.info("Le shell est fermé");
		logger.debug("Le shell est fermé");
		
		 Thread[] lesThreads=ThreadUtilities.getAllThreads();
		 for (Thread thread: lesThreads){
			
			 ThreadUtilities.getThreadInfo(thread).getLockName();
			 ThreadUtilities.getThreadInfo(thread).getThreadState().name();
			 logger.debug("Thread name :"+ThreadUtilities.getThreadInfo(thread).getThreadName());
			 logger.debug("Thread status :"+ThreadUtilities.getThreadInfo(thread).getThreadState().name());
			 logger.debug("Lock name :"+ThreadUtilities.getThreadInfo(thread).getLockName() );
			 //thread.stop();
		 }

	}	
	
	public String chooseFile(Shell s) throws IOException {
		
		
		File directory = new File(".");
		String fileCharSep = System.getProperty("file.separator");
		FileDialog fd = new FileDialog(s, SWT.OPEN);
		fd.setText("Choose a file");
		fd.setFilterPath(directory.getCanonicalPath());
		String[] filterExt = { "*.csv"};
		fd.setFilterExtensions(filterExt);
		String selected=fd.open();
		
		return selected;
	}	
	protected void createContents() {
		shell.setLayout(new FillLayout());
		shell.setSize(789, 517);
		shell.setText("Wycc Invoice");
		
		// on initilaise les dates
		//startdate.
		final SashForm sashForm = new SashForm(shell, SWT.VERTICAL);
		sashForm.setBackground(SWTResourceManager.getColor(255, 255, 255));

		//
		final Composite companyComposite = new Composite(sashForm, SWT.BORDER | SWT.NO_FOCUS);
		companyComposite.setBackground(SWTResourceManager.getColor(255, 255, 255));
		companyComposite.setFont(SWTResourceManager.getFont("Arial Narrow", 11, SWT.NORMAL));
		final GridLayout gridLayout = new GridLayout();
		gridLayout.marginWidth = 10;
		gridLayout.verticalSpacing = 0;
		gridLayout.marginHeight = 0;
		companyComposite.setLayout(gridLayout);
		
		final Composite companyToolBarComposite = new Composite(companyComposite, SWT.NONE);
		companyToolBarComposite.setBackground(SWTResourceManager.getColor(255, 255, 255));
		final GridLayout gridLayout_3 = new GridLayout(15, false);
		companyToolBarComposite.setLayout(gridLayout_3);
		GridData gd_companyToolBarComposite = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_companyToolBarComposite.widthHint = 779;
		gd_companyToolBarComposite.heightHint = 72;
		companyToolBarComposite.setLayoutData(gd_companyToolBarComposite);
		
		// bouton Aggregate
		AggregateButton = new Button(companyToolBarComposite, SWT.NONE);
		GridData gd_AggregateButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_AggregateButton.widthHint = 117;
		AggregateButton.setLayoutData(gd_AggregateButton);
		AggregateButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					
					try {
						filepath = window.chooseFile(shell);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					if (filepath !=null) {
						Shell shell = new Shell();
						logger.info("Creation du ReadCSVFILE");
						String startdateStr =startdate.toString();
						Timestamp TsStart=getTimestampFromDateTime(startdate);
						Timestamp TsEnd=getTimestampFromDateTime(startdate);

						IRunnableWithProgress op = new ReadCSVFile(window, " reading CSV file !", TsStart, TsEnd,shell, m_benefits, appDir, filepath);
						try {
							new ProgressMonitorDialog(shell).run(true, true, op);
						} catch (InvocationTargetException | InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						shell.close();
					}
					Benefit benefit = new Benefit();
					m_benefitsViewer.setSelection(new StructuredSelection(benefit),true);
					m_bindingContext.updateModels();
					
				}
			});

		AggregateButton.setText("Get aggregate");
		
		Button btnReadCsv = new Button(companyToolBarComposite, SWT.NONE);
		GridData gd_btnReadCsv = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnReadCsv.widthHint = 115;
		btnReadCsv.setLayoutData(gd_btnReadCsv);
		btnReadCsv.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new Open().widgetOpen(startdate,enddate);
			}
		});
		btnReadCsv.setText("Read Csv..");
		
		Button btnReadFormula = new Button(companyToolBarComposite, SWT.NONE );
		btnReadFormula.addSelectionListener(new SelectionAdapter() {
	    @Override
		public void widgetSelected(SelectionEvent e) {
		        		 new Read().widgetRead();
		        	}
		        });
		btnReadFormula.setText("Read xls file...");
		new Label(companyToolBarComposite, SWT.NONE);
		new Label(companyToolBarComposite, SWT.NONE);
		new Label(companyToolBarComposite, SWT.NONE);
        new Label(companyToolBarComposite, SWT.NONE);
        new Label(companyToolBarComposite, SWT.NONE);
		new Label(companyToolBarComposite, SWT.NONE);
		new Label(companyToolBarComposite, SWT.NONE);
		
		Label lblStartDate = new Label(companyToolBarComposite, SWT.NONE);
		GridData gd_lblStartDate = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblStartDate.widthHint = 71;
		lblStartDate.setLayoutData(gd_lblStartDate);
		lblStartDate.setAlignment(SWT.CENTER);
		lblStartDate.setText("Start date");
		new Label(companyToolBarComposite, SWT.NONE);
		new Label(companyToolBarComposite, SWT.NONE);
		new Label(companyToolBarComposite, SWT.NONE);
		Label lblEndDate = new Label(companyToolBarComposite, SWT.NONE);
		GridData gd_lblEndDate = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblEndDate.widthHint = 71;
		lblEndDate.setLayoutData(gd_lblEndDate);
		lblEndDate.setAlignment(SWT.CENTER);
		lblEndDate.setText("End date");
        
		SaveButton = new Button(companyToolBarComposite, SWT.NONE);
		SaveButton.setText("Save aggregate..");
		SaveButton.addSelectionListener(new SelectionAdapter() {
        			@Override
					public void widgetSelected(SelectionEvent e) {
        				// on enregistre les Aggregate
        				
        				List<Benefit> mbenefits =m_benefits.getBenefits();
        				
        				ObjectDao myobj = new ObjectDao();
        				Session lasession = myobj.getSessionDao();

        				 
        				lasession.beginTransaction(); 
        				Query q = lasession.createQuery("from BenefitDb where company=:company and formula=:formula and formulename=:formulename and policynumber=:policynumber");
        				 for ( Benefit m_benefit : mbenefits ){
        					 
        					    q.setString("company", m_benefit.getCompany());
        						q.setString("formula", m_benefit.getFormula());
        						q.setString("formulename", m_benefit.getFormulename());
        						q.setString("policynumber", m_benefit.getPolicynumber());
        						q.setMaxResults(1);
        						BenefitDb benedb = (BenefitDb) q.uniqueResult();
        						if (benedb==null) {
        					       benedb =new BenefitDb();
        					       benedb.setCompany(m_benefit.getCompany());
	               				   benedb.setFormula(m_benefit.getFormula());
	               				   benedb.setFormulename(m_benefit.getFormulename());
	               				   benedb.setPolicynumber(m_benefit.getPolicynumber());
        						 }				
        					benedb.setAmount(m_benefit.getAmount());
        					lasession.saveOrUpdate(benedb);
        				 }		
        				  lasession.flush();
        				  lasession.getTransaction().commit(); 
        				  lasession.close();
    				  	Shell shell1 = new Shell();
    					MessageDialog.openInformation(shell1, "Info", "DONE ! \r Data are saved");
    					shell1.close();
        			}
        		});
        
        Button btnClientAmount = new Button(companyToolBarComposite, SWT.NONE);
        btnClientAmount.addSelectionListener(new SelectionAdapter() {
        	@Override
			public void widgetSelected(SelectionEvent e) {
        		new Save().widgetSave();
        	}
        });
        btnClientAmount.addListener(SWT.Selection, new Listener() {
              @Override
			public void handleEvent(Event event) {
        	        new Save();
        	      }
        	    });

        
        btnClientAmount.setText("Client amount...");
        
        
        new Label(companyToolBarComposite, SWT.NONE);
        new Label(companyToolBarComposite, SWT.NONE);
        new Label(companyToolBarComposite, SWT.NONE);
        new Label(companyToolBarComposite, SWT.NONE);
        new Label(companyToolBarComposite, SWT.NONE);
        new Label(companyToolBarComposite, SWT.NONE);
        new Label(companyToolBarComposite, SWT.NONE);
        new Label(companyToolBarComposite, SWT.NONE);
        
        DateTime StartDate = new DateTime(companyToolBarComposite, SWT.BORDER);
        GridData gd_StartDate = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_StartDate.widthHint = 112;
        

        StartDate.setLayoutData(gd_StartDate);
        StartDate.setBackground(SWTResourceManager.getColor(255, 255, 255));
        StartDate.setDay(1);
        StartDate.setMonth(0);
        //StartDate.setYear(2017);
        startdate=StartDate;
        new Label(companyToolBarComposite, SWT.NONE);
        new Label(companyToolBarComposite, SWT.NONE);
        new Label(companyToolBarComposite, SWT.NONE);
        DateTime EndDate = new DateTime(companyToolBarComposite, SWT.BORDER);
        GridData gd_EndDate = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_EndDate.widthHint = 118;
        EndDate.setLayoutData(gd_EndDate);
        EndDate.setBackground(SWTResourceManager.getColor(255, 255, 255));
        EndDate.setDay(31);
        EndDate.setMonth(11);
        //EndDate.setYear(2017);
        enddate=EndDate;
        
		class Open implements SelectionListener {
			
			@Override
			public void widgetSelected(SelectionEvent event) {
				widgetOpen(startdate,enddate);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent event) {
			}
			
			public void widgetSelectedBtn(SelectionEvent event) {
				widgetOpen(startdate,enddate);
			}
			
			public void widgetOpen(DateTime StartD, DateTime EndD){
				File directory = new File(".");
				String fileCharSep = System.getProperty("file.separator");
				
				try {
					FileDialog fd = new FileDialog(s, SWT.OPEN);
					fd.setText("Open");
					fd.setFilterPath(directory.getCanonicalPath());
					String[] filterExt = { "*.csv","*.txt" };
					fd.setFilterExtensions(filterExt);
					String selected = fd.open();
				if (selected !=null) {
					Actionuser a = new Actionuser();
					
					a.lanceLecture(appDir,selected, StartD, EndD);
					
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		// 
		final SashForm benefitsSashForm = new SashForm(sashForm, SWT.VERTICAL);
		final Composite benefitsComposite = new Composite(benefitsSashForm, SWT.BORDER);
		benefitsComposite.setBackground(SWTResourceManager.getColor(255, 255, 255));
		final GridLayout gridLayout_1 = new GridLayout();
		gridLayout_1.horizontalSpacing = 0;
		gridLayout_1.marginWidth = 10;
		gridLayout_1.verticalSpacing = 0;
		gridLayout_1.marginHeight = 0;
		benefitsComposite.setLayout(gridLayout_1);

		// affichage de la table des benefits
		m_benefitsViewer = new TableViewer(benefitsComposite, SWT.FULL_SELECTION);
		table = m_benefitsViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		// on définie les clonnes et les headres
		
		final TableColumn newColumnTableColumn = new TableColumn(table,SWT.CENTER);
		newColumnTableColumn.setWidth(123);
		newColumnTableColumn.setText("Company");

		final TableColumn newColumnTableColumn_1 = new TableColumn(table,SWT.CENTER);
		newColumnTableColumn_1.setWidth(168);
		newColumnTableColumn_1.setText("Formula");

		final TableColumn newColumnTableColumn_2 = new TableColumn(table,SWT.CENTER);
		newColumnTableColumn_2.setWidth(119);
		newColumnTableColumn_2.setText("Formule name");

		final TableColumn newColumnTableColumn_3 = new TableColumn(table,SWT.CENTER);
		newColumnTableColumn_3.setWidth(100);
		newColumnTableColumn_3.setText("Policy Number");

		final TableColumn newColumnTableColumn_4 = new TableColumn(table,SWT.CENTER);
		newColumnTableColumn_4.setWidth(115);
		newColumnTableColumn_4.setText("Aggregate");
	  
		//
		final Composite detailComposite = new Composite(benefitsSashForm, SWT.BORDER);
		detailComposite.setBackground(SWTResourceManager.getColor(255, 255, 255));
		final GridLayout gridLayout_2 = new GridLayout();
		gridLayout_2.numColumns = 2;
		detailComposite.setLayout(gridLayout_2);

		final Label descriptionLabel = new Label(detailComposite, SWT.NONE);
		descriptionLabel.setText("Description:");
		new Label(detailComposite, SWT.NONE);

		final Label label = new Label(detailComposite, SWT.NONE);
		label.setText("Company:");
		m_companyText = new Text(detailComposite, SWT.BORDER);
		m_companyText.setEnabled(false);
		m_companyText.setEditable(false);
		m_companyText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,false));

		final Label formula = new Label(detailComposite, SWT.NONE);
		formula.setText("Formula:");

		m_formulaText = new Text(detailComposite, SWT.BORDER);
		m_formulaText.setEnabled(false);
		m_formulaText.setEditable(false);
		m_formulaText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,true, false));

		final Label formulename = new Label(detailComposite, SWT.NONE);
		formulename.setText("Formule Name:");

		m_formulenameText = new Text(detailComposite, SWT.BORDER);
		m_formulenameText.setEnabled(false);
		m_formulenameText.setEditable(false);
		m_formulenameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,true, false));

		final Label policynumberLabel = new Label(detailComposite, SWT.NONE);
		policynumberLabel.setText("Policy Number:");

		m_policynumberText = new Text(detailComposite, SWT.BORDER);
		m_policynumberText.setEnabled(false);
		m_policynumberText.setEditable(false);
		m_policynumberText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,true, false));

		final Label amountLabel = new Label(detailComposite, SWT.NONE);
		amountLabel.setText("Amount:");

		m_amountText = new Text(detailComposite, SWT.BORDER);
		m_amountText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,true, false));
		benefitsSashForm.setWeights(new int[] {199, 248});
		sashForm.setWeights(new int[] {86, 406});
		m_bindingContext = initDataBindings();

		
	}
	
	class ViewerUpdateValueStrategy extends UpdateValueStrategy {
		@Override
		protected IStatus doSet(IObservableValue observableValue, Object value) {
			Realm.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					m_benefitsViewer.refresh();
				}				
			});
			return super.doSet(observableValue, value);
		}
	}
	
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap[] observeMaps = BeansObservables.observeMaps(listContentProvider.getKnownElements(), Benefit.class, new String[]{"company", "formula", "formulename", "policynumber", "amount"});
		m_benefitsViewer.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		m_benefitsViewer.setContentProvider(listContentProvider);
		//
		IObservableList benefitsBenefitsObserveList = BeanProperties.list("benefits").observe(m_benefits);
		m_benefitsViewer.setInput(benefitsBenefitsObserveList);
		//
		IObservableValue observeSingleSelectionBenefitsViewer = ViewerProperties.singleSelection().observe(m_benefitsViewer);
		IObservableValue benefitsViewerCompanyObserveDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionBenefitsViewer, "company", String.class);
		IObservableValue textCompanyTextObserveValue = SWTObservables.observeText(m_companyText, SWT.Modify);
		bindingContext.bindValue(benefitsViewerCompanyObserveDetailValue, textCompanyTextObserveValue, null, null);
		//
		IObservableValue observeSingleSelectionBenefitsViewer_1 = ViewerProperties.singleSelection().observe(m_benefitsViewer);
		IObservableValue benefitsViewerFormulaObserveDetailValue = BeanProperties.value(Benefit.class, "formula", String.class).observeDetail(observeSingleSelectionBenefitsViewer_1);
		IObservableValue observeTextFormulaTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(m_formulaText);
		bindingContext.bindValue(benefitsViewerFormulaObserveDetailValue, observeTextFormulaTextObserveWidget, null, null);
		//
		IObservableValue observeSingleSelectionBenefitsViewer_2 = ViewerProperties.singleSelection().observe(m_benefitsViewer);
		IObservableValue benefitsViewerFormulenameObserveDetailValue = BeanProperties.value(Benefit.class, "formulename", String.class).observeDetail(observeSingleSelectionBenefitsViewer_2);
		IObservableValue observeTextFormulenameTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(m_formulenameText);
		bindingContext.bindValue(benefitsViewerFormulenameObserveDetailValue, observeTextFormulenameTextObserveWidget, null, null);
		//
		IObservableValue observeSingleSelectionBenefitsViewer_3 = ViewerProperties.singleSelection().observe(m_benefitsViewer);
		IObservableValue benefitsViewerPolicynumberObserveDetailValue = BeanProperties.value(Benefit.class, "policynumber", String.class).observeDetail(observeSingleSelectionBenefitsViewer_3);
		IObservableValue observeTextPolicynumberTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(m_policynumberText);
		bindingContext.bindValue(benefitsViewerPolicynumberObserveDetailValue, observeTextPolicynumberTextObserveWidget, null, null);
		//
		IObservableValue observeSingleSelectionBenefitsViewer_4 = ViewerProperties.singleSelection().observe(m_benefitsViewer);
		IObservableValue benefitsViewerAmountObserveDetailValue = BeanProperties.value(Benefit.class, "amount", String.class).observeDetail(observeSingleSelectionBenefitsViewer_4);
		IObservableValue observeTextAmountTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(m_amountText);
		bindingContext.bindValue(benefitsViewerAmountObserveDetailValue, observeTextAmountTextObserveWidget, null, new ViewerUpdateValueStrategy());
		//
		return bindingContext;
	}
	
	
	public static <T> List<T> distinctList(List<T> list, Function<? super T, ?>... keyExtractors) {

	    return list
	        .stream()
	        .filter(distinctByKeys(keyExtractors))
	        .collect(Collectors.toList());
	}

	private static <T> Predicate<T> distinctByKeys(Function<? super T, ?>... keyExtractors) {

	    final Map<List<?>, Boolean> seen = new ConcurrentHashMap<>();

	    return t -> {

	        final List<?> keys = Arrays.stream(keyExtractors)
	            .map(ke -> ke.apply(t))
	            .collect(Collectors.toList());

	        return seen.putIfAbsent(keys, Boolean.TRUE) == null;

	    };

	}

  public Timestamp getTimestampFromDateTime(DateTime dateime){
	  Timestamp Dstartdate = null;
	  try {
		String Strstart=String.valueOf(dateime.getYear())
			       +"-"
			       +String.valueOf(dateime.getMonth()+1)
				   +"-"
				   +String.valueOf(dateime.getDay())
				   + " "
				   +String.valueOf(dateime.getHours())
				   +":"
				    +String.valueOf(dateime.getMinutes())
				    +":"
				    +String.valueOf(dateime.getSeconds());

  
		    Dstartdate=Timestamp.valueOf(Strstart);
	} catch (Exception e) {
		logger.error("Erreur sur conversion de date "+dateime);
		logger.error("Error "+e);
		e.printStackTrace();
	}
	  return Dstartdate;
  }
	
}
