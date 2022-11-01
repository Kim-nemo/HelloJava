package co.edu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.edu.member.MemberVO;
import co.edu.service.MemberDAO;

@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/json;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.memberList();
		// [{"id":"user1","name":"홍길동","email":"email.com","responsibility":"user"},{},{},{}];
		// 3건. 1(0),2(1),3(2)
//		String json = "[";
//		for(int i=0; i<list.size(); i++) {
//			json += "{\"id\":\""+list.get(i).getId()
//					+"\",\"name\":\""+list.get(i).getName()
//					+"\",\"email\":\""+list.get(i).getEmail()
//					+"\",\"resposibility\":\""+list.get(i).getResposibility() + "\"}";
//			if(i < list.size()-1) {
//				json += ",";
//			}
//		}
//		json += "]";
		Gson gson = new GsonBuilder().create(); // 이거 쓰면 위에 주석처리한거 필요없음 대신 라이브러리에 메이븐 넣어줘야함
		response.getWriter().print(gson.toJson(list)); // 바꿀 자바객체 넣어주면 됨
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("dopost");
		request.setCharacterEncoding("utf-8");// 요청정보에 들어있는 한글 입력방식 설정
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");

		String job = request.getParameter("job");

		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAO();
		// job =>등록, 삭제 구분
		if (job.equals("delete")) {
			if (dao.deleteMember(id)) {
				response.getWriter().print("success");
			} else {
				response.getWriter().print("fail");
			}

		} else if (job.equals("insert")) {
			String pw = request.getParameter("passwd");
			String nm = request.getParameter("name");
			String em = request.getParameter("email");

			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPasswd(pw);
			vo.setName(nm);
			vo.setEmail(em);

			dao.insertMember(vo);
			Gson gson = new GsonBuilder().create(); // gson 인스턴스 호출
			// gson.toJson(vo) = {"id":"user1","passwd":...??}

			response.getWriter().print(gson.toJson(vo)); // 결과페이지를 출력
		}

	}

}
