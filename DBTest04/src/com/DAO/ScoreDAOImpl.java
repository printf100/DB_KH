package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.DTO.ScoreDTO;
import com.db.JDBCTemplate;

public class ScoreDAOImpl extends JDBCTemplate implements ScoreDAO {

	@Override
	public List<ScoreDTO> selectList() {
		Connection conn = getConnection();
		
		Statement stmt = null;
		ResultSet rs = null;

		List<ScoreDTO> scoreList = new ArrayList<ScoreDTO>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_LIST_SQL);
			
			while(rs.next()) {
				ScoreDTO dto = new ScoreDTO();
				
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setKor(rs.getInt(3));
				dto.setMath(rs.getInt(4));
				dto.setEng(rs.getInt(5));
				
				scoreList.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println("[ ERROR ] : ScoreDAOImpl - selectList() SQLException");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(conn);
		}
		
		return scoreList;
	}

	@Override
	public ScoreDTO selectOne(int no) {
		Connection conn = getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ScoreDTO dto = new ScoreDTO();

		try {
			pstmt = conn.prepareStatement(SELECT_LIST_SQL);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			rs.next();
			dto.setNo(no);
			dto.setName(rs.getString(2));
			dto.setKor(rs.getInt(3));
			dto.setMath(rs.getInt(4));
			dto.setEng(rs.getInt(5));
			
		} catch (SQLException e) {
			System.out.println("[ ERROR ] : ScoreDAOImpl - selectOne() SQLException");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return dto;
	}

	@Override
	public int insert(ScoreDTO dto) {
		Connection conn = getConnection();
		
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			pstmt = conn.prepareStatement(INSERT_SQL);
			
			pstmt.setInt(1, dto.getNo());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMath());
			
			res = pstmt.executeUpdate();
			
			if(res > 0) {
				commit(conn);
			}
			
		} catch (SQLException e) {
			System.out.println("[ ERROR ] : ScoreDAOImpl - insert() SQLException");
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		
		return res;
	}

	@Override
	public int update(ScoreDTO dto) {
		
		Connection conn = getConnection();
		
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			pstmt = conn.prepareStatement(UPDATE_SQL);
			
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getKor());
			pstmt.setInt(3, dto.getEng());
			pstmt.setInt(4, dto.getMath());
			pstmt.setInt(5, dto.getNo());
			
			res = pstmt.executeUpdate();
			
			if(res > 0) {
				commit(conn);
			}
			
		} catch (SQLException e) {
			System.out.println("[ ERROR ] : ScoreDAOImpl - update() SQLException");
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		
		return res;
	}

	@Override
	public int delete(int no) {
		
		Connection conn = getConnection();
		
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			pstmt = conn.prepareStatement(DELETE_SQL);
			
			pstmt.setInt(1, no);
			
			res = pstmt.executeUpdate();
			
			if(res > 0) {
				commit(conn);
			}
			
		} catch (SQLException e) {
			System.out.println("[ ERROR ] : ScoreDAOImpl - delete() SQLException");
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		
		return res;
	}

}
