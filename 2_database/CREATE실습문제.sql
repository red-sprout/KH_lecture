--실습문제 --
--도서관리 프로그램을 만들기 위한 테이블들 만들기--
--이때, 제약조건에 이름을 부여할 것
--   각 컬럼에 주석달기

/*
    1. 출판사들에 대한 데이터를 담기위한 출판사 테이블(TB_PUBLISHER)
    컬럼 : PUB_NO(출판사 번호) - 기본키(PUBLISHER_PK)
          PUB_NAME(출판사명) -- NOT NULL(PUBLISHER_NN)
          PHONE(출판사전화번호) -- 제약조건없음
*/
--샘플 3개정도 생성

CREATE TABLE TB_PUBLISHER (
    PUB_NO NUMBER CONSTRAINT PUBLISHER_PK PRIMARY KEY,
    PUB_NAME VARCHAR(20) CONSTRAINT PUBLISHER_NN NOT NULL,
    PHONE VARCHAR(13)
);

INSERT INTO TB_PUBLISHER
VALUES(1, 'EBS BOOKS', '02-526-2472');

INSERT INTO TB_PUBLISHER
VALUES(2, '위키북스', '031-955-3658');

INSERT INTO TB_PUBLISHER
VALUES(3, 'T.W.I.G', NULL);

SELECT * FROM TB_PUBLISHER;

/*
    2. 도서들에 대한 데이터를 담기위한 도서 테이블(TB_BOOK)
    컬럼 : BK_NO(도서번호)--기본키(BOOK_PK)
          BK_TITLE(도서명)--NOT NULL(BOOK__NN_TITLE)
          BK_AUTHOR(저자명)--NOT NULL(BOOK__NN_AUTHOR)
          BK_PRICE(가격)-- 제약조건없음
          BK_PUB_NO(출판사 번호)--외래키(BOOK_FK)(TB_PUBLISHER테이블을 참조)
                                이때 참조하고 있는 부모데이터 삭제시 자식데이터도 삭제 되도록 옵션지정
                                
*/
--5개 정도의 샘플 데이터 추가하기
DROP TABLE TB_BOOKS;
CREATE TABLE TB_BOOK (
    BK_NO NUMBER CONSTRAINT BOOK_PK PRIMARY KEY,
    BK_TITLE VARCHAR(100) CONSTRAINT BOOK__NN_TITLE NOT NULL,
    BK_AUTHOR VARCHAR(20) CONSTRAINT BOOK__NN_AUTHOR NOT NULL,
    BK_PRICE NUMBER,
    BK_PUB_NO NUMBER CONSTRAINT BOOK_FK REFERENCES TB_PUBLISHER(PUB_NO)
);

INSERT INTO TB_BOOK
VALUES(101, '비전공자를 위한 이해할 수 있는 IT 지식', '최원영', 15120, 3);

INSERT INTO TB_BOOK
VALUES(102, '쇼펜하우어의 의지와 표상으로서의 세계', '박은미', 11700, 1);

INSERT INTO TB_BOOK
VALUES(103, '객체지향의 사실과 오해', '조영호', 18000, 2);

INSERT INTO TB_BOOK
VALUES(104, 'Real MySQL 8.0 [1권]', '백은빈, 이성욱', 22000, 2);

INSERT INTO TB_BOOK
VALUES(105, 'Real MySQL 8.0 [2권]', '백은빈, 이성욱', 24000, 2);

SELECT * FROM TB_BOOK;

/*
    3. 회원에 대한 데이터를 담기위한 회원 테이블(TB_MEMBER)
    컬럼명 : MEMBER_NO(회원번호) -- 기본키(MEMBER_PK)
            MEMBER_ID(아이디) -- 중복금지(MEMBER_UQ_ID)
            MEMBER_PWD(비밀번호) -- NOT NULL(MEMBER_NN_PWD)
            MEMBER_NAME(회원명) -- NOT NULL(MEMBER_NN_NAME)
            GENDER(성별) -- M또는 F로 입력되도록 제한(MEMBER_CK_GEN)
            ADDRESS(주소) -- 제약조건없음
            PHONE(연락처)-- 제약조건없음
            STATUS(탈퇴여부) -- 기본값을 N으로 지정, 그리고 N또는 Y만 입력되도록 제약조건 설정(MEMBER_CK_STA)
            ENROLL_DATE(가입일) -- 기본값으로 SYSDATE, NOT NULL 제약조건(MEMBER_NN_EN)
*/
--5개 정도의 샘플 데이터 추가하기

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
VALUES(1, 'USER01', 'PASS01', '홍길동', 'M', NULL, NULL, 'Y', '2000/01/01');

INSERT INTO TB_MEMBER 
VALUES(2, 'USER02', 'PASS02', '홍길순', 'F', '서울 강남구 압구정로', '010-2222-2222', DEFAULT, DEFAULT);

INSERT INTO TB_MEMBER 
VALUES(3, 'USER03', 'PASS03', '칸트', 'M', '독일 바이로이트', '333-3333-3333', DEFAULT, '2010/12/25');

INSERT INTO TB_MEMBER 
VALUES(4, 'USER04', 'PASS04', '김영한', 'M', '부산 해운대', '010-4545-5454', 'N', DEFAULT);

INSERT INTO TB_MEMBER 
VALUES(5, 'USER05', 'PASS05', '박은빈', 'F', '서울 신촌', '010-5555-5555', 'N', '2017/03/02');

SELECT * FROM TB_MEMBER;

/*
    4.어떤 회원이 어떤 도서를 대여했는지에 대한 대여목록 테이블(TB_RENT)
    컬럼명 : RENT_NO(대여번호)-- 기본키(RENT_PK)
            RENT_MEM_NO(대여회원번호)-- 외래키(RENT_FK_MEM) TB_MEMBER와 참조하도록
                                        이때 부모 데이터 삭제시 자식데이터 값이 NULL이 되도록 지정
            RENT_BOOK_NO(대여도서번호)-- 외래키(RENT_FK_BOOK) TB_BOOK와 참조하도록
                                        이때 부모 데이터 삭제시 자식데이터 값이 NULL이 되도록 지정
            RENT_DATE(대여일) -- 기본값 SYSDATE
*/

--3개 정도의 샘플 데이터 추가하기

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