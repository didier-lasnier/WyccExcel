package com.dlas.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AGGREGATE_TAB", schema = "PUBLIC")
public class BenefitDb {

	@Id
	@Column(name = "AGGREGATE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer aggregateid;
	
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

	public Integer getAggregateid() {
		return aggregateid;
	}

	public void setAggregateid(Integer aggregateid) {
		this.aggregateid = aggregateid;
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

	public BenefitDb() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BenefitDb(Integer aggregateid, String company, String formula, String formulename, String policynumber,
			String amount) {
		super();
		this.aggregateid = aggregateid;
		this.company = company;
		this.formula = formula;
		this.formulename = formulename;
		this.policynumber = policynumber;
		this.amount = amount;
	}

	
	
	
	
}
