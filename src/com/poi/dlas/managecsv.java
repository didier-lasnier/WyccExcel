package com.poi.dlas;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
//import java.util.Arrays;
import java.util.ArrayList;

import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class managecsv {

	public managecsv() {
	}

	public List<String[]> getRowsFromFile(File filetoread) {
		CSVReader csvReader = null;

		try {
			/**
			 * Reading the CSV File Delimiter is comma Start reading from line 1
			 */
			csvReader = new CSVReader(new FileReader(filetoread.getAbsolutePath()), ';', '"', 5);
			// employeeDetails stores the values current line
			String[] row = null;
			List<String[]> rows = new ArrayList<String[]>();
			while ((row = csvReader.readNext()) != null) {
				// Printing to the console
				rows.add(row);

			}

			return rows;
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			try {
				// closing the reader
				csvReader.close();
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}
		return null;
	}

	public void setRowToFile(List<String[]> rows, File filetowrite) {
		CSVWriter csvWriter = null;
		try {
			// Create CSVWriter for writing to Employee.csv
			csvWriter = new CSVWriter(new FileWriter(filetowrite.getAbsolutePath(), true));
			// row1
			for (String[] row : rows) {
				csvWriter.writeNext(row);
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			try {
				// closing the writer
				csvWriter.close();
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}
	}

}
