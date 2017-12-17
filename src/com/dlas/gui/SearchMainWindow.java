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
	private Text text;
	
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
		
/*		txtSupplier = new Text(composite, SWT.BORDER);
		txtSupplier.setText("Supplier");
		txtSupplier.setBounds(35, 28, 64, 19);
		toolkit.adapt(txtSupplier, true, true);*/
		
		text = new Text(composite, SWT.BORDER);
		text.setBounds(160, 60, 372, 19);
		toolkit.adapt(text, true, true);
		
		Label lblCompany = new Label(composite, SWT.NONE);
		lblCompany.setBounds(35, 60, 64, 19);
		toolkit.adapt(lblCompany, true, true);
		lblCompany.setText("Company");
		
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
