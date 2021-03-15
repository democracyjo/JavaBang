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
				//���� �ۼ��ϱ�
				writeReview();
				break;
				
			case 2:
				//���� �����ϱ�
				modifyReview();
				break;
				
			case 3:
				//���� �����ϱ�
				deleteReveiew();
				break;
			case 4:
				//����
				System.out.println("=== ������� �����մϴ� ===");
				System.exit(0);
			}
		}
	
	}

	public static void writeReview() {
		System.out.println("************���� �ۼ�************");

		
		System.out.print("����� ��ȣ  : ");
		int userNo = Integer.parseInt(sc.nextLine());

		System.out.print("�� ��ȣ : ");
		int roomNo = Integer.parseInt(sc.nextLine());

		System.out.print("���� : ");
		int score = Integer.parseInt(sc.nextLine());

		System.out.print("���� : ");
		String reviewContent = sc.nextLine();
		
		System.out.print("����� : ");
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
				
		System.out.println("������ ���� ��ȣ : ");
		int reviewNo = Integer.parseInt(sc.nextLine());
		
		System.out.println("������ ���� ���� : ");
		String reviewContent= sc.nextLine();
		
		Review review = new Review(reviewNo, 0, 0, 0, reviewContent, null);
				
		ReviewController.updateReview(review);
	}

	private static void deleteReveiew() {

		System.out.println("������ ���� ��ȣ : ");
		int reviewNo = Integer.parseInt(sc.nextLine());
		
		ReviewController.deleteReview(reviewNo);
	}

	

	private static void reviewMenu() {
		System.out.println("===== JavaBang Hotel=====");
		System.out.println("===���� �Խ���===");
		System.out.println("1. ���� �ۼ� | 2. ���� ���� | 3. ���� ���� | 4. ���� ");
	}
	
	
}
