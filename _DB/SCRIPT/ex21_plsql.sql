/*

ex21_plsql.sql

PL/SQL
- Procedural Language Extensions to SQL
- 표준 SQL : 비 절차성 언어(순서가 없고, 연속적이지 않다.)
- 표준 SQL + 절차적 기능 추가 -> 오라클 추가 SQL -> PL/SQL
- 추가된 부분 -> 자바의 프로그래밍 기능 추가(변수, 제어문, 메소드 등..)
- 오라클 전용 SQL

- 표준 SQL <-> PL/SQL : 자료형 호환이 된다.
- 표준 SQL : 문장 종결자 필수X
- PL/SQL : 문장 종결자 필수O


SQL 처리 과정 & 순서
1. 표준 SQL
 : 클라이언트 구문 작성(SELECT 문) -> 실행(Ctrl + Enter) -> 네트워크를 통해 SQL이 DBMS 서버에게 전달 -> 구문 분석(파싱) -> 컴파일 -> 실제 실행(CPU) -> 결과 처리
 : 위에서 실행한 동일 SQL을 다시 실행 -> 위의 과정 처음부터 끝까지 다시 반복(***)

2. PL/SQL
 : 클라이언트 구문 작성(SELECT 문) -> 실행(Ctrl + Enter) -> 네트워크를 통해 SQL이 DBMS 서버에게 전달 -> 구문 분석(파싱) -> 컴파일 -> 실제 실행(CUP) -> 결과 처리
      2.a 처음 실행 : 위의 과정 처음 ~ 끝까지 실행(표준 SQL과 동일한 방식)
      2.b 이후 반복 실행 : 구문 분석(파싱) ~ 컴파일 부분이 생략
      : (저장) 프로시저 -> Stored Procedure : 자바의 메소드(함수)


프로시저, Procedure
- 메소드, 함수, 서브루틴 등... 특정 목적을 가지고 모인 순서대로 실행할 명령어의 집합
1. 익명 프로시저 -> 이름없음 -> 재호출을 목적으로 하지 않는 프로시저
2. 실명 프로시저 -> 이름있음 -> 재호출을 목적으로 하는 프로시저

*/
BEGIN

      dbms_output.put_line('Hello'); --syso

END;



/*

PL/SQL
- 프로그래밍 기능이 제공 + 표준 SQL
- 주로 프로시저 형태로 사용 -> 블럭 형태로 사용

PL/SQL 블럭 구조

1. 4개 키워드로 구성
- DECLARE
- BEGIN
- EXCEPTION
- END;

2. DECLARE
- 선언부, declare section
- 프로그램에서 사용되는 변수, 객체 등을 선언하는 영역
- 생략 가능

3. BEGIN
- 실행부, 구현부, executable section
- BEGIN ~ END
- 프로그램에서 실제 구현 내용을 선언하는 영역
- 연산, 제어, 표준 SQL 등으로 구현
- 생략 불가능

4. EXCEPTION
- 예외 처리부 , exception section
- catch 절 역할
- 예외 처리 코드를 선언하는 영역
- 생략 가능

5. END;
- 블럭의 종료
- 생략 불가능

6. PL/SQL 블럭 = 선언부 + 실행부 + 예외처리부


자바
{
      {

      }
}

오라클
BEGIN
      BEGIN

      END;
END;


DECLARE
      변수, 자원 선언하기
BEGIN
      구현부
EXCEPTION
      예외처리부
END;



자료형 & 변수

자료형
- 오라클과 동일(거의 유사)

변수 선언하기
- 변수명 자료형 [NOT NULL] [DEFAULT 값]
- 변수의 역할 : 질의의 결과나 인자값을 저장하는 용도

연산자
- 표준 SQL과 동일

표준 SQL 대입 연산자
- 용도 : 컬럼값 대입
- 컬럼명 = 값

PL/SQL 대입 연산자
- 용도 : 변수값 대입
- 변수 := 값
*/
DECLARE
      num NUMBER;
      name VARCHAR2(30);
      today DATE;
BEGIN

      num := 10; -- 정수형 상수(리터럴)
      dbms_output.put_line(num);

      name := '홍길동'; -- 문자열 상수(리터럴)
      dbms_output.put_line(name);

      today := sysdate;
      dbms_output.put_line(today);
      dbms_output.put_line(to_char(today, 'yyyy-mm-dd'));

END;


DECLARE
      num NUMBER DEFAULT 100; --NULL 허용
      age NUMBER NOT NULL DEFAULT 200;
BEGIN

      -- default 선언된 변수는 NULL 상태로 값을 사용하면 자동으로 default값이 대입된다.

      -- num
      dbms_output.put_line(num);

      -- age
      dbms_output.put_line(age);

END;


/*
테이블에서 조회한 데이터를 변수에 담아야하는 경우
- 질의의 결과가 단일값이여 한다.(다중 컬럼 or 다중 레코드 모두 불가능)
      a. 결과셋이 1개의 레코드와 1개의 컬럼으로 구성(PK 조건절)
      b. 집계 함수의 결과셋
*/
DECLARE
      vbuseo varchar2(15);
BEGIN
      --하나의 컬럼값을 하나의 변수에 대입
      SELECT buseo INTO vbuseo FROM tblinsa
            WHERE name = '홍길동';
      dbms_output.put_line('홍길동의 부서는 ' || vbuseo || '입니다.');
END;


DECLARE
      vsalary number; --평균 급여(basicpay + sudang)
BEGIN

      -- 변수 := 값;
      -- 컬럼값 into 변수
      SELECT round(avg(basicpay + sudang)) INTO vsalary FROM tblinsa;

      dbms_output.put_line('평균 급여 : ' || vsalary);

END;

/*
SELECT INTO 절
1. 1개의 결과값을 1개의 변수에 저장(1:1)
2. N개의 결과값을 N개의 변수에 저장(N:N). 단 결과값의 갯수와 변수의 갯수가 일치
*/
DECLARE
      vname VARCHAR2(20);
      vbuseo VARCHAR2(15);
      vjikwi VARCHAR2(15);
      vbasicpay NUMBER;
BEGIN

      SELECT name, buseo, jikwi, basicpay INTO vname, vbuseo, vbasicpay, vjikwi
            FROM tblinsa
                  WHERE num = 1001;

      dbms_output.put_line(vname || '은 ''' || vbuseo || '''에 근무하는 ''' || vjikwi || '''입니다.');

END;


/*
참조형 선언
- 원본(컬럼)의 자료형을 몰라도 된다.
- 유지 보수성이 좋다.
- 테이블과 뷰를 대상으로 한다.

1. %type
- 사용하는 테이블의 특정 컬럼의 자료형과 길이를 참조해서 이곳에 적용하겠습니다.
- 복사되는 정보
      a. 자료형
      b. 길이
      c. NOT NULL 제약

*/
DECLARE
      vname tblinsa.name%type; -- vname varchar2(20) not null
BEGIN
      SELECT name INTO vname FROM tblinsa
            WHERE basicpay = (SELECT max(basicpay) FROM tblinsa);
      dbms_output.put_line(vname);
END;


DECLARE
      vfirst tblname.first%type;
      vlast tblname.last%type;
      vnick tblname.nick%type;
BEGIN
      SELECT first, last, nick INTO vfirst, vlast, vnick FROM tblname
            WHERE height = 178 AND weight = 64;
      dbms_output.put_line(vfirst);
      dbms_output.put_line(vlast);
      dbms_output.put_line(vnick);
END;




DECLARE
      vfirst tblname.first%type;
      vlast tblname.last%type;
      vnick tblname.nick%type;
BEGIN
      SELECT first, last, nick INTO vfirst, vlast, vnick FROM tblname
            WHERE height = 178 AND weight = 64;
      dbms_output.put_line(vfirst);
      dbms_output.put_line(vlast);
      dbms_output.put_line(vnick);
END;




DECLARE
      vfirst tblname.first%type;
BEGIN

      SELECT first INTO vfirst FROM tblname
            WHERE nick = '메뚜기';
      dbms_output.put_line(vfirst);

      SELECT first INTO vfirst FROM tblname
            WHERE nick = '이십끼';
      dbms_output.put_line(vfirst);

      SELECT first INTO vfirst FROM tblname
            WHERE nick = '정중앙';

      dbms_output.put_line(vfirst);

      vfirst := vfirst || '상수';
      dbms_output.put_line(vfirst);
END;


DECLARE
      vbasicpay tblinsa.basicpay%type;
      vname tblinsa.name%type;
BEGIN

      SELECT max(basicpay) INTO vbasicpay FROM tblinsa; --2650000

      SELECT name INTO vname FROM tblinsa WHERE basicpay = vbasicpay;

      dbms_output.put_line(vname);

END;


DECLARE
      vcouple tblmen.couple%type;
BEGIN

      -- 홍길동의 여자친구 바람 -> 하하하
      -- SELECT * FROM tblmen; --홍길동 - 장도연

      -- 1.
      SELECT couple INTO vcouple FROM tblmen WHERE name = '홍길동';

      -- 2.
      UPDATE tblmen SET couple = vcouple WHERE name = '하하하';

      -- 3.
      UPDATE tblmen SET couple = NULL WHERE name = '홍길동';

      -- 4.
      --SELECT * FROM tblwomen;
      UPDATE tblwomen SET couple = '하하하' WHERE name = vcouple;


END;

SELECT * FROM tblmen;
SELECT * FROM tblwomen;





-- tblinsa. 직원 중 일부에게 지급할 보너스 내역 저장
CREATE TABLE tblbonus
(
      seq NUMBER primary key,
      name varchar2(15) NOT NULL, --참조키(다른 테이블 PK 참조)
      --num number REFERENCES tblinsa(num), -- 정답
      bonus NUMBER NOT NULL
);

SELECT * FROM tblinsa
      WHERE city = '서울' AND jikwi = '부장'
            AND (months_between(sysdate, ibsadate) / 12) >= 20;


DECLARE
      vname tblinsa.name%type;
      vsudang tblinsa.sudang%type;
BEGIN

      SELECT name, sudang * 3 INTO vname, vsudang FROM tblinsa
            WHERE city = '서울' AND jikwi = '부장'
                  AND (months_between(sysdate, ibsadate) / 12) >= 20;

      --dbms_output.put_line(vname);
      --dbms_output.put_line(vsudang);

      INSERT INTO tblbonus VALUES (1, vname, vsudang);

END;

SELECT * FROM tblbonus;




/*

2. %rowtype
- 테이블의 레코드 구조를 참조한다.(%type : 컬럼 참조)
- %type 의 집합

*/
DECLARE
      --vrow tblinsa.컬럼명%type;
      vrow tblinsa%rowtype; --레코드의 타입 전체를 복사(컬럼 10개 복사)
BEGIN

      /*
      SELECT
            num, name, ssn, ibsadate, city, tel, buseo, jikwi, basicpay, sudang
            INTO
            vnum, vname, vssn, vibsadate, vcity, vtel, vbuseo, vjikwi, vbasicpay, vsudang
                  FROM tblinsa
                        WHERE num = 1001;
      */
      SELECT * INTO vrow FROM tblinsa WHERE num = 1001;

      --dbms_output.put_line(vrow);
      dbms_output.put_line(vrow.num);
      dbms_output.put_line(vrow.name);
      dbms_output.put_line(vrow.buseo);
      dbms_output.put_line(vrow.city);

END;

-- tblmen -> tblwomen : 옮기기
DECLARE
      vrow tblmen%rowtype;
BEGIN

      -- SELECT * FROM tblmen;
      -- 이동 = 복사 + 삭제

      -- 1. 복사 : select -> insert
      SELECT * INTO vrow FROM tblmen WHERE name = '정형돈';

      --dbms_output.put_line(vrow.name);
      --dbms_output.put_line(vrow.age);

      INSERT INTO tblwomen (name, age, height, weight, couple)
            VALUES (vrow.name, vrow.age, vrow.height, vrow.weight, vrow.couple);

      -- 2. 삭제
      DELETE FROM tblmen WHERE name = '정형돈';

END;

SELECT * FROM tblmen;
SELECT * FROM tblwomen;

/*

상수
- 리터럴 X
- 자바 : final double PI = 3.14;
- 상수명 constant 자료형 [NOT NULL] [DEFAULT]
*/

DECLARE
      num NUMBER := 100;
      PI CONSTANT NUMBER(3, 2) := 3.14;
BEGIN
      --PI := 5.24;
      dbms_output.put_line(PI);
END;



/*

식별자(DB Object)
- 컴파일 시 모든 키워드를 대문자로 변환 -> 저장
- 영문자 + 숫자 + _
- 숫자 시작 X
- 예약어 사용 X -> "예약어" -> 쓰지 말것
- 최대 길이 제한 30바이트 이하(UTF-8)
      : 제약 사항 이름
      ex) tblcountry + name + primary key
           name varchar2(20) constraint tblcountry_name_pk primary key,

*/

-- ORA-00903: invalid table name
CREATE TABLE "NUMBER"
(
      seq number PRIMARY KEY
);

INSERT INTO NUMBER (seq) VALUES (100);
INSERT INTO "NUMBER" (seq) VALUES (100);

SELECT * FROM NUMBER;
SELECT * FROM "NUMBER";


CREATE TABLE tblnumber
(
      seq NUMBER CONSTRAINT tblnumber_seq_pkaaaaaaaaaaaaaaaaaaaa PRIMARY KEY
);

DROP TABLE tblnumber;

CREATE TABLE tblnumberaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
(
      seq NUMBER CONSTRAINT tblnumber_seq_pk PRIMARY KEY
);


SELECT name AS aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa FROM tblinsa;



/*
제어문
*/

-- 조건문 : if문
DECLARE
      vnum NUMBER;
BEGIN

      vnum := -10;

      IF vnum > 0 THEN
             dbms_output.put_line('양수');
      END IF;

      IF vnum > 0 THEN
             dbms_output.put_line('양수');
      ELSE
            dbms_output.put_line('음수');
      END IF;

      IF vnum > 0 THEN
             dbms_output.put_line('양수');
      ELSIF vnum <0 THEN
            dbms_output.put_line('음수');
      ELSE
            dbms_output.put_line('0');
      END IF;

END;



DECLARE
      vgender CHAR(1); --주민번호 1자리
      vnumber NUMBER; --직원 번호
BEGIN
      -- 현재 직원이 남자면 A 업무 진행 or 여자면 B 업무 진행
      vnumber := 1003;

      SELECT substr(ssn, 8, 1) INTO vgender FROM tblinsa WHERE num = vnumber;

      IF vgender = '1' THEN
            UPDATE tblinsa SET basicpay = basicpay + 100000
                  WHERE num = vnumber;
      ELSE
            UPDATE tblinsa SET sudang = sudang + 100000
                  WHERE num = vnumber;
      END IF;

END;

SELECT * FROM tblinsa;



DECLARE
      vrow tblinsa%rowtype;
BEGIN

      SELECT * INTO vrow FROM tblinsa WHERE num = 1001;

      -- 급여 2백만원 이상 + 부장(과장)급?
      IF vrow.basicpay >= 2000000 AND vrow.jikwi IN ('부장', '과장') THEN
            dbms_output.put_line('성공');
      ELSE
            dbms_output.put_line('실패');
      END IF;

END;


/*
case 문
- 자바 : switch case 문
- 표준 case문과 동일
*/

DECLARE
      vcontient tblcountry.continent%type;
      vresult VARCHAR2(30); -- UTF-8
      --vresult NVARCHAR2(30); -- UTF-16
      vpopulation tblcountry.population%type;
BEGIN

      -- 대한민국이 어느 대륙에 속하는지?
      SELECT continent, population INTO vcontient, vpopulation
            FROM tblcountry WHERE name = '대한민국';

      dbms_output.put_line(vcontient);

      IF vcontient = 'AS' THEN
            vresult := '아시아';
      ELSIF vcontient = 'EU' THEN
            vresult := '유럽';
      ELSIF vcontient = 'AF' THEN
            vresult := '아프리카';
      END IF;

      dbms_output.put_line(vresult);

      CASE
            WHEN vcontient = 'AS' THEN vresult := '아시아';
            WHEN vcontient = 'EU' THEN vresult := '유럽';
            WHEN vcontient = 'AF' THEN vresult := '아프리카';
      END CASE;

      CASE vcontient
            WHEN 'AS' THEN vresult := '아시아';
            WHEN 'EU' THEN vresult := '유럽';
            WHEN 'AF' THEN vresult := '아프리카';
      END CASE;

      dbms_output.put_line(vresult);


      --인구수에 따라 업무 분기..
      CASE
            WHEN vpopulation > 10000 THEN vresult := '너무 많음';
            WHEN vpopulation > 5000 THEN vresult := '조금 많음';
            WHEN vpopulation > 1000 THEN vresult := '적당함';
            ELSE vresult := '모자람';
      END CASE ;

      dbms_output.put_line(vresult);

END;



/*
반복문

1. LOOP
- 조건 반복

2. FOR LOOP
- 지정 횟수 반복(자바 for문)

3. WHILE LOOP
- 조건 반복(자바 while문)
*/

BEGIN
      LOOP
            dbms_output.put_line('안녕하세요. ' || sysdate);
            EXIT;
      END LOOP;
END;


DECLARE
      vnum NUMBER;
BEGIN
      vnum := 1;

      LOOP
            dbms_output.put_line(vnum);
            vnum := vnum + 1;
            EXIT WHEN vnum = 11;
      END LOOP;
END;


DECLARE
      vnow DATE;
BEGIN
      LOOP
            vnow := sysdate;
            dbms_output.put_line('현재 시간은 ' || to_char(vnow, 'hh24:mi:ss') || '입니다.');
            EXIT WHEN to_char(vnow, 'ss') = '59';
      END LOOP;
      dbms_output.put_line('종료');
END;





CREATE TABLE tblloop
(
      seq NUMBER primary key,
      data VARCHAR2(30) NOT NULL
);

CREATE SEQUENCE loopseq;

-- 1, 학생1
-- 2, 학생2
-- .. insert x 1000회

DECLARE
      vnum NUMBER; --루프 변수 + seq + 학생 번호
BEGIN
      vnum := 1;
      LOOP
            INSERT INTO tblloop (seq, data) VALUES (vnum, '학생' || vnum);
            vnum := vnum + 1;
            EXIT WHEN vnum >= 1001;
      END LOOP;
END;

SELECT * FROM tblloop;

TRUNCATE TABLE tblloop; --롤백 불가능


BEGIN
      LOOP
            INSERT INTO tblloop (seq, data)
                  VALUES (loopseq.nextval, '학생' || loopseq.currval);
            EXIT WHEN loopseq.currval >= 1000;
      END LOOP;
END;



/*
2. FOR LOOP
- 지정횟수 반복
*/
BEGIN
      -- FOR의 루프변수는 따로 선언문을 가지지 않는다.
      -- i : 루프 변수
      -- 1 : 초기값
      -- .. : 증가
      -- 10 : 최대값
      FOR i IN REVERSE 1..10 LOOP
            dbms_output.put_line(i);
      END LOOP;
END;


-- BEGIN
--       FOR i IN 'A'..'Z'  LOOP
--             dbms_output.put_line(i);
--       END LOOP;
-- END;


--3. WHILE LOOP
DECLARE
      vnum NUMBER;
BEGIN
      vnum := 1;

      WHILE vnum <= 10
      LOOP
            dbms_output.put_line(vnum);
            vnum := vnum + 1;
      END LOOP;

END;

-- 구구단
CREATE TABLE tblgugudan
(
      dan NUMBER NOT NULL , --   2  2  2
      num NUMBER NOT NULL , --  1  2  3
      result NUMBER NOT NULL, -- 2  4  6

      --복합키(Composite Key)
      -- : 2개 이상의 컬럼이 모여서 기본키(PK) 역할
      -- : 컬럼 수준으로 선언 불가능, 테이블 수준으로 선언 가능
      CONSTRAINT tblgugudan_dan_num_pk PRIMARY KEY(dan, num)
);

-- 2단 ~ 9단 : 2중 루프
DECLARE
      vdan NUMBER;
      vnum NUMBER;
      --vresult NUMBER;
BEGIN
      vdan := 2;
      WHILE vdan <= 9 LOOP
            vnum := 1;
            WHILE vnum <= 9 LOOP
                  INSERT INTO tblgugudan (dan, num, result)
                        VALUES (vdan, vnum, vdan * vnum);
                  vnum := vnum + 1;
            END LOOP;
            vdan := vdan + 1;
      END LOOP;
END;

SELECT * FROM tblgugudan ORDER BY dan ASC , num ASC ;

TRUNCATE TABLE tblgugudan;


BEGIN
      FOR dan IN 2..19 LOOP
            FOR num IN 1..19 LOOP
                  INSERT INTO tblgugudan VALUES (dan, num, dan * num);
            END LOOP;
      END LOOP;
END;




/*
SELECT를 통해서 가져온 데이터를 PL/SQL 변수에 넣는 방법
1. SELECT INTO 사용하기
- 결과셋의 레코드가 1개일 때만 가능하다.

2. 커서(Cursor) 사용하기
- 결과셋의 레코드가 1개 이상일 때 가능하다.


커서 구문

DECLARE
      변수 선언;
      커서 선언;
BEGIN
      커서 열기;
      LOOP
            데이터 접근(레코드 접근);
      END LOOP;
      커서 닫기;
END;

*/

-- SELECT INTO
-- 1. 단일 컬럼 x 단일 행(**)
-- 2. 다중 컬럼 x 단일 행(**)

-- tblinsa 직원명 가져오기 x 60명
-- Cursor
-- 3. 단일 컬럼 x 다중 행(**)
DECLARE
      vname tblinsa.name%type;
      CURSOR vcursor
      IS
      SELECT name FROM tblinsa ORDER BY name ASC; --커서 선언(아직까진 select 실행 전)
BEGIN

      OPEN vcursor; --커서 열기(이 때 select 실행)

            LOOP
                  -- 레코드 하나하나를 커서를 사용해서 접근
                  FETCH vcursor INTO vname;

                  -- 커서 속성
                  -- vcursor%notfound : 다음행이 있으면 false, 다음행이 없으면 true
                  EXIT WHEN vcursor%NOTFOUND ;

                  dbms_output.put_line(vname);
            END LOOP;

      CLOSE vcursor; --커서 닫기(자원 해제 코드)

END;





/*
PL/SQL을 사용해서 SELECT 결과셋을 가져오기 + 처리하기

1. SELECT INTO : 단일 행
      a. 단일 컬럼 + 단일 행
      b. 다중 컬럼 + 단일 행

2. CURSOR : 다중 행
      a. 단일 컬럼 + 다중 행(단일 행)
      b. 다중 컬럼 + 다중 행(단일 행)

*/
--1. SELECT INTO : 단일 행
--       a. 단일 컬럼 + 단일 행
--       b. 다중 컬럼 + 단일 행
DECLARE
      vword VARCHAR2(30); --검색어
      vcount NUMBER;

      vname VARCHAR2(100); -- first + last + 공백
      vphone employees.phone_number%type;
      vsalary employees.salary%type;
BEGIN

      vword := 'D';

      SELECT count(*) INTO vcount FROM employees
            WHERE lower(first_name) like lower(vword) || '%'; --1.a

      -- 이후 업무는.. 알아서..
      dbms_output.put_line('''' || vword || '''로 시작하는 직원은 총 ' || vcount || '명입니다.');


      -- select * from employees;

      -- 급여가 가장 많은 사람 : 이름 + 연락처 + 급여
      SELECT * INTO vname, vphone, vsalary
            FROM (SELECT first_name || ' ' ||  last_name as name, phone_number, salary
                  FROM employees ORDER BY salary DESC)
                        WHERE rownum = 1; --1.b

      dbms_output.put_line(vname);
      dbms_output.put_line(vphone);
      dbms_output.put_line(vsalary);

END;


-- 2. CURSOR : 다중 행
--       a. 단일 컬럼 + 다중 행(단일 행)

CREATE TABLE tblfullname
(
      name VARCHAR2(50) PRIMARY KEY
);

DECLARE
      CURSOR vcursor
      IS
      SELECT first_name || ' ' || last_name as name
            FROM employees
                  ORDER BY name asc;
      vname VARCHAR2(50);
BEGIN
      -- 모든 직원의 이름
      OPEN vcursor;

      LOOP
            FETCH vcursor INTO vname; --SELECT INTO 역할
            EXIT WHEN vcursor%NOTFOUND;

            --추가 업무..
            INSERT INTO tblfullname VALUES (vname);
            dbms_output.put_line(vname);

      END LOOP;

      CLOSE vcursor;
END;

SELECT * FROM tblfullname;


-- 단일행 + 단일값 -> cursor
DECLARE
      vcount NUMBER;
      CURSOR vcursor IS
            SELECT count(*) FROM employees WHERE first_name like 'D%';
BEGIN
      OPEN vcursor;
      --LOOP
            FETCH vcursor INTO vcount;
            --EXIT WHEN vcursor%NOTFOUND;
            dbms_output.put_line('결과 : ' || vcount);
      --END LOOP;
      CLOSE vcursor;
END;



/*
단일컬럼 + 다중행
다중컬럼 + 다중행
*/
DECLARE
      CURSOR vcursor IS SELECT name, buseo, jikwi FROM tblinsa;
      vname tblinsa.name%type;
      vbuseo tblinsa.buseo%type;
      vjikwi tblinsa.jikwi%type;

      CURSOR vcursor2 IS SELECT * FROM tblname;
      vrow tblname%rowtype;

BEGIN
      OPEN vcursor;
      LOOP
            FETCH vcursor INTO vname, vbuseo, vjikwi;--SELECT * INTO vname,vbuseo,vjikwi
            EXIT WHEN vcursor%NOTFOUND;

            --추가업무
            dbms_output.put_line(vname);
            dbms_output.put_line(vbuseo);
            dbms_output.put_line(vjikwi);
            dbms_output.put_line('--------');

      END LOOP;
      CLOSE vcursor;


      OPEN vcursor2;
      LOOP
            FETCH vcursor2 INTO vrow;
            EXIT WHEN vcursor2%NOTFOUND;

            --추가업무..
            dbms_output.put_line(vrow.last || vrow.first);
            dbms_output.put_line(vrow.nick);
            dbms_output.put_line('-------');

      END LOOP;
      CLOSE vcursor2;

END;


/*
Cursor의 기본 사용법
 : 커서 객체 생성(정의) -> 커서 열기 -> 루프(선택) -> 데이터 접근 + 가져오기 -> 커서 닫기


CURSOR FOR LOOP
- 커서 + LOOP 조합
- 커서 + FOR LOOP 조합 : 커서 처리 단순화
*/
DECLARE
      CURSOR vcusor IS
            SELECT * FROM tbltodo;
      vrow tbltodo%rowtype;
BEGIN
      OPEN vcusor;
      LOOP
            FETCH vcusor INTO vrow;
            EXIT WHEN vcusor%NOTFOUND;

            dbms_output.put_line(vrow.title || '(' ||
                                 CASE
                                          WHEN vrow.completedate IS NULL THEN '미완료'
                                          WHEN vrow.completedate IS NOT NULL THEN '완료'
                                 END
                                 || ')');

      END LOOP;
      CLOSE vcusor;
END;




DECLARE
      CURSOR vcusor IS
            SELECT * FROM tbltodo;
      --vrow tbltodo%rowtype; --루프변수가 대신
BEGIN

      --FOR i IN 1..10 LOOP   //for (int n : nums)
      --END LOOP;

      --커서 열기 생략

      FOR vrow IN vcusor LOOP -- FETCH vcursor INTO vrow
            dbms_output.put_line(vrow.title || '(' ||
                                 CASE
                                          WHEN vrow.completedate IS NULL THEN '미완료'
                                          WHEN vrow.completedate IS NOT NULL THEN '완료'
                                 END
                                 || ')');
      END LOOP;

      --커서 닫기 생략
END;




-- 서브쿼리 or 인라인 뷰 -> 커서 사용 가능
BEGIN
      FOR vrow IN (SELECT * FROM tbltodo) LOOP
            dbms_output.put_line(vrow.title);
      END LOOP;
END;


/*
EXCEPTION,
- 예외 처리부
- 실행부에서 발생하는 예외 처리 담당
*/
DECLARE
      vdata NUMBER;
BEGIN
      dbms_output.put_line('시작');
      SELECT name INTO vdata FROM tblinsa WHERE num = 1001;
      dbms_output.put_line('끝');
END;



DECLARE
      vdata NUMBER;
BEGIN
      dbms_output.put_line('시작');
      SELECT name INTO vdata FROM tblinsa WHERE num = 1001;
      dbms_output.put_line('끝');
EXCEPTION
      -- 자바 catch절
      -- 예외 처리 코드
      WHEN OTHERS THEN --예외 종류, 자바 catch(Exception e)
            dbms_output.put_line('예외 처리');
END;



-- 예외발생 기록(로그 테이블)
CREATE TABLE tbllog
(
      seq NUMBER PRIMARY KEY, --식별자(PK) -> DB 식별자
      code VARCHAR2(20) CHECK (code IN ('AAA0001', 'BBB0001', 'ZZZ0001')) NOT NULL,-- AAA0001... -> 업무 식별자
      message VARCHAR2(1000) NULL, --상태 메시지
      regdate DATE DEFAULT sysdate NOT NULL --발생 시각
);
CREATE SEQUENCE logseq;


DECLARE
      vnum NUMBER;
      vname varchar2(30);
BEGIN
      SELECT 10000000 / count(*) INTO vnum FROM tblname; --업무1
     --SELECT name INTO vname FROM tblinsa; --WHERE num = 1001; --업무2
      SELECT name INTO vnum FROM tblinsa WHERE num = 1001; --업무3

      dbms_output.put_line(vnum);
      dbms_output.put_line(vname);

EXCEPTION

      WHEN ZERO_DIVIDE THEN
            dbms_output.put_line('tblname에 데이터가 없습니다.');
            INSERT INTO tbllog VALUES (logseq.nextval, 'AAA0001', '김대리 담당', DEFAULT);
      WHEN TOO_MANY_ROWS THEN
            dbms_output.put_line('가져온 직원이 너무 많습니다.');
            INSERT INTO tbllog VALUES (logseq.nextval, 'BBB0001', NULL, DEFAULT);
      WHEN OTHERS THEN
            dbms_output.put_line('관리자에 연락하세요.');
            INSERT INTO tbllog VALUES (logseq.nextval, 'ZZZ0001', NULL, DEFAULT);

END;

COMMIT ;
ROLLBACK;
DELETE FROM tblname;


SELECT * FROM tbllog;



/*
PL/SQL 블럭과 트랜잭션의 관계
*/

SELECT * FROM tbltodo;
COMMIT;
ROLLBACK;
INSERT INTO tbltodo VALUES (21, 'DB 모델링 작업', sysdate, NULL);

DECLARE
      vseq NUMBER;
      vtitle tbltodo.title%type;
BEGIN
      vseq := 22;
      vtitle := '저녁에 팀회의하기';
      INSERT INTO tbltodo VALUES (vseq, vtitle, sysdate, NULL);
END;


/*
PL/SQL 블럭에서 트랜잭션 처리 결과
1. 블럭내의 모든 업무가 성공 -> COMMIT
2. 블럭내의 일부 업무가 실패(예외 발생) -> ROLLBACK
*/

DECLARE
      vcount NUMBER;
      vstate VARCHAR2(50);
BEGIN

      --업무 1.
      dbms_output.put_line('1');
      SELECT count(*) INTO vcount FROM tbltodo WHERE completedate IS NULL;
      dbms_output.put_line('2');

      --업무 2.
      IF vcount >= 10 THEN
            --할일 너무 많이 남아있음
            vstate := '- 빨리 처리 요구';
      ELSE
            --할일이 적당함
            vstate := '- 천천히 해도 됨';
      END IF;
      dbms_output.put_line('3');


      INSERT INTO tbltodo VALUES (22, '저녁에 팀회의', sysdate, NULL);
      dbms_output.put_line('4');

      --업무 3.
      IF vcount >= 5 THEN
            UPDATE tbltodo SET completedate = '2018년 1월 22일';
      END IF;
      dbms_output.put_line('5');


      --모든 업무 성공
      COMMIT;
-- oracle + transaction + exception
EXCEPTION
      WHEN OTHERS THEN
            --로그 insert (X)
            ROLLBACK;
            --로그 insert (O)
            --COMMIT ;
            dbms_output.put_line('6');
END;


SELECT * FROM tbltodo;

/*
익명 블럭 -> 실명 블럭(가독성, 재사용 등..)

여태까지 수업한 PL/SQL 블럭 -> 이름 붙이기 -> 블럭이 오라클 서버에 저장 -> 저장 블럭 -> 저장 프로그램
- 이름을 붙인 PL/SQL 블럭
- 개인 코드 저장 -> 오라클 서버 저장
- 성능 향상(구문 분석 ~ 컴파일 과정 생략)
- 네트워크 트래픽 감소(코드 전체 전송 -> 프로그램 이름만 전송)
- 여러 계정이 동일한 코드를 사용 가능(권한 부여)

저장 프로그램 종류
1. 저장 프로시저, Stored Procedure
2. 저장 함수, Stored Function


저장 프로시저 구문

CREATE [OR REPLACE] PROCEDURE 프로시저명
IS[AS]
      [선언부;]
BEGIN
      실행부;
[EXCEPTION
      예외처리부]
END [프로시저명]; -- 자바주석 : m1()

*/

-- 프로시저 생성
CREATE OR REPLACE PROCEDURE proc_test
IS -- 익명 DECLARE 역할
      vnum NUMBER;
BEGIN
      vnum := 100;
      dbms_output.put_line(vnum);
END;


/*
프로시저 호출(실행)

1. PL/SQL 블럭내에서 호출
- 프로그래밍 방식
- 익명 블럭 or 다른 프로시저에 호출
- 주로 사용

2. 스크립트 환경에서 호출
- 관리자, 담당자
- execute, call
*/

--1.
BEGIN
      SELECT * FROM tblname;
END;

--2.
SELECT * FROM tblname;

--1. 익명 PL/SQL 블럭에서 호출하기
BEGIN
      proc_test; --프로시저 호출
      proc_test();
END;

-- proc_test();

--1. 실명 PL/SQL 블럭에서 호출하기
CREATE or REPLACE PROCEDURE proc_hello
IS
BEGIN
      proc_test; --프로시저 호출
END;

BEGIN
      proc_hello;
END;


--2. 스크립트 호출
EXEC proc_test;
EXECUTE proc_test;
CALL proc_test();


/*
매개변수가 있는 프로시저
- 자바의 메소드의 매개변수와 유사
*/
CREATE OR REPLACE PROCEDURE proc_print(pnum NUMBER)
IS
      vresult NUMBER;
BEGIN
      vresult := pnum * 2;
      dbms_output.put_line(vresult);
END;

BEGIN
      proc_print(100);
END;

DROP PROCEDURE pro_area;

CREATE OR REPLACE PROCEDURE proc_area
(
      pwidth NUMBER,
      pheight NUMBER
)
IS
      varea NUMBER;
BEGIN
      varea := pwidth * pheight;
      dbms_output.put_line(varea);
END;

BEGIN
      proc_area(100, 200);
END;



CREATE OR REPLACE PROCEDURE proc_area
(
      pwidth NUMBER DEFAULT 10,
      pheight NUMBER DEFAULT 20
)
IS
      varea NUMBER;
BEGIN
      varea := pwidth * pheight;
      dbms_output.put_line(varea);
END;

BEGIN
      proc_area(100, 200);
      proc_area(300);
      proc_area;
END;


/*

매개변수 전달 방법
1. Call by Value
2. Call by Reference
3. Out Parameter



매개변수 작동 모드
- 매개변수의 값을 전달하는 방법

1. IN 모드
- 기본 모드

2. OUT 모드
3. IN OUT 모드
*/
CREATE OR REPLACE PROCEDURE proc_sum
(
      vnum1 NUMBER,
      vnum2 NUMBER
)
IS
      vresult NUMBER;
BEGIN
      vresult := vnum1  + vnum2;
      dbms_output.put_line(vresult);
END;

BEGIN
      proc_sum(10, 20);
END;



CREATE OR REPLACE PROCEDURE proc_sum
(
      vnum1 IN NUMBER, -- in 파라미터
      vnum2 IN NUMBER,
      vresult OUT NUMBER, -- out 파라미터(반환값)
      vresult2 OUT NUMBER
)
IS
      --vresult NUMBER;
BEGIN
      vresult := vnum1  + vnum2;
      vresult2 := vnum1 * vnum2;
      --dbms_output.put_line(vresult);
END;

BEGIN
      proc_sum(10, 20);
END;

DECLARE
      vresult NUMBER;
      vresult2 NUMBER;
BEGIN
      vresult := 100; -- out 변수는 초기화X
      proc_sum(30, 40, vresult, vresult2);
      dbms_output.put_line(vresult);
      dbms_output.put_line(vresult2);
END;




-- 검색
--  번호 -> 직원 정보 출력
CREATE OR REPLACE PROCEDURE proc_getinsa
(
      pnum NUMBER
)
IS
      vrow tblinsa%rowtype;
BEGIN
      SELECT * INTO vrow FROM tblinsa
            WHERE num = pnum;
      dbms_output.put_line(vrow.name);
      dbms_output.put_line(vrow.buseo);
      dbms_output.put_line(vrow.jikwi);
END;


BEGIN
      proc_getinsa(1050);
      proc_getinsa(1051);
      proc_getinsa(1052);
END;


-- tblname -> 새로 추가하기
CREATE OR REPLACE PROCEDURE proc_addname
(
      pfirst VARCHAR2,
      plast VARCHAR2,
      pgender VARCHAR2,
      pheight NUMBER,
      pweight NUMBER,
      pnick VARCHAR2
)
IS
      vcount NUMBER; --동명이인이 몇명인지?
BEGIN
--       dbms_output.put_line(pfirst);
--       dbms_output.put_line(plast);
--       dbms_output.put_line(pgender);
--       dbms_output.put_line(pheight);
--       dbms_output.put_line(pweight);
--       dbms_output.put_line(pnick);

      -- 같은 이름이 있는지?
      SELECT count(*) INTO vcount FROM tblname
            WHERE first = pfirst AND last = plast;

      IF vcount = 0 THEN
            INSERT INTO tblname (first, last, gender, height, weight, nick)
                  VALUES (pfirst, plast, pgender, pheight, pweight, pnick);
      ELSE
            dbms_output.put_line('동명 이인 발견');
      END IF;

END;

BEGIN
      proc_addname('무개', '아', 'm', 180, 60, '없음');
      --proc_addname('길동', '홍', 'm', 180, 60, '없음');
END;


SELECT * FROM tblname;



-- employees -> 번호(PK) 입력 -> 이름(성+이름) 반환 -> tblfullname에 추가
CREATE OR REPLACE PROCEDURE proc_addfullname
(
      id NUMBER
)
IS
      vname VARCHAR2(50);
BEGIN
      SELECT first_name || ' ' || last_name INTO vname FROM employees
            WHERE employee_id = id;
      INSERT INTO tblfullname VALUES (vname);
END;

SELECT * FROM employees;
SELECT * FROM tblfullname;

TRUNCATE TABLE tblfullname;

BEGIN
      proc_addfullname(100);
      proc_addfullname(123);
      proc_addfullname(158);
END;



--1. ID -> Full Name 반환
CREATE OR REPLACE PROCEDURE proc_getfullname
(
      pid IN VARCHAR2,
      pname OUT VARCHAR2
)
IS
BEGIN
      SELECT first_name || ' ' || last_name INTO pname FROM employees
            WHERE employee_id = pid;
END;

--2. Full Name -> insert
CREATE OR REPLACE PROCEDURE proc_inserftfullname
(
      pname IN VARCHAR2
)
IS
BEGIN
      INSERT INTO tblfullname VALUES (pname);
END;

-- 조합
DECLARE
      vname VARCHAR2(50);
BEGIN
      --1.
      proc_getfullname(135, vname);
      --2.
      proc_inserftfullname(vname);
END;

SELECT * FROM tblfullname;


--조합 -> 프로시저 생성
CREATE OR REPLACE PROCEDURE proc_addfullname
(
      vid NUMBER
)
IS
      vname VARCHAR2(50);
BEGIN
      --1.
      proc_getfullname(vid, vname);
      --2.
      proc_inserftfullname(vname);
END;


BEGIN
      proc_addfullname(167);
      proc_addfullname(168);
      proc_addfullname(169);
END;

SELECT * FROM tblfullname;


-- 2종류 매개변수 모드
CREATE OR REPLACE PROCEDURE proc_getname(
      pnum IN NUMBER, --직원 번호(매개변수)
      pname OUT VARCHAR2 --직원명(반환값)
)
IS
      --vname VARCHAR2(30);
BEGIN
      SELECT name INTO pname FROM tblinsa WHERE num = pnum;

      --위의 이름을 가지고 다른 테이블에 UPDATE 실행
      --UPDATE table set name = vname...
END;


DECLARE
      vname VARCHAR2(50);
BEGIN
      proc_getname(1001, vname);
      dbms_output.put_line(vname);
END;

CREATE TABLE tbladdress
(
      seq NUMBER PRIMARY KEY, --PK
      name VARCHAR2(30) NOT NULL , --이름
      age NUMBER(3) NOT NULL , --나이
      tel VARCHAR2(15) NOT NULL , --전화번호
      address VARCHAR2(500) NOT NULL , --주소
      regdate DATE DEFAULT sysdate NOT NULL --등록일
);
CREATE SEQUENCE address_seq; --addressSeq

-- 주소록 항목을 추가하는 프로시저 + CRUD
CREATE OR REPLACE PROCEDURE proc_add_address(
      pname VARCHAR2,
      page NUMBER,
      ptel VARCHAR2,
      paddress VARCHAR2,
      presult OUT NUMBER --성공 유무
)
IS
BEGIN
      INSERT INTO tbladdress (seq, name, age, tel, address)
            VALUES (address_seq.nextval, pname, page, ptel, paddress);
      presult := 1; --성공
      COMMIT;
EXCEPTION
      WHEN OTHERS THEN
            presult := 0; --실패
            ROLLBACK;
END;

DECLARE
      vresult NUMBER; --성공유무
BEGIN
      proc_add_address('홍길동', 1234, '010-1111-2222', '서울시 강남구 역삼동', vresult);

      IF vresult = 1 THEN
            dbms_output.put_line('주소록 추가 완료');
      ELSE
            dbms_output.put_line('주소록 추가 실패');
      END IF;
END;



-- R : 번호 -> 1명분 리턴
-- 반환값이 다중 컬럼 or 다중 행 프로시저
-- 1. OUT 매개변수 : 단일 행
-- 2. CURSOR : 다중 행
CREATE OR REPLACE PROCEDURE proc_read_address(
      pseq IN NUMBER, --주소록 번호
      pname OUT VARCHAR2,
      page OUT NUMBER,
      ptel OUT VARCHAR2,
      paddress OUT VARCHAR2,
      pregdate OUT DATE,
      presult OUT NUMBER --성공 유무
)
IS
BEGIN
      SELECT name, age, tel, address, regdate
            INTO pname, page, ptel, paddress, pregdate
                  FROM tbladdress
                        WHERE seq = pseq;
      presult := 1;
EXCEPTION
      WHEN OTHERS THEN
            presult := 0;
END;

DECLARE
      vname VARCHAR2(30);
      vage NUMBER(3);
      vtel VARCHAR2(15);
      vaddress VARCHAR2(50);
      vregdate DATE;
      vresult NUMBER;
BEGIN
      proc_read_address(0, vname, vage, vtel, vaddress, vregdate, vresult);
      IF vresult = 1 THEN
            dbms_output.put_line(vname);
            dbms_output.put_line(vage);
            dbms_output.put_line(vtel);
            dbms_output.put_line(vaddress);
            dbms_output.put_line(vregdate);
      ELSE
            dbms_output.put_line('주소록 읽기 실패');
      END IF;
END;





-- U : 수정(seq 빼고 모두 다)
CREATE OR REPLACE PROCEDURE proc_edit_address(
      pseq NUMBER,
      pname VARCHAR2,
      page NUMBER,
      ptel VARCHAR2,
      paddress VARCHAR2,
      presult OUT NUMBER
)
IS
      vcount NUMBER;
BEGIN

      SELECT count(*) INTO vcount FROM tbladdress WHERE seq = pseq;

      IF vcount = 1 THEN
            UPDATE tbladdress SET
                  name = pname,
                  age = page,
                  tel = ptel,
                  address = paddress
                        WHERE seq = pseq;
            presult := 1;
            COMMIT;
      ELSE
            presult := 2;
      END IF;

EXCEPTION
      WHEN OTHERS THEN
            presult := 0;
            ROLLBACK ;
END;


-- name, age, tel, address, regdate
DECLARE
      vresult NUMBER;
BEGIN

      proc_edit_address(2, '홍길동', 21, '010-1111-2222', '서울시 강남구 역삼동', vresult);

      IF vresult = 1 THEN
            dbms_output.put_line('주소록 수정 완료');
      ELSIF vresult = 0 THEN
            dbms_output.put_line('주소록 수정 실패');
      ELSIF vresult = 2 THEN
            dbms_output.put_line('수정 대상 없음');
      END IF;

END;





-- D : 번호 -> 삭제
CREATE OR REPLACE PROCEDURE proc_del_address (
      vseq NUMBER,
      vresult OUT NUMBER
)
IS
      vcount NUMBER;
BEGIN
      SELECT  count(*) INTO vcount FROM tbladdress WHERE seq = vseq;

      IF vcount = 1 THEN
            DELETE FROM tbladdress WHERE seq = vseq;
            vresult := 1;
            COMMIT;
      ELSE
            vresult := 2;
      END IF;

EXCEPTION
      WHEN OTHERS THEN
            vresult := 0;
            ROLLBACK;
END;


DECLARE
      vresult NUMBER;
      RCOMPLETE CONSTANT NUMBER := 1;
      RNOTFOUND CONSTANT NUMBER := 2;
      RFAILD CONSTANT NUMBER := 0;
BEGIN

      proc_del_address(1, vresult);

      IF vresult = RCOMPLETE THEN
            dbms_output.put_line('주소록 삭제 완료');
      ELSIF vresult = RNOTFOUND THEN
            dbms_output.put_line('삭제 대상 없음');
      ELSIF vresult = RFAILD THEN
            dbms_output.put_line('주소록 삭제 실패');
      END IF;

END;



-- 부모 테이블(PK) <-> 자식 테이블(FK + 일반 컬럼) : 비식별 관계
-- 부모 테이블(PK) <-> 자식 테이블(FK + PK 컬럼) : 식별 관계

-- 회원 가입
-- 1. 회원 정보 테이블
-- 2. 회원 부가 정보 테이블
CREATE TABLE tblmain ( --주요 정보 테이블
      seq NUMBER PRIMARY KEY , --식별자(PK)
      id VARCHAR2(30) UNIQUE NOT NULL, --아이디
      pw VARCHAR2(30) NOT NULL , --암호
      name VARCHAR2(50) NOT NULL --이름
);

CREATE TABLE tblsub ( --부가 정보 테이블
      seq NUMBER PRIMARY KEY , --식별자(PK)
      age NUMBER NULL , --나이
      tel VARCHAR2(15) NULL, --연락처
      address VARCHAR2(100) NULL, --주소
      --id VARCHAR2(30) REFERENCES tblmain(id) NOT NULL --아이디(FK)
      mseq NUMBER REFERENCES tblmain(seq) NOT NULL --회원번호(FK)
);

DROP TABLE tblmain;
DROP TABLE tblsub;


--회원 가입 프로시저
CREATE or REPLACE PROCEDURE proc_register(
      pid VARCHAR2,
      ppw VARCHAR2,
      pname VARCHAR2,
      page NUMBER,
      ptel VARCHAR2,
      paddress VARCHAR2
)
IS
      vseq NUMBER;
BEGIN

      --1. 주요 정보 추가
      INSERT INTO tblmain (seq, id, pw, name)
            VALUES (mainseq.nextval, pid, ppw, pname);

      --1.5 마지막 회원 번호를 가져오기
      SELECT max(seq) INTO vseq FROM tblmain;

      --2. 부가 정보 추가
      INSERT INTO tblsub (seq, age, tel, address, mseq)
            VALUES (subseq.nextval, page, ptel, paddress, vseq);

END;


--시퀀스 객체
CREATE SEQUENCE mainseq;
CREATE SEQUENCE subseq;


-- 회원 가입 -> 아이디(UNIQUE)
CREATE OR REPLACE PROCEDURE proc_idcheck(
      pid VARCHAR2,
      presult OUT NUMBER
)
IS
BEGIN
      SELECT count(*) INTO presult FROM tblmain WHERE id = pid;
END;


DECLARE
      vresult NUMBER;
BEGIN
      proc_idcheck('test', vresult);

      IF vresult = 1 THEN
            dbms_output.put_line('이미 사용중입니다.');
      ELSE
            dbms_output.put_line('사용이 가능합니다.');
      END IF;
END;


BEGIN
      proc_register('hong', '111', '홍길동', 20, '010-1111-1111', '서울시');
END;



SELECT * FROM tblstaff;
SELECT * FROM tblproject;

-- 1. 신규 사원 입사 + 프로젝트 할당
BEGIN
      proc_add_employee(7, '후후후', 180, '부산시', 7, '유지 보수');
END;

-- 2. 직원 퇴사 + 업무 위임
BEGIN
      proc_del_employee(7, 2);
END;


CREATE OR REPLACE PROCEDURE proc_add_employee(
      pseq NUMBER,
      pname VARCHAR2,
      psalary NUMBER,
      paddress VARCHAR2,
      ppseq NUMBER,
      pproject VARCHAR2
)
IS
BEGIN
      INSERT INTO tblstaff VALUES (pseq, pname, psalary, paddress);
      --INSERT INTO tblstaff VALUES (staffseq.nextval, pname, psalary, paddress);

      INSERT INTO tblproject VALUES (ppseq, pproject, pseq);
      --INSERT INTO tblproject VALUES (projectseq.nextval, pproject, staffseq.currval);
END;


CREATE OR REPLACE PROCEDURE proc_del_employee(
      pseq1 NUMBER,
      pseq2 NUMBER
)
IS
BEGIN

      UPDATE tblproject SET staff = pseq2 WHERE pseq1;

      DELETE FROM tblstaff WHERE seq = pseq1;

END;




/*
저장 프로그램
1. 프로시저
2. 함수

함수, Function
- 인자(1개 이상) -> 반환값(1개) 프로시저
- 절대로 OUT 파라미터를 사용하지 말것  ->  return 문 사용
*/

--프로시저
CREATE OR REPLACE PROCEDURE proc_aaa(
      pnum1 NUMBER,
      pnum2 NUMBER,
      presult OUT NUMBER
)
IS
BEGIN
      presult := pnum1 + pnum2;
END;


--프로시저 사용
DECLARE
      vresult NUMBER;
      vheight NUMBER;
      vweight NUMBER;
      CURSOR vcursor IS
            SELECT height, weight FROM TBLNAME;
BEGIN

      --프로시저 + 상수(변수)
      proc_aaa(10, 20, vresult);
      dbms_output.put_line(vresult);

      --SELECT -> 컬럼 2개 -> 프로시저 + 컬럼값
      SELECT height, weight INTO vheight, vweight
            FROM tblname WHERE nick = '메뚜기';

      proc_aaa(vheight, vweight, vresult);
      dbms_output.put_line(vresult);


      --SELECT -> 컬럼 2개 -> 프로시저 + 컬럼값 x 레코드 수
      OPEN vcursor;
      LOOP
            FETCH vcursor INTO vheight, vweight;
            EXIT WHEN vcursor%NOTFOUND;

            --프로시저 호출
            proc_aaa(vheight, vweight, vresult);
            dbms_output.put_line(vresult);

      END LOOP;
      CLOSE vcursor;

END;


--함수
CREATE OR REPLACE FUNCTION fn_bbb(
      vnum1 NUMBER,
      vnum2 NUMBER
) RETURN NUMBER
IS
BEGIN
      return vnum1 + vnum2;
END;


DECLARE
      vresult NUMBER;
      CURSOR vcursor IS
            SELECT fn_bbb(height, weight) as result FROM tblname;
BEGIN

      proc_aaa(10, 20, vresult); --OUT

      --함수 + 상수(변수)
      vresult := fn_bbb(10, 20); --return
      dbms_output.put_line(vresult);



      --SELECT height, weight INTO vheight, vweight
      --     FROM tblname WHERE nick = '메뚜기';
      --proc_aaa(vheight, vweight, vresult);
      --vresult := fn_bbb(vheight, vweight);


      SELECT fn_bbb(height, weight) INTO vresult
            FROM tblname WHERE nick = '메뚜기';

      dbms_output.put_line(vresult);



      --SELECT fn_bbb(height, weight) FROM tblname;

      FOR aaa IN (SELECT fn_bbb(height, weight), first || last as name FROM tblname) LOOP
            dbms_output.put_line(aaa.name);
      END LOOP;

END;


/*
프로시저 vs 함수 차이점
1. 매개변수
      a. 프로시저 : 0 ~ 마음대로..
      b. 함수 : 1개 ~ 마음대로..
2. 반환값
      a. 프로시저 : 0 ~ 마음대로.. + OUT 사용
      b. 함수 : 1개 + return 사용
3. 사용 위치
      a. 프로시저 : PL/SQL 일부로..
      b. 함수 : 표준 SQL 일부로..
*/


-- tblinsa -> 성별
SELECT name, substr(ssn, 8, 1) FROM tblinsa;

SELECT name,
      CASE
            WHEN substr(ssn, 8, 1) = '1' THEN '남자'
            WHEN substr(ssn, 8, 1) = '2' THEN '여자'
      END
FROM tblinsa;

CREATE OR REPLACE FUNCTION fn_get_gender(
      pssn VARCHAR2 --ssn
) RETURN VARCHAR2
IS
BEGIN
      CASE
            WHEN substr(pssn, 8, 1) = '1' THEN RETURN '남자';
            WHEN substr(pssn, 8, 1) = '2' THEN RETURN '여자';
            ELSE RETURN NULL;
      END CASE;
END;

SELECT name, fn_get_gender(ssn) FROM tblinsa;

/*
트리거, Trigger
- 프로시저의 일종
- 특정 사건이 발생하면 자동으로 실행되는 프로시저
- 개발자 실행(X), DBMS 실행(O)
- 특정 사건 : 특정 테이블을 대상으로 오라클 실시간 감시(INSERT, UPDATE, DELETE) -> 미리 준비해 놓은 프로시저를 호출한다.
- 연속적 작업을 손쉽게 구현(사람이 직접 하는것보다 편함)
- 실시간 감시 : 비용 발생 -> 너무 많이 사용하면 안좋다.



트리거 구문

CREATE OR REPLACE TRIGGER 트리거명
      --트리거 옵션
      BEFORE|AFTER --사건 발생 전|후
      INSERT|UPDATE|DELETE --사건종류
      ON 테이블명 --사건 대상 테이블
      [FOR EACH ROW]
DECLARE
      선언부;
BEGIN
      실행부;
EXCEPTION
      예외부;
END

*/

-- 특정 요일(목)에는 tblname의 데이터를 조작할 수 없다.(단, SELECT만 가능)
CREATE OR REPLACE TRIGGER trg_name
      BEFORE
      INSERT OR UPDATE OR DELETE
      ON tblname
BEGIN
      --구현..
      --dbms_output.put_line('trg_name 트리거가 실행되었습니다.');
      IF to_char(sysdate, 'd') = 5 THEN
            -- 강제로 예외 발생, 사용자 정의 예외 발생
            -- 자바 : throw new Exception();
            -- 숫자 : -20000 ~ -29990
            raise_application_error(-20000, '목요일에는 tblname 조작이 불가능합니다.');
      END IF;
END;

--tblname
SELECT * FROM tblname;

INSERT INTO tblname VALUES ('호호', '호', 'f', 165, 50, '방글이');

UPDATE tblname SET first = '헤헤' WHERE nick = '방글이';



-- 로그 트리거
-- tblname에 변화가 생기면 나중에 관리자가 보기 위한 로그를 기록하자
DROP  table tbllog;

CREATE TABLE tbllog (
      seq NUMBER PRIMARY KEY,
      message VARCHAR2(1000) NOT NULL,
      regdate DATE DEFAULT sysdate NOT NULL
);
CREATE SEQUENCE logseq;

DROP TRIGGER trg_name;

CREATE OR REPLACE TRIGGER trg_name
      AFTER
      INSERT OR DELETE
      ON tblname
DECLARE
      vmessage varchar2(1000);
BEGIN

      IF INSERTING THEN
            vmessage := 'tblname 테이블로 새로운 행이 추가되었습니다.';
      ELSIF DELETING THEN
            vmessage := 'tblname 테이블로 기존 행이 삭제되었습니다.';
      ELSE
            vmessage := '기타';
      END IF;

      INSERT INTO tbllog (seq, message, regdate)
            VALUES (logseq.nextval, vmessage, DEFAULT );--로그 기록


END;

DELETE FROM tblname WHERE nick =  '방글이';
INSERT INTO tblname VALUES ('호호', '호', 'f', 165, 50, '방글이');

SELECT * FROM tbllog;



/*
[FOR EACH ROW]

1. 생략
- 문장 단위 트리거
- 트리거 실행 횟수 1회 : 사건 발생 1회 -> 트리거 실행 1회
- DELETE FROM tblinsa WHERE buseo = '영업부'; -> "영업부 직원 삭제"

2. 표현
- 행 단위 트리거
- 트리거 실행 횟수 반복 : 사건이 적용된는 행의 갯수 -> 트리거 실행 횟수
- DELETE FROM tblinsa WHERE buseo = '영업부'; -> "영업부 직원 1명 1명.. 삭제"

*/
SELECT * FROM tbladdress;

DECLARE
      vresult NUMBER;
BEGIN
      proc_add_address('홍길동', 20, '010-1234-5678', '서울시', vresult);
      proc_add_address('아무개', 22, '010-5555-5555', '서울시', vresult);
      proc_add_address('하하하', 23, '010-6666-6666', '서울시', vresult);
END;

CREATE OR REPLACE TRIGGER trg_address
      AFTER
      UPDATE
      ON tbladdress
	FOR EACH ROW
BEGIN
      dbms_output.put_line('[' || to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss')
                                                || '] 주소록이 수정되었습니다.');
END;

UPDATE tbladdress SET age = 30 WHERE name = '홍길동';
UPDATE tbladdress SET age = 27 WHERE name = '아무개';
UPDATE tbladdress SET address = '서울시';
UPDATE tbladdress SET address = '인천시' WHERE floor(age / 10) = 2;

SELECT * FROM tbladdress;



/*
FOR EACH ROW 를 사용하는 경우
- 상관 관계
- :old, :new : 상관 관계 변수를 사용하면 사건을 발생시킨 데이터에 접근 가능

1. INSERT 작업 발생
- 트리거내에서 방금 INSERT 된 행의 컬럼값을 접근하고 싶다.
- :new <- 방금 추가된 행 참조 변수
- :new.컬럼명 <- 방금 추가된 행의 특정 컬럼값 참조
- :old 사용 불가
- AFTER 트리거에서만 사용 가능(BEFORE 사용 불가)

2. UPDATE 작업 발생
- 트리거내에서 방금 수정된 행의 수정되기 전의 값과 수정되는 난 후의 값을 접근하고 싶다.
- :new <- 방금 수정된 후의 행 참조
- :old <- 방금 수정되기 전의 행 참조

3. DELETE 작업 발생
- 트리거내에서 방금 삭제된 행의 값을 접근하고 싶다.
- :old <- 방금 삭제된 행 참조

*/

-- 게시판
CREATE TABLE tblboard
(
      seq NUMBER PRIMARY KEY, --글번호(PK)
      subject varchar2(1000) NOT NULL , --제목
      content varchar2(2000) NOT NULL , --내용
      comment_count NUMBER DEFAULT 0 NOT NULL  --글에 달린 댓글 수
);

-- 댓글
CREATE TABLE tblcomment
(
      seq NUMBER PRIMARY KEY, --댓글 번호(PK)
      subject varchar2(1000) NOT NULL , --제목
      content varchar2(2000) NOT NULL , --내용
      board_seq NUMBER REFERENCES tblboard(seq) --부모글 번호(FK)
);

CREATE SEQUENCE boardseq;
CREATE SEQUENCE commentseq;

-- 글쓰기
INSERT INTO tblboard
      VALUES (boardseq.nextval, '게시판입니다.', '내용입니다.', DEFAULT);

INSERT INTO tblboard
      VALUES (boardseq.nextval, '오라클 트리거 만드는 중..', '내용입니다.', DEFAULT);

INSERT INTO tblboard
      VALUES (boardseq.nextval, '프로젝트 회의 내용입니다.', '내용입니다.', DEFAULT);

-- 댓글 쓰기
INSERT INTO tblcomment
      VALUES (commentseq.nextval, '요구 분석 자료입니다.', '내용', 2);

UPDATE tblboard SET
      comment_count = comment_count + 1 WHERE seq = 3;

SELECT * FROM tblboard;
SELECT * FROM tblcomment;


-- m1. 트랜잭션을 걸어놓은 프로시저 생성
-- CREATE OR REPLACE PROCEDURE 댓글쓰기(
--       ...
-- )
-- IS
-- BEGIN
--       INSERT :  댓글쓰기;
--       UPDATE : 댓글수 증가
--       COMMIT;
-- END;

-- m2. tblcomment 테이블에 INSERT에 대한 트리거 생성
CREATE or REPLACE TRIGGER trg_comment_add
      AFTER
      INSERT OR DELETE
      ON tblcomment
      FOR EACH ROW -- :old, :new
BEGIN
      dbms_output.put_line('댓글 쓰기 완료');

      --INSERT INTO tblcomment
      --    VALUES (commentseq.nextval, '요구 분석 자료입니다.', '내용', 3);

      IF INSERTING THEN
            UPDATE tblboard SET
                  comment_count = comment_count + 1 WHERE seq = :new.board_seq;
      ELSIF DELETING THEN
            UPDATE tblboard SET
                  comment_count = comment_count - 1 WHERE seq = :old.board_seq;
      END IF ;

END;


DELETE FROM tblcomment WHERE seq = 1;

SELECT * FROM tblcomment;
SELECT * FROM tblboard;







-- 회원 테이블(포인트) + 게시판 테이블 + 댓글 테이블
-- : 게시판 글을 쓰면 회원에게 포인트 100 증가
-- : 댓글을 쓰면 회원에게 포인트 20 증가

SELECT * FROM tabs;

DROP TABLE tblcomment;
DROP TABLE tblboard;
DROP TABLE tblrent;
DROP TABLE tblmember;

--회원 테이블
CREATE TABLE tblmember
(
      seq NUMBER PRIMARY KEY, --기본키
      name VARCHAR2(30) NOT NULL , --이름
      point NUMBER DEFAULT 1000 NOT NULL --포인트(기본 1000)
);

--게시판 테이블
CREATE TABLE tblboard
(
      seq NUMBER PRIMARY KEY , --글번호
      subject varchar2(1000) NOT NULL , --제목
      mseq NUMBER REFERENCES tblmember(seq) NOT NULL, --글쓴이(FK)
      comment_count NUMBER DEFAULT 0 NOT NULL --댓글 수
);

--댓글 테이블
CREATE TABLE tblcomment
(
      seq NUMBER PRIMARY KEY , --댓글번호
      subject varchar2(1000) NOT NULL , --제목
      mseq NUMBER REFERENCES tblmember(seq) NOT NULL, --글쓴이(FK)
      board_seq NUMBER REFERENCES tblboard(seq) NOT NULL --부모글번호(FK)
);

INSERT INTO tblmember VALUES (1, '홍길동', DEFAULT);





-- 게시판 글쓰기 -> 포인트 100 증가
CREATE OR REPLACE TRIGGER trg_board
      AFTER
      INSERT
      ON tblboard
      FOR EACH ROW
BEGIN

      --:new.mseq --방금 게시물을 작성한 회원 번호
      UPDATE tblmember SET
            point = point + 100 where seq = :new.mseq;

END;



-- 댓글 글쓰기 -> 포인트 20 증가
CREATE OR REPLACE TRIGGER trg_comment
      AFTER
      INSERT
      ON tblcomment
      FOR EACH ROW
BEGIN

      --:new.mseq --방금 게시물을 작성한 회원 번호
      UPDATE tblmember SET
            point = point + 20 where seq = :new.mseq;

END;


INSERT INTO tblboard VALUES (boardseq.nextval, '테스트', 1, DEFAULT);
INSERT INTO tblcomment VALUES (commentseq.nextval, '테스트', 1, 4);

SELECT * FROM tblboard;
SELECT * FROM tblmember;
SELECT * FROM tblcomment;




/*
DB Object 구현 단계

1. 테이블 생성
2. 뷰 생성
3. 인덱스 생성
4. SQL 생성(SELECT, UPDATE, INSERT, DELETE) - 요구 업무
5. 함수 or 프로시저 생성 + 트리거 생성
6. 더미 데이터 확보

*/

--미리 완성한 SQL -> 프로시저 구현

--1. 추가 작업
CREATE OR REPLACE PROCEDURE 추가작업(
      추가 데이터 -> IN 매개 변수
      성공 유무 반환 -> OUT 매개 변수
)
IS
      내부 변수
BEGIN
      INSERT..
      COMMIT;
EXCEPTION
      WHEN OTHERS THEN
            예외작업..
            ROLLBACK;
END;


--2. 수정 작업
CREATE OR REPLACE PROCEDURE 수정작업(
      추가 데이터 -> IN 매개 변수
      성공 유무 반환 -> OUT 매개 변수
)
IS
      내부 변수
BEGIN
      UPDATE..
      COMMIT;
EXCEPTION
      WHEN OTHERS THEN
            예외작업..
            ROLLBACK;
END;



--3. 삭제 작업
CREATE OR REPLACE PROCEDURE 삭제작업(
      삭제 데이터 -> IN 매개 변수
      성공 유무 반환 -> OUT 매개 변수
)
IS
      내부 변수
BEGIN
      DELETE..
      COMMIT;
EXCEPTION
      WHEN OTHERS THEN
            예외작업..
            ROLLBACK;
END;


--4. 읽기 작업 - 조건 선택 + 반환 (단일 컬럼 + 단일 레코드)
CREATE OR REPLACE PROCEDURE 읽기작업(
      조건 데이터 IN 매개변수 사용
      단일 반환값 OUT 매개변수 사용
)
IS
      내부 변수
BEGIN
      SELECTG
      COMMIT;
EXCEPTION
      WHEN OTHERS THEN
            예외작업..
            ROLLBACK;
END;



--4. 읽기 작업 - 조건 선택 + 반환 (다중 컬럼 + 단일 레코드)
CREATE OR REPLACE PROCEDURE 읽기작업(
      조건 데이터 IN 매개변수 사용
      반환값 OUT 매개변수 사용
      반환값 OUT 매개변수 사용
      반환값 OUT 매개변수 사용
      반환값 OUT 매개변수 사용
)
IS
      내부 변수
BEGIN
      SELECT
      COMMIT;
EXCEPTION
      WHEN OTHERS THEN
            예외작업..
            ROLLBACK;
END;





--4. 읽기 작업 - 조건 선택 + 반환 (컬럼 + 다중 레코드)
SELECT * FROM tblinsa WHERE buseo = '?';

CREATE OR REPLACE PROCEDURE proc_get_buseo(
      pbuseo IN VARCHAR2, --조건
      presult OUT SYS_REFCURSOR --반환값으로 사용하는 CURSOR 자료형 :결과 테이블 자신
)
IS
      --CURSOR  vcursor IS SELECT ...
BEGIN

      OPEN presult
            FOR SELECT * FROM tblinsa WHERE buseo = pbuseo;

      --CLOSE presult;

END;


DECLARE
      vresult SYS_REFCURSOR;
      vrow tblinsa%rowtype;
BEGIN
      proc_get_buseo('영업부', vresult); -- SELECT -> 결과셋을 커서 형태로 반환

      --SYS_REFCURSOR : FOR LOOP 사용 불가
      LOOP
            FETCH vresult INTO vrow;
            EXIT WHEN vresult%NOTFOUND;

            dbms_output.put_line(vrow.name || ' - ' || vrow.buseo);
      END LOOP;

END;







/*
기본키 -> 복합키(Composite Key)
*/

CREATE TABLE tblparent
(
      father VARCHAR2(50) NOT NULL ,--아빠
      mother VARCHAR2(50) NOT NULL , --엄마
      tel VARCHAR2(15) NOT NULL ,
      address VARCHAR2(100) NOT NULL,
      CONSTRAINT tblparent_father_mother_pk PRIMARY KEY(father, mother)
);

INSERT INTO tblparent VALUES ('홍길동', '호호호', '010-1111-1111', '서울시');
INSERT INTO tblparent VALUES ('아무개', '테스트', '010-2222-2222', '서울시');
INSERT INTO tblparent VALUES ('홍길동', '호호호', '010-3333-4444', '부산시');
INSERT INTO tblparent VALUES ('홍길동', '헤헤헤', '010-3333-4444', '부산시');

SELECT * FROM tblparent;


-- 자식 테이블
CREATE TABLE tblchild
(
      name VARCHAR2(50) PRIMARY KEY, --자식 이름
      corder NUMBER NOT NULL , --자식 순서
      --father VARCHAR2(50) REFERENCES tblparent(father, mother) NOT NULL ,
      --mother VARCHAR2(50) REFERENCES tblparent(mother) NOT NULL
      father VARCHAR2(50) NOT NULL ,
      mother VARCHAR2(50)  NOT NULL,
      CONSTRAINT tblchild_father_mother_fk
            FOREIGN KEY(father, mother) REFERENCES tblparent(father, mother)
);

INSERT INTO tblchild VALUES ('홍순신', 1, '홍길동', '호호호');
INSERT INTO tblchild VALUES ('홍미미', 2, '홍길동', '테스트');


SELECT * FROM tblparent p
      INNER JOIN tblchild c
            ON p.father = c.father AND p.mother = c.mother;
























