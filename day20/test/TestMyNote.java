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
		System.out.println("	1. ��Ʈ ���� �����	\r\n" + 
				"	2. ��Ʈ ����		\r\n" + 
				"	3. ��Ʈ ��� �����ϱ�	\r\n" + 
				"	4. ������		\r\n" + 
				"\r\n" + 
				"	�޴� ���� : ��ȣ�Է� : ");
		
		no = sc.nextInt();
		
		switch(no) {
		case 1 : mb.fileSave(); break;
		case 2 : mb.fileOpen();	break;
		case 3 : mb.fileEdit();	break;
		case 4 : return;
		
		
		}
	}

}
