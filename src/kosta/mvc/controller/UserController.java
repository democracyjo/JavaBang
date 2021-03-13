package kosta.mvc.controller;

import java.sql.SQLException; 

import kosta.mvc.model.dto.User;
import kosta.mvc.model.service.UserService;
import kosta.mvc.model.service.UserServiceImpl;

public class UserController {
	private static UserService userService = new UserServiceImpl();

	/**
	 * ȸ�����
	 */
	public static void inputUser(User dto) throws SQLException {
		userService.inputUser(dto);
		/*
		try {
			userService.inputUser(dto);
			SuccessView.printMessage("����� �Ϸ�Ǿ����ϴ�.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
		*/
	}
}