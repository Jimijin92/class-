package com.common;

public class Time {
	//1. 멤버변수 
	int hour;
	int min;
	int hour2;
	int min2;
	
	private String totalTime;



	public Time(String StartTime , String times) {
		
		String[] temp = StartTime.split(":");
		String[] temp2 = times.split(":");

		
		int[] iTemp = new int[temp.length];
		int[] iTemp2 = new int[temp2.length];
		

		
		for(int i =0; i<temp.length;i++) {
			iTemp[i] = Integer.parseInt(temp[i]);
		}
		
		for(int i =0; i<temp2.length;i++) {
			iTemp2[i] = Integer.parseInt(temp2[i]);
		}
		
		hour = iTemp[0];
		min = iTemp[1];
		

		hour2 = iTemp[0]+ iTemp2[0];
		min2 = iTemp[1]+ iTemp2[1];
		
		if(min == 60) {
			hour = hour +1;	
		}
		

		
	}
	public String getTotalTime() {
		//return String.format("%d:%d", hour,min);
		return  hour +":"+ min + "~" +hour2+":"+min2;
	}
	

}
