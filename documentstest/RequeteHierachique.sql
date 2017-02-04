
with 
list (PositionCrew,name,first_name,structure_name,crewmanning,period,family_covered,nationality,country
      ,children,monthly_salary,rang,niveau,wycc_id,start_movement,end_movement,DATEOFNEXTMVT,DATEOFPREVMVT, RANKMVT, rankparent) as
( 
 Select PositionCrew,name,first_name,structure_name,'' crewmanning,period,family_covered,nationality,country,children,monthly_salary,
 MVT_NUM_ID rang,1 niveau, wycc_id, 
 CASE WHEN start_movement <PARSEDATETIME('01/01/2016','dd/MM/yyyy') THEN PARSEDATETIME('01/01/2016','dd/MM/yyyy') else start_movement END start_movement, 
 CASE WHEN end_movement >PARSEDATETIME('31/12/2016','dd/MM/yyyy') THEN PARSEDATETIME('31/12/2016','dd/MM/yyyy') else end_movement END end_movement,
 DATEOFNEXTMVT,DATEOFPREVMVT,RANKMVT,rankparent
 FROM MVT_NUM YT1  where nextmvt= 0 
 union all
 SELECT m.PositionCrew, m.name, m.first_name, m.structure_name,'' crewmanning, m.period, m.family_covered, m.nationality, m.country, m.children,m.monthly_salary,
 l.rang, niveau+1 niveau, m.wycc_id,
  CASE WHEN m.start_movement <PARSEDATETIME('01/01/2016','dd/MM/yyyy') THEN PARSEDATETIME('01/01/2016','dd/MM/yyyy') else m.start_movement END start_movement, 
 CASE WHEN m.end_movement >PARSEDATETIME('31/12/2016','dd/MM/yyyy') THEN PARSEDATETIME('31/12/2016','dd/MM/yyyy') else m.end_movement END end_movement,
 m.DATEOFNEXTMVT,m.DATEOFPREVMVT,m.RANKMVT,m.rankparent FROM MVT_NUM m
 join list l on (m.wycc_id=l.wycc_id and m.start_movement=l.DATEOFNEXTMVT ) WHERE   nextmvt != 0
 )
 select wycc_id,rang,min(niveau),PositionCrew,name,first_name,structure_name,crewmanning,period,family_covered,nationality,country,children,min(start_movement) , max(end_movement),
 Max(DATEOFNEXTMVT),min(DATEOFPREVMVT),max(end_movement)-min(start_movement) jour ,MONTH( max(end_movement))-MONTH(min(start_movement) )+1 mois,DAY_OF_MONTH(min(start_movement)) DresteJ, DAY_OF_MONTH(max(end_movement)) EresteJ,
 Sum( monthly_salary) monthly_salary
 from list  GROUP BY wycc_id,RANG,PositionCrew,name,first_name,structure_name,crewmanning,period,family_covered,nationality,country,children 
 ORDER BY 1,2,13;     
 
 SELECT wycc_id,end_movement-start_movement,monthly_salary,period,MONTH( start_movement)-MONTH( END_movement ) FROM MVT_NUM;
 
