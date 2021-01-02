package co.semi.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.semi.common.DAO;
import co.semi.vo.EduVO;

public class EduDAO extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

	private final String subject_pro = "select * from edu where edusubject=?";
	private final String edu_new = "SELECT * FROM ( SELECT * FROM edu ORDER BY edunumber DESC ) WHERE ROWNUM <= 4";
	private final String edu_hit = "SELECT * FROM ( SELECT * FROM edu ORDER BY eduhit DESC ) WHERE ROWNUM <= 4";
	private final String edu_programming = "SELECT * FROM ( SELECT * FROM edu ORDER BY eduhit DESC ) WHERE edusubject='programming' AND ROWNUM <= 4";
	private final String edu_network = "SELECT * FROM ( SELECT * FROM edu ORDER BY eduhit DESC ) WHERE edusubject='network' AND ROWNUM <= 4";
	private final String edu_database = "SELECT * FROM ( SELECT * FROM edu ORDER BY eduhit DESC ) WHERE edusubject='database' AND ROWNUM <= 4";
	private final String edu_skill = "SELECT * FROM ( SELECT * FROM edu ORDER BY eduhit DESC ) WHERE edusubject='skill' AND ROWNUM <= 4";
	private final String edu_career = "SELECT * FROM ( SELECT * FROM edu ORDER BY eduhit DESC ) WHERE edusubject='career' AND ROWNUM <= 4";
	private final String edu_life = "SELECT * FROM ( SELECT * FROM edu ORDER BY eduhit DESC ) WHERE edusubject='life' AND ROWNUM <= 4";
	private final String edu_search = "SELECT * FROM edu WHERE eduKeyword LIKE ? OR edutitle LIKE ? OR eduskill LIKE ?";
	private final String hit_update = "update edu set eduhit = eduhit +1 where edunumber=?";
	private final String selectDescOne = "select * from where edunumber=?";
	private final String selectOne = "select * from edu where edunumber=?";

	public ArrayList<EduVO> programmingList(EduVO vo) {
		ArrayList<EduVO> list = new ArrayList<EduVO>();

		try {
			psmt = conn.prepareStatement(subject_pro);
			psmt.setString(1, vo.getEduSubject());
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new EduVO();
				vo.setMemberId(rs.getString("MEMBERID"));
				vo.setEduNumber(rs.getInt("EDUNUMBER"));
				vo.setEduTitle(rs.getString("EDUTITLE"));
				vo.setEduPrice(rs.getString("EDUPRICE"));
				vo.setEduLecturer(rs.getString("EDULECTURER"));
				vo.setEduSubject(rs.getString("EDUSUBJECT"));
				vo.setEduHit(rs.getInt("EDUHIT"));
				vo.setEduDifficulty(rs.getString("EDUDIFFICULTY"));
				vo.setEduSkill(rs.getString("EDUSKILL"));
				vo.setEduKeyword(rs.getString("EDUKEYWORD"));
				vo.setEduImg(rs.getString("eduimg"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<EduVO> getMainList(EduVO vo) {
		ArrayList<EduVO> list = new ArrayList<EduVO>();
		try {
			psmt = conn.prepareStatement(edu_new);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new EduVO();
				vo.setMemberId(rs.getString("MEMBERID"));
				vo.setEduNumber(rs.getInt("EDUNUMBER"));
				vo.setEduTitle(rs.getString("EDUTITLE"));
				vo.setEduPrice(rs.getString("EDUPRICE"));
				vo.setEduLecturer(rs.getString("EDULECTURER"));
				vo.setEduSubject(rs.getString("EDUSUBJECT"));
				vo.setEduHit(rs.getInt("EDUHIT"));
				vo.setEduDifficulty(rs.getString("EDUDIFFICULTY"));
				vo.setEduSkill(rs.getString("EDUSKILL"));
				vo.setEduKeyword(rs.getString("EDUKEYWORD"));
				vo.setEduImg(rs.getString("eduimg"));
				list.add(vo);
			}

			psmt = conn.prepareStatement(edu_hit);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new EduVO();
				vo.setMemberId(rs.getString("MEMBERID"));
				vo.setEduNumber(rs.getInt("EDUNUMBER"));
				vo.setEduTitle(rs.getString("EDUTITLE"));
				vo.setEduPrice(rs.getString("EDUPRICE"));
				vo.setEduLecturer(rs.getString("EDULECTURER"));
				vo.setEduSubject(rs.getString("EDUSUBJECT"));
				vo.setEduHit(rs.getInt("EDUHIT"));
				vo.setEduDifficulty(rs.getString("EDUDIFFICULTY"));
				vo.setEduSkill(rs.getString("EDUSKILL"));
				vo.setEduKeyword(rs.getString("EDUKEYWORD"));
				vo.setEduImg(rs.getString("eduimg"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public ArrayList<EduVO> getEduList(EduVO vo) {
		ArrayList<EduVO> list = new ArrayList<EduVO>();
		try {
			psmt = conn.prepareStatement(edu_programming);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new EduVO();
				vo.setMemberId(rs.getString("MEMBERID"));
				vo.setEduNumber(rs.getInt("EDUNUMBER"));
				vo.setEduTitle(rs.getString("EDUTITLE"));
				vo.setEduPrice(rs.getString("EDUPRICE"));
				vo.setEduLecturer(rs.getString("EDULECTURER"));
				vo.setEduSubject(rs.getString("EDUSUBJECT"));
				vo.setEduHit(rs.getInt("EDUHIT"));
				vo.setEduDifficulty(rs.getString("EDUDIFFICULTY"));
				vo.setEduSkill(rs.getString("EDUSKILL"));
				vo.setEduKeyword(rs.getString("EDUKEYWORD"));
				vo.setEduImg(rs.getString("eduimg"));
				list.add(vo);
			}

			psmt = conn.prepareStatement(edu_network);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new EduVO();
				vo.setMemberId(rs.getString("MEMBERID"));
				vo.setEduNumber(rs.getInt("EDUNUMBER"));
				vo.setEduTitle(rs.getString("EDUTITLE"));
				vo.setEduPrice(rs.getString("EDUPRICE"));
				vo.setEduLecturer(rs.getString("EDULECTURER"));
				vo.setEduSubject(rs.getString("EDUSUBJECT"));
				vo.setEduHit(rs.getInt("EDUHIT"));
				vo.setEduDifficulty(rs.getString("EDUDIFFICULTY"));
				vo.setEduSkill(rs.getString("EDUSKILL"));
				vo.setEduKeyword(rs.getString("EDUKEYWORD"));
				vo.setEduImg(rs.getString("eduimg"));
				list.add(vo);
			}

			psmt = conn.prepareStatement(edu_database);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new EduVO();
				vo.setMemberId(rs.getString("MEMBERID"));
				vo.setEduNumber(rs.getInt("EDUNUMBER"));
				vo.setEduTitle(rs.getString("EDUTITLE"));
				vo.setEduPrice(rs.getString("EDUPRICE"));
				vo.setEduLecturer(rs.getString("EDULECTURER"));
				vo.setEduSubject(rs.getString("EDUSUBJECT"));
				vo.setEduHit(rs.getInt("EDUHIT"));
				vo.setEduDifficulty(rs.getString("EDUDIFFICULTY"));
				vo.setEduSkill(rs.getString("EDUSKILL"));
				vo.setEduKeyword(rs.getString("EDUKEYWORD"));
				vo.setEduImg(rs.getString("eduimg"));
				list.add(vo);
			}

			psmt = conn.prepareStatement(edu_skill);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new EduVO();
				vo.setMemberId(rs.getString("MEMBERID"));
				vo.setEduNumber(rs.getInt("EDUNUMBER"));
				vo.setEduTitle(rs.getString("EDUTITLE"));
				vo.setEduPrice(rs.getString("EDUPRICE"));
				vo.setEduLecturer(rs.getString("EDULECTURER"));
				vo.setEduSubject(rs.getString("EDUSUBJECT"));
				vo.setEduHit(rs.getInt("EDUHIT"));
				vo.setEduDifficulty(rs.getString("EDUDIFFICULTY"));
				vo.setEduSkill(rs.getString("EDUSKILL"));
				vo.setEduKeyword(rs.getString("EDUKEYWORD"));
				vo.setEduImg(rs.getString("eduimg"));
				list.add(vo);
			}

			psmt = conn.prepareStatement(edu_career);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new EduVO();
				vo.setMemberId(rs.getString("MEMBERID"));
				vo.setEduNumber(rs.getInt("EDUNUMBER"));
				vo.setEduTitle(rs.getString("EDUTITLE"));
				vo.setEduPrice(rs.getString("EDUPRICE"));
				vo.setEduLecturer(rs.getString("EDULECTURER"));
				vo.setEduSubject(rs.getString("EDUSUBJECT"));
				vo.setEduHit(rs.getInt("EDUHIT"));
				vo.setEduDifficulty(rs.getString("EDUDIFFICULTY"));
				vo.setEduSkill(rs.getString("EDUSKILL"));
				vo.setEduKeyword(rs.getString("EDUKEYWORD"));
				vo.setEduImg(rs.getString("eduimg"));
				list.add(vo);
			}

			psmt = conn.prepareStatement(edu_life);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new EduVO();
				vo.setMemberId(rs.getString("MEMBERID"));
				vo.setEduNumber(rs.getInt("EDUNUMBER"));
				vo.setEduTitle(rs.getString("EDUTITLE"));
				vo.setEduPrice(rs.getString("EDUPRICE"));
				vo.setEduLecturer(rs.getString("EDULECTURER"));
				vo.setEduSubject(rs.getString("EDUSUBJECT"));
				vo.setEduHit(rs.getInt("EDUHIT"));
				vo.setEduDifficulty(rs.getString("EDUDIFFICULTY"));
				vo.setEduSkill(rs.getString("EDUSKILL"));
				vo.setEduKeyword(rs.getString("EDUKEYWORD"));
				vo.setEduImg(rs.getString("eduimg"));
				list.add(vo);
			}
			System.out.println(list);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<EduVO> searchList(String parameter) {

		System.out.println(parameter);
		ArrayList<EduVO> list = new ArrayList<EduVO>();
		try {
			psmt = conn.prepareStatement(edu_search);
			psmt.setString(1, "%" + parameter + "%");
			psmt.setString(2, "%" + parameter + "%");
			psmt.setString(3, "%" + parameter + "%");
			rs = psmt.executeQuery();
			while (rs.next()) {
				EduVO vo = new EduVO();
				vo.setMemberId(rs.getString("MEMBERID"));
				vo.setEduNumber(rs.getInt("EDUNUMBER"));
				vo.setEduTitle(rs.getString("EDUTITLE"));
				vo.setEduPrice(rs.getString("EDUPRICE"));
				vo.setEduLecturer(rs.getString("EDULECTURER"));
				vo.setEduSubject(rs.getString("EDUSUBJECT"));
				vo.setEduHit(rs.getInt("EDUHIT"));
				vo.setEduDifficulty(rs.getString("EDUDIFFICULTY"));
				vo.setEduSkill(rs.getString("EDUSKILL"));
				vo.setEduKeyword(rs.getString("EDUKEYWORD"));
				vo.setEduImg(rs.getString("eduimg"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public EduVO selectDescOne(EduVO vo) {
		try {
			psmt = conn.prepareStatement(selectDescOne);
			psmt.setInt(1, vo.getEduNumber());
			rs = psmt.executeQuery();
			if (rs.next()) {
				psmt = conn.prepareStatement(hit_update);
				psmt.setInt(1, vo.getEduNumber());
				psmt.execute();
				vo.setMemberId(rs.getString("MEMBERID"));
				vo.setEduNumber(rs.getInt("EDUNUMBER"));
				vo.setEduTitle(rs.getString("EDUTITLE"));
				vo.setEduPrice(rs.getString("EDUPRICE"));
				vo.setEduLecturer(rs.getString("EDULECTURER"));
				vo.setEduSubject(rs.getString("EDUSUBJECT"));
				vo.setEduHit(rs.getInt("EDUHIT"));
				vo.setEduDifficulty(rs.getString("EDUDIFFICULTY"));
				vo.setEduSkill(rs.getString("EDUSKILL"));
				vo.setEduKeyword(rs.getString("EDUKEYWORD"));
				vo.setEduImg(rs.getString("eduimg"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public EduVO selectOne(EduVO vo) {

		try {
			psmt = conn.prepareStatement(selectOne);
			psmt.setInt(1, vo.getEduNumber());
			rs = psmt.executeQuery();
			if (rs.next()) {
				psmt = conn.prepareStatement(hit_update);
				psmt.setInt(1, vo.getEduNumber());
				psmt.execute();
				vo.setMemberId(rs.getString("MEMBERID"));
				vo.setEduNumber(rs.getInt("EDUNUMBER"));
				vo.setEduTitle(rs.getString("EDUTITLE"));
				vo.setEduPrice(rs.getString("EDUPRICE"));
				vo.setEduLecturer(rs.getString("EDULECTURER"));
				vo.setEduSubject(rs.getString("EDUSUBJECT"));
				vo.setEduHit(rs.getInt("EDUHIT"));
				vo.setEduDifficulty(rs.getString("EDUDIFFICULTY"));
				vo.setEduSkill(rs.getString("EDUSKILL"));
				vo.setEduKeyword(rs.getString("EDUKEYWORD"));
				vo.setEduImg(rs.getString("eduimg"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

}
