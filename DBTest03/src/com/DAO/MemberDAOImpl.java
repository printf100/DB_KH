package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.DTO.MemberDTO;
import com.db.JDBCTemplate;

public class MemberDAOImpl extends JDBCTemplate implements MemberDAO {

	@Override
	public List<MemberDTO> selectList() {
		
		Connection conn = getConnection();
		
		Statement stmt = null;
		ResultSet rs = null;

		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_LIST_SQL);
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setAge(rs.getInt(3));
				dto.setGender(rs.getString(4));
				dto.setLocation(rs.getString(5));
				dto.setJob(rs.getString(6));
				dto.setTel(rs.getString(7));
				dto.setEmail(rs.getString(8));
				
				memberList.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println("[ ERROR ] : MemberDAOImpl - selectList() SQLException");
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(conn);
		}
		
		return memberList;
	}

	@Override
	public MemberDTO selectOne(int no) {
		
		Connection conn = getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberDTO dto = new MemberDTO();
		
		try {
			pstmt = conn.prepareStatement(SELECT_ONE_SQL);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			rs.next();
			dto.setNo(rs.getInt(1));
			dto.setName(rs.getString(2));
			dto.setAge(rs.getInt(3));
			dto.setGender(rs.getString(4));
			dto.setLocation(rs.getString(5));
			dto.setJob(rs.getString(6));
			dto.setTel(rs.getString(7));
			dto.setEmail(rs.getString(8));
			
		} catch (SQLException e) {
			System.out.println("[ ERROR ] : MemberDAOImpl - selectOne() SQLException");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return dto;
	}

	@Override
	public int insert(MemberDTO dto) {
		
		Connection conn = getConnection();
		
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			pstmt = conn.prepareStatement(INSERT_SQL);
			
			pstmt.setInt(1, dto.getNo());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getLocation());
			pstmt.setString(6, dto.getJob());
			pstmt.setString(7, dto.getTel());
			pstmt.setString(8, dto.getEmail());
			
			res = pstmt.executeUpdate();
			
			if(res > 0) {
				commit(conn);
			}
			
		} catch (SQLException e) {
			System.out.println("[ ERROR ] : MemberDAOImpl - insert() SQLException");
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		
		return res;
	}

	@Override
	public int update(MemberDTO dto) {
		
		Connection conn = getConnection();
		
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			pstmt = conn.prepareStatement(UPDATE_SQL);
			
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getGender());
			pstmt.setString(4, dto.getLocation());
			pstmt.setString(5, dto.getJob());
			pstmt.setString(6, dto.getTel());
			pstmt.setString(7, dto.getEmail());
			pstmt.setInt(8, dto.getNo());
			
			res = pstmt.executeUpdate();
			
			if(res > 0) {
				commit(conn);
			}
			
		} catch (SQLException e) {
			System.out.println("[ ERROR ] : MemberDAOImpl - update() SQLException");
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
			System.out.println("[ ERROR ] : MemberDAOImpl - delete() SQLException");
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		
		return res;
	}

}
