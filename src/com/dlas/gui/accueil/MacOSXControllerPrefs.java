package com.dlas.gui.accueil;

import javax.swing.JOptionPane;
import com.apple.mrj.MRJPrefsHandler;

public class MacOSXControllerPrefs implements  MRJPrefsHandler
{

  

  @Override
public void handlePrefs() throws IllegalStateException
  {
    JOptionPane.showMessageDialog(null, 
                                  "prefs", 
                                  "prefs", 
                                  JOptionPane.INFORMATION_MESSAGE);
  }


}