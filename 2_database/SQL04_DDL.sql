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
INSERT INTO TB_CATEGORY VALUES('공학', 'Y');
INSERT INTO TB_CATEGORY VALUES('자연과학', 'Y');
INSERT INTO TB_CATEGORY VALUES('의학', 'Y');
INSERT INTO TB_CATEGORY VALUES('예체능', 'Y');
INSERT INTO TB_CATEGORY VALUES('인문사회', 'Y');
COMMIT;

--GRANT CREATE VIEW TO wk;
--9
ALTER TABLE TB_DEPARTMENT
    ADD FOREIGN KEY(CATEGORY) REFERENCES TB_CATEGORY;
ALTER TABLE TB_DEPARTMENT
    RENAME CONSTRAINT SYS_C007284 TO FK_DEPARTMENT_CATEGORY;
--10
CREATE OR REPLACE VIEW VW_학생일반정보 
AS (SELECT STUDENT_NO AS "학번", 
            STUDENT_NAME AS "학생이름", 
            STUDENT_ADDRESS AS "주소"
    FROM TB_STUDENT);

SELECT * FROM VW_학생일반정보;
--11
CREATE OR REPLACE VIEW VW_지도면담
AS (SELECT STUDENT_NAME AS "학생이름", 
            DEPARTMENT_NAME AS "학과이름", 
            PROFESSOR_NAME AS "지도교수이름"
    FROM TB_STUDENT
    JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
    LEFT JOIN TB_PROFESSOR ON (COACH_PROFESSOR_NO = PROFESSOR_NO));

SELECT * FROM VW_지도면담
ORDER BY 학과이름;
--12
CREATE OR REPLACE VIEW VW_학과별학생수
AS (SELECT DEPARTMENT_NAME, COUNT(STUDENT_NAME) AS STUDENT_COUNT
    FROM TB_STUDENT
    JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
    GROUP BY DEPARTMENT_NAME);
    
SELECT * FROM VW_학과별학생수;
--13
UPDATE VW_학생일반정보
SET 학생이름 = '주재완'
WHERE 학번 = 'A213046';

SELECT * FROM VW_학생일반정보;
--14
CREATE OR REPLACE VIEW VW_학생일반정보 
AS (SELECT STUDENT_NO AS "학번", 
            STUDENT_NAME AS "학생이름", 
            STUDENT_ADDRESS AS "주소"
    FROM TB_STUDENT)
WITH READ ONLY;

--UPDATE VW_학생일반정보
--SET 학생이름 = '주재완'
--WHERE 학번 = 'A213046';
--15
SELECT *
FROM (SELECT CLASS_NO AS "과목번호",
            CLASS_NAME AS "과목이름",
            COUNT(CLASS_NO) AS "누적수강생수(명)"
        FROM TB_GRADE
        JOIN TB_CLASS USING (CLASS_NO)
        WHERE (SELECT SUBSTR(MAX(TERM_NO), 1, 4) 
                FROM TB_GRADE) - SUBSTR(TERM_NO, 1, 4) <= 3
        GROUP BY CLASS_NO, CLASS_NAME
        ORDER BY "누적수강생수(명)" DESC)
WHERE ROWNUM <= 3;
