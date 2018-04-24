package com.test.collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Stack;

public class Ex_Diary {

	public static void main(String[] args) {
		
	
		
//		문제 5. 
//
//		리소스] 일기.dat
//		요구사항 ] 적혀있는 문장들을 역순으로 저장하시오
//		조건 ] 일기_역순.dat 으로 복사
	
		


			
			
			String path = "D:\\파일_입출력_문제\\일기.dat";
			
			try {
				BufferedReader reader = new BufferedReader(new FileReader(path));
				Stack<String> stack = new Stack<String>(); // 후입선출을 하기 위해 Stack을 호출한다.
				 
				String line = ""; 
				String diary = ""; //line과 diary를 선언하고 초기화해줌
		
				while((line = reader.readLine()) != null) {
					stack.push(line); 
					
				}
				
				reader.close(); // reader 와 write는 함께 쓸수없기 떄문에 close를 꼭해줌 
				
				
				String renamepath ="D:\\파일_입출력_문제\\일기_역순.dat"; //주소에 _역순을 붙여 복사본 생성 
				
				BufferedWriter write = new BufferedWriter(new FileWriter(renamepath)); 
				while(stack.size() > 0) {
					diary= diary + stack.pop() + "\r\n";
					
				}
				write.write(diary);
				
				write.close();
				System.out.println("완료되었습니다.");
			
				
			} catch (Exception e) {
				System.out.println("main : " + e.toString());
			}
			


					
					
				
				
			
				
				
					
				}
				
						
						
			
		
	
	
	
	
	}

	

