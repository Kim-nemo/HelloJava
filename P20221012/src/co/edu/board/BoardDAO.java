package co.edu.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// CreateREadUpdateDelete DB여기 넣으래
public class BoardDAO extends DAO{
	
	public void insert(Board brd) {
		String sql = "insert into board(board_num, board_title, board_content, board_writer)"
				+ "values( " + brd.getNum()
				+ ", '" + brd.getTitle()
				+ ", '" + brd.getContent()
				+ ", '" + brd.getWriter()
				+ ", '" + brd.getDate()
				+ ", '" + brd.getCnt() + "')";
		conn = getConnect();
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			System.out.println(r + "건 입력됨");
		}catch(SQLException e){
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
			psmt.setString(2, brd.getDate());
			psmt.setInt(3, brd.getNum());
			
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	} // end of search
	
	public Board getNum(int num) {
		String sql = "select * from board where board_num = ?";
		conn = getConnect();
		Board sNum = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();
			
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
	}
}
