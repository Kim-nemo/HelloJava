package co.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.emp.EmpDAO;
import co.edu.emp.EmployeeVO;

// 서블릿이 되려면 HttpServlet 상속
// init() -> service() 구현
// 제어의 흐름을 개발자가 아니라 서블릿컨테이너가 흐름을 제어: 제어의 역전(IOC)

public class FirstServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("init() 호출"); // 인스턴스 생성될 때 한번만 실행
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("service() 호출"); // FirstServlet 호출될 때마다 실행
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		// 사용자의 paramet 처리
		String job = req.getParameter("job");
		EmpDAO dao = new EmpDAO();
		if(req.getMethod().equals("GET")) {
			// 조회할 경우
			List<EmployeeVO> list = dao.empList(new EmployeeVO(job));
			out.print("<table border='1' align='center'>");
			out.print("<tr bgcolor='skyblue'><th>사원번호</th><th>이름</th><th>이메일</th><th>직무</th></tr>");
			for(EmployeeVO emp : list) {
				out.print("<tr align=center><td>"+emp.getEmployeeId()
						+ "</td><td>"+emp.getLastName()
						+ "</td><td>"+emp.getEmail()
						+ "</td><td>"+emp.getJobId()+ "</td></tr>");
			}
			out.print("</table>");
			
		} else if (req.getMethod().equals("POST")) {
			// 입력
			String empId = req.getParameter("emp_id"); // emp_id라는 값을 불러와서 문자열 empId로 읽어들이겠다
			String lName = req.getParameter("last_name");
			String email = req.getParameter("email");
			String hDate = req.getParameter("hire_date");
			
			dao.insertEmp(new EmployeeVO(Integer.parseInt(empId) // 사원번호: int,emp_id는 입력하는 값이 아니고 시퀀스로 자동으로 올라가는 값 
				,null
				,lName
				,email
				,hDate
				,job
			));
			
			out.print("<script>alert('입력완료');</script>");
		}
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() 호출");
		
		
	}
}