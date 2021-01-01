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

@WebServlet("/EduDatabase.do")
public class EduDatabaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EduDatabaseController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		EduDAO dao = new EduDAO();
		EduVO vo = new EduVO();
		
		vo.setEduSubject(request.getParameter("database"));
		System.out.println(vo.getEduSubject());
		ArrayList<EduVO> list = dao.programmingList(vo);
		System.out.println(list);
		request.setAttribute("list", list);
		
		String viewPage ="jsp/edu/eduDB.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
