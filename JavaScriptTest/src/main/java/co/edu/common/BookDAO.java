package co.edu.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.book.BookVO;

public class BookDAO extends DAO {
	
	public void insertBook(BookVO vo) { // insert
		getConnect();
		String sql = "insert into tbl_book (book_code, book_name, author, press, price) \r\n"
				+ "values( ? , ? , ? , ? ,? )";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookCode());
			psmt.setString(2, vo.getBookName());
			psmt.setString(3, vo.getAuthor());
			psmt.setString(4, vo.getPress());
			psmt.setInt(5, vo.getPrice());
			
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	
	
	public List<BookVO> bookList() {
		getConnect();
		List<BookVO> list = new ArrayList<>();
		String sql = "select * from tbl_book";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				BookVO vo = new BookVO();
				vo.setBookCode(rs.getString("book_code"));
				vo.setBookName(rs.getString("book_name"));
				vo.setAuthor(rs.getString("author"));
				vo.setPress(rs.getString("press"));
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		// 도서목록을 반환하도록 구성.
		return list;
	}
}
