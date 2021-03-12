package kosta.mvc.model.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import kosta.mvc.model.dto.User;
import kosta.mvc.util.DbUtil;

public class UserDAOImpl implements UserDAO {
private Properties JavaBang = DbUtil.getProFile();
	
	/**
	 * 회원입력
	 * */
	@Override
	public int insertUser(User user) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = JavaBang.getProperty("user.insert");
		int result = 0;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getId());
			ps.setString(3, user.getPw());
			ps.setString(4, user.getSsn());
			ps.setString(5, user.getTel());
			result = ps.executeUpdate();
			
		} finally {
			DbUtil.close(con, ps);
		}

		return result;
	}
}
