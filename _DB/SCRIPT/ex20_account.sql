/*
ex20_account.sql
����� ���� SQL
- DCL�Ϻ�
- ���� ����(�Ҹ�)
- ���ҽ� ���� ���� ���� 


����� ���� �����ϱ�
1. �ý��� ������ ������ �ִ� ������ �����ϴ�.
- �����ڱ� ����(sys, system-java1234)
- ���� ������ �� �ִ� ���Ѹ� ���� 

*/

--�ý��� �������� ���� ��.....
-- �� ���� �����ϱ�
-- CREATE USER ������ IDENTIFIED BY ��ȣ;
-- ALTER USER ������ IDENTIFIED BY ��ȣ;
-- DROP USER ������;

CREATE USER team IDENTIFIED BY java1234;

--���� ���� �Ҵ��ϱ� 
--GRANT ���� TO ������;
GRANT CREATE SESSION TO team; -- ���� 1��  
GRANT CREATE TABLE TO team; -- ���� 2��
GRANT CREATE VIEW TO team; -- ���� 1�� 
GRANT RESOURCE to team; -- ROLE �ο� (������ ����)

SELECT *FROM tabs;

CREATE table tbltemp
(
        seq number primary key,
        data varchar2(100) not null
);



/*
������ �ý��� ���� 
1. CREATE USER :���� ���� ����
2. DROP USER : ���� ���� ����
3. DROP ANY TABLE : ���� ���̺��� ���������� ������ ������. (Ȥ�� DROP ANY TABLE ������ ���� �����ڱ�)


����� �ý��� ���� 
1. CREATE SESSION : DB ���� ����
2. CREATE TABLE : ���̺� ���� ����
3. CREATE VIEW : �� ���� ����
4. CREATE SEQUENCE : ������ ���� ����
5. CREATE PROCCEDURE : ���ν��� ���� ����

..140������.. 

*/

--��ü���� �ο��ϱ�
-- : ���̺�, ��, ������ � ���ؼ� ��ü���� DML�� ����� �� �ִ� ���� 
-- : GRANT OBJECT_PRIVILEAGE ON ���ü TO ������

--HR ���� ���̺��� team �������� �б� ���� �ο��ϱ� 
-- : �� �۾��� ������ ���� (������, HR)
GRANT SELECT 
        ON hr.tblinsa
                TO team;

--���� ���� 
-- : REVOKE OBJECT_PRIVILEAGE ON ���ü TO ������;
REVOKE SELECT
        ON hr.tblinsa
                FROM team;

/*
���� , ROLE

- ����ڿ��� ���������� ������ �ѹ��� �ֱ� ���� ���� �׷�
���� ����ϴ�  ����

1.CONNECT
- ����ڰ� DB���� + �ൿ �⺻���� ���� ���� 

2.RESOURCE
- ����ڰ� ��ü�� �����ϰų� �����ϴ� ���� ����

3. DBA

*/


-- ������Ʈ �۾� �� 
--1. ���� ���� 
CREATE USER team IDENTIFIED BY java1234;

--2. role �߰�
GRANT connext to team;
GRANT resource to team;

-- 3. �߰�
-- GRANT CREATE VIEW to team;




















