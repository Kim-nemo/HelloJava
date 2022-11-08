package co.micol.prj.member.service;

import java.util.List;

import co.micol.prj.member.vo.MemberVO;

public interface MemberService {
	//CRUD포함
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo); // 한명의 데이터가져오기
	int memberInsert(MemberVO vo);
	int memberDelete(MemberVO vo);
	int memberUpdate(MemberVO vo);
	
	MemberVO memberLogin(String id, String passwd);
	// boolean 메소드에 is~를 많이 붙이는데 초기값으로 false를 만들기 위해서(관례적)
	boolean isMemberIdCheck(String id); // id를 넘겨서 존재하면 false("이미사용된아이디"), 존재하지 않으면 true
}
