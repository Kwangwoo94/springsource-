--ȸ������
create table sp_user(
	userid varchar2(50),
	email varchar2(100) not null,
	enabled char(1) default '1',
	password varchar2(100) not null
);

alter table sp_user add constraint sp_user_pk primary key(userid);

--ȸ���� ���� ���� ����
create table sp_user_authority(
	userid varchar2(50) not null,
	authority varchar2(50) not null
);

alter table sp_user_authority add constraint sp_user_authority_fk foreign key(userid)
references sp_user(userid);


insert into sp_user(userid,email,password) values('1','user@test.com','1111');

insert into SP_USER_AUTHORITY(userid,authority) values('1','ROLE_USER');
insert into SP_USER_AUTHORITY(userid,authority) values('1','ROLE_ADMIN');

--1�� ȸ���� ���� ȸ�������� ���� ������ ��ȸ
SELECT u.userid,email,password,enabled,authority 
FROM SP_USER u JOIN SP_USER_AUTHORITY a ON u.userid = a.userid
WHERE u.userid = '1';

select * from SP_USER;
select * from SP_USER_AUTHORITY;

SELECT u.userid,email,password,enabled,authority 
FROM SP_USER u left outer join SP_USER_AUTHORITY a ON u.userid = a.userid
WHERE u.userid = '1';


-- remember me ���̺� ����(���̺� ������ ����)
create table persistent_logins(
	username varchar(64) not null,
	series varchar(64) not null,
	token varchar(64) not null,
	last_used timestamp not null
);

