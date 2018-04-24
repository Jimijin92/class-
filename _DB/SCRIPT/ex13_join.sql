/*

ex13_join.sql

-- ���� ���� + ������ ����ϴ� ������Ʈ ����
-- ���� ���̺�, ������Ʈ ���̺�

*/

CREATE TABLE tblstaff
(
      seq NUMBER PRIMARY KEY, --������ȣ(PK)
      name VARCHAR2(30) NOT NULL, --������
      salary NUMBER NOT NULL, --�޿�
      address VARCHAR2(1000) NOT NULL, --�ּ�
      projname VARCHAR2(100) NULL --��� ������Ʈ��
);

INSERT INTO tblstaff (seq, name, salary, address, projname)
      VALUES (1, 'ȫ�浿', 250, '�����', 'ȫ�� ����');

INSERT INTO tblstaff (seq, name, salary, address, projname)
      VALUES (2, '�ƹ���', 230, '�λ��', 'TV ����');

INSERT INTO tblstaff (seq, name, salary, address, projname)
      VALUES (3, '������', 210, '�����', '���� �м�');

SELECT * FROM tblstaff;

-- 1���� ������ �������� ������Ʈ�� ����� �� �ִ�.
INSERT INTO tblstaff (seq, name, salary, address, projname)
      VALUES (1, 'ȫ�浿', 250, '�����', 'ȫ�� ����');

DROP TABLE tblstaff;



CREATE TABLE tblstaff
(
      seq NUMBER PRIMARY KEY, --������ȣ(PK)
      name VARCHAR2(30) NOT NULL, --������
      salary NUMBER NOT NULL, --�޿�
      address VARCHAR2(1000) NOT NULL --�ּ�
      --project NUMBER NOT NULL --��� ������Ʈ
);

CREATE TABLE tblproject
(
      seq NUMBER PRIMARY KEY, --������Ʈ��ȣ(PK)
      name varchar2(200) NOT NULL, --������Ʈ��
      staff NUMBER NOT NULL --��� ���� ��ȣ
);


INSERT INTO tblstaff (seq, name, salary, address) VALUES (1, 'ȫ�浿', 200, '�����');
INSERT INTO tblstaff (seq, name, salary, address) VALUES (2, '�ƹ���', 250, '��õ��');
INSERT INTO tblstaff (seq, name, salary, address) VALUES (3, '������', 180, '�λ��');

INSERT INTO tblproject (seq, name, staff) VALUES (1, 'ȫ�� ����', 1);
INSERT INTO tblproject (seq, name, staff) VALUES (2, 'TV ����', 2);
INSERT INTO tblproject (seq, name, staff) VALUES (3, '���� �м�', 2);
INSERT INTO tblproject (seq, name, staff) VALUES (4, '�븮�� �о�', 1);
INSERT INTO tblproject (seq, name, staff) VALUES (5, '���� ����', 3);

-- tblstaff(�⺻ ���̺�, �θ� ���̺�) + tblproject(���� ���̺�, �ڽ� ���̺�) : �� ���̺��� ����(relationship)�� �ΰ� �ִ�.

-- ���踦 �ΰ� �ִ� 2���� ���̺��� �����͸� �����ϸ�.. ����� �ϵ�..
-- 1. �θ�  ���̺��� ����
-- 2. �ڽ� ���̺��� ����

--1. ���� ��� �Ի� -> �ű� ������Ʈ ����(���)

--1.a ���� ��� �߰� (O)
INSERT INTO tblstaff (seq, name, salary, address) VALUES (4, 'ȣȣȣ', 150, '�����');

--1.b �ű� ������Ʈ �߰� (O)
INSERT INTO tblproject (seq, name, staff) VALUES (6, '���� ����', 4);

--1.c �ű� ������Ʈ �߰� (X) - parent key not found
INSERT INTO tblproject (seq, name, staff) VALUES (7, '�� ���', 5);

--2. ȫ�浿 ���
--2.a ȫ�浿 ���� - child record found
DELETE FROM tblstaff WHERE name = 'ȫ�浿'; -- where seq = 1

--2.b ȫ�浿 ��� ����
--2.b.a ȫ�浿�� ��� ������Ʈ -> ����
UPDATE tblproject set staff = 3 WHERE staff = 1;

--2.b.b ȫ�浿 ����
DELETE FROM tblstaff WHERE name = 'ȫ�浿';


SELECT * FROM tblstaff;
SELECT * FROM tblproject;




-- �θ� ���̺� + �ڽ� ���̺� -> ���� ���� -> ���� ���� �߰�
-- �ܷ�Ű, Foreign Key
-- : ���� ������ ���̺��� ���� �� ������ �ϴ� �÷��� ���� �׻� ��ȿ�ϰ� ���������ִ� ����\
-- : �θ� ���̺��� PK�� �����ϴ� Ű + �θ� ���̺� �̹� �����ϴ� ���� ���� �� �ִ� �÷� ����
DROP TABLE tblstaff;
DROP TABLE tblproject;

CREATE TABLE tblstaff
(
      seq NUMBER PRIMARY KEY, --������ȣ(PK)
      name VARCHAR2(30) NOT NULL, --������
      salary NUMBER NOT NULL, --�޿�
      address VARCHAR2(1000) NOT NULL --�ּ�
);

CREATE TABLE tblproject
(
      seq NUMBER PRIMARY KEY, --������Ʈ��ȣ(PK)
      name varchar2(200) NOT NULL, --������Ʈ��
      staff NUMBER REFERENCES tblstaff(seq) NOT NULL --�������(FK)
);




-- �� - �Ǹ�
-- �� ���̺�
CREATE TABLE tblcustomer
(
      seq NUMBER PRIMARY KEY, --����ȣ(PK)
      name varchar2(30) not null, --����
      tel varchar2(15) not null, --����ó
      address varchar2(100) not null --�ּ�
);

-- �Ǹ� ���̺�
CREATE TABLE tblsales
(
      seq NUMBER PRIMARY KEY, --�ǸŹ�ȣ(PK)
      item VARCHAR2(50) NOT NULL, --��ǰ��
      qty NUMBER NOT NULL, --����
      regdate DATE DEFAULT sysdate NOT NULL, --�Ǹ� ��¥
      customer NUMBER REFERENCES tblcustomer(seq) --����ȣ(FK)
);

-- �θ� & �ڽ� ���̺�
-- 1. ���� ����
--    : �θ� ���� -> �ڽ� ����
-- 2. ���� ����
--    : �ڽ� ���� -> �θ� ����

DROP TABLE tblcustomer;
DROP TABLE tblsales;



-- ���� �뿩��

-- ȸ�� ���̺�
CREATE TABLE tblmember
(
      seq NUMBER PRIMARY KEY, --ȸ����ȣ(PK)
      name VARCHAR2(20) NOT NULL, --ȸ����
      grade number(1)
            CHECK (grade BETWEEN 1 AND  3) NOT NULL, --ȸ�����(1,2,3)
      byear number(4) NOT NULL, --����
      tel varchar2(15) NOT NULL , --����ó
      address VARCHAR2(300) NULL, --�ּ�
      money NUMBER NOT NULL --��ġ��
);

-- �帣 ���̺�
CREATE TABLE tblgenre
(
      seq NUMBER PRIMARY KEY, --�帣��ȣ(PK)
      name VARCHAR2(30) NOT NULL , --�帣��
      price NUMBER NOT NULL , --�뿩 ����
      period NUMBER NOT NULL --�뿩 �Ⱓ
);

-- ���� ���̺�
CREATE TABLE tblvideo
(
      seq NUMBER PRIMARY KEY , --���� ��ȣ(PK)
      name VARCHAR2(100) NOT NULL , --����
      qty NUMBER NOT NULL , --���� ����
      company VARCHAR2(50) NULL, --���ۻ�
      director varchar2(50) NULL, --����
      major VARCHAR2(50) NULL, --�ֿ����
      genre NUMBER REFERENCES tblgenre(seq) NOT NULL --�帣��ȣ(FK)
);

-- �뿩 ���̺�
CREATE TABLE tblrent
(
      seq NUMBER PRIMARY KEY , --�뿩��ȣ(PK)
      member NUMBER REFERENCES tblmember(seq) NOT NULL , --�뿩�� ȸ����ȣ(FK)
      video NUMBER REFERENCES tblvideo(seq)  NOT NULL ,  --�뿩�� ������ȣ(FK)
      rentdate DATE DEFAULT sysdate NOT NULL , --�뿩��¥
      retdate DATE NULL , --�ݳ���¥
      remart VARCHAR2(500) --���
);

--������ ��ü
CREATE SEQUENCE memberseq;
CREATE SEQUENCE genreseq;
CREATE SEQUENCE videoseq;
CREATE SEQUENCE rentseq;

-- �ٽ� �ʱ�ȭ
DROP TABLE tblrent;
DROP TABLE tblmember;
DROP TABLE tblvideo;
DROP TABLE tblgenre;

DROP SEQUENCE memberseq;
DROP SEQUENCE genreseq;
DROP SEQUENCE videoseq;
DROP SEQUENCE rentseq;


/*

����, Join
- 2�� �̻��� ���̺��� ������ 1���� ������� ����� �۾�
- ���踦 �ΰ� �ִ� ���̺����� ���ؼ�..

������ ����
1. �ܼ� ����, Cross Join
2. ���� ����, Inner Join
3. �ܺ� ����, Outer Join
4. ���� ����, Self Join

1. �ܼ� ����
*/
SELECT * FROM tblcustomer; --3��
SELECT * FROM tblsales; --9��

-- ����� : 27��
SELECT * FROM tblcustomer, tblsales; --����
SELECT * FROM tblcustomer CROSS JOIN tblsales; --����


/*
2. ���� ����
 : �ܼ� ���ο��� ��ȿ�� ���ڵ常 ���ϴ� ����
 : �θ� ���̺��� PK�� �ڽ� ���̺��� FK�� ������ ������ ���Ѵ�. -> ��ȿ�� ���ڵ�

SELECT �÷�����Ʈ FROM ���̺�A
     INNER JOIN ���̺�B
            ON ���̺�A.�÷�(PK) = ���̺�B.�÷�(FK)
*/
-- rs.getString("sseq")
SELECT --3
      s.seq as sseq,
      c.seq as cseq,
      --name,
      --item
      c.name,
      s.item
FROM tblcustomer c INNER JOIN tblsales s --1
                  ON c.seq = s.customer; --2


-- �� ���ϴ� �ൿ(���� ����� * ���� �������� �ʴ´�.)
SELECT * FROM tblcustomer c INNER JOIN tblsales s
                  ON c.seq = s.customer;


SELECT * FROM (SELECT c.name, c.address, s.item, s.qty FROM tblcustomer c INNER JOIN tblsales s
                  ON c.seq = s.customer);


-- ǥ�� SQL
SELECT * FROM tblcustomer c
      INNER JOIN tblsales s
                  ON c.seq = s.customer;

-- ����Ŭ ����
SELECT * FROM tblcustomer c, tblsales s
      WHERE c.seq = s.customer;


-- ���� ��� �� �ϸ� �ȵǴ� �ൿ
SELECT * FROM tblrent;
SELECT * FROM tblhousekeeping;

SELECT * FROM tblrent r
      INNER JOIN tblhousekeeping h
            ON r.member = h.qty;



SELECT * FROM tblcustomer; --3��
SELECT * FROM tblsales; --9��

-- '��Ʈ'��(tblsales) �簣 ȸ���� ����ó(tblcustomer)?

--1. ��������
SELECT name, tel FROM tblcustomer
      WHERE seq = (SELECT customer FROM tblsales WHERE item = '��Ʈ');

--2. ����
SELECT c.tel FROM tblcustomer c
      INNER JOIN tblsales s
            ON c.seq = s.customer
                  WHERE s.item = '��Ʈ';



-- '��Ʈ'��(tblsales) �簣 ȸ���� ����ó(tblcustomer)�� ����(tblsales)?
-- ������ ������� ���� ����� 2�� �̻��� ���̺��� ���;� �Ѵٸ� -> ���� ���

--1. ��������
SELECT name, tel, qty FROM tblcustomer
      WHERE seq = (SELECT customer FROM tblsales WHERE item = '��Ʈ');

SELECT name, tel, (SELECT qty FROM tblsales WHERE customer = c.seq AND item = '��Ʈ')
      FROM tblcustomer c
            WHERE seq = (SELECT customer FROM tblsales WHERE item = '��Ʈ');

--2. ����
SELECT c.tel, s.qty FROM tblcustomer c
      INNER JOIN tblsales s
            ON c.seq = s.customer
                  WHERE s.item = '��Ʈ';

/*
1. �ܼ� ����
2. ���� ����
3. �ܺ� ����
- ���� ���� + a
*/
SELECT * FROM tblcustomer; -- 3��
SELECT * FROM tblsales; -- 9��

--*** �� 1�� �߰�
INSERT INTO tblcustomer VALUES (4, 'ȣȣȣ', '010-1234-1234', '�����');

-- ���� ����
-- ���θ����� 1ȸ �̻�(*******) �����̷��� �ִ� ���� ������ ���� �̷��� �������ÿ�.
SELECT * FROM tblcustomer c
      INNER JOIN tblsales s
            ON c.seq = s.customer; --����(c�� PK�� s�� FK)

-- ���θ����� ��� ���� ������ ��� + �����̷��� �ִ� ȸ���� �����̷µ� ���� ���
-- ������ �׻� �θ� ���̺��� ����Ų��. �ڽ� ���̺��� ����Ű�� INNER JOIN�� ����������.
SELECT * FROM tblcustomer c
      LEFT OUTER JOIN tblsales s
            ON c.seq = s.customer;

SELECT * FROM tblstaff; --3��
SELECT * FROM tblproject; --6��

INSERT INTO tblstaff VALUES (5, 'ȫ�浿', 200, '�����');
INSERT INTO tblstaff VALUES (6, '�׽�Ʈ', 220, '�����');

-- ����ȸ�� : ���� ��� + ������ �ִ� �����..
-- �츮 ���� ��� �����Ͷ� + ������Ʈ�� ����ϰ� �ִ� ������ ���ؼ�..
SELECT * FROM tblstaff s
      INNER JOIN tblproject p
            ON s.seq = p.staff;

-- ����ȸ�� : ���� ��� + ������ �ִ� ���� ��δ�..
-- �츮 ���� ��� �����Ͷ� + ������Ʈ ��� ������ �������..
-- ǥ�� SQL
SELECT * FROM tblstaff s
      LEFT OUTER JOIN tblproject p
            ON s.seq = p.staff;

-- ����Ŭ
SELECT * FROM tblstaff s, tblproject p
      WHERE s.seq = p.staff(+);


/*
4. ���� ����
- 1���� ���̺� ������ ����
- �� ���� -> �ڽ��� �ڽ��� �����ϴ� Ű�� ������
*/
--���� ���� ���̺�
CREATE TABLE tblself
(
      seq NUMBER PRIMARY KEY , --������ȣ(PK)
      name VARCHAR2(30) NOT NULL , --������
      department varchar2(30) NULL, --�μ�
      super NUMBER REFERENCES tblself(seq) NULL --���� ���(FK)
);

INSERT INTO tblself VALUES (1, 'ȫ����', NULL, NULL);
INSERT INTO tblself VALUES (2, '������', '�ѹ���', 1);
INSERT INTO tblself VALUES (3, '������', '�ѹ���', 2);
INSERT INTO tblself VALUES (4, '�ٴ븮', '�ѹ���', 3);
INSERT INTO tblself VALUES (5, '����', '�ѹ���', 4);
INSERT INTO tblself VALUES (6, '������', '������', 1);
INSERT INTO tblself VALUES (7, '�ٰ���', '������', 6);

SELECT * FROM tblself;

SELECT s2.name as ������, s1.name as ���� FROM tblself s1 --��� ���̺�
      RIGHT OUTER JOIN tblself s2 --���� ���̺�
            ON s1.seq = s2.super; -- s1(PK, �θ����̺�) = s2(FK, �ڽ����̺�)

-- employees : manager_id
SELECT e2.first_name as ������, e1.first_name as �Ŵ�����
      FROM employees e1 --�Ŵ���
            INNER JOIN employees e2 -- ����
                  ON e2.manager_id = e1.employee_id;

-- �Ŵ�����? �Ŵ������� ����ϰ� �ִ� ���� ��?
SELECT (SELECT first_name || ' ' || last_name FROM employees WHERE employee_id = e2.manager_id), count(*) FROM employees e2
      GROUP BY manager_id;



-- ���� ����
-- ���̺��� ���� �ø���

-- 1��
-- ������ ����?
SELECT * FROM tblvideo;


-- 2��
-- ��� ���� ����� �뿩 ����, �Ⱓ?
SELECT * FROM tblgenre g
      INNER JOIN tblvideo v
            ON g.seq = v.genre;


-- 3��
-- ��� ������ �뿩����,�Ⱓ + �뿩 ����?
SELECT * FROM tblgenre g
      INNER JOIN tblvideo v
            ON g.seq = v.genre
                  INNER JOIN tblrent r
                        ON r.video = v.seq;

-- 4��
-- ��� ������ �뿩����,�Ⱓ + �뿩 ���� + �뿩 ȸ���� ����?
SELECT * FROM tblgenre g
      INNER JOIN tblvideo v
            ON g.seq = v.genre
                  LEFT OUTER JOIN tblrent r
                        ON r.video = v.seq
                              RIGHT OUTER JOIN tblmember m
                                    ON m.seq = r.member;



-- �뿩��� ��� + ȸ���� + �������� + ���� + �ݳ� ����('�ݳ��Ϸ�' or '�̹ݳ�') - CASE��
CREATE VIEW ���
AS
SELECT
      m.name as ȸ����,
      v.name as ��������,
      to_char(r.rentdate, 'yyyy-mm-dd') as �뿩��¥,
      CASE
            WHEN r.retdate IS NOT NULL then '�ݳ� �Ϸ�'
            WHEN r.retdate IS NULL then '�̹ݳ�'
      END as �ݳ�����
FROM tblrent r
      INNER JOIN tblmember m
            ON m.seq = r.member
                  INNER JOIN tblvideo v
                        ON v.seq = r.video;

























/*
ex13_join.sql

-- ���� ���� + ������ ����ϴ� ������Ʈ ���� 
-- ���� ���̺�, ������Ʈ ���̺�

*/

CREATE TABLE tblstaff
(
    seq NUMBER PRIMARY KEY, --������ȣ(PK)
    name VARCHAR2(30) NOT NULL, --�̸�
    salary NUMBER NOT NULL, --�޿�
    address VARCHAR2(1000) NOT NULL, --�ּ�
    projname VARCHAR2(100) NULL --��� ������Ʈ ��
);

--1���� ������ �������� ������Ʈ�� ����� �� �ִ�. 
INSERT INTO tblstaff (seq, name, salary, address, projname)
    VALUES(1, 'ȫ�浿', 250, '�����', 'ȫ�� ����');

INSERT INTO tblstaff (seq, name, salary, address, projname)
    VALUES(2, '�ƹ���', 250, '�λ��', 'TV ����');

INSERT INTO tblstaff (seq, name, salary, address, projname)
    VALUES(3, '������', 250, '�����', '���� �м�');
    
SELECT*FROM tblstaff;

--�� �����ϴ� ��� ����� ���� -> �ϳ��� ������ �ϳ��� ���ڰ��� ������. 
--�� �ߺ����� �Ⱦ��Ѵ�. 


--�������������� ���ΰ��� ��� ���� ������ ���ʸ� ����� !!!!!!!������������
-- ���̸����� �ް��� ������ ���ϰ� ���� 

DROP TABLE tblstaff;


CREATE TABLE tblstaff
(
    seq NUMBER PRIMARY KEY, --������ȣ(PK)
    name VARCHAR2(30) NOT NULL, --�̸�
    salary NUMBER NOT NULL, --�޿�
    address VARCHAR2(1000) NOT NULL --�ּ�
    --project NUMBER NOT NULL --��� ������Ʈ ��
    
);

DROP TABLE tblproject;

CREATE TABLE tblproject
(
    seq NUMBER PRIMARY KEY, --������Ʈ ��ȣ(PK)
    name VARCHAR2(200) NOT NULL, --������Ʈ��
    staff NUMBER NOT NULL -- ��� ���� ��ȣ
);


INSERT INTO tblstaff(seq, name, salary, address) VALUES (1, 'ȫ�浿', 200, '�����');
INSERT INTO tblstaff(seq, name, salary, address) VALUES (2, '�ƹ���', 200, '��õ��');
INSERT INTO tblstaff(seq, name, salary, address) VALUES (1, '������', 200, '�λ��');

INSERT INTO tblproject (seq, name, staff) VALUES (1, 'ȫ�� ����', 1);
INSERT INTO tblproject (seq, name, staff) VALUES (2, 'TV ����', 2);
INSERT INTO tblproject (seq, name, staff) VALUES (3, '���� �м�', 2);
INSERT INTO tblproject (seq, name, staff) VALUES (4, '�븮�� �о�', 1);
INSERT INTO tblproject (seq, name, staff) VALUES (5, '���� ����', 3);

-- tblstaff(�⺻ ���̺�, �θ� ���̺�) + tblproject(�������̺�, �ڽ����̺�) : �� ���̺��� ����(relationship)�� �ΰ� �ִ�.
-- ����tblproject�� ������ ������ �ְ� �̷����� tblproject�� tblstaff�� �����Ѵٰ� ���Ѵ�. 
-- ���踦 �ΰ� �ִ� 2���� ���̺��� �����͸� �����ϸ�.. ����� �ϵ�..
--1. �θ� ���̺��� ����
--2. �ڽ� ���̺��� ���� 

--1. ���� ��� �Ի� -> �ű� ������Ʈ ����(���) 
--1. a ���Ի�� �߰� (O)
INSERT INTO tblstaff(seq,name,salary,address) VALUES(4, 'ȣȣȣ', 150, '�����');

--1. b �ű� ������Ʈ �߰�(O)
INSERT INTO tblproject(seq, name, staff) VALUES (6, '���� ����', 4);

--1. c �ű� ������Ʈ �߰�(X) - parent key not found
INSERT INTO tblproject(seq, name, staff) VALUES (7, '�� ���', 5);

-- ���� ����ڸ� �����߾�, �ٵ� null���� ���� ���� not null�� �س����ϱ�



-- 2. ȫ�浿 ���
-- 2. a ȫ�浿 ���� -child record found
DELETE FROM tblstaff WHERE name = 'ȫ�浿'; --where seq = 1


--�ڡڡڡڡڡڡڡڡڡڡڡڡ�2. b ȫ�浿 ���� ��� �����ڡڡڡڡڡڡڡڡڡڡڡڡڡڤ��ڡ�
--2. b. a ȫ�浿�� ��� ������Ʈ -> ����
UPDATE tblproject set staff = 3 WHERE staff = 1;

--2. b. b ȫ�浿 ����
DELETE FROM tblstaff WHERE name = 'ȫ�浿'; --where seq = 1

SELECT*FROM tblstaff;
SELECT*FROM tblproject;


----------------------------------------------------------------------------------------
-- �θ� ���̺� + �ڽ� ���̺� -> ���� ���� -> ������� �߰�
-- �ܷ�Ű, FOREIGN KEY
-- : ���� ������ ���̺��� ���� �� ������ �ϴ� �÷��� ���� �׻� ��ȿ�ϰ� ���������ִ� ���� 
-- : �θ� ���̺��� PK�� �����ϴ� Ű + �θ����̺� �̹� �����ϴ� ���� ���� �� �ִ� �÷� ���� 

--�̰�� �׻� ����


-- �� - �Ǹ�
-- �� �ְ� �Ǹ��ִ°Ŵϱ� �����̺��� �θ����̺��̰� �Ǹ����̺��� �����̺� ����ؾ��ϴ�(FOREIGN KEY������) ����

-- �� ���̺�
CREATE TABLE tblcustomer
(
seq NUMBER PRIMARY KEY, --����ȣ(PK)
name VARCHAR2(30) NOT NULL,
tel VARCHAR2(15) NOT NULL,
address VARCHAR2(100) NOT NULL
);

-- �Ǹ� ���̺�
CREATE TABLE tblsales
(
    seq NUMBER PRIMARY KEY, --�ǸŹ�ȣ(PK)
    item VARCHAR2(50) NOT NULL, --��ǰ��
    qty NUMBER NOT NULL, -- ����
    regdate DATE DEFAULT sysdate NOT NULL, --�Ǹų�¥
    customer NUMBER REFERENCES tblcustomer(seq)--����ȣ(FK)
);

--�θ� & �ڽ����̺�
-- 1. ���� ����
--  : �θ� ���� -> �ڽ� ����
-- �θ���� ũ������Ʈ �ϰ� �ڽ�ũ������Ʈ �ϱ� !
-- 2. ���� ���� 

-- �� ������� �����(���) ������
-- ORA-02449: unique/primary keys in table referenced by foreign keys
-- ��, �������� �����ؾ���
DROP TABLE tblcustomer;
DROP TABLE tblsales;

---------------------------------���� �뿩��--------------------------------------
--ȸ�����̺�-----------------------------------------------------------------------
CREATE TABLE tblmember
( 
    seq NUMBER PRIMARY KEY, --ȸ����ȣ
    name VARCHAR2(20) NOT NULL, --ȸ����
    grade NUMBER(1) CHECK(grade BETWEEN 1 AND 3), --ȸ�����(1, 2, 3)
    byear NUMBER(4) NOT NULL, --����
    tel VARCHAR2(15) NOT NULL,--����ó 
    address VARCHAR2(300) NULL, --�ּ�
    money NUMBER NOT NULL --��ġ��
);

--�帣 ���̺�----------------------------------------------------------------------
CREATE TABLE tblgenre
(
    seq NUMBER PRIMARY KEY, --�帣��ȣ(PK)
    name VARCHAR2(20) NOT NULL, --�帣��
    price NUMBER NOT NULL, --�뿩 ����
    period NUMBER NOT NULL -- �뿩 �Ⱓ
);

-- ���� ���̺�--------------------------------------------------------------------
CREATE TABLE tblvideo
(
    seq NUMBER PRIMARY KEY, --���� ��ȣ (PK) 
    name VARCHAR2(100) NOT NULL, -- WPAHR
    qty NUMBER  NOT NULL,-- ���� ����
    company VARCHAR2(50) NULL, --���ۻ�
    director VARCHAR2(50) NULL, --����
    major VARCHAR2(50) NULL, --�ֿ����
    genre NUMBER REFERENCES tblgenre(seq) NOT NULL -- �帣��ȣ(FK)

);

--�뿩���̺�-----------------------------------------------------------------------
CREATE TABLE tblrent
(
    seq NUMBER PRIMARY KEY, --�뿩��ȣ(PK)
    member NUMBER REFERENCES tblmember(seq) NOT NULL, --�뿩�� ȸ����ȣ(FK)
    video NUMBER REFERENCES tblvideo(seq) NOT NULL,
    rentdate DATE DEFAULT sysdate NOT NULL, --�뿩��¥
    retdate DATE NULL, --�ݳ���
    remart VARCHAR2(500) --��� 
);

--������ ��ü------------------------------------------------------------------------
CREATE SEQUENCE memberseq;
CREATE SEQUENCE genreseq;
CREATE SEQUENCE videoseq;
CREATE SEQUENCE rentseq;

--�ٽ� �ʱ�ȭ 

DROP TABLE tblrent;
DROP TABLE tblmember;
DROP TABLE tblvideo;
DROP TABLE tblgenre;

DROP SEQUENCE memberseq;
DROP SEQUENCE genreseq;
DROP SEQUENCE videoseq;
DROP SEQUENCE rentseq;



/*
����, Join
- 2�� �̻��� ���̺��� ������ 1���� ������� ����� �۾�
- ���踦 �ΰ� �ִ� ���̺����� ���ؼ�...

������ ����
1. �ܼ� ���� Cross Join
2. ���� ���� Inner Join
3. �ܺ� ���� Outer Join
4. ���� ���� Self Join
*/


--1. �ܼ�����

SELECT*FROM tblcustomer; --3��
SELECT*FROM tblsales; --9�� 

--����� : 27��
SELECT*FROM tblcustomer, tblsales;
SELECT*FORM tblcustomer CROSS JOIN tblsales; --���� --> ��ȿ���� �ʹ� ������ (����� ����� �� ��ġ��Ű�ϱ�...)

/*
2. ���� ����
 : �ܼ� ���ο��� ��ȿ�� ���ڵ常 ���ϴ� ���� 
 : �θ� ���̺��� (PK)�� �ڽ� ���̺��� FK�� ������ ������ ���Ѵ�. -> ��ȿ�� ���ڵ� 

SELELCT �÷�����Ʈ FROM ���̺� A  
        INNER JOIN ���̺� B
                ON ���̺�A.�÷�(PK) = ���̺�B.�÷�(FK)
*/
-- ORA-00918: column ambiguously defined  --> seq �ΰ��� �÷��� ��ȣ�ϰ� ���ǵƴ�.
SELECT seq FROM tblcustomer
        INNER JOIN tblsales
                ON tblcustomer.seq = tblsales.customer;



-- rs.getString("sseq")
-->  tblsales.seq, tblcustomer.seqó�� �տ� �Ҽ� ���ֱ� 
SELECT --3
        s.tblsales.seq as sseq, 
        c.tblcustomer.seq as cseq,
        --name,
        --item,
        c.tblcustomer.name,
        s.tblsales.item
FROM tblcustomer c INNER JOIN tblsales s --1
                ON c.seq = s.customer; --2



--�� ���ϴ� �ൿ(���� ����� *���� �������� �ʴ´�.)
SELECT * FROM tblcustomer c INNER JOIN tblsales s ON c.seq = s.customer; 
SELECT*FROM (SELECT c.name, c.address, s.item, s.qty FROM tblcustomer c INNER JOIN tblsales s ON c.seq = s.customer); 



--ǥ�� SQL --���� (����Ŭ ���뺸�� �̰� �ܿ���)
SELECT * FROM tblcustomer c 
        INNER JOIN tblsales s 
                ON c.seq = s.customer;

--����Ŭ ����
SELECT*FROM tblcustomer c, tblsales s
        WHERE c.seq = s.customer;


--���� ���� �ϸ� �ȵǴ� �ൿ
SELECT*FROM tblrent;
SELECT*FROM tblhousekeeping;

SELECT*FROM tblrent r
        INNER JOIN tblhousekeeping h
                ON r.member = h.qty;

SELECT * FROM tblcustomer; --3��
SELECT * FROM tblsales; --9��



--'��Ʈ'��(tblsales) �簣 ȸ���� ����ó(tblcustomer)?
-- ������ ������� ���� ����� 2�� �̻��� ���̺��� ���;� �Ѵٸ� -> ���� ���

--1. ��������
SELECT name, tel, qty FROM tblcustomer
        WHERE seq = (SELECT customer FROM tblsales WHERE item = '��Ʈ');
        
SELECT name, tel, (SELECT qty FROM tblsales WHERE customer = c.seq AND item = '��Ʈ')
        FROM tblcustomer c
                WHERE seq = (SELECT customer FROM tblsales WHERE item = '��Ʈ');

--2. ����
SELECT c.tel, s.qty FROM tblcustomer c
        INNER JOIN tblsales s
                ON c.seq = s.customer
                        WHERE s.item = '��Ʈ';
/*
SELECT*FROM tblcustomer c
        INNER JOIN tblsales s
                ON c.seq = s.customer;
                

tblcustomer c
        INNER JOIN tblsales s
                ON c.seq = s.customer;
                -------------------------->>>> A�� �����غ��� 
*/

--������ ����
--1.�ܼ� ����, Cross Join
--2.���� ����, Inner Join
--3.�ܺ�����
--���� ���� + a

-- ****�� 1�� �߰� 
INSERT INTO tblcustomer VALUES (4, 'ȣȣȣ', '010-1234-1234', '�����');

--���� ����
-- ���θ����� 1ȸ �̻�(******)�����̷��� �ִ� ���� ������ ���� �̷��� �������ÿ�.
SELECT*FROM tblcustomer c 
        INNER JOIN tblsales s 
                ON c.seq = s.customer; --����(cd�� pk�� s�� fk)

-- ���θ����� ��� ���� ������ ���  + �����̷��� ������ �����̷µ� ���� ���
-- ������ �׻� �θ� ���̺��� ����Ų��. �ڽ� ���̺��� ����Ű�� INNER JOIN �� ����������.
SELECT*FROM tblcustomer c
        LEFT OUTER JOIN tblsales s -- �׻� �θ����̺��� ����Ų��. 
                ON c.seq = s.customer;

SELECT* FROM tblstaff; --3��
SELECT*FROM tblproject; --6��

INSERT INTO tblstaff VALUES(5, 'ȫ�浿', 200, '�����');
INSERT INTO tblstaff VALUES(6. '�׽�Ʈ', 220, '�����');

-- ����ȸ�� : ���� ��� + ������ �ִ� �����...
--�츮 ���� ��� �����Ͷ� + ������Ʈ�� ����ϰ� �ִ� ������ ���ؼ�....
 SELECT*FROM tblstaff s
        INNER JOIN tblproject p
                ON s.seq = p.staff;
-- ����ȸ�� : ���� ��� + ������ �ִ� ���� ��δ�... 
--�츮 ���� ��� �����Ͷ� + ������Ʈ ��� ������ �������...
-- ǥ�� SQL
SELECT*FROM tblstaff s 
        LEFT OUTER JOIN tblproject p
                ON s.seq = p.staff;

-- ����Ŭ 
SELECT* FROM tblstaff s, tblproject p; 
        WHERE s.seq = p.staff(+);

        
/*
4. ���� ���� 
- 1���� ���̺� ������ ���� 
- �� ���� -> �ڽ��� �ڽ��� �����ϴ� Ű�� ������
*/
 --���� ���� ���̺�
 CREATE TABLE tblself
 (
        seq NUMBER PRIMARY KEY, --������ȣ(PK)
        name VARCHAR2(30) NOT NULL, --������
        department VARCHAR2(30) NULL, --�μ� 
        super NUMBER REFERENCES tblself(seq) NULL --���� ���(FK) 
 );

INSERT INTO tblself VALUES (1, 'ȫ����', NULL, NULL);
INSERT INTO tblself VALUES (2, '������', '�ѹ���', 1);        
INSERT INTO tblself VALUES (3, '������', '�ѹ���', 2);        
INSERT INTO tblself VALUES (4, '�ٴ븮', '�ѹ���', 3);        
INSERT INTO tblself VALUES (5, '����', '�ѹ���', 4);
INSERT INTO tblself VALUES (6, '������', '������', 1);
INSERT INTO tblself VALUES (7, '�ٰ���', '������', 8);
        
 SELECT * FROM tblself;
 
 SELECT s2.name as ������, s1.name as ���� FROM tblself s1 - ������̺�
        INNER JOIN tblself s2 - ���� ���̺�
                ON s1.seq = s2.super; -- s1(PK,  �θ����̺�) = s2(FK, �ڽ����̺�)
        
-- employees : manager_id        
SELECT e2.first_name as ������, e1.first_name as �Ŵ����� 
        FROM employees e1 -- �Ŵ���
                INNER JOIN employees e2-- ����
                        ON e2.manager_id = e1.employee_id;        

-- �Ŵ�����? �Ŵ������� ����ϰ� �ִ� ���� �� 
SELECT (SELECT first_name|| ' '|| last_name FROM employees WHERE employee_id = e2.manager_id), count(*) FROM employees
        GROUP BY manager_id;
        
-- ���� ����
-- ���̺��� ���� �ø��� 

-- 1 ��
-- ������ ����? 
SELECT*FROM tblvideo;

-- 2�� 
-- ��� ���� ����� �뿩 ����, �Ⱓ? 
SELECT*FROM tblgenre g 
        INNER JOIN tblvideo v 
                ON g.seq = v.genre;
                
-- 3�� 
-- ��� ������ �뿩����, �Ⱓ + �뿩���� ?
SELECT*FROM tblgenre g 
        INNER JOIN tblvideo v
                ON g.seq = v.genre
                        INNER JOIN tblrent r 
                                ON r.video = v.seq;

-- 4�� 
-- ��� ������ �뿩����, �Ⱓ + �뿩���� + �뿩  ȸ���� ����?
SELECT*FROM tblgenre g 
        INNER JOIN tblvideo v
                ON g.seq = v.genre
                        LEFT OUTER JOIN tblrent r 
                                ON r.video = v.seq
                                        RIGHT OUTER JOIN tblmember m 
                                                ON m.seq = r.member;

-- �뿩��� ��� + ȸ���� + �������� + ���� + �ݳ� ����('�ݳ��Ϸ�' or '�̹ݳ�') - CASE��
CREATE VIEW ���
AS
SELECT
        m.name as ȸ����,
        v.name as ��������,
        to_char(r.rentdate, 'yyyy-mm-dd') as �뿩��¥,
        CASE
                WHEN r.retdate IS NOT NULL then '�ݳ��Ϸ�'
                WHEN r.retdate IS NOT NULL then '�̹ݳ�'













