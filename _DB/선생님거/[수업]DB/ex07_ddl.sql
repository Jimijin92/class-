/*

ex07_ddl.sql

DML
 - 데이터 조작어(SELECT, INSERT, UPDATE, DELETE)
 - SELECT : DQL(Data Query Language)

DDL
 - 데이터 정의어
 - DB Object(테이블, 뷰, 프로시저, 인덱스, 트리거 등..) 생성/삭제하는 명령어
 - CREATE : 만들기
 - DROP : 삭제
 - ALTER : 수정(부분)


테이블 생성하기

CREATE TABLE 테이블명
(
	컬럼 정의,
	컬럼 정의,
	컬럼 정의,
	컬럼 정의,
	컬럼명 자료형(길이) 제약사항
);

*/

CREATE  TABLE tbltest
(
	num number(3),
	txt varchar2(10),
	regdate date
);

SELECT * FROM tbltest;

INSERT INTO tbltest (num, txt, regdate) VALUES (100, 'test', '2018-01-16');

/*
제약 사항, Constraint
- 컬럼값에 대한 조건(규칙) -> 만족 못하면 데이터를 못 넣는다. -> 데이터 유효성 유지
- 데이터베이스 무결성 보장(Integrity Contstraint Rule - 무결성 제약 조건)

1. NOT NULL
- 반드시 컬럼값을 기재(필수 입력값)
- 컬럼 레벨로만 정의 가능
*/

-- 메모 테이블
CREATE TABLE tblmemo
(
	seq NUMBER NULL, --일련번호 + 필수입력
	name VARCHAR2(20) NULL, --글쓴이
	memo VARCHAR2(1000) NULL, --메모내용
	regdate DATE NULL --작성 시간
);

INSERT INTO tblmemo (seq, name, memo, regdate)
	VALUES (1, '홍길동', '메모입니다.', sysdate);

INSERT INTO tblmemo (seq, name, memo, regdate)
	VALUES (2, '홍길동', '메모입니다.', NULL);

INSERT INTO tblmemo (seq, name, memo, regdate)
	VALUES (3, '홍길동', NULL , NULL);

INSERT INTO tblmemo (seq, name, memo, regdate)
	VALUES (4, NULL , NULL , NULL);

INSERT INTO tblmemo (seq, name, memo, regdate)
	VALUES (NULL , NULL , NULL , NULL); -- 이런 행동을 할 확률 0%

SELECT * FROM tblmemo;

DROP TABLE  tblmemo;

CREATE TABLE tblmemo
(
	seq NUMBER NOT NULL, --일련번호 + 필수입력
	name VARCHAR2(20) NULL, --글쓴이
	memo VARCHAR2(1000) NOT  NULL, --메모내용
	regdate DATE NULL --작성 시간
);

INSERT INTO tblmemo (seq, name, memo, regdate)
	VALUES (1, '홍길동', '메모입니다.', sysdate);

INSERT INTO tblmemo (seq, name, memo, regdate)
	VALUES (2, '홍길동', '메모입니다.', NULL);

--ORA-01400: cannot insert NULL into ("HR"."TBLMEMO"."MEMO")
INSERT INTO tblmemo (seq, name, memo, regdate)
	VALUES (3, '홍길동', NULL , NULL);

INSERT INTO tblmemo (seq, name, memo, regdate)
	VALUES (3, NULL , '메모' , NULL);

INSERT INTO tblmemo (seq, name, memo, regdate)
	VALUES (NULL, NULL , '메모' , NULL);


/*
1. NOT NULL

2. PRIMARY KEY(PK)
- 기본 키
- 키(key) : 컬럼
- 테이블내의 모든 컬럼들을 대표(?)하는 컬럼 -> 행과 행을 구분하는 수단으로 사용
- 테이블내에서 행을 구분하기 위한 고유 식별자(PK 컬럼의 값은 테이블내에 유일해야 한다.)
- 1개의 테이블에는 반드시(***) PK가 존재해야 한다.
	a. 행과 행을 구분하기 위해서..
	b. PK는 1개 이상 정의 가능(2개 이상 PK -> 기본키 역할 -> 복합기(Composite Key))
- PK는 자동으로 NOT NULL이 적용된다.
- PK는 자동으로 NOT Duplicate가 적용된다. -> UNIQUE
- NOT NULL + UNIQUE = PK

*/


DROP TABLE  tblmemo;

CREATE TABLE tblmemo
(
	seq NUMBER PRIMARY KEY, --중복X, 생략X, 테이블의 유일한 식별자 컬럼 -> PK
	name VARCHAR2(20) NULL,
	memo VARCHAR2(1000) NOT  NULL,
	regdate DATE NULL
);

INSERT INTO tblmemo (seq, name, memo, regdate)
	VALUES (1, '홍길동', '메모입니다.', sysdate);

-- ORA-00001: unique constraint (HR.SYS_C007064) violated
INSERT INTO tblmemo (seq, name, memo, regdate)
	VALUES (1, '홍길동', '메모입니다.', sysdate);

INSERT INTO tblmemo (seq, name, memo, regdate)
	VALUES (2, '홍길동', '메모입니다.', sysdate);

INSERT INTO tblmemo (seq, name, memo, regdate)
	VALUES (NULL, '홍길동', '메모입니다.', sysdate);


-- 특정 행 1개를 지정할 때는 반드시 PK를 조건으로 건다.(******)n
SELECT * FROM tblmemo
	WHERE seq = 1; -- 내가 원하는 메모 1개 지정



SELECT * FROM tblinsa;



/*
3. UNIQUE
- 해당 컬럼값이 테이블내에서 유일한 값이어야 한다.(중복값이 있어서는 안된다.)
- NULL을 가질 수 있다.
- 식별자로 사용하면 절대 안된다!!!!!!(NULL 이 있기 때문에)
*/

DROP TABLE  tblmemo;

CREATE TABLE tblmemo
(
	seq NUMBER PRIMARY KEY,
	name VARCHAR2(20) UNIQUE,
	memo VARCHAR2(1000) NOT  NULL,
	regdate DATE NULL
);

INSERT INTO tblmemo (seq, name, memo, regdate)
	VALUES (1, '홍길동', '메모입니다.', sysdate);

INSERT INTO tblmemo (seq, name, memo, regdate)
	VALUES (2, '아무개', '메모입니다.', sysdate);

INSERT INTO tblmemo (seq, name, memo, regdate)
	VALUES (NULL, '홍길동', '메모입니다.', sysdate);

INSERT INTO tblmemo (seq, name, memo, regdate)
	VALUES (4, NULL, '메모입니다.', sysdate);

INSERT INTO tblmemo (seq, name, memo, regdate)
	VALUES (5, NULL, '메모입니다.', sysdate);

SELECT * FROM tblmemo;


/*
4. check
- 열거형, 범위 비교 등의 제약
- where절 유사
*/
DROP TABLE  tblmemo;

CREATE TABLE tblmemo
(
	seq NUMBER PRIMARY KEY,
	name VARCHAR2(20) UNIQUE,
	memo VARCHAR2(1000) NOT  NULL,
	--regdate DATE NULL,
	--color VARCHAR2(20) NOT NULL , -- red, yellow, blue
	--page NUMBER(1) NOT NULL -- 1 ~ 9
	color VARCHAR2(20) CHECK (color IN ('red', 'yellow', 'blue')) NOT NULL ,
	--page NUMBER(1) CHECK (page >= 1 and page <= 9) NOT NULL
	page NUMBER(1) CHECK (page BETWEEN 1 AND 9) NOT NULL,

	-- 날짜 기간 제약
	--regdate date CHECK (regdate BETWEEN '2018-01-15' AND '2018-01-31')
-- 	regdate date CHECK (
-- 		regdate BETWEEN to_date('2018-01-15', 'yyyy-mm-dd')
-- 						AND to_date('2018-01-31', 'yyyy-mm-dd'))

	-- 오전에만 가능
	--regdate date CHECK (to_char(regdate, 'hh24') BETWEEN 0 AND 11) NOT NULL

	-- 토,일요일에만 가능
	regdate date CHECK (to_char(regdate, 'd') in (1, 7)
				  			AND to_char(regdate, 'hh24') BETWEEN 0 AND 11) not NULL

);


INSERT INTO tblmemo (seq, name, memo, regdate, color, page)
	VALUES (1, '홍길동', '메모입니다.', sysdate, 'blue', 1);

INSERT INTO tblmemo (seq, name, memo, regdate, color, page)
	VALUES (2, '아무개', '메모입니다.', sysdate, 'white', 1);

INSERT INTO tblmemo (seq, name, memo, regdate, color, page)
	VALUES (2, '아무개', '메모입니다.', sysdate, 'blue', -1);

INSERT INTO tblmemo (seq, name, memo, regdate, color, page)
	VALUES (1, '홍길동', '메모입니다.', sysdate, 'blue', 1);

INSERT INTO tblmemo (seq, name, memo, regdate, color, page)
	VALUES (2, '아무개', '메모입니다.'
		, to_date('2018-01-20 10:05:50', 'yyyy-mm-dd hh24:mi:ss'), 'blue', 1);


/*
5. default
- 컬럼 기본값
- 해당 컬럼에 값을 넣지 않으면 NULL을 입력하지 말고, 자동으로 미리 준비된 값을 넣어라
*/
DROP TABLE  tblmemo;

CREATE TABLE tblmemo
(
	seq NUMBER PRIMARY KEY,
	name VARCHAR2(20) DEFAULT '익명' NULL,
	memo VARCHAR2(1000) NOT  NULL,
	regdate DATE DEFAULT sysdate NULL
);

INSERT INTO tblmemo (seq, name, memo, regdate)
	VALUES (1, '홍길동', '메모입니다.', sysdate);

INSERT INTO tblmemo (seq, name, memo, regdate)
	VALUES (2, NULL, '메모입니다.', sysdate);

INSERT INTO tblmemo (seq, memo)
	VALUES (3, '메모입니다.');

SELECT * FROM tblmemo;




/*

제약 사항을 만드는 방법

1. 컬럼 수준에서 만드는 방법
	- 컬럼에 직접 제약 거는 방법(1:1)
	- 컬럼명 자료형 제약조건
	- 컬럼명 자료형 constraint 제약명 제약조건

2. 테이블 수준에서 만드는 방법
*/
DROP TABLE tblmemo;

CREATE TABLE tblmemo
(
	--seq NUMBER PRIMARY KEY
	--seq NUMBER CONSTRAINT aaa PRIMARY KEY,
	seq NUMBER CONSTRAINT tblmeno_seq_pk PRIMARY KEY,
	memo varchar2(1000) CONSTRAINT tblmemo_memo_ck
				  CHECK (length(memo) >= 20) NOT NULL
);

CREATE TABLE tblmemo
(
	seq number,
	memo varchar2(1000) NOT NULL ,
	color varchar2(20),
	page number(1),

	CONSTRAINT tblmemo_seq_pk PRIMARY KEY(seq),
	CONSTRAINT tblmemo_color_ck CHECK (color in ('white', 'black')),
	CONSTRAINT tblmemo_page_ck CHECK (page BETWEEN 1 AND 9)
);

INSERT INTO tblmemo (seq, memo) VALUES (1, '메모입니다.');
INSERT INTO tblmemo (seq, memo, color, page) VALUES (1, '메모입니다.', 'white', 1);
INSERT INTO tblmemo (seq, memo, color, page) VALUES (2, '메모입니다.', 'blue', 1);
INSERT INTO tblmemo (seq, memo, color, page) VALUES (2, '메모입니다.', 'black', -1);
















