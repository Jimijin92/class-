--ex02_select.sql

/*

SQL�� ��ҹ��ڸ� �������� �ʴ´�.

1. SQL Ű���� : �빮��
2. ��ü �ĺ��� : �ҹ���(Ǯ)
    a. memberpoint
    b. memberPoint
    c. member_point
    d.MEMBER_POINT
    
    SQL �ڷ��� 
    -DBMS�� ���� ���̰� ���� 
    -�����͸� �����ϴ� �뵵�� booleanŸ���� ���� 
    
    
    1. ������
    a. NUMBER 
    - ���� + �Ǽ� 
    - (��ȿ�ڸ�) 38�ڸ� ������ ���ڸ� ǥ�� ->�ڹ� double ->20byte
    -number (precision, scale)
    1. precision : �Ҽ� ���ϸ� ������ ��ü �ڸ��� (1~38)
    2. scale : �Ҽ��� ���� �ڸ��� 
    ex)
    number : 38�ڸ����� ǥ���� ������ ��� ����(����, �Ǽ�)
    number(3) : �ִ� 3�ڸ����� ǥ���� ������ ���� (-999~999)
    number(4,2) : �ִ� 4�ڸ�����+�Ҽ����� 2�ڸ� ���� (-99.99~99.99)
    number(10,3) : -9999999.999 ~ 9999999.999
    
    
    b. ������ Ÿ��
        - INTEGER, DOUBLE, DECIMAK, REAL ��... : �ٸ� �ý��� or ���� ��������� ȣȯ�� ������.. 
    2. ������
    - �ڹ� : ����(char) + ���ڿ�(String)
    - ����Ŭ�� ���ڿ� ���ڿ��� ������ ����. ��δ� ���������� ����Ѵ�. 
    
    - ����Ŭ �⺻ ���ڵ�
    :~8(EUC-KR)->9i~12c(UTF-8)
    
    a. CHAR/NCHAR
        -���� �ڸ���
        -CHAR(N) : N�ڸ� ���ڿ�(���� - ����Ʈ)
        ex) CHAR(3) : 3����Ʈ���� ���ڸ� ����(abc ->, ȫ�浿-> ) UTF8�̸� OK UTF16�̸� 6����Ʈ�� ����! --���ڱ��̰� �ƴ϶� ����Ʈ ����
        --�ѹ������� �����ִ°����� ȸ���� �ȵǰ� �״�� ���� 
        -�������� but �� ����
        - �ִ�ũ�� :2000����Ʈ
        - �ּ�ũ�� :1����Ʈ
        
    b. VARCHAR/NVARCHAR ->VARCHAR2/NVARCHAR2
        -���� �ڸ���
        -VARCHAR2(N) : N�ڸ� ������ (����-����Ʈ)
        -- ���������� trim�� 
        --�������� but �� ����
        
        -�ִ�ũ�� : 4000����Ʈ
        -�ּ� ũ�� : 1����Ʈ 
    
    c. N�� ����
    - ���ڼ��� ����
    1. N�� ������ : ����Ŭ�� �⺻ ���ڵ� ��� (UTF-8)
    ex)CHAR(3) : UTF-8 3����Ʈ -> �̰� �� ���� ���� 
    2. N�� ������ : ����Ŭ�� �⺻���ڵ��� ������� ������ UTF-16�� ��� 
    ex)NCHAR(3) : 3���ڱ��� //���������δ� 6����Ʈ 
    
3. ��¥ �ð��� 
    a. DATE
        -���� �� �ڷ����� ���
        -�ڹ� Calendar ����
        -��¥+�ð� ����
        -�ð� ������ 
        -7 byte
        -B.C 4712�� 1�� 1�� ~ A.D 9999�� 12�� 31�� 
        -�ּҴ��� : �ʱ��� 
        
        
    b. TIMESTAMP
        - DATE�� ������
        -10����� 1�ʱ���(������)
        
        
    c. INTERVAL
        - �ð� ������
        - ƽ��
        
    
4. ��뷮 �ڷ���
    a. lob(��),Large Object
    - ������(�ӵ� ����)
    - �ε��� ��� X
    1. BLOB
        -��뷮 ���̳ʸ� ������
        -ū �̹���, ������ ��..
        -�ִ� ũ�� : 4GB
        
    2. CLOB
        -��뷮 ���� ������
        -�ִ� ũ�� : 4GB
        

*/

SELECT*FROM tabs;
select*from tabs;

--���̺� �����ϱ�
DROP TABLE tbltype;

CREATE TABLE tbltype
(
    -- �÷� �����ϱ� 
    -- �÷��� �ڷ���(����) ������ ������� 
    -- age NUMBER, 
    -- height NUMBER(3),
    -- weight NUMBER(4,1)
    
    -- name char(3)
    -- name nchar(3)
    -- txt varchar2(30)
    txt1 char(30),
    txt2 varchar2(30)
);

DESC tbltype;
--�̹� ���� ���̺� �θ��� ���ɾ� 


--������ �߰��ϱ� 
INSERT INTO tbltype (age) VALUES (20);
INSERT INTO tbltype (age) VALUES (200000000000000000000);
INSERT INTO tbltype (age) VALUES (1234567890123456789012345678);
INSERT INTO tbltype (age) VALUES (12345678901234567890123456789);
INSERT INTO tbltype (age) VALUES (1234567890123456789012345678901234567890);

INSERT INTO tbltype (age, height) VALUES (20, 180);
INSERT INTO tbltype (age, height) VALUES (20, 999);
INSERT INTO tbltype (age, height) VALUES (20, 1000);
INSERT INTO tbltype (age, height) VALUES (20, -999);
INSERT INTO tbltype (age, height) VALUES (20, -1000);

INSERT INTO tbltype (age, height, weight) VALUES (20, 180, 65.5);
INSERT INTO tbltype (age, height, weight) VALUES (20, 180, 999.9);
INSERT INTO tbltype (age, height, weight) VALUES (20, 180, 9999.9);
INSERT INTO tbltype (age, height, weight) VALUES (20, 180, 999.99);
INSERT INTO tbltype (age, height, weight) VALUES (20, 180, 99.99);
INSERT INTO tbltype (age, height, weight) VALUES (20, 180, 12.34);
INSERT INTO tbltype (age, height, weight) VALUES (20, 3.14, 12.34);

--������ �������� 
SELECT * FROM tbltype; --   20 NULL NULL

INSERT INTO tbltype (name) VALUES ('ABC'); -- O
INSERT INTO tbltype (name) VALUES ('ȫ�浿'); -- X
INSERT INTO tbltype (name) VALUES ('ȫ'); -- O

-- txt VARCHAR2(30) -> 30����Ʈ 
INSERT INTO tbltype (name) VALUES ('abcdeabcdeabcdeabcdeabcdeabcde'); -- O
INSERT INTO tbltype (name) VALUES ('abcdeabcdeabcdeabcdeabcdeabcdef'); -- O
INSERT INTO tbltype (name) VALUES ('���̻�����ĥ�ȱ���'); -- O
INSERT INTO tbltype (name) VALUES ('���̻�����ĥ�ȱ�����'); -- O

INSERT INTO tbltype (name) VALUES ('���̻�����ĥ�ȱ� ab'); -- O
INSERT INTO tbltype (name) VALUES ('���̻�����ĥ�ȱ� abc'); -- O
-- ��� : ���ڰ� ���ڰ� ���̸� �� ���߸� �� 

INSERT INTO tbltype (name) VALUES ('ȫ�浿','ȫ�浿'); 

SELECT * FROM tbltype;
SELECT * FROM tbltype WHERE txt1 = txt2; 
SELECT * FROM tbltype WHERE trim(txt1) = trim(txt2); 


SELECT * 














