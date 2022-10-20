package co.edu.swim;

public class Gangjwa {
	private String gName;
	private String gStuName;
	private String gTeacher;
	private String gDay;
	private int gLevel;
	private int gCount;
	private int gJanyeo;
	
	public Gangjwa() {}
	
	public Gangjwa(String gName, String gStuName, String gTeacher, String gDay, int gLevel, int gCount, int gJanyeo) {
		this.gName = gName;
		this.gStuName = gStuName;
		this.gTeacher = gTeacher;
		this.gDay = gDay;
		this.gLevel = gLevel;
		this.gCount = gCount;
		this.gJanyeo = gJanyeo;
	}

	public Gangjwa(String gName, String gStuName, String gTeacher, int gLevel, int gCount, int gJanyeo) {
		this.gName = gName;
		this.gStuName = gStuName;
		this.gTeacher = gTeacher;
		this.gLevel = gLevel;
		this.gCount = gCount;
		this.gJanyeo = gJanyeo;
	}
	
	public Gangjwa(String gName, String gTeacher, String gDay, int gLevel) {
		this.gName = gName;
		this.gTeacher = gTeacher;
		this.gDay = gDay;
		this.gLevel = gLevel;
	} // 관리자용 수강등록
	
	public Gangjwa(String gName, int gCount, int gJanyeo) {
		this.gName = gName;
		this.gCount = gCount;
		this.gJanyeo = gJanyeo;
	} // 강좌개설
	
	public Gangjwa(int gCount) {
		this.gCount = gCount;
	}
	
	public Gangjwa(String gName, String gStuName, String gDay, int gLevel, int gJanyeo) {
		this.gName = gName;
		this.gStuName = gStuName;
		this.gDay = gDay;
		this.gLevel = gLevel;
		this.gJanyeo = gJanyeo;
	} // 강사명 조회에 씀

	
	public String getgDay() {
		return gDay;
	}

	public void setgDay(String gDay) {
		this.gDay = gDay;
	}

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
		return "강좌조회 [강좌명: " + gName + ", 학생명: " + gStuName + ", 수업요일: " + gDay + ", 레벨명: " + gLevel
				+ "]";
	}
	
}
