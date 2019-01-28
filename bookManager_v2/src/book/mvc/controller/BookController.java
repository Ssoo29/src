package book.mvc.controller;

import java.util.ArrayList;

import book.exception.BookException;
import book.mvc.model.dao.BookDao;
import book.mvc.model.vo.Book;
import book.mvc.service.BookService;
import book.mvc.view.BookMenu;



public class BookController {
	
	
	
	private BookDao bdao = new BookDao();
	private BookService bservice = new BookService();

	public BookController() {}
	
	public void insertBook(Book bk) {	
		
		try {
			int result = bservice.insertBook(bk);
			
			if(result > 0)
				System.out.println("새로운 도서 입력 성공");
			
		} catch (BookException e) {
			new BookException(e.getMessage());
			new BookMenu().displayMenu();
		}
		
		return;
	}
	
	
	public void updateBook(Book bk) {

		
		try {
			int result = bservice.updateBook(bk);
			if(result > 0)
				System.out.println("도서 수정 성공");
			
		} catch (BookException e) {
			new BookException(e.getMessage());
			new BookMenu().displayMenu();
		}
		
		return;
		
	}

	public void deleteBook(int bookId) {
		
		try {
			int result = bservice.deleteBook(bookId);
			if(result > 0)
				System.out.println("도서 삭제 성공");
			
		} catch (BookException e) {
			new BookException(e.getMessage());
			new BookMenu().displayMenu();
		}
		
		
	}
	
	public ArrayList<Book> searchBookTitle(String bookTitle) {
		ArrayList<Book> blist = null;
		try {
			blist = bservice.searchBookTitle(bookTitle);
			
		} catch (BookException e) {
			new BookException(e.getMessage());
			new BookMenu().displayMenu();
		}
		

	   return blist;
		
	}
	
	public ArrayList<Book> selectAll() {
		ArrayList<Book> blist = null;
		try {
			blist = bservice.selectAllBooks();
		} catch (BookException e) {
			new BookException(e.getMessage());
			new BookMenu().displayMenu();
		}

		
		return blist;
	}

	public ArrayList<Book> searchBookId(int BookId) {
		ArrayList<Book> blist = null;
		try {
			blist = bservice.selectBookId(BookId);
		} catch (BookException e) {
			new BookException(e.getMessage());
			new BookMenu().displayMenu();
		}
		

		return blist;
	}

	
	
}