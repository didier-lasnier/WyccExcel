package com.dlas.gui.accueil;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;


public class MenuAccueil {
	private Integer DisplayStatus =0;
	
	
	public Integer getDisplayStatus() {
		return DisplayStatus;
	}

	public void setDisplayStatus(Integer displayStatus) {
		DisplayStatus = displayStatus;
	}

	public MenuAccueil(){};
	
	public MenuAccueil(Shell s,Display d,DateTime StartD, DateTime EndD,String dirpath){
		
	Menu m = new Menu(s, SWT.BAR);
	// create a file menu and add an exit item
	final MenuItem file = new MenuItem(m, SWT.CASCADE);
	file.setText("&File");
	final Menu filemenu = new Menu(s, SWT.DROP_DOWN);
	file.setMenu(filemenu);
	
/*	final MenuItem openItem = new MenuItem(filemenu, SWT.PUSH);
	openItem.setText("&Module\tCTRL+O");
	openItem.setAccelerator(SWT.CTRL + 'O');
	final MenuItem separator = new MenuItem(filemenu, SWT.SEPARATOR);
	OpenItem oitem = new OpenItem(d,s);
	openItem.addSelectionListener(oitem);
	*/
	
	final MenuItem modulelisteitem = new MenuItem(filemenu, SWT.PUSH);
	modulelisteitem.setText("&Module Client\tCTRL+M");
	modulelisteitem.setAccelerator(SWT.CTRL + 'M');
	ModulBoatItem Mbitem = new ModulBoatItem(d,s);
	modulelisteitem.addSelectionListener(Mbitem);
	
	
/*	final MenuItem separator1 = new MenuItem(filemenu, SWT.SEPARATOR);
	final MenuItem exitItem = new MenuItem(filemenu, SWT.PUSH);
	exitItem.setText("&Quit\tCRTL+Q");
	exitItem.setAccelerator(SWT.CTRL + 'Q');
	

    exitItem.addSelectionListener(new ExitItem(s,d));*/
    
    s.setMenuBar(m);

	}
	

}
