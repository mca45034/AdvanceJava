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

@WebServlet("/AuthenticateServlet2")
public class AuthenticateServlet2 extends HttpServlet {
	
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String pass = req.getParameter("pass");

		UserModel model = new UserModel();
		UserBean bean;
		try {
			bean = model.athenticate(login, pass);

				System.out.print("\t" + bean.getLogin_id());
				System.out.print("\t" + bean.getPassword());

			if (bean != null) {
				RequestDispatcher rd = req.getRequestDispatcher("Wel-come.jsp");
				rd.forward(req, resp);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	
	resp.sendRedirect("Authenticate.jsp");
	}
}
