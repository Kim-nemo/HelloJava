package co.micol.prj.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//공통적으로 사용할 인터페이스
public interface Command { // req, resp은 서버가 만들어줌. 요청한 것들을 담아주는 곳 req, 응답하는 객체는 resp
	public String exec(HttpServletRequest request, HttpServletResponse response);
}
