package com.dlas.tools;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.hibernate.Session;

import com.dlas.dao.ModulBoat;
import com.dlas.dao.Mvt;
import com.dlas.dao.Mvt2;
import com.dlas.dao.MvtCsv;
import com.dlas.dao.beneficiaries;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.poi.dlas.WyccWorkbook;

public class CsvTools {

	public void CsvTools() {
	}

	public void readcsvfile(PreparedStatement stmt, String filenamecsv,IProgressMonitor monitor, Session lasession) throws IOException, SQLException, InvocationTargetException, InterruptedException {
		// Build reader instance
		// Read data.csv
		// Default seperator is comma
		// Default quote character is double quote
		// Start reading from line number 2 (line numbers start from zero)

		
		List<MvtCsv> list=getcsvfile(filenamecsv);
		saveCSVRecord(monitor,"",stmt,filenamecsv,list.size(),this,list,lasession);
		

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
	
	
	public void saveCSVRecord (IProgressMonitor monitor,String message,PreparedStatement stmt, String filenamecsv,int workload,CsvTools csvtools,List<MvtCsv> list, Session lasession ){
		try {
			list = csvtools.getcsvfile(filenamecsv);
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    int i = 5;
		    int countor=1;
			MvtCsv recordmodule = null;
			Mvt2 lemvt =new Mvt2();
			for (MvtCsv object : list) {
				monitor.subTask("Processing csv line : "+ countor + " of "+  workload + "...");
				if (i == 5) {
					recordmodule = object;
				} else if (i >= 7) {
					System.out.println(object.getWyccid());
					saveMvt(lemvt,object, recordmodule);
					lasession.save(lemvt);
					lasession.flush();
					lasession.clear();
//					try {
//						csvtools.saveRecord(stmt, object, recordmodule);
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}
				monitor.worked(1);
				countor++;
				i++;
			}
	}
	public static class ProgressBarDb implements IRunnableWithProgress {
		 private String              message;
		 private PreparedStatement   stmt;
		 private String              filenamecsv;
		 private int                 workload     ;
		 private CsvTools            csvtools;
		 private List<MvtCsv>        list;
		 
		 
		public ProgressBarDb(String message,PreparedStatement stmt, String filenamecsv,int workload,CsvTools csvtools,List<MvtCsv> list){
			
          this.message     = message;
          this.stmt        = stmt;
          this.filenamecsv = filenamecsv;
          this.workload    = workload;
          this.csvtools    = csvtools;
          this.list        = list;
		}
		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			 monitor.beginTask(message, workload);
			
			try {
				list = csvtools.getcsvfile(filenamecsv);
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			    int i = 5;
			    int countor=1;
				MvtCsv recordmodule = null;
				for (MvtCsv object : list) {
					monitor.subTask("Processing csv line : "+ countor + " of "+  workload + "...");
					if (i == 5) {
						recordmodule = object;
					} else if (i >= 7) {
						System.out.println(object.getWyccid());
						try {
							csvtools.saveRecord(stmt, object, recordmodule);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					monitor.worked(1);
					countor++;
					i++;
				}
			 monitor.done();
		}
		
	}

	public void saveMvt(Mvt2 lemvt,MvtCsv object, MvtCsv recordmodule){
		//lemvt.setMvtid(
				lemvt.setStructurename(object.getStructurename());
				lemvt.setCertificate(object.getCertificate());
				lemvt.setCertificatestart(object.getCertificatestart());
				lemvt.setCertificaterenewal(object.getCertificaterenewal());
				lemvt.setCertificatecancellation(object.getCertificatecancellation());
				lemvt.setAmendmentstart(object.getAmendmentstart());
				lemvt.setAmendmentend(object.getAmendmentend());
				lemvt.setWyccid(object.getWyccid());
				lemvt.setClaimsmanagerid(object.getClaimsmanagerid());
				lemvt.setGender(object.getGender());
				lemvt.setName(object.getName());
				lemvt.setFirstname(object.getFirstname());
				lemvt.setDateofbirth(object.getDateofbirth());
				lemvt.setEmail(object.getEmail());
				lemvt.setPositiontype(object.getPositiontype());
				lemvt.setPositioncrew(object.getPositioncrew());
				lemvt.setMonthlysalary(object.getMonthlysalary());
				lemvt.setSalarycurrency(object.getSalarycurrency());
				lemvt.setPeriodinsurance(object.getPeriod());
				lemvt.setDays(object.getDays());
				lemvt.setMonths(object.getMonths());
				lemvt.setFamilycovered(object.getFamilycovered());
				lemvt.setRetirementplan(object.getRetirementplan());
				lemvt.setStartmovement(object.getStartmovement());
				lemvt.setEndmovement(object.getEndmovement());
				lemvt.setEmployer(object.getEmployer());
				lemvt.setChildren(object.getChildren());
				lemvt.setCountry(object.getCountry());
				lemvt.setNationality(object.getNationality());
				lemvt.setCompany1(object.getCompany1());
				lemvt.setFormula1(object.getFormula1());
				lemvt.setPolicynumber1(object.getPolicynumber1());
				lemvt.setCurrency1(object.getCurrency1());
				lemvt.setExcess1(object.getExcess1());
				lemvt.setDuration1(object.getDuration1());
				lemvt.setTotalamountinsured1(object.getTotalamountinsured1());
				lemvt.setCiehtbasis1(object.getCiehtbasis1());
				lemvt.setCompany2(object.getCompany2());
				lemvt.setFormula2(object.getFormula2());
				lemvt.setPolicynumber2(object.getPolicynumber2());
				lemvt.setCurrency2(object.getCurrency2());
				lemvt.setExcess2(object.getExcess2());
				lemvt.setDuration2(object.getDuration2());
				lemvt.setTotalamountinsured2(object.getTotalamountinsured2());
				lemvt.setCiehtbasis2(object.getCiehtbasis2());
				lemvt.setCompany3(object.getCompany3());
				lemvt.setFormula3(object.getFormula3());
				lemvt.setPolicynumber3(object.getPolicynumber3());
				lemvt.setCurrency3(object.getCurrency3());
				lemvt.setExcess3(object.getExcess3());
				lemvt.setDuration3(object.getDuration3());
				lemvt.setTotalamountinsured3(object.getTotalamountinsured3());
				lemvt.setCiehtbasis3(object.getCiehtbasis3());
				lemvt.setCompany4(object.getCompany4());
				lemvt.setFormula4(object.getFormula4());
				lemvt.setPolicynumber4(object.getPolicynumber4());
				lemvt.setCurrency4(object.getCurrency4());
				lemvt.setExcess4(object.getExcess4());
				lemvt.setDuration4(object.getDuration4());
				lemvt.setTotalamountinsured4(object.getTotalamountinsured4());
				lemvt.setCiehtbasis4(object.getCiehtbasis4());
				lemvt.setCompany5(object.getCompany5());
				lemvt.setFormula5(object.getFormula5());
				lemvt.setPolicynumber5(object.getPolicynumber5());
				lemvt.setCurrency5(object.getCurrency5());
				lemvt.setExcess5(object.getExcess5());
				lemvt.setDuration5(object.getDuration5());
				lemvt.setTotalamountinsured5(object.getTotalamountinsured5());
				lemvt.setCiehtbasis5(object.getCiehtbasis5());
				lemvt.setCompany6(object.getCompany6());
				lemvt.setFormula(object.getFormula());
				lemvt.setPolicynumber6(object.getPolicynumber6());
				lemvt.setCurrency6(object.getCurrency6());
				lemvt.setExcess6(object.getExcess6());
				lemvt.setDuration6(object.getDuration6());
				lemvt.setTotalamountinsured6(object.getTotalamountinsured6());
				lemvt.setCiehtbasis6(object.getCiehtbasis6());
				lemvt.setCompany7(object.getCompany7());
				lemvt.setFormula7(object.getFormula7());
				lemvt.setPolicynumber7(object.getPolicynumber7());
				lemvt.setCurrency7(object.getCurrency7());
				lemvt.setExcess67(object.getExcess67());
				lemvt.setDuration7(object.getDuration7());
				lemvt.setTotalamountinsured7(object.getTotalamountinsured7());
				lemvt.setCiehtbasis7(object.getCiehtbasis7());
				lemvt.setCompany8(object.getCompany8());
				lemvt.setFormula8(object.getFormula8());
				lemvt.setPolicynumber8(object.getPolicynumber8());
				lemvt.setCurrency8(object.getCurrency8());
				lemvt.setExcess8(object.getExcess8());
				lemvt.setDuration8(object.getDuration8());
				lemvt.setTotalamountinsured8(object.getTotalamountinsured8());
				lemvt.setCiehtbasis8(object.getCiehtbasis8());
				lemvt.setFormulename1(recordmodule.getCompany1());
				lemvt.setFormulename2(recordmodule.getCompany2());
				lemvt.setFormulename3(recordmodule.getCompany3());
				lemvt.setFormulename4(recordmodule.getCompany4());
				lemvt.setFormulename5(recordmodule.getCompany5());
				lemvt.setFormulename6(recordmodule.getCompany6());
				lemvt.setFormulename7(recordmodule.getCompany7());
				lemvt.setFormulename8(recordmodule.getCompany8());
	
	}
}
