/*
ex08_sequence.sql

시퀀스, Sequences
- 시퀀스 객체(DB Object 중 하나)
        -무의미한 일련번호들을 생산하고 관리하는 역할
        
시퀀스 객체 생성하기
- CREATE : 생성
- ALTER : 수정
- DROP : 삭제
- CREATE SEQUENCE 시퀀스명;
*/

CREATE SEQUENCE testseq;

SELECT testseq.nextval FROM dual;
SELECT testseq.currval FROM dual;

DROP TABLE tblmemo;

CREATE TABLE tblmemo
(
seq number, --일련 번호 (1, 2, 3, 4......)
name varchar2(20),
memo varchar2(1000),

CONSTRAINT tblmemo_seq_pk PRIMARY KEY(seq),
CONSTRAINT tblmemo_name_uq UNIQUE (name),
CONSTRAINT tblmemo_memo_ck CHECK (length(memo) >= 10)

);

CREATE SEQUENCE memoseq;

INSERT INTO tblmemo (seq, name, memo) VALUES (1, '홍길동','시퀀스 테스트입니다.');
INSERT INTO tblmemo (seq, name, memo) VALUES (memoseq.nextval, '홍길동','시퀀스 테스트입니다.'); --에러뜸
INSERT INTO tblmemo (seq, name, memo) VALUES (memoseq.nextval, '아무개','시퀀스 테스트입니다.');
INSERT INTO tblmemo (seq, name, memo) VALUES (memoseq.nextval, '테스트','시퀀스 테스트입니다.');
INSERT INTO tblmemo (seq, name, memo) VALUES (memoseq.nextval, '호호호','시퀀스 테스트입니다.');

SELECT memoseq.currval FROM dual;
SELECT memoseq.nextval FROM dual;

SELECT*FROM tblmemo;

delete from tblmemo;

-- 상품 테이블
-- : 상품코드, 상품명, 가격, 수량
-- : 상품코드(PK) -> 1, 2, 3, 4....(X)
-- : 상품코드(PK) -> AA015 --뒤에 세자리 얻어오고 앞에거는 우리가 직접 만들어보쟝

CREATE TABLE tblproduct
(
    seq varchar2(5) PRIMARY KEY, --상품코드
    name varchar2(50) NOT NULL,
    price number NOT NULL,
    qty number NOT NULL
);

-- AA001, AA002, AA003
CREATE SEQUENCE productseq;

INSERT INTO tblproduct (seq, name, price, qty)
    VALUES ('AA' || trim(to_char(productseq.nextval,'000')), '진공 청소기', 1000000, 1); -- AA와 000사이에 공백 안생기게 TRIM시켜주기!
    
INSERT INTO tblproduct (seq, name, price, qty)
    VALUES ('AA' || trim(to_char(productseq.nextval,'000')), '걸레', 100000, 1); -- AA와 000사이에 공백 안생기게 TRIM시켜주기!

INSERT INTO tblproduct (seq, name, price, qty)
    VALUES ('AA' || trim(to_char(productseq.nextval,'000')), '행주', 1000000, 1); -- AA와 000사이에 공백 안생기게 TRIM시켜주기!
    
-- ORA-00001: unique constraint (HR.SYS_C007142) violated   
INSERT INTO tblproduct (seq, name, price, qty)
    VALUES ('AA' || trim(to_char(productseq.nextval,'000')), '새상품', 1000000, 1); -- AA와 000사이에 공백 안생기게 TRIM시켜주기!


SELECT*FROM tblproduct;

-- 시퀀스 객체 초기화(1부터 다시 시작하도록......)
SELECT productseq.nextval FROM dual;
--1. 다시 만들기
DROP SEQUENCE productseq;
CREATE SEQUENCE productseq;

--2. 수정하기(제어하기) 
DROP SEQUENCE productseq;
CREATE SEQUENCE productseq
        INCREMENT BY 1 --증감치
        START WITH 1 --시작값 -->처음부터 10부터 시작함
        MAXVALUE 10 --최대값(넘으면 에러 발생)
        MINVALUE -5 --최소값 --> 역순으로도 갈 수 있음
        CYCLE 
        CACHE 3
        ;

SELECT productseq.nextval FROM dual;        



/*
근데 문제가 하나있어 , 드랍시키고 크리에이트 해 이제 이놈을 호출하면 1이 나오겠지 
근데 1위에 이미 있잖아 최소한 새상품은 4부터 시작해야지, 
그니까 데이터도 지워야지 근데 데이터는 함부로 지우기 힘들거든 
방법은
SELECT productseq.nextval FROM dual; ->를 4가 될때까지 실행해
*/



