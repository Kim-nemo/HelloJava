package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;
import co.edu.board.MemberVO;

public interface BoardService {
	// 기능만 정의
	//입력
	public BoardVO insertBoard(BoardVO vo);
	//전체목록
	public List<BoardVO> getList(BoardVO vo);
	//한건만조회
	public BoardVO findBoard(int boardNo);
	//수정
	public boolean updateBoard(BoardVO vo);
	//삭제
	public boolean deleteBoard(int boardNo);
	
	//페이지
	public List<BoardVO> pageList(int page);
	
	// 회원목록
	public List<MemberVO> memberList();
}
