--1
SELECT STUDENT_NO AS "학번", STUDENT_NAME AS "이름", ENTRANCE_DATE AS "입학년도"
FROM TB_STUDENT
WHERE DEPARTMENT_NO = '002'
ORDER BY "이름";
--2
SELECT PROFESSOR_NAME, PROFESSOR_SSN
FROM TB_PROFESSOR
WHERE LENGTH(PROFESSOR_NAME) != 3;
--3
SELECT PROFESSOR_NAME AS "교수이름",
        TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY')) - TO_NUMBER('19' || SUBSTR(PROFESSOR_SSN, 1, 2)) AS "나이"
FROM TB_PROFESSOR
WHERE SUBSTR(PROFESSOR_SSN, 8, 1) = '1'
ORDER BY "나이";
--4
SELECT SUBSTR(PROFESSOR_NAME, 2) AS "이름"
FROM TB_PROFESSOR;
--5
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE EXTRACT(YEAR FROM ENTRANCE_DATE) - TO_NUMBER('19' || SUBSTR(STUDENT_SSN, 1, 2)) > 19;
--6
SELECT TO_CHAR(TO_DATE('20201225'),'DY') AS "날짜 극혐"
FROM DUAL;
--7
SELECT TO_DATE('99/10/11', 'YY/MM/DD'), TO_DATE('49/10/11', 'YY/MM/DD'), TO_DATE('99/10/11', 'RR/MM/DD'), TO_DATE('49/10/11', 'RR/MM/DD')
FROM DUAL;
--8
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE SUBSTR(STUDENT_NO, 1, 1) != 'A';
--9
SELECT ROUND(AVG(POINT), 1) AS "평점"
FROM TB_GRADE
WHERE STUDENT_NO = 'A517178';
--10
SELECT DEPARTMENT_NO AS "학과번호", COUNT(DEPARTMENT_NO) AS "학생수(명)"
FROM TB_STUDENT
GROUP BY DEPARTMENT_NO
ORDER BY DEPARTMENT_NO;
--11
SELECT COUNT(*)
FROM TB_STUDENT
WHERE COACH_PROFESSOR_NO IS NULL;
--12
SELECT SUBSTR(TERM_NO, 1, 4) AS "년도", ROUND(AVG(POINT),1) AS "년도 별 평점"
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO, 1, 4)
ORDER BY "년도" ASC;
--13
SELECT DEPARTMENT_NO AS "학과코드명", 
    SUM(DECODE((ABSENCE_YN), 'Y', 1, 'N', 0)) AS "휴학생 수"
FROM TB_STUDENT
GROUP BY DEPARTMENT_NO
ORDER BY DEPARTMENT_NO;
--14
SELECT STUDENT_NAME AS "동명이름", COUNT(*) AS "동명인 수"
FROM TB_STUDENT
GROUP BY STUDENT_NAME
HAVING COUNT(*) > 1;
--15
SELECT NVL(TO_CHAR("년도"), ' ') AS "년도", 
        NVL(TO_CHAR("학기"), ' ') AS "학기", 
        NVL(TO_CHAR("평점"), ' ') AS "평점"
FROM(SELECT SUBSTR(TERM_NO, 1, 4) AS "년도", SUBSTR(TERM_NO, 5, 2) AS "학기", ROUND(AVG(POINT),1) AS "평점"
    FROM TB_GRADE
    WHERE STUDENT_NO = 'A112113'
    GROUP BY TERM_NO
    UNION
    SELECT SUBSTR(TERM_NO, 1, 4) AS "년도", NULL, ROUND(AVG(POINT),1) AS "평점"
    FROM TB_GRADE
    WHERE STUDENT_NO = 'A112113'
    GROUP BY SUBSTR(TERM_NO, 1, 4)
    UNION
    SELECT NULL, NULL, ROUND(AVG(POINT),1) AS "평점"
    FROM TB_GRADE
    WHERE STUDENT_NO = 'A112113'
    ORDER BY 1 ASC, 2 ASC);