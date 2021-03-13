package kosta.mvc.test;

import java.util.Scanner;
import kosta.mvc.controller.UserController;
import kosta.mvc.model.dto.User;

public class TestDongso {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			printMenu();
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				// �α���
				printLogin();
				break;

			case 2:
				// ȸ������
				printJoin();
				break;

			case 3:
				// ����
				System.out.println("=== JavaBang ���ھ�ü�� �������� �湮���ּ���^^ ===");
				System.exit(0);
			}
		} // while�� ��.
	} // main��.
/////////////////////////////////////////////////////////////////////
	// �޴� ��
	public static void printMenu() {
		System.out.println("=== JavaBang ���ھ�ü ===");
		System.out.println("1. �α���   |   2. ȸ������   |  3. ����");
	}

	// �α��� ��
	public static void printLogin() {
		System.out.print("���̵� : ");
		String userId = sc.nextLine();

		System.out.print("��й�ȣ : ");
		String userPwd = sc.nextLine();
		
		UserController.login(userId, userPwd);
	}
	
	// ȸ������ ��
	public static void printJoin() {
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

		// controller
		UserController.inputUser(dto);
	} // printJoin() �޼ҵ� ��.

	// �����޴� ��
	public static void printUserMenu(String userId) {
		System.out.println("-----" + userId + " �α��� �� -----");
		System.out.println("1. �˻�   |   2. ����������   |  3. �α׾ƿ�");
		int menu = Integer.parseInt(sc.nextLine());
		switch (menu) {
		case 1:
			
			break;
		case 2:

			break;
		case 3:
			// �α׾ƿ�.
			return; 
		}
	}
}