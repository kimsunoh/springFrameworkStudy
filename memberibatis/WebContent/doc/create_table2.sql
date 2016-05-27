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

/* ȸ�� */
DROP TABLE Member 
	CASCADE CONSTRAINTS;

/* ȸ�������� */
DROP TABLE member_detail 
	CASCADE CONSTRAINTS;

/* ȸ�� */
CREATE TABLE Member (
	id VARCHAR2(16) NOT NULL, /* ���̵� */
	name VARCHAR2(20) NOT NULL, /* �̸� */
	pass VARCHAR2(16) NOT NULL, /* ��й�ȣ */
	email1 VARCHAR2(16), /* �̸���1 */
	email2 VARCHAR2(16), /* �̸���2 */
	joindate DATE DEFAULT sysdate /* ������ */
);

COMMENT ON TABLE Member IS 'ȸ��';

COMMENT ON COLUMN Member.id IS '���̵�';

COMMENT ON COLUMN Member.name IS '�̸�';

COMMENT ON COLUMN Member.pass IS '��й�ȣ';

COMMENT ON COLUMN Member.email1 IS '�̸���1';

COMMENT ON COLUMN Member.email2 IS '�̸���2';

COMMENT ON COLUMN Member.joindate IS '������';

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

/* ȸ�������� */
CREATE TABLE member_detail (
	id VARCHAR2(16) NOT NULL, /* ���̵� */
	zip1 VARCHAR2(3), /* �����ȣ1 */
	zip2 VARCHAR2(3), /* �����ȣ2 */
	addr1 VARCHAR2(100), /* �⺻�ּ� */
	addr2 VARCHAR2(100), /* ���ּ� */
	tel1 VARCHAR2(3), /* ��ȭ��ȣ1 */
	tel2 VARCHAR2(4), /* ��ȭ��ȣ2 */
	tel3 VARCHAR2(4) /* ��ȭ��ȣ3 */
);

COMMENT ON TABLE member_detail IS 'ȸ��������';

COMMENT ON COLUMN member_detail.id IS '���̵�';

COMMENT ON COLUMN member_detail.zip1 IS '�����ȣ1';

COMMENT ON COLUMN member_detail.zip2 IS '�����ȣ2';

COMMENT ON COLUMN member_detail.addr1 IS '�⺻�ּ�';

COMMENT ON COLUMN member_detail.addr2 IS '���ּ�';

COMMENT ON COLUMN member_detail.tel1 IS '��ȭ��ȣ1';

COMMENT ON COLUMN member_detail.tel2 IS '��ȭ��ȣ2';

COMMENT ON COLUMN member_detail.tel3 IS '��ȭ��ȣ3';

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