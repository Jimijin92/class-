/*
���̺� �����ϱ�
1. ���̺� ���� -> ���̺�(����) ���� -> ������ ����(INSERT)//������Ʈ �ʱ� �ܰ�
2. ALTER ��ɾ� -> ������ ���� + ������ ���� // ������Ʈ ���Ĺ� �ܰ� : ALTER ��ɾ�� �ǵ��� ����� ��Ȳ�� �� ����°�...

���̺� ���� �۾�
1. ���ο� �÷� �߰��ϱ� - ���̵� �� 
2. ���� �÷� �����ϱ� 
3. ���� �÷� �����ϱ� 
*/


CREATE TABLE tbledit
(
        seq NUMBER NOT NULL,
        data VARCHAR2(10) NOT NULL
);

INSERT INTO tbledit VALUES (1, 'Ű����');
INSERT INTO tbledit VALUES (1, '���콺');

ALTER TABLE tbledit
        ADD (price number(5) NULL);

ALTER TABLE tbledit
        ADD (regdate DATE NULL);
        
ALTER TABLE tbledit
        ADD (qty number(1) NOT NULL);
        
-- NN ������ �Ÿ� �÷��� ���� �߰��ϴ� ��� 
ALTER TABLE tbledit
        ADD (qty number(1) NULL);

-- 2.
UPDATE tbledit SET qty = 1;

-- 3. 
ALTER TABLE tbledit
        MODIFY (qty number(1) NOT NULL);
        
-- NN ������ �ɸ� �÷��� ���� �߰��ϴ� ���
ALTER TABLE tbledit
        ADD(color VARCHAR2(30) DEFAULT '����' NOT NULL); -- ��� ���� ���ڵ��� ���÷��� default �� ����ȴ�. 

INSERT INTO tbledit VALUES(3, '�����', NULL, NULL, NULL);

SELECT*FROM tbledit; 
     
-- 2. ���� �÷� �����ϱ�
-- : �÷� ���� + ������ ���� 
ALTER TABLE tbledit
        DROP COLUMN qty;

ALTER TABLE tbledit
        DROP COLUMN regdate;
        
SELECT*FROM tbledit;

-- 3. ���� �÷� �����ϱ�
-- : �ڷ���(Ÿ��, ����), �������(NOT NULL ��..) �ٲٱ�
INSERT INTO tbledit VALUES (3, '�����', 1000, '����');
INSERT INTO tbledit VALUES (4, '�޸�', 2000, '���');

SELECT*FROM tbledit;

UPDATE tbledit SET price = 0;

ALTER TABLE tbledit
        MODIFY(price NUMBER(4));
        
-- NN�����ϱ�
ALTER TABLE tbledit 
        MODIFY(price NUMBER(4) NULL);

ALTER TABLE tbledit 
        MODIFY(price NUMBER(4) NOT NULL); --����: ���������� ���� �ִٰ� ����

--ADD (color VARCHAR2(30) DEFAULT '����' NOT NULL);
ALTER TABLE tbldit
        MODIFY(color VARCHAR2(30) DEFAULT '����'
                        CHECK(color IN ('����','����','���','����','�Ķ�')));

INSERT INTO tbledit VALUES (4, '�޸�', 2000, '���');


CREATE TABLE tbledit
(
        seq NUMBER NOT NULL,
        data VARCHAR2(10) NOT NULL
)

--���� ���� �߰��ϱ�
-- : NOT NULL ������ ������ ������ ���� ���� �߰��ϱ�
ALTER TABLE tbledit
        ADD CONSTRAINT tbledit_seq_pk PRIMARY KEY (seq);
        
ALTER TABLE tbledit 
        DROP CONSTRAINT tbledit_seq_pk;
        
ALTER TABLE tbledit
        DROP CONSTRAINT SYS_C007309;

/*
���̺��� ������� �����ϱ�
- ���̺� �ʱ�ȭ (������ �״�� �ΰ� �����͸� �ʱ�ȭ)
- ���� -> �׽�Ʈ -> �Ϸ� -> �ʱ�ȭ

1. DROP -> CREATE
- ��� 
- ��� �� ���� 
- �ǵ����� �Ұ��� 

2. DELETE
- ���� 
- ��� �� or �Ϻ� �� 
- �ǵ����� ����(���� ����)

3. TRUNCATE ��ɾ� (���� �Լ� TRUNC �Լ��� �ٸ� ��ɾ�)
- ���� (***)
- ���̺��� ��� ���� �����ϴ� ��ɾ� (DELETE ���������� ����ϴ� �Ͱ� ���� = DELETE*)
- �ǵ����� �Ұ��� (���� �Ұ���) 
*/

TRUNCATE TABLE tbledit; -- ���� �Ұ���
DELETE FROM tbledit; -- ���� ����
SELECT*FROM tbledit;

CREATE TABLE ������
AS
SELECT*FROM tblinsa WHERE buseo = '������';

SELECT*FROM ������;

COMMIT;
ROLLBACK;

DELETE FROM ������;
TRUNCATE TABLE ������;








