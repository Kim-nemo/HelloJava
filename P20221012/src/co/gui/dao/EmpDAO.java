package co.gui.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DAO { // 데이터 베이스 처리하는 곳
	
	// 입력
	public EmployeeVO insertEmp(EmployeeVO vo) { // 매개값으로 받았던 vo에 시퀀스 값을 추가해주기위해 void대신 EmployeeVO사용
		getConnect();
		
		String seq = "select employees_seq.nextval from dual";
		
		String sql = "insert into empl (employee_id, first_name, last_name, email, hire_date, job_id) "
					+ "values(?, ?, ?, ?, ?, ?)";
		
		try {
			// 시퀀스 획득
			int seqInt = 0;
			psmt = conn.prepareStatement(seq);
			rs = psmt.executeQuery();
			if(rs.next()) {
				seqInt = rs.getInt(1); // 첫번째 칼럼을 가져오겠습니다
			}
			//insert 작업
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seqInt);
			psmt.setString(2, vo.getFirstName());
			psmt.setString(3, vo.getLastName());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getHireDate());
			psmt.setString(6, vo.getJobId());
			int r = psmt.executeUpdate(); // 쿼리실행.
			System.out.println(r+"건 입력됨");
			
			// 새로운 입력하게 사원번호
			vo.setEmployeeId(seqInt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}
	// 삭제
	public void deleteEmp(int employeeId) {
		getConnect();
		String sql = "delete from empl where employee_id = ?"; // employee_id 기준으로 삭제
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, employeeId);
			int r = psmt.executeUpdate();
			System.out.println(r+"건 삭제됨");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	// 수정
	public void updateEmp(EmployeeVO vo) {
		getConnect();
		String sql = "update empl set first_name = ? , last_name =?, email=?, hire_date=? , job_id = ? where employee_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getFirstName());
			psmt.setString(2, vo.getLastName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getHireDate());
			psmt.setString(5, vo.getJobId());
			psmt.setInt(6, vo.getEmployeeId());
			int r = psmt.executeUpdate();
			System.out.println(r+"건 수정됨");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	// 목록
	public List<EmployeeVO> empList(EmployeeVO vo){
		List<EmployeeVO> empList = new ArrayList<EmployeeVO>();
		getConnect();
		String sql = "select * from empl"
				+"  where employee_id = decode(?,0, employee_id, ?) "
				+"  and   first_name like '%'||?||'%' "
				+"  and   last_name like '%'||?||'%' "
				+"  and   email like '%'||?||'%' "
				+"  and   to_char(hire_date,'yyyy-mm-dd') like '%'||?||'%' "
				+"  and   job_id = nvl(?, job_id) " // ?값이 널이면 job_id자체를 비교
				+"order by employee_id";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getEmployeeId());
			psmt.setInt(2, vo.getEmployeeId());
			psmt.setString(3, vo.getFirstName());
			psmt.setString(4, vo.getLastName());
			psmt.setString(5, vo.getEmail());
			psmt.setString(6, vo.getHireDate());
			psmt.setString(7, vo.getJobId());
			rs = psmt.executeQuery(); //rs<-컬렉션(여러건 담을 수 있음)
			while(rs.next()) { // 데이터가 있는 건수만큼 담아서 empList에 넣어줌
				int empId = rs.getInt("employee_id");
				String fName = rs.getString("first_name");
				String lName = rs.getString("last_name");
				String email = rs.getString("email");
				String hDate = rs.getString("hire_date");
				String jobId = rs.getString("job_id");
				
				EmployeeVO emp = new EmployeeVO(empId, fName, lName, email, hDate, jobId);
				empList.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return empList;
	}	
}
