package in.co.rays.car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.co.rays.util.JDBCDataSource;



public class testModel {
	public CarBean FindKeyId(int id) throws Exception {
		Connection conn=JDBCDataSource.getConnection();
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
}
