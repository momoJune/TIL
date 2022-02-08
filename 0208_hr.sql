-- 문제 풀이

-- 31. 위치 ID 가 1700 인 부서에서 근무하는 사원들의 LAST_NAME, 부서 번호 및 JOB_ID 를 조회한다.
SELECT * FROM EMPLOYEES e ;
SELECT * FROM DEPARTMENTS d;

-- JOIN 이용
SELECT 
	LAST_NAME , d.DEPARTMENT_ID , d.DEPARTMENT_NAME , JOB_ID 
FROM 
	EMPLOYEES e , DEPARTMENTS d 
WHERE 
	e.DEPARTMENT_ID = d.DEPARTMENT_ID AND d.LOCATION_ID = 1700
ORDER BY 
	d.DEPARTMENT_ID , JOB_ID , LAST_NAME ;

-- 32. King 을 매니저로 두고 있는 모든 사원들의 LAST_NAME 및 연봉을 조회한다.
SELECT 
	LAST_NAME , SALARY 
FROM 
	EMPLOYEES e 
WHERE 
	MANAGER_ID IN (SELECT e2.EMPLOYEE_ID FROM EMPLOYEES e2 WHERE LAST_NAME='King');

-- 33. EXECUTIVE 부서에 근무하는 모든 사원들의 부서 번호, LAST_NAME, JOB_ID 를 조회한다.
SELECT 
	d.DEPARTMENT_ID , LAST_NAME , JOB_ID 
FROM 
	EMPLOYEES e , DEPARTMENTS d 
WHERE 
	e.DEPARTMENT_ID = d.DEPARTMENT_ID AND UPPER(d.DEPARTMENT_NAME) = 'EXECUTIVE'
ORDER BY 
	d.DEPARTMENT_ID , LAST_NAME, JOB_ID;

-- 34. 회사 전체 평균 연봉 보다 더 버는 사원들 중 LAST_NAME 에 u 가 있는 사원들이
--     근무하는 부서에서 근무하는 사원들의 사번, LAST_NAME 및 연봉을 조회한다.
SELECT DISTINCT DEPARTMENT_ID FROM EMPLOYEES e2  -- 부서아이디
		WHERE 
			SALARY > (SELECT avg(SALARY) avg_sal FROM EMPLOYEES) -- 평균연봉보다 연봉이 높은 사람중에
			AND 
			LAST_NAME LIKE '%u%'; -- 이름에 u자를 포함하는 사람

SELECT 
	e.EMPLOYEE_ID , e.LAST_NAME , e.SALARY 
FROM 
	EMPLOYEES e 
WHERE 
	DEPARTMENT_ID IN ( -- 가지고 있는 사원
		SELECT DISTINCT DEPARTMENT_ID FROM EMPLOYEES e2  -- 부서아이디 중복제거해서 조회
		WHERE 
			SALARY > (SELECT avg(SALARY) avg_sal FROM EMPLOYEES) -- 평균연봉보다 연봉이 높은 사람중에
			AND 
			LAST_NAME LIKE '%u%' -- 이름에 u자를 포함하는 사람
		);

-- 35. ST_CLERK 인 직업 ID 를 가진 사원이 없는 부서 ID 를 조회한다.
--     NULL 값은 제외한다. (NOT EXISTS 사용)
SELECT DEPARTMENT_ID , JOB_ID FROM EMPLOYEES e WHERE JOB_ID = 'ST_CLERK';	
SELECT DISTINCT DEPARTMENT_ID FROM EMPLOYEES e WHERE JOB_ID = 'ST_CLERK';	
-- NOT IN 조건에 서브쿼리 이용
SELECT 
	DISTINCT DEPARTMENT_ID 
FROM 
	EMPLOYEES e 
WHERE 
	DEPARTMENT_ID NOT IN (SELECT DISTINCT DEPARTMENT_ID FROM EMPLOYEES e WHERE JOB_ID = 'ST_CLERK')
	AND
	DEPARTMENT_ID IS NOT NULL
ORDER BY 
	1;
-- NOT EXISTS 사용 : 있으면 1, 없으면 NULL을 반환
SELECT 
	DISTINCT DEPARTMENT_ID 
FROM 
	EMPLOYEES e1
WHERE 
	NOT EXISTS (SELECT '' FROM EMPLOYEES e2 WHERE JOB_ID = 'ST_CLERK' AND e1.DEPARTMENT_ID=e2.DEPARTMENT_ID)
	AND
	DEPARTMENT_ID IS NOT NULL
ORDER BY 
	1;

SELECT 
	DISTINCT DEPARTMENT_ID 
FROM 
	EMPLOYEES e1
WHERE 
	NOT EXISTS (SELECT '1' FROM EMPLOYEES e2 WHERE JOB_ID = 'ST_CLERK' AND e1.DEPARTMENT_ID=e2.DEPARTMENT_ID)
	-- AND
	-- DEPARTMENT_ID IS NOT NULL  ---  이 조건을 생략하면 부서가 없는 행도 나온다.
ORDER BY 
	1;
-- 36. 위치한 부서가 없는 국가 ID 및 국가 이름을 조회힌다.(NOT EXISTS 사용)
SELECT DISTINCT l.COUNTRY_ID FROM LOCATIONS l , DEPARTMENTS d WHERE d.LOCATION_ID = l.LOCATION_ID 

SELECT 
	c.COUNTRY_ID, c.COUNTRY_NAME 
FROM 
	COUNTRIES c 
WHERE 
	COUNTRY_ID NOT IN (SELECT DISTINCT l.COUNTRY_ID FROM LOCATIONS l , DEPARTMENTS d WHERE d.LOCATION_ID = l.LOCATION_ID)
ORDER BY 
	c.COUNTRY_ID ;
	
-- NOT EXISTS 사용
SELECT 
	c.COUNTRY_ID , c.COUNTRY_NAME 
FROM 
	COUNTRIES c 
WHERE 
	NOT EXISTS (
			SELECT '1' 
			FROM LOCATIONS l, DEPARTMENTS d 
			WHERE c.COUNTRY_ID  = l.COUNTRY_ID AND l.LOCATION_ID IN (d.LOCATION_ID)
		)
ORDER BY 
	c.COUNTRY_ID;

-- 37. 기존의 직업을 여전히 가지고 있는 사원들의 사번 및 JOB_ID 를 조회한다.
SELECT 
	e.EMPLOYEE_ID , e.JOB_ID 
FROM 
	EMPLOYEES e 
WHERE 
	e.EMPLOYEE_ID NOT IN (
		SELECT 
			EMPLOYEE_ID 
		FROM 
			JOB_HISTORY j 
		WHERE 
			e.EMPLOYEE_ID  = j.EMPLOYEE_ID 
	);

