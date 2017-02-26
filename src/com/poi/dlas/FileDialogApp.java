package com.poi.dlas;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import com.poi.actionuser.Actionuser;
import com.poi.actionuser.ReadFileXlsx;

import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;

public class FileDialogApp {
	Display d;

	Shell s;
	
	static Logger logger = Logger.getLogger("wycc");
//	private final FormToolkit formToolkit = new FormToolkit(d.getDefault());
//	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	FileDialogApp() {
		d = new Display();
		s = new Shell(d);
		s.setImage(SWTResourceManager.getImage("./img/yatching.jpg"));
		s.setSize(522, 311);

		s.setText("Wycc Invoice");
		// create the menu system
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
		
		class Open implements SelectionListener {

			public void widgetSelected(SelectionEvent event) {
				widgetOpen();
			}

			public void widgetDefaultSelected(SelectionEvent event) {
			}
			
			public void widgetSelectedBtn(SelectionEvent event) {
				widgetOpen();
			}
			public void widgetOpen(){
				File directory = new File(".");
				String fileCharSep = System.getProperty("file.separator");
				try {
				FileDialog fd = new FileDialog(s, SWT.OPEN);
				fd.setText("Open");
				fd.setFilterPath(directory.getCanonicalPath());
				String[] filterExt = { "*.csv","*.txt" };
				fd.setFilterExtensions(filterExt);
				String selected = fd.open();
				if (selected !=null) {
					Actionuser a = new Actionuser();
					a.lanceLecture(selected);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		class Save implements SelectionListener {
			public void widgetSelected(SelectionEvent event) {
				widgetSave();

			}

			public void widgetDefaultSelected(SelectionEvent event) {
			}
			public void widgetSelectedBtn(SelectionEvent event) {
				widgetSave();
			}

			public void widgetSave(){
				File directory = new File(".");
				String fileCharSep = System.getProperty("file.separator");
				FileDialog fd = new FileDialog(s, SWT.SAVE);
				fd.setText("Save");
				try {
					fd.setFilterPath(directory.getCanonicalPath());
					String[] filterExt = { "*.xlsx" };
					fd.setFilterExtensions(filterExt);
					String selected = fd.open();
					if (selected !=null){
						ReadFileXlsx a = new ReadFileXlsx();
						try {
							a.generexls(selected);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		
		class Read implements SelectionListener {
			public void widgetSelected(SelectionEvent event) {
				widgetRead();
			}

			public void widgetDefaultSelected(SelectionEvent event) {
			}
			
			public void widgetSelectedBtn(Event event) {
				widgetRead();
			}
			public void widgetRead(){
				File directory = new File(".");
				String fileCharSep = System.getProperty("file.separator");
				try {
				FileDialog fd = new FileDialog(s, SWT.OPEN);
				fd.setText("Choose a file");
				fd.setFilterPath(directory.getCanonicalPath());
				String[] filterExt = { "*.xlsx"};
				fd.setFilterExtensions(filterExt);
				String selected = fd.open();
				if (selected !=null) {
					ReadFileXlsx a = new ReadFileXlsx();
					try {
						a.readxls();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		openItem.addSelectionListener(new Open());
		saveItem.addSelectionListener(new Save());
		readItem.addSelectionListener(new Read());
		
		exitItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				MessageBox messageBox = new MessageBox(s, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
				messageBox.setMessage("Do you really want to exit?");
				messageBox.setText("Exiting Application");
				int response = messageBox.open();
				if (response == SWT.YES)
					s.close();
					d.dispose();
					System.exit(0);
			}
		});
		s.setMenuBar(m);
	
		Label lblStartDate = new Label(s, SWT.NONE);
		lblStartDate.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		lblStartDate.setBounds(190, 50, 80, 22);
		lblStartDate.setText("Start date :");
		
		DateTime StartDate = new DateTime(s, SWT.BORDER);
		StartDate.setDay(1);
		StartDate.setMonth(0);
		//StartDate.setYear(2016);
		StartDate.setBounds(308, 50, 150, 22);
		
		Label lblNewLabel = new Label(s, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		lblNewLabel.setBounds(190, 95, 80, 21);
		lblNewLabel.setText("End date :");
		
		DateTime EndDate = new DateTime(s, SWT.BORDER);
		EndDate.setBounds(308, 94, 150, 22);
		EndDate.setDay(31);
		EndDate.setMonth(11);
		Button btnOk = new Button(s, SWT.NONE);
		btnOk.setBounds(392, 224, 120, 35);
		btnOk.setText("Quit");
		btnOk.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
		    	s.close();
		        d.dispose();
		        
		      }
		    });
		
		Label lbl_logo = new Label(s, SWT.NONE);
		lbl_logo.setImage(SWTResourceManager.getImage("./img/newlogo_bleu.jpg"));
		lbl_logo.setBounds(10, 10, 177, 147);
//		formToolkit.adapt(lbl_logo, true, true);
		lbl_logo.setText("logo");
		
		Button btnReadCsv = new Button(s, SWT.BORDER | SWT.FLAT);
		btnReadCsv.setBounds(34, 162, 94, 28);
		btnReadCsv.setText("Read csv..");
		btnReadCsv.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
			        new Open();
			      }
			    });
		Button btnSaveXls = new Button(s, SWT.BORDER | SWT.FLAT);
		btnSaveXls.setBounds(202, 162, 94, 28);
		btnSaveXls.setText("Save xls..");
		btnSaveXls.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
			        new Save();
			      }
			    });
		Button btnReadFormula = new Button(s, SWT.BORDER | SWT.FLAT);
		btnReadFormula.setBounds(351, 162, 94, 28);
		btnReadFormula.setText("Read formula..");
		btnReadFormula.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
			        new Read().widgetSelectedBtn(event);;
			      }
			    });
		
		s.open();

		while (!s.isDisposed()) {
			if (!d.readAndDispatch())
				d.sleep();
		}
		d.dispose();
	}

	public static void main(String[] argv) {
		final String APP_NAME = "Wycc invoice";
		Display.setAppName(APP_NAME);

		new FileDialogApp();
	}
	
	
}
