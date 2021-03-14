package kosta.mvc.model.service;

import java.sql.SQLException;

import kosta.mvc.exception.NotFoundException;
import kosta.mvc.model.dto.User;

public interface UserService {
	/**
	 * ȸ�����
	 * */
	public void inputUser(User dto) throws SQLException;
	
	/**
	 * �α���
	 * */
	public User login(String userId, String userPwd) throws NotFoundException, SQLException;
	

}