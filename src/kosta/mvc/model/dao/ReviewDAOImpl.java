package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.Review;
import kosta.mvc.util.DbUtil;

public class ReviewDAOImpl implements ReviewDAO{
	private Properties proFile = DbUtil.getProFile();
	
	/**
	 * �ڽ��� ���� ����
	 */

	@Override
	public List<Review> selectReviewByUserNo(int userNo) throws SQLException {
		// �ε� ���� ���� �ݱ�
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Review review=null;
		String sql=proFile.getProperty("");
		
		
		
		return null;
	}

	/**
	 * ���� ����ϱ�
	 */
	@Override
	public int insertReview(Review review) throws SQLException {
		return 0;
		// TODO Auto-generated method stub
		
	}

	/**
	 * ���� �����ϱ�
	 */
	@Override
	public int updateReview(Review review) throws SQLException {
		return 0;
		// TODO Auto-generated method stub
		
	}

	/**
	 * ���� �����ϱ�
	 */
	@Override
	public int deleteReview(int userNo) throws SQLException {
		return userNo;
		// TODO Auto-generated method stub
		
	}
	
}
