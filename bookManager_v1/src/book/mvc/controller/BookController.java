package book.mvc.controller;

import java.util.ArrayList;

import book.mvc.model.dao.BookDao;
import book.mvc.model.vo.Book;
import book.mvc.service.BookService;
import book.mvc.view.BookMenu;



public class BookController {
	
	
	
	private BookDao bdao = new BookDao();
	private BookService bservice = new BookService();

	public BookController() {}
	
	public void insertBook(Book bk) {	
		int result = bservice.insertBook(bk);
		
		if(result > 0) {
			System.out.println("도서 추가 성공");
		}else {
			System.out.println("도서추가 실패");
		}
		return;
	}
	
	
	public void updateBook(Book bk) {
		int result = bservice.updateBook(bk);
		
		if(result > 0) {
			System.out.println("수정 성공");
		}else {
			System.out.println("수정 실패");
		}
		return;
		
	}

	public void deleteBook(int bookId) {
		int result = bservice.deleteBook(bookId);
		
		if(result > 0) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("도서가 존재하지 않습니다.");
		}
		
		
	}
	
	public ArrayList<Book> searchBookTitle(String bookTitle) {
		ArrayList<Book> blist = bservice.searchBookTitle(bookTitle);
		
		if(blist.size() == 0) {
			System.out.println("없는 도서입니다.");
		}
	   return blist;
		
	}
	
	public ArrayList<Book> selectAll() {
		ArrayList<Book> blist = bservice.selectAllBooks();
		
		if(blist.size() == 0) {
			System.out.println("등록된 도서가 없습니다.");
			new BookMenu().displayMenu();
		}
		
		return blist;
	}

	public ArrayList<Book> searchBookId(int BookId) {
		ArrayList<Book> blist = bservice.selectBookId(BookId);
		
		if(blist.size() == 0) {
			System.out.println("찾는 도서가 없습니다.");
			new BookMenu().displayMenu();
		}
		
		return blist;
	}

	
	
}