package co.semi.member.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.semi.dao.MemberDAO;
import co.semi.vo.MemberVO;

@WebServlet("/SemiLogin.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession(); // 세션객체를 가져옴.

		vo.setMemberId(request.getParameter("mid"));
		vo.setPassword(request.getParameter("password"));

		vo = dao.login(vo);
		System.out.println(vo.getMemberAuth());
		if (vo.getMemberAuth() != null) {
			session.setAttribute("id", vo.getMemberId());
			session.setAttribute("auth", vo.getMemberAuth());
			session.setAttribute("name", vo.getMemberName());
			session.setAttribute("password", vo.getPassword());
		}

//		String viewPage = "/jsp/menu/main.jsp";
//		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
//		dispatcher.forward(request, response);
		
		response.sendRedirect("HomeController.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
