package co.semi.edu.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.semi.dao.EduDAO;
import co.semi.vo.EduVO;

@WebServlet("/EduSearch.do")
public class EduSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EduSearchController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		EduDAO dao = new EduDAO();
		ArrayList<EduVO> list = dao.searchList(request.getParameter("search"));
		request.setAttribute("list", list);

		String viewPage = "jsp/edu/eduSearch.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
