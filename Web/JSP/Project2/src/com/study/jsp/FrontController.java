package com.study.jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.command.BCommand;
import com.study.jsp.command.BContentCommand;
import com.study.jsp.command.BDeleteCommand;
import com.study.jsp.command.BDownloadCommand;
import com.study.jsp.command.BListCommand;
import com.study.jsp.command.BModifyCommand;
import com.study.jsp.command.BReplyCommand;
import com.study.jsp.command.BReplyViewCommand;
import com.study.jsp.command.BRiviewCommand;
import com.study.jsp.command.BStarCommand;
import com.study.jsp.command.BStardelCommand;
import com.study.jsp.command.BWriteCommand;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String viewPage =null;
		BCommand command = null;
				
		String uri =request.getRequestURI();
		String conPath =request.getContextPath();
		String com = uri.substring(conPath.length());

		System.out.println(com);
		
		HttpSession session = null;
		session = request.getSession();
		int curPage = 1;
		if(session.getAttribute("cpage") != null) {
			curPage = (int)session.getAttribute("cpage");
		}
		
		if(com.equals("/write_view.do")) {	//작성글 메뉴
			viewPage = "write_view.jsp";
		}else if(com.equals("/write.do")){	//글작성 버튼
			command = new BWriteCommand();
			command.execute(request, response);
			viewPage ="list.do";
		}else if(com.equals("/list.do")) {	//전체 리스트
			command = new BListCommand();
			command.execute(request, response);
			viewPage ="list.jsp";

		}else if(com.equals("/content_view.do")){	//선택한 글 메뉴
			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
		}else if(com.equals("/modify_view.do")){	//수정 글 메뉴
			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "modify_view.jsp";		
		}else if(com.equals("/modify.do")){		//수정	글 보기
			command = new BModifyCommand();
			command.execute(request, response);
			
			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";		
		}else if(com.equals("/delete.do")){	//글 삭제
			command = new BDeleteCommand();
			command.execute(request, response);
			viewPage = "list.do?page="+curPage;		
		}else if(com.equals("/reply_view.do")){	//답변 달기 메뉴
			command = new BReplyViewCommand();
			command.execute(request, response);
			viewPage = "reply_view.jsp";		
		}else if(com.equals("/reply.do")){	//답변 글 보기
			command = new BReplyCommand();
			command.execute(request, response);
			viewPage = "list.do?page="+curPage;	
		}else if(com.equals("/download.do")){	//다운로드
			command = new BDownloadCommand();
			command.execute(request, response);
			viewPage = "content_view.do";

		}else if(com.equals("/review.do")){	// 평점주기
			command = new BRiviewCommand();
			command.execute(request, response);

			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
		}else if(com.equals("/star.do")){	//즐겨찾기
			command = new BStarCommand();
			command.execute(request, response);
			viewPage = "content_view.do";
		}
		else if(com.equals("/stardel.do")){	//즐겨찾기
			command = new BStardelCommand();
			command.execute(request, response);
			viewPage = "content_view.do";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}

