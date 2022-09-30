package co.edu.board;

public class BoardExe {
	public static void main(String[] args) {
		BoardDAO dao = BoardDAO.getInstance();//인스턴스 호출하는 방법 : 클래스이름.getInstance();
		dao.exe();
	}
}
