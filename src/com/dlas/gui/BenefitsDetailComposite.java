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
		m_companyText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));

		final Label amountLabel = new Label(this, SWT.NONE);
		amountLabel.setText("Amount:");

		m_amountText = new Text(this, SWT.BORDER);
		m_amountText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false));

		final Label policynumber = new Label(this, SWT.NONE);
		policynumber.setText("Policy Number:");

		m_policynumberText = new Text(this, SWT.BORDER);
		m_policynumberText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false));

		final Label formulenameLabel = new Label(this, SWT.NONE);
		formulenameLabel.setText("Formule name :");

		m_formulenameText = new Text(this, SWT.BORDER);
		m_formulenameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false));

		final Label formulaLabel = new Label(this, SWT.NONE);
		formulaLabel.setText("Formula:");

		m_formulaText = new Text(this, SWT.BORDER);
		m_formulaText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false));
		
		m_bindingContext = initDataBindings();
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

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue m_companyTextTextObserveWidget = SWTObservables.observeText(m_companyText, SWT.Modify);
		IObservableValue benefitsCompanyObserveValue = BeansObservables.observeValue(m_benefits, "company");
		bindingContext.bindValue(m_companyTextTextObserveWidget, benefitsCompanyObserveValue, null, null);
		//
		IObservableValue m_amountTextTextObserveWidget = SWTObservables.observeText(m_amountText, SWT.Modify);
		IObservableValue benefitsAmountObserveValue = BeansObservables.observeValue(m_benefits, "amount");
		bindingContext.bindValue(m_amountTextTextObserveWidget, benefitsAmountObserveValue, null, null);
		//
		IObservableValue m_policynumberTextTextObserveWidget = SWTObservables.observeText(m_policynumberText, SWT.Modify);
		IObservableValue benefitsPolicynumberObserveValue = BeansObservables.observeValue(m_benefits, "policynumber");
		bindingContext.bindValue(m_policynumberTextTextObserveWidget, benefitsPolicynumberObserveValue, null, null);
		//
		IObservableValue m_formulenameTextTextObserveWidget = SWTObservables.observeText(m_formulenameText, SWT.Modify);
		IObservableValue benefitsFormulenameObserveValue = BeansObservables.observeValue(m_benefits, "formulename");
		bindingContext.bindValue(m_formulenameTextTextObserveWidget, benefitsFormulenameObserveValue, null, null);
		//
		IObservableValue m_formulaTextTextObserveWidget = SWTObservables.observeText(m_formulaText, SWT.Modify);
		IObservableValue benefitsFormulaObserveValue = BeansObservables.observeValue(m_benefits, "formula");
		bindingContext.bindValue(m_formulaTextTextObserveWidget, benefitsFormulaObserveValue, null, null);
		//
		return bindingContext;
	}
}
