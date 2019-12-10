package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DB03 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 1. driver 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection conn = DriverManager.getConnection(url, user, password);
		
		
		// 3. 쿼리 준비
		Scanner sc = new Scanner(System.in);
		System.out.println("번호 입력 : ");
		int no = sc.nextInt();
		System.out.println("이름 입력 : ");
		String name = sc.next();
		System.out.println("별명 입력 : ");
		String nickname = sc.next();
		
		// INSERT INTO JDBCTEST VALUES(NO, 'NAME', 'NICKNAME')
		String sql = " INSERT INTO JDBCTEST(NO, NAME, NICKNAME) "
				+ "VALUES(" + no + ", '" + name + "', '" + nickname + "')";
		
		Statement stmt = conn.createStatement();
		
		
		// 4. 실행 및 리턴
		// SELECT executeQuery() 메소드 사용, ResultSet이 리턴됨
		// INSERT, UPDATE, DELETE는 executeUpdate() 사용, 적용된 결과값 갯수가 리턴됨
		int res = stmt.executeUpdate(sql);
		if(res > 0) {
			System.out.println(res + "개 INSERT 성공!");
		} else {
			System.out.println("INSERT 실패");
		}
		
		
		// 5. db 종료
		stmt.close();
		conn.close();
	}
}
