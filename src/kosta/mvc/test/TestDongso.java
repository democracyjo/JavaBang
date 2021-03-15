package kosta.mvc.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import kosta.mvc.controller.PayController;
import kosta.mvc.controller.ReviewController;
import kosta.mvc.controller.RoomsController;
import kosta.mvc.controller.RsrvtController;
import kosta.mvc.controller.UserController;
import kosta.mvc.controller.WishController;
import kosta.mvc.model.dto.User;
import kosta.mvc.session.Session;
import kosta.mvc.session.SessionSet;
import kosta.mvc.view.MenuView;

public class TestDongso {
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
	public static void printUserMenu(User user) {
		while (true) {
			System.out.println("\n-----" + user.getId() + " 로그인 중 -----");
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
				printSelectmenu(user);
				break;
			case 2:
				// 마이페이지
				printMyPage(user);
				break;
			case 3:
				// 로그아웃
				logout(user);
				return;
			case 4:
				// 회원탈퇴
				printDelete(user);
				return;
			default:
				System.out.println("1에서 4사이의 숫자를 입력해주세요.");
			}
		}
	}

	// 로그아웃
	public static void logout(User user) {
		Session session = new Session(user.getId());

		SessionSet ss = SessionSet.getInstance();
		ss.remove(session);
	}

	// 회원탈퇴
	public static void printDelete(User user) {
		System.out.println(user.getId() + "님 비밀번호를 다시 입력해주세요.");
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();

		User dto = new User(user.getId(), pw);

		UserController.deleteUser(dto);
	}

//////////////////////////////// => 검색 페이지
	private static void printSelectmenu(User user) {
		System.out.println("\n-----" + user.getId() + " 로그인 중 -----");
		System.out.println("┌──────────────┐");
		System.out.println("  	 1. 전체검색								");
		System.out.println("  	 2. 부분 검색					         	");
		System.out.println("  	 3. 뒤로가기					         	");
		System.out.println("└──────────────┘");
		System.out.print("선택>>");

		int menu = Integer.parseInt(sc.nextLine());
		switch (menu) {
		case 1:
			RoomsController.selectAll();
			printSelectmenu(user);
		case 2:
			printKeywordSelectmenu(user);
			break;
		case 3:
			printUserMenu(user);
			break;
		default:
			System.out.println("1에서 3사이의 숫자를 입력해주세요.");
		}
	}

	// 부분검색
	private static void printKeywordSelectmenu(User user) {
		SessionSet ss = SessionSet.getInstance();
		System.out.println(ss.getSet());
		System.out.println("\n-----" + user.getId() + " 로그인 중 -----");
		System.out.println("┌──────────────┐");
		System.out.println("  	 1. 방크기로 검색						");
		System.out.println("  	 2. 방종류로 검색						");
		System.out.println("  	 3. 방가격으로 검색					   	");
		System.out.println("  	 4. 방층으로 검색							");
		System.out.println("  	 5. 숙박인원으로 검색				    ");
		System.out.println("  	 6. 침대수로 검색					    ");
		System.out.println("  	 7. 조식여부로 검색			       	");
		System.out.println("  	 8. 뒤로가기					         	");
		System.out.println("└──────────────┘");
		System.out.println("선택>>");

		int menu = Integer.parseInt(sc.nextLine());
		switch (menu) {
		case 1:
			printRoomSize();
			printKeywordSelectmenu(user);
			break;
		case 2:
			printRoomTye();
			printKeywordSelectmenu(user);
			break;
		case 3:
			printRoomPrice();
			printKeywordSelectmenu(user);
			break;
		case 4:
			printFloor();
			printKeywordSelectmenu(user);
			break;
		case 5:
			printNumberPeople();
			printKeywordSelectmenu(user);
			break;
		case 6:
			printNumberBeds();
			printKeywordSelectmenu(user);
			break;
		case 7:
			printBreakfastStat();
			printKeywordSelectmenu(user);
			break;
		case 8:
			// 뒤로가기
			printSelectmenu(user);
			break;
		default:
			System.out.println("1에서 8사이의 숫자를 입력해주세요.");
		} // switch문 끝.
	}
	
	// 1. 방크기로 검색
	public static void printRoomSize() {
		System.out.print("최소방 크기 : ");
		int min = Integer.parseInt(sc.nextLine());
		
		System.out.print("최대방 크기 : ");
		int max = Integer.parseInt(sc.nextLine());
		
		RoomsController.searchByRoomSize(min, max, false);
	}

	// 2. 방종류로 검색
	public static void printRoomTye() {
		List<String> typeList = new ArrayList<>();
		
		System.out.print("검색할 방타입 개수 : ");
		int cnt = Integer.parseInt(sc.nextLine());
		for(int i = 1; i <= cnt; i++) {
			System.out.print(i + "번째 방타입 : ");
			typeList.add(sc.nextLine());
		}
		RoomsController.searchByRoomType(typeList, false);
	}

	// 3, 방가격으로 검색
	public static void printRoomPrice() {
		System.out.print("방 최소 가격 : ");
		int minPrice = Integer.parseInt(sc.nextLine());
		
		System.out.print("방 최대 가격 : ");
		int maxPrice = Integer.parseInt(sc.nextLine());
		
		RoomsController.searchByRoomPrice(minPrice, maxPrice, false);
	}
	
	// 4. 방층으로 검색
	public static void printFloor() {
		System.out.print("방 층수 : ");
		int floor = Integer.parseInt(sc.nextLine());
		
		RoomsController.searchByFloor(floor, false);
	}

	// 5. 숙박인원으로 검색
	public static void printNumberPeople() {
		System.out.print("최소인원 : ");
		int minNum = Integer.parseInt(sc.nextLine());
		
		System.out.print("최대인원 : ");
		int maxNum = Integer.parseInt(sc.nextLine());
		
		RoomsController.searchByNumberPeople(minNum, maxNum, false);
	}
	
	// 6. 침대수로 검색
	public static void printNumberBeds() {
		System.out.print("최소 침대수 : ");
		int nimNum = Integer.parseInt(sc.nextLine());
		
		System.out.print("최대 침대수 : ");
		int maxNum = Integer.parseInt(sc.nextLine());
	
		RoomsController.searchByNumberBeds(nimNum, maxNum, false);
	}

	// 7. 조식여부로 검색
	public static void printBreakfastStat() {
		System.out.print("아침가능 여부(true 또는 false로 입력해주세요.) : ");
		boolean bfStat = Boolean.parseBoolean(sc.nextLine());
		RoomsController.searchByBreakfastStat(bfStat, false);
	}
	
//////////////////////////////// => 마이 페이지
	private static void printMyPage(User user) {
		while (true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet());
			System.out.println("\n-----" + user.getId() + " 로그인 중 -----");
			System.out.println("┌──────────────┐");
			System.out.println("  	 1. 관심리스트								");
			System.out.println("  	 2. 예약리스트							");
			System.out.println("  	 3. 결제리스트						    ");
			System.out.println("  	 4. 리뷰관리						    ");
			System.out.println("  	 5. 뒤로가기						    ");
			System.out.println("└──────────────┘");
			System.out.print("선택>>");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				// 관심리스트
				WishController.selectWishByUserId(user.getId());
				printWishList(user);
				break;
			case 2:
				// 예약리스트
				RsrvtController.selectRsrvtByUserId(user.getId());
				printRsrvtList(user);
				printMyPage(user);
				break;
			case 3:
				// 결제리스트
				PayController.selectPayByUserId(user.getId());
				printMyPage(user);
				break;
			case 4:
				// 리뷰관리
//				ReviewController.selectReviewByUserNo(userNo);
				printReview(user);
				printMyPage(user);
			case 5:
				// 뒤로가기
				printUserMenu(user);
				break;
			default:
				System.out.println("1에서 5사이의 숫자를 입력해주세요.");
			}
		}
	}
	
	// 관심리스트
	public static void printWishList(User user) {
		while (true) {
			System.out.println("\n-----" + user.getId() + " 로그인 중 -----");
			System.out.println("┌──────────────┐");
			System.out.println("  	 1. 예약								");
			System.out.println("  	 2. 관심취소							");
			System.out.println("  	 3. 뒤로가기						    ");
			System.out.println("└──────────────┘");
			System.out.print("선택>>");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				// 예약
				WishController.selectWishByUserId(user.getId());
				break;
			case 2:
				// 관심취소
			case 3:
				// 뒤로가기
				printMyPage(user);
				break;
			default:
				System.out.println("1에서 3사이의 숫자를 입력해주세요.");
			}
		}
	}

	// 예약리스트
	public static void printRsrvtList(User user) {
		while (true) {
			System.out.println("\n-----" + user.getId() + " 로그인 중 -----");
			System.out.println("┌──────────────┐");
			System.out.println("  	 1. 결제								");
			System.out.println("  	 2. 예약취소							");
			System.out.println("  	 3. 뒤로가기						    ");
			System.out.println("└──────────────┘");
			System.out.print("선택>>");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				// 결제
				WishController.selectWishByUserId(user.getId());
				break;
			case 2:
				// 예약취소
			case 3:
				// 뒤로가기
				printMyPage(user);
				break;
			default:
				System.out.println("1에서 3사이의 숫자를 입력해주세요.");
			}
		}
	}
	
	// 리뷰관리
	public static void printReview(User user) {
		while (true) {
			System.out.println("\n-----" + user.getId() + " 로그인 중 -----");
			System.out.println("┌──────────────┐");
			System.out.println("  	 1. 리뷰등록								");
			System.out.println("  	 2. 리뷰수정							");
			System.out.println("  	 3. 리뷰삭제					    ");
			System.out.println("  	 4. 뒤로가기						    ");
			System.out.println("└──────────────┘");
			System.out.print("선택>>");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				// 리뷰등록
//				WishController.selectWishByUserId();
				break;
			case 2:
				// 리뷰수정
			case 3:
				// 리뷰삭제
//				printMyPage(userId);
				break;
			case 4:
				// 뒤로가기
				printMyPage(user);
				break;
			default:
				System.out.println("1에서 4사이의 숫자를 입력해주세요.");
			}
		}
	}
}