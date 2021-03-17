package kosta.mvc.model.dao;

import java.sql.SQLException; 
import kosta.mvc.model.dto.User;

public interface UserDAO {
	/**
	 * 회원등록
	 * 회원가입 페이지에서 입력받은 User에 대한, 정보를 UserDAOImpl로 전달.
	 * @param User user 
	 * @return int result
	 * */
	public int insertUser(User user) throws SQLException;
	
	/**
	 * 회원등록시 ID중복 체크
	 * 회원등록에서, 입력받은 유저에 대한 정보중, 이미 가입된 Id가 있으면, 예외를 발생시킨다.
	 * @param String userId
	 * @return boolean result
	 * */
	public boolean duplicateByUser(String userId) throws SQLException;
	
	/**
	 * 회원탈퇴
	 * 로그인 후 보이는 페이지에서, 해당 계정의 비밀번호를 입력받으면, 회원탈퇴된다.
	 * 탈퇴 시 비밀번호가 일치하지 않으면, 계정은 삭제되지 않는다. 
	 * @param User dto
	 * @return int result
	 * */
	int deleteUser(User dto) throws SQLException;
	
	/**
	 * 로그인
	 * 메인 페이지에서, 유저의 ID와, PW를 입력받고, 해당정보가 일치하면 로그인 된다.
	 * @param String userId, String userPwd
	 * @return User user
	 * */
	public User login(String userId, String userPwd) throws SQLException;
}