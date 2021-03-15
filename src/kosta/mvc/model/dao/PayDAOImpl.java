package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.Pay;
import kosta.mvc.util.DbUtil;

public class PayDAOImpl implements PayDAO {

	private Properties proFile = DbUtil.getProFile();
	@Override
	public int payInsert(Pay pay) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=proFile.getProperty("pay.insert"); 
//		pay.insert=insert into PAY_LIST values(PAY_LIST_NO_SEQ.NEXTVAL, SYSDATE, ?)
//		reser_No
		
		int result=0;
		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, pay.getReserNo());

			result = ps.executeUpdate();
			
		}finally {
			DbUtil.close(con, ps);	
		}

		return result;
	}

	@Override
	public List<Pay> selectPayByUserId(String userId) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<Pay> payList = new ArrayList<>();
		Pay pay = null;
		String sql=proFile.getProperty("pay.select"); 
		
		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				 int payNo = rs.getInt(3);
				 String payDate= rs.getString(4);
				 int reserNo  = rs.getInt(2);
				
				pay = new Pay(payNo, payDate, reserNo);
				payList.add(pay);
			}
			
		}finally {
			DbUtil.close(con, ps, rs);	
		}

		return payList;
	}

	@Override
	public int payDelete(int payNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		String sql=proFile.getProperty("pay.delete"); 
//		pay.delete=delete from PAY_LIST where pay_No = ?
//		payNo
		
		int result=0;
		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,payNo);

			result = ps.executeUpdate();
			
		}finally {
			DbUtil.close(con, ps);	
		}

		return result;
	}

	@Override
	public List<Pay> selectPayList() throws SQLException {
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<Pay> payList = new ArrayList<>();
		Pay pay = null;
		String sql=proFile.getProperty("pay.selectAll"); 
		
		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				 int payNo = rs.getInt(1);
				 String payDate= rs.getString(2);
				 int reserNo  = rs.getInt(3);
				
				pay = new Pay(payNo, payDate, reserNo);
				payList.add(pay);
			}
			
		}finally {
			DbUtil.close(con, ps, rs);	
		}

		return payList;
	}

}
