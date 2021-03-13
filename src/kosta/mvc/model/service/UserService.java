package kosta.mvc.model.service;

import java.sql.SQLException;

import kosta.mvc.model.dto.User;

public interface UserService {
	/**
	 * 회원등록
	 * */
	public void inputUser(User dto) throws SQLException;
}