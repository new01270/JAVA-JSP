package co.syeon.command;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFormActionCommand implements ActionCommand {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
		// header.jsp 에서 로그인 페이지를 호출하는 'loginForm.do' key
		return "jsp/member/loginForm.jsp";
	}

}
