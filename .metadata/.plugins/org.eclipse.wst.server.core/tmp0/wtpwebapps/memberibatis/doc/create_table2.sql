ALTER TABLE member_detail
	DROP
		CONSTRAINT FK_Member_TO_member_detail
		CASCADE;

ALTER TABLE Member
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE member_detail
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX PK_Member;

DROP INDEX PK_member_detail;

/* 회원 */
DROP TABLE Member 
	CASCADE CONSTRAINTS;

/* 회원상세정보 */
DROP TABLE member_detail 
	CASCADE CONSTRAINTS;

/* 회원 */
CREATE TABLE Member (
	id VARCHAR2(16) NOT NULL, /* 아이디 */
	name VARCHAR2(20) NOT NULL, /* 이름 */
	pass VARCHAR2(16) NOT NULL, /* 비밀번호 */
	email1 VARCHAR2(16), /* 이메일1 */
	email2 VARCHAR2(16), /* 이메일2 */
	joindate DATE DEFAULT sysdate /* 가입일 */
);

COMMENT ON TABLE Member IS '회원';

COMMENT ON COLUMN Member.id IS '아이디';

COMMENT ON COLUMN Member.name IS '이름';

COMMENT ON COLUMN Member.pass IS '비밀번호';

COMMENT ON COLUMN Member.email1 IS '이메일1';

COMMENT ON COLUMN Member.email2 IS '이메일2';

COMMENT ON COLUMN Member.joindate IS '가입일';

CREATE UNIQUE INDEX PK_Member
	ON Member (
		id ASC
	);

ALTER TABLE Member
	ADD
		CONSTRAINT PK_Member
		PRIMARY KEY (
			id
		);

/* 회원상세정보 */
CREATE TABLE member_detail (
	id VARCHAR2(16) NOT NULL, /* 아이디 */
	zip1 VARCHAR2(3), /* 우편번호1 */
	zip2 VARCHAR2(3), /* 우편번호2 */
	addr1 VARCHAR2(100), /* 기본주소 */
	addr2 VARCHAR2(100), /* 상세주소 */
	tel1 VARCHAR2(3), /* 전화번호1 */
	tel2 VARCHAR2(4), /* 전화번호2 */
	tel3 VARCHAR2(4) /* 전화번호3 */
);

COMMENT ON TABLE member_detail IS '회원상세정보';

COMMENT ON COLUMN member_detail.id IS '아이디';

COMMENT ON COLUMN member_detail.zip1 IS '우편번호1';

COMMENT ON COLUMN member_detail.zip2 IS '우편번호2';

COMMENT ON COLUMN member_detail.addr1 IS '기본주소';

COMMENT ON COLUMN member_detail.addr2 IS '상세주소';

COMMENT ON COLUMN member_detail.tel1 IS '전화번호1';

COMMENT ON COLUMN member_detail.tel2 IS '전화번호2';

COMMENT ON COLUMN member_detail.tel3 IS '전화번호3';

CREATE UNIQUE INDEX PK_member_detail
	ON member_detail (
		id ASC
	);

ALTER TABLE member_detail
	ADD
		CONSTRAINT PK_member_detail
		PRIMARY KEY (
			id
		);

ALTER TABLE member_detail
	ADD
		CONSTRAINT FK_Member_TO_member_detail
		FOREIGN KEY (
			id
		)
		REFERENCES Member (
			id
		);