package in.co.rays.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;
@WebServlet("/AuthenticateServlet1")
public class AuthenticateServlet1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("Authenticate.jsp");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login=req.getParameter("login");
		String pass=req.getParameter("pass");
		
		UserModel model=new UserModel();
		UserBean bean;
		try {
			bean = model.athenticate(login, pass);
		
		if(bean !=null) {
				
				System.out.print("\t" + bean.getLogin_id());
				System.out.print("\t" + bean.getPassword());
				
			
		}
		else {
			System.out.println("id not found...");
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	RequestDispatcher rd=req.getRequestDispatcher("AuthenticateServlet2");
	rd.forward(req, resp);
		
		
	}
	

}
