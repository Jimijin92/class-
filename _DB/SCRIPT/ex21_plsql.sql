/*

ex21_plsql.sql

PL/SQL
- Procedural Language Extensions to SQL
- ǥ�� SQL : �� ������ ���(������ ����, ���������� �ʴ�.)
- ǥ�� SQL + ������ ��� �߰� -> ����Ŭ �߰� SQL -> PL/SQL
- �߰��� �κ� -> �ڹ��� ���α׷��� ��� �߰�(����, ���, �޼ҵ� ��..)
- ����Ŭ ���� SQL

- ǥ�� SQL <-> PL/SQL : �ڷ��� ȣȯ�� �ȴ�.
- ǥ�� SQL : ���� ������ �ʼ�X
- PL/SQL : ���� ������ �ʼ�O


SQL ó�� ���� & ����
1. ǥ�� SQL
 : Ŭ���̾�Ʈ ���� �ۼ�(SELECT ��) -> ����(Ctrl + Enter) -> ��Ʈ��ũ�� ���� SQL�� DBMS �������� ���� -> ���� �м�(�Ľ�) -> ������ -> ���� ����(CPU) -> ��� ó��
 : ������ ������ ���� SQL�� �ٽ� ���� -> ���� ���� ó������ ������ �ٽ� �ݺ�(***)

2. PL/SQL
 : Ŭ���̾�Ʈ ���� �ۼ�(SELECT ��) -> ����(Ctrl + Enter) -> ��Ʈ��ũ�� ���� SQL�� DBMS �������� ���� -> ���� �м�(�Ľ�) -> ������ -> ���� ����(CUP) -> ��� ó��
      2.a ó�� ���� : ���� ���� ó�� ~ ������ ����(ǥ�� SQL�� ������ ���)
      2.b ���� �ݺ� ���� : ���� �м�(�Ľ�) ~ ������ �κ��� ����
      : (����) ���ν��� -> Stored Procedure : �ڹ��� �޼ҵ�(�Լ�)


���ν���, Procedure
- �޼ҵ�, �Լ�, �����ƾ ��... Ư�� ������ ������ ���� ������� ������ ��ɾ��� ����
1. �͸� ���ν��� -> �̸����� -> ��ȣ���� �������� ���� �ʴ� ���ν���
2. �Ǹ� ���ν��� -> �̸����� -> ��ȣ���� �������� �ϴ� ���ν���

*/
BEGIN

      dbms_output.put_line('Hello'); --syso

END;



/*

PL/SQL
- ���α׷��� ����� ���� + ǥ�� SQL
- �ַ� ���ν��� ���·� ��� -> �� ���·� ���

PL/SQL �� ����

1. 4�� Ű����� ����
- DECLARE
- BEGIN
- EXCEPTION
- END;

2. DECLARE
- �����, declare section
- ���α׷����� ���Ǵ� ����, ��ü ���� �����ϴ� ����
- ���� ����

3. BEGIN
- �����, ������, executable section
- BEGIN ~ END
- ���α׷����� ���� ���� ������ �����ϴ� ����
- ����, ����, ǥ�� SQL ������ ����
- ���� �Ұ���

4. EXCEPTION
- ���� ó���� , exception section
- catch �� ����
- ���� ó�� �ڵ带 �����ϴ� ����
- ���� ����

5. END;
- ���� ����
- ���� �Ұ���

6. PL/SQL �� = ����� + ����� + ����ó����


�ڹ�
{
      {

      }
}

����Ŭ
BEGIN
      BEGIN

      END;
END;


DECLARE
      ����, �ڿ� �����ϱ�
BEGIN
      ������
EXCEPTION
      ����ó����
END;



�ڷ��� & ����

�ڷ���
- ����Ŭ�� ����(���� ����)

���� �����ϱ�
- ������ �ڷ��� [NOT NULL] [DEFAULT ��]
- ������ ���� : ������ ����� ���ڰ��� �����ϴ� �뵵

������
- ǥ�� SQL�� ����

ǥ�� SQL ���� ������
- �뵵 : �÷��� ����
- �÷��� = ��

PL/SQL ���� ������
- �뵵 : ������ ����
- ���� := ��
*/
DECLARE
      num NUMBER;
      name VARCHAR2(30);
      today DATE;
BEGIN

      num := 10; -- ������ ���(���ͷ�)
      dbms_output.put_line(num);

      name := 'ȫ�浿'; -- ���ڿ� ���(���ͷ�)
      dbms_output.put_line(name);

      today := sysdate;
      dbms_output.put_line(today);
      dbms_output.put_line(to_char(today, 'yyyy-mm-dd'));

END;


DECLARE
      num NUMBER DEFAULT 100; --NULL ���
      age NUMBER NOT NULL DEFAULT 200;
BEGIN

      -- default ����� ������ NULL ���·� ���� ����ϸ� �ڵ����� default���� ���Եȴ�.

      -- num
      dbms_output.put_line(num);

      -- age
      dbms_output.put_line(age);

END;


/*
���̺��� ��ȸ�� �����͸� ������ ��ƾ��ϴ� ���
- ������ ����� ���ϰ��̿� �Ѵ�.(���� �÷� or ���� ���ڵ� ��� �Ұ���)
      a. ������� 1���� ���ڵ�� 1���� �÷����� ����(PK ������)
      b. ���� �Լ��� �����
*/
DECLARE
      vbuseo varchar2(15);
BEGIN
      --�ϳ��� �÷����� �ϳ��� ������ ����
      SELECT buseo INTO vbuseo FROM tblinsa
            WHERE name = 'ȫ�浿';
      dbms_output.put_line('ȫ�浿�� �μ��� ' || vbuseo || '�Դϴ�.');
END;


DECLARE
      vsalary number; --��� �޿�(basicpay + sudang)
BEGIN

      -- ���� := ��;
      -- �÷��� into ����
      SELECT round(avg(basicpay + sudang)) INTO vsalary FROM tblinsa;

      dbms_output.put_line('��� �޿� : ' || vsalary);

END;

/*
SELECT INTO ��
1. 1���� ������� 1���� ������ ����(1:1)
2. N���� ������� N���� ������ ����(N:N). �� ������� ������ ������ ������ ��ġ
*/
DECLARE
      vname VARCHAR2(20);
      vbuseo VARCHAR2(15);
      vjikwi VARCHAR2(15);
      vbasicpay NUMBER;
BEGIN

      SELECT name, buseo, jikwi, basicpay INTO vname, vbuseo, vbasicpay, vjikwi
            FROM tblinsa
                  WHERE num = 1001;

      dbms_output.put_line(vname || '�� ''' || vbuseo || '''�� �ٹ��ϴ� ''' || vjikwi || '''�Դϴ�.');

END;


/*
������ ����
- ����(�÷�)�� �ڷ����� ���� �ȴ�.
- ���� �������� ����.
- ���̺�� �並 ������� �Ѵ�.

1. %type
- ����ϴ� ���̺��� Ư�� �÷��� �ڷ����� ���̸� �����ؼ� �̰��� �����ϰڽ��ϴ�.
- ����Ǵ� ����
      a. �ڷ���
      b. ����
      c. NOT NULL ����

*/
DECLARE
      vname tblinsa.name%type; -- vname varchar2(20) not null
BEGIN
      SELECT name INTO vname FROM tblinsa
            WHERE basicpay = (SELECT max(basicpay) FROM tblinsa);
      dbms_output.put_line(vname);
END;


DECLARE
      vfirst tblname.first%type;
      vlast tblname.last%type;
      vnick tblname.nick%type;
BEGIN
      SELECT first, last, nick INTO vfirst, vlast, vnick FROM tblname
            WHERE height = 178 AND weight = 64;
      dbms_output.put_line(vfirst);
      dbms_output.put_line(vlast);
      dbms_output.put_line(vnick);
END;




DECLARE
      vfirst tblname.first%type;
      vlast tblname.last%type;
      vnick tblname.nick%type;
BEGIN
      SELECT first, last, nick INTO vfirst, vlast, vnick FROM tblname
            WHERE height = 178 AND weight = 64;
      dbms_output.put_line(vfirst);
      dbms_output.put_line(vlast);
      dbms_output.put_line(vnick);
END;




DECLARE
      vfirst tblname.first%type;
BEGIN

      SELECT first INTO vfirst FROM tblname
            WHERE nick = '�޶ѱ�';
      dbms_output.put_line(vfirst);

      SELECT first INTO vfirst FROM tblname
            WHERE nick = '�̽ʳ�';
      dbms_output.put_line(vfirst);

      SELECT first INTO vfirst FROM tblname
            WHERE nick = '���߾�';

      dbms_output.put_line(vfirst);

      vfirst := vfirst || '���';
      dbms_output.put_line(vfirst);
END;


DECLARE
      vbasicpay tblinsa.basicpay%type;
      vname tblinsa.name%type;
BEGIN

      SELECT max(basicpay) INTO vbasicpay FROM tblinsa; --2650000

      SELECT name INTO vname FROM tblinsa WHERE basicpay = vbasicpay;

      dbms_output.put_line(vname);

END;


DECLARE
      vcouple tblmen.couple%type;
BEGIN

      -- ȫ�浿�� ����ģ�� �ٶ� -> ������
      -- SELECT * FROM tblmen; --ȫ�浿 - �嵵��

      -- 1.
      SELECT couple INTO vcouple FROM tblmen WHERE name = 'ȫ�浿';

      -- 2.
      UPDATE tblmen SET couple = vcouple WHERE name = '������';

      -- 3.
      UPDATE tblmen SET couple = NULL WHERE name = 'ȫ�浿';

      -- 4.
      --SELECT * FROM tblwomen;
      UPDATE tblwomen SET couple = '������' WHERE name = vcouple;


END;

SELECT * FROM tblmen;
SELECT * FROM tblwomen;





-- tblinsa. ���� �� �Ϻο��� ������ ���ʽ� ���� ����
CREATE TABLE tblbonus
(
      seq NUMBER primary key,
      name varchar2(15) NOT NULL, --����Ű(�ٸ� ���̺� PK ����)
      --num number REFERENCES tblinsa(num), -- ����
      bonus NUMBER NOT NULL
);

SELECT * FROM tblinsa
      WHERE city = '����' AND jikwi = '����'
            AND (months_between(sysdate, ibsadate) / 12) >= 20;


DECLARE
      vname tblinsa.name%type;
      vsudang tblinsa.sudang%type;
BEGIN

      SELECT name, sudang * 3 INTO vname, vsudang FROM tblinsa
            WHERE city = '����' AND jikwi = '����'
                  AND (months_between(sysdate, ibsadate) / 12) >= 20;

      --dbms_output.put_line(vname);
      --dbms_output.put_line(vsudang);

      INSERT INTO tblbonus VALUES (1, vname, vsudang);

END;

SELECT * FROM tblbonus;




/*

2. %rowtype
- ���̺��� ���ڵ� ������ �����Ѵ�.(%type : �÷� ����)
- %type �� ����

*/
DECLARE
      --vrow tblinsa.�÷���%type;
      vrow tblinsa%rowtype; --���ڵ��� Ÿ�� ��ü�� ����(�÷� 10�� ����)
BEGIN

      /*
      SELECT
            num, name, ssn, ibsadate, city, tel, buseo, jikwi, basicpay, sudang
            INTO
            vnum, vname, vssn, vibsadate, vcity, vtel, vbuseo, vjikwi, vbasicpay, vsudang
                  FROM tblinsa
                        WHERE num = 1001;
      */
      SELECT * INTO vrow FROM tblinsa WHERE num = 1001;

      --dbms_output.put_line(vrow);
      dbms_output.put_line(vrow.num);
      dbms_output.put_line(vrow.name);
      dbms_output.put_line(vrow.buseo);
      dbms_output.put_line(vrow.city);

END;

-- tblmen -> tblwomen : �ű��
DECLARE
      vrow tblmen%rowtype;
BEGIN

      -- SELECT * FROM tblmen;
      -- �̵� = ���� + ����

      -- 1. ���� : select -> insert
      SELECT * INTO vrow FROM tblmen WHERE name = '������';

      --dbms_output.put_line(vrow.name);
      --dbms_output.put_line(vrow.age);

      INSERT INTO tblwomen (name, age, height, weight, couple)
            VALUES (vrow.name, vrow.age, vrow.height, vrow.weight, vrow.couple);

      -- 2. ����
      DELETE FROM tblmen WHERE name = '������';

END;

SELECT * FROM tblmen;
SELECT * FROM tblwomen;

/*

���
- ���ͷ� X
- �ڹ� : final double PI = 3.14;
- ����� constant �ڷ��� [NOT NULL] [DEFAULT]
*/

DECLARE
      num NUMBER := 100;
      PI CONSTANT NUMBER(3, 2) := 3.14;
BEGIN
      --PI := 5.24;
      dbms_output.put_line(PI);
END;



/*

�ĺ���(DB Object)
- ������ �� ��� Ű���带 �빮�ڷ� ��ȯ -> ����
- ������ + ���� + _
- ���� ���� X
- ����� ��� X -> "�����" -> ���� ����
- �ִ� ���� ���� 30����Ʈ ����(UTF-8)
      : ���� ���� �̸�
      ex) tblcountry + name + primary key
           name varchar2(20) constraint tblcountry_name_pk primary key,

*/

-- ORA-00903: invalid table name
CREATE TABLE "NUMBER"
(
      seq number PRIMARY KEY
);

INSERT INTO NUMBER (seq) VALUES (100);
INSERT INTO "NUMBER" (seq) VALUES (100);

SELECT * FROM NUMBER;
SELECT * FROM "NUMBER";


CREATE TABLE tblnumber
(
      seq NUMBER CONSTRAINT tblnumber_seq_pkaaaaaaaaaaaaaaaaaaaa PRIMARY KEY
);

DROP TABLE tblnumber;

CREATE TABLE tblnumberaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
(
      seq NUMBER CONSTRAINT tblnumber_seq_pk PRIMARY KEY
);


SELECT name AS aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa FROM tblinsa;



/*
���
*/

-- ���ǹ� : if��
DECLARE
      vnum NUMBER;
BEGIN

      vnum := -10;

      IF vnum > 0 THEN
             dbms_output.put_line('���');
      END IF;

      IF vnum > 0 THEN
             dbms_output.put_line('���');
      ELSE
            dbms_output.put_line('����');
      END IF;

      IF vnum > 0 THEN
             dbms_output.put_line('���');
      ELSIF vnum <0 THEN
            dbms_output.put_line('����');
      ELSE
            dbms_output.put_line('0');
      END IF;

END;



DECLARE
      vgender CHAR(1); --�ֹι�ȣ 1�ڸ�
      vnumber NUMBER; --���� ��ȣ
BEGIN
      -- ���� ������ ���ڸ� A ���� ���� or ���ڸ� B ���� ����
      vnumber := 1003;

      SELECT substr(ssn, 8, 1) INTO vgender FROM tblinsa WHERE num = vnumber;

      IF vgender = '1' THEN
            UPDATE tblinsa SET basicpay = basicpay + 100000
                  WHERE num = vnumber;
      ELSE
            UPDATE tblinsa SET sudang = sudang + 100000
                  WHERE num = vnumber;
      END IF;

END;

SELECT * FROM tblinsa;



DECLARE
      vrow tblinsa%rowtype;
BEGIN

      SELECT * INTO vrow FROM tblinsa WHERE num = 1001;

      -- �޿� 2�鸸�� �̻� + ����(����)��?
      IF vrow.basicpay >= 2000000 AND vrow.jikwi IN ('����', '����') THEN
            dbms_output.put_line('����');
      ELSE
            dbms_output.put_line('����');
      END IF;

END;


/*
case ��
- �ڹ� : switch case ��
- ǥ�� case���� ����
*/

DECLARE
      vcontient tblcountry.continent%type;
      vresult VARCHAR2(30); -- UTF-8
      --vresult NVARCHAR2(30); -- UTF-16
      vpopulation tblcountry.population%type;
BEGIN

      -- ���ѹα��� ��� ����� ���ϴ���?
      SELECT continent, population INTO vcontient, vpopulation
            FROM tblcountry WHERE name = '���ѹα�';

      dbms_output.put_line(vcontient);

      IF vcontient = 'AS' THEN
            vresult := '�ƽþ�';
      ELSIF vcontient = 'EU' THEN
            vresult := '����';
      ELSIF vcontient = 'AF' THEN
            vresult := '������ī';
      END IF;

      dbms_output.put_line(vresult);

      CASE
            WHEN vcontient = 'AS' THEN vresult := '�ƽþ�';
            WHEN vcontient = 'EU' THEN vresult := '����';
            WHEN vcontient = 'AF' THEN vresult := '������ī';
      END CASE;

      CASE vcontient
            WHEN 'AS' THEN vresult := '�ƽþ�';
            WHEN 'EU' THEN vresult := '����';
            WHEN 'AF' THEN vresult := '������ī';
      END CASE;

      dbms_output.put_line(vresult);


      --�α����� ���� ���� �б�..
      CASE
            WHEN vpopulation > 10000 THEN vresult := '�ʹ� ����';
            WHEN vpopulation > 5000 THEN vresult := '���� ����';
            WHEN vpopulation > 1000 THEN vresult := '������';
            ELSE vresult := '���ڶ�';
      END CASE ;

      dbms_output.put_line(vresult);

END;



/*
�ݺ���

1. LOOP
- ���� �ݺ�

2. FOR LOOP
- ���� Ƚ�� �ݺ�(�ڹ� for��)

3. WHILE LOOP
- ���� �ݺ�(�ڹ� while��)
*/

BEGIN
      LOOP
            dbms_output.put_line('�ȳ��ϼ���. ' || sysdate);
            EXIT;
      END LOOP;
END;


DECLARE
      vnum NUMBER;
BEGIN
      vnum := 1;

      LOOP
            dbms_output.put_line(vnum);
            vnum := vnum + 1;
            EXIT WHEN vnum = 11;
      END LOOP;
END;


DECLARE
      vnow DATE;
BEGIN
      LOOP
            vnow := sysdate;
            dbms_output.put_line('���� �ð��� ' || to_char(vnow, 'hh24:mi:ss') || '�Դϴ�.');
            EXIT WHEN to_char(vnow, 'ss') = '59';
      END LOOP;
      dbms_output.put_line('����');
END;





CREATE TABLE tblloop
(
      seq NUMBER primary key,
      data VARCHAR2(30) NOT NULL
);

CREATE SEQUENCE loopseq;

-- 1, �л�1
-- 2, �л�2
-- .. insert x 1000ȸ

DECLARE
      vnum NUMBER; --���� ���� + seq + �л� ��ȣ
BEGIN
      vnum := 1;
      LOOP
            INSERT INTO tblloop (seq, data) VALUES (vnum, '�л�' || vnum);
            vnum := vnum + 1;
            EXIT WHEN vnum >= 1001;
      END LOOP;
END;

SELECT * FROM tblloop;

TRUNCATE TABLE tblloop; --�ѹ� �Ұ���


BEGIN
      LOOP
            INSERT INTO tblloop (seq, data)
                  VALUES (loopseq.nextval, '�л�' || loopseq.currval);
            EXIT WHEN loopseq.currval >= 1000;
      END LOOP;
END;



/*
2. FOR LOOP
- ����Ƚ�� �ݺ�
*/
BEGIN
      -- FOR�� ���������� ���� ������ ������ �ʴ´�.
      -- i : ���� ����
      -- 1 : �ʱⰪ
      -- .. : ����
      -- 10 : �ִ밪
      FOR i IN REVERSE 1..10 LOOP
            dbms_output.put_line(i);
      END LOOP;
END;


-- BEGIN
--       FOR i IN 'A'..'Z'  LOOP
--             dbms_output.put_line(i);
--       END LOOP;
-- END;


--3. WHILE LOOP
DECLARE
      vnum NUMBER;
BEGIN
      vnum := 1;

      WHILE vnum <= 10
      LOOP
            dbms_output.put_line(vnum);
            vnum := vnum + 1;
      END LOOP;

END;

-- ������
CREATE TABLE tblgugudan
(
      dan NUMBER NOT NULL , --   2  2  2
      num NUMBER NOT NULL , --  1  2  3
      result NUMBER NOT NULL, -- 2  4  6

      --����Ű(Composite Key)
      -- : 2�� �̻��� �÷��� �𿩼� �⺻Ű(PK) ����
      -- : �÷� �������� ���� �Ұ���, ���̺� �������� ���� ����
      CONSTRAINT tblgugudan_dan_num_pk PRIMARY KEY(dan, num)
);

-- 2�� ~ 9�� : 2�� ����
DECLARE
      vdan NUMBER;
      vnum NUMBER;
      --vresult NUMBER;
BEGIN
      vdan := 2;
      WHILE vdan <= 9 LOOP
            vnum := 1;
            WHILE vnum <= 9 LOOP
                  INSERT INTO tblgugudan (dan, num, result)
                        VALUES (vdan, vnum, vdan * vnum);
                  vnum := vnum + 1;
            END LOOP;
            vdan := vdan + 1;
      END LOOP;
END;

SELECT * FROM tblgugudan ORDER BY dan ASC , num ASC ;

TRUNCATE TABLE tblgugudan;


BEGIN
      FOR dan IN 2..19 LOOP
            FOR num IN 1..19 LOOP
                  INSERT INTO tblgugudan VALUES (dan, num, dan * num);
            END LOOP;
      END LOOP;
END;




/*
SELECT�� ���ؼ� ������ �����͸� PL/SQL ������ �ִ� ���
1. SELECT INTO ����ϱ�
- ������� ���ڵ尡 1���� ���� �����ϴ�.

2. Ŀ��(Cursor) ����ϱ�
- ������� ���ڵ尡 1�� �̻��� �� �����ϴ�.


Ŀ�� ����

DECLARE
      ���� ����;
      Ŀ�� ����;
BEGIN
      Ŀ�� ����;
      LOOP
            ������ ����(���ڵ� ����);
      END LOOP;
      Ŀ�� �ݱ�;
END;

*/

-- SELECT INTO
-- 1. ���� �÷� x ���� ��(**)
-- 2. ���� �÷� x ���� ��(**)

-- tblinsa ������ �������� x 60��
-- Cursor
-- 3. ���� �÷� x ���� ��(**)
DECLARE
      vname tblinsa.name%type;
      CURSOR vcursor
      IS
      SELECT name FROM tblinsa ORDER BY name ASC; --Ŀ�� ����(�������� select ���� ��)
BEGIN

      OPEN vcursor; --Ŀ�� ����(�� �� select ����)

            LOOP
                  -- ���ڵ� �ϳ��ϳ��� Ŀ���� ����ؼ� ����
                  FETCH vcursor INTO vname;

                  -- Ŀ�� �Ӽ�
                  -- vcursor%notfound : �������� ������ false, �������� ������ true
                  EXIT WHEN vcursor%NOTFOUND ;

                  dbms_output.put_line(vname);
            END LOOP;

      CLOSE vcursor; --Ŀ�� �ݱ�(�ڿ� ���� �ڵ�)

END;





/*
PL/SQL�� ����ؼ� SELECT ������� �������� + ó���ϱ�

1. SELECT INTO : ���� ��
      a. ���� �÷� + ���� ��
      b. ���� �÷� + ���� ��

2. CURSOR : ���� ��
      a. ���� �÷� + ���� ��(���� ��)
      b. ���� �÷� + ���� ��(���� ��)

*/
--1. SELECT INTO : ���� ��
--       a. ���� �÷� + ���� ��
--       b. ���� �÷� + ���� ��
DECLARE
      vword VARCHAR2(30); --�˻���
      vcount NUMBER;

      vname VARCHAR2(100); -- first + last + ����
      vphone employees.phone_number%type;
      vsalary employees.salary%type;
BEGIN

      vword := 'D';

      SELECT count(*) INTO vcount FROM employees
            WHERE lower(first_name) like lower(vword) || '%'; --1.a

      -- ���� ������.. �˾Ƽ�..
      dbms_output.put_line('''' || vword || '''�� �����ϴ� ������ �� ' || vcount || '���Դϴ�.');


      -- select * from employees;

      -- �޿��� ���� ���� ��� : �̸� + ����ó + �޿�
      SELECT * INTO vname, vphone, vsalary
            FROM (SELECT first_name || ' ' ||  last_name as name, phone_number, salary
                  FROM employees ORDER BY salary DESC)
                        WHERE rownum = 1; --1.b

      dbms_output.put_line(vname);
      dbms_output.put_line(vphone);
      dbms_output.put_line(vsalary);

END;


-- 2. CURSOR : ���� ��
--       a. ���� �÷� + ���� ��(���� ��)

CREATE TABLE tblfullname
(
      name VARCHAR2(50) PRIMARY KEY
);

DECLARE
      CURSOR vcursor
      IS
      SELECT first_name || ' ' || last_name as name
            FROM employees
                  ORDER BY name asc;
      vname VARCHAR2(50);
BEGIN
      -- ��� ������ �̸�
      OPEN vcursor;

      LOOP
            FETCH vcursor INTO vname; --SELECT INTO ����
            EXIT WHEN vcursor%NOTFOUND;

            --�߰� ����..
            INSERT INTO tblfullname VALUES (vname);
            dbms_output.put_line(vname);

      END LOOP;

      CLOSE vcursor;
END;

SELECT * FROM tblfullname;


-- ������ + ���ϰ� -> cursor
DECLARE
      vcount NUMBER;
      CURSOR vcursor IS
            SELECT count(*) FROM employees WHERE first_name like 'D%';
BEGIN
      OPEN vcursor;
      --LOOP
            FETCH vcursor INTO vcount;
            --EXIT WHEN vcursor%NOTFOUND;
            dbms_output.put_line('��� : ' || vcount);
      --END LOOP;
      CLOSE vcursor;
END;



/*
�����÷� + ������
�����÷� + ������
*/
DECLARE
      CURSOR vcursor IS SELECT name, buseo, jikwi FROM tblinsa;
      vname tblinsa.name%type;
      vbuseo tblinsa.buseo%type;
      vjikwi tblinsa.jikwi%type;

      CURSOR vcursor2 IS SELECT * FROM tblname;
      vrow tblname%rowtype;

BEGIN
      OPEN vcursor;
      LOOP
            FETCH vcursor INTO vname, vbuseo, vjikwi;--SELECT * INTO vname,vbuseo,vjikwi
            EXIT WHEN vcursor%NOTFOUND;

            --�߰�����
            dbms_output.put_line(vname);
            dbms_output.put_line(vbuseo);
            dbms_output.put_line(vjikwi);
            dbms_output.put_line('--------');

      END LOOP;
      CLOSE vcursor;


      OPEN vcursor2;
      LOOP
            FETCH vcursor2 INTO vrow;
            EXIT WHEN vcursor2%NOTFOUND;

            --�߰�����..
            dbms_output.put_line(vrow.last || vrow.first);
            dbms_output.put_line(vrow.nick);
            dbms_output.put_line('-------');

      END LOOP;
      CLOSE vcursor2;

END;


/*
Cursor�� �⺻ ����
 : Ŀ�� ��ü ����(����) -> Ŀ�� ���� -> ����(����) -> ������ ���� + �������� -> Ŀ�� �ݱ�


CURSOR FOR LOOP
- Ŀ�� + LOOP ����
- Ŀ�� + FOR LOOP ���� : Ŀ�� ó�� �ܼ�ȭ
*/
DECLARE
      CURSOR vcusor IS
            SELECT * FROM tbltodo;
      vrow tbltodo%rowtype;
BEGIN
      OPEN vcusor;
      LOOP
            FETCH vcusor INTO vrow;
            EXIT WHEN vcusor%NOTFOUND;

            dbms_output.put_line(vrow.title || '(' ||
                                 CASE
                                          WHEN vrow.completedate IS NULL THEN '�̿Ϸ�'
                                          WHEN vrow.completedate IS NOT NULL THEN '�Ϸ�'
                                 END
                                 || ')');

      END LOOP;
      CLOSE vcusor;
END;




DECLARE
      CURSOR vcusor IS
            SELECT * FROM tbltodo;
      --vrow tbltodo%rowtype; --���������� ���
BEGIN

      --FOR i IN 1..10 LOOP   //for (int n : nums)
      --END LOOP;

      --Ŀ�� ���� ����

      FOR vrow IN vcusor LOOP -- FETCH vcursor INTO vrow
            dbms_output.put_line(vrow.title || '(' ||
                                 CASE
                                          WHEN vrow.completedate IS NULL THEN '�̿Ϸ�'
                                          WHEN vrow.completedate IS NOT NULL THEN '�Ϸ�'
                                 END
                                 || ')');
      END LOOP;

      --Ŀ�� �ݱ� ����
END;




-- �������� or �ζ��� �� -> Ŀ�� ��� ����
BEGIN
      FOR vrow IN (SELECT * FROM tbltodo) LOOP
            dbms_output.put_line(vrow.title);
      END LOOP;
END;


/*
EXCEPTION,
- ���� ó����
- ����ο��� �߻��ϴ� ���� ó�� ���
*/
DECLARE
      vdata NUMBER;
BEGIN
      dbms_output.put_line('����');
      SELECT name INTO vdata FROM tblinsa WHERE num = 1001;
      dbms_output.put_line('��');
END;



DECLARE
      vdata NUMBER;
BEGIN
      dbms_output.put_line('����');
      SELECT name INTO vdata FROM tblinsa WHERE num = 1001;
      dbms_output.put_line('��');
EXCEPTION
      -- �ڹ� catch��
      -- ���� ó�� �ڵ�
      WHEN OTHERS THEN --���� ����, �ڹ� catch(Exception e)
            dbms_output.put_line('���� ó��');
END;



-- ���ܹ߻� ���(�α� ���̺�)
CREATE TABLE tbllog
(
      seq NUMBER PRIMARY KEY, --�ĺ���(PK) -> DB �ĺ���
      code VARCHAR2(20) CHECK (code IN ('AAA0001', 'BBB0001', 'ZZZ0001')) NOT NULL,-- AAA0001... -> ���� �ĺ���
      message VARCHAR2(1000) NULL, --���� �޽���
      regdate DATE DEFAULT sysdate NOT NULL --�߻� �ð�
);
CREATE SEQUENCE logseq;


DECLARE
      vnum NUMBER;
      vname varchar2(30);
BEGIN
      SELECT 10000000 / count(*) INTO vnum FROM tblname; --����1
     --SELECT name INTO vname FROM tblinsa; --WHERE num = 1001; --����2
      SELECT name INTO vnum FROM tblinsa WHERE num = 1001; --����3

      dbms_output.put_line(vnum);
      dbms_output.put_line(vname);

EXCEPTION

      WHEN ZERO_DIVIDE THEN
            dbms_output.put_line('tblname�� �����Ͱ� �����ϴ�.');
            INSERT INTO tbllog VALUES (logseq.nextval, 'AAA0001', '��븮 ���', DEFAULT);
      WHEN TOO_MANY_ROWS THEN
            dbms_output.put_line('������ ������ �ʹ� �����ϴ�.');
            INSERT INTO tbllog VALUES (logseq.nextval, 'BBB0001', NULL, DEFAULT);
      WHEN OTHERS THEN
            dbms_output.put_line('�����ڿ� �����ϼ���.');
            INSERT INTO tbllog VALUES (logseq.nextval, 'ZZZ0001', NULL, DEFAULT);

END;

COMMIT ;
ROLLBACK;
DELETE FROM tblname;


SELECT * FROM tbllog;



/*
PL/SQL ���� Ʈ������� ����
*/

SELECT * FROM tbltodo;
COMMIT;
ROLLBACK;
INSERT INTO tbltodo VALUES (21, 'DB �𵨸� �۾�', sysdate, NULL);

DECLARE
      vseq NUMBER;
      vtitle tbltodo.title%type;
BEGIN
      vseq := 22;
      vtitle := '���ῡ ��ȸ���ϱ�';
      INSERT INTO tbltodo VALUES (vseq, vtitle, sysdate, NULL);
END;


/*
PL/SQL ������ Ʈ����� ó�� ���
1. ������ ��� ������ ���� -> COMMIT
2. ������ �Ϻ� ������ ����(���� �߻�) -> ROLLBACK
*/

DECLARE
      vcount NUMBER;
      vstate VARCHAR2(50);
BEGIN

      --���� 1.
      dbms_output.put_line('1');
      SELECT count(*) INTO vcount FROM tbltodo WHERE completedate IS NULL;
      dbms_output.put_line('2');

      --���� 2.
      IF vcount >= 10 THEN
            --���� �ʹ� ���� ��������
            vstate := '- ���� ó�� �䱸';
      ELSE
            --������ ������
            vstate := '- õõ�� �ص� ��';
      END IF;
      dbms_output.put_line('3');


      INSERT INTO tbltodo VALUES (22, '���ῡ ��ȸ��', sysdate, NULL);
      dbms_output.put_line('4');

      --���� 3.
      IF vcount >= 5 THEN
            UPDATE tbltodo SET completedate = '2018�� 1�� 22��';
      END IF;
      dbms_output.put_line('5');


      --��� ���� ����
      COMMIT;
-- oracle + transaction + exception
EXCEPTION
      WHEN OTHERS THEN
            --�α� insert (X)
            ROLLBACK;
            --�α� insert (O)
            --COMMIT ;
            dbms_output.put_line('6');
END;


SELECT * FROM tbltodo;

/*
�͸� �� -> �Ǹ� ��(������, ���� ��..)

���±��� ������ PL/SQL �� -> �̸� ���̱� -> ���� ����Ŭ ������ ���� -> ���� �� -> ���� ���α׷�
- �̸��� ���� PL/SQL ��
- ���� �ڵ� ���� -> ����Ŭ ���� ����
- ���� ���(���� �м� ~ ������ ���� ����)
- ��Ʈ��ũ Ʈ���� ����(�ڵ� ��ü ���� -> ���α׷� �̸��� ����)
- ���� ������ ������ �ڵ带 ��� ����(���� �ο�)

���� ���α׷� ����
1. ���� ���ν���, Stored Procedure
2. ���� �Լ�, Stored Function


���� ���ν��� ����

CREATE [OR REPLACE] PROCEDURE ���ν�����
IS[AS]
      [�����;]
BEGIN
      �����;
[EXCEPTION
      ����ó����]
END [���ν�����]; -- �ڹ��ּ� : m1()

*/

-- ���ν��� ����
CREATE OR REPLACE PROCEDURE proc_test
IS -- �͸� DECLARE ����
      vnum NUMBER;
BEGIN
      vnum := 100;
      dbms_output.put_line(vnum);
END;


/*
���ν��� ȣ��(����)

1. PL/SQL �������� ȣ��
- ���α׷��� ���
- �͸� �� or �ٸ� ���ν����� ȣ��
- �ַ� ���

2. ��ũ��Ʈ ȯ�濡�� ȣ��
- ������, �����
- execute, call
*/

--1.
BEGIN
      SELECT * FROM tblname;
END;

--2.
SELECT * FROM tblname;

--1. �͸� PL/SQL ������ ȣ���ϱ�
BEGIN
      proc_test; --���ν��� ȣ��
      proc_test();
END;

-- proc_test();

--1. �Ǹ� PL/SQL ������ ȣ���ϱ�
CREATE or REPLACE PROCEDURE proc_hello
IS
BEGIN
      proc_test; --���ν��� ȣ��
END;

BEGIN
      proc_hello;
END;


--2. ��ũ��Ʈ ȣ��
EXEC proc_test;
EXECUTE proc_test;
CALL proc_test();


/*
�Ű������� �ִ� ���ν���
- �ڹ��� �޼ҵ��� �Ű������� ����
*/
CREATE OR REPLACE PROCEDURE proc_print(pnum NUMBER)
IS
      vresult NUMBER;
BEGIN
      vresult := pnum * 2;
      dbms_output.put_line(vresult);
END;

BEGIN
      proc_print(100);
END;

DROP PROCEDURE pro_area;

CREATE OR REPLACE PROCEDURE proc_area
(
      pwidth NUMBER,
      pheight NUMBER
)
IS
      varea NUMBER;
BEGIN
      varea := pwidth * pheight;
      dbms_output.put_line(varea);
END;

BEGIN
      proc_area(100, 200);
END;



CREATE OR REPLACE PROCEDURE proc_area
(
      pwidth NUMBER DEFAULT 10,
      pheight NUMBER DEFAULT 20
)
IS
      varea NUMBER;
BEGIN
      varea := pwidth * pheight;
      dbms_output.put_line(varea);
END;

BEGIN
      proc_area(100, 200);
      proc_area(300);
      proc_area;
END;


/*

�Ű����� ���� ���
1. Call by Value
2. Call by Reference
3. Out Parameter



�Ű����� �۵� ���
- �Ű������� ���� �����ϴ� ���

1. IN ���
- �⺻ ���

2. OUT ���
3. IN OUT ���
*/
CREATE OR REPLACE PROCEDURE proc_sum
(
      vnum1 NUMBER,
      vnum2 NUMBER
)
IS
      vresult NUMBER;
BEGIN
      vresult := vnum1  + vnum2;
      dbms_output.put_line(vresult);
END;

BEGIN
      proc_sum(10, 20);
END;



CREATE OR REPLACE PROCEDURE proc_sum
(
      vnum1 IN NUMBER, -- in �Ķ����
      vnum2 IN NUMBER,
      vresult OUT NUMBER, -- out �Ķ����(��ȯ��)
      vresult2 OUT NUMBER
)
IS
      --vresult NUMBER;
BEGIN
      vresult := vnum1  + vnum2;
      vresult2 := vnum1 * vnum2;
      --dbms_output.put_line(vresult);
END;

BEGIN
      proc_sum(10, 20);
END;

DECLARE
      vresult NUMBER;
      vresult2 NUMBER;
BEGIN
      vresult := 100; -- out ������ �ʱ�ȭX
      proc_sum(30, 40, vresult, vresult2);
      dbms_output.put_line(vresult);
      dbms_output.put_line(vresult2);
END;




-- �˻�
--  ��ȣ -> ���� ���� ���
CREATE OR REPLACE PROCEDURE proc_getinsa
(
      pnum NUMBER
)
IS
      vrow tblinsa%rowtype;
BEGIN
      SELECT * INTO vrow FROM tblinsa
            WHERE num = pnum;
      dbms_output.put_line(vrow.name);
      dbms_output.put_line(vrow.buseo);
      dbms_output.put_line(vrow.jikwi);
END;


BEGIN
      proc_getinsa(1050);
      proc_getinsa(1051);
      proc_getinsa(1052);
END;


-- tblname -> ���� �߰��ϱ�
CREATE OR REPLACE PROCEDURE proc_addname
(
      pfirst VARCHAR2,
      plast VARCHAR2,
      pgender VARCHAR2,
      pheight NUMBER,
      pweight NUMBER,
      pnick VARCHAR2
)
IS
      vcount NUMBER; --���������� �������?
BEGIN
--       dbms_output.put_line(pfirst);
--       dbms_output.put_line(plast);
--       dbms_output.put_line(pgender);
--       dbms_output.put_line(pheight);
--       dbms_output.put_line(pweight);
--       dbms_output.put_line(pnick);

      -- ���� �̸��� �ִ���?
      SELECT count(*) INTO vcount FROM tblname
            WHERE first = pfirst AND last = plast;

      IF vcount = 0 THEN
            INSERT INTO tblname (first, last, gender, height, weight, nick)
                  VALUES (pfirst, plast, pgender, pheight, pweight, pnick);
      ELSE
            dbms_output.put_line('���� ���� �߰�');
      END IF;

END;

BEGIN
      proc_addname('����', '��', 'm', 180, 60, '����');
      --proc_addname('�浿', 'ȫ', 'm', 180, 60, '����');
END;


SELECT * FROM tblname;



-- employees -> ��ȣ(PK) �Է� -> �̸�(��+�̸�) ��ȯ -> tblfullname�� �߰�
CREATE OR REPLACE PROCEDURE proc_addfullname
(
      id NUMBER
)
IS
      vname VARCHAR2(50);
BEGIN
      SELECT first_name || ' ' || last_name INTO vname FROM employees
            WHERE employee_id = id;
      INSERT INTO tblfullname VALUES (vname);
END;

SELECT * FROM employees;
SELECT * FROM tblfullname;

TRUNCATE TABLE tblfullname;

BEGIN
      proc_addfullname(100);
      proc_addfullname(123);
      proc_addfullname(158);
END;



--1. ID -> Full Name ��ȯ
CREATE OR REPLACE PROCEDURE proc_getfullname
(
      pid IN VARCHAR2,
      pname OUT VARCHAR2
)
IS
BEGIN
      SELECT first_name || ' ' || last_name INTO pname FROM employees
            WHERE employee_id = pid;
END;

--2. Full Name -> insert
CREATE OR REPLACE PROCEDURE proc_inserftfullname
(
      pname IN VARCHAR2
)
IS
BEGIN
      INSERT INTO tblfullname VALUES (pname);
END;

-- ����
DECLARE
      vname VARCHAR2(50);
BEGIN
      --1.
      proc_getfullname(135, vname);
      --2.
      proc_inserftfullname(vname);
END;

SELECT * FROM tblfullname;


--���� -> ���ν��� ����
CREATE OR REPLACE PROCEDURE proc_addfullname
(
      vid NUMBER
)
IS
      vname VARCHAR2(50);
BEGIN
      --1.
      proc_getfullname(vid, vname);
      --2.
      proc_inserftfullname(vname);
END;


BEGIN
      proc_addfullname(167);
      proc_addfullname(168);
      proc_addfullname(169);
END;

SELECT * FROM tblfullname;


-- 2���� �Ű����� ���
CREATE OR REPLACE PROCEDURE proc_getname(
      pnum IN NUMBER, --���� ��ȣ(�Ű�����)
      pname OUT VARCHAR2 --������(��ȯ��)
)
IS
      --vname VARCHAR2(30);
BEGIN
      SELECT name INTO pname FROM tblinsa WHERE num = pnum;

      --���� �̸��� ������ �ٸ� ���̺� UPDATE ����
      --UPDATE table set name = vname...
END;


DECLARE
      vname VARCHAR2(50);
BEGIN
      proc_getname(1001, vname);
      dbms_output.put_line(vname);
END;

CREATE TABLE tbladdress
(
      seq NUMBER PRIMARY KEY, --PK
      name VARCHAR2(30) NOT NULL , --�̸�
      age NUMBER(3) NOT NULL , --����
      tel VARCHAR2(15) NOT NULL , --��ȭ��ȣ
      address VARCHAR2(500) NOT NULL , --�ּ�
      regdate DATE DEFAULT sysdate NOT NULL --�����
);
CREATE SEQUENCE address_seq; --addressSeq

-- �ּҷ� �׸��� �߰��ϴ� ���ν��� + CRUD
CREATE OR REPLACE PROCEDURE proc_add_address(
      pname VARCHAR2,
      page NUMBER,
      ptel VARCHAR2,
      paddress VARCHAR2,
      presult OUT NUMBER --���� ����
)
IS
BEGIN
      INSERT INTO tbladdress (seq, name, age, tel, address)
            VALUES (address_seq.nextval, pname, page, ptel, paddress);
      presult := 1; --����
      COMMIT;
EXCEPTION
      WHEN OTHERS THEN
            presult := 0; --����
            ROLLBACK;
END;

DECLARE
      vresult NUMBER; --��������
BEGIN
      proc_add_address('ȫ�浿', 1234, '010-1111-2222', '����� ������ ���ﵿ', vresult);

      IF vresult = 1 THEN
            dbms_output.put_line('�ּҷ� �߰� �Ϸ�');
      ELSE
            dbms_output.put_line('�ּҷ� �߰� ����');
      END IF;
END;



-- R : ��ȣ -> 1��� ����
-- ��ȯ���� ���� �÷� or ���� �� ���ν���
-- 1. OUT �Ű����� : ���� ��
-- 2. CURSOR : ���� ��
CREATE OR REPLACE PROCEDURE proc_read_address(
      pseq IN NUMBER, --�ּҷ� ��ȣ
      pname OUT VARCHAR2,
      page OUT NUMBER,
      ptel OUT VARCHAR2,
      paddress OUT VARCHAR2,
      pregdate OUT DATE,
      presult OUT NUMBER --���� ����
)
IS
BEGIN
      SELECT name, age, tel, address, regdate
            INTO pname, page, ptel, paddress, pregdate
                  FROM tbladdress
                        WHERE seq = pseq;
      presult := 1;
EXCEPTION
      WHEN OTHERS THEN
            presult := 0;
END;

DECLARE
      vname VARCHAR2(30);
      vage NUMBER(3);
      vtel VARCHAR2(15);
      vaddress VARCHAR2(50);
      vregdate DATE;
      vresult NUMBER;
BEGIN
      proc_read_address(0, vname, vage, vtel, vaddress, vregdate, vresult);
      IF vresult = 1 THEN
            dbms_output.put_line(vname);
            dbms_output.put_line(vage);
            dbms_output.put_line(vtel);
            dbms_output.put_line(vaddress);
            dbms_output.put_line(vregdate);
      ELSE
            dbms_output.put_line('�ּҷ� �б� ����');
      END IF;
END;





-- U : ����(seq ���� ��� ��)
CREATE OR REPLACE PROCEDURE proc_edit_address(
      pseq NUMBER,
      pname VARCHAR2,
      page NUMBER,
      ptel VARCHAR2,
      paddress VARCHAR2,
      presult OUT NUMBER
)
IS
      vcount NUMBER;
BEGIN

      SELECT count(*) INTO vcount FROM tbladdress WHERE seq = pseq;

      IF vcount = 1 THEN
            UPDATE tbladdress SET
                  name = pname,
                  age = page,
                  tel = ptel,
                  address = paddress
                        WHERE seq = pseq;
            presult := 1;
            COMMIT;
      ELSE
            presult := 2;
      END IF;

EXCEPTION
      WHEN OTHERS THEN
            presult := 0;
            ROLLBACK ;
END;


-- name, age, tel, address, regdate
DECLARE
      vresult NUMBER;
BEGIN

      proc_edit_address(2, 'ȫ�浿', 21, '010-1111-2222', '����� ������ ���ﵿ', vresult);

      IF vresult = 1 THEN
            dbms_output.put_line('�ּҷ� ���� �Ϸ�');
      ELSIF vresult = 0 THEN
            dbms_output.put_line('�ּҷ� ���� ����');
      ELSIF vresult = 2 THEN
            dbms_output.put_line('���� ��� ����');
      END IF;

END;





-- D : ��ȣ -> ����
CREATE OR REPLACE PROCEDURE proc_del_address (
      vseq NUMBER,
      vresult OUT NUMBER
)
IS
      vcount NUMBER;
BEGIN
      SELECT  count(*) INTO vcount FROM tbladdress WHERE seq = vseq;

      IF vcount = 1 THEN
            DELETE FROM tbladdress WHERE seq = vseq;
            vresult := 1;
            COMMIT;
      ELSE
            vresult := 2;
      END IF;

EXCEPTION
      WHEN OTHERS THEN
            vresult := 0;
            ROLLBACK;
END;


DECLARE
      vresult NUMBER;
      RCOMPLETE CONSTANT NUMBER := 1;
      RNOTFOUND CONSTANT NUMBER := 2;
      RFAILD CONSTANT NUMBER := 0;
BEGIN

      proc_del_address(1, vresult);

      IF vresult = RCOMPLETE THEN
            dbms_output.put_line('�ּҷ� ���� �Ϸ�');
      ELSIF vresult = RNOTFOUND THEN
            dbms_output.put_line('���� ��� ����');
      ELSIF vresult = RFAILD THEN
            dbms_output.put_line('�ּҷ� ���� ����');
      END IF;

END;



-- �θ� ���̺�(PK) <-> �ڽ� ���̺�(FK + �Ϲ� �÷�) : ��ĺ� ����
-- �θ� ���̺�(PK) <-> �ڽ� ���̺�(FK + PK �÷�) : �ĺ� ����

-- ȸ�� ����
-- 1. ȸ�� ���� ���̺�
-- 2. ȸ�� �ΰ� ���� ���̺�
CREATE TABLE tblmain ( --�ֿ� ���� ���̺�
      seq NUMBER PRIMARY KEY , --�ĺ���(PK)
      id VARCHAR2(30) UNIQUE NOT NULL, --���̵�
      pw VARCHAR2(30) NOT NULL , --��ȣ
      name VARCHAR2(50) NOT NULL --�̸�
);

CREATE TABLE tblsub ( --�ΰ� ���� ���̺�
      seq NUMBER PRIMARY KEY , --�ĺ���(PK)
      age NUMBER NULL , --����
      tel VARCHAR2(15) NULL, --����ó
      address VARCHAR2(100) NULL, --�ּ�
      --id VARCHAR2(30) REFERENCES tblmain(id) NOT NULL --���̵�(FK)
      mseq NUMBER REFERENCES tblmain(seq) NOT NULL --ȸ����ȣ(FK)
);

DROP TABLE tblmain;
DROP TABLE tblsub;


--ȸ�� ���� ���ν���
CREATE or REPLACE PROCEDURE proc_register(
      pid VARCHAR2,
      ppw VARCHAR2,
      pname VARCHAR2,
      page NUMBER,
      ptel VARCHAR2,
      paddress VARCHAR2
)
IS
      vseq NUMBER;
BEGIN

      --1. �ֿ� ���� �߰�
      INSERT INTO tblmain (seq, id, pw, name)
            VALUES (mainseq.nextval, pid, ppw, pname);

      --1.5 ������ ȸ�� ��ȣ�� ��������
      SELECT max(seq) INTO vseq FROM tblmain;

      --2. �ΰ� ���� �߰�
      INSERT INTO tblsub (seq, age, tel, address, mseq)
            VALUES (subseq.nextval, page, ptel, paddress, vseq);

END;


--������ ��ü
CREATE SEQUENCE mainseq;
CREATE SEQUENCE subseq;


-- ȸ�� ���� -> ���̵�(UNIQUE)
CREATE OR REPLACE PROCEDURE proc_idcheck(
      pid VARCHAR2,
      presult OUT NUMBER
)
IS
BEGIN
      SELECT count(*) INTO presult FROM tblmain WHERE id = pid;
END;


DECLARE
      vresult NUMBER;
BEGIN
      proc_idcheck('test', vresult);

      IF vresult = 1 THEN
            dbms_output.put_line('�̹� ������Դϴ�.');
      ELSE
            dbms_output.put_line('����� �����մϴ�.');
      END IF;
END;


BEGIN
      proc_register('hong', '111', 'ȫ�浿', 20, '010-1111-1111', '�����');
END;



SELECT * FROM tblstaff;
SELECT * FROM tblproject;

-- 1. �ű� ��� �Ի� + ������Ʈ �Ҵ�
BEGIN
      proc_add_employee(7, '������', 180, '�λ��', 7, '���� ����');
END;

-- 2. ���� ��� + ���� ����
BEGIN
      proc_del_employee(7, 2);
END;


CREATE OR REPLACE PROCEDURE proc_add_employee(
      pseq NUMBER,
      pname VARCHAR2,
      psalary NUMBER,
      paddress VARCHAR2,
      ppseq NUMBER,
      pproject VARCHAR2
)
IS
BEGIN
      INSERT INTO tblstaff VALUES (pseq, pname, psalary, paddress);
      --INSERT INTO tblstaff VALUES (staffseq.nextval, pname, psalary, paddress);

      INSERT INTO tblproject VALUES (ppseq, pproject, pseq);
      --INSERT INTO tblproject VALUES (projectseq.nextval, pproject, staffseq.currval);
END;


CREATE OR REPLACE PROCEDURE proc_del_employee(
      pseq1 NUMBER,
      pseq2 NUMBER
)
IS
BEGIN

      UPDATE tblproject SET staff = pseq2 WHERE pseq1;

      DELETE FROM tblstaff WHERE seq = pseq1;

END;




/*
���� ���α׷�
1. ���ν���
2. �Լ�

�Լ�, Function
- ����(1�� �̻�) -> ��ȯ��(1��) ���ν���
- ����� OUT �Ķ���͸� ������� ����  ->  return �� ���
*/

--���ν���
CREATE OR REPLACE PROCEDURE proc_aaa(
      pnum1 NUMBER,
      pnum2 NUMBER,
      presult OUT NUMBER
)
IS
BEGIN
      presult := pnum1 + pnum2;
END;


--���ν��� ���
DECLARE
      vresult NUMBER;
      vheight NUMBER;
      vweight NUMBER;
      CURSOR vcursor IS
            SELECT height, weight FROM TBLNAME;
BEGIN

      --���ν��� + ���(����)
      proc_aaa(10, 20, vresult);
      dbms_output.put_line(vresult);

      --SELECT -> �÷� 2�� -> ���ν��� + �÷���
      SELECT height, weight INTO vheight, vweight
            FROM tblname WHERE nick = '�޶ѱ�';

      proc_aaa(vheight, vweight, vresult);
      dbms_output.put_line(vresult);


      --SELECT -> �÷� 2�� -> ���ν��� + �÷��� x ���ڵ� ��
      OPEN vcursor;
      LOOP
            FETCH vcursor INTO vheight, vweight;
            EXIT WHEN vcursor%NOTFOUND;

            --���ν��� ȣ��
            proc_aaa(vheight, vweight, vresult);
            dbms_output.put_line(vresult);

      END LOOP;
      CLOSE vcursor;

END;


--�Լ�
CREATE OR REPLACE FUNCTION fn_bbb(
      vnum1 NUMBER,
      vnum2 NUMBER
) RETURN NUMBER
IS
BEGIN
      return vnum1 + vnum2;
END;


DECLARE
      vresult NUMBER;
      CURSOR vcursor IS
            SELECT fn_bbb(height, weight) as result FROM tblname;
BEGIN

      proc_aaa(10, 20, vresult); --OUT

      --�Լ� + ���(����)
      vresult := fn_bbb(10, 20); --return
      dbms_output.put_line(vresult);



      --SELECT height, weight INTO vheight, vweight
      --     FROM tblname WHERE nick = '�޶ѱ�';
      --proc_aaa(vheight, vweight, vresult);
      --vresult := fn_bbb(vheight, vweight);


      SELECT fn_bbb(height, weight) INTO vresult
            FROM tblname WHERE nick = '�޶ѱ�';

      dbms_output.put_line(vresult);



      --SELECT fn_bbb(height, weight) FROM tblname;

      FOR aaa IN (SELECT fn_bbb(height, weight), first || last as name FROM tblname) LOOP
            dbms_output.put_line(aaa.name);
      END LOOP;

END;


/*
���ν��� vs �Լ� ������
1. �Ű�����
      a. ���ν��� : 0 ~ �������..
      b. �Լ� : 1�� ~ �������..
2. ��ȯ��
      a. ���ν��� : 0 ~ �������.. + OUT ���
      b. �Լ� : 1�� + return ���
3. ��� ��ġ
      a. ���ν��� : PL/SQL �Ϻη�..
      b. �Լ� : ǥ�� SQL �Ϻη�..
*/


-- tblinsa -> ����
SELECT name, substr(ssn, 8, 1) FROM tblinsa;

SELECT name,
      CASE
            WHEN substr(ssn, 8, 1) = '1' THEN '����'
            WHEN substr(ssn, 8, 1) = '2' THEN '����'
      END
FROM tblinsa;

CREATE OR REPLACE FUNCTION fn_get_gender(
      pssn VARCHAR2 --ssn
) RETURN VARCHAR2
IS
BEGIN
      CASE
            WHEN substr(pssn, 8, 1) = '1' THEN RETURN '����';
            WHEN substr(pssn, 8, 1) = '2' THEN RETURN '����';
            ELSE RETURN NULL;
      END CASE;
END;

SELECT name, fn_get_gender(ssn) FROM tblinsa;

/*
Ʈ����, Trigger
- ���ν����� ����
- Ư�� ����� �߻��ϸ� �ڵ����� ����Ǵ� ���ν���
- ������ ����(X), DBMS ����(O)
- Ư�� ��� : Ư�� ���̺��� ������� ����Ŭ �ǽð� ����(INSERT, UPDATE, DELETE) -> �̸� �غ��� ���� ���ν����� ȣ���Ѵ�.
- ������ �۾��� �ս��� ����(����� ���� �ϴ°ͺ��� ����)
- �ǽð� ���� : ��� �߻� -> �ʹ� ���� ����ϸ� ������.



Ʈ���� ����

CREATE OR REPLACE TRIGGER Ʈ���Ÿ�
      --Ʈ���� �ɼ�
      BEFORE|AFTER --��� �߻� ��|��
      INSERT|UPDATE|DELETE --�������
      ON ���̺�� --��� ��� ���̺�
      [FOR EACH ROW]
DECLARE
      �����;
BEGIN
      �����;
EXCEPTION
      ���ܺ�;
END

*/

-- Ư�� ����(��)���� tblname�� �����͸� ������ �� ����.(��, SELECT�� ����)
CREATE OR REPLACE TRIGGER trg_name
      BEFORE
      INSERT OR UPDATE OR DELETE
      ON tblname
BEGIN
      --����..
      --dbms_output.put_line('trg_name Ʈ���Ű� ����Ǿ����ϴ�.');
      IF to_char(sysdate, 'd') = 5 THEN
            -- ������ ���� �߻�, ����� ���� ���� �߻�
            -- �ڹ� : throw new Exception();
            -- ���� : -20000 ~ -29990
            raise_application_error(-20000, '����Ͽ��� tblname ������ �Ұ����մϴ�.');
      END IF;
END;

--tblname
SELECT * FROM tblname;

INSERT INTO tblname VALUES ('ȣȣ', 'ȣ', 'f', 165, 50, '�����');

UPDATE tblname SET first = '����' WHERE nick = '�����';



-- �α� Ʈ����
-- tblname�� ��ȭ�� ����� ���߿� �����ڰ� ���� ���� �α׸� �������
DROP  table tbllog;

CREATE TABLE tbllog (
      seq NUMBER PRIMARY KEY,
      message VARCHAR2(1000) NOT NULL,
      regdate DATE DEFAULT sysdate NOT NULL
);
CREATE SEQUENCE logseq;

DROP TRIGGER trg_name;

CREATE OR REPLACE TRIGGER trg_name
      AFTER
      INSERT OR DELETE
      ON tblname
DECLARE
      vmessage varchar2(1000);
BEGIN

      IF INSERTING THEN
            vmessage := 'tblname ���̺�� ���ο� ���� �߰��Ǿ����ϴ�.';
      ELSIF DELETING THEN
            vmessage := 'tblname ���̺�� ���� ���� �����Ǿ����ϴ�.';
      ELSE
            vmessage := '��Ÿ';
      END IF;

      INSERT INTO tbllog (seq, message, regdate)
            VALUES (logseq.nextval, vmessage, DEFAULT );--�α� ���


END;

DELETE FROM tblname WHERE nick =  '�����';
INSERT INTO tblname VALUES ('ȣȣ', 'ȣ', 'f', 165, 50, '�����');

SELECT * FROM tbllog;



/*
[FOR EACH ROW]

1. ����
- ���� ���� Ʈ����
- Ʈ���� ���� Ƚ�� 1ȸ : ��� �߻� 1ȸ -> Ʈ���� ���� 1ȸ
- DELETE FROM tblinsa WHERE buseo = '������'; -> "������ ���� ����"

2. ǥ��
- �� ���� Ʈ����
- Ʈ���� ���� Ƚ�� �ݺ� : ����� ����ȴ� ���� ���� -> Ʈ���� ���� Ƚ��
- DELETE FROM tblinsa WHERE buseo = '������'; -> "������ ���� 1�� 1��.. ����"

*/
SELECT * FROM tbladdress;

DECLARE
      vresult NUMBER;
BEGIN
      proc_add_address('ȫ�浿', 20, '010-1234-5678', '�����', vresult);
      proc_add_address('�ƹ���', 22, '010-5555-5555', '�����', vresult);
      proc_add_address('������', 23, '010-6666-6666', '�����', vresult);
END;

CREATE OR REPLACE TRIGGER trg_address
      AFTER
      UPDATE
      ON tbladdress
	FOR EACH ROW
BEGIN
      dbms_output.put_line('[' || to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss')
                                                || '] �ּҷ��� �����Ǿ����ϴ�.');
END;

UPDATE tbladdress SET age = 30 WHERE name = 'ȫ�浿';
UPDATE tbladdress SET age = 27 WHERE name = '�ƹ���';
UPDATE tbladdress SET address = '�����';
UPDATE tbladdress SET address = '��õ��' WHERE floor(age / 10) = 2;

SELECT * FROM tbladdress;



/*
FOR EACH ROW �� ����ϴ� ���
- ��� ����
- :old, :new : ��� ���� ������ ����ϸ� ����� �߻���Ų �����Ϳ� ���� ����

1. INSERT �۾� �߻�
- Ʈ���ų����� ��� INSERT �� ���� �÷����� �����ϰ� �ʹ�.
- :new <- ��� �߰��� �� ���� ����
- :new.�÷��� <- ��� �߰��� ���� Ư�� �÷��� ����
- :old ��� �Ұ�
- AFTER Ʈ���ſ����� ��� ����(BEFORE ��� �Ұ�)

2. UPDATE �۾� �߻�
- Ʈ���ų����� ��� ������ ���� �����Ǳ� ���� ���� �����Ǵ� �� ���� ���� �����ϰ� �ʹ�.
- :new <- ��� ������ ���� �� ����
- :old <- ��� �����Ǳ� ���� �� ����

3. DELETE �۾� �߻�
- Ʈ���ų����� ��� ������ ���� ���� �����ϰ� �ʹ�.
- :old <- ��� ������ �� ����

*/

-- �Խ���
CREATE TABLE tblboard
(
      seq NUMBER PRIMARY KEY, --�۹�ȣ(PK)
      subject varchar2(1000) NOT NULL , --����
      content varchar2(2000) NOT NULL , --����
      comment_count NUMBER DEFAULT 0 NOT NULL  --�ۿ� �޸� ��� ��
);

-- ���
CREATE TABLE tblcomment
(
      seq NUMBER PRIMARY KEY, --��� ��ȣ(PK)
      subject varchar2(1000) NOT NULL , --����
      content varchar2(2000) NOT NULL , --����
      board_seq NUMBER REFERENCES tblboard(seq) --�θ�� ��ȣ(FK)
);

CREATE SEQUENCE boardseq;
CREATE SEQUENCE commentseq;

-- �۾���
INSERT INTO tblboard
      VALUES (boardseq.nextval, '�Խ����Դϴ�.', '�����Դϴ�.', DEFAULT);

INSERT INTO tblboard
      VALUES (boardseq.nextval, '����Ŭ Ʈ���� ����� ��..', '�����Դϴ�.', DEFAULT);

INSERT INTO tblboard
      VALUES (boardseq.nextval, '������Ʈ ȸ�� �����Դϴ�.', '�����Դϴ�.', DEFAULT);

-- ��� ����
INSERT INTO tblcomment
      VALUES (commentseq.nextval, '�䱸 �м� �ڷ��Դϴ�.', '����', 2);

UPDATE tblboard SET
      comment_count = comment_count + 1 WHERE seq = 3;

SELECT * FROM tblboard;
SELECT * FROM tblcomment;


-- m1. Ʈ������� �ɾ���� ���ν��� ����
-- CREATE OR REPLACE PROCEDURE ��۾���(
--       ...
-- )
-- IS
-- BEGIN
--       INSERT :  ��۾���;
--       UPDATE : ��ۼ� ����
--       COMMIT;
-- END;

-- m2. tblcomment ���̺� INSERT�� ���� Ʈ���� ����
CREATE or REPLACE TRIGGER trg_comment_add
      AFTER
      INSERT OR DELETE
      ON tblcomment
      FOR EACH ROW -- :old, :new
BEGIN
      dbms_output.put_line('��� ���� �Ϸ�');

      --INSERT INTO tblcomment
      --    VALUES (commentseq.nextval, '�䱸 �м� �ڷ��Դϴ�.', '����', 3);

      IF INSERTING THEN
            UPDATE tblboard SET
                  comment_count = comment_count + 1 WHERE seq = :new.board_seq;
      ELSIF DELETING THEN
            UPDATE tblboard SET
                  comment_count = comment_count - 1 WHERE seq = :old.board_seq;
      END IF ;

END;


DELETE FROM tblcomment WHERE seq = 1;

SELECT * FROM tblcomment;
SELECT * FROM tblboard;







-- ȸ�� ���̺�(����Ʈ) + �Խ��� ���̺� + ��� ���̺�
-- : �Խ��� ���� ���� ȸ������ ����Ʈ 100 ����
-- : ����� ���� ȸ������ ����Ʈ 20 ����

SELECT * FROM tabs;

DROP TABLE tblcomment;
DROP TABLE tblboard;
DROP TABLE tblrent;
DROP TABLE tblmember;

--ȸ�� ���̺�
CREATE TABLE tblmember
(
      seq NUMBER PRIMARY KEY, --�⺻Ű
      name VARCHAR2(30) NOT NULL , --�̸�
      point NUMBER DEFAULT 1000 NOT NULL --����Ʈ(�⺻ 1000)
);

--�Խ��� ���̺�
CREATE TABLE tblboard
(
      seq NUMBER PRIMARY KEY , --�۹�ȣ
      subject varchar2(1000) NOT NULL , --����
      mseq NUMBER REFERENCES tblmember(seq) NOT NULL, --�۾���(FK)
      comment_count NUMBER DEFAULT 0 NOT NULL --��� ��
);

--��� ���̺�
CREATE TABLE tblcomment
(
      seq NUMBER PRIMARY KEY , --��۹�ȣ
      subject varchar2(1000) NOT NULL , --����
      mseq NUMBER REFERENCES tblmember(seq) NOT NULL, --�۾���(FK)
      board_seq NUMBER REFERENCES tblboard(seq) NOT NULL --�θ�۹�ȣ(FK)
);

INSERT INTO tblmember VALUES (1, 'ȫ�浿', DEFAULT);





-- �Խ��� �۾��� -> ����Ʈ 100 ����
CREATE OR REPLACE TRIGGER trg_board
      AFTER
      INSERT
      ON tblboard
      FOR EACH ROW
BEGIN

      --:new.mseq --��� �Խù��� �ۼ��� ȸ�� ��ȣ
      UPDATE tblmember SET
            point = point + 100 where seq = :new.mseq;

END;



-- ��� �۾��� -> ����Ʈ 20 ����
CREATE OR REPLACE TRIGGER trg_comment
      AFTER
      INSERT
      ON tblcomment
      FOR EACH ROW
BEGIN

      --:new.mseq --��� �Խù��� �ۼ��� ȸ�� ��ȣ
      UPDATE tblmember SET
            point = point + 20 where seq = :new.mseq;

END;


INSERT INTO tblboard VALUES (boardseq.nextval, '�׽�Ʈ', 1, DEFAULT);
INSERT INTO tblcomment VALUES (commentseq.nextval, '�׽�Ʈ', 1, 4);

SELECT * FROM tblboard;
SELECT * FROM tblmember;
SELECT * FROM tblcomment;




/*
DB Object ���� �ܰ�

1. ���̺� ����
2. �� ����
3. �ε��� ����
4. SQL ����(SELECT, UPDATE, INSERT, DELETE) - �䱸 ����
5. �Լ� or ���ν��� ���� + Ʈ���� ����
6. ���� ������ Ȯ��

*/

--�̸� �ϼ��� SQL -> ���ν��� ����

--1. �߰� �۾�
CREATE OR REPLACE PROCEDURE �߰��۾�(
      �߰� ������ -> IN �Ű� ����
      ���� ���� ��ȯ -> OUT �Ű� ����
)
IS
      ���� ����
BEGIN
      INSERT..
      COMMIT;
EXCEPTION
      WHEN OTHERS THEN
            �����۾�..
            ROLLBACK;
END;


--2. ���� �۾�
CREATE OR REPLACE PROCEDURE �����۾�(
      �߰� ������ -> IN �Ű� ����
      ���� ���� ��ȯ -> OUT �Ű� ����
)
IS
      ���� ����
BEGIN
      UPDATE..
      COMMIT;
EXCEPTION
      WHEN OTHERS THEN
            �����۾�..
            ROLLBACK;
END;



--3. ���� �۾�
CREATE OR REPLACE PROCEDURE �����۾�(
      ���� ������ -> IN �Ű� ����
      ���� ���� ��ȯ -> OUT �Ű� ����
)
IS
      ���� ����
BEGIN
      DELETE..
      COMMIT;
EXCEPTION
      WHEN OTHERS THEN
            �����۾�..
            ROLLBACK;
END;


--4. �б� �۾� - ���� ���� + ��ȯ (���� �÷� + ���� ���ڵ�)
CREATE OR REPLACE PROCEDURE �б��۾�(
      ���� ������ IN �Ű����� ���
      ���� ��ȯ�� OUT �Ű����� ���
)
IS
      ���� ����
BEGIN
      SELECTG
      COMMIT;
EXCEPTION
      WHEN OTHERS THEN
            �����۾�..
            ROLLBACK;
END;



--4. �б� �۾� - ���� ���� + ��ȯ (���� �÷� + ���� ���ڵ�)
CREATE OR REPLACE PROCEDURE �б��۾�(
      ���� ������ IN �Ű����� ���
      ��ȯ�� OUT �Ű����� ���
      ��ȯ�� OUT �Ű����� ���
      ��ȯ�� OUT �Ű����� ���
      ��ȯ�� OUT �Ű����� ���
)
IS
      ���� ����
BEGIN
      SELECT
      COMMIT;
EXCEPTION
      WHEN OTHERS THEN
            �����۾�..
            ROLLBACK;
END;





--4. �б� �۾� - ���� ���� + ��ȯ (�÷� + ���� ���ڵ�)
SELECT * FROM tblinsa WHERE buseo = '?';

CREATE OR REPLACE PROCEDURE proc_get_buseo(
      pbuseo IN VARCHAR2, --����
      presult OUT SYS_REFCURSOR --��ȯ������ ����ϴ� CURSOR �ڷ��� :��� ���̺� �ڽ�
)
IS
      --CURSOR  vcursor IS SELECT ...
BEGIN

      OPEN presult
            FOR SELECT * FROM tblinsa WHERE buseo = pbuseo;

      --CLOSE presult;

END;


DECLARE
      vresult SYS_REFCURSOR;
      vrow tblinsa%rowtype;
BEGIN
      proc_get_buseo('������', vresult); -- SELECT -> ������� Ŀ�� ���·� ��ȯ

      --SYS_REFCURSOR : FOR LOOP ��� �Ұ�
      LOOP
            FETCH vresult INTO vrow;
            EXIT WHEN vresult%NOTFOUND;

            dbms_output.put_line(vrow.name || ' - ' || vrow.buseo);
      END LOOP;

END;







/*
�⺻Ű -> ����Ű(Composite Key)
*/

CREATE TABLE tblparent
(
      father VARCHAR2(50) NOT NULL ,--�ƺ�
      mother VARCHAR2(50) NOT NULL , --����
      tel VARCHAR2(15) NOT NULL ,
      address VARCHAR2(100) NOT NULL,
      CONSTRAINT tblparent_father_mother_pk PRIMARY KEY(father, mother)
);

INSERT INTO tblparent VALUES ('ȫ�浿', 'ȣȣȣ', '010-1111-1111', '�����');
INSERT INTO tblparent VALUES ('�ƹ���', '�׽�Ʈ', '010-2222-2222', '�����');
INSERT INTO tblparent VALUES ('ȫ�浿', 'ȣȣȣ', '010-3333-4444', '�λ��');
INSERT INTO tblparent VALUES ('ȫ�浿', '������', '010-3333-4444', '�λ��');

SELECT * FROM tblparent;


-- �ڽ� ���̺�
CREATE TABLE tblchild
(
      name VARCHAR2(50) PRIMARY KEY, --�ڽ� �̸�
      corder NUMBER NOT NULL , --�ڽ� ����
      --father VARCHAR2(50) REFERENCES tblparent(father, mother) NOT NULL ,
      --mother VARCHAR2(50) REFERENCES tblparent(mother) NOT NULL
      father VARCHAR2(50) NOT NULL ,
      mother VARCHAR2(50)  NOT NULL,
      CONSTRAINT tblchild_father_mother_fk
            FOREIGN KEY(father, mother) REFERENCES tblparent(father, mother)
);

INSERT INTO tblchild VALUES ('ȫ����', 1, 'ȫ�浿', 'ȣȣȣ');
INSERT INTO tblchild VALUES ('ȫ�̹�', 2, 'ȫ�浿', '�׽�Ʈ');


SELECT * FROM tblparent p
      INNER JOIN tblchild c
            ON p.father = c.father AND p.mother = c.mother;
























