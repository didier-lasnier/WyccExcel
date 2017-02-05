CREATE OR REPLACE VIEW LISTMVT (WYCC_ID,RANG,LINE,POSITIONCREW,NAME,FIRST_NAME,STRUCTURE_NAME,CREWMANNING,PERIOD,FAMILY_COVERED,NATIONALITY,COUNTRY,CHILDREN,START_MOVEMENT,END_MOVEMENT,NEXTMVT,PREVMVT,JOUR,MOIS,DRESTEJ,ERESTEJ,MONTHLY_SALARY)
AS
SELECT WYCC_ID,RANG,LINE,POSITIONCREW,NAME,FIRST_NAME,STRUCTURE_NAME,CREWMANNING,PERIOD,FAMILY_COVERED,NATIONALITY,COUNTRY,CHILDREN,START_MOVEMENT,END_MOVEMENT,NEXTMVT,PREVMVT,JOUR,MOIS,DRESTEJ,ERESTEJ,MONTHLY_SALARY FROM ( 
with 
list (PositionCrew,name,first_name,structure_name,crewmanning,period,family_covered,nationality,country
      ,children,monthly_salary,rang,line,wycc_id,start_movement,end_movement,DATEOFNEXTMVT,DATEOFPREVMVT, RANKMVT, rankparent) as
( 
 Select PositionCrew,name,first_name,structure_name,'' crewmanning,period,family_covered,nationality,country,children,monthly_salary,
 MVT_NUM_ID rang,RANKMVT niveau, wycc_id, 
 CASE WHEN start_movement <PARSEDATETIME('01/01/2016','dd/MM/yyyy') THEN PARSEDATETIME('01/01/2016','dd/MM/yyyy') else start_movement END start_movement, 
 CASE WHEN end_movement >PARSEDATETIME('31/12/2016','dd/MM/yyyy') THEN PARSEDATETIME('31/12/2016','dd/MM/yyyy') else end_movement END end_movement,
 DATEOFNEXTMVT,DATEOFPREVMVT,RANKMVT,rankparent
 FROM MVT_NUM YT1  where nextmvt= 0 
 union all
 SELECT m.PositionCrew, m.name, m.first_name, m.structure_name,'' crewmanning, m.period, m.family_covered, m.nationality, m.country, m.children,m.monthly_salary,
 l.rang, m.RANKMVT niveau, m.wycc_id,
  CASE WHEN m.start_movement <PARSEDATETIME('01/01/2016','dd/MM/yyyy') THEN PARSEDATETIME('01/01/2016','dd/MM/yyyy') else m.start_movement END start_movement, 
 CASE WHEN m.end_movement >PARSEDATETIME('31/12/2016','dd/MM/yyyy') THEN PARSEDATETIME('31/12/2016','dd/MM/yyyy') else m.end_movement END end_movement,
 m.DATEOFNEXTMVT,m.DATEOFPREVMVT,m.RANKMVT,m.rankparent FROM MVT_NUM m
 join list l on (m.wycc_id=l.wycc_id and m.start_movement=l.DATEOFNEXTMVT ) WHERE   nextmvt != 0
 )
 select wycc_id,rang,min(line) line,PositionCrew,name,first_name,structure_name,crewmanning,period,family_covered,nationality,country,children,min(start_movement) start_movement , max(end_movement) end_movement,
 Max(DATEOFNEXTMVT) nextmvt ,min(DATEOFPREVMVT) prevmvt ,max(end_movement)-min(start_movement) jour ,MONTH( max(end_movement))-MONTH(min(start_movement) ) mois,DAY_OF_MONTH(min(start_movement)) DresteJ, DAY_OF_MONTH(max(end_movement)) EresteJ,
 Sum( monthly_salary) monthly_salary
 from list  GROUP BY wycc_id,RANG,PositionCrew,name,first_name,structure_name,crewmanning,period,family_covered,nationality,country,children 
 ORDER BY 1,2,3,13
 );     
  SELECT * FROM LISTMVT;
 SELECT wycc_id,end_movement-start_movement,monthly_salary,period,MONTH( start_movement)-MONTH( END_movement ) FROM MVT_NUM;
 
 SELECT WYCC_ID,NAME,FIRST_NAME,line,START_MOVEMENT,PREVMVT,DATEDIFF('DAY',start_Movement,DATEADD('DAY',-1, PARSEDATETIME(FORMATDATETIME( PREVMVT,'dd/MM/yyyy hh:mm:ss'),'dd/MM/yyyy' ) )) ENDCOMP ,
 END_MOVEMENT,NEXTMVT,(DATEDIFF('DAY',END_MOVEMENT, DATEADD('DAY', -1,PARSEDATETIME(FORMATDATETIME( NEXTMVT,'dd/MM/yyyy hh:mm:ss'),'dd/MM/yyyy' ))) )  NEXTCOMP
 ,MONTHLY_SALARY,DresteJ,EresteJ,
 ( CASE WHEN line=1 THEN ((MOIS+1))
                       ELSE mois 
                       END)+ 
     CASE WHEN line!=1 AND DATEDIFF('DAY',start_Movement,DATEADD('DAY',1, PARSEDATETIME(FORMATDATETIME( PREVMVT,'dd/MM/yyyy hh:mm:ss'),'dd/MM/yyyy' ) ))=0  THEN ROUND(( (30-DresteJ)/30.0),5)
 	  ELSE 0
 	  END +CASE WHEN  line!=1 AND (DATEDIFF('DAY',END_MOVEMENT, DATEADD('DAY', -1,PARSEDATETIME(FORMATDATETIME( NEXTMVT,'dd/MM/yyyy hh:mm:ss'),'dd/MM/yyyy' ))) ) =0 THEN ROUND(( EresteJ/30.0),5)
 	  ELSE 0
 	  END TO_INVOICE ,
 	  jour
FROM LISTMVT ORDER BY start_movement;

