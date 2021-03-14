package kosta.mvc.view;

import java.util.Scanner;

import kosta.mvc.controller.RoomsController;
import kosta.mvc.controller.UserController;
import kosta.mvc.model.dto.User;
import kosta.mvc.session.Session;
import kosta.mvc.session.SessionSet;

public class MenuView {
private static Scanner sc = new Scanner(System.in);
	
	public static void menu() {
		while(true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet());
			
			MenuView.printMenu();
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1 :
				MenuView.inputUser(); // ����
				break;
			case 2 :
				MenuView.login();// �α���
				break;

			case 9 : 
				System.exit(0);
			}
		}

	}//end of menu() method
	
	
	public static void inputUser() {

		System.out.print("ID : ");
		String id = sc.nextLine();

		System.out.print("PW : ");
		String pw = sc.nextLine();

		System.out.print("�̸� : ");
		String name = sc.nextLine();

		System.out.print("�ֹε�Ϲ�ȣ : ");
		String ssn = sc.nextLine();

		System.out.print("tel : ");
		String tel = sc.nextLine();

		User dto = new User(0, name, id, pw, ssn, tel);

		UserController.inputUser(dto);
	} 


	public static void printMenu() {
		System.out.println("=== JavaBang HOTEL ===");
		System.out.println("��������������������������������");
		System.out.println("  	 1. ȸ������								");
		System.out.println("  	 2. �α���								");
		System.out.println("  	 3. ����								    ");
		System.out.println("��������������������������������");
		System.out.println("����>>");
	}
	
	public static void printUserMenu(String userId) {
		while(true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet()); //Set��ü
			System.out.println("-----" +userId+ " �α��� �� -----");
			System.out.println("��������������������������������");
			System.out.println("  	 1. �α׾ƿ�								");
			System.out.println("  	 2. �˻�							         	");
			System.out.println("  	 3. ����������						    ");
			System.out.println("��������������������������������");
			System.out.println("����>>");
			int menu =Integer.parseInt( sc.nextLine());
			switch(menu) {
				case 1 :
					logout(userId);
					return;
					//break;
					
				case 2 :
					printSelectmenu(userId);
					break;
				case 3 :
					printIMypageMenu(userId);
					break;
				}
		}
	}
	
	private static void printIMypageMenu(String userId) {
		
	}

	private static void printSelectmenu(String userId) {

		System.out.println("��������������������������������");
		System.out.println("  	 1. ��ü�˻�								");
		System.out.println("  	 2. �κ� �˻�					         	");
		System.out.println("��������������������������������");
		System.out.println("����>>");
		
		int menu = Integer.parseInt(sc.nextLine()); 
		switch(menu) {
		case 1 :
			RoomsController.selectAll();
			return;
			//break;
		case 2 :
			printKeywordSelectmenu(userId);
			break;
		}
	}
	
	private static void printKeywordSelectmenu(String userId) {
		
		System.out.println("��������������������������������");
		System.out.println("  	 1. ��ũ��� �˻�						");
		System.out.println("  	 2. �������� �˻�					   	");
		System.out.println("  	 3. �����ο����� �˻�				    ");
		System.out.println("  	 4. ������ �˻�							");
		System.out.println("  	 5. ���Ŀ��η� �˻�			       	");
		System.out.println("  	 6. ħ����� �˻�					    ");
		System.out.println("  	 7. �߰��ο��� �������� �˻�     ");
		System.out.println("��������������������������������");
		System.out.println("����>>");
		
		int menu = Integer.parseInt(sc.nextLine()); 
		switch(menu) {
		case 1 :
			RoomsController.selectAll();
			return;
			//break;
		case 2 :
			break;
		case 3 :
			break;
		case 4 :
			break;
		case 5 :
			break;
		case 6 :
			break;
		case 7 :
			break;
		}
	}
	
	/**
	 * �α��� �޴�
	 * */
	public static void login() {
		 System.out.print("ID : ");
		 String userId = sc.nextLine();
		 
		 System.out.print("PASSWORD : ");
		 String userPwd = sc.nextLine();
		 
		 UserController.login(userId, userPwd); 
	}
	
	/**
	 * �α׾ƿ�
	 * */
	public static void logout(String userId) {
		Session session = new Session(userId);
		
		SessionSet ss = SessionSet.getInstance();
		ss.remove(session);	
	}
}


