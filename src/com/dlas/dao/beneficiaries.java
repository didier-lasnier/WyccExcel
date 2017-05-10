package com.dlas.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BENEFICIARIES")
public class beneficiaries {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BENEFICIARIES_ID")
	private double beneficiairiesid;
	@Column(name = "WYCC_ID")
	private String wyccid;
	@Column(name = "NAME")
	private String name;
	@Column(name = "FIRST_NAME")
	private String firstname;
	@Column(name = "STRUCTURE_NAME")
	private String structurename;
	@Column(name = "FAMILY_COVERED")
	private String familycovered;
	@Column(name = "CHILDREN")
	private String children;
	@Column(name = "NATIONALITY")
	private String nationality;
	@Column(name = "COUNTRY")
	private String country;
	@Column(name = "POSITIONCREW")
	private String positioncrew;
	@Column(name = "PERIOD_INSURANCE")
	private String periodeinsurance;
	@Column(name = "LINE")
	private Integer line;
	@Column(name = "START_MOVEMENT")
	private Date startmovement;
	@Column(name = "PREVMVT")
	private Date prevmvt;
	@Column(name = "ENDCOMP")
	private Integer endcomp;
	@Column(name = "END_MOVEMENT")
	private Date endmovement;
	@Column(name = "NEXTMVT")
	private Date nextmvt;
	@Column(name = "NEXTCOMP")
	private Integer nextcomp;
	@Column(name = "MONTHLY_SALARY")
	private Integer monthlysalary;
	@Column(name = "SALARY_CURRENCY")
	private String salarycurrency;
	@Column(name = "DRESTEJ")
	private Integer drestej;
	@Column(name = "ERESTEJ")
	private Integer erestej;
	@Column(name = "TO_INVOICE")
	private float toinvoice;
	@Column(name = "JOUR")
	private Integer jour;
	@Column(name = "MOIS")
	private Integer mois;
	
	@Column(name = "COMPANY1")
	private String company1;
	@Column(name = "FORMULE1")
	private String formule1;
	@Column(name = "FORMULE_NAME1")
	private String formulename1;
	@Column(name = "POLICE_NUMBER1")
	private String policenumber1;
	@Column(name = "TOTAL_AMOUNT_INSURED1")
	private String totalamountinsured1;

	@Column(name = "COMPANY2")
	private String company2;
	@Column(name = "FORMULE2")
	private String formule2;
	@Column(name = "FORMULE_NAME2")
	private String formulename2;
	@Column(name = "POLICE_NUMBER2")
	private String policenumber2;
	@Column(name = "TOTAL_AMOUNT_INSURED2")
	private String totalamountinsured2;

	@Column(name = "COMPANY3")
	private String company3;
	@Column(name = "FORMULE3")
	private String formule3;
	@Column(name = "FORMULE_NAME3")
	private String formulename3;
	@Column(name = "POLICE_NUMBER3")
	private String policenumber3;
	@Column(name = "TOTAL_AMOUNT_INSURED3")
	private String totalamountinsured3;

	@Column(name = "COMPANY4")
	private String company4;
	@Column(name = "FORMULE4")
	private String formule4;
	@Column(name = "FORMULE_NAME4")
	private String formulename4;
	@Column(name = "POLICE_NUMBER4")
	private String policenumber4;
	@Column(name = "TOTAL_AMOUNT_INSURED4")
	private String totalamountinsured4;

	@Column(name = "COMPANY5")
	private String company5;
	@Column(name = "FORMULE5")
	private String formule5;
	@Column(name = "FORMULE_NAME5")
	private String formulename5;
	@Column(name = "POLICE_NUMBER5")
	private String policenumber5;
	@Column(name = "TOTAL_AMOUNT_INSURED5")
	private String totalamountinsured5;

	@Column(name = "COMPANY6")
	private String company6;
	@Column(name = "FORMULE6")
	private String formule6;
	@Column(name = "FORMULE_NAME6")
	private String formulename6;
	@Column(name = "POLICE_NUMBER6")
	private String policenumber6;
	@Column(name = "TOTAL_AMOUNT_INSURED6")
	private String totalamountinsured6;

	@Column(name = "COMPANY7")
	private String company7;
	@Column(name = "FORMULE7")
	private String formule7;
	@Column(name = "FORMULE_NAME7")
	private String formulename7;
	@Column(name = "POLICE_NUMBER7")
	private String policenumber7;
	@Column(name = "TOTAL_AMOUNT_INSURED7")
	private String totalamountinsured7;

	@Column(name = "COMPANY8")
	private String company8;
	@Column(name = "FORMULE8")
	private String formule8;
	@Column(name = "FORMULE_NAME8")
	private String formulename8;
	@Column(name = "POLICE_NUMBER8")
	private String policenumber8;
	@Column(name = "TOTAL_AMOUNT_INSURED8")
	private String totalamountinsured8;
	
	
	
	public beneficiaries(double beneficiairiesid, String wyccid, String name, String firstname, String structurename,
			String familycovered, String children, String nationality, String country, String positioncrew,
			String periodeinsurance, Integer line, Date startmovement, Date prevmvt, Integer endcomp, Date endmovement,
			Date nextmvt, Integer nextcomp, Integer monthlysalary, String salarycurrency, Integer drestej,
			Integer erestej, float toinvoice, Integer jour, Integer mois, String company1, String formule1,
			String formulename1, String policenumber1, String totalamountinsured1, String company2, String formule2,
			String formulename2, String policenumber2, String totalamountinsured2, String company3, String formule3,
			String formulename3, String policenumber3, String totalamountinsured3, String company4, String formule4,
			String formulename4, String policenumber4, String totalamountinsured4, String company5, String formule5,
			String formulename5, String policenumber5, String totalamountinsured5, String company6, String formule6,
			String formulename6, String policenumber6, String totalamountinsured6, String company7, String formule7,
			String formulename7, String policenumber7, String totalamountinsured7, String company8, String formule8,
			String formulename8, String policenumber8, String totalamountinsured8) {
		super();
		this.beneficiairiesid = beneficiairiesid;
		this.wyccid = wyccid;
		this.name = name;
		this.firstname = firstname;
		this.structurename = structurename;
		this.familycovered = familycovered;
		this.children = children;
		this.nationality = nationality;
		this.country = country;
		this.positioncrew = positioncrew;
		this.periodeinsurance = periodeinsurance;
		this.line = line;
		this.startmovement = startmovement;
		this.prevmvt = prevmvt;
		this.endcomp = endcomp;
		this.endmovement = endmovement;
		this.nextmvt = nextmvt;
		this.nextcomp = nextcomp;
		this.monthlysalary = monthlysalary;
		this.salarycurrency = salarycurrency;
		this.drestej = drestej;
		this.erestej = erestej;
		this.toinvoice = toinvoice;
		this.jour = jour;
		this.mois = mois;
		this.company1 = company1;
		this.formule1 = formule1;
		this.formulename1 = formulename1;
		this.policenumber1 = policenumber1;
		this.totalamountinsured1 = totalamountinsured1;
		this.company2 = company2;
		this.formule2 = formule2;
		this.formulename2 = formulename2;
		this.policenumber2 = policenumber2;
		this.totalamountinsured2 = totalamountinsured2;
		this.company3 = company3;
		this.formule3 = formule3;
		this.formulename3 = formulename3;
		this.policenumber3 = policenumber3;
		this.totalamountinsured3 = totalamountinsured3;
		this.company4 = company4;
		this.formule4 = formule4;
		this.formulename4 = formulename4;
		this.policenumber4 = policenumber4;
		this.totalamountinsured4 = totalamountinsured4;
		this.company5 = company5;
		this.formule5 = formule5;
		this.formulename5 = formulename5;
		this.policenumber5 = policenumber5;
		this.totalamountinsured5 = totalamountinsured5;
		this.company6 = company6;
		this.formule6 = formule6;
		this.formulename6 = formulename6;
		this.policenumber6 = policenumber6;
		this.totalamountinsured6 = totalamountinsured6;
		this.company7 = company7;
		this.formule7 = formule7;
		this.formulename7 = formulename7;
		this.policenumber7 = policenumber7;
		this.totalamountinsured7 = totalamountinsured7;
		this.company8 = company8;
		this.formule8 = formule8;
		this.formulename8 = formulename8;
		this.policenumber8 = policenumber8;
		this.totalamountinsured8 = totalamountinsured8;
	}
	
	
	public double getBeneficiairiesid() {
		return beneficiairiesid;
	}
	public void setBeneficiairiesid(double beneficiairiesid) {
		this.beneficiairiesid = beneficiairiesid;
	}
	public String getWyccid() {
		return wyccid;
	}
	public void setWyccid(String wyccid) {
		this.wyccid = wyccid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getStructurename() {
		return structurename;
	}
	public void setStructurename(String structurename) {
		this.structurename = structurename;
	}
	public String getFamilycovered() {
		return familycovered;
	}
	public void setFamilycovered(String familycovered) {
		this.familycovered = familycovered;
	}
	public String getChildren() {
		return children;
	}
	public void setChildren(String children) {
		this.children = children;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPositioncrew() {
		return positioncrew;
	}
	public void setPositioncrew(String positioncrew) {
		this.positioncrew = positioncrew;
	}
	public String getPeriodeinsurance() {
		return periodeinsurance;
	}
	public void setPeriodeinsurance(String periodeinsurance) {
		this.periodeinsurance = periodeinsurance;
	}
	public Integer getLine() {
		return line;
	}
	public void setLine(Integer line) {
		this.line = line;
	}
	public Date getStartmovement() {
		return startmovement;
	}
	public void setStartmovement(Date startmovement) {
		this.startmovement = startmovement;
	}
	public Date getPrevmvt() {
		return prevmvt;
	}
	public void setPrevmvt(Date prevmvt) {
		this.prevmvt = prevmvt;
	}
	public Integer getEndcomp() {
		return endcomp;
	}
	public void setEndcomp(Integer endcomp) {
		this.endcomp = endcomp;
	}
	public Date getEndmovement() {
		return endmovement;
	}
	public void setEndmovement(Date endmovement) {
		this.endmovement = endmovement;
	}
	public Date getNextmvt() {
		return nextmvt;
	}
	public void setNextmvt(Date nextmvt) {
		this.nextmvt = nextmvt;
	}
	public Integer getNextcomp() {
		return nextcomp;
	}
	public void setNextcomp(Integer nextcomp) {
		this.nextcomp = nextcomp;
	}
	public Integer getMonthlysalary() {
		return monthlysalary;
	}
	public void setMonthlysalary(Integer monthlysalary) {
		this.monthlysalary = monthlysalary;
	}
	public String getSalarycurrency() {
		return salarycurrency;
	}
	public void setSalarycurrency(String salarycurrency) {
		this.salarycurrency = salarycurrency;
	}
	public Integer getDrestej() {
		return drestej;
	}
	public void setDrestej(Integer drestej) {
		this.drestej = drestej;
	}
	public Integer getErestej() {
		return erestej;
	}
	public void setErestej(Integer erestej) {
		this.erestej = erestej;
	}
	public float getToinvoice() {
		return toinvoice;
	}
	public void setToinvoice(float toinvoice) {
		this.toinvoice = toinvoice;
	}
	public Integer getJour() {
		return jour;
	}
	public void setJour(Integer jour) {
		this.jour = jour;
	}
	public Integer getMois() {
		return mois;
	}
	public void setMois(Integer mois) {
		this.mois = mois;
	}
	public String getCompany1() {
		return company1;
	}
	public void setCompany1(String company1) {
		this.company1 = company1;
	}
	public String getFormule1() {
		return formule1;
	}
	public void setFormule1(String formule1) {
		this.formule1 = formule1;
	}
	public String getFormulename1() {
		return formulename1;
	}
	public void setFormulename1(String formulename1) {
		this.formulename1 = formulename1;
	}
	public String getPolicenumber1() {
		return policenumber1;
	}
	public void setPolicenumber1(String policenumber1) {
		this.policenumber1 = policenumber1;
	}
	public String getTotalamountinsured1() {
		return totalamountinsured1;
	}
	public void setTotalamountinsured1(String totalamountinsured1) {
		this.totalamountinsured1 = totalamountinsured1;
	}
	public String getCompany2() {
		return company2;
	}
	public void setCompany2(String company2) {
		this.company2 = company2;
	}
	public String getFormule2() {
		return formule2;
	}
	public void setFormule2(String formule2) {
		this.formule2 = formule2;
	}
	public String getFormulename2() {
		return formulename2;
	}
	public void setFormulename2(String formulename2) {
		this.formulename2 = formulename2;
	}
	public String getPolicenumber2() {
		return policenumber2;
	}
	public void setPolicenumber2(String policenumber2) {
		this.policenumber2 = policenumber2;
	}
	public String getTotalamountinsured2() {
		return totalamountinsured2;
	}
	public void setTotalamountinsured2(String totalamountinsured2) {
		this.totalamountinsured2 = totalamountinsured2;
	}
	public String getCompany3() {
		return company3;
	}
	public void setCompany3(String company3) {
		this.company3 = company3;
	}
	public String getFormule3() {
		return formule3;
	}
	public void setFormule3(String formule3) {
		this.formule3 = formule3;
	}
	public String getFormulename3() {
		return formulename3;
	}
	public void setFormulename3(String formulename3) {
		this.formulename3 = formulename3;
	}
	public String getPolicenumber3() {
		return policenumber3;
	}
	public void setPolicenumber3(String policenumber3) {
		this.policenumber3 = policenumber3;
	}
	public String getTotalamountinsured3() {
		return totalamountinsured3;
	}
	public void setTotalamountinsured3(String totalamountinsured3) {
		this.totalamountinsured3 = totalamountinsured3;
	}
	public String getCompany4() {
		return company4;
	}
	public void setCompany4(String company4) {
		this.company4 = company4;
	}
	public String getFormule4() {
		return formule4;
	}
	public void setFormule4(String formule4) {
		this.formule4 = formule4;
	}
	public String getFormulename4() {
		return formulename4;
	}
	public void setFormulename4(String formulename4) {
		this.formulename4 = formulename4;
	}
	public String getPolicenumber4() {
		return policenumber4;
	}
	public void setPolicenumber4(String policenumber4) {
		this.policenumber4 = policenumber4;
	}
	public String getTotalamountinsured4() {
		return totalamountinsured4;
	}
	public void setTotalamountinsured4(String totalamountinsured4) {
		this.totalamountinsured4 = totalamountinsured4;
	}
	public String getCompany5() {
		return company5;
	}
	public void setCompany5(String company5) {
		this.company5 = company5;
	}
	public String getFormule5() {
		return formule5;
	}
	public void setFormule5(String formule5) {
		this.formule5 = formule5;
	}
	public String getFormulename5() {
		return formulename5;
	}
	public void setFormulename5(String formulename5) {
		this.formulename5 = formulename5;
	}
	public String getPolicenumber5() {
		return policenumber5;
	}
	public void setPolicenumber5(String policenumber5) {
		this.policenumber5 = policenumber5;
	}
	public String getTotalamountinsured5() {
		return totalamountinsured5;
	}
	public void setTotalamountinsured5(String totalamountinsured5) {
		this.totalamountinsured5 = totalamountinsured5;
	}
	public String getCompany6() {
		return company6;
	}
	public void setCompany6(String company6) {
		this.company6 = company6;
	}
	public String getFormule6() {
		return formule6;
	}
	public void setFormule6(String formule6) {
		this.formule6 = formule6;
	}
	public String getFormulename6() {
		return formulename6;
	}
	public void setFormulename6(String formulename6) {
		this.formulename6 = formulename6;
	}
	public String getPolicenumber6() {
		return policenumber6;
	}
	public void setPolicenumber6(String policenumber6) {
		this.policenumber6 = policenumber6;
	}
	public String getTotalamountinsured6() {
		return totalamountinsured6;
	}
	public void setTotalamountinsured6(String totalamountinsured6) {
		this.totalamountinsured6 = totalamountinsured6;
	}
	public String getCompany7() {
		return company7;
	}
	public void setCompany7(String company7) {
		this.company7 = company7;
	}
	public String getFormule7() {
		return formule7;
	}
	public void setFormule7(String formule7) {
		this.formule7 = formule7;
	}
	public String getFormulename7() {
		return formulename7;
	}
	public void setFormulename7(String formulename7) {
		this.formulename7 = formulename7;
	}
	public String getPolicenumber7() {
		return policenumber7;
	}
	public void setPolicenumber7(String policenumber7) {
		this.policenumber7 = policenumber7;
	}
	public String getTotalamountinsured7() {
		return totalamountinsured7;
	}
	public void setTotalamountinsured7(String totalamountinsured7) {
		this.totalamountinsured7 = totalamountinsured7;
	}
	public String getCompany8() {
		return company8;
	}
	public void setCompany8(String company8) {
		this.company8 = company8;
	}
	public String getFormule8() {
		return formule8;
	}
	public void setFormule8(String formule8) {
		this.formule8 = formule8;
	}
	public String getFormulename8() {
		return formulename8;
	}
	public void setFormulename8(String formulename8) {
		this.formulename8 = formulename8;
	}
	public String getPolicenumber8() {
		return policenumber8;
	}
	public void setPolicenumber8(String policenumber8) {
		this.policenumber8 = policenumber8;
	}
	public String getTotalamountinsured8() {
		return totalamountinsured8;
	}
	public void setTotalamountinsured8(String totalamountinsured8) {
		this.totalamountinsured8 = totalamountinsured8;
	}

	
}
