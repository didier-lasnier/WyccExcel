package com.poi.dlas;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import com.jcg.rca.main.Snippet007FullSelection.MyModel;
import com.poi.actionuser.Actionuser;
import com.poi.actionuser.ReadFileXlsx;

import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.DateTime;

import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;



public class FileDialogApp {
	Display d;
	Shell s;
	private DateTime InStartDate;
	private DateTime InEndDate;
	
	private DateTime StartDate;
	private DateTime EndDate;
	
	private String filepathtxt;
	private String filepath;
	
	static Logger logger = Logger.getLogger("wycc");
	private Table table;
//	private final FormToolkit formToolkit = new FormToolkit(d.getDefault());
//	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	FileDialogApp() {
		d = new Display();
		s = new Shell(d);
		s.setSize(589, 443);

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
				widgetOpen(StartDate,EndDate);
			}

			public void widgetDefaultSelected(SelectionEvent event) {
			}
			
			public void widgetSelectedBtn(SelectionEvent event) {
				widgetOpen(StartDate,EndDate);
			}
			public void widgetOpen(DateTime StartD, DateTime EndD){
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
					
					a.lanceLecture(selected, StartD, EndD);
					
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
				messageBox.setMessage("Do you really want to exit? ");
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
		
		StartDate = new DateTime(s, SWT.BORDER | SWT.DATE | SWT.DROP_DOWN);
		StartDate.setDay(1);
		StartDate.setMonth(0);
		//StartDate.setYear(2016);
		StartDate.setBounds(308, 50, 150, 22);
		
		Label lblNewLabel = new Label(s, SWT.BORDER | SWT.DATE | SWT.DROP_DOWN);
		lblNewLabel.setFont(SWTResourceManager.getFont("Arial", 14, SWT.NORMAL));
		lblNewLabel.setBounds(190, 95, 80, 21);
		lblNewLabel.setText("End date :");
		
		EndDate = new DateTime(s, SWT.BORDER);
		EndDate.setBounds(308, 94, 150, 22);
		EndDate.setDate(2017, 11, 31);
		Button btnOk = new Button(s, SWT.NONE);
		btnOk.setBounds(459, 376, 120, 35);
		btnOk.setText("Quit");
		btnOk.addListener(SWT.Selection, new Listener() {
			
		      public void handleEvent(Event event) {
		    	s.close();
		        d.dispose();
		        
		      }
		    });
		
		Label lbl_logo = new Label(s, SWT.NONE);
		lbl_logo.setImage(SWTResourceManager.getImage("/Volumes/LaCie/ProjetDev/WrkSpaceEclipse/WyccExcel/img/newlogo_bleu.jpg"));
		lbl_logo.setBounds(7, 0, 158, 129);
//		formToolkit.adapt(lbl_logo, true, true);
		lbl_logo.setText("logo");
		
		Button btnReadCsv = new Button(s, SWT.BORDER | SWT.FLAT);
		btnReadCsv.setBounds(34, 162, 94, 28);
		btnReadCsv.setText("Read csv..");
		btnReadCsv.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
		    	   String str =StartDate.toString();
			        new Open().widgetOpen(StartDate,EndDate);
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
		
		TableViewer tableViewer = new TableViewer(s, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setBounds(22, 223, 538, 81);
		
	    table.setLayoutData(new GridData(GridData.FILL_BOTH));

	    // Add the first name column
	    TableColumn tc = new TableColumn(table, SWT.LEFT);
	    tc.setText("Company");
	    TableViewerColumn viewerColumn1 = new TableViewerColumn(tableViewer, tc);
		viewerColumn1.setLabelProvider(new ColumnLabelProvider());
		viewerColumn1.setEditingSupport(new EditColumns(tableViewer));

	    tc.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(SelectionEvent event) {
	        
	      }
	    });
	    
	
	 // Turn on the header and the lines
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);
	    

		
		
		
		btnReadFormula.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
			        new Read().widgetSelectedBtn(event);
			      }
			    });
		
		s.open();

		while (!s.isDisposed()) {
			if (!d.readAndDispatch())
				d.sleep();
		}
		d.dispose();
	}
	public class MyModel {
		public int counter;

		public MyModel(int counter) {
			this.counter = counter;
		}

		@Override
		public String toString() {
			return "Item " + this.counter;
		}
	}
	private MyModel[] createModel() {
		MyModel[] elements = new MyModel[10];

		for( int i = 0; i < 10; i++ ) {
			elements[i] = new MyModel(i);
		}

		return elements;
	}
	
	private class EditColumns extends EditingSupport {

		public EditColumns(ColumnViewer viewer) {
			super(viewer);
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			return new TextCellEditor((Composite) getViewer().getControl());
		}

		@Override
		protected boolean canEdit(Object element) {
			return true;
		}

		@Override
		protected Object getValue(Object element) {
			return ((MyModel) element).counter + "";
		}

		@Override
		protected void setValue(Object element, Object value) {
			((MyModel) element).counter = Integer.parseInt(value.toString());
			getViewer().update(element, null);
		}

	}
	public static void main(String[] argv) {
		final String APP_NAME = "Wycc invoice";
		Display.setAppName(APP_NAME);

		new FileDialogApp();
	}
}
