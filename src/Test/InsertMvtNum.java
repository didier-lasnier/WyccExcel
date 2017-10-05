package Test;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.dlas.dao.Mvt2;
import com.poi.dlas.WyccWorkbook;

public class InsertMvtNum {

	public InsertMvtNum(){
		String sqlstmt ="SELECT COUNT(*) FROM Mvt_Num Where nextmvt = :nextmvt";
		
		Float lvl= 1f;
		
		WyccWorkbook wyccwb = new WyccWorkbook();
		Session lasession=wyccwb.CreateDataSession();
		Query query = lasession.createQuery( sqlstmt);
		query.setParameter("nextmvt", lvl);
		int result = ((Long)query.uniqueResult()).intValue();
		wyccwb.closedataSession(lasession);
	
	}
	
	 public static  void main(String[] arg){
		 
		 new InsertMvtNum();
	}
}
