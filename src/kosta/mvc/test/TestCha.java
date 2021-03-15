package kosta.mvc.test;

import java.sql.SQLException;
import java.util.Scanner;

import com.sun.tools.javac.util.List;

import kosta.mvc.controller.ReviewController;
import kosta.mvc.model.dao.ReviewDAO;
import kosta.mvc.model.dao.ReviewDAOImpl;
import kosta.mvc.model.dto.Review;
import kosta.mvc.view.FailView;


public class TestCha {
	static Scanner sc = new Scanner(System.in);
	static ReviewDAO reviewDAO = new ReviewDAOImpl();
	
	public static void main(String[] args) {
		while(true) {
			reviewMenu();
			int menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1:
				//리뷰 작성하기
				writeReview();
				break;
				
			case 2:
				//리뷰 수정하기
				modifyReview();
				break;
				
			case 3:
				//리뷰 삭제하기
				deleteReveiew();
				break;
			case 4:
				//종료
				System.out.println("=== 리뷰관리 종료합니다 ===");
				System.exit(0);
			}
		}
	
	}

	public static void writeReview() {
		System.out.println("************리뷰 작성************");

		
		System.out.print("사용자 번호  : ");
		int userNo = Integer.parseInt(sc.nextLine());

		System.out.print("방 번호 : ");
		int roomNo = Integer.parseInt(sc.nextLine());

		System.out.print("별점 : ");
		int score = Integer.parseInt(sc.nextLine());

		System.out.print("내용 : ");
		String reviewContent = sc.nextLine();
		
		System.out.print("등록일 : ");
		String reviewDate ;
		
		
		Review review = new Review(0, userNo, roomNo, score, reviewContent, null);
		
		ReviewController.insertReview(review);
		
//		try {
//			Review review = reviewDAO.selectReviewByUserNo(userNo);
//			ReviewController.insertReview(review);
//		}catch(SQLException e) {
//			FailView.errorMessage(e.getMessage());
//		}finally {
//			writeReview();
//		}
	}
	
	private static void modifyReview() {
				
		System.out.println("수정할 리뷰 번호 : ");
		int reviewNo = Integer.parseInt(sc.nextLine());
		
		System.out.println("수정할 리뷰 내용 : ");
		String reviewContent= sc.nextLine();
		
		Review review = new Review(reviewNo, 0, 0, 0, reviewContent, null);
				
		ReviewController.updateReview(review);
	}

	private static void deleteReveiew() {

		System.out.println("삭제할 리뷰 번호 : ");
		int reviewNo = Integer.parseInt(sc.nextLine());
		
		ReviewController.deleteReview(reviewNo);
	}

	

	private static void reviewMenu() {
		System.out.println("===== JavaBang Hotel=====");
		System.out.println("===리뷰 게시판===");
		System.out.println("1. 리뷰 작성 | 2. 리뷰 수정 | 3. 리뷰 삭제 | 4. 종료 ");
	}
	
	
}
