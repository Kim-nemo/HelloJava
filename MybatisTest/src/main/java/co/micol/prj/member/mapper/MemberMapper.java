package co.micol.prj.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.prj.member.vo.MemberVO;

public interface MemberMapper {
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberDelete(MemberVO vo);
	int memberUpdate(MemberVO vo);
	
	//서비스 인터페이스와 똑같지만 mapper인터페이스에 매개변수가 두개이상있다면 @Param("")으로 넘어와야한다
	MemberVO memberLogin(@Param("id") String id,@Param("passwd") String passwd);
	boolean isMemberIdCheck(String id);
}
