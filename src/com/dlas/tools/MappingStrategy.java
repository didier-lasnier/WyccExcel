package com.dlas.tools;

import com.dlas.dao.ModulBoat;
import com.dlas.dao.Mvt;
import com.opencsv.bean.ColumnPositionMappingStrategy;

public class MappingStrategy {

	public void MappingStartegy() {

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ColumnPositionMappingStrategy setColumMapping() {
		ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
		strategy.setType(Mvt.class);
		String[] columns = new String[] { "structurename", "certificate", "certificatestart", "certificaterenewal",
				"certificatecancellation", "amendmentstart", "amendmentend", "wyccid", "claimsmanagerid", "gender",
				"name", "firstname", "dateofbirth", "email", "positiontype", "positioncrew", "monthlysalary",
				"salarycurrency", "period", "days", "months", "familycovered", "retirementplan", "startmovement",
				"endmovement", "employer", "children", "country", "nationality", "company1", "formula1",
				"policynumber1", "currency1", "excess1", "duration1", "totalamountinsured1", "ciehtbasis1", "company2",
				"formula2", "policynumber2", "currency2", "excess2", "duration2", "totalamountinsured2", "ciehtbasis2",
				"company3", "formula3", "policynumber3", "currency3", "excess3", "duration3", "totalamountinsured3",
				"ciehtbasis3", "company4", "formula4", "policynumber4", "currency4", "excess4", "duration4",
				"totalamountinsured4", "ciehtbasis4", "company5", "formula5", "policynumber5", "currency5", "excess5",
				"duration5", "totalamountinsured5", "ciehtbasis5", "company6", "formula", "policynumber6", "currency6",
				"excess6", "duration6", "totalamountinsured6", "ciehtbasis6", "company7", "formula7", "policynumber7",
				"currency7", "excess7", "duration7", "totalamountinsured7", "ciehtbasis7", "company8", "formula8",
				"policynumber8", "currency8", "excess8", "duration8", "totalamountinsured8", "ciehtbasis8"
				// ,"formulename1","formulename2","formulename3","formulename4","formulename5","formulename6","formulename7","formulename8"
		};
		strategy.setColumnMapping(columns);
		return strategy;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ColumnPositionMappingStrategy setColumMapping(Object filecategory) {
		ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
		strategy.setType(Object.class);
		String[] columns;
		if (filecategory.getClass().equals(ModulBoat.class) )
		{
		        columns = new String[] { "modulid","modul_fournisseur","modullabel","modulecategory","modulboat",
		        		                 "modulpricesingle","modulpricefamily","forfaitpercentage","modulscope","invoiceperiod","calculmode","bankfee","surcom"
		};
		strategy.setColumnMapping(columns);
		}
		return strategy;
	}
	
}
