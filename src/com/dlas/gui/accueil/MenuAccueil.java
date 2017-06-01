package com.dlas.gui.accueil;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import com.dlas.gui.accueil.SaveItem;


public class MenuAccueil {

	public MenuAccueil(){};
	
	public MenuAccueil(Shell s,Display d,DateTime StartD, DateTime EndD,String dirpath){
		
	Menu m = new Menu(s, SWT.BAR);
	// create a file menu and add an exit item
	final MenuItem file = new MenuItem(m, SWT.CASCADE);
	file.setText("&File");
	final Menu filemenu = new Menu(s, SWT.DROP_DOWN);
	file.setMenu(filemenu);
	final MenuItem openItem = new MenuItem(filemenu, SWT.PUSH);
	openItem.setText("&Open Csv file\tCTRL+O");
	openItem.setAccelerator(SWT.CTRL + 'O');
	final MenuItem saveItem = new MenuItem(filemenu, SWT.PUSH);
	saveItem.setText("&Save Invoice file\tCTRL+S");
	saveItem.setAccelerator(SWT.CTRL + 'S');
	MenuItem readItem = new MenuItem(filemenu, SWT.PUSH);
	readItem.setText("&Read formula\tCTRL+B");
	readItem.setAccelerator(SWT.CTRL + 'B');
	final MenuItem separator = new MenuItem(filemenu, SWT.SEPARATOR);
	final MenuItem exitItem = new MenuItem(filemenu, SWT.PUSH);
	exitItem.setText("&Quit\tCRTL+Q");
	exitItem.setAccelerator(SWT.CTRL + 'Q');
	
	openItem.addSelectionListener(new OpenItem(d,s));
	
	saveItem.addSelectionListener(new SaveItem(s,StartD,EndD));
	
	readItem.addSelectionListener(new ReadItem(s,StartD,EndD));
	
    exitItem.addSelectionListener(new ExitItem(s,d));
    
    s.setMenuBar(m);
	}
	

}
