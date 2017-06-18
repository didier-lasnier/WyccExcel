package com.dlas.gui.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.swt.widgets.Shell;
import org.hibernate.Session;
import org.hibernate.query.Query;

//import com.dlas.gui.ModulDialog;
import com.dlas.gui.ModuleListe;


import com.dlas.dao.Modul;
import com.dlas.dao.ObjectDao;


public class ModulModel extends AbstractModelObject {
	private List<Modul> m_moduls = new ArrayList();
	
	
	public void addModuls(Shell s, List<Modul> listmodul, ModuleListe window){
		m_moduls.addAll(listmodul);
		firePropertyChange("modulmodel", null, m_moduls);
	}
	
	public void removeBenefit(Modul modul) {
		m_moduls.remove(modul);
		firePropertyChange("modulmodel", null, m_moduls);
	}
	
	public List getM_moduls(){
		return m_moduls;
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
