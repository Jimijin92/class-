create sequence T_ID_SEQ
/

create sequence M_ID_SEQ
/

create sequence PUBLISHER_SEQ
/

create sequence SUB_SEQ
/

create sequence CL_SEQ
/

create sequence COU_SEQ
/

create sequence GO_SEQ
/

create sequence GO_SICK
/

create sequence ABSENCE_SEQ
/

create sequence ABSENCE_S_SEQ
/

create sequence GO_HOME
/

create sequence GO_HOME_SICK_SEQ
/

create sequence BOOK_SEQ
/

create sequence O_COU_SEQ
/

create sequence AVA_SUB_SEQ
/

create sequence S_ID_SEQ
/

create sequence DROP_SEQ
/

create sequence ST_COU_SEQ
/

create sequence O_SUB_SEQ
/

create sequence SCO_SEQ
/

create sequence ATTENDANCE_SEQ
/

create sequence AD_SEQ
/

create table TBL_STUDENT
(
	S_ID VARCHAR2(10) not null
		primary key,
	NAME VARCHAR2(30) not null,
	BIRTH_SSN NUMBER not null,
	SSN NUMBER not null,
	PHONE_NUMBER VARCHAR2(20) not null,
	PASSWORD VARCHAR2(50) default NULL --비밀번호,주민번호 뒷자리를 패스워드 기본값으로!

)
/

create table TBL_TEACHER
(
	T_ID VARCHAR2(3) not null
		primary key,
	NAME VARCHAR2(30) not null,
	SSN VARCHAR2(20) not null,
	PHONE_NUMBER VARCHAR2(20) not null,
	PASSWORD VARCHAR2(50)
)
/

create table TBL_PUBLISHER
(
	PUB_SEQ NUMBER not null
		primary key,
	NAME VARCHAR2(50) not null
)
/

create table TBL_BOOK
(
	BOOK_SEQ NUMBER not null
		primary key,
	NAME VARCHAR2(100),
	BOOK_STOCK NUMBER(4),
	PUB_SEQ NUMBER not null
		references TBL_PUBLISHER
)
/

create table TBL_SUBJECT
(
	SUB_SEQ NUMBER not null
		primary key,
	NAME VARCHAR2(50) not null
)
/

create table TBL_AVA_SUBJECT
(
	AVA_SUB_SEQ NUMBER not null
		primary key,
	T_ID VARCHAR2(3) not null
		references TBL_TEACHER,
	SUB_SEQ NUMBER not null
		references TBL_SUBJECT
)
/

create table TBL_CLASS_ROOM
(
	CL_SEQ NUMBER(2) not null
		primary key,
	NAME VARCHAR2(50),
	CAPACITY NUMBER(3) not null
)
/

create table TBL_COURSE
(
	COU_SEQ NUMBER not null
		primary key,
	NAME VARCHAR2(1000) not null
)
/

create table TBL_MANAGER
(
	M_ID VARCHAR2(2) not null
		primary key,
	PASSWORD VARCHAR2(50),
	SSN NUMBER not null,
	NAME VARCHAR2(30) not null
)
/

create table TBL_OPEN_COURSE
(
	O_COU_SEQ NUMBER not null
		primary key,
	START_DATE DATE not null,
	END_DATE DATE not null,
	CL_SEQ NUMBER not null
		references TBL_CLASS_ROOM,
	COU_SEQ NUMBER not null
		references TBL_COURSE,
	M_ID VARCHAR2(2) not null
		references TBL_MANAGER,
	T_ID VARCHAR2(3) not null
		references TBL_TEACHER
)
/

create table TBL_COURSE_STUDENT
(
	ST_COU_SEQ NUMBER not null
		primary key,
	S_ID VARCHAR2(10) not null
		references TBL_STUDENT,
	O_COU_SEQ NUMBER not null
		references TBL_OPEN_COURSE
)
/

create table TBL_DISTRIBUTION
(
	BOOK_SEQ NUMBER not null
		references TBL_BOOK,
	ST_COU_SEQ NUMBER not null
		references TBL_COURSE_STUDENT
)
/

create table TBL_ATTENDANCE
(
	ATT_SEQ NUMBER not null
		primary key,
	ST_COU_SEQ NUMBER not null
		references TBL_COURSE_STUDENT,
	STATE_SEQ NUMBER not null,
	S_DATE DATE not null
)
/

create table TBL_GO
(
	GO_SEQ NUMBER not null
		primary key,
	ATT_SEQ NUMBER not null
		references TBL_ATTENDANCE,
	REASON VARCHAR2(1000)
)
/

create table TBL_GO_SICK
(
	GO_SICK_SEQ NUMBER not null
		primary key,
	GO_SEQ NUMBER not null
		references TBL_GO
)
/

create table TBL_ABSENCE
(
	ABSENCE_SEQ NUMBER not null
		primary key,
	ATT_SEQ NUMBER not null
		references TBL_ATTENDANCE
)
/

create table TBL_ABSENCE_SICK
(
	ABSENCE_S_SEQ NUMBER not null
		primary key,
	ABSENCE_SEQ NUMBER not null
		references TBL_ABSENCE
)
/

create table TBL_GO_HOME
(
	GO_HOME_SEQ NUMBER not null
		primary key,
	ATT_SEQ NUMBER not null
		references TBL_ATTENDANCE,
	REASON VARCHAR2(1000)
)
/

create table TBL_GO_HOME_SICK
(
	GO_HOME_S_SEQ NUMBER not null
		primary key,
	GO_HOME_SEQ NUMBER not null
		references TBL_GO_HOME
)
/

create table TBL_ADVICE
(
	AD_SEQ NUMBER not null
		primary key,
	CONTENT VARCHAR2(1000) not null,
	AD_DATE DATE,
	M_ID VARCHAR2(2) not null
		references TBL_MANAGER,
	ST_COU_SEQ NUMBER not null
		references TBL_COURSE_STUDENT
)
/

create table TBL_OPEN_SUBJECT
(
	O_SUB_SEQ NUMBER not null
		primary key,
	START_DATE DATE not null,
	END_DATE DATE not null,
	W_RATIO NUMBER(3) default 40 not null,
	P_RATIO NUMBER(3) default 40 not null,
	AT_RATIO NUMBER(3) default 20 not null,
	W_TEST DATE,
	P_TEST DATE,
	SUB_SEQ NUMBER not null
		references TBL_SUBJECT,
	BOOK_SEQ NUMBER not null
		references TBL_BOOK,
	O_COU_SEQ NUMBER not null
		references TBL_OPEN_COURSE
)
/

create table TBL_SCORE
(
	SCO_SEQ NUMBER not null
		primary key,
	ORG_W_SCORE NUMBER,
	ORG_P_SCORE NUMBER,
	ORG_A_SCORE NUMBER,
	F_W_SCORE NUMBER,
	F_P_SCORE NUMBER,
	F_A_SCORE NUMBER,
	O_SUB_SEQ NUMBER not null
		references TBL_OPEN_SUBJECT,
	ST_COU_SEQ NUMBER not null
		references TBL_COURSE_STUDENT
)
/

create table TBL_DROP_OUT
(
	DROP_SEQ NUMBER not null
		primary key,
	REASON VARCHAR2(1000) not null,
	DROP_DATE DATE not null,
	ST_COU_SEQ NUMBER not null
		references TBL_COURSE_STUDENT
)
/

create table TBL_FINAL_ATT
(
	F_ATT_SEQ NUMBER not null
		primary key
)
/

create table TBL_STATE
(
	STATE_SEQ NUMBER not null
		primary key,
	STATE VARCHAR2(10)
		check (state IN('출근','조퇴','외출','퇴근'))
)
/

create table TBL_CASE
(
	STATE_SEQ NUMBER not null
		references TBL_STATE,
	F_ATT_SEQ NUMBER not null
		references TBL_FINAL_ATT
)
/

