package kosta.mvc.session;

import java.util.HashSet;
import java.util.Set;
/**
 * 여러 유저를 관리하는 클래스
 * */
public class SessionSet {//싱글톤
//	필요할 때마다 계속 새로운 객체 생성하면 안되니까. 싱글톤으로 생성.
	private static SessionSet ss = new SessionSet();
	private Set<Session> set;
	
	private SessionSet() {
		set = new HashSet<>(); //Set<Session> set 앞에 제네릭 타입을 지정해줬으면 구현체에서는 생략가능. 
//		new HashSet<>(); 이부분은 필드부분에서 해줘도 무관.
	}
	
	public static SessionSet getInstance() {//이 메서드를 호출하면 무조건 같은 객체가 호출될 수 있도록,
		return ss;
	}
	
	
	/**
	 * 사용자 찾기
	 * */
	public Session get(String sessionId) {
		for(Session session : set) {//set안에 들어있는 특정 Session을 찾고 싶을 때 
			if(session.getSessionId().equals(sessionId)) {
				return session;
			}
		}
		return null;
	}
	
	//세션 객체들 반환
		public Set<Session> getSet(){
			return set;
		}
	
		/**
		 * 로그인 된 사용자 추가
		 * */
		public void add(Session session) {
			set.add(session); //set에 Session을 저장하는 과정 == 로그인/로그인상태 유지의 절차.
		}
		
	/**
	 * 사용자 제거 - 로그아웃
	 * */
	public void remove(Session session) {
		set.remove(session);
	}
	
	
}
