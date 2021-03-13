package kosta.mvc.view;

import java.util.List;

import kosta.mvc.model.dto.Pay;
import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.dto.Wish;

public class SuccessView {

	/**
	 * �������� �� �޽��� ���
	 * */
	public static void messagePrint(String message) {
		System.out.println(message);
	}

	public static void selectWishByUserIdPrint(List<Wish> wishList) {
		
		System.out.println("========= ���ɸ���Ʈ["+wishList.size()+"]=========");
		for(Wish wish : wishList) {
			System.out.println(wish);
		}
		System.out.println();
	}

	public static void selectRsrvtByUserId(List<Reservation> reserList) {
		System.out.println("========= ���ฮ��Ʈ["+reserList.size()+"]=========");
		for(Reservation reserv : reserList) {
			System.out.println(reserv);
		}
		System.out.println();
	}

	public static void selectPayByUserIdPrint(List<Pay> payList) {
		System.out.println("========= ��������Ʈ["+payList.size()+"]=========");
		for(Pay pay : payList) {
			System.out.println(pay);
		}
		System.out.println();
	}

}








