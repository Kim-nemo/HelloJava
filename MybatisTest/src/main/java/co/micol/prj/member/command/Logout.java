package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.common.Command;

public class Logout implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃처리
		HttpSession session = request.getSession(); //세션 객체 만들기
		String message = (String) session.getAttribute("name"); // 세션객체는 타입이 없기때문에 String으로 캐스캐이팅 해주는거
		message = message.concat("님 안녕히가세요~!");
		request.setAttribute("message", message); // request객체에 메세지 담아보내기
		session.invalidate(); // 서버에 보관하고 있는 세션자체를 완전히 삭제해버리는 것
		return "member/memberLogin.tiles"; // 로그아웃했을때 메세지나오게
		//return "main.do"; // 처음으로 돌리기(로그인 안 된)
	}

}
