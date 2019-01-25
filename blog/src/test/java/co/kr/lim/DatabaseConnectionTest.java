package co.kr.lim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class DatabaseConnectionTest {

	private String driverClassName = "org.postgresql.Driver";

	private String url = "jdbc:postgresql://localhost:5432/";

	private String userName = "postgres";

	private String password = "zaq12wsx";

	@Test
	public void test() {
		Connection conn = null; // null로 초기화 한다.

		PreparedStatement preparedStatement;
		try {

			Class.forName(driverClassName); // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.

			conn = DriverManager.getConnection(url, userName, password); // DriverManager 객체로부터 Connection 객체를 얻어온다.
			preparedStatement = conn.prepareStatement("select * from member");
			ResultSet rs = preparedStatement.executeQuery();
			String username = null;
			while (rs.next()) {
				username = rs.getString("username");
			}
			System.out.println("username" + username); // 커넥션이 제대로 연결되면 수행된다.

		} catch (Exception e) { // 예외가 발생하면 예외 상황을 처리한다.

			e.printStackTrace();

		}

	}

}
