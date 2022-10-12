package co.edu.board;

import java.sql.SQLException;
import java.util.Scanner;

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
		
	}	
}
