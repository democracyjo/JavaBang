package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Review;

public interface ReviewDAO {

	
	/**
	 * �溰 ���� ����
	 */
	List<Review> selectReviewByRoomNo(int roomNo) throws SQLException;

	
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
	int deleteReview(int reviewNo) throws SQLException;


	/**
	 * ���� �����ϱ�
	 */
	int updateReview(Review review) throws SQLException;
	/**
	 * ���� �������ϱ�
	 * @param roomNo
	 * @return
	 * @throws SQLException
	 */
	double getAvgP(int roomNo) throws SQLException;

}
