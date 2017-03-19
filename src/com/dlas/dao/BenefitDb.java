package com.dlas.dao;

import java.util.Date;

import org.hibernate.annotations.Columns;

import com.dlas.gui.model.Benefit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AGGREGATE_TAB", schema = "PUBLIC")
public class BenefitDb extends Benefit {

	@Id
	@Column(name = "AGGREGATE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long aggregateid;
	
	
	public long getAggregateid() {
		return aggregateid;
	}

	public void setAggregateid(long aggregateid) {
		this.aggregateid = aggregateid;
	}
	@Override
	public String getCompany() {
		// TODO Auto-generated method stub
		return super.getCompany();
	}

	@Override
	public void setCompany(String company) {
		// TODO Auto-generated method stub
		super.setCompany(company);
	}

	@Override
	public String getFormula() {
		// TODO Auto-generated method stub
		return super.getFormula();
	}

	@Override
	public void setFormula(String formula) {
		// TODO Auto-generated method stub
		super.setFormula(formula);
	}

	@Override
	public String getFormulename() {
		// TODO Auto-generated method stub
		return super.getFormulename();
	}

	@Override
	public void setFormulename(String formulename) {
		// TODO Auto-generated method stub
		super.setFormulename(formulename);
	}

	@Override
	public String getPolicynumber() {
		// TODO Auto-generated method stub
		return super.getPolicynumber();
	}

	@Override
	public void setPolicynumber(String policynumber) {
		// TODO Auto-generated method stub
		super.setPolicynumber(policynumber);
	}

	@Override
	public String getAmount() {
		// TODO Auto-generated method stub
		return super.getAmount();
	}

	@Override
	public void setAmount(String amount) {
		// TODO Auto-generated method stub
		super.setAmount(amount);
	}

	public BenefitDb() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BenefitDb(String company, String formula, String formulename, String policynumber, String amount) {
		super(company, formula, formulename, policynumber, amount);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
