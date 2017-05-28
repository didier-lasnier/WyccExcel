package com.dlas.gui;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.List;

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
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.dlas.dao.Modul;
import com.dlas.dao.ObjectDao;
import com.dlas.dao.beneficiaries;
import com.dlas.gui.EcranAccueil.ViewerUpdateValueStrategy;
import com.dlas.gui.model.Benefit;
import com.dlas.gui.model.Benefits;
import com.dlas.gui.model.ModulModel;

import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Table;
import swing2swt.layout.FlowLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import swing2swt.layout.BoxLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewer;

public class ModulDialog extends Dialog {

	private DataBindingContext m_bindingContext;
	private com.dlas.dao.Modul modul = new com.dlas.dao.Modul();
	//private static Display display = new Display();
	private static Shell shellModul =new Shell() ;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	static  ModulDialog window = new ModulDialog();
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
	private ModulModel m_moduls = new ModulModel();
	protected static Shell shell;
	private static String APP_NAME = "Wycc invoice";
	private TableViewer Modulviewer_1;
	/**
	 * @wbp.parser.constructor
	 */

	public ModulDialog(Display display) {
		super(shellModul);
		m_moduls.addModuls(shellModul, getListmodul(), window);
		Moduldisplay(display);
		
	}
	public ModulDialog() {
		super(shellModul);
	}

	protected void createContents() {
		shellModul.setBackground(SWTResourceManager.getColor(255, 255, 255));
		shellModul.setSize(647, 591);
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
		formToolkit.adapt(tableareacomposite);
		formToolkit.paintBordersFor(tableareacomposite);
		
		Modulviewer_1 = new TableViewer(tableareacomposite, SWT.FULL_SELECTION);

		ModulTable = Modulviewer_1.getTable();
		ModulTable.setHeaderVisible(true);
		ModulTable.setLinesVisible(true);
		ModulTable.setSize(636, 218);
		formToolkit.paintBordersFor(ModulTable);
		ModulTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		
		TableColumn tblclmnModulId = new TableColumn(ModulTable, SWT.NONE);
		tblclmnModulId.setWidth(100);
		tblclmnModulId.setText("Modul id");
		
		TableColumn tblclmnFormula = new TableColumn(ModulTable, SWT.NONE);
		tblclmnFormula.setWidth(100);
		tblclmnFormula.setText("Formula");
		
		TableColumn tblclmnCategory = new TableColumn(ModulTable, SWT.NONE);
		tblclmnCategory.setWidth(149);
		tblclmnCategory.setText("Category");
		
		TableColumn tblclmnSupplier = new TableColumn(ModulTable, SWT.NONE);
		tblclmnSupplier.setWidth(180);
		tblclmnSupplier.setText("Supplier");
		Tablearea.setWeights(new int[] {1});
		
		Composite recordcomposite = new Composite(shellModul, SWT.BORDER);
		recordcomposite.setLayoutData(new RowData(633, 225));
		
		Label lblModulId = new Label(recordcomposite, SWT.NONE);
		lblModulId.setBounds(10, 10, 59, 14);
		formToolkit.adapt(lblModulId, true, true);
		lblModulId.setText("Modul id");
		
		Label lblSupplier = new Label(recordcomposite, SWT.NONE);
		lblSupplier.setBounds(10, 64, 59, 14);
		formToolkit.adapt(lblSupplier, true, true);
		lblSupplier.setText("Supplier:");
		
		Label lblFormula = new Label(recordcomposite, SWT.NONE);
		lblFormula.setBounds(167, 10, 59, 14);
		formToolkit.adapt(lblFormula, true, true);
		lblFormula.setText("Formula:");
		
		Label lblCategory = new Label(recordcomposite, SWT.NONE);
		lblCategory.setBounds(10, 44, 59, 14);
		formToolkit.adapt(lblCategory, true, true);
		lblCategory.setText("Category:");
		
		txtmodulid = new Text(recordcomposite, SWT.BORDER);
		txtmodulid.setBounds(96, 10, 64, 19);
		formToolkit.adapt(txtmodulid, true, true);
		
		txtfournisseur = new Text(recordcomposite, SWT.BORDER);
		txtfournisseur.setBounds(96, 64, 301, 19);
		formToolkit.adapt(txtfournisseur, true, true);
		
		txtlabel = new Text(recordcomposite, SWT.BORDER);
		txtlabel.setBounds(253, 10, 301, 19);
		formToolkit.adapt(txtlabel, true, true);
		
		txtcategory = new Text(recordcomposite, SWT.BORDER);
		txtcategory.setBounds(96, 39, 301, 19);
		formToolkit.adapt(txtcategory, true, true);
		
		Label lblCalculMode = new Label(recordcomposite, SWT.NONE);
		lblCalculMode.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblCalculMode.setBounds(60, 121, 79, 14);
		formToolkit.adapt(lblCalculMode, true, true);
		lblCalculMode.setText("Calcul mode:");
		
		Label lblPrice = new Label(recordcomposite, SWT.NONE);
		lblPrice.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblPrice.setBounds(60, 153, 59, 14);
		formToolkit.adapt(lblPrice, true, true);
		lblPrice.setText("Price:");
		
		Label lblScope = new Label(recordcomposite, SWT.NONE);
		lblScope.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblScope.setBounds(331, 121, 59, 14);
		formToolkit.adapt(lblScope, true, true);
		lblScope.setText("Scope:");
		
		Label lblForfaitpercentage = new Label(recordcomposite, SWT.NONE);
		lblForfaitpercentage.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		lblForfaitpercentage.setBounds(331, 153, 113, 14);
		formToolkit.adapt(lblForfaitpercentage, true, true);
		lblForfaitpercentage.setText("Forfait/percentage:");
		
		txtcalculmode = new Text(recordcomposite, SWT.BORDER);
		txtcalculmode.setBounds(183, 119, 64, 19);
		formToolkit.adapt(txtcalculmode, true, true);
		
		txtprice = new Text(recordcomposite, SWT.BORDER);
		txtprice.setBounds(183, 151, 64, 19);
		formToolkit.adapt(txtprice, true, true);
		
		txtscope = new Text(recordcomposite, SWT.BORDER);
		txtscope.setBounds(396, 119, 64, 19);
		formToolkit.adapt(txtscope, true, true);
		
		txtforfait = new Text(recordcomposite, SWT.BORDER);
		txtforfait.setBounds(454, 151, 64, 19);
		formToolkit.adapt(txtforfait, true, true);
		
		Group group = new Group(recordcomposite, SWT.NONE);
		group.setBounds(50, 108, 505, 93);
		formToolkit.adapt(group);
		formToolkit.paintBordersFor(group);
		
		m_modulcontext= initDataBindings();
	}

	public int open() {
		
		Display display = Display.getDefault();	
		
//		setDefaultValues();
		createContents();
		//MenuAccueil menuaccueil=new MenuAccueil(shell,display,startdate,enddate,appDir);
		Display.setAppName(APP_NAME);
		shellModul.open();
		shellModul.layout();
		while (!shellModul.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		return 0;
	}
	
	public static void Moduldisplay(Display display) {
		//final String APP_NAME = "Wycc invoice";

		
		
		Display.setAppName(APP_NAME);
		//Display display = new Display();
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(255, 255, 255));
		shell.setSize(638, 382);
		/*
		 *  On détermine le dossier d'execution du jar
		 * 
		 */
		URL url = ModulDialog.class.getProtectionDomain().getCodeSource().getLocation(); //Gets the path
	  	String jarPath = null;
			try {
				jarPath = URLDecoder.decode(url.getFile(), "UTF-8"); //Should fix it to be read correctly by the system
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

	    
		Menu menusy=display.getSystemMenu();
     	Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
			@Override
			public void run() {

				try {
					window.open();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
	
	public List<Modul> getListmodul() {
		// on recupére a liste des module de la base de données.
		
		// on se connect à la base
		// on exexute un from sans critére
		// on affiche la liste obtenue
		
		ObjectDao myobj = new ObjectDao();
		Session lasession = myobj.getSessionDao();
		lasession.beginTransaction();
		Query query = lasession.createQuery("from Modul");
		
		List<Modul> resultdistinct = query.list();
		lasession.getTransaction().commit();
		return resultdistinct;
	}
	
	class ViewerUpdateValueStrategy extends UpdateValueStrategy {
		@Override
		protected IStatus doSet(IObservableValue observableValue, Object value) {
			Realm.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					Modulviewer_1.refresh();
				}				
			});
			return super.doSet(observableValue, value);
		}
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap[] observeMaps = PojoObservables.observeMaps(listContentProvider.getKnownElements(), Modul.class, new String[]{"calculmode", "displayorder", "forfaitpercentage", "modulcategory", "modulfournisseur", "modulid", "modullabel", "modulprice", "modulscope"});
		Modulviewer_1.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		Modulviewer_1.setContentProvider(listContentProvider);
		//
		IObservableList ModulObserveList = BeanProperties.list("ModulModel").observe(m_moduls);
		Modulviewer_1.setInput(ModulObserveList);
		//
		IObservableValue observeSingleSelectionModulviewer_1 = ViewerProperties.singleSelection().observe(Modulviewer_1);
		IObservableValue benefitsViewermodulfournisseurObserveDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionModulviewer_1, "modulfournisseur", String.class);
		IObservableValue modulfournisseurTextObserveValue = SWTObservables.observeText(txtfournisseur, SWT.Modify);
		bindingContext.bindValue(benefitsViewermodulfournisseurObserveDetailValue, modulfournisseurTextObserveValue, null, null);
		//
		return bindingContext;
	}
}
