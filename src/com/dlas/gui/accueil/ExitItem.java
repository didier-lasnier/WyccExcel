package com.dlas.gui.accueil;

import java.io.File;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import com.poi.actionuser.ReadFileXlsx;

public class ExitItem implements SelectionListener {
	private Display d;
	private Shell    s;

	public void ExitItem(){

	}
	public  ExitItem(Shell s,Display d){
		this.s=s;
		this.d=d;
	}
	
	@Override
	public void widgetSelected(SelectionEvent event) {
		widgetExit(s,d);

	}

	public void widgetExit(Shell s,Display d){
		MessageBox messageBox = new MessageBox(s, SWT.ICON_QUESTION | SWT.YES | SWT.NO);					
		messageBox.setMessage("Do you really want to exit? ");
		messageBox.setText("Exiting Application");
		int response = messageBox.open();
		
		if (response == SWT.YES){
			s.close();
			d.dispose();
			System.exit(0);
		}
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub

	}

}
