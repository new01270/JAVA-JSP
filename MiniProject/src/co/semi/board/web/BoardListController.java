package co.semi.board.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.semi.common.Paging;
import co.semi.dao.BoardDAO;
import co.semi.vo.BoardVO;

@WebServlet("/BoardList.do")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardListController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		BoardDAO dao = new BoardDAO();
		Paging paging = new Paging();

		String opt = request.getParameter("opt");
		String search = request.getParameter("search");
		System.out.println(opt + search);
		
		paging.setPageSize(10);
		request.setAttribute("pageSize", paging.getPageSize());
		Integer pageSize = (Integer) request.getAttribute("pageSize");
		String currentPage = request.getParameter("pageNum");
		
		if (currentPage == null || currentPage.equals("")) {
			currentPage = "1";
		}
		
		int cPage = Integer.parseInt(currentPage);
		paging.setPageNo(cPage);
		
		paging.setPageBlock(3);
		
		int pPage = cPage == 1 ? 1 : cPage - 1;
		paging.setPrevPageNo(pPage);
		
		int nPage = cPage == paging.getEndPageNo() ? cPage : cPage + 1;
		paging.setNextPageNo(nPage);
		
		if (opt == null && search == null) {
			paging.setTotalCount(dao.getAllCount());
		} else {
			paging.setTotalCount(dao.getKeywordCount(opt, search));
		}
		
		if (opt == null && search == null) {
			ArrayList<BoardVO> allList = dao.getList(currentPage, pageSize);// dao.selectAll();
			request.setAttribute("list", allList);
		} else {
			ArrayList<BoardVO> keyList = dao.getKeywordList(currentPage, pageSize, opt, search);
			request.setAttribute("list", keyList);
		}
		
		request.setAttribute("params", paging);
		request.setAttribute("opt", opt);
		request.setAttribute("search", search);
		request.setAttribute("totalCount", paging.getTotalCount());
		
		HttpSession session = request.getSession();
		request.setAttribute("session_id", session.getAttribute("id"));
		
		String viewPage = "jsp/board/boardList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
