/*
    *DDL : ������ ���� ���
    ����Ŭ���� �����ϴ� ��ü�� ���� �����(CREATE), ������ �����ϰ�(ALTER), ������ü�� ����(DELETE)�ϴ� ���
    ��, ���� ������ ���� �ƴ� ��Ģ ��ü�� �����ϴ� ���
    
    ����Ŭ������ ��ü(����) : ���̺�, ��, ������, �ε���, ��Ű��, Ʈ����
                        ���ν���, �Լ�, ���Ǿ�, �����
                        
    <CREATE>
    ��ü�� ���� �����ϴ� ����
*/

/*
    1. ���̺� ����
    - ���̺��̶� : ��� ���� �����Ǵ� ���� �⺻���� �����ͺ��̽� ��ü
                ��� �����͵��� ���̺��� ���ؼ� ���� ��
                
    CREATE TABLE ���̺��(
        �÷��� �ڷ���(ũ��),
        �÷��� �ڷ���(ũ��),
        �÷��� �ڷ���,
        ...
    )
    
    *�ڷ���
    -����(CHAR(����Ʈũ��) | VARCHAR2(����Ʈũ��))
        CHAR : �ִ� 2000����Ʈ���� �������� / ��������(������ ���ڼ��� �����Ͱ� ��� ���)
        (������ ũ�⺸�� �� ���� ���� ������ �������ζ� ä���� ó�� ������ ũ�⸦ ������ش�.)
        VARCHAR2 : �ִ� 4000����Ʈ���� �������� / ��������(������� �����Ͱ� ����� �𸣴� ���)
        (��� ���� ���� ���� ũ�Ⱑ ������)
    -����(NUMBER)
    -��¥(DATE)
*/

--ȸ���� ���� �����͸� ������� ���̺� MEMBER ����
CREATE TABLE MEMBER(
    MEM_NO NUMBER,
    MEM_ID VARCHAR2(20),
    MEM_PWD VARCHAR2(20),
    MEM_NAME VARCHAR2(20),
    GENDER CHAR(3),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE
);

SELECT * FROM MEMBER;

--������ ��ųʸ� : �پ��� ��ü���� ������ �����ϰ� �ִ� �ý��� ���̺�
SELECT * FROM USER_TABLES;
SELECT * FROM USER_TAB_COLUMNS;

----------------------------------------------------------------------------------
/*
    2. Į���� �ּ��ޱ�(�÷��� ���� ������ ����)
    
    [ǥ����]
    COMMENT ON COLUMN ���̺��.�÷��� IS '�ּ�����'
    -> �߸� �ۼ��� ���� �����ϸ� �ȴ�.
*/
COMMENT ON COLUMN MEMBER.MEM_NO IS 'ȸ����ȣ';
COMMENT ON COLUMN MEMBER.MEM_ID IS 'ȸ�����̵�';
COMMENT ON COLUMN MEMBER.MEM_PWD IS 'ȸ����й�ȣ';
COMMENT ON COLUMN MEMBER.MEM_NAME IS 'ȸ����';
COMMENT ON COLUMN MEMBER.GENDER IS '����(��/��)';
COMMENT ON COLUMN MEMBER.PHONE IS '��ȭ��ȣ';
COMMENT ON COLUMN MEMBER.EMAIL IS '�̸���';
COMMENT ON COLUMN MEMBER.MEM_DATE IS 'ȸ��������';

--���̺� �����ϰ��� �� �� : DROP TABLE ���̺��;
DROP TABLE MEMBER;

--���̺� �����͸� �߰���Ű�� ����(INSERT)
--INSERT INTO ���̺�� VALUES(��, ��, ��, ��, ��, ��, ��)
INSERT INTO MEMBER
VALUES(1, 'USER1', 'PASS1', 'ȫ�浿', '��', '010-1111-2222', 'aaaa@naver.com', '24/02/23');

INSERT INTO MEMBER
VALUES(2, 'USER2', 'PASS2', 'ȫ�浿', NULL, NULL, NULL, SYSDATE);

INSERT INTO MEMBER
VALUES(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--------------------------------------------------------------------------------------
/*
    <��������>
    -���ϴ� �����Ͱ�(��ȿ�� ������ ��)�� �����ϱ� ���ؼ� Ư�� �÷��� �����ϴ� ����
    -������ ���Ἲ ������ �������� �Ѵ�.
    
    ���� : NOT NULL, UNIQUE, CHECK, PRIMARY, FOREIGN KEY
*/

/*
    *NOT NULL ��������
    �ش� �÷��� �ݵ�� ���� �����ؾ߸� �� ���(��, ���� NULL�� ������ �ȵǴ� ���)
    ����/������ NULL���� ������� �ʵ��� ����
    
    ���������� �ο��ϴ� ����� ũ�� 2������ �ִ�. (�÷�������� / ���̺������)
    NOT NULL���������� ������ �÷�����������θ� �����ϴ�.
*/

CREATE TABLE MEM_NOTNULL(
    MEM_NO NUMBER NOT NULL,
    MEM_ID VARCHAR2(20) NOT NULL,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50)
);

INSERT INTO MEM_NOTNULL
VALUES(1, 'USER1', 'PASS1', 'ȫ�浿', '��', '010-1111-2222', 'aaaa@naver.com');

SELECT * FROM MEM_NOTNULL;

INSERT INTO MEM_NOTNULL
VALUES(2, 'USER2', 'PASS2', 'ȫ���', NULL, NULL, NULL);

INSERT INTO MEM_NOTNULL
VALUES(3, NULL, 'PASS2', 'ȫ���', NULL, NULL, NULL);
--�ǵ��ߴ���� ������ �߻��Ѵ�. (NOT NULL �������ǿ� ����Ǿ� ���� �߻�)

INSERT INTO MEM_NOTNULL
VALUES(3, 'USER2', 'PASS2', 'ȫ���', NULL, NULL, NULL);
--���̵� �ߺ��Ǿ������� �ұ��ϰ� �� �߰��� �ȴ�...

-----------------------------------------------------------------------------
/*
    *UNIQUE ��������
    �ش��÷��� �ߺ��� ���� ������ �ȵ� ��� ����Ѵ�.
    �÷����� �ߺ����� �����ϴ� ���������̴�.
    ����/������ ������ �ִ� ������ �� �� �ߺ����� ���� ��� ������ �߻���Ų��.
*/

CREATE TABLE MEM_UNIQUE(
    MEM_NO NUMBER NOT NULL,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE, -- �÷��������
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50)
    -- UNIQUE(MEM_ID) -- ���̺������
);

INSERT INTO MEM_UNIQUE
VALUES(1, 'USER1', 'PASS1', 'ȫ�浿', '��', '010-1111-2222', 'aaaa@naver.com');

SELECT * FROM MEM_UNIQUE;

INSERT INTO MEM_UNIQUE
VALUES(2, 'USER1', 'PASS2', 'ȫ���', '��', NULL, NULL);
--UNIQUE �������ǿ� ����Ǿ����Ƿ� INSERT ����
--> ���������� �������Ǹ����� �˷��ش�.
--> ���� �ľ��ϱ�� ��ƴ�
--> �������� �ο��� �������Ǹ��� ���������� ������ �ý��ۿ��� �̸��� �ο��Ѵ�.

-----------------------------------------------------------------------------------
/*
    *�������� �ο��� �������Ǹ���� �����ִ� ���
    > �÷��������
    CREATE TABLE ���̺��(
        �÷��� �ڷ��� (CONSTRAINTE �������Ǹ�) ��������
    )
    
    > ���̺������
    CREATE TABLE ���̺��(
        �÷��� �ڷ���,
        �÷��� �ڷ���,
        (CONSTRAINTE �������Ǹ�) ��������(�÷���)
    )
*/

DROP TABLE MEM_UNIQUE;

CREATE TABLE MEM_UNIQUE(
    MEM_NO NUMBER CONSTRAINT MEMNO_NT NOT NULL,
    MEM_ID VARCHAR2(20) CONSTRAINT MEMID_NT NOT NULL, -- �÷��������
    MEM_PWD VARCHAR2(20) CONSTRAINT MEMPWD_NT NOT NULL,
    MEM_NAME VARCHAR2(20) CONSTRAINT MEMNAME_NT NOT NULL,
    GENDER CHAR(3),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    CONSTRAINT MEMID_UQ UNIQUE(MEM_ID) -- ���̺������
);

INSERT INTO MEM_UNIQUE
VALUES(1, 'USER1', 'PASS1', 'ȫ�浿', '��', '010-1111-2222', 'aaaa@naver.com');

INSERT INTO MEM_UNIQUE
VALUES(2, 'USER2', 'PASS2', 'ȫ���', '��', NULL, NULL);

INSERT INTO MEM_UNIQUE
VALUES(3, 'USER3', 'PASS3', '�谳��', NULL, NULL, NULL);

INSERT INTO MEM_UNIQUE
VALUES(4, 'USER4', 'PASS4', '�ְ���', NULL, NULL, NULL);

-------------------------------------------------------------------------
/*
    *CHECK(���ǽ�)
    �ش��÷��� ���� �� �ִ� ���� ���� ������ �����ص� �� ����
    �ش����ǿ� �����ϴ� �����Ͱ��� ��� �� ����
*/

CREATE TABLE MEM_CHECK(
    MEM_NO NUMBER NOT NULL,
    MEM_ID VARCHAR2(20) NOT NULL,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('��', '��')),-- ��, ��
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    UNIQUE(MEM_ID)
    -- CHECK(GENDER IN ('��', '��'))
);

INSERT INTO MEM_CHECK
VALUES(1, 'USER1', 'PASS1', 'ȫ�浿', '��', '010-1111-2222', 'aaaa@naver.com');

SELECT * FROM MEM_CHECK;

INSERT INTO MEM_CHECK
VALUES(2, 'USER2', 'PASS2', 'ȫ���', '��', NULL, NULL);
--> CHECK �������Ƕ����� ������ �߻��Ѵ�.
--> ���� GENDER�÷��� �����͸� �ְ����Ѵٸ� CHECK�������ǿ� �����ϴ� ���� �־�� �Ѵ�.

INSERT INTO MEM_CHECK
VALUES(2, 'USER2', 'PASS2', 'ȫ���', NULL, NULL, NULL);
--> NULL�� ���� ���ٴ� ���̱� ������ �����ϴ�.

---------------------------------------------------------------------------------

/*
    PRIMARY KEY(�⺻Ű) ��������
    ���̺��� �� ��(ROW)�� �ĺ��ϱ� ���� ���� �÷��� �ο��ϴ� ��������(�ĺ��� ����)
    
    EX) ȸ����ȣ, �й�, ����, �μ��ڵ�, �����ڵ�, �ֹ���ȣ, �ù������ȣ, �����ȣ���...
    PRIMARY KEY ���������� �ο� -> NOT NULL + UNIQUE
    
    ���ǻ��� : �����̺�� ���� �Ѱ��� ���� ����
*/

CREATE TABLE MEM_PRI(
    MEM_NO NUMBER CONSTRAINT MEMNO_PK PRIMARY KEY,
    MEM_ID VARCHAR2(20) NOT NULL,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('��', '��')),-- ��, ��
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    UNIQUE(MEM_ID)
    -- PRIMARY KEY(MEM_NO)
);

INSERT INTO MEM_PRI
VALUES(1, 'USER1', 'PASS1', 'ȫ�浿', '��', '010-1111-2222', 'aaaa@naver.com');

INSERT INTO MEM_PRI
VALUES(1, 'USER2', 'PASS2', 'ȫ���', '��', NULL, NULL);
--> �⺻Ű�� �ߺ����� �������� �� ��(UNIQUE �������� ����)

INSERT INTO MEM_PRI
VALUES(NULL, 'USER2', 'PASS2', 'ȫ���', '��', NULL, NULL);
--> �⺻Ű�� NULL�� �������� �� ��(NOT NULL �������� ����)

INSERT INTO MEM_PRI
VALUES(2, 'USER2', 'PASS2', 'ȫ���', '��', NULL, NULL);

---------------------------------------------------------------------------------
CREATE TABLE MEM_PRI2(
    MEM_NO NUMBER,
    MEM_ID VARCHAR2(20) NOT NULL,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('��', '��')),-- ��, ��
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    UNIQUE(MEM_ID),
    PRIMARY KEY(MEM_NO, MEM_ID)
);
-- ����Ű - �ΰ��� �÷��� ���ÿ� �ϳ��� PRIMARYKEY�� �����ϴ� ��

INSERT INTO MEM_PRI2
VALUES(1, 'USER1', 'PASS1', 'ȫ�浿', '��', '010-1111-2222', 'aaaa@naver.com');

INSERT INTO MEM_PRI2
VALUES(1, 'USER2', 'PASS2', 'ȫ���', '��', NULL, NULL);

INSERT INTO MEM_PRI2
VALUES(2, 'USER3', 'PASS3', 'ȫ���', '��', NULL, NULL);

--����Ű ��� ����(� ȸ���� � ��ǰ�� ���ϴ����� ���� �����͸� �����ϴ� ���̺�)
CREATE TABLE TB_LIKE(
    MEM_NO NUMBER,
    PRODUCT_NAME VARCHAR2(10),
    LIKE_DATE DATE,
    PRIMARY KEY(MEM_NO, PRODUCT_NAME)
);

--ȸ���� 2��(1, 2��) �����Ѵ�.
--����A, ����B ��ǰ�� �����Ѵ�.

INSERT INTO TB_LIKE VALUES(1, '������A', SYSDATE);
SELECT * FROM TB_LIKE;
INSERT INTO TB_LIKE VALUES(1, '������B', SYSDATE);
INSERT INTO TB_LIKE VALUES(1, '������A', SYSDATE);

----------------------------------------------------------------------------
--ȸ����޿� ���� �����͸� ���� �����ϴ� ���̺�
CREATE TABLE MEM_GRADE(
    GRADE_CODE NUMBER PRIMARY KEY,
    GRADE_NAME VARCHAR2(30) NOT NULL
);

INSERT INTO MEM_GRADE VALUES(10, '�Ϲ�ȸ��');
INSERT INTO MEM_GRADE VALUES(20, '���ȸ��');
INSERT INTO MEM_GRADE VALUES(30, 'Ư��ȸ��');

CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('��', '��')),-- ��, ��
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    GRADE_ID NUMBER
);

INSERT INTO MEM VALUES(1, 'USER1', 'PASS01', 'ȫ���', '��', NULL, NULL, NULL);
INSERT INTO MEM VALUES(2, 'USER2', 'PASS02', 'ȫ�浿', '��', NULL, NULL, 10);
INSERT INTO MEM VALUES(3, 'USER3', 'PASS03', '������', NULL, NULL, NULL, 10);
--��ȿ�� ȸ����޹�ȣ�� �ƴϾ INSERT�� �� �ȴ�.
------------------------------------------------------------------------------
/*
    *FOREIGN KEY(�ܷ�Ű) ��������
    �ٸ����̺� �����ϴ� ���� ���;ߵǴ� Ư�� Į���� �ο��ϴ� ��������
    -> �ٸ� ���̺��� �����Ѵٰ� ǥ��
    -> �ַ� FOREIGN KEY ������������ ���� ���̺� ���谡 �����ȴ�.
    
    > �÷��������
    �÷��� �ڷ��� REFERENCES ���������̺��[(������ �÷���)]
    
    > ���̺� �������
    FOREIGN KEY(�÷���) REFERENCES ���������̺��[(������ �÷���)]
    
    -> �������÷��� ������ ������ ���̺� PRIMARY KEY�� ������ �÷��� ��Ī�ȴ�.
*/

DROP TABLE MEM;
CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('��', '��')),-- ��, ��
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    GRADE_ID NUMBER REFERENCES MEM_GRADE(GRADE_CODE)
    -- FOREIGN KEY(GRADE_ID) REFERENCES MEM_GRADE(GRADE_CODE)
);

INSERT INTO MEM VALUES(1, 'USER1', 'PASS01', 'ȫ�浿', '��', NULL, NULL, NULL);
-->�ܷ�Ű ���������� �ο��� �÷��� �⺻������ NULL����
INSERT INTO MEM VALUES(2, 'USER2', 'PASS02', 'ȫ���', '��', NULL, NULL, 10);
INSERT INTO MEM VALUES(3, 'USER3', 'PASS03', '�ְ���', NULL, NULL, NULL, 40);
-->parent key�� ã�� �� ���ٴ� ���� �߻�

SELECT * FROM MEM;
-- MEM_GRADE(�θ����̺�) -|-------<- MEM(�ڽ����̺�)
--          1:N���� 1���� �θ����̺� N�� �ڽ����̺�
INSERT INTO MEM VALUES(3, 'USER3', 'PASS3', '�谳��', '��', NULL, NULL, 20);
INSERT INTO MEM VALUES(4, 'USER4', 'PASS4', '�ֹ��', '��', NULL, NULL, 10);

--> �̶� �θ����̺��� �����Ͱ��� �����ϸ� ��� �ɱ�?
-- ������ ���� : DELETE FROM ���̺�� WHERE ����;

--MEM_GRADE ���̺��� 10����� ����
DELETE FROM MEM_GRADE
WHERE GRADE_CODE = 10;
--> �ڽ����̺��� 10�̶�� ���� ����ϰ� �ֱ� ������ ������ �ȵ�

DELETE FROM MEM_GRADE
WHERE GRADE_CODE = 30;
--> �ڽ����̺��� 30�̶�� ���� ����ϰ� ���� �ʱ� ������ ������ �ȴ�.

--> �ڽ����̺� �̹� ����ϰ� �ִ� ���� ���� ���
--> �θ����̺�κ��� ������ ������ �ȵǴ� "��������" �ɼ��� �ɷ��ִ�.

ROLLBACK;

-----------------------------------------------------------------------------
/*
    �ڽ����̺� ������ �ܷ�Ű �������� �ο��� �� �����ɼ� ��������
    *�����ɼ� : �θ����̺��� ������ ������ �� �����͸� ����ϰ� �ִ� �ڽ����̺��� ���� ��� �� ���ΰ�?
    
    -ON DELETE RESTRICTED(�⺻��): �������ѿɼ�, �ڽĵ����ͷκ��� ���̴� �θ����ʹ� ������ �ƿ� �ȵ�
    -ON DELETE SET NULL : �θ����� ������ �ش� �����͸� ����ϰ� �ִ� �ڽĵ������� ���� NULL�� ����
    -ON DELETE CASCADE : �θ����� ������ �ش� �����͸� ����ϰ� �ִ� �ڽĵ����͵� ���� ������Ű�� �ɼ�
*/

DROP TABLE MEM;

CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('��', '��')),-- ��, ��
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    GRADE_ID NUMBER REFERENCES MEM_GRADE(GRADE_CODE) ON DELETE SET NULL
    -- FOREIGN KEY(GRADE_ID) REFERENCES MEM_GRADE(GRADE_CODE)
);

INSERT INTO MEM VALUES(1, 'USER1', 'PASS01', 'ȫ�浿', '��', NULL, NULL, NULL);
INSERT INTO MEM VALUES(2, 'USER2', 'PASS02', 'ȫ���', '��', NULL, NULL, 10);
INSERT INTO MEM VALUES(3, 'USER3', 'PASS3', '�谳��', '��', NULL, NULL, 20);
INSERT INTO MEM VALUES(4, 'USER4', 'PASS4', '�ֹ��', '��', NULL, NULL, 10);

--10�� ��� ����
DELETE FROM MEM_GRADE
WHERE GRADE_CODE = 10;
--> �� ������ �Ϸ��, 10�� ������ �����ִ� �ڽĵ������� ���� NULL�� �����

ROLLBACK;

DROP TABLE MEM;

CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('��', '��')),-- ��, ��
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    GRADE_ID NUMBER REFERENCES MEM_GRADE(GRADE_CODE) ON DELETE CASCADE
    -- FOREIGN KEY(GRADE_ID) REFERENCES MEM_GRADE(GRADE_CODE)
);

INSERT INTO MEM VALUES(1, 'USER1', 'PASS01', 'ȫ�浿', '��', NULL, NULL, NULL);
INSERT INTO MEM VALUES(2, 'USER2', 'PASS02', 'ȫ���', '��', NULL, NULL, 10);
INSERT INTO MEM VALUES(3, 'USER3', 'PASS3', '�谳��', '��', NULL, NULL, 20);
INSERT INTO MEM VALUES(4, 'USER4', 'PASS4', '�ֹ��', '��', NULL, NULL, 10);

--10�� ��� ����
DELETE FROM MEM_GRADE
WHERE GRADE_CODE = 10;
--> ������ �ߵ�, �ش絥���͸� ����ϰ� �ִ� �ڽĵ����͵� ���� ������ ��

------------------------------------------------------------------------------
/*
    <DEFAULT �⺻��> *���������� �ƴϴ�.
    �÷��� ���������ʰ� INSERT�� NULL�� �ƴ� �⺻���� INSERT�ϰ����Ѵ�.
    �� �� �����ص� �� �ִ� ��
    
    �÷��� �ڷ��� DEFAULT �⺻��
*/

DROP TABLE MEMBER;

CREATE TABLE MEMBER(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_NAME VARCHAR2(20) NOT NULL,
    MEM_AGE NUMBER,
    HOBBY VARCHAR2(20) DEFAULT '����',
    ENROLL_DATE DATE DEFAULT SYSDATE
);

--INSERT INTO ���̺�� VALUES(�÷���, �÷���...)
INSERT INTO MEMBER VALUES(1, '������', 20, '�', '20/01/01');
INSERT INTO MEMBER VALUES(2, '����', 22, NULL, NULL);
INSERT INTO MEMBER VALUES(3, '������', 17, DEFAULT, DEFAULT);

SELECT * FROM MEMBER;

--INSERT INTO MEMBER(�÷�1, �÷�2, ...) VALUES(�÷�1��, �÷�2��...);
INSERT INTO MEMBER(MEM_NO, MEM_NAME) VALUES(4, '�̱���');
-->���õ��� ���� �÷����� �⺻������ NULL�� ��
-->��, �ش� �÷��� DEFAULT���� �ο��Ǿ� ���� ��� NULL�� �ƴ� DEFAULT���� ��.

------------------------------------------------------------------------------
--���̺��� ������ �� �ִ�.
CREATE TABLE EMPLOYEE_COPY
AS (SELECT * FROM EMPLOYEE);

DROP TABLE EMPLOYEE_COPY;
------------------------------------------------------------------------------

/*
    *���̺��� �� ������ �Ŀ� �ڴʰ� ���������� �߰��ϴ� ���
    ALTER TABLE ���̺�� ������ ����
    
    -PRIMARY KEY : ALTER TABLE ���̺�� ADD PRIMARY KEY(�÷���);
    -FOREIGN KEY : ALTER TABLE ���̺�� ADD FOREIGN KET(�÷���) REFERENCES ������ ���̺��[(�������÷���)]
    -UNIQUE      : ALTER TABLE ���̺�� ADD UNIQUE(�÷���);
    -CHECK       : ALTER TABLE ���̺�� ADD CHECK(�÷��� ���� ���ǽ�);
    -NOT NULL    : ALTER TABLE ���̺�� MODIFY �÷��� NOT NULL;
*/

--EMPLOYEE_COPY ���̺� PRIMARY_KEY ���������� �߰�(EMP_ID)
ALTER TABLE EMPLOYEE_COPY ADD PRIMARY KEY(EMP_ID);

--EMPLOYEE ���̺� DEPT_CODE�� �ܷ�Ű �������� �߰�
ALTER TABLE EMPLOYEE ADD FOREIGN KEY(DEPT_CODE) REFERENCES DEPARTMENT(DEPT_ID);

--EMPLOYEE ���̺� JOB_CODE�� �ܷ�Ű �������� �߰�
ALTER TABLE EMPLOYEE ADD FOREIGN KEY(JOB_CODE) REFERENCES JOB(JOB_CODE);

--DEPARTMENT ���̺� LOCATION_ID�� �ܷ�Ű �������� �߰�
ALTER TABLE DEPARTMENT ADD FOREIGN KEY(LOCATION_ID) REFERENCES LOCATION(LOCAL_CODE);
