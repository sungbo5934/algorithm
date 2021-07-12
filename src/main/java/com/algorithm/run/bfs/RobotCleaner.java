package com.algorithm.run.bfs;

import java.util.Scanner;

public class RobotCleaner {
	
	public static int[][] xyArr;
	public static int yIndex;
	public static int xIndex;
	public static boolean result = true;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String xyStr =  sc.nextLine();
		
		yIndex =  Integer.parseInt(xyStr.split(" ")[0]);
		xIndex =  Integer.parseInt(xyStr.split(" ")[1]);
		xyArr = new int[xIndex][yIndex];
		String curStr =  sc.nextLine();
		Robot robot = new Robot(Integer.parseInt(curStr.split(" ")[0]), Integer.parseInt(curStr.split(" ")[1]), Integer.parseInt(curStr.split(" ")[2]), 0);
		
		for(int i =0 ; i < yIndex ; i ++) {
			String yStr = sc.nextLine();
			String[] yArr = yStr.split(" ");
			for(int j = 0 ; j < xIndex; j++) {
				xyArr[j][i] = Integer.parseInt(yArr[j]);
			}
			
		}
		
		search(robot);
		
		
		
		
	}
	
	public static void search(Robot robot) {
		
		
			if(xyArr[robot.getX()][robot.getY()] == 0) {
				robot.setClean(robot.getClean() + 1);
				xyArr[robot.getX()][robot.getY()] = 2;
			}
			
			if(xyArr[robot.getX()-1][robot.getY()] != 0
					&& xyArr[robot.getX()+1][robot.getY()] != 0
					&& xyArr[robot.getX()][robot.getY()-1] != 0
					&& xyArr[robot.getX()][robot.getY()+1] != 0) {
				
				if(robot.getSearch() == 0 ) {
					if(robot.getY() + 1 < yIndex && xyArr[robot.getX()][robot.getY() + 1] != 1) {
						robot.setY(robot.getY() + 1);
						search(robot);
						return;
					}else {
						System.out.println(robot.getClean());
						result = false;
						return;
					}
	
				}
				
				if(robot.getSearch() == 1  ) {
					if(robot.getX() - 1 >= 0 && xyArr[robot.getX() - 1 ][robot.getY()] != 1) {
						robot.setX(robot.getX() - 1);
						search(robot);
						return;
					}else {
						System.out.println(robot.getClean());
						result = false;
						return;
					}
				}
				
				if(robot.getSearch() == 2 ) {
					if(robot.getY() - 1 >= 0 && xyArr[robot.getX()][robot.getY() - 1] != 1) {
						robot.setY(robot.getY() - 1);
						search(robot);
						return;
					}else {
						System.out.println(robot.getClean());
						result = false;
						return;
					}
				}
				
				if(robot.getSearch() == 3 ) {
					if(robot.getX() + 1 < xIndex && xyArr[robot.getX() + 1][robot.getY()] != 1) {
						robot.setX(robot.getX() + 1);
						search(robot);
						return;
					}else {
						System.out.println(robot.getClean());
						result = false;
						return;
					}
				}
				
	
			}
	
			if(robot.getSearch() == 0 ) {
				if(robot.getX()-1 >= 0 && xyArr[robot.getX()-1][robot.getY()] != 1 && xyArr[robot.getX()-1][robot.getY()] != 2){
					robot.setX(robot.getX()-1);
					robot.setSearch(3);
					search(robot);
					return;
				}else {
					robot.setSearch(3);
					search(robot);
					return;
				}
			}
			
			if(robot.getSearch() == 1  ) {
				if(robot.getY() - 1 >=  0 && xyArr[robot.getX()][robot.getY() - 1] != 1 && xyArr[robot.getX()][robot.getY() - 1] != 2){
					robot.setY(robot.getY() - 1);
					robot.setSearch(0);
					search(robot);
					return;
				}else {
					robot.setSearch(0);
					search(robot);
					return;
				}	
			}
			
			if(robot.getSearch() == 2 ) {
				if(robot.getX() + 1 < xIndex && xyArr[robot.getX()+1][robot.getY()] != 1 && xyArr[robot.getX()+1][robot.getY()] != 2){
					robot.setX(robot.getX()+1);
					robot.setSearch(1);
					search(robot);
					return;
				}else {
					robot.setSearch(1);
					search(robot);
					return;
				}
			}
			
			if(robot.getSearch() == 3 ) {
				if(robot.getY() + 1 <  yIndex && xyArr[robot.getX()][robot.getY() + 1] != 1 && xyArr[robot.getX()][robot.getY() + 1] != 2){
					robot.setY(robot.getY() + 1);
					robot.setSearch(2);
					search(robot);
					return;
				}else {
					robot.setSearch(2);
					search(robot);
					return;
				}
			}
			
		
	}

}


class Robot{
	private int y;
	private int x;
	private int search;
	private int clean;
	
	public Robot(int y, int x, int search, int clean) {
		super();
		this.y = y;
		this.x = x;
		this.search = search;
		this.clean = clean;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getSearch() {
		return search;
	}

	public void setSearch(int search) {
		this.search = search;
	}

	public int getClean() {
		return clean;
	}

	public void setClean(int clean) {
		this.clean = clean;
	}
	
	
}
