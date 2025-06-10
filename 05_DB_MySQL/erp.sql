/*
	DB 모델링
    1. 개념적 모델링
		- ENTITY(테이블) 추출
        - 엔터티 간의 관계 설정
    2. 논리적 모델링
     - 속성(컬럼) 추출
     - 정규화 작업 (1, 2, 3) ---> 이 이상으로 가면 반정규화
    3. 물리적 모델링
	 - 테이블 실질적으로 작성 (CREATE 문 작성)
     - 
        
	* 정규화 (NOMALIZATION)
    - 불 필요한 데이터를 중복을 제거하여 데이터 모델을 구조화 하는것
    - 효율적인 자료 저장 및 데이터 무결성을 보장하고 오류를 최소화하여 안정성을 보장하기 위해 적용함
    
    제 1 정규화 : 복수의 속성값을 갖는 속성을 분리
    제 2 정구화 : 주식별자에 종속되지 않는 속성ㅇ을 분리
    제 3 정규화 : 속성에 종속적인 속성을 제거
    
*/

/*
	- * 과제 * -
	사용자 or 사원 관련 정보 들어가는 테이블 하나 CREATE 문 작성해서 제출
    PRIMARY KEY : AUTO_INCREMENT 추가
    MySQL
    - 데이터 타입
    1. 문자 
		- CHAR/**VARCHAR** : 고정/가변 길이 문자, 반드시 크기 지정
		- TEXT : 매우 긴 문자열을 저장하는데 사용
	2. 숫자
		- **INT** : 정수값 저장하는데 사용
        - FLOAT / DOUBLE : 부동소수점 저장하는데 사용
        - DECIMAL : 고정소수점 저장하는데 사용
	3. 날짜 및 시간
		- **DATE** : 날짜 저장하는데 사용
        - TIME : 시간 저장하는데 사용
        - **DATETIME** / TIMESTAMP : 날짜와 시간을 함께 저장 (DEFAULT NOW())
	4. BOOLEAN
		- BOOLEAN / BOOL : 참(TRUE) / 거짓(FALSE) 값을 저장하는데 사용
	5. 이진 자료형
		- BLOB : 이진 데이터를 사용하는데 사용, 이미지나 동영상과 같은 이진 파일
		---> 실제로는 이미지나 동영상은 따로 관리 (URL만 문자형으로 저장)
*/
/*
- * 과제 * -
	사용자 or 사원 관련 정보 들어가는 테이블 하나 CREATE 문 작성해서 제출
*/

CREATE TABLE USER_INFO(
	USER_NO INT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(20) NOT NULL,
    ID VARCHAR(50) UNIQUE NOT NULL,
    PW VARCHAR(300) NOT NULL,
    PHONE VARCHAR(50) UNIQUE,
    EMAIL VARCHAR(100) UNIQUE,
    BIRTH_DATE DATE,
    GENDER VARCHAR(10) CHECK (GENDER IN ('남','여')),
    ADDRESS VARCHAR(200),
    HIRE_DATE DATE DEFAULT (CURRENT_DATE),
    QUIT_DATE DATE,
    DEPT_NO INT,
    GRADE_NO INT
);
   -- PW 같은 경우 암호화 돼서 들어가기때문에 길게 잡아야함.
   
   CREATE TABLE DEPARTMENT(
		DEPT_NO INT PRIMARY KEY AUTO_INCREMENT,
		DEPT_NAME VARCHAR(100) NOT NULL
   );
   CREATE TABLE GRADE(
		GRADE_NO  INT PRIMARY KEY AUTO_INCREMENT,
		GRADE_NAME VARCHAR(100) NOT NULL
    );
    
-- DEPT_NO, GRADE_NO
ALTER TABLE USER_INFO ADD
	FOREIGN KEY (DEPT_NO) REFERENCES DEPARTMENT(DEPT_NO);

ALTER TABLE USER_INFO ADD
	FOREIGN KEY (GRADE_NO) REFERENCES GRADE(GRADE_NO);
-- 효율성 때문에 테이블 다 만들고 FOREIGN KEY 처리

-- ** 과제 **
-- 프로젝트 관리 : 테이블 몇개든 상관없이 짜보고, FOREIGN KEY까지 걸어보는 것까지!
-- 테이블 필요한 컬럼 짜기 힘들면 어떤 기능이 있어야 되는지 정도로 제출

CREATE TABLE PROJECT (
	PROJECT_ID INT PRIMARY KEY auto_increment,
    PROJECT_NAME VARCHAR(50) NOT NULL,
    PROJECT_MANAGER VARCHAR(30) NOT NULL UNIQUE,
    START_DATE DATE,
    END_DATE DATE,
    MEMBER VARCHAR(50) NOT NULL,
    STATUS VARCHAR(30) CHECK (STATUS IN ('진행 전','진행중','완료'))
);

CREATE TABLE PROJECT_MEMBER(
	MEMBER_ID INT PRIMARY KEY AUTO_INCREMENT,
    USER_ID INT NOT NULL,
    PROJECT_ID INT NOT NULL
);
CREATE TABLE PERSONAL_WORK(
	WORK_NO INT PRIMARY KEY auto_increment,
    PROJECT_ID INT,
    STATUS VARCHAR(30) CHECK (STATUS IN ('진행 전', '진행 중', '완료'))
);

ALTER TABLE PROJECT_MEMBER ADD FOREIGN KEY (USER_ID) REFERENCES USER_INFO(USER_NO);
ALTER TABLE PROJECT_MEMBER ADD FOREIGN KEY (PROJECT_ID) REFERENCES PROJECT(PROJECT_ID);


