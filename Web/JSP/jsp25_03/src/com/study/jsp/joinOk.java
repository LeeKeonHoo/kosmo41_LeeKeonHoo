package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class joinOk implements Service {

	public joinOk() {
		// TODO 자동 생성된 생성자 스텁
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("joinOk");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");

		MemberDao dao = MemberDao.getInstance();
		MemberDto dto = new MemberDto();
		
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		dto.setName(request.getParameter("name"));
		dto.seteMail(request.getParameter("eMail"));
		dto.setAddress(request.getParameter("address"));
		dto.seteMail2(request.getParameter("eMail2"));

		dto.setrDate(new Timestamp(System.currentTimeMillis()));
		if (dao.confirmId(dto.getId()) == MemberDao.MEMBER_EXISTENT) {
			writer.println("아이디가 이미 존재합니다");
			writer.close();
		} else {
			int ri = dao.insertMember(dto);
			if (ri == MemberDao.MEMBER_JOIN_SUCCESS) {
				session.setAttribute("id", dto.getId());
				writer.println("회원가입을 출하합니다");
				writer.close();
			} else {
				writer.println("회원가입에 실패했습니다");
				writer.close();
			}
		}
	}

}
