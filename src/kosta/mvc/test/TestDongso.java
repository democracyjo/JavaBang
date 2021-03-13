package kosta.mvc.test;

import java.sql.SQLException;
import java.util.Scanner;
import kosta.mvc.controller.UserController;
import kosta.mvc.model.dto.User;

public class TestDongso {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		while(true) {
			printMenu();
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				// 로그인
//				login();
				break;
			case 2:
				// 회원가입
				printJoin();
				break;

			case 9:
				System.exit(0);
			}
			
		}
	
	} // main끝.
	
	// 메뉴 뷰
	public static void printMenu() {
		System.out.println("=== JavaBang 숙박업체 ===");
		System.out.println("1. 로그인   |   2. 회원가입   |  3. 종료");
	}
	
	// 조인 뷰
	public static void printJoin() {
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
		
		// controller
		try {
			UserController.inputUser(dto);
			System.out.println("등록이 완료되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}