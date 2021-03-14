package kosta.mvc.model.dao;

import java.sql.SQLException;

import kosta.mvc.exception.DuplicatedException;
import kosta.mvc.model.dto.User;

public interface UserDAO {
	/**
	 * ȸ�����
	 * */
	public int insertUser(User user) throws SQLException;
	
	/**
	 * ȸ����Ͻ� ID�ߺ� üũ
	 * */
	public boolean duplicateByUser(String userId) throws SQLException;
	
	/**
	 * ȸ������ ����
	 * */
//	public int updateUser
	
	/**
	 * ȸ��Ż��
	 * */
	int deleteUser(User dto) throws SQLException;
	
	/**
	 * �α���
	 * */
	public User login(String userId, String userPwd) throws SQLException;
	
}