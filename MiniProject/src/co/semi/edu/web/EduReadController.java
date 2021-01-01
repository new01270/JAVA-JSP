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

@WebServlet("/EduRead.do")
public class EduReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EduReadController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		EduVO vo = new EduVO();
		EduDAO dao = new EduDAO();
		vo.setEduNumber(Integer.valueOf(request.getParameter("id")));
		vo = dao.selectOne(vo);

		request.setAttribute("vo", vo);
		String viewPage = "jsp/edu/eduRead.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}