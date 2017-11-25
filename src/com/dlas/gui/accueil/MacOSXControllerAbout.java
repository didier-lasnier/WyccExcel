package com.dlas.gui.accueil;

import javax.swing.JOptionPane;
import com.apple.mrj.MRJAboutHandler;

public class MacOSXControllerAbout  implements MRJAboutHandler
{

  @Override
public void handleAbout()
  {
    JOptionPane.showMessageDialog(null, 
                                  "about", 
                                  "about", 
                                  JOptionPane.INFORMATION_MESSAGE);
  }


}