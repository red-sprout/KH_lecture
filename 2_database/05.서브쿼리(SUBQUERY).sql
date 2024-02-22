/*
    *�������� (SUBQUERY)
    -�ϳ��� SQL�� �ȿ� ���Ե� �� �ٸ� SELECT��
    -���� SQL���� ���� ���� ������ �ϴ� ����
*/

--������ �������� ����1.
--���ö ����� ���� �μ��� ���� ����� ��ȸ

--1)���ö ����� �μ��ڵ�
SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '���ö';

--2)�μ��ڵ尡 D9�� ����� ��ȸ
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

--�� �� �ܰ踦 �ϳ��� ����������
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '���ö');
                    
--������ �������� ����2
--�� ������ ��ձ޿����� �� ���� �޿��� �޴� ������� ���, �̸�, �����ڵ�, �޿� ��ȸ
--1) �������� ��ձ޿�
SELECT ROUND(AVG(SALARY))
FROM EMPLOYEE; --3047663

--2) 3047663���� �� ���� �޿��� �޴� ������� ���, �̸�, �����ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3047663;
                    
--3) �� �ܰ踦 �ϳ��� ���غ���
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= (SELECT AVG(SALARY)
                    FROM EMPLOYEE);

/*
    *���������� ����
    ���������� ������ ������� ���� ��� �����Ŀ� ���� �з�
    
    --������ �������� : ���������� ��ȸ ������� ������ ������ 1���� ��
    --������ �������� : ���������� ��ȸ ������� �������� ��(������ �ѿ�)
    --���߿� �������� : ���������� ��ȸ ������� �� �������� �÷��� �������� ��
    --������ ���߿� �������� : ���������� ��ȸ ������� ������ �������� ��
    
    >> ���������� ������ ���Ŀ� ���� �������� �տ� �ٴ� ������ �޶���
*/

/*
    1. ������ ��������
    ���������� ��ȸ ������� ������ ������ 1���� ��(���� �ѿ�)
    �Ϲ� �񱳿����� ��� ����
    = != > <= ...
*/

--1) �� ������ ��� �޿����� �޿��� �� ���Թ޴� ������� �����, �����ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY < (SELECT AVG(SALARY) 
                FROM EMPLOYEE);
                
--2) �����޿��� �޴� ����� ���, �̸�, �޿�, �Ի��� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY) 
                FROM EMPLOYEE);

--3) ���ö ����� �޿����� ���̹޴� ������� ���, �̸�, �μ��ڵ�, �޿���ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEE
                WHERE EMP_NAME = '���ö');

--4) ���ö ����� �޿����� ���̹޴� ������� ���, �̸�, �μ���, �޿���ȸ
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEE
                WHERE EMP_NAME = '���ö');
                
--5) �μ��� �޿����� ���� ū �μ��� �μ��ڵ� �޿���
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
                    FROM EMPLOYEE
                    GROUP BY DEPT_CODE);

--6) '������'����� ���� �μ��� ������� ���, �����, ��ȭ��ȣ, �Ի���, �μ����� ��ȸ
--��, ����������� ����
SELECT EMP_ID, EMP_NAME, PHONE, HIRE_DATE, DEPT_TITLE
FROM EMPLOYEE E, DEPARTMENT D 
WHERE (E.DEPT_CODE = D.DEPT_ID)
AND (EMP_NAME != '������') 
AND (DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '������'));

SELECT EMP_ID, EMP_NAME, PHONE, HIRE_DATE, DEPT_TITLE
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
WHERE (EMP_NAME != '������') 
AND (DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '������'));
                    
---------------------------------------------------------------------------------
/*
    2. ������ ��������
    ���������� ������ ������� �������� ��(�÷��� �Ѱ�)
    
    IN (��������) : �������� ����� �߿��� �Ѱ��� ��ġ�ϴ� ���� �ִٸ� ��ȸ
    > ANY (��������) : �������� ����� �߿��� �Ѱ��� Ŭ ���
    < ANY (��������) : �������� ����� �߿��� �Ѱ��� ���� ��� ��ȸ
        �񱳴�� > ANY (���������� ����� => ��1, ��2, ��3...)
        �񱳴�� > ��1 OR �񱳴�� > ��2 OR �񱳴�� > ��3
    > ALL (��������) : �������� ��� ������� ���� Ŭ ��� ��ȸ
    < ALL (��������) : �������� ��� ������� ���� ���� ���
        �񱳴�� > ALL (���������� ����� => ��1, ��2, ��3...)
        �񱳴�� > ��1 AND �񱳴�� > ��2 AND �񱳴�� > ��3...
*/
--1) ����� �Ǵ� �����ػ���� ���� ������ ������� ���, �����, �����ڵ�, �޿� ��ȸ
--1_1) ����� �Ǵ� �����ػ���� �����ڵ�
SELECT JOB_CODE
FROM EMPLOYEE
WHERE EMP_NAME IN ('������', '�����');

--1_2) ������ J3, J7�� ����� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE IN ('J3', 'J7');

-- �� ������ ���������� ���� ���غ���
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE IN (SELECT JOB_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME IN ('������', '�����'));
                    
--2) �븮 �����ӿ��� ���� ���� �޿��� �� �ּ� �޿����� ���� �޴� ����� ��ȸ
--(���, �̸�, ����, �޿�)
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE E
JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
WHERE JOB_NAME = '�븮'
AND SALARY > (SELECT MIN(SALARY) 
                FROM EMPLOYEE 
                JOIN JOB USING (JOB_CODE)
                WHERE JOB_NAME = '����');

SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE E
JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
WHERE JOB_NAME = '�븮'
AND SALARY > ANY (SELECT SALARY 
                FROM EMPLOYEE 
                JOIN JOB USING (JOB_CODE)
                WHERE JOB_NAME = '����');
                
------------------------------------------------------------------------------
/*
    3. ���߿� ��������
    ������� �� �������� ������ �÷����� �������� ���
*/

--1) ������ ����� ���� �μ��ڵ�, ���� �����ڵ忡 �ش��ϴ� ����� ��ȸ
--(�����, �μ��ڵ�, �����ڵ�, �Ի���)
--> ������ ��������
SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '������')
    AND JOB_CODE = (SELECT JOB_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '������');
---> ���߿� ���������� �ۼ�
SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE
                                FROM EMPLOYEE
                                WHERE EMP_NAME = '������');
                                
--�ڳ��� ����� ���� �����ڵ�, ���� ����� ������ �ִ� ������� ���, �����, �����ڵ�, �����ȣ ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE (JOB_CODE, MANAGER_ID) = (SELECT JOB_CODE, MANAGER_ID
                                FROM EMPLOYEE
                                WHERE EMP_NAME = '�ڳ���')
    AND EMP_NAME = '�ڳ���';

------------------------------------------------------------------------------
/*
    4. ������ ���߿� ��������
    ���������� ��ȸ ������� ������ �������� ���
*/

--1) �� ���޺� �ּұ޿��� �޴� �����ȸ(���, �����, �����ڵ�, �޿�)
--> �� ���޺� �ּұ޿�
SELECT JOB_CODE, MIN(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE;

--> �� ���޺� �ּұ޿��� �޴� �����ȸ(���, �����, �����ڵ�, �޿�)
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
-- �������� ����
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, MIN(SALARY)
                            FROM EMPLOYEE
                            GROUP BY JOB_CODE);
                            
--�� �μ��� �ְ�޿��� �޴� ������� ���, �����, �μ��ڵ�, �޿�
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE (DEPT_CODE, SALARY) IN (SELECT DEPT_CODE, MAX(SALARY)
                                FROM EMPLOYEE
                                GROUP BY DEPT_CODE);
                                
------------------------------------------------------------------------------
/*
    5. �ζ��� ��
    FROM���� ���������� �ۼ��� ��
    ���������� ������ ����� ��ġ ���̺�ó�� ���
*/

--������� ���, �̸�, ���ʽ����Կ���, �μ��ڵ� ��ȸ
--��, ���ʽ����� ������ NULL�̸� �ȵȴ�.
--��, ���ʽ����� ������ 3000���� �̻��� ����鸸 ��ȸ

SELECT ROWNUM, EMP_ID, EMP_NAME, (SALARY + (SALARY * NVL(BONUS, 0))) * 12 AS "����", DEPT_CODE
FROM EMPLOYEE
WHERE (SALARY + (SALARY * NVL(BONUS, 0))) * 12 >= 30000000
ORDER BY ���� DESC;

--> �ζ��κ並 �ַ� ����ϴ� �� >> TOP_N�м� : ���� ��� ��ȸ
-- �� ���� �� �ݿ��� ���� ���� 5�� ��ȸ
-- ROWNUM : ����Ŭ���� �������ִ� �÷�, ��ȸ�� ������� 1���� ������ �ο����ִ� �÷�
SELECT ROWNUM, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE ROWNUM <= 5
ORDER BY SALARY DESC;

--> ORDER BY���� ����� ����� ������ ROWNUM �ο� -> ���� 5�� ��ȸ
SELECT ROWNUM, EMP_NAME, SALARY
FROM (SELECT EMP_NAME, SALARY
        FROM EMPLOYEE
        ORDER BY SALARY DESC)
WHERE ROWNUM <= 5;

--���� �ֱٿ� �Ի��� ��� 5�� ��ȸ(�����, �޿�, �Ի���)
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM (SELECT EMP_NAME, SALARY, HIRE_DATE
        FROM EMPLOYEE
        ORDER BY HIRE_DATE DESC)
WHERE ROWNUM <= 5;

--�� �μ��� ��ձ޿��� ���� 3���� �μ� ��ȸ
SELECT DEPT_CODE, ��ձ޿�
FROM (SELECT DEPT_CODE, ROUND(AVG(SALARY)) AS "��ձ޿�"
        FROM EMPLOYEE
        GROUP BY DEPT_CODE
        ORDER BY ��ձ޿� DESC)
WHERE ROWNUM <= 3;

--�μ��� ��ձ޿��� 270������ �ʰ��ϴ� �μ��鿡 ���ؼ�
--(�μ��ڵ�, �μ��� �� �޿���, �μ��� ��ձ޿�, �μ��� �����) ��ȸ
SELECT DEPT_CODE, SUM(SALARY) AS "�ѱ޿���", 
ROUND(AVG(SALARY)) AS "��ձ޿�", COUNT(*) AS "�����"
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING AVG(SALARY) > 2700000
ORDER BY DEPT_CODE ASC;

SELECT *
FROM (SELECT DEPT_CODE, SUM(SALARY) AS "�ѱ޿���", 
        ROUND(AVG(SALARY)) AS "��ձ޿�", COUNT(*) AS "�����"
        FROM EMPLOYEE
        GROUP BY DEPT_CODE
        ORDER BY DEPT_CODE ASC)
WHERE ��ձ޿� > 2700000;

------------------------------------------------------------------------
/*
    *������ �ű�� �Լ�(WINDOW FUNCTION)
    RANK() OVER(���ı���) | DANSE_RANK() OVER(���ı���)
    RANK() OVER(���ı���) : ������ ���� ������ ����� ������ �ο� �� ��ŭ �ǳʶٰ� ���� ���
    DENSE_RANK() OVER(���ı���) : ������ ������ �ִٰ� �ص� �� ���� ����� ������ 1�� ������Ŵ
    
    ������ SELECT�������� ��밡��
*/

--�޿��� ���� ������� ������ �Űܼ� ��ȸ
SELECT EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) AS "����"
FROM EMPLOYEE;
--���� 19�� 2�� �� �� ����� 21������ �ϳ� �ǳ� �� �� �� �� �ִ�.

SELECT EMP_NAME, SALARY, DENSE_RANK() OVER(ORDER BY SALARY DESC) AS "����"
FROM EMPLOYEE;
--> 19���� ���������� �� �ڿ� 20���� �ٷ� ������ ���� �� �� �ִ�.

SELECT *
FROM (SELECT EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) AS "����"
        FROM EMPLOYEE)
WHERE ���� <= 5;