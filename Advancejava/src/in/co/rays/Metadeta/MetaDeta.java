package in.co.rays.Metadeta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;



public class MetaDeta {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select id,s_name,login_id,password,fee from newstudent");
		ResultSetMetaData rsmd=rs.getMetaData();
		System.out.println("Catelog name :"+rsmd.getCatalogName(1));
		System.out.println("Table name name :"+rsmd.getCatalogName(1));
		int columnCount=rsmd.getColumnCount();
		System.out.println("Total columns :"+columnCount);
		for (int i = 1; i <= columnCount; i++) {
			System.out.println("Column:"+(i));
			System.out.println("leble:"+rsmd.getColumnLabel(i));
			System.out.println("name:"+rsmd.getColumnName(i));
			System.out.println("type:"+rsmd.getColumnType(i));
			System.out.println("size:"+rsmd.getColumnDisplaySize(i));
			System.out.println("precision:"+rsmd.getPrecision(i));
			System.out.println();
			
		}
		
	}

}
