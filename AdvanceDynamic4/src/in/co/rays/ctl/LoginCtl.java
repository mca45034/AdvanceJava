package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.sendRedirect("LoginView.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("loginid");
		String pass = req.getParameter("password");
		UserBean bean = null;
		UserModel model = new UserModel();
		try {
			bean = model.athenticate(login, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (bean != null) {
			RequestDispatcher rd = req.getRequestDispatcher("Welcomess.jsp");
			rd.forward(req, resp);
		} else {
			resp.sendRedirect("LoginView.jsp");
		}

		System.out.println(login);
		System.out.println(pass);
	}
}