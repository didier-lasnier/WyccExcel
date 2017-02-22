package com.dlas.tools;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.dlas.dao.Mvt;
import com.opencsv.CSVReader;


import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

public class CSVMappedMvt {
	
	public void CSVMappedMvt(){
		
	}
	public void getListDataCSV (String csvFilename) throws FileNotFoundException {
		@SuppressWarnings({"rawtypes", "unchecked"})
		
		 CsvToBean csv = new CsvToBean();
	    
//	    String csvFilename = "data.csv";
	    CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
	    String[] nextline;
	    try {
			while ((nextline = csvReader.readNext())!=null){
			if (nextline !=null){
				System.out.println(Arrays.toString(nextline));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //Set column mapping strategy
//	    List list = csv.parse(setColumMapping(), csvReader);
//	    return list;
	    
	}
	 
    
}
