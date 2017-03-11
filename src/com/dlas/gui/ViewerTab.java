package com.dlas.gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import com.dlas.gui.model.Benefits;
import com.dlas.gui.model.Companies;
import com.dlas.gui.model.Company;

import com.dlas.gui.GroupDialog;
import com.dlas.gui.accueil.MenuAccueil;




//import com.jcg.rca.main.PlayerConst;
//import com.jcg.rca.main.PlayerViewerSorter;

public class ViewerTab  {
	private Button deleteCompanyButton;
	private Button newCompanyButton;
	private Table table_1;
	private Button editCompanyButton;
	private TableViewer m_benefitsViewer;
	private TableViewer m_companyViewer;
	private Companies m_companies = new Companies();
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
	
	Display d;
	Shell s;
	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final String APP_NAME = "Wycc invoice";
		
		Display display = new Display();
		shell = new Shell();
		display.setAppName(APP_NAME);

     		Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
			public void run() {

				try {

					ViewerTab window = new ViewerTab();
					window.open();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Open the window
	 */
	public void open() {
		final Display display = Display.getDefault();		
		setDefaultValues();
		createContents();
		MenuAccueil menuaccueil=new MenuAccueil(shell,display,startdate,enddate);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	private void setDefaultValues() {
		Company company = new Company();
		//m_companies.addCompany(company);
	}
	protected void createContents() {

		shell.setLayout(new FillLayout());
		shell.setSize(789, 517);
		shell.setText("Wycc Invoice");
		final SashForm sashForm = new SashForm(shell, SWT.NONE);

		final Composite companyComposite = new Composite(sashForm, SWT.BORDER);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.marginWidth = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.marginHeight = 0;
		companyComposite.setLayout(gridLayout);
		
		// Creation de la barrre des bouton de gestion des companies.
		final Composite compnayToolBarComposite = new Composite(companyComposite, SWT.NONE);
		final GridLayout gridLayout_3 = new GridLayout(3, false);
		compnayToolBarComposite.setLayout(gridLayout_3);
		compnayToolBarComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		// bouton 
		newCompanyButton = new Button(compnayToolBarComposite, SWT.NONE);
		newCompanyButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				Company company = new Company();
				//GroupDialog dialog = new GroupDialog(shell, company, true);
				if (1==1) { //dialog.open() == Window.OK) 
					m_companies.addCompany(shell,company);
					m_companyViewer.setSelection(new StructuredSelection(company),
							true);
					m_bindingContext.updateModels();
				}
			}
		});
		newCompanyButton.setText("Get aggregate");
		

		editCompanyButton = new Button(compnayToolBarComposite, SWT.NONE);
		editCompanyButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection selection = (IStructuredSelection) m_companyViewer
						.getSelection();
				Company group = (Company) selection.getFirstElement();
				//
				GroupDialog dialog = new GroupDialog(shell, group, false);
				dialog.open();
			}
		});
		editCompanyButton.setEnabled(false);
		editCompanyButton.setText("Edit");

		deleteCompanyButton = new Button(compnayToolBarComposite, SWT.NONE);
		deleteCompanyButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection selection = (IStructuredSelection) m_companyViewer
						.getSelection();
				Company company = (Company) selection.getFirstElement();
				boolean confirm = MessageDialog.openConfirm(shell,
						"Confirm Delete",
						"Are you sure you want to delete group '"
								+ company.getCompany() + "'?");
				if (confirm) {
					m_companies.removeCompany(company);
					m_bindingContext.updateModels();
				}
			}
		});
		deleteCompanyButton.setEnabled(false);
		deleteCompanyButton.setText("Delete");
		// Liste des companies
		m_companyViewer = new TableViewer(companyComposite, SWT.NONE);
		table_1 = m_companyViewer.getTable();
		table_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));		
		final SashForm benefitsSashForm = new SashForm(sashForm, SWT.VERTICAL);
		final Composite benefitsComposite = new Composite(benefitsSashForm, SWT.BORDER);
		final GridLayout gridLayout_1 = new GridLayout();
		gridLayout_1.horizontalSpacing = 0;
		gridLayout_1.marginWidth = 0;
		gridLayout_1.verticalSpacing = 0;
		gridLayout_1.marginHeight = 0;
		benefitsComposite.setLayout(gridLayout_1);

		// Bouton de gestion des benefits
		final Composite benefitsToolBar = new Composite(benefitsComposite, SWT.NONE);
		benefitsToolBar.setLayout(new GridLayout(2, false));
		benefitsToolBar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		newBenefitsButton = new Button(benefitsToolBar, SWT.NONE);
		newBenefitsButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection companySelection = (IStructuredSelection) m_companyViewer
				.getSelection();
				Company company = (Company) companySelection.getFirstElement();
				if (company != null) {
					Benefits benefits = new Benefits();
					company.addBenefits(benefits);
					m_benefitsViewer.setSelection(new StructuredSelection(benefits), true);
					m_bindingContext.updateModels();
				}
			}
		});
		newBenefitsButton.setText("New...");
		
		deleteBenefitsButton = new Button(benefitsToolBar, SWT.NONE);
		deleteBenefitsButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection groupSelection = (IStructuredSelection) m_companyViewer
				.getSelection();
				IStructuredSelection benefitsSelection = (IStructuredSelection) m_benefitsViewer
						.getSelection();
				Company company = (Company) benefitsSelection.getFirstElement();
				Benefits benefits = (Benefits) benefitsSelection.getFirstElement();
				boolean confirm = MessageDialog.openConfirm(shell,
						"Confirm Delete",
						"Are you sure you want to delete benefits '"
								+ benefits.getCompany() + "'?");
				if (confirm) {
					company.removeBenefits(benefits);
					m_bindingContext.updateModels();
				}
			}
		});
		deleteBenefitsButton.setEnabled(false);
		deleteBenefitsButton.setText("Delete");
		
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
		benefitsSashForm.setWeights(new int[] { 1, 1 });
		sashForm.setWeights(new int[] {172, 614});
		
		m_bindingContext = initDataBindings();
		//	
	}
	protected DataBindingContext initDataBindings() {
		
		IObservableValue m_benefitsViewerSelectionObserveSelection_1 = ViewersObservables.observeSingleSelection(m_benefitsViewer);
		IObservableValue m_benefitsViewerSelectionObserveSelection_2 = ViewersObservables.observeSingleSelection(m_benefitsViewer);
		IObservableValue m_benefitsViewerSelectionObserveSelection_3 = ViewersObservables.observeSingleSelection(m_benefitsViewer);	
		IObservableValue m_benefitsViewerSelectionObserveSelection_4 = ViewersObservables.observeSingleSelection(m_benefitsViewer);
		IObservableValue m_benefitsViewerSelectionObserveSelection = ViewersObservables.observeSingleSelection(m_benefitsViewer);

		IObservableValue m_benefitsViewerCompanyObserveDetailValue = BeansObservables.observeDetailValue(Realm.getDefault(), m_benefitsViewerSelectionObserveSelection_4, "company", java.lang.String.class);
		IObservableValue m_companyTextTextObserveWidget = SWTObservables.observeText(m_companyText, SWT.Modify);

		IObservableValue m_benefitsViewerFormulaObserveDetailValue = BeansObservables.observeDetailValue(Realm.getDefault(), m_benefitsViewerSelectionObserveSelection_1, "formula", java.lang.String.class);
		IObservableValue m_formulaTextTextObserveWidget = SWTObservables.observeText(m_formulaText, SWT.Modify);

		IObservableValue m_benefitsViewerPolicynumberObserveDetailValue = BeansObservables.observeDetailValue(Realm.getDefault(), m_benefitsViewerSelectionObserveSelection_2, "policynumber", java.lang.String.class);
		IObservableValue m_policynumberTextTextObserveWidget = SWTObservables.observeText(m_policynumberText, SWT.Modify);

		IObservableValue m_benefitsViewerFormulenameObserveDetailValue = BeansObservables.observeDetailValue(Realm.getDefault(), m_benefitsViewerSelectionObserveSelection, "formulename", java.lang.String.class);
		IObservableValue m_formulenameTextTextObserveWidget = SWTObservables.observeText(m_formulenameText, SWT.Modify);

		IObservableValue m_benefitsViewerAmountObserveDetailValue = BeansObservables.observeDetailValue(Realm.getDefault(), m_benefitsViewerSelectionObserveSelection_3, "amount", java.lang.String.class);
		IObservableValue m_amountTextTextObserveWidget = SWTObservables.observeText(m_amountText, SWT.Modify);

		
		IObservableValue table_1SelectionIndexObserveWidget_1 = SWTObservables.observeSingleSelectionIndex(table_1);
		
		IObservableValue m_companyViewerSelectionObserveSelection = ViewersObservables.observeSingleSelection(m_companyViewer);
		
		IObservableValue deleteCompanyButtonEnabledObserveWidget = SWTObservables.observeEnabled(deleteCompanyButton);
		IObservableValue newCompanyButtonEnabledObserveWidget = SWTObservables.observeEnabled(editCompanyButton);
		IObservableValue deleteBenefitsButtonEnabledObserveWidget = SWTObservables.observeEnabled(deleteBenefitsButton);
			
		IObservableValue tableSelectionIndexObserveWidget = SWTObservables.observeSingleSelectionIndex(table);
		IObservableValue table_1SelectionIndexObserveWidget = SWTObservables.observeSingleSelectionIndex(table_1);
		
		//
		DataBindingContext bindingContext = new DataBindingContext();
		//
		bindingContext.bindValue(m_benefitsViewerCompanyObserveDetailValue, m_companyTextTextObserveWidget, null, null);
		bindingContext.bindValue(m_benefitsViewerFormulaObserveDetailValue, m_formulaTextTextObserveWidget, null, null);
		bindingContext.bindValue(m_benefitsViewerPolicynumberObserveDetailValue, m_policynumberTextTextObserveWidget, null, null);
		bindingContext.bindValue(m_benefitsViewerFormulenameObserveDetailValue, m_formulenameTextTextObserveWidget, null, null);
		bindingContext.bindValue(m_benefitsViewerAmountObserveDetailValue, m_amountTextTextObserveWidget, null, null);
		
		bindingContext.bindValue(table_1SelectionIndexObserveWidget_1, newCompanyButtonEnabledObserveWidget, new com.dlas.gui.SelectionUpdateValueStrategy(), new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER));
		bindingContext.bindValue(table_1SelectionIndexObserveWidget, deleteCompanyButtonEnabledObserveWidget, new com.dlas.gui.SelectionUpdateValueStrategy(), new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER));
		bindingContext.bindValue(tableSelectionIndexObserveWidget, deleteBenefitsButtonEnabledObserveWidget, new com.dlas.gui.SelectionUpdateValueStrategy(), new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER));
		/*
		 *  on tarck les changements de data dans la collection company
		 */
		ObservableListContentProvider m_companyViewerContentProviderList = new ObservableListContentProvider();
		m_companyViewer.setContentProvider(m_companyViewerContentProviderList);
		//
		IObservableMap[] m_companyViewerLabelProviderMaps = BeansObservables.observeMaps(m_companyViewerContentProviderList.getKnownElements(), Company.class, new String[]{"company"});
		m_companyViewer.setLabelProvider(new ObservableMapLabelProvider(m_companyViewerLabelProviderMaps));
		//
		IObservableList m_companiesObserveList = BeansObservables.observeList(Realm.getDefault(), m_companies, "companies");
		m_companyViewer.setInput(m_companiesObserveList);
		/*
		 * on track les changements des elements de la liste compny, ce sont les benefits
		 */
		ObservableListContentProvider m_benefitsViewerContentProviderList = new ObservableListContentProvider();
		m_benefitsViewer.setContentProvider(m_benefitsViewerContentProviderList);
		//
		IObservableMap[] m_benefitsViewerLabelProviderMaps = BeansObservables.observeMaps(m_benefitsViewerContentProviderList.getKnownElements(), Benefits.class, new String[]{"company", "formula", "formulename", "policynumber", "amount"});
		m_benefitsViewer.setLabelProvider(new ObservableMapLabelProvider(m_benefitsViewerLabelProviderMaps));
		//
		IObservableList m_companyViewerPersonsObserveDetailList = BeansObservables.observeDetailList(Realm.getDefault(), m_companyViewerSelectionObserveSelection, "benefits", com.dlas.gui.model.Benefits.class);
		m_benefitsViewer.setInput(m_companyViewerPersonsObserveDetailList);
		//
		return bindingContext;
	}


}
