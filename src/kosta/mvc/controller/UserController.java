package kosta.mvc.controller;

import java.sql.SQLException;

import kosta.mvc.model.dto.User;

public interface UserController {
	/**
	 * 회원추가하기
	 * */
	void insertUser(User dto) throws SQLException;
	
	
}
