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
	 * 성공했을 때 메시지 출력
	 * */
	public static void messagePrint(String message) {
		System.out.println(message);
	}
	/**
	 * 관심리스트 출력
	 * @param wishList
	 */
	public static void selectWishByUserIdPrint(List<Wish> wishList) {
		
		System.out.println("========= 관심리스트["+wishList.size()+"]=========");
		for(Wish wish : wishList) {
			System.out.println(wish);
		}
		System.out.println();
	}
	/**
	 * 
	 * 예약리스트 출력
	 */
	public static void selectRsrvtByUserId(List<Reservation> reserList) {
		System.out.println("========= 예약리스트["+reserList.size()+"]=========");
		for(Reservation reserv : reserList) {
			System.out.println(reserv);
		}
		System.out.println();
	}
	/**
	 * 결제 리스트 출력
	 * 
	 */
	public static void selectPayByUserIdPrint(List<Pay> payList) {
		System.out.println("========= 결제리스트["+payList.size()+"]=========");
		for(Pay pay : payList) {
			System.out.println(pay);
		}
		System.out.println();
	}
	/**
	 * 리뷰 리스트 출력
	 * 
	 */
	public static void selectReviewPrint(List<Review> reviewList) {
		System.out.println("========= 리뷰리스트["+reviewList.size()+"]=========");
		for(Review review : reviewList) {
			System.out.println(review);
		}
		System.out.println();
	}
	

	/**
	 * 방리스트 출력
	 * 
	 */
	public static void printRoomList(List<Room> roomList) {
		System.out.println("========= 방리스트["+roomList.size()+"]=========");
		for(Room room : roomList) {
			System.out.println(room);
		}
		System.out.println();
	}
	/**
	 * 방 종류 리스트 출력
	 * 
	 */
	public static void printRoomTypeList(List<String> list) {
		System.out.println("========= 방종류 리스트["+list.size()+"]=========");
		list.sort(null);
		for(String rm:list) {
			System.out.println(rm);
		}
		
	}
}