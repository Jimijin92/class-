package com.project2.mvc;

import com.project2.mvc.manager.model.BasicInfoDAO;
import com.project2.mvc.manager.view.BasicInfoView;
import com.project2.mvc.manager.view.ManagerView;

public class MainClass {
	
	public static void main(String[] args) {
		
		ManagerView view = new ManagerView();
		
		//view.menu();
		
		BasicInfoDAO dao = new BasicInfoDAO();
		
		dao.subjectList();
		System.out.println();
		dao.courseList();
		System.out.println();
		dao.classRoomList();
		System.out.println();
		dao.bookList();
		System.out.println();
		dao.publisherList();
		 System.out.println("┍━━━━━━━┐");
         System.out.println("│┻┻┻┻┻┻┻│");
         System.out.println("│   ⌒         ⌒    │");
         System.out.println("│   డ             డ    │");
         System.out.println("│          ᗜ            │");
         System.out.println("│                      │");
         System.out.println("└───────┘");

        
             System.out.println("┍━━━━━━━┐");
             System.out.println("│┻┻┻┻┻┻┻│");
             System.out.println("│    ⌒        ⌒    │");
             System.out.println("│    ఠ           ఠ      │");
             System.out.println("│         ᗜ             │");
             System.out.println("│                      │");
             System.out.println("└───────┘");
             System.out.println("┍━━━━━━━┐");
             System.out.println("│┻┻┻┻┻┻┻│");
             System.out.println("│   ⌒         ⌒    │");
             System.out.println("│    ᗒ            ᗕ     │");
             System.out.println("│         ᗜ             │");
             System.out.println("│                      │");
             System.out.println("└───────┘");


	}

}
