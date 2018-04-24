/*

ex13_join.sql

-- 직원 정보 + 직원이 담당하는 프로젝트 정보
-- 직원 테이블, 프로젝트 테이블

*/

CREATE TABLE tblstaff
(
      seq NUMBER PRIMARY KEY, --직원번호(PK)
      name VARCHAR2(30) NOT NULL, --직원명
      salary NUMBER NOT NULL, --급여
      address VARCHAR2(1000) NOT NULL, --주소
      projname VARCHAR2(100) NULL --담당 프로젝트명
);

INSERT INTO tblstaff (seq, name, salary, address, projname)
      VALUES (1, '홍길동', 250, '서울시', '홍콩 수출');

INSERT INTO tblstaff (seq, name, salary, address, projname)
      VALUES (2, '아무개', 230, '부산시', 'TV 광고');

INSERT INTO tblstaff (seq, name, salary, address, projname)
      VALUES (3, '하하하', 210, '서울시', '매출 분석');

SELECT * FROM tblstaff;

-- 1명의 직원이 여러개의 프로젝트를 담당할 수 있다.
INSERT INTO tblstaff (seq, name, salary, address, projname)
      VALUES (1, '홍길동', 250, '서울시', '홍콩 수출');

DROP TABLE tblstaff;



CREATE TABLE tblstaff
(
      seq NUMBER PRIMARY KEY, --직원번호(PK)
      name VARCHAR2(30) NOT NULL, --직원명
      salary NUMBER NOT NULL, --급여
      address VARCHAR2(1000) NOT NULL --주소
      --project NUMBER NOT NULL --담당 프로젝트
);

CREATE TABLE tblproject
(
      seq NUMBER PRIMARY KEY, --프로젝트번호(PK)
      name varchar2(200) NOT NULL, --프로젝트명
      staff NUMBER NOT NULL --담당 직원 번호
);


INSERT INTO tblstaff (seq, name, salary, address) VALUES (1, '홍길동', 200, '서울시');
INSERT INTO tblstaff (seq, name, salary, address) VALUES (2, '아무개', 250, '인천시');
INSERT INTO tblstaff (seq, name, salary, address) VALUES (3, '하하하', 180, '부산시');

INSERT INTO tblproject (seq, name, staff) VALUES (1, '홍콩 수출', 1);
INSERT INTO tblproject (seq, name, staff) VALUES (2, 'TV 광고', 2);
INSERT INTO tblproject (seq, name, staff) VALUES (3, '매출 분석', 2);
INSERT INTO tblproject (seq, name, staff) VALUES (4, '대리점 분양', 1);
INSERT INTO tblproject (seq, name, staff) VALUES (5, '노조 협상', 3);

-- tblstaff(기본 테이블, 부모 테이블) + tblproject(참조 테이블, 자식 테이블) : 두 테이블이 관계(relationship)를 맺고 있다.

-- 관계를 맺고 있는 2개의 테이블의 데이터를 조작하면.. 생기는 일들..
-- 1. 부모  테이블의 조작
-- 2. 자식 테이블의 조작

--1. 신입 사원 입사 -> 신규 프로젝트 시작(담당)

--1.a 신입 사원 추가 (O)
INSERT INTO tblstaff (seq, name, salary, address) VALUES (4, '호호호', 150, '서울시');

--1.b 신규 프로젝트 추가 (O)
INSERT INTO tblproject (seq, name, staff) VALUES (6, '자재 매입', 4);

--1.c 신규 프로젝트 추가 (X) - parent key not found
INSERT INTO tblproject (seq, name, staff) VALUES (7, '고객 상담', 5);

--2. 홍길동 퇴사
--2.a 홍길동 삭제 - child record found
DELETE FROM tblstaff WHERE name = '홍길동'; -- where seq = 1

--2.b 홍길동 퇴사 절차
--2.b.a 홍길동의 담당 프로젝트 -> 위임
UPDATE tblproject set staff = 3 WHERE staff = 1;

--2.b.b 홍길동 삭제
DELETE FROM tblstaff WHERE name = '홍길동';


SELECT * FROM tblstaff;
SELECT * FROM tblproject;




-- 부모 테이블 + 자식 테이블 -> 강한 결합 -> 제약 사항 추가
-- 외래키, Foreign Key
-- : 참조 관계의 테이블간에 연결 고리 역할을 하는 컬럼의 값을 항상 유효하게 유지시켜주는 역할\
-- : 부모 테이블의 PK를 참조하는 키 + 부모 테이블 이미 존재하는 값만 넣을 수 있는 컬럼 제약
DROP TABLE tblstaff;
DROP TABLE tblproject;

CREATE TABLE tblstaff
(
      seq NUMBER PRIMARY KEY, --직원번호(PK)
      name VARCHAR2(30) NOT NULL, --직원명
      salary NUMBER NOT NULL, --급여
      address VARCHAR2(1000) NOT NULL --주소
);

CREATE TABLE tblproject
(
      seq NUMBER PRIMARY KEY, --프로젝트번호(PK)
      name varchar2(200) NOT NULL, --프로젝트명
      staff NUMBER REFERENCES tblstaff(seq) NOT NULL --담당직원(FK)
);




-- 고객 - 판매
-- 고객 테이블
CREATE TABLE tblcustomer
(
      seq NUMBER PRIMARY KEY, --고객번호(PK)
      name varchar2(30) not null, --고객명
      tel varchar2(15) not null, --연락처
      address varchar2(100) not null --주소
);

-- 판매 테이블
CREATE TABLE tblsales
(
      seq NUMBER PRIMARY KEY, --판매번호(PK)
      item VARCHAR2(50) NOT NULL, --상품명
      qty NUMBER NOT NULL, --수량
      regdate DATE DEFAULT sysdate NOT NULL, --판매 날짜
      customer NUMBER REFERENCES tblcustomer(seq) --고객번호(FK)
);

-- 부모 & 자식 테이블
-- 1. 생성 순서
--    : 부모 생성 -> 자식 생성
-- 2. 삭제 순서
--    : 자식 삭제 -> 부모 삭제

DROP TABLE tblcustomer;
DROP TABLE tblsales;



-- 비디오 대여점

-- 회원 테이블
CREATE TABLE tblmember
(
      seq NUMBER PRIMARY KEY, --회원번호(PK)
      name VARCHAR2(20) NOT NULL, --회원명
      grade number(1)
            CHECK (grade BETWEEN 1 AND  3) NOT NULL, --회원등급(1,2,3)
      byear number(4) NOT NULL, --생년
      tel varchar2(15) NOT NULL , --연락처
      address VARCHAR2(300) NULL, --주소
      money NUMBER NOT NULL --예치금
);

-- 장르 테이블
CREATE TABLE tblgenre
(
      seq NUMBER PRIMARY KEY, --장르번호(PK)
      name VARCHAR2(30) NOT NULL , --장르명
      price NUMBER NOT NULL , --대여 가격
      period NUMBER NOT NULL --대여 기간
);

-- 비디오 테이블
CREATE TABLE tblvideo
(
      seq NUMBER PRIMARY KEY , --비디오 번호(PK)
      name VARCHAR2(100) NOT NULL , --제목
      qty NUMBER NOT NULL , --보유 수량
      company VARCHAR2(50) NULL, --제작사
      director varchar2(50) NULL, --감독
      major VARCHAR2(50) NULL, --주연배우
      genre NUMBER REFERENCES tblgenre(seq) NOT NULL --장르번호(FK)
);

-- 대여 테이블
CREATE TABLE tblrent
(
      seq NUMBER PRIMARY KEY , --대여번호(PK)
      member NUMBER REFERENCES tblmember(seq) NOT NULL , --대여한 회원번호(FK)
      video NUMBER REFERENCES tblvideo(seq)  NOT NULL ,  --대여한 비디오번호(FK)
      rentdate DATE DEFAULT sysdate NOT NULL , --대여날짜
      retdate DATE NULL , --반납날짜
      remart VARCHAR2(500) --비고
);

--시퀀스 객체
CREATE SEQUENCE memberseq;
CREATE SEQUENCE genreseq;
CREATE SEQUENCE videoseq;
CREATE SEQUENCE rentseq;

-- 다시 초기화
DROP TABLE tblrent;
DROP TABLE tblmember;
DROP TABLE tblvideo;
DROP TABLE tblgenre;

DROP SEQUENCE memberseq;
DROP SEQUENCE genreseq;
DROP SEQUENCE videoseq;
DROP SEQUENCE rentseq;


/*

조인, Join
- 2개 이상의 테이블을 가져와 1개의 결과셋을 만드는 작업
- 관계를 맺고 있는 테이블끼리에 한해서..

조인의 종류
1. 단순 조인, Cross Join
2. 내부 조인, Inner Join
3. 외부 조인, Outer Join
4. 셀프 조인, Self Join

1. 단순 조인
*/
SELECT * FROM tblcustomer; --3명
SELECT * FROM tblsales; --9건

-- 결과행 : 27행
SELECT * FROM tblcustomer, tblsales; --생략
SELECT * FROM tblcustomer CROSS JOIN tblsales; --정식


/*
2. 내부 조인
 : 단순 조인에서 유효한 레코드만 취하는 조인
 : 부모 테이블의 PK와 자식 테이블의 FK가 동일한 값만을 취한다. -> 유효한 레코드

SELECT 컬럼리스트 FROM 테이블A
     INNER JOIN 테이블B
            ON 테이블A.컬럼(PK) = 테이블B.컬럼(FK)
*/
-- rs.getString("sseq")
SELECT --3
      s.seq as sseq,
      c.seq as cseq,
      --name,
      --item
      c.name,
      s.item
FROM tblcustomer c INNER JOIN tblsales s --1
                  ON c.seq = s.customer; --2


-- 잘 안하는 행동(조인 결과를 * 으로 가져오지 않는다.)
SELECT * FROM tblcustomer c INNER JOIN tblsales s
                  ON c.seq = s.customer;


SELECT * FROM (SELECT c.name, c.address, s.item, s.qty FROM tblcustomer c INNER JOIN tblsales s
                  ON c.seq = s.customer);


-- 표준 SQL
SELECT * FROM tblcustomer c
      INNER JOIN tblsales s
                  ON c.seq = s.customer;

-- 오라클 전용
SELECT * FROM tblcustomer c, tblsales s
      WHERE c.seq = s.customer;


-- 조인 사용 시 하면 안되는 행동
SELECT * FROM tblrent;
SELECT * FROM tblhousekeeping;

SELECT * FROM tblrent r
      INNER JOIN tblhousekeeping h
            ON r.member = h.qty;



SELECT * FROM tblcustomer; --3명
SELECT * FROM tblsales; --9건

-- '노트'를(tblsales) 사간 회원의 연락처(tblcustomer)?

--1. 서브쿼리
SELECT name, tel FROM tblcustomer
      WHERE seq = (SELECT customer FROM tblsales WHERE item = '노트');

--2. 조인
SELECT c.tel FROM tblcustomer c
      INNER JOIN tblsales s
            ON c.seq = s.customer
                  WHERE s.item = '노트';



-- '노트'를(tblsales) 사간 회원의 연락처(tblcustomer)와 수량(tblsales)?
-- 과정과 상관없이 최종 결과가 2개 이상의 테이블에서 나와야 한다면 -> 조인 사용

--1. 서브쿼리
SELECT name, tel, qty FROM tblcustomer
      WHERE seq = (SELECT customer FROM tblsales WHERE item = '노트');

SELECT name, tel, (SELECT qty FROM tblsales WHERE customer = c.seq AND item = '노트')
      FROM tblcustomer c
            WHERE seq = (SELECT customer FROM tblsales WHERE item = '노트');

--2. 조인
SELECT c.tel, s.qty FROM tblcustomer c
      INNER JOIN tblsales s
            ON c.seq = s.customer
                  WHERE s.item = '노트';

/*
1. 단순 조인
2. 내부 조인
3. 외부 조인
- 내부 조인 + a
*/
SELECT * FROM tblcustomer; -- 3명
SELECT * FROM tblsales; -- 9건

--*** 고객 1명 추가
INSERT INTO tblcustomer VALUES (4, '호호호', '010-1234-1234', '서울시');

-- 내부 조인
-- 쇼핑몰에서 1회 이상(*******) 구매이력이 있는 고객의 정보와 구매 이력을 가져오시오.
SELECT * FROM tblcustomer c
      INNER JOIN tblsales s
            ON c.seq = s.customer; --관계(c의 PK와 s의 FK)

-- 쇼핑몰에서 모든 고객의 정보를 출력 + 구매이력이 있는 회원은 구매이력도 같이 출력
-- 방향은 항상 부모 테이블을 가르킨다. 자식 테이블을 가르키면 INNER JOIN과 동일해진다.
SELECT * FROM tblcustomer c
      LEFT OUTER JOIN tblsales s
            ON c.seq = s.customer;

SELECT * FROM tblstaff; --3명
SELECT * FROM tblproject; --6건

INSERT INTO tblstaff VALUES (5, '홍길동', 200, '서울시');
INSERT INTO tblstaff VALUES (6, '테스트', 220, '서울시');

-- 보험회사 : 직원 명단 + 실적이 있는 사람만..
-- 우리 직원 명단 가져와라 + 프로젝트를 담당하고 있는 직원에 한해서..
SELECT * FROM tblstaff s
      INNER JOIN tblproject p
            ON s.seq = p.staff;

-- 보험회사 : 직원 명단 + 실적이 있던 없던 모두다..
-- 우리 직원 명단 가져와라 + 프로젝트 담당 유무와 상관없이..
-- 표준 SQL
SELECT * FROM tblstaff s
      LEFT OUTER JOIN tblproject p
            ON s.seq = p.staff;

-- 오라클
SELECT * FROM tblstaff s, tblproject p
      WHERE s.seq = p.staff(+);


/*
4. 셀프 조인
- 1개의 테이블 가지고 조인
- 빈도 낮음 -> 자신이 자신을 참조하는 키를 소유함
*/
--직원 정보 테이블
CREATE TABLE tblself
(
      seq NUMBER PRIMARY KEY , --직원번호(PK)
      name VARCHAR2(30) NOT NULL , --직원명
      department varchar2(30) NULL, --부서
      super NUMBER REFERENCES tblself(seq) NULL --직속 상사(FK)
);

INSERT INTO tblself VALUES (1, '홍사장', NULL, NULL);
INSERT INTO tblself VALUES (2, '가부장', '총무부', 1);
INSERT INTO tblself VALUES (3, '나과장', '총무부', 2);
INSERT INTO tblself VALUES (4, '다대리', '총무부', 3);
INSERT INTO tblself VALUES (5, '라사원', '총무부', 4);
INSERT INTO tblself VALUES (6, '마부장', '영업부', 1);
INSERT INTO tblself VALUES (7, '바과장', '영업부', 6);

SELECT * FROM tblself;

SELECT s2.name as 직원명, s1.name as 상사명 FROM tblself s1 --상사 테이블
      RIGHT OUTER JOIN tblself s2 --직원 테이블
            ON s1.seq = s2.super; -- s1(PK, 부모테이블) = s2(FK, 자식테이블)

-- employees : manager_id
SELECT e2.first_name as 직원명, e1.first_name as 매니저명
      FROM employees e1 --매니저
            INNER JOIN employees e2 -- 직원
                  ON e2.manager_id = e1.employee_id;

-- 매니저명? 매니저별로 담당하고 있는 직원 수?
SELECT (SELECT first_name || ' ' || last_name FROM employees WHERE employee_id = e2.manager_id), count(*) FROM employees e2
      GROUP BY manager_id;



-- 내부 조인
-- 테이블의 갯수 늘리기

-- 1개
-- 비디오가 뭐뭐?
SELECT * FROM tblvideo;


-- 2개
-- 모든 비디오 제목과 대여 가격, 기간?
SELECT * FROM tblgenre g
      INNER JOIN tblvideo v
            ON g.seq = v.genre;


-- 3개
-- 모든 비디오와 대여가격,기간 + 대여 정보?
SELECT * FROM tblgenre g
      INNER JOIN tblvideo v
            ON g.seq = v.genre
                  INNER JOIN tblrent r
                        ON r.video = v.seq;

-- 4개
-- 모든 비디오와 대여가격,기간 + 대여 정보 + 대여 회원의 정보?
SELECT * FROM tblgenre g
      INNER JOIN tblvideo v
            ON g.seq = v.genre
                  LEFT OUTER JOIN tblrent r
                        ON r.video = v.seq
                              RIGHT OUTER JOIN tblmember m
                                    ON m.seq = r.member;



-- 대여기록 출력 + 회원명 + 비디오제목 + 언제 + 반납 유무('반납완료' or '미반납') - CASE문
CREATE VIEW 장부
AS
SELECT
      m.name as 회원명,
      v.name as 비디오제목,
      to_char(r.rentdate, 'yyyy-mm-dd') as 대여날짜,
      CASE
            WHEN r.retdate IS NOT NULL then '반납 완료'
            WHEN r.retdate IS NULL then '미반납'
      END as 반납유무
FROM tblrent r
      INNER JOIN tblmember m
            ON m.seq = r.member
                  INNER JOIN tblvideo v
                        ON v.seq = r.video;



















