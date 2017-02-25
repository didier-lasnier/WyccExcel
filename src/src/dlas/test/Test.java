package src.dlas.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

  public static void main (String arg[]){
	  String retour ="";
	  retour =getNewNumColonne("AS5-AU5","[$,A-Z]*",26,1*57);
/*	  retour =getNewNumColonne("AA5*(1+AB5)","[$,A-Z]*",26,2*57);
	  retour =getNewNumColonne("AE5/12*$Q$5","[$,A-Z]*",26,2*57);
	  retour =getNewNumColonne("EI5*$O$5*12","[$,A-Z]*",26,2*57);
	  retour =getNewNumColonne("BE14*BC14","[$,A-Z]*",26,2*57);*/
		
	}

	public static String getString(String str){
		int therow = 8;
		str=String.format(str,therow,therow,therow,therow) ;
		return str;
	}
	public static String getNewNumColonne(String formule,String pattern, int colStart,int colOffset ){
		
		//List<String> allMatches = new ArrayList<String>();
		 Matcher m = Pattern.compile(pattern).matcher(formule);

		 String str=null ;
		 while (m.find()) {
			 if (!m.group().startsWith("$") )
			 {
				 if (m.group().length()  !=0){
					 int colInt=0;
					 int compteur =1;
					 int ascii=0;
					 while (compteur<=m.group().length() ){
						
						 if (compteur < m.group().length()){
							 ascii =(int) m.group().substring(compteur-1, compteur).charAt(0)-64;
							 colInt=colInt+(colStart*ascii);				
						 }	
						 else {
							  ascii = (int) m.group().substring(compteur-1, compteur).charAt(0);
							  colInt=colInt+( ascii - 64) ;
						 }
						 compteur++;	
					 }

					 String replacement="";
					 int colonenumber=0;
					 
/*					 if (colInt >=26){
						 colonenumber=64+((colOffset+colInt)/26);
						
					 } else {
						 colonenumber=64+(colOffset+colInt); 
					 }*/
					
					 colonenumber=64+((colOffset+colInt)/26);	
					 if ((colOffset+colInt) > 26) {
						  if ((colOffset+colInt)%26!=0){ 
							  replacement=Character.toString((char) colonenumber );
						  } else {
							  replacement=Character.toString((char) (colonenumber-1) );
						  }
					 }
					  //String replacement=Character.toString((char) (64+((colOffset+colInt)/26)))
					 if ((colOffset+colInt)%26 == 0) {
						 replacement=replacement+"Z"; 
					 }
					 else {
						 replacement=replacement+Character.toString((char) (64+((colOffset+colInt)%26)));
					 
					 }
					 
					 formule=formule.replace( m.group(), replacement);
				 }
			 }
		 }
		 
		return formule;
		
	}

}
