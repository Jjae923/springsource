package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.domain.AttachFileVO;
import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.mapper.AttachMapper;
import com.spring.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	@Autowired
	private AttachMapper attach;
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		return mapper.list(cri);
	}

	@Override
	public int totalRows(Criteria cri) {
		return mapper.total(cri);
	}
	
	@Transactional
	@Override
	public boolean insertBoard(BoardVO vo) {
		// 게시글 DB 저장 요청
		boolean result = mapper.insert(vo)==1? true:false;
		
		// 첨부파일 DB 저장 요청 (bno가 필요하기 때문에 게시글이 먼저 저장되어야 함)
		if(vo.getAttachList() == null || vo.getAttachList().size() <= 0) {
			return result;
		}
		// 함수형태로 처리하는 람다(java8에서 추가) 추후에 설명 
		vo.getAttachList().forEach(attach1 -> {
			attach1.setBno(vo.getBno());
			attach.insert(attach1);
		});
		return true;
	}

	@Override
	public BoardVO readBoard(int bno) {
		return mapper.read(bno);
	}

	@Transactional
	@Override
	public boolean modifyBoard(BoardVO vo) {
		// 현재 bno의 첨부파일 DB에서 삭제
		attach.delete(vo.getBno());
		// 첨부파일 삽입
		if(vo.getAttachList() != null && vo.getAttachList().size() >= 0) {
			for(AttachFileVO attach1 : vo.getAttachList()) {
				attach1.setBno(vo.getBno());  // 첨부파일마다 해당 게시물의 bno 넣어주기
				attach.insert(attach1);
			}
		}
		return mapper.modify(vo)==1? true:false;
	}

	@Transactional
	@Override
	public boolean deleteBoard(int bno) {
		attach.delete(bno);
		return mapper.delete(bno)==1? true:false;
	}
	
	@Override
	public List<AttachFileVO> attachList(int bno) {
		return attach.select(bno);
	}
}
