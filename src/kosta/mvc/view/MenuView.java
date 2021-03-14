package kosta.mvc.view;

import java.util.Scanner;

import kosta.mvc.controller.PayController;
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

//////////////////////////////// => 검색 페이지
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
				// 검색페이지
				printSelectmenu(userId);
				break;
			case 2:
				// 마이페이지
				printMyPage(userId);
				break;
			case 3:
				// 로그아웃
				logout(userId);
				return;
			case 4:
				// 회원탈퇴
				printDelete(userId);
				return;
			default :
				System.out.println("1에서 4사이의 숫자를 입력해주세요.");
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

//////////////////////////////// => 검색 페이지
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
			printSelectmenu(userId);
		case 2:
			printKeywordSelectmenu(userId);
			break;
		default :
			System.out.println("1에서 2사이의 숫자를 입력해주세요.");
		}
	}

	private static void printKeywordSelectmenu(String userId) {
		System.out.println("\n-----" + userId + " 로그인 중 -----");
		System.out.println("┌──────────────┐");
		System.out.println("  	 1. 방크기로 검색						");
		System.out.println("  	 2. 방종류로 검색						");
		System.out.println("  	 3. 방가격으로 검색					   	");
		System.out.println("  	 4. 방층으로 검색							");
		System.out.println("  	 5. 숙박인원으로 검색				    ");
		System.out.println("  	 6. 침대수로 검색					    ");
		System.out.println("  	 7. 조식여부로 검색			       	");
		System.out.println("  	 8. 결과내 검색			       	");
		System.out.println("└──────────────┘");
		System.out.println("선택>>");

		int menu = Integer.parseInt(sc.nextLine());
		switch (menu) {
		case 1:
			printRoomSize();
			printKeywordSelectmenu(userId);
			break;
		case 2:
			printRoomTye();
			printKeywordSelectmenu(userId);
			break;
		case 3:
			printRoomPrice();
			printKeywordSelectmenu(userId);
			break;
		case 4:
			printFloor();
			printKeywordSelectmenu(userId);
			break;
		case 5:
			printNumberPeople();
			printKeywordSelectmenu(userId);
			break;
		case 6:
			printNumberBeds();
			printKeywordSelectmenu(userId);
			break;
		case 7:
			printBreakfastStat();
			printKeywordSelectmenu(userId);
			break;
	
		case 8:
			printsearchWthRsl();
			printKeywordSelectmenu(userId);
			break;
			default :
				System.out.println("1에서 8사이의 숫자를 입력해주세요.");
		}
	}

	// 1. 방크기로 검색
	public static void printRoomSize() {}
	
	// 2. 방종류로 검색
	public static void printRoomTye() {}
	
	// 3, 방가격으로 검색
	public static void printRoomPrice() {}
	
	// 4. 방층으로 검색
	public static void printFloor() {}
	
	// 5. 숙박인원으로 검색
	public static void printNumberPeople() {}
	
	// 6. 침대수로 검색
	public static void printNumberBeds() {}
	
	// 7. 조식여부로 검색
	public static void printBreakfastStat() {}
	
	// 8, 결과내 검색
	public static void printsearchWthRsl() {}
	
//////////////////////////////// => 마이 페이지
	
	private static void printMyPage(String userId) {
		while (true) {
			System.out.println("\n-----" + userId + " 로그인 중 -----");
			System.out.println("┌──────────────┐");
			System.out.println("  	 1. 관심리트스								");
			System.out.println("  	 2. 예약리스트							");
			System.out.println("  	 3. 결제리트스						    ");
			System.out.println("  	 4. 리뷰관리						    ");
			System.out.println("└──────────────┘");
			System.out.print("선택>>");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				// 관심리스트
				
				break;
			case 2:
				// 예약리스트
				
				break;
			case 3:
				// 결제리스트
				PayController.selectPayByUserId(userId);
				printMyPage(userId);
				break;
			case 4:
				// 리뷰관리
				
				printMyPage(userId);
				break;
			default :
				System.out.println("1에서 4사이의 숫자를 입력해주세요.");
			}
		}	
	} // printMyPage() 끝.
}