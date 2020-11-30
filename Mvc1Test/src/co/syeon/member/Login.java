package co.syeon.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id"); // Form에서 입력한 아이디와 비밀번호 값은 request 객체에 저장되어있다.
//		String password = request.getParameter("password");
		String msg;

		if (id.equals("hong")) {
			msg = "홍길동 님 환영합니다.";
		}else {
			msg = "아이디가 존재하지 않습니다.";
		}
		
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.print("<div align='center'>");
		out.print("<h1>" + msg + "</h1>");
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
