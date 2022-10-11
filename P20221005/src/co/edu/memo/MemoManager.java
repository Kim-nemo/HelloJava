package co.edu.memo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoManager {
	
	List<Memo> memoStorage = new ArrayList<>(); // 정보 담아놓기 위한 컬렉션
	File file = new File("C:/Temp/memobook.dat");
	Scanner scn = new Scanner(System.in);
	
	// 싱글톤
	private static MemoManager instance = new MemoManager();
	private MemoManager() {
		readFromFile();
	}
	public static MemoManager getInstance() {
		return instance;
	}
	
	// 추가
	public void inputData() {
		System.out.print("번호>> ");
		int no = Integer.parseInt(scn.nextLine());
		System.out.print("날짜>> ");
		String date = scn.nextLine();
		System.out.print("내용>> ");
		String content = scn.nextLine();
		
		memoStorage.add(new Memo(no, date, content)); // 메모라는 인스턴스를 담을 수 있는 인스턴스
		
	}
	
	// 조회(날짜를 입력받으면 해당되는 날짜의 번호를 모두 출력)
	public void searchData() {
		System.out.print("날짜>> ");
		String sDate = scn.nextLine();
		boolean exists = false;
		for(int i=0; i<memoStorage.size(); i++) {
			if(sDate.equals(memoStorage.get(i).getDate())) { //memoStorage.get(i)의 날짜를 get으로 가져와서 비교하기
				System.out.println(memoStorage.get(i).toString());
				exists = true;
			}
		}
		if(!exists) {
			System.out.println("해당 날짜의 메모가 없습니다.");
		}
	}
	
	// 삭제(번호를 입력해주면 한 건 삭제)
	public void deleteData() {
		System.out.print("번호>> ");
		int dNo = Integer.parseInt(scn.nextLine());
		boolean exists = false;
		for(int i=0; i<memoStorage.size(); i++) {
			if(dNo == memoStorage.get(i).getNo()) {
				memoStorage.remove(i);
				exists = true;
				System.out.println("삭제 완료");
			}
		}
		if(!exists) {
			System.out.println("해당 번호의 메모가 없습니다.");
		}
	}
	
	// 프로그램이 시작되면 파일을 읽어서 데이터를 memoStorage에 담아주는 기능
	public void readFromFile() {
		// try with resource라는 예외처리 기능
		try( FileInputStream fis = new FileInputStream(file);
			 ObjectInputStream ois = new ObjectInputStream(fis);
			){
			
			memoStorage = (List<Memo>) ois.readObject(); //있으면 담아주고
			
		}catch(Exception e) { // 없으면 그냥 리턴
//			e.printStackTrace();
			return;
		}
	}
	
	//종료하면 파일 저장
	public void storeToFile() {
		try( FileOutputStream fos = new FileOutputStream(file);
			 ObjectOutputStream oos = new ObjectOutputStream(fos);
			){
			oos.writeObject(memoStorage); // 파일에 저장하겠다는 의미
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

