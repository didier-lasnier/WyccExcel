package com.dlas.dao;

import java.util.Date;

import org.hibernate.annotations.Columns;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="BENEFICIARIES")
public class beneficiaries {
	@Id
	@Column(name="BENEFICIARIES_ID")
	private double     beneficiairiesid;
	@Column(name="WYCC_ID")
	private String     wyccid         ;
	@Column(name="NAME")
	private String     name            ;
	@Column(name="FIRST_NAME")
	private String     firstname      ;
	@Column(name="STRUCTURE_NAME")
 	private String     structurename   ;
 	@Column(name="FAMILY_COVERED")
 	private String     familycovered   ;
 	@Column(name="CHILDREN")
 	private String     children   ;
 	@Column(name="NATIONALITY")
 	private String     nationality   ;
 	@Column(name="COUNTRY")
 	private String     country   ;
 	@Column(name="POSITIONCREW")
 	private String     positioncrew   ;
 	@Column(name="PERIOD_INSURANCE")
 	private String  periodeinsurance   ;
	@Column(name="LINE")
	private Integer    line            ;
	@Column(name="START_MOVEMENT")
	private Date       startmovement  ;
	@Column(name="PREVMVT")
	private Date       prevmvt         ;
	@Column(name="ENDCOMP")
	private Integer    endcomp         ;
	@Column(name="END_MOVEMENT")
	private Date       endmovement    ;
	@Column(name="NEXTMVT")
	private Date       nextmvt         ;
	@Column(name="NEXTCOMP")
	private Integer    nextcomp        ;
	@Column(name="MONTHLY_SALARY")
	private Integer    monthlysalary  ;
	@Column(name="SALARY_CURRENCY")
	private String     salarycurrency  ;
	@Column(name="DRESTEJ")
	private Integer    drestej         ;
	@Column(name="ERESTEJ")
	private Integer    erestej         ;
	@Column(name="TO_INVOICE")
	private float      toinvoice      ;
	@Column(name="JOUR")
	private Integer    jour            ;
    @Column(name="FORMULE_NAME1")
	private String formulename1;
	@Column(name="TOTAL_AMOUNT_INSURED1")
	private String totalamountinsured1;
	@Column(name="FORMULE_NAME2")
	private String formulename2;
	@Column(name="TOTAL_AMOUNT_INSURED2")
	private String totalamountinsured2;
	@Column(name="FORMULE_NAME3")
	private String formulename3;
	@Column(name="TOTAL_AMOUNT_INSURED3")
	private String totalamountinsured3;
	@Column(name="FORMULE_NAME4")
	private String formulename4;
	@Column(name="TOTAL_AMOUNT_INSURED4")
	private String totalamountinsured4;
	@Column(name="FORMULE_NAME5")
	private String formulename5;
	@Column(name="TOTAL_AMOUNT_INSURED5")
	private String totalamountinsured5;
	@Column(name="FORMULE_NAME6")
	private String formulename6;
	@Column(name="TOTAL_AMOUNT_INSURED6")
	private String totalamountinsured6;
	@Column(name="FORMULE_NAME7")
	private String formulename7;
	@Column(name="TOTAL_AMOUNT_INSURED7")
	private String totalamountinsured7;
	@Column(name="FORMULE_NAME8")
	private String formulename8;
	@Column(name="TOTAL_AMOUNT_INSURED8")
	private String totalamountinsured8;
	/**
	 * @return the beneficiairiesid
	 */
	public Double getBeneficiairiesid() {
		return beneficiairiesid;
	}
	
	

	public beneficiaries(double beneficiairiesid, String wyccid, String name, String firstname, String structurename,
			String familycovered, String children, String nationality, String country, String positioncrew,
			String periodeinsurance, Integer line, Date startmovement, Date prevmvt, Integer endcomp, Date endmovement,
			Date nextmvt, Integer nextcomp, Integer monthlysalary, String salarycurrency, Integer drestej,
			Integer erestej, float toinvoice, Integer jour, String formulename1, String totalamountinsured1,
			String formulename2, String totalamountinsured2, String formulename3, String totalamountinsured3,
			String formulename4, String totalamountinsured4, String formulename5, String totalamountinsured5,
			String formulename6, String totalamountinsured6, String formulename7, String totalamountinsured7,
			String formulename8, String totalamountinsured8) {
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
		this.formulename1 = formulename1;
		this.totalamountinsured1 = totalamountinsured1;
		this.formulename2 = formulename2;
		this.totalamountinsured2 = totalamountinsured2;
		this.formulename3 = formulename3;
		this.totalamountinsured3 = totalamountinsured3;
		this.formulename4 = formulename4;
		this.totalamountinsured4 = totalamountinsured4;
		this.formulename5 = formulename5;
		this.totalamountinsured5 = totalamountinsured5;
		this.formulename6 = formulename6;
		this.totalamountinsured6 = totalamountinsured6;
		this.formulename7 = formulename7;
		this.totalamountinsured7 = totalamountinsured7;
		this.formulename8 = formulename8;
		this.totalamountinsured8 = totalamountinsured8;
	}

	/**
	 * @param beneficiairiesid the beneficiairiesid to set
	 */
	public void setBeneficiairiesid(Double beneficiairiesid) {
		this.beneficiairiesid = beneficiairiesid;
	}

	/**
	 * @return the wyccid
	 */
	public String getWyccid() {
		return wyccid;
	}

	/**
	 * @param wyccid the wyccid to set
	 */
	public void setWyccid(String wyccid) {
		this.wyccid = wyccid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the structurename
	 */
	public String getStructurename() {
		return structurename;
	}

	/**
	 * @param structurename the structurename to set
	 */
	public void setStructurename(String structurename) {
		this.structurename = structurename;
	}

	/**
	 * @return the familycovered
	 */
	public String getFamilycovered() {
		return familycovered;
	}

	/**
	 * @param familycovered the familycovered to set
	 */
	public void setFamilycovered(String familycovered) {
		this.familycovered = familycovered;
	}

	/**
	 * @return the children
	 */
	public String getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(String children) {
		this.children = children;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the positioncrew
	 */
	public String getPositioncrew() {
		return positioncrew;
	}

	/**
	 * @param positioncrew the positioncrew to set
	 */
	public void setPositioncrew(String positioncrew) {
		this.positioncrew = positioncrew;
	}

	/**
	 * @return the line
	 */
	public Integer getLine() {
		return line;
	}

	/**
	 * @param line the line to set
	 */
	public void setLine(Integer line) {
		this.line = line;
	}

	/**
	 * @return the startmovement
	 */
	public Date getStartmovement() {
		return startmovement;
	}

	/**
	 * @param startmovement the startmovement to set
	 */
	public void setStartmovement(Date startmovement) {
		this.startmovement = startmovement;
	}

	/**
	 * @return the prevmvt
	 */
	public Date getPrevmvt() {
		return prevmvt;
	}

	/**
	 * @param prevmvt the prevmvt to set
	 */
	public void setPrevmvt(Date prevmvt) {
		this.prevmvt = prevmvt;
	}

	/**
	 * @return the endcomp
	 */
	public Integer getEndcomp() {
		return endcomp;
	}

	/**
	 * @param endcomp the endcomp to set
	 */
	public void setEndcomp(Integer endcomp) {
		this.endcomp = endcomp;
	}

	/**
	 * @return the endmovement
	 */
	public Date getEndmovement() {
		return endmovement;
	}

	/**
	 * @param endmovement the endmovement to set
	 */
	public void setEndmovement(Date endmovement) {
		this.endmovement = endmovement;
	}

	/**
	 * @return the nextmvt
	 */
	public Date getNextmvt() {
		return nextmvt;
	}

	/**
	 * @param nextmvt the nextmvt to set
	 */
	public void setNextmvt(Date nextmvt) {
		this.nextmvt = nextmvt;
	}

	/**
	 * @return the nextcomp
	 */
	public Integer getNextcomp() {
		return nextcomp;
	}

	/**
	 * @param nextcomp the nextcomp to set
	 */
	public void setNextcomp(Integer nextcomp) {
		this.nextcomp = nextcomp;
	}

	/**
	 * @return the monthlysalary
	 */
	public Integer getMonthlysalary() {
		return monthlysalary;
	}

	/**
	 * @param monthlysalary the monthlysalary to set
	 */
	public void setMonthlysalary(Integer monthlysalary) {
		this.monthlysalary = monthlysalary;
	}

	/**
	 * @return the sALARY_CURRENCY
	 */
	public String getSalaryCurrency() {
		return salarycurrency;
	}

	/**
	 * @param sALARY_CURRENCY the sALARY_CURRENCY to set
	 */
	public void setSalaryCurrency(String salarycurrency) {
		salarycurrency = salarycurrency;
	}

	/**
	 * @return the drestej
	 */
	public Integer getDrestej() {
		return drestej;
	}

	/**
	 * @param drestej the drestej to set
	 */
	public void setDrestej(Integer drestej) {
		this.drestej = drestej;
	}

	/**
	 * @return the erestej
	 */
	public Integer getErestej() {
		return erestej;
	}

	/**
	 * @param erestej the erestej to set
	 */
	public void setErestej(Integer erestej) {
		this.erestej = erestej;
	}

	/**
	 * @return the toinvoice
	 */
	public float getToinvoice() {
		return toinvoice;
	}

	/**
	 * @param toinvoice the toinvoice to set
	 */
	public void setToinvoice(float toinvoice) {
		this.toinvoice = toinvoice;
	}

	/**
	 * @return the jour
	 */
	public Integer getJour() {
		return jour;
	}

	/**
	 * @param jour the jour to set
	 */
	public void setJour(Integer jour) {
		this.jour = jour;
	}

	public int ColumnCount() {
	    return getClass().getDeclaredFields().length;
	}

	/**
	 * @return the salarycurrency
	 */
	public String getSalarycurrency() {
		return salarycurrency;
	}

	/**
	 * @return the formulename1
	 */
	public String getFormulename1() {
		return formulename1;
	}

	/**
	 * @return the totalamountinsured1
	 */
	public String getTotalamountinsured1() {
		return totalamountinsured1;
	}

	/**
	 * @return the formulename2
	 */
	public String getFormulename2() {
		return formulename2;
	}

	/**
	 * @return the totalamountinsured2
	 */
	public String getTotalamountinsured2() {
		return totalamountinsured2;
	}

	/**
	 * @return the formulename3
	 */
	public String getFormulename3() {
		return formulename3;
	}

	/**
	 * @return the totalamountinsured3
	 */
	public String getTotalamountinsured3() {
		return totalamountinsured3;
	}

	/**
	 * @return the formulename4
	 */
	public String getFormulename4() {
		return formulename4;
	}

	/**
	 * @return the totalamountinsured4
	 */
	public String getTotalamountinsured4() {
		return totalamountinsured4;
	}

	/**
	 * @return the formulename5
	 */
	public String getFormulename5() {
		return formulename5;
	}

	/**
	 * @return the totalamountinsured5
	 */
	public String getTotalamountinsured5() {
		return totalamountinsured5;
	}

	/**
	 * @return the formulename6
	 */
	public String getFormulename6() {
		return formulename6;
	}

	/**
	 * @return the totalamountinsured6
	 */
	public String getTotalamountinsured6() {
		return totalamountinsured6;
	}

	/**
	 * @return the formulename7
	 */
	public String getFormulename7() {
		return formulename7;
	}

	/**
	 * @return the totalamountinsured7
	 */
	public String getTotalamountinsured7() {
		return totalamountinsured7;
	}

	/**
	 * @return the formulename8
	 */
	public String getFormulename8() {
		return formulename8;
	}

	/**
	 * @return the totalamountinsured8
	 */
	public String getTotalamountinsured8() {
		return totalamountinsured8;
	}

	/**
	 * @param beneficiairiesid the beneficiairiesid to set
	 */
	public void setBeneficiairiesid(double beneficiairiesid) {
		this.beneficiairiesid = beneficiairiesid;
	}

	/**
	 * @param salarycurrency the salarycurrency to set
	 */
	public void setSalarycurrency(String salarycurrency) {
		this.salarycurrency = salarycurrency;
	}

	/**
	 * @param formulename1 the formulename1 to set
	 */
	public void setFormulename1(String formulename1) {
		this.formulename1 = formulename1;
	}

	/**
	 * @param totalamountinsured1 the totalamountinsured1 to set
	 */
	public void setTotalamountinsured1(String totalamountinsured1) {
		this.totalamountinsured1 = totalamountinsured1;
	}

	/**
	 * @param formulename2 the formulename2 to set
	 */
	public void setFormulename2(String formulename2) {
		this.formulename2 = formulename2;
	}

	/**
	 * @param totalamountinsured2 the totalamountinsured2 to set
	 */
	public void setTotalamountinsured2(String totalamountinsured2) {
		this.totalamountinsured2 = totalamountinsured2;
	}

	/**
	 * @param formulename3 the formulename3 to set
	 */
	public void setFormulename3(String formulename3) {
		this.formulename3 = formulename3;
	}

	/**
	 * @param totalamountinsured3 the totalamountinsured3 to set
	 */
	public void setTotalamountinsured3(String totalamountinsured3) {
		this.totalamountinsured3 = totalamountinsured3;
	}

	/**
	 * @param formulename4 the formulename4 to set
	 */
	public void setFormulename4(String formulename4) {
		this.formulename4 = formulename4;
	}

	/**
	 * @param totalamountinsured4 the totalamountinsured4 to set
	 */
	public void setTotalamountinsured4(String totalamountinsured4) {
		this.totalamountinsured4 = totalamountinsured4;
	}

	/**
	 * @param formulename5 the formulename5 to set
	 */
	public void setFormulename5(String formulename5) {
		this.formulename5 = formulename5;
	}

	/**
	 * @param totalamountinsured5 the totalamountinsured5 to set
	 */
	public void setTotalamountinsured5(String totalamountinsured5) {
		this.totalamountinsured5 = totalamountinsured5;
	}

	/**
	 * @param formulename6 the formulename6 to set
	 */
	public void setFormulename6(String formulename6) {
		this.formulename6 = formulename6;
	}

	/**
	 * @param totalamountinsured6 the totalamountinsured6 to set
	 */
	public void setTotalamountinsured6(String totalamountinsured6) {
		this.totalamountinsured6 = totalamountinsured6;
	}

	/**
	 * @param formulename7 the formulename7 to set
	 */
	public void setFormulename7(String formulename7) {
		this.formulename7 = formulename7;
	}

	/**
	 * @param totalamountinsured7 the totalamountinsured7 to set
	 */
	public void setTotalamountinsured7(String totalamountinsured7) {
		this.totalamountinsured7 = totalamountinsured7;
	}

	/**
	 * @param formulename8 the formulename8 to set
	 */
	public void setFormulename8(String formulename8) {
		this.formulename8 = formulename8;
	}

	/**
	 * @param totalamountinsured8 the totalamountinsured8 to set
	 */
	public void setTotalamountinsured8(String totalamountinsured8) {
		this.totalamountinsured8 = totalamountinsured8;
	}

	/**
	 * @return the periodeinsurance
	 */
	public String getPeriodeinsurance() {
		return periodeinsurance;
	}

	/**
	 * @param periodeinsurance the periodeinsurance to set
	 */
	public void setPeriodeinsurance(String periodeinsurance) {
		this.periodeinsurance = periodeinsurance;
	}
}
