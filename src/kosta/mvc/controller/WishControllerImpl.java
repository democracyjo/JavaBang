package kosta.mvc.controller;

import java.sql.SQLException;

import kosta.mvc.model.dto.Wish;
import kosta.mvc.model.service.WishService;
import kosta.mvc.model.service.WishServiceImpl;

public class WishControllerImpl implements WishController {
	private WishService wishService = new WishServiceImpl();
	
	@Override
	public void insertWish(Wish wish) throws SQLException {
		wishService.insertWish(wish);
		
	}

	@Override
	public void wishDelete(int wishNo) throws SQLException {

	}

	@Override
	public void selectWishByUserId(String userId) throws SQLException {

	}

}
