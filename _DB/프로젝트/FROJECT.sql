commit;
--로그인

SELECT * FROM (
SELECT S_ID AS ID ,TRIM(TO_CHAR(TBL_STUDENT.SSN, '9999999')) AS PW FROM TBL_STUDENT
UNION ALL
SELECT T_ID AS ID,TRIM(TBL_TEACHER.SSN) AS PW FROM TBL_TEACHER
UNION ALL
SELECT M_ID AS ID,TRIM(TO_CHAR(TBL_MANAGER.SSN,'9999999')) AS PW FROM TBL_MANAGER) T
WHERE T.ID = 'A1' AND T.PW = '5000000';

--SELECT*FROM TBL_MANAGER;


SELECT  * FROM  TABS;


-- 104
-- 기초정보 상세내역 (과정명/과목명/강의실/교재명)
--***조회
---------표준SQL
--과정
SELECT COU_SEQ, name as 과정명 FROM tbl_course WHERE STATE = 1;
-- 과목
SELECT SUB_SEQ, name as 과목명 FROM tbl_subject WHERE STATE = 1;
-- 강의실 선택시 강의실명, 정원 출력
SELECT CL_SEQ, name as 교재명, capacity||'명' as 정원 FROM tbl_class_room WHERE STATE = 1;
-- 교재명 선택시 (교재, 출판사, 재고량) 출력
SELECT b.BOOK_SEQ, b.name as 교재명, p.name as 출판사, b.book_stock as 재고량 FROM tbl_book b
        INNER JOIN tbl_publisher p
                ON b.pub_seq = p.pub_seq WHERE B.STATE = 1;


--***입력
SELECT*FROM TBL_COURSE;
--과정
INSERT INTO tbl_course(cou_seq,name) VALUES (cou_seq.nextval, '과정입력성공');
-- 과목
INSERT INTO tbl_subject(sub_seq,name) VALUES (sub_seq.nextval,'');
--강의실 (강의실명, 정원 입력받기)
INSERT INTO tbl_class_room (cl_seq,name,capacity) VALUES(cl_seq.nextval,'',);
--교재명 (출판사명, 교재명 입력받기)
INSERT INTO tbl_publisher (pub_seq, name) VALUES (publisher_seq.nextval, ); --출판사 먼저 넣고
INSERT INTO tbl_book (book_seq, name, book_stock, pub_seq) VALUES (book_seq.nextval,'',11,pub_seq(fk)); --교재 수량 넣는다.





--***수정
--과정
UPDATE TBL_COURSE SET NAME = '과정 업데이트 성공!!'
  WHERE COU_SEQ = 2;

SELECT * FROM TBL_COURSE; --확인

--과목
UPDATE TBL_SUBJECT SET name= '과목 업데이트 성공!!'
  WHERE SUB_SEQ = 1;

SELECT*FROM TBL_SUBJECT;-- 확인

--강의실 (우선, 강의실명) -> 받은 값 따라 NAME자리에 정원 넣을수도 있음
UPDATE tbl_class_room SET name = '강의실 업데이트 성공!!'
  WHERE CL_SEQ = 1;

SELECT*FROM TBL_CLASS_ROOM; --확인

--교재명
UPDATE TBL_BOOK SET name= '교재명 업데이트 성공!!'
  WHERE book_seq = 1;
--출판사명
UPDATE TBL_PUBLISHER SET name= '출판사명 업데이트 성공!!'
  WHERE PUB_SEQ = 1;

select*from TBL_BOOK; --확인
select*from TBL_PUBLISHER; --확인





--***삭제
--과정
UPDATE TBL_COURSE SET STATE = 0
  WHERE COU_SEQ = 2;

SELECT * FROM TBL_COURSE; --확인

--과목
UPDATE TBL_SUBJECT SET STATE = 0
  WHERE SUB_SEQ = 1;

SELECT*FROM TBL_SUBJECT;-- 확인

--강의실 (우선, 강의실명) -> 받은 값 따라 NAME자리에 정원 넣을수도 있음
UPDATE tbl_class_room SET STATE = 0
  WHERE CL_SEQ = 1;

SELECT*FROM TBL_CLASS_ROOM; --확인

--교재명
UPDATE TBL_BOOK SET STATE = 0
  WHERE book_seq = 1;
--출판사명
UPDATE TBL_PUBLISHER SET STATE = 0
  WHERE PUB_SEQ = 1;

select*from TBL_BOOK; --확인
select*from TBL_PUBLISHER; --확인

-------------------------------------------------------------------------------------------- 교사계정관리--------------------------------------------------------------------------------------------------
-- 교사 등록하기

INSERT INTO TBL_TEACHER (T_ID, NAME, SSN, PHONE_NUMBER, PASSWORD, STATE)
 VALUES ('B'||TRIM(to_char(s_id_seq.nextval,'00')), '하이루', '2302482', '010-1342-2428', NULL, DEFAULT);

select*from TBL_TEACHER
-- 108
-- 교사계정관리 
-- 전체정보 출력
--select*from tbl_teacher;
--select*from tbl_ava_subject;
--select*from tbl_subject;

--전체 정보 출력
SELECT ROWNUM AS rnum,S.* FROM (SELECT t.name as 교사이름, t.ssn as 주민번호뒷자리, t.phone_number as 전화번호,T.T_ID
        FROM tbl_teacher t
               ORDER BY t.name) S;

-- 109
-- 1. 강의가능과목 출력
SELECT s.name as 강의가능과목
FROM tbl_teacher t
        INNER JOIN tbl_ava_subject a
                ON t.t_id = a.t_id
        INNER JOIN tbl_subject s
                ON a.sub_seq = s.sub_seq
 WHERE t.T_ID = (SELECT T_ID FROM
                  (SELECT ROWNUM as rnum,S.* FROM (SELECT t.name as 교사이름, t.ssn as 주민번호뒷자리, t.phone_number as 전화번호,T.T_ID FROM tbl_teacher t
                      ORDER BY t.name)S)
                          WHERE rnum=5);

---- 특정 과목 강의 가능한 선생님 출력
--SELECT t.name as 강의가능선생님
--        FROM tbl_teacher t
--                INNER JOIN tbl_ava_subject a
--                        ON t.t_id = a.t_id
--                                INNER JOIN tbl_subject s
--                                        ON a.sub_seq = s.sub_seq
--                                                WHERE s.name = 'CSS3' OR s.name = 'HTML5'; --> 물어보는 횟수만큼 출력하는 선생님이 모든 조건 충족!

--110

 특정 교사를 선택한 경우 배정된 개설 과목명, 개설 과목기간(시작 년월일, 끝 년월일), 과정명,
 개설 과정기간(시작 년월일, 끝 년월일),

 교재명, 강의실, 강의진행여부(강의 예정, 강의중, 강의종료)를
 확인할 수 있어야 한다. 강의진행여부는 날짜를 기준으로 확인한다.
-- 2. 개설과정 출력
 SELECT c.name as 과정명, cr.name as 강의실 ,oc.start_date as 과정시작일자, oc.end_date as 과정끝일자
        FROM tbl_open_course oc
                INNER JOIN tbl_course c
                        ON oc.cou_seq = c.cou_seq
                INNER JOIN tbl_class_room cr
                        ON oc.cl_seq = cr.cl_seq
        WHERE t_id =(SELECT T_ID FROM
                  (SELECT ROWNUM as rnum,S.* FROM (SELECT t.name as 교사이름, t.ssn as 주민번호뒷자리, t.phone_number as 전화번호,T.T_ID FROM tbl_teacher t
                      ORDER BY t.name)S)
                          WHERE rnum=1);

-- 3. 개설과목 출력
SELECT t.* FROM (SELECT c.name as 과정명, s.name as 과목명, b.name as 교재명
                , to_char(os.start_date,'yyyy-mm-dd') as 과목시작일자, to_char(os.end_date,'yyyy-mm-dd') as 과목끝일자
                , CASE
                        WHEN os.start_date <= sysdate AND os.end_date >= sysdate THEN '강의중'
                        WHEN os.start_date > sysdate THEN '강의예정'
                  ELSE '강의종료'
                END as 상태

        FROM tbl_open_course oc
                INNER JOIN tbl_course c
                        ON oc.cou_seq = c.cou_seq
                INNER JOIN tbl_open_subject os
                        ON oc.o_cou_seq = os.o_cou_seq
                INNER JOIN tbl_subject s
                        ON os.sub_seq = s.sub_seq
                INNER JOIN tbl_book b
                        ON os.book_seq = b.book_seq

        WHERE t_id = (SELECT T_ID FROM
                  (SELECT ROWNUM as rnum,S.* FROM (SELECT t.name as 교사이름, t.ssn as 주민번호뒷자리, t.phone_number as 전화번호,T.T_ID FROM tbl_teacher t
                      ORDER BY t.name)S)
                          WHERE rnum=1) ) T
        ORDER BY 과목끝일자 DESC, 과정명;


--교사정보 수정
UPDATE TBL_TEACHER SET name = '교사이름수정' where t_id = (SELECT T_ID FROM
                  (SELECT ROWNUM as rnum,S.* FROM (SELECT t.name as 교사이름, t.ssn as 주민번호뒷자리, t.phone_number as 전화번호,T.T_ID FROM tbl_teacher t
                      ORDER BY t.name)S)
                          WHERE rnum=1);

SELECT *from TBL_TEACHER;







--교사 강의가능과목 수정
-- 교사의 강의 가능 과목은 기초 정보 과목명을 이용해서 선택적으로 추가할 수 있어야 한다.
select*from TBL_AVA_SUBJECT;

--<<프로시저>>
CREATE OR REPLACE PROCEDURE proc_TBL_AVA_SUBJECT_add(
  psub_seq NUMBER,
  presult OUT VARCHAR2
)
IS
  vcount NUMBER;
BEGIN
  SELECT count(*) INTO vcount FROM TBL_AVA_SUBJECT
  WHERE SUB_SEQ = psub_seq;

  IF vcount = 0 THEN
    INSERT INTO TBL_AVA_SUBJECT (AVA_SUB_SEQ, T_ID, SUB_SEQ) VALUES (AVA_SUB_SEQ.nextval,'B1',psub_seq);
    presult := '등록되었습니다.';
  ELSE
    presult := '이미 등록된 강의가능과목입니다.';
  END IF;
END;

--교사 삭제


-------------------------------------------------------------------------4. 개설과정관리---------------------------------------------------------------------------
--입력
INSERT INTO TBL_OPEN_COURSE (O_COU_SEQ, START_DATE, END_DATE, CL_SEQ, COU_SEQ, M_ID, T_ID)
  VALUES (1, TO_DATE('2017-08-08 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-03-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 1, 'A1', 'B1');


--1출력
SELECT oc.O_COU_SEQ, c.name as 과정명, oc.start_date as 시작일자, oc.end_date as 종료일자, cr.name as 강의실, COUNT(S.O_COU_SEQ)||'명' as 수강인원
FROM TBL_OPEN_COURSE oc
  INNER JOIN tbl_course c
    ON oc.COU_SEQ = c.COU_SEQ
  INNER JOIN TBL_CLASS_ROOM cr
    ON oc.CL_SEQ = cr.cl_seq
  INNER JOIN TBL_COURSE_STUDENT S
    ON oc.O_COU_SEQ = S.O_COU_SEQ

  WHERE OC.STATE = 1 --삭제되지 않은 과정
  GROUP BY oc.O_COU_SEQ, C.NAME, oc.start_date, oc.end_date, CR.NAME, S.O_COU_SEQ
  ORDER BY oc.O_COU_SEQ;


--1-1개설 과목 출력
-- 삭제되지 않은 과정목록을 띄워준 후 선택받는것이기 때문에 따로 삭제여부를 확인할 필요는 없다.
SELECT s.name as 과목명, b.name as 교재명
                , to_char(os.start_date,'yyyy-mm-dd') as 과목시작일자, to_char(os.end_date,'yyyy-mm-dd') as 과목끝일자
                , CASE
                        WHEN os.start_date <= sysdate AND os.end_date >= sysdate THEN '강의중'
                        WHEN os.start_date > sysdate THEN '강의예정'
                  ELSE '강의종료'
                END as 상태

        FROM tbl_open_course oc
                INNER JOIN tbl_course c
                        ON oc.cou_seq = c.cou_seq
                INNER JOIN tbl_open_subject os
                        ON oc.o_cou_seq = os.o_cou_seq
                INNER JOIN tbl_subject s
                        ON os.sub_seq = s.sub_seq
                INNER JOIN tbl_book b
                        ON os.book_seq = b.book_seq

        WHERE oc.O_COU_SEQ = 2
        ORDER BY 과목끝일자 DESC;

--1-2 등록된 교육생 정보 출력
-- 교육생 이름, 주민번호 뒷자리, 전화번호, 수료 및 중도탈락
SELECT TS.NAME AS 이름 , TS.SSN AS 주민번호뒷자리, TS.PHONE_NUMBER AS 전화번호,
CASE
 WHEN DO.ST_COU_SEQ IS NULL AND C.END_DATE > SYSDATE AND C.START_DATE <SYSDATE THEN '수강중'
 WHEN DO.ST_COU_SEQ IS NULL AND C.END_DATE < SYSDATE THEN '수료'
 WHEN DO.ST_COU_SEQ IS NULL AND C.START_DATE > SYSDATE THEN '수강전'
 WHEN DO.ST_COU_SEQ IS NOT NULL THEN '중퇴'
END as 수강현황


FROM TBL_OPEN_COURSE C
  INNER JOIN TBL_COURSE_STUDENT CS
    ON C.O_COU_SEQ = CS.O_COU_SEQ
  INNER JOIN TBL_STUDENT TS
    ON CS.S_ID = TS.S_ID
  LEFT OUTER JOIN TBL_DROP_OUT DO
    ON CS.ST_COU_SEQ = DO.ST_COU_SEQ
WHERE CS.O_COU_SEQ = 3;


SELECT*FROM TBL_DROP_OUT;


--1-3 개설과정수정  -> 프로시저로 중복 안되게 수정 같은 기간 과정끼리 강의실 중복, 선생님 중복 안됨
-- 담당 매니저만 수정 가능
-- 강의 종료일은 시작일보다 뒤여야 한다.
-- 과정명, 과정기간(시작 년월일, 끝 년월일), 강의실, 담당선생님 정보 수정 가능
UPDATE TBL_OPEN_COURSE SET CL_SEQ = 1 WHERE O_COU_SEQ = 3; -- 강의실
UPDATE TBL_OPEN_COURSE SET COU_SEQ = 1 WHERE O_COU_SEQ = 3; -- 과정
UPDATE TBL_OPEN_COURSE SET T_ID = 'B1' WHERE O_COU_SEQ = 3; -- 선생님
UPDATE TBL_OPEN_COURSE SET START_DATE = TO_DATE('2017-08-09', 'YYYY-MM-DD') WHERE O_COU_SEQ = 3; --과정기간 시작일
UPDATE TBL_OPEN_COURSE SET END_DATE = TO_DATE('2017-10-18', 'YYYY-MM-DD') WHERE O_COU_SEQ = 3; --과정기간 종료일

SELECT*FROM TBL_OPEN_COURSE;


--개설과정삭제(폐강 등록하기)
UPDATE TBL_OPEN_COURSE SET STATE = 0 WHERE O_COU_SEQ = 3; -- 강의실
SELECT*FROM TBL_OPEN_COURSE