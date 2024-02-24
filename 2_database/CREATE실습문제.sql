--�ǽ����� --
--�������� ���α׷��� ����� ���� ���̺�� �����--
--�̶�, �������ǿ� �̸��� �ο��� ��
--   �� �÷��� �ּ��ޱ�

/*
    1. ���ǻ�鿡 ���� �����͸� ������� ���ǻ� ���̺�(TB_PUBLISHER)
    �÷� : PUB_NO(���ǻ� ��ȣ) - �⺻Ű(PUBLISHER_PK)
          PUB_NAME(���ǻ��) -- NOT NULL(PUBLISHER_NN)
          PHONE(���ǻ���ȭ��ȣ) -- �������Ǿ���
*/
--���� 3������ ����

CREATE TABLE TB_PUBLISHER (
    PUB_NO NUMBER CONSTRAINT PUBLISHER_PK PRIMARY KEY,
    PUB_NAME VARCHAR(20) CONSTRAINT PUBLISHER_NN NOT NULL,
    PHONE VARCHAR(13)
);

INSERT INTO TB_PUBLISHER
VALUES(1, 'EBS BOOKS', '02-526-2472');

INSERT INTO TB_PUBLISHER
VALUES(2, '��Ű�Ͻ�', '031-955-3658');

INSERT INTO TB_PUBLISHER
VALUES(3, 'T.W.I.G', NULL);

SELECT * FROM TB_PUBLISHER;

/*
    2. �����鿡 ���� �����͸� ������� ���� ���̺�(TB_BOOK)
    �÷� : BK_NO(������ȣ)--�⺻Ű(BOOK_PK)
          BK_TITLE(������)--NOT NULL(BOOK__NN_TITLE)
          BK_AUTHOR(���ڸ�)--NOT NULL(BOOK__NN_AUTHOR)
          BK_PRICE(����)-- �������Ǿ���
          BK_PUB_NO(���ǻ� ��ȣ)--�ܷ�Ű(BOOK_FK)(TB_PUBLISHER���̺��� ����)
                                �̶� �����ϰ� �ִ� �θ����� ������ �ڽĵ����͵� ���� �ǵ��� �ɼ�����
                                
*/
--5�� ������ ���� ������ �߰��ϱ�
DROP TABLE TB_BOOKS;
CREATE TABLE TB_BOOK (
    BK_NO NUMBER CONSTRAINT BOOK_PK PRIMARY KEY,
    BK_TITLE VARCHAR(100) CONSTRAINT BOOK__NN_TITLE NOT NULL,
    BK_AUTHOR VARCHAR(20) CONSTRAINT BOOK__NN_AUTHOR NOT NULL,
    BK_PRICE NUMBER,
    BK_PUB_NO NUMBER CONSTRAINT BOOK_FK REFERENCES TB_PUBLISHER(PUB_NO)
);

INSERT INTO TB_BOOK
VALUES(101, '�������ڸ� ���� ������ �� �ִ� IT ����', '�ֿ���', 15120, 3);

INSERT INTO TB_BOOK
VALUES(102, '�����Ͽ���� ������ ǥ�����μ��� ����', '������', 11700, 1);

INSERT INTO TB_BOOK
VALUES(103, '��ü������ ��ǰ� ����', '����ȣ', 18000, 2);

INSERT INTO TB_BOOK
VALUES(104, 'Real MySQL 8.0 [1��]', '������, �̼���', 22000, 2);

INSERT INTO TB_BOOK
VALUES(105, 'Real MySQL 8.0 [2��]', '������, �̼���', 24000, 2);

SELECT * FROM TB_BOOK;

/*
    3. ȸ���� ���� �����͸� ������� ȸ�� ���̺�(TB_MEMBER)
    �÷��� : MEMBER_NO(ȸ����ȣ) -- �⺻Ű(MEMBER_PK)
            MEMBER_ID(���̵�) -- �ߺ�����(MEMBER_UQ_ID)
            MEMBER_PWD(��й�ȣ) -- NOT NULL(MEMBER_NN_PWD)
            MEMBER_NAME(ȸ����) -- NOT NULL(MEMBER_NN_NAME)
            GENDER(����) -- M�Ǵ� F�� �Էµǵ��� ����(MEMBER_CK_GEN)
            ADDRESS(�ּ�) -- �������Ǿ���
            PHONE(����ó)-- �������Ǿ���
            STATUS(Ż�𿩺�) -- �⺻���� N���� ����, �׸��� N�Ǵ� Y�� �Էµǵ��� �������� ����(MEMBER_CK_STA)
            ENROLL_DATE(������) -- �⺻������ SYSDATE, NOT NULL ��������(MEMBER_NN_EN)
*/
--5�� ������ ���� ������ �߰��ϱ�

CREATE TABLE TB_MEMBER (
    MEMBER_NO NUMBER CONSTRAINT MEMBER_PK PRIMARY KEY,
    MEMBER_ID VARCHAR(20) CONSTRAINT MEMBER_UQ_ID UNIQUE,
    MEMBER_PWD VARCHAR(20) CONSTRAINT MEMBER_NN_PWD NOT NULL,
    MEMBER_NAME VARCHAR(20) CONSTRAINT MEMBER_NN_NAME NOT NULL,
    GENDER CHAR(1) CONSTRAINT MEMBER_CK_GEN CHECK(GENDER IN ('M' , 'F')),
    ADDRESS VARCHAR(200),
    PHONE VARCHAR(13),
    STATUS CHAR(1) DEFAULT 'N' CONSTRAINT MEMBER_CK_STA CHECK(STATUS IN ('N', 'Y')),
    ENROLL_DATE DATE DEFAULT SYSDATE CONSTRAINT MEMBER_NN_EN NOT NULL
);

INSERT INTO TB_MEMBER 
VALUES(1, 'USER01', 'PASS01', 'ȫ�浿', 'M', NULL, NULL, 'Y', '2000/01/01');

INSERT INTO TB_MEMBER 
VALUES(2, 'USER02', 'PASS02', 'ȫ���', 'F', '���� ������ �б�����', '010-2222-2222', DEFAULT, DEFAULT);

INSERT INTO TB_MEMBER 
VALUES(3, 'USER03', 'PASS03', 'ĭƮ', 'M', '���� ���̷���Ʈ', '333-3333-3333', DEFAULT, '2010/12/25');

INSERT INTO TB_MEMBER 
VALUES(4, 'USER04', 'PASS04', '�迵��', 'M', '�λ� �ؿ��', '010-4545-5454', 'N', DEFAULT);

INSERT INTO TB_MEMBER 
VALUES(5, 'USER05', 'PASS05', '������', 'F', '���� ����', '010-5555-5555', 'N', '2017/03/02');

SELECT * FROM TB_MEMBER;

/*
    4.� ȸ���� � ������ �뿩�ߴ����� ���� �뿩��� ���̺�(TB_RENT)
    �÷��� : RENT_NO(�뿩��ȣ)-- �⺻Ű(RENT_PK)
            RENT_MEM_NO(�뿩ȸ����ȣ)-- �ܷ�Ű(RENT_FK_MEM) TB_MEMBER�� �����ϵ���
                                        �̶� �θ� ������ ������ �ڽĵ����� ���� NULL�� �ǵ��� ����
            RENT_BOOK_NO(�뿩������ȣ)-- �ܷ�Ű(RENT_FK_BOOK) TB_BOOK�� �����ϵ���
                                        �̶� �θ� ������ ������ �ڽĵ����� ���� NULL�� �ǵ��� ����
            RENT_DATE(�뿩��) -- �⺻�� SYSDATE
*/

--3�� ������ ���� ������ �߰��ϱ�

CREATE TABLE TB_RENT (
    RENT_NO NUMBER CONSTRAINT RENT_PK PRIMARY KEY,
    RENT_MEM_NO NUMBER CONSTRAINT RENT_FK_MEM REFERENCES TB_MEMBER ON DELETE SET NULL,
    RENT_BOOK_NO NUMBER CONSTRAINT RENT_FK_BOOK REFERENCES TB_BOOK ON DELETE SET NULL,
    RENT_DATE DATE DEFAULT SYSDATE
);

INSERT INTO TB_RENT
VALUES(1, 2, 101, SYSDATE);

INSERT INTO TB_RENT
VALUES(2, 3, 102, '2020/02/21');

INSERT INTO TB_RENT
VALUES(3, 4, 103, '2022/02/22');

SELECT * FROM TB_RENT;

SELECT MEMBER_NAME, BK_TITLE
FROM TB_RENT
JOIN TB_MEMBER ON (RENT_MEM_NO = MEMBER_NO)
JOIN TB_BOOK ON (RENT_BOOK_NO = BK_NO);