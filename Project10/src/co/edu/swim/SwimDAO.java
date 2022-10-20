package co.edu.swim;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SwimDAO extends DAO{
	
	
	
	//로그인
	public int login(String id, String passwd) {
		String sql = "select * from manager where id = ? and passwd = ?";
		String sql2 = "select * from member where id = ? and passwd = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, passwd);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
					return 1;
				}
			
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, id);
			psmt.setString(2, passwd);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
					return 2;
				}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;
	}// end of login
	
	//Swim
	public void insert(Swim swm) {
		String sql = "insert into member(id, passwd, member_no, member_name, member_sex, member_birth, member_phoneNo, member_level)\r\n"
				+ "values( ? , ? , ? , ? , ? , ? , ? , ? )";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, swm.getsId());
			psmt.setString(2, swm.getsPw());
			psmt.setInt(3, swm.getsNo());
			psmt.setString(4, swm.getName());
			psmt.setString(5, swm.getSex());
			psmt.setString(6, swm.getBirth());
			psmt.setString(7, swm.getPhoneNo());
			psmt.setInt(8, swm.getLevel());
			
			psmt.executeUpdate();
//			System.out.println(r + "건 입력됨");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}// end of insert
	
	public List<Swim> search() {
		conn = getConnect();
		List<Swim> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from member order by member_no");
			while(rs.next()) {
				list.add(new Swim(rs.getInt("member_no")
						,rs.getString("member_name")
						,rs.getString("member_sex")
						,rs.getString("member_birth")
						,rs.getString("member_phoneNo")
						,rs.getInt("member_level")
				));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}// end of search
	
	public Swim getsNo(int num) {
		String sql = "select * from member where member_no = ?";
		
		conn = getConnect();
		Swim sNum = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				sNum = new Swim(rs.getString("id")
						,rs.getInt("member_no")
						,rs.getString("member_name")
						,rs.getString("member_sex")
						,rs.getString("member_birth")
						,rs.getString("member_phoneNo")
						,rs.getInt("member_level")
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return sNum;
	}// end of getsNo
	
	public void update(Swim swm) {
		String sql = "update member "
				+ "set member_name = ?, "
				+ "member_sex = ?, "
				+ "member_birth = ?, "
				+ "member_phoneNo = ?, "
				+ "member_level = ? "
				+ "where member_no = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, swm.getName());
			psmt.setString(2, swm.getSex());
			psmt.setString(3, swm.getBirth());
			psmt.setString(4, swm.getPhoneNo());
			psmt.setInt(5, swm.getLevel());
			psmt.setInt(6, swm.getsNo());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경됨.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}// end of update
	
	public boolean delete(int num) {
		String sql = "delete from member where member_no = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			
			int r = psmt.executeUpdate();
			if(r>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}// end of delete
	
	public SwimClass getcLv(int level) {
		String sql = "select * from swimClass where class_level = ?";
		
		conn = getConnect();
		SwimClass sLevel = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, level);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				sLevel = new SwimClass(rs.getInt("class_level")
						,rs.getString("class_name")
						,rs.getString("class_day")
						,rs.getString("class_teacher")
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return sLevel;
	}// end of getcLv
	
	public Swim getsId(String sId) {
		String sql = "select * from member where id = ?";
		
		conn = getConnect();
		Swim mId = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sId);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				mId = new Swim(rs.getString("id")
						,rs.getInt("member_no")
						,rs.getString("member_name")
						,rs.getString("member_sex")
						,rs.getString("member_birth")
						,rs.getString("member_phoneNo")
						,rs.getInt("member_level")
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return mId;
	}// end of getsId
	
	// 수강정보	
//	public List<Gangjwa> searchG (String gName) {
//		String sql = "select s.class_name, m.member_name, s.class_teacher, s.class_level, g.g_janyeo\n"
//				+ "from member m, swimclass s, gangjwa g\n"
//				+ "where m.member_level = s.class_level\n"
//				+ "and s.class_name = g.g_name\n"
//				+ "and g.g_name like '%'||?||'%'"; // 실행안됨..
//		
//		conn = getConnect();
//		List<Gangjwa> list = new ArrayList<>();
//		
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, gName);
//			rs = psmt.executeQuery();
//			
//			while(rs.next()) {
//				list.add(new Gangjwa(rs.getString("class_name")
//						,rs.getString("member_name")
//						,rs.getString("class_teacher")
//						,rs.getInt("class_level")
//						,rs.getInt("g_janyeo")
//						));
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			disconnect();
//		}
//		return list;
//	}// 수강정보 조회
	
	public List<Gangjwa> searchG (String gTeacher) {
		String sql = "select s.class_name, m.member_name, s.class_day, s.class_level, g.g_janyeo\n"
				+ "from member m, swimclass s, gangjwa g\n"
				+ "where m.member_level = s.class_level\n"
				+ "and s.class_name = g.g_name\n"
				+ "and s.class_teacher like '%'||?||'%'"
				+ " order by s.class_name"; 
		
		conn = getConnect();
		List<Gangjwa> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, gTeacher);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				list.add(new Gangjwa(rs.getString("class_name")
						,rs.getString("member_name")
						,rs.getString("class_day")
						,rs.getInt("class_level")
						,rs.getInt("g_janyeo")
						));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}// 강사명 수강조회
	
	// 강좌개설
	public void openClassSc(Gangjwa gj) {
		String scsql = "insert into swimclass(class_level, class_name, class_day, class_teacher)\r\n"
				+ "values( ?, ? ,? ,?)";
		conn = getConnect();
		
		try {
			psmt = conn.prepareStatement(scsql);
			psmt.setInt(1, gj.getgLevel());
			psmt.setString(2, gj.getgName());
			psmt.setString(3, gj.getgDay());
			psmt.setString(4, gj.getgTeacher());
			
					
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}
	
	public void openClassN(Gangjwa ngj) {
		String sql = "insert into Gangjwa(g_name, g_count, g_janyeo) "
					+"values(?, ?, 0)";
			conn = getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, ngj.getgName());
			psmt.setInt(2, ngj.getgCount());
					
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	public boolean gDelete(String gName) {
		String sql = "delete from swimclass where class_name like '%'||?||'%'";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, gName);
			
			int r = psmt.executeUpdate();
			if(r>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}// 강좌삭제
	
	public boolean gGDelete(String gName) {
		String sql = "delete from gangjwa where g_name like '%'||?||'%'";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, gName);
			
			int r = psmt.executeUpdate();
			if(r>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}// 강좌삭제
}
