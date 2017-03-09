package com.dlas.gui.model;

import java.util.ArrayList;
import java.util.List;

import com.dlas.gui.model.AbstractModelObject;
import com.dlas.gui.model.Benefits;

public class Company extends AbstractModelObject {
	private final List/* <Benefits> */m_benefits = new ArrayList();
	private String m_company;

	public Company() {
	}

	public Company(String name) {
		m_company = name;
	}

	public String getName() {
		return m_company;
	}

	public void setName(String name) {
		String oldValue = m_company;
		m_company = name;
		firePropertyChange("name", oldValue, m_company);
	}

	public void addBenefits(Benefits benefits) {
		m_benefits.add(benefits);
		firePropertyChange("benefits", null, m_benefits);
	}

	public void removeBenefits(Benefits benefits) {
		m_benefits.remove(benefits);
		firePropertyChange("benefits", null, m_benefits);
	}

	public List getBenefits() {
		return m_benefits;
	}
	
	public String getFormula() {
		return "";
	}

	public void setFormula(String formula) {
	}

	public String getFornulename() {
		return "";
	}

	public void setFornulename(String fornulename) {
	}

	public String getPolicynumber() {
		return "";
	}

	public void setPolicynumber(String policynumber) {
	}

	public float getAmount() {
		return 0f;
	}

	public void setAmount(Float amount) {
	}
}