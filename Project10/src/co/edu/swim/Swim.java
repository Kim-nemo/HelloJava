package co.edu.swim;

public class Swim {
	private String sId;
	private String sPw;
	private int sNo;
	private String name;
	private String sex;
	private String phoneNo;
	private String birth;
	private String level;
	
	public Swim() {}
	
	public Swim(String sId, String sPw, int sNo, String name, String sex, String phoneNo, String birth, String level) {
		this.sId = sId;
		this.sPw = sPw;
		this.sNo = sNo;
		this.name = name;
		this.sex = sex;
		this.phoneNo = phoneNo;
		this.birth = birth;
		this.level = level;
	}
	
	public Swim(String sId, int sNo, String name, String sex, String phoneNo, String birth, String level) {
		this.sId = sId;
		this.sNo = sNo;
		this.name = name;
		this.sex = sex;
		this.phoneNo = phoneNo;
		this.birth = birth;
		this.level = level;
	} //인서트
	
	public Swim(int sNo, String name, String sex, String birth, String phoneNo, String level) {
		this.sNo = sNo;
		this.name = name;
		this.sex = sex;
		this.phoneNo = phoneNo;
		this.birth = birth;
		this.level = level;
	} //전체조회
	
	public Swim(String name, String sex, String phoneNo, String birth, String level) {
		this.name = name;
		this.sex = sex;
		this.phoneNo = phoneNo;
		this.birth = birth;
		this.level = level;
	} //수정
	
	
	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getsPw() {
		return sPw;
	}

	public void setsPw(String sPw) {
		this.sPw = sPw;
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	@Override
	public String toString() {
		return "회원번호: "+ sNo +", 회원명: " + name + ", 성별: " + sex + ", 레벨: "+ level;
	}

	public String getString() {
		return "아이디: "+ sId + ", 회원번호: "+ sNo 
			+", 회원명: " + name + ", 성별: " + sex 
			+ ", 생년월일: "+ birth +", 연락처: " + phoneNo 
			+ ", 레벨: "+ level;
	}
}
