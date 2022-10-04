package co.edu.inherit.friend;

public class ComFriend extends Friend{
	private String company;
	private String dept;
	
	public ComFriend() {
		super();
	}
	public ComFriend(String name, String phone, String company, String dept) {
		super(name, phone); // 부모클래스의 생성자를 통해서 받는 매개값 호출
		this.company = company;
		this.dept = dept;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getCompany() {
		return this.company;
	}
	public String getDept() {
		return this.dept;
	}
	@Override
	public String showInfo() {
		// 회사친구의 정보
		return "회사친구의 이름 " + getName() + ", 연락처 " + getPhone() 
				// name과 phone은 private이기 때문에 get메소드로 가져와야하 한다
				+ ", 회사명 " + this.company + ", 부서는 " + this.dept + "입니다";
	}
}
