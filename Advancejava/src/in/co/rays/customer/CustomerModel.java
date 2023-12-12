package in.co.rays.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.util.JDBCDataSource;

public class CustomerModel {
	public void insert(CustomerBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("insert into customer values(?,?,?,?,?,?)");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setString(3, bean.getLoin_id());
		ps.setDate(4, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(5, bean.getPassword());
		ps.setInt(6, bean.getPyment());
		int i = ps.executeUpdate();
		System.out.println("data inserted..." + i);

	}

	public void update(CustomerBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn
				.prepareStatement("update customer set name=?,login_id=?,dob=?,password=?,pyment=? where id=? ");
		ps.setString(1, bean.getName());
		ps.setString(2, bean.getLoin_id());
		ps.setDate(3, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(4, bean.getPassword());
		ps.setInt(5, bean.getPyment());
		ps.setInt(6, bean.getId());
		int i = ps.executeUpdate();
		System.out.println("record updated.." + i);

	}

	public void delete(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("delete from customer where id=? ");
		ps.setInt(1, id);
		int i = ps.executeUpdate();
		System.out.println("record delete.." + i);

	}

	public List search() throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from customer");
		List list = new ArrayList();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			CustomerBean bean = new CustomerBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setLoin_id(rs.getString(3));
			bean.setDob(rs.getDate(4));
			bean.setPassword(rs.getString(5));
			bean.setPyment(rs.getInt(6));
			list.add(bean);

		}
		return list;

	}

	public CustomerBean findById(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from customer where id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		CustomerBean bean = null;
		while (rs.next()) {
			bean = new CustomerBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setLoin_id(rs.getString(3));
			bean.setDob(rs.getDate(4));
			bean.setPassword(rs.getString(5));
			bean.setPyment(rs.getInt(6));
		}
		return bean;

	}

	public CustomerBean Athenticate(String login_id, String password) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("select * from  customer where login_id=? and password=?");
		ps.setString(1, login_id);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		CustomerBean bean = null;
		while(rs.next()){
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setLoin_id(rs.getString(3));
			bean.setDob(rs.getDate(4));
			bean.setPassword(rs.getString(5));
			bean.setPyment(rs.getInt(6));
		}
		return bean;

	}
	public List DynamicSearch(CustomerBean bean ,int pageNo,int pageSize) throws Exception {
		Connection conn=JDBCDataSource.getConnection();
		StringBuffer sql=new StringBuffer("select * from customer where 1=1");
		if(bean !=null) {
			if(bean.getDob() !=null && bean.getDob().getTime() > 0) {
				sql.append(" and dob like '"+new java.sql.Date(bean.getDob().getTime()) + "%'");
			}
			if(bean.getPyment() >0) {
				sql.append(" and pyment = "+bean.getPyment());
			}
		}
		if(pageSize>0) {
			pageNo=(pageNo-1)*pageSize;
		sql.append(" limit "+pageNo +","+pageSize);
		}
		System.out.println(sql);
		PreparedStatement ps=conn.prepareStatement(sql.toString());
		ResultSet rs=ps.executeQuery();
		List list=new  ArrayList();
		while(rs.next()) {
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setLoin_id(rs.getString(3));
			bean.setDob(rs.getDate(4));
			bean.setPassword(rs.getString(5));
			bean.setPyment(rs.getInt(6));
			list.add(bean);
		}
		return list;
		
		
	}

}

