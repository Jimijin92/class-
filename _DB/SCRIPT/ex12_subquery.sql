/*
ex12_subquery.sql
- sub query
- SQL안에
- SELECT문이 서브쿼리 형태로 사용된다.
- 서브쿼리가 들어갈 수 있는 위치 
    a. where절 : 서브쿼리의 결과셋을 조건값으로 사용 
    b. 컬럼리스트 : 서브쿼리의 결과셋을 또 하나의 컬럼 역할 
    c. from절 : 서브쿼리의 결과셋을 하나의 테이블로 사용 -뷰(View)
    d. order by 절
    e. group by 절 
*/


SELECT*FROM tblhousekeeping ORDER BY price DESC;
단가가 가장 높은 물건명?
SELECT max(price) FROM tblhousekeeping; --15000
SELECT item FROM tblhousekeeping WHERE price = 15000;

SELECT item FROM tblhousekeeping WHERE price = max(price); --에러나는 구문 max(price)도 15000이지만 아래 구문과는 다른 연산결과임
SELECT item FROM tblhousekeeping WHERE price = (SELECT max(price) FROM tblhousekeeping);        
                                                              --= (15000);
                                                                
SELECT*FROM tbltodo;
-- 가장 최근에 등록한 할일?(adddate가 가장 마지막 날짜)

SELECT title, max(adddate) FROM tbltodo;

SELECT title, max(adddate) FROM tbltodo; --2018-01-12 12:30:23


SELECT title, adddate FROM tbltodo WHERE adddate =to_date('2018-01-12 12:30:23', 'yyyy-mm-dd hh24:mi:ss');
                           
-- 회사 평균 월급(155만원)보다 많이 받는 직원들 명단?                                     
SELECT*FROM tblinsa;                                                                
                                                                
SELECT avg(basicpay) from tblinsa;

SELECT * FROM tblinsa WHERE basicpay > (SELECT avg(basicpay) from tblinsa);

--총무부의 평균급여보다 많이 받는 타부서 사람들?
SELECT * FROM tblinsa 
    WHERE basicpay > (SELECT avg(basicpay) from tblinsa WHERE buseo = '총무부')
                AND buseo<>'총무부';                                                                
                                                        
SELECT*FROM tblinsa WHERE name = '홍길동';                                                        
SELECT*FROM tblinsa WHERE basicpay > (SELECT basicpay FROM tblinsa WHERE name = '홍길동');                                            

--에러남 (단일값이 아니라서)
SELECT*FROM tblinsa WHERE basicpay > (SELECT basicpay FROM tblinsa WHERE jikwi = '과장');                                            


SELECT*FROM tblinsa WHERE basicpay > (SELECT max(basicpay) FROM tblinsa WHERE jikwi = '과장');                                            
                                
SELECT*FROM tblmen;
SELECT*FROM tblwomen;
                                                                
--남자 170cm +? - > 여자친구 -> 여자친구 키?                                                                
SELECT couple FROM tblmen WHERE height = 170 AND weight IS NULL;
SELECT height FROM tblwomen WHERE name = '김지민'

SELECT height FROM tblwomen WHERE name = (SELECT couple FROM tblmen WHERE height = 170 AND weight IS NULL);

--HR
SELECT*FROM employees;
SELECT*FROM departments;
SELECT*FROM locations;

-- 직원 Steven King이 소속된 부서가 어느 지역에 있는지 주소를 알려주세요.
SELECT*FROM locations
    WHERE location_id = ( SELECT location_id FROM departments
         WHERE department_id = (
            SELECT department_id FROM employees
                WHERE upper(first_name || last_name) 
                    = upper(replace('steven king',' ', ''))));

                
--컬럼리스트에 서브쿼리 사용
-- 기획부 직원들은 길동이보다 얼마를 더 받고 얼마를 덜 받는지 차액이 궁금?
SELECT name, basicpay, 2610000 - basicpay FROM tblinsa WHERE buseo = '기획부';

SELECT name, basicpay, 26, (SELECT basicpay FROM tblinsa WHERE name = '홍길동') - basicpay FROM tblinsa WHERE buseo = '기획부';                                                                


------------------------집계함수를 컬럼리스트에 사용 -> 서브쿼리---------------------
SELECT name, basicpay, max(basicpay) FROM tblinsa;                            
--이거는 좀 애매할 수 있어,, 가치가 있는지는..
SELECT name, basicpay, (SELECT max(basicpay)FROM tblinsa) FROM tblinsa;                                                                
--이건 완전 말 되지,,
SELECT name, basicpay, (SELECT max(basicpay)FROM tblinsa) - basicpay FROM tblinsa;                                                                
 -----------------------------------------------------------------------------------------
 
- 바깥쪽 테이블의 데이터를 안쪽 테이블의 조건으로 사용 -보류

--from절 -> 서브쿼리 

-- 셀렉트 끝나는 순간 없어지는 애
-- 일회용 테이블
SELECT*FROM (SELECT*FROM tblname WHERE gender ='m'); --임시 남자 테이블 

-- 이름이 있다는건 영구적으로 보존이 가능하다는것                                  
-- 관련 업무를 추후 여러번 사용할 일이 있을때
CREATE TABLE tbltempmen
AS
SELECT*FROM tblname WHERE gender ='m';
SELECT*FROM tbltempmen;


SELECT  *   FROM (SELECT name, ssn, jikwi, city FROM tblinsa WHERE buseo = '기획부');                                                                
        --  ↖ name, ssn, jikwi, city, 딱 네가지 컬럼만을 의미함

--에러뜸 jumin으로 바꿔줬으면 부를때도 jumin으로 하기
SELECT name, ssn, jikwi, city FROM (SELECT name, ssn as jumin, jikwi, city FROM tblinsa WHERE buseo = '기획부');                                                                                                                                

-- 서브쿼리의 결과가 다중값일 때 
-- 1. 다중 행 
-- 2. 다중 컬럼 

--1. 다중 행 
-- 홍길동(부장)과 이순신(부장)이 속한 부서 직원들을 가져오시오.
SELECT name, buseo FROM tblinsa
    -- WHERE buseo = '기획부' or buseo = '개발부';
    WHERE buseo in('기획부','개발부');

SELECT buseo FROM tblinsa
    WHERE name = '홍길동' or name = '이순애';
                        
                                                 
-- 에러남
SELECT name, buseo FROM tblinsa
    WHERE buseo = ( SELECT buseo FROM tblinsa
    WHERE name = '홍길동' or name = '이순애');
                                                           
--정상작동 --> in 써서 해결                                                           
SELECT name, buseo FROM tblinsa
    WHERE buseo in ( SELECT buseo FROM tblinsa
    WHERE name = '홍길동' or name = '이순애');
                                                           
                                                           
                                                           
--2. 다중 컬럼
SELECT*FROM tblinsa    
    WHERE name = '나윤균';
                              
-- 나윤균과 같은 부서에 소속 + 같은 직위를 가지는 사람?                                                            
SELECT*FROM tblinsa
    WHERE buseo ='인사부' AND jikwi = '사원';
                                                           

SELECT*FROM tblinsa
    WHERE buseo =(SELECT buseo FROM tblinsa WHERE name = '나윤균') 
        AND jikwi = (SELECT jikwi FROM tblinsa WHERE name = '나윤균');
        
SELECT*FROM tblinsa
    WHERE buseo =(SELECT buseo FROM tblinsa WHERE num = 1035) 
        AND jikwi = (SELECT jikwi FROM tblinsa WHERE num = 1035);
                                                           
SELECT*FROM tblinsa
    WHERE buseo =(SELECT buseo FROM tblinsa WHERE basicpay = (SELECT min(basicpay) FROM tblinsa)) 
        AND jikwi = (SELECT jikwi FROM tblinsa WHERE basicpay = (SELECT min(basicpay) FROM tblinsa));                                                           
        
--1단계, 하나로 합치기 (근데 아직 에러남)                                                           
SELECT*FROM tblinsa
    WHERE buseo =(SELECT buseo, jikwi FROM tblinsa WHERE name = '나윤균'); 
--2단계  완성       
SELECT*FROM tblinsa
    WHERE (buseo, jikwi) = (SELECT buseo, jikwi FROM tblinsa WHERE name = '나윤균');        
                                                           
                                                           
-- 에러남 뒤에는 직위없어서                                                           
SELECT*FROM tblinsa
    WHERE (buseo, jikwi) = (SELECT buseo FROM tblinsa WHERE name = '나윤균');        
                                                           
--♥ 순서만 중요 !!!!!!!!!!!!!!!! ♥ --작동함                                                          
SELECT*FROM tblinsa
    WHERE (buseo, jikwi) = (SELECT buseo, jikwi as position FROM tblinsa WHERE name = '나윤균');        
       
-- 에러는 안나는데 이런거 쓰지말기  
-- 다중컬럼 + 다중 행 -> 서브쿼리 조건값으로 사용 
SELECT*FROM tblinsa
    WHERE (buseo, jikwi) in (SELECT buseo, jikwi FROM tblinsa);                                                           
                                                                
                                                                