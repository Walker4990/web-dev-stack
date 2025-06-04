/*
    함수 : 컬럼 값을 읽어서 가공된 값을 반환
    - 단일행 함수 : N개의 값을 받아서 N개의 결과 반환
    - 그룹 함수 : N개의 값을 받아서 1개의 결과 반환
    
    >> 단일행 함수와 그룹 함수는 SELECT 절에서 함께 사용할 수 없음
    >> 함수를 사용할 수 있는 위치 : SELECT, WHERE, ORDER BY, GROUP BY, HAVING
*/
-- 단일행 함수 
/*
    문자 처리 함수 
    
    LENGTH : 문자 수 반환
    - 한글 1글자 -> 1
    - 영문자/숫자/특수문자 -> 1
    
    LENGTHB :  바이트 수 반환
    - 한글 1글자 -> 3
    - 영문자/숫자/특수문자 -> 1
*/
SELECT 
    LENGTH('데이터베이스'), LENGTHB('데이터베이스'),
    LENGTH('DATABASE'), LENGTHB('DATABASE')
FROM DUAL; -- 가상의 테이블 생성


--    INSTR(컬럼, 찾을 문자, 시작 위치, 몇번째)
--    - 특정 문자가 몇 번재 위치하는지 반환
--    - 없으면 0을 반환
--    - 시작위치 : 1 (앞에서부터), -1 (뒤에서부터)

SELECT
    INSTR('AABAACAABBAA', 'B', -1, 2), -- 뒤에서부터 2번째에있는 B
    INSTR('AABAACAABBAA', 'D')
FROM DUAL;

-- USER_INFO에서 각 전화번호(CONTACT)에서 앞에서부터 5가 들어간 위치 조회
SELECT NAME, INSTR(CONTACT, 5)
FROM USER_INFO;

-- EMPLOYEE에서 's'가 포함되어 있는 이메일 중 @ 위치 조회
SELECT EMP_NAME, EMAIL, INSTR(EMAIL, '@')
FROM EMPLOYEE
WHERE EMAIL LIKE '%s%';

/*
    LPAD / RPAD (컬럼, 최종적으로 반환할 문자의 길이, 덧붙이고자 하는 문자)
    - 문자열을 조회 시 통일감 있게 조회하고자 할 때 사용
*/

SELECT 
    LPAD('HELLO', 10), LPAD('HELLO', 10, 'A'),
    RPAD('HELLO', 10), RPAD('HELLO', 10, 'A')
FROM DUAL;

/*
    LTRIM / RTRIM (컬럼, 제거할 문자들)
    - 문자열에서 특정문자를 제거한 나머지를 반환
*/
SELECT LTRIM('     K H     '), -- 왼쪽 공백 제거
       LTRIM('ACBAACCCKH', 'ABC'), -- 왼쪽에서 ABC에 해당하는 문자들 제거
       RTRIM('465485KH54568', '0123456789') -- 오른쪽에서 해당하는 숫자들 제거
FROM DUAL;

/*
    TRIM(LEADING|TRAILING|BOTH 제거 하고자 하는 문자들 FROM 컬럼)
    - 문자열의 양쪽(앞/뒤)에 있는 지정한 문자들을 제거한 나머지 문자열 반환
*/
SELECT
    TRIM(LEADING 'Z' FROM 'ZZZKHZZZ'), -- LTRIM과 같다.
    TRIM(TRAILING 'Z' FROM 'ZZZKHZZZ'), --RTRIM과 같다.
    TRIM(BOTH 'Z' FROM 'ZZZKHZZZ'), -- LTRIM + RTRIM
    TRIM('          KH          ') -- 앞뒤 공백제거
FROM DUAL;

/*
    SUBSTR(컬럼, 시작 위치, 추출 길이)
    -문자열에서 특정 부분을 잘라서 추출
*/
SELECT 
    SUBSTR('PROGRAMMING', 5, 2),
    SUBSTR('PROGRAMMING', 1, 6),
    SUBSTR('PROGRAMMING', -8, 3)
FROM DUAL;

-- USER_INFO에서 전화번호(CONTACT)에서 가운데 번호 4자리만 조회
SELECT SUBSTR(CONTACT, INSTR(CONTACT, '-')+1, 4) 
FROM USER_INFO;

-- EMPLOYEE에서 이메일에서 아이디만 조회
SELECT EMAIL, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1), REPLACE(EMAIL, '@kh.or.kr')
FROM EMPLOYEE;

-- 주민등록번호(EMP_NO)를 000000-0******로 조회
SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO, 1, 8), 14, '*'),
        SUBSTR(EMP_NO,1,8)||'******',
        REPLACE(EMP_NO, SUBSTR(EMP_NO, -6,6), '******')
FROM EMPLOYEE;

--남자 사원들만 조회
SELECT EMP_NAME 
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = 1;

SELECT *
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, INSTR(EMP_NO, '-') + 1, 1) = 1;

/*
    LOWER : 다 소문자로 변경
    UPPER : 다 대문자로 변경
*/
SELECT LOWER('Welcome'), UPPER('Welcome')
FROM DUAL;

/*
    CONCAT : 문자열 두개를 전달 받아 하나로 합친 후 결과 반환
    (문자열, 문자열) 딱 두개만 가능
*/
SELECT CONCAT('가나다라',1234), '가나다라'||1234
FROM DUAL;

--가나다라, ABCD, 1234를 합치기
SELECT '가나다라'||'ABCD'||'1234', CONCAT(CONCAT('가나다라','ABCD'),1234)
FROM DUAL;

/*
    REPLACE(컬럼, 바꾸고 싶은 문자열, 바꿀 문자열)
    - 특정 문자열로 변경
*/
SELECT REPLACE('서울시 강남구 역삼동', '역삼동', '삼성동') FROM DUAL;

-- USER_INFO에서 서울인 사람들을 모두 경기로 변경
SELECT REPLACE(ADDRESS, '서울', '경기')
FROM USER_INFO;

--EMPLOYEE에서 사원들의 이메일 kh.or.kr을 gamil.com으로 바꾸기
SELECT REPLACE(EMAIL, 'kh.or.kr', 'gmail.com')
FROM EMPLOYEE;

/*
    숫자 처리 함수
    
    ABS : 절대값 반환
    MOD(숫자1, 숫자2) : 나머지 반환
    CEIL : 올림, FLOOR : 내림
*/
SELECT 
        ABS(5.7), ABS(-10), 
        MOD(7, 2), 
        CEIL(123.152), FLOOR(123.952),
        SIGN(10), SIGN(0), SIGN(-10)
FROM DUAL;

/*
    ROUND(숫자, 위치)
    - 반올림한 결과 반환
    - 위치 생략시 0
*/
SELECT
    ROUND(123.456),
    ROUND(123.456, 1), -- 위치: 소숫점 자릿수
    ROUND(123.456, -2) -- 정수 1의 자리가 -1
FROM DUAL;

/*
    TRUNC(숫자, 위치)
    - 위치 지정해서 버림 처리
*/
SELECT 
    TRUNC(123.952, 1),
    TRUNC(123.952)
FROM DUAL;

/*
    날짜 처리 함수
    
    SYSDATE : 시스템의 날짜를 반환(현재 날짜)
    
*/
SELECT SYSDATE FROM DUAL;

-- 날짜 포맷 변경 
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';

/*
    MONTHS_BETWEEN(날짜1, 날짜2)
    - 입력받은 두 날짜 사이의 개월 수 반환
    날짜1 - 날짜2
    
*/
SELECT FLOOR(MONTHS_BETWEEN('20251216', SYSDATE))
FROM DUAL;

--USER_INFO에서 몇개월 생인지

SELECT FLOOR(MONTHS_BETWEEN(SYSDATE, BIRTHDATE))
FROM USER_INFO;

/*
    ADD_MONTHS(날짜, 숫자)
    - 특정 날짜에 입력받는 숫자만큼 개월 수를 더한 날짜 반환
*/
SELECT ADD_MONTHS(SYSDATE, 2) FROM DUAL;

-- USER_INFO 에서 해당 태어난 날짜부터 20년이 지났을 경우
SELECT ADD_MONTHS(BIRTHDATE, 12*20)
FROM USER_INFO;

/*
    NEXT_DAY(날짜, 요일(문자/숫자))
    -특정 날짜에서 구하려는 요일의 가장 가까운 날짜 리턴
    - 1 - 일, 2- 월, 3 - 화 ... 7 - 토
*/
SELECT NEXT_DAY(SYSDATE, 'MONDAY') FROM DUAL;
SELECT NEXT_DAY(SYSDATE, '월요일') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '금') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE,1) FROM DUAL;

-- 언어 변경
ALTER SESSION SET NLS_LANGUAGE = KOREAN;
ALTER SESSION SET NLS_LANGUAGE = ENGLISH;

/*
    LAST_DAY(날짜)
    -해당 월의 마지막 날짜 반환
*/
SELECT LAST_DAY(SYSDATE), LAST_DAY('20250724'),LAST_DAY('2025/12/16') FROM DUAL;

/*
    EXTRACT(YEAR|MONTH|DAY FROM 날짜)
    - 특정 날짜에서 연도, 월, 일 정보 추출
*/
-- USER_INFO에서 BIRTHDATE로 연도, 월, 일 따로 조회
SELECT EXTRACT(YEAR FROM BIRTHDATE), EXTRACT(MONTH FROM BIRTHDATE), EXTRACT(DAY FROM BIRTHDATE)
FROM USER_INFO;

/*
    형 변환 함수
    
    TO_CHAR(날짜|숫자, 포맷)
    - 날짜 또는 숫자형 데이터를 문자 타입으로 변환
*/

SELECT TO_CHAR(1234, 'L99,999') FROM DUAL; -- 현재 설정된 화폐 단위에 따라 바뀜

ALTER SESSION SET NLS_CURRENCY = '$';

-- EMPLOYEE에서 연봉을 TO_CHAR를 이용해서 조회(,)
SELECT TO_CHAR(SALARY*12, '999,999,999') 연봉 -- 포맷자리수가 더 크거나 같아야 금액이 나옴.
FROM EMPLOYEE
ORDER BY 연봉;

-- 날짜 -> 문자
SELECT 
    TO_CHAR(SYSDATE, 'YYYY'), --년 YY, RR, RRRR 다 가능
    TO_CHAR(SYSDATE, 'MM'), --월 : MON, MONTH 다 가능
    TO_CHAR(SYSDATE, 'DD'), --일 : D : 주, DD : 월, DDD : 년 기준,
    TO_CHAR(SYSDATE, 'DY'), --요일 : DY, DAY
    TO_CHAR(SYSDATE, 'PM HH:MI:SS'), -- AM/PM
    TO_CHAR(SYSDATE, 'HH24:MI:SS') -- HH24 AM/PM과 혼용가능
FROM DUAL;

-- BIRTHDATE를 '2025년 06월 04일 수요일' 포맷으로 조회
SELECT 
TO_CHAR(BIRTHDATE, 'YYYY')|| '년' 
|| TO_CHAR(BIRTHDATE, 'MM')||'월'
|| TO_CHAR(BIRTHDATE, 'DD')||'일'
|| TO_CHAR(BIRTHDATE, 'DAY')
FROM USER_INFO;

SELECT TO_CHAR(BIRTHDATE, 'YYYY"년" MM"월" DD"일" DAY') FROM USER_INFO;


/*
    TO_DATE(숫자|문자, 포맷)
    -숫자 또는 문자형 데이터를 날짜 타입으로 변환
*/
-- 숫자 -> 날짜
SELECT TO_DATE(20250604) FROM DUAL;
SELECT TO_DATE(20250605164230) FROM DUAL;

--문자 -> 날짜
SELECT TO_DATE('20250604') FROM DUAL;
SELECT TO_DATE('20250605164230') FROM DUAL;

/*
    TO_NUMBER(문자, 포맷)
    -문자형 데이터를 숫자 타입으로 변환
    
*/
SELECT TO_NUMBER('100000'+'50000') FROM DUAL; --묵시적 형 변환

SELECT 
    TO_NUMBER('100,000', '999,999') + 
    TO_NUMBER('550,000','999,999')
FROM DUAL; -- 명시적 형 변환

-- 이미지, 동영상들은 직접 DB에 저장하지 않고, 스토리지의 경로(문자)가 들어간다.

/*
    NVL/COALESCE(값1, 값2)
    - 값1이 NULL이 아니면 값1을 반환하고, 값1이 NULL이면 값2 반환
*/
--USER_INFO에서 MBTI가 NULL인 경우 'MBTI 모름' 처리
SELECT NVL(MBTI, 'MBTI 모름')
FROM USER_INFO;

-- COALESCE(값1, 값2, 값3, ...)
-- MBTI 가 NULL이 아니면 MBTI, NULL이면 HOBBY, 이것 또한 NULL이면 '모름'
SELECT COALESCE(MBTI, HOBBY, '모름') FROM USER_INFO;

/*
    NVL2(값1, 값2, 값3)
    - 값1 NULL이 아니면 값2, NULL이면 값3
*/
--EMPLOYEE 에서 부서코드 (DEPT_CODE)가 있으면 '부서있음', 없으면 '부서없음'

SELECT NVL2(DEPT_CODE, '부서있음', '부서없음') FROM EMPLOYEE;

/*
    NULLIF(값1, 값2)
    - 두 개의 값이 동일하면 NULL, 동일하지 않으면 값1 리턴
*/
SELECT NULLIF('123', '123'), NULLIF('123', '456') 
FROM DUAL;

/*
    선택 함수 : 여러 가지 경우에 선택할 수 있는 기능을 제공
    
    DECODE(대상, 조건값1, 결과값1, 조건값2, 결과값2, ...)
    - 비교하고자 하는 값이 조건값과 일치하는 경우 그에 해당하는 결과값 반환
*/
-- EMPLOYEE에서 주민번호 (EMP_NO)로 성별(남, 여) 조회
SELECT 
SUBSTR(EMP_NO, 8, 1),
DECODE (SUBSTR(EMP_NO, 8, 1), 1, '남', 2, '여')
FROM EMPLOYEE;





































