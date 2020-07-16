create table spring_reply(
	rno number(10) constraint pk_reply primary key, -- 댓글 글번호
	bno number(10) not null,						-- 원본 글 번호
	reply varchar2(1000) not null, 					-- 댓글 내용
	replyer varchar2(50) not null,					-- 댓글 작성자
	replydate date default sysdate,					-- 댓글 작성일
	updatedate date default sysdate,				-- 댓글 수정일
	constraint fk_spring_reply foreign key(bno) references spring_board(bno)  -- 외래키
);

create sequence seq_reply;

-- 댓글 수 컬럼 추가
alter table spring_board add(replycnt number default 0);

-- 기존 댓글 수 업데이트
update spring_board set replycnt = (select count(*)
									from spring_reply
									where spring_reply.bno = SPRING_BOARD.bno);
