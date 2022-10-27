package co.edu.dao;

import java.sql.SQLException;

import co.edu.board.BoardVO;
import co.edu.board.MemberVO;
import co.edu.common.DAO;

public class MemberDAO extends DAO {
	public MemberVO insertMember(MemberVO vo) {
		// 입력처리 중에 에러가 발생하면 null;
		getConnect();
		String sql = "insert into members (id, passwd, name, email, resposibility)\r\n"
				+ "values(?, ?, ?, ?, ?)";
		
		try {
			
			// insert
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getResposibility());
			int r = psmt.executeUpdate();
			if(r>0) {
				return vo;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null; // 실패할 경우에는 null을 반환
	}
	
	// 로그인
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
