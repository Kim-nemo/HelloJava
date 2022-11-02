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

import co.edu.member.CalendarVO;
import co.edu.service.MemberDAO;


@WebServlet("/ScheduleServlet")
public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ScheduleServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		List<CalendarVO> list = dao.calendarList();
		
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(list));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("dopost");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		
		//String job = request.getParameter("job");
		MemberDAO dao = new MemberDAO();
		String start = request.getParameter("start");
		String title = request.getParameter("title");
		String end = request.getParameter("end");
		System.out.println(start+title+end);
		CalendarVO vo = new CalendarVO();
		vo.setTitle(title);
		vo.setStart(start);
		vo.setEnd(end);
		
		if (dao.insertCalendar(vo)) {
			response.getWriter().print("success");
		}else {
			response.getWriter().print("fail");
		}
		//Gson gson = new GsonBuilder().create();
		//response.getWriter().print(gson.toJson(vo));
//		if (job.equals("delete")) {
//			if(dao.deleteCalendar(start)) {
//				response.getWriter().print("success");
//			}else {
//				response.getWriter().print("fail");
//			}
//		} else if (job.equals("insert")) {
//			String title = request.getParameter("title");
//			String end = request.getParameter("end_date");
//			
//			CalendarVO vo = new CalendarVO();
//			vo.setTitle(title);
//			vo.setStart(start);
//			vo.setEnd(end);
//			
//			dao.insertCalendar(vo);
//			Gson gson = new GsonBuilder().create();
//			
//			response.getWriter().print(gson.toJson(vo));
//		}
		
		
	}

}
