package com.edu.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	public void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

// 전체리스트조회, 신규입력, 수정, 삭제  - DBMS
	// 한건조회
	public BookBean getBook(String title) {
		String sql = "select * from book where title = ?";
		conn = DAO.connect();
		BookBean book = new BookBean();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			rs = psmt.executeQuery();
			if (rs.next()) {
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setTitle(rs.getString("title"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return book;
	}

	// 전체리스트(여러건조회
	public List<BookBean> getBookList() {
		String sql = "select * from book";
		conn = DAO.connect();
		List<BookBean> bookList = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BookBean book = new BookBean();
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setTitle(rs.getString("title"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return bookList;
	}

	// 저자별 책조회: author -> 책리스트를 반환(getBooksbyAuthor)
	public BookBean getBooksByAuthor(String author){
		String sql = "select * from book where author=?";
		conn = DAO.connect();
		BookBean book = new BookBean();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, author);
			rs = psmt.executeQuery();
			if (rs.next()) {
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setTitle(rs.getString("title"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	return null;
	}
	
	//한건입력 :BookbBean타입 -> insertBook(BookBean book)
	public void insertBook(BookBean book) {
		String sql ="insert into book values(?,?,?)";
		conn = DAO.connect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getTitle());
			psmt.setString(2, book.getAuthor());
			psmt.setString(3, book.getPublisher());
			int r = psmt.executeUpdate();
			System.out.println(r);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
