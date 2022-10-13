package co.edu.board;

public class Reply {
	private int reNum;
	private int reBNum;
	private String reContent;
	private String reWriter;
	private String reDate;
	
	public Reply() {}

	public Reply(int reNum, int reBNum, String reContent, String reWriter, String reDate) {
		this.reNum = reNum;
		this.reBNum = reBNum;
		this.reContent = reContent;
		this.reWriter = reWriter;
		this.reDate = reDate;
	}
	
	public Reply(int reBNum, String reContent, String reWriter) {
		this.reBNum = reBNum;
		this.reContent = reContent;
		this.reWriter = reWriter;
	}

	public int getReNum() {
		return reNum;
	}

	public void setReNum(int reNum) {
		this.reNum = reNum;
	}

	public int getReBNum() {
		return reBNum;
	}

	public void setReBNum(int reBNum) {
		this.reBNum = reBNum;
	}

	public String getReContent() {
		return reContent;
	}

	public void setReContent(String reContent) {
		this.reContent = reContent;
	}

	public String getReWriter() {
		return reWriter;
	}

	public void setReWriter(String reWriter) {
		this.reWriter = reWriter;
	}

	public String getReDate() {
		return reDate;
	}

	public void setReDate(String reDate) {
		this.reDate = reDate;
	}
	
	@Override
	public String toString() {
		return "[댓글 번호: " + reNum 
				+ ", 원본글 번호: " + reBNum 
				+ ", 댓글내용: " + reContent 
				+ ", 댓글작성자: " + reWriter
				+ ", 댓글작성일시: " + reDate
				+"]";
	}
}
