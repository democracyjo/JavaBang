package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import kosta.mvc.model.dto.User;
import kosta.mvc.util.DbUtil;

public class UserDAOImpl implements UserDAO {
	private Properties JavaBang = DbUtil.getProFile();

	/**
	 * 회원등록
	 **/
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

	} // insertUser 메소드 끝.

	/**
	 * 로그인
	 */
	@Override
	public User login(String userId, String userPwd) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = JavaBang.getProperty("user.login");
		User user = null;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, userPwd);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
			
		} finally {
			DbUtil.close(con, ps, rs);
		}

		return user;

	} // login 메소드 끝.

} // 클래스 끝.