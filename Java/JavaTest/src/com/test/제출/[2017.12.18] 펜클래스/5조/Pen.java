package com.test.question;

public class Pen {

	private String color;
	private int ink;
	
	private static int inkAll = 0;
	private static int lineAll = 0;
	private static int circleAll = 0;
	private static int rectangleAll = 0;
	
	private int penInk = 1;
	
	
	
	public Pen() {
		this("검정", 100);
	}
	
	public Pen(String color) {
		this.setColor(color);
		this.setInk(100);
	}
	
	public Pen(int ink) {
		this.setColor("검정");
		this.setInk(ink);
		
	}
	
	public Pen(String color, int ink) {
		this.setColor(color);
		this.setInk(ink);
	}
	
	
	public void drawLine() {
		this.setInk(ink-2);
		if (this.getInk() < 0) {
			if (penInk == 1) {
			System.out.println("잉크가 다 소진되었습니다.");
			penInk--;
			}
			return;
		} else {
		System.out.printf("%s색으로 선을 그렸습니다.\n", this.getColor());
		inkAll += 2;
		lineAll++;
		}
		
	}
	
	public void drawLine(int thickness) {
		
		this.setInk(ink-(2*thickness));
		if (this.getInk() < 0) {
			if (penInk == 1) {
				System.out.println("잉크가 다 소진되었습니다.");
				penInk--;
			}
			return;
		} else {
		System.out.printf("%s색으로 선을 그렸습니다.\n", this.getColor());
		inkAll += 2*thickness;
		lineAll++;
		}
	}
	
	
	public void drawCircle() {
		this.setInk(ink-3);
		if (this.getInk() < 0) {
			if (penInk == 1) {
				System.out.println("잉크가 다 소진되었습니다.");
				penInk--;
			}
			return;
		} else {
		System.out.printf("%s색으로 원을 그렸습니다.\n", this.getColor());
		inkAll += 3;
		circleAll++;
		}
	}
	
	public void drawCircle(int thickness) {
		this.setInk(ink-(3*thickness));
		if (this.getInk() < 0) {
			if (penInk == 1) {
				System.out.println("잉크가 다 소진되었습니다.");
				penInk--;
			}
			return;
		} else {
		System.out.printf("%s색으로 원을 그렸습니다.\n", this.getColor());
		inkAll += 3 *thickness;
		circleAll++;
		}
	}
	
	public void drawRectengle() {
		this.setInk(ink-4);
		if (this.getInk() < 0) {
			if (penInk == 1) {
				System.out.println("잉크가 다 소진되었습니다.");
				penInk--;
			}
			return;
		} else {
		System.out.printf("%s색으로 사각형을 그렸습니다.\n", this.getColor());
		inkAll += 4;
		rectangleAll++;
		}
	}
	
	public void drawRectengle(int thickness) {
		this.setInk(ink-(4*thickness));
		if (this.getInk() < 0) {
			if (penInk == 1) {
				System.out.println("잉크가 다 소진되었습니다.");
				penInk--;
			}
			return;
		} else {
		System.out.printf("%s색으로 사각형을 그렸습니다.\n", this.getColor());
		inkAll += 4 * thickness;
		rectangleAll++;
		}
	}
	
	public static void report() {
		System.out.println();
		System.out.printf("모든 펜의 총 잉크 사용량 	: %d\n", inkAll);
		System.out.printf("모든 펜의 선을 그린 횟수 	: %d\n", lineAll);
		System.out.printf("모든 펜의 원을 그린 횟수 	: %d\n", circleAll);
		System.out.printf("모든 펜의 사각형을 그린 횟수	: %d\n", rectangleAll);
		
	}
	

	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getInk() {
		return ink;
	}

	public void setInk(int ink) {
		this.ink = ink;
	}
	
	
	

}
