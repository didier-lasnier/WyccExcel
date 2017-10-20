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
import com.dlas.gui.ModuleListeBoat;
import com.dlas.dao.ModulBoat;


public class ModulBoatModel extends AbstractModelObject {
	private List<ModulBoat> m_modulboats = new ArrayList();
	
	
	public void addModuls(Shell s, List<ModulBoat> listmodul, ModuleListeBoat moduleliste){
		m_modulboats.addAll(listmodul);
		firePropertyChange("m_modulboats", null, this.m_modulboats);
	}
	
	public void addOneModul(Shell s, ModulBoat modulboat, ModuleListeBoat window){
		m_modulboats.add(modulboat);
		firePropertyChange("ModulBoatModel", null, m_modulboats);
	}
	
	public void removeModul(ModulBoat modulboat) {
		m_modulboats.remove(modulboat);
		firePropertyChange("ModulBoatModel", null, m_modulboats);
	}
	
	public void removeModulofIndex (int index) {
		m_modulboats.remove(index);
	
		firePropertyChange("ModulBoatModel", null, m_modulboats);
	}
	
	public Integer getSize(){
		return 	m_modulboats.size();
	}
	
	public List getM_modulboats(){
		return m_modulboats;
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
