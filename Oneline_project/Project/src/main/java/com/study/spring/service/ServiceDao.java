package com.study.spring.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.study.spring.dao.BoardDaoImp;

@Service("BoardService")
public class ServiceDao implements BoardService {
	
	@Resource(name = "BoardDao")
	private BoardDaoImp boardDao;
	
	public Map<String, Object> loginChk(Map<String, Object> map) {
		return boardDao.loginChk(map);
	}

	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return boardDao.list(map);
	}

	@Override
	public List<Map<String, Object>> searchAjax(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return boardDao.searchAjax(map);
	}

	@Override
	public Map<String, Object> content(int seq) {
		// TODO Auto-generated method stub
		return boardDao.content(seq);
	}

	@Override
	public int insertBoard(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return boardDao.insertBoard(map);
	}

	@Override
	public Map<String, Object> writeview() {
		// TODO Auto-generated method stub
		return boardDao.writeview();
	}

	@Override
	public int updateBoard(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return boardDao.updateBoard(map);
	}

	@Override
	public int history(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return boardDao.history(map);
	}

	@Override
	public List<Map<String, Object>> historyContent(int seq) {
		// TODO Auto-generated method stub
		return boardDao.historyContent(seq);
	}

	@Override
	public int lmsiupdateBoard(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return boardDao.lmsiupdateBoard(map);
	}

	@Override
	public List<Map<String, Object>> popuplist(String kwanhan) {
		// TODO Auto-generated method stub
		return boardDao.popuplist(kwanhan);
	}

	@Override
	public Map<String, Object> popupajax(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return boardDao.popupajax(map);
	}

	@Override
	public int popupok(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return boardDao.popupok(map);
	}

	@Override
	public List<Map<String, Object>> kwanhan(String sessionName) {
		// TODO Auto-generated method stub
		return boardDao.kwanhan(sessionName);
	}


	
}
