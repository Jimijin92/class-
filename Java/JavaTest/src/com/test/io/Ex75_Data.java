package com.test.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

public class Ex75_Data {

	public static void main(String[] args) throws IOException {
		//Ex75_Data.java
		//m1();
		//m2();
		
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		
		//m9();
		m10();
		
	}
	
	
	private static void m10() {
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("gif", "100");
		map.put("jpg", "200");
		map.put("bmp", "300");
		
		
		Set<String> set = map.keySet(); //순서 상관 x
		
		Iterator<String> iter = set.iterator();
		
		while (iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + " : " + map.get(key));
			
		}
	}


	private static void m9() {

		String path = "D:\\Class\\Java\\JavaTest\\src\\com\\test\\io\\Ex75_Data.java";
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line = "";
			int lineNumber = 1;
			
			
			/*while (reader.readLine() != null) {
				String txt = reader.readLine();
				System.out.println(txt);
			}*/ //잘못된 코드 , 짝만 읽게 된다. 
			
			
			while ((line = reader.readLine()) != null) {
				System.out.printf("%03d : %s\n", lineNumber, line);
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("m9 : " + e.toString());
		}
		
	}


	private static void m8() {

		try {
			
			//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			//String txt = reader.readLine();
			
			BufferedReader reader = new BufferedReader(new FileReader("D:\\data.txt"));
			
//			String txt = reader.readLine();
//			System.out.println(txt);
//		   
//			txt = reader.readLine();
//			System.out.println(txt);
//		
//			txt = reader.readLine();
//			System.out.println(txt);
//
//			txt = reader.readLine();
//			System.out.println(txt);
//
//			txt = reader.readLine();
//			System.out.println(txt);

			String line = null;
			
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("m8 : " + e.toString());
		}
		
	}


	private static void m7() {
		//데이터 쓰기
		//	- 문자 & 문자열 쓰기
		//	- 유니코드 지원
		
		//BufferedWriter <-> BufferedReader
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\data.txt", true));
			
			writer.write("하나");
			writer.write("둘");
			writer.write("셋");
			
			writer.newLine(); //\r\n출력
			writer.write("넷");
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private static void m6() {
		Scanner scan = new Scanner(System.in);
		System.out.println("파일의 위치 : ");
		String path = scan.nextLine();
		
		try {
		
			//읽기
			//	- 문자 단위 읽기
			FileReader reader = new FileReader(path);
			
			//유니코드 지원
			//reader.read(); //읽을때는 한글자씩 
			
			int code = -1;
			
			//한글 읽기까지 지원가능
			while ((code = reader.read()) != -1) {
				System.out.println((char)code);
			}
			
			//Clean up코드
			reader.close();
			scan.close();
			
			
		} catch (Exception e) {
			System.out.println("m6 : " + e.toString());
		}
		
	}//m6


	private static void m5() throws IOException {
		//메모장 글쓰기
		
		Scanner scan = new Scanner(System.in);
		System.out.println("[메모장]");
		
		System.out.println("파일명 : ");
		String fileName = scan.nextLine();
		
		try {
		FileWriter writer = new FileWriter("D:\\" + fileName + ".txt");
		
		while(true) {
			String txt = scan.nextLine();
			
			if(txt.equals("exit")) {
				break;
			}
			
			writer.write(txt + "\r\n");
		}
		
		writer.close();
		scan.close();
		
		System.out.println("쓰기 완료");
		
		} catch (Exception e) {
			System.out.println("m5 : " + e.toString());
		}
		
	}//m5


	private static void m4() {
		//데이터 쓰기
		//	- 문자(2byte)  단위 쓰기
		
		try {
			
			//FileOutputStream
			FileWriter writer = new FileWriter("D:\\member.txt"); //이것도 생성모드
		
			writer.write(65);
			writer.write("ABCD");
			writer.write("안녕하세요.");
			
			 writer.close();
			//Scanner scan = new Scanner(System.in);
			//scan.nextLine();
			//마무리를 하고 죽는거지 정식클래스는 아님 
			//무조건 스스로 닫는 버릇을 들이기
			
		} catch (Exception e) {
			System.out.println("m4 : " + e.toString());
		}
		
	}


	private static void m3() {
		
		//데이터 읽기
		//	- 바이트 단위 읽기(ASCII)
		//	- System.in.read() 유사
		
		try {
			
			//읽기 전용 (빨대) 스트림
			FileInputStream stream
				= new FileInputStream("D:\\data.txt");
			
//			int code = stream.read();
//			System.out.println(code);
//			
//			code = stream.read();
//			System.out.println(code);
//			
//			code = stream.read();
//			System.out.println(code);
//			
//			code = stream.read();
//			System.out.println(code);
//			
//			code = stream.read();
//			System.out.println(code);
			

			
			//★외우기
			int code = -1;
			
			while((code = stream.read()) != -1){
				System.out.print((char)code);
			}
			//Bof 처음, Eof 끝을 만나서 -1을 돌려준다
			
			
			stream.close();
			
			
			
		} catch (Exception e) {
			System.out.println("m3 : " + e.toString());
		}
		
		
	}


	private static void m2() {
		try {
			
			//true : 이어 쓰기 모드
			//false(생략) : 생성 모드
			FileOutputStream stream
				= new FileOutputStream("D:\\data.txt", true);
		
			stream.write(65);
			stream.write(66);
			stream.write(67);
			
			//stream.write(13);
			//stream.write(10);
			stream.write((int)'\r');
			stream.write((int)'\n');

			stream.write((int)'A');
			stream.write((int)'B');
			stream.write((int)'C');
			
			stream.write('A');
			stream.write('B');
			stream.write('C');
			//stream.write("D");
			
			stream.write((int)'\r');
			stream.write((int)'\n');

			String str = "Hello~ Hi~ Hong!!";
			
			for(int i=0; i<str.length(); i++) {
				stream.write(str.charAt(i));
			}
			
			stream.close();
			
			System.out.println("종료");
		
			Process notepad = new ProcessBuilder("notepad.exe", "D:\\data.txt").start();
			
			
			
		} catch (Exception e) {
			System.out.println("m2 : " + e.toString());
		}
		
	}


	private static void m1() {
		//파일 입출력
		//양방향 스트링은 단방향 스트링보다 느리다.
		//	- try catch 필수 
		
		//쓰기 
		//1. 바이트 단위 쓰기
		//	- 1바이트 단위 > 문자 코드값 1바이트 >ASCII 코드 지원
		
		//파일에 데이터 저장하기
		//1. 스트림 객체 생성하기 (열기) (쓰기 전용 스트림)
		//2. 스트림 객체를 사용해서 데이터 쓰기
		//3. 스트림 객체 닫기 
		
		try {
			File file = new File("D:\\data.txt");
			
			//쓰기 전용 스트림
			// + 생성 모드 (Create Mode) : 파일이 없으면 새로 생성하고, 있으면 덮어써라
			FileOutputStream stream = new FileOutputStream(file);
			
			//쓰기 작업
			stream.write(100);
			stream.write(101);
			stream.write(102);

			//스트림 닫기 // 꼭해주기
			stream.close();
			
			//Scanner scan = new Scanner(System.in);
			//scan.hasNextLine();
		
			System.out.println("쓰기 완료");
			
		}catch (Exception e) {
			System.out.print("m1 : " + e.toString());
		}
		
		
		/*try {
			int n = 0;
			System.out.println(100 / n);
		}catch (Exception e) {
			//System.out.println(e.getMessage());
			//System.out.println(e. getStackTrace());
			System.out.println(e.toString());
		}*/
		
		
		
		
	}
	
	
	
}//Ex75
