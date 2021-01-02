package co.semi.comment.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.semi.dao.CommentsDAO;
import co.semi.vo.CommentsVO;

@WebServlet("/CommentWrite.do")
public class CommentWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommentWriteController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		CommentsDAO dao = new CommentsDAO();
		CommentsVO c_vo = new CommentsVO();

		int comment_board = Integer.parseInt(request.getParameter("comment_board"));
		String comment_id = request.getParameter("comment_id");
		String comment_content = request.getParameter("comment_content");

		c_vo.setCommentnumber(dao.getSeq());
		c_vo.setBoardnumber(comment_board);
		c_vo.setMemberid(comment_id);
		c_vo.setCommentcontent(comment_content);

		boolean result = dao.insertComment(c_vo);
		
		if(result){
            response.setContentType("text/html;charset=euc-kr");
            PrintWriter out = response.getWriter();
            out.println("1");
            out.close();
        }

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
