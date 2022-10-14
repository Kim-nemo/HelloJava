package co.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManage {

	File file = new File("c:/Temp/studentList.txt");
	ArrayList<Student> studentList = new ArrayList<>();
	Scanner scn = new Scanner(System.in);

	// 싱글톤 인스턴스 생성.
	private static StudentManage instance = new StudentManage();

	private StudentManage() {
		readFromFile();
	}

	public static StudentManage getInstance() {
		return instance;
	}

	// 등록.
	public void add(Student student) {
		studentList.add(student);
	}

	// 삭제.
	public void del(int studNo) {
		boolean exists = false;
		for(int i=0; i<studentList.size(); i++) {
			if(studNo == studentList.get(i).getStudNo()) {
				studentList.remove(i);
				exists = true;
				System.out.println("<<삭제되었습니다>>");
			}
		}
		if(!exists) {
			System.out.println("<<해당정보가 없습니다>>");
		}
	}

	// 목록(입력순서).
	public void list() {
		for(int i=0; i<studentList.size();i++) {
		int allScore = studentList.get(i).getEngScore()+studentList.get(i).getMathScore();
			for(i=0; i<studentList.size();i++) {
				System.out.println(studentList.get(i).getStudNo() + "  "
								+studentList.get(i).getStudName() + "  "
								+studentList.get(i).getStudAge() + "  "
								+studentList.get(i).getEngScore() + "  "
								+studentList.get(i).getMathScore() + "  "
								+allScore);
	
			}
		}
	}

	// 순위(총점순서).
	public void ord() {
		for(int i=0; i<studentList.size();i++) {
			int allScore = studentList.get(i).getEngScore()+studentList.get(i).getMathScore();
				for(i=0; i<studentList.size();i++) {
					System.out.println(studentList.get(i).getStudNo() + "  "
								+studentList.get(i).getStudName() + "  "
								+studentList.get(i).getStudAge() + "  "
								+studentList.get(i).getEngScore() + "  "
								+studentList.get(i).getMathScore() + "  "
								+allScore);
		
				}
			}
	}

	// 저장된 파일을 읽어오기.
	public void readFromFile() {

		try {
			FileReader fr = new FileReader(file); //
			BufferedReader br = new BufferedReader(fr);//

			String studentInfo = null;
			String[] itemAry = null;

			while (true) {
				studentInfo = br.readLine();
				if (studentInfo == null) { // 파일의 끝부분이면 종료.
					break;
				}
				itemAry = studentInfo.split(" ");
				int no = Integer.parseInt(itemAry[0]);
				String name = itemAry[1];
				int age = Integer.parseInt(itemAry[2]);
				int eng = Integer.parseInt(itemAry[3]);
				int math = Integer.parseInt(itemAry[4]);
				Student student = new Student(no, name, age, eng, math);
				studentList.add(student);
			}
			br.close();
			fr.close();

		} catch (Exception e) {
			System.out.println("읽을 파일이 없습니다.");
		}
	} // 입력스트림

	// 입력된 내용을 파일에 저장하기.
	public void storeToFile() {
		try {
			FileWriter fw = new FileWriter(file);
			for (int i=0; i<studentList.size(); i++) {
				String x = studentList.get(i).getStudNo() + "  "
						+studentList.get(i).getStudName() + "  "
						+studentList.get(i).getStudAge() + "  "
						+studentList.get(i).getEngScore() + "  "
						+studentList.get(i).getMathScore() + "  ";
				fw.write(x);
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // 출력스트림


}
