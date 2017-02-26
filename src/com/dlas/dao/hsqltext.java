package com.dlas.dao;

public class hsqltext {
	public hsqltext() {

	}

	public String insertmvt() {
		String sqlstmt = null;

		sqlstmt = "INSERT INTO PUBLIC.MVT( ";
		sqlstmt = sqlstmt + "  STRUCTURE_NAME, ";
		sqlstmt = sqlstmt + "  CERTIFICATE ,";
		sqlstmt = sqlstmt + "  CERTIFICATE_START ,";
		sqlstmt = sqlstmt + "  CERTIFICATE_RENEWAL ,";
		sqlstmt = sqlstmt + "  CERTIFICATE_CANCELLATION ,";
		sqlstmt = sqlstmt + "  AMENDMENT_START ,";
		sqlstmt = sqlstmt + "  AMENDMENT_END ,";
		sqlstmt = sqlstmt + "  WYCC_ID ,";
		sqlstmt = sqlstmt + "  CLAIMS_MANAGER_ID ,";
		sqlstmt = sqlstmt + "  GENDER ,";
		sqlstmt = sqlstmt + "  NAME ,";
		sqlstmt = sqlstmt + "  FIRST_NAME ,";
		sqlstmt = sqlstmt + "  DATE_OF_BIRTH ,";
		sqlstmt = sqlstmt + "  EMAIL ,";
		sqlstmt = sqlstmt + "  POSITION_TYPE ,";
		sqlstmt = sqlstmt + "  POSITIONCREW ,";
		sqlstmt = sqlstmt + "  MONTHLY_SALARY ,";
		sqlstmt = sqlstmt + "  SALARY_CURRENCY ,";
		sqlstmt = sqlstmt + "  PERIOD_INSURANCE ,";
		sqlstmt = sqlstmt + "  DAYS ,";
		sqlstmt = sqlstmt + "  MONTHS ,";
		sqlstmt = sqlstmt + "  FAMILY_COVERED ,";
		sqlstmt = sqlstmt + "  RETIREMENT_PLAN ,";
		sqlstmt = sqlstmt + "  START_MOVEMENT ,";
		sqlstmt = sqlstmt + "  END_MOVEMENT ,";
		sqlstmt = sqlstmt + "  EMPLOYER ,";
		sqlstmt = sqlstmt + "  CHILDREN ,";
		sqlstmt = sqlstmt + "  COUNTRY ,";
		sqlstmt = sqlstmt + "  NATIONALITY ,";
		sqlstmt = sqlstmt + "  COMPANY1 ,";
		sqlstmt = sqlstmt + "  FORMULA1 ,";
		sqlstmt = sqlstmt + "  POLICY_NUMBER1 ,";
		sqlstmt = sqlstmt + "  CURRENCY1 ,";
		sqlstmt = sqlstmt + "  EXCESS1 ,";
		sqlstmt = sqlstmt + "  DURATION1 ,";
		sqlstmt = sqlstmt + "  TOTAL_AMOUNT_INSURED1 ,";
		sqlstmt = sqlstmt + "  CIE_HT_BASIS1 ,";
		sqlstmt = sqlstmt + "  COMPANY2 ,";
		sqlstmt = sqlstmt + "  FORMULA2 ,";
		sqlstmt = sqlstmt + "  POLICY_NUMBER2 ,";
		sqlstmt = sqlstmt + "  CURRENCY2 ,";
		sqlstmt = sqlstmt + "  EXCESS2 ,";
		sqlstmt = sqlstmt + "  DURATION2 ,";
		sqlstmt = sqlstmt + "  TOTAL_AMOUNT_INSURED2 ,";
		sqlstmt = sqlstmt + "  CIE_HT_BASIS2 ,";
		sqlstmt = sqlstmt + "  COMPANY3 ,";
		sqlstmt = sqlstmt + "  FORMULA3 ,";
		sqlstmt = sqlstmt + "  POLICY_NUMBER3 ,";
		sqlstmt = sqlstmt + "  CURRENCY3 ,";
		sqlstmt = sqlstmt + "  EXCESS3 ,";
		sqlstmt = sqlstmt + "  DURATION3 ,";
		sqlstmt = sqlstmt + "  TOTAL_AMOUNT_INSURED3 ,";
		sqlstmt = sqlstmt + "  CIE_HT_BASIS3 ,";
		sqlstmt = sqlstmt + "  COMPANY4 ,";
		sqlstmt = sqlstmt + "  FORMULA4 ,";
		sqlstmt = sqlstmt + "  POLICY_NUMBER4 ,";
		sqlstmt = sqlstmt + "  CURRENCY4 ,";
		sqlstmt = sqlstmt + "  EXCESS4 ,";
		sqlstmt = sqlstmt + "  DURATION4 ,";
		sqlstmt = sqlstmt + "  TOTAL_AMOUNT_INSURED4 ,";
		sqlstmt = sqlstmt + "  CIE_HT_BASIS4 ,";
		sqlstmt = sqlstmt + "  COMPANY5 ,";
		sqlstmt = sqlstmt + "  FORMULA5 ,";
		sqlstmt = sqlstmt + "  POLICY_NUMBER5 ,";
		sqlstmt = sqlstmt + "  CURRENCY5 ,";
		sqlstmt = sqlstmt + "  EXCESS5 ,";
		sqlstmt = sqlstmt + "  DURATION5 ,";
		sqlstmt = sqlstmt + "  TOTAL_AMOUNT_INSURED5 ,";
		sqlstmt = sqlstmt + "  CIE_HT_BASIS5 ,";
		sqlstmt = sqlstmt + "  COMPANY6 ,";
		sqlstmt = sqlstmt + "  FORMULA ,";
		sqlstmt = sqlstmt + "  POLICY_NUMBER6 ,";
		sqlstmt = sqlstmt + "  CURRENCY6 ,";
		sqlstmt = sqlstmt + "  EXCESS6 ,";
		sqlstmt = sqlstmt + "  DURATION6 ,";
		sqlstmt = sqlstmt + "  TOTAL_AMOUNT_INSURED6 ,";
		sqlstmt = sqlstmt + "  CIE_HT_BASIS6 ,";
		sqlstmt = sqlstmt + "  COMPANY7 ,";
		sqlstmt = sqlstmt + "  FORMULA7 ,";
		sqlstmt = sqlstmt + "  POLICY_NUMBER7 ,";
		sqlstmt = sqlstmt + "  CURRENCY7 ,";
		sqlstmt = sqlstmt + "  EXCESS67 ,";
		sqlstmt = sqlstmt + "  DURATION7 ,";
		sqlstmt = sqlstmt + "  TOTAL_AMOUNT_INSURED7 ,";
		sqlstmt = sqlstmt + "  CIE_HT_BASIS7 ,";
		sqlstmt = sqlstmt + "  COMPANY8 ,";
		sqlstmt = sqlstmt + "  FORMULA8 ,";
		sqlstmt = sqlstmt + "  POLICY_NUMBER8 ,";
		sqlstmt = sqlstmt + "  CURRENCY8 ,";
		sqlstmt = sqlstmt + "  EXCESS8 ,";
		sqlstmt = sqlstmt + "  DURATION8 ,";
		sqlstmt = sqlstmt + "  TOTAL_AMOUNT_INSURED8 ,";
		sqlstmt = sqlstmt + "  CIE_HT_BASIS8 ,";
		sqlstmt = sqlstmt + "  FORMULE_NAME1 ,";
		sqlstmt = sqlstmt + "  FORMULE_NAME2 ,";
		sqlstmt = sqlstmt + "  FORMULE_NAME3 ,";
		sqlstmt = sqlstmt + "  FORMULE_NAME4 ,";
		sqlstmt = sqlstmt + "  FORMULE_NAME5 ,";
		sqlstmt = sqlstmt + "  FORMULE_NAME6 ,";
		sqlstmt = sqlstmt + "  FORMULE_NAME7 ,";
		sqlstmt = sqlstmt + "  FORMULE_NAME8 ";

		sqlstmt = sqlstmt + "  )";
		sqlstmt = sqlstmt + "  VALUES (";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";

		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?,";
		sqlstmt = sqlstmt + " ?";
		sqlstmt = sqlstmt + " )";

		return sqlstmt;
	}

	public String insertmvtnum() {
		String sqlstmt = null;

		sqlstmt = "INSERT INTO PUBLIC.MVT_NUM (STRUCTURE_NAME, CERTIFICATE, CERTIFICATE_START, CERTIFICATE_RENEWAL, CERTIFICATE_CANCELLATION, AMENDMENT_START, AMENDMENT_END, WYCC_ID,";
		sqlstmt = sqlstmt
				+ " CLAIMS_MANAGER_ID, GENDER, NAME, FIRST_NAME, DATE_OF_BIRTH, EMAIL, POSITION_TYPE, POSITIONCREW, MONTHLY_SALARY, SALARY_CURRENCY, PERIOD_INSURANCE, DAYS, MONTHS, ";
		sqlstmt = sqlstmt
				+ " FAMILY_COVERED, RETIREMENT_PLAN, START_MOVEMENT, END_MOVEMENT, EMPLOYER, CHILDREN, COUNTRY, NATIONALITY, COMPANY1,FORMULE_NAME1, FORMULA1, POLICY_NUMBER1, CURRENCY1, ";
		sqlstmt = sqlstmt
				+ " EXCESS1, DURATION1, TOTAL_AMOUNT_INSURED1, CIE_HT_BASIS1, COMPANY2,FORMULE_NAME2, FORMULA2, POLICY_NUMBER2, CURRENCY2, EXCESS2, DURATION2, TOTAL_AMOUNT_INSURED2,";
		sqlstmt = sqlstmt
				+ " CIE_HT_BASIS2, COMPANY3,FORMULE_NAME3, FORMULA3, POLICY_NUMBER3, CURRENCY3, EXCESS3, DURATION3, TOTAL_AMOUNT_INSURED3, CIE_HT_BASIS3, COMPANY4,FORMULE_NAME4, FORMULA4, POLICY_NUMBER4,";
		sqlstmt = sqlstmt
				+ " CURRENCY4, EXCESS4, DURATION4, TOTAL_AMOUNT_INSURED4, CIE_HT_BASIS4, COMPANY5,FORMULE_NAME5, FORMULA5, POLICY_NUMBER5, CURRENCY5, EXCESS5, DURATION5, TOTAL_AMOUNT_INSURED5,";
		sqlstmt = sqlstmt
				+ " CIE_HT_BASIS5, COMPANY6,FORMULE_NAME6, FORMULA6, POLICY_NUMBER6, CURRENCY6, EXCESS6, DURATION6, TOTAL_AMOUNT_INSURED6, CIE_HT_BASIS6, COMPANY7,FORMULE_NAME7, FORMULA7, POLICY_NUMBER7,";
		sqlstmt = sqlstmt
				+ " CURRENCY7, EXCESS67, DURATION7, TOTAL_AMOUNT_INSURED7, CIE_HT_BASIS7, COMPANY8,FORMULE_NAME8, FORMULA8, POLICY_NUMBER8, CURRENCY8, EXCESS8, DURATION8, TOTAL_AMOUNT_INSURED8,";
		sqlstmt = sqlstmt + " CIE_HT_BASIS8, NBREMVT,RANKMVT, NEXTMVT,DATEOFNEXTMVT,DATEOFPREVMVT)";
		sqlstmt = sqlstmt
				+ " SELECT STRUCTURE_NAME,CERTIFICATE,CERTIFICATE_START,CERTIFICATE_RENEWAL,CERTIFICATE_CANCELLATION,AMENDMENT_START,AMENDMENT_END,";
		sqlstmt = sqlstmt
				+ " WYCC_ID,CLAIMS_MANAGER_ID,GENDER,NAME,FIRST_NAME,DATE_OF_BIRTH,EMAIL,POSITION_TYPE,POSITIONCREW,";
		sqlstmt = sqlstmt
				+ " CAST( CASE WHEN REPLACE(MONTHLY_SALARY,',','.')!='' then REPLACE(MONTHLY_SALARY,',','.') else  '0' end  as Integer),";
		sqlstmt = sqlstmt
				+ " SALARY_CURRENCY,PERIOD_INSURANCE ,cast(DAYS as Integer),cast(MONTHS as Integer),FAMILY_COVERED,RETIREMENT_PLAN,";
		sqlstmt = sqlstmt + " TO_TIMESTAMP(START_MOVEMENT,'dd/MM/yyyy') START_MOVEMENT,";
		sqlstmt = sqlstmt + " TO_TIMESTAMP(END_MOVEMENT,'dd/MM/yyyy') END_MOVEMENT,";
		sqlstmt = sqlstmt
				+ " EMPLOYER,CHILDREN,COUNTRY,NATIONALITY,COMPANY1,FORMULE_NAME1,FORMULA1,POLICY_NUMBER1,CURRENCY1,EXCESS1,DURATION1,";
		sqlstmt = sqlstmt
				+ " CAST( CASE WHEN REPLACE(TOTAL_AMOUNT_INSURED1,',','.')!='' then REPLACE(TOTAL_AMOUNT_INSURED1,',','.')  else  '0' end  as Float) ,";
		sqlstmt = sqlstmt
				+ " CAST( CASE WHEN REPLACE(REPLACE(CIE_HT_BASIS1,'%','') ,',','.') !=''  then REPLACE(REPLACE(CIE_HT_BASIS1,'%','') ,',','.') else  '0' end  as Float),";
		sqlstmt = sqlstmt + " COMPANY2,FORMULE_NAME2,FORMULA2,POLICY_NUMBER2,CURRENCY2,EXCESS2,DURATION2,";
		sqlstmt = sqlstmt
				+ " CAST( CASE WHEN REPLACE(TOTAL_AMOUNT_INSURED2,',','.')!=''  then REPLACE(TOTAL_AMOUNT_INSURED2,',','.') else  '0' end  as Float),";
		sqlstmt = sqlstmt
				+ " CAST( CASE WHEN REPLACE(REPLACE(CIE_HT_BASIS2,'%',''),',','.') !='' then REPLACE(REPLACE(CIE_HT_BASIS2,'%',''),',','.') else  '0' end  as Float),";
		sqlstmt = sqlstmt + " COMPANY3,FORMULE_NAME3,FORMULA3,POLICY_NUMBER3,CURRENCY3,EXCESS3,DURATION3,";
		sqlstmt = sqlstmt
				+ " CAST( CASE WHEN REPLACE(TOTAL_AMOUNT_INSURED3,',','.')!='' then REPLACE(TOTAL_AMOUNT_INSURED3,',','.') else  '0' end  as Float),";
		sqlstmt = sqlstmt
				+ " CAST( CASE WHEN REPLACE(REPLACE(CIE_HT_BASIS3,'%',''),',','.') !='' then REPLACE(REPLACE(CIE_HT_BASIS3,'%',''),',','.') else  '0' end  as Float),";
		sqlstmt = sqlstmt + " COMPANY4,FORMULE_NAME4,FORMULA4,POLICY_NUMBER4,CURRENCY4,EXCESS4,DURATION4,";
		sqlstmt = sqlstmt
				+ " CAST( CASE WHEN REPLACE(TOTAL_AMOUNT_INSURED4,',','.') !='' then REPLACE(TOTAL_AMOUNT_INSURED4,',','.') else  '0' end  as Float),";
		sqlstmt = sqlstmt
				+ " CAST( CASE WHEN REPLACE(REPLACE(CIE_HT_BASIS4,'%',''),',','.') !='' then REPLACE(REPLACE(CIE_HT_BASIS4,'%',''),',','.') else  '0' end  as Float),";
		sqlstmt = sqlstmt + " COMPANY5,FORMULE_NAME5, FORMULA5, POLICY_NUMBER5, CURRENCY5, EXCESS5, DURATION5,";
		sqlstmt = sqlstmt
				+ " CAST( CASE WHEN REPLACE(TOTAL_AMOUNT_INSURED5,',','.') !='' then REPLACE(TOTAL_AMOUNT_INSURED5,',','.') else  '0' end  as Float),";
		sqlstmt = sqlstmt
				+ " CAST( CASE WHEN REPLACE(REPLACE(CIE_HT_BASIS5,'%',''),',','.') !='' then REPLACE(REPLACE(CIE_HT_BASIS5,'%',''),',','.') else  '0' end  as Float),";
		sqlstmt = sqlstmt + " COMPANY6,FORMULE_NAME6, FORMULA, POLICY_NUMBER6, CURRENCY6, EXCESS6, DURATION6,";
		sqlstmt = sqlstmt
				+ " CAST( CASE WHEN REPLACE(TOTAL_AMOUNT_INSURED6,',','.') !='' then REPLACE(TOTAL_AMOUNT_INSURED6,',','.') else  '0' end  as Float),";
		sqlstmt = sqlstmt
				+ " CAST( CASE WHEN REPLACE(REPLACE(CIE_HT_BASIS6,'%',''),',','.') !='' then REPLACE(REPLACE(CIE_HT_BASIS6,'%',''),',','.') else  '0' end  as Float),";
		sqlstmt = sqlstmt + " COMPANY7, FORMULE_NAME7,FORMULA7, POLICY_NUMBER7, CURRENCY7, EXCESS67, DURATION7,";
		sqlstmt = sqlstmt
				+ " CAST( CASE WHEN REPLACE(TOTAL_AMOUNT_INSURED7,',','.')  !='' then REPLACE(TOTAL_AMOUNT_INSURED7,',','.') else  '0' end  as Float),";
		sqlstmt = sqlstmt
				+ " CAST( CASE WHEN REPLACE(REPLACE(CIE_HT_BASIS7,'%',''),',','.') !='' then REPLACE(REPLACE(CIE_HT_BASIS7,'%',''),',','.') else  '0' end  as Float),";
		sqlstmt = sqlstmt + " COMPANY8,FORMULE_NAME8, FORMULA8, POLICY_NUMBER8, CURRENCY8, EXCESS8, DURATION8,";
		sqlstmt = sqlstmt
				+ " CAST( CASE WHEN REPLACE(TOTAL_AMOUNT_INSURED8,',','.') !='' then REPLACE(TOTAL_AMOUNT_INSURED8,',','.') else  '0' end  as Float),";
		sqlstmt = sqlstmt
				+ " CAST( CASE WHEN REPLACE(REPLACE(CIE_HT_BASIS8,'%',''),',','.') !='' then REPLACE(REPLACE(CIE_HT_BASIS8,'%',''),',','.') else  '0' end  as Float),";
		sqlstmt = sqlstmt + " ( SELECT COUNT(*) FROM mvt yt2 WHERE yt2.wycc_id = yt1.wycc_id ), ";
		sqlstmt = sqlstmt
				+ " ( SELECT COUNT(*) FROM mvt yt2 WHERE yt2.wycc_id = yt1.wycc_id AND TO_TIMESTAMP(yt2.start_movement,'dd/MM/yyyy') < DATEADD( 'DAY', 1,  TO_TIMESTAMP(yt1.end_movement,'dd/MM/yyyy') ) ),";
		sqlstmt = sqlstmt
				+ " ( SELECT COUNT(*) FROM mvt yt2 WHERE yt2.wycc_id = yt1.wycc_id AND TO_TIMESTAMP(yt2.end_movement,'dd/MM/yyyy') = DATEADD( 'DAY', -1, TO_TIMESTAMP(yt1.start_movement,'dd/MM/yyyy') ) ), ";
		sqlstmt = sqlstmt
				+ " ( SELECT MIN( TO_TIMESTAMP( yt2.start_movement, 'dd/MM/yyyy' ) ) FROM mvt yt2 WHERE yt2.wycc_id = yt1.wycc_id AND TO_TIMESTAMP(yt2.start_movement,'dd/MM/yyyy') > TO_TIMESTAMP(yt1.end_movement,'dd/MM/yyyy') ),";
		sqlstmt = sqlstmt
				+ " ( SELECT Max( TO_TIMESTAMP( yt2.end_movement, 'dd/MM/yyyy' )) FROM mvt yt2 WHERE yt2.wycc_id = yt1.wycc_id AND TO_TIMESTAMP( yt2.end_movement, 'dd/MM/yyyy' ) < TO_TIMESTAMP( yt1.start_movement, 'dd/MM/yyyy' ) ) dateprev";
		sqlstmt = sqlstmt + " FROM PUBLIC.MVT YT1";
		return sqlstmt;
	}

	public String insertbeneficiairies() {
		String sqlstmt = null;

		sqlstmt = " INSERT INTO PUBLIC.BENEFICIARIES_TAB";
		sqlstmt = sqlstmt + "( WYCC_ID, NAME, FIRST_NAME, LINE, STRUCTURE_NAME, FAMILY_COVERED, CHILDREN, NATIONALITY,";
		sqlstmt = sqlstmt
				+ " COUNTRY, POSITIONCREW, PERIOD_INSURANCE, START_MOVEMENT, PREVMVT, ENDCOMP, END_MOVEMENT, ";
		sqlstmt = sqlstmt
				+ "NEXTMVT, NEXTCOMP, MONTHLY_SALARY, SALARY_CURRENCY, DRESTEJ, ERESTEJ, JOUR,MOIS, TO_INVOICE,";
		sqlstmt = sqlstmt
				+ " company1,formule1,formule_name1, total_amount_insured1,company2,formule2, formule_name2, total_amount_insured2,company3,formule3, formule_name3, total_amount_insured3,";
		sqlstmt = sqlstmt
				+ " company4,formule4,formule_name4, total_amount_insured4,company5,formule5, formule_name5, total_amount_insured5,company6,formule6, formule_name6, total_amount_insured6,";
		sqlstmt = sqlstmt
				+ " company7,formule7,formule_name7,total_amount_insured7,company8,formule8,formule_name8,total_amount_insured8)";
		sqlstmt = sqlstmt + "  SELECT WYCC_ID, NAME, FIRST_NAME, LINE, STRUCTURE_NAME,";
		sqlstmt = sqlstmt + "    FAMILY_COVERED, CHILDREN, NATIONALITY, COUNTRY, POSITIONCREW,";
		sqlstmt = sqlstmt + "    PERIOD_INSURANCE,START_MOVEMENT, PREVMVT,";
		sqlstmt = sqlstmt + "    DATEDIFF('DAY', START_MOVEMENT, DATEADD('DAY', -1, PREVMVT)) AS ENDCOMP,";
		sqlstmt = sqlstmt + "    END_MOVEMENT, NEXTMVT,";
		sqlstmt = sqlstmt + "    DATEDIFF('DAY', END_MOVEMENT, DATEADD('DAY', -1, NEXTMVT)) AS NEXTCOMP,";
		sqlstmt = sqlstmt + "    MONTHLY_SALARY, SALARY_CURRENCY, DRESTEJ, ERESTEJ, JOUR, MOIS,";
		sqlstmt = sqlstmt + "    ((CASE WHEN (LINE = 1) THEN (MOIS + 1) ELSE MOIS END + CASE WHEN ((LINE <> 1)";
		sqlstmt = sqlstmt
				+ "        AND (DATEDIFF('DAY', START_MOVEMENT, DATEADD('DAY', 1, PREVMVT)) = 0)) THEN ROUND(((30.0 - (1.0*DRESTEJ)) / 30.0), 5) ELSE 0 END) + CASE WHEN ((LINE <> 1)";
		sqlstmt = sqlstmt
				+ "        AND (DATEDIFF('DAY', END_MOVEMENT, DATEADD('DAY', -1, NEXTMVT)) = 0)) THEN ROUND(((1.0*ERESTEJ) / 30.0), 5) ELSE 0 END) AS TO_INVOICE,";
		sqlstmt = sqlstmt
				+ " company1,formule1,formule_name1, total_amount_insured1,company2,formule2, formule_name2, total_amount_insured2,company3,formule3, formule_name3, total_amount_insured3,";
		sqlstmt = sqlstmt
				+ " company4,formule4,formule_name4, total_amount_insured4,company5,formule5, formule_name5, total_amount_insured5,company6,formule6, formule_name6, total_amount_insured6,";
		sqlstmt = sqlstmt
				+ " company7,formule7,formule_name7,total_amount_insured7,company8,formule8,formule_name8,total_amount_insured8";
		sqlstmt = sqlstmt + " FROM PUBLIC.LISTGROUP ";

		return sqlstmt;
	}

	public String createTableMvt() {
		String sqlstmt = null;

		sqlstmt = "CREATE TABLE PUBLIC.MVT (";
		sqlstmt = sqlstmt + "STRUCTURE_NAME VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "CERTIFICATE VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "CERTIFICATE_START VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "CERTIFICATE_RENEWAL VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "CERTIFICATE_CANCELLATION VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "AMENDMENT_START VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "AMENDMENT_END VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "WYCC_ID VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "CLAIMS_MANAGER_ID VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "GENDER VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "NAME VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "FIRST_NAME VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "DATE_OF_BIRTH VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "EMAIL VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "POSITION_TYPE VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "POSITIONCREW VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "MONTHLY_SALARY VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "SALARY_CURRENCY VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "PERIOD VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "DAYS VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "MONTHS VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "FAMILY_COVERED VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "RETIREMENT_PLAN VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "START_MOVEMENT VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "END_MOVEMENT VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "EMPLOYER VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "CHILDREN VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "COUNTRY VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "NATIONALITY VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "COMPANY1 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "FORMULA1 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "POLICY_NUMBER1 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "CURRENCY1 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "EXCESS1 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "DURATION1 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "TOTAL_AMOUNT_INSURED1 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "CIE_HT_BASIS1 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "COMPANY2 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "FORMULA2 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "POLICY_NUMBER2 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "CURRENCY2 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "EXCESS2 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "DURATION2 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "TOTAL_AMOUNT_INSURED2 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "CIE_HT_BASIS2 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "COMPANY3 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "FORMULA3 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "POLICY_NUMBER3 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "CURRENCY3 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "EXCESS3 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "DURATION3 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "TOTAL_AMOUNT_INSURED3 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "CIE_HT_BASIS3 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "COMPANY4 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "FORMULA4 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "POLICY_NUMBER4 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "CURRENCY4 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "EXCESS4 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "DURATION4 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "TOTAL_AMOUNT_INSURED4 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "CIE_HT_BASIS4 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "COMPANY5 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "FORMULA5 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "POLICY_NUMBER5 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "CURRENCY5 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "EXCESS5 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "DURATION5 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "TOTAL_AMOUNT_INSURED5 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "CIE_HT_BASIS5 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "COMPANY6 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "FORMULA VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "POLICY_NUMBER6 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "CURRENCY6 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "EXCESS6 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "DURATION6 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "TOTAL_AMOUNT_INSURED6 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "CIE_HT_BASIS6 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "COMPANY7 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "FORMULA7 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "POLICY_NUMBER7 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "CURRENCY7 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "EXCESS67 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "DURATION7 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "TOTAL_AMOUNT_INSURED7 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "CIE_HT_BASIS7 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "COMPANY8 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "FORMULA8 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "POLICY_NUMBER8 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "CURRENCY8 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "EXCESS8 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "DURATION8 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "TOTAL_AMOUNT_INSURED8 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + "CIE_HT_BASIS8 VARCHAR(2147483647)";
		sqlstmt = sqlstmt + ")";
		return sqlstmt;
	}

	public String createTableMvtNum() {
		String sqlstmt = null;
		sqlstmt = "CREATE TABLE PUBLIC.MVT_NUM (";
		sqlstmt = sqlstmt + " STRUCTURE_NAME VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " CERTIFICATE VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " CERTIFICATE_START VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " CERTIFICATE_RENEWAL VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " CERTIFICATE_CANCELLATION VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " AMENDMENT_START VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " AMENDMENT_END VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " WYCC_ID VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " CLAIMS_MANAGER_ID VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " GENDER VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " NAME VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " FIRST_NAME VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " DATE_OF_BIRTH VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " EMAIL VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " POSITION_TYPE VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " POSITIONCREW VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " MONTHLY_SALARY DECIMAL(65535,32767),";
		sqlstmt = sqlstmt + " SALARY_CURRENCY VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " PERIOD VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " DAYS DECIMAL(65535,32767),";
		sqlstmt = sqlstmt + " MONTHS DECIMAL(65535,32767),";
		sqlstmt = sqlstmt + " FAMILY_COVERED VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " RETIREMENT_PLAN VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " START_MOVEMENT DATE,";
		sqlstmt = sqlstmt + " END_MOVEMENT DATE,";
		sqlstmt = sqlstmt + " EMPLOYER VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " CHILDREN VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " COUNTRY VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " NATIONALITY VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " COMPANY1 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " FORMULA1 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " POLICY_NUMBER1 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " CURRENCY1 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " EXCESS1 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " DURATION1 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " TOTAL_AMOUNT_INSURED1 DECIMAL(65535,32767),";
		sqlstmt = sqlstmt + " CIE_HT_BASIS1 DECIMAL(65535,32767),";
		sqlstmt = sqlstmt + " COMPANY2 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " FORMULA2 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " POLICY_NUMBER2 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " CURRENCY2 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " EXCESS2 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " DURATION2 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " TOTAL_AMOUNT_INSURED2 DECIMAL(65535,32767),";
		sqlstmt = sqlstmt + " CIE_HT_BASIS2 DECIMAL(65535,32767),";
		sqlstmt = sqlstmt + " COMPANY3 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " FORMULA3 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " POLICY_NUMBER3 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " CURRENCY3 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " EXCESS3 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " DURATION3 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " TOTAL_AMOUNT_INSURED3 DECIMAL(65535,32767),";
		sqlstmt = sqlstmt + " CIE_HT_BASIS3 DECIMAL(65535,32767),";
		sqlstmt = sqlstmt + " COMPANY4 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " FORMULA4 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " POLICY_NUMBER4 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " CURRENCY4 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " EXCESS4 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " DURATION4 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " TOTAL_AMOUNT_INSURED4 DECIMAL(65535,32767),";
		sqlstmt = sqlstmt + " CIE_HT_BASIS4 DECIMAL(65535,32767),";
		sqlstmt = sqlstmt + " COMPANY5 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " FORMULA5 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " POLICY_NUMBER5 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " CURRENCY5 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " EXCESS5 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " DURATION5 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " TOTAL_AMOUNT_INSURED5 DECIMAL(65535,32767),";
		sqlstmt = sqlstmt + " CIE_HT_BASIS5 DECIMAL(65535,32767),";
		sqlstmt = sqlstmt + " COMPANY6 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " FORMULA VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " POLICY_NUMBER6 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " CURRENCY6 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " EXCESS6 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " DURATION6 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " TOTAL_AMOUNT_INSURED6 DECIMAL(65535,32767),";
		sqlstmt = sqlstmt + " CIE_HT_BASIS6 DECIMAL(65535,32767),";
		sqlstmt = sqlstmt + " COMPANY7 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " FORMULA7 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " POLICY_NUMBER7 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " CURRENCY7 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " EXCESS67 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " DURATION7 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " TOTAL_AMOUNT_INSURED7 DECIMAL(65535,32767),";
		sqlstmt = sqlstmt + " CIE_HT_BASIS7 DECIMAL(65535,32767),";
		sqlstmt = sqlstmt + " COMPANY8 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " FORMULA8 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " POLICY_NUMBER8 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " CURRENCY8 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " EXCESS8 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " DURATION8 VARCHAR(2147483647),";
		sqlstmt = sqlstmt + " TOTAL_AMOUNT_INSURED8 DECIMAL(65535,32767),";
		sqlstmt = sqlstmt + " CIE_HT_BASIS8 DECIMAL(65535,32767),";
		sqlstmt = sqlstmt + " NBREMVT DECIMAL(65535,32767),";
		sqlstmt = sqlstmt + " RANKMVT DECIMAL(65535,32767),";
		sqlstmt = sqlstmt + " NEXTMVT DECIMAL(65535,32767),";
		sqlstmt = sqlstmt + " DATEOFNEXTMVT DATE";
		sqlstmt = sqlstmt + " )";
		return sqlstmt;

	}

	public String insertListMvt() {
		String sqlstmt = " ";
		sqlstmt = "INSERT INTO PUBLIC.LISTMVT_TAB (WYCC_ID, RANG, LINE, POSITIONCREW, NAME, FIRST_NAME, STRUCTURE_NAME, CREWMANNING, PERIOD, FAMILY_COVERED, NATIONALITY, COUNTRY, CHILDREN, START_MOVEMENT, END_MOVEMENT, NEXTMVT, PREVMVT, JOUR, MOIS, DRESTEJ, ERESTEJ, MONTHLY_SALARY, SALARY_CURRENCY)";
		sqlstmt = sqlstmt + " SELECT";
		sqlstmt = sqlstmt + " WYCC_ID,";
		sqlstmt = sqlstmt + " RANG,";
		sqlstmt = sqlstmt + " LINE,";
		sqlstmt = sqlstmt + " POSITIONCREW,";
		sqlstmt = sqlstmt + " NAME,";
		sqlstmt = sqlstmt + " FIRST_NAME,";
		sqlstmt = sqlstmt + " STRUCTURE_NAME,";
		sqlstmt = sqlstmt + " CREWMANNING,";
		sqlstmt = sqlstmt + " PERIOD,";
		sqlstmt = sqlstmt + " FAMILY_COVERED,";
		sqlstmt = sqlstmt + " NATIONALITY,";
		sqlstmt = sqlstmt + " COUNTRY,";
		sqlstmt = sqlstmt + " CHILDREN,";
		sqlstmt = sqlstmt + " START_MOVEMENT,";
		sqlstmt = sqlstmt + " END_MOVEMENT,";
		sqlstmt = sqlstmt + " NEXTMVT,";
		sqlstmt = sqlstmt + " PREVMVT,";
		sqlstmt = sqlstmt + " JOUR,";
		sqlstmt = sqlstmt + " MOIS,";
		sqlstmt = sqlstmt + " DRESTEJ,";
		sqlstmt = sqlstmt + " ERESTEJ,";
		sqlstmt = sqlstmt + " MONTHLY_SALARY,";
		sqlstmt = sqlstmt + " SALARY_CURRENCY";
		sqlstmt = sqlstmt
				+ " FROM (WITH RECURSIVE LIST(POSITIONCREW,NAME,FIRST_NAME,STRUCTURE_NAME,CREWMANNING,PERIOD,FAMILY_COVERED,NATIONALITY,COUNTRY,CHILDREN,MONTHLY_SALARY,SALARY_CURRENCY,RANG,LINE,WYCC_ID,START_MOVEMENT,END_MOVEMENT,DATEOFNEXTMVT,DATEOFPREVMVT,RANKMVT,RANKPARENT) AS (";
		sqlstmt = sqlstmt
				+ " (SELECTPOSITIONCREW,NAME,FIRST_NAME,STRUCTURE_NAME,NULL AS CREWMANNING,PERIOD,FAMILY_COVERED,NATIONALITY,COUNTRY,CHILDREN,MONTHLY_SALARY,SALARY_CURRENCY,MVT_NUM_ID,RANKMVT,WYCC_ID,";
		sqlstmt = sqlstmt
				+ "CASE WHEN (START_MOVEMENT < TIMESTAMP '2016-01-01 00:00:00.0') THEN TIMESTAMP '2016-01-01 00:00:00.0' ELSE START_MOVEMENT END AS START_MOVEMENT,";
		sqlstmt = sqlstmt
				+ "CASE WHEN (END_MOVEMENT > TIMESTAMP '2016-12-31 00:00:00.0') THEN TIMESTAMP '2016-12-31 00:00:00.0' ELSE END_MOVEMENT END AS END_MOVEMENT,";
		sqlstmt = sqlstmt + "DATEOFNEXTMVT,DATEOFPREVMVT,RANKMVT,RANKPARENT FROM PUBLIC.MVT_NUM YT1 WHERE NEXTMVT = 0)";
		sqlstmt = sqlstmt + " UNION ALL ";
		sqlstmt = sqlstmt + "(SELECT M.POSITIONCREW, M.NAME, M.FIRST_NAME, M.STRUCTURE_NAME,";
		sqlstmt = sqlstmt
				+ "'NULL AS CREWMANNING, M.PERIOD, M.FAMILY_COVERED, M.NATIONALITY,M.COUNTRY, M.CHILDREN,M.MONTHLY_SALARY,M.SALARY_CURRENCY, L.RANG, M.RANKMVT, M.WYCC_ID,";
		sqlstmt = sqlstmt
				+ "CASE WHEN (M.START_MOVEMENT < TIMESTAMP '2016-01-01 00:00:00.0') THEN TIMESTAMP '2016-01-01 00:00:00.0' ELSE M.START_MOVEMENT END AS START_MOVEMENT,";
		sqlstmt = sqlstmt
				+ "CASE WHEN (M.END_MOVEMENT > TIMESTAMP '2016-12-31 00:00:00.0') THEN TIMESTAMP '2016-12-31 00:00:00.0' ELSE M.END_MOVEMENT END AS END_MOVEMENT,";
		sqlstmt = sqlstmt + " M.DATEOFNEXTMVT,  M.DATEOFPREVMVT,  M.RANKMVT, M.RANKPARENT";
		sqlstmt = sqlstmt
				+ " FROM PUBLIC.MVT_NUM M INNER JOIN PUBLIC.LIST L ON 1=1 WHERE (NEXTMVT <> 0) AND ((M.WYCC_ID = L.WYCC_ID) AND (M.START_MOVEMENT = L.DATEOFNEXTMVT))) )";
		sqlstmt = sqlstmt + "SELECT";
		sqlstmt = sqlstmt + "         WYCC_ID,";
		sqlstmt = sqlstmt + "         RANG,";
		sqlstmt = sqlstmt + "         MIN(LINE) AS LINE,";
		sqlstmt = sqlstmt + "         POSITIONCREW,";
		sqlstmt = sqlstmt + "         NAME,";
		sqlstmt = sqlstmt + "         FIRST_NAME,";
		sqlstmt = sqlstmt + "         STRUCTURE_NAME,";
		sqlstmt = sqlstmt + "         CREWMANNING,";
		sqlstmt = sqlstmt + "         PERIOD,";
		sqlstmt = sqlstmt + "         FAMILY_COVERED,";
		sqlstmt = sqlstmt + "         NATIONALITY,";
		sqlstmt = sqlstmt + "         COUNTRY,";
		sqlstmt = sqlstmt + "         CHILDREN,";
		sqlstmt = sqlstmt + "         SALARY_CURRENCY,";
		sqlstmt = sqlstmt + "         MIN(START_MOVEMENT) AS START_MOVEMENT,";
		sqlstmt = sqlstmt + "         MAX(END_MOVEMENT) AS END_MOVEMENT,";
		sqlstmt = sqlstmt + "         MAX(DATEOFNEXTMVT) AS NEXTMVT,";
		sqlstmt = sqlstmt + "         MIN(DATEOFPREVMVT) AS PREVMVT,";
		sqlstmt = sqlstmt + "         DATEDIFF('DAY', MIN(START_MOVEMENT), MAX(END_MOVEMENT)) AS JOUR,";
		sqlstmt = sqlstmt + "         (MONTH(MAX(END_MOVEMENT)) - MONTH(MIN(START_MOVEMENT))) AS MOIS,";
		sqlstmt = sqlstmt + "         DAY_OF_MONTH(MIN(START_MOVEMENT)) AS DRESTEJ,";
		sqlstmt = sqlstmt + "         DAY_OF_MONTH(MAX(END_MOVEMENT)) AS ERESTEJ,";
		sqlstmt = sqlstmt + "         SUM(MONTHLY_SALARY) AS MONTHLY_SALARY";
		sqlstmt = sqlstmt
				+ "     FROM LIST GROUP BY WYCC_ID, RANG, POSITIONCREW, NAME, FIRST_NAME, STRUCTURE_NAME, CREWMANNING, PERIOD, FAMILY_COVERED, NATIONALITY, COUNTRY, CHILDREN, SALARY_CURRENCY";
		// sqlstmt = sqlstmt+" ORDER BY WYCC_ID, RANG, 3, 13";
		sqlstmt = sqlstmt + ")";

		return sqlstmt;
	}

	public String insertRootListMvthier() {
		String sqlstmt = null;
		sqlstmt = " INSERT INTO PUBLIC.LISTMVTHIER";
		sqlstmt = sqlstmt + " (lv1, positioncrew, name, first_name, structure_name,";
		sqlstmt = sqlstmt
				+ " company1,formule1,formule_name1,POLICE_NUMBER1, total_amount_insured1,company2,formule2, formule_name2,POLICE_NUMBER2, total_amount_insured2,company3,formule3, formule_name3,POLICE_NUMBER3, total_amount_insured3,";
		sqlstmt = sqlstmt
				+ " company4,formule4,formule_name4,POLICE_NUMBER4, total_amount_insured4,company5,formule5, formule_name5,POLICE_NUMBER5, total_amount_insured5,company6,formule6, formule_name6,POLICE_NUMBER6, total_amount_insured6,";
		sqlstmt = sqlstmt
				+ " company7,formule7,formule_name7,POLICE_NUMBER7, total_amount_insured7,company8,formule8, formule_name8,POLICE_NUMBER8,total_amount_insured8,";
		sqlstmt = sqlstmt + " crewmanning, period_insurance, family_covered,";
		sqlstmt = sqlstmt
				+ " nationality, country, children, monthly_salary, salary_currency,  niveau, wycc_id, start_movement, end_movement,";
		sqlstmt = sqlstmt + "dateofnextmvt, dateofprevmvt, rankmvt, rankparent, nextmvt)";
		sqlstmt = sqlstmt + " select 1 lv1, m.positioncrew,  m.name,  m.first_name,  m.structure_name,";
		sqlstmt = sqlstmt
				+ " company1,formula1,formule_name1,POLICY_NUMBER1, total_amount_insured1,company2,formula2, formule_name2,POLICY_NUMBER2, total_amount_insured2,company3,formula3, formule_name3,POLICY_NUMBER3, total_amount_insured3,";
		sqlstmt = sqlstmt
				+ " company4,formula4,formule_name4,POLICY_NUMBER4, total_amount_insured4,company5,formula5, formule_name5,POLICY_NUMBER5, total_amount_insured5,company6,formula6, formule_name6,POLICY_NUMBER6, total_amount_insured6,";
		sqlstmt = sqlstmt
				+ " company7,formula7,formule_name7,POLICY_NUMBER7, total_amount_insured7,company8,formula8, formule_name8,POLICY_NUMBER8,total_amount_insured8,";
		sqlstmt = sqlstmt
				+ "					 '' as crewmanning,  m.period_insurance,  m.family_covered,  m.nationality,  m.country,";
		sqlstmt = sqlstmt
				+ "					  m.children,  m.monthly_salary,  m.salary_currency,   m.rankmvt as niveau,";
		sqlstmt = sqlstmt + "					  m.wycc_id,";
		sqlstmt = sqlstmt
				+ "					 case when ( m.start_movement < timestamp '2016-01-01 00:00:00.0') then timestamp '2016-01-01 00:00:00.0' else  m.start_movement end as start_movement,";
		sqlstmt = sqlstmt
				+ "					 case when ( m.end_movement > timestamp '2016-12-31 00:00:00.0') then timestamp '2016-12-31 00:00:00.0' else  m.end_movement end as end_movement,";
		sqlstmt = sqlstmt
				+ "					  m.dateofnextmvt,  m.dateofprevmvt,  m.rankmvt,  m.rankparent,  m.nextmvt";
		sqlstmt = sqlstmt + "		from PUBLIC.mvt_num m where nextmvt = 0 ";
		sqlstmt = sqlstmt + "";
		return sqlstmt;
	}

	public String isLevelNListMvthier() {
		String sqlstmt = null;
		sqlstmt = " select count(*) from PUBLIC.mvt_num m where nextmvt = ? ";
		return sqlstmt;
	}

	public String insertLevelNListMvthier() {
		String sqlstmt = null;
		sqlstmt = " INSERT INTO PUBLIC.LISTMVTHIER";
		sqlstmt = sqlstmt + " (lv1, positioncrew, name, first_name, structure_name,";
		sqlstmt = sqlstmt
				+ " company1,formule1,formule_name1,POLICE_NUMBER1, total_amount_insured1,company2,formule2, formule_name2,POLICE_NUMBER2, total_amount_insured2,company3,formule3, formule_name3,POLICE_NUMBER3, total_amount_insured3,";
		sqlstmt = sqlstmt
				+ " company4,formule4,formule_name4,POLICE_NUMBER4, total_amount_insured4,company5,formule5, formule_name5,POLICE_NUMBER5, total_amount_insured5,company6,formule6, formule_name6,POLICE_NUMBER6, total_amount_insured6,";
		sqlstmt = sqlstmt
				+ " company7,formule7,formule_name7,POLICE_NUMBER7, total_amount_insured7,company8,formule8, formule_name8,POLICE_NUMBER8,total_amount_insured8,";
		sqlstmt = sqlstmt + " crewmanning, period_insurance, family_covered,";
		sqlstmt = sqlstmt
				+ " nationality, country, children, monthly_salary, salary_currency,  niveau, wycc_id, start_movement, end_movement,";
		sqlstmt = sqlstmt + "dateofnextmvt, dateofprevmvt, rankmvt, rankparent, nextmvt)";
		sqlstmt = sqlstmt + " select ? lv1, m.positioncrew,  m.name,  m.first_name,  m.structure_name,";
		sqlstmt = sqlstmt
				+ "  m.company1,m.formula1,m.formule_name1,m.POLICY_NUMBER1, m.total_amount_insured1, m.company2,m.formula2, m.formule_name2,m.POLICY_NUMBER2, m.total_amount_insured2, m.company3,m.formula3, m.formule_name3,m.POLICY_NUMBER3, m.total_amount_insured3,";
		sqlstmt = sqlstmt
				+ "  m.company4,m.formula4,m.formule_name4,m.POLICY_NUMBER4, m.total_amount_insured4, m.company5,m.formula5, m.formule_name5,m.POLICY_NUMBER5, m.total_amount_insured5, m.company6,m.formula6, m.formule_name6,m.POLICY_NUMBER6, m.total_amount_insured6,";
		sqlstmt = sqlstmt
				+ "  m.company7,m.formula7,m.formule_name7,m.POLICY_NUMBER7, m.total_amount_insured7, m.company8,m.formula8, m.formule_name8,m.POLICY_NUMBER8, m.total_amount_insured8,";
		sqlstmt = sqlstmt
				+ "					 '' as crewmanning,  m.period_insurance,  m.family_covered,  m.nationality,  m.country,";
		sqlstmt = sqlstmt
				+ "					  m.children,  m.monthly_salary,  m.salary_currency,   m.rankmvt as niveau,";
		sqlstmt = sqlstmt + "					  m.wycc_id,";
		sqlstmt = sqlstmt
				+ "					 case when ( m.start_movement < timestamp '2016-01-01 00:00:00.0') then timestamp '2016-01-01 00:00:00.0' else  m.start_movement end as start_movement,";
		sqlstmt = sqlstmt
				+ "					 case when ( m.end_movement > timestamp '2016-12-31 00:00:00.0') then timestamp '2016-12-31 00:00:00.0' else  m.end_movement end as end_movement,";
		sqlstmt = sqlstmt
				+ "					  m.dateofnextmvt,  m.dateofprevmvt,  m.rankmvt,  m.rankparent,  m.nextmvt";
		sqlstmt = sqlstmt + "		from PUBLIC.mvt_num m where nextmvt = ? ";
		sqlstmt = sqlstmt + "";
		return sqlstmt;
	}

	public String Selectbeneficiairies() {
		String sqlstmt = " SELECT BENEFICIARIES_ID";
		sqlstmt = sqlstmt + ",WYCC_ID";
		sqlstmt = sqlstmt + ",NAME";
		sqlstmt = sqlstmt + ",FIRST_NAME";
		sqlstmt = sqlstmt + ",LINE";
		sqlstmt = sqlstmt + ",STRUCTURE_NAME";
		sqlstmt = sqlstmt + ",FAMILY_COVERED";
		sqlstmt = sqlstmt + ",CHILDREN";
		sqlstmt = sqlstmt + ",NATIONALITY";
		sqlstmt = sqlstmt + ",COUNTRY";
		sqlstmt = sqlstmt + ",POSITIONCREW";
		sqlstmt = sqlstmt + ",START_MOVEMENT";
		sqlstmt = sqlstmt + ",PREVMVT";
		sqlstmt = sqlstmt + ",ENDCOMP";
		sqlstmt = sqlstmt + ",END_MOVEMENT";
		sqlstmt = sqlstmt + ",NEXTMVT";
		sqlstmt = sqlstmt + ",NEXTCOMP";
		sqlstmt = sqlstmt + ",MONTHLY_SALARY";
		sqlstmt = sqlstmt + ",SALARY_CURRENCY";
		sqlstmt = sqlstmt + ",DRESTEJ";
		sqlstmt = sqlstmt + ",ERESTEJ";
		sqlstmt = sqlstmt + ",TO_INVOICE";
		sqlstmt = sqlstmt + ",JOUR";
		sqlstmt = sqlstmt + ",MOIS";
		sqlstmt = sqlstmt + " FROM PUBLIC.BENEFICIARIES";
		return sqlstmt;
	}

}
