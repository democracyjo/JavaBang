package kosta.mvc.session;

import java.util.HashSet;
import java.util.Set;
/**
 * ���� ������ �����ϴ� Ŭ����
 * */
public class SessionSet {//�̱���
//	�ʿ��� ������ ��� ���ο� ��ü �����ϸ� �ȵǴϱ�. �̱������� ����.
	private static SessionSet ss = new SessionSet();
	private Set<Session> set;
	
	private SessionSet() {
		set = new HashSet<>(); //Set<Session> set �տ� ���׸� Ÿ���� ������������ ����ü������ ��������. 
//		new HashSet<>(); �̺κ��� �ʵ�κп��� ���൵ ����.
	}
	
	public static SessionSet getInstance() {//�� �޼��带 ȣ���ϸ� ������ ���� ��ü�� ȣ��� �� �ֵ���,
		return ss;
	}
	
	
	/**
	 * ����� ã��
	 * */
	public Session get(String sessionId) {
		for(Session session : set) {//set�ȿ� ����ִ� Ư�� Session�� ã�� ���� �� 
			if(session.getSessionId().equals(sessionId)) {
				return session;
			}
		}
		return null;
	}
	
	//���� ��ü�� ��ȯ
		public Set<Session> getSet(){
			return set;
		}
	
		/**
		 * �α��� �� ����� �߰�
		 * */
		public void add(Session session) {
			set.add(session); //set�� Session�� �����ϴ� ���� == �α���/�α��λ��� ������ ����.
		}
		
	/**
	 * ����� ���� - �α׾ƿ�
	 * */
	public void remove(Session session) {
		set.remove(session);
	}
	
	
}
