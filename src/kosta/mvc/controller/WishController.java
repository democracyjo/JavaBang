package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.WishDAO;
import kosta.mvc.model.dao.WishDAOImpl;
import kosta.mvc.model.dto.Pay;
import kosta.mvc.model.dto.User;
import kosta.mvc.model.dto.Wish;
import kosta.mvc.model.service.WishService;
import kosta.mvc.model.service.WishServiceImpl;
import kosta.mvc.view.FailView;
import kosta.mvc.view.SuccessView;

public class WishController{
	private  static WishService wishService = new WishServiceImpl();
	private static WishDAO wishDAO = new WishDAOImpl();
	
	public static void insertWish(Wish wish)  {
		try {
			
			List<Wish> wishList = wishDAO.selectWishList();
			for(Wish wish2 :wishList) {
				if(wish.getRoomNo()==wish2.getRoomNo()) {
					System.out.println("이미 관심리스트에 추가된 방번호입니다. ");
					return;
				}
			}
			wishService.insertWish(wish);
			SuccessView.messagePrint("관심리스트에 등록되었습니다.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	public static void insertWish(User user, int roomNo)  {
		try {
			Wish wish = new Wish(0, user.getUserNo(), roomNo, null);
			List<Wish> wishList = wishDAO.selectWishList();
			for(Wish wish2 :wishList) {
				if(wish.getRoomNo()==wish2.getRoomNo()) {
					System.out.println("이미 관심리스트에 추가된 방번호입니다. ");
					return;
				}
				wishService.insertWish(wish);
				SuccessView.messagePrint("관심리스트에 등록되었습니다.");
			}
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
