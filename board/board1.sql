-- rownum : 가상컬럼
select rownum, bno, title from spring_board;

select rownum, bno, title from spring_board where rownum<=10;

insert into SPRING_BOARD(bno,title,content,writer)
(select seq_board.nextval,title,content,writer from spring_board);

select count(*) from spring_board;

--최신글 10개 추출
select rownum,bno,title,writer
from(select bno,title,writer from spring_board where bno>0 order by bno desc)
where rownum<=10;

-- 1 => 최신글 10개 209~200
select *
from(select rownum rn,bno,title,writer
	from(select bno,title,writer from spring_board where bno>0 order by bno desc)
	where rownum<=10)
where rn>0;

-- 2 => 그 다음 최신글 200~191
select *
from(select rownum rn,bno,title,writer
	from(select bno,title,writer from spring_board where bno>0 order by bno desc)
	where rownum<=20)
where rn>10;

-- 오라클 힌트 이용하기
select *
from(select /*+INDEX_DESC(spring_board pk spring_board)*/
		rownum rn,bno,title,writer
	from SPRING_BOARD
	where rownum<=10
where rn>0;

-- TC 선택, 검색어 자바
select *
from(select /*+INDEX_DESC(spring_board pk spring_board)*/
	rownum rn,bno,title,writer,regdate,updatedate
	from SPRING_BOARD
	where rownum <= (1*20) and (title like '%자바' or content like '%자바')
where rn > ((1-1)*20)

-- TCW 선택, 검색어 자바
select *
from(select /*+INDEX_DESC(spring_board pk spring_board)*/
	rownum rn,bno,title,writer,regdate,updatedate
	from SPRING_BOARD
	where rownum <= (1*20) and (title like '%자바' or content like '%자바' or writer like '%자바')
where rn > ((1-1)*20)

--댓글 테이블 작성
create table spring_reply(
	rno number(10,0) constraint pk_reply primary key, --댓글 글번호
	bno number(10,0) not null, --원본 글번호
	reply varchar2(1000) not null, --댓글 내용
	replyer varchar2(50) not null, --댓글 작성자
	replydate date default sysdate,
	updatedate date default sysdate,
	constraint fk_reply_board foreign key(bno) references spring_board(bno)
);

create sequence seq_reply;

insert into spring_reply(rno,bno,reply,replyer)
values(seq_reply.nextval,140,'댓글작성2','홍길동');

select rownum, bno, rno  from spring_reply;

--댓글 index 생성
create index idx_reply on spring_reply(bno desc,rno asc);

--댓글 목록 불러오기
select rno,bno,reply,replyer,replydate,updatedate
from(
	select /*+INDEX(spring_reply idx_reply)*/
		rownum rn,rno,bno,reply,replyer,replydate,updatedate
	from spring_reply
	where bno=140 and rno > 0 and rownum <= 2 * 10
	)
where rn > (2-1) * 10;


--댓글 한 게시물에 있는 총 갯수
select count(*) from spring_reply where bno=140;

select * from spring_reply where bno=147;


--파일 첨부 테이블
create table spring_attach(
	uuid varchar2(100) not null,
	uploadPath varchar2(200) not null,
	fileName varchar2(100) not null,
	fileType char(1) default 'I',
	bno number(10,0)
);

alter table spring_attach add constraint pk_attach primary key(uuid);
alter table spring_attach add constraint fk_board_attach foreign key(bno) references spring_board(bno);

select * from spring_attach;

--어제 날짜
select * from spring_attach
where uploadPath = to_char(sysdate-1,'yyyy\mm\dd');
