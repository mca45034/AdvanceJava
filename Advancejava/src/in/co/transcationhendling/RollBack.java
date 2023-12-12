package in.co.transcationhendling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RollBack {

	public static void main(String[] args) throws Exception {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
			conn.setAutoCommit(false);
			Statement stmt=conn.createStatement();
			int i=stmt.executeUpdate("insert into emp values(120,'ffff',23000,2)");
			i=stmt.executeUpdate("insert into emp values(120,'ffff',23000,2)");
			i=stmt.executeUpdate("insert into emp values(121,'ffff',23000,2)");
			conn.commit();
			System.out.println("data inserted ..."+i);
			
		} catch (Exception e) {
			conn.rollback();
			System.out.println("done");
		}

	}

}
