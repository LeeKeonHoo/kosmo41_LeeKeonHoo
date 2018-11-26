package com.study.jsp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.BDao;
import com.study.jsp.BDto;

public class BRiviewCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String bId =request.getParameter("bId");
		String sumscore = request.getParameter("sumscore");
		System.out.println(bId);
		System.out.println(sumscore);
		BDao dao = BDao.getInstance();
		BDto dto = dao.riview(bId,sumscore,request,response);
		
	}

}
