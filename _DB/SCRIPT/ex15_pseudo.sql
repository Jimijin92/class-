/*
ex15_pseudo.sql

�ǻ� �÷�, Pseudo Column

rownum
- ����Ŭ
- ���ȣ
- ���� ������ ��ȣ�� ��ȯ�ϴ� ���� �÷�(�����ڰ� ���� �������� �ʴ��� �����ϴ� �÷�)
- ���������� ���ؾ� ����ϱ� ����. ����(*****)
- rownum�� FROM���� ������ �� ��ȣ�� �Ҵ��Ѵ�. (************)
*/

SELECT * FROM tblinsa;
SELECT name, buseo, jikwi, rownum FROM tblinsa;

SELECT name, buseo, jikwi, basicpay, rownum FROM tblinsa;

--��ȣ�� �ű�� ������ ���Ͽ�...
SELECT name, buseo, jikwi, basicpay, rownum --2.
        FROM tblinsa --1.
                ORDER BY basicpay DESC; --3.
                
--���Ҹ��� rownumber������
SELECT name, buseo, jikwi, basicpay, rnum, rownum FROM 
(SELECT name, buseo, jikwi, basicpay, rownum as rnum
        FROM tblinsa 
                ORDER BY basicpay DESC)
                        WHERE rownum <=3; 
                        

-- rownum�� �������� ��� -> 1���� ����
SELECT name, basicpay, rownum FROM tblinsa;
SELECT name, basicpay, rownum FROM tblinsa WHERE rownum = 1; --A
SELECT name, basicpay, rownum FROM tblinsa WHERE rownum = 3; --X
SELECT name, basicpay, rownum FROM tblinsa WHERE rownum <= 5;
SELECT name, basicpay, rownum FROM tblinsa WHERE rownum >= 6 AND rownum <= 10;

-- rownum�� �������� ����ϱ� ���ؼ�...-> �������� ��� -> rownum������ �ʵ��� �ϱ� ���ؼ�(����)
SELECT name, basicpay, rownum FROM tblinsa;

SELECT name, basicpay, rownum, rnum
        FROM(SELECT name, basicpay, rownum as rnum FROM tblinsa)
                WHERE rnum >= 5 AND rnum <=10;

-- �޿��� ���� ������� ����
SELECT*FROM
        (SELECT rownum as rnum, a.* FROM 
                (SELECT t.* FROM tblinsa t ORDER BY basicpay DESC)a) b
                        WHERE rnum > 3 AND rnum < =5;
                        
                        




