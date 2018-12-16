package day20.silsub1;

import java.util.*;
import java.io.*;

public class MyNote  {

	private static Scanner sc = new Scanner(System.in);
	
	
	public MyNote() {}
	
	public void fileSave() {
		String fileName = null;
		StringBuilder sb = new StringBuilder();	
		
		System.out.println("������ ���� : ");
		
		String line = null;
		while(!(line = sc.nextLine()).equals("exit")){
				sb.append(line + "\n");
			}	
		System.out.println(sb.toString());
		
		System.out.print("���� ? (y/n)");
		char ans = sc.next().toUpperCase().charAt(0);
		if(ans == 'Y') {
			System.out.print("���ϸ� : ");
		 fileName = sc.next();
			
		try(BufferedWriter bw =
				new BufferedWriter(new FileWriter(fileName));){
				
				bw.write(sb.toString());
				bw.flush();
			System.out.println("�Է¿Ϸ�.");	
			
		}catch (FileNotFoundException e) {
				e.printStackTrace();
		}catch (IOException e) {
				e.printStackTrace();}
	
		
	}
}
		
	
	
	public void fileOpen() {
		
		System.out.print("������ ���ϸ� : ");
		String fileName = sc.next();

		try(BufferedReader br 
				= new BufferedReader(
						new FileReader(fileName)); ){	
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			System.out.println("\n�б�Ϸ�!");
			System.out.println(sb.toString());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
			
			}

		
	
	public void fileEdit() {
		StringBuilder sb = new StringBuilder(); 
		
		System.out.print("������ ���ϸ� : ");
		String fileName = sc.next();
		try(BufferedReader br 
				= new BufferedReader(
						new FileReader(fileName)); ){	
			
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			System.out.println("\n�б�Ϸ�!");
			System.out.println(sb.toString());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(BufferedWriter bw =
				new BufferedWriter(new FileWriter(fileName));)
		{		System.out.println("���Ͽ� �߰��� ������ �Է��ϼ���.");
		       	String line = null;
		       	while(!(line = sc.nextLine()).equals("exit")) {
		       		sb.append(line + "\n");
		       	}
		       	
		    	System.out.print("����� ���� �߰� ? (y/n)");
				char ans = sc.next().toUpperCase().charAt(0);
				if(ans == 'Y') 
				bw.write(sb.toString());
				bw.flush();
			System.out.println("�Է¿Ϸ�.");	
			
		}catch (FileNotFoundException e) {
				e.printStackTrace();
		}catch (IOException e) {
				e.printStackTrace();}
		
		
		
		
		
		

		
		
	}
}
