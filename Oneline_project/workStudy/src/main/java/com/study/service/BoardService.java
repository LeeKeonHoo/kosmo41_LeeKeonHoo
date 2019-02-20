package com.study.service;

import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.study.vo.BoardVO;

public interface BoardService {

	java.util.List<BoardVO> boardlist(Map<String, Object> map);

	public BoardVO detail(int seq);

	int update(BoardVO vo);
	
	//?????
}
