-- rownum : �����÷�
select rownum, bno, title from spring_board;

select rownum, bno, title from spring_board where rownum<=10;

insert into SPRING_BOARD(bno,title,content,writer)
(select seq_board.nextval,title,content,writer from spring_board);

select count(*) from spring_board;

--�ֽű� 10�� ����
select rownum,bno,title,writer
from(select bno,title,writer from spring_board where bno>0 order by bno desc)
where rownum<=10;

-- 1 => �ֽű� 10�� 209~200
select *
from(select rownum rn,bno,title,writer
	from(select bno,title,writer from spring_board where bno>0 order by bno desc)
	where rownum<=10)
where rn>0;

-- 2 => �� ���� �ֽű� 200~191
select *
from(select rownum rn,bno,title,writer
	from(select bno,title,writer from spring_board where bno>0 order by bno desc)
	where rownum<=20)
where rn>10;

-- ����Ŭ ��Ʈ �̿��ϱ�
select *
from(select /*+INDEX_DESC(spring_board pk spring_board)*/
		rownum rn,bno,title,writer
	from SPRING_BOARD
	where rownum<=10
where rn>0;

-- TC ����, �˻��� �ڹ�
select *
from(select /*+INDEX_DESC(spring_board pk spring_board)*/
	rownum rn,bno,title,writer,regdate,updatedate
	from SPRING_BOARD
	where rownum <= (1*20) and (title like '%�ڹ�' or content like '%�ڹ�')
where rn > ((1-1)*20)

-- TCW ����, �˻��� �ڹ�
select *
from(select /*+INDEX_DESC(spring_board pk spring_board)*/
	rownum rn,bno,title,writer,regdate,updatedate
	from SPRING_BOARD
	where rownum <= (1*20) and (title like '%�ڹ�' or content like '%�ڹ�' or writer like '%�ڹ�')
where rn > ((1-1)*20)