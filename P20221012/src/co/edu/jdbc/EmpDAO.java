package co.edu.jdbc; // 조회하는 기능

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpDAO {

	public static void main(String[] args) {
		update();
	}
	
	public static void update() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		
		stmt = conn.createStatement();
		int u = stmt.executeUpdate("update empl set first_name = 'messi' where employee_id = 500");
		System.out.println(u + "건 업데이트 됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
//				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void delete() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		
		stmt = conn.createStatement();
		int r = stmt.executeUpdate("delete from empl where employee_id = 700"); // insert, delete, update 구문을 쓸 때 사용
		System.out.println(r + "건 삭제됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
//				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void search() {
		// jdbc driver 로드
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); // 괄호안에 url, 사용자 계정, password필요
					
				stmt = conn.createStatement(); // 실행쿼리문을 전송, 결과 받아오도록하는 객체
				rs = stmt.executeQuery("select * from empl order by employee_id"); // select 일 경우 executeQuery사용
				// Set 컬렉션에 담아온 쿼리를 넣어준다
				while(rs.next()) {
						System.out.println("사원번호: " + rs.getInt("employee_id"));
						System.out.println("이름: " + rs.getString("first_name"));
						System.out.println("급여: " + rs.getInt("salary"));
						System.out.println("=====================================");
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// 예외가 발생하거나 정상 처리가 되더라도 반드시 실행할 문장 넣어줌
					try {
						rs.close();
						stmt.close();
						conn.close(); // 커넥션 객체는 연결하고 나면 클로즈로 닫아줘야 나중에 연결 오류가 나지 않는다
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				System.out.println("프로그램 종료");
	}
}
