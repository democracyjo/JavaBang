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
		while (true) {
			MenuView.printMenu();
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				// 로그인
				MenuView.login();
				break;
			case 2:
				// 회원가입
				MenuView.inputUser();
				break;
			case 3:
				// 종료
				System.out.println("=== JavaBang HOTEL에 다음에도 방문해주세요. ===");
				System.exit(0);
			}
		}
	}

	// 메인메뉴
	public static void printMenu() {
		System.out.println("=== JavaBang HOTEL ===");
		System.out.println("┌──────────────┐");
		System.out.println("  	 1. 로그인								");
		System.out.println("  	 2. 회원가임								");
		System.out.println("  	 3. 종료								    ");
		System.out.println("└──────────────┘");
		System.out.print("선택>>");
	}

	// 로그인
	public static void login() {
		System.out.print("아이디 : ");
		String userId = sc.nextLine();

		System.out.print("패스워드 : ");
		String userPwd = sc.nextLine();

		UserController.login(userId, userPwd);
	}

	// 회원가입
	public static void inputUser() {
		System.out.print("아이디 : ");
		String id = sc.nextLine();

		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();

		System.out.print("이름 : ");
		String name = sc.nextLine();

		System.out.print("주민등록번호 : ");
		String ssn = sc.nextLine();

		System.out.print("전화번호 : ");
		String tel = sc.nextLine();

		User dto = new User(0, name, id, pw, ssn, tel);

		UserController.inputUser(dto);
	}

//////////////////////////////////////////////////////////////////////////////////////////////
	// 로그인시 메뉴
	public static void printUserMenu(String userId) {
		while (true) {
			System.out.println("\n-----" + userId + " 로그인 중 -----");
			System.out.println("┌──────────────┐");
			System.out.println("  	 1. 검색								");
			System.out.println("  	 2. 마이페이지							");
			System.out.println("  	 3. 로그아웃						    ");
			System.out.println("  	 4. 회원탈퇴						    ");
			System.out.println("└──────────────┘");
			System.out.print("선택>>");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				printSelectmenu(userId);
				break;
			case 2:
				// 마이페이지

				break;
			case 3:
				// 로그아웃
				logout(userId);
				return;
			case 4:
				// 회원탈퇴
				printDelete(userId);
				return;
			}
		}
	}

	// 로그아웃
	public static void logout(String userId) {
		Session session = new Session(userId);

		SessionSet ss = SessionSet.getInstance();
		ss.remove(session);
	}

	// 회원탈퇴
	public static void printDelete(String userId) {
		System.out.println(userId + "님 비밀번호를 다시 입력해주세요.");
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();

		User dto = new User(userId, pw);

		UserController.deleteUser(dto);
	}

///////////////////////////////////////////////////////////////////////////////////////////////////
	private static void printSelectmenu(String userId) {
		System.out.println("\n-----" + userId + " 로그인 중 -----");
		System.out.println("┌──────────────┐");
		System.out.println("  	 1. 전체검색								");
		System.out.println("  	 2. 부분 검색					         	");
		System.out.println("└──────────────┘");
		System.out.print("선택>>");

		int menu = Integer.parseInt(sc.nextLine());
		switch (menu) {
		case 1:
			RoomsController.selectAll();
			return;
		case 2:
			printKeywordSelectmenu(userId);
			break;
		}
	}

	private static void printKeywordSelectmenu(String userId) {
		System.out.println("\n-----" + userId + " 로그인 중 -----");
		System.out.println("\n┌──────────────┐");
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
		switch (menu) {
		case 1:
			
			return;
		case 2:
			
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		}
	}
	
	
	
	
	
	
	
}