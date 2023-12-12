package in.co.rays.marksheet;

import java.util.Iterator;
import java.util.List;

public class DynamicSearchingTest {
	private static void testSearch() throws Exception{
		MarksheetBean bean=new MarksheetBean();
		bean.setF_name("h");
		//bean.setRoll_no(105);
		DynamicSearchingModel model=new DynamicSearchingModel();
		
		List list =model.search(bean);
		Iterator it=list.iterator();
		while(it.hasNext()) {
			 bean=(MarksheetBean) it.next();
			System.out.print( bean.getF_name());
			System.out.print("\t" + bean.getRoll_no());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());
		}
		

	 }

	public static void main(String[] args) throws Exception {
		testSearch();

	}

}
