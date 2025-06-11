/*
    서브쿼리(SUBQUERY)
    - 하나의 SQL문 안에 포함된 또 다른 SQL문
*/
-- 노옹철 사원의 부서코드 조회
SELECT DEPT_CODE, EMP_NAME
FROM EMPLOYEE
WHERE EMP_NAME = '노옹철'; -- D9

-- 부서코드가 D9인 사원들 조회
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- 노옹철 사원과 같은 부서원들 조회
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '노옹철');

-- 전 직원의 평균 급여보다 더 많은 급여를 받는 사원들 조회
SELECT EMP_NAME
FROM EMPLOYEE
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE);

-- 계산 해보고 서브쿼리 짜는거 추천

/*
    서브쿼리의 종류
    - 서브쿼리를 수행한 결과 값이 몇 행 몇 열이냐에 따라서 분류
    - 서브쿼리의 종류에 따라 서브쿼리 앞에 붙는 연산자가 달라짐

    1. 단일행 서브쿼리
    - 서브쿼리의 조회 결과 값의 개수가 딱 한개일 때 (한 행, 한 열)
    - 일반 비교연산자 사용가능 : =, !=, >, <, >=, <=

   
*/
-- 노옹철 사원의 급여보다 더 많이 받는 사원들 조회
SELECT *
FROM EMPLOYEE
WHERE SALARY > (SELECT SALARY FROM EMPLOYEE WHERE EMP_NAME = '노옹철');

-- 부서별 급여의 합이 가장 큰 부서의 부서코드, 급여 합 조회
SELECT MAX(SUM(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE; --17700000

SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) = (
  SELECT MAX(SUM(SALARY))
  FROM EMPLOYEE
  GROUP BY DEPT_CODE
);

-- 전지연 사원이 속해 있는 부서원들 조회 (단, 전지연 제외)

SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME ='전지연'; -- D1

SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME ='전지연')
AND EMP_NAME != '전지연';

/*
    2. 다중 행 서브쿼리
    - 서브쿼리 조회 결과 값의 개수가 여러 행 일 때 (여러 행 한 열)

    IN 서브쿼리 : 여러 개의 결과 값 중에서 한 개라도 일치하는 값이 있다면 
*/
-- 각 부서별 최고 급여를 받는 사원들 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY IN (SELECT MAX(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE)
ORDER BY SALARY DESC;

SELECT *
FROM EMPLOYEE E
WHERE SALARY = (SELECT MAX(SALARY)
                  FROM EMPLOYEE
                  WHERE DEPT_CODE = E.DEPT_CODE);

-- 사원에 대해 사번, 이름, 부서코드, 구분(사수/사원) 조회
-- 사수이면 MANAGER_ID의 EMP_ID값이 있는경우 / 사원이면 없는 경우

SELECT * FROM EMPLOYEE;

SELECT EMP_ID, EMP_NAME, DEPT_CODE, MANAGER_ID,
    CASE 
        WHEN MANAGER_ID IS NULL THEN '사수'
        ELSE '사원' END "구분"
FROM EMPLOYEE;

--  CASE 
--         WHEN MANAGER_ID = EMP_ID THEN '사원'
--         WHEN MANAGER_ID != EMP_ID THEN '사수'
--         END 구분

SELECT *
FROM EMPLOYEE;

SELECT EMP_ID, EMP_NAME, DEPT_CODE, MANAGER_ID,
    CASE WHEN MANAGER_ID IS NULL THEN '사수'
        ELSE '사원'
        END AS 구분
FROM EMPLOYEE;

SELECT DISTINCT MANAGER_ID
FROM EMPLOYEE
WHERE MANAGER_ID IS NOT NULL; -- 누군가의 사수인 사람들

-- 서브쿼리 SELECT절에서도 사용할 수 있다.
SELECT EMP_ID, EMP_NAME, DEPT_CODE, MANAGER_ID,
    CASE WHEN EMP_ID IN (SELECT DISTINCT MANAGER_ID
                FROM EMPLOYEE
                WHERE MANAGER_ID IS NOT NULL) THEN '사수'
        ELSE '사원'
        END AS 구분
FROM EMPLOYEE;

/*
    비교대상 > ANY(서브쿼리) : 여러개의 결과 값 중에서 "한개라도" 클 경우
                            (=여러 개의 결과 값 중에서 가장 작은 값보다 클 경우)
    비교대상 < ANY(서브쿼리) : 여러개의 결과 값 중에서 "한개라도" 작을 경우
                            (=여러 개의 결과 값 중에서 가장 큰 값보다 클경우)
*/                          

-- 대리 직급임에도 불구하고 과장 직급들의 최소 급여보다 많이 받는 직원의 사번, 이름, 직급명, 급여 조회

SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '대리'
AND SALARY > ANY (SELECT SALARY 
                    FROM EMPLOYEE JOIN JOB USING (JOB_CODE)
                   WHERE JOB_NAME = '과장');

--  위아래 둘다 가능 --
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '대리'
AND SALARY > (SELECT MIN(SALARY) 
                    FROM EMPLOYEE JOIN JOB USING (JOB_CODE)
                   WHERE JOB_NAME = '과장');

/*
     비교대상 > ALL(서브쿼리) : 여러개의 "모든" 결과 값들보다 클 경우
     비교대상 < ALL(서브쿼리) : 여러개의 "모든" 결과 값들보다 작을 경우
*/
-- 과장 직급임에도 차장 직급의 최대 급여보다 더 많이 받는 직원들 조회

SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '과장'
AND SALARY > ALL(SELECT SALARY
                   FROM EMPLOYEE JOIN JOB USING (JOB_CODE)
                  WHERE JOB_NAME = '차장');


SELECT EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '과장'
AND SALARY > (SELECT MAX(SALARY)
                FROM EMPLOYEE JOIN JOB USING (JOB_CODE)
               WHERE JOB_NAME = '차장');

/*
    3. 다중 컬럼 서브쿼리
    - 서브쿼리의 조회 결과 값이 한 행이지만 컬럼이 여러개일 때 (한 행 여러 열)
*/
-- 하이유 사원과 같은 부서코드, 같은 직급코드에 해당하는 사원들 조회

SELECT DEPT_CODE, JOB_CODE, EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME = '하이유')
AND JOB_CODE = (SELECT JOB_CODE FROM EMPLOYEE WHERE EMP_NAME = '하이유');


SELECT DEPT_CODE, JOB_CODE, EMP_NAME
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE 
                                 FROM EMPLOYEE 
                                WHERE EMP_NAME = '하이유');

/*
    4. 다중행 다중컬럼 서브쿼리
    - 서브쿼리의 조회 결과 값이 여러 행, 여러 열일 경우
*/

-- 각 직급별로 최소 급여를 받는 사원들의 사번, 이름, 직급 코드, 급여 조회

SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (SALARY, JOB_CODE) IN (SELECT MIN(SALARY), JOB_CODE
                   FROM EMPLOYEE
                    GROUP BY JOB_CODE);

/*
    인라인 뷰 - 페이징과 연결되어 있음
    - FROM 절에 서브쿼리를 제시하고, 서브쿼리를 수행한 결과를 테이블 대신 사용
*/
-- 전 직원 중 급여가 가장 높은 상위 5명 순위, 이름, 급여 조회
-- ROWNUM : 오라클에서 제공하는 컬럼, 조회된 순서대로 1부터 순번 부여
-- > 정렬하기 전에 순번을 매김.
SELECT ROWNUM, SALARY, EMP_NAME
FROM EMPLOYEE
ORDER BY SALARY DESC;

SELECT ROWNUM, EMP_NAME, SALARY
FROM (SELECT ROWNUM, SALARY, EMP_NAME
        FROM EMPLOYEE
        ORDER BY SALARY DESC)
WHERE ROWNUM <= 5;

-- 부서별 평균 급여가 높은 3개 부서의 부서 코드, 평균 급여 조회

SELECT ROUND(AVG(SALARY)) AVG_SAL, DEPT_CODE
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY AVG_SAL DESC;



-- ROUND(AVG(SALARY)) 두번 사용 불가능해서 별칭 부여 후 
-- 서브쿼리에 있는 별칭 메인 쿼리에 같이 사용함.
SELECT ROWNUM, AVG_SAL, DEPT_CODE
FROM (SELECT ROUND(AVG(NVL(SALARY,0))) AVG_SAL, DEPT_CODE
        FROM EMPLOYEE
        GROUP BY DEPT_CODE
        ORDER BY AVG_SAL DESC)
WHERE ROWNUM <= 3;

-- WITH 사용 (TOP N QUERY)

WITH TOPN_SAL AS (
    SELECT ROUND(AVG(NVL(SALARY,0))) AVG_SAL, DEPT_CODE
        FROM EMPLOYEE
        GROUP BY DEPT_CODE
        ORDER BY AVG_SAL DESC
)
SELECT DEPT_CODE, AVG_SAL
FROM TOPN_SAL
WHERE ROWNUM <= 3;

/*
    RANK 함수
    - RANK() OVER(정렬 기준) : 동일한 순위 이후의 등수를 동일한 인원수만큼 건너뛰고 순위 계산
    EX) 공동 1위 2명 -> 그다음 순위 3위
    - DENSE_RANK() OVER(정렬 기준) : 동일한 순위 이후의 등수를 무조건 1씩 증가
    EX)공동 1위 2명 -> 그다음 순위 2위
*/
-- 사원별 급여가 높은 순서대로 조회

SELECT 
    RANK() OVER(ORDER BY SALARY DESC),
    EMP_NAME, SALARY
FROM EMPLOYEE;

SELECT 
    DENSE_RANK() OVER(ORDER BY SALARY DESC),
    EMP_NAME, SALARY
FROM EMPLOYEE;

-- 상위 5명만 조회
SELECT
     RANK, EMP_NAME, SALARY
FROM (SELECT 
    RANK() OVER(ORDER BY SALARY DESC) RANK,
    EMP_NAME, SALARY
FROM EMPLOYEE)
WHERE RANK <= 19;

-- RANK, ROWNUM 동순위 출력 하고 안하고의 차이

/*
    LAG / LEAD 함수
    - LAG(컬럼) OVER(정렬기준) : 이전 행의 값을 현재 기준으로
    - LEAD(컬럼) OVER(정렬기준) : 다음 행의 값을 현재 기준으로

    --> 행 간의 데이터를 비교하거나 변화하는 걸 분석하고자 할 때
*/

SELECT 
    EMP_NAME, SALARY,
    LAG(SALARY) OVER(ORDER BY SALARY DESC),
    LEAD(SALARY) OVER(ORDER BY SALARY DESC)
FROM EMPLOYEE;

-- 이전 사원과의 급여 차이 조회
SELECT EMP_NAME, SALARY,
    LAG(SALARY) OVER(ORDER BY SALARY DESC) ,
     LAG(SALARY) OVER(ORDER BY SALARY DESC) - SALARY
FROM EMPLOYEE;

-- 다음 사원과의 급여차이 조회
SELECT EMP_NAME, SALARY,
    LEAD(SALARY) OVER(ORDER BY SALARY DESC),
    SALARY - LEAD(SALARY) OVER(ORDER BY SALARY DESC)
FROM EMPLOYEE;

-- 페이징 처리(기존 방식)
-- 1페이지
SELECT ROWNUM, E.*
FROM (SELECT * FROM EMPLOYEE) E
WHERE ROWNUM <= 10;

-- 2페이지
SELECT *
FROM (SELECT ROWNUM NUM, E.*
        FROM (SELECT * FROM EMPLOYEE) E
        WHERE ROWNUM <= 20)
WHERE NUM >= 11;

-- 오라클 이전 버전 사용 불가
SELECT *
FROM EMPLOYEE
OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY;
--   시작 위치           자르는 개수


-- 키워드 검색
-- 테이블 : USER_INFO, REVIEW, MOVIE, ACTOR, MOVIE_ACTOR

-- 1. 국제시장을 감독한 감독의 다른 영화 조회
SELECT TITLE
FROM MOVIE
WHERE DIRECTOR IN (SELECT DIRECTOR
                FROM MOVIE
                WHERE TITLE = '국제시장')
AND TITLE != '국제시장';


-- 2. 서울에 사는 사용자들이 리뷰를 남긴 영화 조회
SELECT USER_ID, ADDRESS, "COMMENT" 
FROM REVIEW 
    JOIN MOVIE USING(MOVIE_ID)
    JOIN USER_INFO USING(USER_ID)
WHERE ADDRESS IN (SELECT ADDRESS
                    FROM USER_INFO 
                    WHERE ADDRESS LIKE '서울%');

-- 3. 봉준호 감독 영화 중 평균 평점이 3.0 이상인 영화 조회
SELECT TITLE, RATING
FROM MOVIE M
    JOIN REVIEW R ON M.MOVIE_ID = R.MOVIE_ID
WHERE RATING >= (SELECT AVG(RATING)
                FROM REVIEW R2
                    JOIN MOVIE M2 ON R2.MOVIE_ID = M2.MOVIE_ID
                WHERE DIRECTOR = '봉준호');


-- 4. 가장 리뷰 수가 많은 영화 조회
-- SELECT TITLE, COUNT(MOVIE_ID)
-- FROM (SELECT TITLE, COUNT(MOVIE_ID) CNT
--         FROM REVIEW
--         GROUP BY TITLE)
-- WHERE CNT = (SELECT MAX(CNT)
--              FROM REVIEW
--             GROUP BY TITLE)
-- GROUP BY TITLE;

--가장 많은 리뷰수
SELECT MAX(CNT) AS MAX_CNT
FROM (
    SELECT COUNT(*) AS CNT
    FROM REVIEW
    JOIN MOVIE USING (MOVIE_ID)
    GROUP BY TITLE
);

SELECT TITLE, COUNT(*)
FROM REVIEW JOIN MOVIE USING (MOVIE_ID)
GROUP BY TITLE
HAVING COUNT(*) = (
    SELECT MAX(CNT) AS MAX_CNT
FROM (
    SELECT COUNT(*) AS CNT
    FROM REVIEW
    JOIN MOVIE USING (MOVIE_ID)
    GROUP BY TITLE
)
);

SELECT USER_ID, NAME, ADDRESS FROM USER_INFO;
SELECT MOVIE_ID, USER_ID, RATING, "COMMENT" FROM REVIEW;
SELECT MOVIE_ID, TITLE, DIRECTOR FROM MOVIE;
SELECT ACTOR_ID, NAME FROM ACTOR;
SELECT MOVIE_ID, ACTOR_ID, ROLE FROM MOVIE_ACTOR;
-- 5. 전체 리뷰 평균 평점보다 높은 순으로 3위까지 영화 조회

-- 전체 리뷰 평균 평점
SELECT AVG(RATING) FROM REVIEW;

SELECT ROWNUM, RATING, RNK
FROM (
    SELECT RATING,
           RANK() OVER (ORDER BY RATING DESC) AS RNK
    FROM REVIEW
    WHERE RATING > (SELECT AVG(RATING) FROM REVIEW)
)
WHERE ROWNUM <= 3;















































































































































































































