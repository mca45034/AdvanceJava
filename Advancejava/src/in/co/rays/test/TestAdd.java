package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestAdd {

	public static void main(String[] args) throws  SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("delete from marksheet  where id=18");

		System.out.println("Data Inserted = " + i);
	}

}
