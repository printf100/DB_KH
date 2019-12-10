package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB01 {

	// J DB C
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 1. driver 연결 -> ojdbc6.jar 꼭 추가!!!
		Class.forName("oracle.jdbc.driver.OracleDriver");	// ClassNotFoundExeption
		
		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "kh";
		String password = "kh";
		
		Connection conn = DriverManager.getConnection(url, user, password);
		
		// 3. query 준비
		Statement stmt = conn.createStatement();
		String sql = " SELECT * FROM EMP ";	// 복잡한 쿼리는 밑으로 내려쓰는 경우가 있다. 그래서 앞뒤는 꼭 공백으로 한번씩 띄어주기!
		
		// 4. 실행 및 리턴
		ResultSet rs = null;
		rs = stmt.executeQuery(sql);	// 커서를 가지고 있음
		while(rs.next()) {	// 커서를 한줄씩 움직여서 데이터를 가져오게 함
			System.out.printf("%d %s %s %d %s %d %d %d\n", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt("MGR"), rs.getDate(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
		}
		
		// 5. db 종료
		rs.close();
		stmt.close();
		conn.close();
	}
}