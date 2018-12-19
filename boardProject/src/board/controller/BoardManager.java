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
	System.out.println("board_list 파일이 없습니다.");}
	 catch (Exception e) {
	e.printStackTrace();}

	 }
			 
	 
	 public void writeBoard() {
			
			System.out.println("새 게시글 쓰기 입니다.");
			System.out.print("글 제목 : ");
			String boardTitle = sc.nextLine();
			System.out.print("작성자 : ");
			String boardWriter = sc.next();
			sc.nextLine();  //버퍼의 엔터키 제거
			Date today = new Date();
			System.out.print("글 내용 : \n");
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
		 System.out.print("조회할 글번호 : ");
		 int index = sc.nextInt();
		 System.out.println(list.get(index));
		 list.get(index).setReadCount(list.get(index).getReadCount() + 1);
	 }
	 
	 
	 public void searchBoard() {
		 System.out.print("검색할 제목 : ");
		 String find = sc.nextLine();
		 for(int i = 0; i < list.size(); i++) {
			 if(find.equals(list.get(i).getBoardTitle())) {
				 System.out.println(list.get(i));
			 }
		 }
	 }
	 
	 public void modifyTitle() {
		 try {
		 System.out.print("수정할 글번호 : ");
		 int boardNo = sc.nextInt();
		 System.out.println(list.get(boardNo).getBoardContent());
		 System.out.print("변경할 제목 : ");
		 sc.nextLine();
		 String modify = sc.nextLine();
		 list.get(boardNo).setBoardTitle(modify);
		 }catch(Exception e) {
			 System.out.println("잘못된 숫자 입력하셨습니다.");
		 }
	 }
	 
	 public void modifyContent() {
		 System.out.print("수정할 글번호 : ");
		 int boardNo = sc.nextInt();
		 System.out.println(list.get(boardNo).getBoardContent());
		 System.out.print("변경할 내용 : \n");
		 StringBuilder sb = new StringBuilder();
		 String line = null;
		 while(!(line = sc.nextLine()).equals("exit")) {
			 sb.append(line + "\n");
		 }
	 }
	 
	 public void deleteBoard() {
		 System.out.print("삭제할 글번호 : ");
		 int boardNo = sc.nextInt();
		 System.out.println(list.get(boardNo).getBoardContent());
		 System.out.println("정말 삭제하시겠습니까 ? (y/n)");
		 if(sc.next().toUpperCase().charAt(0) == 'Y')
			 list.remove(boardNo);
		 System.out.println(boardNo + "번 글이 삭제되었습니다.");
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
					
					System.out.println("board_list.dat에 성공적으로 저장되었습니다.");
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

