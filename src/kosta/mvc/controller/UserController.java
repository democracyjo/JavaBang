package kosta.mvc.controller;

import java.sql.SQLException;

import kosta.mvc.model.dto.User;

public interface UserController {
	/**
	 * ȸ���߰��ϱ�
	 * */
	void insertUser(User dto) throws SQLException;
	
	
}
