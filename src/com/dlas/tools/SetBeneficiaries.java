package com.dlas.tools;

import java.util.List;

import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.eclipse.core.runtime.IProgressMonitor;
import org.hibernate.Session;

import com.dlas.dao.Modul;
import com.dlas.dao.ModulBoat;
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
	private int    compteur;
	private ModulBoat  modulboat;
	
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

	

	public SetBeneficiaries(WyccWorkbook wb, SXSSFWorkbook newworkbook, IProgressMonitor monitor, beneficiaries rs,
			SXSSFSheet spreadsheet, SXSSFRow row, int introw, int nbmodule, Session lasession, List result,
			SXSSFCell lastcellule, SXSSFCell firstcellul, String addressfirstcell, ModulBoat modulboat) {
		super();
		this.wb = wb;
		this.newworkbook = newworkbook;
		this.monitor = monitor;
		this.rs = rs;
		this.spreadsheet = spreadsheet;
		this.row = row;
		this.introw = introw;
		this.nbmodule = nbmodule;
		this.lasession = lasession;
		this.result = result;
		this.lastcellule = lastcellule;
		this.firstcellul = firstcellul;
		this.addressfirstcell = addressfirstcell;
		this.modulboat = modulboat;
	}


	public SetBeneficiaries(WyccWorkbook wb, SXSSFWorkbook newworkbook, IProgressMonitor monitor, beneficiaries rs,
			SXSSFSheet spreadsheet, SXSSFRow row, int introw, int nbmodule, Modul modul, Session lasession, List result,
			SXSSFCell lastcellule, SXSSFCell firstcellul, String addressfirstcell, int compteur) {
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
		this.compteur = compteur;
	}


	public SetBeneficiaries(WyccWorkbook wb, SXSSFWorkbook newworkbook, IProgressMonitor monitor, beneficiaries rs,
			SXSSFSheet spreadsheet, SXSSFRow row, int introw, int nbmodule, Modul modul, Session lasession, List result,
			SXSSFCell lastcellule, SXSSFCell firstcellul, String addressfirstcell, int compteur, ModulBoat modulboat) {
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
		this.compteur = compteur;
		this.modulboat = modulboat;
	}


	public WyccWorkbook getWb() {
		return wb;
	}


	public SXSSFWorkbook getNewworkbook() {
		return newworkbook;
	}


	public IProgressMonitor getMonitor() {
		return monitor;
	}


	public beneficiaries getRs() {
		return rs;
	}


	public SXSSFSheet getSpreadsheet() {
		return spreadsheet;
	}


	public SXSSFRow getRow() {
		return row;
	}


	public int getIntrow() {
		return introw;
	}


	public int getNbmodule() {
		return nbmodule;
	}


	public Modul getModul() {
		return modul;
	}


	public Session getLasession() {
		return lasession;
	}


	public List getResult() {
		return result;
	}


	public SXSSFCell getLastcellule() {
		return lastcellule;
	}


	public SXSSFCell getFirstcellul() {
		return firstcellul;
	}


	public String getAddressfirstcell() {
		return addressfirstcell;
	}


	public int getCompteur() {
		return compteur;
	}


	public ModulBoat getModulboat() {
		return modulboat;
	}


	public void setWb(WyccWorkbook wb) {
		this.wb = wb;
	}


	public void setNewworkbook(SXSSFWorkbook newworkbook) {
		this.newworkbook = newworkbook;
	}


	public void setMonitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}


	public void setRs(beneficiaries rs) {
		this.rs = rs;
	}


	public void setSpreadsheet(SXSSFSheet spreadsheet) {
		this.spreadsheet = spreadsheet;
	}


	public void setRow(SXSSFRow row) {
		this.row = row;
	}


	public void setIntrow(int introw) {
		this.introw = introw;
	}


	public void setNbmodule(int nbmodule) {
		this.nbmodule = nbmodule;
	}


	public void setModul(Modul modul) {
		this.modul = modul;
	}


	public void setLasession(Session lasession) {
		this.lasession = lasession;
	}


	public void setResult(List result) {
		this.result = result;
	}


	public void setLastcellule(SXSSFCell lastcellule) {
		this.lastcellule = lastcellule;
	}


	public void setFirstcellul(SXSSFCell firstcellul) {
		this.firstcellul = firstcellul;
	}


	public void setAddressfirstcell(String addressfirstcell) {
		this.addressfirstcell = addressfirstcell;
	}


	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}


	public void setModulboat(ModulBoat modulboat) {
		this.modulboat = modulboat;
	}



}
