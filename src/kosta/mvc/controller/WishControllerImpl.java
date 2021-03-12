package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Wish;
import kosta.mvc.model.service.WishService;
import kosta.mvc.model.service.WishServiceImpl;
import kosta.mvc.view.FailView;
import kosta.mvc.view.SuccessView;

public class WishControllerImpl implements WishController {
	private WishService wishService = new WishServiceImpl();
	
	@Override
	public void insertWish(Wish wish)  {
		try {
			wishService.insertWish(wish);
			SuccessView.messagePrint("관심리스트에 등록되었습니다.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}

	@Override
	public void wishDelete(int wishNo) {
		try {
			wishService.wishDelete(wishNo);
			SuccessView.messagePrint("관심리스트의"+wishNo+"번이 삭제되었습니다.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}

	@Override
	public void selectWishByUserId(String userId) {
		try {
			List<Wish> wishList = wishService.selectWishByUserId(userId);
			SuccessView.selectWishByUserIdPrint(wishList);
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		
		}
		
	}

}
