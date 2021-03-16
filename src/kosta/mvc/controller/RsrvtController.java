package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.PayDAO;
import kosta.mvc.model.dao.PayDAOImpl;
import kosta.mvc.model.dto.Pay;
import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.dto.User;
import kosta.mvc.model.service.RsrvtService;
import kosta.mvc.model.service.RsrvtServiceImpl;
import kosta.mvc.view.FailView;
import kosta.mvc.view.SuccessView;

public class RsrvtController{
	private static RsrvtService reserService = new RsrvtServiceImpl();
	private static PayDAO payDAO = new PayDAOImpl();

	public static void insertReservation(Reservation rsrvt,  int roomNo) {
		try {
			reserService.insertReservation(rsrvt, roomNo);
			SuccessView.messagePrint("예약되었습니다.");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void reservationDelete(int reserNo)  {
		try {
			List<Pay> payList = payDAO.selectPayList();
			for(Pay pay :payList) {
				if(reserNo==pay.getReserNo()) {
					System.out.println("이미 결제된 예약번호입니다. 예약취소 불가능합니다.");
					return;
				}
			}
			reserService.reservationDelete(reserNo);
			SuccessView.messagePrint(reserNo+"번 예약 삭제되었습니다.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	public static List<Reservation> selectRsrvtByUserId(String userId) {
		List<Reservation> reserList=null;
		try {
			reserList = reserService.selectRsrvtByUserId(userId);
			SuccessView.selectRsrvtByUserId(reserList);
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
		return reserList;
	}
	
	public static boolean hasReserNo(User user, int reserNo) {
		try {
			if(reserService.hasReserNo(user, reserNo)) {
				System.out.println("예약번호 확인되었습니다.");
			}
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
			return false;
		}
		return true;
	}

}
