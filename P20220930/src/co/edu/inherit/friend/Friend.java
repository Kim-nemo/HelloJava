package co.edu.inherit.friend;

public class Friend {
	private String name;
	private String phone;
	
	public Friend() {}// 기본생성자 정의. 없으면 상속받는 클래스에서 오류남.
	public Friend(String name, String phone) {
		super(); // Object클래스 생성자 호출
		this.name = name;
		this.phone = phone;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return this.name;
	}
	public String getPhone() {
		return this.phone;
	}
	public String showInfo() {
		return "친구의 이름은 " + name +", 연락처는 " + phone;
	}
	
}
