package co.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame extends JFrame{

	public MyFrame() {
		
		setTitle("윈도우 UI");
		setSize(300 , 250); //윈도우 사이즈 가로, 세로
		
		setLayout(new FlowLayout()); // 배치관리자
		
		JButton btn = new JButton("확인"); // 버튼
		JButton btn2 = new JButton("취소");
		btn.addActionListener(e -> System.out.println("확인버튼 클릭"));
		
		btn2.addActionListener((e) -> {
				System.out.println("취소버튼 클릭");
				System.exit(0); // 종료하게 하는 이벤트
		});
		add(btn); // 컨트롤 등록
		add(btn2);
		
		setVisible(true); // 화면 출력
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X버튼 누르면 화면이 종료되게
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
