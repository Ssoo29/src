package book.mvc.model.dao;

import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import book.exception.BookException;
import book.mvc.model.vo.Book;
import static common.JDBCTemplate.*;

public class BookDao {
	private Properties prop = new Properties();
	
	
	public BookDao() {
		try {
			prop.load(new FileReader("properties/query.properties"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insertBook(Connection conn, Book bk) throws BookException{
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insert");
		
		try {				
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bk.getTitle());
			pstmt.setString(2, bk.getAuthor());
			pstmt.setString(3, bk.getPublisher());
			pstmt.setDate(4, bk.getPublish_date());
			pstmt.setInt(5, bk.getPrice());
			
			result = pstmt.executeUpdate();
	
			if(result <= 0 )
			rollback(conn);
			System.out.println("도서 입력에 실패하였습니다.");
			
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		}finally {
			try {
				close(pstmt);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int updateBook(Connection conn, Book bk) throws BookException{
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("updateb");
		
		try {
			pstmt = conn.prepareStatement(query);	
			pstmt.setInt(1, bk.getPrice());
			pstmt.setString(1, bk.getTitle());
			result = pstmt.executeUpdate();
			
			if(result <= 0 )
				rollback(conn);
				System.out.println("도서 수정에 실패하였습니다(title).");
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();


			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	
	public int deleteBook(Connection conn, int bookId) throws BookException {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("delete");
		try {

		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, bookId);
		result = pstmt.executeUpdate();
		
		if(result <= 0 )
			rollback(conn);
			System.out.println("도서 삭제 실패하였습니다.");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}	
		return result;
	}
	
	public ArrayList<Book> selectAllBooks(Connection conn) throws BookException{
		ArrayList<Book> blist = new ArrayList<>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectall");
		
		try {	
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Book bk = new Book();
				bk.setBook_id(rset.getInt("book_id"));
				bk.setTitle(rset.getString("title"));
				bk.setAuthor(rset.getString("author"));
				bk.setPublisher(rset.getString("publisher"));
				bk.setPublish_date(rset.getDate("publish_date"));
				bk.setPrice(rset.getInt("price"));
				
				blist.add(bk);
			}
			
			if(blist.size() == 0) {
				System.out.println("조회한 정보가 존재하지 않습니다.");
			}
		
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		}finally {
			try {
				close(rset);
				close(stmt);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return blist;
		
	}
	
	public ArrayList<Book> searchBookTitle(Connection conn, String bookTitle) throws BookException{
		ArrayList<Book> blist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectbooktitle");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookTitle);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Book bk = new Book();
				bk.setBook_id(rset.getInt("book_id")); 
				bk.setTitle(bookTitle);
				bk.setAuthor(rset.getString("author"));
				bk.setPublisher(rset.getString("publisher")); 
				bk.setPublish_date(rset.getDate("publish_date")); 
				bk.setPrice(rset.getInt("price"));
						
				blist.add(bk);
			}
			if(blist.size() == 0) {
				System.out.println("조회한 도서가 존재하지 않습니다.");
			}
			
			
		} catch (Exception e) {
			System.out.println("무언가 잘못되었다.");
		}finally {
			try {
				close(rset);
				close(pstmt);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return blist;
		
	}
	
	public ArrayList<Book> selectBookId(Connection conn, int bookId) throws BookException {
		ArrayList<Book> blist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectbookid");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Book bk = new Book();
				bk.setBook_id(bookId); 
				bk.setTitle(rset.getString("title"));
				bk.setAuthor(rset.getString("author"));
				bk.setPublisher(rset.getString("publisher")); 
				bk.setPublish_date(rset.getDate("publish_date")); 
				bk.setPrice(rset.getInt("price"));
						
				blist.add(bk);
			}
			if(blist.size() == 0) {
				System.out.println("조회하신 도서가 존재하지 않습니다.");
			}
			
			
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		}finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return blist;
		
	}
	
}
