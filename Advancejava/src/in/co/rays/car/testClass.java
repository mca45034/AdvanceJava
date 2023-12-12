package in.co.rays.car;

public class testClass {

	public static void main(String[] args) throws Exception {
		for (int i = 1; i <= 50; i++) {
			testFindById();
			System.out.println("connection..." + i);
		}

	}

	private static void testFindById() throws Exception {
		testModel model = new testModel();
		CarBean bean = model.FindKeyId(110);
		if (bean != null) {
			System.out.print(bean.getCar_id());
			System.out.print("\t" + bean.getName());
			System.out.println("\t" + bean.getPrice());
		}

	}

}
