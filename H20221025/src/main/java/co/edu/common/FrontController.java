package co.edu.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.control.BulletinControl;
import co.edu.control.LogOut;
import co.edu.control.MainControl;
import co.edu.control.MemberList;
import co.edu.control.PasswdRe;
import co.edu.control.PasswdReForm;
import co.edu.control.SearchBoard;
import co.edu.control.SignIn;
import co.edu.control.SignInForm;
import co.edu.control.SignUp;
import co.edu.control.SignUpForm;
import co.edu.control.WriteBoard;
import co.edu.control.WriteForm;

public class FrontController extends HttpServlet {
	
	HashMap<String, Control> controlList;
	String charset;
	
	// init()
	
//	@Override
//	public void init() throws ServletException {
//		
//		ServletContext sc = this.getServletContext();
//		sc.getInitParameter("charset");
//	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		controlList = new HashMap<String, Control>();
		
		controlList.put("/main.do", new MainControl());
		controlList.put("/bulletin.do", new BulletinControl());
		controlList.put("/searchBoard.do", new SearchBoard());
		controlList.put("/writeBoardForm.do", new WriteForm());
		controlList.put("/writeBoard.do", new WriteBoard());
		
		// 회원 가입
		controlList.put("/signUpForm.do", new SignUpForm()); // 회원가입화면
		controlList.put("/signUp.do", new SignUp()); // 회원가입 처리 => 회원가입되었습니다. 메세지띄우기
		controlList.put("/memberList.do", new MemberList());
		
		controlList.put("/signInForm.do", new SignInForm()); // 로그인화면
		controlList.put("/signIn.do", new SignIn()); // 로그인 처리
		
		controlList.put("/signOut.do", new LogOut());// 로그아웃처리
		
		controlList.put("/passwdReForm", new PasswdReForm()); // 비밀번호 재전송
		controlList.put("/passwdRe.do", new PasswdRe());
		}
	// service()
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding(charset); // 한글처리
		resp.setCharacterEncoding(charset); //한글
		
		String uri = req.getRequestURI(); // http://localhost:8081/H20221025/main.do 에서 서버정보 빼고 프로젝트 이름과 호출한 페이지(main.do)까지 uri값
		String context = req.getContextPath(); // -> /H20221025
		String path = uri.substring(context.length());
		
		System.out.println(path);
		Control subControl = controlList.get(path);
		subControl.exec(req, resp); // /main.do => control실행
	}
}
