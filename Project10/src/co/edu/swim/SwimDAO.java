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
}
