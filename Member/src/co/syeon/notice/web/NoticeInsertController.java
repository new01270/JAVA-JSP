package co.syeon.notice.web;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import co.syeon.notice.dao.NoticeDAO;
import co.syeon.notice.vo.NoticeVO;

@WebServlet("/NoticeInsert.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
		maxFileSize = 1024 * 1024 * 200, // 200 MB
		maxRequestSize = 1024 * 1024 * 200) // 200 MB
public class NoticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "uploadFile"; // 파일업로드 경로

	public NoticeInsertController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		NoticeDAO dao = new NoticeDAO();
		NoticeVO vo = new NoticeVO();

		HttpSession session = request.getSession();
		vo.setNoticewriter((String) session.getAttribute("name"));// 이런식으로 담는게 정석 세션에 저장된 값을 어츠리부ㅠ트로 들고오고 스트링 형변환해주시
		// vo.setNoticeWriter("관리자");
		vo.setNoticetitle(request.getParameter("title"));
		vo.setNoticecontent(request.getParameter("content"));

		// 서버의 실제 경로
		String applicationPath = request.getServletContext().getRealPath("/");
		String uploadFilePath = applicationPath + UPLOAD_DIR;// "uploadFile"

		System.out.println(uploadFilePath);// 실경로가 정확히 되는지 보기위해서
		// File fileSaveDir = new File(uploadFilePath);

		// 파일 경로 없으면 생성

		// if (!fileSaveDir.exists()) {
		// fileSaveDir.mkdirs();
		// }

		/* String fileName = null; */// 파일네임 ㄱ담아서 디비에 넣어주기
		// Get all the parts from request and write it to the file on server
		String fileName = null;
		for (Part part : request.getParts()) { // 파일명 찾기 및 파일 업로드
			String contentDisp = part.getHeader("content-disposition");
			String[] tokens = contentDisp.split(";");
			for (String str : tokens) {
				if (str.trim().startsWith("filename")) {
					System.out.println(str.substring(str.indexOf("=") + 2, str.length() - 1));
					fileName = str.substring(str.indexOf("=") + 2, str.length() - 1);
					part.write(uploadFilePath + File.separator + fileName);
				}
			}
		}
		System.out.println(fileName);
		vo.setNoticewriter((String) session.getAttribute("name"));
		vo.setNoticetitle(request.getParameter("title"));
		vo.setNoticecontent(request.getParameter("content"));
		vo.setNoticeattach(fileName);
		int n = dao.insert(vo);// 이곳에 돌려줄 페이지 작성

		if (n != 0) {
			response.sendRedirect("/Member/NoticeList.do");
		} else {
			// 둥록 실패 페이지로 보냄
		}
	}

	/*
	 * for (Part part : request.getParts()) { part.getName();
	 * 
	 * System.out.println(part.getName().getBytes());
	 * 
	 * }
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * Utility method to get file name from HTTP header content-disposition
	 */
	private String getFileName(Part part) { // filename구해서 서버에 저장
		String contentDisp = part.getHeader("content-disposition");
		System.out.println(" LOG :: content-disposition 헤더 :: = " + contentDisp);
		String[] tokens = contentDisp.split(";");
		for (String token : tokens) {
			if (token.trim().startsWith("attachfile")) {
				System.out.println(" LOG :: 파일 이름 :: " + token);
				return token.substring(token.indexOf("=") + 2, token.length() - 1);
			}
		}
		return null;
	}

}
