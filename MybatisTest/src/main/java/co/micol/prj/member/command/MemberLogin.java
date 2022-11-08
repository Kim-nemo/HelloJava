package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.impl.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class MemberLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 처리
		MemberService dao = new MemberServiceImpl();
		MemberVO member = new MemberVO(); // 돌려받을 값은 MemberVO
		HttpSession session = request.getSession(); // 세션값을 사용하기 위해 
		
		String id = request.getParameter("id"); // 여기 파라메터("변수")는 폼에서 가져온 name 이름
		String passwd = request.getParameter("passwd");
		
		String message = "아이디 또는 패스워드가 틀립니다."; // 실패메세지
		
		member = dao.memberLogin(id, passwd);
		
		if(member != null) { // id, passwd가 정상적으로 패스 되면
			session.setAttribute("id", member.getId()); // 세션에 아이디 객체를 넣어서 한번 넣고 계속 사용할 수 있게
			session.setAttribute("name", member.getName());
			session.setAttribute("resposibility", member.getResposibility());
			message = member.getName() + "님 환영합니다~!";
		}
		
		request.setAttribute("message", message);
		return "member/memberLogin.tiles"; // member밑에 memberLogin.jsp를 돌려주라
	}

}
