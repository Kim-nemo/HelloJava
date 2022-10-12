package co.edu.board;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private int num;
	private String title;
	private String content;
	private String writer;
	private String date;
	private String cnt;
	
	public Board() {}

	public Board(int num, String title, String content, String writer, String date, String cnt) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.cnt = cnt;
	}
	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCnt() {
		return cnt;
	}

	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String toString() {
		return "[글 번호= " + num + ",제목: "+title+", 작성자: "+writer+", 작성일시: " + date+"]";
	}
}
