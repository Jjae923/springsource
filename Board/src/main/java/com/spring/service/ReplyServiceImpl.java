package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.domain.Criteria;
import com.spring.domain.ReplyPageVO;
import com.spring.domain.ReplyVO;
import com.spring.mapper.BoardMapper;
import com.spring.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapper reply;
	
	@Autowired
	private BoardMapper board;
	
	@Transactional
	@Override
	public boolean replyInsert(ReplyVO vo) {
		// 댓글 게시물 수 변경
		board.updateReplyCnt(vo.getBno(), 1);
		// 댓글 삽입
		return reply.insertReply(vo)==1? true:false;
	}

	@Override
	public ReplyVO replyRead(int rno) {
		return reply.read(rno);
	}

	@Override
	public boolean replyUpdate(ReplyVO vo) {
		return reply.updateReply(vo)==1? true:false;
	}

	@Transactional
	@Override
	public boolean replyDelete(int rno) {
		// rno를 이용해 bno 알아내기
		ReplyVO vo = reply.read(rno);
		// 댓글 게시물 수 변경
		board.updateReplyCnt(vo.getBno(), -1);
		// 댓글 삭제
		return reply.deleteReply(rno)==1? true:false;
	}

	@Override
	public ReplyPageVO replyList(Criteria cri, int bno) {
		return new ReplyPageVO(reply.getCountByBno(bno),reply.list(cri, bno));
	}
}
