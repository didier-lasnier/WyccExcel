package com.dlas.gui.accueil;

import javax.swing.JOptionPane;
import com.apple.mrj.MRJAboutHandler;
import com.apple.mrj.MRJPrefsHandler;
import com.apple.mrj.MRJQuitHandler;

public class MacOSXControllerPrefs implements  MRJPrefsHandler
{

  

  public void handlePrefs() throws IllegalStateException
  {
    JOptionPane.showMessageDialog(null, 
                                  "prefs", 
                                  "prefs", 
                                  JOptionPane.INFORMATION_MESSAGE);
  }


}