package com.test.collection;

import java.util.Iterator;
import java.util.TreeSet;

public class Ex86_Collection {

	public static void main(String[] args) {
		
		//Ex86_Collection.java
		
		//TreeSet
		//	- Set : 중복값X, 순서X(-> 정렬X)
		//	- 자동 정렬(데이터를 관리할 때 항상 정렬된 상태로 관리) -> 순서가 있어 "보이는" set을 만들고 싶을때 !
		//	- 트리구조(이진 검색 트리 구조) -> 자식 개수가 2개로 고정 
		//	- 정렬O + 검색, 범위 검색 용이(***)	
	
		//m1();
		//m2();
		m3();
	}

	private static void m3() {
		
		//TreeSet<User> set = new TreeSet<User>();
		
		//1. Comparator 사용해서 해결
		
/*		
 		TreeSet<User> set = new TreeSet<User>(new Comparator<User>() {
			
			public int compare(User o1, User o2) {
				return o1.getTotalPoint() - o2.getTotalPoint();
			}
			
		});
*/
		
		//2. Comparable 사용해서 해결
		TreeSet<User> set = new TreeSet<User>();
		
		
		set.add(new User("가가가", 44, 96));
		set.add(new User("나나나", 34, 67));
		set.add(new User("다다다", 23, 21));
		set.add(new User("라라라", 87, 23));
		set.add(new User("마마마", 55, 45));
		set.add(new User("바바바", 89, 36));
		set.add(new User("사사사", 93, 54));
		set.add(new User("아아아", 77, 78));
		
		System.out.println(set);
	
		User u1 = new User("홍길동", 100, 100);
		User u2 = new User("아무개", 50, 50);
		
		System.out.println(u1.compareTo(u2) > 0);  // 홍길동이 더 높은 점수를 가지고 있니? 
		//System.out.println(u1 > u2); //안되는 식
		
		
		
	}

	
	
	
	
	
	private static void m2() {
		TreeSet<String> set = new TreeSet<String>();
		
		set.add("가방");
		set.add("가다랭이");
		set.add("가죽");
		set.add("강아지");
		set.add("다이소");
		set.add("갑순이");
		set.add("나방");
		set.add("나이순");
		set.add("다리");
		set.add("라면");
		set.add("가위");
		set.add("나이테");
		set.add("강도");
		set.add("라디오");
		set.add("나비");
		set.add("라식");
	
		
		System.out.println(set);
		
		System.out.println(set.subSet("나", "라"));
		System.out.println(set.headSet("다")); //-> 끝위치 나타냄, 처음부터 다 전까지 
		System.out.println(set.tailSet("다")); //-> 시작위치 나타냄, 다 부터 끝까지 
		
		
		
		//Set -> iterator
		Iterator<String> iter = set.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		
		
		iter = set.descendingIterator();

		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		
		
	}

	private static void m1() {
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		for(int i=0; i<10; i++) {
			int num = (int)(Math.random()* 100) + 1; //1~100
			set.add(num);
			
		}
		
		
		System.out.println(set);
		
		
	}
}


//class User {
//	private String name;
//	private int point;
//	private int bonus;
//	
//	public User(String name, int point, int bonus) {
//		this.name = name;
//		this.point = point;
//		this.bonus = bonus;
//	}
//	
//	public String toString() {
//		return String.format("%s(%d)", this.name, this.point + this.bonus);
//	}
//	
//	public int getTotalPoint() {
//		return this.point + this.bonus;
//	}	
//}






class User implements Comparable<User> {
	private String name;
	private int point;
	private int bonus;
	
	public User(String name, int point, int bonus) {
		this.name = name;
		this.point = point;
		this.bonus = bonus;
	}
	
	public String toString() {
		return String.format("%s(%d)", this.name, this.point + this.bonus);
	}
	
	public int getTotalPoint() {
		return this.point + this.bonus;
	}

	@Override
	public int compareTo(User user) {
		
		return user.getTotalPoint() - this.getTotalPoint();
	}	
}




























