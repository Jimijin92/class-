package com.common;

import java.util.ArrayList;

public class Pickdays {
	private ArrayList<String> pickday = new ArrayList<String>();
	
	public Pickdays(String[] days) {
		
		for(int i =0; i<days.length;i++) {
			if(days[i].equals("*")) {
				days[i] = "";
			}else {
				pickday.add(days[i]);
			}
		}
		for(int j =0; j<pickday.size();j++) {
			if(pickday.get(j).equals("")) {
				pickday.remove(j);
				j--;
			}else {
				break;
			}
			
		}
	}
	public ArrayList<String> getPickday() {
		return pickday;
	}
	
	
}
