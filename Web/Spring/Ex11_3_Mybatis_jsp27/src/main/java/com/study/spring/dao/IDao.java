package com.study.spring.dao;

import java.util.ArrayList;

import com.study.spring.dto.ContentDto;

public interface IDao {

	public ArrayList<ContentDto> listDao();
	public void writeDao(String bName, String bTitle,String bContent);
	public ContentDto viewDao(String bId);
	public void deleteDao(String bId);
	public void viewDao2(String bId);
}
