package com.study.jsp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.BDao;
import com.study.jsp.BDto;
import com.study.jsp.BPageInfo;

public class BListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String search =request.getParameter("search");
		String option =request.getParameter("option");
		
		int nPage=1;
		try {
			String sPage =request.getParameter("page");
			nPage =Integer.parseInt(sPage);
		}catch(Exception e) {
		}
		
		BDao dao = BDao.getInstance();
		BPageInfo pinfo = dao.articlePage(nPage,search, option);
		request.setAttribute("page", pinfo);
		request.setAttribute("search", search);
		request.setAttribute("option", option);

		nPage = pinfo.getCurPage();
		
		HttpSession session =null;
		session = request.getSession();
		session.setAttribute("cpage", nPage);
		session.setAttribute("search", search);
		session.setAttribute("option", option);

		
		ArrayList<BDto> dtos = dao.list(nPage, search, option);
		request.setAttribute("list", dtos);
		
		

	}

}
