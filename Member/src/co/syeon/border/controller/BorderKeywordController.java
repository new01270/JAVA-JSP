package co.syeon.border.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.syeon.border.dao.BorderDao;
import co.syeon.border.vo.BorderVO;

@WebServlet("/BorderKeyword.do")
public class BorderKeywordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BorderKeywordController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 검색기능 list?opt=title,writer,date&condition=aaa;

		String opt = request.getParameter("opt");
		String condition = request.getParameter("condition");

		HashMap<String, Object> search = new HashMap<String, Object>();
		search.put("opt", opt);
		search.put("condition", condition);

		BorderDao dao = new BorderDao();
		ArrayList<BorderVO> slist = dao.getBoardList(search);
		request.setAttribute("list", slist);

		String viewPage = "jsp/border/borderList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
