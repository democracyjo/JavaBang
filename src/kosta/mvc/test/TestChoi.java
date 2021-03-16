package kosta.mvc.test;

import java.awt.color.ProfileDataException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import kosta.mvc.controller.ReviewController;
import kosta.mvc.model.dao.RsrvtDAO;
import kosta.mvc.model.dao.RsrvtDAOImpl;
import kosta.mvc.model.dto.Reservation;
import kosta.mvc.model.dto.Review;
import kosta.mvc.util.DbUtil;
import kosta.mvc.view.SuccessView;

public class TestChoi {
	private Properties proFile = DbUtil.getProFile();

	public static void main(String[] args) {
		Properties proFile = DbUtil.getProFile();

		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;

		String sql = proFile.getProperty("room.updateAvgByRevNo");

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			int reviewNo = 23;
			ps.setInt(1, reviewNo);
			ps.setInt(2, reviewNo);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
