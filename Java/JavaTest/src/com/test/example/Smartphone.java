package com.test.example;

import java.util.Scanner;

import temp.Tablet;

//import com.test.util.utility;
//import temp.Tablet;
//import temp.Time;
//import temp.*;

public class Smartphone {

	
	
	
	
	
	
	
	
	
	
	
	
	
	//다른 클래스를 참조해서 사용하는 경우..
	//1. 현재 클래스와 같은 패키지내에 들어있는 클래스
	Smartphone iphone = new Smartphone();
	com.test.example.Smartphone galaxy
	= new com.test.example.Smartphone();
	
	//2. 현재 클래스와 다른 패키지내에 들어있는 클래스
	temp.Tablet ipad = new temp.Tablet();
	Tablet ipad2 = new Tablet();
	
	//같은 패키지의 Time 사용
	//com.test.example.Time t1 = new com.test.example.Time();
	
	Scanner scan = new Scanner(System.in);
	
	//다른 패키지의 Time 사용
	//Time t2 = new Time();
	//temp.Time t3 = new temp.Time();
	
	Time t4 = new Time();
	
	//현재 소스의 모든 import 대상을 자동으로 처리
	//	-> Ctrl + Shift + o
}















