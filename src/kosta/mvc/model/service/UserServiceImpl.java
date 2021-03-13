package kosta.mvc.model.service;

import java.sql.SQLException;

import kosta.mvc.model.dao.UserDAO;
import kosta.mvc.model.dao.UserDAOImpl;
import kosta.mvc.model.dto.User;

public class UserServiceImpl implements UserService{
	private UserDAO userDAO = new UserDAOImpl();
	
	@Override
	public void inputUser(User dto) throws SQLException {
		int result = userDAO.insertUser(dto);
		if(result == 0) throw new SQLException("등록되지 않았습니다.");
	}
}