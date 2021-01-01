package co.semi.edu.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.semi.dao.EduDAO;
import co.semi.vo.EduVO;

/**
 * Servlet implementation class EduProgrammingController
 */
@WebServlet("/EduProgramming.do")
public class EduProgrammingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public EduProgrammingController() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		EduDAO dao = new EduDAO();
		EduVO vo = new EduVO();
		
		vo.setEduSubject(request.getParameter("programming"));
		System.out.println(vo.getEduSubject());
		ArrayList<EduVO> list = dao.programmingList(vo);
		System.out.println(list);
		request.setAttribute("list", list);//"vo"이름으로 vo 담아줘 이걸 jsp에서 쓸거야
		
		String viewPage ="jsp/edu/eduProgramming.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
