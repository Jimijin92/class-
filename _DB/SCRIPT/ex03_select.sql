--ex03_select.sql


/*

SELECT ��
1. ���̺�κ��� ���ϴ� �����͸� �������� ��ɾ�
    :Ŭ���̾�Ʈ -> (SELECT �䫊) -> ���� -> (ǥ ���·� ��ȯ, ResultSet, ResultTable)
    
2. ���̺��� �ƴѰ����κ��� �����͸� �������� ��ɾ� 


*** SQL�� �Ϲ������� 1��(2��) �̻��� ��(��)�� ���յǾ� ������ �����.

SELECT ����

SELECT �÷�����Ʈ FROM ���̺��;
SELECT �÷�����Ʈ FROM ���̺�� WHERE��;
SELECT �÷�����Ʈ FROM ���̺�� WHERE�� ODER BY��;
SELECT �÷�����Ʈ FROM ���̺�� WHERE�� GROUP BY�� ODER BY��;
SELECT �÷�����Ʈ FROM ���̺�� WHERE�� GROUP BY�� HAVING�� ODER BY��;
SELECT �÷�����Ʈ FROM ���̺�� [WHERE��] BY�� [HAVING��] [ODER BY��];

1. SELECT �÷�����Ʈ
    : ������ �÷��� �����Ѵ�.
FROM ���̺��;
    : ������ ���̺��� �����Ѵ�.
    
    
    
*/
DESC tbltype;

SELECT txt1
FROM tbltype;

SELECT*FROM tabs;

SELECT*FROM TBLNAME;
DESC tblname;


--tblname�κ��� �̸�(first)�� �������ÿ�.
SELECT first FROM tblname;
SELECT gender FROM tblname;
SELECT tel FROM tblname; --ORA-00904: "TEL": invalid identifier --�����ڵ� ã�� �� ���ڷ� ã��

-- �� + �̸�
SELECT first, last FROM tblname;
SELECT last, first FROM tblname;
SELECT last, first, nick FROM tblname;

--1�� ����, 1������ ���� ���̼���. 
SELECT last, first, nick, gender, weight, height FROM tblname;  --1��
SELECT*FROM tblname; --2��

--�÷�����Ʈ���� ������ �÷��� 1�� �̻� �� �� �ִ�. 
SELECT nick FROM tblname;
SELECT nick, nick FROM tblname;
SELECT nick, length(nick) FROM tblname;
SELECT nick, nick, nick FROM tblname;



--SELECT first
--FROM tblname;

--SELECT first
--FROM tblname;

--SELECT 
--    first
--FROM 
--    tblname;

SELECT*FROM tblcountry;
SELECT*FROM tbldiary;
SELECT*FROM tblhousekeeping;
SELECT*FROM tblinsa;
SELECT*FROM tblmen;
SELECT*FROM tblwomen;
SELECT*FROM tbltodo;

/*
����Ŭ ��� ǥ��
1. ������
    a. ������
        ex) 10
    b. �Ǽ���
        ex) 3.14
        
2. ����(���ڿ�)��
    ex)'��', 'ȫ�浿'
    
3. ��¥�� ���
    ex) '2018-01-12' : ������ ��� -> (����ȯ) -> ��¥�� : ���ƿ� ���� �޶��� (��¥ or ����)
    ex) '100'
    ex) '2018�� 01�� 12��' --X(���� ǥ�� ����)
    ex) '2018-01-12','2018/01/12'       
*/

--�÷����� ����
--SELECT�� ����� �÷������� �����ϰ� ��ȯ���� �� �ְ�, Ȥ�� �����̳� �Լ��� �Ű������� ����� �� �ִ�. 
--Ȥ�� �����̳� �Լ��� �Ű������� ����� �� �ִ�.
--SELECT name, basicpay FROM tblinsa;
SELECT name, basicpay, basicpay*1.1 FROM tblinsa;

SELECT last, first, weight, weight+3 FROM tblname;

SELECT name, length(name) FROM tblcountry;

--BMI
SELECT last, first, weight/height*height FROM tblname;

--���ڿ� ���ϱ�
SELECT last, first, last + first FROM tblname;
SELECT last, first, last || first FROM tblname;

SELECT last, last FROM tblname;

--������� �÷����� �ٲٱ�
-- : ��Ī(Alias) �����ϱ� 
-- : �̸� �ٲٱ�(***������ �ٲ�� ���� �ƴ�)
-- : �÷��� as ����

SELECT last, last, last || first AS FROM tblname;
SELECT last as ��, last as �̸�, last || first AS ��ü�̸� FROM tblname; --�ĺ��ڿ� ��������, Ư����������, ���ڽ��� �ȵ�

SELECT last as ��, last as �̸�, last || first AS "��ü �̸�" FROM tblname;  --�ĺ��� ���̿� ����־ ������� ���� �� 
SELECT ��, �̸�, "��ü�̸�" FROM ���� ���̺�;

SELECT weight AS "from" FROM tblname; --������ ���� �̸��� �ĺ��ڷ� ����ϰ� ���� ��  

-- ��ü ǥ���
SELECT * FROM tblname;
SELECT * FROM hr.tblname;

SELECT hr.tblname.first, hr.tblname.last FROM hr.tblname;

SELECT hr.tblname.first, hr.tblname.last FROM hr.tblname;

SELECT n.first, n.last FROM tblname n; --���̺� ��Ī
SELECT first, last FROM tblname n; --���̺� ��Ī

SELECT *, weight+100 FROM tblname; -- �� ��� �ݵ�� �տ� ���̺� �÷����� ����� �Ѵ�.
SELECT tblname.*,weight+100 FROM tblname; -- �� ��� �ݵ�� �տ� ���̺� �÷����� ����� �Ѵ�.
SELECT n.*, weight+100 FROM tblname n;

/*
    SQL ��(��)�� ���� ���� (�켱 ����) --�ϱ��ϱ�
    
    1. SELECT �� - 2��
    2. FROM�� - 1��
    
*/

--SELECT last, first 
--FROM tblname;
--
--SELECT FIRST
--FROM tblname;
--
--SELECT first, last FROM tblname;


--�ý��� ���̺�
--1. tabs
-- : �ش� ������ �ҟ��ϰ� �ִ� ���̺� ���
-- 2. dual
-- : ���� ���̺�
-- : ���̺� ��ü�� �ǹ̰� ����;

-- sysdate : Calendar.getInstance();

SELECT sysdate FROM dual; --X

SELECT first, sysdate FROM tblname; --����Ŭ�� �Ű����� ������ ()���ص� �� 
SELECT 100* 2 FROM dual;

/*
������

1. ���������
    - +, -, *, /
    - ������ �����ڰ� ���� -> �Լ��� ����(mod())
    
2. �񱳿����� 
    - >, >=, <, <=
    - =(==), <>(!=)
3. �������� 
    - and(&&), or(||), not(!)
    
4. ���ڿ� ������
    - ||(concat)
    
5. SQL ������
    - Java : instanceof, typeof...
    - in, between, like, is, any, all ��...
    */

SELECT 10>5 FROM dual;

SELECT '����' FROM dual WHERE 10>5;

-- NULL
-- : �ڹ��� NULL�� ������ ǥ�� 
-- : SQL���� NULL�� ������ ����� �� �� ����.(�ǿ����� �ڰ�X)
-- : SQL�� NULL�� ���Ե� ������ �ϰ� �Ǹ� ������ NULL�� ��ȯ


SELECT 10 + NULL FROM dual;
SELECT NULL*300 FROM dual;
SELECT 10 / NULL FROM dual;
SELECT NULL - 20 NULL FROM dual;




