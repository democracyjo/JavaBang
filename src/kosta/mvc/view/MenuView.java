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

//////////////////////////////////////////////////////////////////////////////////////////////
	// �α��ν� �޴�
	public static void printUserMenu(String userId) {
		while (true) {
			System.out.println("\n-----" + userId + " �α��� �� -----");
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
				printSelectmenu(userId);
				break;
			case 2:
				// ����������

				break;
			case 3:
				// �α׾ƿ�
				logout(userId);
				return;
			case 4:
				// ȸ��Ż��
				printDelete(userId);
				return;
			}
		}
	}

	// �α׾ƿ�
	public static void logout(String userId) {
		Session session = new Session(userId);

		SessionSet ss = SessionSet.getInstance();
		ss.remove(session);
	}

	// ȸ��Ż��
	public static void printDelete(String userId) {
		System.out.println(userId + "�� ��й�ȣ�� �ٽ� �Է����ּ���.");
		System.out.print("��й�ȣ : ");
		String pw = sc.nextLine();

		User dto = new User(userId, pw);

		UserController.deleteUser(dto);
	}

///////////////////////////////////////////////////////////////////////////////////////////////////
	private static void printSelectmenu(String userId) {
		System.out.println("\n-----" + userId + " �α��� �� -----");
		System.out.println("��������������������������������");
		System.out.println("  	 1. ��ü�˻�								");
		System.out.println("  	 2. �κ� �˻�					         	");
		System.out.println("��������������������������������");
		System.out.print("����>>");

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
		System.out.println("\n-----" + userId + " �α��� �� -----");
		System.out.println("\n��������������������������������");
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