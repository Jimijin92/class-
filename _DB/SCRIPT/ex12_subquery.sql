/*
ex12_subquery.sql
- sub query
- SQL�ȿ�
- SELECT���� �������� ���·� ���ȴ�.
- ���������� �� �� �ִ� ��ġ 
    a. where�� : ���������� ������� ���ǰ����� ��� 
    b. �÷�����Ʈ : ���������� ������� �� �ϳ��� �÷� ���� 
    c. from�� : ���������� ������� �ϳ��� ���̺�� ��� -��(View)
    d. order by ��
    e. group by �� 
*/


SELECT*FROM tblhousekeeping ORDER BY price DESC;
�ܰ��� ���� ���� ���Ǹ�?
SELECT max(price) FROM tblhousekeeping; --15000
SELECT item FROM tblhousekeeping WHERE price = 15000;

SELECT item FROM tblhousekeeping WHERE price = max(price); --�������� ���� max(price)�� 15000������ �Ʒ� �������� �ٸ� ��������
SELECT item FROM tblhousekeeping WHERE price = (SELECT max(price) FROM tblhousekeeping);        
                                                              --= (15000);
                                                                
SELECT*FROM tbltodo;
-- ���� �ֱٿ� ����� ����?(adddate�� ���� ������ ��¥)

SELECT title, max(adddate) FROM tbltodo;

SELECT title, max(adddate) FROM tbltodo; --2018-01-12 12:30:23


SELECT title, adddate FROM tbltodo WHERE adddate =to_date('2018-01-12 12:30:23', 'yyyy-mm-dd hh24:mi:ss');
                           
-- ȸ�� ��� ����(155����)���� ���� �޴� ������ ���?                                     
SELECT*FROM tblinsa;                                                                
                                                                
SELECT avg(basicpay) from tblinsa;

SELECT * FROM tblinsa WHERE basicpay > (SELECT avg(basicpay) from tblinsa);

--�ѹ����� ��ձ޿����� ���� �޴� Ÿ�μ� �����?
SELECT * FROM tblinsa 
    WHERE basicpay > (SELECT avg(basicpay) from tblinsa WHERE buseo = '�ѹ���')
                AND buseo<>'�ѹ���';                                                                
                                                        
SELECT*FROM tblinsa WHERE name = 'ȫ�浿';                                                        
SELECT*FROM tblinsa WHERE basicpay > (SELECT basicpay FROM tblinsa WHERE name = 'ȫ�浿');                                            

--������ (���ϰ��� �ƴ϶�)
SELECT*FROM tblinsa WHERE basicpay > (SELECT basicpay FROM tblinsa WHERE jikwi = '����');                                            


SELECT*FROM tblinsa WHERE basicpay > (SELECT max(basicpay) FROM tblinsa WHERE jikwi = '����');                                            
                                
SELECT*FROM tblmen;
SELECT*FROM tblwomen;
                                                                
--���� 170cm +? - > ����ģ�� -> ����ģ�� Ű?                                                                
SELECT couple FROM tblmen WHERE height = 170 AND weight IS NULL;
SELECT height FROM tblwomen WHERE name = '������'

SELECT height FROM tblwomen WHERE name = (SELECT couple FROM tblmen WHERE height = 170 AND weight IS NULL);

--HR
SELECT*FROM employees;
SELECT*FROM departments;
SELECT*FROM locations;

-- ���� Steven King�� �Ҽӵ� �μ��� ��� ������ �ִ��� �ּҸ� �˷��ּ���.
SELECT*FROM locations
    WHERE location_id = ( SELECT location_id FROM departments
         WHERE department_id = (
            SELECT department_id FROM employees
                WHERE upper(first_name || last_name) 
                    = upper(replace('steven king',' ', ''))));

                
--�÷�����Ʈ�� �������� ���
-- ��ȹ�� �������� �浿�̺��� �󸶸� �� �ް� �󸶸� �� �޴��� ������ �ñ�?
SELECT name, basicpay, 2610000 - basicpay FROM tblinsa WHERE buseo = '��ȹ��';

SELECT name, basicpay, 26, (SELECT basicpay FROM tblinsa WHERE name = 'ȫ�浿') - basicpay FROM tblinsa WHERE buseo = '��ȹ��';                                                                


------------------------�����Լ��� �÷�����Ʈ�� ��� -> ��������---------------------
SELECT name, basicpay, max(basicpay) FROM tblinsa;                            
--�̰Ŵ� �� �ָ��� �� �־�,, ��ġ�� �ִ�����..
SELECT name, basicpay, (SELECT max(basicpay)FROM tblinsa) FROM tblinsa;                                                                
--�̰� ���� �� ����,,
SELECT name, basicpay, (SELECT max(basicpay)FROM tblinsa) - basicpay FROM tblinsa;                                                                
 -----------------------------------------------------------------------------------------
 
- �ٱ��� ���̺��� �����͸� ���� ���̺��� �������� ��� -����

--from�� -> �������� 

-- ����Ʈ ������ ���� �������� ��
-- ��ȸ�� ���̺�
SELECT*FROM (SELECT*FROM tblname WHERE gender ='m'); --�ӽ� ���� ���̺� 

-- �̸��� �ִٴ°� ���������� ������ �����ϴٴ°�                                  
-- ���� ������ ���� ������ ����� ���� ������
CREATE TABLE tbltempmen
AS
SELECT*FROM tblname WHERE gender ='m';
SELECT*FROM tbltempmen;


SELECT  *   FROM (SELECT name, ssn, jikwi, city FROM tblinsa WHERE buseo = '��ȹ��');                                                                
        --  �� name, ssn, jikwi, city, �� �װ��� �÷����� �ǹ���

--������ jumin���� �ٲ������� �θ����� jumin���� �ϱ�
SELECT name, ssn, jikwi, city FROM (SELECT name, ssn as jumin, jikwi, city FROM tblinsa WHERE buseo = '��ȹ��');                                                                                                                                

-- ���������� ����� ���߰��� �� 
-- 1. ���� �� 
-- 2. ���� �÷� 

--1. ���� �� 
-- ȫ�浿(����)�� �̼���(����)�� ���� �μ� �������� �������ÿ�.
SELECT name, buseo FROM tblinsa
    -- WHERE buseo = '��ȹ��' or buseo = '���ߺ�';
    WHERE buseo in('��ȹ��','���ߺ�');

SELECT buseo FROM tblinsa
    WHERE name = 'ȫ�浿' or name = '�̼���';
                        
                                                 
-- ������
SELECT name, buseo FROM tblinsa
    WHERE buseo = ( SELECT buseo FROM tblinsa
    WHERE name = 'ȫ�浿' or name = '�̼���');
                                                           
--�����۵� --> in �Ἥ �ذ�                                                           
SELECT name, buseo FROM tblinsa
    WHERE buseo in ( SELECT buseo FROM tblinsa
    WHERE name = 'ȫ�浿' or name = '�̼���');
                                                           
                                                           
                                                           
--2. ���� �÷�
SELECT*FROM tblinsa    
    WHERE name = '������';
                              
-- �����հ� ���� �μ��� �Ҽ� + ���� ������ ������ ���?                                                            
SELECT*FROM tblinsa
    WHERE buseo ='�λ��' AND jikwi = '���';
                                                           

SELECT*FROM tblinsa
    WHERE buseo =(SELECT buseo FROM tblinsa WHERE name = '������') 
        AND jikwi = (SELECT jikwi FROM tblinsa WHERE name = '������');
        
SELECT*FROM tblinsa
    WHERE buseo =(SELECT buseo FROM tblinsa WHERE num = 1035) 
        AND jikwi = (SELECT jikwi FROM tblinsa WHERE num = 1035);
                                                           
SELECT*FROM tblinsa
    WHERE buseo =(SELECT buseo FROM tblinsa WHERE basicpay = (SELECT min(basicpay) FROM tblinsa)) 
        AND jikwi = (SELECT jikwi FROM tblinsa WHERE basicpay = (SELECT min(basicpay) FROM tblinsa));                                                           
        
--1�ܰ�, �ϳ��� ��ġ�� (�ٵ� ���� ������)                                                           
SELECT*FROM tblinsa
    WHERE buseo =(SELECT buseo, jikwi FROM tblinsa WHERE name = '������'); 
--2�ܰ�  �ϼ�       
SELECT*FROM tblinsa
    WHERE (buseo, jikwi) = (SELECT buseo, jikwi FROM tblinsa WHERE name = '������');        
                                                           
                                                           
-- ������ �ڿ��� �������                                                           
SELECT*FROM tblinsa
    WHERE (buseo, jikwi) = (SELECT buseo FROM tblinsa WHERE name = '������');        
                                                           
--�� ������ �߿� !!!!!!!!!!!!!!!! �� --�۵���                                                          
SELECT*FROM tblinsa
    WHERE (buseo, jikwi) = (SELECT buseo, jikwi as position FROM tblinsa WHERE name = '������');        
       
-- ������ �ȳ��µ� �̷��� ��������  
-- �����÷� + ���� �� -> �������� ���ǰ����� ��� 
SELECT*FROM tblinsa
    WHERE (buseo, jikwi) in (SELECT buseo, jikwi FROM tblinsa);                                                           
                                                                
                                                                