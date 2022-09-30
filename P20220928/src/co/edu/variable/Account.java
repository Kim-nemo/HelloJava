package co.edu.variable;

public class Account {	
	private String accNo; // 계좌번호.  두 단어의 조합: 2번째 첫번째는 대문자로. 
	private String owner; // 예금주
	private int balance; // 예금액

	void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	void setOwner(String owner) {
		this.owner = owner;
	}
	void setBalance(int balance) {
		this.balance = balance;
	}
	
	String getAccNo() {
		return this.accNo;
	}
	String getOwner() {
		return this.owner;
	}
	int getBalance() {
		return this.balance;
	}
	
		
//	public static void main(String[] args) {
//		WhileBankApp b1 = new WhileBankApp();
//		
//		b1.setAccNo("1-1111");
//		b1.setOwner("홍길동");
//		b1.setBalance(10000);
//		
//		System.out.println(b1.getAccNo);
//	}
	/*
	private String accNo; // 계좌번호.  두 단어의 조합: 2번째 첫번째는 대문자로. 
	private String owner; // 예금주
	private int balance; // 예금액
	*/
	
	// setter, getter 정의
	
	
}
