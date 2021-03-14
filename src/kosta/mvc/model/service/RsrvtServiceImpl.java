package kosta.mvc.model.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import kosta.mvc.model.dao.RoomsDAO;
import kosta.mvc.model.dao.RoomsDAOImpl;
import kosta.mvc.model.dao.RsrvtDAO;
import kosta.mvc.model.dao.RsrvtDAOImpl;
import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.dto.Room;

public class RsrvtServiceImpl implements RsrvtService {
	private RsrvtDAO reserDAO  = new RsrvtDAOImpl();
	private RoomsDAO roomDAO = new RoomsDAOImpl();
	@Override
	public void insertReservation(Reservation rsrvt, Room room) throws SQLException, ParseException {
		List<Reservation> reserList = reserDAO.selectRsrvtByRoomNo(room.getRoomNo());
		boolean state = RsrvtDAOImpl.isDuplicatedReser(reserList, rsrvt);
		if(state) {
			throw new ParseException(null, 0);
		}

		int res = reserDAO.reservationInsert(rsrvt, room);
		if(res == 0) {
			throw new SQLException("예약 실패하였습니다.");
		}
	}

	@Override
	public void reservationDelete(int reserNo) throws SQLException {
		int res = reserDAO.reservationDelete(reserNo);
		if(res == 0) {
			throw new SQLException(reserNo+"예약 삭제 실패하였습니다.");
		}
	}

	@Override
	public List<Reservation> selectRsrvtByUserId(String userId) throws SQLException {
		
		 List<Reservation> reserList =  reserDAO.selectRsrvtByUserId(userId);
		 if(reserList ==null || reserList.size()==0 ) { 
				throw new SQLException("검색된 정보가 없습니다.");
			}
		return reserList;
	}


}
