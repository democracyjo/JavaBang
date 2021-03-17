package kosta.mvc.view;

import java.util.List;

import kosta.mvc.model.dto.Pay;
import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.dto.Review;
import kosta.mvc.model.dto.Room;
import kosta.mvc.model.dto.Wish;

public class SuccessView {
	public static void printMessage(String message) {
		System.out.println(message);
	}
	
	/**
	 * �������� �� �޽��� ���
	 * */
	public static void messagePrint(String message) {
		System.out.println(message);
	}
	/**
	 * ���ɸ���Ʈ ���
	 * @param wishList
	 */
	public static void selectWishByUserIdPrint(List<Wish> wishList) {
		
		System.out.println("========= ���ɸ���Ʈ["+wishList.size()+"]=========");
		for(Wish wish : wishList) {
			System.out.println(wish);
		}
		System.out.println();
	}
	/**
	 * 
	 * ���ฮ��Ʈ ���
	 */
	public static void selectRsrvtByUserId(List<Reservation> reserList) {
		System.out.println("========= ���ฮ��Ʈ["+reserList.size()+"]=========");
		for(Reservation reserv : reserList) {
			System.out.println(reserv);
		}
		System.out.println();
	}
	/**
	 * ���� ����Ʈ ���
	 * 
	 */
	public static void selectPayByUserIdPrint(List<Pay> payList) {
		System.out.println("========= ��������Ʈ["+payList.size()+"]=========");
		for(Pay pay : payList) {
			System.out.println(pay);
		}
		System.out.println();
	}
	/**
	 * ���� ����Ʈ ���
	 * 
	 */
	public static void selectReviewPrint(List<Review> reviewList) {
		System.out.println("========= ���丮��Ʈ["+reviewList.size()+"]=========");
		for(Review review : reviewList) {
			System.out.println(review);
		}
		System.out.println();
	}
	

	/**
	 * �渮��Ʈ ���
	 * 
	 */
	public static void printRoomList(List<Room> roomList) {
		System.out.println("========= �渮��Ʈ["+roomList.size()+"]=========");
		for(Room room : roomList) {
			System.out.println(room);
		}
		System.out.println();
	}
	/**
	 * �� ���� ����Ʈ ���
	 * 
	 */
	public static void printRoomTypeList(List<String> list) {
		System.out.println("========= ������ ����Ʈ["+list.size()+"]=========");
		list.sort(null);
		for(String rm:list) {
			System.out.println(rm);
		}
		
	}
}