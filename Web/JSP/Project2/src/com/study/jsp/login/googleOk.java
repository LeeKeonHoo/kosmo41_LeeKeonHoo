package com.study.jsp.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class googleOk implements Service {

	public googleOk() {
		// TODO 자동 생성된 생성자 스텁
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("googleOk");
		
		request.setCharacterEncoding("UTF-8");

		String id =request.getParameter("ggID");
		String name =request.getParameter("ggName");

		System.out.println("id : "+id);
		System.out.println("name : "+name);
		System.out.println("length : "+id.length());
		response.setContentType("text/html; charset=UTF-8");
				
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("ValidMem", "yes");

	}
	}
