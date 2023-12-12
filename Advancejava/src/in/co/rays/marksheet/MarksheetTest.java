package in.co.rays.marksheet;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MarksheetTest {
	private static void testAdd() throws Exception {
		Scanner sc=new Scanner(System.in);
		MarksheetBean bean=new MarksheetBean();
		System.out.println("Enter the student id..");
		bean.setId(sc.nextInt());
		System.out.println("Enter the student first name...");
		bean.setF_name(sc.next());
		System.out.println("Enter the student last name...");
		bean.setL_name(sc.next());
		System.out.println("Enter the student roll number...");
		bean.setRoll_no(sc.nextInt());
		System.out.println("Enter the student physics marks..");
		bean.setPhysics(sc.nextInt());
		System.out.println("Enter the student chemistry marks...");
		bean.setChemistry(sc.nextInt());
		System.out.println("Enter the student maths marks...");
		bean.setMaths(sc.nextInt());
		MarksheetModel model=new MarksheetModel();
		model.add(bean);
	}
	
	private static void testUpdate() throws Exception {
		Scanner sc=new Scanner(System.in);
		MarksheetBean bean=new MarksheetBean();
		System.out.println("Enter the student id..");
		bean.setId(sc.nextInt());
		System.out.println("update the student first name...");
		bean.setF_name(sc.next());
		System.out.println("update the student last name...");
		bean.setL_name(sc.next());
		System.out.println("update the student roll number...");
		bean.setRoll_no(sc.nextInt());
		System.out.println("update the student physics marks..");
		bean.setPhysics(sc.nextInt());
		System.out.println("update the student chemistry marks...");
		bean.setChemistry(sc.nextInt());
		System.out.println("update the student maths marks...");
		bean.setMaths(sc.nextInt());
		MarksheetModel model=new  MarksheetModel();
		model.update(bean);
	}
	private static void testDelete() throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the student id..");
		MarksheetModel model=new MarksheetModel();
		model.delete(sc.nextInt());
	}
	private static void testSearch() throws Exception {
	
		MarksheetModel model=new MarksheetModel();
		List list=model.search();
		Iterator it=list.iterator();
		while(it.hasNext()) {
			MarksheetBean bean=(MarksheetBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getF_name());
			System.out.print("\t" + bean.getL_name());
			System.out.print("\t" + bean.getRoll_no());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());
		} 
	}
	private static void testFindById() throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the student id..");
		MarksheetModel model=new MarksheetModel();
		MarksheetBean bean=model.findById(sc.nextInt());
		if(bean !=null) {
			
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getF_name());
			System.out.print("\t" + bean.getL_name());
			System.out.print("\t" + bean.getRoll_no());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());
			
		}
		else{
			System.out.println("ID does not exist...");
		}
	}
	private static void allRecord() throws Exception {
		String ans;
		do {
		

			Scanner sc=new Scanner(System.in);
			System.out.println("=========================================");
			System.out.println("WelCome to Student !!!!!");
			System.out.println("=========================================");
			System.out.println("1. insert data");
			System.out.println("2. update data");
			System.out.println("3. delete data");
			System.out.println("4. find perticular name by id");
			System.out.println("5. view the database table");
			System.out.println(" ");
			System.out.println("Enter youre choice");
			int choice=sc.nextInt();
			switch(choice) {
			case 1: {
				   testAdd();
				   break;
			}
			case 2:{
				 testUpdate();
				 break;
			}
			case 3:{
				 testDelete();
				 break;
			}
			case 4:{
				testFindById();
				 break;
			}
			case 5:{
				testSearch();
				 break;
			}
			}
			System.out.println("do you want to continue yes/no");
			ans=sc.next();
			}while(ans.equalsIgnoreCase("yes"));
	}
	
	public static void main(String[] args) throws Exception {
		allRecord();
	}

}
