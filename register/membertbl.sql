create table memberTBL(
	userid varchar2(15),
	password varchar2(20) not null,
	name varchar(20) not null,
	gender varchar(10) not null,
	email varchar(50) not null,
	constraint memberTBL_pk primary key(userid) 
);

insert into memberTBL(userid,password,name,gender,email)
values('yuri01','010203','조유리','여성','izoneyuri@naver.com');

select * from memberTBL;
