package book.mvc.view;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import book.mvc.controller.BookController;
import book.mvc.model.vo.Book;

public class BookMenu {
	
	private BookController bcon = new BookController();
	private Scanner sc = new Scanner(System.in);

	
	public void displayMenu() {
	 
	 
	do {
	System.out.println("1. 도서 추가");	
	System.out.println("2. 도서 정보 수정");	
	System.out.println("3. 도서 삭제");	
	System.out.println("4. 도서 아이디로 조회");	
	System.out.println("5. 도서 제목으로 조회");	
	System.out.println("6. 도서 목록 전체 조회");		
	System.out.println("9. 끝내기");	
	System.out.print("번호 선택 : ");
	int no = sc.nextInt();
	
	switch(no) {
	case 1 : bcon.insertBook(inputBook()); break;
	case 2 : bcon.updateBook(inputBookUpdate()); break;
	case 3 : bcon.deleteBook(inputBookid()); break;
	case 4 : printList(bcon.searchBookId(inputBookId())); break;
	case 5 : printList(bcon.searchBookTitle(inputBookTitle())); break;
	case 6 : printList(bcon.selectAll()); break;
	case 9 : return;
	}
		
	}while(true);

}
	


	public int inputBookid() {
		System.out.print("삭제할 도서 아이디 입력 : ");
		return sc.nextInt();
	}

	private void printList(ArrayList<Book> blist) {
		for(Book bk : blist)
			System.out.println(bk);
		
	}

	public Book inputBook() {
		Book bk = new Book();
		
		System.out.print("도서제목입력 : " );
		bk.setTitle(sc.next());
		System.out.print("작가 입력 : ");
		bk.setAuthor(sc.next());
		System.out.print("출판사 입력 : ");
		bk.setPublisher(sc.next());
		System.out.print("출판일 입력[yyyy-MM-dd] : ");
		bk.setPublish_date(Date.valueOf(sc.next()));
		System.out.print("가격 입력 : ");
		bk.setPrice(sc.nextInt());
		
		return bk;
	}
	
	public Book inputBookUpdate() {
		Book bk = new Book();
		System.out.print("수정할 도서 제목 : ");
		bk.setTitle(sc.next());
		System.out.print("수정할 가격 : ");
		bk.setPrice(sc.nextInt());
		return bk;
		
	}
	
	public int inputBookId() {
		System.out.print("도서 아이디 입력 : ");
		return sc.nextInt();
	}
	
	public String inputBookTitle() {
		System.out.print("찾을 도서명 입력 : ");
		return sc.next();
	}
	

	
	public void printError(String message) {
		System.out.println("\n프로그램 작동에 문제 발생!");
		System.out.println("시스템 관리자에게 문의하여 주십시오.");
		System.out.println(message);
		
		displayMenu();
	}
	
	
	

}