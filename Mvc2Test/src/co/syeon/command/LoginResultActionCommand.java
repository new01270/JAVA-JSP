package co.syeon.command;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginResultActionCommand implements ActionCommand {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
		// header.jsp 에서 로그인 정보를 호출하는 'loginCheck.do' key
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String msg;
		
		if(id.equals("syeon") && password.equals("1234")) {
			msg = "서수연 님 환영합니다.";
		}else {
			msg = id + "님 아이디 또는 비밀번호가 일치하지 않습니다.";					
		}
		request.setAttribute("msg", msg);	// key, data. 메세지를 보여 줄 페이지에 전달.(jsp/member/loginCheck.jsp)
		// 위 문장은 처리한 data를 request 객체에 실어 보냄.
		return "jsp/member/loginCheck.jsp";
	}

}
