package co.syeon.mem.web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.syeon.common.TestDAO;
import co.syeon.mem.vo.TestVO;

@WebServlet("/Sign.do")
public class SignController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		TestVO vo = new TestVO();
		TestDAO dao = new TestDAO();
		
		vo.setId(request.getParameter("id"));
		vo.setName(request.getParameter("name"));
		vo.setPassword(request.getParameter("password"));
		vo.setSigndate(Date.valueOf(request.getParameter("date")));
		vo = dao.insert(vo);
		
		request.setAttribute("vo", vo);
		String viewPage = "jsp/loginResult.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
