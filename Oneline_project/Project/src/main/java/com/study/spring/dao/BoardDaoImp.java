package com.study.spring.dao;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


@Repository("BoardDao")
public class BoardDaoImp implements BoardDao {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	public Map<String, Object> loginChk(Map<String, Object> map){
		return sqlSessionTemplate.selectOne("mapper.loginChk", map);
	}

	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("mapper.list", map);
	}

	@Override
	public List<Map<String, Object>> searchAjax(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("mapper.searchAjax", map);
	}

	public Map<String, Object> content(int seq) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("mapper.content", seq);
	}

	@Override
	public int insertBoard(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("mapper.insert", map);
	}

	@Override
	public Map<String, Object> writeview() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("mapper.writeview");
	}

	@Override
	public int updateBoard(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("mapper.update", map);
	}

	@Override
	public int history(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("mapper.history", map);
	}

	@Override
	public List<Map<String, Object>> historyContent(int seq) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("mapper.historyContent", seq);
	}

	public int lmsiupdateBoard(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("mapper.lmsiupdate", map);
	}

	@Override
	public List<Map<String, Object>> popuplist(String kwanhan) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("mapper.popuplist",kwanhan);
	}

	@Override
	public Map<String, Object> popupajax(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("mapper.popupajax",map);
	}

	@Override
	public int popupok(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("mapper.popupok", map);
	}

	@Override
	public List<Map<String, Object>> kwanhan(String sessionName) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("mapper.kwanhan", sessionName);
	}



}
