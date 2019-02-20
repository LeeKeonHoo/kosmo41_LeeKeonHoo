package com.study.dao.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.study.dao.BoardDao;
import com.study.vo.BoardVO;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao{

	@Inject
	SqlSession slqsession;
		//dkssudgktpduy
	@Override
	public List<BoardVO> boardlist(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		List<BoardVO> list=slqsession.selectList("mapper.list",map);
		return list;
	}

	@Override
	public BoardVO detail(int seq) {
		// TODO Auto-generated method stub
		return slqsession.selectOne("mapper.detail", seq);
	}

	@Override
	public int update(BoardVO vo) {
		// TODO Auto-generated method stub
		int cnt = slqsession.update("mapper.update", vo);
		return cnt;
	}

	
	
	
}
