package co.edu.inherit.friend;

public abstract class Animal {
	private String kind;
	public Animal() {
		
	}
	public Animal(String kind) {
		this.kind = kind;
	}
	public void move() {
		System.out.println("움직입니다");
	}
	public abstract void eat(); // 추상메소드: 자식클래스에서 반드시 구현하도록 함
	public abstract void speak(); 
}
