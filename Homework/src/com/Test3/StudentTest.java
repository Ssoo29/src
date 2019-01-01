package com.Test3;

import java.util.Arrays;

public class StudentTest {

	public static void main(String[] args) {
	//	Student s = new Student();
		
		Student [] st = new Student[3];
		
		st[0] = new Student("홍길동", 15, 170, 80);
		st[1] = new Student("한사람", 13, 180, 70);
		st[2] = new Student("임걱정", 16, 175, 65);
		
		for(int i = 0; i < st.length; i++) {
			System.out.println(st[i].studentInfo());
		}
		
		System.out.printf("나이 평균 : %.3f\n" ,(double)(st[0].getAge() + st[1].getAge() + st[2].getAge())/3);
		System.out.printf("신장평균 : %.3f\n",(double)((st[0].getHeight() + st[1].getHeight() + st[2].getHeight())/3));
		System.out.printf("몸무게 평균 : %.3f\n" ,(double)(st[0].getWeight() + st[1].getWeight() + st[2].getWeight())/3);
		
		//나이구하기
		int maxage = st[0].getAge();
		int minage = st[0].getAge();
			
		for(int i = 0; i < st.length; i++) {
			if(maxage < st[i].getAge()) {
				maxage = st[i].getAge();		
				}
			}
		for(int i = 0; i < st.length; i++)
		if(maxage == st[i].getAge()) {
			System.out.println("연장자 : " + st[i].getName());
		}
		
		for(int i = 0; i < st.length; i++){
			if(minage > st[i].getAge()) {
				minage = st[i].getAge();	
				}
			}
		for(int i = 0; i < st.length; i++) {
			if(minage == st[i].getAge()) {
				System.out.println("최연소 : " + st[i].getName());
			}
		}
			
		//키구하기
		int maxheight = st[0].getHeight();
		int minheight = st[0].getHeight();
		
		for(int i = 0; i < st.length; i++) {
			if(maxheight < st[i].getHeight()) 
				maxheight = st[i].getHeight();			
			}
		for(int i = 0; i < st.length; i++) {
		if(maxheight == st[i].getHeight()) 
			System.out.println("신장이 가장 큰 학생 : " + st[i].getName());
		}
		
		for(int i = 0; i < st.length; i++) {
		if(minheight > st[i].getHeight()) 
			minheight = st[i].getHeight();
		}
		for(int i = 0; i < st.length; i++) {
		if(minheight == st[i].getHeight()) 
			System.out.println("신장이 가장 작은 학생 : " + st[i].getName());
		}
		
		
		//몸무게 구하기
		int maxweight = st[0].getWeight();
		int minweight = st[0].getWeight();
		
		for(int i = 0; i < st.length; i++) {
			if(minweight < st[i].getWeight()) 
				minweight = st[i].getWeight();
			}
		for(int i = 0; i < st.length; i++) {
			if(minweight == st[i].getWeight()) 
				System.out.println("몸무게 제일 많아 나가는 사람 : " + st[i].getName());
			}
		
		
		for(int i = 0; i < st.length; i++) {
			if(minweight > st[i].getWeight()) 
				minweight = st[i].getWeight();
			}
		for(int i = 0; i < st.length; i++) {
			if(minweight == st[i].getWeight()) 
				System.out.println("몸무게 제일 적게 나가는 사람 : " + st[i].getWeight());
			}	
		}
}
	




