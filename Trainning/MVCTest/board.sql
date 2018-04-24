--MVCTest>board.sql


--2. 게시판 테이블 (원글)
create table tblMember(
  id varchar2(30) PRIMARY key,
  pw varchar2(30),
  name varchar2(30),
  lv number

);


insert into tblMember values('hong', '1111', '홍길동', 1);
insert into tblMember values('test', '1111', '테스트', 1);
insert into tblMember values('cat', '1111', '고양이', 2);
insert into tblMember values('dog', '1111', '강아지', 2);
insert into tblMember values('admin', '1111', '홍길동', 3);


drop table tblMember;

drop TABLE tblBoard;

create table tblBoard (
  seq number primary key, --글번호 (PK)
  subject VARCHAR2(500) NOT NULL, --글 제목
  content VARCHAR2(2000) NOT NULL, --글 내용
  id VARCHAR2(30) NOT NULL REFERENCES TBLMEMBER(id), --글쓴 사람
  regdate DATE DEFAULT sysdate NOT NULL , --글쓴 시각
  readcount number DEFAULT 0 NOT NULL, --조회수
  tag VARCHAR2(1) NOT NULL CHECK (tag IN('y', 'n'))-- 글내용에 태그 허용(y,n)
);


create SEQUENCE board_seq;


insert into tblboard (seq, subject, content, id, regdate, readcount, tag) VALUES (board_seq.nextval, '게시판 첫글입니다.', '내용입니다', 'hong', default, default, 'y');

SELECT * from tblBoard;

commit;

SELECT * from TBLMEMBER;

SELECT *
FROM tblBoard;

select seq, subject, id, (select name from tblMember where id = b.id) as name, regdate, readcount from tblBoard b order by seq desc;

select seq, subject, id, (select name from tblMember where id = b.id) as name, regdate, readcount, round((sysdate-regdate)*24*60) as gap from tblBoard b order by seq desc;


delete from tblBoard where seq= 26;

commit;


select seq, subject, id, (select name from tblMember where id = b.id) as name, regdate, readcount, round((sysdate-regdate)*24*60) as gap from tblBoard b  where  name like '%홍길동%' order by seq desc;

SELECT * from (select seq, subject, id, (select name from tblMember where id = b.id) as name, regdate, readcount, round((sysdate-regdate)*24*60) as gap from tblBoard b) where name like '%홍길동%' order by seq desc;



SELECT * from (SELECT a.*, rownum as rnum from (select seq, subject, id, (select name from tblMember where id = b.id) as name, regdate, readcount, round((sysdate-regdate)*24*60) as gap, content from tblBoard b order by seq desc) a )
WHERE rnum >=1 and rnum <= 10
  ORDER BY seq desc;



rownum
1. 정렬
2. 그걸로 rownum 얻어내기

SELECT * from TBLMEMBER;



--댓글 테이블
create table tblComment (
  seq number PRIMARY KEY, -- 댓글번호(PK)
  id VARCHAR2(30) NOT NULL REFERENCES TBLMEMBER(id), -- 글쓴이
  content VARCHAR2(1000) NOT NULL, --댓글내용
  regdate date DEFAULT sysdate NOT NULL, --글쓴시각
  pseq NUMBER NOT NULL REFERENCES tblBoard(seq) --부모글(FK)
);

CREATE SEQUENCE comment_seq;

SELECT * from tblComment;


SELECT c.*, (SELECT name from TBLMEMBER where id=c.id)as name from tblComment c where pseq=542 ORDER BY seq asc;

select seq, subject, id, (select name from tblMember where id=b.id) as name, regdate, readcount, round((sysdate-regdate)*24*60) as gap, content, (select count(*) from tblComment where pseq = b.seq) as ccount from tblBoard b;


