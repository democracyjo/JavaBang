package kosta.mvc.model.service;

import java.sql.SQLException;

import kosta.mvc.exception.NotFoundException;
import kosta.mvc.model.dao.UserDAO;
import kosta.mvc.model.dao.UserDAOImpl;
import kosta.mvc.model.dto.User;
import kosta.mvc.session.Session;

public class UserServiceImpl implements UserService{
	private UserDAO userDAO = new UserDAOImpl();
	
	@Override
	public void inputUser(User dto) throws SQLException {
		int result = userDAO.insertUser(dto);
		if(result == 0) throw new SQLException("등록되지 않았습니다.");
	}

	@Override
	public User login(String userId, String userPwd) throws NotFoundException, SQLException{
		User user = userDAO.login(userId, userPwd);
		if(user == null) {
			throw new NotFoundException("정보를 다시 확인해주세요.");
		}
		
		// 로그인 된 정보 저장하기
		Session session = new Session(userId);
		
		return user;
	}
}