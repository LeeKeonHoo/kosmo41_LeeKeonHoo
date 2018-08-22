package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Suhak")
public class Suhak extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("doPost");
			
			request.setCharacterEncoding("UTF-8");
			
			String name = request.getParameter("name");
			String name2 = request.getParameter("name2");
			String major = request.getParameter("major");
			
			int name3, name4;
			name3 = Integer.parseInt(name);
			name4 = Integer.parseInt(name2);
			int result = 0;
			if(major.equals("더하기")) {
				result = name3+name4;
			}else if(major.equals("빼기")) {				
				result = name3-name4;
			}else if(major.equals("곱하기")) {				
				result = name3*name4;
			}else if(major.equals("나누기")){			
				result = name3/name4;			
			}				
				
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			
			writer.println("<html><head></head><body>");			
			writer.println("첫번째 수 : " + name + "<br>");
			writer.println("두번째 수 : " + name2 + "<br>");
			writer.println(name3 + " " + major + " " + name4 + " 는 " + result + "<br>");
			writer.println("</body></html>");
	}

}
