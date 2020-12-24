package co.syeon.border.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.syeon.border.command.Paging;
import co.syeon.border.dao.BorderDao;
import co.syeon.border.vo.BorderVO;

@WebServlet("/BorderList.do") // one컨트롤러+one커맨드
public class BorderListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BorderListController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 게시판 관련 처리
		// BorderCommand command = new BorderList();
		// 선언!!! command들을 List에 담아 실행명령 선언. -> BorderList.java 에서 처리.

		request.setCharacterEncoding("utf-8");

		BorderDao dao = new BorderDao();
		Paging paging = new Paging();

		String opt = request.getParameter("opt");
		String condition = request.getParameter("condition");
		System.out.println(opt + condition);

		// pageSize
		paging.setPageSize(5);// 페이지에 파라미터로 넘겨보기
		request.setAttribute("pageSize", paging.getPageSize());
		Integer pageSize = (Integer) request.getAttribute("pageSize");

		// pageNo
		String currentPage = request.getParameter("pageNum");
		if (currentPage == null || currentPage.equals("")) {
			currentPage = "1";
		}
		int cPage = Integer.parseInt(currentPage);
		paging.setPageNo(cPage);

		// pageBlock
		paging.setPageBlock(5);

		// prevPage
		int pPage = cPage == 1 ? 1 : cPage - 1;
		paging.setPrevPageNo(pPage);

		// nextPage
		int nPage = cPage == paging.getEndPageNo() ? cPage : cPage + 1;
		paging.setNextPageNo(nPage);

		// totalCount : DB의 튜플개수
		if (opt == null && condition == null) {
			paging.setTotalCount(dao.getAllCount());
		} else {
			paging.setTotalCount(dao.getKeywordCount(opt, condition));
		}

		// 페이징 리스트
		if (opt == null && condition == null) {
			ArrayList<BorderVO> allList = dao.getList(currentPage, pageSize);// dao.selectAll();
			request.setAttribute("list", allList);
		} else {
			ArrayList<BorderVO> keyList = dao.getKeywordList(currentPage, pageSize, opt, condition);
			request.setAttribute("list", keyList);
		}

		request.setAttribute("params", paging);
		request.setAttribute("opt", opt);
		request.setAttribute("condition", condition);
		request.setAttribute("totalCount", paging.getTotalCount());

		System.out.println(paging);

		String viewPage = "jsp/border/borderList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		// Client에게 값, request, response("jsp/border/borderList.jsp";) 함께 전달.
		// 호출페이지 전달!!! 보여줄 페이지 선택. (값을 유지하기위해 dispatcher 사용)

	}

}
