package in.co.rays.employee;

public class EmployeeTest {
	private static void testInsert() throws Exception {
		EmployeeBean bean=new EmployeeBean();
		bean.setId(113);
		bean.setName("rrrr");
		bean.setSalary(23456);
		bean.setDep_id(3);
		EmployeeModel1 model=new EmployeeModel1();
		model.add(bean);
	}
	private static void testUpdate() throws Exception {
		EmployeeBean bean=new EmployeeBean();
		bean.setId(113);
		bean.setName("sssss");
		bean.setSalary(8888888);
		bean.setDep_id(1);
		EmployeeModel1 model=new EmployeeModel1();
		model.Update(bean);
	}
	private static void testDelete() throws Exception {
		EmployeeModel1 model=new EmployeeModel1();
		model.delete1(113);
		
	}

	public static void main(String[] args) throws Exception {
		//testInsert();
		//testUpdate();
		testDelete();
	}

}
