package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.board.MemberVO;
import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.service.MemberService;
import co.edu.service.MemberServiceImpl;

public class PasswdRe implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		
		MemberService service = new MemberServiceImpl();
		MemberVO result = service.login(id,passwd);
		MemberVO Emailresult = service.searchEmail(id);
		
		
		if(result != null) {
			req.setAttribute("logInfo", result);
			
			HttpSession session = req.getSession();
			session.setAttribute("id", result.getId());
			session.setAttribute("passwd", Emailresult.getPasswd());
			
			String passwdReturn = "1234";
			
			MailApp app = new MailApp();
			app.sendMail("rhakdnj1232@naver.com", result.getEmail(), "비밀번호재설정", passwdReturn);
			service.updatePasswd(new MemberVO(id,passwdReturn,null,null,null));
			
			HttpUtil.forward(req, resp, "member/passwdRe.tiles");
		} else {
			HttpUtil.forward(req, resp, "member/signInForm.tiles");
		}

	}

}
