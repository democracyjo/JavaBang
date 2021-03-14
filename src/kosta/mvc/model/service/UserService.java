package kosta.mvc.model.service;

import java.sql.SQLException;

import kosta.mvc.exception.DuplicatedException;
import kosta.mvc.exception.NotFoundException;
import kosta.mvc.model.dto.User;

public interface UserService {
	/**
	 * 회원등록
	 * */
	public void inputUser(User dto) throws SQLException, DuplicatedException;
	
	/**
	 * 회원정보수정
	 * */
//	public void
	
	/**
	 * 회원탈퇴
	 * */
	public void deleteUser(User dto) throws SQLException;
	
	/**
	 * 로그인
	 * */
	public User login(String userId, String userPwd) throws NotFoundException, SQLException;
	
}