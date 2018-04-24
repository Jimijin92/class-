/*

ex06_casting.sql

형변환 함수

1. to_char() : 숫자 -> 문자
2. to_char() : 날짜 -> 문자 : ****
3. to_number() : 문자 -> 숫자
4. to_date() : 문자 -> 날짜 : ****


1. 숫자 -> 문자
- char to_char(컬럼명, 형식문자열)

형식문자열 구성 요소
- 아래의 요소 이외에는 형식문자열에 포함될 수 없다.(***)
a. 9 : 숫자 1자리를 문자 1개로 바꾸는 역할(모자란 자리는 공백으로 채우기) + 맨앞에 공백 1개 추가(부호)
b. 0 : 숫자 1자리를 문자 1개로 바꾸는 역할(모자란 자리는 0으로 채우기) + 맨앞에 공백 1개 추가(부호)
c. $ : 달러 표시용
d. L : Locale(지역 통화 표시)
e. . : 소수점 표시용
f. , : 천단위 표시용
*/
SELECT 100, '100' FROM dual;

SELECT to_char(100, '999') FROM dual; --100 -> '100'
SELECT to_char(100, '000') FROM dual; --100 -> '100'

SELECT to_char(10, '999') FROM dual; --10 -> '10'
SELECT to_char(10, '000') FROM dual; --10 -> '010'

SELECT to_char(1, '999') FROM dual; --1 -> '1'
SELECT to_char(1, '000') FROM dual; --1 -> '001'

SELECT '@' || to_char(-100, '999') || '@' FROM dual; --1 -> '1'
SELECT '@' || to_char(1, '000') || '@' FROM dual; --1 -> '001'


SELECT to_char(1000, '999') FROM dual;

-- 100원
SELECT to_char(100, '$999') FROM dual;
SELECT to_char(100, '999원') FROM dual;
SELECT to_char(100, 'L999') FROM dual;
SELECT to_char(100, '999') || '원' FROM dual;

SELECT to_char(123.456, '999.999') FROM dual;
SELECT to_char(123.456, '999.99') FROM dual; -- 반올림 + 문자열 변환
SELECT to_char(123.456, '999.9') FROM dual;

SELECT to_char(1000000, '9,999,999') FROM dual;
SELECT to_char(1000000, '999,9999') FROM dual;
SELECT to_char(1000000, '9,9,9,9,9,9,9') FROM dual;



/*
2. 날짜 -> 문자
- varchar2 to_char(컬럼명, '형식문자열')

형식 문자열의 구성 요소
- yyyy
- yy
- month
- mon
- mm
- day
- dy
- ddd, dd, d
- hh(hh12), hh24
- mi
- ss
- am(pm)
*/
SELECT sysdate FROM dual;
SELECT to_char(sysdate, 'yyyy') FROM dual; --2018 년(4자리)
SELECT to_char(sysdate, 'yy') FROM dual; --18 년(2자리) X
SELECT to_char(sysdate, 'month') FROM dual; --1월, 로케일(풀네임)
SELECT to_char(sysdate, 'mon') FROM dual; --1월, 로케일(약어)
SELECT to_char(sysdate, 'mm') FROM dual; --01, 두자리 숫자(*************)
SELECT to_char(sysdate, 'day') FROM dual; --요일, 로케일(풀네임)
SELECT to_char(sysdate, 'dy') FROM dual; --요일, 로케일(약어)
SELECT to_char(sysdate, 'ddd') FROM dual; --016, 날짜(기준 : 1월1월)
SELECT to_char(sysdate, 'dd') FROM dual; --16, 날짜(기준 : 월 1일)
SELECT to_char(sysdate, 'd') FROM dual; --3, 날짜(기준 : 이번주 = 요일)
SELECT to_char(sysdate, 'hh') FROM dual; --02, 시(12시간)
SELECT to_char(sysdate, 'hh24') FROM dual; --14, 시(24시간)
SELECT to_char(sysdate, 'mi') FROM dual; --분
SELECT to_char(sysdate, 'ss') FROM dual; --초
SELECT to_char(sysdate, 'am') FROM dual; --오후
SELECT to_char(sysdate, 'pm') FROM dual; --오후


SELECT to_char(sysdate, 'yyyy-mm-dd') from dual;
SELECT to_char(sysdate, 'yyyy년mm월dd일') from dual;

SELECT to_char(sysdate, 'hh24:mi:ss') from dual;
SELECT to_char(sysdate, 'am hh:mi:ss') from dual;


-- 조건절에 사용
-- date형을 문자열 함수에 사용하지 말것!!!!
-- date형 -> 문자열로 형변환 -> 문자열 함수 사용

-- 12월에 입사한 직원?
SELECT name, ibsadate, substr(ibsadate, 1)
	FROM tblinsa;

SELECT name, ibsadate, to_char(ibsadate, 'mm')
	FROM tblinsa
		WHERE to_char(ibsadate, 'mm') = '12';

SELECT *
	FROM tbltodo
		--WHERE to_char(adddate, 'am') = '오전';
		WHERE to_char(adddate, 'd') = 7; --토요일 등록한 할일


-- 97 ~ 99년 사이에 입사한 사람
SELECT * FROM tblinsa
	--WHERE ibsadate BETWEEN '1997-01-01' AND '2000-01-01';
	WHERE to_char(ibsadate, 'yyyy') BETWEEN 1997 AND 1999;

-- 정렬
SELECT * FROM tblinsa
	--ORDER BY ibsadate DESC ;
	ORDER BY to_char(ibsadate, 'mm') ASC, to_char(ibsadate, 'yyyy') ASC,
				to_char(ibsadate, 'dd'), num ASC ;


/*
3. 문자 -> 숫자
- number to_number(문자열)
- Integer.parseInt(문자열)
*/
SELECT to_number('123') FROM dual;
SELECT '123' * 2 FROM dual;


/*
4. 문자 -> 날짜
- date to_date(컬럼명, '형식문자열')
- 2번에서 사용한 형식 문자열과 동일
*/
SELECT '2018-01-16', sysdate FROM dual;  --'2018-01-16' : 문자열
SELECT * FROM tblinsa WHERE ibsadate < '2018-01-16'; -- '2018-01-16' : date

-- 형식문자열 만드는 방법 -> 앞의 데이터 포맷을 그대로 표현
SELECT to_date('2018-01-16', 'yyyy-mm-dd'), sysdate FROM dual;
SELECT to_date('2018.01.16', 'yyyy.mm.dd'), sysdate FROM dual;
SELECT to_date('20180116', 'yyyymmdd'), sysdate FROM dual;

SELECT to_date('2018-01-16 17:56:22', 'yyyy-mm-dd hh24:mi:ss'), sysdate FROM dual;
























