package com.dlas.gui;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import com.dlas.gui.ModuleListeBoat.ProgressBarDb;
import com.dlas.gui.ModuleListeBoat.Searchinfo;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

public class Search extends Shell {
	private Search              window;
	private Text                txtCompany;
	private Text                txtForumula;
	private Text                txtModule;
	private Text                txtPolicyNumber;
	private Text                txtBoat;

	private static String       APP_NAME                = "Wycc invoice"      ;
	private static Shell        shellMSearch                                  ; 
	private Display             display                                       ;
	private Text                text                                          ;
	/**
	 * Launch the application.
	 * @param args
	 */
	
	public int open (Display display) {
		
	//	createContents();
		Display.setAppName(APP_NAME);
		shellMSearch.open();
		shellMSearch.layout();
		shellMSearch.update();
		while (!shellMSearch.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		return 0;

	}

	public  Search(Display display,Searchinfo theinfo) {
		super(display, SWT.SHELL_TRIM);
		addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent arg0) {
			}
		});
		shellMSearch=this;
		createContents();
	}
	/**
	 * Create the shell.
	 * @param display
	 */
	
	
	
	public void SearchDisplay(Display display) {
		
 	    Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
		@Override
		public void run() {

			try {
				//logger.info("Window open start ");
				window.open(display);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	}

	public Text getTxtCompany() {
		return txtCompany;
	}

	public Text getTxtForumula() {
		return txtForumula;
	}

	public Text getTxtModule() {
		return txtModule;
	}

	public Text getTxtPolicyNumber() {
		return txtPolicyNumber;
	}

	public Text getTxtBoat() {
		return txtBoat;
	}

	public void setTxtCompany(Text txtCompany) {
		this.txtCompany = txtCompany;
	}

	public void setTxtForumula(Text txtForumula) {
		this.txtForumula = txtForumula;
	}

	public void setTxtModule(Text txtModule) {
		this.txtModule = txtModule;
	}

	public void setTxtPolicyNumber(Text txtPolicyNumber) {
		this.txtPolicyNumber = txtPolicyNumber;
	}

	public void setTxtBoat(Text txtBoat) {
		this.txtBoat = txtBoat;
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(616, 462);
		setLayout(null);
		
		Label lblCompany = new Label(this, SWT.NONE);
		lblCompany.setBounds(15, 3, 66, 18);
		lblCompany.setFont(SWTResourceManager.getFont("Arial", 12, SWT.NORMAL));
		lblCompany.setBounds(10, 44, 106, 25);
		lblCompany.setText("Company : ");
		
		Label lblFormula = new Label(this, SWT.NONE);
		lblFormula.setBounds(15, 24, 59, 18);
		lblFormula.setText("Formula : ");
		lblFormula.setFont(SWTResourceManager.getFont("Arial", 12, SWT.NORMAL));
		lblFormula.setBounds(10, 113, 106, 25);
		
		Label lblModule = new Label(this, SWT.NONE);
		lblModule.setBounds(15, 45, 54, 18);
		lblModule.setText("Module : ");
		lblModule.setFont(SWTResourceManager.getFont("Arial", 12, SWT.NORMAL));
		lblModule.setBounds(10, 182, 106, 25);
		
		Label lblPolicyNumber = new Label(this, SWT.NONE);
		lblPolicyNumber.setBounds(15, 66, 91, 18);
		lblPolicyNumber.setText("Policy number : ");
		lblPolicyNumber.setFont(SWTResourceManager.getFont("Arial", 12, SWT.NORMAL));
		lblPolicyNumber.setBounds(10, 251, 106, 25);
		
		Label lblBoat = new Label(this, SWT.NONE);
		lblBoat.setBounds(15, 87, 39, 18);
		lblBoat.setText("Boat : ");
		lblBoat.setFont(SWTResourceManager.getFont("Arial", 12, SWT.NORMAL));
		lblBoat.setBounds(10, 320, 106, 25);
		
		Button btnCancel = new Button(this, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shellMSearch.getShell().setVisible(false);
			}
		});
		btnCancel.setBounds(15, 108, 68, 28);
		btnCancel.setBounds(10, 389, 170, 25);
		btnCancel.setText("Cancel");
		
		Button btnSearch = new Button(this, SWT.NONE);
		btnSearch.setBounds(15, 139, 69, 28);
		btnSearch.setText("Search");
		btnSearch.setBounds(336, 388, 228, 25);
		
		txtCompany = new Text(this, SWT.BORDER);
		txtCompany.setBounds(15, 170, 64, 23);
		txtCompany.setFont(SWTResourceManager.getFont("Arial", 12, SWT.NORMAL));
		txtCompany.setBounds(241, 44, 323, 25);
		
		txtForumula = new Text(this, SWT.BORDER);
		txtForumula.setBounds(15, 196, 64, 19);
		txtForumula.setBounds(241, 113, 323, 25);
		
		txtModule = new Text(this, SWT.BORDER);
		txtModule.setBounds(15, 218, 64, 19);
		txtModule.setBounds(241, 182, 323, 25);
		
		txtPolicyNumber = new Text(this, SWT.BORDER);
		txtPolicyNumber.setBounds(15, 240, 64, 19);
		txtPolicyNumber.setBounds(241, 251, 323, 25);
		
		txtBoat = new Text(this, SWT.BORDER);
		txtBoat.setBounds(15, 262, 64, 19);
		txtBoat.setBounds(241, 320, 323, 25);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	
	public void setDefaultValues(Display display) throws InvocationTargetException, InterruptedException {
		window=this;
		this.display=display;

		
	}
}
