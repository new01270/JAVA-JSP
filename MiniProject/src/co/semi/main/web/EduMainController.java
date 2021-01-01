package co.semi.main.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.semi.dao.EduDAO;
import co.semi.vo.EduVO;

@WebServlet("/EduMain.do")
public class EduMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EduMainController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		EduVO vo = new EduVO();
		EduDAO dao = new EduDAO();

		ArrayList<EduVO> list = dao.getEduList(vo);
		List<EduVO> listProgramming = list.subList(0, 4);
		List<EduVO> listNetwork = list.subList(4, 8);
		List<EduVO> listDatabase = list.subList(8, 12);
		List<EduVO> listskill = list.subList(12, 16);
		List<EduVO> listCareer = list.subList(16, 20);
		List<EduVO> listLife = list.subList(20, 24);

		request.setAttribute("listProgramming", listProgramming);
		request.setAttribute("listNetwork", listNetwork);
		request.setAttribute("listDatabase", listDatabase);
		request.setAttribute("listskill", listskill);
		request.setAttribute("listCareer", listCareer);
		request.setAttribute("listLife", listLife);
		
		String viewPage = "jsp/edu/eduMain.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
