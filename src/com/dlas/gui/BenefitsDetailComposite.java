package com.dlas.gui;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.dlas.gui.model.Benefits;

public class BenefitsDetailComposite extends Composite {

	private Benefits m_benefits = new Benefits();
	
	private Text m_formulaText;
	private Text m_formulenameText;
	private Text m_policynumberText;
	private Text m_amountText;
	private Text m_companyText;
	
	private DataBindingContext m_bindingContext;
	
	public BenefitsDetailComposite(Composite parent, int style) {
		super(parent, style);

		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		setLayout(gridLayout);

		final Label descriptionLabel = new Label(this, SWT.NONE);
		descriptionLabel.setText("Description:");
		new Label(this, SWT.NONE);

		final Label label = new Label(this, SWT.NONE);
		label.setText("Company:");

		m_companyText = new Text(this, SWT.BORDER);
		final GridData gd_m_companyText = new GridData(SWT.FILL, SWT.CENTER, true,
				false);
		m_companyText.setLayoutData(gd_m_companyText);

		final Label amountLabel = new Label(this, SWT.NONE);
		amountLabel.setText("Amount:");

		m_amountText = new Text(this, SWT.BORDER);
		final GridData gd_m_amountText = new GridData(SWT.FILL, SWT.CENTER,
				true, false);
		m_amountText.setLayoutData(gd_m_amountText);

		final Label policynumber = new Label(this, SWT.NONE);
		policynumber.setText("Policy Number:");

		m_policynumberText = new Text(this, SWT.BORDER);
		final GridData gd_m_policynumber = new GridData(SWT.FILL, SWT.CENTER,
				true, false);
		m_policynumberText.setLayoutData(gd_m_policynumber);

		final Label formulenameLabel = new Label(this, SWT.NONE);
		formulenameLabel.setText("Formule name :");

		m_formulenameText = new Text(this, SWT.BORDER);
		final GridData gd_m_formulename = new GridData(SWT.FILL, SWT.CENTER,
				true, false);
		m_formulenameText.setLayoutData(gd_m_formulename);

		final Label formulaLabel = new Label(this, SWT.NONE);
		formulaLabel.setText("Mobile Phone 2:");

		m_formulaText = new Text(this, SWT.BORDER);
		final GridData gd_m_formulaText = new GridData(SWT.FILL, SWT.CENTER,
				true, false);
		m_formulaText.setLayoutData(gd_m_formulaText);
		
		m_bindingContext = initDataBindings();
	}
	protected DataBindingContext initDataBindings() {
		IObservableValue m_amountTextTextObserveWidget = SWTObservables.observeText(m_amountText, SWT.Modify);
		IObservableValue benefitsCompnayObserveValue = BeansObservables.observeValue(m_benefits, "company");
		IObservableValue m_policynumberTextTextObserveWidget = SWTObservables.observeText(m_policynumberText, SWT.Modify);
		IObservableValue m_companyTextTextObserveWidget = SWTObservables.observeText(m_companyText, SWT.Modify);
		IObservableValue benefitsFormulaObserveValue = BeansObservables.observeValue(m_benefits, "formula");
		IObservableValue benefitsFormulenameObserveValue = BeansObservables.observeValue(m_benefits, "formulename");
		IObservableValue m_formulaTextTextObserveWidget = SWTObservables.observeText(m_formulaText, SWT.Modify);
		IObservableValue benefitsAmountObserveValue = BeansObservables.observeValue(m_benefits, "amount");
		IObservableValue benefitsPolicynumberObserveValue = BeansObservables.observeValue(m_benefits, "policynumber");
		IObservableValue m_formulenameTextTextObserveWidget = SWTObservables.observeText(m_formulenameText, SWT.Modify);
		//
		//
		DataBindingContext bindingContext = new DataBindingContext();
		//
		bindingContext.bindValue(m_companyTextTextObserveWidget, benefitsCompnayObserveValue, null, null);
		bindingContext.bindValue(m_amountTextTextObserveWidget, benefitsAmountObserveValue, null, null);
		bindingContext.bindValue(m_policynumberTextTextObserveWidget, benefitsPolicynumberObserveValue, null, null);
		bindingContext.bindValue(m_formulenameTextTextObserveWidget, benefitsFormulenameObserveValue, null, null);
		bindingContext.bindValue(m_formulaTextTextObserveWidget, benefitsFormulaObserveValue, null, null);
		//
		return bindingContext;
	}
	public Benefits getBenefits() {
		return m_benefits;
	}
	public void setBenefits(Benefits benefits) {
		if (m_bindingContext != null) {
			m_bindingContext.dispose();
		}
		this.m_benefits = benefits;
		m_bindingContext = initDataBindings();
	}

}
