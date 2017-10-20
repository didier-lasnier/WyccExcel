package com.dlas.dao;

import java.awt.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FormuleEmbedded {

	@Column(name="COMPANY", insertable=false,updatable=false)
	public String company;
	@Column(name="FORMULA", insertable=false,updatable=false)
	public String formula;
	@Column(name = "FORMULE_NAME", insertable=false,updatable=false)
	public String formulename;
	@Column(name = "POLICY_NUMBER", insertable=false,updatable=false)
	public String policynumber;
	
		
	public FormuleEmbedded() {
		}


	public FormuleEmbedded(String company, String formula, String formulename, String policynumber) {
			super();
			this.company = company;
			this.formula = formula;
			this.formulename = formulename;
			this.policynumber = policynumber;
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



    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof FormuleEmbedded)) {
            return false;
        }
        FormuleEmbedded limitaggcsv = (FormuleEmbedded) o;
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
