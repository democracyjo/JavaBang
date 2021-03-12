package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Review;

public interface ReviewDAO {

	/**
	 * �ۼ��� ���� ����
	 */
	List<Review> selectReviewByUserNo(int userNo) throws SQLException;
	
	/**
	 * ���� ���
	 */
	int insertReview(Review review) throws SQLException;
	
	/**
	 * ���� ����
	 */
	 int updateReview(Review review) throws SQLException;
	
	/**
	 * ���� ����
	 */
	int deleteReview(int userNo) throws SQLException;
	


}
