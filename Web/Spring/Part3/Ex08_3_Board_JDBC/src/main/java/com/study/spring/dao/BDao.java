package com.study.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.study.spring.dto.BDto;
import com.study.spring.util.Constant;

public class BDao {

	private static BDao instance = new BDao();
	DataSource dataSource = null;
	int listCount =10;	//한 페이지당 보여줄 게시물의 개수
	int pageCount =10;	//하단에 보여줄 페이지 리스트의 개수
	
	JdbcTemplate template = null;

	public BDao() {
		template = Constant.template;
	}

	public static BDao getInstance() {
		return instance;
	}

	public void write(final String bName,final String bTitle,final String bContent) {			//작성

		template.update(new PreparedStatementCreator(){
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
			throws SQLException{
				String query = "insert into mvc_board " +
						"(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) " +
						"values " + 
						"(mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				
				return pstmt;
			}
		});
	}
	
	public ArrayList<BDto> list(){		//목록 10개씩 분리
					
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent " + 
		               "  from mvc_board " +
				       " order by bGroup desc, bStep asc";
		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}

	
	public BDto contentView(String strId) {	//작성글 보기
		upHit(strId);
		
			String query = "select * from mvc_board where bId = " + strId;
				
			return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public void modify(final String bId,final String bName, final String bTitle, final String bContent) {	//수정

		String query = "update mvc_board " +
				" set bName =?, " +
				" bTitle =?, " +
				" bContent =? " +
				" where bId =?";
		template.update(query ,new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
			ps.setString(1, bName);
			ps.setString(2, bTitle);
			ps.setString(3, bContent);
			ps.setInt(4, Integer.parseInt(bId));
			}
		});
	}
	
	private void upHit(final String bId) {	//조회수

		String query = "update mvc_board set bHit = bHit + 1 where bId = ?";
		template.update(query ,new PreparedStatementSetter(){

		@Override
		public void setValues(PreparedStatement ps) throws SQLException{
			ps.setString(1, bId);
		}
		});
	}
	
	public void delete(final String bId) {	//삭제

			String query = "delete mvc_board where bId = ?";
			template.update(query ,new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setString(1, bId);
			}
		});	
	}
	
	public BDto reply_view(String str) {	//답변보기
		String query = "select * from mvc_board where bId = " + str;
		
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public void reply(final String bId,final String bName, final String bTitle, final String bContent,
					final String bGroup, final String bStep, final String bIndent) {	//답변하기

		replyShape(bGroup,bStep);

		String query = "insert into mvc_board " +
				" (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) " +
				" values (mvc_board_seq.nextval, ?, ?, ?, ?, ? ,?)";

		template.update(query ,new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
			ps.setString(1, bName);
			ps.setString(2, bTitle);
			ps.setString(3, bContent);
			ps.setInt(4, Integer.parseInt(bGroup));
			ps.setInt(5, Integer.parseInt(bStep) +1);
			ps.setInt(6, Integer.parseInt(bIndent) +1);
			}
		});
	}

	private void replyShape(final String strGroup, final String strStep) {

			String query = "update mvc_board " +
						" set bStep = bStep + 1 " +
						" where bGroup = ? and bStep > ? ";
			template.update(query ,new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
			ps.setInt(1, Integer.parseInt(strGroup));
			ps.setInt(2, Integer.parseInt(strStep));
			}
		});
	}

}