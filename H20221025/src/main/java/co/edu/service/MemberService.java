package co.edu.service;

import co.edu.board.BoardVO;
import co.edu.board.MemberVO;
import co.edu.dao.MemberDAO;

public interface MemberService {
	public MemberVO insertMember(MemberVO vo);
	public MemberVO login(String id, String passwd);
	public boolean updatePasswd(MemberVO vo);
	public MemberVO searchEmail(String id);
}
