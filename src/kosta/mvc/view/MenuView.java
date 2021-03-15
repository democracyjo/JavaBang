package kosta.mvc.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kosta.mvc.controller.PayController;
import kosta.mvc.controller.ReviewController;
import kosta.mvc.controller.RoomsController;
import kosta.mvc.controller.RsrvtController;
import kosta.mvc.controller.UserController;
import kosta.mvc.controller.WishController;
import kosta.mvc.model.dto.Pay;
import kosta.mvc.model.dto.Reservation;
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
			printSearchWthRes(user);
			break;
		case 2:
			printKeywordSelectmenu(user);
			break;
		case 3:
			return;
		default:
			System.out.println("1에서 3사이의 숫자를 입력해주세요.");
		}
	}

	// 결과내 검색
	private static void printSearchWthRes(User user) {
		
			System.out.println("\n-----" + user.getId() + " 로그인 중 -----");
			System.out.println("------------결과 내 검색-------------");
			System.out.println("┌────────────────────────┐");
			System.out.println("  	 1. 방 선택								");
			System.out.println("  	 2. 예약 날짜로 검색			       	");
			System.out.println("  	 3. 방크기로 검색						");
			System.out.println("  	 4. 방종류로 검색						");
			System.out.println("  	 5. 방가격으로 검색					   	");
			System.out.println("  	 6. 방층으로 검색				    	");
			System.out.println("  	 7. 숙박인원으로 검색				    ");
			System.out.println("  	 8. 침대수로 검색					    ");
			System.out.println("  	 9. 조식여부로 검색			         	");
			System.out.println("  	 10. 뒤로가기							");
			System.out.println("└────────────────────────┘");
			System.out.println("선택>>");

			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				selectRoom(user);

				printSearchWthRes(user);
				break;
			case 2:
				printResDate(true);

				printSearchWthRes(user);
				break;
			case 3:
				printRoomSize(true);

				printSearchWthRes(user);
				break;
			case 4:
				printRoomTye(true);
				printSearchWthRes(user);
				break;
			case 5:
				printRoomPrice(true);
				printSearchWthRes(user);
				break;
			case 6:
				printFloor(true);
				printSearchWthRes(user);
				break;
			case 7:
				printNumberPeople(true);
				printSearchWthRes(user);
				break;
			case 8:
				printNumberBeds(true);
				printSearchWthRes(user);
				break;
			case 9:
				printBreakfastStat(true);
				printSearchWthRes(user);
				break;
			case 10:
				// 뒤로가기
				return;
			default:
				System.out.println("1에서 10사이의 숫자를 입력해주세요.");
			} // switch문 끝.
		
	}

	// 방선택
	private static void selectRoom(User user) {
		System.out.println("\n-----" + user.getId() + " 로그인 중 -----");
		System.out.print("방번호 : ");
		int roomNo = Integer.parseInt(sc.nextLine());
		RoomsController.searchByRoomNo(roomNo);
		ReviewController.selectReviewByRoomNo(roomNo);
		System.out.println("┌────────────────────────┐");
		System.out.println("  	 1. 예약하기			       	");
		System.out.println("  	 2. 찜하기			       	");
		System.out.println("  	 3. 뒤로가기					         	");
		System.out.println("└────────────────────────┘");

		int menu = Integer.parseInt(sc.nextLine());
		switch (menu) {
		case 1:

			break;
		case 2:
			// 찜하기
			break;

		case 3:
			// 뒤로가기
			return;
		default:
			System.out.println("1에서 3사이의 숫자를 입력해주세요.");
		} // switch문 끝.
	}

	// 부분 검색
	private static void printKeywordSelectmenu(User user) {
		RoomsController.refresh();
		System.out.println("\n-----" + user.getId() + " 로그인 중 -----");
		
		System.out.println("┌────────────────────────┐");
		System.out.println("  	 1. 예약 날짜로 검색			       	");
		System.out.println("  	 2. 방크기로 검색						");
		System.out.println("  	 3. 방종류로 검색						");
		System.out.println("  	 4. 방가격으로 검색					   	");
		System.out.println("  	 5. 방층으로 검색							");
		System.out.println("  	 6. 숙박인원으로 검색				    ");
		System.out.println("  	 7. 침대수로 검색					    ");
		System.out.println("  	 8. 조식여부로 검색			       	");

		System.out.println("  	 9. 뒤로가기					         	");
		System.out.println("└────────────────────────┘");
		System.out.println("선택>>");

		int menu = Integer.parseInt(sc.nextLine());
		switch (menu) {
		case 1:
			printResDate(false);

			printSearchWthRes(user);
			break;
		case 2:
			printRoomSize(false);

			printSearchWthRes(user);
			break;
		case 3:
			printRoomTye(false);
			printSearchWthRes(user);
			break;
		case 4:
			printRoomPrice(false);
			printSearchWthRes(user);
			break;
		case 5:
			printFloor(false);
			printSearchWthRes(user);
			break;
		case 6:
			printNumberPeople(false);
			printSearchWthRes(user);
			break;
		case 7:
			printNumberBeds(false);
			printSearchWthRes(user);
			break;
		case 8:
			printBreakfastStat(false);
			printSearchWthRes(user);
			break;
		case 9:
			// 뒤로가기
			return;
		default:
			System.out.println("1에서 9사이의 숫자를 입력해주세요.");
		} // switch문 끝.
	}

	// 1.예약날짜로 검색
	public static void printResDate(boolean schWthRes) {
		System.out.println("yyyy-mm-dd 타입으로 넣어주세요.");
		System.out.print("체크인 날짜 : ");
		String checkin = sc.nextLine();

		System.out.print("체크아웃 날짜 : ");
		String checkout = sc.nextLine();

		RoomsController.searchByResDate(checkin, checkout, schWthRes);

	}

	// 2. 방크기로 검색
	public static void printRoomSize(boolean schWthRes) {
		System.out.print("최소방 크기 : ");
		int min = Integer.parseInt(sc.nextLine());

		System.out.print("최대방 크기 : ");
		int max = Integer.parseInt(sc.nextLine());

		RoomsController.searchByRoomSize(min, max, schWthRes);
	}

	// 3. 방종류로 검색
	public static void printRoomTye(boolean schWthRes) {
		List<String> typeList = new ArrayList<>();

		System.out.print("검색할 방타입 개수 : ");
		int cnt = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= cnt; i++) {
			System.out.print(i + "번째 방타입 : ");
			typeList.add(sc.nextLine());
		}
		RoomsController.searchByRoomType(typeList, schWthRes);
	}

	// 4, 방가격으로 검색
	public static void printRoomPrice(boolean schWthRes) {
		System.out.print("방 최소 가격 : ");
		int minPrice = Integer.parseInt(sc.nextLine());

		System.out.print("방 최대 가격 : ");
		int maxPrice = Integer.parseInt(sc.nextLine());

		RoomsController.searchByRoomPrice(minPrice, maxPrice, schWthRes);
	}

	// 5. 방층으로 검색
	public static void printFloor(boolean schWthRes) {
		System.out.print("방 층수 : ");
		int floor = Integer.parseInt(sc.nextLine());

		RoomsController.searchByFloor(floor, schWthRes);
	}

	// 6. 숙박인원으로 검색
	public static void printNumberPeople(boolean schWthRes) {
		System.out.print("최소인원 : ");
		int minNum = Integer.parseInt(sc.nextLine());

		System.out.print("최대인원 : ");
		int maxNum = Integer.parseInt(sc.nextLine());

		RoomsController.searchByNumberPeople(minNum, maxNum, schWthRes);
	}

	// 7. 침대수로 검색
	public static void printNumberBeds(boolean schWthRes) {
		System.out.print("최소 침대수 : ");
		int nimNum = Integer.parseInt(sc.nextLine());

		System.out.print("최대 침대수 : ");
		int maxNum = Integer.parseInt(sc.nextLine());

		RoomsController.searchByNumberBeds(nimNum, maxNum, schWthRes);
	}

	// 8. 조식여부로 검색
	public static void printBreakfastStat(boolean schWthRes) {
		System.out.print("아침가능 여부(true 또는 false로 입력해주세요.) : ");
		boolean bfStat = Boolean.parseBoolean(sc.nextLine());
		RoomsController.searchByBreakfastStat(bfStat, schWthRes);
	}

	// 8.

//////////////////////////////// => 마이 페이지
	private static void printMyPage(User user) {
		while (true) {
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
				printReview(user);
				printMyPage(user);
			case 5:
				// 뒤로가기
				return;
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
				printInputReser();
				break;
			case 2:
				// 관심취소
				printInputWishDelete();
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
				printInputPay(user);
				break;
			case 2:
				// 예약취소
				printInputReserDelete(user);
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
				WishController.selectWishByUserId(user.getId());
				break;
			case 2:
				// 리뷰수정
			case 3:
				// 리뷰삭제
//				printMyPage(userId);
				break;
			case 4:
				// 뒤로가기
//				printMyPage(userId);
				break;
			default:
				System.out.println("1에서 4사이의 숫자를 입력해주세요.");
			}
		}
	}
	
	
	/*
	 * 예약
	 * reservation.insert=insert into RESERVATION_LIST values(RESERVATION_LIST_NO_SEQ.NEXTVAL, SYSDATE, ?, ?, ?, ?, ?, ? )
	 * */
	public static void printInputReser() {
		System.out.print("회원번호 : ");
		int userNo = Integer.parseInt(sc.nextLine()); //Reservation
		
		System.out.print("체크인 날짜 : ");
		String checkinDate = sc.nextLine();

		System.out.print("체크아웃 날짜 : ");
		String checkoutDate = sc.nextLine();

		System.out.print("숙박할 인원수 : ");
		int totalpeopleNum = Integer.parseInt(sc.nextLine());

		System.out.print("예약할 방번호 : ");
		int roomNo = Integer.parseInt(sc.nextLine());

		Reservation reser = new Reservation(0, null, userNo, checkinDate, checkoutDate, totalpeopleNum, 0, roomNo);

		RoomsController.searchByRoomNo(roomNo);
		RsrvtController.insertReservation(reser, roomNo);

	}// end of printInputReser()

	/**
	 * 결제하기
	 */
	public static void printInputPay(User user) {

		System.out.print("예약번호 : ");
		int reserNo = Integer.parseInt(sc.nextLine());

		System.out.print("비밀번호: ");
		String pwd = sc.nextLine();
		
		if(user.getPw().equals(pwd)) {
			Pay pay = new Pay(0, null, reserNo);
			PayController.insertPay(pay);
		}else {
			System.out.println("비밀번호가 틀렸습니다. 다시 시도해 주세요.");
		}


	}// end of printInputPay()

	/**
	 * 관심취소
	 * */
	public static void printInputWishDelete() {
		
		System.out.print("예약번호 : ");
		int wishNo = Integer.parseInt(sc.nextLine());
		
		WishController.wishDelete(wishNo);
		
	}//end of method
	
	/**
	 * 예약취소
	 * */
	public static void printInputReserDelete(User user) {
		
		System.out.print("예약번호 : ");
		int reserNo = Integer.parseInt(sc.nextLine());
		
		System.out.print("비밀번호: ");
		String pwd = sc.nextLine();
		
		if(user.getPw().equals(pwd)) {
			RsrvtController.reservationDelete(reserNo);
		}else {
			System.out.println("비밀번호가 틀렸습니다. 다시 시도해 주세요.");
		}
		
		
	}//end of method
	
} // MenuView 클래스 끝.