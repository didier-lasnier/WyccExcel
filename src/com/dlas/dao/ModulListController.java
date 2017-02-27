package com.dlas.dao;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoObservables;


public class ModulListController {
	private ModulList m_modulList;
	private DataBindingContext m_bindingContext;
	private com.dlas.dao.Modul modul = new com.dlas.dao.Modul();

	public ModulListController(ModulList modulList, com.dlas.dao.Modul newModul) {
		m_modulList = modulList;
		setModul(newModul);
	}

	public ModulListController(ModulList modulList) {
		m_modulList = modulList;
		if (modul != null) {
			m_bindingContext = initDataBindings();
		}
	}

	private DataBindingContext initDataBindings() {
		IObservableValue calculmodeObserveWidget = SWTObservables.observeText(m_modulList.getCalculmodeText(), SWT.Modify);
		IObservableValue calculmodeObserveValue = PojoObservables.observeValue(modul, "calculmode");
		IObservableValue displayorderObserveWidget = SWTObservables.observeText(m_modulList.getDisplayorderText(), SWT.Modify);
		IObservableValue displayorderObserveValue = PojoObservables.observeValue(modul, "displayorder");
		IObservableValue forfaitpercentageObserveWidget = SWTObservables.observeSelection(m_modulList.getForfaitpercentageScale());
		IObservableValue forfaitpercentageObserveValue = PojoObservables.observeValue(modul, "forfaitpercentage");
		IObservableValue modulcategoryObserveWidget = SWTObservables.observeText(m_modulList.getModulcategoryText(), SWT.Modify);
		IObservableValue modulcategoryObserveValue = PojoObservables.observeValue(modul, "modulcategory");
		IObservableValue modulfournisseurObserveWidget = SWTObservables.observeText(m_modulList.getModulfournisseurText(), SWT.Modify);
		IObservableValue modulfournisseurObserveValue = PojoObservables.observeValue(modul, "modulfournisseur");
		IObservableValue modulidObserveWidget = SWTObservables.observeSelection(m_modulList.getModulidScale());
		IObservableValue modulidObserveValue = PojoObservables.observeValue(modul, "modulid");
		IObservableValue modullabelObserveWidget = SWTObservables.observeText(m_modulList.getModullabelText(), SWT.Modify);
		IObservableValue modullabelObserveValue = PojoObservables.observeValue(modul, "modullabel");
		IObservableValue modulpriceObserveWidget = SWTObservables.observeText(m_modulList.getModulpriceText(), SWT.Modify);
		IObservableValue modulpriceObserveValue = PojoObservables.observeValue(modul, "modulprice");
		IObservableValue modulscopeObserveWidget = SWTObservables.observeText(m_modulList.getModulscopeText(), SWT.Modify);
		IObservableValue modulscopeObserveValue = PojoObservables.observeValue(modul, "modulscope");
		//
		DataBindingContext bindingContext = new DataBindingContext();
		//
		bindingContext.bindValue(calculmodeObserveWidget, calculmodeObserveValue, null, null);
		bindingContext.bindValue(displayorderObserveWidget, displayorderObserveValue, null, null);
		bindingContext.bindValue(forfaitpercentageObserveWidget, forfaitpercentageObserveValue, null, null);
		bindingContext.bindValue(modulcategoryObserveWidget, modulcategoryObserveValue, null, null);
		bindingContext.bindValue(modulfournisseurObserveWidget, modulfournisseurObserveValue, null, null);
		bindingContext.bindValue(modulidObserveWidget, modulidObserveValue, null, null);
		bindingContext.bindValue(modullabelObserveWidget, modullabelObserveValue, null, null);
		bindingContext.bindValue(modulpriceObserveWidget, modulpriceObserveValue, null, null);
		bindingContext.bindValue(modulscopeObserveWidget, modulscopeObserveValue, null, null);
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