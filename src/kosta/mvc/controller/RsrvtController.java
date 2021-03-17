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
 * ����ó��
 * */
public class RsrvtController{
	private static RsrvtService reserService = new RsrvtServiceImpl();
	private static PayDAO payDAO = new PayDAOImpl();

	/**
	 * ���� ���
	 * : ���ȣ�� �Է��Ͽ� �����ϱ�.
	 * @param Reservation rsrvt,  int roomNo
	 * */
	public static void insertReservation(Reservation rsrvt,  int roomNo) {
		try {
			reserService.insertReservation(rsrvt, roomNo);
			SuccessView.messagePrint("����Ǿ����ϴ�.");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * �������
	 * -�����ȣ�� �Է��Ͽ� �̰��� ������ ���� �����ϱ�.
	 * -�����Ϸ�� ���� ���� �Ұ�.
	 * @param int reserNo
	 * */
	public static void reservationDelete(int reserNo)  {
		try {
			List<Pay> payList = payDAO.selectPayList();
			for(Pay pay :payList) {
				if(reserNo==pay.getReserNo()) {
					System.out.println("�̹� ������ �����ȣ�Դϴ�. ������� �Ұ����մϴ�.");
					return;
				}
			}
			reserService.reservationDelete(reserNo);
			SuccessView.messagePrint(reserNo+"�� ���� �����Ǿ����ϴ�.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * UserId�� ���ฮ��Ʈ �˻�
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
	 * userID�� reserNo�� ���ฮ��Ʈ�� �ش� �����ȣ ���翩�� Ȯ��
	 * : �����ϴ� �����ȣ�� ���� �����ϵ��� ����
	 * @param User user, int reserNo
	 * @return boolean - �����ȣ ������ true, ������ false
	 * */
	public static boolean hasReserNo(User user, int reserNo) {
		try {
			if(reserService.hasReserNo(user, reserNo)) {
				System.out.println("�����ȣ Ȯ�εǾ����ϴ�.");
				return true;
			}
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
			return false;
		}
		return false;
		
	}

}
