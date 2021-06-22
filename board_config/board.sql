--board ����
create table spring_board(
	bno number(10,0),
	title varchar2(200) not null,
	content varchar2(2000) not null,
	writer varchar2(50) not null,
	regdate date default sysdate,
	updatedate date default sysdate
);

alter table spring_board add constraint pk_string_board primary key(bno);

-- ������ ����
create sequence seq_board;

--��� �� ���� �÷� �߰�
alter table spring_board add(replycnt number default 0);

--�̹� �� ��� �� ����
update spring_board
set replycnt = (select count(bno) from SPRING_REPLY where SPRING_BOARD.bno = SPRING_REPLY.bno);