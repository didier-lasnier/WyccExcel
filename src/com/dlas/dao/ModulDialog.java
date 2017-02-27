package com.dlas.dao;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ModulDialog extends Dialog {

	private DataBindingContext m_bindingContext;
	private com.dlas.dao.Modul modul = new com.dlas.dao.Modul();
	private Text modulidText;
	private Text modulfournisseurText;
	private Text modulcategoryText;
	private Text modullabelText;
	private Text modulpriceText;
	private Text forfaitpercentageText;
	private Text calculmodeText;
	private Text modulscopeText;
	private Text displayorderText;

	/**
	 * @wbp.parser.constructor
	 */
	public ModulDialog(Shell parentShell) {
		super(parentShell);
	}

	public ModulDialog(Shell parentShell, com.dlas.dao.Modul newModul) {
		super(parentShell);
		setModul(newModul, false);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(2, false));

		new Label(container, SWT.NONE).setText("Modulid:");

		modulidText = new Text(container, SWT.BORDER | SWT.SINGLE);
		modulidText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		new Label(container, SWT.NONE).setText("Modulfournisseur:");

		modulfournisseurText = new Text(container, SWT.BORDER | SWT.SINGLE);
		modulfournisseurText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		new Label(container, SWT.NONE).setText("Modulcategory:");

		modulcategoryText = new Text(container, SWT.BORDER | SWT.SINGLE);
		modulcategoryText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		new Label(container, SWT.NONE).setText("Modullabel:");

		modullabelText = new Text(container, SWT.BORDER | SWT.SINGLE);
		modullabelText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		new Label(container, SWT.NONE).setText("Modulprice:");

		modulpriceText = new Text(container, SWT.BORDER | SWT.SINGLE);
		modulpriceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		new Label(container, SWT.NONE).setText("Forfaitpercentage:");

		forfaitpercentageText = new Text(container, SWT.BORDER | SWT.SINGLE);
		forfaitpercentageText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		new Label(container, SWT.NONE).setText("Calculmode:");

		calculmodeText = new Text(container, SWT.BORDER | SWT.SINGLE);
		calculmodeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		new Label(container, SWT.NONE).setText("Modulscope:");

		modulscopeText = new Text(container, SWT.BORDER | SWT.SINGLE);
		modulscopeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		new Label(container, SWT.NONE).setText("Displayorder:");

		displayorderText = new Text(container, SWT.BORDER | SWT.SINGLE);
		displayorderText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		if (modul != null) {
			m_bindingContext = initDataBindings();
		}
		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

	private DataBindingContext initDataBindings() {
		IObservableValue modulidObserveWidget = SWTObservables.observeText(modulidText, SWT.None);
		IObservableValue modulidObserveValue = PojoObservables.observeValue(modul, "modulid");
		IObservableValue modulfournisseurObserveWidget = SWTObservables.observeText(modulfournisseurText, SWT.Modify);
		IObservableValue modulfournisseurObserveValue = PojoObservables.observeValue(modul, "modulfournisseur");
		IObservableValue modulcategoryObserveWidget = SWTObservables.observeText(modulcategoryText, SWT.Modify);
		IObservableValue modulcategoryObserveValue = PojoObservables.observeValue(modul, "modulcategory");
		IObservableValue modullabelObserveWidget = SWTObservables.observeText(modullabelText, SWT.Modify);
		IObservableValue modullabelObserveValue = PojoObservables.observeValue(modul, "modullabel");
		IObservableValue modulpriceObserveWidget = SWTObservables.observeText(modulpriceText, SWT.Modify);
		IObservableValue modulpriceObserveValue = PojoObservables.observeValue(modul, "modulprice");
		IObservableValue forfaitpercentageObserveWidget = SWTObservables.observeText(forfaitpercentageText, SWT.Modify);
		IObservableValue forfaitpercentageObserveValue = PojoObservables.observeValue(modul, "forfaitpercentage");
		IObservableValue calculmodeObserveWidget = SWTObservables.observeText(calculmodeText, SWT.Modify);
		IObservableValue calculmodeObserveValue = PojoObservables.observeValue(modul, "calculmode");
		IObservableValue modulscopeObserveWidget = SWTObservables.observeText(modulscopeText, SWT.Modify);
		IObservableValue modulscopeObserveValue = PojoObservables.observeValue(modul, "modulscope");
		IObservableValue displayorderObserveWidget = SWTObservables.observeText(displayorderText, SWT.Modify);
		IObservableValue displayorderObserveValue = PojoObservables.observeValue(modul, "displayorder");
		//
		DataBindingContext bindingContext = new DataBindingContext();
		//
		bindingContext.bindValue(modulidObserveWidget, modulidObserveValue,
				new org.eclipse.core.databinding.UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER),
				new org.eclipse.core.databinding.UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER));
		bindingContext.bindValue(modulfournisseurObserveWidget, modulfournisseurObserveValue, null, null);
		bindingContext.bindValue(modulcategoryObserveWidget, modulcategoryObserveValue, null, null);
		bindingContext.bindValue(modullabelObserveWidget, modullabelObserveValue, null, null);
		bindingContext.bindValue(modulpriceObserveWidget, modulpriceObserveValue, null, null);
		bindingContext.bindValue(forfaitpercentageObserveWidget, forfaitpercentageObserveValue, null, null);
		bindingContext.bindValue(calculmodeObserveWidget, calculmodeObserveValue, null, null);
		bindingContext.bindValue(modulscopeObserveWidget, modulscopeObserveValue, null, null);
		bindingContext.bindValue(displayorderObserveWidget, displayorderObserveValue, null, null);
		//
		return bindingContext;
	}

	public com.dlas.dao.Modul getModul() {
		return modul;
	}

	public void setModul(com.dlas.dao.Modul newModul) {
		setModul(newModul, true);
	}

	public void setModul(com.dlas.dao.Modul newModul, boolean update) {
		modul = newModul;
		if (update) {
			if (m_bindingContext != null) {
				m_bindingContext.dispose();
				m_bindingContext = null;
			}
			if (modul != null) {
				m_bindingContext = initDataBindings();
			}
		}
	}

}
