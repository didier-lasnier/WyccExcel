package com.dlas.dao;

import javax.persistence.Column;

public class Mvt extends MvtCsv {

	@Column(name = "FORMULE_NAME1")
	private String formulename1;
	@Column(name = "FORMULE_NAME2")
	private String formulename2;
	@Column(name = "FORMULE_NAME3")
	private String formulename3;
	@Column(name = "FORMULE_NAME4")
	private String formulename4;
	@Column(name = "FORMULE_NAME5")
	private String formulename5;
	@Column(name = "FORMULE_NAME6")
	private String formulename6;
	@Column(name = "FORMULE_NAME7")
	private String formulename7;
	@Column(name = "FORMULE_NAME8")
	private String formulename8;

	public Mvt(String structurename, String certificate, String certificatestart, String certificaterenewal,
			String certificatecancellation, String amendmentstart, String amendmentend, String wyccid,
			String claimsmanagerid, String gender, String name, String firstname, String dateofbirth, String email,
			String positiontype, String positioncrew, String monthlysalary, String salarycurrency, String period,
			String days, String months, String familycovered, String retirementplan, String startmovement,
			String endmovement, String employer, String children, String country, String nationality, String company1,
			String formula1, String policynumber1, String currency1, String excess1, String duration1,
			String totalamountinsured1, String ciehtbasis1, String company2, String formula2, String policynumber2,
			String currency2, String excess2, String duration2, String totalamountinsured2, String ciehtbasis2,
			String company3, String formula3, String policynumber3, String currency3, String excess3, String duration3,
			String totalamountinsured3, String ciehtbasis3, String company4, String formula4, String policynumber4,
			String currency4, String excess4, String duration4, String totalamountinsured4, String ciehtbasis4,
			String company5, String formula5, String policynumber5, String currency5, String excess5, String duration5,
			String totalamountinsured5, String ciehtbasis5, String company6, String formula, String policynumber6,
			String currency6, String excess6, String duration6, String totalamountinsured6, String ciehtbasis6,
			String company7, String formula7, String policynumber7, String currency7, String excess67, String duration7,
			String totalamountinsured7, String ciehtbasis7, String company8, String formula8, String policynumber8,
			String currency8, String excess8, String duration8, String totalamountinsured8, String ciehtbasis8,
			String formulename1, String formulename2, String formulename3, String formulename4, String formulename5,
			String formulename6, String formulename7, String formulename8) {
		super(structurename, certificate, certificatestart, certificaterenewal, certificatecancellation, amendmentstart,
				amendmentend, wyccid, claimsmanagerid, gender, name, firstname, dateofbirth, email, positiontype,
				positioncrew, monthlysalary, salarycurrency, period, days, months, familycovered, retirementplan,
				startmovement, endmovement, employer, children, country, nationality, company1, formula1, policynumber1,
				currency1, excess1, duration1, totalamountinsured1, ciehtbasis1, company2, formula2, policynumber2,
				currency2, excess2, duration2, totalamountinsured2, ciehtbasis2, company3, formula3, policynumber3,
				currency3, excess3, duration3, totalamountinsured3, ciehtbasis3, company4, formula4, policynumber4,
				currency4, excess4, duration4, totalamountinsured4, ciehtbasis4, company5, formula5, policynumber5,
				currency5, excess5, duration5, totalamountinsured5, ciehtbasis5, company6, formula, policynumber6,
				currency6, excess6, duration6, totalamountinsured6, ciehtbasis6, company7, formula7, policynumber7,
				currency7, excess67, duration7, totalamountinsured7, ciehtbasis7, company8, formula8, policynumber8,
				currency8, excess8, duration8, totalamountinsured8, ciehtbasis8);

		this.formulename1 = formulename1;
		this.formulename2 = formulename2;
		this.formulename3 = formulename3;
		this.formulename4 = formulename4;
		this.formulename5 = formulename5;
		this.formulename6 = formulename6;
		this.formulename7 = formulename7;
		this.formulename8 = formulename8;
	}

	public Mvt() {

	}

	/**
	 * @return the formulename1
	 */
	public String getFormulename1() {
		return formulename1;
	}

	/**
	 * @return the formulename2
	 */
	public String getFormulename2() {
		return formulename2;
	}

	/**
	 * @return the formulename3
	 */
	public String getFormulename3() {
		return formulename3;
	}

	/**
	 * @return the formulename4
	 */
	public String getFormulename4() {
		return formulename4;
	}

	/**
	 * @return the formulename5
	 */
	public String getFormulename5() {
		return formulename5;
	}

	/**
	 * @return the formulename6
	 */
	public String getFormulename6() {
		return formulename6;
	}

	/**
	 * @return the formulename7
	 */
	public String getFormulename7() {
		return formulename7;
	}

	/**
	 * @return the formulename8
	 */
	public String getFormulename8() {
		return formulename8;
	}

	/**
	 * @param formulename1
	 *            the formulename1 to set
	 */
	public void setFormulename1(String formulename1) {
		this.formulename1 = formulename1;
	}

	/**
	 * @param formulename2
	 *            the formulename2 to set
	 */
	public void setFormulename2(String formulename2) {
		this.formulename2 = formulename2;
	}

	/**
	 * @param formulename3
	 *            the formulename3 to set
	 */
	public void setFormulename3(String formulename3) {
		this.formulename3 = formulename3;
	}

	/**
	 * @param formulename4
	 *            the formulename4 to set
	 */
	public void setFormulename4(String formulename4) {
		this.formulename4 = formulename4;
	}

	/**
	 * @param formulename5
	 *            the formulename5 to set
	 */
	public void setFormulename5(String formulename5) {
		this.formulename5 = formulename5;
	}

	/**
	 * @param formulename6
	 *            the formulename6 to set
	 */
	public void setFormulename6(String formulename6) {
		this.formulename6 = formulename6;
	}

	/**
	 * @param formulename7
	 *            the formulename7 to set
	 */
	public void setFormulename7(String formulename7) {
		this.formulename7 = formulename7;
	}

	/**
	 * @param formulename8
	 *            the formulename8 to set
	 */
	public void setFormulename8(String formulename8) {
		this.formulename8 = formulename8;
	}

}
