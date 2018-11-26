package com.study.jsp.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class modifyOk implements Service {

	public modifyOk() {
		// TODO 자동 생성된 생성자 스텁
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("modifyOk");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();		
		
		String id=(String)session.getAttribute("id");

		MemberDao dao = MemberDao.getInstance();
		MemberDto dto = new MemberDto();

		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		dto.setName(request.getParameter("name"));
		dto.seteMail(request.getParameter("eMail"));
		dto.setAddress(request.getParameter("address"));
		dto.seteMail2(request.getParameter("eMail2"));
		
		dto.setId(id);
		int ri=dao.updateMember(dto);
		
		if(ri ==1){
			response.setContentType("text/html; charset=UTF-8");
			writer.println("<script language='javascript'>");
			writer.println("alert('정보가 수정되었습니다');");
			writer.println("location.href='list.jsp'");
			writer.println("</script>");
			writer.close();
			
		}else{
			response.setContentType("text/html; charset=UTF-8");
			writer.println("<script language='javascript'>");
			writer.println("alert('정보수정에 실패했습니다');");
			writer.println("location.href='list.jsp'");
			writer.println("</script>");
			writer.close();
		}
	}

}
