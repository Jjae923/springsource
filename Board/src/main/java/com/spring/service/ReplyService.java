package com.spring.service;

import java.util.List;

import com.spring.domain.Criteria;
import com.spring.domain.ReplyVO;

/* 변수명, 메소드명 규칙(카멜케이스)
 * 소문자로 시작 
 * 두 단어가 연결되었을 때 두번째 단어의 첫 시작부분을 대문자로 주기
 * 
 * 데이터베이스 규칙(스네이크케이스)
 * 두 단어 연결 시 _(언더바)로 연결
 */
public interface ReplyService {
	public boolean replyInsert(ReplyVO vo);
	public ReplyVO replyRead(int rno);
	public boolean replyUpdate(ReplyVO vo);
	public boolean replyDelete(int rno);
	
	public List<ReplyVO> replyList(Criteria cri, int bno);
}
