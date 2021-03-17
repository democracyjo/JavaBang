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
			throw new SQLException("입력하신 관심번호["+wishNo+"]가 존재하지 않습니다.\n관심번호 확인 후 다시 시도해 주세요.");
		}
	}

	@Override
	public void insertWish(Wish wish) throws SQLException {
		int res = wishDAO.wishInsert(wish);
		if(res ==0) {
			throw new SQLException("관심리스트 등록 실패하였습니다.");
		}
	}

	@Override
	public List<Wish> selectWishByUserId(String userId) throws SQLException {
		
		List<Wish> wishList = wishDAO.selectWishByUserId(userId);
		if(wishList ==null || wishList.size()==0 ) { 
			throw new SQLException("검색된 정보가 없습니다.");
		}
		return wishList;
	}

	@Override
	public List<Wish> selectWishList() throws SQLException {
		List<Wish> wishList = wishDAO.selectWishList();
		if(wishList ==null || wishList.size()==0 ) { 
			throw new SQLException("검색된 정보가 없습니다.");
		}
		return wishList;
		
	}
	
	@Override
	public boolean hasRoomNo(User user, int roomNo) throws SQLException {
		List<Wish> list = wishDAO.selectWishByUserId(user.getId());
		for(Wish wish :list) {
			if(wish.getRoomNo()==roomNo) {
				throw new SQLException("이미 관심리스트에 등록된 방번호입니다.");
			}
		}		
		return false;

	}

}
