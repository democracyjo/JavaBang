package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.User;
import kosta.mvc.model.dto.Wish;
import kosta.mvc.model.service.WishService;
import kosta.mvc.model.service.WishServiceImpl;
import kosta.mvc.view.FailView;
import kosta.mvc.view.SuccessView;

public class WishController{
	private  static WishService wishService = new WishServiceImpl();
	
	public static void insertWish(Wish wish)  {
		try {
			wishService.insertWish(wish);
			SuccessView.messagePrint("관심리스트에 등록되었습니다.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	public static void insertWish(User user, int roomNo)  {
		try {
			wishService.insertWish(new Wish(0, user.getUserNo(), roomNo, null));
			SuccessView.messagePrint("관심리스트에 등록되었습니다.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}

	public static void wishDelete(int wishNo) {
		try {
			wishService.wishDelete(wishNo);
			SuccessView.messagePrint("관심리스트의 "+wishNo+"번이 삭제되었습니다.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}

	public static void selectWishByUserId(String userId) {
		try {
			List<Wish> wishList = wishService.selectWishByUserId(userId);
			SuccessView.selectWishByUserIdPrint(wishList);
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		
		}
		
	}//end of method
	
	public static void selectWishList() {
		try {
			List<Wish> wishList = wishService.selectWishList();
			SuccessView.selectWishByUserIdPrint(wishList);
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
			
		}
		
	}//end of method

}//end of class
