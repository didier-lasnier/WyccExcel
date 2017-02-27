package com.dlas.dao;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Text;

public class ModulList extends Composite {

	private ModulListController m_controller;
	private Text calculmodeText;
	private Text displayorderText;
	private Scale forfaitpercentageScale;
	private Text modulcategoryText;
	private Text modulfournisseurText;
	private Scale modulidScale;
	private Text modullabelText;
	private Text modulpriceText;
	private Text modulscopeText;

	public ModulList(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));

		new Label(this, SWT.NONE).setText("Calculmode:");

		calculmodeText = new Text(this, SWT.BORDER | SWT.SINGLE);
		calculmodeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		new Label(this, SWT.NONE).setText("Displayorder:");

		displayorderText = new Text(this, SWT.BORDER | SWT.SINGLE);
		displayorderText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		new Label(this, SWT.NONE).setText("Forfaitpercentage:");

		forfaitpercentageScale = new Scale(this, SWT.HORIZONTAL);
		forfaitpercentageScale.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		new Label(this, SWT.NONE).setText("Modulcategory:");

		modulcategoryText = new Text(this, SWT.BORDER | SWT.SINGLE);
		modulcategoryText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		new Label(this, SWT.NONE).setText("Modulfournisseur:");

		modulfournisseurText = new Text(this, SWT.BORDER | SWT.SINGLE);
		modulfournisseurText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		new Label(this, SWT.NONE).setText("Modulid:");

		modulidScale = new Scale(this, SWT.HORIZONTAL);
		modulidScale.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		new Label(this, SWT.NONE).setText("Modullabel:");

		modullabelText = new Text(this, SWT.BORDER | SWT.SINGLE);
		modullabelText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		new Label(this, SWT.NONE).setText("Modulprice:");

		modulpriceText = new Text(this, SWT.BORDER | SWT.SINGLE);
		modulpriceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		new Label(this, SWT.NONE).setText("Modulscope:");

		modulscopeText = new Text(this, SWT.BORDER | SWT.SINGLE);
		modulscopeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		m_controller = new ModulListController(this);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public Text getCalculmodeText() {
		return calculmodeText;
	}

	public Text getDisplayorderText() {
		return displayorderText;
	}

	public Scale getForfaitpercentageScale() {
		return forfaitpercentageScale;
	}

	public Text getModulcategoryText() {
		return modulcategoryText;
	}

	public Text getModulfournisseurText() {
		return modulfournisseurText;
	}

	public Scale getModulidScale() {
		return modulidScale;
	}

	public Text getModullabelText() {
		return modullabelText;
	}

	public Text getModulpriceText() {
		return modulpriceText;
	}

	public Text getModulscopeText() {
		return modulscopeText;
	}

}
