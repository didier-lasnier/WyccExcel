package com.dlas.gui;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.Transaction;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.Binding;

import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerProperties;

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
import com.dlas.dao.BenefitDb;

import com.dlas.gui.accueil.MenuAccueil;
import com.dlas.gui.accueil.OpenItem;
import com.dlas.gui.accueil.ReadItem;
import com.dlas.gui.accueil.SaveItem;
import com.dlas.gui.model.Benefit;
import com.dlas.gui.model.Companies;
import com.dlas.gui.model.Company;
import com.poi.actionuser.Actionuser;
import com.poi.actionuser.ReadFileXlsx;
import com.dlas.gui.model.Benefits;
import org.eclipse.swt.widgets.Menu;




public class EcranAccueil {
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
	
	Display d;
	Shell s;
	
	public static void main(String[] args) {
		final String APP_NAME = "Wycc invoice";
		Display display = new Display();
		shell = new Shell();
		shell.setSize(638, 382);
		
		display.setAppName(APP_NAME);
		
     	Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
			public void run() {

				try {

					EcranAccueil window = new EcranAccueil();
					window.open();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	class Open implements SelectionListener {
			
		public void widgetSelected(SelectionEvent event) {
			widgetOpen(startdate,enddate);
		}

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
				
				a.lanceLecture(selected, StartD, EndD);
				
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
		public void widgetSelected(SelectionEvent event) {
			widgetSave();
		}

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
						a.generexls(selected);
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
		public void widgetSelected(SelectionEvent event) {
			widgetRead();
		}

		public void widgetDefaultSelected(SelectionEvent event) {
		}
		
		public void widgetSelectedBtn(Event event) {
			widgetRead();
		}
		public void widgetRead(){
			File directory = new File(".");
			String fileCharSep = System.getProperty("file.separator");
			try {
			FileDialog fd = new FileDialog(s, SWT.OPEN);
			fd.setText("Choose a file");
			fd.setFilterPath(directory.getCanonicalPath());
			String[] filterExt = { "*.xlsx"};
			fd.setFilterExtensions(filterExt);
			String selected = fd.open();
			if (selected !=null) {
				ReadFileXlsx a = new ReadFileXlsx();
				try {
					a.readxls();
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
		final Display display = Display.getDefault();		
//		setDefaultValues();
		createContents();
		MenuAccueil menuaccueil=new MenuAccueil(shell,display,startdate,enddate);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}	
	
	
	protected void createContents() {
		shell.setLayout(new FillLayout());
		shell.setSize(789, 517);
		shell.setText("Wycc Invoice");
		final SashForm sashForm = new SashForm(shell, SWT.VERTICAL);

		//
		final Composite companyComposite = new Composite(sashForm, SWT.BORDER);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.marginWidth = 10;
		gridLayout.verticalSpacing = 0;
		gridLayout.marginHeight = 0;
		companyComposite.setLayout(gridLayout);
		
		final Composite companyToolBarComposite = new Composite(companyComposite, SWT.NONE);
		final GridLayout gridLayout_3 = new GridLayout(5, false);
		companyToolBarComposite.setLayout(gridLayout_3);
		GridData gd_companyToolBarComposite = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_companyToolBarComposite.heightHint = 72;
		companyToolBarComposite.setLayoutData(gd_companyToolBarComposite);
		
		// bouton Aggregate
		AggregateButton = new Button(companyToolBarComposite, SWT.NONE);
		AggregateButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				Benefit benefit = new Benefit();
				//GroupDialog dialog = new GroupDialog(shell, company, true);
				if (1==1) { //dialog.open() == Window.OK) 
					m_benefits.addBenefit(shell,benefit);
					m_benefitsViewer.setSelection(new StructuredSelection(benefit),
							true);
					m_bindingContext.updateModels();
					
				}
			}
		});
		
		AggregateButton.setText("Get aggregate");
		new Label(companyToolBarComposite, SWT.NONE);

		SaveButton = new Button(companyToolBarComposite, SWT.NONE);
		SaveButton.setText("Save..");
		SaveButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// on enregistre les Aggregate
				ObjectDao myobj = new ObjectDao();
				Session lasession = myobj.getSessionDao();
				List<Benefit> mbenefits =m_benefits.getBenefits();
				lasession.beginTransaction();
				Query q = lasession.createQuery("delete from BenefitDb");
				q.executeUpdate();
				 lasession.getTransaction().commit(); 
				 
				lasession.beginTransaction(); 
				 for ( Benefit m_benefit : mbenefits ){
					BenefitDb benedb =new BenefitDb();
					benedb.setCompany(m_benefit.getCompany());
					benedb.setFormula(m_benefit.getFormula());
					benedb.setFormulename(m_benefit.getFormulename());
					benedb.setPolicynumber(m_benefit.getPolicynumber());
					benedb.setAmount(m_benefit.getAmount());
					lasession.save(benedb);
				 }		
				  lasession.flush();
				  lasession.getTransaction().commit(); 
				  lasession.close();
			}
		});
		
		Button btnReadCsv = new Button(companyToolBarComposite, SWT.NONE);
		btnReadCsv.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new Open().widgetOpen(startdate,enddate);
			}
		});
		btnReadCsv.setText("Read Csv..");
		
		Button btnClientAmount = new Button(companyToolBarComposite, SWT.NONE);
		btnClientAmount.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new Save().widgetSave();
			}
		});
		btnClientAmount.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
			        new Save();
			      }
			    });
        btnClientAmount.setText("Client amount...");
        
        Label lblStartDate = new Label(companyToolBarComposite, SWT.NONE);
        lblStartDate.setText("Start date");
        new Label(companyToolBarComposite, SWT.NONE);
        DateTime StartDate = new DateTime(companyToolBarComposite, SWT.BORDER);
        startdate=StartDate;
        Label lblEndDate = new Label(companyToolBarComposite, SWT.NONE);
        lblEndDate.setText("End date");
        DateTime EndDate = new DateTime(companyToolBarComposite, SWT.BORDER);
        enddate=EndDate;
        
		class Open implements SelectionListener {
			
			public void widgetSelected(SelectionEvent event) {
				widgetOpen(startdate,enddate);
			}

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
					
					a.lanceLecture(selected, StartD, EndD);
					
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
		
		final TableColumn newColumnTableColumn = new TableColumn(table,SWT.NONE);
		newColumnTableColumn.setWidth(123);
		newColumnTableColumn.setText("Company");

		final TableColumn newColumnTableColumn_1 = new TableColumn(table,SWT.NONE);
		newColumnTableColumn_1.setWidth(168);
		newColumnTableColumn_1.setText("Formula");

		final TableColumn newColumnTableColumn_2 = new TableColumn(table,SWT.NONE);
		newColumnTableColumn_2.setWidth(119);
		newColumnTableColumn_2.setText("Formule name");

		final TableColumn newColumnTableColumn_3 = new TableColumn(table,SWT.NONE);
		newColumnTableColumn_3.setWidth(100);
		newColumnTableColumn_3.setText("Policy Number");

		final TableColumn newColumnTableColumn_4 = new TableColumn(table,SWT.NONE);
		newColumnTableColumn_4.setWidth(100);
		newColumnTableColumn_4.setText("Amount Aggregate");
	  
		//
		final Composite detailComposite = new Composite(benefitsSashForm, SWT.BORDER);
		final GridLayout gridLayout_2 = new GridLayout();
		gridLayout_2.numColumns = 2;
		detailComposite.setLayout(gridLayout_2);

		final Label descriptionLabel = new Label(detailComposite, SWT.NONE);
		descriptionLabel.setText("Description:");
		new Label(detailComposite, SWT.NONE);

		final Label label = new Label(detailComposite, SWT.NONE);
		label.setText("Company:");
		m_companyText = new Text(detailComposite, SWT.BORDER);
		m_companyText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,false));

		final Label formula = new Label(detailComposite, SWT.NONE);
		formula.setText("Formula:");

		m_formulaText = new Text(detailComposite, SWT.BORDER);
		m_formulaText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,true, false));

		final Label formulename = new Label(detailComposite, SWT.NONE);
		formulename.setText("Formule Name:");

		m_formulenameText = new Text(detailComposite, SWT.BORDER);
		m_formulenameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,true, false));

		final Label policynumberLabel = new Label(detailComposite, SWT.NONE);
		policynumberLabel.setText("Policy Number:");

		m_policynumberText = new Text(detailComposite, SWT.BORDER);
		m_policynumberText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,true, false));

		final Label amountLabel = new Label(detailComposite, SWT.NONE);
		amountLabel.setText("Amount:");

		m_amountText = new Text(detailComposite, SWT.BORDER);
		m_amountText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,true, false));
		benefitsSashForm.setWeights(new int[] {199, 248});
		sashForm.setWeights(new int[] {86, 406});
		m_bindingContext = initDataBindings();

		
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
		bindingContext.bindValue(benefitsViewerAmountObserveDetailValue, observeTextAmountTextObserveWidget, null, null);
		
		//
		return bindingContext;
	}
}
