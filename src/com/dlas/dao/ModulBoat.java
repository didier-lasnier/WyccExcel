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
	private Integer         modulid                   ;
	@Column(name = "MODUL_FOURNISSEUR")
	private String          modul_fournisseur          ;
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
	private Integer         forfaitpercentage         ;
	@Column(name = "CALCULMODE")
	private String          calculmode                 ;
	@Column(name = "BANK_FEE")
	private Float          bankfee                     ;	
	@Column(name = "SUR_COM")
	private Float          surcom                      ;	
	@Column(name = "INVOICE_PERIOD")
	private Float          invoiceperiod               ;
	public ModulBoat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModulBoat(Integer modulid, String modul_fournisseur, String modullabel, String modulboat,
			Float modulpricesingle, Float modulpricefamily, String modulscope, String modulecategory,
			Integer forfaitpercentage, String calculmode, Float bankfee, Float surcom, Float invoiceperiod) {
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
	public Integer getModulid() {
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
	public Integer getForfaitpercentage() {
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
	public Float getInvoiceperiod() {
		return invoiceperiod;
	}
	public void setModulid(Integer modulid) {
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
	public void setForfaitpercentage(Integer forfaitpercentage) {
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
	public void setInvoiceperiod(Float invoiceperiod) {
		this.invoiceperiod = invoiceperiod;
	}	
	
	

	
}
