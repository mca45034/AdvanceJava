package in.co.transcationhendling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AutoCommit {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		conn.setAutoCommit(false);
		Statement stmt=conn.createStatement();
		int i=stmt.executeUpdate("insert into emp values(120,'ffff',23000,2)");
		i=stmt.executeUpdate("insert into emp values(120,'ffff',23000,2)");
		i=stmt.executeUpdate("insert into emp values(121,'ffff',23000,2)");
		conn.commit();
		System.out.println("data inserted ..."+i);
		

	}

}
