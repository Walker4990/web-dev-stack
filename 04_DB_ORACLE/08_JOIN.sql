/*
    JOIN
    - 두 개 이상의 테이블에서 데이터를 조회하고자 할 때 사용되는 구문
    - 조회 결과는 하나의 결과물(RESULT SET)으로 나옴

    - 관계형 데이터베이스는 최소한의 데이터로 각각의 테이블에 담고 있음
      (중복을 최소화 하기 위해 최대한 쪼개서 관리함)
      부서 데이터는 부서 테이블, 사원 데이터는 사원 테이블

    만약에 어떤 사원이 어떤 부서에 속해있는지 부서명과 같이 조회하고 싶다면?
    => 즉, 관계형 데이터베이스에서 SQL문을 이용한 테이블 간에 "관계"를 맺어 원하는 데이터를 조회하는 방법

    "오라클 구문"과 "ANSI 구문"
    ANSI(미국국립표준협회 == 산업표준을 제정하는 단체)
*/

/*
    등가 조인(EQUAL JOIN) / 내부조인(INNER / NATURAL JOIN)
    - 연결시키는 컬럼의 값이 일치하는 행들만 조인되서 조회

    오라클 구문
    SELECT 컬럼, 컬럼, ...
    FROM 테이블1, 테이블2 
    WHERE 테이블1.컬럼 = 테이블2.컬럼;

    ANSI 구문
    SELECT 컬럼, 컬럼, ...
    FROM 테이블1
        JOIN 테이블2 ON(테이블1.컬럼 = 테이블2.컬럼);
    - FROM 절에서 기준이 테이블 기술
    - JOIN 절에서 같이 조회하고자 하는 테이블을 기술 후 매칭시킬
        컬럼에 대한 조건을 기술(USING || ON)
    
        --> 연결에 사용하는 컬럼명이 같은 경우 USING(컬럼명)

*/
-- EMPLOYEE, DEPARTMENT 조인해서 
-- 사번(EMP_ID), 사원명(EMP_NAME), 부서코드(DEPT_CODE), 부서명(DEPT_TITLE) 조회

-- 오라클 구문
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE E, DEPARTMENT D 
WHERE E.DEPT_CODE = D.DEPT_ID;

--ANSI 구문
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE E INNER JOIN DEPARTMENT D 
ON E.DEPT_CODE = D.DEPT_ID;

INSERT INTO DEPARTMENT (DEPT_ID, DEPT_TITLE, LOCATION_ID) VALUES('D1', '인사관리부', 'L1');

COMMIT;

-- 사번 (EMP_ID), 사원명(EMP_NAME), 직급코드(JOB_CODE), 직급명(JOB_NAME)
-- 테이블 : EMPLOYEE, JOB
-- 연결할 두 컬럼이 같은경우
-- 1. 테이블명을 이용
-- 오라클 구문
SELECT EMP_ID, EMP_NAME, JOB.JOB_CODE, JOB_NAME
FROM EMPLOYEE, JOB  
WHERE EMPLOYEE.JOB_CODE = JOB.JOB_CODE;

--ANSI구문
SELECT EMP_ID, EMP_NAME, JOB.JOB_CODE, JOB_NAME
FROM EMPLOYEE JOIN JOB  
ON (EMPLOYEE.JOB_CODE = JOB.JOB_CODE);

-- 2. 테이블에 별칭을 부여 해서 이용
SELECT EMP_ID, EMP_NAME, J.JOB_CODE, JOB_NAME
FROM EMPLOYEE E JOIN JOB J 
ON (E.JOB_CODE = J.JOB_CODE);

-- 3. 컬럼명이 같은 경우는 USING 사용 추천
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE JOIN JOB  
USING (JOB_CODE);

-- 자연조인 (NATURAL JOIN) : 각 테이블마다 동일한 컬럼이 한 개만 존재할 경우(추천X)
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE 
    NATURAL JOIN JOB;

-- 직급이 대리인 사원의 사번(EMP_ID), 이름(EMP_NAME), 직급명(JOB_NAME), 급여(SALARY) 조회
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE E JOIN JOB J
ON (E.JOB_CODE = J.JOB_CODE)
WHERE JOB_NAME = '대리';

SELECT * FROM EMPLOYEE;
SELECT * FROM JOB;

-- 부서가 인사관리부인 사원들의 사번, 이름, 보너스 조회
SELECT * FROM EMPLOYEE;
SELECT * FROM DEPARTMENT;

SELECT EMP_ID, EMP_NAME, BONUS
FROM EMPLOYEE E JOIN DEPARTMENT D
ON E.DEPT_CODE = D.DEPT_ID
WHERE DEPT_TITLE = '인사관리부';

-- DEPARTMENT 랑 LOCATION 참고해서 전체 부서의 부서코드, 부서명, 지역코드, 지역명 조회
SELECT * FROM DEPARTMENT;
SELECT * FROM LOCATION;

SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID, LOCAL_NAME
FROM DEPARTMENT D JOIN LOCATION L
ON D.LOCATION_ID = L.LOCAL_CODE;

-- 부서가 총무부가 아닌 사원들의 사원명, 급여 조회
SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE E JOIN DEPARTMENT D
ON E.DEPT_CODE = D.DEPT_ID
WHERE DEPT_TITLE <> '총무부';

/* 
    포괄조인 / 외부조인 (OUTER JOIN)
    - 두 테이블 간의 JOIN 시 일치하지 않은 행도 포함시켜서 조회가 가능
    - 단, 반드시 기준이 되는 테이블(컬럼)을 지정해야 한다.
*/

-- 사원명, 부서명 조회
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE 
    LEFT JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE);

--기준 삼는 테이블의 반대 테이블의 컬럼 뒤에 (+)
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_ID(+) = DEPT_CODE;

-- RIGHT JOIN
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE 
    RIGHT JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE);

-- FULL JOIN = LEFT + RIGHT -> MySQL에서 안씀
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE 
    FULL JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE);

/*
    비등가 조인(NON EQUAL JOIN)
    - 매칭시킬 컬럼에 대한 조건 작성시 '='(등호)를 사용하지 않는 조인문
        --> 값의 범위에 포함되는 행들을 연결하는 방식
    - ANSI 구문으로는 JOIN ON으로만 사용가능 (USING 사용 불가)
*/

-- 사원명, 급여, 급여레벨 조회 (ON BETWEEN 사용)
SELECT SAL_LEVEL, MIN_SAL, MAX_SAL FROM SAL_GRADE;

SELECT * FROM EMPLOYEE;

SELECT EMP_NAME, SALARY, SAL_LEVEL
FROM EMPLOYEE E JOIN SAL_GRADE S
ON (E.SALARY BETWEEN S.MIN_SAL AND S.MAX_SAL);

/*
    자체 조인(SELF JOIN)
    - 같은 테이블을 다시 한번 조인하는 경우 (자기 자신과 조인) -> 대댓글 기능
*/

-- 사원사번, 사원명, 사원부서코드, 사수사번, 사수명, 사수 부서코드 조회

SELECT EMP_ID, EMP_NAME, MANAGER_ID FROM EMPLOYEE;

SELECT E1.EMP_ID, E1.EMP_NAME, E1.DEPT_CODE, E2.EMP_ID, E2.EMP_NAME
FROM EMPLOYEE E1 JOIN EMPLOYEE E2
ON E2.EMP_ID = E1.MANAGER_ID;

/*
    카테시안 곱(CATESIAN PRODUCT) / 교차 조인(CROSS JOIN)
    - 조인되는 모든 테이블의 각 행들이 서로 모두 매핑된 데이터가 검색 (곱집합)
    - 두 테이블의 행들이 모두 곱해진 행들의 조합이 출력 -> 방대한 데이터 출력으로 과부하
*/

SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE CROSS JOIN DEPARTMENT; -- 23 * 9

/*
    다중 JOIN
    - 여러 개의 테이블을 조인하는 경우
*/

--사원명, 부서명, 직급명 조회
SELECT * FROM JOB;

SELECT E.EMP_NAME, D.DEPT_TITLE, J.JOB_NAME
FROM EMPLOYEE E JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
        JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE);

-- 국가명, 지역명, 직급명, 부서명, 사원명, 급여, 급여등급, 조회
-- NATIONAL, LOCATION, JOB, DEPARTMENT, EMPLOYEE, SAL_GRADE

SELECT NATIONAL_CODE, NATIONAL_NAME FROM NATIONAL;
SELECT LOCAL_CODE, NATIONAL_CODE, LOCAL_NAME FROM LOCATION;
SELECT JOB_CODE, JOB_NAME FROM JOB;
SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID FROM DEPARTMENT;
SELECT EMP_NAME, SALARY, DEPT_CODE, JOB_CODE FROM EMPLOYEE;
SELECT SAL_LEVEL, MIN_SAL, MAX_SAL FROM SAL_GRADE;


SELECT N.NATIONAL_NAME, L.LOCAL_NAME, J.JOB_NAME, D.DEPT_TITLE, E.EMP_NAME, E.SALARY, S.SAL_LEVEL
FROM EMPLOYEE E 
    JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
    JOIN JOB J ON E.JOB_CODE = J.JOB_CODE
    JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
    JOIN NATIONAL N ON (L.NATIONAL_CODE = N.NATIONAL_CODE)
    JOIN SAL_GRADE S ON (E.SALARY BETWEEN MIN_SAL AND MAX_SAL);


