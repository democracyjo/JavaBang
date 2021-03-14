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
	 * 방별 리뷰 보기
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
	 * 작성한 리뷰 보기
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
	 * 리뷰 등록하기
	 */
	public static void insertReview(Review review) {
		try {
			reviewService.insertReview(review);
			SuccessView.messagePrint("리뷰 등록되었습니다.");
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 리뷰 수정하기
	 */
	public static void updateReview(Review review) {
		try {
			reviewService.updateReview(review);
			SuccessView.messagePrint("리뷰가 수정되었습니다.");
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 리뷰 삭제하기
	 */
	public static void deleteReview(int userNo) {
		try {
			reviewService.deleteReview(userNo);
			SuccessView.messagePrint("리뷰가 삭제되었습니다.");
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	
}
