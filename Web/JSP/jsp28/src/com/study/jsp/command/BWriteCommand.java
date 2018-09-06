package com.study.jsp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.study.jsp.BDao;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
//		  request.setCharacterEncoding("euc-kr");		
		  MultipartRequest multi = null;	

		  	int sizeLimit = 10 * 1024 * 1024 ; // 10메가입니다.
		  	String savePath = request.getSession().getServletContext().getRealPath("/upload");    // 파일이 업로드될 실제 tomcat 폴더의 WebContent 기준
		  	try{
		  		multi=new MultipartRequest(request, savePath, sizeLimit, "euc-kr", new DefaultFileRenamePolicy()); 
		  	}catch (Exception e) {
		  		e.printStackTrace();
		  	} 

		  	String filename = multi.getFilesystemName("filename");

		  	String bName =multi.getParameter("bName");
			String bTitle =multi.getParameter("bTitle");
			String bContent =multi.getParameter("bContent");
			String food =multi.getParameter("food");
			String sido =multi.getParameter("sido");
			String gigungu =multi.getParameter("gigungu");
			BDao dao = BDao.getInstance();
			dao.write(bName, bTitle, bContent,filename,food, sido, gigungu);

		  	String regip = request.getRemoteAddr();



	}

}
