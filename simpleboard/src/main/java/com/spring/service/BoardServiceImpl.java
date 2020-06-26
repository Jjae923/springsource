package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.domain.BoardVO;
import com.spring.persistence.BoardDAO;

//@Component("board")  // 클래스명 길기 때문에 이름 지정하여 객체 생성
@Service("board")
public class BoardServiceImpl implements BoardService {

	@Autowired     // 스프링 컨테이너가 보관하고 있던 객체 주입
	private BoardDAO dao; // annotation 이용 시 DAO는 객체 생성 따로 하지 않고 Component함
	
	@Override
	public int insertBoard(BoardVO vo) {
		return dao.insertArticle(vo);
	}
	@Override
	public int updateBoard(BoardVO vo) {
		return 0;
	}
	@Override
	public int deleteBoard(BoardVO vo) {
		return 0;
	}
	@Override
	public BoardVO getBoard(int bno) {
		return null;
	}
	@Override
	public List<BoardVO> getList() {
		return null;
	}
}
