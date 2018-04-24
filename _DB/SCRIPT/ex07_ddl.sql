/*
ex07_ddl.sql

DML
- ������ ���۾�(SELECT, INSERT, UPDATE, DELETE)
- SELECT : DQL(Data Query Language)

DDL
- ������ ���Ǿ�
- DB Object(���̺�, ��, ���ν���, �ε���, Ʈ���� ��...) ����/�����ϴ� ��ɾ�
- CREATE : �����
- DROP : ����
- ALTER: ����(�κ�)

���̺� �����ϱ� 

CREATE TABLE ���̺��
(
    �÷� ����,
    �÷� ����,
    �÷� ����,
    �÷� ����,
    �÷��� �ڷ���(����) �������
);
*/

CREATE TABLE tbltest
(
    num number(3), 
    txt varchar2(10),
    regdate date
);

SELECT * FROM tbltest;
INSERT INTO tbltest(num, txt, regdate) VALUES(100, 'test', '2018-01-16');


/*
�������, Constraint
- �÷����� ���� ����(��Ģ) -> ���� ���ϸ� �����͸� �� �ִ´�. -> ������ ��ȿ�� ����
- �����ͺ��̽� ���Ἲ ����(Integrity Constraint Rule - ���Ἲ ���� ����)

1. NOT NULL
- �ݵ�� �÷����� ����(�ʼ� �Է°�)
- �÷������θ� ���� ����
*/

--�޸����̺�
CREATE TABLE tblmemo
(
    seq NUMBER NOT NULL, -- �Ϸ� ��ȣ + �ʼ� �Է�
    name VARCHAR2(20) NULL, -- �۾���
    memo VARCHAR2(1000) NULL, -- �޸� ����
    regdate DATE NULL -- �ۼ� �ð�
);

INSERT INTO tblmemo(seq, name, memo, regdate)
    VALUES (1, 'ȫ�浿', '�޸��Դϴ�.', sysdate);

INSERT INTO tblmemo(seq, name, memo, regdate)
    VALUES (2, 'ȫ�浿', '�޸��Դϴ�.', NULL);

INSERT INTO tblmemo(seq, name, memo, regdate)
    VALUES (3, 'ȫ�浿', NULL, NULL);

INSERT INTO tblmemo(seq, name, memo, regdate)
    VALUES (4, NULL, NULL, NULL);
    
INSERT INTO tblmemo(seq, name, memo, regdate)
    VALUES (NULL, NULL, NULL, NULL); -- ����, �̷� �ൿ�� �� Ȯ�� 0%

SELECT * FROM tblmemo;













DROP TABLE tblmemo;

CREATE TABLE tblmemo
(
    seq NUMBER NOT NULL, -- �Ϸ� ��ȣ + �ʼ� �Է�
    name VARCHAR2(20) NULL, -- �۾���
    memo VARCHAR2(1000)NOT NULL, -- �޸� ����
    regdate DATE NULL -- �ۼ� �ð�
);


INSERT INTO tblmemo(seq, name, memo, regdate)
    VALUES (1, 'ȫ�浿', '�޸��Դϴ�.', sysdate);

INSERT INTO tblmemo(seq, name, memo, regdate)
    VALUES (2, 'ȫ�浿', '�޸��Դϴ�.', NULL);

-- ORA-01400: cannot insert NULL into ("HR"."TBLMEMO"."MEMO")
INSERT INTO tblmemo(seq, name, memo, regdate)
    VALUES (3, 'ȫ�浿', NULL, NULL);
    
INSERT INTO tblmemo(seq, name, memo, regdate)
    VALUES (3, NULL, '�޸�', NULL);

-- ORA-01400: cannot insert NULL into ("HR"."TBLMEMO"."SEQ")
INSERT INTO tblmemo(seq, name, memo, regdate)
    VALUES (NULL, NULL, '�޸�', NULL);

/*
1.NOT NULL

2. PRIMARY KEY(PK)
- �⺻ Ű
- Ű(KEY) : �÷�
- ���̺��� ��� �÷����� ��ǥ(?)�ϴ� �÷� -> ��� ���� �����ϴ� �������� ���
- ������ ��ġ�ϴ� ���� 2���̻� ������ �ȵ� !
- ���̺����� ���� �����ϱ� ���� ���� �ĺ���(PK �÷��� ���� ���̺��� �����ؾ� �Ѵ�.)
- 1���� ���̺��� �ݵ��(***) PK�� �����ؾ� �Ѵ�.
    a. ��� ���� �����ϱ� ���ؼ�..
    b. PK�� 1�� �̻� ���� ����(2�� �̻� PK -> �⺻Ű ���� -> ���ձ�(Composite Key))
- PK�� �ڵ����� NOT NULL�� ����ȴ�.
- PK�� �ڵ����� NOT Duplicate�� ����ȴ�. -> UNIQUE
- NOT NULL + UNIQUE = PK
*/

DROP TABLE tblmemo;

CREATE TABLE tblmemo
(
    seq NUMBER PRIMARY KEY, --�ߺ�X, ����X, ���̺��� ������ �ĺ��� �÷� -> PK
    name VARCHAR2(20) NULL, -- �۾���
    memo VARCHAR2(1000)NOT NULL, -- �޸� ����
    regdate DATE NULL -- �ۼ� �ð�
);

INSERT INTO tblmemo (seq, name, memo, regdate)
    VALUES (1, 'ȫ�浿', '�޸��Դϴ�.', sysdate); --������

-- ORA-00001: unique constraint (HR.SYS_C007068) violated --�ߺ��ƴٴ� ����
INSERT INTO tblmemo (seq, name, memo, regdate)
    VALUES (1, 'ȫ�浿', '�޸��Դϴ�.', sysdate); --������

INSERT INTO tblmemo (seq, name, memo, regdate)
    VALUES (2, 'ȫ�浿', '�޸��Դϴ�.', sysdate); --�տ� ������ȣ �ٲ㼭 �����ȳ��� ���ֱ�

INSERT INTO tblmemo (seq, name, memo, regdate)
    VALUES (NULL, 'ȫ�浿', '�޸��Դϴ�.', sysdate); --������
    
--Ư�� �� 1���� ������ ���� �ݵ�� PK�� �������� �Ǵ�.(******)
SELECT * FROM tblmemo
    WHERE seq=1 ; -- ���� ���ϴ� �޸���

/*
3.  UNIQUE
- �ش� �÷����� ���̺����� ������ ���̾�� �Ѵ�.(�ߺ����� �־�� �ȵȴ�.)
- NULL�� ���� �� �ִ�.
- �ĺ��ڷ� ����ϸ� ���� �ȵ�!!!!!! (NULL�� �ֱ� ������)
- PK�� UNIQUE���߿� �ϳ��� ������ �� ����
*/


DROP TABLE tblmemo;

CREATE TABLE tblmemo
(
    seq NUMBER NOT NULL, -- �Ϸ� ��ȣ + �ʼ� �Է�
    name VARCHAR2(20) UNIQUE, -- �۾���
    memo VARCHAR2(1000)NOT NULL, -- �޸� ����
    regdate DATE NULL -- �ۼ� �ð�
);

INSERT INTO tblmemo (seq, name, memo, regdate)
    VALUES (1, 'ȫ�浿', '�޸��Դϴ�.', sysdate); --������

INSERT INTO tblmemo (seq, name, memo, regdate)
    VALUES (2, '�ƹ���', '�޸��Դϴ�.', sysdate); --������

INSERT INTO tblmemo (seq, name, memo, regdate)
    VALUES (NULL, 'ȫ�浿', '�޸��Դϴ�.', sysdate); --������

INSERT INTO tblmemo (seq, name, memo, regdate)
    VALUES (4, 'ȫ�浿', '�޸��Դϴ�.', sysdate); --������

INSERT INTO tblmemo (seq, name, memo, regdate)
    VALUES (5, NULL, '�޸��Դϴ�.', sysdate); --������

SELECT * FROM tblmemo;


/*
4. check (������Ʈ�� �� ����)
- ������, ���� �� ���� ���� 
- where�� ���� 
*/
DROP TABLE tblmemo;
CREATE TABLE tblmemo
(
    seq NUMBER NOT NULL, -- �Ϸ� ��ȣ + �ʼ� �Է�
    name VARCHAR2(20) UNIQUE, -- �۾���
    memo VARCHAR2(1000)NOT NULL, -- �޸� ����
    -- regdate DATE NULL, -- �ۼ� �ð�
    -- color VARCHAR2(20) NOT NULL, -- red, yellow, blue
    -- page NUMBER(1) NOT NULL -- 1~9
    color VARCHAR(20) CHECK (color IN('red', 'yellow', 'blue')) NOT NULL,
    -- page NUMBER(1) CHECK (page >=1 and page <=9) NOT NULL
    page NUMBER(1)CHECK (page BETWEEN 1 AND 9) NOT NULL,    
    -- ��¥ �Ⱓ ���� 
--    regdate DATE CHECK
--        (regdate BETWEEN to_date('2018-01-15','yyyy-mm-dd') 
--            AND to_date('2018-01-31','yyyy-mm-dd')) NOT NULL

    --�������� ����
    -- regdate date CHECK (to_char(regdate, 'hh24') BETWEEN 0 AND 11) NOT NULL
    
    --��, �Ͽ��Ͽ��� ����
    regdate date CHECK (to_char(regdate,'d') in (1, 7) 
                                AND to_char(regdate, 'hh24') BETWEEN 0 AND 12) NOT NULL
    
);

INSERT INTO tblmemo (seq, name, memo, regdate, color, page)
    VALUES (1, 'ȫ�浿', '�޸��Դϴ�.', sysdate, 'blue', 1); 

-- ORA-02290: check constraint (HR.SYS_C007081) violated
INSERT INTO tblmemo (seq, name, memo, regdate, color, page)
    VALUES (2, '�ƹ���', '�޸��Դϴ�.', sysdate, 'white', 1); 

-- ORA-02290: check constraint (HR.SYS_C007081) violated
INSERT INTO tblmemo (seq, name, memo, regdate, color, page)
    VALUES (2, '�ƹ���', '�޸��Դϴ�.', sysdate, 'blue', -1);
    
INSERT INTO tblmemo (seq, name, memo, regdate, color, page)
    VALUES (1, 'ȫ�浿', '�޸��Դϴ�.', sysdate, 'blue', 1); 

INSERT INTO tblmemo (seq, name, memo, regdate, color, page)
    VALUES (2, '�ƹ���', '�޸��Դϴ�.'
        , to_date('2018-01-20 10:05:50','yyyy-mm-dd hh24:mi:ss'), 'blue', 1); 


/*
5. DEFAULT
- �÷� �⺻��
- �ش� �÷��� ���� ���� ������ NULL�� �Է����� ����, �ڵ����� �̸� �غ�� ���� �־��.
*/

DROP TABLE tblmemo;

CREATE TABLE tblmemo
(
    seq NUMBER NOT NULL, 
    name VARCHAR2(20) DEFAULT '�͸�' NULL, 
    memo VARCHAR2(1000)NOT NULL, 
    regdate DATE DEFAULT sysdate NULL
);

INSERT INTO tblmemo (seq, name, memo, regdate)
    VALUES (1, 'ȫ�浿', '�޸��Դϴ�.', sysdate); 

INSERT INTO tblmemo (seq, name, memo, regdate)
    VALUES (2, NULL, '�޸��Դϴ�.', sysdate); 

INSERT INTO tblmemo (seq, memo, regdate)
    VALUES (3, '�޸��Դϴ�.', sysdate); 

INSERT INTO tblmemo (seq, memo)
    VALUES (3, '�޸��Դϴ�.'); 

SELECT *FROM tblmemo;


/*
���� ������ ����� ���
1. �÷� ���ؿ��� ����� ���
    - �÷��� �ڷ��� �������� 
    - �÷��� �ڷ��� ��������
    - �÷��� �ڷ��� constraint ����� �������� 
2. ���̺� ���ؿ��� ����� ���
*/
DROP TABLE tblmemo;

CREATE TABLE tblmemo
(
    seq number,
    memo varchar2(1000) NOT NULL,
    color varchar2(20),
    page number(1), -->���� �޸� �ִ°� ��������!
    -- �Ʒ�ó�� �ϸ� ����� �� �� ��� ����
    --CONSTRAINT tblmemo_seq_pk PRIMARY KEY
    CONSTRAINT tblmemo_seq_pk PRIMARY KEY(seq),
    CONSTRAINT tblmemo_color_ck CHECK (color in ('white', 'black')),
    CONSTRAINT tblmemo_page_ck CHECK (page BETWEEN 1 AND 9)
);

INSERT INTO tblmemo(seq, memo) VALUES (1, '�޸��Դϴ�.');
INSERT INTO tblmemo(seq, memo, color, page) VALUES (1, '�޸��Դϴ�.','white', 1);
INSERT INTO tblmemo(seq, memo, color, page) VALUES (2, '�޸��Դϴ�.','blue', 1);
INSERT INTO tblmemo(seq, memo, color, page) VALUES (2, '�޸��Դϴ�.','white', -1);




INSERT INTO tblmemo(seq, memo) VALUES(1, '�޸��Դϴ�.');

ORA-00001: unique constraint (HR.TBLMEMO_SEQ_PK) violated
INSERT INTO tblmemo(seq, memo) VALUES(1, '�޸��Դϴ�.');


