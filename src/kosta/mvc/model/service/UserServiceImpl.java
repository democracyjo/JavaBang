package kosta.mvc.model.service;

import java.sql.SQLException; 

import kosta.mvc.exception.DuplicatedException;
import kosta.mvc.exception.NotFoundException;
import kosta.mvc.model.dao.UserDAO;
import kosta.mvc.model.dao.UserDAOImpl;
import kosta.mvc.model.dto.User;
import kosta.mvc.session.Session;

public class UserServiceImpl implements UserService{
	private UserDAO userDAO = new UserDAOImpl();
	
	@Override
	public void inputUser(User dto) throws SQLException, DuplicatedException {
		if(!userDAO.duplicateByUser(dto.getId())) {
			int result = userDAO.insertUser(dto);
			if(result == 0) throw new SQLException("ȸ�����Կ� �����߽��ϴ�.\n");
		} else {
			throw new DuplicatedException(dto.getId() + "�� �̹� ���Ե� ���̵��Դϴ�. ID�� �ٽ� �Է����ּ���.\n");
		}	
	}
	
	@Override
	public void deleteUser(User dto) throws SQLException {
		int result = userDAO.deleteUser(dto);
		if(result == 0) {
			throw new SQLException("�н����尡 ��ġ���� �ʽ��ϴ�.\n");
		}
	}
	
	@Override
	public User login(String userId, String userPwd) throws NotFoundException, SQLException{
		User user = userDAO.login(userId, userPwd);
		if(user == null) {
			throw new NotFoundException("������ �ٽ� Ȯ�����ּ���.\n");
		}
		
		// �α��� �� ���� �����ϱ�
		Session session = new Session(userId);
	
		return user;
	}
}