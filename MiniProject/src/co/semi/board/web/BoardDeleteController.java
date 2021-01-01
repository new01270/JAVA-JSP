package co.semi.board.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.semi.dao.BoardDAO;
import co.semi.vo.BoardVO;

@WebServlet("/BoardDelete.do")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardDeleteController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();

		vo.setBoardnumber(Integer.valueOf(request.getParameter("id")));

		int n = dao.delete(vo);

		if (n != 0) {
			String viewPage = "BoardList.do";
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		} else {
			String msg = "삭제하지 못하였습니다.";
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
