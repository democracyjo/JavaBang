package kosta.mvc.controller;

import java.sql.SQLException;

import kosta.mvc.model.dto.User;
import kosta.mvc.model.service.UserService;
import kosta.mvc.model.service.UserServiceImpl;
import kosta.mvc.view.FailView;
import kosta.mvc.view.MenuView;
import kosta.mvc.view.SuccessView;

public class UserController {
	private static UserService userService = new UserServiceImpl();

	/**
	 * ȸ�����
	 */
	public static void inputUser(User dto) {
		try {
			userService.inputUser(dto);
			SuccessView.printMessage(dto.getId() + "�� ȸ�������� ���ϵ帳�ϴ�.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * �α���
	 */
	public static void login(String userId, String userPwd) {	
		try {
			User user = userService.login(userId, userPwd);
			MenuView.printUserMenu(userId);
			//MenuView.menu();
		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}