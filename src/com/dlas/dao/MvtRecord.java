package com.dlas.dao;

import java.util.Date;

import org.hibernate.annotations.Columns;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

public class MvtRecord extends MvtCsv {
	@Id
	private Integer Id;

	public MvtRecord() {

	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}

	public MvtRecord(Integer id, String structurename, String certificate, String certificatestart,
			String certificaterenewal, String certificatecancellation, String amendmentstart, String amendmentend,
			String wyccid, String claimsmanagerid, String gender, String name, String firstname, String dateofbirth,
			String email, String positiontype, String positioncrew, String monthlysalary, String salarycurrency,
			String period, String days, String months, String familycovered, String retirementplan,
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
			String totalamountinsured8, String ciehtbasis8) {
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
		Id = id;
	}

}
