package com.test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import common.JDBCTemplate;

public class DB06 extends JDBCTemplate {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 번호 : ");
		int no = sc.nextInt();
		System.out.println("수정할 이름 : ");
		String name = sc.next();
		System.out.println("수정할 별명 : ");
		String nickname = sc.next();
		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = " UPDATE JDBCTEST SET NAME = ?, NICKNAME = ?"
				+ "WHERE NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, nickname);
			pstmt.setInt(3, no);
			
			res = pstmt.executeUpdate();
			if(res > 0) {
				System.out.println(no + "번 수정 성공!");
				commit(conn);
			} else {
				System.out.println(no + "번 수정 실패 ,,");
			}
		} catch (SQLException e) {
			System.out.println("[ ERROR ] : 3, 4");
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
	}
}
