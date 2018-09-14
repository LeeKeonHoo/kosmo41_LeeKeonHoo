package com.study.jsp.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginOk implements Service {

	public loginOk() {
		// TODO 자동 생성된 생성자 스텁
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		
		System.out.println("loginOk");
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");	
		String pw = request.getParameter("pw");
		
		System.out.println("id : "+id);
		System.out.println("pw : "+pw);
		System.out.println("length : "+id.length());
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();		

		MemberDao dao = MemberDao.getInstance();
		int checkNum = dao.userCheck(id, pw);
		if(checkNum == -1){
			response.setContentType("text/html; charset=UTF-8");
			writer.println("<script language='javascript'>");
			writer.println("alert('아이디가 존재하지 않습니다');");
			writer.println("location.href='login.jsp'");
			writer.println("</script>");
			writer.close();
		}else if(checkNum == 0){
			response.setContentType("text/html; charset=UTF-8");
			writer.println("<script language='javascript'>");
			writer.println("alert('비밀번호가 틀립니다');");
			writer.println("location.href='login.jsp'");
			writer.println("</script>");
			writer.close();
			
		}else if(checkNum == 1){
			MemberDto dto = dao.getMember(id);
			
			if(dto ==null){
				response.setContentType("text/html; charset=UTF-8");
				writer.println("<script language='javascript'>");
				writer.println("alert('존재하지 않는 회원입니다');");
				writer.println("location.href='login.jsp'");
				writer.println("</script>");
				writer.close();

			}else{
				
				HttpSession session = request.getSession();

				String name = dto.getName();
				session.setAttribute("id", id);
				session.setAttribute("name", name);
				session.setAttribute("ValidMem", "yes");
				response.sendRedirect("list.do");		
			}
		}
	}
	}