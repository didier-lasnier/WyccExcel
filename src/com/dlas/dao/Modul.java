package com.dlas.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.engine.query.*;
import org.hibernate.query.Query;

@Entity
@Table(name = "MODUL", schema="PUBLIC")
public class Modul {

		@Id
		@Column(name = "MODUL_ID")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long modulid;
		@Column(name = "MODUL_FOURNISSEUR")
		private String modulfournisseur;
		@Column(name = "MODUL_LABEL")
		private String modullabel;
		@Column(name = "MODUL_PRICE")
		private String modulprice;
		@Column(name = "MODUL_SCOPE")
		private String modulscope;
		@Column(name = "FORFAIT_PERCENTAGE")
		private int forfaitpercentage;
		@Column(name = "CALCULMODE")
		private String calculmode;
		@Column(name = "DISPLAYORDER")
		private String dispalyorder;		
		@Column(name = "MODULE_CATEGORY")
		private String modulcategory;	
		
		public Modul(long modulid, String modulfournisseur, String modullabel, String modulprice, String modulscope,
				int forfaitpercentage, String calculmode, String dispalyorder, String modulcategory) {
			super();
			this.modulid = modulid;
			this.modulfournisseur = modulfournisseur;
			this.modullabel = modullabel;
			this.modulprice = modulprice;
			this.modulscope = modulscope;
			this.forfaitpercentage = forfaitpercentage;
			this.calculmode = calculmode;
			this.dispalyorder = dispalyorder;
			this.modulcategory = modulcategory;
		}

		public Modul(long modulid, String modulfournisseur, String modullabel, String modulprice, String modulscope,
				int forfaitpercentage, String calculmode, String dispalyorder) {
			super();
			this.modulid = modulid;
			this.modulfournisseur = modulfournisseur;
			this.modullabel = modullabel;
			this.modulprice = modulprice;
			this.modulscope = modulscope;
			this.forfaitpercentage = forfaitpercentage;
			this.calculmode = calculmode;
			this.dispalyorder = dispalyorder;
		}

		public Modul() {
			super();
			// TODO Auto-generated constructor stub
		}

		/**
		 * @return the modulid
		 */
		public long getModulid() {
			return modulid;
		}

		/**
		 * @return the modulfournisseur
		 */
		public String getModulfournisseur() {
			return modulfournisseur;
		}

		/**
		 * @return the modullabel
		 */
		public String getModullabel() {
			return modullabel;
		}

		/**
		 * @return the modulprice
		 */
		public String getModulprice() {
			return modulprice;
		}

		/**
		 * @return the modulscope
		 */
		public String getModulscope() {
			return modulscope;
		}

		/**
		 * @param modulid the modulid to set
		 */
		public void setModulid(long modulid) {
			this.modulid = modulid;
		}

		/**
		 * @param modulfournisseur1 the modulfournisseur1 to set
		 */
		public void setModulfournisseur(String modulfournisseur) {
			this.modulfournisseur = modulfournisseur;
		}

		/**
		 * @param modullabel the modullabel to set
		 */
		public void setModullabel(String modullabel) {
			this.modullabel = modullabel;
		}

		/**
		 * @param modulprice the modulprice to set
		 */
		public void setModulprice(String modulprice) {
			this.modulprice = modulprice;
		}

		/**
		 * @param modulscope the modulscope to set
		 */
		public void setModulscope(String modulscope) {
			this.modulscope = modulscope;
		}
		
		public Modul getOneModul (String hqlquery,Session session,String fournisseur,String modullabel){
			Query query = session.createQuery("from Modul where modulforunisseur = :fournisseur and modullabel = :modullabel");
			query.setString(":fournisseur", fournisseur);
			query.setString(":modullabel", modullabel);
			query.setMaxResults(1);
			return (Modul) query.uniqueResult();
		}

		/**
		 * @return the forfaitpercentage
		 */
		public int getForfaitpercentage() {
			return forfaitpercentage;
		}

		/**
		 * @return the calculmode
		 */
		public String getCalculmode() {
			return calculmode;
		}

		/**
		 * @return the dispalyorder
		 */
		public String getDispalyorder() {
			return dispalyorder;
		}

		/**
		 * @param forfaitpercentage the forfaitpercentage to set
		 */
		public void setForfaitpercentage(int forfaitpercentage) {
			this.forfaitpercentage = forfaitpercentage;
		}

		/**
		 * @param calculmode the calculmode to set
		 */
		public void setCalculmode(String calculmode) {
			this.calculmode = calculmode;
		}

		/**
		 * @param dispalyorder the dispalyorder to set
		 */
		public void setDispalyorder(String dispalyorder) {
			this.dispalyorder = dispalyorder;
		}

		/**
		 * @return the modulcategory
		 */
		public String getModulcategory() {
			return modulcategory;
		}

		/**
		 * @param modulcategory the modulcategory to set
		 */
		public void setModulcategory(String modulcategory) {
			this.modulcategory = modulcategory;
		}
		
		
}
