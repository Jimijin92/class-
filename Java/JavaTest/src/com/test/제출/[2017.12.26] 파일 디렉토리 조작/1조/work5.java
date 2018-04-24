import java.io.File;
import java.util.ArrayList;

public class work5 {

	public static void main(String[] args) {
		
	
//	요구사항] Music_1 과 Music_2  폴더를 서로 비교해서 양쪽 폴더에 모두 존재하는 파일만을 출력하시오



	
		
		String path1 ="D:\\파일_디렉토리_문제\\동일 파일\\Music_1"; 
		String path2 ="D:\\파일_디렉토리_문제\\동일 파일\\Music_2";
		// 뮤직1과 2폴더의 주소를 스트링 으로 넣어줌
		
		
		File dir = new File(path1);
		File[] files = dir.listFiles();
		
		File dir2 = new File(path2);
		File[] files2 = dir2.listFiles();
		// 뮤직 1/2의 폴더의 파일들을 배열로 뽑아서 
		
		
		ArrayList<String> same = new ArrayList<String>();
		// 동일한 파일명을 담기 위해 선언
		
		
			for (File file : files) { //뮤직1파일을 불러옴
				for (File file2 : files2) {	//뮤직2파일을 불러옴
					if (file.getName().equals(file2.getName())) { //비교
						String name = file.getName();
						same.add(name);//same 에 동일한 이름을 넣는다.
					}
					
				}
				
			}
			
			for (int i = 0; i < same.size(); i++) {
				System.out.println(same.get(i)); // get으로 하나씩 가져와 목록을 출력
			}
	
			
	}
}
