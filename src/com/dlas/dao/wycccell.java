package com.dlas.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.sql.Timestamp;


@Entity
@Table(name = "SETTINGSCELL", schema="PUBLIC")
//@SequenceGenerator(name="ID", sequenceName = "SEQ_SETTINGSCELL", initialValue=1, allocationSize=20)
public class wycccell {
	 		@Id
	 		@Column(name = "CELL_ID")
//	 		@GeneratedValue(strategy = GenerationType.AUTO)
	 		private long id;
			/**
			 * @return the id
			 */
			public long getId() {
				return id;
			}

			/**
			 * @param id the id to set
			 */
			public void setId(long id) {
				this.id = id;
			}

			/**
			 * @return the valeurcell
			 */
			public String getValeurcell() {
				return valeurcell;
			}

			/**
			 * @param valeurcell the valeurcell to set
			 */
			public void setValeurcell(String valeurcell) {
				this.valeurcell = valeurcell;
			}

			/**
			 * @return the formulecell
			 */
			public String getFormulecell() {
				return formulecell;
			}

			/**
			 * @param formulecell the formulecell to set
			 */
			public void setFormulecell(String formulecell) {
				this.formulecell = formulecell;
			}

			/**
			 * @return the typecell
			 */
			public int getTypecell() {
				return typecell;
			}

			/**
			 * @param typecell the typecell to set
			 */
			public void setTypecell(int typecell) {
				this.typecell = typecell;
			}

			@Column(name = "CELLROW")
			private int cellrow ;
			@Column(name = "CELLCOLUMN")
			private int cellcolumn ;
			@Column(name = "SHEETNUM")
			private int sheetnum ;
			@Column(name = "HALIGNEMENT")
			private int halignement ;
			@Column(name = "VALIGNEMENT")
			private int valignement ;
			@Column(name = "BODERBOTTOM")
			private int borderbottom ;
			@Column(name = "BORDERTOP")
			private int bordertop ;
			@Column(name = "BORDERLEFT")
			private int borterleft ;
			@Column(name = "BORDERRIGHT")
			private int borderright ;
			@Column(name = "DATAFORMAT")
			private int dataformat ;
			@Column(name = "DATAFORMATSTRING")
			private String dataformatstring;
			@Column(name = "BAXKGROUNDCOLOR")
			private int baxkgroundcolor ;
			@Column(name = "FRONTGROUNDCOLOR")
			private int frontgroundcolor ;
			@Column(name = "PATTERN")
			private int pattern ;
			@Column(name = "FONTINDEX")
			private int fontindex ;
			@Column(name = "INDENTION")
			private float indention ;
			@Column(name = "BODERCOLORBOTTEM")
			private int bordercolorbottom ;
			@Column(name = "BORDERCOLORTOP")
			private int bordercolortop ;
			@Column(name = "BORDERCOLORRIGHT")
			private int bordercolorright ;
			@Column(name = "BORDERCOLORIGHT")
			private int bordercolorleft ;
			@Column(name = "VALEURCELL")
			private String valeurcell ;
			@Column(name = "FORMULECELL")
			private String formulecell ;
			@Column(name = "TYPECELL")
			private int typecell ;
			
			
		public wycccell(){
			
		}
		
		public wycccell(int cellrow , int cellcolumn , int sheetnum,
				int halignement , int valignement , int borderbottom ,
				int bordertop , int borterleft , int borderright ,
				int dataformat , String dataformatstring,
				int baxkgroundcolor ,int frontgroundcolor, int pattern , int fontindex ,
				float indention , int bordercolorbottom ,
				int bordercolortop , int bordercolorright , int bordercolorleft,String valeurcell,String formulecell,int typecell ){
//			this.id                =(Long) null;
			this.cellrow           = cellrow ;
			this.cellcolumn        = cellcolumn ;
			this.sheetnum          = sheetnum ;
			this.halignement       = halignement ;
			this.valignement       = valignement ;
			this.borderbottom      = borderbottom ;
			this.bordertop         = bordertop ;
			this.borterleft        = borterleft ;
			this.borderright       = borderright ;
			this.dataformat        = dataformat ;
			this.dataformatstring  = dataformatstring;
			this.baxkgroundcolor   = baxkgroundcolor ;
			this.frontgroundcolor  = frontgroundcolor;
			this.pattern           = pattern ;
			this.fontindex         = fontindex ;
			this.indention         = indention;
			this.bordercolorbottom = bordercolorbottom ;
			this.bordercolortop    = bordercolortop ;
			this.bordercolorright  = bordercolorright ;
			this.bordercolorleft   = bordercolorleft ;
			this.valeurcell        = valeurcell;
			this.formulecell       = formulecell;
			this.typecell          = typecell;
			
		}

		/**
		 * @return the cellrow
		 */
		public int getCellrow() {
			return cellrow;
		}

		/**
		 * @param cellrow the cellrow to set
		 */
		public void setCellrow(int cellrow) {
			this.cellrow = cellrow;
		}

		/**
		 * @return the cellcolumn
		 */
		public int getCellcolumn() {
			return cellcolumn;
		}

		/**
		 * @param cellcolumn the cellcolumn to set
		 */
		public void setCellcolumn(int cellcolumn) {
			this.cellcolumn = cellcolumn;
		}

		/**
		 * @return the sheetnum
		 */
		public int getSheetnum() {
			return sheetnum;
		}

		/**
		 * @param sheetnum the sheetnum to set
		 */
		public void setSheetnum(int sheetnum) {
			this.sheetnum = sheetnum;
		}

		/**
		 * @return the halignement
		 */
		public int getHalignement() {
			return halignement;
		}

		/**
		 * @param halignement the halignement to set
		 */
		public void setHalignement(int halignement) {
			this.halignement = halignement;
		}

		/**
		 * @return the valignement
		 */
		public int getValignement() {
			return valignement;
		}

		/**
		 * @param valignement the valignement to set
		 */
		public void setValignement(int valignement) {
			this.valignement = valignement;
		}

		/**
		 * @return the borderbottom
		 */
		public int getBorderbottom() {
			return borderbottom;
		}

		/**
		 * @param borderbottom the borderbottom to set
		 */
		public void setBorderbottom(int borderbottom) {
			this.borderbottom = borderbottom;
		}

		/**
		 * @return the bordertop
		 */
		public int getBordertop() {
			return bordertop;
		}

		/**
		 * @param bordertop the bordertop to set
		 */
		public void setBordertop(int bordertop) {
			this.bordertop = bordertop;
		}

		/**
		 * @return the borterleft
		 */
		public int getBorterleft() {
			return borterleft;
		}

		/**
		 * @param borterleft the borterleft to set
		 */
		public void setBorterleft(int borterleft) {
			this.borterleft = borterleft;
		}

		/**
		 * @return the borderright
		 */
		public int getBorderright() {
			return borderright;
		}

		/**
		 * @param borderright the borderright to set
		 */
		public void setBorderright(int borderright) {
			this.borderright = borderright;
		}

		/**
		 * @return the dataformat
		 */
		public int getDataformat() {
			return dataformat;
		}

		/**
		 * @param dataformat the dataformat to set
		 */
		public void setDataformat(int dataformat) {
			this.dataformat = dataformat;
		}

		/**
		 * @return the dataformatstring
		 */
		public String getDataformatstring() {
			return dataformatstring;
		}

		/**
		 * @param dataformatstring the dataformatstring to set
		 */
		public void setDataformatstring(String dataformatstring) {
			this.dataformatstring = dataformatstring;
		}

		/**
		 * @return the baxkgroundcolor
		 */
		public int getBaxkgroundcolor() {
			return baxkgroundcolor;
		}

		/**
		 * @param baxkgroundcolor the baxkgroundcolor to set
		 */
		public void setBaxkgroundcolor(int baxkgroundcolor) {
			this.baxkgroundcolor = baxkgroundcolor;
		}
		/**
		 * @return the baxkgroundcolor
		 */
		public int getFrontgroundcolor() {
			return frontgroundcolor;
		}

		/**
		 * @param baxkgroundcolor the baxkgroundcolor to set
		 */
		public void setFrontgroundcolor(int frontgroundcolor) {
			this.frontgroundcolor = frontgroundcolor;
		}

		/**
		 * @return the pattern
		 */
		public int getPattern() {
			return pattern;
		}

		/**
		 * @param pattern the pattern to set
		 */
		public void setPattern(int pattern) {
			this.pattern = pattern;
		}

		/**
		 * @return the fontindex
		 */
		public int getFontindex() {
			return fontindex;
		}

		/**
		 * @param fontindex the fontindex to set
		 */
		public void setFontindex(int fontindex) {
			this.fontindex = fontindex;
		}

		/**
		 * @return the indention
		 */
		public float getIndention() {
			return indention;
		}

		/**
		 * @param indention the indention to set
		 */
		public void setIndention(float indention) {
			this.indention = indention;
		}

		/**
		 * @return the bordercolorbottom
		 */
		public int getBordercolorbottom() {
			return bordercolorbottom;
		}

		/**
		 * @param bordercolorbottom the bordercolorbottom to set
		 */
		public void setBordercolorbottom(int bordercolorbottom) {
			this.bordercolorbottom = bordercolorbottom;
		}

		/**
		 * @return the bordercolortop
		 */
		public int getBordercolortop() {
			return bordercolortop;
		}

		/**
		 * @param bordercolortop the bordercolortop to set
		 */
		public void setBordercolortop(int bordercolortop) {
			this.bordercolortop = bordercolortop;
		}

		/**
		 * @return the bordercolorright
		 */
		public int getBordercolorright() {
			return bordercolorright;
		}

		/**
		 * @param bordercolorright the bordercolorright to set
		 */
		public void setBordercolorright(int bordercolorright) {
			this.bordercolorright = bordercolorright;
		}

		/**
		 * @return the bordercolorleft
		 */
		public int getBordercolorleft() {
			return bordercolorleft;
		}

		/**
		 * @param bordercolorleft the bordercolorleft to set
		 */
		public void setBordercolorleft(int bordercolorleft) {
			this.bordercolorleft = bordercolorleft;
		}

		/**
		 * @return the valeurcell
		 */
		public String getvaleurcell() {
			return valeurcell;
		}

		/**
		 * @param valeurcell the valeurcell to set
		 */
		public void setvaleurcell(String valeurcell) {
			this.valeurcell = valeurcell;
		}		
		/**
		 * @return the formulecell
		 */
		public String getformulecell() {
			return formulecell;
		}

		/**
		 * @param formulecell the formulecell to set
		 */
		public void setformulecell(String formulecell) {
			this.formulecell = formulecell;
		}		
		/**
		 * @return the typecell
		 */
		public int gettypecell() {
			return typecell;
		}

		/**
		 * @param formulecell the formulecell to set
		 */
		public void settypecell(int typecell) {
			this.typecell = typecell;
		}				
}
