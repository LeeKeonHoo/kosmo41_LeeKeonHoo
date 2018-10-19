package com.study.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.study.spring.dto.BDto;

public class BDao {

	private static BDao instance = new BDao();
	DataSource dataSource = null;
	int listCount =10;	//한 페이지당 보여줄 게시물의 개수
	int pageCount =10;	//하단에 보여줄 페이지 리스트의 개수

	public BDao() {
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

	public void write(String bName,String bTitle,String bContent) {			//작성

		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into mvc_board " +
						"(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) " +
						"values " + 
						"(mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
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
	
	public ArrayList<BDto> list(){		//목록 10개씩 분리
		
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet resultSet = null;
				
		try {
			con = dataSource.getConnection();
			
			String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent " + 
		               "  from mvc_board " +
				       " order by bGroup desc, bStep asc";

			pstmt=con.prepareStatement(query);
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
				
				BDto dto =new BDto(bId, bName, bTitle, bContent, bDate,
									bHit, bGroup, bStep, bIndent);
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

	
	public BDto contentView(String strId) {	//작성글 보기
		upHit(strId);
		
		BDto dto =null;
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet resultSet = null;
		
		try {
			con = dataSource.getConnection();
			
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
				
				dto = new BDto(bId, bName, bTitle, bContent, bDate,
								bHit, bGroup, bStep, bIndent);
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
	
	public void modify(String bId, String bName,String bTitle,String bContent) {	//수정

		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "update mvc_board " +
						" set bName =?, " +
						" bTitle =?, " +
						" bContent =? " +
						" where bId =?";
						

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setString(4, bId);
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
				
				dto = new BDto(bId, bName, bTitle, bContent, bDate,
								bHit, bGroup, bStep, bIndent);
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
	
}