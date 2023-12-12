package in.co.rays.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarksheetModel {
	public void add(MarksheetBean bean  ) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps=conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?,?)");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getF_name());
		ps.setString(3, bean.getL_name());
		ps.setInt(4, bean.getRoll_no());
		ps.setInt(5, bean.getPhysics());
		ps.setInt(6, bean.getChemistry());
		ps.setInt(7, bean.getMaths());
		
		int i=ps.executeUpdate();
		System.out.println("data insert "+i);
		     	   
	}
	public void update(MarksheetBean bean) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps=conn.prepareStatement("update marksheet set f_name=?,l_name=?,roll_no=?,physics=?,chemistry=?,maths=? where id=?");
		ps.setString(1, bean.getF_name());
		ps.setString(2, bean.getL_name());
		ps.setInt(3, bean.getRoll_no());
		ps.setInt(4, bean.getPhysics());
		ps.setInt(5, bean.getChemistry());
		ps.setInt(6, bean.getMaths());
		ps.setInt(7, bean.getId());
		
		int i=ps.executeUpdate();
		System.out.println("data update"+i);
		
		
	}
	
	public void delete(int id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps=conn.prepareStatement("delete from marksheet where id=?");
		ps.setInt(1, id);
		int i=ps.executeUpdate();
		System.out.println("data deleted in successfully....!!!! "+i);
		
	}
	
	public MarksheetBean findById(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from marksheet where id = ?");

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		MarksheetBean bean = null;

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setF_name(rs.getString(2));
			bean.setL_name(rs.getString(3));
			bean.setRoll_no(rs.getInt(4));
			bean.setPhysics(rs.getInt(5));
			bean.setChemistry(rs.getInt(6));
			bean.setMaths(rs.getInt(7));
		}
		return bean;

	}

	public List search() throws Exception {
		
		

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from marksheet");

		ResultSet rs = ps.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			
			MarksheetBean bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setF_name(rs.getString(2));
			bean.setL_name(rs.getString(3));
			bean.setRoll_no(rs.getInt(4));
			bean.setPhysics(rs.getInt(5));
			bean.setChemistry(rs.getInt(6));
			bean.setMaths(rs.getInt(7));

			list.add(bean);
			}
			
		return list;
   }
	
	public Integer  nextPK() throws Exception {
		int pk=0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select max(id) from marksheet");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			pk=rs.getInt(1);
		}
		return pk+1;
		
	}
	public void autoPk(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps=conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		int pk=nextPK();
		ps.setInt(1, pk);
		ps.setString(2, bean.getF_name());
		ps.setString(3, bean.getL_name());
		ps.setInt(4, bean.getRoll_no());
		ps.setInt(5, bean.getPhysics());
		ps.setInt(6, bean.getChemistry());
		ps.setInt(7, bean.getMaths());
		
		int i=ps.executeUpdate();
		System.out.println("data insert "+i);
	}
	

}
