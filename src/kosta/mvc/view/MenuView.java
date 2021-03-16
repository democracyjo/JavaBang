package kosta.mvc.view;

import java.sql.SQLException;
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
import kosta.mvc.model.dto.Review;
import kosta.mvc.model.dto.User;
import kosta.mvc.model.service.RoomsService;
import kosta.mvc.model.service.RsrvtService;
import kosta.mvc.model.service.RsrvtServiceImpl;
import kosta.mvc.session.Session;
import kosta.mvc.session.SessionSet;

public class MenuView {
	public static final int ROOM_SIZE = 1;
	public static final int ROOM_TYPE = 2;
	public static final int ROOM_PRICE = 3;
	public static final int ROOM_FLOOR = 4;
	public static final int ROOM_APPNO = 5;
	public static final int ROOM_BED_NO = 6;
	public static final int ROOM_BREAK = 7;
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
			System.out.println("\n----- " + user.getId() + " / ȸ����ȣ[" + user.getUserNo() + "] �α��� �� -----");
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
		while (true) {
			System.out.println("\n----- " + user.getId() + " / ȸ����ȣ[" + user.getUserNo() + "] �α��� �� -----");
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
				printSearchWthRes(user);
				break;
			case 2:
				printKeywordSelectmenu(user);
				break;
			case 3:
				return;
			default:
				System.out.println("1���� 3������ ���ڸ� �Է����ּ���.");
			}
		}
	}

	// ����� �˻�
	private static void printSearchWthRes(User user) {

		System.out.println("\n----- " + user.getId() + " / ȸ����ȣ[" + user.getUserNo() + "] �α��� �� -----");
		System.out.println("------------��� �� �˻�-------------");
		System.out.println("����������������������������������������������������");
		System.out.println("  	 1. �� ����								");
		System.out.println("  	 2. ���� ��¥�� �˻�			       	");
		System.out.println("  	 3. ��ũ��� �˻�						");
		System.out.println("  	 4. �������� �˻�						");
		System.out.println("  	 5. �氡������ �˻�					   	");
		System.out.println("  	 6. �������� �˻�				    	");
		System.out.println("  	 7. �����ο����� �˻�				    ");
		System.out.println("  	 8. ħ����� �˻�					    ");
		System.out.println("  	 9. ���Ŀ��η� �˻�			         	");
		System.out.println("  	 10. �ڷΰ���							");
		System.out.println("����������������������������������������������������");
		System.out.println("����>>");

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
			// �ڷΰ���
			return;
		default:
			System.out.println("1���� 10������ ���ڸ� �Է����ּ���.");
		} // switch�� ��.

	}

	// �漱��
	private static void selectRoom(User user) {
		System.out.println("\n----- " + user.getId() + " / ȸ����ȣ[" + user.getUserNo() + "] �α��� �� -----");
		System.out.print("���ȣ : ");
		int roomNo = Integer.parseInt(sc.nextLine());
		RoomsController.searchByRoomNo(roomNo);
		ReviewController.selectReviewByRoomNo(roomNo);
		System.out.println("����������������������������������������������������");
		System.out.println("  	 1. �����ϱ�			       	");
		System.out.println("  	 2. ���ϱ�			       	");
		System.out.println("  	 3. �ڷΰ���					         	");
		System.out.println("����������������������������������������������������");
		System.out.println("����>>");

		int menu = Integer.parseInt(sc.nextLine());
		switch (menu) {
		case 1:
			// ����
			printInputReser(user);
			break;
		case 2:
			// ���ϱ�
			WishController.insertWish(user, roomNo);
			break;

		case 3:
			// �ڷΰ���
			return;
		default:
			System.out.println("1���� 3������ ���ڸ� �Է����ּ���.");
		} // switch�� ��.
	}

	// �κ� �˻�
	private static void printKeywordSelectmenu(User user) {
		RoomsController.refresh();
		System.out.println("\n----- " + user.getId() + " / ȸ����ȣ[" + user.getUserNo() + "] �α��� �� -----");

		System.out.println("����������������������������������������������������");
		System.out.println("  	 1. ���� ��¥�� �˻�			       	");
		System.out.println("  	 2. ��ũ��� �˻�						");
		System.out.println("  	 3. �������� �˻�						");
		System.out.println("  	 4. �氡������ �˻�					   	");
		System.out.println("  	 5. �������� �˻�							");
		System.out.println("  	 6. �����ο����� �˻�				    ");
		System.out.println("  	 7. ħ����� �˻�					    ");
		System.out.println("  	 8. ���Ŀ��η� �˻�			       	");

		System.out.println("  	 9. �ڷΰ���					         	");
		System.out.println("����������������������������������������������������");
		System.out.println("����>>");

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
			// �ڷΰ���
			return;
		default:
			System.out.println("1���� 9������ ���ڸ� �Է����ּ���.");
		} // switch�� ��.
	}

	// 1.���೯¥�� �˻�
	public static void printResDate(boolean schWthRes) {
		System.out.println("yyyy-mm-dd Ÿ������ �־��ּ���.");
		System.out.print("üũ�� ��¥ : ");
		String checkin = sc.nextLine();

		System.out.print("üũ�ƿ� ��¥ : ");
		String checkout = sc.nextLine();

		RoomsController.searchByResDate(checkin, checkout, schWthRes);

	}

	// 2. ��ũ��� �˻�
	public static void printRoomSize(boolean schWthRes) {
		System.out.println("��ũ�� : " + RoomsController.getMin(ROOM_SIZE) + "~" + RoomsController.getMax(ROOM_SIZE));
		System.out.print("�ּҹ� ũ�� : ");
		int min = Integer.parseInt(sc.nextLine());

		System.out.print("�ִ�� ũ�� : ");
		int max = Integer.parseInt(sc.nextLine());

		RoomsController.searchByRoomSize(min, max, schWthRes);
	}

	// 3. �������� �˻�
	public static void printRoomTye(boolean schWthRes) {
		List<String> typeList = new ArrayList<>();
		RoomsController.printRoomTypeList(schWthRes);
		System.out.print("�˻��� ��Ÿ�� ���� : ");
		int cnt = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= cnt; i++) {
			System.out.print(i + "��° ��Ÿ�� : ");
			typeList.add(sc.nextLine());
		}
		RoomsController.searchByRoomType(typeList, schWthRes);
	}

	// 4, �氡������ �˻�
	public static void printRoomPrice(boolean schWthRes) {
		System.out.println("�� ���� : " + RoomsController.getMin(ROOM_PRICE) + "~" + RoomsController.getMax(ROOM_PRICE));

		System.out.print("�� �ּ� ���� : ");
		int minPrice = Integer.parseInt(sc.nextLine());

		System.out.print("�� �ִ� ���� : ");
		int maxPrice = Integer.parseInt(sc.nextLine());

		RoomsController.searchByRoomPrice(minPrice, maxPrice, schWthRes);
	}

	// 5. �������� �˻�
	public static void printFloor(boolean schWthRes) {
		System.out.println("�� ���� : " + RoomsController.getMin(ROOM_FLOOR) + "~" + RoomsController.getMax(ROOM_FLOOR));

		System.out.print("�ּ� �� : ");
		int minFloor = Integer.parseInt(sc.nextLine());

		System.out.print("�ִ� �� : ");
		int maxFloor = Integer.parseInt(sc.nextLine());

		RoomsController.searchByFloor(minFloor, maxFloor, schWthRes);
	}

	// 6. �����ο����� �˻�
	public static void printNumberPeople(boolean schWthRes) {
		System.out.println("�� �ο� : " + RoomsController.getMin(ROOM_APPNO) + "~" + RoomsController.getMax(ROOM_APPNO));

		System.out.print("�ּ��ο� : ");
		int minNum = Integer.parseInt(sc.nextLine());

		System.out.print("�ִ��ο� : ");
		int maxNum = Integer.parseInt(sc.nextLine());

		RoomsController.searchByNumberPeople(minNum, maxNum, schWthRes);
	}

	// 7. ħ����� �˻�
	public static void printNumberBeds(boolean schWthRes) {
		System.out.println("ħ�� �� : " + RoomsController.getMin(ROOM_BED_NO) + "~" + RoomsController.getMax(ROOM_BED_NO));

		System.out.print("�ּ� ħ��� : ");
		int nimNum = Integer.parseInt(sc.nextLine());

		System.out.print("�ִ� ħ��� : ");
		int maxNum = Integer.parseInt(sc.nextLine());

		RoomsController.searchByNumberBeds(nimNum, maxNum, schWthRes);
	}

	// 8. ���Ŀ��η� �˻�
	public static void printBreakfastStat(boolean schWthRes) {
		System.out.print("��ħ���� ����(true �Ǵ� false�� �Է����ּ���.) : ");
		boolean bfStat = Boolean.parseBoolean(sc.nextLine());
		RoomsController.searchByBreakfastStat(bfStat, schWthRes);
	}

	// 8.

//////////////////////////////// => ���� ������
	private static void printMyPage(User user) {
		while (true) {
			System.out.println("\n----- " + user.getId() + " / ȸ����ȣ[" + user.getUserNo() + "] �α��� �� -----");
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

				break;
			case 3:
				// ��������Ʈ
				PayController.selectPayByUserId(user.getId());

				break;
			case 4:
				// �������
				printReview(user);

				break;
			case 5:
				// �ڷΰ���
				return;
			default:
				System.out.println("1���� 5������ ���ڸ� �Է����ּ���.");
			}
		}
	}

	// ���ɸ���Ʈ
	public static void printWishList(User user) {
		while (true) {
			System.out.println("\n----- " + user.getId() + " / ȸ����ȣ[" + user.getUserNo() + "] �α��� �� -----");
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
				printInputReser(user);
				break;
			case 2:
				// �������
				printInputWishDelete();
				break;
			case 3:
				// �ڷΰ���

				return;
			default:
				System.out.println("1���� 3������ ���ڸ� �Է����ּ���.");
			}
		}
	}

	// ���ฮ��Ʈ
	public static void printRsrvtList(User user) {
		while (true) {
			System.out.println("\n----- " + user.getId() + " / ȸ����ȣ[" + user.getUserNo() + "] �α��� �� -----");
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
				printInputPay(user);
				break;
			case 2:
				// �������
				printInputReserDelete(user);
				break;
			case 3:
				// �ڷΰ���
				return;
			default:
				System.out.println("1���� 3������ ���ڸ� �Է����ּ���.");
			}
		}
	}

	// �������
	public static void printReview(User user) {
		while (true) {
			System.out.println("\n----- " + user.getId() + " / ȸ����ȣ[" + user.getUserNo() + "] �α��� �� -----");
			System.out.println("��������������������������������");
			System.out.println("  	 1. ������								");
			System.out.println("  	 2. �������							");
			System.out.println("  	 3. �������					    ");
			System.out.println("  	 4. �ڷΰ���						    ");
			System.out.println("��������������������������������");
			System.out.print("����>>");
			int menu = Integer.parseInt(sc.nextLine());

			ReviewController.selectReviewByUserNo(user.getUserNo());

			switch (menu) {
			case 1:
				// ���� �ۼ��ϱ�
				System.out.print("���ȣ�� �Է����ּ��� : ");
				int roomNo = Integer.parseInt(sc.nextLine());

				System.out.print("�濡���� ������ �����ּ��� : ");
				int score = Integer.parseInt(sc.nextLine());

				System.out.print("�濡���� ���븦 �����ּ��� : ");
				String reviewContent = sc.nextLine();

				Review review = new Review(0, user.getUserNo(), roomNo, score, reviewContent, null);
				ReviewController.insertReview(review);
				break;

			case 2:
				// ���� �����ϱ�
				System.out.print("�����ȣ�� �Է����ּ��� : ");
				int reviewNo = Integer.parseInt(sc.nextLine());

				System.out.print("������ ���� ������ �Է����ּ��� : ");
				String updateContent = sc.nextLine();

				review = new Review(reviewNo, updateContent);
				ReviewController.updateReview(review);
				break;

			case 3:
				// ���� �����ϱ�
				System.out.print("������ ���� ��ȣ�� �Է����ּ��� : ");
				reviewNo = Integer.parseInt(sc.nextLine());

				ReviewController.deleteReview(reviewNo);
				break;

			case 4:
				// �ڷΰ���
				return;

			default:
				System.out.println("1���� 4������ ���ڸ� �Է����ּ���.");

			}
		}
	}

	/*
	 * ���� reservation.insert=insert into RESERVATION_LIST
	 * values(RESERVATION_LIST_NO_SEQ.NEXTVAL, SYSDATE, ?, ?, ?, ?, ?, ? )
	 */
	public static void printInputReser(User user) {
		RsrvtService rs = new RsrvtServiceImpl();
		System.out.print("üũ�� ��¥ : ");
		String checkinDate = sc.nextLine();

		System.out.print("üũ�ƿ� ��¥ : ");
		String checkoutDate = sc.nextLine();
		try {
			rs.diffOfDate(checkinDate, checkoutDate);

			System.out.print("������ �ο��� : ");
			int totalpeopleNum = Integer.parseInt(sc.nextLine());

			System.out.print("������ ���ȣ : ");
			int roomNo = Integer.parseInt(sc.nextLine());

			Reservation reser = new Reservation(0, null, user.getUserNo(), checkinDate, checkoutDate, totalpeopleNum, 0,
					roomNo);

			RoomsController.searchByRoomNo(roomNo);
			RsrvtController.insertReservation(reser, roomNo);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}// end of printInputReser()

	/**
	 * �����ϱ�
	 */
	public static void printInputPay(User user) {

		System.out.print("�����ȣ : ");
		int reserNo = Integer.parseInt(sc.nextLine());
		

		if(RsrvtController.hasReserNo(user, reserNo)) {
			System.out.print("��й�ȣ: ");
			String pwd = sc.nextLine();
			
			if (user.getPw().equals(pwd)) {
				Pay pay = new Pay(0, null, reserNo);
				PayController.insertPay(pay);
			} else {
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �õ��� �ּ���.");
			}
		}
		

	}// end of printInputPay()

	/**
	 * �������
	 */
	public static void printInputWishDelete() {

		System.out.print("���ɹ�ȣ : ");
		int wishNo = Integer.parseInt(sc.nextLine());

		WishController.wishDelete(wishNo);

	}// end of method

	/**
	 * �������
	 */
	public static void printInputReserDelete(User user) {

		System.out.print("�����ȣ : ");
		int reserNo = Integer.parseInt(sc.nextLine());

		System.out.print("��й�ȣ: ");
		String pwd = sc.nextLine();

		if (user.getPw().equals(pwd)) {
			RsrvtController.reservationDelete(reserNo);
		} else {
			System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �õ��� �ּ���.");
		}

	}// end of method

} // MenuView Ŭ���� ��.