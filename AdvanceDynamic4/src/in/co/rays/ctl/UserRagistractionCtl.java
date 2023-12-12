package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;
import in.co.rays.util.DataUtility;
@WebServlet("/UserRagistractionCtl")
public class UserRagistractionCtl extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("UserRagisrtation0.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=(Integer.parseInt(req.getParameter("id")));
		String f_name=req.getParameter("firstName");
		String s_name=req.getParameter("lastName");
		String login_ids=req.getParameter("loginId");
		String password=req.getParameter("pass");
		 String Dob=req.getParameter("dob");
		String Address=req.getParameter("address");
		
		UserBean bean=new UserBean();
		
		bean.setId(id);
		bean.setF_name(f_name);
		bean.setL_name(s_name);
		bean.setLogin_id(login_ids);
		bean.setPassword(password );
        bean.setDOB(DataUtility.stringToDate(Dob));
		bean.setAddress(Address);
		
		UserModel model=new UserModel();
		try {
			model.insert(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

}
