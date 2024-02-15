/*
    <SELECT>
    SELECT ��������� ���� ���� FROM ���̺�;
    SELECT (*) �Ǵ� �÷�1, �÷�2, �÷�3... FROM ���̺�;
*/

--��� ����� ������ ������
SELECT * FROM EMPLOYEE;

--��� ����� �̸�, �ֹε�Ϲ�ȣ, �ڵ�����ȣ
SELECT EMP_NAME, EMP_NO, PHONE
FROM EMPLOYEE;

-----------------------------�ǽ�--------------------------------
--JOB ���̺��� ���޸� �÷��� ��ȸ
SELECT JOB_NAME FROM JOB;

--DEPARTMENT ���̺��� ��� �÷� ��ȸ
SELECT * FROM DEPARTMENT;

--DEPARTMENT ���̺��� �μ��ڵ�, �μ��� ��ȸ
SELECT DEPT_ID, DEPT_TITLE FROM DEPARTMENT;

--DEPARTMENT ���̺��� �����, �̸���, ��ȭ��ȣ, �Ի���, �޿� ��ȸ
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE, SALARY FROM EMPLOYEE;

-- <�÷����� ���� �������>
-- SELECT�� �÷��� �ۼ��κп� ��������� �� �� �ִ�.

-- EMPLOYEE ���̺��� �����, ����� ����(SALARY * 12)�� ��ȸ
SELECT EMP_NAME, SALARY * 12
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� �����, �޿�, ���ʽ�, ����, ���ʽ����Կ��� ��ȸ(�޿� + (�޿� * ���ʽ�)) * 12
SELECT EMP_NAME, SALARY, BONUS, SALARY * 12, (SALARY + SALARY * BONUS) * 12 
FROM EMPLOYEE;

-- ������� ���� �߿� NULL�����Ͱ� ���ԵǾ� �ִٸ� ������ ������� NULL

-- �����, �Ի���, �ٹ��ϼ��� ��ȸ
-- ����ð� - �Ի��� = �ٹ��ѽð�
-- DATE - DATE => ����� ������ �Ϸ� ���ð� �ȴ�.
-- �ڵ����� ��¥�� ǥ���ϴ� ��� : SYSDATE [��/��/��/��/��/��]
SELECT EMP_NAME, HIRE_DATE, SYSDATE - HIRE_DATE
FROM EMPLOYEE;

SELECT SYSDATE FROM DUAL;
-- DUAL : ����Ŭ���� �������ִ� ���������� ���̺�(���̵�����)

/*
    <�÷��� ��Ī �����ϱ�>
    ��������� �ϰԵǸ� �÷����� ������������. �̶� �÷��� ��Ī�� �ο��ؼ� ����ϰ� ������ �� �ִ�.
    [ǥ����]
    �÷��� ��Ī / �÷��� AS ��Ī / �÷��� "��Ī" / �÷��� AS "��Ī"
*/

SELECT EMP_NAME �����, SALARY AS �޿�, BONUS "���ʽ�", (SALARY * 12) AS "����(��)",
        (SALARY + (SALARY * BONUS)) * 12 AS "�� �ҵ�"
FROM EMPLOYEE;

/*
    <���ͷ�>
    ���Ƿ� ������ ���ڿ�('')
    ��ȸ�� ���(RESULT SET)�� ��� �࿡ �ݺ������� ���
*/

-- EMPLOYEE ���̺��� ���, �����, �޿�
SELECT EMP_ID, EMP_NAME, SALARY, '��' AS "����"
FROM EMPLOYEE;

/*
    <���Ῥ���� : ||>
    ���� �÷������� ��ġ �ϳ��� �÷�ó�� ������ �� �ִ�.
*/

-- ���, �̸�, �޿��� �ϳ��� �÷����� ��ȸ
SELECT EMP_ID || EMP_NAME || SALARY
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� ��� ����� ������ ��ȸ�Ѵ�.
-- ������ ���� ����� �������� ����϶�
-- XX�� ������ XX���Դϴ�.

SELECT EMP_NAME || '�� ������ ' || SALARY || '���Դϴ�.' AS "�޿�"
FROM EMPLOYEE;

/*
    <DISTINCT>
    �ߺ����� - �÷��� ǥ�õ� ������ �ѹ����� ��ȸ�ϰ��� �� �� ���
*/

-- EMPLOYEE �����ڵ� ��ȸ
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;

-- EMPLOYEE �μ��ڵ带 ��ȸ
SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;

-- SELECT DISTINCT JOB_CODE, DISTINCT DEPT_CODE
-- ��ó�� �ۼ��ϸ� ������ �߻��Ѵ�. DISTINCT�� �ѹ��� ����� �����ϴ�.
SELECT DISTINCT JOB_CODE, DEPT_CODE
-- ��ó�� ���� (JOB_CODE, DEPT_CODE)�� ������ ��� �ߺ��� ������ ���� ������
FROM EMPLOYEE;

--===========================================================================================

/*
    <WHERE ��>
    ��ȸ�ϰ��� �ϴ� ���̺�κ��� Ư�� ���ǿ� �����ϴ� �����͸��� ��ȸ�� �� ���
    ���ǽĿ����� �پ��� ������ ����� ����
    [ǥ����]
    SELECT �÷�, �÷�, �÷� ����
    FROM ���̺�
    WHERE ����;
    
    >> �� ������ <<
    >, <, >=, <= : ��Һ�
    =            : ������ ����
    !=, ^=, <>   : ������ �ٸ���
*/

-- EMPLOYEE���� �μ��ڵ尡 'D9'�� ����鸸 ��ȸ(����÷�)
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- EMPLOYEE���� �μ��ڵ尡 'D1'�� ������� �����, �޿�, �μ��ڵ� ��ȸ
SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1';

-- EMPLOYEE���� �μ��ڵ尡 'D1'�� �ƴ� ������� �����, �޿�, �μ��ڵ� ��ȸ
SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE != 'D1';

-- ������ 400���� �̻��� ������� �����, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 4000000;

---------------------------------�ǽ�--------------------------------------
-- 1. �޿��� 300���� �̻��� ������� �����, �޿�, �Ի���, ����(��Ī -> ����) ��ȸ
SELECT EMP_NAME, SALARY, HIRE_DATE, (SALARY * 12) AS "����"
FROM EMPLOYEE
WHERE SALARY >= 3000000;

-- 2. ������ 5õ���� �̻��� ������� �����, �޿�, ����(��Ī->����), �μ��ڵ� ��ȸ
SELECT EMP_NAME, SALARY, HIRE_DATE, (SALARY * 12) AS "����", JOB_CODE
FROM EMPLOYEE
WHERE SALARY * 12 >= 50000000;
-- WHERE ���� >= 50000000; -> ������ �߻��Ѵ�
-- ���� : ��������� FROM -> WHERE -> SELECT

-- 3. �����ڵ尡 'J3'�� �ƴ� ������� ���, �����, �����ڵ�, ��翩�� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, ENT_YN
FROM EMPLOYEE
WHERE JOB_CODE != 'J3';

-- 4. �޿��� 350���� �̻� 600���� ������ ��� ����� �����, ���, �޿���ȸ
SELECT EMP_NAME, EMP_NO, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3500000 AND SALARY <= 6000000;