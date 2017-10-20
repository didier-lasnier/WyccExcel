package Test;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.apache.logging.log4j.*;

import com.dlas.dao.HsqlText;
import com.dlas.dao.Mvt2;
import com.poi.dlas.WyccWorkbook;

public class InsertMvtNum {
	public Logger  logger = LogManager.getLogger("wycc");
	
	public InsertMvtNum(){
		
		Float lvl= 1f;
		String StartDateStr = "2016-01-31 00:00:00";
		String EndDateStr = "2016-12-31 59:59:59";
		
		logger.info("start run ReadCSVFile");
		WyccWorkbook wyccwb = new WyccWorkbook();
		Session lasession=wyccwb.CreateDataSession();
		Integer numberOfRows = 0;
		
		HsqlText sqlstmt = new HsqlText();
		
		
		Query query = null;
		Query query1 = null;
		query = lasession.createQuery(sqlstmt.isLevelNListMvthier());
		logger.info(sqlstmt.insertLevelNListMvthier(StartDateStr,EndDateStr));
		query1 = lasession.createQuery(sqlstmt.insertLevelNListMvthier(StartDateStr,EndDateStr));

		wyccwb.closedataSession(lasession);
	
	}
	
	 public static  void main(String[] arg){
		 
		 new InsertMvtNum();
	}
}
