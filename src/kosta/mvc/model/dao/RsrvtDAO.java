package kosta.mvc.model.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.dto.Room;

/**
 * ���ฮ��Ʈ�� �������� ���/����/�˻� ���
 * ���� �����ϰ�, ������ ���� �˻� �Ǵ� ��������ϴ� �뵵
 * 
 * @author Minjoo Jo
 * @version 1.0
 * */
public interface RsrvtDAO {
	
	/**
	   * ���ฮ��Ʈ�� �߰��ϱ�
	   * 1) RESERVATION_LIST ���̺� insert
	   * 2) �ش� �� ���డ���� ������Ʈ.
	   * @param Reservation rsrvt
	   * @return  Room room 
	   * @throws SQLException, ParseException
	   * */
		int reservationInsert(Reservation rsrvt,  Room room)throws SQLException, ParseException;
		
		/**
		   * �����ȣ�� ���ฮ��Ʈ���� ���� �����ϱ�
		   * : RESERVATION_LIST ���̺��� delete
		   * @param int reserNo
		   * @return int 
		   * @throws SQLException
		   * */
		int reservationDelete(int reserNo) throws SQLException;
		
		/**
		 * �ش� ���̵�� ���ฮ��Ʈ ��ü ���� 
		 * @param String userId
		 * @return List<Reservation>  : �������� ������
		 * @throws SQLException
		 * */
		List<Reservation> selectRsrvtByUserId(String userId)throws SQLException;
		
		/**
		 * ��� ȸ���� ���ฮ��Ʈ ����
		 * @return List<Reservation>
		 * */
		List<Reservation> selectRsrvtAll() throws SQLException;
		
		/**
		 * ���ȣ�� ���ฮ��Ʈ Ȯ���ϱ� 
		 * :�ش� ���� ������¸� �����ִ� �뵵
		 * @param int RoomNo
		 * @return List<Reservation>
		 * @throws SQLException
		 * */
		List<Reservation> selectRsrvtByRoomNo(int RoomNo)throws SQLException;
}
