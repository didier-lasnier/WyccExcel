package com.dlas.gui;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.dlas.dao.ModulBoat;
import com.dlas.dao.ObjectDao;
import com.dlas.gui.model.ModulBoatModel;
import com.dlas.tools.XlsImpExp;

public class ModuleListeBoat {
	private    DataBindingContext             m_bindingContext                              ;
	private    static Shell                   shellModul                                    ;
	static     ModuleListeBoat                window                                        ;
	private    ModulBoat                      modulboat                                     ; 
	private    TableViewer                    modulboatviewer_1                             ;
	private    Text                           txtmodulid                                    ;
	private    Text                           txtfournisseur                                ;
	private    Text                           txtformula                                    ;
	private    Text                           txtmodule                                     ;
	private    Text                           txtboat                                      ;
	private    Text                           txtcalculmode                                 ;
	private    Text                           txtpricesingle                                ;
	private    Text                           txtpricefamily                                ;
	private    Text                           txtscope                                      ;
	private    Text                           txtforfait                                    ;
	private    Table                          modulboattable                                ;
    private    TableViewer                    modulboatviewer                               ;
    private    DataBindingContext             m_modulcontext                                ;
	private    Display                        display                                       ;        
	private    ModulBoatModel                 m_modulboatmodels       =new ModulBoatModel() ;
	protected  static Shell                   shell                                         ;
	private    static String                  APP_NAME                = "Wycc invoice"      ;
   
	private    static Integer                DisplayStatus            =0                    ;
	private    List<ModulBoat>               deletemodulboat          =new ArrayList()      ;
	
	public ModuleListeBoat(){
	}
	public static Logger logger = LogManager.getLogger("wycc");
	private Text text;
	private Text textbankfee;
	private Text textsurcom;
	private Text textinvoicingperiod;
	private Text textPolicyNumber;
	private Text textAggregateAmount;
	/**
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shellModul=new Shell();
		shellModul.setBackground(SWTResourceManager.getColor(245, 255, 250));
		shellModul.setSize(961, 562);
		RowLayout rl_shellModul = new RowLayout(SWT.HORIZONTAL);
		rl_shellModul.marginLeft = 15;
		shellModul.setLayout(rl_shellModul);
		
		SashForm buttonBar = new SashForm(shellModul, SWT.BORDER | SWT.SMOOTH);
		buttonBar.setLayoutData(new RowData(935, SWT.DEFAULT));
		
		Composite btnrecord = new Composite(buttonBar, SWT.NONE);
		btnrecord.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Button btnAddRecord = new Button(btnrecord, SWT.NONE);
		btnAddRecord.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				ModulBoat newmodul=new ModulBoat();
			
				m_modulboatmodels.addOneModul(shellModul, newmodul, window);
				modulboatviewer_1.refresh();
				
				Integer selection= m_modulboatmodels.getSize()-1;			
				newmodul=(ModulBoat) modulboatviewer_1.getElementAt(selection);
				ISelection Sel = new StructuredSelection(modulboatviewer_1.getElementAt(selection));
				modulboatviewer_1.setSelection(Sel,true);
				

			}
		});
		btnAddRecord.setText("Add");
		
		Button btnDeleteRecord = new Button(btnrecord, SWT.NONE);
		btnDeleteRecord.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				int index = modulboatviewer_1.getTable().getSelectionIndex();
				if (index >=0){
				ModulBoat lemodultodel=(ModulBoat) modulboatviewer_1.getElementAt(index);
				deletemodulboat.add(lemodultodel);
				m_modulboatmodels.removeModulofIndex(index);
				}
				modulboatviewer_1.refresh();
			}
		});
		btnDeleteRecord.setText("Delete");
		
		Button btnImport = new Button(btnrecord, SWT.NONE);
		btnImport.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				XlsImpExp xlsprocess = new XlsImpExp();
				xlsprocess.getFileXlstoImp("open");
				xlsprocess.readxlsFileToList(xlsprocess.getFiletoprocess());
				xlsprocess.setDisplay(display);
				 m_modulboatmodels.getM_modulboats().removeAll(m_modulboatmodels.getM_modulboats());
				 try {
					window.setDefaultValues(display);
				} catch (InvocationTargetException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnImport.setText("Import");
		
		Button btnExport = new Button(btnrecord, SWT.NONE);
		btnExport.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				XlsImpExp xlsprocess = new XlsImpExp();
				xlsprocess.getFileXlstoImp("save");
				xlsprocess.writexlsFileToList(xlsprocess.getFiletoprocess(), m_modulboatmodels.getM_modulboats());
			}
		});
		btnExport.setText("Export");
		
		Button btnSearch = new Button(btnrecord, SWT.NONE);
		btnExport.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				//
				String info=" The feature is under development !";
				javax.swing.JOptionPane.showMessageDialog(null,info); 
			}
		});
		btnSearch.setText("Search");

		
		
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
				myobj.setLafactory(myobj.getFactory());
				Session lasession = myobj.getSession(myobj.getLafactory());
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
				  myobj.getLafactory().close();
				 shellModul.getShell().setVisible(false);
			}
		});
		btnSave.setBounds(176, 0, 127, 26);
		btnSave.setText("Save (and close)");
		//buttonBar.setWeights(new int[] {1, 1, 1});
		
		SashForm Tablearea = new SashForm(shellModul, SWT.VERTICAL);
		Tablearea.setLayoutData(new RowData(936, 228));
		
		Composite tableareacomposite = new Composite(Tablearea, SWT.NONE);
		Tablearea.setSize(937, 228);
		modulboatviewer_1 = new TableViewer(tableareacomposite, SWT.FULL_SELECTION);
		modulboattable = modulboatviewer_1.getTable();
		modulboattable.setLocation(0, 0);
		modulboattable.setHeaderVisible(true);
		modulboattable.setLinesVisible(true);
		modulboattable.setSize(937, 228);
		modulboattable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		
		TableColumn tblclmnid = new TableColumn(modulboattable, SWT.RIGHT );
		tblclmnid.setWidth(80);
		tblclmnid.setText("Identifier");
		
		TableColumn tblclmnsupplier = new TableColumn(modulboattable, SWT.LEFT);
		tblclmnsupplier.setWidth(120);
		tblclmnsupplier.setText("Supplier");
		
		TableColumn tblclmnformula = new TableColumn(modulboattable, SWT.LEFT);
		tblclmnformula.setWidth(120);
		tblclmnformula.setText("Formula");
		
		TableColumn tblclmnmodule = new TableColumn(modulboattable, SWT.LEFT);
		tblclmnmodule.setWidth(120);
		tblclmnmodule.setText("Module");

		TableColumn tblclmnboat = new TableColumn(modulboattable, SWT.LEFT);
		tblclmnboat.setWidth(120);
		tblclmnboat.setText("Boat");
		
		TableColumn tblclmnpricesingle = new TableColumn(modulboattable, SWT.RIGHT);
		tblclmnpricesingle.setWidth(80);
		tblclmnpricesingle.setText("Price (Single)");
		
		TableColumn tblclmnpricefamily = new TableColumn(modulboattable, SWT.RIGHT);
		tblclmnpricefamily.setWidth(80);
		tblclmnpricefamily.setText("Price (Family)");
		
		TableColumn tblclmnpercantage = new TableColumn(modulboattable, SWT.RIGHT);
		tblclmnpercantage.setWidth(35);
		tblclmnpercantage.setText("%");
		
		TableColumn tblclmnModulScope = new TableColumn(modulboattable, SWT.LEFT);
		tblclmnModulScope.setWidth(80);
		tblclmnModulScope.setText("Scope");
		
		TableColumn tblclmninvoicingperiod = new TableColumn(modulboattable, SWT.RIGHT);
		tblclmninvoicingperiod.setWidth(100);
		tblclmninvoicingperiod.setText("Invoicing period");
		
		TableColumn tblclmnMode = new TableColumn(modulboattable, SWT.LEFT);
		tblclmnMode.setWidth(100);
		tblclmnMode.setText("mode");
		
		TableColumn tblclmnbankfee = new TableColumn(modulboattable, SWT.RIGHT);
		tblclmnbankfee.setWidth(100);
		tblclmnbankfee.setText("Bank fee");
		
		TableColumn tblclmnsurcom = new TableColumn(modulboattable, SWT.RIGHT);
		tblclmnsurcom.setWidth(100);
		tblclmnsurcom.setText("Sur Com");

		TableColumn tblpolicynumbercom = new TableColumn(modulboattable, SWT.RIGHT);
		tblpolicynumbercom.setWidth(100);
		tblpolicynumbercom.setText("Policy number");
		
		TableColumn tblclmnaggregateamount = new TableColumn(modulboattable, SWT.RIGHT);
		tblclmnaggregateamount.setWidth(100);
		tblclmnaggregateamount.setText("Aggregate Amount");
		
		
		Tablearea.setWeights(new int[] {1});
		
		Composite recordcomposite = new Composite(shellModul, SWT.BORDER);
		recordcomposite.setLayoutData(new RowData(937, 225));
		
		Label lblModulId = new Label(recordcomposite, SWT.NONE);
		lblModulId.setBounds(5, 20, 59, 14);
		lblModulId.setText("Identifier :");
		txtmodulid = new Text(recordcomposite, SWT.READ_ONLY);
		txtmodulid.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		txtmodulid.setEnabled(false);
		txtmodulid.setBounds(96, 0, 86, 19);
		
		Label lblSupplier = new Label(recordcomposite, SWT.NONE);
		lblSupplier.setBounds(5, 54, 59, 14);
		lblSupplier.setText("Supplier:");
		txtfournisseur = new Text(recordcomposite, SWT.BORDER);
		txtfournisseur.setBounds(113, 16, 501, 26);
		
		Label lblFormula = new Label(recordcomposite, SWT.NONE);
		lblFormula.setBounds(5, 88, 59, 14);
		lblFormula.setText("Formula:");
		txtformula = new Text(recordcomposite, SWT.BORDER);
		txtformula.setBounds(113, 58, 501, 26);
		
		
		Label lblmodule = new Label(recordcomposite, SWT.NONE);
		lblmodule.setBounds(5, 122, 59, 14);
		lblmodule.setText("Module:");
		txtmodule = new Text(recordcomposite, SWT.BORDER);
		txtmodule.setBounds(113, 100, 501, 26);
				
				Label lblCalculMode = new Label(recordcomposite, SWT.NONE);
				lblCalculMode.setBounds(643, 16, 97, 14);
				lblCalculMode.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
				lblCalculMode.setText("Calcul mode:");
				//txtpricefamily
						Label lblPricefamily = new Label(recordcomposite, SWT.NONE);
						lblPricefamily.setBounds(643, 46, 97, 14);
						lblPricefamily.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
						lblPricefamily.setText("Price family :");
						
						
						Label lblPricesingle = new Label(recordcomposite, SWT.NONE);
						lblPricesingle.setBounds(643, 76, 97, 14);
						lblPricesingle.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
						lblPricesingle.setText("Price single :");
						txtcalculmode = new Text(recordcomposite, SWT.BORDER);
						txtcalculmode.setBounds(786, 5, 105, 26);
						txtpricefamily = new Text(recordcomposite, SWT.BORDER | SWT.RIGHT);
						txtpricefamily.setBounds(786, 36, 105, 26);
						txtpricesingle = new Text(recordcomposite, SWT.BORDER | SWT.RIGHT);
						txtpricesingle.setBounds(786, 67, 105, 26);
						
						Label lblScope = new Label(recordcomposite, SWT.NONE);
						lblScope.setBounds(382, 0, 59, 14);
						lblScope.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
						lblScope.setText("Scope:");
						
						txtscope = new Text(recordcomposite, SWT.READ_ONLY);
						txtscope.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
						txtscope.setEnabled(false);
						txtscope.setEditable(false);
						txtscope.setBounds(457, -3, 147, 17);
						
						Label lblForfaitpercentage = new Label(recordcomposite, SWT.NONE);
						lblForfaitpercentage.setBounds(643, 106, 119, 14);
						lblForfaitpercentage.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
						lblForfaitpercentage.setText("Forfait/percentage:");
						
						txtforfait = new Text(recordcomposite, SWT.BORDER | SWT.RIGHT);
						txtforfait.setBounds(786, 98, 105, 26);
						
						Label labelBoat = new Label(recordcomposite, SWT.NONE);
						labelBoat.setText("Boat:");
						labelBoat.setBounds(5, 156, 59, 14);
						txtboat = new Text(recordcomposite, SWT.BORDER);
						txtboat.setBounds(113, 142, 501, 26);
						
						Label lblBankFee = new Label(recordcomposite, SWT.NONE);
						lblBankFee.setText("Bank fee :");
						lblBankFee.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
						lblBankFee.setBounds(643, 166, 97, 14);
						
						textbankfee = new Text(recordcomposite, SWT.BORDER | SWT.RIGHT);
						textbankfee.setBounds(786, 160, 105, 26);
						
						Label lblSurCom = new Label(recordcomposite, SWT.NONE);
						lblSurCom.setText("Sur com :");
						lblSurCom.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
						lblSurCom.setBounds(643, 196, 97, 14);
						
						textsurcom = new Text(recordcomposite, SWT.BORDER | SWT.RIGHT);
						textsurcom.setBounds(786, 191, 105, 26);
						
						textinvoicingperiod = new Text(recordcomposite, SWT.BORDER);
						textinvoicingperiod.setBounds(786, 130, 147, 26);
						
						Label lblInvoicingPeriod = new Label(recordcomposite, SWT.NONE);
						lblInvoicingPeriod.setText("Invoicing period:");
						lblInvoicingPeriod.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
						lblInvoicingPeriod.setBounds(643, 137, 139, 14);
						
						textPolicyNumber = new Text(recordcomposite, SWT.BORDER);
						textPolicyNumber.setBounds(113, 188, 147, 26);
						
						Label lblPolicyNumber = new Label(recordcomposite, SWT.NONE);
						lblPolicyNumber.setText("Policy number :");
						lblPolicyNumber.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
						lblPolicyNumber.setBounds(5, 194, 97, 14);
						
						Label lblAggregateAmount = new Label(recordcomposite, SWT.NONE);
						lblAggregateAmount.setText("Aggregate amount :");
						lblAggregateAmount.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
						lblAggregateAmount.setBounds(432, 196, 59, 14);
						
						textAggregateAmount = new Text(recordcomposite, SWT.BORDER | SWT.RIGHT);
						textAggregateAmount.setBounds(509, 188, 105, 26);

		m_modulcontext= initDataBindings();
	}


	protected DataBindingContext initDataBindings() {

		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		modulboatviewer_1.setContentProvider(listContentProvider);
		//
		IObservableMap[] observeMaps = PojoObservables.observeMaps(listContentProvider.getKnownElements(), ModulBoat.class, new String[]{"modulid","modul_fournisseur","modullabel","modulecategory","modulboat","modulpricesingle","modulpricefamily","forfaitpercentage","modulscope","invoiceperiod","calculmode","bankfee","surcom","policynumber","aggregateamount"});
		modulboatviewer_1.setLabelProvider(new ObservableMapLabelProvider(observeMaps));		

       //
		IObservableList ModulObserveList = BeanProperties.list(ModulBoatModel.class,"m_modulboats").observe(m_modulboatmodels);		
		modulboatviewer_1.setInput(ModulObserveList);
		

		IObservableValue observeSingleSelectionmodulboatviewerid = ViewerProperties.singleSelection().observe(modulboatviewer_1);
		IObservableValue modulboatvieweridObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionmodulboatviewerid,"modulid",Double.class);
		IObservableValue textidTextObserveValue = SWTObservables.observeText(txtmodulid,SWT.NONE);
		bindingContext.bindValue(modulboatvieweridObservableDetailValue, textidTextObserveValue, null, new ViewerUpdateValueStrategy());
			
		IObservableValue observeSingleSelectionmodulboatviewersupplier = ViewerProperties.singleSelection().observe(modulboatviewer_1);
		IObservableValue modulboatviewersupplierObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionmodulboatviewersupplier,"modul_fournisseur",String.class);
		IObservableValue textsupplierTextObserveValue = SWTObservables.observeText(txtfournisseur,SWT.Modify);
		bindingContext.bindValue(modulboatviewersupplierObservableDetailValue, textsupplierTextObserveValue, null, new ViewerUpdateValueStrategy());

		IObservableValue observeSingleSelectionmodulboatviewerformula = ViewerProperties.singleSelection().observe(modulboatviewer_1);
		IObservableValue modulboatviewerformulaObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionmodulboatviewerformula,"modullabel",String.class);
		IObservableValue textformulaTextObserveValue = SWTObservables.observeText(txtformula,SWT.Modify);
		bindingContext.bindValue(modulboatviewerformulaObservableDetailValue, textformulaTextObserveValue, null, new ViewerUpdateValueStrategy());
	
		IObservableValue observeSingleSelectionmodulboatviewermodule = ViewerProperties.singleSelection().observe(modulboatviewer_1);
		IObservableValue modulboatviewermoduleObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionmodulboatviewermodule,"modulecategory",String.class);
		IObservableValue textmoduleTextObserveValue = SWTObservables.observeText(txtmodule,SWT.Modify);
		bindingContext.bindValue(modulboatviewermoduleObservableDetailValue, textmoduleTextObserveValue, null, new ViewerUpdateValueStrategy());
	
		IObservableValue observeSingleSelectionmodulboatviewerboat = ViewerProperties.singleSelection().observe(modulboatviewer_1);
		IObservableValue modulboatviewerboatObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionmodulboatviewerboat,"modulboat",String.class);
		IObservableValue textboatTextObserveValue = SWTObservables.observeText(txtboat,SWT.Modify);
		bindingContext.bindValue(modulboatviewerboatObservableDetailValue, textboatTextObserveValue, null, new ViewerUpdateValueStrategy());

		IObservableValue observeSingleSelectionmodulboatviewercalculmode = ViewerProperties.singleSelection().observe(modulboatviewer_1);
		IObservableValue modulboatviewercalculmodeObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionmodulboatviewercalculmode,"calculmode",String.class);
		IObservableValue textcalculmodeTextObserveValue = SWTObservables.observeText(txtcalculmode,SWT.Modify);
		bindingContext.bindValue(modulboatviewercalculmodeObservableDetailValue, textcalculmodeTextObserveValue, null, new ViewerUpdateValueStrategy());
		
		IObservableValue observeSingleSelectionmodulboatviewerpricefamily = ViewerProperties.singleSelection().observe(modulboatviewer_1);
		IObservableValue modulboatviewerfamilyObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionmodulboatviewerpricefamily,"modulpricefamily",Float.class);
		IObservableValue textfamilyTextObserveValue = SWTObservables.observeText(txtpricefamily,SWT.Modify);
		bindingContext.bindValue(modulboatviewerfamilyObservableDetailValue, textfamilyTextObserveValue, null, new ViewerUpdateValueStrategy());
		
		IObservableValue observeSingleSelectionmodulboatviewerpricesingle = ViewerProperties.singleSelection().observe(modulboatviewer_1);
		IObservableValue modulboatviewersingleObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionmodulboatviewerpricesingle,"modulpricesingle",Float.class);
		IObservableValue textsingleTextObserveValue = SWTObservables.observeText(txtpricesingle,SWT.Modify);
		bindingContext.bindValue(modulboatviewersingleObservableDetailValue, textsingleTextObserveValue, null, new ViewerUpdateValueStrategy());		
	
		IObservableValue observeSingleSelectionmodulboatviewerpercentage = ViewerProperties.singleSelection().observe(modulboatviewer_1);
		IObservableValue modulboatviewerpercentageObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionmodulboatviewerpercentage,"forfaitpercentage",Double.class);
		IObservableValue textpercentageTextObserveValue = SWTObservables.observeText(txtforfait,SWT.Modify);
		bindingContext.bindValue(modulboatviewerpercentageObservableDetailValue, textpercentageTextObserveValue, null, new ViewerUpdateValueStrategy());	

		IObservableValue observeSingleSelectionmodulboatviewerscope = ViewerProperties.singleSelection().observe(modulboatviewer_1);
		IObservableValue modulboatviewerscopeObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionmodulboatviewerscope,"modulscope",String.class);
		IObservableValue textscopeTextObserveValue = SWTObservables.observeText(txtscope,SWT.Modify);
		bindingContext.bindValue(modulboatviewerscopeObservableDetailValue, textscopeTextObserveValue, null, new ViewerUpdateValueStrategy());

		IObservableValue observeSingleSelectionmodulboatviewerbankfee = ViewerProperties.singleSelection().observe(modulboatviewer_1);
		IObservableValue modulboatviewerbankfeeObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionmodulboatviewerbankfee,"bankfee",Float.class);
		IObservableValue textbankfeeTextObserveValue = SWTObservables.observeText(textbankfee,SWT.Modify);
		bindingContext.bindValue(modulboatviewerbankfeeObservableDetailValue, textbankfeeTextObserveValue, null, new ViewerUpdateValueStrategy());
		
		IObservableValue observeSingleSelectionmodulboatviewersurcom = ViewerProperties.singleSelection().observe(modulboatviewer_1);
		IObservableValue modulboatviewersurcomObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionmodulboatviewersurcom,"surcom",Float.class);
		IObservableValue textsurcomTextObserveValue = SWTObservables.observeText(textsurcom,SWT.Modify);
		bindingContext.bindValue(modulboatviewersurcomObservableDetailValue, textsurcomTextObserveValue, null, new ViewerUpdateValueStrategy());
		
		IObservableValue observeSingleSelectionmodulboatviewerinvoiceperiod = ViewerProperties.singleSelection().observe(modulboatviewer_1);
		IObservableValue modulboatviewerinvoiceperiodObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionmodulboatviewerinvoiceperiod,"invoiceperiod",String.class);
		IObservableValue textinvoiceperiodTextObserveValue = SWTObservables.observeText(textinvoicingperiod,SWT.Modify);
		bindingContext.bindValue(modulboatviewerinvoiceperiodObservableDetailValue, textinvoiceperiodTextObserveValue, null, new ViewerUpdateValueStrategy());
		
		IObservableValue observeSingleSelectionmodulboatviewerpolicynumber = ViewerProperties.singleSelection().observe(modulboatviewer_1);
		IObservableValue modulboatviewerpolicynumberObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionmodulboatviewerpolicynumber,"policynumber",String.class);
		IObservableValue textpolicynumberTextObserveValue = SWTObservables.observeText(textPolicyNumber,SWT.Modify);
		bindingContext.bindValue(modulboatviewerpolicynumberObservableDetailValue, textpolicynumberTextObserveValue, null, new ViewerUpdateValueStrategy());
		
		IObservableValue observeSingleSelectionmodulboatvieweraggregateamount = ViewerProperties.singleSelection().observe(modulboatviewer_1);
		IObservableValue modulboatvieweraggregateamountObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionmodulboatvieweraggregateamount,"aggregateamount",Float.class);
		IObservableValue textaggregateamountTextObserveValue = SWTObservables.observeText(textAggregateAmount,SWT.Modify);
		bindingContext.bindValue(modulboatvieweraggregateamountObservableDetailValue, textaggregateamountTextObserveValue, null, new ViewerUpdateValueStrategy());
		
		
		
		
		return bindingContext;
	}


	class ViewerUpdateValueStrategy extends UpdateValueStrategy {
		@Override
		protected IStatus doSet(IObservableValue observableValue, Object value) {
			
			//Realm.getDefault().  
			observableValue.getRealm().asyncExec(new Runnable() {
				@Override
				public void run() {
					modulboatviewer_1.refresh();
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
		modulboatviewer_1.refresh();
		while (!shellModul.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		return 0;
	}	
	
	public void setDefaultValues(Display display) throws InvocationTargetException, InterruptedException {
		window=this;
		this.display=display;

		Shell shell = new Shell();
		IRunnableWithProgress op = new ProgressBarDb("Database initialisation",shell, window);
		
		new ProgressMonitorDialog(shell).run(true, true, op);
		shell.close();
		
	}
		
	public List<ModulBoat> getListmodul() {
		
		ObjectDao myobj = new ObjectDao();
		myobj.setLafactory(myobj.getFactory());
		Session lasession = myobj.getSession(myobj.getLafactory());
		
		
		List<ModulBoat> resultdistinct = null;
		try {
			lasession.beginTransaction();
			Query query = lasession.createQuery("from ModulBoat");		
			resultdistinct = query.list();
			lasession.getTransaction().commit();
			lasession.close();
			myobj.getLafactory().close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		return resultdistinct;
	}
	
	
	public static void Moduldisplay(Display display) {		
		Display.setAppName(APP_NAME);

		/*
		 *  On détermine le dossier d'execution du jar
		 * 
		 */
		URL url = ModuleListeBoat.class.getProtectionDomain().getCodeSource().getLocation(); //Gets the path
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


    public void ObservableValuecalculmode( TableViewer modulboatviewer,DataBindingContext bindingContext,String attr,Text displayzone ){
		IObservableValue observeSingleSelectionmodulboatviewer = ViewerProperties.singleSelection().observe(modulboatviewer);
		IObservableValue modulboatviewercalculmodeObservableDetailValue = BeansObservables.observeDetailValue(observeSingleSelectionmodulboatviewer,attr,String.class);
		IObservableValue textCalculmodeTextObserveValue = SWTObservables.observeText(displayzone,SWT.Modify);
		bindingContext.bindValue(modulboatviewercalculmodeObservableDetailValue, textCalculmodeTextObserveValue, null, new ViewerUpdateValueStrategy());
	
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
	
	

    public  class ProgressBarDb implements IRunnableWithProgress {
		 private String           message;
		 private Shell            shellModul;
		 private ModuleListeBoat  moduleliste;
		 
		 
		public ProgressBarDb(String message,Shell        shellModul, ModuleListeBoat  moduleliste){
			
           this.message       = message;
           this.shellModul    = shellModul;
           this.moduleliste   = moduleliste;
           
		}
		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			    monitor.beginTask(message, IProgressMonitor.UNKNOWN);
			    monitor.worked(1);
				
				
			    List<ModulBoat> templist= getListmodul();
			  	m_modulboatmodels.addModuls(shellModul, templist, moduleliste);
				monitor.worked(1);

			 monitor.done();
		}
		
	}
    
}

