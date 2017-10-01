package com.dlas.gui;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.*;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
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
import com.dlas.dao.H2db;
import com.dlas.dao.HsqlText;
import com.dlas.gui.EcranAccueil.ViewerUpdateValueStrategy;
import com.dlas.gui.model.ModulModel;
import com.poi.actionuser.Actionuser;
import com.poi.actionuser.Actionuser.ProgressBarDb;
import com.dlas.gui.model.Benefit;
import com.dlas.gui.model.IntegerToString;
import org.eclipse.swt.layout.GridLayout;

public class ModuleListe {
	private DataBindingContext m_bindingContext;
	private Modul modul ; //= new Modul()
	//private static Display display = new Display();
	private static Shell shellModul  ;
	static  ModuleListe window ;
		private TableViewer Modulviewer_1;
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

	private static Integer DisplayStatus =0;
	private List<Modul> deletemodul =new ArrayList();
	public ModuleListe(){

	}
	public static Logger logger = LogManager.getLogger("wycc");
	/**
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		logger.info("Start create content");
		shellModul=new Shell();
		shellModul.setBackground(SWTResourceManager.getColor(245, 255, 250));
		shellModul.setSize(753, 562);
		RowLayout rl_shellModul = new RowLayout(SWT.HORIZONTAL);
		rl_shellModul.marginLeft = 15;
		shellModul.setLayout(rl_shellModul);
		
		SashForm buttonBar = new SashForm(shellModul, SWT.BORDER | SWT.SMOOTH);
		buttonBar.setLayoutData(new RowData(722, SWT.DEFAULT));
		
		Composite btnrecord = new Composite(buttonBar, SWT.NONE);
		btnrecord.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Button btnDeleteRecord = new Button(btnrecord, SWT.NONE);
		btnDeleteRecord.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				int index = Modulviewer_1.getTable().getSelectionIndex();
				if (index >=0){
				Modul lemodultodel=(Modul) Modulviewer_1.getElementAt(index);
				deletemodul.add(lemodultodel);
				m_modulmodels.removeModulofIndex(index);
				}
				Modulviewer_1.refresh();
			}
		});
		btnDeleteRecord.setText("Delete");
		
		Button btnAddRecord = new Button(btnrecord, SWT.NONE);
		btnAddRecord.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Modul newmodul=new Modul();
			
				m_modulmodels.addOneModul(shellModul, newmodul, window);
				Modulviewer_1.refresh();
				
				Integer selection= m_modulmodels.getSize()-1;			
				newmodul=(Modul) Modulviewer_1.getElementAt(selection);
				ISelection Sel = (ISelection) new StructuredSelection(Modulviewer_1.getElementAt(selection));
				Modulviewer_1.setSelection(Sel,true);
				

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
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				//shellModul.close();
				// We have to save the modification
				ObjectDao myobj = new ObjectDao();
				Session lasession = myobj.getSessionDao();
				lasession.beginTransaction(); 
				 for ( Modul modul : (List<Modul>) m_modulmodels.getM_moduls() ){
					 lasession.saveOrUpdate(modul);
				 }
				 if (deletemodul!= null) {
					 for ( Modul modul : deletemodul){
						 lasession.delete(modul);
					 }
				 }
				  lasession.flush();
				  lasession.getTransaction().commit(); 
				  lasession.close();
				
				shellModul.getShell().setVisible(false);
			}
		});
		btnSave.setBounds(176, 0, 127, 26);
		btnSave.setText("Save (and close)");
		//buttonBar.setWeights(new int[] {1, 1, 1});
		
		SashForm Tablearea = new SashForm(shellModul, SWT.VERTICAL);
		Tablearea.setLayoutData(new RowData(722, 228));
		
		Composite tableareacomposite = new Composite(Tablearea, SWT.NONE);
		Modulviewer_1 = new TableViewer(tableareacomposite, SWT.FULL_SELECTION);
		ModulTable = Modulviewer_1.getTable();
		ModulTable.setLocation(0, 0);
		ModulTable.setHeaderVisible(true);
		ModulTable.setLinesVisible(true);
		ModulTable.setSize(721, 218);
		ModulTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		
		TableColumn tblclmnCalculMode = new TableColumn(ModulTable, SWT.NONE);
		tblclmnCalculMode.setWidth(80);
		tblclmnCalculMode.setText("Mode");
		
		TableColumn tblclmnDispalyOrder = new TableColumn(ModulTable, SWT.NONE);
		tblclmnDispalyOrder.setWidth(40);
		tblclmnDispalyOrder.setText("Order");
		
		TableColumn tblclmnForfaitPercentage = new TableColumn(ModulTable, SWT.RIGHT);
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
		
		TableColumn tblclmnModulPrice = new TableColumn(ModulTable, SWT.RIGHT);
		tblclmnModulPrice.setWidth(80);
		tblclmnModulPrice.setText("Price");
		
		TableColumn tblclmnModulScope = new TableColumn(ModulTable, SWT.NONE);
		tblclmnModulScope.setWidth(80);
		tblclmnModulScope.setText("Scope");
		
		Tablearea.setWeights(new int[] {1});
		
		Composite recordcomposite = new Composite(shellModul, SWT.BORDER);
		recordcomposite.setLayoutData(new RowData(722, 225));
		
		Label lblModulId = new Label(recordcomposite, SWT.NONE);
		lblModulId.setBounds(38, 207, 59, 14);
		lblModulId.setText("Modul id");
		
		Label lblSupplier = new Label(recordcomposite, SWT.NONE);
		lblSupplier.setBounds(38, 6, 59, 14);
		lblSupplier.setText("Supplier:");
		
		Label lblFormula = new Label(recordcomposite, SWT.NONE);
		lblFormula.setBounds(38, 30, 59, 14);
		lblFormula.setText("Formula:");
		
		Label lblCategory = new Label(recordcomposite, SWT.NONE);
		lblCategory.setBounds(38, 60, 59, 14);
		lblCategory.setText("Category:");
		
		txtmodulid = new Text(recordcomposite, SWT.READ_ONLY);
		txtmodulid.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		txtmodulid.setEnabled(false);
		txtmodulid.setBounds(124, 207, 86, 19);
		
		txtfournisseur = new Text(recordcomposite, SWT.BORDER);
		txtfournisseur.setBounds(103, 0, 501, 26);
		
		txtlabel = new Text(recordcomposite, SWT.BORDER);
		txtlabel.setBounds(103, 28, 501, 26);
		
		txtcategory = new Text(recordcomposite, SWT.BORDER);
		txtcategory.setBounds(103, 58, 501, 26);
		
		Label lblCalculMode = new Label(recordcomposite, SWT.NONE);
		lblCalculMode.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblCalculMode.setBounds(82, 121, 79, 14);
		lblCalculMode.setText("Calcul mode:");
		
		Label lblPrice = new Label(recordcomposite, SWT.NONE);
		lblPrice.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblPrice.setBounds(82, 153, 59, 14);
		lblPrice.setText("Price:");
		
		txtcalculmode = new Text(recordcomposite, SWT.BORDER);
		txtcalculmode.setBounds(205, 115, 105, 26);
		
		txtprice = new Text(recordcomposite, SWT.BORDER | SWT.RIGHT);
		txtprice.setBounds(205, 151, 105, 26);
		
		Group group = new Group(recordcomposite, SWT.NONE);
		group.setBounds(76, 90, 550, 111);
		
		txtscope = new Text(group, SWT.BORDER);
		txtscope.setBounds(383, 25, 147, 26);
		
		txtforfait = new Text(group, SWT.BORDER | SWT.RIGHT);
		txtforfait.setBounds(441, 61, 89, 26);
		
		Label lblScope = new Label(group, SWT.NONE);
		lblScope.setBounds(318, 31, 59, 14);
		lblScope.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblScope.setText("Scope:");
		
		Label lblForfaitpercentage = new Label(group, SWT.NONE);
		lblForfaitpercentage.setBounds(318, 67, 113, 14);
		lblForfaitpercentage.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblForfaitpercentage.setText("Forfait/percentage:");
		logger.info("end create content");
		m_modulcontext= initDataBindings();
	}


	protected DataBindingContext initDataBindings() {
		logger.info("end initDataBindings");
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

		IObservableValue observeSingleSelectionModulviewer = ViewerProperties.singleSelection().observe(Modulviewer_1);
		IObservableValue modulviewercalculmodeObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionModulviewer,"calculmode",String.class);
		IObservableValue textCalculmodeTextObserveValue = SWTObservables.observeText(txtcalculmode,SWT.Modify);
		bindingContext.bindValue(modulviewercalculmodeObservableDetailValue, textCalculmodeTextObserveValue, null, new ViewerUpdateValueStrategy());

	
		IObservableValue observeSingleSelectionModulviewermodulid = ViewerProperties.singleSelection().observe(Modulviewer_1);
		IObservableValue modulviewermodulidObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionModulviewermodulid,"modulid",Integer.class);
		IObservableValue textmodulidTextObserveValue = SWTObservables.observeText(txtmodulid,SWT.Modify);
		bindingContext.bindValue(modulviewermodulidObservableDetailValue, textmodulidTextObserveValue, null, new ViewerUpdateValueStrategy());
		
//		UpdateValueStrategy strategy1 =  new ViewerUpdateValueStrategy();
//		strategy1.setConverter(new com.dlas.gui.model.StringToInteger());
//		
//		UpdateValueStrategy strategy2 =  new ViewerUpdateValueStrategy();
//		strategy2.setConverter(new com.dlas.gui.model.IntegerToString());
		
		IObservableValue observeSingleSelectionModulviewerforfaitpercentage = ViewerProperties.singleSelection().observe(Modulviewer_1);
		IObservableValue modulviewerforfaitpercentageObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionModulviewerforfaitpercentage,"forfaitpercentage",Integer.class);
		IObservableValue textforfaitpercentageTextObserveValue = SWTObservables.observeText(txtforfait,SWT.Modify);
		bindingContext.bindValue(modulviewerforfaitpercentageObservableDetailValue, textforfaitpercentageTextObserveValue, null, new ViewerUpdateValueStrategy());
		
		IObservableValue observeSingleSelectionModulviewermodulfournisseur = ViewerProperties.singleSelection().observe(Modulviewer_1);
		IObservableValue modulviewermodulfournisseurObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionModulviewermodulfournisseur,"modulfournisseur",String.class);
		IObservableValue textmodulfournisseurTextObserveValue = SWTObservables.observeText(txtfournisseur,SWT.Modify);
		bindingContext.bindValue(modulviewermodulfournisseurObservableDetailValue, textmodulfournisseurTextObserveValue, null, new ViewerUpdateValueStrategy());
		
		
		IObservableValue observeSingleSelectionModulviewermodulcategory = ViewerProperties.singleSelection().observe(Modulviewer_1);
		IObservableValue modulviewermodulcategoryObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionModulviewermodulcategory,"modulcategory",String.class);
		IObservableValue textmodulcategoryTextObserveValue = SWTObservables.observeText(txtcategory,SWT.Modify);
		bindingContext.bindValue(modulviewermodulcategoryObservableDetailValue, textmodulcategoryTextObserveValue, null, new ViewerUpdateValueStrategy());
		
		IObservableValue observeSingleSelectionModulviewermodullabel = ViewerProperties.singleSelection().observe(Modulviewer_1);
		IObservableValue modulviewermodullabelObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionModulviewermodullabel,"modullabel",String.class);
		IObservableValue textmodullabelTextObserveValue = SWTObservables.observeText(txtlabel,SWT.Modify);
		bindingContext.bindValue(modulviewermodullabelObservableDetailValue, textmodullabelTextObserveValue, null, new ViewerUpdateValueStrategy());
		
		IObservableValue observeSingleSelectionModulviewermodulscope = ViewerProperties.singleSelection().observe(Modulviewer_1);
		IObservableValue modulviewermodulscopeObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionModulviewermodulscope,"modulscope",String.class);
		IObservableValue textmodulscopeTextObserveValue = SWTObservables.observeText(txtscope,SWT.Modify);
		bindingContext.bindValue(modulviewermodulscopeObservableDetailValue, textmodulscopeTextObserveValue, null, new ViewerUpdateValueStrategy());
		
		IObservableValue observeSingleSelectionModulviewermodulprice = ViewerProperties.singleSelection().observe(Modulviewer_1);
		IObservableValue modulviewermodulpriceObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionModulviewermodulprice,"modulprice",Float.class);
		IObservableValue textmodulpriceTextObserveValue = SWTObservables.observeText(txtprice,SWT.Modify);
		bindingContext.bindValue(modulviewermodulpriceObservableDetailValue, textmodulpriceTextObserveValue, null, new ViewerUpdateValueStrategy());
		
		

		
/*
		ObservableValuecalculmode( Modulviewer_1,bindingContext,"modulfournisseur",txtfournisseur );
		ObservableValuecalculmode( Modulviewer_1,bindingContext,"modulcategory",txtcategory );
		ObservableValuecalculmode( Modulviewer_1,bindingContext,"modullabel",txtlabel );
		ObservableValuecalculmode( Modulviewer_1,bindingContext,"modulscope",txtscope );
		ObservableValuecalculmode( Modulviewer_1,bindingContext,"modulprice",txtprice );
*/
		
		//
		logger.info("end initDataBindings");

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
		logger.info("open window");
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
	
	public void setDefaultValues(Display display) throws InvocationTargetException, InterruptedException {
		window=this;
		
//		List<Modul> templist= getListmodul();
//		m_modulmodels.addModuls(shellModul, templist, window);
		Shell shell = new Shell();
		IRunnableWithProgress op = new ProgressBarDb("Database initialisation",shell, window);
		
		new ProgressMonitorDialog(shell).run(true, true, op);
		shell.close();
		
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


    public  class ProgressBarDb implements IRunnableWithProgress {
		 private String       message;
		 private Shell        shellModul;
		 private ModuleListe  moduleliste;
		 
		 
		public ProgressBarDb(String message,Shell        shellModul, ModuleListe  moduleliste){
			
           this.message       = message;
           this.shellModul    = shellModul;
           this.moduleliste   = moduleliste;
           
		}
		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			    monitor.beginTask(message, IProgressMonitor.UNKNOWN);
			    monitor.worked(1);
				
				
			    List<Modul> templist= getListmodul();
			  	m_modulmodels.addModuls(shellModul, templist, moduleliste);
				monitor.worked(1);

			 monitor.done();
		}
		
	}

 
    
    
    
}

