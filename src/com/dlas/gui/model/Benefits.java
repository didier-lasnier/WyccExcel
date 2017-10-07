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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.dlas.dao.BenefitDb;
import com.dlas.dao.LimitAggCsv;
import com.dlas.gui.EcranAccueil;
import com.dlas.tools.CsvTools;
import com.poi.actionuser.Actionuser;
import com.poi.dlas.WyccWorkbook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Benefits extends AbstractModelObject {
	Logger logger=LogManager.getLogger("Wycc");
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
				    logger.info("File selectd "+selected);
					window.setFilepath(selected );
					try {
					CsvTools a = new CsvTools();
					Actionuser b = new Actionuser();
					// le fichier csv est lu et est en mémoire
					window.setListCsv(a.getcsvfile(selected));
					//on construit une collections avec les données des companies 
					List<LimitAggCsv>	listviewer   = b.readAggregate(window.getListCsv());
					List<LimitAggCsv>	listdistinct = distinctList(listviewer,LimitAggCsv::getPolicynumber,LimitAggCsv::getFormula,LimitAggCsv::getFormulename,LimitAggCsv::getCompany);
					if (false) {

					} else {

							for (LimitAggCsv distinct :listdistinct){
							// on recupére les données précédement enregistrées
							Session lasession=wyccwb.CreateDataSession();	
							String amount = wyccwb.getAggregate(distinct.getCompany(),distinct.getFormula(),distinct.getFormulename(),distinct.getPolicynumber(),lasession );
							wyccwb.closedataSession(lasession);
							m_benefits.add(new Benefit(distinct.getCompany(),distinct.getFormula(),distinct.getFormulename(),distinct.getPolicynumber(),amount));
						}

					}
					
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						logger.error(e1);
						e1.printStackTrace();
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error(e);
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error(e);
				e.printStackTrace();
			}
		firePropertyChange("benefits", null, m_benefits);
	}

	public void addBenefits(String selected,Shell s, Benefit benefit, EcranAccueil window,IProgressMonitor monitor) {
		  WyccWorkbook wyccwb = new WyccWorkbook();

			File directory = new File(".");
			String fileCharSep = System.getProperty("file.separator");
			try {
			if (selected !=null) {
				    logger.info("File open : "+selected);
					window.setFilepath(selected );
					try {
					CsvTools a = new CsvTools();
					Actionuser b = new Actionuser();
					// le fichier csv est lu et est en mémoire
					window.setListCsv(a.getcsvfile(selected));
					//on construit une collections avec les données des companies 
					
					 monitor.setTaskName("Processing file gettings the various formula and waranty.");
					 monitor.worked(1);
					 //monitor.subTask("Processing beneficiaries ");
						List<LimitAggCsv>	listviewer   = b.readAggregate(window.getListCsv(),monitor);
						List<LimitAggCsv>	listdistinct = distinctList(listviewer,LimitAggCsv::getPolicynumber,LimitAggCsv::getFormula,LimitAggCsv::getFormulename,LimitAggCsv::getCompany);
						Session lasession=null;

						/*
						lasession=wyccwb.CreateDataSession();
						Query query = lasession.createQuery( "FROM BenefitDb where (company,formula,formulename,policynumber,amount) in :listdistinct");
						query.setParameterList("listdistinct", listdistinct);
						List<BenefitDb> resultdistinct = query.list();
						wyccwb.closedataSession(lasession);
						
*/
						monitor.setTaskName("Processing data .");
						monitor.subTask("Launch database this operation could take a while");
						monitor.worked(1);
						
						lasession=wyccwb.CreateDataSession();
						for (LimitAggCsv distinct :listdistinct){
						// on recupére les données précédement enregistrées							
						monitor.worked(1);
						String amount = wyccwb.getAggregate(distinct.getCompany(),distinct.getFormula(),distinct.getFormulename(),distinct.getPolicynumber(),lasession );
                        monitor.subTask("process : "+distinct.getCompany());
						monitor.worked(1);
						m_benefits.add(new Benefit(distinct.getCompany(),distinct.getFormula(),distinct.getFormulename(),distinct.getPolicynumber(),amount));
					
						
					    }
						
						wyccwb.closedataSession(lasession);

				
					
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						logger.error(e1);
						e1.printStackTrace();
					}
				}
			} catch (Exception e) {
				logger.error(e);
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

