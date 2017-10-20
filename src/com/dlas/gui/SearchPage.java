package com.dlas.gui;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;

public class SearchPage implements IDetailsPage {

	private IManagedForm managedForm;
	private Text textSupplier;
	private Text textFormula;
	private Text textModule;
	private Text textBoat;
	private Text textPolicyNumber;


	/**
	 * Create the details page.
	 */
	public SearchPage() {
		// Create the details page
	}

	/**
	 * Initialize the details page.
	 * @param form
	 */
	@Override
	public void initialize(IManagedForm form) {
		managedForm = form;
	}

	/**
	 * Create contents of the details page.
	 * @param parent
	 */
	@Override
	public void createContents(Composite parent) {
		FormToolkit toolkit = managedForm.getToolkit();
		parent.setLayout(new FillLayout());
		//		
		Section section = toolkit.createSection(parent, ExpandableComposite.EXPANDED | ExpandableComposite.TITLE_BAR);
		section.setText("Empty Section");
		//
		Composite composite = toolkit.createComposite(section, SWT.NONE);
		toolkit.paintBordersFor(composite);
		section.setClient(composite);
		
		Label lblSupplier = new Label(composite, SWT.NONE);
		lblSupplier.setFont(SWTResourceManager.getFont("Helvetica", 12, SWT.BOLD));
		lblSupplier.setBounds(43, 70, 60, 14);
		toolkit.adapt(lblSupplier, true, true);
		lblSupplier.setText("Supplier :");
		
		textSupplier = new Text(composite, SWT.BORDER);
		textSupplier.setBounds(154, 70, 382, 19);
		textSupplier.setFont(SWTResourceManager.getFont("Helvetica", 12, SWT.BOLD));
		toolkit.adapt(textSupplier, true, true);
		
		Label lblFormula = new Label(composite, SWT.NONE);
		lblFormula.setBounds(43, 100, 59, 14);
		lblFormula.setFont(SWTResourceManager.getFont("Helvetica", 12, SWT.BOLD));
		toolkit.adapt(lblFormula, true, true);
		lblFormula.setText("Formula :");
		
		textFormula = new Text(composite, SWT.BORDER);
		textFormula.setBounds(154, 100, 382, 19);
		textFormula.setFont(SWTResourceManager.getFont("Helvetica", 12, SWT.BOLD));
		toolkit.adapt(textFormula, true, true);
		
		Label lblModule = new Label(composite, SWT.NONE);
		lblModule.setBounds(43, 130, 59, 14);
		lblModule.setFont(SWTResourceManager.getFont("Helvetica", 12, SWT.BOLD));
		toolkit.adapt(lblModule, true, true);
		lblModule.setText("Module :");
		
		textModule = new Text(composite, SWT.BORDER);
		textModule.setBounds(154, 130, 382, 19);
		textModule.setFont(SWTResourceManager.getFont("Helvetica", 12, SWT.BOLD));
		toolkit.adapt(textModule, true, true);
		
		Label lblBoat = new Label(composite, SWT.NONE);
		lblBoat.setBounds(43, 160, 59, 14);
		lblBoat.setFont(SWTResourceManager.getFont("Helvetica", 12, SWT.BOLD));
		toolkit.adapt(lblBoat, true, true);
		lblBoat.setText("Boat :");
		
		textBoat = new Text(composite, SWT.BORDER);
		textBoat.setBounds(154, 160, 382, 19);
		textBoat.setFont(SWTResourceManager.getFont("Helvetica", 12, SWT.BOLD));
		toolkit.adapt(textBoat, true, true);
		
		
		Label lblPolicyNumber = new Label(composite, SWT.NONE);
		lblPolicyNumber.setBounds(43, 160, 59, 14);
		lblPolicyNumber.setFont(SWTResourceManager.getFont("Helvetica", 12, SWT.BOLD));
		toolkit.adapt(lblPolicyNumber, true, true);
		lblPolicyNumber.setText("Policy number :");
		
		textPolicyNumber = new Text(composite, SWT.BORDER);
		textPolicyNumber.setBounds(154, 190, 382, 19);
		textPolicyNumber.setFont(SWTResourceManager.getFont("Helvetica", 12, SWT.BOLD));
		toolkit.adapt(textPolicyNumber, true, true);
		
		Button btnSearch = new Button(composite, SWT.NONE);
		btnSearch.setBounds(436, 263, 100, 40);
		btnSearch.setFont(SWTResourceManager.getFont("Helvetica", 12, SWT.BOLD));
		toolkit.adapt(btnSearch, true, true);
		btnSearch.setText("Search...");

		Button btnCancel = new Button(composite, SWT.NONE);
		btnCancel.setBounds(301, 263, 100, 40);
		btnCancel.setFont(SWTResourceManager.getFont("Helvetica", 12, SWT.BOLD));
		toolkit.adapt(btnCancel, true, true);
		btnCancel.setText("Cancel");
		
		
/*		textSupplier = new Text(composite, SWT.BORDER);
		textSupplier.setBounds(154, 68, 382, 19);
		textSupplier.setFont(SWTResourceManager.getFont("Helvetica", 12, SWT.BOLD));
		toolkit.adapt(textSupplier, true, true);*/
		
	}

	@Override
	public void dispose() {
		// Dispose
	}

	@Override
	public void setFocus() {
		// Set focus
	}

	private void update() {
		// Update
	}

	@Override
	public boolean setFormInput(Object input) {
		return false;
	}

	@Override
	public void selectionChanged(IFormPart part, ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		update();
	}

	@Override
	public void commit(boolean onSave) {
		// Commit
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isStale() {
		return false;
	}

	@Override
	public void refresh() {
		update();
	}
}
