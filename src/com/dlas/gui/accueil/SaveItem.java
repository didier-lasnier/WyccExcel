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

public class SaveItem implements SelectionListener {
	private DateTime StartD;
	private DateTime EndD;
	private Shell    s;

	public SaveItem(){

	}
	
	public SaveItem(Shell s,DateTime StartD, DateTime EndD){
		this.s=s;
		this.StartD=StartD;
		this.EndD=EndD;
	}
	
	@Override
	public void widgetSelected(SelectionEvent event) {
		widgetSave(s,StartD,EndD);

	}

	public void widgetSelectedBtn(SelectionEvent event,Shell s,DateTime StartD, DateTime EndD) {
		widgetSave(s,StartD,EndD);
	}

	public void widgetSave(Shell s,DateTime StartD, DateTime EndD){
		File directory = new File(".");
		String fileCharSep = System.getProperty("file.separator");
		FileDialog fd = new FileDialog(s, SWT.SAVE);
		fd.setText("Save");
		try {
			fd.setFilterPath(directory.getCanonicalPath());
			String[] filterExt = { "*.xlsx" };
			fd.setFilterExtensions(filterExt);
			String selected = fd.open();
			if (selected !=null){
				ReadFileXlsx a = new ReadFileXlsx();
				try {
					a.generexls(selected);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub

	}

}
