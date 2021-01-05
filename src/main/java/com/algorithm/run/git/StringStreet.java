package com.algorithm.run.git;

import java.io.IOException;
import java.util.*;


public class StringStreet {

	static char[] O;
	static char[] N;
	static boolean[][] visited;
	static boolean[] visitedCnt;
	static int count = 0;
	static int totalCnt= -1;

	public static void main(String[] args) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		String oStr = sc.nextLine();
		String nStr = sc.nextLine();

		O = oStr.toCharArray();
		N = nStr.toCharArray();
		
		if(oStr.equals(nStr)) {
			System.out.println(0);
			return;
		}
		
		visited = new boolean[O.length][N.length];
		visitedCnt = new boolean[N.length]; 
		for(int i = 0 ; i < O.length ; i++) {
			for(int j = 0 ; j < N.length ; j++) {
				if(O[i] == N[j]) {
					visited[i][j] = true;
				}
			}

		}
		
		for(int i = 0 ; i < visited[0].length ; i++) {
			if(visited[0][i]) {
				bfs( 0 , i);
			}
		}
		
		
		
		System.out.println(totalCnt);

	}
	
	static void bfs(int x , int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x , y , null));
		
		while(!q.isEmpty()) {
			Point p   = q.poll();
			int xIndex = p.x;
			int yIndex = p.y;
			
			if(xIndex == O.length - 1) {
				totalVisitCnt(p.sb.toString());
				continue;
			}
			
			int limit = N.length - O.length + xIndex + 2;
			for(int i = yIndex + 1 ; i < limit  ; i++) {
				if(visited[xIndex + 1][i] ) {
					q.add(new Point(xIndex + 1 ,  i , p.sb.toString()));
				}
			}
			
		}
	}
	static void totalVisitCnt(String str) {
		count = 0;

		for(int i = 0 ; i < str.split(",").length ; i++) {
			for(int j = 0 ; j <visitedCnt.length ; j++) {
				if(Integer.parseInt(str.split(",")[i]) == j) {
					visitedCnt[j]  = true;
				}else {
					visitedCnt[j]  = false;
				}
			}
		}
		
		for(int i = 0 ; i <visitedCnt.length ; i++) {
			if( i == 0 && !visitedCnt[0]) {
				count++;
			}else {
				if(visitedCnt[i -1] == true && visitedCnt[i] == false) {
					count++;
				}
			}
		}
		
		if(totalCnt < 0) {
			totalCnt = count;
		}else {
			if(totalCnt >= count) {
				totalCnt = count;
			}
		}
		
	}
	
	static class Point{
		int x;
		int y;
		int[] intArr;
		StringBuilder sb  = new StringBuilder();
		
		public Point(int x, int  y, String str) {
			this.x = x;
			this.y = y;
			if(str == null || str.equals("")) {
				
			}else {
				sb.append(str);
				sb.append(",");
			}
			sb.append(y);
			
		}
	}


}

