package in.co.rays.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DynamicSearchingModel {
	
public List search(MarksheetBean bean) throws Exception {
		
		

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		StringBuffer sql=new StringBuffer("select * from marksheet where 1=1"); //sql injection== runtime sql query apped doit..
        if(bean !=null) {
        	if(bean.getF_name() !=null && bean.getF_name().length()>0) {//garbeg value withoutget anme..
        		sql.append(" and f_name like '"+bean.getF_name()+"%'");
        	}
        	if(bean.getRoll_no()>0) {
        		sql.append(" and roll_no = "+bean.getRoll_no());
        	}
        }
        int pageSize = 0;
		if(pageSize > 0) {
			int pageNo=0;
        	pageNo=(pageNo - 1)*pageSize;
        	sql.append(" limit "+ pageNo + ", " +pageSize);
        	
        }
        System.out.println("done......"+sql);
		PreparedStatement ps = conn.prepareStatement(sql.toString());  // where id 1=1 is return type boolean

		ResultSet rs = ps.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			
			 bean = new MarksheetBean();
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


}
