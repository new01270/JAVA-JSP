package co.semi.common;

public class Paging {

	private int pageSize;
	private int firstPageNo;
	private int prevPageNo;
	private int startPageNo;
	private int pageNo;
	private int endPageNo;
	private int nextPageNo;
	private int finalPageNo;
	private int totalCount;
	private int pageBlock;
	private int pageCount;

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageBlock() {
		return pageBlock;
	}

	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getFirstPageNo() {
		return firstPageNo;
	}

	public void setFirstPageNo(int firstPageNo) {
		this.firstPageNo = firstPageNo;
	}

	public int getPrevPageNo() {
		return prevPageNo;
	}

	public void setPrevPageNo(int prevPageNo) {
		this.prevPageNo = prevPageNo;
	}

	public int getStartPageNo() {
		return startPageNo;
	}

	public void setStartPageNo(int startPageNo) {
		this.startPageNo = startPageNo;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getEndPageNo() {
		return endPageNo;
	}

	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}

	public int getNextPageNo() {
		return nextPageNo;
	}

	public void setNextPageNo(int nextPageNo) {
		this.nextPageNo = nextPageNo;
	}

	public int getFinalPageNo() {
		return finalPageNo;
	}

	public void setFinalPageNo(int finalPageNo) {
		this.finalPageNo = finalPageNo;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.makePaging();
	}

	// 페이징 생성
	private void makePaging() {

		if (this.totalCount == 0)
			return;

		if (this.pageNo == 0)
			this.setPageNo(1);

		if (this.pageSize == 0)
			this.setPageSize(5);
		
		if (this.pageBlock == 0)
			this.setPageBlock(7);
		
		int pageCount = totalCount / pageSize + (totalCount % pageSize == 0? 0 : 1);
		this.setPageCount(pageCount);

		int finalPage = (totalCount + (pageSize - 1)) / pageSize;
		if (this.pageNo > finalPage)
			this.setPageNo(finalPage); // 기본 값 설정
		if (this.pageNo < 0 || this.pageNo > finalPage)
			this.pageNo = 1; // 현재 페이지 유효성 체크

		boolean isNowFirst = pageNo == 1 ? true : false; // 시작 페이지 (전체)
		boolean isNowFinal = pageNo == finalPage ? true : false; // 마지막 페이지 (전체)

		int startPage = ((pageNo - 1) / pageBlock) * pageBlock + 1; // 시작 페이지 (페이징 네비 기준)

		int endPage = startPage + pageBlock - 1; // 끝 페이지 (페이징 네비 기준)
		if (endPage > pageCount) { // [마지막 페이지 (페이징 네비 기준) > 마지막 페이지] 보다 큰 경우
			endPage = pageCount;
		}

		this.setFirstPageNo(1); // 첫 번째 페이지 번호

		if (isNowFirst) {
			this.setPrevPageNo(1); // 이전 페이지 번호
		} else {
			this.setPrevPageNo(((pageNo - 1) < 1 ? 1 : (pageNo - 1))); // 이전 페이지 번호
		}

		this.setStartPageNo(startPage); // 시작 페이지 (페이징 네비 기준)
		this.setEndPageNo(endPage); // 끝 페이지 (페이징 네비 기준)
		if (isNowFinal) {
			this.setNextPageNo(finalPage); // 다음 페이지 번호
		} else {
			this.setNextPageNo(((pageNo + 1) > finalPage ? finalPage : (pageNo + 1))); // 다음 페이지 번호
		}

		this.setFinalPageNo(finalPage); // 마지막 페이지 번호
	}

	@Override
	public String toString() {
		return "Paging [pageSize=" + pageSize + ", firstPageNo=" + firstPageNo + ", prevPageNo=" + prevPageNo
				+ ", startPageNo=" + startPageNo + ", pageNo=" + pageNo + ", endPageNo=" + endPageNo + ", nextPageNo="
				+ nextPageNo + ", finalPageNo=" + finalPageNo + ", totalCount=" + totalCount + ", pageBlock="
				+ pageBlock + ", pageCount=" + pageCount + "]";
	}

	
	

}
