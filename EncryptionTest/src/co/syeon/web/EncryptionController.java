package co.syeon.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.syeon.dao.EnDAO;
import co.syeon.vo.enVO;

@WebServlet("/Encryption.do")
public class EncryptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EncryptionController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		EnDAO dao = new EnDAO();
		enVO vo = new enVO();

		vo.setId(Integer.parseInt(request.getParameter("id")));
		vo.setPassword(request.getParameter("password"));

		String pw = request.getParameter("password");

		String enPW = "";
		for (int i = pw.length() - 1; i >= 0; i--) {
			System.out.print(pw.charAt(i));
			enPW += (char) ((int) pw.charAt(i) - 3);
		}
		// String enPW = String.valueOf(change);

		System.out.println("변환 전  문자" + pw);
		System.out.println("변환 된 문자 : " + enPW);

		vo.setEncryptionpassword(enPW);

		int n = dao.insert(vo);

		String viewPage = "jsp/loginMsg.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
