package com.dlas.gui.model;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import com.dlas.dao.LimitAggCsv;
import com.dlas.tools.CsvTools;
import com.poi.actionuser.Actionuser;

public class Companies extends AbstractModelObject {
	private final List/* <PhoneGroup> */m_companies = new ArrayList();

	public void addCompany(Shell s,Company company) {
		
		
		  		//public void widgetRead(){
				File directory = new File(".");
				String fileCharSep = System.getProperty("file.separator");
				try {
				FileDialog fd = new FileDialog(s, SWT.OPEN);
				fd.setText("Choose a file");
				fd.setFilterPath(directory.getCanonicalPath());
				String[] filterExt = { "*.csv"};
				fd.setFilterExtensions(filterExt);
				String selected = fd.open();
				CsvTools a = new CsvTools();
				Actionuser b = new Actionuser();
				if (selected !=null) {
						//ReadFileXlsx a = new ReadFileXlsx();
						try {
							
						List<LimitAggCsv>	listviewer=  b.readAggregate(a.getcsvfile(selected));
						List<LimitAggCsv>	listdistinct =listviewer.stream().filter(distinctByKey(p -> p.getCompany())).collect(Collectors.toList());
						for (LimitAggCsv agg :listdistinct){
							Company comp =new 	Company();
							comp.setCompany(agg.getCompany());
							for (LimitAggCsv distinct : listviewer) {
								comp.addBenefits(new Benefits(distinct.getCompany(),distinct.getFormula(),distinct.getFormulename(),distinct.getPolicynumber(),distinct.getAmount()));
							}
							m_companies.add(comp);
						}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//}
		
		 
		//m_companies.add(company);
		firePropertyChange("companies", null, m_companies);
	}

	public void removeCompany(Company company) {
		m_companies.remove(company);
		firePropertyChange("companies", null, m_companies);
	}

	public List getCompanies() {
		return m_companies;
	}
	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) 
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}