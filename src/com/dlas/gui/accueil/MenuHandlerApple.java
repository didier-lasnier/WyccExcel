package com.dlas.gui.accueil;

import javax.swing.JOptionPane;
import com.apple.eawt.ApplicationAdapter;
import com.apple.eawt.ApplicationEvent;

/**
 * MacAdapter.java
 * Copyright 2010, Alvin J. Alexander, devdaily.com.
 * 
 * This file is part of the DesktopShield application. This class implements the 
 * Apple/Mac/Java ApplicationAdapter class, specifically the handleQuit
 * method of that class, to help shut down this application properly.
 *
 * The DesktopShield application is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The DesktopShield application is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with the DesktopShield application. If not, see <http://www.gnu.org/licenses/>.
*/
public class MenuHandlerApple extends ApplicationAdapter
{
 /* private DesktopShield handler;
  
  public MyApplicationAdapter(DesktopShield handler)
  {
    this.handler = handler;
  }*/

  @Override
public void handleQuit(ApplicationEvent e)
  {
    System.exit(0);
  }

  @Override
public void handleAbout(ApplicationEvent e)
  {
    // tell the system we're handling this, so it won't display
    // the default system "about" dialog after ours is shown.
    e.setHandled(true);
    JOptionPane.showMessageDialog(null, "Show About dialog here");
  }

  @Override
public void handlePreferences(ApplicationEvent e)
  {
    JOptionPane.showMessageDialog(null, "Show Preferences dialog here");
  }
}