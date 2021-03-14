package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.dto.Room;

public interface RsrvtDAO {
	
	/**
	   * ���ฮ��Ʈ�� �߰��ϱ�
	   * 1) RESERVATION_LIST ���̺� insert
	   * 2) �ش� �� ���డ���� ������Ʈ.
	   * @param Reservation rsrv
	   * @return int 
	   * */
		int reservationInsert(Reservation rsrvt,  Room room)throws SQLException;
		
		/**
		   * ���ฮ��Ʈ �����ϱ�
		   * : RESERVATION_LIST ���̺��� delete
		   * @param int reserNo
		   * @return int 
		   * */
		int reservationDelete(int reserNo) throws SQLException;
		
		/**
		 * ���ฮ��Ʈ ��ü ���� 
		 * @param String userId
		 * @return List<Reservation> 
		 * */
		List<Reservation> selectRsrvtByUserId(String userId)throws SQLException;
		
		List<Reservation> selectRsrvtAll() throws SQLException;
		
		List<Reservation> selectRsrvtByRoomNo(int RoomNo)throws SQLException;
}
