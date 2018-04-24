/*
ex23_����������.sql

- ����Ŭ������ ����
- �亯�� �Խ���, ī�װ� ó��, BOM(���� ����) ��.. �θ�� �ڽ����� ������ Ʈ�� ������ ������ ó��

[��ǰ ����]
��ǻ��
   - ��ü
      - ���κ���
      - ��ī��
      - �޸�(RAM)

   - �����
      - ���ʸ�
   - ������
      -��ũ īƮ����
      -A4 ����
*/

CREATE TABLE tblcomputer
(
        seq NUMBER PRIMARY KEY, -- �ĺ���
        name VARCHAR2(100) NOT NULL, --��ǰ��
        qty NUMBER NOT NULL, --���� 
        pseq NUMBER REFERENCES tblcomputer(seq) NULL --�θ��ǰ
);

INSERT INTO tblcomputer VALUES(1,'��ǻ��', 1, NULL); --��Ʈ���
INSERT INTO tblcomputer VALUES(2,'��ü', 1, 1);
INSERT INTO tblcomputer VALUES(3,'���κ���', 1, 2);
INSERT INTO tblcomputer VALUES(4,'��ī��', 1, 3);
INSERT INTO tblcomputer VALUES(12,'�׷���ī��', 1, 3);
INSERT INTO tblcomputer VALUES(5,'RAM', 1, 3);
INSERT INTO tblcomputer VALUES(11,'�Ŀ����ö���', 1, 2);
INSERT INTO tblcomputer VALUES(6,'�����', 1, 1);
INSERT INTO tblcomputer VALUES(7,'���ʸ�', 1, 6);
INSERT INTO tblcomputer VALUES(8,'������', 1, 1);
INSERT INTO tblcomputer VALUES(9,'��ũ īƮ����', 1, 8);
INSERT INTO tblcomputer VALUES(10,'A4 ����',1, 8);

SELECT*FROM tblcomputer;
COMMIT;

--1. ���� ��� -> ������ ������ ����
--; �ڱ� ���� -> ���� ����
--; ���� ����? �ܺ� ����? 
SELECT c1.name, c2.name as panme FROM tblcomputer c1 --��ǰ
        LEFT OUTER JOIN tblcomputer c2 --�θ� ��ǰ
                ON c1.pseq = c2.seq; --�ڽ����̺� <-> �θ����̺�
                        
--2. start with �� .. connect by ��
-- ������ �����͸� ������� ����
SELECT*FROM tblcomputer
        START WITH seq = 1
                CONNECT BY PRIOR seq = pseq;

-- ������ ������ �ǻ� �÷�
-- level
SELECT lpad(' ', (level -1) * 6) || name, pseq, level FROM tblcomputer
        START WITH seq = 1
                CONNECT BY PRIOR seq = pseq;
        
-- ���� ��������
-- : �ٱ��� �����ʹ� ���� ������� �������� ���� ���� ���� 
        
-- ��� ���� ����         
-- : �ٱ����� ���� ����� ���� ������ ����ϴ� ���� ����  
SELECT lpad(' ', (level -1) * 6) || name, 
        (SELECT name FROM tblcomputer WHERE seq = c2.pseq), 
        level FROM tblcomputer c2
        START WITH seq = 1
                CONNECT BY PRIOR seq = pseq;
   
 -- �ǻ��÷�
 --prior: �θ� ���ڵ� ���� 
SELECT lpad(' ', (level -1) * 6) || name, 
        prior name, prior seq, --= (SELECT name FROM tblcomputer WHERE seq = c2.pseq), <-�� ����. 
        level FROM tblcomputer c2
        START WITH seq = 1
                CONNECT BY PRIOR seq = pseq;             

-- start with�� ����
SELECT lpad(' ', (level -1) * 6) || name as name, PRIOR name
        FROM tblcomputer
        -- START WITH seq = 1 -- �������� ����(���� �˰��ֱ� ������)
        -- START WITH pseq IS NULL -- �θ� ���� ���(= ��Ʈ���)
        -- START WITH seq = (SELECT seq FROM tblcomputer WHERE name = '��ǻ��')
        START WITH seq = 1
                        CONNECT BY PRIOR seq = pseq;     


-- connect by ����
-- �θ��÷� = �ڽ��÷� ����
-- �ݵ�� prior �ǻ��÷��� ���� ���
SELECT lpad(' ', (level -1) * 6) || name as name, PRIOR name 
        FROM tblcomputer
                START WITH seq = 1
                        CONNECT BY seq = PRIOR pseq;







DROP TABLE tblcomment;
DROP TABLE tblboard;

-- ������ �Խ���(= �亯�� �Խ���)
CREATE TABLE tblboard
(
    seq NUMBER PRIMARY KEY,
    subject VARCHAR2(1000) NOT NULL,
    pseq NUMBER NULL
);

INSERT INTO tblboard VALUES (1, '1�� ���Դϴ�.', NULL);
INSERT INTO tblboard VALUES (2, '2�� ���Դϴ�.', NULL);
INSERT INTO tblboard VALUES (3, '3�� ���Դϴ�.', NULL);

INSERT INTO tblboard VALUES (4, '1���� ù��° �亯���Դϴ�.', 1);
INSERT INTO tblboard VALUES (5, '1���� �ι�° �亯���Դϴ�.', 1);
INSERT INTO tblboard VALUES (6, '1���� ����° �亯���Դϴ�.', 1);

INSERT INTO tblboard VALUES (7, '2���� ù��° �亯���Դϴ�.', 2);
INSERT INTO tblboard VALUES (8, '2���� �ι�° �亯���Դϴ�.', 2);

INSERT INTO tblboard VALUES (9, '3���� ù��° �亯���Դϴ�.', 3);
INSERT INTO tblboard VALUES (10, '3���� �ι�° �亯���Դϴ�.', 3);
INSERT INTO tblboard VALUES (11, '3���� ����° �亯���Դϴ�.', 3);

INSERT INTO tblboard VALUES (12, '1���� ù��° �亯�� ù��° �亯���Դϴ�.', 4);
INSERT INTO tblboard VALUES (13, '1���� ù��° �亯�� �ι�° �亯���Դϴ�.', 4);

INSERT INTO tblboard VALUES (14, '2���� ù��° �亯�� ù��° �亯���Դϴ�.', 7);
INSERT INTO tblboard VALUES (15, '3���� �ι�° �亯�� ù��° �亯���Դϴ�.', 10);





CREATE TABLE tblcategory
(
    seq NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    pseq NUMBER NULL
);

INSERT INTO tblcategory VALUES (1, '�м��Ƿ�/��ȭ', NULL);
INSERT INTO tblcategory VALUES (2, '��Ƽ', NULL);
INSERT INTO tblcategory VALUES (3, '�ֹ��ǰ', NULL);
INSERT INTO tblcategory VALUES (4, '�����м�', 1);
INSERT INTO tblcategory VALUES (5, '�����м�', 1);
INSERT INTO tblcategory VALUES (6, '���̺��м�', 1);
INSERT INTO tblcategory VALUES (7, 'Ƽ����', 4);
INSERT INTO tblcategory VALUES (8, '����', 4);
INSERT INTO tblcategory VALUES (9, '���콺', 5);
INSERT INTO tblcategory VALUES (10, '���ǽ�', 5);
INSERT INTO tblcategory VALUES (11, '��ĿƮ', 5);
INSERT INTO tblcategory VALUES (12, '���̺� ����', 6);
INSERT INTO tblcategory VALUES (13, '���̺� ����', 6);
INSERT INTO tblcategory VALUES (14, '���̺� ����', 6);
INSERT INTO tblcategory VALUES (15, '��Ų�ɾ�', 2);
INSERT INTO tblcategory VALUES (16, '���', 2);
INSERT INTO tblcategory VALUES (17, '���� ȭ��ǰ', 15);
INSERT INTO tblcategory VALUES (18, 'Ŭ��¡', 15);
INSERT INTO tblcategory VALUES (19, '����ũ', 15);
INSERT INTO tblcategory VALUES (20, '���� ���', 16);
INSERT INTO tblcategory VALUES (21, '���� ���', 16);
INSERT INTO tblcategory VALUES (22, '�׸�', 3);
INSERT INTO tblcategory VALUES (23, '��', 3);
INSERT INTO tblcategory VALUES (24, '��ȸ��ǰ', 3);
INSERT INTO tblcategory VALUES (25, '�ı�', 22);
INSERT INTO tblcategory VALUES (26, '���ƽı�', 22);
INSERT INTO tblcategory VALUES (27, '�ӱ�', 23);
INSERT INTO tblcategory VALUES (28, '������', 23);
INSERT INTO tblcategory VALUES (29, '�Һ�', 23);
INSERT INTO tblcategory VALUES (30, '������', 24);



COMMIT;



--�Խ���
SELECT *FROM tblboard;

SELECT lpad(' ', (level -1) * 8) || subject as subject FROM tblboard
        -- WHERE �� ��ġ        
                -- START WITH pseq IS NULL
                START WITH seq = 1
                        CONNECT BY PRIOR seq = pseq
                                -- ORDER BY seq DESC; --������ �������� �Ϲ����� ORDER BY �� ��
                                ORDER SIBLINGS BY seq DESC;


-- ī�װ� 
SELECT lpad(' ', (level -1) * 6) || name FROM tblcategory
        START WITH pseq IS NULL
                CONNECT BY PRIOR seq = pseq;



--���ǽ�
SELECT
	CASE
		WHEN level = 1 THEN '�Һз�'
		WHEN level = 2 THEN '�ߺз�'
		WHEN level = 3 THEN '��з�'
	END as "level",
	lpad(' ', (level - 1) * 6) || name
	FROM tblcategory
		START WITH seq = (SELECT seq FROM tblcategory WHERE name = '���ǽ�')
			CONNECT BY seq = PRIOR pseq;


-- �θ� �ڽ������� Ư���ڽĸ� ������ �� ����.


/*
������ ���� �ǻ��÷�
1.PRIOR : �θ� ���ڵ� ���� 
2. CONNECT_BY_ROOT : ��Ʈ ��� ���ڵ� ����
3. CONNECT_BY_ISLEAF : ���� ��� ���� ��ȯ
4. sys_connect_by_path() �Լ�
*/
SELECT 
        lpad(' ', (level -1) * 6) || name as "���� ī�װ�",
        prior name as "�θ� ī�װ�",
        connect_by_root name as "��Ʈ ī�װ�",
        CONNECT_BY_ISLEAF,
        sys_connect_by_path(name, '>') 
        FROM tblcategory
                START WITH pseq IS NULL 
                        CONNECT BY PRIOR seq = pseq;
                        
                        
SELECT lpad(' ', (level-1)*6) || first_name || '' || last_name as name FROM employees
        START WITH employee_id = 100
                CONNECT BY PRIOR employee_id = manager_id
                        ORDER SIBLINGS BY first_name ASC;


-- ��� ��������, Correlated Sub Query
-- 1. �ٱ����� ���� ���� ������ ���ǿ��� ����ϴ� ��������
-- 2. ���� ������ �ܵ����� ���� �Ұ����� ����

-- ��� ���� ������ ���� �� �Ϻδ� group by �� ����� ������ ���̴� ��찡 �ִ�.

-- �� �μ��� �ְ� �޿�?
-- group by ���
SELECT name, jikwi, buseo, max(basicpay) FROM tblinsa --> name�̶� jikwi������ ������
	GROUP BY buseo;

-- ��� ���� ���� ���
SELECT name, jikwi, buseo, basicpay FROM tblinsa --> name�̶� jikwi�ᵵ ���� �ȳ� 
	WHERE basicpay = (SELECT max(basicpay) FROM tblinsa
                                                WHERE buseo = i1.buseo);

-- �� ������ �ִ� �޿��� �޴� �����? 
-- �������
SELECT name, jikwi, basicpay FROM tblinsa i1
        WHERE basicpay = (SELECT max(basicpay) FROM tblinsa WHERE jikwi = i1.jikwi);


-- Pairwise Sub Query
SELECT name, jikwi, basicpay FROM tblinsa 
        WHERE (buseo, basicpay) in (SELECT buseo, basicpay FROM tblinsa
                                                                GROUP BY jikwi);
        
        
-- ȫ�浿�� �� �μ��� ��� �޿��� �������ÿ�.
SELECT name, jikwi, buseo,basicpay, 
        (SELECT round(avg(basicpay)) FROM tblinsa WHERE buseo = '��ȹ��') 
                FROM tblinsa
                        WHERE name = 'ȫ�浿';
        --> �� ��� ȫ�浿�� �̼������� �ٲ�� �μ��� �ٲ�� ����� ������ Ȯ���ؼ� ��ȹ�θ� �̼��ų� �μ��� �ٲ���� ��, �׷��� �Ʒ� ��ĵ� ����
        
        
-- ���ʿ��� ȫ�浿�� �μ� ��������
SELECT name, jikwi, buseo,basicpay, 
        (SELECT round(avg(basicpay)) FROM tblinsa WHERE buseo = (SELECT buseo FROM tblinsa WHERE name = 'ȫ�浿')) 
                FROM tblinsa
                        WHERE name = 'ȫ�浿';      
       
       
-- �ٱ��� ���� ���ؼ� �����������
SELECT name, jikwi, buseo,basicpay, 
        (SELECT round(avg(basicpay)) FROM tblinsa WHERE buseo = i1.buseo) 
                FROM tblinsa i1
                        WHERE name = 'ȫ�浿'; 
                
-- �� �μ��� �ִ� �޿��� �޴� ��� 3�� �������ÿ�.
SELECT name, buseo, basicpay FROM tblinsa i1
        WHERE (SELECT count(*) FROM tblinsa
                        WHERE basicpay > i1.basicpay AND buseo = i1.buseo) < 3
                        ORDER BY buseo ASC, basicpay DESC; 
                        
                        
                        
                        