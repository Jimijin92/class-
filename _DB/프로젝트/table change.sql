-- 학원컴에서 고치기

SELECT*FROM TBL_AVA_SUBJECT;

ALTER TABLE TBL_AVA_SUBJECT
        ADD (state number(1) DEFAULT 1);

ALTER TABLE TBL_TEACHER
        ADD (state number(1) DEFAULT 1);
SELECT*FROM TBL_TEACHER


ALTER TABLE TBL_COURSE
        ADD (STATE number(1) DEFAULT 1);
--SELECT*FROM TBL_COURSE;

ALTER TABLE TBL_SUBJECT
        ADD (STATE number(1) DEFAULT 1);
--SELECT*FROM TBL_SUBJECT;

ALTER TABLE TBL_CLASS_ROOM
        ADD (STATE number(1) DEFAULT 1);
--SELECT*FROM TBL_CLASS_ROOM

ALTER TABLE TBL_BOOK
        ADD (STATE number(1) DEFAULT 1);
--SELECT*FROM TBL_BOOK

ALTER TABLE TBL_PUBLISHER
        ADD (STATE number(1) DEFAULT 1);
--SELECT*FROM TBL_PUBLISHER

ALTER TABLE TBL_OPEN_COURSE
        ADD (STATE number(1) DEFAULT 1);
SELECT*FROM TBL_OPEN_COURSE;