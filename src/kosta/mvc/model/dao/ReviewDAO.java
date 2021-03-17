package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Review;

public interface ReviewDAO {

	
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
	 * @return
	 * @throws SQLException
	 */
	int insertReview(Review review) throws SQLException;
	
	
	
	/**
	 * ���� ����
	 * @param reviewNo
	 * @return
	 * @throws SQLException
	 */
	int deleteReview(int reviewNo) throws SQLException;


	/**
	 * ���� �����ϱ�
	 * @param review
	 * @return
	 * @throws SQLException
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
