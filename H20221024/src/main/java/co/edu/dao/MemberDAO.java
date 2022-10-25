package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;
import co.edu.vo.MemberVO;

public class MemberDAO extends DAO {	
	// 생성, 수정, 삭제, 한건 조회, 목록 조회
	public void memberInsert(MemberVO vo) {
		conn = getConnect();
		
		String sql = "insert into members (id, passwd, name, email) "
				+ "values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public MemberVO memberSearch(String id) {
		getConnect();
		String sql = "select * from members where id=?";
		MemberVO member= null;
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberVO(rs.getString("id")
									,rs.getString("passwd")
									,rs.getString("name")
									,rs.getString("email")
									,rs.getString("resposibility")
									);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return member;
	}
	
	public void memberUpdate(MemberVO vo) {
		getConnect();
		String sql = "update members set passwd=?, name=?, email=? "
				+ "where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPasswd());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getId());
			
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		
	}
	
	public void memberDelete(String id) {
		getConnect();
		String sql = "delete from members where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public List<MemberVO> memberList() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		getConnect();
		String sql = "select * from members";
//					+ "where id like '%'||?||'%' "
//					+ "and passwd like '%'||?||'%' "
//					+ "and name like '%'||?||'%' "
//					+ "and email like '%'||?||'%' ";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("passwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String resposibility = rs.getString("resposibility");
				
				list.add(new MemberVO(id, pw, name, email,resposibility));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return list;
	}
	
	// String id, String passwd => MemberVO타입으로 리턴
	public MemberVO login(String id, String passwd) {
		getConnect();
		String sql = "select * from members where id=? and passwd=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, passwd);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setResposibility(rs.getString("resposibility"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
}
