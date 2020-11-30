package co.syeon.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.syeon.command.ActionCommand;
import co.syeon.command.LoginFormActionCommand;
import co.syeon.command.LoginResultActionCommand;
import co.syeon.command.MainActionCommand;

//@WebServlet(description = "모든요청을 처리하는 컨트롤러", urlPatterns = { "/FrontController" }) 대신 web.xml 매핑.
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, ActionCommand> map = new HashMap<String, ActionCommand>();
	
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		// 여기 요청 주소를 써 넣으면 됨. init: 최초 한번 실행.
		
		map.put("/main.do", new MainActionCommand());
		map.put("/loginForm.do", new LoginFormActionCommand());
		map.put("/loginCheck.do", new LoginResultActionCommand());
//		map.put("/main.do", new MainActionCommand());
//		map.put("/main.do", new MainActionCommand());
//		map.put("/main.do", new MainActionCommand());
//		map.put("/main.do", new MainActionCommand());
//		map.put("/main.do", new MainActionCommand());
//		map.put("/main.do", new MainActionCommand());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 여기 실제 서비스 할 내용을 쓰면 됨. service: 요청 할 때마다 실행.
		
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();	// 요청 분석을 위해 URI 값을 구함.
		String contextPath = request.getContextPath();	// contextPath 값을 구함.
		String path = uri.substring(contextPath.length());	// 실제 요청 경로를 구함.
		
		ActionCommand command = map.get(path);	// 수행 할 Model 구함.
		/*
		 ActionCommand command = new MainActionCommand();	
		 위 코드처럼 매번 가져오지 않고 MAP에 담아뒀던  map.put("key", "value값(new객체 초기화)")을
		  구분해서 가져옴  map.get(key).
		*/
		
		String viewPage = command.action(request, response);	// Model 수행 후 결과와 view(jsp page)를 돌려받음.
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);	// forward 객체 생성.
		dispatcher.forward(request, response);	// 결과 페이지를 돌려준다.
	}

}
