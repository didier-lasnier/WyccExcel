package com.poi.dlas;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.poi.actionuser.*;


/* SwingMenuExample.java requires images/middle.gif. */

/*
 * This class exists solely to show you what menus look like.
 * It has no menu-related event handling.
 */

public class MenuWycc {
    JTextArea output;
    JScrollPane scrollPane;
 //   Action readcsv, readxlsx;
    
    // our icons for the actions

    
    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu;//, submenu;
        JMenuItem menuItem;
//        JRadioButtonMenuItem rbMenuItem;
//        JCheckBoxMenuItem cbMenuItem;

        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the first menu.
        menu = new JMenu("Wycc");
        menu.setMnemonic(KeyEvent.VK_L);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);
        
        //a group of JMenuItems
        menuItem = new JMenuItem("Lire un fichier csv...",
                                 KeyEvent.VK_L);
        //menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_L, ActionEvent.META_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menuItem.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e)
        	{
        		Actionuser a= new Actionuser();
                try {
        			a.lanceLecture();
        			//a.lireCSV();
        		} catch (Exception e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
        	}
        });
        menu.add(menuItem);
        
        
//==========================GENERER UN FICHIER EXCEL=================================
        menuItem = new JMenuItem("Génére fichier excel...",
                KeyEvent.VK_E);
		//menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		KeyEvent.VK_E, ActionEvent.META_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
		"This doesn't really do anything");
		menuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e)
					{
							ReadFileXlsx a= new ReadFileXlsx();
						try {
							a.generexls();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
			});
		menu.add(menuItem);

		
	    menuItem = new JMenuItem("Gnére un exemple excel...",
	                KeyEvent.VK_E);
			//menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
			menuItem.setAccelerator(KeyStroke.getKeyStroke(
			KeyEvent.VK_E, ActionEvent.META_MASK));
			menuItem.getAccessibleContext().setAccessibleDescription(
			"This doesn't really do anything");
			menuItem.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e)
						{
								ReadFileXlsx a= new ReadFileXlsx();
							try {
								a.generexlstest();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
				});
			menu.add(menuItem);
		
//==========================LIRE UN FICHIER EXCEL=================================		
		menuItem = new JMenuItem("Lire un fichier Excel...",
                KeyEvent.VK_R);
		//menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		KeyEvent.VK_R, ActionEvent.META_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
		"This doesn't really do anything");
		menuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e)
					{
							ReadFileXlsx a= new ReadFileXlsx();
						try {
							a.readxls();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
			});
		menu.add(menuItem);
        return menuBar;
    }

    public Container createContentPane() {
        //Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);

        //Create a scrolled text area.
        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);

        //Add the text area to the content pane.
        contentPane.add(scrollPane, BorderLayout.CENTER);

        return contentPane;
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = MenuWycc.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("MenuWycc");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        MenuWycc myMenu = new MenuWycc();
        frame.setJMenuBar(myMenu.createMenuBar());
        frame.setContentPane(myMenu.createContentPane());

        //Display the window.
        frame.setSize(450, 260);
        frame.setVisible(true);
    }
    
    

}

