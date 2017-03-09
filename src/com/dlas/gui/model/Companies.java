package com.dlas.gui.model;


import java.util.ArrayList;
import java.util.List;

public class Companies extends AbstractModelObject {
	private final List/* <PhoneGroup> */m_company = new ArrayList();

	public void addCompany(Company company) {
		m_company.add(company);
		firePropertyChange("companies", null, m_company);
	}

	public void removeGroup(Company company) {
		m_company.remove(company);
		firePropertyChange("companies", null, m_company);
	}

	public List getGroups() {
		return m_company;
	}
}