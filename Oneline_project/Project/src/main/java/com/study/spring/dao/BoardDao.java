package com.study.spring.dao;

import java.util.List;
import java.util.Map;

public interface BoardDao {
            
	Map<String, Object> loginChk(Map<String, Object> map);

	List<Map<String, Object>> list(Map<String, Object> map);
	
	List<Map<String, Object>> searchAjax(Map<String, Object> map);
	
	Map<String, Object> content(int seq);
	
	int insertBoard(Map<String, Object> map);
	
	Map<String, Object> writeview();
	
	int updateBoard(Map<String, Object> map);
	
	int history(Map<String, Object> map);

	List<Map<String, Object>> historyContent(int seq);
	
	int lmsiupdateBoard(Map<String, Object> map);

	List<Map<String, Object>> popuplist(String kwanhan);
	
	Map<String, Object> popupajax(Map<String, Object> map);
	
	int popupok(Map<String, Object> map);

	List<Map<String, Object>> kwanhan(String sessionName);
	

}