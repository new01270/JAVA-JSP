package co.semi.member.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.semi.dao.MemberDAO;

@WebServlet("/IdDuplication.do")
public class IdDuplicationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IdDuplicationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		MemberDAO dao = new MemberDAO();
		
		// 서블릿에서 ajax로 받아온 id값
		String id = request.getParameter("id");
		response.getWriter().write(dao.duplicationCheck(id) + "");	// 받은 아이디를 체크 후 return할 값은 ajax에서 success(result)값.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
