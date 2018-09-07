package com.study.jsp;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.catalina.connector.Request;

public class BDao {

	private static BDao instance = new BDao();
	DataSource dataSource = null;
	int listCount =10;	//한 페이지당 보여줄 게시물의 개수
	int pageCount =10;	//하단에 보여줄 페이지 리스트의 개수

	private BDao() {
		try {
			// lookup함수의 파라메터는 context.xml에 설정된
			// name(jdbc/Oracle11g)과 동일해야 한다
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public static BDao getInstance() {
		return instance;
	}

	public void write(String bName,String bTitle,String bContent,String filename,String food, String sido, String gigungu) {			//작성

		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into mvc_board " +
						"(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent, manscore, sumscore, avgscore, upload,food, sido, gigungu) " +
						"values " + 
						"(mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0, 0, 0, 0, ?, ? ,? ,?)";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setString(4, filename);
			pstmt.setString(5, food);
			pstmt.setString(6, sido);
			pstmt.setString(7, gigungu);
			int rn = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)	pstmt.close();
				if (con != null)	con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public ArrayList<BDto> list(int curPage, String search, String option){		//목록 10개씩 분리
		
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet resultSet = null;
		
		int nStart = (curPage -1) * listCount + 1;
		int nEnd = (curPage -1) * listCount + listCount;
		
		try {
			con = dataSource.getConnection();
			
			if(option == null) {
			String query ="select * " +
					  	  "  from ( " +
						  "	   select rownum num, A.* " +
						  "	     from ( " +
						  "	        select * " +
						  "	          from mvc_board " +
						  "	         order by bgroup desc, bstep asc ) A " +
						  "	    where rownum <= ? ) B " +
						  "	where B.num >= ? ";

			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, nEnd);
			pstmt.setInt(2, nStart);
			}
			else if(option.equals("")) {
			String query ="select * " +
					  	  "  from ( " +
						  "	   select rownum num, A.* " +
						  "	     from ( " +
						  "	        select * " +
						  "	          from mvc_board " +
						  "	         order by bgroup desc, bstep asc ) A " +
						  "	    where rownum <= ? ) B " +
						  "	where B.num >= ? ";

			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, nEnd);
			pstmt.setInt(2, nStart);
			}
			else if (option.equals("1"))
			{
				String query ="select * " +
					  	  "  from ( " +
						  "	   select rownum num, A.* " +
						  "	     from ( " +
						  "	        select * " +
						  "	          from mvc_board " +
						  "             where bTitle like ? " +
						  "	         order by bgroup desc, bstep asc ) A " +
						  "	    where rownum <= ? ) B " +
						  "	where B.num >= ? ";

			pstmt=con.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, nEnd);
			pstmt.setInt(3, nStart);				
			}
			else if (option.equals("2"))
			{
				String query ="select * " +
					  	  "  from ( " +
						  "	   select rownum num, A.* " +
						  "	     from ( " +
						  "	        select * " +
						  "	          from mvc_board " +
						  "             where bName like ? " +
						  "	         order by bgroup desc, bstep asc ) A " +
						  "	    where rownum <= ? ) B " +
						  "	where B.num >= ? ";

			pstmt=con.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, nEnd);
			pstmt.setInt(3, nStart);				
			}
			else if (option.equals("3"))
			{
				String query ="select * " +
					  	  "  from ( " +
						  "	   select rownum num, A.* " +
						  "	     from ( " +
						  "	        select * " +
						  "	          from mvc_board " +
						  "             where food like ? " +
						  "	         order by bgroup desc, bstep asc ) A " +
						  "	    where rownum <= ? ) B " +
						  "	where B.num >= ? ";

			pstmt=con.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, nEnd);
			pstmt.setInt(3, nStart);				
			}
			else if (option.equals("4"))
			{
				String query ="select * " +
					  	  "  from ( " +
						  "	   select rownum num, A.* " +
						  "	     from ( " +
						  "	        select * " +
						  "	          from mvc_board " +
						  "             where sido like ? " +
						  "	         order by bgroup desc, bstep asc ) A " +
						  "	    where rownum <= ? ) B " +
						  "	where B.num >= ? ";

			pstmt=con.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, nEnd);
			pstmt.setInt(3, nStart);
			}
			else if (option.equals("5"))
			{
				String query ="select * " +
					  	  "  from ( " +
						  "	   select rownum num, A.* " +
						  "	     from ( " +
						  "	        select * " +
						  "	          from mvc_board " +
						  "             where gigungu like ? " +
						  "	         order by bgroup desc, bstep asc ) A " +
						  "	    where rownum <= ? ) B " +
						  "	where B.num >= ? ";

			pstmt=con.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, nEnd);
			pstmt.setInt(3, nStart);
			}
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String bName =resultSet.getString("bName");
				String bTitle =resultSet.getString("bTitle");
				String bContent =resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				String food=resultSet.getString("food");
				String sido=resultSet.getString("sido");
				String gigungu=resultSet.getString("gigungu");
				String manscore=resultSet.getString("manscore");
				String sumscore=resultSet.getString("sumscore");
				String avgscore=resultSet.getString("avgscore");
				String upload=resultSet.getString("upload");
				
				BDto dto =new BDto(bId, bName, bTitle, bContent, bDate,
									bHit, bGroup, bStep, bIndent, food, sido, gigungu, manscore, sumscore, avgscore,upload);
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}

	public BPageInfo articlePage(int curPage, String search, String option) {
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet resultSet = null;
		
		
		int totalCount = 0;	//총 게시물의 갯수
		try {
			con = dataSource.getConnection();
			
			
			if(option ==null) {
				String query = "select count(*) as total from mvc_board";
				pstmt = con.prepareStatement(query);				
			}
			else if(option.equals("")) {
				String query = "select count(*) as total from mvc_board";
				pstmt = con.prepareStatement(query);				
			}
			else if(option.equals("1")) {
				String query = "select count(*) as total from mvc_board where bTitle like ?";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%"+search+"%");				
			}
			else if(option.equals("2")) {
				String query = "select count(*) as total from mvc_board where bName like ?";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%"+search+"%");				
			}
			else if(option.equals("3")) {
				String query = "select count(*) as total from mvc_board where food like ?";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%"+search+"%");				
			}
			else if(option.equals("4")) {
				String query = "select count(*) as total from mvc_board where sido like ?";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%"+search+"%");				
			}
			else if(option.equals("5")) {
				String query = "select count(*) as total from mvc_board where gigungu like ?";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, "%"+search+"%");				
			}

			resultSet = pstmt.executeQuery();
					
			if(resultSet.next()) {
				totalCount =resultSet.getInt("total");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}		
		}
	
		//총 페이지 수
		int totalPage = totalCount / listCount;
		if(totalCount % listCount > 0)
			totalPage++;
		
		//현재 페이지
		int mycurPage = curPage;
		if (mycurPage > totalPage)
		    mycurPage = totalPage;
		if (mycurPage < 1)
		    mycurPage = 1;

		//시작 페이지
		int startPage = ((mycurPage -1) / pageCount) * pageCount + 1;
		
		//끝 페이지
		int endPage = startPage + pageCount -1;
		if(endPage > totalPage)
			endPage = totalPage;
		
		BPageInfo pinfo = new BPageInfo();
		pinfo.setTotalCount(totalCount);
		pinfo.setListCount(listCount);
		pinfo.setTotalPage(totalPage);
		pinfo.setCurPage(mycurPage);
		pinfo.setPageCount(pageCount);
		pinfo.setStartPage(startPage);
		pinfo.setEndPage(endPage);
		
		return pinfo;
	}
	
	public BDto contentView(String strId,HttpServletRequest request) {	//작성글 보기
		upHit(strId);
		
		BDto dto =null;
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet resultSet = null;
		HttpSession session = request.getSession();
		try {
			con = dataSource.getConnection();
	
			String sid = (String)session.getAttribute("id");

			String query = "select * from mvc_board where bId =?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(strId));
			resultSet = pstmt.executeQuery();
					
			if(resultSet.next()){
				int bId =resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit =resultSet.getInt("bHit");
				int bGroup =resultSet.getInt("bGroup");
				int bStep =resultSet.getInt("bStep");
				int bIndent =resultSet.getInt("bIndent");
				String food=resultSet.getString("food");
				String sido=resultSet.getString("sido");
				String gigungu=resultSet.getString("gigungu");
				String manscore=resultSet.getString("manscore");
				String sumscore=resultSet.getString("sumscore");
				String avgscore=resultSet.getString("avgscore");
				String upload=resultSet.getString("upload");
							
				dto = new BDto(bId, bName, bTitle, bContent, bDate,
								bHit, bGroup, bStep, bIndent,food,sido,gigungu,manscore,sumscore,avgscore, upload);
		
				if(sid.equals(bName)) {
					session.setAttribute("check", "yes");
				}
				else if(sid.equals("admin")){			
					session.setAttribute("check", "yes");
				}
				else
				{
					session.setAttribute("check", "no");
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}		
		}
		return dto;
	}
	
	public void modify(String bId, String bName,String bTitle,String bContent, String food, String sido, String gigungu) {	//수정

		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "update mvc_board " +
						" set bName =?, " +
						" bTitle =?, " +
						" bContent =?, " +
						" food =?, " +
						" sido =?, " +
						" gigungu =? " +
						" where bId =? ";
						

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setString(4, food);
			pstmt.setString(5, sido);
			pstmt.setString(6, gigungu);
			pstmt.setString(7, bId);
			int rn = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)	pstmt.close();
				if (con != null)	con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	private void upHit(String bId) {	//조회수

		Connection con =null;
		PreparedStatement pstmt =null;
		
		try {
			con = dataSource.getConnection();
			String query = "update mvc_board set bHit = bHit + 1 where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bId);

			int rn = pstmt.executeUpdate();	
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}		
		}
	}
	
	public void delete(String bId) {	//삭제

		Connection con =null;
		PreparedStatement pstmt =null;
		
		try {
			con = dataSource.getConnection();
			String query = "delete mvc_board where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bId);

			int rn = pstmt.executeUpdate();	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}		
		}
	}
	
	public BDto reply_view(String str) {	//답변보기
		
		BDto dto =null;
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet resultSet = null;
		
		try {
			con = dataSource.getConnection();
			
			String query = "select * from mvc_board where bId =?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(str));
			resultSet = pstmt.executeQuery();
					
			if(resultSet.next()){
				int bId =resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit =resultSet.getInt("bHit");
				int bGroup =resultSet.getInt("bGroup");
				int bStep =resultSet.getInt("bStep");
				int bIndent =resultSet.getInt("bIndent");
				String food=resultSet.getString("food");
				String sido=resultSet.getString("sido");
				String gigungu=resultSet.getString("gigungu");
				String manscore=resultSet.getString("manscore");
				String sumscore=resultSet.getString("sumscore");
				String avgscore=resultSet.getString("avgscore");
				String upload=resultSet.getString("upload");
				
				dto = new BDto(bId, bName, bTitle, bContent, bDate,
								bHit, bGroup, bStep, bIndent,food,sido,gigungu,manscore,sumscore,avgscore, upload);

			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}		
		}
		return dto;
	}
	
	public void reply(String bId, String bName, String bTitle, String bContent,
					String bGroup, String bStep, String bIndent) {	//답변하기
		
		replyShape(bGroup,bStep);
		
		Connection con =null;
		PreparedStatement pstmt =null;
		
		try {
			con = dataSource.getConnection();
			
			String query = "insert into mvc_board " +
						" (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) " +
						" values (mvc_board_seq.nextval, ?, ?, ?, ?, ? ,?)";
			pstmt = con.prepareStatement(query);
					
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bGroup));
			pstmt.setInt(5, Integer.parseInt(bStep) +1);
			pstmt.setInt(6, Integer.parseInt(bIndent) +1);
			int rn = pstmt.executeUpdate();				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}		
		}
	}

	private void replyShape(String strGroup, String strStep) {
		Connection con =null;
		PreparedStatement pstmt =null;

		try {
			con = dataSource.getConnection();
			
			String query = "update mvc_board " +
						" set bStep = bStep + 1 " +
						" where bGroup = ? and bStep > ? ";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(strGroup));
			pstmt.setInt(2, Integer.parseInt(strStep));
			int rn = pstmt.executeUpdate();				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}		
		}
	}
	
	public BDto riview(String bId,String sumscore) {	//점수주기

		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		String query =  " update mvc_board set " +
						" avgscore = round(((sumscore+"+sumscore+")/(manscore+1)), 2), " +
						" manscore = (manscore+1), " +
						" sumscore = (sumscore+"+sumscore+") " +
						" where bid = '"+bId+"' " ;
						

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			int rn = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)	pstmt.close();
				if (con != null)	con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
	
	
}

