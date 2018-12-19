package board.controller;

import java.io.*;
import java.util.*;
import board.model.vo.*;

public class BoardManager {

	 private ArrayList<Board> list = new ArrayList<Board>();
	 private Scanner sc = new Scanner(System.in);
	 
	 public BoardManager() {
		//Board [] b = new Board[100]; 
		try(ObjectInputStream objin = new ObjectInputStream(new FileInputStream("board_list.dat"));)
		{	
	/*		for(int i = 0; i < b.length; i++) {
				b[i] = (Board)objin.readObject();	
			}
			
			for(int i = 0; i < list.size(); i++ ) {
				System.out.println(list.add(i, b[i]);
			}*/

			list = (ArrayList<Board>) objin.readObject();
			
			/*for(int i = 0; i < list.size(); i++) {
				Board b1 = (Board)objin.;*/
			
	} catch (FileNotFoundException e) {
	System.out.println("board_list ������ �����ϴ�.");}
	 catch (Exception e) {
	e.printStackTrace();}

	 }
			 
	 
	 public void writeBoard() {
			
			System.out.println("�� �Խñ� ���� �Դϴ�.");
			System.out.print("�� ���� : ");
			String boardTitle = sc.nextLine();
			System.out.print("�ۼ��� : ");
			String boardWriter = sc.next();
			sc.nextLine();  //������ ����Ű ����
			Date today = new Date();
			System.out.print("�� ���� : \n");
			StringBuilder sb = new StringBuilder();
			String line = null;
			while(!((line = sc.nextLine()).equals("exit"))){
				sb.append(line +"\n");
			}
			
			Board b = new Board(list.size(),boardTitle,boardWriter,today,sb.toString(),0);
			list.add(b);
			
	}
	 
	 public void displayBoard() {
		 Board b = new Board();
		 System.out.print("��ȸ�� �۹�ȣ : ");
		 int index = sc.nextInt();
		 System.out.println(list.get(index));
		 list.get(index).setReadCount(list.get(index).getReadCount() + 1);
	 }
	 
	 
	 public void searchBoard() {
		 System.out.print("�˻��� ���� : ");
		 String find = sc.nextLine();
		 for(int i = 0; i < list.size(); i++) {
			 if(find.equals(list.get(i).getBoardTitle())) {
				 System.out.println(list.get(i));
			 }
		 }
	 }
	 
	 public void modifyTitle() {
		 try {
		 System.out.print("������ �۹�ȣ : ");
		 int boardNo = sc.nextInt();
		 System.out.println(list.get(boardNo).getBoardContent());
		 System.out.print("������ ���� : ");
		 sc.nextLine();
		 String modify = sc.nextLine();
		 list.get(boardNo).setBoardTitle(modify);
		 }catch(Exception e) {
			 System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�.");
		 }
	 }
	 
	 public void modifyContent() {
		 System.out.print("������ �۹�ȣ : ");
		 int boardNo = sc.nextInt();
		 System.out.println(list.get(boardNo).getBoardContent());
		 System.out.print("������ ���� : \n");
		 StringBuilder sb = new StringBuilder();
		 String line = null;
		 while(!(line = sc.nextLine()).equals("exit")) {
			 sb.append(line + "\n");
		 }
	 }
	 
	 public void deleteBoard() {
		 System.out.print("������ �۹�ȣ : ");
		 int boardNo = sc.nextInt();
		 System.out.println(list.get(boardNo).getBoardContent());
		 System.out.println("���� �����Ͻðڽ��ϱ� ? (y/n)");
		 if(sc.next().toUpperCase().charAt(0) == 'Y')
			 list.remove(boardNo);
		 System.out.println(boardNo + "�� ���� �����Ǿ����ϴ�.");
	 }
	 
	 public void saveListFile() {

		Board[] b = new Board[100];		 
		try(ObjectOutputStream objOut = new ObjectOutputStream(
						new FileOutputStream("board_list.dat"));){
					for(int i = 0; i < b.length; i++) {
						objOut.writeObject(b[i]);
					}
					for(int i = 0; i < b.length; i++)
					list.add(i, b[i]);
					
					System.out.println("board_list.dat�� ���������� ����Ǿ����ϴ�.");
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		 
	 public void sortList(int item, boolean isDesc) {
		if(isDesc = false) { 
		 if(item == 1) {
			 list.sort(new AcsBoardNo());
			 if(item == 2) {
				 list.sort(new AscBoardDate());{
					 if(item == 3)
						 list.sort(new AscBoardTitle());
				 }
			 }
		  }
		}else {
			 if(item == 1) {
				 list.sort(new DescBoardNo());
				 if(item == 2) {
					 list.sort(new DescBoardDate());{
						 if(item == 3)
							 list.sort(new DescBoardTitle());
					 }
				 }
			  }		
		}
	 }
	 
	 
	 public void displayAllList() {
		 System.out.println(list);
	 }
		 
	 }

