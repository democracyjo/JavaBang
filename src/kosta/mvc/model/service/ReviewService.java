package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Review;

public interface ReviewService {

	/**
	 * �溰 ���� ����
	 * @param roomNo
	 * @return List<Review>
	 * @throws SQLException
	 */
	List<Review> selectReviewByRoomNo(int roomNo) throws SQLException;
	/**
	 * �ۼ��� ���� ����
	 * @param userNo
	 * @return List<Review>
	 * @throws SQLException
	 */
	List<Review> selectReviewByUserNo(int userNo) throws SQLException;
	
	/**
	 * ���� ���
	 * @param review
	 * @throws SQLException
	 */
	void insertReview(Review review) throws SQLException;
	
	/**
	 * ���� ����
	 * @param review
	 * @throws SQLException
	 */
	void updateReview(Review review) throws SQLException;	
	
	/**
	 * ���� ����
	 * @param reviewNo
	 * @throws SQLException
	 */
	void deleteReview(int reviewNo) throws SQLException;
	
//	double getAvgP(int roomNo) throws SQLException;
	
	


}
