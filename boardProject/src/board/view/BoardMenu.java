package board.view;

import java.util.*;

import board.controller.BoardManager;

public class BoardMenu {
	
	private Scanner sc = new Scanner(System.in);
	
	public BoardMenu() {}
	
	public void mainMenu() {
		BoardManager bm = new BoardManager();
		int no = 0;
		
		do {
		System.out.println("\r\n" + 
				"	******* �Խñ� ���� ���α׷� *******\r\n" + 
				"\r\n" + 
				"	1. �Խñ� ����		\n" + 
				"	2. �Խñ� ��ü ����		\n" + 
				"	3. �Խñ� �Ѱ� ����		\n" + 
				"	4. �Խñ� ���� ����		\n" + 
				"	5. �Խñ� ���� ����		\n" + 
				"	6. �Խñ� ����		\n" + 
				"	7. �Խñ� �˻�		\n" + 
				"	8. ���Ͽ� �����ϱ�	\n" + 
				"	9. �����ϱ�		\n" + 
				"	9. ������		\n" + 
				"");
		
		System.out.print("�޴� ��ȣ ���� : ");
		no = sc.nextInt();
		
		switch(no) {
		case 1 : bm.writeBoard(); break;
		case 2 : bm.displayAllList(); break;
		case 3 : bm.displayBoard(); break;
		case 4 : bm.modifyTitle(); break;
		case 5 : bm.modifyContent(); break;
		case 6 : bm.deleteBoard(); break;
		case 7 : bm.searchBoard(); break;
		case 8 : bm.saveListFile(); break;
		case 9 : sortSubMenu();					
		 return;
		
		}
		
	}while(no != 9);
	}
	public void sortSubMenu() {
		BoardManager bm = new BoardManager();
		int no = 0;
		
		do {
		System.out.println("****** �Խñ� ���� �޴� ******\r\n" + 
				"\r\n" + 
				"	1. �۹�ȣ�� ������������	\n" + 
				"	2. �۹�ȣ�� ������������	\n" + 
				"	3. �ۼ���¥�� ������������	\n" + 
				"	4. �ۼ���¥�� ������������	\n" + 
				"	5. ������� ������������	\n" + 
				"	6. ������� ������������	\n" + 
				"	7. ���� �޴��� �̵�		");
		
		System.out.print("�޴� �Է� : ");
		no = sc.nextInt();
		
		switch(no) {
		case 1 : bm.sortList(1, false); break;
		case 2 : bm.sortList(1, true); break;
		case 3 : bm.sortList(2, false); break;
		case 4 : bm.sortList(2, true); break;
		case 5 : bm.sortList(3, false); break;
		case 6 : bm.sortList(3, true); break;
		case 7 : return;
		
		}
		
		}while(no != 7);
		
	}
}

