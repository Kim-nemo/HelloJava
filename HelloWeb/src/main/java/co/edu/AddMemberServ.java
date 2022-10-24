package co.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.emp.EmpDAO;
import co.edu.emp.EmployeeVO;

/**
 * Servlet implementation class AddMemberServ
 */
@WebServlet({ "/addMemberServlet", "/addMember" })
public class AddMemberServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMemberServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //get 방식의 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// content 타입을 지정
		response.setContentType("text/html;charset=UTF-8"); // 보여지는 페이지의 타입을 html로 설정
		
		System.out.println("/addMemberSer 페이지입니다.");
		String empId = request.getParameter("employee_id");
		String lName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String hireDate = request.getParameter("hire_date");
		String jobId = request.getParameter("job_id");
		
		System.out.println(empId);
		
		// 입력
		EmpDAO dao = new EmpDAO();
		EmployeeVO vo = new EmployeeVO(0, lName, email, hireDate, jobId);
		dao.insertEmp(vo);
		
		System.out.println("입력완료");
		
		PrintWriter out = response.getWriter(); // 출력 스트림
		out.print("<h3>completed.</h3>");
		out.print("<p>사원번호 : " +vo.getEmployeeId()+ "</p>");
		out.print("<p>성씨 : " + vo.getLastName()+ "</p>");
		out.print("<p>이메일 : " +vo.getEmail()+ "</p>");
		out.print("<p>입사일시 : " +hireDate + "</p>");
		out.print("<p>직부 : " +jobId + "</p>");
		
		out.print("<a href = index.html>첫 페이지로 이동</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	// post 방식의 요청시 실행
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
//		doGet(request, response);
		PrintWriter out = response.getWriter(); // 사용자의 브라우저(출력스트림 생성)
		out.print("<h3>Post 방식의 요청</h3>");
	}
}
