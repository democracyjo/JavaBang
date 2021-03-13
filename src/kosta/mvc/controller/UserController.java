package kosta.mvc.controller;

import java.sql.SQLException;

import kosta.mvc.exception.NotFoundException;
import kosta.mvc.model.dto.User;
import kosta.mvc.model.service.UserService;
import kosta.mvc.model.service.UserServiceImpl;
import kosta.mvc.view.MenuView;

public class UserController {
	private static UserService userService = new UserServiceImpl();

	/**
	 * 회원등록
	 */
	public static void inputUser(User dto) throws SQLException {
		userService.inputUser(dto);
		/*
		 * try { userService.inputUser(dto); SuccessView.printMessage("등록이 완료되었습니다."); }
		 * catch (SQLException e) { FailView.errorMessage(e.getMessage()); }
		 */
	}
	
	/**
	 * 로그인
	 */
	public static void login(String userId, String userPwd) {
		try {
			MenuView.printUserMenu(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}