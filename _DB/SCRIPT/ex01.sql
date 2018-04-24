/*오라클- Oracle
- 회사명
- 제품명(데이터베이스 + 데이터베이스 관리 시스템)

오라클 설치 후 동작 확인? 
1. services.msc
2. OracleXXX 패턴의 서비스명 
    - XE : SID (Service ID) - 오라클 프로그램 이름 
    a. OracleServiceXE   -> OracleServiceOrcl
        - 데이터베이스 프로그램
        - DB
        - 오라클
    B. OracleXETNSListener -> OracleOrclTNSListener
        - 데이터베이스(오라클)가 외부의 클라이언트들의 요청을 받기 위한 대화 서비스 
        

서비스 시작 * 멈춤
>cmd + 관리자 권한 실행
1.net start 서비스명
2.net stop 서비스명 

net start OracleServiceXE


데이터베이스 
- 정보 -> 유효한 정보 -> 데이터(유효한 데이터) -> 집합 -> 데이터베이스 

데이터베이스의 특징(자격)
- 실시간 접근성 제공
- 지속적인 변화 관리 
- 동시 공유 (많은 사용자가 데이터를 사용해야 한다.)


데이터베이스 모델
1. 계층형 모델, Hirerachial Model
    - 폴더 & 파일 형태의 구조로 데이터를 저장하는 방식
    - 현재 거의 사용 안함
    
2. 관계형 모델, Relational Model
    - 1969년
    - 열과 행을 가지는 표 형태로 데이터를 저장하는 방식
    - SQL 언어를 사용해서 조작한다.
    - 현재 대다수 DB환경이 이 모델을 사용한다. (오라클) 
    
3. 객체 지향 데이터베이스, Object Oriented Databasem OODB
    - 데이터를 객체 단위로 저장하는 방식
    
4. XML 데이터베이스 
    - XML 형식으로 저장하는 방식

5. 키-값형 데이터 스토어
    - 맵 형식으로 저장하는 방식(연관 배열 방식과 유사)
    - 대량의 데이터를 초고속으로 취급해야 하는 업무
    - NoSQL(Not only SQL)
    - 빅데이터 
    - MongoDB, Couchbase, Cassandra...




관계형 데이터
1. 수많은 데이터들이 테이블 형태로 관리된다.
    - 세부 정보 : 컬럼
    - 세부 정보 집합 : 행
    
2.  관계?
    - RDB에서는 표를 관계(Relational)라고 부른다.     

데이터베이스 관리시스템, Database Management System, DBMS
- 데이터베이스를 관리하는 시스템(프로그램 + 환경 등...)
- 많은 양의 데이터를 꼭 DBMS 사용해야 관리하나? 그냥 텍스트파일 OR 엑셀 사용?

1. 다수의 사람이 데이터를 공유하기 쉽다. 
2. 대량의 데이터를 다루기 쉽다. 
    - 수백만, 수천만건의 데이터 

3. 일기/쓰기를 자동화하기 쉽다.  
    - 텍스트, 엑셀 -> 사전지식이 없는 일반 유저 ->프로그래밍화
    - 사용법이 쉽다. 
 
 4. 만약의 사고에 대응하기 쉽다. (***) 
    - 백업/복구
    - 보안(유출)
    

DBMS 제품 종류(DB + DBMS)

1. ORACLE
    - ORACLE 사
    - 기업, 소호
    - Java와 같이 사용함.(많이)
    - 국내, 가장 많이 사용하는 제품 
    
2. MS-SQL Server
    - Microsoft
    - 기업, 소호
    - 윈도우에서만 구동
    
3. MS ACCESS
    - Microsoft
    - 소호, 개인
    - 오피스에 포함 
    
4. DB2
    - IBM 
    - 한동안 IBM컴퓨터에서만 구동 -> 현재는 다른 시스템에서도 구동 가능
    
5. INFOMIX
    - INFOMIX
    - 오라클 경쟁
    - IBM에서 인수

6. MySQL
    - 오픈 소스(무료)
    - Oracle 인수 
    - 개인 > 상용 DB 급 
    
7. MariaDB
    - 오픈소스(무료)

8. MaxDB
    - SAP  + MySQL -> MaxDB
    
9.  PostgreSQL
    - 오픈 소스

10. SQLite
    - 오픈 소스
    - 임베디드에서 많이 사용
    
11. 티베로 
    - 티맥스 
    - 오라클과 거의 동일(호환성)
    - 기업은행, 기아현대차, 정부시스템 일부 

 오라클 종류 
 
 1. Enterprise Edition
    -CPU무제한
 
 2. Standard Edition
 3. Personal Edition
 4. Express EdItion (우리가 받은거)
    - CPU 1개 제한
    - 운영체제 32bit -> 64bit
    - 데이터 4GB
    - 메모리 1GB
 
오라클 버전
    - v1(1978년) ~ 12c(2013년)
    - 9i ~ 11g 가장 많이 쓰임
    - 9i : internet
    - 10g : grid(분산 컴퓨터팅 환경)
    - 11g : grid
    - 12c : cloud(클라우드)
    
    
설치 프로그램
1. 데이터베이스
    - Oracle server
2. DB 클라이언트 툴
    - SQL Developer
    - QueryBox
    - 데이터베이스 서버로부터 서비스를 제공받는 툴
    
3. 모델링 툴
    - eXERD
    - 데이터베이스 설계 툴 
   
    
DB 관련 직책

1. DB관리자, DB Admin(Administrator)
    - DB 총괄 (신입 안돼)
    - DB 서비스를 안정적으로 운영/관리 

2. DB 엔지니어
    - H/W 관리

3. 백업 마스터
    - DB Admin 겸임
    
4. 모델러
    - DB 설계 
    
5. 튜너
    - DB 튜닝 (돈 잘범)
    
6. DB개발자, 프로그래머 
    - 1~5번의 하위 단계 
    - 데이터 조작 관련 업무 
    - 응용 프로그램 개발자도 많이 함. 자바개발자가 겸임하기도 함  
*/



SELECT*FROM tabs;

/*

SQL
- 관계형 데이터베이스 시스템과 대화할 수 있는 언어(명령어)
- Structred Query Language , 구조화된 질의 언어 


SQL 명령어의 종류
1. DDL,Data Definition Language, 데이터 정의어
- 데이터를 저장하기 위한 데이터배이스 구좋를 정의를 정의하는 명령어
a.  CREATE M객체  객체 생성
b. DROP : 갹채생성
c. ALTER : 객체 수정
- 데이터베이스 관리자 (담당자) 프로그머(일부)
 
 
2. DML
    - 데이터베이스에 데이터를 추가/검색/수정/삭제하는 작업
    - SQL 가장 기본셋
    - CRUD 작업
        a. SELECT : 데이터 가져오기  
        b. INSERT : 데이터 추가하기
        c. UPDATE : 데이터 수정하기
        d. DELECT : 데이터 삭제하기
        - 데이터베이스 관리자(담당자), 프로그래머   
    
3. DCL, Data Control Language, 데이터 제어어
    - 트래잭션, 보안 등 작업 
        a. COMMIT : 데이터 처리 승인
        b. ROLLBACK  : 데이터 처리 반려
        c. GRANT : 권한 부여
        d. REMOVE : 권한 제거
        
SQL 표준화 및 종류

- DBM의 종류에 따라 구문이 조금 다르다.
- ISO, ANSI -> SQL 표준화 -> 표준 SQL(ANSI SQL) : SQL-92, SQL-99, SQL-2003, SQL-2008 등
- 대다수 DBMS들이 표준 SQL 지원 

1. 표준 SQL
- DBMS 종류와 상관없이 모두 지원
- 1986년

2. PL/SQL
- 오라클 전용 SQL

3. T-SQL
- MS-SQL 전용 SQL

4. MySQL...

계정

1. sys : 최고관리자 
2. system : 관리자 
3. sysoper : 관리자 
4. 사용자 계정
    - 직접 생성 
    - 직원별/업무별
    - scott/tiger
    - hr(Human Resources)/lion
    
HR 계정
    - 오라클 설치 직후 -> 잠겨있음 -> 잠금해제(활성화) + 암호 변경(java1234)
    - 위의 작업은 권한이 있는 계정이 할 수 있다.
    
5. 
    
*/
ALTER USER hr ACCOUNT UNLOCK; -- 잠금해제
ALTER USER hr IDENTIFIED BY java1234; --암호변경
--드래그하고 컨트롤 엔터
--흐름(batch)이 없고 그떄그때 블록잡고 컨트롤엔터(스크립트 파일-> 순서없음)
--문장단위로 실행 꼭 사람대화하듯 한문장씩 주고 받고 

ALTER USER hr ACCOUNT UNLOCK IDENTIFIED BY java1234; -- 동시에
ALTER USER hr IDENTIFIED BY java1234 ACCOUNT UNLOCK;
-- 핑(Ping) 테스트, 루프 백(Loop Back) IP
-- 127.0.0.1
-- 자신을 뜻하는 주소
-- localhost : 아무 기능없는 단어 

--DNS 서버(서비스)
--1521 / 8080

--기본 클라이언트 툴 -> sqlplus (콘솔 기반)
-- >sqlplus 

--> sqlpus/nolog
-->SQL>conn/as sysdba

--tabs : Tables
-- 시스템 테이블 중 하나
-- 해당 유저가 소유하고 있는 테이블의 목록 제공 -> 자신의 스키마 내부에 있는 테이블 자원 반환 
SELECT * FROM tabs;

SELECT*FROM employees;
SELECT*FROM departments;


































