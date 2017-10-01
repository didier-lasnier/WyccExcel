package com.dlas.gui.accueil;

import javax.swing.JOptionPane;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.apple.mrj.MRJAboutHandler;
import com.apple.mrj.MRJPrefsHandler;
import com.apple.mrj.MRJQuitHandler;

public class MacOSXControllerQuit implements MRJQuitHandler
{
	private Display  d;
	private Shell    s;
	
	
  public MacOSXControllerQuit() {
		super();
	}


public Display getD() {
	return d;
}


public Shell getS() {
	return s;
}


public void setD(Display d) {
	this.d = d;
}


public void setS(Shell s) {
	this.s = s;
}


public void handleQuit() throws IllegalStateException
  {
	s.dispose();
//	d.dispose();
	System.exit(0);
  }

}