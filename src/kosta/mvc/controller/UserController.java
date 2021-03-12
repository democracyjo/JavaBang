package kosta.mvc.controller;

import java.sql.SQLException;

import kosta.mvc.model.dto.User;
import kosta.mvc.model.service.UserService; 
import kosta.mvc.model.service.UserServiceImpl;

public class UserController {
	private static UserService userService = new UserServiceImpl();
	
	/**
	 * 회원등록
	 * */
	public static void inputUser(User dto) {
		try {
			userService.inputUser(dto);
		} catch (SQLException e) {
			e.getMessage();
		}
	}
}