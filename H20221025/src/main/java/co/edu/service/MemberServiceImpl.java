package co.edu.service;

import co.edu.board.BoardVO;
import co.edu.board.MemberVO;
import co.edu.dao.MemberDAO;

public class MemberServiceImpl implements MemberService {
	MemberDAO dao = new MemberDAO();

	@Override
	public MemberVO insertMember(MemberVO vo) {
		return dao.insertMember(vo);
	}

	@Override
	public MemberVO login(String id, String passwd) {
		return dao.login(id, passwd);
	}
}
