/*
    <������ SEQUENCE>
    �ڵ����� ��ȣ�� �߻������ִ� ������ �ϴ� ��ü
    �������� ���������� �������� ������Ű�鼭 ��������
    
    EX) ȸ����ȣ, �����ȣ, �Խñ۹�ȣ....
    
    [ǥ����]
    CREATE SEQUENCE ��������
    [START WITH ���ۼ���] --> ó�� �߻���ų ���۰� ����[�⺻�� 1]
    [INCREMENT BY ����] --> �� �� ������ų ����[�⺻�� 1]
    [MAXVALUE ����] --> �ִ밪 ����[�⺻���� �ſ� ū ��]
    [MINVALUE ����] --> �ּҰ� ����[�⺻�� 1]
    [CYCLE | NOCYCLE] --> ���� ��ȯ���� ���� [�⺻�� NOCYCLE]
    [NOCACHE | CACHE ����Ʈũ��] --> ĳ�ø޸� �Ҵ�(�⺻�� CACHE 20)
    
    ĳ�ø޸� : �̸� �߻��� ������ �����ؼ� �����صδ� ����
                �Ź� ȣ��� ������ ���� ��ȣ�� �����ϴ°� �ƴ϶�
                ĳ�ø޸� ������ �̸� ������ ������ ������ �� �� �ִ�. (�ӵ��� ��������)
    ���̺�� : TB_
    ��� : VW_
    ������ : SEQ_
    Ʈ���� : TRG_
*/

CREATE SEQUENCE SEQ_TEST;

--[����] ���� ������ �����ϰ� �ִ� ���������� ������ ������ �� ��
SELECT * FROM USER_SEQUENCES;

CREATE SEQUENCE SEQ_EMPNO
    START WITH 300
    INCREMENT BY 5
    MAXVALUE 310
    NOCYCLE
    NOCACHE;

/*
    2. ������ ���
    
    ��������.CURRVAL : ���� ������ ��(���������� ������ NEXTVAL�� ��)
    ��������.NEXTvAL : ���������� �������� �������� �߻��� ��
                    ���� ������ ������ INCREMENT BY ����ŭ ������ ��;
*/

SELECT * FROM USER_SEQUENCES;

SELECT SEQ_EMPNO.CURRVAL FROM DUAL; --����
--> NEXTVAL�� �ѹ��� �������� ���� �̻� CURRVAL�� ������ �� ����
--> ��? CURRVAL�� ���������� ������ NEXTVAL�� ���� �����ؼ� �����ִ� �ӽð�
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 300
SELECT SEQ_EMPNO.CURRVAL FROM DUAL; -- 300
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 305
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 310

SELECT * FROM USER_SEQUENCES;
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 315

/*
    3. �������� ��������
    
    ALTER SEQUENCE ��������
    [INCREMENT BY ����] --> �� �� ������ų ����[�⺻�� 1]
    [MAXVALUE ����] --> �ִ밪 ����[�⺻���� �ſ� ū ��]
    [MINVALUE ����] --> �ּҰ� ����[�⺻�� 1]
    [CYCLE | NOCYCLE] --> ���� ��ȯ���� ���� [�⺻�� NOCYCLE]
    [NOCACHE | CACHE ����Ʈũ��] --> ĳ�ø޸� �Ҵ�(�⺻�� CACHE 20)
    
    START WITH�� ������ �Ұ�
*/

ALTER SEQUENCE SEQ_EMPNO
    INCREMENT BY 10
    MAXVALUE 400;
    
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL;

--4. ������ ����
DROP SEQUENCE SEQ_EMPNO;

------------------------------------------------------------------------
CREATE SEQUENCE SEQ_EID
    START WITH 400
    NOCACHE;
    
INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, JOB_CODE, HIRE_DATE)
    VALUES(SEQ_EID.NEXTVAL, '�踻��', '111111-2222222', 'J6', SYSDATE);
    
INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, JOB_CODE, HIRE_DATE)
    VALUES(SEQ_EID.NEXTVAL, '�����', '111111-2222222', 'J6', SYSDATE);

SELECT * FROM EMPLOYEE;