package com.test.collection;

public class NewCollectionTest {

	public static void main(String[] args) {
		
		NewArrayList list = new NewArrayList();
		
		list.add("하나");
		list.add("둘");
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));

		System.out.println(list.get(2));
		System.out.println(list.get(7));//실제배열은 4갠데 우리는 2개까지 있는걸로 알고 있어서
		
		System.out.println(list.size());
		
		list.set(0, "one");
		System.out.println(list.get(0));
		
		//list.set(2, "three"); //만약에 예외처리 없었으면 이거 들어갔음
		
		//[0][0][][]	
		//[0][0][][]
		list.remove(0);
		
		System.out.println(list.get(1));
		
	}

	
	
	
	
}











