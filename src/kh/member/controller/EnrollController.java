package kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.member.model.service.MemberService;
import kh.member.model.vo.MemberVo;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/enroll")
public class EnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");  > EncodinFilter로 설정
		//1. 전달받은데이터 읽어 변수에 담기 (변수이름은 vo에 설정한 것과 맞춰주는것이 좋다.)
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPasswd(passwd);
		vo.setName(name);
		vo.setEmail(email);
		System.out.println("Ctrl param : " + vo);
		
		//2. DB다녀오기 (JdbcTemplate - DTO/VO - DAO - Service - Controller 순으로 작성)
		int result = new MemberService().enroll(vo);
		
		if(result < 1) {
			System.out.println("회원가입 실패");
		} else {
			System.out.println("회원가입 성공");
			//session 등록
			
			response.sendRedirect(request.getContextPath()+"/");
		}
		
	}	
		
}
