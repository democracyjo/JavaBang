package kosta.mvc.model.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kosta.mvc.model.dao.RoomsDAO;
import kosta.mvc.model.dao.RoomsDAOImpl;
import kosta.mvc.model.dao.RsrvtDAO;
import kosta.mvc.model.dao.RsrvtDAOImpl;
import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.dto.Room;
import kosta.mvc.model.dto.User;

public class RsrvtServiceImpl implements RsrvtService {
	private RsrvtDAO reserDAO  = new RsrvtDAOImpl();
	private RoomsDAO roomDAO= new RoomsDAOImpl();
	@Override
	public void insertReservation(Reservation rsrvt, int roomNo) throws SQLException, ParseException {
		List<Reservation> reserList = reserDAO.selectRsrvtByRoomNo(roomNo);
		Room room = roomDAO.searchByRoomNo(roomNo);
		boolean state = RsrvtDAOImpl.isDuplicatedReser(reserList, rsrvt);
		if(state) {
			throw new ParseException("�̹� ����� ��¥�Դϴ�. �ٽ� �õ��� �ּ���", 0);
		}

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
	

	@Override
	public boolean diffOfDate(String begin, String end) throws SQLException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date stDt = format.parse(begin);
			Date edDt = format.parse(end);

			long diff = edDt.getTime() - stDt.getTime();
			long diffDays = diff / (24 * 60 * 60 * 1000);
			if (diffDays <= 0) {
				throw new SQLException("üũ �� ��¥�� üũ �ƿ� ��¥���� ������մϴ�.");
			} else {
				return true;
			}
		} catch (ParseException e) {
			throw new SQLException("yyyy-MM-dd ���Ŀ� �°� �Է����ּ���.");
		}
	}

	@Override
	public boolean hasReserNo(User user, int reserNo) throws SQLException {
		List<Reservation> list = reserDAO.selectRsrvtByUserId(user.getId());
		for(Reservation reser :list) {
			if(reser.getReserNo()!=reserNo) {
				throw new SQLException("�ش��ϴ� �����ȣ�� �������� �ʽ��ϴ�. �ٽ� �õ��� �ּ���.");
			}
		}
		return true;
	}

}
