package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginProcess")
public class LoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet resultSet;
	
   	String driver = "oracle.jdbc.driver.OracleDriver";
   	String url = "jdbc:oracle:thin:@localhost:1521:xe";
   	String uid = "scott";
   	String upw = "tiger";
   	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);
		
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id,pw,name,phone,gender;
		
		id= request.getParameter("id");
		pw= request.getParameter("pw");
		name= "";
		phone= "";
		gender = "";
		
		String query = "select * from member where id = ? and pw = ?";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, upw);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			resultSet = pstmt.executeQuery();
			
			//결과데이터가 한개라면 while 대신 if를 사용해도 된다
			while(resultSet.next()) {
				//id = resultSet.getString("id");
				//pw = resultSet.getString("pw");
				name = resultSet.getString("name");
				phone = resultSet.getString("phone");
				gender = resultSet.getString("gender");
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();		

			if(id != null) {
				System.out.println("login sucess");
				writer.println("[{\"result\":\"ok\",\"desc\":\"none\"}]");
			}
			writer.close();
			
			
		}catch(Exception e) {
			System.out.println("insert fail");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();		
			writer.println("[{\"result\":\"false\",\"desc\":\"로그인 실패했습니다\"}]");
			writer.close();				
			}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}	
	}
}
