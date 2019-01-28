package book.mvc.service;

import java.sql.*;
import java.util.*;

import book.exception.BookException;
import book.mvc.model.dao.BookDao;
import book.mvc.model.vo.Book;
import static common.JDBCTemplate.*;


public class BookService {

	private BookDao bdao = new BookDao();
	
	public BookService() {}
	
	public int insertBook(Book bk) throws BookException{
		Connection conn = getConnection();
		int result = bdao.insertBook(conn, bk);
		System.out.println(bk);
	
		
		return result;
	}
	
	public int updateBook(Book bk)throws BookException {
		Connection conn = getConnection();
		int result = bdao.updateBook(conn, bk);

		return result;
		
	}
	
	public int deleteBook(int bookId)throws BookException {
		Connection conn = getConnection();
		int result = bdao.deleteBook(conn, bookId);

		return result;
	}
	
	public ArrayList<Book> selectAllBooks()throws BookException{
		Connection conn = getConnection();
		ArrayList<Book> blist = bdao.selectAllBooks(conn);
		close(conn);
		return blist;
		
	}
	
	public ArrayList<Book> searchBookTitle(String bookTitle)throws BookException{
		Connection conn = getConnection();
		ArrayList<Book> blist = bdao.searchBookTitle(conn, bookTitle);
		close(conn);
		return blist;

	}
	
	public ArrayList<Book> selectBookId(int BookId) throws BookException{
		Connection conn = getConnection();
		ArrayList<Book> blist = bdao.selectBookId(conn, BookId);
		close(conn);
		
		return blist;

		
	}
}
