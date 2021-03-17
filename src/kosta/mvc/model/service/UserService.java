package kosta.mvc.model.service;

import java.sql.SQLException;

import kosta.mvc.exception.DuplicatedException;
import kosta.mvc.exception.NotFoundException;
import kosta.mvc.model.dto.User;

public interface UserService {
	/**
	 * 회원등록
	 * 회원가입 페이지에서 회원등록 정보를 User dto에 담아서, UserDAO로 전달.
	 * @param User dto
	 * @return void
	 * */
	public void inputUser(User dto) throws SQLException, DuplicatedException;
	
	/**
	 * 회원탈퇴
	 * 메인페이지에서 로그인 한 뒤, 로그인한 정보를 User dto에 담고, UserDAO로 전달.
	 * @param User dto
	 * @return void
	 * */
	public void deleteUser(User dto) throws SQLException;
	
	/**
	 * 로그인
	 * 메인 페이지에서, 유저의 ID와, PW를 입력받고, 해당정보를 UserDAO로 전달.
	 * @param String userId, String userPwd
	 * @return User user
	 * */
	public User login(String userId, String userPwd) throws NotFoundException, SQLException;
	
}