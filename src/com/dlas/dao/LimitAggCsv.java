package com.dlas.dao;

import java.awt.List;

public class LimitAggCsv {

		public String company;
		public String formula;
		public String formulename;
		public String policynumber;
		public float  amount;
		
		public LimitAggCsv() {
		}


	public LimitAggCsv(String company, String formula, String formulename, String policynumber, float amount) {
			super();
			this.company = company;
			this.formula = formula;
			this.formulename = formulename;
			this.policynumber = policynumber;
			this.amount = amount;
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


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
		this.amount = amount;
	}


}
