package com.poi.dlas;

//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

//import javax.swing.JButton;
import javax.swing.JFileChooser;
//import javax.swing.filechooser.FileFilter;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;

public class FileDialogOld extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int OPENDIAG = 1;
	public static final int SAVEDIAG = 2;
	public static final int CLOSEDIAG = 3;

	private static File fileToSave;
	private static File fileToOpen;
	// private JButton buttonBrowse;

	static Logger logger = Logger.getLogger("file");

	public File DirectoryDefault;

	public FileDialogOld() {
	}

	public File saveFileDialog(File DirectoryDefault) throws InvocationTargetException, InterruptedException {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		try {

			fileToSave = showSaveFileDialog(DirectoryDefault);
			/*
			 * SwingUtilities.invokeAndWait(new Runnable() { File
			 * DirectoryDefault = new File (".");
			 * 
			 * @Override public void run() {
			 * fileToSave=showSaveFileDialog(DirectoryDefault); } });
			 */

			return fileToSave;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public File openFileDialog(File DirectoryDefault) throws InvocationTargetException, InterruptedException {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}

		try {

			fileToOpen = showOpenFileDialog(DirectoryDefault);

			/*
			 * SwingUtilities.invokeAndWait(new Runnable() { File
			 * DirectoryDefault = new File (".");
			 * 
			 * @Override public void run() {
			 * fileToOpen=showOpenFileDialog(DirectoryDefault); } });
			 */
			return fileToOpen;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void launchDialog() { // main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new FileDialogOld();
			}
		});
	}

	private File showSaveFileDialog(File DirectoryDefault) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(DirectoryDefault);
		logger.info("showSaveFileDialog Création fileChooser");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		logger.info("showSaveFileDialog.setFileSelectionMode");
		fileChooser.setAcceptAllFileFilterUsed(true);
		logger.info("showSaveFileDialog.setAcceptAllFileFilterUsed");
		/*
		 * fileChooser.setFileFilter(new FileFilter() {
		 * 
		 * @Override public boolean accept(File file) { return
		 * file.getName().toUpperCase().equals(".XLS"); }
		 * 
		 * @Override public String getDescription() { return ".xls files"; } });
		 */
		fileChooser.setDialogTitle("Specify a file to save");
		logger.info("showSaveFileDialog.setDialogTitle");
		int userSelection = fileChooser.showSaveDialog(this);
		logger.info("showSaveFileDialog.userSelection");
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			fileToSave = fileChooser.getSelectedFile();
		}
		return fileToSave;
	}

	private File showOpenFileDialog(File DirectoryDefault) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(DirectoryDefault);
		logger.info("Création fileChooser");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.setDialogTitle("Specify a file to open");
		logger.info("showOpenFileDialog.setDialogTitle");
		int userSelection = fileChooser.showOpenDialog(this);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			fileToOpen = fileChooser.getSelectedFile();
			return fileToOpen;

		}
		return fileToOpen;
	}
}