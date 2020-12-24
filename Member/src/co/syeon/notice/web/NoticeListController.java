package co.syeon.notice.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.syeon.border.command.Paging;
import co.syeon.notice.dao.NoticeDAO;
import co.syeon.notice.vo.NoticeVO;

@WebServlet("/NoticeList.do")
public class NoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeListController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		NoticeDAO dao = new NoticeDAO();
		Paging paging = new Paging();

		// 검색 옵션, 검색어
		String opt = request.getParameter("opt");
		String condition = request.getParameter("condition");

		// pageSize
		paging.setPageSize(7);
		request.setAttribute("pageSizeNo", paging.getPageSize()); // 위 setPageSize를 불러온다.
		Integer pageSize = (Integer) request.getAttribute("pageSizeNo");

		// pageBlock
		paging.setPageBlock(5);

		// pageNo
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null || pageNum.equals("")) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		paging.setPageNo(currentPage);

		// prevPage
		int prevPage = currentPage == 1 ? 1 : currentPage - 1;
		paging.setPrevPageNo(prevPage);

		// nextPage
		int nextPage = currentPage == paging.getEndPageNo() ? currentPage : currentPage + 1;
		paging.setNextPageNo(nextPage);

		// totalCount
		if (opt == null && condition == null) {
			paging.setTotalCount(dao.getAllCount());
		} else {
			paging.setTotalCount(dao.getKeywordCount(opt, condition));
		}

		// 리스트 불러오기
		if (opt == null && condition == null) {
			ArrayList<NoticeVO> allList = dao.getNoticeAllList(currentPage, pageSize);
			request.setAttribute("list", allList);
		} else {
			ArrayList<NoticeVO> keyList = dao.getKeywordList(condition, opt, currentPage, pageSize);
			request.setAttribute("list", keyList);
		}

		request.setAttribute("params", paging);
		request.setAttribute("opt", opt);
		request.setAttribute("condition", condition);
		request.setAttribute("totalCount", paging.getTotalCount());

		String viewPage = "jsp/notice/noticeList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
