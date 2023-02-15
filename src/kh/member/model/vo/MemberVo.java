package kh.member.model.vo;

/**
 * 
 * @author chan
 * 
 * TEST_MEMBER 테이블 이용
 * 
 *  [첫화면]("/") index.jsp include header.jsp - 로그인(login Get)/ 로그아웃(logout Get) 버튼 토글 / nav 내정보보기 버튼(myinfo get)
 * 
 *  [로그인화면] : 로그인 버튼 (login post) / 회원가입 버튼(enroll get)
 *  	회원가입("/enroll") - get enroll.jsp로 forward, post 회원가입DB다녀와서 첫 화면 이동
 * 
 *  [회원가입화면] : 회원가입 버튼(enroll post)
 *  	로그인("/login")  	- GET login.jsp로 forward , post 로그인확인DB다녀와서 session("lgnss") 첫 이동 /이름,id,email 저장
 *  	로그아웃("/logout") 	- GET세션만료 후 / 첫 화면 이동
 *  
 *  [내정보 보기 화면] : 하단에 수정 버튼(infoupdate get) / 탈퇴 버튼(
 *  	내정보 보기("/myinfo") - get myinfo.jsp
 *  
 *  [내정보 수정하기 화면] : 내정보수정(infoupdate post)
 *  	내정보 수정하기("/infoupdate")
 * 
 */

public class MemberVo {
/*
desc test_member;           
------ -------- ------------ 
ID     NOT NULL VARCHAR2(15) 
PASSWD NOT NULL VARCHAR2(15) 
NAME   NOT NULL VARCHAR2(20) 
EMAIL           VARCHAR2(30) 	
 */
	private String id;
	private String passwd;
	private String name;
	private String email;
	
	//toString
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", passwd=" + passwd + ", name=" + name + ", email=" + email + "]";
	}
	
	// Getter, Setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
