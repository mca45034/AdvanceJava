package in.co.transcationhendling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Commit {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		Statement stmt=conn.createStatement();
		int i=stmt.executeUpdate("insert into emp values(119,'ffff',23000,2)");
		i=stmt.executeUpdate("insert into emp values(119,'ffff',23000,2)");
		i=stmt.executeUpdate("insert into emp values(120,'ffff',23000,2)");
		System.out.println("data inserted ..."+i);
		

	}

}
