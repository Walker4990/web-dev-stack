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
DROP TABLE PROJECT_MEMBERS;
DROP TABLE USER_INFO;
DROP TABLE DEPARTMENT;
DROP TABLE GRADE;
DROP TABLE PROJECT_TASKS;
DROP TABLE PROJECT;





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
		DEPT_NAME VARCHAR(100) NOT NULL,
        DEPT_COLOR VARCHAR(50)
   );
   CREATE TABLE GRADE(
		GRADE_NO  INT PRIMARY KEY AUTO_INCREMENT,
		GRADE_NAME VARCHAR(100) NOT NULL
    );
    


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
DROP TABLE PERSONAL_WORK;


-- 강사님 VER
CREATE TABLE PROJECT (
	PRO_NO INT AUTO_INCREMENT PRIMARY KEY,
	PRO_NAME VARCHAR(100) NOT NULL,
    PRO_DESC TEXT,
    START_DATE DATE,
    END_DATE DATE,
    STATUS VARCHAR(10) CHECK (STATUS IN ('진행 전', '진행 중', '완료','중단'))
);
CREATE TABLE PROJECT_MEMBERS (
	MEMBER_NO INT AUTO_INCREMENT PRIMARY KEY,
    USER_NO INT,
    PRO_NO INT,
    ROLE VARCHAR(50)
);

-- 프로젝트 : 업무들 = 1:M
CREATE TABLE PROJECT_TASKS(
	TASK_NO INT AUTO_INCREMENT PRIMARY KEY,
    PRO_NO INT,
    TASK_NAME VARCHAR(100),
    TASK_DESC TEXT,
    STATUS VARCHAR(30) CHECK (STATUS IN ('진행 전', '진행 중', '완료','중단')),
	START_DATE DATE,
    END_DATE DATE,
    PARENT_TASK_NO INT
);


    
--  ** 과제 **
-- 일정 관리!

-- 내가 한것
create table schedules(
	schedule_id int primary key auto_increment,
    title varchar(100) not null, -- 스케줄 이름
    description text, -- 세부 내용
    start_date date, -- 시작 일자
    end_date date,  -- 마감 일자
    schedule_type varchar(10) check (schedule_type in ('내근','외근','회의')), -- 근무 타입
    pro_no int, -- 프로젝트 일정 연결
    task_no int -- 개인 업무 일정 연결
    
);

ALTER TABLE SCHEDULES ADD FOREIGN KEY (PRO_NO) REFERENCES PROJECT(PRO_NO);
ALTER TABLE SCHEDULES ADD FOREIGN KEY (TASK_NO) REFERENCES PROJECT_TASKS(TASK_NO);

-- 강사님 VER.
CREATE TABLE SCHEDULE (
	SCHEDULE_NO INT AUTO_INCREMENT PRIMARY KEY,
    SCHEDULE_TITLE VARCHAR(100) NOT NULL,
    SCHEDULE_DESC TEXT, 
    START_DATE DATE,
    END_DATE DATE,
    STATUS VARCHAR(30) CHECK (STATUS IN ('진행 전', '진행 중', '완료','중단')),
    LOCATION VARCHAR(200),
    PRO_NO INT,
    TASK_NO INT,
    USER_NO INT
    );

CREATE TABLE SCHEDULE_MEMBERS(
	SCH_MEM_NO INT AUTO_INCREMENT PRIMARY KEY,
    USER_NO INT,
    SCHEDULE_NO INT
);
-- DEPT_NO, GRADE_NO
ALTER TABLE USER_INFO ADD
	FOREIGN KEY (DEPT_NO) REFERENCES DEPARTMENT(DEPT_NO);
ALTER TABLE USER_INFO ADD
	FOREIGN KEY (GRADE_NO) REFERENCES GRADE(GRADE_NO);

-- PROJECT_MEMBERS :USER_NO, PRO_NO 
ALTER TABLE PROJECT_MEMBERS ADD
	FOREIGN KEY (USER_NO) REFERENCES USER_INFO(USER_NO);
ALTER TABLE PROJECT_MEMBERS ADD
	FOREIGN KEY (PRO_NO) REFERENCES PROJECT(PRO_NO);
    
-- PROJECT_TASKS : PRO_NO
ALTER TABLE PROJECT_TASKS ADD
	FOREIGN KEY (PRO_NO) REFERENCES PROJECT(PRO_NO);

-- SCHEDULE : PRO_NO, TASK_NO, USER_NO
ALTER TABLE SCHEDULE ADD
	FOREIGN KEY (PRO_NO) REFERENCES PROJECT(PRO_NO);
ALTER TABLE SCHEDULE ADD
	FOREIGN KEY (TASK_NO) REFERENCES PROJECT_TASKS(TASK_NO);
ALTER TABLE SCHEDULE ADD
	FOREIGN KEY (USER_NO) REFERENCES USER_INFO(USER_NO);
-- SCHEDULE_MEMBERS : SCHEDULE_NO
ALTER TABLE SCHEDULE_MEMBERS ADD 
FOREIGN KEY (SCHEDULE_NO) REFERENCES SCHEDULE(SCHEDULE_NO);

-- 고객관계관리, 인적자원관리, 재무관리, 품질보증관리
-- 가장 해볼만 하다 싶은거 1개 OR 여러개 해도 괜찮음

-- 고객관계관리
CREATE TABLE CRM(
User
- id (PK)
- name
- email
- role (담당자, 관리자 등)

Customer
- id (PK)
- name
- company
- contact
- email
- type (VIP, 일반, 신규 등)
- user_id (FK)

InteractionLog
- id (PK)
- customer_id (FK)
- user_id (FK)
- date
- content

Sales
- id (PK)
- customer_id (FK)
- user_id (FK)
- amount
- status (진행중, 완료 등)
- expected_close_date
);

