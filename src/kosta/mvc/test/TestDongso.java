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
				// 로그인
				printLogin();
				break;

			case 2:
				// 회원가입
				printJoin();
				break;

			case 3:
				// 종료
				System.out.println("=== JavaBang HOTEL에 다음에도 방문해주세요. ===");
				System.exit(0);
			}
		} // while문 끝.
	} // main끝.
////////////////////////////////////////////////////////////////////////
	// 메뉴 뷰
	public static void printMenu() {
		System.out.println("=== JavaBang 숙박업체 ===");
		System.out.println("1. 로그인   |   2. 회원가입   |  3. 종료");
	}
	
	// 유저메뉴 뷰
	public static void printUserMenu(String userId) {
		System.out.println("-----" + userId + " 로그인 중 -----");
		System.out.println("1. 검색   |   2. 마이페이지   |  3. 로그아웃  |  4. 회원정보수정  |  5. 회원탈퇴");
		int menu = Integer.parseInt(sc.nextLine());
		switch (menu) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			// 로그아웃.
			return; 
		
		case 4:
			
			break;
		case 5:
			// 회원탈퇴	
			printDelete(userId);
			break;
		} // switch문 끝.
	}
	
	// 로그인 뷰
	public static void printLogin() {
		 System.out.print("아이디 : ");
		 String userId = sc.nextLine();
		 
		 System.out.print("패스워드 : ");
		 String userPwd = sc.nextLine();
		
		UserController.login(userId, userPwd);
	}
	
	// 회원가입 뷰
	public static void printJoin() {
		System.out.println("************회원가입************");
		System.out.print("아이디 : ");
		String id = sc.nextLine();

		System.out.print("패스워드 : ");
		String pw = sc.nextLine();

		System.out.print("이름 : ");
		String name = sc.nextLine();

		System.out.print("주민등록번호 : ");
		String ssn = sc.nextLine();

		System.out.print("전화번호 : ");
		String tel = sc.nextLine();

		User dto = new User(0, name, id, pw, ssn, tel);

		UserController.inputUser(dto);
	} // printJoin() 메소드 끝.
	
	// 회원탈퇴 뷰
	public static void printDelete(String userId) {
		System.out.println("************회원탈퇴************");
		System.out.println(userId + "님 비밀번호를 다시 입력해주세요.");
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		
		User dto = new User(userId, pw);
		
		UserController.deleteUser(dto);
	} // printDelete() 메소드 끝.
}