/*
ex05_function.sql

����Ŭ �Լ�
- ������ ��� -> �Լ����·� ����

���� �Լ�, ��� �Լ�, ���� �Լ�, ���� �Լ� 
-> ���� ����� ����� ����. 
-> ������ ���� �Է¹޾� ���� ���� ��ȯ�Ѵ�. 

1. count() : ����
2. sum() : ����
3. avg() : ���
4. max() : �ִ밪
5. min() : �ּҰ�

*/


/*
1. count()
- number count(�÷���) ***
- number count(�����)
- number count(���)
- �ش� �÷����� ������ �ִ� ���ڵ��� ���� ��ȯ(�� ���� ��ȯ)
*/

SELECT count(*) FROM tblname;
SELECT count(*) FROM tblinsa;
SELECT count(*) FROM employees;

SELECT count(name) FROM tblinsa;
SELECT count(tel) FROM tblinsa; --tel�� NULL�� ������ ���ڵ尡 3�� ���� 

SELECT count(*) FROM tbltodo; --��� ������ ����
SELECT count(completedate) FROM tbltodo; --�Ϸ��� ���� ���� 

-- ���� �ؾ��� ���� ����??
SELECT count(*) - count(completedate) FROM tbltodo;
SELECT count(*) FROM tbltodo WHERE completedate IS NULL ;
SELECT count(*) FROM tbltodo; --���߿� �ϳ��� ������ �ϳ��� ������ �� ���ڵ�μ��� ���簡ġ ������ 

-- tblinsa
-- ���� ��� ������ ���?
SELECT * FROM tblinsa WHERE city ='����';
SELECT count(*) FROM tblinsa WHERE city ='����';

-- �󿩱� -> 1000000000�� 
-- 1/N 
SELECT count(*) FROM tblinsa;
SELECT 1000000000 / 60 FROM tblinsa; --�̰ź���
SELECT 1000000000 / count(*) FROM tblinsa; --�̰Գ���

SELECT buseo FROM tblinsa;
-- ���� ȸ�翡�� � �μ���? 
SELECT DISTINCT buseo FROM tblinsa;
-- ���� ȸ�翡�� �μ��� �� �? 
SELECT count (DISTINCT buseo) FROM tblinsa;

-- ���� �Լ� ���� ������ ��!!!
-- 1. �����Լ��� ����� �Ϲ� �÷��� �Բ� �÷� ����Ʈ�� ���� �� ����. 
-- ORA-00937: not a single-group group function --�����޼���
-- 2. �����Լ��� ����� WHERE������ ����� �� ����.
-- ORA-00934: group function is not allowed here
SELECT name, count(jikwi) FROM tblinsa; --������

SELECT name FROM tblinsa;
SELECT count(*) FROM tblinsa;

SELECT avg(basicpay)FROM tblinsa;
SELECT * FROM tblinsa WHERE basicpay >= avg(basicpay); --������ 

/*
2. sum()
- number sum(�÷���)
- �ش� �÷����� ������ ��ȯ
- �����÷����� �������.. 
*/

SELECT sum(height) FROM tblname;
SELECT sum(nick) FROM tblname; -->���ڰ� �ƴϹǷ� ����
SELECT sum(*) FROM tblname;  --> ���ڰ� �ƴ� �÷� ������ �� �����Ƿ� ���� (all�� count���� ����)

SELECT sum(weight), sum(weight + 10), sum(weight)+10 FROM tblinsa;
SELECT sum(sudang * 2) FROM tblinsa;

-- ��� �޿� 
SELECT �޿���/������ FROM tblinsa;
SELECT sum(basicpay + sudang) / count(*) FROM tblinsa;
SELECT avg(basicpay + sudang) / FROM tblinsa;

/*
3.avg()
- number avg(�÷���)
- ���� �÷��� �������...
*/

SELECT population FROM TBLCOUNTRY;--NULL�� ���Ե� �÷�
SELECT sum(population) FROM tblcountry;

SELECT sum(population) / count(*) FROM tblcountry; --14475 --count(*)���� NULL���� ���ԵǾ� ����
SELECT sum(population) / count(population) FROM tblcountry; --15588
SELECT avg(population) FROM tblcountry; --15588

SELECT 10��/��ü���� from ���;// count(*)
SELECT 10��/�������� from ���;// count(������Ʈ)

--���δ�� avg�������� ��Ȯ�� � �ǵ��� avg���� �ľ��ϰ� ����ϱ�(NULL �� ����ϱ�)

SELECT avg(ibsadate) FROM tblinsa; 

/*
4. max()
5. min()
- object max(�÷���)
- object min(�÷���)
- �ش� �÷��� ���� ū �� or ������ ��ȯ
- ����, ����, ��¥ ��� ��� ����
*/
SELECT basicpay FROM tblinsa;
SELECT avg(basicpay) FROM tblinsa; --1556526
SELECT max(basicpay) FROM tblinsa; -- 2650000
SELECT min(basicpay) FROM tblinsa; --840000

-- max�� basicpay�޴� ����� �̸��� �˰�ʹٸ�?

SELECT name FROM tblinsa WHERE basicpay = 2650000;
SELECT name FROM tblinsa WHERE basicpay = max(basicpay); --����(�����Լ��� where������ �� �� ����.)

SELECT 
    count(*) as "�� ������",
    sum(basicpay) as "�� �޿���",
    avg(basicpay) as "��� �޿�",
    max(basicpay) as "�ִ� �޿�",
    min(basicpay) as "�ּ� �޿�",
    max(basicpay) - avg(basicpay),
    avg(basicpay) -min(basicpay)
FROM tblinsa;




/*
���� ���� �Լ�(�����Լ�)

1.round()
- �ݿø�
- number round(�÷���)
- number round(�÷���, �ڸ���)
*/

SELECT 3.14, round(3.14) FROM dual;
SELECT 3.56, round(3.56) FROM dual;

SELECT round(avg(basicpay)) FROM tblinsa;
SELECT round(avg(basicpay), 2) FROM tblinsa;
SELECT round(avg(basicpay), 0) FROM tblinsa;

/*
2. floor(), trunc()
- ���� �Լ�
- ������ ���� �Լ� 
- number floor(�÷���)
- number trunc(�÷�,[�ڸ���])
*/

SELECT 123.4567 FROM dual;
SELECT floor(123.4567) FROM dual;
SELECT floor(123.9567) FROM dual;

SELECT trunc(123.9567) FROM dual;
SELECT trunc(123.9567,1) FROM dual;

/*
3.ceil()
- ������ �ø� �Լ� 
- number ceil(�÷���)
*/
SELECT 123.4567 FROM dual;
SELECT ceil(123.4567) FROM dual;
SELECT ceil(123.000000000001) FROM dual;

/*
4. mod()
- ������ �Լ�
- number mod(������, ����)
*/

SELECT mod(10,3) FROM dual;

--100�� -> ��ð� ���?
SELECT floor(100 / 60) as "��", mod(100 / 60) as "��" FROM dual;

/*
���ڿ� �Լ�
1. upper(), lower(), initcap()
- varchar2 upper(�÷���)
*/

SELECT
    'studentName'
    upper('studentName'),
    lower('studentName'),
    initcap('studentName')
FROM dual;

SELECT*FROM employees
    --WHERE first_name like '%an%';
    --WHERE lower(first_name) like '%' || lower ('An')|| '%';
    --WHERE lower(first_name) like lower('%An%'); --�������� �ʴ� ��� 
    --WHERE upper(first_name) = upper('Diana'); --upper�� lower�� ���� 
    

/*
2. substr
- �ڹ� : substring
- ���ڿ� ����
- varchar2 substr(�÷���, ������ġ, ����)
- varchar2 substr(�÷���, ������ġ) : ������
- SQL�� ������ 1���� �����Ѵ�.
*/

SELECT '�����ٶ󸶹ٻ������īŸ����' FROM dual;
SELECT substr('�����ٶ󸶹ٻ������īŸ����', 3, 5) FROM dual;
SELECT substr('�����ٶ󸶹ٻ������īŸ����', 3) FROM dual;

SELECT name, substr(name, 1, 1) as "��", substr(name, 2) as "�̸�" FROM tblinsa;
SELECT 
    name, 
    '19' || substr(ssn, 1, 2) as "���"
    substr(ssn, 3, 2) as "����",
    CASE
        WHEN substr(ssn, 8, 1) = '1' THEN '����'
        WHEN substr(ssn, 8, 1) = '2' THEN '����'   
    END as "����",
    CASE    
        WHEN substr(ssn, 3, 2) >= 3 and substr(ssn, 3, 2) <= 6 THEN '��'
        WHEN substr(ssn, 3, 2) >= 6 and substr(ssn, 3, 2) <= 8 THEN '����'
        WHEN substr(ssn, 3, 2) >= 9  and substr(ssn, 3, 2) <= 11 THEN '����'
        ELSE '�ܿ�'
    END as "����"
    
FROM tblinsa;
--WHERE ; ssn like '______-1______';
--WHERE ssn like '%1%';
--WHERE substr(ssn, 8, 1) = '2';
--WHERE substr(ssn, 8, 1) = '2' of substr(ssn, 8, 1) = '4';
--WHERE substr(ssn, 8, 1) in ('2', '4', '6', '8', 'O'); --����
WHERE mod(substr(ssn, 8, 1), 2) = O;

-- ���� �Լ�
-- : �÷�����Ʈ O, where�� X 
-- �����Լ�, ���ڿ� �Լ�
-- : �÷�����Ʈ O, where�� O, order by �� O

--�¾ ��¥������ ���� 
SELECT *FROM tblinsa
    ORDER BY substr(ssn, 5, 2) ASC;
    
/*
3. length()
- ���ڿ� ����
- number length(�÷���)
*/

SELECT first_name, lenght(first_name)                       --3
    FROM employees                                           --1
        WHERE length(first_name)>=5;                      --2
            ORDER BY length(first_name) DESC;            --4
            
            
            
/*
4. instr()
- indexOf()
- �˻����� ��ġ�� ��ȯ�ϴ� �Լ�
- number instr(�÷���, �˻���)
- number instr(�÷���, �˻���, ������ġ)
*/
SELECT '�ȳ��ϼ���. ȫ�浿��.' FROM dual;
SELECT instr('�ȳ��ϼ���. ȫ�浿��', 'ȫ�浿') FROM dual; --8
SELECT instr('�ȳ��ϼ���. ȫ�浿��', '�ƹ���') FROM dual; --0
SELECT instr('�ȳ��ϼ���. ȫ�浿��', '�ƹ���') > 0 FROM dual; -- ������, �ڹ�ó�� �������� ���� 

SELECT*FROM employees
    WHERE instr(first_name,'an') > 0; --first_name like '%an%'

/*
5. Ipad(), rpad()
- varchar2 Ipad(�÷�, ����, ����)
- varchar2 rpad(�÷�, ����, ����)
*/

SELECT first_name, lpad(first_name, 20, '��') FROM employees;
SELECT first_name, rpad(first_name, 20, '��') FROM employees;
SELECT first_name, lpad(first_name, 20, '-') FROM employees;

SELECT 
    item, 
    lpad(' ', qty+1, '��')
FROM tblhousekeeping;


/*
6. trim(), ltrim(), rtrim()
- varchar2 trim(�÷���)
*/

SELECT '     ȫ�浿      'FROM dual;
SELECT trim('     ȫ�浿      ') || '*' FROM dual;
SELECT ltrim('     ȫ�浿      ') || '*' FROM dual;
SELECT rtrim('     ȫ�浿      ') || '*' FROM dual;

-- char vs varchar2 �� 
DROP TABLE tbltemp;

CREATE TABLE tbltemp
(
    name1 char(50) not null,
    name2 varchar2(50) not null,
    age number not null
);

INSERT INTO tbltemp(name1, name2, age)  VALUES('ȫ�浿', 'ȫ�浿', 20);

COMMIT;

SELECT* FROM tbltemp WHERE name1 = 'ȫ�浿'; --char
SELECT* FROM tbltemp WHERE name2 = 'ȫ�浿'; --varchar2
SELECT* FROM tbltemp WHERE rtrim(name1) = name2; 
SELECT length(name1), length(name2) FROM tbltemp;

 /*   
-- char vs varchar2

1. char
- ���� �ڸ���
- ������ ��ȿ�������� ���
- ��� ���� �߻�
- �������� Ư���� ���� ���� ������ ���� ������ -> �ֹι�ȣ, �������, �̸�

2. varchar2
- ���� �ڸ���
- ������ ȿ�������� ���
- ��� ���� �߻�
- ���� �龦���� -> �ּ�, �۳��� 

3. ���
- ������ varchar2
*/



/*
7. replace()
- ���ڿ� ġȯ �Լ�
- varchar2 replace(�÷���, ã�� ���ڿ�, �ٲ� ���ڿ�)
*/

SELECT 'ȫ�浿', replace('ȫ�浿', 'ȫ', '��') FROM dual;

SELECT 
    last || first as name,
    gender,
    CASE
        WHEN gender = 'm' THEN '����'
        WHEN gender = 'f' THEN '����'
    END as gender2
    replace(replace(gender, 'm', '����'), 'f', '����')
    --replace(gender, 'f', '����')
FROM tblname; 

-- name.replace("m","����").replace("f","����")

SELECT 
        name, 
        replace(replace(substr(ssn, 8, 1),'1', '����'),'2','����') 
FROM tblinsa;


SELECT name, replace(replace(replace(replace(replace(continent, 'AS', '�ƽþ�'),'SA', '�Ƹ޸�ī'),'EU', '����'), 'AF', '������ī'), 'AU', '����Ʈ���ϸ���') as ��� FROM tblcountry;


/*
8. decode()
- ���ڿ� ġȯ �Լ�  
- replace()�� ����
- varchar2 decode(Į����, ã�� ���ڿ�, �ٲ� ���ڿ�[, ã�� ���ڿ�, �ٲ� ���ڿ�] x n)
- ġȯ �Ұ����̸� NULL��ȯ(***)
*/

SELECT
    name,
    decode(continent, 'AS', '�ƽþ�', 'EU', '����', 'SA', '�Ƹ޸�ī', 'AF', '������ī', 'AU', 'ȣ��') --decode�� ã���� ������ null�� �����ش�. (replace�� ����������)
FROM tblcountry;


--  �ѹ��� ����� ���?
SELECT count(*) FROM tblinsa WHERE buseo = '�ѹ���'; --7

-- ������ ����� ���?
SELECT count(*) FROM tblinsa WHERE buseo = '������'; --16

-- ��ȹ�� ����� ���?
SELECT count(*) FROM tblinsa WHERE buseo = 'ȫ����'; --6

/*
 ���� ��� 3���� ���ÿ� �������� �ʹ�.
 [�μ�]         [�ο���]
 �ѹ���            7
 ������           16
 ȫ����            6


[�ѹ���]       [������]       [ȫ����]
   7               16              6
*/

SELECT 
    count (decode(buseo, '�ѹ���', 1)) as �ѹ���, --�ڿ����� ġȯ���ڴ� �ƹ��ų� ������ �׳� 1�־����
    count (decode(buseo, '������', 1)) as ������,
    count (decode(buseo, 'ȫ����', 1)) as ȫ����
FROM tblinsa;


SELECT 
    decode(buseo, '�ѹ���', 1) as �ѹ���, --�ڿ����� ġȯ���ڴ� �ƹ��ų� ������ �׳� 1�־����
    decode(buseo, '������', 1) as ������,
    decode(buseo, 'ȫ����', 1) as ȫ����
FROM tblinsa;



SELECT
    count(decode(substr(ssn, 8, 1), '1', 1)) as ����,
    count(decode(substr(ssn, 8, 1), '2', 1)) as ����
FROM tblinsa;

SELECT 
    count(decode(substr(name, 1, 1), '��', 1)) as ��, 
    count(decode(substr(name, 1, 1), '��', 1)) as ��, 
    count(decode(substr(name, 1, 1), '��', 1)) as ��, 
    count(decode(substr(name, 1, 1), '��', 1)) as ��, 
    count(decode(substr(name, 1, 1), '��', 1)) as ��, 
FROM tblinsa;




/*
nvl
- null �Լ�, null value
- object nvl(�÷���, ��ü��)
- �ش� �÷��� null�̸� ��ü���� ��� ��ȯ
- ��ü���� �ݵ�� �ش��÷��� ������ �ڷ����� ���ؼ�...
*/

SELECT name, population FROM tblcountry;
SELECT name, nvl(population, 0) FROM tblcountry; --���ɽ����� ġȯ�ϱ� 

SELECT name, nvl(population, '�̱���') FROM tblcountry; --���ɽ����� ġȯ�ϱ� 

SELECT name, nvl(tel, '����ó ����') FROM tblinsa; --���ɽ����� ġȯ�ϱ� 







/*
��¥ �ð� �Լ�

1. sysdate
- ���� �ð� ��ȯ
- date sysdate
- Calendar.getInstance() ������
*/

SELECT sysdate FROM dual;

-- ��¥ ����
-- date + ���� : �ϴ��� ���� ���� 

-- �ð� + �ð�(��) = �ð�
SELECT sysdate + 1 FROM dual;
SELECT sysdate - 1 FROM dual;
SELECT name, ibsadate, ibsadate + 1000 FROM tblinsa;
SELECT ����, �뿩��, �뿩�� + 7 FROM �����뿩;

--�ð� - �ð� = �ð�
SELECT name, ibsadate FROM tblinsa;
SELECT name, ibsadate, sysdate - ibsadate as �ٹ��ϼ� FROM tblinsa;
SELECT name, ibsadate, (sysdate - ibsadate) /365 as �ٹ���� FROM tblinsa;

--�Ʒ� ���� �����ٸ� �̾ӽ� �Ǵϱ� �� ��� ���� 
SELECT name, ibsadate, round((sysdate - ibsadate) /365) as �ٹ���� FROM tblinsa;
SELECT name, ibsadate, floor((sysdate - ibsadate) /365) as �ٹ���� FROM tblinsa;
SELECT name, ibsadate, ceil((sysdate - ibsadate) /365) as �ٹ���� FROM tblinsa;

SELECT title, completedate - adddate FROM tbltodo
    ORDER BY completedate - adddate ASC;
    
    
/*
2. last_day
- �ش� �ð��� ���Ե� ���� ������ ��¥
- date last_day(�÷���)
*/    
SELECT last_day(sysdate) FROM dual;



/*
3.months_between
- number months_between(date, date) : ��
- date - date : ��
*/
SELECT 
    name,
    ibsadate,
    sysdate - ibsadate / 365 as �ٹ����,
    months_between(sysdate, ibsadate) / 12 as "�ٹ����(��)" --O
FROM tblinsa;


/*
4. add_months
-date add_months(date, number)
*/
SELECT sysdate + 1, add_months(sysdate, 1) FROM dual;
SELECT sysdate - 1, add_months(sysdate, -1) FROM dual;

/*
�ð�, �ð� ����
1. date + ��, date -1
2. date - date = �ð���(��)
3. months_between(date, date) = �ð���(��)
4. add_months(date, ��) = date
*/




