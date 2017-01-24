package com.dlas.dao;

public class hsqltext {
	public hsqltext(){
		
	}
	
	public String insertmvtnum ()
	{
		String sqlstmt =null;

		sqlstmt = "INSERT INTO PUBLIC.MVT_NUM (STRUCTURE_NAME, CERTIFICATE, CERTIFICATE_START, CERTIFICATE_RENEWAL, CERTIFICATE_CANCELLATION, AMENDMENT_START, AMENDMENT_END, WYCC_ID,";
		sqlstmt = sqlstmt+ " CLAIMS_MANAGER_ID, GENDER, NAME, FIRST_NAME, DATE_OF_BIRTH, EMAIL, POSITION_TYPE, POSITIONCREW, MONTHLY_SALARY, SALARY_CURRENCY, PERIOD, DAYS, MONTHS, ";
		sqlstmt = sqlstmt+ " FAMILY_COVERED, RETIREMENT_PLAN, START_MOVEMENT, END_MOVEMENT, EMPLOYER, CHILDREN, COUNTRY, NATIONALITY, COMPANY1, FORMULA1, POLICY_NUMBER1, CURRENCY1, ";
		sqlstmt = sqlstmt+ " EXCESS1, DURATION1, TOTAL_AMOUNT_INSURED1, CIE_HT_BASIS1, COMPANY2, FORMULA2, POLICY_NUMBER2, CURRENCY2, EXCESS2, DURATION2, TOTAL_AMOUNT_INSURED2,";
		sqlstmt = sqlstmt+ " CIE_HT_BASIS2, COMPANY3, FORMULA3, POLICY_NUMBER3, CURRENCY3, EXCESS3, DURATION3, TOTAL_AMOUNT_INSURED3, CIE_HT_BASIS3, COMPANY4, FORMULA4, POLICY_NUMBER4,";
		sqlstmt = sqlstmt+ " CURRENCY4, EXCESS4, DURATION4, TOTAL_AMOUNT_INSURED4, CIE_HT_BASIS4, COMPANY5, FORMULA5, POLICY_NUMBER5, CURRENCY5, EXCESS5, DURATION5, TOTAL_AMOUNT_INSURED5,";
		sqlstmt = sqlstmt+ " CIE_HT_BASIS5, COMPANY6, FORMULA, POLICY_NUMBER6, CURRENCY6, EXCESS6, DURATION6, TOTAL_AMOUNT_INSURED6, CIE_HT_BASIS6, COMPANY7, FORMULA7, POLICY_NUMBER7,";
		sqlstmt = sqlstmt+ " CURRENCY7, EXCESS67, DURATION7, TOTAL_AMOUNT_INSURED7, CIE_HT_BASIS7, COMPANY8, FORMULA8, POLICY_NUMBER8, CURRENCY8, EXCESS8, DURATION8, TOTAL_AMOUNT_INSURED8,";
		sqlstmt = sqlstmt+ "CIE_HT_BASIS8, NBREMVT,RANKMVT, NEXTMVT,DATEOFNEXTMVT)";
		sqlstmt = sqlstmt+"SELECT STRUCTURE_NAME,CERTIFICATE,CERTIFICATE_START,CERTIFICATE_RENEWAL,CERTIFICATE_CANCELLATION,AMENDMENT_START,AMENDMENT_END,";
		sqlstmt = sqlstmt+" WYCC_ID,CLAIMS_MANAGER_ID,GENDER,NAME,FIRST_NAME,DATE_OF_BIRTH,EMAIL,POSITION_TYPE,POSITIONCREW,";
		sqlstmt = sqlstmt+" CAST( CASE WHEN REPLACE(MONTHLY_SALARY,',','.')!='' then REPLACE(MONTHLY_SALARY,',','.') else  '0' end  as Number),";
		sqlstmt = sqlstmt+" SALARY_CURRENCY,PERIOD ,cast(DAYS as number),cast(MONTHS as number),FAMILY_COVERED,RETIREMENT_PLAN,";
		sqlstmt = sqlstmt+" PARSEDATETIME(START_MOVEMENT,'dd/MM/yyyy') START_MOVEMENT,";
		sqlstmt = sqlstmt+" PARSEDATETIME(END_MOVEMENT,'dd/MM/yyyy') END_MOVEMENT,";
		sqlstmt = sqlstmt+" EMPLOYER,CHILDREN,COUNTRY,NATIONALITY,COMPANY1,FORMULA1,POLICY_NUMBER1,CURRENCY1,EXCESS1,DURATION1,";
		sqlstmt = sqlstmt+" CAST( CASE WHEN REPLACE(TOTAL_AMOUNT_INSURED1,',','.')!='' then REPLACE(TOTAL_AMOUNT_INSURED1,',','.')  else  '0' end  as Number) ,";
		sqlstmt = sqlstmt+" CAST( CASE WHEN REPLACE(REPLACE(CIE_HT_BASIS1,'%','') ,',','.') !=''  then REPLACE(REPLACE(CIE_HT_BASIS1,'%','') ,',','.') else  '0' end  as Number),";
		sqlstmt = sqlstmt+" COMPANY2,FORMULA2,POLICY_NUMBER2,CURRENCY2,EXCESS2,DURATION2,";
		sqlstmt = sqlstmt+" CAST( CASE WHEN REPLACE(TOTAL_AMOUNT_INSURED2,',','.')!=''  then REPLACE(TOTAL_AMOUNT_INSURED2,',','.') else  '0' end  as Number),";
		sqlstmt = sqlstmt+" CAST( CASE WHEN REPLACE(REPLACE(CIE_HT_BASIS2,'%',''),',','.') !='' then REPLACE(REPLACE(CIE_HT_BASIS2,'%',''),',','.') else  '0' end  as Number),";
		sqlstmt = sqlstmt+" COMPANY3,FORMULA3,POLICY_NUMBER3,CURRENCY3,EXCESS3,DURATION3,";
		sqlstmt = sqlstmt+" CAST( CASE WHEN REPLACE(TOTAL_AMOUNT_INSURED3,',','.')!='' then REPLACE(TOTAL_AMOUNT_INSURED3,',','.') else  '0' end  as Number),";
		sqlstmt = sqlstmt+" CAST( CASE WHEN REPLACE(REPLACE(CIE_HT_BASIS3,'%',''),',','.') !='' then REPLACE(REPLACE(CIE_HT_BASIS3,'%',''),',','.') else  '0' end  as Number),";
		sqlstmt = sqlstmt+" COMPANY4,FORMULA4,POLICY_NUMBER4,CURRENCY4,EXCESS4,DURATION4,";
		sqlstmt = sqlstmt+" CAST( CASE WHEN REPLACE(TOTAL_AMOUNT_INSURED4,',','.') !='' then REPLACE(TOTAL_AMOUNT_INSURED4,',','.') else  '0' end  as Number),";
		sqlstmt = sqlstmt+" CAST( CASE WHEN REPLACE(REPLACE(CIE_HT_BASIS4,'%',''),',','.') !='' then REPLACE(REPLACE(CIE_HT_BASIS4,'%',''),',','.') else  '0' end  as Number),";
		sqlstmt = sqlstmt+" COMPANY5, FORMULA5, POLICY_NUMBER5, CURRENCY5, EXCESS5, DURATION5,";
		sqlstmt = sqlstmt+" CAST( CASE WHEN REPLACE(TOTAL_AMOUNT_INSURED5,',','.') !='' then REPLACE(TOTAL_AMOUNT_INSURED5,',','.') else  '0' end  as Number),";
		sqlstmt = sqlstmt+" CAST( CASE WHEN REPLACE(REPLACE(CIE_HT_BASIS5,'%',''),',','.') !='' then REPLACE(REPLACE(CIE_HT_BASIS5,'%',''),',','.') else  '0' end  as Number),";
		sqlstmt = sqlstmt+" COMPANY6, FORMULA, POLICY_NUMBER6, CURRENCY6, EXCESS6, DURATION6,";
		sqlstmt = sqlstmt+" CAST( CASE WHEN REPLACE(TOTAL_AMOUNT_INSURED6,',','.') !='' then REPLACE(TOTAL_AMOUNT_INSURED6,',','.') else  '0' end  as Number),";
		sqlstmt = sqlstmt+" CAST( CASE WHEN REPLACE(REPLACE(CIE_HT_BASIS6,'%',''),',','.') !='' then REPLACE(REPLACE(CIE_HT_BASIS6,'%',''),',','.') else  '0' end  as Number),";
		sqlstmt = sqlstmt+" COMPANY7, FORMULA7, POLICY_NUMBER7, CURRENCY7, EXCESS67, DURATION7,";
		sqlstmt = sqlstmt+" CAST( CASE WHEN REPLACE(TOTAL_AMOUNT_INSURED7,',','.')  !='' then REPLACE(TOTAL_AMOUNT_INSURED7,',','.') else  '0' end  as Number),";
		sqlstmt = sqlstmt+" CAST( CASE WHEN REPLACE(REPLACE(CIE_HT_BASIS7,'%',''),',','.') !='' then REPLACE(REPLACE(CIE_HT_BASIS7,'%',''),',','.') else  '0' end  as Number),";
		sqlstmt = sqlstmt+" COMPANY8, FORMULA8, POLICY_NUMBER8, CURRENCY8, EXCESS8, DURATION8,";
		sqlstmt = sqlstmt+" CAST( CASE WHEN REPLACE(TOTAL_AMOUNT_INSURED8,',','.') !='' then REPLACE(TOTAL_AMOUNT_INSURED8,',','.') else  '0' end  as Number),";
		sqlstmt = sqlstmt+" CAST( CASE WHEN REPLACE(REPLACE(CIE_HT_BASIS8,'%',''),',','.') !='' then REPLACE(REPLACE(CIE_HT_BASIS8,'%',''),',','.') else  '0' end  as Number),";
		sqlstmt = sqlstmt+" ( SELECT COUNT(*) FROM mvt yt2 WHERE yt2.wycc_id = yt1.wycc_id ), ";
		sqlstmt = sqlstmt+" ( SELECT COUNT(*) FROM mvt yt2 WHERE yt2.wycc_id = yt1.wycc_id AND PARSEDATETIME(yt2.start_movement,'dd/MM/yyyy') < DATEADD( 'DAY', 1,  PARSEDATETIME(yt1.end_movement,'dd/MM/yyyy') ) ),";
		sqlstmt = sqlstmt+" ( SELECT COUNT(*) FROM mvt yt2 WHERE yt2.wycc_id = yt1.wycc_id AND PARSEDATETIME(yt2.start_movement,'dd/MM/yyyy') = DATEADD( 'DAY', 1, PARSEDATETIME(yt1.end_movement,'dd/MM/yyyy') ) ), ";
		sqlstmt = sqlstmt+" ( SELECT MIN( PARSEDATETIME( yt2.start_movement, 'dd/MM/yyyy' ) ) FROM mvt yt2 WHERE yt2.wycc_id = yt1.wycc_id AND PARSEDATETIME(yt2.start_movement,'dd/MM/yyyy') > PARSEDATETIME(yt1.end_movement,'dd/MM/yyyy') )";
		sqlstmt = sqlstmt+" FROM PUBLIC.MVT YT1";
		return 	sqlstmt;
	}
	
	public String createTableMvt (){
		String sqlstmt =null;

		sqlstmt = "CREATE TABLE PUBLIC.MVT (";
		sqlstmt = sqlstmt+"STRUCTURE_NAME VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"CERTIFICATE VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"CERTIFICATE_START VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"CERTIFICATE_RENEWAL VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"CERTIFICATE_CANCELLATION VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"AMENDMENT_START VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"AMENDMENT_END VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"WYCC_ID VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"CLAIMS_MANAGER_ID VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"GENDER VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"NAME VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"FIRST_NAME VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"DATE_OF_BIRTH VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"EMAIL VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"POSITION_TYPE VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"POSITIONCREW VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"MONTHLY_SALARY VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"SALARY_CURRENCY VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"PERIOD VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"DAYS VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"MONTHS VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"FAMILY_COVERED VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"RETIREMENT_PLAN VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"START_MOVEMENT VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"END_MOVEMENT VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"EMPLOYER VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"CHILDREN VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"COUNTRY VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"NATIONALITY VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"COMPANY1 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"FORMULA1 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"POLICY_NUMBER1 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"CURRENCY1 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"EXCESS1 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"DURATION1 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"TOTAL_AMOUNT_INSURED1 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"CIE_HT_BASIS1 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"COMPANY2 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"FORMULA2 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"POLICY_NUMBER2 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"CURRENCY2 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"EXCESS2 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"DURATION2 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"TOTAL_AMOUNT_INSURED2 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"CIE_HT_BASIS2 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"COMPANY3 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"FORMULA3 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"POLICY_NUMBER3 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"CURRENCY3 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"EXCESS3 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"DURATION3 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"TOTAL_AMOUNT_INSURED3 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"CIE_HT_BASIS3 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"COMPANY4 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"FORMULA4 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"POLICY_NUMBER4 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"CURRENCY4 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"EXCESS4 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"DURATION4 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"TOTAL_AMOUNT_INSURED4 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"CIE_HT_BASIS4 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"COMPANY5 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"FORMULA5 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"POLICY_NUMBER5 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"CURRENCY5 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"EXCESS5 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"DURATION5 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"TOTAL_AMOUNT_INSURED5 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"CIE_HT_BASIS5 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"COMPANY6 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"FORMULA VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"POLICY_NUMBER6 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"CURRENCY6 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"EXCESS6 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"DURATION6 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"TOTAL_AMOUNT_INSURED6 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"CIE_HT_BASIS6 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"COMPANY7 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"FORMULA7 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"POLICY_NUMBER7 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"CURRENCY7 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"EXCESS67 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"DURATION7 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"TOTAL_AMOUNT_INSURED7 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"CIE_HT_BASIS7 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"COMPANY8 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"FORMULA8 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"POLICY_NUMBER8 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"CURRENCY8 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"EXCESS8 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"DURATION8 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"TOTAL_AMOUNT_INSURED8 VARCHAR(2147483647),";
		sqlstmt = sqlstmt+"CIE_HT_BASIS8 VARCHAR(2147483647)";
		sqlstmt = sqlstmt+")";
		return sqlstmt;
		}
	
	public String createTableMvtNum (){
		String sqlstmt =null;
		sqlstmt = "CREATE TABLE PUBLIC.MVT_NUM (";
				sqlstmt = sqlstmt+" STRUCTURE_NAME VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" CERTIFICATE VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" CERTIFICATE_START VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" CERTIFICATE_RENEWAL VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" CERTIFICATE_CANCELLATION VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" AMENDMENT_START VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" AMENDMENT_END VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" WYCC_ID VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" CLAIMS_MANAGER_ID VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" GENDER VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" NAME VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" FIRST_NAME VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" DATE_OF_BIRTH VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" EMAIL VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" POSITION_TYPE VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" POSITIONCREW VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" MONTHLY_SALARY DECIMAL(65535,32767),";
				sqlstmt = sqlstmt+" SALARY_CURRENCY VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" PERIOD VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" DAYS DECIMAL(65535,32767),";
				sqlstmt = sqlstmt+" MONTHS DECIMAL(65535,32767),";
				sqlstmt = sqlstmt+" FAMILY_COVERED VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" RETIREMENT_PLAN VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" START_MOVEMENT DATE,";
				sqlstmt = sqlstmt+" END_MOVEMENT DATE,";
				sqlstmt = sqlstmt+" EMPLOYER VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" CHILDREN VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" COUNTRY VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" NATIONALITY VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" COMPANY1 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" FORMULA1 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" POLICY_NUMBER1 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" CURRENCY1 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" EXCESS1 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" DURATION1 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" TOTAL_AMOUNT_INSURED1 DECIMAL(65535,32767),";
				sqlstmt = sqlstmt+" CIE_HT_BASIS1 DECIMAL(65535,32767),";
				sqlstmt = sqlstmt+" COMPANY2 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" FORMULA2 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" POLICY_NUMBER2 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" CURRENCY2 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" EXCESS2 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" DURATION2 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" TOTAL_AMOUNT_INSURED2 DECIMAL(65535,32767),";
				sqlstmt = sqlstmt+" CIE_HT_BASIS2 DECIMAL(65535,32767),";
				sqlstmt = sqlstmt+" COMPANY3 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" FORMULA3 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" POLICY_NUMBER3 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" CURRENCY3 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" EXCESS3 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" DURATION3 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" TOTAL_AMOUNT_INSURED3 DECIMAL(65535,32767),";
				sqlstmt = sqlstmt+" CIE_HT_BASIS3 DECIMAL(65535,32767),";
				sqlstmt = sqlstmt+" COMPANY4 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" FORMULA4 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" POLICY_NUMBER4 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" CURRENCY4 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" EXCESS4 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" DURATION4 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" TOTAL_AMOUNT_INSURED4 DECIMAL(65535,32767),";
				sqlstmt = sqlstmt+" CIE_HT_BASIS4 DECIMAL(65535,32767),";
				sqlstmt = sqlstmt+" COMPANY5 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" FORMULA5 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" POLICY_NUMBER5 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" CURRENCY5 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" EXCESS5 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" DURATION5 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" TOTAL_AMOUNT_INSURED5 DECIMAL(65535,32767),";
				sqlstmt = sqlstmt+" CIE_HT_BASIS5 DECIMAL(65535,32767),";
				sqlstmt = sqlstmt+" COMPANY6 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" FORMULA VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" POLICY_NUMBER6 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" CURRENCY6 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" EXCESS6 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" DURATION6 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" TOTAL_AMOUNT_INSURED6 DECIMAL(65535,32767),";
				sqlstmt = sqlstmt+" CIE_HT_BASIS6 DECIMAL(65535,32767),";
				sqlstmt = sqlstmt+" COMPANY7 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" FORMULA7 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" POLICY_NUMBER7 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" CURRENCY7 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" EXCESS67 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" DURATION7 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" TOTAL_AMOUNT_INSURED7 DECIMAL(65535,32767),";
				sqlstmt = sqlstmt+" CIE_HT_BASIS7 DECIMAL(65535,32767),";
				sqlstmt = sqlstmt+" COMPANY8 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" FORMULA8 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" POLICY_NUMBER8 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" CURRENCY8 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" EXCESS8 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" DURATION8 VARCHAR(2147483647),";
				sqlstmt = sqlstmt+" TOTAL_AMOUNT_INSURED8 DECIMAL(65535,32767),";
				sqlstmt = sqlstmt+" CIE_HT_BASIS8 DECIMAL(65535,32767),";
				sqlstmt = sqlstmt+" NBREMVT DECIMAL(65535,32767),";
				sqlstmt = sqlstmt+" RANKMVT DECIMAL(65535,32767),";
				sqlstmt = sqlstmt+" NEXTMVT DECIMAL(65535,32767),";
				sqlstmt = sqlstmt+" DATEOFNEXTMVT DATE";
				sqlstmt = sqlstmt+" )";
		return sqlstmt;
	
	}

	
}
