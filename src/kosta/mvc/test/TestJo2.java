package kosta.mvc.test;

import kosta.mvc.controller.RsrvtController;
import kosta.mvc.controller.WishController;
import kosta.mvc.model.dao.RsrvtDAO;
import kosta.mvc.model.dao.RsrvtDAOImpl;
import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.dto.User;

public class TestJo2 {

	public static void main(String[] args) {
//		TestJo.menu();
		
//		TestJo.printInputReser();
//		int days =RsrvtDAOImpl.calDate(reser);
//		System.out.println(days);
		
//		TestJo.printInputPay();
		
//		WishController.selectWishByUserId("minjoo");
		
		User user = new User("minjoo", "1234");
		RsrvtController.hasReserNo(user, 2);
	}

}
