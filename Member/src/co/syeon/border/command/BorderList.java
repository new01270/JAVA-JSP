package co.syeon.border.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.syeon.border.dao.BorderDao;
import co.syeon.border.vo.BorderVO;
import co.syeon.common.BorderCommand;

// borderList Command.
public class BorderList implements BorderCommand {

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 리스트 기능
		BorderDao dao = new BorderDao();
		ArrayList<BorderVO> blist = dao.selectAll();
		request.setAttribute("list", blist);

		return "jsp/border/borderList.jsp";
	}

}
