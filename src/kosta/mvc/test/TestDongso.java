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
				// �α���
				MenuView.login();
				break;
			case 2:
				// ȸ������
				MenuView.inputUser();
				break;
			case 3:
				// ����
				System.out.println("=== JavaBang HOTEL�� �������� �湮���ּ���. ===");
				System.exit(0);
			}
		}
	}

	// ���θ޴�
	public static void printMenu() {
		System.out.println("=== JavaBang HOTEL ===");
		System.out.println("��������������������������������");
		System.out.println("  	 1. �α���								");
		System.out.println("  	 2. ȸ������								");
		System.out.println("  	 3. ����								    ");
		System.out.println("��������������������������������");
		System.out.print("����>>");
	}

	// �α���
	public static void login() {
		System.out.print("���̵� : ");
		String userId = sc.nextLine();

		System.out.print("�н����� : ");
		String userPwd = sc.nextLine();

		UserController.login(userId, userPwd);
	}

	// ȸ������
	public static void inputUser() {
		System.out.print("���̵� : ");
		String id = sc.nextLine();

		System.out.print("��й�ȣ : ");
		String pw = sc.nextLine();

		System.out.print("�̸� : ");
		String name = sc.nextLine();

		System.out.print("�ֹε�Ϲ�ȣ : ");
		String ssn = sc.nextLine();

		System.out.print("��ȭ��ȣ : ");
		String tel = sc.nextLine();

		User dto = new User(0, name, id, pw, ssn, tel);

		UserController.inputUser(dto);
	}

//////////////////////////////// => �˻� ������
	// �α��ν� �޴�
	public static void printUserMenu(User user) {
		while (true) {
			System.out.println("\n-----" + user.getId() + " �α��� �� -----");
			System.out.println("��������������������������������");
			System.out.println("  	 1. �˻�								");
			System.out.println("  	 2. ����������							");
			System.out.println("  	 3. �α׾ƿ�						    ");
			System.out.println("  	 4. ȸ��Ż��						    ");
			System.out.println("��������������������������������");
			System.out.print("����>>");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				// �˻�������
				printSelectmenu(user);
				break;
			case 2:
				// ����������
				printMyPage(user);
				break;
			case 3:
				// �α׾ƿ�
				logout(user);
				return;
			case 4:
				// ȸ��Ż��
				printDelete(user);
				return;
			default:
				System.out.println("1���� 4������ ���ڸ� �Է����ּ���.");
			}
		}
	}

	// �α׾ƿ�
	public static void logout(User user) {
		Session session = new Session(user.getId());

		SessionSet ss = SessionSet.getInstance();
		ss.remove(session);
	}

	// ȸ��Ż��
	public static void printDelete(User user) {
		System.out.println(user.getId() + "�� ��й�ȣ�� �ٽ� �Է����ּ���.");
		System.out.print("��й�ȣ : ");
		String pw = sc.nextLine();

		User dto = new User(user.getId(), pw);

		UserController.deleteUser(dto);
	}

//////////////////////////////// => �˻� ������
	private static void printSelectmenu(User user) {
		System.out.println("\n-----" + user.getId() + " �α��� �� -----");
		System.out.println("��������������������������������");
		System.out.println("  	 1. ��ü�˻�								");
		System.out.println("  	 2. �κ� �˻�					         	");
		System.out.println("  	 3. �ڷΰ���					         	");
		System.out.println("��������������������������������");
		System.out.print("����>>");

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
			System.out.println("1���� 3������ ���ڸ� �Է����ּ���.");
		}
	}

	// �κа˻�
	private static void printKeywordSelectmenu(User user) {
		SessionSet ss = SessionSet.getInstance();
		System.out.println(ss.getSet());
		System.out.println("\n-----" + user.getId() + " �α��� �� -----");
		System.out.println("��������������������������������");
		System.out.println("  	 1. ��ũ��� �˻�						");
		System.out.println("  	 2. �������� �˻�						");
		System.out.println("  	 3. �氡������ �˻�					   	");
		System.out.println("  	 4. �������� �˻�							");
		System.out.println("  	 5. �����ο����� �˻�				    ");
		System.out.println("  	 6. ħ����� �˻�					    ");
		System.out.println("  	 7. ���Ŀ��η� �˻�			       	");
		System.out.println("  	 8. �ڷΰ���					         	");
		System.out.println("��������������������������������");
		System.out.println("����>>");

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
			// �ڷΰ���
			printSelectmenu(user);
			break;
		default:
			System.out.println("1���� 8������ ���ڸ� �Է����ּ���.");
		} // switch�� ��.
	}
	
	// 1. ��ũ��� �˻�
	public static void printRoomSize() {
		System.out.print("�ּҹ� ũ�� : ");
		int min = Integer.parseInt(sc.nextLine());
		
		System.out.print("�ִ�� ũ�� : ");
		int max = Integer.parseInt(sc.nextLine());
		
		RoomsController.searchByRoomSize(min, max, false);
	}

	// 2. �������� �˻�
	public static void printRoomTye() {
		List<String> typeList = new ArrayList<>();
		
		System.out.print("�˻��� ��Ÿ�� ���� : ");
		int cnt = Integer.parseInt(sc.nextLine());
		for(int i = 1; i <= cnt; i++) {
			System.out.print(i + "��° ��Ÿ�� : ");
			typeList.add(sc.nextLine());
		}
		RoomsController.searchByRoomType(typeList, false);
	}

	// 3, �氡������ �˻�
	public static void printRoomPrice() {
		System.out.print("�� �ּ� ���� : ");
		int minPrice = Integer.parseInt(sc.nextLine());
		
		System.out.print("�� �ִ� ���� : ");
		int maxPrice = Integer.parseInt(sc.nextLine());
		
		RoomsController.searchByRoomPrice(minPrice, maxPrice, false);
	}
	
	// 4. �������� �˻�
	public static void printFloor() {
		System.out.print("�� ���� : ");
		int floor = Integer.parseInt(sc.nextLine());
		
		RoomsController.searchByFloor(floor, false);
	}

	// 5. �����ο����� �˻�
	public static void printNumberPeople() {
		System.out.print("�ּ��ο� : ");
		int minNum = Integer.parseInt(sc.nextLine());
		
		System.out.print("�ִ��ο� : ");
		int maxNum = Integer.parseInt(sc.nextLine());
		
		RoomsController.searchByNumberPeople(minNum, maxNum, false);
	}
	
	// 6. ħ����� �˻�
	public static void printNumberBeds() {
		System.out.print("�ּ� ħ��� : ");
		int nimNum = Integer.parseInt(sc.nextLine());
		
		System.out.print("�ִ� ħ��� : ");
		int maxNum = Integer.parseInt(sc.nextLine());
	
		RoomsController.searchByNumberBeds(nimNum, maxNum, false);
	}

	// 7. ���Ŀ��η� �˻�
	public static void printBreakfastStat() {
		System.out.print("��ħ���� ����(true �Ǵ� false�� �Է����ּ���.) : ");
		boolean bfStat = Boolean.parseBoolean(sc.nextLine());
		RoomsController.searchByBreakfastStat(bfStat, false);
	}
	
//////////////////////////////// => ���� ������
	private static void printMyPage(User user) {
		while (true) {
			SessionSet ss = SessionSet.getInstance();
			System.out.println(ss.getSet());
			System.out.println("\n-----" + user.getId() + " �α��� �� -----");
			System.out.println("��������������������������������");
			System.out.println("  	 1. ���ɸ���Ʈ								");
			System.out.println("  	 2. ���ฮ��Ʈ							");
			System.out.println("  	 3. ��������Ʈ						    ");
			System.out.println("  	 4. �������						    ");
			System.out.println("  	 5. �ڷΰ���						    ");
			System.out.println("��������������������������������");
			System.out.print("����>>");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				// ���ɸ���Ʈ
				WishController.selectWishByUserId(user.getId());
				printWishList(user);
				break;
			case 2:
				// ���ฮ��Ʈ
				RsrvtController.selectRsrvtByUserId(user.getId());
				printRsrvtList(user);
				printMyPage(user);
				break;
			case 3:
				// ��������Ʈ
				PayController.selectPayByUserId(user.getId());
				printMyPage(user);
				break;
			case 4:
				// �������
//				ReviewController.selectReviewByUserNo(userNo);
				printReview(user);
				printMyPage(user);
			case 5:
				// �ڷΰ���
				printUserMenu(user);
				break;
			default:
				System.out.println("1���� 5������ ���ڸ� �Է����ּ���.");
			}
		}
	}
	
	// ���ɸ���Ʈ
	public static void printWishList(User user) {
		while (true) {
			System.out.println("\n-----" + user.getId() + " �α��� �� -----");
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
				WishController.selectWishByUserId(user.getId());
				break;
			case 2:
				// �������
			case 3:
				// �ڷΰ���
				printMyPage(user);
				break;
			default:
				System.out.println("1���� 3������ ���ڸ� �Է����ּ���.");
			}
		}
	}

	// ���ฮ��Ʈ
	public static void printRsrvtList(User user) {
		while (true) {
			System.out.println("\n-----" + user.getId() + " �α��� �� -----");
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
				WishController.selectWishByUserId(user.getId());
				break;
			case 2:
				// �������
			case 3:
				// �ڷΰ���
				printMyPage(user);
				break;
			default:
				System.out.println("1���� 3������ ���ڸ� �Է����ּ���.");
			}
		}
	}
	
	// �������
	public static void printReview(User user) {
		while (true) {
			System.out.println("\n-----" + user.getId() + " �α��� �� -----");
			System.out.println("��������������������������������");
			System.out.println("  	 1. ������								");
			System.out.println("  	 2. �������							");
			System.out.println("  	 3. �������					    ");
			System.out.println("  	 4. �ڷΰ���						    ");
			System.out.println("��������������������������������");
			System.out.print("����>>");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				// ������
//				WishController.selectWishByUserId();
				break;
			case 2:
				// �������
			case 3:
				// �������
//				printMyPage(userId);
				break;
			case 4:
				// �ڷΰ���
				printMyPage(user);
				break;
			default:
				System.out.println("1���� 4������ ���ڸ� �Է����ּ���.");
			}
		}
	}
}