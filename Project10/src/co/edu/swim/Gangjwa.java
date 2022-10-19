package co.edu.swim;

public class Gangjwa {
	private String gName;
	private String gStuName;
	private String gTeacher;
	private int gLevel;
	private int gCount;
	private int gJanyeo;
	
	public Gangjwa() {}

	public Gangjwa(String gName, String gStuName, String gTeacher, int gLevel, int gCount, int gJanyeo) {
		super();
		this.gName = gName;
		this.gStuName = gStuName;
		this.gTeacher = gTeacher;
		this.gLevel = gLevel;
		this.gCount = gCount;
		this.gJanyeo = gJanyeo;
	}
	
	public Gangjwa(String gName, String gStuName, String gTeacher, int gLevel, int gCount) {
		super();
		this.gName = gName;
		this.gStuName = gStuName;
		this.gTeacher = gTeacher;
		this.gLevel = gLevel;
		this.gCount = gCount;
	} // 관리자용 수강등록

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String getgStuName() {
		return gStuName;
	}

	public void setgStuName(String gStuName) {
		this.gStuName = gStuName;
	}

	public String getgTeacher() {
		return gTeacher;
	}

	public void setgTeacher(String gTeacher) {
		this.gTeacher = gTeacher;
	}

	public int getgLevel() {
		return gLevel;
	}

	public void setgLevel(int gLevel) {
		this.gLevel = gLevel;
	}

	public int getgCount() {
		return gCount;
	}

	public void setgCount(int gCount) {
		this.gCount = gCount;
	}

	public int getgJanyeo() {
		return gJanyeo;
	}

	public void setgJanyeo(int gJanyeo) {
		this.gJanyeo = gJanyeo;
	}

	@Override
	public String toString() {
		return "Gangjwa [gName=" + gName + ", gStuName=" + gStuName + ", gTeacher=" + gTeacher + ", gLevel=" + gLevel
				+ ", gCount=" + gCount + ", gJanyeo=" + gJanyeo + "]";
	}
	
}
