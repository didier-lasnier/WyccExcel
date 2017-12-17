package com.dlas.gui.model;

import java.awt.List;

import javax.persistence.Column;

public class Benefit  extends AbstractModelObject{
	@Column(name = "COMPANY")
	public String company;
	@Column(name = "FORMULA")
	public String formula;
	@Column(name = "FORMULE_NAME")
	public String formulename;
	@Column(name = "POLICY_NUMBER")
	public String policynumber;
	@Column(name = "AMOUNT")
	public String amount;
	
	public Benefit() {
	}


public Benefit(String company, String formula, String formulename, String policynumber, String amount) {
		super();
		this.company = company;
		this.formula = formula;
		this.formulename = formulename;
		this.policynumber = policynumber;
		this.amount = amount;
	}


public Benefit(String company2, String formula2, String formulename2, String policynumber2, float amount2) {
	// TODO Auto-generated constructor stub
	super();
	this.company = company2;
	this.formula = formula2;
	this.formulename = formulename2;
	this.policynumber = policynumber2;
	this.amount = Float.toString(amount2);
}


private List createModel() {
	List elements = null;
	return elements;
}


public String getCompany() {
	return company;
}


public void setCompany(String company) {
	this.company = company;
}


public String getFormula() {
	return formula;
}


public void setFormula(String formula) {
	this.formula = formula;
}


public String getFormulename() {
	return formulename;
}


public void setFormulename(String formulename) {
	this.formulename = formulename;
}


public String getPolicynumber() {
	return policynumber;
}


public void setPolicynumber(String policynumber) {
	this.policynumber = policynumber;
}


public String getAmount() {
	return amount;
}


public void setAmount(String amount) {
	this.amount = amount;
}


}
