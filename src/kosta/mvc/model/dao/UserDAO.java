package kosta.mvc.model.dao;

import java.sql.SQLException; 
import kosta.mvc.model.dto.User;

public interface UserDAO {
	/**
	 * ȸ�����
	 * */
	public int insertUser(User user) throws SQLException;
}