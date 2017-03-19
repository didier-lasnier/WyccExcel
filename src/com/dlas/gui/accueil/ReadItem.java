package com.dlas.gui.accueil;

import java.io.File;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import com.poi.actionuser.ReadFileXlsx;

public class ReadItem implements SelectionListener {
	private DateTime StartD;
	private DateTime EndD;
	private Shell    s;

	public ReadItem(){

	}
	public ReadItem(Shell s,DateTime StartD, DateTime EndD){
		this.s=s;
		this.StartD=StartD;
		this.EndD=EndD;
	}
	
	@Override
	public void widgetSelected(SelectionEvent event) {
		widgetRead(s,StartD,  EndD);

	}

	public void widgetSelectedBtn(SelectionEvent event,Shell s,DateTime StartD, DateTime EndD) {
		widgetRead(s,StartD,  EndD);
	}

	public void widgetRead(Shell s,DateTime StartD, DateTime EndD){
		File directory = new File(".");
		String fileCharSep = System.getProperty("file.separator");
		try {
		FileDialog fd = new FileDialog(s, SWT.OPEN);
		fd.setText("Choose a file");
		fd.setFilterPath(directory.getCanonicalPath());
		String[] filterExt = { "*.xlsx"};
		fd.setFilterExtensions(filterExt);
		String selected = fd.open();
		if (selected !=null) {
			ReadFileXlsx a = new ReadFileXlsx();
			try {
				a.readxls();
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
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub

	}

}
