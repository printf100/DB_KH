package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// driver 연결
// 계정 연결
// db 종료
// commit & rollback
// 모든 메소드는 static!!!
public class JDBCTemplate {

	// 메모리 낭비를 막기 위해 싱글톤으로 만들거나, static에 다 박아버리기
	
	// 1. driver 연결
	// 2. 계정연결
	public static Connection getConnection() {
		
		// 1.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver 연결 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("[ ERROR ] : 1");
			e.printStackTrace();
		}
		
		// 2.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String pw = "kh";
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pw);
			conn.setAutoCommit(false);	// 원할 때 commit할 수 있도록 false로
			System.out.println("계정 연결 성공!");
		} catch (SQLException e) {
			System.out.println("[ ERROR ] : 2");
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	// 5. db 종료
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// commit & rollback
	public static void commit(Connection conn) {
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
