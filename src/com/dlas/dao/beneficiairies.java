package com.dlas.dao;

import java.util.Date;

import org.hibernate.annotations.Columns;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="BENEFICIAIRIES")
public class beneficiairies {
	@Id
	@Column(name="BENEFICIAIRIES_ID")
	private String     beneficiairiesid;
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
	
	/**
	 * @return the beneficiairiesid
	 */
	public String getBeneficiairiesid() {
		return beneficiairiesid;
	}

	/**
	 * @param beneficiairiesid the beneficiairiesid to set
	 */
	public void setBeneficiairiesid(String beneficiairiesid) {
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
}
