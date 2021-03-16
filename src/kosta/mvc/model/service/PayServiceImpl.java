package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.PayDAO;
import kosta.mvc.model.dao.PayDAOImpl;
import kosta.mvc.model.dto.Pay;

public class PayServiceImpl implements PayService {

	private PayDAO payDAO = new PayDAOImpl();
	
	
	@Override
	public void insertPay(Pay pay) throws SQLException {
		
		List<Pay> payList = payDAO.selectPayList();
		for(Pay pay2 : payList) {
			if(pay.getReserNo() == pay2.getReserNo()) {
				throw new SQLException("�̹� ������ �����ȣ�Դϴ�.");
			}
		}
		int res = payDAO.payInsert(pay);
		if(res ==0) {
			throw new SQLException("��������Ʈ ��� �����Ͽ����ϴ�.");
		}
	}

	@Override
	public void payDelete(int payNo) throws SQLException {
		int res = payDAO.payDelete(payNo);
		if(res ==0) {
			throw new SQLException(payNo+"�� �������� ���� �����Ͽ����ϴ�.");
		}
	}

	@Override
	public List<Pay> selectPayByUserId(String userId) throws SQLException {
		
		List<Pay> payList = payDAO.selectPayByUserId(userId);
		if(payList ==null || payList.size()==0 ) { 
			throw new SQLException("�˻��� ������ �����ϴ�.");
		}

		return payList;
	}

}
