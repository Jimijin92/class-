/*
ex09_insert.sql

DML : select, insert, update, delete

INSERT��
- INSERT INTO ���̺��(�÷�����Ʈ) VALUES (�� ����Ʈ);

*/

DROP TABLE tblmemo;

CREATE TABLE tblmemo
(
seq number PRIMARY KEY, --�޸��ȣ(PK)
name VARCHAR2(30) NOT NULL, --�۾���
memo VARCHAR2(1000) NOT NULL, --�޸�
regdate date DEFAULT sysdate NOT NULL, --��¥
etc VARCHAR2(500) DEFAULT '������' NULL, -- ���
page NUMBER NULL --��������
);

-- developer ���� Ű�� ������
-- ORA-08002: sequence MEMOSEQ.CURRVAL is not yet defined in this session
SELECT memoseq.currval FROM dual;


--> �ذ��
SELECT memoseq.nextval FROM dual; --> �̰� �־��ֱ�
SELECT memoseq.currval FROM dual;




-- INSERT ���� ����(****************************************)

--1. ǥ�� ���� : ���� ���̺��� ���� �÷� ������� �÷�����Ʈ�� ������Ʈ�� ǥ�� 
INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', sysdate, '���', 1);
    
-- ������ 
-- ORA-01841: (full) year must be between -4713 and +9999, and not be 0 
--> year�� �ݵ�� -4713���� 9999���� �մϴ�.
-- �÷�����Ʈ ������ ������Ʈ ������ �ݵ�� ����
INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', '���', sysdate, 1);

-- SQL ����: ORA-00947: not enough values 
--> ������ �ȸ�����, ���� �ʹ� ���� �� 
INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', sysdate, '���');

-- SQL ����: ORA-00913: too many values
--> �����ȸ�����, ���� �ʹ� ���� ��
INSERT INTO tblmemo(seq, name, memo, regdate, etc)
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', sysdate, '���', 1);
    

--2. �÷�(��)�� ���� �ٲٱ� 
-- �÷�����Ʈ�� ������Ʈ�� ������ �ݵ�� �������̺��� ���ǿ� ��ġ�� �ʿ䰡 ����. 
INSERT INTO tblmemo(name, memo, regdate, etc, page, seq)
    VALUES ('ȫ�浿', '�޸�', sysdate, '���', 1, memoseq.nextval);
    
--3. NULL ������ ���� �÷��� �Է��ϱ�
-- Ư�� �÷��� NULL�� �����ϰ� �ʹ�. 

    -- 3.a ��� �÷��� ���� �����ϸ� �ȴ�. -> page�� 1������
INSERT INTO tblmemo(seq, name, memo, regdate, etc)
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', sysdate, '���');


INSERT INTO tblmemo(seq, name, memo, regdate)
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', sysdate); --�ڡڡڡڡ�etc> ���� > default�� �Է�


    -- 3. b��������� NULL�� ���� -> NULL ����� ����Ѵ�.
INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', sysdate, '���', NULL);
    
INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', sysdate, NULL, NULL); --> �ڡڡڡڡ�default�ɷ��ִ� �ִ� �ΰ����� �־���� NULL �� ����

--4. default�� �Է� 
    --4. a default�� ���ǵǾ� �־ ���� ���� �Է��ϴ� ��� > default�� �ƴ� ����ڰ� ���� �Է��� ���� ����
INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', sysdate, '���', 1);

    --4. b default�÷��� ���� > default���� ����
INSERT INTO tblmemo(seq, name, memo, page)
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', 1);
    
    --4. c default + null ���� null����� �Է��ϸ� default ���� ����
INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', sysdate, '���', 1);
   
    --4. d ��������� default�� ����
INSERT INTO tblmemo(seq, name, memo, regdate, etc, page)
    VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', DEFAULT, DEFAULT '���', 1);

SELECT*FROM tblmemo;

--5. �÷�����Ʈ ����
INSERT  INTO tblmemo VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', sysdate, '���', 1);

--5.a �ݵ�� ���̺��� ������� ����� �÷�������� ������Ʈ�� ����� �Ѵ�.
--ORA-01722: invalid number
INSERT INTO tblmemo VALUES ('ȫ�浿', '�޸�', sysdate, '���', 1, memoseq.nextval);

--5.b default ó���� ���� �� ������ �Ұ����ϴ�.
INSERT INTO tblmemo VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', 1);
--5. c default ����ϰ� ������ ������ �Ұ��������� default ����� �����ϴ�.******
INSERT  INTO tblmemo VALUES (memoseq.nextval, 'ȫ�浿', '�޸�', DEFAULT, DEFAULT, '���', 1);

------------------------------�Ϲ����� INSERT

SELECT*FROM tblmemo;

DROP TABLE tblmemo;
CREATE TABLE tblmemo
(
seq number PRIMARY KEY, --�޸��ȣ(PK)
name VARCHAR2(30) NOT NULL, --�۾���
memo VARCHAR2(1000) NOT NULL, --�޸�
regdate date DEFAULT sysdate NOT NULL, --��¥
etc VARCHAR2(500) DEFAULT '������' NULL, -- ���
page NUMBER NULL --��������
);

--tblmemo -> (����) -> tblmemobackup
INSERT into tblmemobackup 
    SELECT*FROM tblmemo WHERE page = 1; --���� ����
    
SELECT*FROM tblmemobackup;

--tblmemo���� page�� 1�� �׸�鸸 ������ ������ ���̺� ����
CREATE TABLE tblmemoonepage
AS
SELECT*FROM tblmemo WHERE page = 1;
SELECT*FROM tblmemoonepage;

--
SELECT*FROM tblinsa;
CREATE TABLE ������
AS
SELECT*FROM tblinsa WHERE buseo = '������';

SELECT*FROM ������;


/*
1. ���� ���̺� -> (������ ����) -> ���� ���̺� B
- insert + select
- ������ O, ������ �׽�Ʈ�� O

2. ���� ���̺� A -> (���̺� ���� + ������ ����) -> ���� ���̺� B
- CREATE + SELECT 
- ������X, ������ �׽�Ʈ�� O
- ���̺��� ������ �� �����ʹ� ���簡 �Ǵµ�.. ��������� ���簡 �ȵȴ�. 
*/





















