--ex03_select.sql


/*

SELECT 문
1. 테이블로부터 원하는 데이터를 가져오는 명령어
    :클라이언트 -> (SELECT 요쳥) -> 서버 -> (표 형태로 반환, ResultSet, ResultTable)
    
2. 테이블이 아닌것으로부터 데이터를 가져오는 명령어 


*** SQL은 일반적으로 1개(2개) 이상의 구(절)이 조합되어 문장을 만든다.

SELECT 구문

SELECT 컬럼리스트 FROM 테이블명;
SELECT 컬럼리스트 FROM 테이블명 WHERE절;
SELECT 컬럼리스트 FROM 테이블명 WHERE절 ODER BY절;
SELECT 컬럼리스트 FROM 테이블명 WHERE절 GROUP BY절 ODER BY절;
SELECT 컬럼리스트 FROM 테이블명 WHERE절 GROUP BY절 HAVING절 ODER BY절;
SELECT 컬럼리스트 FROM 테이블명 [WHERE절] BY절 [HAVING절] [ODER BY절];

1. SELECT 컬럼리스트
    : 가져올 컬럼을 지정한다.
FROM 테이블명;
    : 가져올 테이블을 지정한다.
    
    
    
*/
DESC tbltype;

SELECT txt1
FROM tbltype;

SELECT*FROM tabs;

SELECT*FROM TBLNAME;
DESC tblname;


--tblname로부터 이름(first)을 가져오시오.
SELECT first FROM tblname;
SELECT gender FROM tblname;
SELECT tel FROM tblname; --ORA-00904: "TEL": invalid identifier --에러코드 찾을 때 숫자로 찾기

-- 성 + 이름
SELECT first, last FROM tblname;
SELECT last, first FROM tblname;
SELECT last, first, nick FROM tblname;

--1번 권장, 1번으로 습관 들이세요. 
SELECT last, first, nick, gender, weight, height FROM tblname;  --1번
SELECT*FROM tblname; --2번

--컬럼리스트에는 동일한 컬럼이 1개 이상 올 수 있다. 
SELECT nick FROM tblname;
SELECT nick, nick FROM tblname;
SELECT nick, length(nick) FROM tblname;
SELECT nick, nick, nick FROM tblname;



--SELECT first
--FROM tblname;

--SELECT first
--FROM tblname;

--SELECT 
--    first
--FROM 
--    tblname;

SELECT*FROM tblcountry;
SELECT*FROM tbldiary;
SELECT*FROM tblhousekeeping;
SELECT*FROM tblinsa;
SELECT*FROM tblmen;
SELECT*FROM tblwomen;
SELECT*FROM tbltodo;

/*
오라클 상수 표현
1. 숫자형
    a. 정수형
        ex) 10
    b. 실수형
        ex) 3.14
        
2. 문자(문자열)형
    ex)'김', '홍길동'
    
3. 날짜형 상수
    ex) '2018-01-12' : 문자형 상수 -> (형변환) -> 날짜형 : 문맥에 따라 달라짐 (날짜 or 문자)
    ex) '100'
    ex) '2018년 01월 12일' --X(국제 표기 기준)
    ex) '2018-01-12','2018/01/12'       
*/

--컬럼값의 연산
--SELECT의 대상인 컬럼값들은 순수하게 반환받을 수 있고, 혹은 연산이나 함수의 매개값으로 사용할 수 있다. 
--혹은 연산이나 함수의 매개값으로 사용할 수 있다.
--SELECT name, basicpay FROM tblinsa;
SELECT name, basicpay, basicpay*1.1 FROM tblinsa;

SELECT last, first, weight, weight+3 FROM tblname;

SELECT name, length(name) FROM tblcountry;

--BMI
SELECT last, first, weight/height*height FROM tblname;

--문자열 더하기
SELECT last, first, last + first FROM tblname;
SELECT last, first, last || first FROM tblname;

SELECT last, last FROM tblname;

--결과셋의 컬럼명을 바꾸기
-- : 별칭(Alias) 지정하기 
-- : 이름 바꾸기(***원본이 바뀌는 것이 아님)
-- : 컬럼명 as 별명

SELECT last, last, last || first AS FROM tblname;
SELECT last as 성, last as 이름, last || first AS 전체이름 FROM tblname; --식별자에 공백포함, 특수문자포함, 숫자시작 안됨

SELECT last as 성, last as 이름, last || first AS "전체 이름" FROM tblname;  --식별자 사이에 공백넣어서 별명만들고 싶을 때 
SELECT 성, 이름, "전체이름" FROM 위의 테이블;

SELECT weight AS "from" FROM tblname; --예약어와 같은 이름을 식별자로 사용하고 싶을 떄  

-- 객체 표기법
SELECT * FROM tblname;
SELECT * FROM hr.tblname;

SELECT hr.tblname.first, hr.tblname.last FROM hr.tblname;

SELECT hr.tblname.first, hr.tblname.last FROM hr.tblname;

SELECT n.first, n.last FROM tblname n; --테이블 별칭
SELECT first, last FROM tblname n; --테이블 별칭

SELECT *, weight+100 FROM tblname; -- 이 경우 반드시 앞에 테이블 컬럼명을 써줘야 한다.
SELECT tblname.*,weight+100 FROM tblname; -- 이 경우 반드시 앞에 테이블 컬럼명을 써줘야 한다.
SELECT n.*, weight+100 FROM tblname n;

/*
    SQL 구(절)의 실행 순서 (우선 순위) --암기하기
    
    1. SELECT 절 - 2번
    2. FROM절 - 1번
    
*/

--SELECT last, first 
--FROM tblname;
--
--SELECT FIRST
--FROM tblname;
--
--SELECT first, last FROM tblname;


--시스템 테이블
--1. tabs
-- : 해당 유저가 소윺하고 있는 테이블 목록
-- 2. dual
-- : 더미 테이블
-- : 테이블 자체는 의미가 없음;

-- sysdate : Calendar.getInstance();

SELECT sysdate FROM dual; --X

SELECT first, sysdate FROM tblname; --오라클은 매개값이 없으면 ()안해도 됨 
SELECT 100* 2 FROM dual;

/*
연산자

1. 산술연산자
    - +, -, *, /
    - 나머지 연산자가 없음 -> 함수로 제공(mod())
    
2. 비교연산자 
    - >, >=, <, <=
    - =(==), <>(!=)
3. 논리연산자 
    - and(&&), or(||), not(!)
    
4. 문자열 연산자
    - ||(concat)
    
5. SQL 연산자
    - Java : instanceof, typeof...
    - in, between, like, is, any, all 등...
    */

SELECT 10>5 FROM dual;

SELECT '만족' FROM dual WHERE 10>5;

-- NULL
-- : 자바의 NULL과 유사한 표현 
-- : SQL에서 NULL은 연산의 대상이 될 수 없다.(피연산자 자격X)
-- : SQL은 NULL이 포함된 연산을 하게 되면 무조건 NULL을 반환


SELECT 10 + NULL FROM dual;
SELECT NULL*300 FROM dual;
SELECT 10 / NULL FROM dual;
SELECT NULL - 20 NULL FROM dual;




