package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Review;

public interface ReviewService {

	/**
	 * �ۼ��� ���� ����
	 */
	List<Review> selectReviewByUserNo(int userNo) throws SQLException;
	
	/**
	 * ���� ���
	 */
	void insertReview(Review review) throws SQLException;
	
	/**
	 * ���� ����
	 */
	void updateReview(Review review) throws SQLException;
	
	/**
	 * ���� ����
	 */
	void deleteReview(int userNo) throws SQLException;
	


}