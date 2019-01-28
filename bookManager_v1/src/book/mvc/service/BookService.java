package book.mvc.service;

import java.sql.*;
import java.util.*;

import book.mvc.model.dao.BookDao;
import book.mvc.model.vo.Book;
import static common.JDBCTemplate.*;


public class BookService {

	private BookDao bdao = new BookDao();
	
	public BookService() {}
	
	public int insertBook(Book bk) {
		Connection conn = getConnection();
		int result = bdao.insertBook(conn, bk);
		System.out.println(bk);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
		return result;
	}
	
	public int updateBook(Book bk) {
		Connection conn = getConnection();
		int result = bdao.updateBook(conn, bk);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
		return result;
		
	}
	
	public int deleteBook(int bookId) {
		Connection conn = getConnection();
		int result = bdao.deleteBook(conn, bookId);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
		return result;
	}
	
	public ArrayList<Book> selectAllBooks(){
		Connection conn = getConnection();
		ArrayList<Book> blist = bdao.selectAllBooks(conn);
		close(conn);
		return blist;
		
	}
	
	public ArrayList<Book> searchBookTitle(String bookTitle){
		Connection conn = getConnection();
		ArrayList<Book> blist = bdao.searchBookTitle(conn, bookTitle);
		close(conn);
		return blist;

	}
	
	public ArrayList<Book> selectBookId(int BookId) {
		Connection conn = getConnection();
		ArrayList<Book> blist = bdao.selectBookId(conn, BookId);
		close(conn);
		
		return blist;

		
	}
}
