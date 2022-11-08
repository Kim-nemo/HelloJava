package co.micol.prj.book.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.book.service.BookService;
import co.micol.prj.book.service.impl.bookServiceImpl;
import co.micol.prj.book.vo.BookVO;
import co.micol.prj.common.Command;

public class BookList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 책목록 가져오기
		BookService dao = new bookServiceImpl(); //구현체를 통해서 초기화
		List<BookVO> books = new ArrayList<>();
		books = dao.bookSelectList(); // 전체목록
		request.setAttribute("books", books); // 결과를 담음
		
		return "book/bookList"; // 보여줄 페이지  books라는 리스트를 book/bookList에 던져줌
	}

}
