package kosta.mvc.controller;
import java.sql.SQLException;
import kosta.mvc.exception.DuplicatedException;
import kosta.mvc.model.dto.User;
import kosta.mvc.model.service.UserService;
import kosta.mvc.model.service.UserServiceImpl;
import kosta.mvc.test.TestDongso;
import kosta.mvc.view.FailView;
import kosta.mvc.view.MenuView;
import kosta.mvc.view.SuccessView;

public class UserController {
	private static UserService userService = new UserServiceImpl();
	
	/**
	 * ȸ�����
	 */
	public static void inputUser(User dto) {
		try {
			userService.inputUser(dto);
			SuccessView.printMessage(dto.getId() + "�� ȸ�������� ���ϵ帳�ϴ�.\n");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		} catch (DuplicatedException e) {
			FailView.errorMessage(e.getMessage());
			TestDongso.printJoin();
		}
	}
	
	/**
	 * ȸ����������
	 * */
	public static void updateUser() {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * ȸ��Ż��
	 * */
	public static void deleteUser(User dto) {
		try {
			userService.deleteUser(dto);
			SuccessView.printMessage("�� ���� JavaBang HOTEL�� �̿��� �ּż� �����մϴ�.\n");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			TestDongso.printUserMenu(dto.getId());
		}
	}
	
	/**
	 * �α���
	 */
	public static void login(String userId, String userPwd) {	
		try {
			User user = userService.login(userId, userPwd);
			TestDongso.printUserMenu(userId);
			//MenuView.menu();
		}catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}