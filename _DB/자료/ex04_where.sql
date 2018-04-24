-- ex04_where.sql

/*
WHERE��
-SELECT �÷�����Ʈ FROM ���̺�� WHERE��
- ����ڰ� �����ͺ��̽� �����͸� ������ �� �׻� ��� �����͸� �������� �ʴ´�.
- ������ ������ �ؼ� �Ϻ� ���ڵ常 �������� �Ѵ�. -> ������
- ��, ������ �Ǵ��ϴ� ������� ��� -> �񱳿�����&��������

-WHERE ���� ���͸�
-SELECT ���� ���͸�



1.SELECT -3
2.FROM -1
3.WHERE -2
*/

SELECT*FROM tblname WHERE weight > 70;
SELECT*FROM tblname WHERE weight >= 70 and weight <=90;
SELECT first, last FROM tblname WHERE weight >= 70 and weight <=90;

--��ȣ

SELECT*FROM tblname WHERE last ='��';
SELECT*FROM tblname WHERE height = 184;
SELECT*FROM tblinsa; WHERE ibsadate = '98/10/11';
SELECT*FROM tblinsa; WHERE ibsadate = '1998-10-11'; --����

-- ����Ŭ�� ���ڿ� ����� ��¥������ �ڵ� ����ȯ�� �����ش�.
-- �ú��ʰ� ��������� ����ȯ �Ұ��� -> �Լ� �۾�
SELECT*FROM tbltodo WHERE adddate = '2018-01-01 06:00:00';
SELECT*FROM tbltodo WHERE adddate = '2018-01-01'; --00:00:00 �츮 ��ſ� �ú��� �ڸ��� ������ �־��� -> 0�� 0�� 0��  

--�� ����
SELECT*FROM tblname WHERE height >= 170;

SELECT*FROM tblname WHERE 1 = 1; -- ������ �׶�� �ϴ� ���� 
SELECT*FROM tblname WHERE 1 > 0;

SELECT*FROM tblname WHERE weight / height*height >20; --����, �Լ��� ����� WHERE ���� �� �� ����
SELECT name,lenght(name) FROM tblcountry WHERE length(name) >=3;

-- �� ���꿡 ���Ǵ� �ڷ���
--1. ������
--2. ������ if("ȫ�浿">"�ƹ���")->if("ȫ�浿".compareTo("�ƹ���")>0)   --����Ŭ������ ������������ �񱳿����� �� �� ���� 
--3. ��¥ �ð��� if(c1 > c2) -> tick    --��¥�������� �� ���� 


SELECT*FROM tblname WHERE weight > 70;
SELECT*FROM tblname WHERE first > '��';
SELECT*FROM employees WHERE first_name < 'D';
SELECT*FROM tblinsa WHERE ibsadate >= '2000-01-01';





/*
between 
- where������ ���(�������� ���)
- ���� ���� ����
- �÷��� between �ּҰ� and �ִ밪
- ������ ���
- �ּ� �ִ밪 ��� ���� (inclusive)
*/

SELECT*FROM tblname;
    WHERE weight >= 70 and weight <=90;
    
SELECT*FROM tblname
    WHERE weight BETWEEN 64 AND 90;
    
SELECT*FROM employees
    WHERE last_name BETWEEN 'D' AND 'F';
    
SELECT*FROM tblinsa
    WHERE ibsadate BETWEEN '1999-01-01' AND '2000-12-31';
    
- between�� ��� ���� > ��(��) �����ڸ� ����ϴ°� �ӵ��� �� ���� 

/*
in 
-WHERE������ ���(�������� ���)
-������ ���� �� (���õ� �� �߿��� �ϳ��� �����ϸ� true)\
-�÷��� in(������ ��)

*/

SELECT*FROM tblcountry;
    WHERE continent = 'AS' or continent = 'EU'
    
SELECT*FROM tblcountry
    WHERE continent IN ('AS','EU');

SELECT*FROM tblinsa
    --WHERE buseo = '��ȹ��';
    WHERE buseo = '��ȹ��' buseo = '������' or buseo = '�ѹ���';\
    WHERE buseo IN('��ȹ��','������','�ѹ���');
        AND jikwi IN('����','����')AND city IN ('����', '��õ');
        AND basicpay BETWEEN 2500000 AND 3000000;
        
        
        
/*
like
- WHERE ������ ���(�������� ���)
- ���� ����(Ư���� ������ ������ ���ڿ� �˻�)
- �÷��� like '���� ���ڿ�'
- �������� ������� �˻� 

���� ���ڿ� ���� ���
1. _ : ������ ���� 1��
2. % : ������ ���� 0�� ~ ���Ѵ�
*/        
        
SELECT name FROM tblinsa
    --WHERE name like '��__';
    WHERE name like '��%';--���ڼ��� Ư������ �� ������ 
    
SELECT*FROM employees
    --WHERE first_name like 'N____';
    --WHERE first_name like 'N%';
    --WHERE first_name like '__n_e';
    --WHERE first_name like 'N%e'
    --WHERE first_name like '%e';
    --WHERE first_name like '%te';
    WHERE first_name like '%an%';
    
SELECT*FROM ���̹�
    --WHERE subject = '�ڹ�';
    --WHERE subject like '�ڹ�%';
    -- WHERE subject like '%�ڹ�%';
    WHERE subject like '%�ڹ�%����%'
        OR subject like '%����%�ڹ�%'
        OR subject like '%����%'
        OR subject like '%�ڹ�%';
    
    
SELECT*FROM tblinsa;
    WHERE ssn like '______-1_____';
    WHERE tel like '019-____-____';
        

/*
null���� 
- where������ ���
- null �ǿ����ڷ� ��� �Ұ� -> ���ǿ��� ��� �Ұ�
- �÷��� is null(�÷��� == null)


*/
-- �α����� �̱����� ����? 
SELECT*FROM tblcountry
    --WHERE population = NULL; 
        -->����� �ȳ��� ����Ŭ�� �ǿ����ڷ� NULL�� ����� �� ���� 
    WHERE population IS NULL;
    
-- tblinsa ����ó �̱��� ����?
SELECT*FROM tblinsa
    WHERE*FROM tblinsa WHERE tel IS NULL;

-- �α����� ����� ����
SELECT *FROM tblcountry
    WHERE population IS NOT NULL;

WHERE*FROM tblinsa WHERE tel IS NOT NULL;
SELECT*FROM tblinsa WHERE NOT tel IS NULL;

SELECT*FROM tblinsa WHERE city IN ('����','��õ','�λ�');
SELECT*FROM tblinsa WHERE NOT city IN ('����','��õ','�λ�');
SELECT*FROM tblinsa WHERE NOT name like '��%';

--completedate : ���� �Ϸ� �ð�
-- ���� ���� �Ϸ� ���Ѱ͵鸸 ��������
SELECT*FROM tbltodo WHERE completedate IS NULL;
SELECT*FROM tbltodo WHERE completedate IS NOT NULL;

-- ������ �뿩 ���̺� 
-- �뿩��, �ݳ���

SELECT*FROM �뿩���̺� WHERE �ݳ��� IS NULL; --���� �뿩���� ���

/*
distinct
- �÷�����Ʈ���� ���
- distinct �÷���
- �ߺ��� ����
- NULL�� �������� �� ������ �ν��Ѵ�. 
        -> NULL�� ������ ���ڵ�鵵 �ߺ��� �����Ŀ� 1�� ��ȯ
- ���� �÷��� ������� distinct ���
*/

--���� ���̺� ����� ���� �ִ���?
SELECT continent FROM tblcountry;
SELECT DISTINCT continent FROM tblcountry;

--���� ���� �ִ���?
SELECT gender FROM tblname;
SELECT DISTINCT gender FROM tblname;

-- tblinsa ������ ��͵��� �ִ���?
SELECT DISTINCT jikwi FROM tblinsa;

SELECT DISTINCT last FROM tblname;
SELECT DISTINCT first FROM tblname;

SELECT DISTINCT population FROM tblcountry
    WHERE population IS NOT NULL ;
    
    
    
    
-- ���� ���� ���̺�
DROP TABLE tblmen;
DROP TABLE tblwomen;


CREATE TABLE tblmen
(
	name varchar2(30) primary key,
	age number not null,
	height number null,
	weight number null,	
	couple varchar2(30) null
);

CREATE TABLE tblwomen
(
	name varchar2(30) primary key,
	age number not null,
	height number null,
	weight number null,
	couple varchar2(30) null
);


INSERT INTO tblmen VALUES ('ȫ�浿', 25, 180, 70, '�嵵��');
INSERT INTO tblmen VALUES ('�ƹ���', 22, 175, NULL, '�̼���');
INSERT INTO tblmen VALUES ('������', 27, NULL, 80, NULL);
INSERT INTO tblmen VALUES ('����', 21, 177, 72, NULL);
INSERT INTO tblmen VALUES ('���缮', 29, NULL, NULL, '���');
INSERT INTO tblmen VALUES ('�ڸ��', 30, 170, NULL, '������');
INSERT INTO tblmen VALUES ('������', 31, 183, NULL, '�ź���');
INSERT INTO tblmen VALUES ('������', 28, NULL, 92, NULL);
INSERT INTO tblmen VALUES ('�缼��', 22, 166, 55, '��ΰ�');
INSERT INTO tblmen VALUES ('����ȣ', 24, 165, 58, '������');

INSERT INTO tblwomen VALUES ('�ڳ���', 23, 150, 55, NULL);
INSERT INTO tblwomen VALUES ('�嵵��', 28, 177, 65, 'ȫ�浿');
INSERT INTO tblwomen VALUES ('������', 30, 160, NULL, '�ڸ��');
INSERT INTO tblwomen VALUES ('���', 34, 158, NULL, '���缮');
INSERT INTO tblwomen VALUES ('������', 27, NULL, NULL, '����ȣ');
INSERT INTO tblwomen VALUES ('��ΰ�', 22, 169, 88, '�缼��');
INSERT INTO tblwomen VALUES ('ȫ����', 20, 158, 75, NULL);
INSERT INTO tblwomen VALUES ('�ź���', 26, 170, 60, '������');
INSERT INTO tblwomen VALUES ('�̼���', 28, 163, NULL, '�ƹ���');
INSERT INTO tblwomen VALUES ('�ź���', 27, 162, NULL, NULL);


COMMIT;

SELECT*FROM tblmen;
SELECT*FROM tblwomen;

SELECT*FROM tblmen WHERE couple IS NULL; --�ַ�
SELECT*FROM tblWOmen WHERE couple IS NULL; --�ַ�

--distinct�� �����÷����� ������ �� �ִ�.
SELECT DISTINCT price FROM tblhousekeeping;
SELECT DISTINCT price,qty FROM tblhousekeeping; --DISTINCT�� ��� �÷��Ͻ�Ʈ���� �տ� ��ġ�ؾ� �Ѵ�.
SELECT price, DISTINCT qyt FROM tblhousekeeping;


/*
case
- �÷� ����Ʈ�� ���
- ���������� ���
- �ڹٿ����� case���� ���� 
*/

SELECT last || last as name, 
    case 
        when gender = 'm' then '����'
        when gender = 'f' then '����'
    end AS gender  
FROM tblname;

SELECT name, case when continent ='AS' then '�ƽþ�' when continent ='EU' then '����' end FROM tblcountry;
SELECT name, 
    CASE
        WHEN continent ='AS' then '�ƽþ�' 
        WHEN continent ='EU' then '����' 
        ELSE '��Ÿ'
    END 
FROM tblcountry;
--�̹��� �޿� -> ����(����)�� sudang x 2�� ����
SELECT name, basicpay, sudang,
    CASE
        WHEN jikwi = '����' THEN sudang*2
        WHEN jikwi = '����' THEN sudang*2
        WHEN jikwi = '�븮' THEN sudang*2
        ELSE sudang 
    END
, jikwi FROM tblinsa;

SELECT name, basicpay,
    CASE
        WHEN basicpay >= 2000000 THEN '��׿���'
        WHEN basicpay >= 1000000 THEN '�Ϲݿ���
        ELSE '���׿���'
    END 
FROM tblinsa;


SELECT namel,weight, couple,
    CASE 
        WHEN weight >90 THEN '��ü��'
        WHEN weight > 60 THEN '����ü��'
        WHEN weight >0 THEN '��ü��'
        ELSE '����'    
    END as ü�߻���,
    CASE 
        WHEN couple IS NOT NULL THEN '����ģ�� ����'
        WHEN couple IS NULL THEN '�ַ�'
    END AS ���ֻ���
FROM tblmen;


SELECT title 
    CASE
        WHEN completedate IS NULL THEN '������..'
        WHEN completedate IS NOT NULL THEN '�Ϸ�'
    END
FROM tbltodo;

/*
1. SELECT
2. FROM
3. WHERE
4. ORDER BY

����, Sorting 
- ������� ���ڵ��� ������ ���� (�������̺���� ����)
- ���� ���̺� ���ڵ� ������ DBMS�� �˾Ƽ� �� 
- ORDER BY �÷���[ASC|DESC]
    - ORDER BY �÷��� ASC//Ascending��������
    - ORDER BY �÷��� DESC//Descending��������
    - ORDER BY �÷���
*/

- -ASC
    --10-> 20 -> 30
    --'��'->'��'->'��'
    --'2016' -> '2017' -> '2019'
SELECT * FROM tblinsa
 -- ORDER BY name ASC;
 -- ORDER BY ibsadate DESC;
 -- ORDER BY basicpay DESC;
ORDER BY basicpay + sudang DESC;
ORDER BY buseo ASC,jikwi ASC, basicpay DESC; --�������� 

--�ֱ� �Ϸ��� ���Ϻ��� �������ÿ�.
SELECT*FROM tbltodo ORDER BY COMPLETEDATE DESC;
--���� ��� NULL�� ���ԵǾ� ������ �Ϲ������� ���� �����Ѵ�.(���� �񱳰� �Ұ����ϱ� ������...)
--���� NULL�� ���ԵǴ� �����̶��..-> NULL�� ��ġ��? -> DBMS�� ���� �ٸ���. 
SELECT*FROM tbltodo
    WHERE completedate IS NOT NULL
        ORDER BY completedate DESC;

/*
1. SELECT -3
2. FROM -1
3. WHERE -2
4. ORDER BY -4
*/

SELECT last || first as name 
FROM tblname
--WHERE name = '���缮';
WHERE last || first = '���缮';
ORDER BY name DESC ;
ORDER BY last || first ASC;




