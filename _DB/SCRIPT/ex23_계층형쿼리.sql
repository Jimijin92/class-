/*
ex23_계층형쿼리.sql

- 오라클에서만 지원
- 답변형 게시판, 카테고리 처리, BOM(자재 명세서) 등.. 부모와 자식으로 구성된 트리 구조의 데이터 처리

[부품 정보]
컴퓨터
   - 본체
      - 메인보드
      - 랜카드
      - 메모리(RAM)

   - 모니터
      - 편광필름
   - 프린터
      -잉크 카트리지
      -A4 용지
*/

CREATE TABLE tblcomputer
(
        seq NUMBER PRIMARY KEY, -- 식별자
        name VARCHAR2(100) NOT NULL, --부품명
        qty NUMBER NOT NULL, --수량 
        pseq NUMBER REFERENCES tblcomputer(seq) NULL --부모부품
);

INSERT INTO tblcomputer VALUES(1,'컴퓨터', 1, NULL); --루트노드
INSERT INTO tblcomputer VALUES(2,'본체', 1, 1);
INSERT INTO tblcomputer VALUES(3,'메인보드', 1, 2);
INSERT INTO tblcomputer VALUES(4,'랜카드', 1, 3);
INSERT INTO tblcomputer VALUES(12,'그래픽카드', 1, 3);
INSERT INTO tblcomputer VALUES(5,'RAM', 1, 3);
INSERT INTO tblcomputer VALUES(11,'파워서플라이', 1, 2);
INSERT INTO tblcomputer VALUES(6,'모니터', 1, 1);
INSERT INTO tblcomputer VALUES(7,'편광필름', 1, 6);
INSERT INTO tblcomputer VALUES(8,'프린터', 1, 1);
INSERT INTO tblcomputer VALUES(9,'잉크 카트리지', 1, 8);
INSERT INTO tblcomputer VALUES(10,'A4 용지',1, 8);

SELECT*FROM tblcomputer;
COMMIT;

--1. 조인 사용 -> 계층형 데이터 접근
--; 자기 참조 -> 셀프 조인
--; 내부 조인? 외부 조인? 
SELECT c1.name, c2.name as panme FROM tblcomputer c1 --부품
        LEFT OUTER JOIN tblcomputer c2 --부모 부품
                ON c1.pseq = c2.seq; --자식테이블 <-> 부모테이블
                        
--2. start with 절 .. connect by 절
-- 계층형 데이터를 대상으로 질의
SELECT*FROM tblcomputer
        START WITH seq = 1
                CONNECT BY PRIOR seq = pseq;

-- 계층형 쿼리의 의사 컬럼
-- level
SELECT lpad(' ', (level -1) * 6) || name, pseq, level FROM tblcomputer
        START WITH seq = 1
                CONNECT BY PRIOR seq = pseq;
        
-- 비상관 서브쿼리
-- : 바깥쪽 쿼리와는 전혀 상관없는 독립적인 안쪽 서브 쿼리 
        
-- 상관 서브 쿼리         
-- : 바깥쪽의 쿼리 결과를 안쪽 쿼리에 사용하는 서브 쿼리  
SELECT lpad(' ', (level -1) * 6) || name, 
        (SELECT name FROM tblcomputer WHERE seq = c2.pseq), 
        level FROM tblcomputer c2
        START WITH seq = 1
                CONNECT BY PRIOR seq = pseq;
   
 -- 의사컬럼
 --prior: 부모 레코드 참조 
SELECT lpad(' ', (level -1) * 6) || name, 
        prior name, prior seq, --= (SELECT name FROM tblcomputer WHERE seq = c2.pseq), <-와 같다. 
        level FROM tblcomputer c2
        START WITH seq = 1
                CONNECT BY PRIOR seq = pseq;             

-- start with절 역할
SELECT lpad(' ', (level -1) * 6) || name as name, PRIOR name
        FROM tblcomputer
        -- START WITH seq = 1 -- 정적으로 지정(내가 알고있기 때문에)
        -- START WITH pseq IS NULL -- 부모가 없는 노드(= 루트노드)
        -- START WITH seq = (SELECT seq FROM tblcomputer WHERE name = '컴퓨터')
        START WITH seq = 1
                        CONNECT BY PRIOR seq = pseq;     


-- connect by 역할
-- 부모컬럼 = 자식컬럼 연결
-- 반드시 prior 의사컬럼과 같이 사용
SELECT lpad(' ', (level -1) * 6) || name as name, PRIOR name 
        FROM tblcomputer
                START WITH seq = 1
                        CONNECT BY seq = PRIOR pseq;







DROP TABLE tblcomment;
DROP TABLE tblboard;

-- 계층형 게시판(= 답변형 게시판)
CREATE TABLE tblboard
(
    seq NUMBER PRIMARY KEY,
    subject VARCHAR2(1000) NOT NULL,
    pseq NUMBER NULL
);

INSERT INTO tblboard VALUES (1, '1번 글입니다.', NULL);
INSERT INTO tblboard VALUES (2, '2번 글입니다.', NULL);
INSERT INTO tblboard VALUES (3, '3번 글입니다.', NULL);

INSERT INTO tblboard VALUES (4, '1번의 첫번째 답변글입니다.', 1);
INSERT INTO tblboard VALUES (5, '1번의 두번째 답변글입니다.', 1);
INSERT INTO tblboard VALUES (6, '1번의 세번째 답변글입니다.', 1);

INSERT INTO tblboard VALUES (7, '2번의 첫번째 답변글입니다.', 2);
INSERT INTO tblboard VALUES (8, '2번의 두번째 답변글입니다.', 2);

INSERT INTO tblboard VALUES (9, '3번의 첫번째 답변글입니다.', 3);
INSERT INTO tblboard VALUES (10, '3번의 두번째 답변글입니다.', 3);
INSERT INTO tblboard VALUES (11, '3번의 세번째 답변글입니다.', 3);

INSERT INTO tblboard VALUES (12, '1번의 첫번째 답변의 첫번째 답변글입니다.', 4);
INSERT INTO tblboard VALUES (13, '1번의 첫번째 답변의 두번째 답변글입니다.', 4);

INSERT INTO tblboard VALUES (14, '2번의 첫번째 답변의 첫번째 답변글입니다.', 7);
INSERT INTO tblboard VALUES (15, '3번의 두번째 답변의 첫번째 답변글입니다.', 10);





CREATE TABLE tblcategory
(
    seq NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    pseq NUMBER NULL
);

INSERT INTO tblcategory VALUES (1, '패션의류/잡화', NULL);
INSERT INTO tblcategory VALUES (2, '뷰티', NULL);
INSERT INTO tblcategory VALUES (3, '주방용품', NULL);
INSERT INTO tblcategory VALUES (4, '남성패션', 1);
INSERT INTO tblcategory VALUES (5, '여성패션', 1);
INSERT INTO tblcategory VALUES (6, '베이비패션', 1);
INSERT INTO tblcategory VALUES (7, '티셔츠', 4);
INSERT INTO tblcategory VALUES (8, '셔츠', 4);
INSERT INTO tblcategory VALUES (9, '블라우스', 5);
INSERT INTO tblcategory VALUES (10, '원피스', 5);
INSERT INTO tblcategory VALUES (11, '스커트', 5);
INSERT INTO tblcategory VALUES (12, '베이비 여아', 6);
INSERT INTO tblcategory VALUES (13, '베이비 남아', 6);
INSERT INTO tblcategory VALUES (14, '베이비 공용', 6);
INSERT INTO tblcategory VALUES (15, '스킨케어', 2);
INSERT INTO tblcategory VALUES (16, '향수', 2);
INSERT INTO tblcategory VALUES (17, '기초 화장품', 15);
INSERT INTO tblcategory VALUES (18, '클렌징', 15);
INSERT INTO tblcategory VALUES (19, '마스크', 15);
INSERT INTO tblcategory VALUES (20, '여성 향수', 16);
INSERT INTO tblcategory VALUES (21, '남성 향수', 16);
INSERT INTO tblcategory VALUES (22, '그릇', 3);
INSERT INTO tblcategory VALUES (23, '컵', 3);
INSERT INTO tblcategory VALUES (24, '일회용품', 3);
INSERT INTO tblcategory VALUES (25, '식기', 22);
INSERT INTO tblcategory VALUES (26, '유아식기', 22);
INSERT INTO tblcategory VALUES (27, '머그', 23);
INSERT INTO tblcategory VALUES (28, '와인잔', 23);
INSERT INTO tblcategory VALUES (29, '텀블러', 23);
INSERT INTO tblcategory VALUES (30, '위생백', 24);



COMMIT;



--게시판
SELECT *FROM tblboard;

SELECT lpad(' ', (level -1) * 8) || subject as subject FROM tblboard
        -- WHERE 절 위치        
                -- START WITH pseq IS NULL
                START WITH seq = 1
                        CONNECT BY PRIOR seq = pseq
                                -- ORDER BY seq DESC; --계층형 쿼리에는 일반적인 ORDER BY 못 씀
                                ORDER SIBLINGS BY seq DESC;


-- 카테고리 
SELECT lpad(' ', (level -1) * 6) || name FROM tblcategory
        START WITH pseq IS NULL
                CONNECT BY PRIOR seq = pseq;



--원피스
SELECT
	CASE
		WHEN level = 1 THEN '소분류'
		WHEN level = 2 THEN '중분류'
		WHEN level = 3 THEN '대분류'
	END as "level",
	lpad(' ', (level - 1) * 6) || name
	FROM tblcategory
		START WITH seq = (SELECT seq FROM tblcategory WHERE name = '원피스')
			CONNECT BY seq = PRIOR pseq;


-- 부모가 자식집을때 특정자식만 지정할 수 없다.


/*
계층형 쿼리 의사컬럼
1.PRIOR : 부모 레코드 참조 
2. CONNECT_BY_ROOT : 루트 노드 레코드 참조
3. CONNECT_BY_ISLEAF : 리프 노드 유무 반환
4. sys_connect_by_path() 함수
*/
SELECT 
        lpad(' ', (level -1) * 6) || name as "현재 카테고리",
        prior name as "부모 카테고리",
        connect_by_root name as "루트 카테고리",
        CONNECT_BY_ISLEAF,
        sys_connect_by_path(name, '>') 
        FROM tblcategory
                START WITH pseq IS NULL 
                        CONNECT BY PRIOR seq = pseq;
                        
                        
SELECT lpad(' ', (level-1)*6) || first_name || '' || last_name as name FROM employees
        START WITH employee_id = 100
                CONNECT BY PRIOR employee_id = manager_id
                        ORDER SIBLINGS BY first_name ASC;


-- 상관 서브쿼리, Correlated Sub Query
-- 1. 바깥쪽의 질의 값을 안쪽의 질의에서 사용하는 서브쿼리
-- 2. 서브 쿼리가 단독으로 실행 불가능한 쿼리

-- 상관 서브 쿼리의 형태 중 일부는 group by 와 비슷한 성질을 보이는 경우가 있다.

-- 각 부서별 최고 급여?
-- group by 사용
SELECT name, jikwi, buseo, max(basicpay) FROM tblinsa --> name이랑 jikwi때문에 에러남
	GROUP BY buseo;

-- 상관 서브 쿼리 사용
SELECT name, jikwi, buseo, basicpay FROM tblinsa --> name이랑 jikwi써도 에러 안남 
	WHERE basicpay = (SELECT max(basicpay) FROM tblinsa
                                                WHERE buseo = i1.buseo);

-- 각 직위별 최대 급여를 받는 사람들? 
-- 상관쿼리
SELECT name, jikwi, basicpay FROM tblinsa i1
        WHERE basicpay = (SELECT max(basicpay) FROM tblinsa WHERE jikwi = i1.jikwi);


-- Pairwise Sub Query
SELECT name, jikwi, basicpay FROM tblinsa 
        WHERE (buseo, basicpay) in (SELECT buseo, basicpay FROM tblinsa
                                                                GROUP BY jikwi);
        
        
-- 홍길동과 그 부서의 평균 급여를 가져오시오.
SELECT name, jikwi, buseo,basicpay, 
        (SELECT round(avg(basicpay)) FROM tblinsa WHERE buseo = '기획부') 
                FROM tblinsa
                        WHERE name = '홍길동';
        --> 이 경우 홍길동이 이순신으로 바뀌면 부서가 바뀌고 사람이 일일이 확인해서 기획부를 이순신네 부서로 바꿔줘야 함, 그래서 아래 방식들 참고
        
        
-- 안쪽에서 홍길동의 부서 가져오기
SELECT name, jikwi, buseo,basicpay, 
        (SELECT round(avg(basicpay)) FROM tblinsa WHERE buseo = (SELECT buseo FROM tblinsa WHERE name = '홍길동')) 
                FROM tblinsa
                        WHERE name = '홍길동';      
       
       
-- 바깥쪽 값을 취해서 상관서브쿼리
SELECT name, jikwi, buseo,basicpay, 
        (SELECT round(avg(basicpay)) FROM tblinsa WHERE buseo = i1.buseo) 
                FROM tblinsa i1
                        WHERE name = '홍길동'; 
                
-- 각 부서별 최대 급여를 받는 사람 3명씩 가져오시오.
SELECT name, buseo, basicpay FROM tblinsa i1
        WHERE (SELECT count(*) FROM tblinsa
                        WHERE basicpay > i1.basicpay AND buseo = i1.buseo) < 3
                        ORDER BY buseo ASC, basicpay DESC; 
                        
                        
                        
                        