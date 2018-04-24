-- ex04_where.sql

/*
WHERE절
-SELECT 컬럼리스트 FROM 테이블명 WHERE절
- 사용자가 데이터베이스 데이터를 가져올 때 항상 모든 데이터를 취하지는 않는다.
- 조건의 역할을 해서 일부 레코드만 가져오게 한다. -> 조건절
- 참, 거짓을 판단하는 연산식을 사용 -> 비교연산자&논리연산자

-WHERE 수평 필터링
-SELECT 수직 필터링



1.SELECT -3
2.FROM -1
3.WHERE -2
*/

SELECT*FROM tblname WHERE weight > 70;
SELECT*FROM tblname WHERE weight >= 70 and weight <=90;
SELECT first, last FROM tblname WHERE weight >= 70 and weight <=90;

--등호

SELECT*FROM tblname WHERE last ='김';
SELECT*FROM tblname WHERE height = 184;
SELECT*FROM tblinsa; WHERE ibsadate = '98/10/11';
SELECT*FROM tblinsa; WHERE ibsadate = '1998-10-11'; --권장

-- 오라클은 문자열 상수를 날짜형으로 자동 형변환을 시켜준다.
-- 시분초가 들어있으면 형변환 불가능 -> 함수 작업
SELECT*FROM tbltodo WHERE adddate = '2018-01-01 06:00:00';
SELECT*FROM tbltodo WHERE adddate = '2018-01-01'; --00:00:00 우리 대신에 시분초 자리에 뭔가를 넣었음 -> 0시 0분 0초  

--비교 연산
SELECT*FROM tblname WHERE height >= 170;

SELECT*FROM tblname WHERE 1 = 1; -- 누구라도 네라고 하는 조건 
SELECT*FROM tblname WHERE 1 > 0;

SELECT*FROM tblname WHERE weight / height*height >20; --연산, 함수의 결과도 WHERE 절에 들어갈 수 있음
SELECT name,lenght(name) FROM tblcountry WHERE length(name) >=3;

-- 비교 연산에 사용되는 자료형
--1. 숫자형
--2. 문자형 if("홍길동">"아무개")->if("홍길동".compareTo("아무개")>0)   --오라클에서는 문자형에서도 비교연산자 쓸 수 있음 
--3. 날짜 시간형 if(c1 > c2) -> tick    --날짜형끼리도 비교 가능 


SELECT*FROM tblname WHERE weight > 70;
SELECT*FROM tblname WHERE first > '마';
SELECT*FROM employees WHERE first_name < 'D';
SELECT*FROM tblinsa WHERE ibsadate >= '2000-01-01';





/*
between 
- where절에서 사용(조건으로 사용)
- 범위 조건 지정
- 컬럼명 between 최소값 and 최대값
- 가독성 향상
- 최소 최대값 모두 포함 (inclusive)
*/

SELECT*FROM tblname;
    WHERE weight >= 70 and weight <=90;
    
SELECT*FROM tblname
    WHERE weight BETWEEN 64 AND 90;
    
SELECT*FROM employees
    WHERE last_name BETWEEN 'D' AND 'F';
    
SELECT*FROM tblinsa
    WHERE ibsadate BETWEEN '1999-01-01' AND '2000-12-31';
    
- between절 사용 금지 > 비교(논리) 연산자를 사용하는게 속도가 더 빠름 

/*
in 
-WHERE절에서 사용(조건으로 사용)
-열거형 조건 비교 (제시된 값 중에서 하나라도 만족하면 true)\
-컬럼명 in(열거형 값)

*/

SELECT*FROM tblcountry;
    WHERE continent = 'AS' or continent = 'EU'
    
SELECT*FROM tblcountry
    WHERE continent IN ('AS','EU');

SELECT*FROM tblinsa
    --WHERE buseo = '기획부';
    WHERE buseo = '기획부' buseo = '영업부' or buseo = '총무부';\
    WHERE buseo IN('기획부','영업부','총무부');
        AND jikwi IN('부장','과장')AND city IN ('서울', '인천');
        AND basicpay BETWEEN 2500000 AND 3000000;
        
        
        
/*
like
- WHERE 절에서 사용(조건으로 사용)
- 패턴 조건(특정한 패턴을 가지는 문자열 검색)
- 컬럼명 like '패턴 문자열'
- 문자형을 대상으로 검색 

패턴 문자열 구성 요소
1. _ : 임의의 문자 1개
2. % : 임의의 문자 0개 ~ 무한대
*/        
        
SELECT name FROM tblinsa
    --WHERE name like '김__';
    WHERE name like '박%';--글자수를 특정지을 수 없을때 
    
SELECT*FROM employees
    --WHERE first_name like 'N____';
    --WHERE first_name like 'N%';
    --WHERE first_name like '__n_e';
    --WHERE first_name like 'N%e'
    --WHERE first_name like '%e';
    --WHERE first_name like '%te';
    WHERE first_name like '%an%';
    
SELECT*FROM 네이버
    --WHERE subject = '자바';
    --WHERE subject like '자바%';
    -- WHERE subject like '%자바%';
    WHERE subject like '%자바%문제%'
        OR subject like '%문제%자바%'
        OR subject like '%문제%'
        OR subject like '%자바%';
    
    
SELECT*FROM tblinsa;
    WHERE ssn like '______-1_____';
    WHERE tel like '019-____-____';
        

/*
null조건 
- where절에서 사용
- null 피연산자로 사용 불가 -> 조건에도 사용 불가
- 컬럼명 is null(컬럼명 == null)


*/
-- 인구수가 미기재인 나라? 
SELECT*FROM tblcountry
    --WHERE population = NULL; 
        -->결과값 안나옴 오라클은 피연산자로 NULL을 사용할 수 없음 
    WHERE population IS NULL;
    
-- tblinsa 연락처 미기재 직원?
SELECT*FROM tblinsa
    WHERE*FROM tblinsa WHERE tel IS NULL;

-- 인구수가 기재된 나라만
SELECT *FROM tblcountry
    WHERE population IS NOT NULL;

WHERE*FROM tblinsa WHERE tel IS NOT NULL;
SELECT*FROM tblinsa WHERE NOT tel IS NULL;

SELECT*FROM tblinsa WHERE city IN ('서울','인천','부산');
SELECT*FROM tblinsa WHERE NOT city IN ('서울','인천','부산');
SELECT*FROM tblinsa WHERE NOT name like '김%';

--completedate : 할일 완료 시각
-- 아직 일을 완료 못한것들만 가져오기
SELECT*FROM tbltodo WHERE completedate IS NULL;
SELECT*FROM tbltodo WHERE completedate IS NOT NULL;

-- 도서관 대여 테이블 
-- 대여일, 반납일

SELECT*FROM 대여테이블 WHERE 반납일 IS NULL; --아직 대여중인 목록

/*
distinct
- 컬럼리스트에서 사용
- distinct 컬럼명
- 중복값 제거
- NULL도 데이터의 한 종류로 인식한다. 
        -> NULL을 가지는 레코드들도 중복값 제거후에 1개 반환
- 복합 컬럼을 대상으로 distinct 사용
*/

--국가 테이블에 대륙이 뭐가 있는지?
SELECT continent FROM tblcountry;
SELECT DISTINCT continent FROM tblcountry;

--성이 뭐뭐 있는지?
SELECT gender FROM tblname;
SELECT DISTINCT gender FROM tblname;

-- tblinsa 직위가 어떤것들이 있는지?
SELECT DISTINCT jikwi FROM tblinsa;

SELECT DISTINCT last FROM tblname;
SELECT DISTINCT first FROM tblname;

SELECT DISTINCT population FROM tblcountry
    WHERE population IS NOT NULL ;
    
    
    
    
-- 남자 여자 테이블
DROP TABLE tblmen;
DROP TABLE tblwomen;


CREATE TABLE tblmen
(
	name varchar2(30) primary key,
	age number not null,
	height number null,
	weight number null,	
	couple varchar2(30) null
);

CREATE TABLE tblwomen
(
	name varchar2(30) primary key,
	age number not null,
	height number null,
	weight number null,
	couple varchar2(30) null
);


INSERT INTO tblmen VALUES ('홍길동', 25, 180, 70, '장도연');
INSERT INTO tblmen VALUES ('아무개', 22, 175, NULL, '이세영');
INSERT INTO tblmen VALUES ('하하하', 27, NULL, 80, NULL);
INSERT INTO tblmen VALUES ('무명씨', 21, 177, 72, NULL);
INSERT INTO tblmen VALUES ('유재석', 29, NULL, NULL, '김숙');
INSERT INTO tblmen VALUES ('박명수', 30, 170, NULL, '김지민');
INSERT INTO tblmen VALUES ('정준하', 31, 183, NULL, '신보라');
INSERT INTO tblmen VALUES ('정형돈', 28, NULL, 92, NULL);
INSERT INTO tblmen VALUES ('양세형', 22, 166, 55, '김민경');
INSERT INTO tblmen VALUES ('조세호', 24, 165, 58, '오나미');

INSERT INTO tblwomen VALUES ('박나래', 23, 150, 55, NULL);
INSERT INTO tblwomen VALUES ('장도연', 28, 177, 65, '홍길동');
INSERT INTO tblwomen VALUES ('김지민', 30, 160, NULL, '박명수');
INSERT INTO tblwomen VALUES ('김숙', 34, 158, NULL, '유재석');
INSERT INTO tblwomen VALUES ('오나미', 27, NULL, NULL, '조세호');
INSERT INTO tblwomen VALUES ('김민경', 22, 169, 88, '양세형');
INSERT INTO tblwomen VALUES ('홍현희', 20, 158, 75, NULL);
INSERT INTO tblwomen VALUES ('신보라', 26, 170, 60, '정준하');
INSERT INTO tblwomen VALUES ('이세영', 28, 163, NULL, '아무개');
INSERT INTO tblwomen VALUES ('신봉선', 27, 162, NULL, NULL);


COMMIT;

SELECT*FROM tblmen;
SELECT*FROM tblwomen;

SELECT*FROM tblmen WHERE couple IS NULL; --솔로
SELECT*FROM tblWOmen WHERE couple IS NULL; --솔로

--distinct를 복수컬럼에도 적용할 수 있다.
SELECT DISTINCT price FROM tblhousekeeping;
SELECT DISTINCT price,qty FROM tblhousekeeping; --DISTINCT는 모든 컬럼니스트보다 앞에 위치해야 한다.
SELECT price, DISTINCT qyt FROM tblhousekeeping;


/*
case
- 컬럼 리스트에 사용
- 조건절에서 사용
- 자바에서의 case문과 유사 
*/

SELECT last || last as name, 
    case 
        when gender = 'm' then '남자'
        when gender = 'f' then '여자'
    end AS gender  
FROM tblname;

SELECT name, case when continent ='AS' then '아시아' when continent ='EU' then '유럽' end FROM tblcountry;
SELECT name, 
    CASE
        WHEN continent ='AS' then '아시아' 
        WHEN continent ='EU' then '유럽' 
        ELSE '기타'
    END 
FROM tblcountry;
--이번달 급여 -> 부장(과장)은 sudang x 2배 지급
SELECT name, basicpay, sudang,
    CASE
        WHEN jikwi = '부장' THEN sudang*2
        WHEN jikwi = '과장' THEN sudang*2
        WHEN jikwi = '대리' THEN sudang*2
        ELSE sudang 
    END
, jikwi FROM tblinsa;

SELECT name, basicpay,
    CASE
        WHEN basicpay >= 2000000 THEN '고액연봉'
        WHEN basicpay >= 1000000 THEN '일반연봉
        ELSE '저액연봉'
    END 
FROM tblinsa;


SELECT namel,weight, couple,
    CASE 
        WHEN weight >90 THEN '과체중'
        WHEN weight > 60 THEN '정상체중'
        WHEN weight >0 THEN '저체중'
        ELSE '미정'    
    END as 체중상태,
    CASE 
        WHEN couple IS NOT NULL THEN '여자친구 있음'
        WHEN couple IS NULL THEN '솔로'
    END AS 연애상태
FROM tblmen;


SELECT title 
    CASE
        WHEN completedate IS NULL THEN '실행중..'
        WHEN completedate IS NOT NULL THEN '완료'
    END
FROM tbltodo;

/*
1. SELECT
2. FROM
3. WHERE
4. ORDER BY

정렬, Sorting 
- 결과셋의 레코드의 순서를 정렬 (원본테이블과는 무관)
- 원본 테이블 레코드 순서는 DBMS가 알아서 함 
- ORDER BY 컬럼명[ASC|DESC]
    - ORDER BY 컬럼명 ASC//Ascending오름차순
    - ORDER BY 컬럼명 DESC//Descending내림차순
    - ORDER BY 컬럼명
*/

- -ASC
    --10-> 20 -> 30
    --'가'->'나'->'다'
    --'2016' -> '2017' -> '2019'
SELECT * FROM tblinsa
 -- ORDER BY name ASC;
 -- ORDER BY ibsadate DESC;
 -- ORDER BY basicpay DESC;
ORDER BY basicpay + sudang DESC;
ORDER BY buseo ASC,jikwi ASC, basicpay DESC; --다중정렬 

--최근 완료한 할일부터 가져오시오.
SELECT*FROM tbltodo ORDER BY COMPLETEDATE DESC;
--정렬 대상에 NULL이 포함되어 있으면 일반적으로 빼고 정렬한다.(우위 비교가 불가능하기 때문에...)
--만약 NULL이 포함되는 정렬이라면..-> NULL의 위치는? -> DBMS에 따라 다르다. 
SELECT*FROM tbltodo
    WHERE completedate IS NOT NULL
        ORDER BY completedate DESC;

/*
1. SELECT -3
2. FROM -1
3. WHERE -2
4. ORDER BY -4
*/

SELECT last || first as name 
FROM tblname
--WHERE name = '유재석';
WHERE last || first = '유재석';
ORDER BY name DESC ;
ORDER BY last || first ASC;




