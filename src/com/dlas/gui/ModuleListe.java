package com.dlas.gui;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.dlas.dao.Modul;
import com.dlas.dao.ObjectDao;
import com.dlas.gui.EcranAccueil.ViewerUpdateValueStrategy;
import com.dlas.gui.model.ModulModel;
import org.eclipse.swt.layout.GridLayout;

public class ModuleListe {
	private DataBindingContext m_bindingContext;
	private com.dlas.dao.Modul modul = new com.dlas.dao.Modul();
	//private static Display display = new Display();
	private static Shell shellModul  ;
	static  ModuleListe window ;
	private Text txtmodulid;
	private Text txtfournisseur;
	private Text txtlabel;
	private Text txtcategory;
	private Text txtcalculmode;
	private Text txtprice;
	private Text txtscope;
	private Text txtforfait;
	private Table ModulTable;
    private TableViewer Modulviewer;
    private DataBindingContext m_modulcontext;
	private ModulModel m_modulmodels = new ModulModel();
	protected static Shell shell;
	private static String APP_NAME = "Wycc invoice";
	private TableViewer Modulviewer_1;
	private static Integer DisplayStatus =0;
	
	public ModuleListe(){

	}
	public static Logger logger = Logger.getLogger("Wycc");
	/**
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shellModul=new Shell();
		shellModul.setBackground(SWTResourceManager.getColor(255, 255, 255));
		shellModul.setSize(649, 591);
		shellModul.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		SashForm buttonBar = new SashForm(shellModul, SWT.BORDER | SWT.SMOOTH);
		buttonBar.setLayoutData(new RowData(633, SWT.DEFAULT));
		
		Composite btnrecord = new Composite(buttonBar, SWT.NONE);
		btnrecord.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Button btnModifyRecord = new Button(btnrecord, SWT.NONE);
		btnModifyRecord.setText("Modify");
		
		Button btnDeleteRecord = new Button(btnrecord, SWT.NONE);
		btnDeleteRecord.setText("Delete");
		
		Button btnAddRecord = new Button(btnrecord, SWT.NONE);
		btnAddRecord.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
			}
		});
		btnAddRecord.setText("Add");
		
		Composite btncollection = new Composite(buttonBar, SWT.BORDER);
		btncollection.setLayout(null);
		
		Button btnCancel = new Button(btncollection, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				//shellModul.close();
				shellModul.getShell().setVisible(false);
				
			}
		});
		btnCancel.setBounds(176, 26, 127, 26);
		btnCancel.setText("Cancel (close)");
		
		Button btnSave = new Button(btncollection, SWT.NONE);
		btnSave.setBounds(176, 0, 127, 26);
		btnSave.setText("Save (and close)");
		//buttonBar.setWeights(new int[] {1, 1, 1});
		
		SashForm Tablearea = new SashForm(shellModul, SWT.VERTICAL);
		Tablearea.setLayoutData(new RowData(636, 228));
		
		Composite tableareacomposite = new Composite(Tablearea, SWT.NONE);
		Modulviewer_1 = new TableViewer(tableareacomposite, SWT.FULL_SELECTION);
		ModulTable = Modulviewer_1.getTable();
		ModulTable.setHeaderVisible(true);
		ModulTable.setLinesVisible(true);
		ModulTable.setSize(636, 218);
		ModulTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		
		TableColumn tblclmnCalculMode = new TableColumn(ModulTable, SWT.NONE);
		tblclmnCalculMode.setWidth(80);
		tblclmnCalculMode.setText("Mode");
		
		TableColumn tblclmnDispalyOrder = new TableColumn(ModulTable, SWT.NONE);
		tblclmnDispalyOrder.setWidth(40);
		tblclmnDispalyOrder.setText("Order");
		
		TableColumn tblclmnForfaitPercentage = new TableColumn(ModulTable, SWT.NONE);
		tblclmnForfaitPercentage.setWidth(40);
		tblclmnForfaitPercentage.setText("Fft/Pct");
		
		TableColumn tblclmnModulCategory = new TableColumn(ModulTable, SWT.NONE);
		tblclmnModulCategory.setWidth(120);
		tblclmnModulCategory.setText("Category");
		
		TableColumn tblclmnModulFournisseur = new TableColumn(ModulTable, SWT.NONE);
		tblclmnModulFournisseur.setWidth(120);
		tblclmnModulFournisseur.setText("Fournisseur");
		
		TableColumn tblclmnModulId = new TableColumn(ModulTable, SWT.NONE);
		tblclmnModulId.setWidth(40);
		tblclmnModulId.setText("Id");
		
		TableColumn tblclmnModulLabel = new TableColumn(ModulTable, SWT.NONE);
		tblclmnModulLabel.setWidth(120);
		tblclmnModulLabel.setText("Label");
		
		TableColumn tblclmnModulPrice = new TableColumn(ModulTable, SWT.NONE);
		tblclmnModulPrice.setWidth(80);
		tblclmnModulPrice.setText("Price");
		
		TableColumn tblclmnModulScope = new TableColumn(ModulTable, SWT.NONE);
		tblclmnModulScope.setWidth(80);
		tblclmnModulScope.setText("Scope");
		
		Tablearea.setWeights(new int[] {1});
		
		Composite recordcomposite = new Composite(shellModul, SWT.BORDER);
		recordcomposite.setLayoutData(new RowData(633, 225));
		
		Label lblModulId = new Label(recordcomposite, SWT.NONE);
		lblModulId.setBounds(10, 10, 59, 14);
		lblModulId.setText("Modul id");
		
		Label lblSupplier = new Label(recordcomposite, SWT.NONE);
		lblSupplier.setBounds(10, 64, 59, 14);
		lblSupplier.setText("Supplier:");
		
		Label lblFormula = new Label(recordcomposite, SWT.NONE);
		lblFormula.setBounds(167, 10, 59, 14);
		lblFormula.setText("Formula:");
		
		Label lblCategory = new Label(recordcomposite, SWT.NONE);
		lblCategory.setBounds(10, 44, 59, 14);
		lblCategory.setText("Category:");
		
		txtmodulid = new Text(recordcomposite, SWT.BORDER);
		txtmodulid.setBounds(96, 10, 64, 19);
		
		txtfournisseur = new Text(recordcomposite, SWT.BORDER);
		txtfournisseur.setBounds(96, 64, 301, 19);
		
		txtlabel = new Text(recordcomposite, SWT.BORDER);
		txtlabel.setBounds(253, 10, 301, 19);
		
		txtcategory = new Text(recordcomposite, SWT.BORDER);
		txtcategory.setBounds(96, 39, 301, 19);
		
		Label lblCalculMode = new Label(recordcomposite, SWT.NONE);
		lblCalculMode.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblCalculMode.setBounds(60, 121, 79, 14);
		lblCalculMode.setText("Calcul mode:");
		
		Label lblPrice = new Label(recordcomposite, SWT.NONE);
		lblPrice.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblPrice.setBounds(60, 153, 59, 14);
		lblPrice.setText("Price:");
		
		Label lblScope = new Label(recordcomposite, SWT.NONE);
		lblScope.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblScope.setBounds(331, 121, 59, 14);
		lblScope.setText("Scope:");
		
		Label lblForfaitpercentage = new Label(recordcomposite, SWT.NONE);
		lblForfaitpercentage.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblForfaitpercentage.setBounds(331, 153, 113, 14);
		lblForfaitpercentage.setText("Forfait/percentage:");
		
		txtcalculmode = new Text(recordcomposite, SWT.BORDER);
		txtcalculmode.setBounds(183, 119, 64, 19);
		
		txtprice = new Text(recordcomposite, SWT.BORDER);
		txtprice.setBounds(183, 151, 64, 19);
		
		txtscope = new Text(recordcomposite, SWT.BORDER);
		txtscope.setBounds(396, 119, 64, 19);
		
		txtforfait = new Text(recordcomposite, SWT.BORDER);
		txtforfait.setBounds(454, 151, 64, 19);
		
		Group group = new Group(recordcomposite, SWT.NONE);
		group.setBounds(50, 108, 505, 93);

		m_modulcontext= initDataBindings();
	}


	protected DataBindingContext initDataBindings() {

		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		Modulviewer_1.setContentProvider(listContentProvider);
		//
		IObservableMap[] observeMaps = PojoObservables.observeMaps(listContentProvider.getKnownElements(), Modul.class, new String[]{"calculmode", "displayorder", "forfaitpercentage", "modulcategory", "modulfournisseur", "modulid", "modullabel", "modulprice", "modulscope"});
		Modulviewer_1.setLabelProvider(new ObservableMapLabelProvider(observeMaps));		

       //
		IObservableList ModulObserveList = BeanProperties.list("m_moduls").observe(m_modulmodels);		
		Modulviewer_1.setInput(ModulObserveList);
		
		//

		IObservableValue observeSingleSelectionModulviewer = ViewerProperties.singleSelection().observe(Modulviewer_1);
		IObservableValue modulviewercalculmodeObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionModulviewer,"calculmode",String.class);
		IObservableValue textCalculmodeTextObserveValue = SWTObservables.observeText(txtcalculmode,SWT.Modify);
		bindingContext.bindValue(modulviewercalculmodeObservableDetailValue, textCalculmodeTextObserveValue, null, new ViewerUpdateValueStrategy());

	//ObservableValuecalculmode(  Modulviewer_1,bindingContext ,"calculmode",txtcalculmode );
			
		//
		

		return bindingContext;
	}


	class ViewerUpdateValueStrategy extends UpdateValueStrategy {
		@Override
		protected IStatus doSet(IObservableValue observableValue, Object value) {
			
			//Realm.getDefault().  
			observableValue.getRealm().asyncExec(new Runnable() {
				@Override
				public void run() {
					Modulviewer_1.refresh();
				}				
			});
			return super.doSet(observableValue, value);
		}
	}
	
	public int open(Display display) {

		//setDefaultValues(display);
		createContents();

		Display.setAppName(APP_NAME);
		shellModul.open();
		shellModul.layout();
		Modulviewer_1.refresh();
		while (!shellModul.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		return 0;
	}	
	
	public void setDefaultValues(Display display) {
		window=this;
		//logger.info("Window status :"+shellModul.getShell().getVisible());
		List<Modul> templist= getListmodul();
		m_modulmodels.addModuls(shellModul, templist, window);
	}
		
	public List<Modul> getListmodul() {
		
		ObjectDao myobj = new ObjectDao();
		Session lasession = myobj.getSessionDao();
		lasession.beginTransaction();
		Query query = lasession.createQuery("from Modul");		
		List<Modul> resultdistinct = query.list();
		lasession.getTransaction().commit();
		return resultdistinct;
	}
	
	
	public static void Moduldisplay(Display display) {		
		Display.setAppName(APP_NAME);

		/*
		 *  On détermine le dossier d'execution du jar
		 * 
		 */
		URL url = ModuleListe.class.getProtectionDomain().getCodeSource().getLocation(); //Gets the path
	  	String jarPath = null;
			try {
				jarPath = URLDecoder.decode(url.getFile(), "UTF-8"); //Should fix it to be read correctly by the system
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

	    

     	    Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
			@Override
			public void run() {

				try {
					logger.info("Window open start ");
					window.open(display);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	


    public void ObservableValuecalculmode( TableViewer modulviewer,DataBindingContext bindingContext,String attr,Text displayzone ){
		IObservableValue observeSingleSelectionModulviewer = ViewerProperties.singleSelection().observe(modulviewer);
		IObservableValue modulviewercalculmodeObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionModulviewer,attr,String.class);
		IObservableValue textCalculmodeTextObserveValue = SWTObservables.observeText(displayzone,SWT.Modify);
		bindingContext.bindValue(modulviewercalculmodeObservableDetailValue, textCalculmodeTextObserveValue, null, new ViewerUpdateValueStrategy());
	
    }


}

