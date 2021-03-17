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
/**
 * Reservation Controller
 * 예외처리
 * */
public class RsrvtController{
	private static RsrvtService reserService = new RsrvtServiceImpl();
	private static PayDAO payDAO = new PayDAOImpl();

	/**
	 * 예약 등록
	 * : 방번호를 입력하여 예약하기.
	 * @param Reservation rsrvt,  int roomNo
	 * */
	public static void insertReservation(Reservation rsrvt,  int roomNo) {
		try {
			reserService.insertReservation(rsrvt, roomNo);
			SuccessView.messagePrint("예약되었습니다.");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 예약삭제
	 * -예약번호를 입력하여 미결제 상태인 예약 삭제하기.
	 * -결제완료된 예약 삭제 불가.
	 * @param int reserNo
	 * */
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

	/**
	 * UserId로 예약리스트 검색
	 * @param String userId
	 * @return List<Reservation> 
	 * */
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
	
	/**
	 * userID와 reserNo로 예약리스트에 해당 예약번호 존재여부 확인
	 * : 존재하는 예약번호만 결제 가능하도록 설정
	 * @param User user, int reserNo
	 * @return boolean - 예약번호 있으면 true, 없으면 false
	 * */
	public static boolean hasReserNo(User user, int reserNo) {
		try {
			if(reserService.hasReserNo(user, reserNo)) {
				System.out.println("예약번호 확인되었습니다.");
				return true;
			}
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
			return false;
		}
		return false;
		
	}

}
