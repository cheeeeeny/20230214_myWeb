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
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login Post");
		//1. 전송받은 데이터값 불러오기 : /login의 id/pw 데이터를 가지고 온다.
		MemberVo vo = new MemberVo();
		vo.setId(request.getParameter("id"));
		vo.setPasswd(request.getParameter("passwd"));
		
//		String id = request.getParameter("id");
//		String passwd = request.getParameter("passwd");
		
		//2. DB 다녀오기 (JdbcTemplate - DTO/VO - DAO - Service - Controller 순으로 작성)
		MemberVo result = new MemberService().login(vo);
		if(result != null) {
			System.out.println("로그인성공");
			request.getSession().setAttribute("lgnss", result);
		}else {
			System.out.println("로그인실패");
		}
		
		//3. 페이지 이동 및 데이터 전달
		//3-1. response.sendRedirect(request.getContextPath()+"url");
		//3-2. request.setAttribute("name1", "값");
		//3-3. request.getRequestDispatcher("xxx.jsp").forward(request, response);
		//3-4. out.println(값); out.flush(); out.close();
		
		
		response.sendRedirect(request.getContextPath()+"/");
	}

}
