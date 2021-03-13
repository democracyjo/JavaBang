package kosta.mvc.view;

import java.util.Scanner;

import kosta.mvc.controller.UserController;

public class MenuView {
	private static Scanner sc = new Scanner(System.in);
	
	public static void menu() {
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
				break;

			case 3:
				// ����
				System.exit(0);
			}
		} // while�� ��.
	} // menu() �޼ҵ� ��.

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