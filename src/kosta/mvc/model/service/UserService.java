package kosta.mvc.model.service;

import java.sql.SQLException;

import kosta.mvc.exception.DuplicatedException;
import kosta.mvc.exception.NotFoundException;
import kosta.mvc.model.dto.User;

public interface UserService {
	/**
	 * ȸ�����
	 * ȸ������ ���������� ȸ����� ������ User dto�� ��Ƽ�, UserDAO�� ����.
	 * @param User dto
	 * @return void
	 * */
	public void inputUser(User dto) throws SQLException, DuplicatedException;
	
	/**
	 * ȸ��Ż��
	 * �������������� �α��� �� ��, �α����� ������ User dto�� ���, UserDAO�� ����.
	 * @param User dto
	 * @return void
	 * */
	public void deleteUser(User dto) throws SQLException;
	
	/**
	 * �α���
	 * ���� ����������, ������ ID��, PW�� �Է¹ް�, �ش������� UserDAO�� ����.
	 * @param String userId, String userPwd
	 * @return User user
	 * */
	public User login(String userId, String userPwd) throws NotFoundException, SQLException;
	
}