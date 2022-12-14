package co.gui;

import java.awt.BorderLayout;

import javax.swing.*;

public class BatchFrame2 extends JFrame{

	public BatchFrame2() {
		setTitle("BoarderLayout 관리자");
		setSize(300, 250);
		
		setLayout(new BorderLayout(10,10)); //좌우 상하 여백 지정
		
		JButton top = new JButton("top");
		JButton left = new JButton("left");
		JButton center = new JButton("center");
		JButton right = new JButton("right");
		JButton bottom = new JButton("bottom");
		
		add("North", top);
		add("West", left);
		add("Center", center);
		add("East", right);
		add("South", bottom);
		
		setVisible(true); // 컴포넌트를 다 배치하고 호출해야한다
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // 화면의 중앙
	}
	
	public static void main(String[] args) {
		new BatchFrame2();
	}
}
