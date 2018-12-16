package day20.test;

import java.util.*;
import day20.silsub1.*;

public class TestMyNote {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		menu();		

	}
	
	public static void menu() {
		MyNote mb = new MyNote();
		
		int no = 0;
		
		System.out.println("******* My Note *********");
		System.out.println("	1. 노트 새로 만들기	\r\n" + 
				"	2. 노트 열기		\r\n" + 
				"	3. 노트 열어서 수정하기	\r\n" + 
				"	4. 끝내기		\r\n" + 
				"\r\n" + 
				"	메뉴 선택 : 번호입력 : ");
		
		no = sc.nextInt();
		
		switch(no) {
		case 1 : mb.fileSave(); break;
		case 2 : mb.fileOpen();	break;
		case 3 : mb.fileEdit();	break;
		case 4 : return;
		
		
		}
	}

}
