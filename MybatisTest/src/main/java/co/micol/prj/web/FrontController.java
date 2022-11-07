package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.book.command.BookList;
import co.micol.prj.common.Command;
import co.micol.prj.main.MainCommand;

/**
 * 모든 요청을 받아들이는 컨트롤러
 */
@WebServlet("*.do") // 어노테이션 서블릿을 사용. 원래 이름을 빼고 *.do 넣어서 어떤 요청에 끝이 .do로 끝나면~
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 명령을 저장할 수 있는 map 컬렛견을 만들어줌. 
    private HashMap<String, Command> map = new HashMap<String, Command>();
    public FrontController() { // 생성자
        super();
    }

	// 요청한 것을 실행하는 명령을 모아두는 곳
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand()); // 처음 보여줄 페이지 명령
		map.put("/bookList.do", new BookList()); // 책 목록 보기
	}

	// 요청을 분석하고 실행, 결과를 돌려주는 곳
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글 깨짐 방지
		String uri = request.getRequestURI(); // 요청한 uri를 구함
		String contextPath = request.getContextPath(); // 루트를 구함, context Path
		String page = uri.substring(contextPath.length()); // 실제 수행할 요청을 구함. url, uri 사진 참고
		
		Command command = map.get(page); // init메소드에서 수행할 명령을 가져온다.
		// map 에 집어넣을땐 put, 가져올땐 get
		
		//Command command = new MainCommand(); 인터페이스를 초기화
		String viewPage = command.exec(request, response); // 명령을 수행하고 결과를 돌려받음
		// viewPage 는 보여줄 페이지
		
		// viewResolve : 요청을 보내고 views폴더에 가서 필요한 jsp를 찾아서 응답하는 과정, 돌아갈 곳을 찾아주는 것
		if(!viewPage.endsWith(".do") && viewPage != null) {// 리턴되는 문자열에서 마지막에 .do가 포함되어있지 않고, null이 아니라면
			//ajax: 요청한 페이지의 결과를 주는 것
			//타일즈 돌아가는 곳
			viewPage = "/WEB-INF/views/" + viewPage + ".jsp"; // WEB-INF는 서버에서만 접근 가능하니까 접근가능하도록 하는 과정
			// view를 찾고 dispatcher 시키기
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response); // 권한 위임 하는데 request값이 실려감 (ex. 삼성 AS 센터)
		}else {
			response.sendRedirect(viewPage); // *.do로 들어올 때 돌아가는 곳. 권한 위임 하는데 명령만 보내고 request값이 실려가지 않음
		}
		
		
	}

}
