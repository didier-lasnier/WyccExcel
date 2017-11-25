package com.dlas.gui;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.custom.ScrolledComposite;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class SearchMainWindow extends Composite {

	private    static String                  APP_NAME                = "Wycc invoice" ;
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtSupplier;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	
	public static Logger logger = LogManager.getLogger("wycc");
	private Text textcompany;
	private Text textFormula;
	private Text textModul;
	private Text textPolicy;
	private Text textBoat;
	
	public SearchMainWindow(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBounds(-17, -21, 677, 381);
		toolkit.adapt(scrolledComposite);
		toolkit.paintBordersFor(scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Composite composite = new Composite(scrolledComposite, SWT.NONE);
		toolkit.adapt(composite);
		toolkit.paintBordersFor(composite);
		
		
		textcompany = new Text(composite, SWT.BORDER);
		textcompany.setBounds(162, 76, 372, 19);
		toolkit.adapt(textcompany, true, true);
		
		Label lblCompany = new Label(composite, SWT.NONE);
		lblCompany.setBounds(35, 76, 119, 19);
		toolkit.adapt(lblCompany, true, true);
		lblCompany.setText("Company");
		
		Label lblFormula = new Label(composite, SWT.NONE);
		lblFormula.setBounds(35, 104, 119, 15);
		toolkit.adapt(lblFormula, true, true);
		lblFormula.setText("Formula");
		
		textFormula = new Text(composite, SWT.BORDER);
		textFormula.setBounds(162, 101, 307, 21);
		toolkit.adapt(textFormula, true, true);
		
		Label lblmodule = new Label(composite, SWT.NONE);
		lblmodule.setText("Modul");
		lblmodule.setBounds(35, 131, 119, 15);
		toolkit.adapt(lblmodule, true, true);
		
		textModul = new Text(composite, SWT.BORDER);
		textModul.setBounds(162, 128, 307, 21);
		toolkit.adapt(textModul, true, true);
		
		Label lblPolicy = new Label(composite, SWT.NONE);
		lblPolicy.setText("Policy");
		lblPolicy.setBounds(35, 162, 119, 15);
		toolkit.adapt(lblPolicy, true, true);
		
		textPolicy = new Text(composite, SWT.BORDER);
		textPolicy.setBounds(162, 159, 307, 21);
		toolkit.adapt(textPolicy, true, true);
		
		Label lblBoat = new Label(composite, SWT.NONE);
		lblBoat.setText("Boat");
		lblBoat.setBounds(35, 189, 119, 15);
		toolkit.adapt(lblBoat, true, true);
		
		textBoat = new Text(composite, SWT.BORDER);
		textBoat.setBounds(162, 186, 307, 21);
		toolkit.adapt(textBoat, true, true);
		
		Button btnNewsearch = new Button(composite, SWT.NONE);
		btnNewsearch.setBounds(239, 240, 91, 25);
		toolkit.adapt(btnNewsearch, true, true);
		btnNewsearch.setText("New search");
		
		Button vtnsearch = new Button(composite, SWT.NONE);
		vtnsearch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
			}
		});
		vtnsearch.setText("Search");
		vtnsearch.setBounds(367, 240, 91, 25);
		toolkit.adapt(vtnsearch, true, true);
		
		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	
	}
	
	public static void Moduldisplay(Display display) {		
		Display.setAppName(APP_NAME);

		/*
		 *  On détermine le dossier d'execution du jar
		 * 
		 */
		URL url = ModuleListeBoat.class.getProtectionDomain().getCodeSource().getLocation(); //Gets the path
	  	String jarPath = null;
			try {
				jarPath = URLDecoder.decode(url.getFile(), "UTF-8"); //Should fix it to be read correctly by the system
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

	    

     	    Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
			@Override
			public void run() {

				try {
					logger.info("Window open start ");
					//window.open(display);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
}
