DROP TABLE TB_CLASS_TYPE;
DROP TABLE TB_CATEGORY;
--1
CREATE TABLE TB_CATEGORY (
    NAME VARCHAR2(10),
    USE_YN CHAR(1) DEFAULT 'Y'
);
--2
CREATE TABLE TB_CLASS_TYPE (
    NO VARCHAR2(5) PRIMARY KEY,
    NAME VARCHAR2(10)
);
--3
ALTER TABLE TB_CATEGORY
ADD PRIMARY KEY(NAME);
--4
ALTER TABLE TB_CLASS_TYPE
MODIFY NAME NOT NULL;
--5
ALTER TABLE TB_CATEGORY
    MODIFY NAME VARCHAR2(20);
ALTER TABLE TB_CLASS_TYPE
    MODIFY NO VARCHAR2(10)
    MODIFY NAME VARCHAR2(20);
--6
ALTER TABLE TB_CATEGORY
    RENAME COLUMN NAME TO CATEGORY_NAME;
ALTER TABLE TB_CLASS_TYPE
    RENAME COLUMN NO TO CLASS_TYPE_NO;
ALTER TABLE TB_CLASS_TYPE
    RENAME COLUMN NAME TO CLASS_TYPE_NAME;
--7
ALTER TABLE TB_CATEGORY
    RENAME CONSTRAINT SYS_C007282 TO PK_CATEGORY_NAME;
ALTER TABLE TB_CLASS_TYPE
    RENAME CONSTRAINT SYS_C007281 TO PK_CLASS_TYPE_NO;
--8
INSERT INTO TB_CATEGORY VALUES('����', 'Y');
INSERT INTO TB_CATEGORY VALUES('�ڿ�����', 'Y');
INSERT INTO TB_CATEGORY VALUES('����', 'Y');
INSERT INTO TB_CATEGORY VALUES('��ü��', 'Y');
INSERT INTO TB_CATEGORY VALUES('�ι���ȸ', 'Y');
COMMIT;

--GRANT CREATE VIEW TO wk;
--9
ALTER TABLE TB_DEPARTMENT
    ADD FOREIGN KEY(CATEGORY) REFERENCES TB_CATEGORY;
ALTER TABLE TB_DEPARTMENT
    RENAME CONSTRAINT SYS_C007284 TO FK_DEPARTMENT_CATEGORY;
--10
CREATE OR REPLACE VIEW VW_�л��Ϲ����� 
AS (SELECT STUDENT_NO AS "�й�", 
            STUDENT_NAME AS "�л��̸�", 
            STUDENT_ADDRESS AS "�ּ�"
    FROM TB_STUDENT);

SELECT * FROM VW_�л��Ϲ�����;
--11
CREATE OR REPLACE VIEW VW_�������
AS (SELECT STUDENT_NAME AS "�л��̸�", 
            DEPARTMENT_NAME AS "�а��̸�", 
            PROFESSOR_NAME AS "���������̸�"
    FROM TB_STUDENT
    JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
    LEFT JOIN TB_PROFESSOR ON (COACH_PROFESSOR_NO = PROFESSOR_NO));

SELECT * FROM VW_�������
ORDER BY �а��̸�;
--12
CREATE OR REPLACE VIEW VW_�а����л���
AS (SELECT DEPARTMENT_NAME, COUNT(STUDENT_NAME) AS STUDENT_COUNT
    FROM TB_STUDENT
    JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
    GROUP BY DEPARTMENT_NAME);
    
SELECT * FROM VW_�а����л���;
--13
UPDATE VW_�л��Ϲ�����
SET �л��̸� = '�����'
WHERE �й� = 'A213046';

SELECT * FROM VW_�л��Ϲ�����;
--14
CREATE OR REPLACE VIEW VW_�л��Ϲ����� 
AS (SELECT STUDENT_NO AS "�й�", 
            STUDENT_NAME AS "�л��̸�", 
            STUDENT_ADDRESS AS "�ּ�"
    FROM TB_STUDENT)
WITH READ ONLY;

--UPDATE VW_�л��Ϲ�����
--SET �л��̸� = '�����'
--WHERE �й� = 'A213046';
--15
SELECT *
FROM (SELECT CLASS_NO AS "�����ȣ",
            CLASS_NAME AS "�����̸�",
            COUNT(CLASS_NO) AS "������������(��)"
        FROM TB_GRADE
        JOIN TB_CLASS USING (CLASS_NO)
        WHERE (SELECT SUBSTR(MAX(TERM_NO), 1, 4) 
                FROM TB_GRADE) - SUBSTR(TERM_NO, 1, 4) <= 3
        GROUP BY CLASS_NO, CLASS_NAME
        ORDER BY "������������(��)" DESC)
WHERE ROWNUM <= 3;