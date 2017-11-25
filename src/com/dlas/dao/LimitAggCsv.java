package com.dlas.dao;

import java.awt.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "AGGREGATE_TAB", schema = "PUBLIC")
public class LimitAggCsv {

	@Column(name = "COMPANY")
	public String company;
	@Column(name = "FORMULA")
	public String formula;
	@Column(name = "FORMULE_NAME")
	public String formulename;
	@Column(name = "POLICY_NUMBER")
	public String policynumber;
	@Column(name = "AMOUNT")
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

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof LimitAggCsv)) {
            return false;
        }
        LimitAggCsv limitaggcsv = (LimitAggCsv) o;
        return  Objects.equals(company,limitaggcsv.company) &&
                Objects.equals(formula, limitaggcsv.formula) &&
                Objects.equals(formulename, limitaggcsv.formulename) &&
        		Objects.equals(policynumber, limitaggcsv.policynumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, formula, formulename,policynumber);
    }

}
