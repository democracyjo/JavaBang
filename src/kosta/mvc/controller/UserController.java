package kosta.mvc.controller;
import java.sql.SQLException;
import kosta.mvc.exception.DuplicatedException;
import kosta.mvc.model.dto.User;
import kosta.mvc.model.service.UserService;
import kosta.mvc.model.service.UserServiceImpl;
import kosta.mvc.test.TestDongso;
import kosta.mvc.view.FailView;
import kosta.mvc.view.MenuView;
import kosta.mvc.view.SuccessView;

public class UserController {
	private static UserService userService = new UserServiceImpl();
	
	/**
	 * 회원등록
	 */
	public static void inputUser(User dto) {
		try {
			userService.inputUser(dto);
			SuccessView.printMessage(dto.getId() + "님 회원가입을 축하드립니다.\n");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		} catch (DuplicatedException e) {
			FailView.errorMessage(e.getMessage());
			TestDongso.printJoin();
		}
	}
	
	/**
	 * 회원정보수정
	 * */
	public static void updateUser() {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * 회원탈퇴
	 * */
	public static void deleteUser(User dto) {
		try {
			userService.deleteUser(dto);
			SuccessView.printMessage("그 동안 JavaBang HOTEL을 이용해 주셔서 감사합니다.\n");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			TestDongso.printUserMenu(dto.getId());
		}
	}
	
	/**
	 * 로그인
	 */
	public static void login(String userId, String userPwd) {	
		try {
			User user = userService.login(userId, userPwd);
			TestDongso.printUserMenu(userId);
			//MenuView.menu();
		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}