package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.service.RsrvtService;
import kosta.mvc.model.service.RsrvtServiceImpl;
import kosta.mvc.view.FailView;
import kosta.mvc.view.SuccessView;

public class RsrvtController{
	private static RsrvtService reserService = new RsrvtServiceImpl();
	

	public static void insertReservation(Reservation rsrvt) {
		try {
			reserService.insertReservation(rsrvt);
			SuccessView.messagePrint("����Ǿ����ϴ�.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void reservationDelete(int reserNo)  {
		try {
			reserService.reservationDelete(reserNo);
			SuccessView.messagePrint(reserNo+"�� ���� �����Ǿ����ϴ�.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void selectRsrvtByUserId(String userId) {
		try {
			List<Reservation> reserList = reserService.selectRsrvtByUserId(userId);
			SuccessView.selectRsrvtByUserId(reserList);
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

}
