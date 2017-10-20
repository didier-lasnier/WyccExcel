package com.dlas.gui;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class ModulBoatListe implements IDetailsPage {

	private IManagedForm managedForm;
	private Table listmoduleboat;

	/**
	 * Create the details page.
	 */
	public ModulBoatListe() {
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
		section.setText("Module per client");
		//
		Composite composite = toolkit.createComposite(section, SWT.NONE);
		toolkit.paintBordersFor(composite);
		section.setClient(composite);
		
		listmoduleboat = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		listmoduleboat.setBounds(10, 10, 578, 265);
		toolkit.adapt(listmoduleboat);
		toolkit.paintBordersFor(listmoduleboat);
		listmoduleboat.setHeaderVisible(true);
		listmoduleboat.setLinesVisible(true);
		
		TableColumn tblclmnModulid = new TableColumn(listmoduleboat, SWT.NONE);
		tblclmnModulid.setWidth(48);
		tblclmnModulid.setText("id");
		
		TableColumn tblclmnboat = new TableColumn(listmoduleboat, SWT.NONE);
		tblclmnboat.setWidth(100);
		tblclmnboat.setText("Boat");
		
		TableColumn tblclmnsupplier = new TableColumn(listmoduleboat, SWT.NONE);
		tblclmnsupplier.setWidth(100);
		tblclmnsupplier.setText("Supplier");
		
		TableColumn tblclmnlabel = new TableColumn(listmoduleboat, SWT.NONE);
		tblclmnlabel.setWidth(100);
		tblclmnlabel.setText("Formule");
		
		TableColumn tblclmnmodule = new TableColumn(listmoduleboat, SWT.NONE);
		tblclmnmodule.setWidth(100);
		tblclmnmodule.setText("Module");
		
		TableColumn tblclmnpricesingle = new TableColumn(listmoduleboat, SWT.NONE);
		tblclmnpricesingle.setWidth(100);
		tblclmnpricesingle.setText("Price (Single)");
		
		TableColumn tblclmnpricefamily = new TableColumn(listmoduleboat, SWT.NONE);
		tblclmnpricefamily.setWidth(100);
		tblclmnpricefamily.setText("Price (Family)");
	}

	@Override
	public void dispose() {
		Shell s = new Shell();
		MessageBox messageBox = new MessageBox(s, SWT.ICON_QUESTION | SWT.YES | SWT.NO);					
		messageBox.setMessage("Do you really want to exit? ");
		messageBox.setText("Exiting Application");
		int response = messageBox.open();
		s.close();
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
