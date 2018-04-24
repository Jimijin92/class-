package com.test.question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

import com.test.collection.Member;

public class File_Test {

	public static void main(String[] args) {
		// TODO File_Test
		// m1();
//		 m2();
		 m3();
//		 m4();
//		 m5();
//		 m6();
		// m7();
//		m8();

	}

	private static void m8() {
		// TODO 심플 콘솔 메모장
		//
		// 요구사항]
		// - 메뉴 : 1. 쓰기
		// 2. 읽기
		//
		// - 지난 예제 참조
		//
		//
		// 1. 쓰기 기능
		// a. 이름 // 입력
		// . 년월일 시분초 // calendar 사용
		// . 메모 내용 // 입력 - 한줄입력
		//
		//
		// 2. 읽기 기능
		// . 모두 가 출력
		//
		// 추가]
		// 1. 메모 내용을 여러줄 출력하게
		// 2. 최신 메모를 먼저 출력
		//
		//
		// 작성자 : 홍길동
		// 날짜 :2017-12-20
		// 메모
		// 메모
		// ========
		// 홍길동
		// 2017-12-20
		// 메모
		// 메모
		// 메모
		// ========

		Scanner scan = new Scanner(System.in);

		System.out.println("프로그램을 시작합니다.");

		boolean loop = true;
		// Scanner scan = new Scanner(System.in);

		while (loop) {

			// 메뉴 > 선택 > 해당 업무 실행 > 메뉴 > 선택..
			System.out.println("==================================================");
			System.out.println("콘솔 메모장");
			System.out.println("1. 메모 쓰기");
			System.out.println("2. 메모 읽기");
			System.out.println("3. 종료");
			System.out.println("==================================================");
			System.out.print("선택(번호입력) : ");

			String sel = scan.nextLine();

			if (sel.equals("1")) {
				addMemo();
			} else if (sel.equals("2")) {
				readMemo();
			} else {
				loop = false;
				// scan.close();
			} // if

		} // while

		System.out.println("프로그램을 종료합니다");

	}

	private static void readMemo() {
		// TODO readMemo

		String path = "D:\\memo.txt";

		try {

			BufferedReader reader = new BufferedReader(new FileReader(path));

			String line = "";

			// while (reader.readLine() != null) {
			// String txt = reader.readLine();
			// System.out.println(txt);
			// }

			while ((line = reader.readLine()) != null) {

				System.out.printf("%s\n", line);

			}

			reader.close();

		} catch (Exception e) {
			System.out.println("m9 : " + e.toString());
		}

	}

	private static void addMemo() {
		// TODO addMemo
		Scanner scan = new Scanner(System.in);
		System.out.println("작성자의 이름과 메모를 기입하고 '[종료]'를 입력하세요.");

		String path = "D:\\memo.txt";

		boolean memoBool = false;

		File memo = new File(path);

		ArrayList<String> memolist = new ArrayList<String>();

		if (memo.length() != 0) {
			memoBool = true;
		}

		if (memo.exists()) {
			if (memo.isFile()) {
				if (memoBool) {
					try {

						BufferedReader reader = new BufferedReader(new FileReader(path));

						String line = "";

						while ((line = reader.readLine()) != null) {

							memolist.add(line);

						}

						reader.close();

					} catch (Exception e) {
						System.out.println("m9 : " + e.toString());
					}
				}
			}

		}

		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(path));

			System.out.print("작성자 : ");
			String memoName = scan.nextLine();
			String writerName = String.format("작성자 : %s", memoName);
			Calendar memoCal = Calendar.getInstance();

			// System.out.println(memoCal);
			String writeCal = String.format("날짜 : %tF", memoCal);

			writer.write(writerName);
			writer.newLine();
			writer.write(writeCal);
			writer.newLine();

			while (true) {
				String txt = scan.nextLine();

				if (txt.equals("[종료]")) {

					if (memolist != null) {
						writer.write("======================================================");
						writer.newLine();

						for (int i = 0; i < memolist.size(); i++) {

							String oldMemo = String.format("%s", memolist.get(i));
							writer.write(oldMemo);
							writer.newLine();

						}
					}

					break;

				}
				writer.write(txt);
				writer.newLine();

			}

			writer.close();

		} catch (Exception e) {
			System.out.println("addMemo : " + e.toString());
		}

	}

	private static void m1() {
		// TODO m1
		// 문제1.
		//
		// 요구사항] 음악 파일이 100개 있다. 파일명 앞에 숫자를 붙이시오.
		// 리소스] 음악파일
		// 결과]
		// [001]7 go up-Yum-yum (얌얌).mp3
		// [002]10cm-봄이 좋냐.mp3
		// [003]10cm - 스토커.mp3
		// ..
		// [100]

		String path = "D:\\_Class\\파일_디렉토리_문제\\음악 파일\\Music";
		String pathOri = "D:\\_Class\\파일_디렉토리_문제\\음악 파일\\Music";
		File musicDir = new File(path);

		File[] files = musicDir.listFiles();

		if (musicDir.exists()) {

			String dest = "D:\\_Class\\파일_디렉토리_문제\\음악 파일\\Music";

			String num = "";

			for (int i = 0; i < files.length; i++) {

				num = zeroplus(i + 1);

				String fileName = String.format("%s", files[i]);
				String destFileName = String.format("%s\\[%s]%s", pathOri, num, files[i].getName());

				path = fileName;
				dest = destFileName;

				File musicFile = new File(path);
				File musicDest = new File(dest);

				musicFile.renameTo(musicDest);

				path = pathOri;
				dest = pathOri;

			}

		}
		System.out.println("변경이 완료 되었습니다.");

	}

	private static String zeroplus(int i) {

		// Scanner scan = new Scanner(System.in);
		//
		// System.out.printf("숫자 : ");
		// String num = scan.nextLine();
		String num = i + "";

		if (num.length() == 1) {
			// System.out.printf("00" + num);
			num = String.format("00%s", num);
			// System.out.println();
		} else if (num.length() == 2) {
			num = String.format("0%s", num);
			// System.out.printf("0" + num);
			// System.out.println();
		} else if (num.length() == 3) {
			num = String.format("%s", num);
			// System.out.print(num);
			// System.out.println();
		} else {
			// System.out.println("정해진 범위가 아님");
		}

		return num;

	}

	private static void m2() {
		// TODO m2
		// 문제2.
		//
		// 요구사항] 이미지 파일이 확장자별로 있다. 확장자 별로 몇개인지 카운트
		// 리소스] 확장자별 카운트
		// 결과] *.gif : *개
		// *.jpg : *개
		// *.png : *개
		//
		// 추가] mouse.bmp 추가
		// -> 소스 수정없이 *.bmp : 1개
		// 힌트] hashMap 사용

		String path = "D:\\_Class\\파일_디렉토리_문제\\확장자별 카운트";

		File extensionDir = new File(path);

		File[] files = extensionDir.listFiles();
		HashMap<String, Integer> hashExtension = new HashMap<String, Integer>();
		ArrayList<String> arrayExtension = new ArrayList<String>();

		if (extensionDir.exists()) {

			int n = 0;

			
			for (File file : files) {

				String fileExtension = String.format("%s", files[n]);
				
				
				int feriodNum = fileExtension.indexOf(".");
				
				String extension = fileExtension.substring(feriodNum);
				
				if (hashExtension.get(extension) != null) {
					hashExtension.put(extension, (hashExtension.get(extension)+1));
					
				} else {
					hashExtension.put(extension, 1);
					arrayExtension.add(extension);
				}

					n++;

				
			}
			
			
			for (int i=0; i<hashExtension.size(); i++) {
				
				String result = String.format("*%s : %d개", arrayExtension.get(i), hashExtension.get(arrayExtension.get(i)));
				System.out.println(result);
				
			}
			
			System.out.println(hashExtension.toString());

		}

	}

	private static void m3() {
		// TODO m3

		String path = "D:\\_Class\\파일_디렉토리_문제\\폴더 삭제\\delete";

		File dir = new File(path);
		int countdir =0;
		int countFile =0;

		
		countFile = delFileCount(dir, countFile, path);
		countdir = delDirCount(dir, countdir, path);
		
		System.out.printf("폴더 %d개와 파일%d를 삭제 했습니다.", countdir, countFile);
		

	}
	
	private static int delFileCount(File dir, int countFile, String path) {
		if (dir.exists()) {

			File[] files = dir.listFiles();

			String newPath = path;

			for (File subdir : files) {

				if (subdir.isDirectory()) {
					// 부모와 동일한 업무 다시 반복

					newPath = subdir.getPath();
					countFile = delFileCount(subdir, countFile, newPath);
					// System.out.println(newPath);

				}

			}

			for (File file : files) {

				if (file.isFile()) {
					// 이 부분이 업무에 맞게 수정 -> 해당 폴더와 관련된 정보를 취득할 수 있다.
					// length += file.length();
//					String delFile = newPath + "\\" + file.getName();

					file.delete();
					countFile++;
				}

			}

		}
		return countFile;
	}

	private static int delDirCount(File dir, int countDir, String path) {//, int length
		if (dir.exists()) {
			
			File[] files = dir.listFiles();
	
			String newPath = path;
			String delPath = newPath;
			
			for (File subdir : files) {
				
				if (subdir.isDirectory()) {
					//부모와 동일한 업무 다시 반복
										
					newPath = subdir.getPath();
//					delPath = newPath;
					countDir = delDirCount(subdir, countDir, newPath);
//					System.out.println(newPath);
					subdir.delete();
					countDir++;
					
					
				}
				
			}

			
		
			
			
		}
		return countDir;
	}
	

	private static void m4() {
		// TODO m4
		
		String path = "D:\\_Class\\파일_디렉토리_문제\\파일 제거";

		File dir = new File(path);
		
		int count = 0;		
		
		if (dir.exists()) {
			File[] files = dir.listFiles();
			
			for (File file : files) {
				if (file.isFile()) {
					if (file.length() == 0) {
						
						file.delete();
						count++;
						
					}
				}
			}
			
		}
		
		String result = String.format("총 %d개의 파일을 삭제 했습니다.", count);
		System.out.println(result);
		

	}

	private static void m5() {
		// TODO m5
		String path = "D:\\_Class\\파일_디렉토리_문제\\동일 파일";
		
		File dir = new File(path);
		HashMap<String, Integer> fileName = new HashMap<String, Integer>();

		ArrayList<String> fileNameArray = new ArrayList<String>();
		
		if (dir.exists()) {

			File[] files = dir.listFiles();
			
			for (File file : files) {
			
				if (file.isDirectory()) {
				
					File[] files2 = file.listFiles();
					
					for (File file2 : files2) {
					
						if (file2.isFile()) {

							if (fileName.get(file2.getName()) == null) {

								fileName.put(file2.getName(), 1);

							} else {
						
								fileName.put(file2.getName(), fileName.get(file2.getName()) + 1);
								if (fileName.get(file2.getName())==2) {
									fileNameArray.add(file2.getName());
								}

							}

						}

					}

				}

			}

			System.out.println("동일파일 검색 결과 : ");
			for(int i = 0; i<fileNameArray.size(); i++) {
				
				System.out.println(fileNameArray.get(i));
				
			}
			
		}

	}

	private static void m6() {
		// TODO m6
		
		String path = "D:\\_Class\\파일_디렉토리_문제\\크기 정렬";

		File dir = new File(path);

	}

	private static void m7() {
		// TODO m7

	}

}
