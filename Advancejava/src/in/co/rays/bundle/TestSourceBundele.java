package in.co.rays.bundle;

import java.util.ResourceBundle;

public class TestSourceBundele {

	public static void main(String[] args) {
		ResourceBundle rs=ResourceBundle.getBundle("in.co.rays.bundle.dev_hi");
		System.out.println(rs.getString("dev"));

	}

}
