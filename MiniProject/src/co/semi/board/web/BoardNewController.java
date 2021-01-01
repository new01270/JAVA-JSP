package co.semi.board.web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.semi.dao.BoardDAO;
import co.semi.vo.BoardVO;

@WebServlet("/BoardNew.do")
public class BoardNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardNewController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();

		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();

		vo.setBoardtitle(request.getParameter("title"));
		vo.setBoardcontent(request.getParameter("content"));
		vo.setBoarddate(Date.valueOf(request.getParameter("wdate")));
		String id = (String) session.getAttribute("id");
		vo.setMemberid(id);

		int n = dao.insert(vo);

		if (n != 0) {
			String viewPage = ("BoardList.do");
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		} else {
			String msg = "데이터베이스에 정상적으로 입력하지 못하였습니다.";
			request.setAttribute("msg", msg);
			String viewPage = "jsp/board/inputError.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
