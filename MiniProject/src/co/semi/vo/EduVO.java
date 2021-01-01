package co.semi.vo;

public class EduVO {
	private String memberId;
	private int eduNumber;
	private String eduTitle;
	private String eduPrice;
	private String eduLecturer;
	private String eduSubject;
	private int eduHit;
	private String eduDifficulty;
	private String eduSkill;
	private String eduKeyword;
	private String eduImg;
	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getEduNumber() {
		return eduNumber;
	}
	public void setEduNumber(int eduNumber) {
		this.eduNumber = eduNumber;
	}
	public String getEduTitle() {
		return eduTitle;
	}
	public void setEduTitle(String eduTitle) {
		this.eduTitle = eduTitle;
	}
	public String getEduPrice() {
		return eduPrice;
	}
	public void setEduPrice(String eduPrice) {
		this.eduPrice = eduPrice;
	}
	public String getEduLecturer() {
		return eduLecturer;
	}
	public void setEduLecturer(String eduLecturer) {
		this.eduLecturer = eduLecturer;
	}
	public String getEduSubject() {
		return eduSubject;
	}
	public void setEduSubject(String eduSubject) {
		this.eduSubject = eduSubject;
	}
	public int getEduHit() {
		return eduHit;
	}
	public void setEduHit(int eduHit) {
		this.eduHit = eduHit;
	}
	public String getEduDifficulty() {
		return eduDifficulty;
	}
	public void setEduDifficulty(String eduDifficulty) {
		this.eduDifficulty = eduDifficulty;
	}
	public String getEduSkill() {
		return eduSkill;
	}
	public void setEduSkill(String eduSkill) {
		this.eduSkill = eduSkill;
	}
	public String getEduKeyword() {
		return eduKeyword;
	}
	public void setEduKeyword(String eduKeyword) {
		this.eduKeyword = eduKeyword;
	}
	public String getEduImg() {
		return eduImg;
	}
	public void setEduImg(String eduImg) {
		this.eduImg = eduImg;
	}
	@Override
	public String toString() {
		return "EduVO [memberId=" + memberId + ", eduNumber=" + eduNumber + ", eduTitle=" + eduTitle + ", eduPrice="
				+ eduPrice + ", eduLecturer=" + eduLecturer + ", eduSubject=" + eduSubject + ", eduHit=" + eduHit
				+ ", eduDifficulty=" + eduDifficulty + ", eduSkill=" + eduSkill + ", eduKeyword=" + eduKeyword
				+ ", eduImg=" + eduImg + "]";
	}

	
}