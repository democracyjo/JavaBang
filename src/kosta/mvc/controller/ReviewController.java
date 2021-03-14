package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;
import kosta.mvc.model.dto.Review;
import kosta.mvc.model.service.ReviewService;
import kosta.mvc.model.service.ReviewServiceImpl;
import kosta.mvc.view.FailView;
import kosta.mvc.view.SuccessView;


public interface ReviewController {
	static ReviewService reviewService = new ReviewServiceImpl();
	
	/**
	 * �溰 ���� ����
	 */
	public static void selectReviewByRoomNo(int roomNo) {
		try {
			List<Review> review = reviewService.selectReviewByRoomNo(roomNo);
			SuccessView.selectReviewByRoomNoPrint(review);
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * �ۼ��� ���� ����
	 */
	public static void selectReviewByUserNo(int userNo) {
		try {
			List<Review> review = reviewService.selectReviewByUserNo(userNo);
			SuccessView.selectReviewByUserNoPrint(review);
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * ���� ����ϱ�
	 */
	public static void insertReview(Review review) {
		try {
			reviewService.insertReview(review);
			SuccessView.messagePrint("���� ��ϵǾ����ϴ�.");
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * ���� �����ϱ�
	 */
	public static void updateReview(Review review) {
		try {
			reviewService.updateReview(review);
			SuccessView.messagePrint("���䰡 �����Ǿ����ϴ�.");
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * ���� �����ϱ�
	 */
	public static void deleteReview(int userNo) {
		try {
			reviewService.deleteReview(userNo);
			SuccessView.messagePrint("���䰡 �����Ǿ����ϴ�.");
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	
}
