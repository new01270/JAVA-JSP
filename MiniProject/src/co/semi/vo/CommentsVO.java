package co.semi.vo;

import java.util.Date;

/*
CREATE TABLE comments
(
  commentnumber NUMBER NOT NULL,
  boardnumber NUMBER NOT NULL,
  memberid varchar2(30),
  commentdate DATE, 
  commentparent NUMBER,
  commentcontent VARCHAR2(1000) NOT NULL,
);
ALTER TABLE comments
       ADD  ( FOREIGN KEY (boardnumber)
                             REFERENCES BOARD ) ;
                             
ALTER TABLE comments
       ADD  ( FOREIGN KEY (memberid)
                             REFERENCES member ) ; 
*/

public class CommentsVO {
	private int commentnumber; // 댓글번호
	private int boardnumber; // 댓글의 게시글 BOARD(BOARDNUMBER)
	private String memberid; // 댓글 아이디
	private Date commentdate;
	private int commentparent; // 부모글
	private String commentcontent;
	private int commentlevel;

	public int getCommentlevel() {
		return commentlevel;
	}

	public void setCommentlevel(int commentlevel) {
		this.commentlevel = commentlevel;
	}

	public int getCommentnumber() {
		return commentnumber;
	}

	public void setCommentnumber(int commentnumber) {
		this.commentnumber = commentnumber;
	}

	public int getBoardnumber() {
		return boardnumber;
	}

	public void setBoardnumber(int boardnumber) {
		this.boardnumber = boardnumber;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public Date getCommentdate() {
		return commentdate;
	}

	public void setCommentdate(Date commentdate) {
		this.commentdate = commentdate;
	}

	public int getCommentparent() {
		return commentparent;
	}

	public void setCommentparent(int commentparent) {
		this.commentparent = commentparent;
	}

	public String getCommentcontent() {
		return commentcontent;
	}

	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}

}
