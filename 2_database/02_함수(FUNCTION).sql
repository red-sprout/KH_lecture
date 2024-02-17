SELECT EMP_ID, EMP_NAME, SALARY ----------- 3
FROM EMPLOYEE        ---------- 1
WHERE DEPT_CODE IS NULL; ----------- 2

/*
   <ORDER BY ��>
   SELECT�� ���� ������ �ٿ� �ۼ�, ����������� ���� �������� �����Ѵ�.
   
   [ǥ����]
   SELECT ��ȸ�� �÷�....
   FROM ��ȸ�� ���̺�
   WHERE ���ǽ�
   ORDER BY ���ı����� �� �÷��� | ��Ī | �÷����� [ASC | DESC] [NULL FIRST | NULL LAST]
   
   - ASC : ��������(���� ������ �����ؼ� ���� ���� Ŀ���� ��) -> �⺻��
   - DESC : ��������(ū������ �����ؼ� ���� ���� �پ��� ��)
   
   -- NULL�� �⺻������ ���� ū������ �з��ؼ� �����Ѵ�.
   - NULLS FIRST : �����ϰ����ϴ� �÷����� NULL�� ���� ��� �ش絥���� �� �տ� ��ġ(DESC�϶� �⺻��)
   - NULLS LAST : �����ϰ����ϴ� �÷����� NULL�� ���� ��� �ش絥���� �� �������� ��ġ(ASC�϶� �⺻��)
*/

SELECT *
FROM EMPLOYEE
--ORDER BY BONUS; -- �⺻���� ��������
--ORDER BY BONUS ASC;
--ORDER BY BONUS ASC NULLS FIRST;
--ORDER BY BONUS DESC; -- NULLS FIRST �⺻
--���ı��ؿ� �÷����� ������ ��� �� ���������� ���ؼ� ���� ���� ������ �� �ִ�.
ORDER BY BONUS DESC, SALARY ASC;

--�� ����� �����, ����(���ʽ�����) ��ȸ(�� �� ������ �������� ����)
SELECT EMP_NAME, SALARY * 12 AS "����"
FROM EMPLOYEE
--ORDER BY SALARY * 12 DESC;
--ORDER BY ���� DESC;
ORDER BY 2 DESC; -- ������밡�� ����Ŭ�� ���� 1���� ����

--================================================================
/*
    <�Լ� FUNCTION>
    ���޵� �÷����� �о�鿩�� �Լ��� ������ ����� ��ȯ
    
    -������ �Լ� : N���� ���� �о�鿩�� N���� ������� ����(���ึ�� �Լ��������� ��ȯ)
    -�׷��Լ� : N���� ���� �о�鿩�� 1���� ������� ����(�׷��� ���� �׷캰�� �Լ� ������ ��ȯ)
    
    >> SELECT ���� ������ �Լ��� �׷��Լ��� �԰� ������� ����!
    ��? ��� ���� ������ �ٸ��� ������
    
    >>�Լ����� ����� �� �ִ� ��ġ : SELECT�� WHERE�� ORDER BY�� GROUP BY�� HAVING��
*/

--=========================<������ �Լ�>=================================
/*
    <���� ó�� �Լ�>
    
    *LENGTH(�÷� | '���ڿ�') : �ش� ���ڿ��� ���ڼ��� ��ȯ
    *LENGTHB(�÷� | '���ڿ�') : �ش� ���ڿ��� ����Ʈ���� ��ȯ
    
    '��' '��' '��' �ѱ��� ���ڴ� 3BYTE
    ������, ����, Ư������ ���ڴ� 1BYTE
*/

SELECT LENGTH('����Ŭ'), LENGTHB('����Ŭ')
FROM DUAL;

SELECT LENGTH('ORACLE'), LENGTHB('ORACLE')
FROM DUAL;

SELECT EMP_NAME, LENGTH(EMP_NAME), LENGTHB(EMP_NAME),
       EMAIL, LENGTH(EMAIL), LENGTHB(EMAIL)
FROM EMPLOYEE;


------------------------------------------------------------------

/*
    *INSTR
    ���ڿ��κ��� Ư�� ������ ������ġ�� ã�Ƽ� ��ȯ
    
    INSTR(�÷� | '���ڿ�', 'ã�����ϴ� ����', ['ã�� ��ġ�� ���۰�', ����]) => ����� NUMBER ����
*/

SELECT INSTR('AABAACAABBAA', 'B') FROM DUAL; -- ���ʿ� �ִ� ù B�� 3��° ��ġ�� �ִٰ� ����
-- ã�� ��ġ ���۰� : 1 , ���� : 1 => �⺻��
SELECT INSTR('AABAACAABBAA', 'B', 1) FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B', -1) FROM DUAL; -- �ڿ������� ã���� ���� ���� ������ �о �˷��ش�.
SELECT INSTR('AABAACAABBAA', 'B', 1, 2) FROM DUAL; -- ������ �����Ϸ��� ã�� ��ġ�� ���۰��� ǥ���ؾ���
SELECT INSTR('AABAACAABBAA', 'B', 1, 3) FROM DUAL;

SELECT EMAIL, INSTR(EMAIL, '_', 1, 1) AS "LOCATION", INSTR(EMAIL, '@') AS "@��ġ"
FROM EMPLOYEE;

-------------------------------------------------------------------------------
/*
    *SUBSTR / ���־���
    ���ڿ����� Ư�� ���ڿ��� �����ؼ� ��ȯ
    
    [ǥ����]
    SUBSTR(STRING, POSITION, [LENGTH])
    - STRING : ����Ÿ���� �÷� | '���ڿ�'
    - POSITION : ���ڿ� ������ ������ġ�� ��
    - LENGTH : ������ ���� ����(�����ϸ� ������)
*/

SELECT SUBSTR('SHOWMETHEMONEY', 7) FROM DUAL; -- 7��° ��ġ���� ������
SELECT SUBSTR('SHOWMETHEMONEY', 5, 2) FROM DUAL; 
SELECT SUBSTR('SHOWMETHEMONEY', 1, 6) FROM DUAL;  --SHOWME
SELECT SUBSTR('SHOWMETHEMONEY', -8, 3) FROM DUAL;

SELECT EMP_NAME, EMP_NO, SUBSTR(EMP_NO, 8, 1) AS "����"
FROM EMPLOYEE;

--������� ������鸸 EMP_NAME, EMP_NO ��ȸ
SELECT EMP_NAME, EMP_NO
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = '2' OR SUBSTR(EMP_NO, 8, 1) = '4';

--������� ������鸸 EMP_NAME, EMP_NO ��ȸ
SELECT EMP_NAME, EMP_NO
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = '1' OR SUBSTR(EMP_NO, 8, 1) = '3'
ORDER BY EMP_NAME;

--�Լ� ��ø��� ����
--�̸��� ���̵�κи� ����
-- �����Ͽ��� �����, �̸���, ���̵� ��ȸ
SELECT EMP_NAME, EMAIL, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@') - 1)
FROM EMPLOYEE;

------------------------------------------------------------------

/*
    *LPAD / RPAD
    ���ڿ��� ��ȸ�� �� ���ϰ��ְ� �����ϰ��� �� �� ���
    
    [ǥ����]
    LPAD/RPAD(STRING, ���������� ��ȯ�� ������ ����, [�����̰����ϴ� ����])
    
    ���ڿ��� �����̰����ϴ� ���ڸ� ���� �Ǵ� �����ʿ� �ٿ��� ���� N���̸�ŭ�� ���ڿ��� ��ȯ
*/

--20��ŭ�� ���� �� EAMIL�÷����� ���������� �����ϰ� ������ �κ��� �������� ä���
SELECT EMP_NAME, LPAD(EMAIL, 20)
FROM EMPLOYEE;

SELECT EMP_NAME, LPAD(EMAIL, 20, '#')
FROM EMPLOYEE;

SELECT EMP_NAME, RPAD(EMAIL, 20, '#')
FROM EMPLOYEE;

SELECT RPAD('910524-1', 14, '*')
FROM DUAL;

--������� ����� �ֹε�Ϲ�ȣ ��ȸ("910524-1" ��������)
--SELECT EMP_NAME, SUBSTR(EMP_NO, 1, 8)
--SELECT EMP_NAME, SUBSTR(EMP_NO, 1, 8) || '*******'
SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO, 1, 8), 14, '*')
FROM EMPLOYEE;

--------------------------------------------------------------------------------
/*
    *LTRIM / RTRIM
    ���ڿ����� Ư�� ���ڸ� ������ �������� ��ȯ
    LTRIM/RTRIM(STRING, [�����ϰ����ϴ� ���ڵ�])
    
    ���ڿ��� ���� Ȥ�� �����ʿ��� �����ϰ����ϴ� ���ڵ��� ã�Ƽ� ������ ������ ���ڿ��� ��ȯ    
*/

SELECT LTRIM('    K  H') FROM DUAL; -- �տ������� �ٸ����ڰ� ���ö� ������ ��������
SELECT LTRIM('123123KH123', '123') FROM DUAL;
SELECT LTRIM('ACABACCKH', 'ABC') FROM DUAL; -- �����ϰ����ϴ� ���ڴ� ���ڿ��̾ƴ� ���ڵ�!
SELECT RTRIM('574185KH123', '0123456789') FROM DUAL;

/*
    *TRIM
    ���ڿ��� ��/��/���ʿ� �ִ� ������ ���ڵ��� ������ ������ ���ڿ� ��ȯ
    TRIM([LEADING | TRAILING | BOTH] �����ϰ����ϴ� ���ڿ� FROM ���ڿ�)
*/

SELECT TRIM('      K   H    ') FROM DUAL; -- ���ʿ��ִ� ������ ����
SELECT TRIM('Z' FROM 'ZZZZKHZZZZZZZZ') FROM DUAL; -- ���ʿ��ִ� Ư������ ����

SELECT TRIM(LEADING 'Z' FROM 'ZZZZKHZZZZZZZZ') FROM DUAL; -- LTRIM������ ���
SELECT TRIM(TRAILING 'Z' FROM 'ZZZZKHZZZZZZZZ') FROM DUAL; -- RTRIM������ ���
SELECT TRIM(BOTH 'Z' FROM 'ZZZZKHZZZZZZZZ') FROM DUAL; -- ���ʿ��ִ� Ư������ ����

--------------------------------------------------------------------------
/*
    *LOWER / UPPER / INITCAP
    
    LOWER : �� �ҹ��ڷ� ������ ���ڿ� ��ȯ
    UPPER : �� �빮�ڷ� ������ ���ڿ� ��ȯ
    INITCAP : ���� ���� ù ���ڸ��� �빮�ڷ� ������ ���ڿ� ��ȯ
*/
SELECT LOWER('Welcome To My World!') FROM DUAL;
SELECT UPPER('Welcome To My World!') FROM DUAL;
SELECT INITCAP('welcome to my world!') FROM DUAL;

-------------------------------------------------------------------------------

/*
    *CONCAT
    ���ڿ� �ΰ� ���޹޾� �ϳ��� ��ģ �� ��ȯ
    CONCAT(STRING1, STRING2)
*/

SELECT CONCAT('������', 'ABC') FROM DUAL; -- �ΰ��� ���ڿ��� ����
SELECT '������' || 'ABC' FROM DUAL;

--------------------------------------------------------------------

/*
    *REPLACE
    Ư�����ڿ����� Ư���κ��� �ٸ��κ����� ��ü
    REPLACE(���ڿ�, ã�� ���ڿ�, �����ҹ��ڿ�)
*/
SELECT EMAIL, REPLACE(EMAIL, 'KH.or.kr', 'gmail.com')
FROM EMPLOYEE;

--------------------------------------------------------------------------------------
/*
    <���� ó�� �Լ�>
    
    *ABS
    ������ ���밪�� �����ִ� �Լ�
*/

SELECT ABS(-10), ABS(-6.3) FROM DUAL;

----------------------------------------------------------------------------------------

/*
    *MOD
    �� ���� ���� ���������� ��ȯ
    MOD(NUMBER, NUMBER)
*/

SELECT MOD(10, 3) FROM DUAL;
SELECT MOD(10.9, 3) FROM DUAL;

--------------------------------------------------------------------------------

/*
    *ROUND
    �ݿø��� ����� ��ȯ
    
    ROUND(NUMBER, [��ġ])
*/

SELECT ROUND(123.456, 0) FROM DUAL; -- �⺻�ڸ����� �Ҽ��� ù��° �ڸ����� �ݿø� : 0
SELECT ROUND(123.456, 1) FROM DUAL; -- ����� ������ ���� �Ҽ��� �ڷ� ��ĭ�� �̵�
SELECT ROUND(123.456, -1) FROM DUAL; -- ������ ������ ���� �Ҽ��� ���ڸ��� �̵�

-----------------------------QUIZ------------------------------------------
--�˻��ϰ��� �ϴ� ����
--JOB_CODE�� J7�̰ų� J6�̸鼭 SALARY���� 200���� �̻��̰�
--BONUS�� �ְ� �����̸� �̸����ּҴ� _�տ� 3���ڸ� �ִ� �����
--�̸�, �ֹε�Ϲ�ȣ, �����ڵ�, �μ��ڵ�, �޿�, ���ʽ��� ��ȸ�ϰ�ʹ�.
--���������� ��ȸ�Ǹ� ����� 2��

SELECT EMP_NAME, EMP_NO, JOB_CODE, DEPT_CODE, SALARY, BONUS
FROM EMPLOYEE
WHERE (JOB_CODE IN('J6', 'J7')) AND SALARY >= 2000000
    AND BONUS IS NOT NULL
    AND SUBSTR(EMP_NO, INSTR(EMP_NO, '-') + 1, 1) IN('2', '4')
    AND EMAIL LIKE '___\_%' ESCAPE '\';
