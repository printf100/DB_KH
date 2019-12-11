package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.DTO.MyDTO;
import com.db.JDBCTemplate;

// DAO : Data Access Object
// db와 연결해주는 객체
public class MyDAO extends JDBCTemplate {

	// 전체 출력
	public List<MyDTO> selectList() {
		
		// 1. driver 연결
		// 2. 계정 연결
		Connection conn = getConnection();
		
		String sql = " SELECT NO, NAME, NICKNAME FROM MYTEST ";
		Statement stmt = null;
		ResultSet rs = null;
		
		List<MyDTO> list = new ArrayList<MyDTO>();
		
		try {
			// 3. 쿼리 준비
			stmt = conn.createStatement();
			
			// 4. 실행 및 리턴
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				MyDTO dto = new MyDTO();
				
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setNickname(rs.getString(3));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println("[ ERROR ] : 3, 4");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(conn);
		}
		
		return list;
	}
	
	
	// 선택 출력
	public MyDTO selectOne(int no) {
		
		Connection conn = getConnection();
		
		String sql = "SELECT NO, NAME, NICKNAME FROM MYTEST WHERE NO = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MyDTO dto = new MyDTO();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
		
			rs.next();
			dto.setNo(no);
			dto.setName(rs.getString(2));
			dto.setNickname(rs.getString(3));
			
		} catch (SQLException e) {
			System.out.println("[ ERROR ] : 3, 4");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return dto;
	}
	
	
	// 추가
	public int insert(MyDTO dto) {
		
		Connection conn = getConnection();
		
		String sql = "INSERT INTO MYTEST VALUES (?, ?, ?) ";
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getNo());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getNickname());
			
			res = pstmt.executeUpdate();
			if(res > 0) {
				commit(conn);
			}
			
		} catch (SQLException e) {
			System.out.println("[ ERROR ] : 3, 4");
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
	
		return res;
	}
	
	
	// 수정
	public int update(MyDTO dto) {
		
		Connection conn = getConnection();
		
		String sql = " UPDATE MYTEST SET NAME = ?, NICKNAME = ? WHERE NO = ? ";
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getNickname());
			pstmt.setInt(3, dto.getNo());
			
			res = pstmt.executeUpdate();
			
			if(res > 0) {
				commit(conn);
			}
			
		} catch (SQLException e) {
			System.out.println("[ ERROR ] : 3, 4");
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}

		return res;
	}
	
	
	// 삭제
	public int delete(int no) {
		
		Connection conn = getConnection();
		
		String sql = " DELETE FROM MYTEST WHERE NO = ? ";
		PreparedStatement pstmt = null;		
		int res = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			res = pstmt.executeUpdate();
			
			if(res > 0) {
				commit(conn);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		
		return res;
	}


}
