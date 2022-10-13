package co.edu.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// CreateREadUpdateDelete DB여기 넣으래
public class BoardDAO extends DAO{
	//댓글 추가
	public void insert(Reply rpl) {
		String sql = "insert into reply(rep_seq, board_num, rep_content, rep_writer, creation_date)\r\n"
				+ "values(reply_seq.nextval, ? , ? , ? , sysdate)";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, rpl.getReBNum());
			psmt.setString(2, rpl.getReContent());
			psmt.setString(3, rpl.getReWriter());			
			psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	//댓글 조회
	public List<Reply> getR(int num) {
		String sql = "select * from Reply where board_num = ?";
		conn = getConnect();
		List<Reply> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();
			while(rs.next()) {
				list.add(new Reply(rs.getInt("rep_seq")
						,rs.getInt("board_num")
						,rs.getString("rep_content")
						,rs.getString("rep_writer")
						,rs.getString("creation_date")
						));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	// 로그인
	public int login(String id, String passwd) {
		String sql = "select * from users where id = ? and passwd = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, passwd);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
					return 1;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;
	}// end of login
	
	//보드 시작
	public void insert(Board brd) {
		String sql = "insert into board(board_num, board_title, board_content, board_writer)\r\n"
				+ "values( ? , ? , ? , ? )";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, brd.getNum());
			psmt.setString(2, brd.getTitle());
			psmt.setString(3, brd.getContent());
			psmt.setString(4, brd.getWriter());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력됨");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}	
	} // end of insert
	
	public void update(Board brd) {
		String sql = "update board "
				+ "set board_content = ?, "
				+ "creation_date = sysdate "
				+ "where board_num = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, brd.getContent());
			psmt.setInt(2, brd.getNum());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경됨.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	} // end of update
	
	public boolean delete(int num) {
		String sql = "delete from board where board_num = ?";
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
	} // end of delete
	
	public List<Board> search() {
		conn = getConnect();
		List<Board> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from board order by board_num");
			while(rs.next()) {
				list.add(new Board(rs.getInt("board_num")
						,rs.getString("board_title")
						,rs.getString("board_content")
						,rs.getString("board_writer")
						,rs.getString("creation_date")
						,rs.getInt("cnt")
				));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	} // end of search
	
	public Board getNum(int num) {
		String sql = "select * from board where board_num = ?";
		String cnt = "update board set cnt = cnt + 1 where board_num = ?";
		conn = getConnect();
		Board sNum = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();
			
			psmt = conn.prepareStatement(cnt);
			psmt.setInt(1, num);
			psmt.executeUpdate();
//			System.out.println(r + "만큼 조회수 업뎃");
			
			if(rs.next()) {
				sNum = new Board(rs.getInt("board_num")
						,rs.getString("board_title")
						,rs.getString("board_content")
						,rs.getString("board_writer")
						,rs.getString("creation_date")
						,rs.getInt("cnt")
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return sNum;
	} // end of getNum
}
