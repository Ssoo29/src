package day20.silsub1;

import java.util.*;
import java.io.*;

public class MyNote  {

	private static Scanner sc = new Scanner(System.in);
	
	
	public MyNote() {}
	
	public void fileSave() {
		String fileName = null;
		StringBuilder sb = new StringBuilder();	
		
		System.out.println("저장할 내용 : ");
		
		String line = null;
		while(!(line = sc.nextLine()).equals("exit")){
				sb.append(line + "\n");
			}	
		System.out.println(sb.toString());
		
		System.out.print("저장 ? (y/n)");
		char ans = sc.next().toUpperCase().charAt(0);
		if(ans == 'Y') {
			System.out.print("파일명 : ");
		 fileName = sc.next();
			
		try(BufferedWriter bw =
				new BufferedWriter(new FileWriter(fileName));){
				
				bw.write(sb.toString());
				bw.flush();
			System.out.println("입력완료.");	
			
		}catch (FileNotFoundException e) {
				e.printStackTrace();
		}catch (IOException e) {
				e.printStackTrace();}
	
		
	}
}
		
	
	
	public void fileOpen() {
		
		System.out.print("열기할 파일명 : ");
		String fileName = sc.next();

		try(BufferedReader br 
				= new BufferedReader(
						new FileReader(fileName)); ){	
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			System.out.println("\n읽기완료!");
			System.out.println(sb.toString());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
			
			}

		
	
	public void fileEdit() {
		StringBuilder sb = new StringBuilder(); 
		
		System.out.print("수정할 파일명 : ");
		String fileName = sc.next();
		try(BufferedReader br 
				= new BufferedReader(
						new FileReader(fileName)); ){	
			
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			System.out.println("\n읽기완료!");
			System.out.println(sb.toString());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(BufferedWriter bw =
				new BufferedWriter(new FileWriter(fileName));)
		{		System.out.println("파일에 추가할 내용을 입력하세요.");
		       	String line = null;
		       	while(!(line = sc.nextLine()).equals("exit")) {
		       		sb.append(line + "\n");
		       	}
		       	
		    	System.out.print("변경된 내용 추가 ? (y/n)");
				char ans = sc.next().toUpperCase().charAt(0);
				if(ans == 'Y') 
				bw.write(sb.toString());
				bw.flush();
			System.out.println("입력완료.");	
			
		}catch (FileNotFoundException e) {
				e.printStackTrace();
		}catch (IOException e) {
				e.printStackTrace();}
		
		
		
		
		
		

		
		
	}
}
