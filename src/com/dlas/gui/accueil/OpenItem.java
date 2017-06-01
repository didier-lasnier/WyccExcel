package com.dlas.gui.accueil;

import java.io.File;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import com.poi.actionuser.Actionuser;
import com.dlas.gui.ModulDialog;

public class OpenItem implements SelectionListener {
	private DateTime StartD;
	private DateTime EndD;
	private Shell    s;
	private String Dirpath;
	private Display d;
	public OpenItem(){}


	//public OpenItem(Shell s,DateTime StartD, DateTime EndD,String Dirpath){
	public OpenItem(Display  d,Shell s){
		this.s=s;
		this.d=d;
//		this.StartD=StartD;
//		this.EndD=EndD;
//		this.Dirpath=Dirpath;
	}
	@Override
	public void widgetSelected(SelectionEvent event) {
		widgetOpen(s,StartD,EndD);
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent event) {
	}

	public void widgetSelectedBtn(SelectionEvent event) {
		widgetOpen( s,StartD,  EndD);
	}
	
	public void widgetOpen(Shell s,DateTime StartD, DateTime EndD){
		ModulDialog moduldia = new ModulDialog (d) ;	

	}


}