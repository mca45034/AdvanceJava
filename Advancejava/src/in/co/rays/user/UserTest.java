package in.co.rays.user;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UserTest {
	private static void testInsert() throws Exception {
		Scanner sc=new Scanner(System.in);
		SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");
		UserBean bean=new UserBean();
		System.out.println("Enter your id..");
		bean.setId(sc.nextInt());
		System.out.println("Enter your first name..");
		bean.setF_name(sc.next());
		System.out.println("Enter your last name..");
		bean.setL_name(sc.next());
		System.out.println("Enter  login id..");
		bean.setLogin_id(sc.next());
		System.out.println("Enter password ..");
		bean.setPassword(sc.next());
		System.out.println("Enter your DOB..");
		bean.setDOB(sdf.parse(sc.next()));
		System.out.println("Enter your address..");
		bean.setAddress(sc.next());
		UserModel model=new UserModel();
		model.insert(bean);
	}
	private static void testUpdate() throws Exception {
		Scanner sc=new Scanner(System.in);
		SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");
		UserBean bean=new UserBean();
		System.out.println("Enter user id..");
		bean.setId(sc.nextInt());
		System.out.println("update user first name..");
		bean.setF_name(sc.next());
		System.out.println("update user last name..");
		bean.setL_name(sc.next());
		System.out.println("update user login id..");
		bean.setLogin_id(sc.next());
		System.out.println("update user password..");
		bean.setPassword(sc.next());
		System.out.println("update user DOB..");
		bean.setDOB(sdf.parse(sc.next()));
		System.out.println("update user address..");
		bean.setAddress(sc.next());
		UserModel model=new UserModel();
		model.update(bean);
		
	}
	private static void testDelete() throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter user id..");
		UserModel model=new UserModel();
		model.delete(sc.nextInt());
	}
	private static void testSearchByUser() throws Exception {
		UserModel model=new UserModel();
		UserBean bean=new UserBean();
		SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");
		bean.setDOB(sdf.parse("2020-11-25"));
		
		List list=model.searchUserBy(bean, 1, 3);
		Iterator it=list.iterator();
		while(it.hasNext()) {
			 bean =(UserBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getF_name());
			System.out.print("\t" + bean.getL_name());
			System.out.print("\t" + bean.getLogin_id());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDOB());
			System.out.println("\t" + bean.getAddress());
		}
	}
	private static void testSearchById() throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter user id..");
		UserModel model=new UserModel();
		UserBean bean=model.finById(sc.nextInt());
		if(bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getF_name());
			System.out.print("\t" + bean.getL_name());
			System.out.print("\t" + bean.getLogin_id());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDOB());
			System.out.println("\t" + bean.getAddress());
		}
		else {
			System.out.println("ID does not exist...");
		}
	}
	
	
	
	private static void testSearch() throws Exception {
		UserModel model=new UserModel();
		List list=model.search();
		Iterator it=list.iterator();
		while(it.hasNext()) {
			UserBean bean =(UserBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getF_name());
			System.out.print("\t" + bean.getL_name());
			System.out.print("\t" + bean.getLogin_id());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDOB());
			System.out.println("\t" + bean.getAddress());
		}
	}
	
	private static void athenticate() throws Exception {
		UserModel model=new UserModel();
		UserBean bean=model.athenticate("12345abc", "kumar@123");
		if(bean !=null) {
				System.out.print(bean.getId());
				System.out.print("\t" + bean.getF_name());
				System.out.print("\t" + bean.getL_name());
				//System.out.print("\t" + bean.getLogin_id());
				//System.out.print("\t" + bean.getPassword());
				System.out.print("\t" + bean.getDOB());
				System.out.println("\t" + bean.getAddress());
			
		}
		else {
			System.out.println("id not found...");
		}
	}
	
	
	
	
	
	
	
	private static void allRecords() throws Exception {
		Scanner sc=new Scanner(System.in);
		String ans;
		do {
			System.out.println("=======================");
			System.out.println("WELCOME TO USER");
			System.out.println("=======================");
			System.out.println("1. Insert user data");
			System.out.println("2. update User data");
			System.out.println("3. delete user data");
			System.out.println("4. search user data");
			System.out.println("5. search particular id by data");
			
			System.out.println("");
			System.out.println("Enter youre choice !!!!");
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1:{
				testInsert();
			}
			break;
			case 2: {
				testUpdate();
			}
			break;
			case 3: {
				testDelete();
			}
			break;
			case 4: {
				testSearch();
			}
			break;
			case 5: {
				testSearchById();
			}
			break;
			}
			System.out.println("");
			System.out.println("do you want continue yes/no..");
			ans=sc.next();
		}while("yes".equalsIgnoreCase(ans));
	}
	public static void main(String[] args) throws Exception {
		allRecords();
		//testSearchByUser();
		//athenticate();
		
		
	}

}
