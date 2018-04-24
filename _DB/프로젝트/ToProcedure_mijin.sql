---------------------------------------------------<<기초정보 관리>>-----------------------------------------------------

--기초정보 출력 뷰 생성
SELECT*FROM TBL_OPEN_COURSE;
UPDATE TBL_OPEN_COURSE SET T_ID = 'B1' WHERE O_COU_SEQ = 4 ;
ROLLBACK;
COMMIT;

-- 뷰 삭제
drop view tbl_class_room_view;
--과정 뷰
CREATE VIEW tbl_course_view
AS
SELECT COU_SEQ, name FROM tbl_course
    WHERE STATE = 1;

--과목 뷰
CREATE VIEW tbl_subject_view
AS
SELECT SUB_SEQ, name FROM tbl_subject
    WHERE STATE = 1;

--강의실 뷰
CREATE VIEW tbl_class_room_view
AS
SELECT CL_SEQ, name, capacity FROM tbl_class_room
    WHERE STATE = 1;


-- 교재 뷰
CREATE VIEW tbl_book_view
AS
SELECT b.BOOK_SEQ, b.name as bname, p.name as pname, b.book_stock FROM tbl_book b
        INNER JOIN tbl_publisher p
                ON b.pub_seq = p.pub_seq

    WHERE B.STATE = 1 AND BOOK_SEQ>=1  AND BOOK_SEQ <=12
    ORDER BY BOOK_SEQ;

--출판사 뷰
CREATE VIEW tbl_publisher_view
AS
SELECT*FROM TBL_PUBLISHER WHERE STATE = 1;

-------------------------------------------------------------------
DELETE TBL_CLASS_ROOM_VIEW WHERE CL_SEQ=21;

COMMIT;
select*from TBL_book_VIEW
;
--1. 출력
commit;
update tbl_course set name = 'JAVA를 활용한 웹개발 전문가 양성과정' where cou_seq = 2 ;
select*from tbl_course;
--과정출력
CREATE OR REPLACE PROCEDURE proc_list_course (
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR SELECT*FROM tbl_course_view;
END;

--과목 출력
CREATE OR REPLACE PROCEDURE proc_list_subject (
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR SELECT * FROM tbl_subject_view;
END;

-- 강의실 출력
CREATE OR REPLACE PROCEDURE proc_list_class_room (
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR SELECT*FROM tbl_class_room_view;

END;

--교재 출력
CREATE OR REPLACE PROCEDURE proc_list_book (
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR SELECT * FROM tbl_book_view;
END;
select*from tbl_book;
update tbl_book set name = '객체지향 프로그래밍' where book_seq = 15;

-- 출판사 출력
CREATE OR REPLACE PROCEDURE proc_list_publisher(
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR SELECT*FROM tbl_publisher_view;

END;


--2. 등록
-- 1이면 등록 성공, 아니면 이미 등록된 것.
select*from tbl_COURSE;
--과정 등록
CREATE OR REPLACE PROCEDURE proc_add_course(
	pname VARCHAR2,
	presult OUT NUMBER
)
IS
	vcount NUMBER;
BEGIN
	SELECT count(*) INTO vcount FROM TBL_COURSE
		WHERE name = pname;

	IF vcount = 0 THEN
		INSERT INTO tbl_course(cou_seq,name) VALUES (cou_seq.nextval, pname);
		presult := 1;
	ELSE
		presult := 2;
	END IF;

	EXCEPTION
      WHEN OTHERS THEN
            presult := 0;
            ROLLBACK ;
END;

-- 과목 등록
CREATE OR REPLACE PROCEDURE proc_add_subject(
	pname VARCHAR2,
	presult OUT NUMBER
)
IS
	vcount NUMBER;
BEGIN
	SELECT count(*) INTO vcount FROM TBL_SUBJECT
		WHERE name = pname;

	IF vcount = 0 THEN
		INSERT INTO tbl_subject(sub_seq,name) VALUES (sub_seq.nextval,pname);
		presult := 1;
	ELSE
		presult := 2;
	END IF;

	EXCEPTION
      WHEN OTHERS THEN
            presult := 0;
            ROLLBACK ;

END;



--강의실 등록
CREATE OR REPLACE PROCEDURE proc_add_class_room(
	pname VARCHAR2,
	pcapacity NUMBER,
	presult OUT NUMBER
)
IS
	vcount NUMBER;
BEGIN
	SELECT count(*) INTO vcount FROM TBL_CLASS_ROOM
		WHERE name = pname;

	IF vcount = 0 THEN
		INSERT INTO tbl_class_room (cl_seq, name, capacity) VALUES(cl_seq.nextval, pname, pcapacity);
		presult := 1;
	ELSE
		presult := 2;
	END IF;

	EXCEPTION
      WHEN OTHERS THEN
            presult := 0;
            ROLLBACK ;

END;

-- 출판사범위안에서 출력했는지 확인하는 용
CREATE OR REPLACE PROCEDURE PROC_CHECK_PUBLISHER(
PPUB_SEQ NUMBER,
PRESULT OUT NUMBER
)
IS
	VCOUNT NUMBER;
BEGIN
	SELECT COUNT(*) INTO VCOUNT FROM tbl_publisher_view WHERE PUB_SEQ = PPUB_SEQ;
	IF VCOUNT = 1 THEN
		PRESULT := 1; --성공
		ELSE
		PRESULT := 2; --범위안에서 입력하세요요	END IF;
	end if;
END;


-- 교재 등록
CREATE OR REPLACE PROCEDURE proc_add_book(
	pname VARCHAR2,
	pbook_stock NUMBER,
	ppub_seq NUMBER,
	presult OUT NUMBER
)
IS
	vcount NUMBER;
BEGIN
	SELECT count(*) INTO vcount FROM TBL_BOOK
		WHERE name = pname AND pub_seq = ppub_seq;

	IF vcount = 0 THEN--중복되는거 없으면 삽입
		INSERT INTO tbl_book (book_seq, name, book_stock, pub_seq, state)
					VALUES (book_seq.nextval,pname,pbook_stock,ppub_seq, DEFAULT);
		presult := 1;
	ELSIF vcount = 1 THEN--출판사 교재명 같으면 중복돼서 안됨
		presult := 2;
	END IF;

	EXCEPTION
      WHEN OTHERS THEN
            presult := 0; --번호 제대로 입력하기
            ROLLBACK ;

END;

	select*from tbl_publisher_view;

-- 출판사 등록
CREATE OR REPLACE PROCEDURE proc_add_pub(
	pname VARCHAR2,
	presult OUT NUMBER
)
IS
	vcount NUMBER;
BEGIN
	SELECT count(*) INTO vcount FROM TBL_PUBLISHER
		WHERE name = pname;

	IF vcount = 0 THEN
		INSERT INTO tbl_publisher (pub_seq, name) VALUES (publisher_seq.nextval, pname);
		presult := 1;
	ELSE
		presult := 2;
	END IF;

	EXCEPTION
      WHEN OTHERS THEN
            presult := 0;
            ROLLBACK ;

END;


-- 3. 수정
-- 1이면 수정 성공, 아니면 이미 등록된 것.


--기존 과정 정보 불러오기
CREATE OR REPLACE PROCEDURE PROC_EDIT_COURSE_ORIGINAL(
PCOU_SEQ NUMBER,
PCURSOR OUT SYS_REFCURSOR
)
	IS
	BEGIN
		OPEN PCURSOR FOR
		SELECT NAME FROM TBL_COURSE_VIEW WHERE COU_SEQ = PCOU_SEQ;
	END;


--과정 수정
CREATE OR REPLACE PROCEDURE proc_edit_course(
	pcou_seq NUMBER,
	pname VARCHAR2,
	presult OUT NUMBER
)
IS
	vcount NUMBER;
	acount NUMBER;
BEGIN
	SELECT count(*) INTO vcount FROM (SELECT*FROM TBL_COURSE_VIEW WHERE COU_SEQ <> PCOU_SEQ)
		WHERE name = pname; -- 새로입력할 값과 중복되는 값이 없어야 하며

	SELECT count(*) INTO acount FROM TBL_COURSE_VIEW
		WHERE COU_SEQ = pcou_seq; --수정하고자 하는 과정이 존재해야 한다.

	IF acount = 1 THEN
		IF vcount = 0 THEN
			UPDATE TBL_COURSE SET NAME = PNAME
			WHERE COU_SEQ = pcou_seq;
			presult := 1; -- 수정 성공했습니다.
		ELSIF vcount >= 1 THEN
		 presult := 2; -- 이미 같은 항목이 존재합니다.
		END IF;
	ELSIF acount = 0 THEN
		presult := 3; -- 목록에 있는 번호를 입력하세요.
	END IF;

EXCEPTION
      WHEN OTHERS THEN
            presult := 0; -- 숫자로만 입력하세요.
            ROLLBACK ;
END;

--기존 과목 불러오기
CREATE OR REPLACE PROCEDURE PROC_EDIT_subject_ORIGINAL(
Psub_SEQ NUMBER,
PCURSOR OUT SYS_REFCURSOR
)
	IS
	BEGIN
		OPEN PCURSOR FOR
		SELECT NAME FROM tbl_subject_view WHERE sub_SEQ = Psub_SEQ;
	END;

-- 과목 수정
CREATE OR REPLACE PROCEDURE proc_edit_subject(
	psub_seq NUMBER,
	pname VARCHAR2,
	presult OUT NUMBER
)
IS
	vcount NUMBER;
	acount NUMBER;
BEGIN
	SELECT count(*) INTO vcount FROM (SELECT*FROM tbl_subject_view WHERE SUB_SEQ <> PSUB_SEQ)
		WHERE name = pname;
	SELECT count(*) INTO acount FROM tbl_subject_view
		WHERE SUB_SEQ = psub_seq;


	IF acount = 1 THEN
		IF vcount = 0 THEN
			UPDATE TBL_SUBJECT SET name= PNAME
  	WHERE SUB_SEQ = psub_seq;
			presult := 1; -- 수정 성공했습니다.
		ELSIF vcount >= 1 THEN
		 presult := 2; -- 이미 같은 항목이 존재합니다.
		END IF;
	ELSIF acount = 0 THEN
		presult := 3; -- 목록에 있는 번호를 입력하세요.
	END IF;


EXCEPTION
      WHEN OTHERS THEN
            presult := 0;
            ROLLBACK ;
END;






--기존 강의실 불러오기
CREATE OR REPLACE PROCEDURE PROC_EDIT_class_room_ORIGINAL(
Pcl_SEQ NUMBER,
PCURSOR OUT SYS_REFCURSOR
)
	IS
	BEGIN
		OPEN PCURSOR FOR
		SELECT NAME, capacity FROM tbl_class_room_view  WHERE cl_SEQ = Pcl_SEQ;
	END;

--강의실 수정
CREATE OR REPLACE PROCEDURE proc_edit_class_room(
	pcl_seq NUMBER,
	pname VARCHAR2,
	pcapacity NUMBER,
	presult OUT NUMBER
)
IS
	vcount NUMBER; -- 중복값이 있는지 확인하는 변수
	acount NUMBER; -- 입력받은 항목이 존재하는지 담을 변수
BEGIN
	SELECT count(*) INTO vcount FROM (SELECT*FROM tbl_class_room_view WHERE cl_SEQ <> Pcl_SEQ)
		WHERE name = pname;
	SELECT count(*) INTO acount FROM tbl_class_room_view
		WHERE CL_SEQ = pcl_seq;

	IF acount = 1 THEN
		IF vcount = 0 THEN
			UPDATE tbl_class_room SET name = pname, capacity = pcapacity
  		WHERE CL_SEQ = pcl_seq;
			presult := 1; -- 수정 성공했습니다.
		ELSIF vcount >= 1 THEN
		 presult := 2; -- 이미 같은 항목이 존재합니다.
		END IF;
	ELSIF acount = 0 THEN
		presult := 3; -- 목록에 있는 번호를 입력하세요.
	END IF;

EXCEPTION
    WHEN OTHERS THEN
    presult := 0;
  	ROLLBACK ;
END;





--기존 교재 불러오기
CREATE OR REPLACE PROCEDURE PROC_EDIT_book_ORIGINAL(
PBOOK_SEQ NUMBER,
PCURSOR OUT SYS_REFCURSOR
)
	IS
	BEGIN
		OPEN PCURSOR FOR
		SELECT NAME, BOOK_SEQ, book_stock, PUB_SEQ FROM tbl_book WHERE BOOK_SEQ = PBOOK_SEQ;
	END;

-- 교재 수정
CREATE OR REPLACE PROCEDURE proc_edit_book(
	pbook_seq NUMBER,
	pname VARCHAR2,
	pbook_stock NUMBER,
	ppub_seq NUMBER,
	presult OUT NUMBER
)
IS
	acount NUMBER;
	vcount NUMBER;
BEGIN
	SELECT count(*) INTO acount FROM TBL_BOOK_VIEW
		WHERE BOOK_SEQ = pbook_seq;

	SELECT count(*) INTO vcount FROM (SELECT*FROM (SELECT*FROM TBL_BOOK WHERE STATE = 1) WHERE BOOK_SEQ <> PBOOK_SEQ)
		WHERE name = pname AND pub_seq = ppub_seq;

	IF acount = 1 THEN --
		IF vcount = 0 THEN
			UPDATE tbl_book SET name = pname, book_stock = pbook_stock, pub_seq = ppub_seq
			WHERE book_seq = pbook_seq;
			presult := 1; --성공
		ELSIF vcount >= 1 THEN
			presult := 2 ; --중복값이 있습니다.
		END IF;
	ELSE
		presult := 3; --목록중에서 있는 번호로 다시 입력하세요
	END IF;

EXCEPTION
      WHEN OTHERS THEN
            presult := 0; --숫자로만 입력하세요
            ROLLBACK ;
END;


--기존 출판사 불러오기
CREATE OR REPLACE PROCEDURE PROC_EDIT_pub_ORIGINAL(
Ppub_SEQ NUMBER,
PCURSOR OUT SYS_REFCURSOR
)
	IS
	BEGIN
		OPEN PCURSOR FOR
		SELECT NAME FROM tbl_publisher_view WHERE pub_SEQ = Ppub_SEQ;
	END;


-- 출판사 수정
CREATE OR REPLACE PROCEDURE proc_edit_pub(
	ppub_seq NUMBER,
	pname VARCHAR2,
	presult OUT NUMBER
)
IS
	vcount NUMBER;
	acount NUMBER;
BEGIN
	SELECT count(*) INTO vcount FROM (SELECT*FROM tbl_publisher_view WHERE pub_SEQ <> Ppub_SEQ)
		WHERE name = pname;
	SELECT count(*) INTO acount FROM tbl_publisher_view
		WHERE PUB_SEQ = ppub_seq;

	IF vcount = 0 AND acount = 1 THEN
		UPDATE TBL_PUBLISHER SET name= PNAME
  	WHERE PUB_SEQ = ppub_seq;
		presult := 1;
	ELSIF vcount >= 1 AND acount = 1 THEN
		presult := 2; -- 기존 출판사명이랑 동일한게 있음 수정 못함
	END IF;
EXCEPTION
      WHEN OTHERS THEN
            presult := 0;
            ROLLBACK ;
END;


-- 4. 삭제

--현재 과정에 들어가 있는 과정이면 삭제 불가능으로 수정
--아래 강의실, 교사 중복 참고해서 수정하기


-- select*from tbl_open_course_view;
--
-- select CL_SEQ from tbl_class_room_view
-- 	minus
-- select DISTINCT CL_SEQ from TBL_OPEN_COURSE_VIEW
-- WHERE (start_date <= sysdate AND end_date >= sysdate)
--                         OR(start_date > sysdate);
--
-- commit;
--
--
-- select*from TBL_OPEN_SUBJECT;


--과정 삭제
CREATE OR REPLACE PROCEDURE proc_del_course(
	pcou_seq NUMBER,
	presult OUT NUMBER
)
IS
	vcount NUMBER;
	acount number;
BEGIN
	SELECT count(*) INTO vcount FROM tbl_course_view
		WHERE COU_SEQ = pcou_seq; --수정하고자 하는 과정이 존재해야 한다.

	--강의 예정, 진행중이지 않은 과정 -> 삭제 가능
	SELECT count(*) INTO acount
	FROM
		(
			SELECT COU_SEQ from tbl_course_view
			MINUS
			SELECT DISTINCT COU_SEQ from TBL_OPEN_COURSE_VIEW
			WHERE (start_date <= sysdate AND end_date >= sysdate) OR (start_date > sysdate)
		)
	WHERE COU_SEQ = pcou_seq;

	IF acount = 1 THEN
		-- 삭제처리하기
		UPDATE TBL_COURSE SET STATE = 0
  	WHERE COU_SEQ = pcou_seq;
		presult := 1; -- 삭제 성공했습니다.
	ELSIF acount = 0 and vcount = 1 then
		presult := 2; -- 현재 개설과정 진행중/예정인 과정입니다. 삭제를 원하시면 먼저 개설과정을 수정해주세요.
	ELSE
		presult := 0; -- 목록에서 번호를 입력해주세요
	END IF;
END;

--과목 삭제
CREATE OR REPLACE PROCEDURE proc_del_subject(
	psub_seq NUMBER,
	presult OUT NUMBER
)
IS
	vcount NUMBER;
	acount number;
BEGIN
	SELECT count(*) INTO vcount FROM TBL_SUBJECT_VIEW
		WHERE SUB_SEQ = psub_seq; --수정하고자 하는 과정이 존재해야 한다.

	--강의 예정, 진행중이지 않은 과목 ->삭제할 수 있는 과목
	SELECT count(*) INTO acount
		FROM
			(
				SELECT SUB_SEQ FROM tbl_subject_view
				MINUS
				SELECT DISTINCT s.SUB_SEQ FROM TBL_OPEN_COURSE_VIEW oc
				INNER JOIN TBL_OPEN_SUBJECT s
				ON oc.O_COU_SEQ = s.O_COU_SEQ
				WHERE (oc.start_date <= sysdate AND oc.end_date >= sysdate)
																				OR(oc.start_date > sysdate)
			)
		WHERE SUB_SEQ = psub_seq;

	IF acount = 1 THEN
		--삭제처리하기
		UPDATE TBL_SUBJECT SET STATE = 0
  	WHERE SUB_SEQ = psub_seq;
		presult := 1; -- 삭제 성공했습니다.
	ELSIF acount = 0 and vcount = 1 then
		presult := 2; -- 현재 개설과정 진행중/예정인 과정입니다. 삭제를 원하시면 먼저 개설과정을 수정해주세요.
	ELSE
		presult := 0; -- 목록에서 번호를 입력해주세요
	END IF;
END;
--강의실 삭제
CREATE OR REPLACE PROCEDURE proc_del_class_room(
	pcl_seq NUMBER,
	presult OUT NUMBER
)
IS
	vcount NUMBER;
	acount NUMBER;
BEGIN
	SELECT count(*) INTO vcount FROM tbl_class_room_view
		WHERE cl_SEQ = pcl_seq; --수정하고자 하는 과정이 존재해야 한다.

	SELECT COUNT (*) INTO acount
		FROM
			(
				SELECT CL_SEQ FROM tbl_class_room_view
				MINUS
				SELECT DISTINCT CL_SEQ FROM TBL_OPEN_COURSE_VIEW
				WHERE (start_date <= sysdate AND end_date >= sysdate)
																			OR(start_date > sysdate)
			)
		WHERE CL_SEQ =pcl_seq;

	IF acount = 1 THEN
		--삭제처리하기
		UPDATE TBL_CLASS_ROOM SET STATE = 0
  	WHERE Cl_SEQ = pcl_seq;
		presult := 1; -- 삭제 성공했습니다.
	ELSif acount = 0 and vcount = 1 then
		presult := 2; -- 현재 개설과정 진행중/예정인 과정입니다. 삭제를 원하시면 먼저 개설과정을 수정해주세요.
	ELSE
		presult := 0; -- 목록에서 번호를 입력해주세요
	END IF;
END;
--교재 삭제
CREATE OR REPLACE PROCEDURE proc_del_book(
	pbook_seq NUMBER,
	presult OUT NUMBER
)
IS
	vcount NUMBER;
	acount NUMBER;
BEGIN
	SELECT count(*) INTO vcount FROM TBL_BOOK_VIEW
		WHERE book_SEQ = pbook_seq; --수정하고자 하는 교재가 존재해야 한다.

		SELECT count(*) INTO acount
		FROM
			(
				SELECT book_SEQ FROM tbl_book_view
				MINUS
				SELECT DISTINCT s.BOOK_SEQ FROM TBL_OPEN_COURSE_VIEW oc
				INNER JOIN TBL_OPEN_SUBJECT s
				ON oc.O_COU_SEQ = s.O_COU_SEQ
				WHERE (oc.start_date <= sysdate AND oc.end_date >= sysdate)
																				OR(oc.start_date > sysdate)
			)
		WHERE BOOK_SEQ = pbook_seq;


	IF acount = 1 THEN
		UPDATE TBL_BOOK SET STATE = 0
  	WHERE BOOK_SEQ = pbook_seq;
		presult := 1; -- 삭제 성공했습니다.
	ELSif acount = 0 and vcount = 1 then
		presult := 2; -- 현재 개설과정 진행중/예정인 과정입니다. 삭제를 원하시면 먼저 개설과정을 수정해주세요.
	ELSE
		presult := 0; -- 목록에서 번호를 입력해주세요
	END IF;
END;
-- 출판사 삭제
--출판사 삭제하면 교재도 자동으로 삭제
CREATE OR REPLACE PROCEDURE proc_del_publisher(
	ppub_seq NUMBER,
	presult OUT NUMBER
)
IS
	vcount NUMBER;
	acount NUMBER;
BEGIN
	SELECT count(*) INTO vcount FROM tbl_publisher_view
		WHERE pub_SEQ = ppub_seq; --수정하고자 하는 교재가 존재해야 한다.

	--삭제해도 되는 출판사 목록
	SELECT count(*) INTO acount
		FROM
			(
				SELECT PUB_SEQ FROM tbl_publisher_view
				MINUS
				SELECT DISTINCT BOOK.PUB_SEQ FROM TBL_OPEN_COURSE_VIEW oc
				INNER JOIN TBL_OPEN_SUBJECT s
				ON oc.O_COU_SEQ = s.O_COU_SEQ
				INNER JOIN TBL_BOOK BOOK
				ON s.BOOK_SEQ = BOOK.BOOK_SEQ
				WHERE (oc.start_date <= sysdate AND oc.end_date >= sysdate)
																				OR(oc.start_date > sysdate)
			)
		WHERE PUB_SEQ = ppub_seq;


	IF acount = 1 THEN
		UPDATE TBL_PUBLISHER SET STATE = 0
  	WHERE pub_SEQ = ppub_seq;

		UPDATE tbl_book SET STATE = 0
			WHERE PUB_SEQ = ppub_seq; --책까지 같이 삭제
		presult := 1; -- 삭제 성공했습니다.
	ELSif acount = 0 and vcount = 1 then
		presult := 2; -- 현재 개설과정 진행중/예정인 과정입니다. 삭제를 원하시면 먼저 개설과정을 수정해주세요.
	ELSE
		presult := 0; -- 목록에서 번호를 입력해주세요
	END IF;
END;

	SELECT*FROM TBL_SCORE;

---------------------------------------------------<<교사정보 관리>>-----------------------------------------------------

--1. 등록
-- 교사 존재하는 교사만 뷰
CREATE VIEW tbl_teacher_view
AS
SELECT * FROM tbl_teacher
    WHERE STATE = 1;

--기존에 같은 교사 있는지 확인
create or REPLACe PROCEDURE proc_add_teacher_check(
  PSSN VARCHAR2,
	presult out number

)IS
	VCOUNT NUMBER;
	BEGIN
		SELECT count(*) INTO vcount FROM TBL_TEACHER_VIEW
		WHERE ssn = pssn;

		IF vcount = 0 THEN

		presult := 1;
	ELSE
		presult := 2;
	END IF;

	EXCEPTION
      WHEN OTHERS THEN
            presult := 0;
            ROLLBACK ;
END;


	select*from tbl_state;
-- 교사 등록
CREATE OR REPLACE PROCEDURE proc_add_teacher(
	pssn VARCHAR2,
	pname VARCHAR2,
	pphone_number VARCHAR2
)
IS
BEGIN

		INSERT INTO TBL_TEACHER (T_ID, NAME, SSN, PHONE_NUMBER, PASSWORD, STATE)
VALUES ('B'||TRIM(to_char(s_id_seq.nextval,'00')), pname, pssn, pphone_number, pssn, DEFAULT);

END;
-- 교사 강의가능과목 등록 --모든 교사에게 강의가능 과목 등록할 수 있다.
CREATE OR REPLACE PROCEDURE PROC_ADD_AVA_SUBJECT(

	PT_ID VARCHAR2,
	PSUB_SEQ NUMBER,
	presult OUT NUMBER
)
IS
	VCOUNT NUMBER;
	ACOUNT NUMBER;
BEGIN
	SELECT COUNT(*) INTO VCOUNT FROM tbl_subject_view WHERE SUB_SEQ=PSUB_SEQ;
	SELECT COUNT(*) INTO ACOUNT FROM (SELECT SUB_SEQ FROM TBL_AVA_SUBJECT_view WHERE T_ID=PT_ID) WHERE SUB_SEQ=PSUB_SEQ;

	IF VCOUNT = 1 THEN
		IF ACOUNT = 0 THEN
			INSERT INTO TBL_AVA_SUBJECT VALUES(AVA_SUB_SEQ.nextval, PT_ID, PSUB_SEQ, DEFAULT);
			presult :=1; --등록되었습니다.
		ELSE
			presult :=2; --이미 등록된 강의입니다.
		END IF;
	ELSE
		presult :=3; -- 목록에 있는 과목 번호를 입력하세요

	END IF;

	EXCEPTION
      WHEN OTHERS THEN
            presult := 0;
            ROLLBACK ;
END;

--2. 출력

--담당매니저 포함 강의예정, 강의중인 교사 정보뷰
CREATE VIEW list_teacher_view
AS
SELECT T.T_ID as t_id, T.name as name, T.ssn as ssn, T.phone_number as phone_number, oc.M_ID as m_id
        FROM tbl_teacher_view t
			INNER JOIN TBL_OPEN_COURSE oc
					ON T.T_ID = OC.T_ID
			WHERE (oC.start_date <= sysdate AND oC.end_date >= sysdate)
                        OR(oC.start_date > sysdate);



SELECT*FROM TBL_OPEN_COURSE;
--(전체) 교사 제대로 골랐는지 확인하는 프로시저
CREATE OR REPLACE PROCEDURE PROC_TEACHER_LIST_CHECK(
PT_ID VARCHAR2,
PRESULT OUT NUMBER
)
IS
VCOUNT NUMBER;
BEGIN
	SELECT COUNT(*) INTO VCOUNT FROM tbl_teacher_view WHERE T_ID = pt_id;

	IF VCOUNT = 1 THEN
		PRESULT := 1;
	ELSE
		PRESULT := 2; --목록에 있는 교사아이디만 입력해주세요
	END IF;

	EXCEPTION
	WHEN OTHERS THEN
	PRESULT := 0; --아이디를 정확히 입력하세요

END;

--(담당) 교사 제대로 골랐는지 확인하는 프로시저
CREATE OR REPLACE PROCEDURE PROC_TEACHER_LIST_CHECK_MY(
	PM_ID VARCHAR2,
	PT_ID       VARCHAR2,
	PRESULT OUT NUMBER
)
	IS
  VCOUNT NUMBER;
	BEGIN
		select COUNT(*) INTO VCOUNT from (select T_ID, NAME, SSN, phone_number from list_teacher_view
			WHERE M_ID = PM_ID
				GROUP BY T_ID, NAME, SSN, phone_number
        	ORDER BY T_ID) WHERE t_id =pt_id;



			IF vcount = 1 THEN
				PRESULT := 1; --출력 성공
	ELSE
		PRESULT := 2; --목록에 있는 교사아이디만 입력해주세요
	END IF;
	EXCEPTION
	WHEN OTHERS THEN
	PRESULT := 0; --아이디를 정확히 입력하세요

	END;

SELECT*FROM tbl_teacher_view;
SELECT*FROM TBL_OPEN_COURSE_VIEW;

--(전체)교사 전체정보 출력, 학원에 등록돼 있는 모든 교사정보 출력
CREATE OR REPLACE PROCEDURE proc_list_teacher(
          pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
		SELECT T_ID, name, ssn, phone_number
        FROM tbl_teacher_view
               ORDER BY T_ID;
END;


CREATE OR REPLACE PROCEDURE proc_list_teacher_one(
pt_id VARCHAR2,
	  pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
		SELECT T_ID, name, ssn, phone_number
        FROM tbl_teacher_view
        where t_id = pt_id
               ORDER BY T_ID;
END;


	UPDATE tbl_teacher set PASSWORD = SSN;

SELECT*FROM tbl_teacher_view;

--(담당)교사 전체정보 출력, 내가 담당하는, 할, 과정의 교사만 출력, --중복 제거
CREATE OR REPLACE PROCEDURE proc_list_teacher_manager(
	PM_ID VARCHAR2,
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
		select T_ID, NAME, SSN, phone_number from list_teacher_view
			WHERE M_ID = PM_ID
				GROUP BY T_ID, NAME, SSN, phone_number
        	ORDER BY T_ID;
END;

	UPDATE tbl_teacher SET STATE = 0 WHERE T_ID = 'B02';
SELECT*FROM tbl_teacher_view;


--특정교사 강의가능과목 출력
--과목이 삭제되면 특정교사의 강의가능과목도 자동으로 출력 안함
CREATE OR REPLACE PROCEDURE PROC_teacher_ava_subject(
	pt_id VARCHAR2,
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
		OPEN pcursor FOR
		SELECT A.AVA_SUB_SEQ, s.name
		FROM tbl_teacher_view t
						INNER JOIN tbl_ava_subject_VIEW a
										ON t.t_id = a.t_id
						INNER JOIN TBL_SUBJECT_VIEW s
										ON a.sub_seq = s.sub_seq
		 WHERE t.T_ID = pt_id;
END;

--삭제안된 강의가능과목 뷰
CREATE VIEW TBL_AVA_SUBJECT_VIEW
	AS
SELECT AVA_SUB_SEQ, T_ID, SUB_SEQ FROM TBL_AVA_SUBJECT WHERE STATE = 1;


--특정교사 개설과정 출력
CREATE OR REPLACE PROCEDURE proc_list_teacher_course(
	pt_id VARCHAR2,
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
		OPEN pcursor FOR
		SELECT c.name as 과정명, cr.name as 강의실 ,to_char(oc.start_date,'yyyy-mm-dd') as 과목시작일자, to_char(oc.end_date,'yyyy-mm-dd') as 과목끝일자
			, CASE
        		WHEN oC.start_date <= sysdate AND oC.end_date >= sysdate THEN '강의중'
            WHEN oC.start_date > sysdate THEN '강의예정'
        ELSE '강의종료'
			END as 상태

					FROM tbl_open_course_VIEW oc
									INNER JOIN TBL_COURSE c
													ON oc.cou_seq = c.cou_seq
									INNER JOIN TBL_CLASS_ROOM cr
													ON oc.cl_seq = cr.cl_seq
					WHERE t_id = pt_id; --삭제되지 않은 개설과정만 출력
END;
--특정교사 개설과목 출력
CREATE OR REPLACE PROCEDURE proc_list_teacher_open_subject(
	pt_id VARCHAR2,
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
	SELECT c.name as 과정명, s.name as 과목명, b.name as 교재명
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

  WHERE t_id = pt_id
  ORDER BY 과목끝일자 DESC, 과정명 ASC;
END;   --뒤에 있는거로 활용

select*from TBL_AVA_SUBJECT;
SELECT*FROM tbl_subject_view;
SELECT*FROM TBL_OPEN_SUBJECT;
--3. 수정




--(전체)교사 개인정보 수정
--관리자는 담당 교사가 아니어도 정보를 수정할 수 있다 -> 담당매니저가 없는 교사도 있기 때문
CREATE OR REPLACE PROCEDURE proc_edit_teacher(
	pname VARCHAR2,
	pphone_number VARCHAR2,
	PPASSWORD VARCHAR2,
	PT_ID VARCHAR2
)
IS

BEGIN
		UPDATE TBL_TEACHER SET NAME = PNAME, PHONE_NUMBER = pphone_number, PASSWORD = PPASSWORD
		WHERE T_ID = PT_ID;
END;


-- 교사 개인정보 수정 기존정보 담을 프로시저
	CREATE OR REPLACE PROCEDURE proc_edit_teacher_original(
	PT_ID VARCHAR2,
	pcursor out SYS_REFCURSOR

)
IS
BEGIN
	open pcursor for
	SELECT NAME, PHONE_NUMBER, PASSWORD FROM tbl_teacher WHERE T_ID=PT_ID;
END;




-- ****수정/삭제 가능한 교사인지 되돌려 주는 프로시저
CREATE OR REPLACE PROCEDURE PROC_AVA_CHANGE(
PT_ID VARCHAR2,
PRESULT OUT NUMBER
)
IS
	vcount NUMBER;
BEGIN

			SELECT COUNT(*) INTO VCOUNT FROM
			(select T_ID from TBL_TEACHER_VIEW
				MINUS
				SELECT T_ID from list_teacher_view)
		WHERE T_ID = PT_ID; --강의안하고 있는 교사들


		IF vcount = 1 THEN
			PRESULT := 1; -- 강의 안하는 교사들, 다음단계 가능
		ELSE
			PRESULT := 2; -- 강의중인 교사들 다시선택하세요
		END IF;

			EXCEPTION
      WHEN OTHERS THEN
            presult := 0; --똑바로 입력하세요
            ROLLBACK ;
	END;

	SELECT*FROM TBL_OPEN_SUBJECT;
SELECT*FROM TBL_AVA_SUBJECT WHERE T_ID = 'B5';

--(전체)교사 강의가능 과목 수정
--과정 강의예정, 강의중인 교사는 강의가능과목 수정 불가능!
CREATE OR REPLACE PROCEDURE proc_ava_subject_edit(

	PT_ID VARCHAR2,
	PSUB_SEQ NUMBER,
	PAVA_SUB_SEQ NUMBER,
	presult OUT NUMBER
)
IS
	vcount NUMBER;
	ACOUNT NUMBER;
	CCOUNT NUMBER;

BEGIN

	  SELECT COUNT(*) INTO ACOUNT FROM (SELECT* FROM TBL_AVA_SUBJECT WHERE T_ID = PT_ID)WHERE AVA_SUB_SEQ = PAVA_SUB_SEQ; --고유번호 제대로 선택했는지
		SELECT COUNT(*) INTO VCOUNT FROM (SELECT SUB_SEQ FROM TBL_AVA_SUBJECT WHERE T_ID=PT_ID) WHERE SUB_SEQ=PSUB_SEQ; --기존거랑 겹치지 않는지
		SELECT COUNT(*) INTO CCOUNT FROM tbl_subject_view WHERE SUB_SEQ = PSUB_SEQ;

	IF ACOUNT = 1 THEN
		IF CCOUNT = 1 THEN
			IF VCOUNT = 0 THEN
					UPDATE TBL_AVA_SUBJECT SET SUB_SEQ = PSUB_SEQ WHERE AVA_SUB_SEQ = PAVA_SUB_SEQ;
					presult :=1; --수정되었습니다.
			ELSE
					presult :=2; --이미 등록된 강의입니다.
			END IF;
		ELSE
			presult := 4;
		END IF;
	ELSE
		presult := 3; --번호를 제대로 입력하세요
	END IF;
END;

SELECT*FROM tbl_teacher_view;

--4. 삭제
--(전체) 교사 삭제
-- 강의중이거나 강의예정인 교사는 삭제 불가능, 먼저 다른 교사로 대체한 후에 삭제 가능
CREATE OR REPLACE PROCEDURE PROC_DEL_TEACHER(
PT_ID VARCHAR2
)
IS
BEGIN
			UPDATE TBL_TEACHER SET STATE = 0 WHERE T_ID = PT_ID;
END;
--(전체) 교사 강의가능과목 삭제
CREATE OR REPLACE PROCEDURE proc_DEL_AVA_SUB(
	pt_id VARCHAR2,
	PAVA_SUB_SEQ NUMBER,
	PRESULT OUT NUMBER
)
IS
VCOUNT NUMBER;
BEGIN

	SELECT COUNT(*) INTO VCOUNT FROM (SELECT* FROM TBL_AVA_SUBJECT WHERE T_ID = PT_ID)WHERE AVA_SUB_SEQ = PAVA_SUB_SEQ;

	IF VCOUNT = 1 THEN
		UPDATE TBL_AVA_SUBJECT SET STATE = 0 WHERE AVA_SUB_SEQ = PAVA_SUB_SEQ;
		PRESULT := 1;
	ELSE
		PRESULT := 2;
	END IF;

	EXCEPTION
	WHEN OTHERS THEN
	PRESULT :=0;

END;

	SELECT*FROM TBL_AVA_SUBJECT;
---------------------------------------------------<<개설과정 관리>>-----------------------------------------------------
select*from TBL_SUBJECT;
--삭제안된 과정 뷰 생성
CREATE VIEW TBL_OPEN_COURSE_VIEW
	AS
	SELECT O_COU_SEQ, START_DATE, END_DATE, CL_SEQ, COU_SEQ, M_ID, T_ID FROM TBL_OPEN_COURSE
	WHERE STATE = 1;

-- (완)기간 겹치지 않는 강의실 출력 프로시저
CREATE OR REPLACE PROCEDURE TBL_AVA_CLASS_ROOM(
		pstart_date VARCHAR2,
		pend_date VARCHAR2,
	  pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR

SELECT CL_SEQ, name, CAPACITY FROM TBL_CLASS_ROOM
	MINUS
SELECT DISTINCT a.CL_SEQ, d.name, d.capacity FROM TBL_OPEN_COURSE_VIEW a
inner join tbl_class_room_view d
on a.cl_seq = d.CL_SEQ
		WHERE (a.START_DATE <= TO_DATE(pstart_date, 'YYYY-MM-DD') AND TO_DATE(pstart_date, 'YYYY-MM-DD')<= a.END_DATE) -- 겹치는 기간 A.시작날짜가 기존기간안에 있는 경우
					OR (a.START_DATE <= TO_DATE(pend_date, 'YYYY-MM-DD') AND TO_DATE(pend_date, 'YYYY-MM-DD')<= a.END_DATE); -- 겹치는 기간 A.끝날짜가 기존기간안에 있는 경우
END;
	--완 기간겹치지 않는 강의실에서 골랐는지 확인하는 프로시저
CREATE OR REPLACE PROCEDURE TBL_AVA_CLASS_ROOM_CHECK(
		PCL_SEQ NUMBER,
		pstart_date VARCHAR2,
		pend_date VARCHAR2,
	  presult out number
)
IS
		vnumber number;
BEGIN
		SELECT COUNT(*) into vnumber FROM
	(
	SELECT CL_SEQ
	FROM TBL_CLASS_ROOM
	MINUS
	SELECT DISTINCT CL_SEQ
	FROM TBL_OPEN_COURSE_VIEW
	WHERE (START_DATE <= TO_DATE(pstart_date, 'YYYY-MM-DD') AND TO_DATE(pstart_date, 'YYYY-MM-DD') <= END_DATE)
				-- 겹치는 기간 A.시작날짜가 기존기간안에 있는 경우
				OR (START_DATE <= TO_DATE(pend_date, 'YYYY-MM-DD') AND
						TO_DATE(pend_date, 'YYYY-MM-DD') <= END_DATE) -- 겹치는 기간 A.끝날짜가 기존기간안에 있는 경우
	)WHERE CL_SEQ = PCL_SEQ;
		if vnumber = 1 then
			presult := 1;
		else
			presult:=2;
 		end if;

	EXCEPTION
      WHEN OTHERS THEN
            presult := 0; --똑바로 숫자로 입력하세요
            ROLLBACK ;

END;





-- 기간 겹치지 않는 선생님 출력 프로시저
CREATE OR REPLACE PROCEDURE PROC_TBL_AVA_TEACHER (
pstart_date VARCHAR2,
		pend_date VARCHAR2,
	  pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
SELECT T_ID, name  FROM TBL_TEACHER
	MINUS
SELECT DISTINCT t.T_ID, t.name FROM TBL_OPEN_COURSE_VIEW o
	INNER JOIN tbl_teacher_view t
	on o.T_ID = t.T_ID
		WHERE (o.START_DATE <= TO_DATE(pstart_date, 'YYYY-MM-DD') AND TO_DATE(pstart_date, 'YYYY-MM-DD')<= o.END_DATE) -- 겹치는 기간 A.시작날짜가 기존기간안에 있는 경우
					OR (o.START_DATE <= TO_DATE(pend_date, 'YYYY-MM-DD') AND TO_DATE(pend_date, 'YYYY-MM-DD')<= o.END_DATE); -- 겹치는 기간 A.끝날짜가 기존기간안에 있는 경우
END;
--선생님 제대로 골랐는지 확인
CREATE OR REPLACE PROCEDURE AVA_TEACHER_CHECK(
PT_ID VARCHAR2,
pstart_date VARCHAR2,
pend_date VARCHAR2,
PRESULT out NUMBER
)
IS
VCOUNT NUMBER;
BEGIN

		SELECT COUNT(*) INTO VCOUNT FROM
			(
SELECT T_ID, name  FROM TBL_TEACHER
	MINUS
SELECT DISTINCT t.T_ID, t.name FROM TBL_OPEN_COURSE_VIEW o
	INNER JOIN tbl_teacher_view t
	on o.T_ID = t.T_ID
		WHERE (o.START_DATE <= TO_DATE(pstart_date, 'YYYY-MM-DD') AND TO_DATE(pstart_date, 'YYYY-MM-DD')<= o.END_DATE) -- 겹치는 기간 A.시작날짜가 기존기간안에 있는 경우
					OR (o.START_DATE <= TO_DATE(pend_date, 'YYYY-MM-DD') AND TO_DATE(pend_date, 'YYYY-MM-DD')<= o.END_DATE)
			)
		WHERE T_ID = PT_ID;



	IF VCOUNT = 1 THEN
		PRESULT := 1;
	ELSE
		PRESULT :=2;

END IF;

	EXCEPTION
	WHEN OTHERS THEN
	PRESULT := 0;


	END;



--1. 입력



--개설과정 입력
CREATE OR REPLACE PROCEDURE proc_add_open_course(
	pstart_date VARCHAR2,
	pend_date VARCHAR2,
	pcl_seq NUMBER,
	pcou_seq NUMBER,
	PM_ID VARCHAR2,
	PT_ID VARCHAR2

)
IS

BEGIN

		INSERT INTO TBL_OPEN_COURSE (O_COU_SEQ, START_DATE, END_DATE, CL_SEQ, COU_SEQ, M_ID, T_ID)
  	VALUES (O_COU_SEQ.nextval, TO_DATE(pstart_date, 'YYYY-MM-DD HH24:MI:SS'),
						 TO_DATE(pend_date, 'YYYY-MM-DD HH24:MI:SS'), pcl_seq, pcou_seq, PM_ID, PT_ID);

END;

	--기초과정 목록안에서 선택했는지 확인
CREATE OR REPLACE PROCEDURE PROC_COURSE_CHOICE_CHECK(
	PCOU_SEQ NUMBER,
	PRESULT OUT NUMBER
	)
IS
		VCOUNT NUMBER;
BEGIN
	SELECT count(*) INTO Vcount FROM TBL_COURSE_VIEW
		WHERE COU_SEQ = pcou_seq;

	IF VCOUNT = 1 THEN
		PRESULT := 1;
	ELSE
		PRESULT := 2;
	END IF;

	EXCEPTION
		WHEN OTHERS THEN
		PRESULT := 0;

END;



select* from TBL_OPEN_COURSE;

--2. 출력

-- 완(전체)개설과정 출력
CREATE OR REPLACE PROCEDURE PROC_list_open_course(
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR

		SELECT oc.O_COU_SEQ as O_COU_SEQ, c.name as name, to_char(oc.start_date, 'yyyy-mm-dd') as start_date, to_char(oc.end_date, 'yyyy-mm-dd') as end_date
						, cr.name as 강의실, COUNT(S.O_COU_SEQ)||'명' AS 강의인원
		FROM TBL_OPEN_COURSE_VIEW oc
			INNER JOIN tbl_course c
				ON oc.COU_SEQ = c.COU_SEQ
			INNER JOIN TBL_CLASS_ROOM cr
				ON oc.CL_SEQ = cr.cl_seq
			LEFT OUTER JOIN TBL_COURSE_STUDENT S
				ON oc.O_COU_SEQ = S.O_COU_SEQ
 		GROUP BY oc.O_COU_SEQ, C.NAME, oc.start_date, oc.end_date, CR.NAME, S.O_COU_SEQ
 		ORDER BY oc.START_DATE DESC;


END;

commit;


CREATE OR REPLACE PROCEDURE PROC_list_open_course2(
	po_cou_seq NUMBER,
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
	SELECT oc.O_COU_SEQ, c.name as 과정명, to_char(oc.start_date, 'yyyy-mm-dd') as start_date, to_char(oc.end_date, 'yyyy-mm-dd') as end_date
					, cr.name as 강의실, COUNT(S.O_COU_SEQ)||'명' as 수강인원, T.NAME
	FROM TBL_OPEN_COURSE_VIEW oc
		INNER JOIN tbl_course c
			ON oc.COU_SEQ = c.COU_SEQ
		INNER JOIN TBL_CLASS_ROOM cr
			ON oc.CL_SEQ = cr.cl_seq
                INNER JOIN TBL_TEACHER T
                        ON OC.T_ID = T.T_ID
		LEFT OUTER JOIN TBL_COURSE_STUDENT S
			ON oc.O_COU_SEQ = S.O_COU_SEQ

  WHERE OC.O_COU_SEQ = PO_COU_SEQ
  GROUP BY oc.O_COU_SEQ, C.NAME, oc.start_date, oc.end_date, CR.NAME, S.O_COU_SEQ, T.NAME
  ORDER BY oc.START_DATE DESC;
END;

SELECT*FROM TBL_OPEN_COURSE;

update tbl_open_course set name = 'JAVA를 활용한 웹개발자 양성과정' where o_cou_seq = 6;
SELECT * FROM TBL_OPEN_COURSE;
-- (담당)개설과정 출력
CREATE OR REPLACE PROCEDURE PROC_list_open_course_my(
	PM_ID VARCHAR2,
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
	SELECT oc.O_COU_SEQ, c.name as 과정명, to_char(oc.start_date, 'yyyy-mm-dd') as start_date, to_char(oc.end_date, 'yyyy-mm-dd') as end_date
					, cr.name as 강의실, COUNT(S.O_COU_SEQ)||'명' as 수강인원
	FROM TBL_OPEN_COURSE_VIEW oc
		INNER JOIN tbl_course c
			ON oc.COU_SEQ = c.COU_SEQ
		INNER JOIN TBL_CLASS_ROOM cr
			ON oc.CL_SEQ = cr.cl_seq
		LEFT OUTER JOIN TBL_COURSE_STUDENT S
			ON oc.O_COU_SEQ = S.O_COU_SEQ

  WHERE OC.M_ID = PM_ID
  GROUP BY oc.O_COU_SEQ, C.NAME, oc.start_date, oc.end_date, CR.NAME, S.O_COU_SEQ
  ORDER BY oc.START_DATE DESC;
END;

-- 완(전체) 과정과목 출력
CREATE OR REPLACE PROCEDURE PROC_list_course_open_subject(
	po_cou_seq NUMBER,
	pcursor OUT SYS_REFCURSOR

)
IS
BEGIN
					OPEN pcursor FOR

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

								WHERE oc.O_COU_SEQ = po_cou_seq
								ORDER BY 과목끝일자 DESC;
END;


-- (담당)과정과목 출력
CREATE OR REPLACE PROCEDURE PROC_list_open_subject_my(
	po_cou_seq VARCHAR2,
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
					OPEN pcursor FOR
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

								WHERE oc.O_COU_SEQ = po_cou_seq
								ORDER BY 과목끝일자 DESC;
END;


-- (전체)특정 과정학생 출력
CREATE OR REPLACE PROCEDURE PROC_list_course_student(
	po_cou_seq VARCHAR2,
	pcursor OUT SYS_REFCURSOR
)
IS
BEGIN
	OPEN pcursor FOR
	SELECT TS.NAME AS 이름 , TS.SSN AS 주민번호뒷자리, TS.PHONE_NUMBER AS 전화번호,
		CASE
		 WHEN DO.ST_COU_SEQ IS NULL AND C.END_DATE > SYSDATE AND C.START_DATE <SYSDATE THEN '수강중'
		 WHEN DO.ST_COU_SEQ IS NULL AND C.END_DATE < SYSDATE THEN '수료'
		 WHEN DO.ST_COU_SEQ IS NULL AND C.START_DATE > SYSDATE THEN '수강전'
		 WHEN DO.ST_COU_SEQ IS NOT NULL THEN '중퇴'
		END as 수강현황

	FROM TBL_OPEN_COURSE_VIEW C
		INNER JOIN TBL_COURSE_STUDENT CS
			ON C.O_COU_SEQ = CS.O_COU_SEQ
		INNER JOIN TBL_STUDENT TS
			ON CS.S_ID = TS.S_ID
		LEFT OUTER JOIN TBL_DROP_OUT DO
			ON CS.ST_COU_SEQ = DO.ST_COU_SEQ
	WHERE CS.O_COU_SEQ = po_cou_seq;
END;
-- (담당)특정과정 학생 출력
CREATE OR REPLACE PROCEDURE PROC_list_course_student_my(
	po_cou_seq VARCHAR2,
	PM_ID VARCHAR2,
	pcursor OUT SYS_REFCURSOR
)
IS
	VCOUNT NUMBER;
	PRESULT NUMBER;
BEGIN

	SELECT COUNT(*) INTO VCOUNT FROM (SELECT*FROM TBL_OPEN_COURSE_VIEW WHERE M_ID = PM_ID) WHERE O_COU_SEQ = po_cou_seq;


	IF VCOUNT = 1 THEN
			OPEN pcursor FOR
			SELECT TS.NAME AS 이름 , TS.SSN AS 주민번호뒷자리, TS.PHONE_NUMBER AS 전화번호,
				CASE
				 WHEN DO.ST_COU_SEQ IS NULL AND C.END_DATE > SYSDATE AND C.START_DATE <SYSDATE THEN '수강중'
				 WHEN DO.ST_COU_SEQ IS NULL AND C.END_DATE < SYSDATE THEN '수료'
				 WHEN DO.ST_COU_SEQ IS NULL AND C.START_DATE > SYSDATE THEN '수강전'
				 WHEN DO.ST_COU_SEQ IS NOT NULL THEN '중퇴'
				END as 수강현황

			FROM TBL_OPEN_COURSE_VIEW C
				INNER JOIN TBL_COURSE_STUDENT CS
					ON C.O_COU_SEQ = CS.O_COU_SEQ
				INNER JOIN TBL_STUDENT TS
					ON CS.S_ID = TS.S_ID
				LEFT OUTER JOIN TBL_DROP_OUT DO
					ON CS.ST_COU_SEQ = DO.ST_COU_SEQ
			WHERE CS.O_COU_SEQ = po_cou_seq;
	END IF;
END;



--수정이나 변경을 원하는 강좌하나를 보여주는 프로시저
CREATE OR REPLACE PROCEDURE PROC_O_COURE_FOR_OPER(
	PM_ID VARCHAR2,
	pcursor OUT SYS_REFCURSOR,
	PO_COU_SEQ VARCHAR2
)
IS
BEGIN
	OPEN pcursor FOR
	SELECT oc.O_COU_SEQ, c.name as 과정명, oc.start_date as 시작일자, oc.end_date as 종료일자
					, cr.name as 강의실, COUNT(S.O_COU_SEQ)||'명' as 수강인원
	FROM TBL_OPEN_COURSE_VIEW oc
		INNER JOIN tbl_course c
			ON oc.COU_SEQ = c.COU_SEQ
		INNER JOIN TBL_CLASS_ROOM cr
			ON oc.CL_SEQ = cr.cl_seq
		INNER JOIN TBL_COURSE_STUDENT S
			ON oc.O_COU_SEQ = S.O_COU_SEQ

  WHERE OC.M_ID = PM_ID AND OC.O_COU_SEQ = PO_COU_SEQ
  GROUP BY oc.O_COU_SEQ, C.NAME, oc.start_date, oc.end_date, CR.NAME, S.O_COU_SEQ
  ORDER BY oc.START_DATE DESC;
END;

--3. 개설과정 수정
-- 기간변경을 원하는 경우 과정을 삭제하고 다시 등록해야 한다. (강의실이나 선생님 겹치는 문제때문에)
-- 그러므로 1. 강의실, 2. 과정명, 3. 선생님만 다시 바꿀수 있다.
-- 강의실과 선생님은 중복되지 않아야 한다.
-- 과정명은 중복되어도 된다.

--(특정)과정번호 범위안에서 제대로 골랐는지 확인하는 프로시저
CREATE OR REPLACE PROCEDURE PROC_CHOICE_MY(
	PM_ID VARCHAR2,
	po_cou_seq NUMBER,
	presult OUT NUMBER
)
IS
	vcount NUMBER;
BEGIN
	SELECT count(*) INTO vcount FROM (SELECT*FROM TBL_OPEN_COURSE_VIEW WHERE M_ID = PM_ID)
		WHERE O_COU_SEQ = po_cou_seq; --삭제하고자 하는 과정이 존재해야 한다.
	IF VCOUNT = 1 THEN
		presult := 1; --잘 골랐음
	ELSE
		presult := 2; --목록 안에서 다시 고르셈
	END IF;
END;

--(담당)과정번호 범위안에서 제대로 골랐는지 확인하는 프로시저
CREATE OR REPLACE PROCEDURE PROC_CHECK_OPEN_COURSE_CHOICE(
	po_cou_seq NUMBER,
	presult OUT NUMBER
)
IS
	vcount NUMBER;
BEGIN
	SELECT count(*) INTO vcount FROM (SELECT*FROM TBL_OPEN_COURSE_VIEW)
		WHERE O_COU_SEQ = po_cou_seq; --선택한 과정이 존재해야 한다.

	IF VCOUNT = 1 THEN
		presult := 1; --잘 골랐음
	ELSE
		presult := 2; --목록 안에서 다시 고르셈
	END IF;

	EXCEPTION
      WHEN OTHERS THEN
            presult := 0; --똑바로 숫자로 입력하세요
            ROLLBACK ;
END;

select*from TBL_OPEN_COURSE_VIEW;
--강의실 수정 프로시저
CREATE OR REPLACE PROCEDURE PROC_OPEN_COURSE_CL_CHANGE(
	po_cou_seq NUMBER,
	PCL_SEQ NUMBER
)
IS
BEGIN
		UPDATE TBL_OPEN_COURSE SET CL_SEQ = PCL_SEQ
  	WHERE o_COU_SEQ = po_cou_seq;
END;


--과정 건네주면 날짜 돌려주는 프로시저
	CREATE OR REPLACE PROCEDURE PROC_RETURN_PERIOD(
pO_COU_SEQ NUMBER,
PCURSOR OUT SYS_REFCURSOR
)
	IS
	BEGIN
		OPEN PCURSOR FOR
		SELECT START_DATE, END_DATE FROM TBL_OPEN_COURSE_VIEW WHERE o_COU_SEQ =pO_COU_SEQ;
	END;


--현재 사용가능한 강의실 보여주는 프로시저
CREATE OR REPLACE PROCEDURE PROC_NOW_AVA_CL_ROOM(
	PSTART_DATE VARCHAR2,
	PEND_DATE VARCHAR2,
	PCURSOR OUT SYS_REFCURSOR
)
IS

BEGIN
	OPEN pcursor FOR

SELECT CL_SEQ FROM TBL_CLASS_ROOM
	MINUS
SELECT DISTINCT CL_SEQ FROM TBL_OPEN_COURSE_VIEW
		WHERE START_DATE <= (TO_DATE('2018-06-01 00:00:00', 'YYYY-MM-DD hh24:mm:ss'))




					 AND TO_DATE('2018-01-01 00:00:00', 'YYYY-MM-DD hh24:mm:ss')<= END_DATE) -- 겹치는 기간 A.시작날짜가 기존기간안에 있는 경우
					OR (START_DATE <= TO_DATE('2019-01-01 00:00:00', 'YYYY-MM-DD hh24:mm:ss') AND TO_DATE('2019-01-01 00:00:00', 'YYYY-MM-DD hh24:mm:ss')<= END_DATE); -- 겹치는 기간 A.끝날짜가 기존기간안에 있는 경우
END;




--++++++++++이것만 하면 끝 !
----------------------------------------------------------------미완성 작업분
-- 선생님 수정 프로시저
-- **같은과목 강의 가능한 선생님 뷰 만들기
-- 같은과목 가르칠 수 있는 선생님 못만들 경우 폐강해야함
CREATE OR REPLACE PROCEDURE PROC_TEACHER_CHANGE(

	po_cou_seq NUMBER,
	PT_ID VARCHAR2
--	presult OUT NUMBER,
--	psentence varchar2
)
IS

BEGIN
	SELECT * FROM TBL_AVA_SUBJECT a
		INNER JOIN tbl_teacher_view b
		on a.T_ID = b.T_ID;

--	where psentence; --삭제하고자 하는 과정이 존재해야 한다.

commit;
--	IF vcount = 1 THEN
		UPDATE TBL_OPEN_COURSE SET T_ID = PT_ID
  	WHERE o_COU_SEQ = po_cou_seq;
--		presult := 1; -- 선생님 수정 성공했습니다.
--	ELSE
--		presult := 2; -- 목록에 있는 선생님으로만 수정가능합니다.
--	END IF;
END;
SELECT * FROM TBL_AVA_SUBJECT;
--강좌명 수정 프로시저
CREATE OR REPLACE PROCEDURE PROC_OPEN_COURSE_CLASS_ROOM_CHANGE(
	po_cou_seq NUMBER,
	PCOU_SEQ NUMBER,
	presult OUT NUMBER
)
IS
	vcount NUMBER;
BEGIN
	SELECT COUNT(*) INTO VCOUNT FROM tbl_course_view WHERE COU_SEQ=PCOU_SEQ;

	IF vcount = 1 THEN
		UPDATE TBL_OPEN_COURSE SET COU_SEQ = PCOU_SEQ
  	WHERE o_COU_SEQ = po_cou_seq;
		presult := 1; -- 삭제 성공했습니다.
	ELSE
		presult := 2; -- 목록에 있는 과정명을 입력해주세요.
	END IF;
END;

SELECT COUNT(*) FROM TBL_AVA_SUBJECT WHERE T_ID = 'B1';
SELECT SUB_SEQ FROM TBL_AVA_SUBJECT WHERE T_ID ='B1';
SELECT COUNT(*), T_ID FROM TBL_AVA_SUBJECT_ WHERE

	SUB_SEQ = 1 OR SUB_SEQ = 2 OR SUB_SEQ = 3 GROUP BY T_ID;

SELECT*FROM TBL_OPEN_COURSE_view;

--4. 삭제 --매니저만 삭제 가능
CREATE OR REPLACE PROCEDURE proc_del_open_course(
	PM_ID VARCHAR2,
	po_cou_seq NUMBER,
	presult OUT NUMBER
)
IS
	vcount NUMBER;
BEGIN
	SELECT count(*) INTO vcount FROM (SELECT*FROM TBL_OPEN_COURSE_VIEW WHERE M_ID = PM_ID)
		WHERE O_COU_SEQ = po_cou_seq; --삭제하고자 하는 과정이 존재해야 한다.

	IF vcount = 1 THEN
		UPDATE TBL_OPEN_COURSE SET STATE = 0
  	WHERE o_COU_SEQ = po_cou_seq;
		presult := 1; -- 삭제 성공했습니다.
	ELSE
		presult := 2; -- 본인 담당 과정만 수정가능합니다.
	END IF;
END;
