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
					TestJo.inputUser(); // ����
					break;
				case 2 :
					TestJo.login();// �α���
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

			System.out.print("�̸� : ");
			String name = sc.nextLine();

			System.out.print("�ֹε�Ϲ�ȣ : ");
			String ssn = sc.nextLine();

			System.out.print("tel : ");
			String tel = sc.nextLine();

			User dto = new User(0, name, id, pw, ssn, tel);

			UserController.inputUser(dto);
		} // printJoin() �޼ҵ� ��.
		


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

		// ���ฮ��Ʈ
		public static void printRsrvtList(String userId) {
			while (true) {
				System.out.println("\n-----" + userId + " �α��� �� -----");
				System.out.println("��������������������������������");
				System.out.println("  	 1. ����								");
				System.out.println("  	 2. �������							");
				System.out.println("  	 3. �ڷΰ���						    ");
				System.out.println("��������������������������������");
				System.out.print("����>>");
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1:
					// ����
					WishController.selectWishByUserId(userId);
					break;
				case 2:
					// �������
				case 3:
					// �ڷΰ���
//					printMyPage(userId);
					break;
				default:
					System.out.println("1���� 3������ ���ڸ� �Է����ּ���.");
				}
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

		/*
		 * ����
		 * reservation.insert=insert into RESERVATION_LIST values(RESERVATION_LIST_NO_SEQ.NEXTVAL, SYSDATE, ?, ?, ?, ?, ?, ? )
		 * */
		public static void printInputReser() {
			System.out.print("ȸ����ȣ : ");
			int userNo = Integer.parseInt(sc.nextLine()); //Reservation
			
			System.out.print("üũ�� ��¥ : ");
			String checkinDate = sc.nextLine();
			
			System.out.print("üũ�ƿ� ��¥ : ");
			String checkoutDate = sc.nextLine();
			
			System.out.print("������ �ο��� : ");
			int totalpeopleNum = Integer.parseInt(sc.nextLine());
			
			System.out.print("������ ���ȣ : ");
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
		 * �����ϱ�
		 * */
		public static void printInputPay() {
			
			System.out.print("�����ȣ : ");
			int reserNo = Integer.parseInt(sc.nextLine());
			
			Pay pay = new Pay(0, null, reserNo);
			
			PayController.insertPay(pay);
			
		}//end of printInputReser()
		
		
		
		
}//end of class
