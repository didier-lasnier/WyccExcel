package Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

   private static final String REGEX = "([$,A-Z]+)([$,0-9]+)";
   private static final String INPUT = "AU5/12*$Q$5";

   public static void main( String args[] ) {
	   
/*      Pattern p = Pattern.compile(REGEX);
      Matcher m = p.matcher(INPUT);   // get a matcher object
      int count = 0;
      String [] bateaux = p.split(INPUT) ;
      for (int i =  0 ; i < bateaux.length ; i++) {  
    	    System.out.println("[" + i +  "] = " + bateaux[i]) ;    
      }*/
	   
	   Pattern p = Pattern.compile("([$A-Z]+)([$0-9]+)") ;  
	   
//	   String s =  "(SI(BV26>(2011/12);2011/12;BV26)*0)+(SI(BV26>(2011/12);2011/12;BV26)*0)+(SI(EA26>(2012/12);2012/12;EA26)*0)+(SI(EA26>(2012/12);2012/12;EA26)*0)+(SI(GF26>(2003/12);2003/12;GF26)*0,501)+(SI(IK26>(2004/12);2004/12;IK26)*0,1253)+(SI(KP26>(2005/12);2005/12;KP26)*0,0619)+(SI(MU26>(2006/12);2006/12;MU26)*0,2108)+(SI(OZ26>(2007/12);2007/12;OZ26)*0,4525)+(SI(RE26>(2008/12);2008/12;RE26)*0,9044)" ;  
      String s = "AX5/12*$Q$5";
	   Matcher m = p.matcher(s) ; 
	   StringBuffer sb =  new StringBuffer() ; 
	    while (m.find()) {
	       System.out.println("groupe = " + m.group()) ;

	       Pattern p1 = Pattern.compile("([0-9]+)") ;  
	       Matcher m1 = p1.matcher(m.group()) ;
	       StringBuffer sb1 =  new StringBuffer() ; 
	       while (m1.find()) {
	    	   m1.appendReplacement(sb1,"%d") ; 
	       }
	       m1.appendTail(sb1) ;
	       String str=sb1.toString();
	       m.appendReplacement(sb,sb1.toString()) ;
	   }
	    m.appendTail(sb) ;
	   String lafor= sb.toString();
	   System.out.println("Formule = " + lafor) ;  

   }
}
