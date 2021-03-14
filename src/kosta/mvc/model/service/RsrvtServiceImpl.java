package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.RsrvtDAO;
import kosta.mvc.model.dao.RsrvtDAOImpl;
import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.dto.Room;

public class RsrvtServiceImpl implements RsrvtService {
	private RsrvtDAO reserDAO  = new RsrvtDAOImpl();
	@Override
	public void insertReservation(Reservation rsrvt, Room room) throws SQLException {
		int res = reserDAO.reservationInsert(rsrvt, room);
		if(res == 0) {
			throw new SQLException("���� �����Ͽ����ϴ�.");
		}
	}

	@Override
	public void reservationDelete(int reserNo) throws SQLException {
		int res = reserDAO.reservationDelete(reserNo);
		if(res == 0) {
			throw new SQLException(reserNo+"���� ���� �����Ͽ����ϴ�.");
		}
	}

	@Override
	public List<Reservation> selectRsrvtByUserId(String userId) throws SQLException {
		
		 List<Reservation> reserList =  reserDAO.selectRsrvtByUserId(userId);
		 if(reserList ==null || reserList.size()==0 ) { 
				throw new SQLException("�˻��� ������ �����ϴ�.");
			}
		return reserList;
	}


}
