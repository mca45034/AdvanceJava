package in.co.rays.car;

import java.util.Iterator;
import java.util.List;

public class CarTest {
	private static void testAdd() throws Exception {
		CarBean bean = new CarBean();
		bean.setCar_id(134);
		bean.setName("alto");
		bean.setPrice(20000);
		CarModel model = new CarModel();
		model.add(bean);
	}

	private static void testUpdate() throws Exception {
		CarBean bean = new CarBean();
		bean.setCar_id(110);
		bean.setName("mar");
		bean.setPrice(20000);
		CarModel model = new CarModel();
		model.update(bean);
	}

	private static void testDelete() throws Exception {
		CarBean bean = new CarBean();
		bean.setCar_id(130);
		CarModel model = new CarModel();
		model.delete(bean);
	}

	private static void testSearch() throws Exception {
		CarModel model = new CarModel();
		List list = model.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			CarBean bean = (CarBean) it.next();
			System.out.print(bean.getCar_id());
			System.out.print("\t" + bean.getName());
			System.out.println("\t" + bean.getPrice());
		}

	}

	private static void testFindById() throws Exception {
		CarModel model = new CarModel();
		CarBean bean = model.FindKeyId(110);
		if (bean != null) {
			System.out.print(bean.getCar_id());
			System.out.print("\t" + bean.getName());
			System.out.println("\t" + bean.getPrice());
		}

	}

	private static void testAthontecate() throws Exception {
		CarModel model = new CarModel();
		CarBean bean = model.authanticate(250000, "audi");
		if (bean != null) {
			System.out.print(bean.getCar_id());
			System.out.print("\t" + bean.getName());
			System.out.println("\t" + bean.getPrice());

		}
	}

	public static void main(String[] args) throws Exception {
		testAdd();
		// testUpdate();
		// testDelete();
		// testSearch();
		// testFindById();
		// testAthontecate();

	}

}
