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
				MenuView.inputUser(); // 가입
				break;
			case 2 :
				MenuView.login();// 로그인
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

		System.out.print("이름 : ");
		String name = sc.nextLine();

		System.out.print("주민등록번호 : ");
		String ssn = sc.nextLine();

		System.out.print("tel : ");
		String tel = sc.nextLine();

		User dto = new User(0, name, id, pw, ssn, tel);

		UserController.inputUser(dto);
	} 


	public static void printMenu() {
		System.out.println("=== JavaBang HOTEL ===");
		System.out.println("┌──────────────┐");
		System.out.println("  	 1. 회원가입								");
		System.out.println("  	 2. 로그인								");
		System.out.println("  	 3. 종료								    ");
		System.out.println("└──────────────┘");
		System.out.println("선택>>");
	}
	
	public static void printUserMenu(String userId) {
		while(true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet()); //Set객체
			System.out.println("-----" +userId+ " 로그인 중 -----");
			System.out.println("┌──────────────┐");
			System.out.println("  	 1. 로그아웃								");
			System.out.println("  	 2. 검색							         	");
			System.out.println("  	 3. 마이페이지						    ");
			System.out.println("└──────────────┘");
			System.out.println("선택>>");
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

		System.out.println("┌──────────────┐");
		System.out.println("  	 1. 전체검색								");
		System.out.println("  	 2. 부분 검색					         	");
		System.out.println("└──────────────┘");
		System.out.println("선택>>");
		
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
		
		System.out.println("┌──────────────┐");
		System.out.println("  	 1. 방크기로 검색						");
		System.out.println("  	 2. 가격으로 검색					   	");
		System.out.println("  	 3. 숙박인원으로 검색				    ");
		System.out.println("  	 4. 층으로 검색							");
		System.out.println("  	 5. 조식여부로 검색			       	");
		System.out.println("  	 6. 침대수로 검색					    ");
		System.out.println("  	 7. 추가인원당 가격으로 검색     ");
		System.out.println("└──────────────┘");
		System.out.println("선택>>");
		
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
	 * 로그인 메뉴
	 * */
	public static void login() {
		 System.out.print("ID : ");
		 String userId = sc.nextLine();
		 
		 System.out.print("PASSWORD : ");
		 String userPwd = sc.nextLine();
		 
		 UserController.login(userId, userPwd); 
	}
	
	/**
	 * 로그아웃
	 * */
	public static void logout(String userId) {
		Session session = new Session(userId);
		
		SessionSet ss = SessionSet.getInstance();
		ss.remove(session);	
	}
}


