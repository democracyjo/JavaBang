package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Pay;
import kosta.mvc.model.service.PayService;
import kosta.mvc.model.service.PayServiceImpl;
import kosta.mvc.view.FailView;
import kosta.mvc.view.SuccessView;

public class PayController {
	private  static PayService payService = new PayServiceImpl();

	public static void insertPay(Pay pay)  {
		try {
			payService.insertPay(pay);
			SuccessView.messagePrint("���� �Ϸ�Ǿ����ϴ�.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void payDelete(int payNo)  {
		try {
			payService.payDelete(payNo);
			SuccessView.messagePrint(payNo+"�� �������� �����Ǿ����ϴ�.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void selectPayByUserId(String userId) {
		try {
			List<Pay> payList = payService.selectPayByUserId(userId);
			SuccessView.selectPayByUserIdPrint(payList);
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}