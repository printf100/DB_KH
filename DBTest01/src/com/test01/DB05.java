package com.test01;

//캡슐화, 모듈화 : 만들어놓고 가져다가 사용하는 것
import static common.JDBCTemplate.*;	// static으로 import해서 클래스명 없이 메소드 호출 가능!

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DB05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 번호 : ");
		int no = sc.nextInt();
		
		// 1.
		// 2.
		Connection conn = getConnection();
		Statement stmt = null;
		int res = 0;
		String sql = " DELETE FROM JDBCTEST WHERE NO = " + no;
		
		// 3.
		// 4.
		try {
			stmt = conn.createStatement();
			res = stmt.executeUpdate(sql);
			
			if(res > 0) {	// DELETE가 성공했다면,
				System.out.println(no + "번 삭제 성공!");
				commit(conn);
			} else {
				System.out.println(no + "번 삭제 실패 ,,");
			}
		} catch (SQLException e) {
			System.out.println("[ ERROR ] : 3, 4");
			e.printStackTrace();
		} finally {
			// 5.
			close(stmt);
			close(conn);
		}
	}
}
