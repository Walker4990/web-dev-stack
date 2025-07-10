CREATE TABLE person(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    age INT,
    addr VARCHAR(200)
);

CREATE TABLE member(
	id VARCHAR(100) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE bank(
	name VARCHAR(100),
    balance INT
);
INSERT INTO bank VALUES('지은', 100000);
INSERT INTO bank VALUES('지연', 0);

drop table book;
CREATE TABLE book(
	book_no INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(50) NOT NULL,
    access_age INT DEFAULT 0
);
drop table member;
CREATE TABLE member(
	id VARCHAR(100) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    pwd VARCHAR(200) NOT NULL,
    age INT NOT NULL
    );
    
    DROP TABLE rent;
CREATE TABLE rent(
	rent_no INT PRIMARY KEY AUTO_INCREMENT,
    id VARCHAR(100),
    book_no INT ,
    rent_date DATE DEFAULT (CURRENT_DATE)
    );
    
    SELECT * FROM information_schema.table_constraints WHERE table_name = 'rent';
    ALTER TABLE rent DROP CONSTRAINT rent_ibfk_1;
ALTER TABLE rent ADD FOREIGN KEY (id) REFERENCES member(id);
ALTER TABLE rent ADD FOREIGN KEY (book_no) REFERENCES book(book_no);

select * from book;
select * from member;