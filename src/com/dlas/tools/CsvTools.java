package com.dlas.tools;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import com.dlas.dao.Mvt;
import com.dlas.dao.MvtCsv;
import com.dlas.tools.*;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;

public class CsvTools {

	public void CsvTools() {
	}

	public void readcsvfile(PreparedStatement stmt, String filenamecsv) throws IOException, SQLException {
		// Build reader instance
		// Read data.csv
		// Default seperator is comma
		// Default quote character is double quote
		// Start reading from line number 2 (line numbers start from zero)
		/*CSVReader reader = null;
		MappingStrategy mapping = new MappingStrategy();
		try {
			reader = new CSVReader(new FileReader(filenamecsv), ';', '"', 4);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Read CSV line by line and use the string array as you want
		CsvToBean<MvtCsv> csvToBean = new CsvToBean<MvtCsv>();
		CSVMappedMvt objectCSV = new CSVMappedMvt();

		List<MvtCsv> list = csvToBean.parse(mapping.setColumMapping(), reader);*/
		List<MvtCsv> list=getcsvfile(filenamecsv);
		String[] nextLine;
		int i = 5;
		MvtCsv recordmodule = null;
		for (MvtCsv object : list) {
			if (i == 5) {
				recordmodule = object;
			} else if (i >= 7) {
				System.out.println(object.getWyccid());
				saveRecord(stmt, object, recordmodule);
			}

			i++;
		}

	}
	public List<MvtCsv> getcsvfile( String filenamecsv) throws IOException, SQLException {
		// Build reader instance
		// Read data.csv
		// Default seperator is comma
		// Default quote character is double quote
		// Start reading from line number 2 (line numbers start from zero)
		CSVReader reader = null;
		MappingStrategy mapping = new MappingStrategy();
		try {
			reader = new CSVReader(new FileReader(filenamecsv), ';', '"', 4);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Read CSV line by line and use the string array as you want
		CsvToBean<MvtCsv> csvToBean = new CsvToBean<MvtCsv>();
		CSVMappedMvt objectCSV = new CSVMappedMvt();

		List<MvtCsv> list = csvToBean.parse(mapping.setColumMapping(), reader);
		return list;
	}
	// lecture record
	public void lireRecord(Mvt csvRecord) {

	}

	// save dans la table
	public void saveRecord(PreparedStatement statement, MvtCsv object, MvtCsv recordmodule) throws SQLException {

		statement.setString(1, object.getStructurename());
		statement.setString(2, object.getCertificate());
		statement.setString(3, object.getCertificatestart());
		statement.setString(4, object.getCertificaterenewal());
		statement.setString(5, object.getCertificatecancellation());
		statement.setString(6, object.getAmendmentstart());
		statement.setString(7, object.getAmendmentend());
		statement.setString(8, object.getWyccid());
		statement.setString(9, object.getClaimsmanagerid());
		statement.setString(10, object.getGender());
		statement.setString(11, object.getName());
		statement.setString(12, object.getFirstname());
		statement.setString(13, object.getDateofbirth());
		statement.setString(14, object.getEmail());
		statement.setString(15, object.getPositiontype());
		statement.setString(16, object.getPositioncrew());
		statement.setString(17, object.getMonthlysalary());
		statement.setString(18, object.getSalarycurrency());
		statement.setString(19, object.getPeriod());
		statement.setString(20, object.getDays());
		statement.setString(21, object.getMonths());
		statement.setString(22, object.getFamilycovered());
		statement.setString(23, object.getRetirementplan());
		statement.setString(24, object.getStartmovement());
		statement.setString(25, object.getEndmovement());
		statement.setString(26, object.getEmployer());
		statement.setString(27, object.getChildren());
		statement.setString(28, object.getCountry());
		statement.setString(29, object.getNationality());
		statement.setString(30, object.getCompany1());
		statement.setString(31, object.getFormula1());
		statement.setString(32, object.getPolicynumber1());
		statement.setString(33, object.getCurrency1());
		statement.setString(34, object.getExcess1());
		statement.setString(35, object.getDuration1());
		statement.setString(36, object.getTotalamountinsured1());
		statement.setString(37, object.getCiehtbasis1());
		statement.setString(38, object.getCompany2());
		statement.setString(39, object.getFormula2());
		statement.setString(40, object.getPolicynumber2());
		statement.setString(41, object.getCurrency2());
		statement.setString(42, object.getExcess2());
		statement.setString(43, object.getDuration2());
		statement.setString(44, object.getTotalamountinsured2());
		statement.setString(45, object.getCiehtbasis2());
		statement.setString(46, object.getCompany3());
		statement.setString(47, object.getFormula3());
		statement.setString(48, object.getPolicynumber3());
		statement.setString(49, object.getCurrency3());
		statement.setString(50, object.getExcess3());
		statement.setString(51, object.getDuration3());
		statement.setString(52, object.getTotalamountinsured3());
		statement.setString(53, object.getCiehtbasis3());
		statement.setString(54, object.getCompany4());
		statement.setString(55, object.getFormula4());
		statement.setString(56, object.getPolicynumber4());
		statement.setString(57, object.getCurrency4());
		statement.setString(58, object.getExcess4());
		statement.setString(59, object.getDuration4());
		statement.setString(60, object.getTotalamountinsured4());
		statement.setString(61, object.getCiehtbasis4());
		statement.setString(62, object.getCompany5());
		statement.setString(63, object.getFormula5());
		statement.setString(64, object.getPolicynumber5());
		statement.setString(65, object.getCurrency5());
		statement.setString(66, object.getExcess5());
		statement.setString(67, object.getDuration5());
		statement.setString(68, object.getTotalamountinsured5());
		statement.setString(69, object.getCiehtbasis5());
		statement.setString(70, object.getCompany6());
		statement.setString(71, object.getFormula());
		statement.setString(72, object.getPolicynumber6());
		statement.setString(73, object.getCurrency6());
		statement.setString(74, object.getExcess6());
		statement.setString(75, object.getDuration6());
		statement.setString(76, object.getTotalamountinsured6());
		statement.setString(77, object.getCiehtbasis6());
		statement.setString(78, object.getCompany7());
		statement.setString(79, object.getFormula7());
		statement.setString(80, object.getPolicynumber7());
		statement.setString(81, object.getCurrency7());
		statement.setString(82, object.getExcess67());
		statement.setString(83, object.getDuration7());
		statement.setString(84, object.getTotalamountinsured7());
		statement.setString(85, object.getCiehtbasis7());
		statement.setString(86, object.getCompany8());
		statement.setString(87, object.getFormula8());
		statement.setString(88, object.getPolicynumber8());
		statement.setString(89, object.getCurrency8());
		statement.setString(90, object.getExcess8());
		statement.setString(91, object.getDuration8());
		statement.setString(92, object.getTotalamountinsured8());
		statement.setString(93, object.getCiehtbasis8());

		statement.setString(94, recordmodule.getCompany1());
		statement.setString(95, recordmodule.getCompany2());
		statement.setString(96, recordmodule.getCompany3());
		statement.setString(97, recordmodule.getCompany4());
		statement.setString(98, recordmodule.getCompany5());
		statement.setString(99, recordmodule.getCompany6());
		statement.setString(100, recordmodule.getCompany7());
		statement.setString(101, recordmodule.getCompany8());

		statement.executeUpdate();

	}

}
