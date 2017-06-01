package com.dlas.gui.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.dlas.gui.EcranAccueil;
import com.dlas.tools.CsvTools;
import com.poi.actionuser.Actionuser;
import com.poi.dlas.WyccWorkbook;



public class Benefits extends AbstractModelObject {
	private final List/* <PhoneGroup> */m_benefits = new ArrayList();
	
	
	public void addBenefit(Shell s, Benefit benefit, EcranAccueil window) {
		  WyccWorkbook wyccwb = new WyccWorkbook();
  		//public void widgetRead(){
			File directory = new File(".");
			String fileCharSep = System.getProperty("file.separator");
			try {
			FileDialog fd = new FileDialog(s, SWT.OPEN);
			fd.setText("Choose a file");
			fd.setFilterPath(directory.getCanonicalPath());
			String[] filterExt = { "*.csv"};
			fd.setFilterExtensions(filterExt);
			String selected=fd.open();
			

			if (selected !=null) {
				 window.setFilepath(selected );
					try {
					CsvTools a = new CsvTools();
					Actionuser b = new Actionuser();
					// le fichier csv est lu et est en mémoire
					window.setListCsv(a.getcsvfile(selected));
					//on construit une collections avec les données des companies 
					List<LimitAggCsv>	listviewer=  b.readAggregate(window.getListCsv());
					List<LimitAggCsv>	listdistinct	= distinctList(listviewer,LimitAggCsv::getPolicynumber,LimitAggCsv::getFormula,LimitAggCsv::getFormulename,LimitAggCsv::getCompany);
					if (false) {

					} else {
						
					//for (LimitAggCsv agg :listdistinct){
						
						//for (LimitAggCsv distinct : listviewer) 
							for (LimitAggCsv distinct :listdistinct){
							// on recupére les données précédement enregistrées
							String amount = wyccwb.readaggregate(distinct.getCompany(),distinct.getFormula(),distinct.getFormulename(),distinct.getPolicynumber() );
							
							m_benefits.add(new Benefit(distinct.getCompany(),distinct.getFormula(),distinct.getFormulename(),distinct.getPolicynumber(),amount));
						}
					//}
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
		firePropertyChange("benefits", null, m_benefits);
	}
	
	public void removeBenefit(Benefit benefit) {
		m_benefits.remove(benefit);
		firePropertyChange("benefits", null, m_benefits);
	}
	
	public List getBenefits(){
		return m_benefits;
	}
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) 
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
	
	public static <T> List<T> distinctList(List<T> list, Function<? super T, ?>... keyExtractors) {

	    return list
	        .stream()
	        .filter(distinctByKeys(keyExtractors))
	        .collect(Collectors.toList());
	}

	private static <T> Predicate<T> distinctByKeys(Function<? super T, ?>... keyExtractors) {

	    final Map<List<?>, Boolean> seen = new ConcurrentHashMap<>();

	    return t -> {

	        final List<?> keys = Arrays.stream(keyExtractors)
	            .map(ke -> ke.apply(t))
	            .collect(Collectors.toList());

	        return seen.putIfAbsent(keys, Boolean.TRUE) == null;

	    };

	}
	
	
}

