package in.co.rays.customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class CustomerTest {

	public static void main(String[] args) throws Exception {
		// testInsert();
		// testUpdate();
		// testDelete();
		// testSearch();
		//testFindById();
		
		//testAuthenticate();
		testDynamicSearch();
	}

	private static void testInsert() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		CustomerBean bean = new CustomerBean();
		bean.setId(400);
		bean.setName("ramesh");
		bean.setLoin_id("remash@1234");
		bean.setDob(sdf.parse("2024-11-09"));
		bean.setPassword("2345");
		bean.setPyment(234500);
		CustomerModel model = new CustomerModel();
		model.insert(bean);
	}

	private static void testUpdate() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		CustomerBean bean = new CustomerBean();
		bean.setId(200);
		bean.setName("gggg");
		bean.setLoin_id("gg@123");
		bean.setDob(sdf.parse("2023-12-09"));
		bean.setPassword("1234");
		bean.setPyment(45000);
		CustomerModel model = new CustomerModel();
		model.update(bean);
	}

	private static void testDelete() throws Exception {
		CustomerModel model = new CustomerModel();
		model.delete(200);

	}

	private static void testSearch() throws Exception {
		CustomerModel model = new CustomerModel();
		List list = model.search();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			CustomerBean bean = (CustomerBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getLoin_id());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getPyment());
		}
	}

	private static void testFindById() throws Exception {
		CustomerModel model = new CustomerModel();
		CustomerBean bean = model.findById(100);
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getLoin_id());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getPyment());
		}
	}

	private static void testAuthenticate() throws Exception {
		CustomerModel model = new CustomerModel();
		CustomerBean bean = model.Athenticate("sham@123", "1234");
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getLoin_id());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getPyment());
		}
	}
	private static void testDynamicSearch() throws Exception {
		
		CustomerBean bean=new CustomerBean();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		bean.setDob(sdf.parse("2020-12-09"));
		bean.setPyment(123456);
		CustomerModel model=new CustomerModel();
		List list=model.DynamicSearch(bean, 2, 0);
		Iterator it=list.iterator();
		while(it.hasNext()) {
			bean=(CustomerBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getLoin_id());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getPyment());
		}
	}

}
