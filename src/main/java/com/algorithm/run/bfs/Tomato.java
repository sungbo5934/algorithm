package com.algorithm.run.bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;


public class Tomato {
	
	public static int[][][] xyzTomato;
	public static int curDayMax = 1;
	
	public static int xLength;
	public static int yLength;
	public static int zLength;
	
	public static Queue<String> que;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String boxInfoStr =sc.nextLine();
		xLength = Integer.parseInt(boxInfoStr.split(" ")[0]);
		yLength = Integer.parseInt(boxInfoStr.split(" ")[1]);
		zLength = Integer.parseInt(boxInfoStr.split(" ")[2]);
		
		xyzTomato = new int[xLength][yLength][zLength];
		
		que = new ArrayDeque<String>();
		
		for(int i  = 0 ; i < yLength * zLength ; i++) {
			String tomatoInfoStr =sc.nextLine();
			String[] tomatoInfoArr = tomatoInfoStr.split(" ");
			
			for(int j = 0 ; j < tomatoInfoArr.length ; j++) {
				int xyz = Integer.parseInt(tomatoInfoArr[j]);
				int xIndex = j;
				int yIndex = i - ((i/yLength) * yLength);
				int zIndex = i/yLength;
					
				xyzTomato[xIndex][yIndex][zIndex] = xyz;
				
				if(xyz == 1) {
					que.add(xIndex+ "," + yIndex + "," + zIndex);
				}
			}
			
		}
		while(!que.isEmpty()) {
			String indexStr = que.poll();
			moveTomato(indexStr);
		}
		boolean chk = false;
		
		Loof1:
		for(int i = 0 ; i < zLength ; i ++) {
			for(int j = 0 ; j < yLength ; j ++) {
				for(int k = 0 ; k < xLength ; k ++) {
					if(xyzTomato[k][j][i] == 0) {
						chk = true;
						break Loof1;
					}
				}
			}
		}
		
		if(chk) {
			System.out.println(-1);
		}else {
			System.out.println(curDayMax - 1);
		}
		
	}
	public static void up(int curDay) {
		if(curDayMax < curDay ) {
			curDayMax = curDay;
		}
	}
	
	public static void moveTomato(String indexStr) {
		
		
		int xIndex = Integer.parseInt(indexStr.split(",")[0]);
		int yIndex = Integer.parseInt(indexStr.split(",")[1]);
		int zIndex = Integer.parseInt(indexStr.split(",")[2]);
		
		int curDay = xyzTomato[xIndex][yIndex][zIndex] + 1;
		
		if(xIndex - 1 > -1 ) {
			int x = xIndex - 1;
			if(xyzTomato[x][yIndex][zIndex] == 0) {
				xyzTomato[x][yIndex][zIndex] = curDay;
				que.add(x+","+yIndex+","+zIndex);
				up(curDay);
			}
		}
		
		if(xIndex + 1 < xLength ) {
			int x = xIndex + 1;
			if(xyzTomato[x][yIndex][zIndex] == 0) {
				xyzTomato[x][yIndex][zIndex] = curDay;
				que.add(x+","+yIndex+","+zIndex);
				up(curDay);
			}
		}
		
		if(yIndex - 1 > -1 ) {
			int y = yIndex - 1;
			if(xyzTomato[xIndex][y][zIndex] == 0) {
				xyzTomato[xIndex][y][zIndex] = curDay;
				que.add(xIndex+","+y+","+zIndex);
				up(curDay);
			}
		}
		
		if(yIndex + 1 < yLength ) {
			int y = yIndex + 1;
			if(xyzTomato[xIndex][y][zIndex] == 0) {
				xyzTomato[xIndex][y][zIndex] = curDay;
				que.add(xIndex+","+y+","+zIndex);
				up(curDay);
			}
			
		}
		
		if(zIndex - 1 > -1 ) {
			int z = zIndex - 1;
			if(xyzTomato[xIndex][yIndex][z] == 0) {
				xyzTomato[xIndex][yIndex][z] = curDay;
				que.add(xIndex+","+yIndex+","+z);
				up(curDay);
			}
		}
		
		if(zIndex + 1 < zLength ) {
			int z = zIndex + 1;
			if(xyzTomato[xIndex][yIndex][z] == 0) {
				xyzTomato[xIndex][yIndex][z] = curDay;
				que.add(xIndex+","+yIndex+","+z);
				up(curDay);
			}
		}
		
		
		
	}
}
