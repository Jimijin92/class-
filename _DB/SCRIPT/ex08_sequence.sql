/*
ex08_sequence.sql

������, Sequences
- ������ ��ü(DB Object �� �ϳ�)
        -���ǹ��� �Ϸù�ȣ���� �����ϰ� �����ϴ� ����
        
������ ��ü �����ϱ�
- CREATE : ����
- ALTER : ����
- DROP : ����
- CREATE SEQUENCE ��������;
*/

CREATE SEQUENCE testseq;

SELECT testseq.nextval FROM dual;
SELECT testseq.currval FROM dual;

DROP TABLE tblmemo;

CREATE TABLE tblmemo
(
seq number, --�Ϸ� ��ȣ (1, 2, 3, 4......)
name varchar2(20),
memo varchar2(1000),

CONSTRAINT tblmemo_seq_pk PRIMARY KEY(seq),
CONSTRAINT tblmemo_name_uq UNIQUE (name),
CONSTRAINT tblmemo_memo_ck CHECK (length(memo) >= 10)

);

CREATE SEQUENCE memoseq;

INSERT INTO tblmemo (seq, name, memo) VALUES (1, 'ȫ�浿','������ �׽�Ʈ�Դϴ�.');
INSERT INTO tblmemo (seq, name, memo) VALUES (memoseq.nextval, 'ȫ�浿','������ �׽�Ʈ�Դϴ�.'); --������
INSERT INTO tblmemo (seq, name, memo) VALUES (memoseq.nextval, '�ƹ���','������ �׽�Ʈ�Դϴ�.');
INSERT INTO tblmemo (seq, name, memo) VALUES (memoseq.nextval, '�׽�Ʈ','������ �׽�Ʈ�Դϴ�.');
INSERT INTO tblmemo (seq, name, memo) VALUES (memoseq.nextval, 'ȣȣȣ','������ �׽�Ʈ�Դϴ�.');

SELECT memoseq.currval FROM dual;
SELECT memoseq.nextval FROM dual;

SELECT*FROM tblmemo;

delete from tblmemo;

-- ��ǰ ���̺�
-- : ��ǰ�ڵ�, ��ǰ��, ����, ����
-- : ��ǰ�ڵ�(PK) -> 1, 2, 3, 4....(X)
-- : ��ǰ�ڵ�(PK) -> AA015 --�ڿ� ���ڸ� ������ �տ��Ŵ� �츮�� ���� ������

CREATE TABLE tblproduct
(
    seq varchar2(5) PRIMARY KEY, --��ǰ�ڵ�
    name varchar2(50) NOT NULL,
    price number NOT NULL,
    qty number NOT NULL
);

-- AA001, AA002, AA003
CREATE SEQUENCE productseq;

INSERT INTO tblproduct (seq, name, price, qty)
    VALUES ('AA' || trim(to_char(productseq.nextval,'000')), '���� û�ұ�', 1000000, 1); -- AA�� 000���̿� ���� �Ȼ���� TRIM�����ֱ�!
    
INSERT INTO tblproduct (seq, name, price, qty)
    VALUES ('AA' || trim(to_char(productseq.nextval,'000')), '�ɷ�', 100000, 1); -- AA�� 000���̿� ���� �Ȼ���� TRIM�����ֱ�!

INSERT INTO tblproduct (seq, name, price, qty)
    VALUES ('AA' || trim(to_char(productseq.nextval,'000')), '����', 1000000, 1); -- AA�� 000���̿� ���� �Ȼ���� TRIM�����ֱ�!
    
-- ORA-00001: unique constraint (HR.SYS_C007142) violated   
INSERT INTO tblproduct (seq, name, price, qty)
    VALUES ('AA' || trim(to_char(productseq.nextval,'000')), '����ǰ', 1000000, 1); -- AA�� 000���̿� ���� �Ȼ���� TRIM�����ֱ�!


SELECT*FROM tblproduct;

-- ������ ��ü �ʱ�ȭ(1���� �ٽ� �����ϵ���......)
SELECT productseq.nextval FROM dual;
--1. �ٽ� �����
DROP SEQUENCE productseq;
CREATE SEQUENCE productseq;

--2. �����ϱ�(�����ϱ�) 
DROP SEQUENCE productseq;
CREATE SEQUENCE productseq
        INCREMENT BY 1 --����ġ
        START WITH 1 --���۰� -->ó������ 10���� ������
        MAXVALUE 10 --�ִ밪(������ ���� �߻�)
        MINVALUE -5 --�ּҰ� --> �������ε� �� �� ����
        CYCLE 
        CACHE 3
        ;

SELECT productseq.nextval FROM dual;        



/*
�ٵ� ������ �ϳ��־� , �����Ű�� ũ������Ʈ �� ���� �̳��� ȣ���ϸ� 1�� �������� 
�ٵ� 1���� �̹� ���ݾ� �ּ��� ����ǰ�� 4���� �����ؾ���, 
�״ϱ� �����͵� �������� �ٵ� �����ʹ� �Ժη� ����� ����ŵ� 
�����
SELECT productseq.nextval FROM dual; ->�� 4�� �ɶ����� ������
*/



