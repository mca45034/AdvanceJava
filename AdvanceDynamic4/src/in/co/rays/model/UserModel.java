 package in.co.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.util.JDBCDataSource;


public class UserModel {
	public void insert(UserBean bean) throws Exception {
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getF_name());
		ps.setString(3, bean.getL_name());
		ps.setString(4, bean.getLogin_id());
		ps.setString(5, bean.getPassword());
		ps.setDate(6, new java.sql.Date(bean.getDOB().getTime()));
		ps.setString(7, bean.getAddress());
		int i=ps.executeUpdate();
		System.out.println("data insrted.."+i);
		
		
	}
	public void update(UserBean bean) throws Exception {
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("update user set f_name=?,l_name=?,login_id=?,password=?,dob=?,address=? where id=?");
		
		ps.setString(1, bean.getF_name());
		ps.setString(2, bean.getL_name());
		ps.setString(3, bean.getLogin_id());
		ps.setString(4, bean.getPassword());
		ps.setDate(5, new java.sql.Date(bean.getDOB().getTime()));
		ps.setString(6, bean.getAddress());
		ps.setInt(7, bean.getId());
		int i=ps.executeUpdate();
		System.out.println("data updated.."+i);
	}
	public void delete(int id) throws Exception {
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("delete from user where id=? ");
		ps.setInt(1, id);
		int i=ps.executeUpdate();
		System.out.println("data deleted.."+i);
		
	}
	public  List searchUserBy(UserBean bean,int pageNo,int pageSize) throws Exception {
		Connection conn=JDBCDataSource.getConnection();
		StringBuffer sql=new StringBuffer("select * from user where 1=1");
		if(bean !=null) {
			if(bean.getDOB()!=null && bean.getDOB().getTime()>0) {
				sql.append(" and dob like '"+new java.sql.Date(bean.getDOB().getTime()) + "%'");
			}
			
			if(pageSize>0) {
				pageNo=(pageNo-1)*pageSize;
				sql.append(" limit "+ pageNo +","+pageSize);
			}
		}
		
		
		
		System.out.println(sql);
		PreparedStatement ps=conn.prepareStatement(sql.toString());
		ResultSet rs=ps.executeQuery();
		List list=new ArrayList();
		while(rs.next()) {
		     bean=new UserBean();
			bean.setId(rs.getInt(1));
			bean.setF_name(rs.getString(2));
			bean.setL_name(rs.getString(3));
			bean.setLogin_id(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDOB(rs.getDate(6));
			bean.setAddress(rs.getString(7));
			list.add(bean);
		}
		return list;
		
	}
	public List search() throws Exception {
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("select * from user");
		ResultSet rs = ps.executeQuery();
		List list=new ArrayList();
		while(rs.next()) {
		   UserBean  bean=new UserBean();
			bean.setId(rs.getInt(1));
			bean.setF_name(rs.getString(2));
			bean.setL_name(rs.getString(3));
			bean.setLogin_id(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDOB(rs.getDate(6));
			bean.setAddress(rs.getString(7));
			list.add(bean);
		}
		return list;
		
	}
	public UserBean finById(int id) throws Exception {
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("select * from user where id=?");
		ps.setInt(1,id );
		ResultSet rs=ps.executeQuery();
		UserBean bean=null;
		while(rs.next()) {
			bean=new UserBean();
			bean.setId(rs.getInt(1));
			bean.setF_name(rs.getString(2));
			bean.setL_name(rs.getString(3));
			bean.setLogin_id(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDOB(rs.getDate(6));
			bean.setAddress(rs.getString(7));
			
		}
		return bean;
		
	}

	public UserBean athenticate(String login_id,String password) throws Exception {
		Connection conn=JDBCDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement(" select * from user where login_id=? and password=? ");
		ps.setString(1, login_id);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		UserBean bean=null;
		while(rs.next()) {
			bean=new UserBean();
			bean.setId(rs.getInt(1));
			bean.setF_name(rs.getString(2));
			bean.setL_name(rs.getString(3));
			bean.setLogin_id(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDOB(rs.getDate(6));
			bean.setAddress(rs.getString(7));
			
		}
		return bean;
	}
	
	

}
