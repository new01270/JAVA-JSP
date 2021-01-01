package co.semi.dao;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.semi.vo.BoardVO;

/**
 * Servlet implementation class BoardEditController
 */
@WebServlet("/BoardEdit.do")
public class BoardEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardEditController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setBoardnumber(Integer.parseInt(request.getParameter("id")));
		vo.setBoardtitle(request.getParameter("bTitle"));
		vo.setBoardcontent(request.getParameter("bContent"));
		int n= dao.update(vo);
		if(n!=0) {
			response.sendRedirect("/MiniProject/BoardList.do");
		}else {
			String msg="수정 실패";
			request.setAttribute("msg", msg);
			String viewPage = "jsp/board/inputError.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
