/*

ex17_transaction.sql

Ʈ�����, Transaction
- DCL �� ����
- ����Ŭ(DBMS)���� �߻��ϴ� 1�� �̻��� ���ɾ�(SQL)���� �ϳ��� ���� �������� ���� ���� ���� -> ����
-Ʈ����ǿ� ���ؼ� �����Ǵ� ���ɾ� : DML�� �ش�ȴ�. (INSERT, UPDATE, DELETE)

Ʈ�����
1. COMMIT
2. ROLLBACK
3. SAVEPOINT

*/

CREATE TABLE �����
AS
SELECT*FROM tblinsa WHERE city = '����';

seleldtjdnftl 20aud
--HR ������ ó������ ����Ŭ�� ����
-- : Ʈ������� ���۵ȴ�. 
SELECT * FROM �����; --20

-- ȫ�浿 �����ϱ�
DELETE FROM ����� WHERE name = 'ȫ�浿';
DELETE FROM ����� WHERE name = '�Ѽ���';
DELETE FROM ����� WHERE name = '������';

-- ������ -> Ʈ����� ���� -> SELECT -> DELETE(�浿) -> SELECT -> DELETE(����) -> DELETE(����) -> SELECT
-- ���� Ʈ����ǿ� ��ϵ� ��� �۾��� ������ �Ϸ�....
-- ���� Ʈ������� ��� �۾��� �ٽ� �ǵ����� ���ο� Ʈ������� �����Ѵ�. 
ROLLBACK;

DELETE FROM ����� WHERE name = 'ȫ�浿';

SELECT*FROM �����;

ROLLBACK;

DELETE FROM ����� WHERE name = 'ȫ�浿';
SELECT * FROM �����;

-- ���� Ʈ������� ��� ������ DB�� �����Ű�� Ʈ����� �Ϸ� + �� Ʈ����� ���� 
COMMIT; 

ROLLBACK;
SELECT*FROM �����;

--Ŭ���̾�Ʈ �� 
-- -> Auto Commit : ���� �۾� 
-- ����� -> ����? commit or rollback

DELETE FROM ����� WHERE name = '�Ѽ���'
SELECT*FROM �����; 

/*
�� Ʈ������� ���� �����ϴ� ���(******)
1. Ŭ���̾�Ʈ�� ���� �� �� 
2. COMMIT ���� �� ��
3. ROLLBACK���� �� ��  
4. DDL, DCL ���� �� �� 

���� Ʈ������� ����Ǵ� ���(*******)
1. Ŭ���̾�Ʈ ���� ���� 
2. COMMIT ���� �� ��
3. ROLLBACK ���� �� �� 
4. DDL, DCL���� �� �� (�ڵ� COMMIT)

�ڵ� Ŀ��, Auto  Commit
- Ŭ���̾�Ʈ ���� ����� �ƴ�;;
- ����ڰ�(���� �������� ���ǿ��� ���������� COMMIT�� �������� �ʾƵ� �ڵ����� COMMIT�� ����Ǵ� ��Ȳ
- DDL, DCL�� ������ �� ����� �𸣰� �ڵ����� COMMIT�� �߻��Ѵ�. 
        (CREATE, ALTER, DROP, TRUNCATE..) -> ������ �����ϴ� �ൿ
*/

COMMIT;
SELECT*FROM �����;

DELETE*FROM ����� WHERE name = '�踻��';
DELETE*FROM ����� WHERE name = '�Ѽ���';

CREATE TABLE tbltemp2(seq NUMBER);

DELETE*FROM ����� WHERE name = '������';

ROLLBACK;




--SAVEPOINT
COMMIT;
SAVEPOINT a;
DELETE FROM ����� WHERE name = '������';
SAVEPOINT b;
DELETE FROM ����� WHERE name = '���μ�';
SAVEPOINT c;
DELETE FROM ����� WHERE name = '�迵��';

ROLLBACK;
ROLLBACK TO c;
ROLLBACK TO b;
COMMIT
SELECT*FROM �����;




