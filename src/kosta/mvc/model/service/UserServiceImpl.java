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
			if(result == 0) throw new SQLException("회원가입에 실패했습니다.\n");
		} else {
			throw new DuplicatedException(dto.getId() + "는 이미 가입된 아이디입니다. ID를 다시 입력해주세요.\n");
		}	
	}
	
	@Override
	public void deleteUser(User dto) throws SQLException {
		int result = userDAO.deleteUser(dto);
		if(result == 0) {
			throw new SQLException("패스워드가 일치하지 않습니다.\n");
		}
	}
	
	@Override
	public User login(String userId, String userPwd) throws NotFoundException, SQLException{
		User user = userDAO.login(userId, userPwd);
		if(user == null) {
			throw new NotFoundException("정보를 다시 확인해주세요.\n");
		}
		
		// 로그인 된 정보 저장하기
		Session session = new Session(userId);
	
		return user;
	}
}