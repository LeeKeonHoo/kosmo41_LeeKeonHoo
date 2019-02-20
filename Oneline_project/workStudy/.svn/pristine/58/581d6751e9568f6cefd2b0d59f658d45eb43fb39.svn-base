package com.study.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.study.dao.BoardDao;
import com.study.service.BoardService;
import com.study.vo.BoardVO;


@Service("a")
public class BoardServiceImpl implements BoardService{

	@Resource(name = "boardDao")
	BoardDao boarddao;
	
	@Override
	public List<BoardVO> boardlist(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return boarddao.boardlist(map);
	}

	@Override
	public BoardVO detail(int seq) {
		// TODO Auto-generated method stub
		return boarddao.detail(seq);
	}

	@Override
	public int update(BoardVO vo) {
		// TODO Auto-generated method stub
		int cnt = boarddao.update(vo);
		return cnt;
	}
}
