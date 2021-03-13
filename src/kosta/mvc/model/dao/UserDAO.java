package kosta.mvc.model.dao;

import java.sql.SQLException; 
import kosta.mvc.model.dto.User;

public interface UserDAO {
	/**
	 * 회원등록
	 * */
	public int insertUser(User user) throws SQLException;
	
	/**
	 * 로그인
	 * */
	public User login(String userId, String userPwd) throws SQLException;
	
}