package kosta.mvc.test;

import java.sql.SQLException;
import java.util.Scanner;

import kosta.mvc.controller.PayController;
import kosta.mvc.controller.RoomsController;
import kosta.mvc.controller.RsrvtController;
import kosta.mvc.controller.UserController;
import kosta.mvc.controller.WishController;
import kosta.mvc.model.dao.RoomsDAO;
import kosta.mvc.model.dao.RoomsDAOImpl;
import kosta.mvc.model.dao.RsrvtDAO;
import kosta.mvc.model.dao.RsrvtDAOImpl;
import kosta.mvc.model.dto.Pay;
import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.dto.Room;
import kosta.mvc.model.dto.User;
import kosta.mvc.session.Session;
import kosta.mvc.session.SessionSet;
import kosta.mvc.view.FailView;

public class TestJo {
	private static Scanner sc = new Scanner(System.in);
	static RoomsDAO roomDAO = new RoomsDAOImpl();
	static RsrvtDAO reserDAO = new RsrvtDAOImpl();

	public static void menu() {
			while(true) {
				SessionSet ss = SessionSet.getInstance();
				System.out.println(ss.getSet());
				
				TestJo.printMenu();
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1 :
					TestJo.inputUser(); // 가입
					break;
				case 2 :
					TestJo.login();// 로그인
					break;

				case 9 : 
					System.exit(0);
				}
			}

		}//end of menu() method
		
		
		private static void inputUser() {

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
		} // printJoin() 메소드 끝.
		


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

		// 예약리스트
		public static void printRsrvtList(String userId) {
			while (true) {
				System.out.println("\n-----" + userId + " 로그인 중 -----");
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
					WishController.selectWishByUserId(userId);
					break;
				case 2:
					// 예약취소
				case 3:
					// 뒤로가기
//					printMyPage(userId);
					break;
				default:
					System.out.println("1에서 3사이의 숫자를 입력해주세요.");
				}
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
			
			
			try {
				Room room = roomDAO.searchByRoomNo(roomNo);
				RsrvtController.insertReservation(reser, room);
			} catch (SQLException e) {
				FailView.errorMessage(e.getMessage());
			}finally {
				printInputReser();
			}
		}//end of printInputReser()
		
		
		/**
		 * 결제하기
		 * */
		public static void printInputPay() {
			
			System.out.print("예약번호 : ");
			int reserNo = Integer.parseInt(sc.nextLine());
			
			Pay pay = new Pay(0, null, reserNo);
			
			PayController.insertPay(pay);
			
		}//end of printInputReser()
		
		
		
		
}//end of class
