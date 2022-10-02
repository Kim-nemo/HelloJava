package co.edu.homework;

public class Member {
	private int memberNo;
	private String memberName;
	private String birth;
	private String tel;
	
	public Member() {}
	
	public Member(int memberNo, String memberName, String birth, String tel) {
		super();
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.birth = birth;
		this.tel = tel;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "회원정보 [회원번호=" + memberNo + ", 이름=" + memberName + ", 생년월일=" + birth + ", 연락처="
				+ tel + "]";
	}
}
	
	
	
	
