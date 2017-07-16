package com.dlas.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.dlas.gui.model.AbstractModelObject;

@Entity
@Table(name = "MODULBOAT", schema = "PUBLIC")
public class ModulBoat extends AbstractModelObject {
	@Id
	@Column(name = "MODUL_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Double         modulid                   ;
	@Column(name = "MODUL_FOURNISSEUR")
	private String          modul_fournisseur         ;
	@Column(name = "MODUL_LABEL")
	private String          modullabel                ;
	@Column(name = "MODUL_BOAT")
	private String          modulboat                 ;
	@Column(name = "MODUL_PRICE_SINGLE")
	private Float          modulpricesingle         ;
	@Column(name = "MODUL_PRICE_FAMILY")
	private Float          modulpricefamily         ;
	@Column(name = "MODUL_SCOPE")
	private String          modulscope                ;
	@Column(name = "MODULE_CATEGORY")
	private String          modulecategory            ;
	@Column(name = "FORFAIT_PERCENTAGE")
	private Double         forfaitpercentage         ;
	@Column(name = "CALCULMODE")
	private String          calculmode                 ;
	@Column(name = "BANK_FEE")
	private Float          bankfee                     ;	
	@Column(name = "SUR_COM")
	private Float          surcom                      ;	
	@Column(name = "INVOICE_PERIOD")
	private String          invoiceperiod               ;
	@Column(name = "POLICY_NUMBER")
	private String          policynumber                ;
	@Column(name = "AGGREGATE_AMOUNT")
	private Float          aggregateamount                     ;
	
	
	
	public ModulBoat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ModulBoat(Double modulid, String modul_fournisseur, String modullabel, String modulboat,
			Float modulpricesingle, Float modulpricefamily, String modulscope, String modulecategory,
			Double forfaitpercentage, String calculmode, Float bankfee, Float surcom, String invoiceperiod) {
		super();
		this.modulid = modulid;
		this.modul_fournisseur = modul_fournisseur;
		this.modullabel = modullabel;
		this.modulboat = modulboat;
		this.modulpricesingle = modulpricesingle;
		this.modulpricefamily = modulpricefamily;
		this.modulscope = modulscope;
		this.modulecategory = modulecategory;
		this.forfaitpercentage = forfaitpercentage;
		this.calculmode = calculmode;
		this.bankfee = bankfee;
		this.surcom = surcom;
		this.invoiceperiod = invoiceperiod;
	}
	
	
	public ModulBoat(Double modulid, String modul_fournisseur, String modullabel, String modulboat,
			Float modulpricesingle, Float modulpricefamily, String modulscope, String modulecategory,
			Double forfaitpercentage, String calculmode, Float bankfee, Float surcom, String invoiceperiod,
			String policynumber, Float aggregateamount) {
		super();
		this.modulid = modulid;
		this.modul_fournisseur = modul_fournisseur;
		this.modullabel = modullabel;
		this.modulboat = modulboat;
		this.modulpricesingle = modulpricesingle;
		this.modulpricefamily = modulpricefamily;
		this.modulscope = modulscope;
		this.modulecategory = modulecategory;
		this.forfaitpercentage = forfaitpercentage;
		this.calculmode = calculmode;
		this.bankfee = bankfee;
		this.surcom = surcom;
		this.invoiceperiod = invoiceperiod;
		this.policynumber = policynumber;
		this.aggregateamount = aggregateamount;
	}

	public Double getModulid() {
		return modulid;
	}
	public String getModul_fournisseur() {
		return modul_fournisseur;
	}
	public String getModullabel() {
		return modullabel;
	}
	public String getModulboat() {
		return modulboat;
	}
	public Float getModulpricesingle() {
		return modulpricesingle;
	}
	public Float getModulpricefamily() {
		return modulpricefamily;
	}
	public String getModulscope() {
		return modulscope;
	}
	public String getModulecategory() {
		return modulecategory;
	}
	public Double getForfaitpercentage() {
		return forfaitpercentage;
	}
	public String getCalculmode() {
		return calculmode;
	}
	public Float getBankfee() {
		return bankfee;
	}
	public Float getSurcom() {
		return surcom;
	}
	public String getInvoiceperiod() {
		return invoiceperiod;
	}
	public String getPolicynumber() {
		return policynumber;
	}
	public Float getAggregateamount() {
		return aggregateamount;
	}
	public void setModulid(Double modulid) {
		this.modulid = modulid;
	}
	public void setModul_fournisseur(String modul_fournisseur) {
		this.modul_fournisseur = modul_fournisseur;
	}
	public void setModullabel(String modullabel) {
		this.modullabel = modullabel;
	}
	public void setModulboat(String modulboat) {
		this.modulboat = modulboat;
	}
	public void setModulpricesingle(Float modulpricesingle) {
		this.modulpricesingle = modulpricesingle;
	}
	public void setModulpricefamily(Float modulpricefamily) {
		this.modulpricefamily = modulpricefamily;
	}
	public void setModulscope(String modulscope) {
		this.modulscope = modulscope;
	}
	public void setModulecategory(String modulecategory) {
		this.modulecategory = modulecategory;
	}
	public void setForfaitpercentage(Double forfaitpercentage) {
		this.forfaitpercentage = forfaitpercentage;
	}
	public void setCalculmode(String calculmode) {
		this.calculmode = calculmode;
	}
	public void setBankfee(Float bankfee) {
		this.bankfee = bankfee;
	}
	public void setSurcom(Float surcom) {
		this.surcom = surcom;
	}
	public void setInvoiceperiod(String invoiceperiod) {
		this.invoiceperiod = invoiceperiod;
	}
	public void setPolicynumber(String policynumber) {
		this.policynumber = policynumber;
	}
	public void setAggregateamount(Float aggregateamount) {
		this.aggregateamount = aggregateamount;
	}


	
}
