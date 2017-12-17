package com.dlas.gui;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.CLabel;

public class Search extends Dialog {

	protected Object      result;
	protected Shell       shell;
	private   Text        txtcompany;
	private   Text        txtformule ;
	private   Text        txtmodul;
	private   Text        txtpolicy;
	private   Text        txtboat;
	
	
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	
	public Search(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
		open();
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(450, 300);
		shell.setText(getText());
		
		Label lblcompany = new Label(shell, SWT.NONE);
		lblcompany.setForeground(SWTResourceManager.getColor(0, 0, 0));
		lblcompany.setFont(SWTResourceManager.getFont("Helvetica Neue", 12, SWT.NORMAL));
		lblcompany.setBounds(10, 70, 163, 19);
		lblcompany.setText("Insurance Company : ");
		
		txtcompany = new Text(shell, SWT.BORDER);
		txtcompany.setFont(SWTResourceManager.getFont("Helvetica Neue", 12, SWT.NORMAL));
		txtcompany.setBounds(164, 70, 246, 19);

		Label lblformule = new Label(shell, SWT.NONE);
		lblformule.setForeground(SWTResourceManager.getColor(0, 0, 0));
		lblformule.setFont(SWTResourceManager.getFont("Helvetica Neue", 12, SWT.NORMAL));
		lblformule.setBounds(10, 100, 163, 19);
		lblformule.setText("Formula : ");
		
		txtformule = new Text(shell, SWT.BORDER);
		txtformule.setFont(SWTResourceManager.getFont("Helvetica Neue", 12, SWT.NORMAL));
		txtformule.setBounds(164, 100, 246, 19);
		
		Label lblmodul = new Label(shell, SWT.NONE);
		lblmodul.setForeground(SWTResourceManager.getColor(0, 0, 0));
		lblmodul.setFont(SWTResourceManager.getFont("Helvetica Neue", 12, SWT.NORMAL));
		lblmodul.setBounds(10, 130, 163, 19);
		lblmodul.setText("Modul : ");
		
		txtmodul = new Text(shell, SWT.BORDER);
		txtmodul.setFont(SWTResourceManager.getFont("Helvetica Neue", 12, SWT.NORMAL));
		txtmodul.setBounds(164, 130, 246, 19);
		
		Label lblpolicy = new Label(shell, SWT.NONE);
		lblpolicy.setForeground(SWTResourceManager.getColor(0, 0, 0));
		lblpolicy.setFont(SWTResourceManager.getFont("Helvetica Neue", 12, SWT.NORMAL));
		lblpolicy.setBounds(10, 160, 163, 19);
		lblpolicy.setText("policy : ");
		
		txtpolicy = new Text(shell, SWT.BORDER);
		txtpolicy.setFont(SWTResourceManager.getFont("Helvetica Neue", 12, SWT.NORMAL));
		txtpolicy.setBounds(164, 160, 246, 19);
		
		Label lblboat = new Label(shell, SWT.NONE);
		lblboat.setForeground(SWTResourceManager.getColor(0, 0, 0));
		lblboat.setFont(SWTResourceManager.getFont("Helvetica Neue", 12, SWT.NORMAL));
		lblboat.setBounds(10, 190, 163, 19);
		lblboat.setText("Boat : ");
		
		txtboat = new Text(shell, SWT.BORDER);
		txtboat.setFont(SWTResourceManager.getFont("Helvetica Neue", 12, SWT.NORMAL));
		txtboat.setBounds(164, 190, 246, 19);
		
		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.setBounds(200, 240, 94, 28);
		btnCancel.setText("Cancel");
		
		Button btnSearch = new Button(shell, SWT.BORDER);
		btnSearch.setSelection(true);
		btnSearch.setBounds(314, 240, 94, 28);
		btnSearch.setText("Search");
		
		CLabel lblNewLabel = new CLabel(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Diwan Kufi", 24, SWT.NORMAL));
		lblNewLabel.setBounds(10, 10, 350, 60);
		lblNewLabel.setText("Search...");
		
		
	}
}
