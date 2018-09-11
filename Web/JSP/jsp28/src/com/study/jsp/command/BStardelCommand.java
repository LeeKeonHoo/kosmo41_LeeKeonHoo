package com.study.jsp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.BDao;
import com.study.jsp.BDto;

public class BStardelCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String bId =request.getParameter("bId");
		System.out.println(bId);
		BDao dao = BDao.getInstance();
		BDto dto = dao.stardel(bId,request,response);
	}

}
