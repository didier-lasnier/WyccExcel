package com.dlas.tools;

import java.util.List;

import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.eclipse.core.runtime.IProgressMonitor;
import org.hibernate.Session;

import com.dlas.dao.Modul;
import com.dlas.dao.beneficiaries;
import com.poi.dlas.WyccWorkbook;

public class SetBeneficiaries {
	private WyccWorkbook wb;
	private SXSSFWorkbook newworkbook;
	private IProgressMonitor monitor;
	private  beneficiaries rs;
	private SXSSFSheet spreadsheet;
	private SXSSFRow row;
	private int introw;
	private int nbmodule;
	private  Modul modul;
	private Session lasession;
	private List result;
	private SXSSFCell lastcellule;
	private SXSSFCell firstcellul;
	private String addressfirstcell;
	
	
	public SetBeneficiaries() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public SetBeneficiaries(WyccWorkbook wb, SXSSFWorkbook newworkbook, IProgressMonitor monitor, beneficiaries rs,
			SXSSFSheet spreadsheet, SXSSFRow row, int introw, int nbmodule, Modul modul, Session lasession, List result,
			SXSSFCell lastcellule, SXSSFCell firstcellul, String addressfirstcell) {
		super();
		this.wb = wb;
		this.newworkbook = newworkbook;
		this.monitor = monitor;
		this.rs = rs;
		this.spreadsheet = spreadsheet;
		this.row = row;
		this.introw = introw;
		this.nbmodule = nbmodule;
		this.modul = modul;
		this.lasession = lasession;
		this.result = result;
		this.lastcellule = lastcellule;
		this.firstcellul = firstcellul;
		this.addressfirstcell = addressfirstcell;
	}


	public WyccWorkbook getWb() {
		return wb;
	}
	public void setWb(WyccWorkbook wb) {
		this.wb = wb;
	}
	public SXSSFWorkbook getNewworkbook() {
		return newworkbook;
	}
	public void setNewworkbook(SXSSFWorkbook newworkbook) {
		this.newworkbook = newworkbook;
	}
	public IProgressMonitor getMonitor() {
		return monitor;
	}
	public void setMonitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}
	public beneficiaries getRs() {
		return rs;
	}
	public void setRs(beneficiaries rs) {
		this.rs = rs;
	}
	public SXSSFSheet getSpreadsheet() {
		return spreadsheet;
	}
	public void setSpreadsheet(SXSSFSheet spreadsheet) {
		this.spreadsheet = spreadsheet;
	}
	public SXSSFRow getRow() {
		return row;
	}
	public void setRow(SXSSFRow row) {
		this.row = row;
	}
	public int getIntrow() {
		return introw;
	}
	public void setIntrow(int introw) {
		this.introw = introw;
	}
	public int getNbmodule() {
		return nbmodule;
	}
	public void setNbmodule(int nbmodule) {
		this.nbmodule = nbmodule;
	}
	public Modul getModul() {
		return modul;
	}
	public void setModul(Modul modul) {
		this.modul = modul;
	}
	public Session getLasession() {
		return lasession;
	}
	public void setLasession(Session lasession) {
		this.lasession = lasession;
	}
	public List getResult() {
		return result;
	}
	public void setResult(List result) {
		this.result = result;
	}
	public SXSSFCell getLastcellule() {
		return lastcellule;
	}
	public void setLastcellule(SXSSFCell lastcellule) {
		this.lastcellule = lastcellule;
	}
	public SXSSFCell getFirstcellul() {
		return firstcellul;
	}
	public void setFirstcellul(SXSSFCell firstcellul) {
		this.firstcellul = firstcellul;
	}
	public String getAddressfirstcell() {
		return addressfirstcell;
	}
	public void setAddressfirstcell(String addressfirstcell) {
		this.addressfirstcell = addressfirstcell;
	}

	
}
