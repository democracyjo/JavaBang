package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Review;

public class ReviewDAOImpl implements ReviewDAO{

	
	/**
	 * �ڽ��� ���� ����
	 */

	@Override
	public List<Review> selectReviewByUserNo(int userNo) throws SQLException {
		// TODO Auto-generated method stub
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
