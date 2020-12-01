package co.syeon.id.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.syeon.id.dao.MemberDAO;

@WebServlet("/Idcheck.do")
public class IdcheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IdcheckController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		MemberDAO dao = new MemberDAO();

		String key = request.getParameter("id");
		String checkKey = dao.idCheck(key);
		String viewPage;

		if (key.equals(checkKey)) {
			request.setAttribute("id", checkKey);
			viewPage = "/jsp/fail.jsp";
		} else {
			request.setAttribute("id", key);
			viewPage = "/jsp/success.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
