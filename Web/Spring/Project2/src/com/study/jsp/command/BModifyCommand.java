package com.study.jsp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.BDao;

public class BModifyCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String bId =request.getParameter("bId");
		String bName =request.getParameter("bName");
		String bTitle =request.getParameter("bTitle");
		String bContent =request.getParameter("bContent");
		String food=request.getParameter("food");
		String sido=request.getParameter("sido");
		String gigungu=request.getParameter("gigungu");
		
		BDao dao = BDao.getInstance();
		dao.modify(bId, bName, bTitle, bContent,food, sido, gigungu);
		
	}

}
