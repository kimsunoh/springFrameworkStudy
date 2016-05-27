create table member
(
     name      varchar2(20) not null,
     id           varchar2(16),
     pass       varchar2(16) not null,
     email      varchar2(16),
     email2     varchar2(50),
     zip1       varchar2(3),
     zip2        varchar2(3),
     addr1      varchar2(100),
     addr2     varchar2(100),
     tel1       varchar2(3),
     tel2      varchar2(4),
     tel3      varchar2(4),
     joindate     date default sysdate,
     constraint member_id_pk primary key(id)
);