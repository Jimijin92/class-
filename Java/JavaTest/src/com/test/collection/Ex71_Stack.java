package com.test.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex71_Stack {

	public static void main(String[] args) {
		
		
		//Ex71_Stack.java
		
		//Queue, 큐
		//	- 선입선출
		//	- FIFO, First Input First Output
		//	- 소비하고 끝
		
		//Stack, 스택
		//	- 후입선출
		//	- LIFO, Last Input First Output
		//	- 소비하고 끝
		
		//m1();
		m2();
		
		
		
	}//main

	private static void m1() {
		
		//   ===================
		//-> 노랑	파랑		빨강 ->
		//   ===================
		Queue<String> queue = new LinkedList<String>();
		
		//1. 요소 추가
		queue.add("빨강");
		queue.add("파랑");
		queue.add("노랑");
		
		//2. 요소 갯수
		System.out.println(queue.size());
		
		//2.5 
		System.out.println(queue.peek());
		System.out.println(queue.size());
		
		//3. 요소 접근
		System.out.println(queue.poll());
		System.out.println(queue.size());
		
		System.out.println(queue.poll());
		System.out.println(queue.size());

		System.out.println(queue.poll());
		System.out.println(queue.size());
		
		System.out.println(queue.poll());
		System.out.println(queue.size());
		
		
		
		queue.add("빨강");
		queue.add("주황");
		queue.add("노랑");
		queue.add("초록");
		queue.add("파랑");
		queue.add("남색");
		queue.add("보라");
	
		
		//큐 -> 루프
		//1. 일반 for
		//향상된 for문
		
		/*System.out.println(queue.size());
		
		int size = queue.size();
		
		for (int i=0; i<queue.size(); i++) {
			System.out.println(queue.poll());
		}*/
		
		
		
		/*for (String color : queue){
		 System.out.println(color));
		}
		
		
		System.out.println(queue.size());
		
		while(true) {
			System.out.println(pueue.poll());
			if(queue.size() == 0)
				break;
			
			
		while(queue.size>0) {
			System.out.println(pueue.poll());
		}
		
		System.out.println(queue.sizze());*/
		
		
		
		queue.clear();
		queue.contains("빨강");
		//queue.isEmpty();
		queue.remove("빨강"); //X
		
			
		}
			
	

	
	private static void m2() {
			//   =====================
			//-> 노랑	파랑		빨강  |
			//   =====================
		
		
			Stack<String> stack = new Stack<String>();
			
			stack.push("빨강");
			stack.push("파랑");
			stack.push("노랑");
			
			System.out.println(stack.peek());
			System.out.println(stack.size());
			
			System.out.println(stack.pop());
			System.out.println(stack.size());
			
			System.out.println(stack.pop());
			System.out.println(stack.size());
			
			System.out.println(stack.pop());
			System.out.println(stack.size());
			
//			System.out.println(stack.pop());
//			System.out.println(stack.size());
			
	}
}
