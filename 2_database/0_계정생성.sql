-- �� �� �ּ�
/*
    ������
    �ּ�
*/

SELECT * FROM DBA_USERS; -- ���� ��� �����鿡 ���ؼ� ��ȸ�ϴ� ��ɹ�
--��ɹ� �ѱ��� ����(������ �����ư Ŭ�� | CTRL + ENTER)

--�Ϲ� ����� ������ �����ϴ� ����(���� ������ ���������� �� �� �ִ�.)
--[ǥ����] CREATE USER ������ IDENTIFIED BY ��й�ȣ;
CREATE USER KH IDENTIFIED BY KH;
--������ ��й�ȣ�� ��ҹ��ڸ� �����Ѵ�.

--������ ������ �Ϲ� ����� ������ �ּ����� ����(����, ������ ����) �ο�
--[ǥ����] GRANT ����1, ����2... TO ������;
GRANT RESOURCE, CONNECT TO KH;

CREATE USER JDBC IDENTIFIED BY JDBC;
GRANT RESOURCE, CONNECT TO JDBC;