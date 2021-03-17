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
 * ����ó��
 * */
public class WishController{
	private  static WishService wishService = new WishServiceImpl();
	
	/**
	 * ���ɸ���Ʈ ���
	 * : �����ִ� ���ȣ�� �Է��Ͽ� ���ɸ���Ʈ�� �߰��ϱ�.
	 * @param User user, int roomNo
	 * */
	public static void insertWish(User user, int roomNo)  {
		try {
			if(!wishService.hasRoomNo(user, roomNo)) {
				Wish wish =  new Wish(0, user.getUserNo(), roomNo, null);
				wishService.insertWish(wish);
				SuccessView.messagePrint("���ɸ���Ʈ�� ��ϵǾ����ϴ�.");
			}
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}

	/**
	 * ���ɸ���Ʈ ����
	 * : �ش� ���ɹ�ȣ�� �Է��Ͽ� ���ɸ���Ʈ���� ����
	 * @param int wishNo
	 * */
	public static void wishDelete(int wishNo) {
		try {
			wishService.wishDelete(wishNo);
			SuccessView.messagePrint("���ɸ���Ʈ�� ���ɹ�ȣ[ "+wishNo+"]�� �����Ǿ����ϴ�.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}

	/**
	 * UserId�� ���ɸ���Ʈ �˻�
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
	 * ��ü ���ɸ���Ʈ �˻� -- �����ڿ�
	 * ��� ȸ���� ���ɸ���Ʈ �˻��ϱ�
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
