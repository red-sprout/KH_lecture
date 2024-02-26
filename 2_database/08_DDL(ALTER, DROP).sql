/*
    DDL : ������ ���Ǿ��
    
    ��ü�� ����(CREATE), ����(ALTER), ����(DROP)�ϴ� ����
    
    <ALTER>
    ��ü�� �����ϴ� ����
    
    [ǥ����]
    ALTER TABLE ���̺�� ������ ����;
    
    ������ ����
    1) �÷� �߰�/����/����
    2) �������� �߰�/���� --> ������ �Ұ�(������ �ٽ� �߰�)
    3) �÷���/�������Ǹ�/���̺�� ����
*/

CREATE TABLE DEPT_TABLE
AS (SELECT * FROM DEPARTMENT);

--1) �÷� �߰�/����/����
--DEPT_TABLE�� CNAME�÷� �߰�
ALTER TABLE DEPT_TABLE ADD CNAME VARCHAR2(20);


--LNAME �÷� �߰�(�⺻�� -> �ѱ�)
ALTER TABLE DEPT_TABLE ADD LNAME VARCHAR2(20) DEFAULT '�ѱ�';

--1_2 �÷� ����(MODIFY)
--> ������ Ÿ�Լ��� : MODIFY �÷��� �ٲٰ����ϴ� ������Ÿ��
--> DEFAULT�� ���� : MODIFY �÷��� DEFAULT �ٲٰ����ϴ� �⺻��

ALTER TABLE DEPT_TABLE MODIFY DEPT_ID CHAR(5);
--ALTER TABLE DEPT_TABLE MODIFY DEPT_ID NUMBER; -- ���Ŀ��� �߻�
--ALTER TABLE DEPT_TABLE MODIFY DEPT_TITLE VARCHAR2(10); -- ũ����� �߻�

--DEPT_TITLE Į���� VARCHAR2(40)
ALTER TABLE DEPT_TABLE MODIFY DEPT_TITLE VARCHAR2(40);

--LNAME �÷��� �⺻���� '�̱�'���� ����
ALTER TABLE DEPT_TABLE MODIFY LNAME DEFAULT '�̱�';

--���ߺ��� ����
ALTER TABLE DEPT_TABLE
    MODIFY DEPT_TITLE VARCHAR2(40)
    MODIFY LNAME DEFAULT '�̱�';
    
-- 1_3) �÷� ����(DROP COLUMN) : DROP COLUMN �����ϰ����ϴ� �÷�

CREATE TABLE DEPT_COPY
AS SELECT * FROM DEPT_TABLE;

SELECT * FROM DEPT_COPY;

ALTER TABLE DEPT_COPY DROP COLUMN DEPT_ID;
ALTER TABLE DEPT_COPY DROP COLUMN CNAME;
ALTER TABLE DEPT_COPY DROP COLUMN LNAME;
ALTER TABLE DEPT_COPY DROP COLUMN DEPT_TITLE;

SELECT * FROM DEPT_COPY;
ALTER TABLE DEPT_COPY DROP COLUMN DEPT_COPY;
--> �ּ� �Ѱ��� �÷��� �����ؾ��Ѵ�.

-------------------------------------------------------------------
--2) �������� �߰�/����(������ �����ϰ� �ٽ� �߰��ϱ�� ��ü)

/*
    2_1)
    -PRIMARY KEY : ALTER TABLE ���̺�� ADD PRIMARY KEY(�÷���);
    -FOREIGN KEY : ALTER TABLE ���̺�� ADD FOREIGN KET(�÷���) REFERENCES ������ ���̺��[(�������÷���)]
    -UNIQUE      : ALTER TABLE ���̺�� ADD UNIQUE(�÷���);
    -CHECK       : ALTER TABLE ���̺�� ADD CHECK(�÷��� ���� ���ǽ�);
    -NOT NULL    : ALTER TABLE ���̺�� MODIFY �÷��� NOT NULL;
    
    �������Ǹ� �����ϰ��� �Ѵٸ� [CONSTRAINT �������Ǹ�] ��������
*/

--DEPT_TABLE
--DEPT_ID�� PRIMARY_KEY �������� �߰�
--DEPT_TITLE�� UNIQUE �������� �߰�
--LNAME�� NOT NULL �������� �߰�

ALTER TABLE DEPT_TABLE
    ADD CONSTRAINT DTABLE_PK PRIMARY KEY(DEPT_ID)
    ADD CONSTRAINT DTABLE_UQ UNIQUE(DEPT_TITLE)
    MODIFY LNAME CONSTRAINT DTABLE_NN NOT NULL ;


-- 2_2) �������� ���� : DROP CONSTRAINT �������Ǹ� / NOT NULL -> �����ȵ�
ALTER TABLE DEPT_TABLE DROP CONSTRAINT DTABLE_PK;

ALTER TABLE DEPT_TABLE
    DROP CONSTRAINT DTABLE_UQ
    MODIFY LNAME NULL;
    
------------------------------------------------------------------
--���̺� ����
DROP TABLE DEPT_TABLE;
--��򰡿� �����ǰ� �ִ� �θ����̺��� �Ժη� ���������� �ʴ´�.
--���� ������� �Ѵٸ�
-- 1. �ڽ����̺� ���� ���� �� ����
-- 2. �׳� �θ����̺� �����ϴµ� �������Ǳ��� �����ϴ� ���
-- DROP TABLE ���̺�� CASCADE CONSTRAINT;

-------------------------------------------------------------------
--3) �÷���/�������Ǹ�/���̺�� ����(RENAME)
--3_1) �÷��� ���� : RENAME COLUMN �����÷��� TO �ٲ� �÷���

SELECT * FROM DEPT_TABLE;

-- DEPT_TITLE -> DEPT_NAME ����
ALTER TABLE DEPT_TABLE RENAME COLUMN DEPT_TITLE TO DEPT_NAME;

--3_2)�������Ǹ� ���� : RENAME CONSTRAINT �����������Ǹ� TO �ٲ��������Ǹ�
ALTER TABLE DEPT_TABLE RENAME CONSTRAINT SYS_C007221 TO DTABLE_LID_NN;

--3_3)���̺�� ���� : RENAME TO �ٲ����̺��
ALTER TABLE DEPT_TABLE RENAME TO DEPT_TEST;

------------------------------------------------------------------------------
-- TRUNCATE : ���̺� �ʱ�ȭ
-- DROP���� �ٸ��� ���̺��� �����͸��� ���� �����Ͽ� ���̺��� �ʱ���·� �����ش�.
TRUNCATE TABLE DEPT_TEST;
SELECT * FROM DEPT_TEST;

DROP TABLE DEPT_TEST;
DROP TABLE DEPT_COPY;