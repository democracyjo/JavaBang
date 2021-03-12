package kosta.mvc.test;

import java.sql.SQLException;
import java.util.Scanner;

import kosta.mvc.controller.UserController;
import kosta.mvc.model.dto.User;

public class TestDongso {
	public static void main(String[] args) {
		// main
		Scanner sc = new Scanner(System.in);
		
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