package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.WishDAO;
import kosta.mvc.model.dao.WishDAOImpl;
import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.dto.User;
import kosta.mvc.model.dto.Wish;

public class WishServiceImpl implements WishService {
	private WishDAO wishDAO = new WishDAOImpl();

	@Override
	public void wishDelete(int wishNo) throws SQLException {
		int res = wishDAO.wishDelete(wishNo);
		if(res ==0) {
			throw new SQLException("�Է��Ͻ� ���ɹ�ȣ["+wishNo+"]�� �������� �ʽ��ϴ�.\n���ɹ�ȣ Ȯ�� �� �ٽ� �õ��� �ּ���.");
		}
	}

	@Override
	public void insertWish(Wish wish) throws SQLException {
		int res = wishDAO.wishInsert(wish);
		if(res ==0) {
			throw new SQLException("���ɸ���Ʈ ��� �����Ͽ����ϴ�.");
		}
	}

	@Override
	public List<Wish> selectWishByUserId(String userId) throws SQLException {
		
		List<Wish> wishList = wishDAO.selectWishByUserId(userId);
		if(wishList ==null || wishList.size()==0 ) { 
			throw new SQLException("�˻��� ������ �����ϴ�.");
		}
		return wishList;
	}

	@Override
	public List<Wish> selectWishList() throws SQLException {
		List<Wish> wishList = wishDAO.selectWishList();
		if(wishList ==null || wishList.size()==0 ) { 
			throw new SQLException("�˻��� ������ �����ϴ�.");
		}
		return wishList;
		
	}
	
	@Override
	public boolean hasRoomNo(User user, int roomNo) throws SQLException {
		List<Wish> list = wishDAO.selectWishByUserId(user.getId());
		for(Wish wish :list) {
			if(wish.getRoomNo()==roomNo) {
				throw new SQLException("�̹� ���ɸ���Ʈ�� ��ϵ� ���ȣ�Դϴ�.");
			}
		}		
		return false;

	}

}
