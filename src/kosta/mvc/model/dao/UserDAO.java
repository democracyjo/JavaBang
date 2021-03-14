package kosta.mvc.model.dao;

import java.sql.SQLException;

import kosta.mvc.exception.DuplicatedException;
import kosta.mvc.model.dto.User;

public interface UserDAO {
	/**
	 * 회원등록
	 * */
	public int insertUser(User user) throws SQLException;
	
	/**
	 * 회원등록시 ID중복 체크
	 * */
	public boolean duplicateByEmpno(String userId) throws SQLException;
	
	/**
	 * 회원탈퇴
	 * */
	int deleteUser(User dto) throws SQLException;
	
	/**
	 * 로그인
	 * */
	public User login(String userId, String userPwd) throws SQLException;
	
}