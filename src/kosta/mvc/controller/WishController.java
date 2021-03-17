package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.User;
import kosta.mvc.model.dto.Wish;
import kosta.mvc.model.service.WishService;
import kosta.mvc.model.service.WishServiceImpl;
import kosta.mvc.view.FailView;
import kosta.mvc.view.SuccessView;
/**
 * WishController
 * 예외처리
 * */
public class WishController{
	private  static WishService wishService = new WishServiceImpl();
	
	/**
	 * 관심리스트 등록
	 * : 관심있는 방번호를 입력하여 관심리스트에 추가하기.
	 * @param User user, int roomNo
	 * */
	public static void insertWish(User user, int roomNo)  {
		try {
			if(!wishService.hasRoomNo(user, roomNo)) {
				Wish wish =  new Wish(0, user.getUserNo(), roomNo, null);
				wishService.insertWish(wish);
				SuccessView.messagePrint("관심리스트에 등록되었습니다.");
			}
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}

	/**
	 * 관심리스트 삭제
	 * : 해당 관심번호를 입력하여 관심리스트에서 삭제
	 * @param int wishNo
	 * */
	public static void wishDelete(int wishNo) {
		try {
			wishService.wishDelete(wishNo);
			SuccessView.messagePrint("관심리스트의 관심번호[ "+wishNo+"]가 삭제되었습니다.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}

	/**
	 * UserId로 관심리스트 검색
	 * @param String userId
	 * */
	public static void selectWishByUserId(String userId) {
		try {
			List<Wish> wishList = wishService.selectWishByUserId(userId);
			SuccessView.selectWishByUserIdPrint(wishList);
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		
		}
		
	}//end of method
	
	/**
	 * 전체 관심리스트 검색 -- 관리자용
	 * 모든 회원의 관심리스트 검색하기
	 * */
	public static void selectWishList() {
		try {
			List<Wish> wishList = wishService.selectWishList();
			SuccessView.selectWishByUserIdPrint(wishList);
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
			
		}
		
	}//end of method


}//end of class
