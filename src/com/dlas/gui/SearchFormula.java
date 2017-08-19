package com.dlas.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class SearchFormula extends JFrame {

	private JPanel contentPane;
	private JTextField textSupplier;
	private JTextField textFormula;
	private JTextField textModule;
	private JTextField textBoat;
	private JTextField textPolicy;
	private JTextField textCalculMode;
	
	
	private final Action actionsearch = new SwingActionSearch();
	private final Action actioncancel = new SwingActionCancel();
	
	
	
	
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchFormula frame = new SearchFormula();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public JPanel getContentPane() {
		return contentPane;
	}
	public JTextField getTextSupplier() {
		return textSupplier;
	}
	public JTextField getTextFormula() {
		return textFormula;
	}
	public JTextField getTextModule() {
		return textModule;
	}
	public JTextField getTextBoat() {
		return textBoat;
	}
	public JTextField getTextPolicy() {
		return textPolicy;
	}
	public JTextField getTextCalculMode() {
		return textCalculMode;
	}
	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}
	public void setTextSupplier(JTextField textSupplier) {
		this.textSupplier = textSupplier;
	}
	public void setTextFormula(JTextField textFormula) {
		this.textFormula = textFormula;
	}
	public void setTextModule(JTextField textModule) {
		this.textModule = textModule;
	}
	public void setTextBoat(JTextField textBoat) {
		this.textBoat = textBoat;
	}
	public void setTextPolicy(JTextField textPolicy) {
		this.textPolicy = textPolicy;
	}
	public void setTextCalculMode(JTextField textCalculMode) {
		this.textCalculMode = textCalculMode;
	}
	/**
	 * Create the frame.
	 */
	public SearchFormula() {
		int heigth =20;
		int interline = 30;
		int starttop=22;
		int margin =18;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSupplier = new JLabel("Supplier:");
		lblSupplier.setBounds(margin, starttop+(0*interline), 62, heigth);
		contentPane.add(lblSupplier);
		
		JLabel lblFormula = new JLabel("Formula:");
		lblFormula.setBounds(margin, starttop+(1*interline), 100, heigth);
		contentPane.add(lblFormula);
		
		JLabel lblModule = new JLabel("Module: ");
		lblModule.setBounds(margin, starttop+(2*interline), 100, heigth);
		contentPane.add(lblModule);
		
		JLabel lblBoat = new JLabel("Boat: ");
		lblBoat.setBounds(margin, starttop+(3*interline), 100, heigth);
		contentPane.add(lblBoat);
		
		JLabel lblpolicy = new JLabel("Policy: ");
		lblpolicy.setBounds(margin, starttop+(4*interline), 100, heigth);
		contentPane.add(lblpolicy);
		
		JLabel lblCalculMode = new JLabel("Calcul mode: ");
		lblCalculMode.setBounds(margin, starttop+(5*interline), 100, heigth);
		contentPane.add(lblCalculMode);
		
		textSupplier = new JTextField();
		textSupplier.setBounds(120,  starttop+(0*interline), 300, heigth);
		contentPane.add(textSupplier);
		textSupplier.setColumns(40);
		
		textFormula = new JTextField();
		textFormula.setBounds(120,  starttop+(1*interline), 300, heigth);
		contentPane.add(textFormula);
		textFormula.setColumns(40);
		
		textModule = new JTextField();
		textModule.setBounds(120,  starttop+(2*interline), 300, heigth);
		contentPane.add(textModule);
		textModule.setColumns(40);
		
		textBoat = new JTextField();
		textBoat.setBounds(120,  starttop+(3*interline), 300, heigth);
		contentPane.add(textBoat);
		textBoat.setColumns(40);
		
		textPolicy = new JTextField();
		textPolicy.setBounds(120,  starttop+(4*interline), 300, heigth);
		contentPane.add(textPolicy);
		textPolicy.setColumns(40);
		
		textCalculMode = new JTextField();
		textCalculMode.setBounds(120,  starttop+(5*interline), 300, heigth);
		contentPane.add(textCalculMode);
		textCalculMode.setColumns(40);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setAction(actionsearch);
		btnSearch.setBounds(303, 228, 117, 29);
		contentPane.add(btnSearch);
	
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setAction(actioncancel);
		btnCancel.setBounds(163, 228, 117, 29);
		contentPane.add(btnCancel);
		
		
	}
	private class SwingActionSearch extends AbstractAction {
		public SwingActionSearch() {
			putValue(NAME, "Search");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			// on recupére les valeurs saisie il faut les renvoyées à la class appelante.
			
		}
	}
	private class SwingActionCancel extends AbstractAction {
		public SwingActionCancel() {
			putValue(NAME, "Cancel");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			SearchFormula.this.setVisible(false);
		}
	}
}
