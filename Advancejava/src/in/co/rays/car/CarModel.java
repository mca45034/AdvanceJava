package in.co.rays.car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.util.JDBCDataSource;


public class CarModel {
	public void add(CarBean bean) throws Exception {
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("insert into car values(?,?,?)");
		ps.setInt(1, bean.getCar_id());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getPrice());
		int i=ps.executeUpdate();
		System.out.println("insert data.."+i);
		
	}
	public void update(CarBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps=conn.prepareStatement("update car set name=?,price=? where car_id=?");
		ps.setString(1, bean.getName());
		ps.setInt(2, bean.getPrice());
		ps.setInt(3, bean.getCar_id());
		int i=ps.executeUpdate();
		System.out.println("update data.."+i);
		
	}
	public void delete(CarBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps=conn.prepareStatement("delete from car where car_id=?");
		ps.setInt(1, bean.getCar_id());
		int i=ps.executeUpdate();
		System.out.println("delete record.."+i);
	}
	public List list() throws Exception  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps=conn.prepareStatement("select * from car");
		ResultSet rs=ps.executeQuery();
		List list=new ArrayList();
		while(rs.next()) {
			CarBean bean=new CarBean();
			bean.setCar_id(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setPrice(rs.getInt(3));
			list.add(bean);
		}
		
		return list;
		
	}
	public CarBean FindKeyId(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps=conn.prepareStatement("select*from car where car_id=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		CarBean bean=null;
		while(rs.next()) {
			bean=new CarBean();
			bean.setCar_id(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setPrice(rs.getInt(3));
		}
		
		return bean;
		
	}
	public CarBean authanticate(int car_id,String name) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps=conn.prepareStatement("select * from car where name=? and price=?");
		ps.setString(1, name );
		ps.setInt(2, car_id);
		ResultSet rs=ps.executeQuery();
		CarBean bean=null;
		 while(rs.next()) {
			bean=new CarBean();
			 bean.setCar_id(rs.getInt(1));
			 bean.setName(rs.getString(2));
			 bean.setPrice(rs.getInt(3));
		 }
		 return bean;
		
	}

}
