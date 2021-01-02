package co.semi.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.semi.common.DAO;
import co.semi.vo.CommentsVO;

public class CommentsDAO extends DAO {

	PreparedStatement psmt;
	ResultSet rs;
	private final String select_comments = "SELECT LEVEL, commentnumber, boardnumber, memberid, commentdate, commentparent, commentcontent "
											+ "FROM comments WHERE boardnumber=? "
											+ "START WITH commentparent=0 CONNECT BY PRIOR commentnumber = commentparent";

	public ArrayList<CommentsVO> comment_list(CommentsVO vo) {
		ArrayList<CommentsVO> list = new ArrayList<CommentsVO>();
		try {
			psmt = conn.prepareStatement(select_comments);
			psmt.setInt(1, vo.getBoardnumber());
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new CommentsVO();
				vo.setCommentlevel(rs.getInt("level"));
				vo.setBoardnumber(rs.getInt("boardnumber"));
				vo.setCommentcontent(rs.getString("commentcontent"));
				vo.setCommentdate(rs.getDate("commentdate"));
				vo.setCommentnumber(rs.getInt("commentnumber"));
				vo.setCommentparent(rs.getInt("commentparent"));
				vo.setMemberid(rs.getString("memberid"));
				list.add(vo);
				System.out.println("리스트리뷰");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return list;

	}
	
	/* 댓글의 페이지 처리를 하고싶다면 이 쿼리를 사용하면 된다.
     * SELECT * FROM
     *            (SELECT  ROWNUM AS RNUM,
     *                   DATA.*
     *             FROM
     *                   (SELECT LEVEL,
     *                           COMMENTNUMBER,
     *                             BOARDNUMBER,
     *                           MEMBERID,
     *                           COMMENTDATE,
     *                           COMMENTPARENT,
     *                           COMMENTCONTENT
     *                    FROM COMMENTS
     *                    WHERE BOARDNUMBER = ?
     *                   START WITH COMMENTPARENT = 0
     *                   CONNECT BY PRIOR COMMENTNUMBER = COMMENTPARENT) 
     *              DATA)
     *    WHERE BETWEEN RNUM>=? AND RNUM<=? ;
	*/


	private final String select_seq = "SELECT r_seq.nextval FROM dual";

	public int getSeq() {
		int result = 1;
		try {
			psmt = conn.prepareStatement(select_seq);
			rs = psmt.executeQuery();
			if (rs.next())
				result = rs.getInt(1); // 첫번째 튜플을 가져온다.
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	private final String insert_comment = "INSERT INTO comments(commentnumber, boardnumber, memberid, commentdate, commentparent, commentcontent) VALUES(?,?,?,sysdate,?,?)";
	public boolean insertComment(CommentsVO vo) {
		boolean result = false;
		try {
			psmt = conn.prepareStatement(insert_comment);
			psmt.setInt(1, vo.getCommentnumber());
			psmt.setInt(2, vo.getBoardnumber());
			psmt.setString(3, vo.getMemberid());
			psmt.setDate(4, (Date) vo.getCommentdate());
			psmt.setInt(5, vo.getCommentparent());
			psmt.setString(6, vo.getCommentcontent());
			int n = psmt.executeUpdate();
			if(n != 0) {
				result = true;
				conn.commit();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private void close()
    {
        try {
            if ( psmt != null ){ psmt.close(); psmt=null; }
            if ( conn != null ){ conn.close(); conn=null;    }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }



}
