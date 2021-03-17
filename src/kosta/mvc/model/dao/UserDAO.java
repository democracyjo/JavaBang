package kosta.mvc.model.dao;

import java.sql.SQLException; 
import kosta.mvc.model.dto.User;

public interface UserDAO {
	/**
	 * ȸ�����
	 * ȸ������ ���������� �Է¹��� User�� ����, ������ UserDAOImpl�� ����.
	 * @param User user 
	 * @return int result
	 * */
	public int insertUser(User user) throws SQLException;
	
	/**
	 * ȸ����Ͻ� ID�ߺ� üũ
	 * ȸ����Ͽ���, �Է¹��� ������ ���� ������, �̹� ���Ե� Id�� ������, ���ܸ� �߻���Ų��.
	 * @param String userId
	 * @return boolean result
	 * */
	public boolean duplicateByUser(String userId) throws SQLException;
	
	/**
	 * ȸ��Ż��
	 * �α��� �� ���̴� ����������, �ش� ������ ��й�ȣ�� �Է¹�����, ȸ��Ż��ȴ�.
	 * Ż�� �� ��й�ȣ�� ��ġ���� ������, ������ �������� �ʴ´�. 
	 * @param User dto
	 * @return int result
	 * */
	int deleteUser(User dto) throws SQLException;
	
	/**
	 * �α���
	 * ���� ����������, ������ ID��, PW�� �Է¹ް�, �ش������� ��ġ�ϸ� �α��� �ȴ�.
	 * @param String userId, String userPwd
	 * @return User user
	 * */
	public User login(String userId, String userPwd) throws SQLException;
}