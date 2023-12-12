package in.co.rays.student;

import java.util.Iterator;
import java.util.List;

public class StudentTest {
	private static void testInsert() throws Exception {
		StudentBean bean=new StudentBean();
		bean.setId(3);
		bean.setS_name("ramesh");
		bean.setLogin_id("ramesh@123");
		bean.setPassword("1234");
		bean.setFee(23000);
		StudentModel model=new StudentModel();
		model.insert(bean);
		
	}
	private static void testUpdate() throws Exception {
		StudentBean bean=new StudentBean();
		bean.setId(3);
		bean.setS_name("kirar");
		bean.setLogin_id("kirar@123");
		bean.setPassword("1234");
		bean.setFee(256780);
		StudentModel model=new StudentModel();
		model.update(bean);
	}
	private static void testDelete() throws Exception {
		StudentModel model=new StudentModel();
		model.delete(1);
	}
	private static void testSearch() throws Exception {
		StudentModel model=new StudentModel();
		List list=model.search();
		Iterator it=list.iterator();
		while(it.hasNext()) {
			StudentBean bean=(StudentBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t"+bean.getS_name());
			System.out.print("\t"+bean.getLogin_id());
			System.out.print("\t"+bean.getPassword());
			System.out.println("\t"+bean.getFee());
		}
	}
	private static void testFindById() throws Exception {
		StudentModel model=new StudentModel();
		StudentBean bean=model.findById(2);
		if(bean !=null) {
			
			System.out.print(bean.getId());
			System.out.print("\t"+bean.getS_name());
			System.out.print("\t"+bean.getLogin_id());
			System.out.print("\t"+bean.getPassword());
			System.out.println("\t"+bean.getFee());
		}
		
	}
	private static void testAuthenticate() throws Exception {
		StudentModel model=new StudentModel();
		StudentBean bean=model.Authenticate("rahul@123", "1234");
		if(bean !=null) {
			System.out.print(bean.getId());
			System.out.print("\t"+bean.getS_name());
			System.out.print("\t"+bean.getLogin_id());
			System.out.print("\t"+bean.getPassword());
			System.out.println("\t"+bean.getFee());
			
		}
	}
	private static void testSearchByName() throws Exception {
		StudentBean bean=new StudentBean();
		bean.setS_name("r");
		bean.setFee(13000);
		StudentModel model=new StudentModel();
		List list=model.searchByParticular(bean);
		Iterator it=list.iterator();
		while(it.hasNext()) {
			 bean=(StudentBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t"+bean.getS_name());
			System.out.print("\t"+bean.getLogin_id());
			System.out.print("\t"+bean.getPassword());
			System.out.println("\t"+bean.getFee());
		}
	}
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		//testInsert();
		//testUpdate();
        //testDelete();
		//testSearch();
		//testFindById();
		//testAuthenticate();
		testSearchByName();
	}

}
