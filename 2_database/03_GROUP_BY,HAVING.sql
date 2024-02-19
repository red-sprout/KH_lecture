/*
    <GROUP BY��>
    �׷������ ������ �� �ִ� ����(�ش� �׷���غ��� ���� �׷����� ���� �� ����)
    �������� ������ �ϳ��� �׷����� ��� ó���ϴ� �������� ���
*/

SELECT SUM(SALARY)
FROM EMPLOYEE; -- ��ü����� �ϳ��� �׷����� ��� �� ���� ���� ���

-- �� �μ��� �� �޿�
-- �� �μ����� ���� �׷�
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- �� �μ��� ��� ��
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT DEPT_CODE, COUNT(*), SUM(SALARY) ------- 3
FROM EMPLOYEE ------- 1
GROUP BY DEPT_CODE ------- 2
ORDER BY DEPT_CODE; ------- 4

-- �� ���޺� �ѻ����, ���ʽ��� �޴� ��� ��, �޿���, ��ձ޿�, �����޿�, �ְ�޿� (���� : ���� ��������)
SELECT 
    JOB_CODE, 
    COUNT(*) AS "�����",
    COUNT(BONUS) AS "���ʽ�", 
    SUM(SALARY) AS "�޿�", 
    ROUND(AVG(SALARY)) AS "�޿����", 
    MIN(SALARY) AS "�����޿�", 
    MAX(SALARY) AS "�ְ�޿�"
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

-- GROUP BY ���� �Լ��� ��� ����
SELECT DECODE(SUBSTR(EMP_NO, 8, 1),
    '1', '��',
    '2', '��'), COUNT(*)
FROM EMPLOYEE
GROUP BY SUBSTR(EMP_NO, 8, 1);

-- GROUP BY ���� ���� �÷� ���
SELECT DEPT_CODE, JOB_CODE, COUNT(*), SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE
ORDER BY DEPT_CODE ASC, JOB_CODE ASC;

---------------------------------------------------------------------------------------
/*
    [HAVING ��]
    �׷쿡 ���� ������ ������ �� ���Ǵ� ����(�ַ� �׷��Լ����� ������ ������ ����)
*/
-- �� �μ��� ��� �޿� ��ȸ(�μ��ڵ�, ��ձ޿�)
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- �� �μ��� ��� �޿��� 300���� �̻��� �μ��鸸 ��ȸ(�μ��ڵ� ��ձ޿�)
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE
-- WHERE AVG(SALARY) >= 3000000;
HAVING AVG(SALARY) >= 3000000;

--===========================================================================
--���޺� �����ڵ�, �� �޿���(��, ���޺� �޿����� 1000���� �̻��� ���޸� ��ȸ)
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
HAVING SUM(SALARY) >= 10000000;

--�μ��� ���ʽ��� �޴� ����� ���� �μ��� �ڵ�
SELECT DEPT_CODE
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(BONUS) = 0;

-----------------------------------------------------------------------------
/*
    SELECT * | ��ȸ�ϰ���� �÷� AS ��Ī | �Լ��� | ��������                ------- 5
    FROM ��ȸ�ϰ����ϴ� ���̺� | DUAL                                     ------- 1
    WHERE ���ǽ� (�����ڵ��� Ȱ���Ͽ� ���)                                 ------- 2
    GROUP BY �׷������ �Ǵ� �÷� | �Լ���                                 ------- 3
    HAVING ���ǽ�(�׷��Լ��� ������ ���)                                  ------- 4
    ORDER BY �÷� | ��Ī | ���� [ASC | DESC] [NULLS FIST | NULLS LAST]  ------- 6
*/