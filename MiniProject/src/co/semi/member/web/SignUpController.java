package co.semi.member.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.semi.dao.MemberDAO;
import co.semi.vo.MemberVO;

@WebServlet("/SignUp.do")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignUpController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();

		vo.setMemberName(request.getParameter("name"));
		vo.setMemberId(request.getParameter("mid"));
		vo.setPassword(request.getParameter("password"));
		System.out.println(vo.getMemberId());
		
		int n = dao.insert(vo);
		
		if (n != 0) {
			request.setAttribute("mid", request.getParameter("mid"));
//			response.sendRedirect("/MiniProject/jsp/member/login.jsp");
			String viewPage = "jsp/member/signResult.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
			// dispatcher를 사용할 경우 절대경로로 넘어가지 않는다.
			// sendRedirect 로 넘길 때 request를 가져가지 못한다.
		} else {
			PrintWriter out = response.getWriter();
			out.println(
					"<script>alert('가입을 완료하지 못하였습니다.'); location.href='/MiniProject/jsp/member/signUp.jsp; </script>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
