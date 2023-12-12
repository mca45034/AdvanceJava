package in.co.rays.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentModel {
	public void insert(StudentBean bean ) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps=conn.prepareStatement("insert into newstudent values(?,?,?,?,?)");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getS_name());
		ps.setString(3, bean.getLogin_id());
		ps.setString(4, bean.getPassword());
		ps.setInt(5, bean.getFee());
		int i=ps.executeUpdate();
		System.out.println("insert data.."+i);
		
	}
	public void update(StudentBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps=conn.prepareStatement("update newstudent set s_name=?,login_id=?,password=?,fee=? where id=?");
		ps.setString(1, bean.getS_name());
		ps.setString(2, bean.getLogin_id());
		ps.setString(3, bean.getPassword());
		ps.setInt(4, bean.getFee());
		ps.setInt(5, bean.getId());
		int i=ps.executeUpdate();
		System.out.println("update data.."+i);
	}
	public void delete(int id) throws Exception  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps=conn.prepareStatement("delete from newstudent where id=? ");
		ps.setInt(1, id);
		int i=ps.executeUpdate();
		System.out.println("delete record.."+i);
		
	}
	public List search() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps=conn.prepareStatement("select * from newstudent");
		List list=new ArrayList();
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			StudentBean bean=new StudentBean();
			bean.setId(rs.getInt(1));
			bean.setS_name(rs.getString(2));
			bean.setLogin_id(rs.getString(3));
			bean.setPassword(rs.getString(4));
			bean.setFee(rs.getInt(5));
			list.add(bean);
		}
		return list;
		
	}
	public StudentBean findById(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps=conn.prepareStatement("select * from newstudent where id=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		StudentBean bean=null;
		while(rs.next()) {
			bean =new StudentBean();
			bean.setId(rs.getInt(1));
			bean.setS_name(rs.getString(2));
			bean.setLogin_id(rs.getString(3));
			bean.setPassword(rs.getString(4));
			bean.setFee(rs.getInt(5));
		} 
		return bean;
		
	}
	public StudentBean Authenticate(String login_id,String password) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		PreparedStatement ps=conn.prepareStatement("select * from newstudent where login_id=? and password=?");
		ps.setString(1, login_id);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		StudentBean bean=null;
		while(rs.next()) {
			bean=new StudentBean();
			bean.setId(rs.getInt(1));
			bean.setS_name(rs.getString(2));
			bean.setLogin_id(rs.getString(3));
			bean.setPassword(rs.getString(4));
			bean.setFee(rs.getInt(5));
		}
		return bean;
		
	}
	public List searchByParticular(StudentBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		StringBuffer sql=new StringBuffer("select * from newstudent where 1=1");
		if(bean !=null) {
			if(bean.getS_name() !=null && bean.getS_name().length()>0) {
				sql.append(" and s_name like '"+bean.getS_name()+"%'");
				
			}
			if(bean.getFee()>0) {
				sql.append(" and fee ="+bean.getFee());
			}
		}
		System.out.println(sql);
			PreparedStatement ps=conn.prepareStatement(sql.toString());
			ResultSet rs=ps.executeQuery();
			
			List list=new ArrayList();
			 bean=null;
			while(rs.next()) {
				bean=new StudentBean();
				bean.setId(rs.getInt(1));
				bean.setS_name(rs.getString(2));
				bean.setLogin_id(rs.getString(3));
				bean.setPassword(rs.getString(4));
				bean.setFee(rs.getInt(5));
				list.add(bean);
			}
			return list;
			
		}
	
	}


