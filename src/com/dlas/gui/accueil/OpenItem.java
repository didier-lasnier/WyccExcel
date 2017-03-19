package com.dlas.gui.accueil;

import java.io.File;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import com.poi.actionuser.Actionuser;

public class OpenItem implements SelectionListener {
	private DateTime StartD;
	private DateTime EndD;
	private Shell    s;

	public OpenItem(){}


	public OpenItem(Shell s,DateTime StartD, DateTime EndD){
		this.s=s;
		this.StartD=StartD;
		this.EndD=EndD;
	}
	@Override
	public void widgetSelected(SelectionEvent event) {
		widgetOpen(s,StartD,EndD);
	}

	public void widgetDefaultSelected(SelectionEvent event) {
	}

	public void widgetSelectedBtn(SelectionEvent event) {
		widgetOpen( s,StartD,  EndD);
	}
	
	public void widgetOpen(Shell s,DateTime StartD, DateTime EndD){
		File directory = new File(".");
		String fileCharSep = System.getProperty("file.separator");

		try {
			FileDialog fd = new FileDialog(s, SWT.OPEN);
			fd.setText("Open");
			fd.setFilterPath(directory.getCanonicalPath());
			String[] filterExt = { "*.csv","*.txt" };
			fd.setFilterExtensions(filterExt);
			String selected = fd.open();
			if (selected !=null) {
				Actionuser a = new Actionuser();
				a.lanceLecture(selected, StartD, EndD);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}