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