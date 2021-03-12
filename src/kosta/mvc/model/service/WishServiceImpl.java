package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.WishDAO;
import kosta.mvc.model.dao.WishDAOImpl;
import kosta.mvc.model.dto.Wish;

public class WishServiceImpl implements WishService {
	private WishDAO wishDAO = new WishDAOImpl();

	@Override
	public void wishDelete(int wishNo) throws SQLException {
		int res = wishDAO.wishDelete(wishNo);
		if(res ==0) {
			throw new SQLException("관심리스트 삭제 실패하였습니다.");
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

}
