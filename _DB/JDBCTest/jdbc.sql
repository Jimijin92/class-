-- C:\_Class\_DB\JDBCTest\jdbc.sql

SELECT * FROM tabs ORDER BY table_name asc;
SELECT * FROM tblmemo;

-- 메모 테이블
DROP TABLE tblmemo;

CREATE TABLE tblmemo (
	seq NUMBER PRIMARY KEY , --메모 번호
	name VARCHAR2(50) NOT NULL , --작성자
	memo VARCHAR2(1000) NOT NULL , --메모 내용
	regdate DATE DEFAULT sysdate NOT NULL , --작성 시간
	priority NUMBER(1) CHECK (priority BETWEEN 1 AND 3) NOT NULL --우선순위(1.높음 ~ 3.낮음)
);

DROP SEQUENCE memoseq;
CREATE SEQUENCE memoseq;


INSERT INTO tblmemo VALUES (memoseq.nextval, '홍길동', '홍길동''s House', default, 2);
INSERT INTO tblmemo VALUES (memoseq.nextval, '아무개', '안녕하세요. 아무개입니다.', default, 1);
INSERT INTO tblmemo VALUES (memoseq.nextval, '하하하', 'JDBC 수업 중입니다..', default, 3);

SELECT * FROM tblmemo;

COMMIT;

SELECT seq, name, to_char(regdate, 'hh24:mi:ss'), priority, memo FROM tblmemo ORDER BY seq DESC





SELECT seq, name, to_char(regdate, 'hh24:mi:ss') as regdate, CASE WHEN priority = 1 THEN '높음' WHEN priority = 2 THEN '중간' WHEN priority = 3 THEN '낮음' END as priority, memo FROM tblmemo WHERE memo like '%메모%' ORDER BY seq DESC;

SELECT * FROM tbladdress;




-- CallableStatement 예제 프로시저
-- m1()
CREATE or REPLACE PROCEDURE proc_m1(
	pname tbladdress.name%type,
	page tbladdress.age%type,
	ptel tbladdress.tel%type,
	paddress tbladdress.address%type
)
IS
BEGIN
	INSERT INTO tbladdress VALUES (address_seq.nextval, pname, page, ptel, paddress, default);
	COMMIT;
END;

select * from tbladdress;



-- m2()
CREATE OR REPLACE PROCEDURE proc_m2
IS
BEGIN



	DELETE FROM tbladdress;
	COMMIT;
	--truncate table tbladdress;
END;


-- m3()
-- 반환값
-- a. out 파라미터
-- b. return 문
CREATE OR REPLACE PROCEDURE proc_m3(
	vcount OUT NUMBER
)
IS
BEGIN
	SELECT count(*) INTO vcount FROM tbladdress;
END;

DECLARE
	vcount NUMBER;
BEGIN
	proc_m3(vcount);
	dbms_output.put_line(vcount);
END;


CREATE OR REPLACE PROCEDURE proc_m3(
	pname OUT VARCHAR2,
	page OUT NUMBER,
	ptel OUT VARCHAR2
)
IS
BEGIN
	SELECT name, age, tel INTO pname, page, ptel FROM tbladdress
		WHERE seq = (SELECT max(seq) FROM tbladdress);
END;

INSERT INTO tbladdress VALUES (address_seq.nextval, '홍길동', 20, '010-1234-5678', '서울시', default);





CREATE OR REPLACE PROCEDURE proc_m3(
	pseq IN NUMBER,
	pname OUT VARCHAR2,
	page OUT NUMBER,
	ptel OUT VARCHAR2
)
IS
BEGIN
	SELECT name, age, tel INTO pname, page, ptel FROM tbladdress
		WHERE seq = pseq;
END;



CREATE OR REPLACE PROCEDURE proc_m4(
	pcity VARCHAR2,
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
		SELECT name, buseo, jikwi FROM tblinsa
			WHERE city = pcity;
END;




CREATE OR REPLACE PROCEDURE proc_m5(
	pword VARCHAR2,
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
		SELECT name, buseo, jikwi, tel FROM tblinsa
			WHERE replace(tel, '-', '') like '%' || pword || '%';
END;





CREATE TABLE tblbuy
(
	seq NUMBER PRIMARY KEY,
	name VARCHAR2(50) NOT NULL ,
	item VARCHAR2(50) NOT NULL ,
	qty NUMBER NOT NULL ,
	regdate DATE DEFAULT sysdate NOT NULL
);

CREATE SEQUENCE buyseq;

SELECT * FROM tblbuy;

CREATE OR REPLACE PROCEDURE proc_addbuy (
	pname VARCHAR2,
	pitem VARCHAR2,
	pqty NUMBER
)
IS
	vcount NUMBER;
BEGIN

	SELECT count(*) INTO vcount FROM tblbuy
		WHERE name = pname AND item = pitem;

	IF vcount = 0 THEN
		INSERT INTO tblbuy (seq, name, item, qty, regdate)
			VALUES (buyseq.nextval, pname, pitem, pqty, default);
	ELSE
		UPDATE tblbuy SET
			qty = qty + pqty
				WHERE name = pname AND item = pitem;
	END IF;

END;


SELECT * FROM tblbuy;





CREATE OR REPLACE PROCEDURE proc_listbuy (
	pqty NUMBER,
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
		SELECT * FROM tblbuy
			WHERE qty >= pqty;
END;






CREATE TABLE tblauth
(
	id VARCHAR2(50) PRIMARY KEY --아이디
);

INSERT INTO tblauth VALUES ('hong');
INSERT INTO tblauth VALUES ('test');
INSERT INTO tblauth VALUES ('aaa');

CREATE OR REPLACE PROCEDURE proc_auth(
	pid VARCHAR2,
	presult OUT NUMBER
)
IS
BEGIN
	SELECT count(*) INTO presult FROM tblauth
		WHERE id = pid;
END;








CREATE TABLE tbl_big_category
(
	seq NUMBER PRIMARY KEY,
	name VARCHAR2(100) NOT NULL
);

CREATE TABLE tbl_middle_category
(
	seq NUMBER PRIMARY KEY,
	name VARCHAR2(100) NOT NULL,
	pseq NUMBER NOT NULL REFERENCES tbl_big_category(seq)
);

CREATE TABLE tbl_small_category
(
	seq NUMBER PRIMARY KEY,
	name VARCHAR2(100) NOT NULL,
	pseq NUMBER NOT NULL REFERENCES tbl_middle_category(seq)
);

CREATE TABLE tbl_product
(
	seq NUMBER PRIMARY KEY ,
	name varchar2(100) NOT NULL ,
	qty NUMBER NOT NULL ,
	pseq NUMBER NOT NULL REFERENCES tbl_small_category(seq)
);

INSERT INTO tbl_big_category VALUES (1, '전자제품');
INSERT INTO tbl_big_category VALUES (2, '식음료');
INSERT INTO tbl_big_category VALUES (3, '운동용품');

INSERT INTO tbl_middle_category VALUES (1, '모니터', 1);
INSERT INTO tbl_middle_category VALUES (2, '마우스', 1);
INSERT INTO tbl_middle_category VALUES (3, '키보드', 1);

INSERT INTO tbl_middle_category VALUES (4, '과일음료', 2);
INSERT INTO tbl_middle_category VALUES (5, '건강음료', 2);
INSERT INTO tbl_middle_category VALUES (6, '인스턴스 식품', 2);

INSERT INTO tbl_middle_category VALUES (7, '야구', 3);
INSERT INTO tbl_middle_category VALUES (8, '축구', 3);
INSERT INTO tbl_middle_category VALUES (9, '농구', 3);

INSERT INTO tbl_small_category VALUES (1, '소형', 1);
INSERT INTO tbl_small_category VALUES (2, '중형', 1);
INSERT INTO tbl_small_category VALUES (3, '대형', 1);

INSERT INTO tbl_small_category VALUES (4, '일반', 2);
INSERT INTO tbl_small_category VALUES (5, '인체공학', 2);
INSERT INTO tbl_small_category VALUES (6, '버티컬', 2);

INSERT INTO tbl_small_category VALUES (7, '기계식', 3);
INSERT INTO tbl_small_category VALUES (8, '블루투스', 3);
INSERT INTO tbl_small_category VALUES (9, '일반', 3);


INSERT INTO tbl_product VALUES (1, 'LG100', 50, 1);
INSERT INTO tbl_product VALUES (2, 'Dell100', 20, 1);
INSERT INTO tbl_product VALUES (3, 'HP100', 25, 1);

INSERT INTO tbl_product VALUES (4, 'LG200', 15, 2);
INSERT INTO tbl_product VALUES (5, 'Dell200', 53, 2);
INSERT INTO tbl_product VALUES (6, 'HP200', 23, 2);

INSERT INTO tbl_product VALUES (7, 'LG300', 72, 3);
INSERT INTO tbl_product VALUES (8, 'Dell300', 23, 3);
INSERT INTO tbl_product VALUES (9, 'HP300', 22, 3);

commit;



CREATE OR REPLACE PROCEDURE proc_list_big_category (
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
		SELECT * FROM tbl_big_category
			ORDER BY seq ASC;
END;


CREATE OR REPLACE PROCEDURE proc_list_middle_category (
	ppseq IN NUMBER,
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
		SELECT * FROM tbl_middle_category
			WHERE pseq = ppseq
				ORDER BY seq ASC;
END;


CREATE OR REPLACE PROCEDURE proc_list_small_category (
	ppseq IN NUMBER,
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
		SELECT * FROM tbl_small_category
			WHERE pseq = ppseq
				ORDER BY seq ASC;
END;



CREATE OR REPLACE PROCEDURE proc_list_product (
	ppseq IN NUMBER,
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
		SELECT * FROM tbl_product
			WHERE pseq = ppseq
				ORDER BY seq ASC;
END;



SELECT * FROM employees;




CREATE OR REPLACE PROCEDURE proc_employees(
	pid NUMBER,
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
		SELECT
			first_name || ' ' || last_name as name,
			phone_number as phone,
			level
			FROM employees
				START WITH employee_id = pid
					CONNECT BY PRIOR employee_id = manager_id;
END;








-- 레코드 비교
CREATE TABLE tblone
(
	seq NUMBER PRIMARY KEY ,
	state NUMBER NOT NULL,
	regdate VARCHAR(5) NOT NULL
);

INSERT INTO tblone VALUES (1, 1, '08-08');--정상 출근
INSERT INTO tblone VALUES (2, 4, '08-08');--정상 퇴근
INSERT INTO tblone VALUES (3, 2, '08-09');--지각 출근
INSERT INTO tblone VALUES (4, 4, '08-09');--정상 퇴근


CREATE TABLE tbltwo
(
	state NUMBER NOT NULL ,
	gstate NUMBER NOT NULL
);

INSERT INTO tbltwo VALUES (1, 1);
INSERT INTO tbltwo VALUES (4, 1);
INSERT INTO tbltwo VALUES (2, 2);
INSERT INTO tbltwo VALUES (4, 2);

SELECT * FROM tblone;
SELECT * FROM tbltwo;

SELECT gstate, avg(state) FROM tbltwo
	GROUP BY gstate
		HAVING avg(state) = (SELECT avg(state) FROM tblone WHERE regdate = '08-08');

SELECT state FROM tblone WHERE regdate = '08-08';
SELECT avg(state) FROM tblone WHERE regdate = '08-08';
-- 레코드 비교






--부서별 비상 연락망
CREATE OR REPLACE PROCEDURE proc_mergency(
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
		SELECT name, jikwi, buseo FROM tblinsa
			ORDER BY buseo ASC, name ASC ;
END;







CREATE TABLE tbl_holiday
(
	hdate DATE NOT NULL
);

INSERT INTO tbl_holiday VALUES ('2018-01-01');--공휴일
INSERT INTO tbl_holiday VALUES ('2018-01-16');--자체 휴일
INSERT INTO tbl_holiday VALUES ('2018-02-15');--공휴일
INSERT INTO tbl_holiday VALUES ('2018-02-16');--공휴일
INSERT INTO tbl_holiday VALUES ('2018-02-26');--자체 휴일
INSERT INTO tbl_holiday VALUES ('2018-03-01');--공휴일
INSERT INTO tbl_holiday VALUES ('2018-03-12');--자체 휴일

SELECT * FROM tbl_holiday;

COMMIT;



DROP TABLE tbl_zipcode;

CREATE TABLE tbl_zipcode
(
	zipcode VARCHAR2(5) NOT NULL, --구역번호(우편번호)
	sido VARCHAR2(20) NULL, --시도
	e_sido VARCHAR2(40) NULL, --시도영문
	gugun VARCHAR2(20) NULL, --시군구
	e_gugun VARCHAR2(40) NULL, --시군구영문
	eup_myeon VARCHAR2(20) NULL, --읍면
	e_eup_myeon VARCHAR2(40) NULL, --읍면영문
	doro_code VARCHAR2(12) NULL, --도로명코드
	doro VARCHAR2(80) NULL, --도로명
	e_doro VARCHAR2(80) NULL, --도로명영문
	jiha VARCHAR2(1) NULL, --지하여부(0:지상, 1:지하)
	geonmul_bonbun VARCHAR2(5) NULL, --건물번호본번
	geonmul_bubun VARCHAR2(5) NULL, --건물번호부번
	geonmul_gwanri_bun VARCHAR2(25) NULL, --건물관리번호
	daryang VARCHAR2(40) NULL, --다량배달처명
	sigugun_geonmul VARCHAR2(200) NULL, --시군구용건물명
	beobjungdong_code VARCHAR2(10) NULL, --법정동코드
	beobjung VARCHAR2(20) NULL, --법정동명
	ri VARCHAR2(20) NULL, --리명
	haengjungdong VARCHAR2(40) NULL, --행정동명
	san VARCHAR2(1) NULL, --산여부(0:토지, 1:산)
	jibun_bonbun NUMBER NULL, --지번본번
	eup_myeon_dong_num VARCHAR2(2) NULL, --읍면동일련번호
	jibun_bubun NUMBER NULL, --지번부번
	old_zipcode VARCHAR2(6) NULL, --구 우편번호
	ilyun_bun VARCHAR2(3) NULL --우편번호 일련번호
);

CREATE OR REPLACE PROCEDURE proc_add_zipcode(
	pzipcode VARCHAR2,
	psido VARCHAR2,
	pe_sido VARCHAR2,
	pgugun VARCHAR2,
	pe_gugun VARCHAR2,
	peup_myeon VARCHAR2,
	pe_eup_myeon VARCHAR2,
	pdoro_code VARCHAR2,
	pdoro VARCHAR2,
	pe_doro VARCHAR2,
	pjiha VARCHAR2,
	pgeonmul_bonbun VARCHAR2,
	pgeonmul_bubun VARCHAR2,
	pgeonmul_gwanri_bun VARCHAR2,
	pdaryang VARCHAR2,
	psigugun_geonmul VARCHAR2,
	pbeobjungdong_code VARCHAR2,
	pbeobjung VARCHAR2,
	pri VARCHAR2,
	phaengjungdong VARCHAR2,
	psan VARCHAR2,
	pjibun_bonbun NUMBER,
	peup_myeon_dong_num VARCHAR2,
	pjibun_bubun NUMBER,
	pold_zipcode VARCHAR2,
	pilyun_bun VARCHAR2
)
IS
BEGIN
	INSERT INTO tbl_zipcode VALUES (pzipcode, psido,	pe_sido, pgugun, pe_gugun, peup_myeon, pe_eup_myeon, pdoro_code, pdoro, pe_doro, pjiha, pgeonmul_bonbun, pgeonmul_bubun, pgeonmul_gwanri_bun, pdaryang, psigugun_geonmul, pbeobjungdong_code, pbeobjung, pri, phaengjungdong, psan, pjibun_bonbun, peup_myeon_dong_num, pjibun_bubun, pold_zipcode, pilyun_bun);
END;




BEGIN


END;

SELECT * FROM tbl_zipcode;






-- 성별 가져오기
CREATE VIEW vw_gender
AS
SELECT
	DISTINCT substr(ssn, 8, 1) as gender,
	CASE
		WHEN substr(ssn, 8, 1) = '1' THEN '남자'
		WHEN substr(ssn, 8, 1) = '2' THEN '여자'
	END as gender_name
FROM tblinsa;



-- 부서 가져오기
CREATE VIEW vw_buseo
AS
SELECT distinct buseo FROM tblinsa;



-- 지역 가져오기
CREATE VIEW vw_city
AS
SELECT distinct city FROM tblinsa;


-- 최종 목록 가져오기
CREATE OR REPLACE PROCEDURE proc_list_insa (
	pgender VARCHAR2, --1,2
	pbuseo VARCHAR2, --부서명
	pcity VARCHAR2, --지역명
	pcursor OUT SYS_REFCURSOR --결과 테이블
)
IS
BEGIN
	OPEN pcursor FOR
		SELECT * FROM tblinsa
			WHERE substr(ssn, 8, 1) = pgender AND buseo = pbuseo AND city = pcity
				ORDER BY name ASC ;
END;


select * from tblinsa;

UPDATE tblinsa SET city = '서울' WHERE name = '홍길동';
UPDATE tblinsa SET city = '경기' WHERE name = '이순신';

COMMIT;


UPDATE tblinsa SET city = '제주제주제주' WHERE name = '이순신';


----------------------------------------------------------------문제----------------------------------------------------------------------------------------
--문제 1

<<테이블>>
CREATE TABLE tblauth
(
        id VARCHAR2(50) PRIMARY KEY --아이디
);
INSERT INTO tblauth VALUES ('hong');
INSERT INTO tblauth VALUES ('test');
INSERT INTO tblauth VALUES ('aaa');

select*from tblauth;

<<프로시저>>
CREATE OR REPLACE PROCEDURE proc_auth(
        pid VARCHAR2,
        presult OUT VARCHAR2
)
IS
        vcount NUMBER;
BEGIN
        SELECT count(*) INTO vcount FROM tblauth
        WHERE id = pid;

        IF vcount = 0 THEN
                presult := '사용이 가능합니다.';
        ELSE
                presult := '이미 사용중입니다.';
        END IF;
END;

--문제 2
--<<테이블>>
--employees
SELECT*FROM employees;
<<프로시저>>
CREATE OR REPLACE PROCEDURE proc_employees(
	구현
)
IS

BEGIN
	구현
END;


--문제 2
CREATE OR REPLACE PROCEDURE proc_employees(
	pid NUMBER,
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
		SELECT
			first_name || ' ' || last_name as name,
			phone_number as phone,
			level
			FROM employees
				START WITH employee_id = pid
					CONNECT BY PRIOR employee_id = manager_id;
END;

select*from

COMMIT;



--문제 3
DROP TABLE tbl_big_category;
DROP TABLE tbl_middle_category;
DROP TABLE tbl_small_category;
DROP TABLE tbl_product;
-- <<테이블>>
--대분류
CREATE TABLE tbl_big_category
(
	seq NUMBER PRIMARY KEY,
	name VARCHAR2(100) NOT NULL
);

--중분류
CREATE TABLE tbl_middle_category
(
	seq NUMBER PRIMARY KEY,
	name VARCHAR2(100) NOT NULL,
	pseq NUMBER NOT NULL REFERENCES tbl_big_category(seq)
);

--소분류
CREATE TABLE tbl_small_category
(
	seq NUMBER PRIMARY KEY,
	name VARCHAR2(100) NOT NULL,
	pseq NUMBER NOT NULL REFERENCES tbl_middle_category(seq)
);

--상품
CREATE TABLE tbl_product
(
	seq NUMBER PRIMARY KEY ,
	name varchar2(100) NOT NULL ,
	qty NUMBER NOT NULL ,
	pseq NUMBER NOT NULL REFERENCES tbl_small_category(seq)
);

--데이터
INSERT INTO tbl_big_category VALUES (1, '전자제품');
INSERT INTO tbl_big_category VALUES (2, '식음료');
INSERT INTO tbl_big_category VALUES (3, '운동용품');

INSERT INTO tbl_middle_category VALUES (1, '모니터', 1);
INSERT INTO tbl_middle_category VALUES (2, '마우스', 1);
INSERT INTO tbl_middle_category VALUES (3, '키보드', 1);

INSERT INTO tbl_middle_category VALUES (4, '과일음료', 2);
INSERT INTO tbl_middle_category VALUES (5, '건강음료', 2);
INSERT INTO tbl_middle_category VALUES (6, '인스턴스 식품', 2);

INSERT INTO tbl_middle_category VALUES (7, '야구', 3);
INSERT INTO tbl_middle_category VALUES (8, '축구', 3);
INSERT INTO tbl_middle_category VALUES (9, '농구', 3);

INSERT INTO tbl_small_category VALUES (1, '소형', 1);
INSERT INTO tbl_small_category VALUES (2, '중형', 1);
INSERT INTO tbl_small_category VALUES (3, '대형', 1);

INSERT INTO tbl_small_category VALUES (4, '일반', 2);
INSERT INTO tbl_small_category VALUES (5, '인체공학', 2);
INSERT INTO tbl_small_category VALUES (6, '버티컬', 2);

INSERT INTO tbl_small_category VALUES (7, '기계식', 3);
INSERT INTO tbl_small_category VALUES (8, '블루투스', 3);
INSERT INTO tbl_small_category VALUES (9, '일반', 3);


INSERT INTO tbl_product VALUES (1, 'LG100', 50, 1);
INSERT INTO tbl_product VALUES (2, 'Dell100', 20, 1);
INSERT INTO tbl_product VALUES (3, 'HP100', 25, 1);

INSERT INTO tbl_product VALUES (4, 'LG200', 15, 2);
INSERT INTO tbl_product VALUES (5, 'Dell200', 53, 2);
INSERT INTO tbl_product VALUES (6, 'HP200', 23, 2);

INSERT INTO tbl_product VALUES (7, 'LG300', 72, 3);
INSERT INTO tbl_product VALUES (8, 'Dell300', 23, 3);
INSERT INTO tbl_product VALUES (9, 'HP300', 22, 3);




--<<프로시저>>
CREATE OR REPLACE PROCEDURE proc_list_big_category (
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
		SELECT * FROM tbl_big_category
			ORDER BY seq ASC;
END;


CREATE OR REPLACE PROCEDURE proc_list_middle_category (
	ppseq IN NUMBER,
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
		SELECT * FROM tbl_middle_category
			WHERE pseq = ppseq
				ORDER BY seq ASC;
END;


CREATE OR REPLACE PROCEDURE proc_list_small_category (
	ppseq IN NUMBER,
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
		SELECT * FROM tbl_small_category
			WHERE pseq = ppseq
				ORDER BY seq ASC;
END;



CREATE OR REPLACE PROCEDURE proc_list_product (
	ppseq IN NUMBER,
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
		SELECT * FROM tbl_product
			WHERE pseq = ppseq
				ORDER BY seq ASC;
END;







--문제 4
<<테이블>>
tblinsa

<<프로시저>>
CREATE OR REPLACE PROCEDURE proc_mergency(
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
		SELECT name, buseo FROM tblinsa
			ORDER BY buseo ASC, name ASC ;
END;


commit;
-- 문제 5
<<테이블>>
CREATE TABLE tbl_point
(
	seq NUMBER PRIMARY KEY, --PK
	name VARCHAR(100) NOT NULL, --장소명
	latitude NUMBER NOT NULL, --위도
	longitude NUMBER NOT NULL --경도
);

CREATE SEQUENCE point_seq;

INSERT INTO tbl_point VALUES (point_seq.nextval, '쌍용 교육원 강남 센터', 37.499306, 127.033202);
INSERT INTO tbl_point VALUES (point_seq.nextval, '강남역 2호선', 37.497901, 127.027631);
INSERT INTO tbl_point VALUES (point_seq.nextval, '역삼역 2호선', 37.500649, 127.036476);
INSERT INTO tbl_point VALUES (point_seq.nextval, '광화문', 37.576015, 126.976914);
INSERT INTO tbl_point VALUES (point_seq.nextval, '홍대 입구', 37.556724, 126.923615);
INSERT INTO tbl_point VALUES (point_seq.nextval, '이태원', 37.534456, 126.993887);
INSERT INTO tbl_point VALUES (point_seq.nextval, '인사동', 37.571734, 126.986966);
INSERT INTO tbl_point VALUES (point_seq.nextval, '어린이 대공원', 37.549330, 127.081160);
INSERT INTO tbl_point VALUES (point_seq.nextval, '서울역', 37.553185, 126.971530);

<<프로시저>>-- 크로스조인
SELECT
	s.name as sname, e.name as ename,
	--abs(s.latitude - e.latitude) as "위도차",
	--abs(s.longitude - e.longitude) as "경도차",
	--abs(s.latitude - e.latitude) * 92 as "위도 간 거리",
	--abs(s.longitude - e.longitude) * 114 as "경도 간 거리",
	round(sqrt(power(abs(s.latitude - e.latitude) * 92, 2) + power(abs(s.longitude - e.longitude) * 114, 2)), 2) as "거리"
		FROM tbl_point s, tbl_point e
			WHERE s.seq != e.seq
				ORDER BY s.name ASC, e.name ASC;

단위 : km
공식 : 두 점간의 거리 = 루트((|x1-x2|)^2 + (|y1-y2|)^2)

두 포인트의 위도값의 차이 : 0.0012
두 포인트의 경도간의 차이 : 0.0002
두 포인트의 위도 간 실제 거리 = 0.0012*92 = 0.1104
두 포인트의 경도 간 거리 = 0.0002*114 = 0.0228
루트(0.01104^2 + 0.00228^2)
= 루트(0.01218816 + 0.00051984)
= 루트(0.012708)
= 0.112730 km


CREATE OR REPLACE PROCEDURE proc_distance (
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
		SELECT
			s.name as sname, e.name as ename,
			round(sqrt(power(abs(s.latitude - e.latitude) * 92, 2) + power(abs(s.longitude - e.longitude) * 114, 2)), 2) as distance
				FROM tbl_point s, tbl_point e
					WHERE s.seq != e.seq
						ORDER BY s.name ASC, e.name ASC;
END;



commit;


--회원 + 메모

-- 회원 테이블
-- 회원번호, 회원명, 나이, 전화, 이메일, 포인트, 비밀번호,
CREATE TABLE tbl_member(
seq NUMBER PRIMARY KEY, --PK
name VARCHAR2(50) NOT NULL, --회원명
age NUMBER NOT NULL, --나이
tel VARCHAR2(15) NOT NULL, --전화
email VARCHAR2(100) NOT NULL, --이메일
point NUMBER DEFAULT 1000 NOT NULL, --포인트 (기본 포인트 : 1000)
pw VARCHAR2(50) NOT NULL, -- 암호
ing NUMBER(1) DEFAULT 1 NOT NULL --탈퇴여부 (회원 : 1, 탈퇴 : 0)
)
SELECT*FROM tbl_member;





--메모 테이블
-- 메모번호, 제목, 내용, 작성자(회원번호), 작성시간
CREATE TABLE tbl_memo
(
        seq NUMBER PRIMARY KEY, --PK
        subject VARCHAR2(100) NOT NULL, --제목
        content VARCHAR2(1000) NOT NULL, --내용
        mseq NUMBER NOT NULL REFERENCES tbl_member(seq), --작성자(FK)
        regdate DATE DEFAULT sysdate NOT NULL --작성시간
)

CREATE SEQUENCE member_seq;
CREATE SEQUENCE memo_seq;


SELECT*FROM tbl_memo;






















