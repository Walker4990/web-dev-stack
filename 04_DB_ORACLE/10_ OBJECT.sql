/*
    시퀀스(SEQUENCE)
    - 번호를 자동으로 생성하는 객체
    - 주로 PK 값 자동 생성

    CREATE SEQUENCE 시퀀스명
    START WITH 시작값 (DEFAULT 1)
    INCREMENT BY 증가값 (기본값 1)
    MAXVALUE 최대값 (기본값 큼)
    MINVALUE 최소값 (기본값 1)
    CYCLE | NOCYCLE (기본값 NOCYCLE) -- 값 순환 여부
    CACHE | NOCACHE (기본값 CACHE 20) -- 캐시메모리 할당여부;

    * 캐시메모리
    - 미리 발생된 값들을 생성해서 저장해두는 공간
    - 매번 호출될 때마다 새로 번호를 생성하는 게 아니라 캐시메모리 공간에 
        미리 생선된 값들을 가져다 쓸 수 있음 (속도가 빨라짐)
    - 접속이 해제되면 -> 캐시메모리에 미리 만들어 둔 번호들은 다 날라감.

    * 객체 명칭
    테이블명 : TB_
    시퀀스명 : SEQ_
    뷰명 : VW_
    트리거명 : TRG_
    */

CREATE SEQUENCE SEQ_EMPID
    START WITH 300
    INCREMENT BY 5
    MAXVALUE 310
    NOCYCLE
    NOCACHE;

-- 현재 계정이 소유하고 있는 시퀀스들의 구조를 보고자 할 때
SELECT * FROM USER_SEQUENCES;

/*
    시퀀스명.CURRVAL : 현재 시퀀스 값
    시퀀스명.NEXTVAL : 시퀀스값에 일정값을 증가시켜서 발생된 값
                      시퀀스명.CURRVAL + INCREMENT BY 값
*/

-- CURRVAL은 한번이라도 NEXTVAL가 수행하지 않으면 가져올 수 없음.
SELECT SEQ_EMPID.CURRVAL FROM DAUL;
-- MAXVALUE가 초과하고 NOCYCLE인 경우 에러
SELECT SEQ_EMPID.NEXTVAL FROM DUAL;

/*
    시퀀스 변경

    ALTER SEQUENCE 시퀀스명
    INCREMENT BY 증가값 
    MAXVALUE 최대값 
    MINVALUE 최소값 
    CYCLE | NOCYCLE  
    CACHE | NOCACHE 바이트크기;

    -> START WITH는 변경 불가
*/
ALTER SEQUENCE SEQ_EMPID
INCREMENT BY 10
MAXVALUE 400;

SELECT SEQ_EMPID.NEXTVAL FROM DUAL;

/*
    시퀀스 삭제
    DROP SEQUENCE 시퀀스명;
*/
DROP SEQUENCE SEQ_EMPID;

/*
    시퀀스 명 : SEQ_TEST
    시작값 : 300
    증가값 : 1
    최대값 : 1000
    순환 없음
    캐시사용 안함
*/
CREATE SEQUENCE SEQ_TEST
    START WITH 300
    INCREMENT BY 1
    MAXVALUE 1000
    NOCYCLE
    NOCACHE;

/*
    뷰(VIEW)
    - SELECT문을 저장할 수 있는 객체
    - 가상 테이블 (실제 데이터가 담겨있는 건 아님 -> 논리적인 테이블)
    - DML(INSERT, UPDATE, DELETE) 작업 가능 (단, 일부만)

    * 사용 목적
    - 편리성 : SELECT문의 복잡도 완화
    - 보안성 : 테이블의 특정 열을 노출하고 싶지 않은 경우
*/

-- '한국'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
SELECT * FROM EMPLOYEE;
SELECT * FROM LOCATION;
SELECT * FROM DEPARTMENT;
SELECT * FROM NATIONAL;

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_NAME, SALARY
FROM EMPLOYEE
    JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
    JOIN NATIONAL USING (NATIONAL_CODE)
WHERE NATIONAL_CODE ='KO';

-- '일본'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_NAME, SALARY
FROM EMPLOYEE
    JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
    JOIN NATIONAL USING (NATIONAL_CODE)
WHERE NATIONAL_CODE ='JP';

-- '증국'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_NAME, SALARY
FROM EMPLOYEE
    JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
    JOIN NATIONAL USING (NATIONAL_CODE)
WHERE NATIONAL_CODE ='CH';

/*
    뷰 생성
    
    CREATE OR REPLACE FORCE | NOFORCE VIEW 뷰명
    AS 서브쿼리 
    WITH CHECK OPTION 
    WITH READ ONLY;

    * VIEW 옵션들
    - OR REPLACE : 뷰 생성 시 기존에 중복된 이름의 뷰가 없다면 새로 뷰 생성,
                    기존에 중복된 이름의 뷰가 있다면 해당 뷰 변경
    - FORCE : 서브 쿼리에 기술된 테이블이 존재하지 않는 테이블이어도 뷰 생성
    - NOFORCE : 서브 쿼리에 기술된 테이블이 존재해야하만 뷰 생성 (기본값 NOFORCE)
    - WITH CHECK OPTION : 서브 쿼리에 기술 된 조건에 부합하지 않는 값으로 수정하는 경우 오류 발생
    - WITH READ ONLY : 뷰에 대해 조회만 가능 (DML 수행 불가)
*/

-- 관리자 계정으로 CREATE VIEW 권한 부여
ALTER SESSION SET CONTAINER = XEPDB1;
GRANT CREATE VIEW TO KH;

CREATE VIEW VW_EMPLOYEE
AS SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_NAME, SALARY
FROM EMPLOYEE
    JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
    JOIN NATIONAL USING (NATIONAL_CODE);

-- '한국'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
SELECT * FROM VW_EMPLOYEE
WHERE NATIONAL_NAME ='한국';

/*
    뷰 컬럼에 별칭을 부여해야 하는 경우
    - 서브쿼리의 SELECT절에 함수식이나 산술연산식이 기술 되어있을 경우 반드시 별칭 부여!
*/
-- 사원의 사번, 사원명, 직급명, 성별, 근무년수 조회
-- 뷰명 : VW_EMP_JOB

-- 1. 일부만 별칭 부여할 시 서브쿼리에서
CREATE OR REPLACE VIEW VW_EMP_JOB
    AS SELECT EMP_ID 사번, EMP_NAME 이름, JOB_NAME 직급명, 
        DECODE(SUBSTR(EMP_NO, 8, 1), 1, '남', 2, '여') 성별, 
        ROUND((SYSDATE- HIRE_DATE)/365) 근무년수
        -- EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) 근무년수
        FROM EMPLOYEE
            JOIN JOB USING(JOB_CODE);

-- 2. 뷰 생성시 모든 컬럼에 별칭 부여 
CREATE OR REPLACE VIEW VW_EMP_JOB("사번","사원명","직급명","성별","근무년수")
    AS SELECT EMP_ID , EMP_NAME , JOB_NAME, 
        DECODE(SUBSTR(EMP_NO, 8, 1), 1, '남', 2, '여'), 
        ROUND((SYSDATE- HIRE_DATE)/365) -- 이게 더 정확
        --EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) 근무년수
        FROM EMPLOYEE
            JOIN JOB USING(JOB_CODE);

-- 성별이 남자인 사원의 사원명, 직급명 조회
SELECT 사원명, 직급명 FROM VW_EMP_JOB
WHERE 성별 = '남';
-- 근무년수가 20년 이상인 사원 조회
SELECT 사원명, 근무년수 FROM VW_EMP_JOB
WHERE 근무년수 > 20;

/*
    VIEW를 이용해서 DML(INSERT, UPDATE, DELETE) 사용 가능
    - 뷰를 통해서 조작하게 되면 실제 데이터가 담겨 있는 베이스 테이블에 반영
*/
CREATE OR REPLACE VIEW VW_JOB
AS SELECT JOB_CODE, JOB_NAME FROM JOB;

-- INSERT
INSERT INTO VW_JOB VALUES('J8', '인턴');

-- UPDATE
UPDATE VW_JOB
SET JOB_NAME ='알바'
WHERE JOB_CODE = 'J8';


-- DELETE 
DELETE FROM VW_JOB
WHERE JOB_CODE ='J8';

SELECT * FROM JOB;

/*
    DML 구문으로 VIEW 조작이 불가능한 경우
*/
-- 1. 뷰 정의에 포함되지 않은 컬럼을 조작하는 경우
CREATE OR REPLACE VIEW VW_JOB
AS SELECT JOB_CODE FROM JOB;

-- INSERT
INSERT INTO VW_JOB VALUES('J8', '인턴'); -- 값의 수가 많아서!
INSERT INTO VW_JOB VALUES('J8');

SELECT * FROM JOB;
-- UPDATE
UPDATE VW_JOB
SET JOB_NAME ='알바'
WHERE JOB_CODE = 'J8'; -- JOB_NAME이 VIEW에 존재하지 않아서


-- DELETE 
DELETE FROM VW_JOB
WHERE JOB_CODE ='J8';

DELETE FROM VW_JOB
WHERE JOB_NAME ='사원';-- JOB_NAME이 VIEW에 존재하지 않아서

-- 2. 뷰에 포함되지 않은 컬럼 중에서 베이스가 되는 컬럼이 NOT NULL인 경우
CREATE OR REPLACE VIEW VW_JOB
AS SELECT JOB_NAME FROM JOB;

-- INSERT
INSERT INTO VW_JOB VALUES('인턴'); -- JOB_CODE가 NOT NULL 제약조건이 있어서

SELECT * FROM JOB;

-- UPDATE
UPDATE VW_JOB
SET JOB_NAME ='알바'
WHERE JOB_NAME = '사원'; -- JOB_NAME이 VIEW에 존재하지 않아서
ROLLBACK;

-- DELETE 
DELETE FROM VW_JOB
WHERE JOB_NAME ='사원';

-- 3. 산술표현식 또는 함수식으로 정의된 경우
-- 뷰명 : VW_EMP_SAL
-- 컬럼 : EMP_ID, EMP)NAME, SALARY, 연봉

CREATE OR REPLACE VIEW VW_EMP_SAL
    AS SELECT EMP_ID, EMP_NAME, SALARY, SALARY * 12 연봉
        FROM EMPLOYEE;



-- INSERT
INSERT INTO VW_EMP_SAL
VALUES ( 300, '최다인', 3000000, 36000000); -- 가상열은 사용할 수 없습니다.

ALTER TABLE EMPLOYEE MODIFY EMP_NO NULL;
INSERT INTO VW_EMP_SAL(EMP_ID, EMP_NAME, SALARY)
VALUES  (300, '최다인', 3000000); --  사용할 수 없습니다.

SELECT * FROM VW_EMP_SAL
WHERE EMP_ID = 300;

--UPDATE
-- 300번 사원의 연봉을 9600만으로

UPDATE VW_EMP_SAL
SET SALARY = 8000000
WHERE EMP_ID = 300;

--DELETE
DELETE FROM VW_EMP_SAL
WHERE 연봉 = 96000000;

ROLLBACK;

-- 4. 그룹함수나 GROUP BY절을 포함하는경우
-- 뷰명 : VW_GROUPDEPT
-- 컬럼 : 부서별 급여합계, 급여평균

CREATE OR REPLACE VIEW VW_GROUPDEPT("급여 합계", "급여 평균","부서 코드")
    AS SELECT SUM(SALARY), ROUND(AVG(SALARY)), DEPT_CODE
        FROM EMPLOYEE
        GROUP BY DEPT_CODE;

SELECT * FROM VW_GROUPDEPT;

-- INSERT
INSERT INTO VW_GROUPDEPT
VALUES ("D10",1000000, 100000); -- 그룹 함수들은 이미 계산된 함수식이기 때문에

INSERT INTO VW_GROUPDEPT(DEPT_CODE)
VALUES ("D0");

-- UPDATE
UPDATE VW_GROUPDEPT
SET "급여 합계" = 2000000
WHERE "부서코드" = 'D1';

-- DELETE
DELETE FROM VW_GROUPDEPT
WHERE "급여 합계" = 17700000;

DELETE FROM VW_GROUPDEPT
WHERE "DEPT_CODE" = 'D1';

-- 5. DISTINCT 구문이 포함된 경우
CREATE OR REPLACE VIEW VW_DT_JOB
AS SELECT DISTINCT JOB_CODE FROM EMPLOYEE;

-- INSERT 
INSERT INTO VW_DT_JOB
VALUES('J8');

-- UPDATE 
UPDATE VW_DT_JOB
SET JOB_CODE = 'J8'
WHERE JOB_CODE = 'J7';

-- DELETE 
DELETE FROM VW_DT_JOB
WHERE JOB_CODE = 'D1';

-- 6. JOIN을 이용해서 여러 테이블을 연결하는 경우
-- 뷰명 VW_JOINEMP
-- 컬럼 : EMP_ID, EMP_NAME, DEPT_TITLE
CREATE OR REPLACE VIEW VW_JOINEMP
AS SELECT EMP_ID, EMP_NAME, DEPT_TITLE
    FROM EMPLOYEE
       LEFT JOIN DEPARTMENT ON DEPT_CODE = DEPT_ID;

SELECT * FROM VW_JOINEMP;

-- INSERT
-- 조인 뷰에 의하여 기본테이블 이외에 컬럼을 수정하지 못한다.
INSERT INTO VW_JOINEMP VALUES(300, '문채은', '총무부');

INSERT INTO VW_JOINEMP(EMP_ID, EMP_NAME) VALUES(300, '문채은');

-- UPDATE
UPDATE VW_JOINEMP
SET EMP_NAME = '간성훈'
WHERE EMP_ID = 300;

UPDATE VW_JOINEMP
SET DEPT_TITLE = '인사관리부'
WHERE EMP_ID = 300;

-- DELETE
DELETE FROM VW_JOINEMP
WHERE DEPT_TITLE = '총무부';

ROLLBACK;

-- VIEW 옵션들
-- FORCE : 존재하지 않아도 일단 뷰부터 생성 가능 
-- NOFORCE(기본값) : 존재하는 테이블만 뷰가 생성됨.

-- 컴파일 오류와 함께 뷰가 생성되었습니다. -> 그래도 만들어짐
CREATE OR REPLACE FORCE VIEW VW_EMP
AS SELECT * FROM TEST;

CREATE TABLE TEST(
    TID NUMBER
);

-- WITH CHECK OPTION : 서브쿼리에 기술된 조건에 부합하지 않는 값으로 수정시 오류 발생
CREATE OR REPLACE FORCE VIEW VW_EMP
AS SELECT * FROM EMPLOYEE
    WHERE SALARY >= 3000000
WITH CHECK OPTION;

-- WITH CHECK OPTION이 있는 경우 해당 조건에 위배가 되어 변경 불가
-- 200번 사원의 급여를 200 -> 400만원으로 변경
UPDATE VW_EMP
SET SALARY = 4000000
WHERE EMP_ID = 200;

ROLLBACK;

SELECT * FROM VW_EMP;

-- WITH READ ONLY : 뷰에 대해 조회만 가능 (DML 수행불가)
CREATE OR REPLACE VIEW VW_DEPT
AS SELECT * FROM DEPARTMENT
WITH READ ONLY;

INSERT INTO VW_DEPT VALUES('D0', '개발부', 'L1');

UPDATE VW_DEPT
SET DEPT_TITLE = '디자인부'
WHERE DEPT_ID = 'D0';

SELECT * FROM VW_DEPT;

DELETE FROM VW_DEPT
WHERE DEPT_ID = 'D0';

/*
    INDEX 
    - SQL 명령문의 처리 속도를 향상시키기 위해서 행들의 위치 정보를 가지고 있다.

    * 데이터 검색 방식
    1. Table Full Scan : 테이블 데이터를 처음부터 끝까지 검색하여 원하는 데이터를 찾는 방식
    2. Index Scan : 인덱스를 통해 데이터를 찾는 방식
*/

-- 현재 인덱스 정보
SELECT * FROM USER_INDEXES;
SELECT * FROM USER_IND_COLUMNS;

-- 데이터가 얼마 없으면 오라클에서 굳이 인덱스 사용해서 데이터 조회 X
SELECT * 
FROM USER_INFO
WHERE USER_ID = 1;

SELECT * 
FROM USER_INFO
WHERE NAME = '간성훈';

/*
    INDEX 생성
    CREATE INDEX 인덱스명
    ON 테이블명(컬럼, 컬럼, ...);
*/
CREATE INDEX IDX_USER_NAME
ON USER_INFO(NAME);

CREATE INDEX IDX_USER_ID_NAME
ON USER_INFO(USER_ID, NAME); -- 결합인덱스 생성

-- 인덱스 삭제
DROP INDEX IDX_USER_ID_NAME;

/*
    동의어(SYNONYM)
    - 데이터베이스 객체에 별칭을 생성

    CREATE PUBLIC SYNONYM 동의어명
    FOR 사용자.객체명;
*/
-- 관리자계정에서 권한부여
ALTER SESSION SET CONTAINER = XEPDB1;
GRANT CREATE SYNONYM TO KH;
 -- KH 계정
CREATE SYNONYM EMP
FOR EMPLOYEE;

SELECT * FROM EMP;

-- 관리자 계정으로 접속해서 공개 SYNONYM 생성
CREATE PUBLIC SYNONYM DEPT FOR KH.DEPARTMENT;

-- TEST 계정 생성하고 권한부여
ALTER SESSION SET CONTAINER = XEPDB1;
CREATE USER TEST IDENTIFIED BY TEST;
GRANT CONNECT, RESOURCE TO TEST;
GRANT SELECT ON KH.DEPARTMENT TO TEST;

SELECT * FROM DEPT;








