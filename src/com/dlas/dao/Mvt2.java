package com.dlas.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MVT", schema = "PUBLIC")
public class Mvt2{
	
	@Id
	@Column(name = "MVT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer                  mvtid;
	@Column(name = "STRUCTURE_NAME")
	private String                   structurename;
	@Column(name = "CERTIFICATE")
	private String                   certificate;
	@Column(name = "CERTIFICATE_START")
	private String                   certificatestart;
	@Column(name = "CERTIFICATE_RENEWAL")
	private String                   certificaterenewal;
	@Column(name = "CERTIFICATE_CANCELLATION")
	private String                   certificatecancellation;
	@Column(name = "AMENDMENT_START")
	private String                   amendmentstart;
	@Column(name = "AMENDMENT_END")
	private String                   amendmentend;
	@Column(name = "WYCC_ID")
	private String                   wyccid;
	@Column(name = "CLAIMS_MANAGER_ID")
	private String                   claimsmanagerid;
	@Column(name = "GENDER")
	private String                   gender;
	@Column(name = "NAME")
	private String                   name;
	@Column(name = "FIRST_NAME")
	private String                   firstname;
	@Column(name = "DATE_OF_BIRTH")
	private String                   dateofbirth;
	@Column(name = "EMAIL")
	private String                   email;
	@Column(name = "POSITION_TYPE")
	private String                   positiontype;
	@Column(name = "POSITIONCREW")
	private String                   positioncrew;
	@Column(name = "MONTHLY_SALARY")
	private String                   monthlysalary;
	@Column(name = "SALARY_CURRENCY")
	private String                   salarycurrency;
	@Column(name = "PERIOD_INSURANCE")
	private String                   periodinsurance;
	@Column(name = "DAYS")
	private String                   days;
	@Column(name = "MONTHS")
	private String                   months;
	@Column(name = "FAMILY_COVERED")
	private String                   familycovered;
	@Column(name = "RETIREMENT_PLAN")
	private String                   retirementplan;
	@Column(name = "START_MOVEMENT")
	private String                   startmovement;
	@Column(name = "END_MOVEMENT")
	private String                   endmovement;
	@Column(name = "EMPLOYER")
	private String                   employer;
	@Column(name = "CHILDREN")
	private String                   children;
	@Column(name = "COUNTRY")
	private String                   country;
	@Column(name = "NATIONALITY")
	private String                   nationality;
	@Column(name = "COMPANY1")
	private String                   company1;
	@Column(name = "FORMULA1")
	private String                   formula1;
	@Column(name = "POLICY_NUMBER1")
	private String                   policynumber1;
	@Column(name = "CURRENCY1")
	private String                   currency1;
	@Column(name = "EXCESS1")
	private String                   excess1;
	@Column(name = "DURATION1")
	private String                   duration1;
	@Column(name = "TOTAL_AMOUNT_INSURED1")
	private String                   totalamountinsured1;
	@Column(name = "CIE_HT_BASIS1")
	private String                   ciehtbasis1;
	@Column(name = "COMPANY2")
	private String                   company2;
	@Column(name = "FORMULA2")
	private String                   formula2;
	@Column(name = "POLICY_NUMBER2")
	private String                   policynumber2;
	@Column(name = "CURRENCY2")
	private String                   currency2;
	@Column(name = "EXCESS2")
	private String                   excess2;
	@Column(name = "DURATION2")
	private String                   duration2;
	@Column(name = "TOTAL_AMOUNT_INSURED2")
	private String                   totalamountinsured2;
	@Column(name = "CIE_HT_BASIS2")
	private String                   ciehtbasis2;
	@Column(name = "COMPANY3")
	private String                   company3;
	@Column(name = "FORMULA3")
	private String                   formula3;
	@Column(name = "POLICY_NUMBER3")
	private String                   policynumber3;
	@Column(name = "CURRENCY3")
	private String                   currency3;
	@Column(name = "EXCESS3")
	private String                   excess3;
	@Column(name = "DURATION3")
	private String                   duration3;
	@Column(name = "TOTAL_AMOUNT_INSURED3")
	private String                   totalamountinsured3;
	@Column(name = "CIE_HT_BASIS3")
	private String                   ciehtbasis3;
	@Column(name = "COMPANY4")
	private String                   company4;
	@Column(name = "FORMULA4")
	private String                   formula4;
	@Column(name = "POLICY_NUMBER4")
	private String                   policynumber4;
	@Column(name = "CURRENCY4")
	private String                   currency4;
	@Column(name = "EXCESS4")
	private String                   excess4;
	@Column(name = "DURATION4")
	private String                   duration4;
	@Column(name = "TOTAL_AMOUNT_INSURED4")
	private String                   totalamountinsured4;
	@Column(name = "CIE_HT_BASIS4")
	private String                   ciehtbasis4;
	@Column(name = "COMPANY5")
	private String                   company5;
	@Column(name = "FORMULA5")
	private String                   formula5;
	@Column(name = "POLICY_NUMBER5")
	private String                   policynumber5;
	@Column(name = "CURRENCY5")
	private String                   currency5;
	@Column(name = "EXCESS5")
	private String                   excess5;
	@Column(name = "DURATION5")
	private String                   duration5;
	@Column(name = "TOTAL_AMOUNT_INSURED5")
	private String                   totalamountinsured5;
	@Column(name = "CIE_HT_BASIS5")
	private String                   ciehtbasis5;
	@Column(name = "COMPANY6")
	private String                   company6;
	@Column(name = "FORMULA")
	private String                   formula;
	@Column(name = "POLICY_NUMBER6")
	private String                   policynumber6;
	@Column(name = "CURRENCY6")
	private String                   currency6;
	@Column(name = "EXCESS6")
	private String                   excess6;
	@Column(name = "DURATION6")
	private String                   duration6;
	@Column(name = "TOTAL_AMOUNT_INSURED6")
	private String                   totalamountinsured6;
	@Column(name = "CIE_HT_BASIS6")
	private String                   ciehtbasis6;
	@Column(name = "COMPANY7")
	private String                   company7;
	@Column(name = "FORMULA7")
	private String                   formula7;
	@Column(name = "POLICY_NUMBER7")
	private String                   policynumber7;
	@Column(name = "CURRENCY7")
	private String                   currency7;
	@Column(name = "EXCESS67")
	private String                   excess67;
	@Column(name = "DURATION7")
	private String                   duration7;
	@Column(name = "TOTAL_AMOUNT_INSURED7")
	private String                   totalamountinsured7;
	@Column(name = "CIE_HT_BASIS7")
	private String                   ciehtbasis7;
	@Column(name = "COMPANY8")
	private String                   company8;
	@Column(name = "FORMULA8")
	private String                   formula8;
	@Column(name = "POLICY_NUMBER8")
	private String                   policynumber8;
	@Column(name = "CURRENCY8")
	private String                   currency8;
	@Column(name = "EXCESS8")
	private String                   excess8;
	@Column(name = "DURATION8")
	private String                   duration8;
	@Column(name = "TOTAL_AMOUNT_INSURED8")
	private String                   totalamountinsured8;
	@Column(name = "CIE_HT_BASIS8")
	private String                   ciehtbasis8;
	@Column(name = "FORMULE_NAME1")
	private String                   formulename1;
	@Column(name = "FORMULE_NAME2")
	private String                   formulename2;
	@Column(name = "FORMULE_NAME3")
	private String                   formulename3;
	@Column(name = "FORMULE_NAME4")
	private String                   formulename4;
	@Column(name = "FORMULE_NAME5")
	private String                   formulename5;
	@Column(name = "FORMULE_NAME6")
	private String                   formulename6;
	@Column(name = "FORMULE_NAME7")
	private String                   formulename7;
	@Column(name = "FORMULE_NAME8")
	private String                   formulename8;


	public Mvt2(Integer mvtid, String structurename, String certificate, String certificatestart,
			String certificaterenewal, String certificatecancellation, String amendmentstart, String amendmentend,
			String wyccid, String claimsmanagerid, String gender, String name, String firstname, String dateofbirth,
			String email, String positiontype, String positioncrew, String monthlysalary, String salarycurrency,
			String periodinsurance, String days, String months, String familycovered, String retirementplan,
			String startmovement, String endmovement, String employer, String children, String country,
			String nationality, String company1, String formula1, String policynumber1, String currency1,
			String excess1, String duration1, String totalamountinsured1, String ciehtbasis1, String company2,
			String formula2, String policynumber2, String currency2, String excess2, String duration2,
			String totalamountinsured2, String ciehtbasis2, String company3, String formula3, String policynumber3,
			String currency3, String excess3, String duration3, String totalamountinsured3, String ciehtbasis3,
			String company4, String formula4, String policynumber4, String currency4, String excess4, String duration4,
			String totalamountinsured4, String ciehtbasis4, String company5, String formula5, String policynumber5,
			String currency5, String excess5, String duration5, String totalamountinsured5, String ciehtbasis5,
			String company6, String formula, String policynumber6, String currency6, String excess6, String duration6,
			String totalamountinsured6, String ciehtbasis6, String company7, String formula7, String policynumber7,
			String currency7, String excess67, String duration7, String totalamountinsured7, String ciehtbasis7,
			String company8, String formula8, String policynumber8, String currency8, String excess8, String duration8,
			String totalamountinsured8, String ciehtbasis8, String formulename1, String formulename2,
			String formulename3, String formulename4, String formulename5, String formulename6, String formulename7,
			String formulename8) {
		super();
		this.mvtid = mvtid;
		this.structurename = structurename;
		this.certificate = certificate;
		this.certificatestart = certificatestart;
		this.certificaterenewal = certificaterenewal;
		this.certificatecancellation = certificatecancellation;
		this.amendmentstart = amendmentstart;
		this.amendmentend = amendmentend;
		this.wyccid = wyccid;
		this.claimsmanagerid = claimsmanagerid;
		this.gender = gender;
		this.name = name;
		this.firstname = firstname;
		this.dateofbirth = dateofbirth;
		this.email = email;
		this.positiontype = positiontype;
		this.positioncrew = positioncrew;
		this.monthlysalary = monthlysalary;
		this.salarycurrency = salarycurrency;
		this.periodinsurance = periodinsurance;
		this.days = days;
		this.months = months;
		this.familycovered = familycovered;
		this.retirementplan = retirementplan;
		this.startmovement = startmovement;
		this.endmovement = endmovement;
		this.employer = employer;
		this.children = children;
		this.country = country;
		this.nationality = nationality;
		this.company1 = company1;
		this.formula1 = formula1;
		this.policynumber1 = policynumber1;
		this.currency1 = currency1;
		this.excess1 = excess1;
		this.duration1 = duration1;
		this.totalamountinsured1 = totalamountinsured1;
		this.ciehtbasis1 = ciehtbasis1;
		this.company2 = company2;
		this.formula2 = formula2;
		this.policynumber2 = policynumber2;
		this.currency2 = currency2;
		this.excess2 = excess2;
		this.duration2 = duration2;
		this.totalamountinsured2 = totalamountinsured2;
		this.ciehtbasis2 = ciehtbasis2;
		this.company3 = company3;
		this.formula3 = formula3;
		this.policynumber3 = policynumber3;
		this.currency3 = currency3;
		this.excess3 = excess3;
		this.duration3 = duration3;
		this.totalamountinsured3 = totalamountinsured3;
		this.ciehtbasis3 = ciehtbasis3;
		this.company4 = company4;
		this.formula4 = formula4;
		this.policynumber4 = policynumber4;
		this.currency4 = currency4;
		this.excess4 = excess4;
		this.duration4 = duration4;
		this.totalamountinsured4 = totalamountinsured4;
		this.ciehtbasis4 = ciehtbasis4;
		this.company5 = company5;
		this.formula5 = formula5;
		this.policynumber5 = policynumber5;
		this.currency5 = currency5;
		this.excess5 = excess5;
		this.duration5 = duration5;
		this.totalamountinsured5 = totalamountinsured5;
		this.ciehtbasis5 = ciehtbasis5;
		this.company6 = company6;
		this.formula = formula;
		this.policynumber6 = policynumber6;
		this.currency6 = currency6;
		this.excess6 = excess6;
		this.duration6 = duration6;
		this.totalamountinsured6 = totalamountinsured6;
		this.ciehtbasis6 = ciehtbasis6;
		this.company7 = company7;
		this.formula7 = formula7;
		this.policynumber7 = policynumber7;
		this.currency7 = currency7;
		this.excess67 = excess67;
		this.duration7 = duration7;
		this.totalamountinsured7 = totalamountinsured7;
		this.ciehtbasis7 = ciehtbasis7;
		this.company8 = company8;
		this.formula8 = formula8;
		this.policynumber8 = policynumber8;
		this.currency8 = currency8;
		this.excess8 = excess8;
		this.duration8 = duration8;
		this.totalamountinsured8 = totalamountinsured8;
		this.ciehtbasis8 = ciehtbasis8;
		this.formulename1 = formulename1;
		this.formulename2 = formulename2;
		this.formulename3 = formulename3;
		this.formulename4 = formulename4;
		this.formulename5 = formulename5;
		this.formulename6 = formulename6;
		this.formulename7 = formulename7;
		this.formulename8 = formulename8;
	}

	public Mvt2() {

	}

	public Integer getMvtid() {
		return mvtid;
	}

	public String getStructurename() {
		return structurename;
	}

	public String getCertificate() {
		return certificate;
	}

	public String getCertificatestart() {
		return certificatestart;
	}

	public String getCertificaterenewal() {
		return certificaterenewal;
	}

	public String getCertificatecancellation() {
		return certificatecancellation;
	}

	public String getAmendmentstart() {
		return amendmentstart;
	}

	public String getAmendmentend() {
		return amendmentend;
	}

	public String getWyccid() {
		return wyccid;
	}

	public String getClaimsmanagerid() {
		return claimsmanagerid;
	}

	public String getGender() {
		return gender;
	}

	public String getName() {
		return name;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public String getEmail() {
		return email;
	}

	public String getPositiontype() {
		return positiontype;
	}

	public String getPositioncrew() {
		return positioncrew;
	}

	public String getMonthlysalary() {
		return monthlysalary;
	}

	public String getSalarycurrency() {
		return salarycurrency;
	}

	public String getPeriodinsurance() {
		return periodinsurance;
	}

	public String getDays() {
		return days;
	}

	public String getMonths() {
		return months;
	}

	public String getFamilycovered() {
		return familycovered;
	}

	public String getRetirementplan() {
		return retirementplan;
	}

	public String getStartmovement() {
		return startmovement;
	}

	public String getEndmovement() {
		return endmovement;
	}

	public String getEmployer() {
		return employer;
	}

	public String getChildren() {
		return children;
	}

	public String getCountry() {
		return country;
	}

	public String getNationality() {
		return nationality;
	}

	public String getCompany1() {
		return company1;
	}

	public String getFormula1() {
		return formula1;
	}

	public String getPolicynumber1() {
		return policynumber1;
	}

	public String getCurrency1() {
		return currency1;
	}

	public String getExcess1() {
		return excess1;
	}

	public String getDuration1() {
		return duration1;
	}

	public String getTotalamountinsured1() {
		return totalamountinsured1;
	}

	public String getCiehtbasis1() {
		return ciehtbasis1;
	}

	public String getCompany2() {
		return company2;
	}

	public String getFormula2() {
		return formula2;
	}

	public String getPolicynumber2() {
		return policynumber2;
	}

	public String getCurrency2() {
		return currency2;
	}

	public String getExcess2() {
		return excess2;
	}

	public String getDuration2() {
		return duration2;
	}

	public String getTotalamountinsured2() {
		return totalamountinsured2;
	}

	public String getCiehtbasis2() {
		return ciehtbasis2;
	}

	public String getCompany3() {
		return company3;
	}

	public String getFormula3() {
		return formula3;
	}

	public String getPolicynumber3() {
		return policynumber3;
	}

	public String getCurrency3() {
		return currency3;
	}

	public String getExcess3() {
		return excess3;
	}

	public String getDuration3() {
		return duration3;
	}

	public String getTotalamountinsured3() {
		return totalamountinsured3;
	}

	public String getCiehtbasis3() {
		return ciehtbasis3;
	}

	public String getCompany4() {
		return company4;
	}

	public String getFormula4() {
		return formula4;
	}

	public String getPolicynumber4() {
		return policynumber4;
	}

	public String getCurrency4() {
		return currency4;
	}

	public String getExcess4() {
		return excess4;
	}

	public String getDuration4() {
		return duration4;
	}

	public String getTotalamountinsured4() {
		return totalamountinsured4;
	}

	public String getCiehtbasis4() {
		return ciehtbasis4;
	}

	public String getCompany5() {
		return company5;
	}

	public String getFormula5() {
		return formula5;
	}

	public String getPolicynumber5() {
		return policynumber5;
	}

	public String getCurrency5() {
		return currency5;
	}

	public String getExcess5() {
		return excess5;
	}

	public String getDuration5() {
		return duration5;
	}

	public String getTotalamountinsured5() {
		return totalamountinsured5;
	}

	public String getCiehtbasis5() {
		return ciehtbasis5;
	}

	public String getCompany6() {
		return company6;
	}

	public String getFormula() {
		return formula;
	}

	public String getPolicynumber6() {
		return policynumber6;
	}

	public String getCurrency6() {
		return currency6;
	}

	public String getExcess6() {
		return excess6;
	}

	public String getDuration6() {
		return duration6;
	}

	public String getTotalamountinsured6() {
		return totalamountinsured6;
	}

	public String getCiehtbasis6() {
		return ciehtbasis6;
	}

	public String getCompany7() {
		return company7;
	}

	public String getFormula7() {
		return formula7;
	}

	public String getPolicynumber7() {
		return policynumber7;
	}

	public String getCurrency7() {
		return currency7;
	}

	public String getExcess67() {
		return excess67;
	}

	public String getDuration7() {
		return duration7;
	}

	public String getTotalamountinsured7() {
		return totalamountinsured7;
	}

	public String getCiehtbasis7() {
		return ciehtbasis7;
	}

	public String getCompany8() {
		return company8;
	}

	public String getFormula8() {
		return formula8;
	}

	public String getPolicynumber8() {
		return policynumber8;
	}

	public String getCurrency8() {
		return currency8;
	}

	public String getExcess8() {
		return excess8;
	}

	public String getDuration8() {
		return duration8;
	}

	public String getTotalamountinsured8() {
		return totalamountinsured8;
	}

	public String getCiehtbasis8() {
		return ciehtbasis8;
	}

	public String getFormulename1() {
		return formulename1;
	}

	public String getFormulename2() {
		return formulename2;
	}

	public String getFormulename3() {
		return formulename3;
	}

	public String getFormulename4() {
		return formulename4;
	}

	public String getFormulename5() {
		return formulename5;
	}

	public String getFormulename6() {
		return formulename6;
	}

	public String getFormulename7() {
		return formulename7;
	}

	public String getFormulename8() {
		return formulename8;
	}

	public void setMvtid(Integer mvtid) {
		this.mvtid = mvtid;
	}

	public void setStructurename(String structurename) {
		this.structurename = structurename;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public void setCertificatestart(String certificatestart) {
		this.certificatestart = certificatestart;
	}

	public void setCertificaterenewal(String certificaterenewal) {
		this.certificaterenewal = certificaterenewal;
	}

	public void setCertificatecancellation(String certificatecancellation) {
		this.certificatecancellation = certificatecancellation;
	}

	public void setAmendmentstart(String amendmentstart) {
		this.amendmentstart = amendmentstart;
	}

	public void setAmendmentend(String amendmentend) {
		this.amendmentend = amendmentend;
	}

	public void setWyccid(String wyccid) {
		this.wyccid = wyccid;
	}

	public void setClaimsmanagerid(String claimsmanagerid) {
		this.claimsmanagerid = claimsmanagerid;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPositiontype(String positiontype) {
		this.positiontype = positiontype;
	}

	public void setPositioncrew(String positioncrew) {
		this.positioncrew = positioncrew;
	}

	public void setMonthlysalary(String monthlysalary) {
		this.monthlysalary = monthlysalary;
	}

	public void setSalarycurrency(String salarycurrency) {
		this.salarycurrency = salarycurrency;
	}

	public void setPeriodinsurance(String periodinsurance) {
		this.periodinsurance = periodinsurance;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public void setFamilycovered(String familycovered) {
		this.familycovered = familycovered;
	}

	public void setRetirementplan(String retirementplan) {
		this.retirementplan = retirementplan;
	}

	public void setStartmovement(String startmovement) {
		this.startmovement = startmovement;
	}

	public void setEndmovement(String endmovement) {
		this.endmovement = endmovement;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public void setCompany1(String company1) {
		this.company1 = company1;
	}

	public void setFormula1(String formula1) {
		this.formula1 = formula1;
	}

	public void setPolicynumber1(String policynumber1) {
		this.policynumber1 = policynumber1;
	}

	public void setCurrency1(String currency1) {
		this.currency1 = currency1;
	}

	public void setExcess1(String excess1) {
		this.excess1 = excess1;
	}

	public void setDuration1(String duration1) {
		this.duration1 = duration1;
	}

	public void setTotalamountinsured1(String totalamountinsured1) {
		this.totalamountinsured1 = totalamountinsured1;
	}

	public void setCiehtbasis1(String ciehtbasis1) {
		this.ciehtbasis1 = ciehtbasis1;
	}

	public void setCompany2(String company2) {
		this.company2 = company2;
	}

	public void setFormula2(String formula2) {
		this.formula2 = formula2;
	}

	public void setPolicynumber2(String policynumber2) {
		this.policynumber2 = policynumber2;
	}

	public void setCurrency2(String currency2) {
		this.currency2 = currency2;
	}

	public void setExcess2(String excess2) {
		this.excess2 = excess2;
	}

	public void setDuration2(String duration2) {
		this.duration2 = duration2;
	}

	public void setTotalamountinsured2(String totalamountinsured2) {
		this.totalamountinsured2 = totalamountinsured2;
	}

	public void setCiehtbasis2(String ciehtbasis2) {
		this.ciehtbasis2 = ciehtbasis2;
	}

	public void setCompany3(String company3) {
		this.company3 = company3;
	}

	public void setFormula3(String formula3) {
		this.formula3 = formula3;
	}

	public void setPolicynumber3(String policynumber3) {
		this.policynumber3 = policynumber3;
	}

	public void setCurrency3(String currency3) {
		this.currency3 = currency3;
	}

	public void setExcess3(String excess3) {
		this.excess3 = excess3;
	}

	public void setDuration3(String duration3) {
		this.duration3 = duration3;
	}

	public void setTotalamountinsured3(String totalamountinsured3) {
		this.totalamountinsured3 = totalamountinsured3;
	}

	public void setCiehtbasis3(String ciehtbasis3) {
		this.ciehtbasis3 = ciehtbasis3;
	}

	public void setCompany4(String company4) {
		this.company4 = company4;
	}

	public void setFormula4(String formula4) {
		this.formula4 = formula4;
	}

	public void setPolicynumber4(String policynumber4) {
		this.policynumber4 = policynumber4;
	}

	public void setCurrency4(String currency4) {
		this.currency4 = currency4;
	}

	public void setExcess4(String excess4) {
		this.excess4 = excess4;
	}

	public void setDuration4(String duration4) {
		this.duration4 = duration4;
	}

	public void setTotalamountinsured4(String totalamountinsured4) {
		this.totalamountinsured4 = totalamountinsured4;
	}

	public void setCiehtbasis4(String ciehtbasis4) {
		this.ciehtbasis4 = ciehtbasis4;
	}

	public void setCompany5(String company5) {
		this.company5 = company5;
	}

	public void setFormula5(String formula5) {
		this.formula5 = formula5;
	}

	public void setPolicynumber5(String policynumber5) {
		this.policynumber5 = policynumber5;
	}

	public void setCurrency5(String currency5) {
		this.currency5 = currency5;
	}

	public void setExcess5(String excess5) {
		this.excess5 = excess5;
	}

	public void setDuration5(String duration5) {
		this.duration5 = duration5;
	}

	public void setTotalamountinsured5(String totalamountinsured5) {
		this.totalamountinsured5 = totalamountinsured5;
	}

	public void setCiehtbasis5(String ciehtbasis5) {
		this.ciehtbasis5 = ciehtbasis5;
	}

	public void setCompany6(String company6) {
		this.company6 = company6;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public void setPolicynumber6(String policynumber6) {
		this.policynumber6 = policynumber6;
	}

	public void setCurrency6(String currency6) {
		this.currency6 = currency6;
	}

	public void setExcess6(String excess6) {
		this.excess6 = excess6;
	}

	public void setDuration6(String duration6) {
		this.duration6 = duration6;
	}

	public void setTotalamountinsured6(String totalamountinsured6) {
		this.totalamountinsured6 = totalamountinsured6;
	}

	public void setCiehtbasis6(String ciehtbasis6) {
		this.ciehtbasis6 = ciehtbasis6;
	}

	public void setCompany7(String company7) {
		this.company7 = company7;
	}

	public void setFormula7(String formula7) {
		this.formula7 = formula7;
	}

	public void setPolicynumber7(String policynumber7) {
		this.policynumber7 = policynumber7;
	}

	public void setCurrency7(String currency7) {
		this.currency7 = currency7;
	}

	public void setExcess67(String excess67) {
		this.excess67 = excess67;
	}

	public void setDuration7(String duration7) {
		this.duration7 = duration7;
	}

	public void setTotalamountinsured7(String totalamountinsured7) {
		this.totalamountinsured7 = totalamountinsured7;
	}

	public void setCiehtbasis7(String ciehtbasis7) {
		this.ciehtbasis7 = ciehtbasis7;
	}

	public void setCompany8(String company8) {
		this.company8 = company8;
	}

	public void setFormula8(String formula8) {
		this.formula8 = formula8;
	}

	public void setPolicynumber8(String policynumber8) {
		this.policynumber8 = policynumber8;
	}

	public void setCurrency8(String currency8) {
		this.currency8 = currency8;
	}

	public void setExcess8(String excess8) {
		this.excess8 = excess8;
	}

	public void setDuration8(String duration8) {
		this.duration8 = duration8;
	}

	public void setTotalamountinsured8(String totalamountinsured8) {
		this.totalamountinsured8 = totalamountinsured8;
	}

	public void setCiehtbasis8(String ciehtbasis8) {
		this.ciehtbasis8 = ciehtbasis8;
	}

	public void setFormulename1(String formulename1) {
		this.formulename1 = formulename1;
	}

	public void setFormulename2(String formulename2) {
		this.formulename2 = formulename2;
	}

	public void setFormulename3(String formulename3) {
		this.formulename3 = formulename3;
	}

	public void setFormulename4(String formulename4) {
		this.formulename4 = formulename4;
	}

	public void setFormulename5(String formulename5) {
		this.formulename5 = formulename5;
	}

	public void setFormulename6(String formulename6) {
		this.formulename6 = formulename6;
	}

	public void setFormulename7(String formulename7) {
		this.formulename7 = formulename7;
	}

	public void setFormulename8(String formulename8) {
		this.formulename8 = formulename8;
	}



}
