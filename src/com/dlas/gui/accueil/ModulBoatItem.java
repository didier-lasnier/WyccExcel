package com.dlas.gui.accueil;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.dlas.dao.ObjectDao;
import com.dlas.gui.ModuleListeBoat;

public class ModulBoatItem implements SelectionListener {
	private DateTime    StartD;
	private DateTime    EndD;
	private Shell       s;
	private String      Dirpath;
	private Display     d;
	private Integer     CountSelectedItem=0;
	private ObjectDao   theconnection;
	
	
	public DateTime getStartD() {
		return StartD;
	}


	public void setStartD(DateTime startD) {
		StartD = startD;
	}


	public DateTime getEndD() {
		return EndD;
	}


	public void setEndD(DateTime endD) {
		EndD = endD;
	}


	public Shell getS() {
		return s;
	}


	public void setS(Shell s) {
		this.s = s;
	}


	public String getDirpath() {
		return Dirpath;
	}


	public void setDirpath(String dirpath) {
		Dirpath = dirpath;
	}


	public Display getD() {
		return d;
	}


	public void setD(Display d) {
		this.d = d;
	}


	public Integer getCountSelectedItem() {
		return CountSelectedItem;
	}


	public void setCountSelectedItem(Integer countSelectedItem) {
		CountSelectedItem = countSelectedItem;
	}


	public ModulBoatItem(){}


	//public OpenItem(Shell s,DateTime StartD, DateTime EndD,String Dirpath){
	public ModulBoatItem(Display  d,Shell s,ObjectDao myconnection){
		this.s=s;
		this.d=d;
		this.theconnection=myconnection;
//		this.StartD=StartD;
//		this.EndD=EndD;
//		this.Dirpath=Dirpath;
	}
	@Override
	public void widgetSelected(SelectionEvent event) {
		try {
			widgetOpen(s,StartD,EndD,theconnection);
		} catch (InvocationTargetException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent event) {
	}

	public void widgetSelectedBtn(SelectionEvent event) throws InvocationTargetException, InterruptedException {
		widgetOpen( s,StartD,  EndD,theconnection);
	}
	
	public void widgetOpen(Shell s,DateTime StartD, DateTime EndD,ObjectDao theconnection) throws InvocationTargetException, InterruptedException{
		this.setCountSelectedItem(this.getCountSelectedItem()+1);
		this.theconnection=theconnection;
		ModuleListeBoat modulboatdia = new ModuleListeBoat () ;	
		modulboatdia.setDefaultValues(d,theconnection);
		modulboatdia.Moduldisplay(d);

	}


}