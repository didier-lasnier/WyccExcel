DROP  VIEW LISTGROUP;

create
	view listgroup as select
		wycc_id,min( niveau ) as line,positioncrew,name,first_name,structure_name,
		crewmanning,period_insurance,family_covered,nationality,country,children,salary_currency,
		company1,formule_name1,total_amount_insured1,
		company2,formule_name2,total_amount_insured2,
		company3,formule_name3,total_amount_insured3,
		company4,formule_name4,total_amount_insured4,
		company5,formule_name5,total_amount_insured5,
		company6,formule_name6,total_amount_insured6,
		company7,formule_name7,total_amount_insured7,
		company8,formule_name8,total_amount_insured8,
		min( start_movement ) as start_movement, max( end_movement ) as end_movement,
		max( dateofnextmvt ) as nextmvt, min( dateofprevmvt ) as prevmvt,
		datediff( 'day', min( start_movement ), max( end_movement )) as jour,
		( month( max( end_movement ) )- month( min( start_movement ) ) ) as mois,
		dayofmonth( min( start_movement )) as drestej, dayofmonth( max( end_movement )) as erestej,
		sum( monthly_salary ) as monthly_salary
	from
		listmvthier
	group by wycc_id, positioncrew, name,
		first_name, structure_name, crewmanning,
		period_insurance, family_covered, nationality,
		country, children, salary_currency,
		company1,formule_name1, total_amount_insured1,
		company2,formule_name2, total_amount_insured2,
		company3,formule_name3, total_amount_insured3,
		company4,formule_name4, total_amount_insured4,
		company5,formule_name5, total_amount_insured5,
		company6,formule_name6, total_amount_insured6,
		company7,formule_name7, total_amount_insured7,
		company8,formule_name8, total_amount_insured8
	order by 1, 2, 3, 13;