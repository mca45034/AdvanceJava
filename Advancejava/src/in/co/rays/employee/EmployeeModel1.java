package in.co.rays.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeModel1 {
	public void add(EmployeeBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps=conn.prepareStatement("insert into emp values(?,?,?,?)");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getSalary());
		ps.setInt(4, bean.getDep_id());
		int i=ps.executeUpdate();
		System.out.println("data inserted " +i);
	}
	public void Update(EmployeeBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps=conn.prepareStatement("update emp set name=?,salary=?,dep_id=? where id=?");
		ps.setString(1, bean.getName());
		ps.setInt(2, bean.getSalary());
		ps.setInt(3, bean.getDep_id());
		ps.setInt(4, bean.getId());
		int i=ps.executeUpdate();
		System.out.println("update data "+i);
		
	}
	public void delete1(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps=conn.prepareStatement("delete from emp where id=?");
		ps.setInt(1, id);
		int i=ps.executeUpdate();
		System.out.println("delete record  "+i);
	}

}
