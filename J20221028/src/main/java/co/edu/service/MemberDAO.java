package co.edu.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.edu.common.DAO;
import co.edu.member.CalendarVO;
import co.edu.member.MemberVO;

public class MemberDAO extends DAO{
	
	// 부서명, 부서인원
	public Map<String, Integer> getEmpByDept(){
		getConnect();
		Map<String, Integer> map = new HashMap<>();
		String sql = "select d.department_name, count(1) "
				+ "from hr.employees e "
				+ "join hr.departments d "
				+ "on e.department_id = d.department_id "
				+ "group by d.department_name";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				map.put(rs.getString(1), rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return map;
	}
	
	// 한건 삭제
	public boolean deleteMember(String id) {
		getConnect();
		String sql = "delete from members where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r= psmt.executeUpdate(); // true 아니면 false값 리턴
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
	
	// 한건 등록
	public void insertMember(MemberVO vo) {
		getConnect();
		String sql = "insert into members (id, passwd, name, email, resposibility)"
					+" values(?,?,?,?,'user') ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			
			psmt.executeUpdate();
			
			vo.setResposibility("user");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	// 전체목록
	public List<MemberVO> memberList(){
		getConnect();
		List<MemberVO> list = new ArrayList<>();
		String sql = "select * from members";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setResposibility(rs.getString("resposibility"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	// 전체 스케줄 목록
	public List<CalendarVO> calendarList(){
		getConnect();
		List<CalendarVO> list = new ArrayList<>();
		String sql = "select * from full_calendar";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CalendarVO vo = new CalendarVO();
				vo.setTitle(rs.getString("title"));
				vo.setStart(rs.getString("start_date"));
				vo.setEnd(rs.getString("end_date"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	// 리스트 한건 등록
		public boolean insertCalendar(CalendarVO vo) {
			getConnect();
			String sql = "insert into full_calendar (title, start_date, end_date)\r\n"
						+" values(?,?,?) ";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, vo.getTitle());
				psmt.setString(2, vo.getStart());
				psmt.setString(3, vo.getEnd());
				
				int r = psmt.executeUpdate();
				if(r>0) {
					return true;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return false;
		}
	// 리스트 삭제
		public boolean deleteCalendar(String start) {
			getConnect();
			String sql = "delete from members where start_date=?";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, start);
				int r= psmt.executeUpdate(); // true 아니면 false값 리턴
				if(r>0) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return false;
		}
}
