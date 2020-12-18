package co.syeon.border.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.syeon.border.command.BorderList;
import co.syeon.border.command.Paging;
import co.syeon.border.dao.BorderDao;
import co.syeon.common.BorderCommand;

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
		// 여기가 게시판 관련 처리

		request.setCharacterEncoding("utf-8");

		BorderCommand command = new BorderList(); // 선언!!! command들을 List에 담아 실행명령 선언.
		BorderDao dao = new BorderDao();
		Paging paging = new Paging();
		
		paging.setPageSize(10);// 페이지에 파라미터로 넘겨보기
		paging.setTotalCount(dao.getAllCount());
		String currentPage = request.getParameter("pageNum");
		if (currentPage == null || currentPage.equals("")) {
			currentPage = "1";
		}
		int cPage = Integer.parseInt(currentPage);
		int pPage = cPage == 1 ? 1 : cPage - 1;
		int nPage = cPage == paging.getEndPageNo() ? cPage : cPage + 1;
		paging.setPageNo(cPage);
		paging.setPrevPageNo(pPage);
		paging.setNextPageNo(nPage);

		request.setAttribute("pageSize", paging.getPageSize());
		request.setAttribute("params", paging);

		System.out.println(paging);

		String viewPage = command.action(request, response); 
		// 호출!!! 실행명령 호출. 
		//viewpage에 BorderList()의 return값  "jsp/border/borderList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); 
		// 호출페이지 전달!!! 보여줄 페이지 선택. (값을 유지하기위해 dispatcher 사용)
		dispatcher.forward(request, response); // Client에게 값, request, response("jsp/border/borderList.jsp";) 함께 전달.

	}

}
