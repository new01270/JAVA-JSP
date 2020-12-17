package co.syeon.notice.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.syeon.notice.dao.NoticeDAO;
import co.syeon.notice.vo.NoticeVO;

@WebServlet("/NoticeKeyword.do")
public class NoticeKeywordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeKeywordController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opt = request.getParameter("opt");
		String condition = request.getParameter("condition");

		HashMap<String, Object> search = new HashMap<String, Object>();
		search.put("opt", opt);
		search.put("condition", condition);

		NoticeDAO dao = new NoticeDAO();
		ArrayList<NoticeVO> slist = dao.getBoardList(search);
		request.setAttribute("list", slist);

		String viewPage = "jsp/border/noticeList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
