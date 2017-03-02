package com.poi.dlas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.wb.swt.SWTResourceManager;


//import com.jcg.rca.main.PlayerConst;
//import com.jcg.rca.main.PlayerViewerSorter;

public class ViewerTab extends Composite {
	private Table CsvTable;

	Display d;
	Shell s;
	
	 /**
	   * Runs the application
	   */
	  public void main() {
		  	Display display = new Display();
		    final Shell shell = new Shell(display);
	   
	  }

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ViewerTab(Composite parent, int style) {
		super(parent, style);
		
		d = new Display();
		s = new Shell(d);
		s.setSize(589, 443);

		s.setText("Wycc Invoice");
		//Setup table
		
	    
		Button btnCancel = new Button(this, SWT.NONE);
		btnCancel.setBounds(420, 422, 94, 28);
		btnCancel.setText("Cancel");
		
		Button btnOk = new Button(this, SWT.NONE);
		btnOk.setBounds(519, 422, 94, 28);
		btnOk.setText("Ok");
		
		DateTime EndDate = new DateTime(this, SWT.BORDER);
		EndDate.setBounds(152, 68, 129, 27);
		
		DateTime StartDate = new DateTime(this, SWT.BORDER);
		StartDate.setBounds(152, 30, 122, 27);
		
		Button btnImportCsvFile = new Button(this, SWT.NONE);
		btnImportCsvFile.setBounds(0, 268, 128, 28);
		btnImportCsvFile.setText("Import Csv file..");
		
		Button btnSaveXlsx = new Button(this, SWT.NONE);
		btnSaveXlsx.setBounds(0, 200, 128, 28);
		btnSaveXlsx.setText("Save xlsx");
		
		Button btnReadFormula = new Button(this, SWT.NONE);
		btnReadFormula.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnReadFormula.setBounds(0, 166, 128, 28);
		btnReadFormula.setText("Read formula");
		
		Label lblEndDate = new Label(this, SWT.NONE);
		lblEndDate.setBounds(0, 74, 146, 14);
		lblEndDate.setText("End date");
		
		Label lblstartDate = new Label(this, SWT.NONE);
		lblstartDate.setBounds(0, 36, 146, 14);
		lblstartDate.setText("Start date");
		
		Button btnReadCsvFile = new Button(this, SWT.NONE);
		btnReadCsvFile.setText("Read Csv file..");
		btnReadCsvFile.setBounds(0, 234, 128, 28);
		
		Label lblLogo = new Label(this, SWT.NONE);
		lblLogo.setImage(SWTResourceManager.getImage("/Volumes/LaCie/ProjetDev/WrkSpaceEclipse/WyccExcel/img/newlogo_bleu.jpg"));
		lblLogo.setBounds(369, 30, 244, 203);
		lblLogo.setText("Logo");
		
		TableViewer CsvViewer = new TableViewer(this, SWT.BORDER | SWT.FULL_SELECTION);
		CsvTable = CsvViewer.getTable();
		CsvTable.setBounds(0, 307, 623, 81);

		 // Add the first name column
	    TableColumn tc = new TableColumn(CsvTable, SWT.LEFT);
	    tc.setText("Company");
//	    tc.addSelectionListener(new SelectionAdapter() {
//	      public void widgetSelected(SelectionEvent event) {
//	        ((PlayerViewerSorter) tv.getSorter())
//	            .doSort(PlayerConst.COLUMN_FIRST_NAME);
//	        tv.refresh();
//	      }
//	    });
	    
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
