package co.semi.board.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.semi.dao.BoardDAO;
import co.semi.dao.CommentsDAO;
import co.semi.vo.BoardVO;
import co.semi.vo.CommentsVO;

@WebServlet("/BoardRead.do")
public class BoardReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardReadController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();

		String boardnumber = request.getParameter("no");
		System.out.println("boardnumber:"+boardnumber);
		
		// 게시글
		vo.setBoardnumber(Integer.valueOf(boardnumber));
		vo = dao.selectRead(vo);
		request.setAttribute("vo", vo);

		// 댓글목록
		CommentsDAO c_dao = new CommentsDAO();
		CommentsVO c_vo = new CommentsVO();
		c_vo.setBoardnumber(Integer.valueOf(boardnumber));
		ArrayList<CommentsVO> c_list = c_dao.comment_list(c_vo);

		if (c_list.size() != 0) {
			request.setAttribute("c_list", c_list);
		}

		String viewPage = "jsp/board/boardRead.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
