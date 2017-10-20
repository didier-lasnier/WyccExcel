package com.dlas.gui.accueil;

import javax.swing.JOptionPane;
import com.apple.mrj.MRJAboutHandler;
import com.apple.mrj.MRJPrefsHandler;
import com.apple.mrj.MRJQuitHandler;

public class MacOSXControllerAbout  implements MRJAboutHandler
{

  public void handleAbout()
  {
    JOptionPane.showMessageDialog(null, 
                                  "about", 
                                  "about", 
                                  JOptionPane.INFORMATION_MESSAGE);
  }


}