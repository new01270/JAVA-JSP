package co.semi.edu.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.semi.dao.EduDAO;
import co.semi.vo.EduVO;

/**
 * Servlet implementation class EduDescriptController
 */
@WebServlet("/EduDescript.do")
public class EduDescriptController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EduDescriptController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		EduDAO dao = new EduDAO();
		EduVO vo = new EduVO();
		vo.setEduNumber(Integer.valueOf(request.getParameter("id")));
		vo = dao.selectDescOne(vo);
		System.out.println(vo);

		request.setAttribute("vo", vo);
		String viewPage = "jsp/edu/descriptTable.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
