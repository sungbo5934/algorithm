package com.algorithm.run.bfs;

import java.util.HashSet;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class BfsRun2 {
	//문제 url : https://www.acmicpc.net/problem/17090
	//U인 경우에는 (r-1, c)로 이동해야 한다. 위
	//R인 경우에는 (r, c+1)로 이동해야 한다. 오른쪽
	//D인 경우에는 (r+1, c)로 이동해야 한다. 아래
	//L인 경우에는 (r, c-1)로 이동해야 한다  왼쪽
	
	static int H  = 0;
	static int W = 0;
	static int count = 0;
	static String[][] miroArr;
	static HashSet<String> hashSet;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String hwStr = sc.nextLine();
		H = Integer.parseInt(hwStr.split(" ")[0]);
		W = Integer.parseInt(hwStr.split(" ")[1]);
		miroArr =  new String[H][W];
		for(int i = 0 ; i < H ; i++) {
			String scStr = sc.nextLine();
			for(int j = 0 ; j <scStr.length() ; j++) {
				miroArr[i][j] = scStr.charAt(j) +  "" ;
			}
		}
		for(int i = 0 ; i < H ; i++) {
			for(int j = 0 ; j < W ; j++) {
				hashSet = new HashSet<String>();
				hashSet.add(i + "," + j);
				bfs(i ,j );
			}
		}
		System.out.println("탈출 칸 : " + count);

	}
	
	static void bfs(int xIndex ,  int yIndex ) {
		 String code = miroArr[xIndex][yIndex];
		 if(StringUtils.equals(code, "U")) {
			 int xMove = xIndex - 1;
			 int yMove = yIndex;
			 if(xMove < 0) {
				 System.out.println("xIndex : " + xIndex + ", yIndex + : "+yIndex);
				 count ++;
			 }else {
				 String rememIndex = xMove + "," + yMove;
				 if(hashSet.contains(rememIndex)) {
					 
				 }else {
					 hashSet.add(rememIndex);
					 bfs( xMove, yMove );
				 }
			 }
		 }
		 
		 if(StringUtils.equals(code, "R")) {
			 int xMove = xIndex;
			 int yMove = yIndex + 1;
			 
			 if(yMove >= W) {
				 System.out.println("xIndex : " + xIndex + ", yIndex + : "+yIndex);
				 count ++;
			 }else {
				 String rememIndex = xMove + "," + yMove;
				 if(hashSet.contains(rememIndex)) {
					 
				 }else {
					 hashSet.add(rememIndex);
					 bfs( xMove, yMove );
				 }
			 }
		 }
		 
		 if(StringUtils.equals(code, "D")) {
			 int xMove = xIndex + 1;
			 int yMove = yIndex;
			 
			 if(xMove >= H) {
				 System.out.println("xIndex : " + xIndex + ", yIndex + : "+yIndex);
				 count ++;
			 }else {
				 String rememIndex = xMove + "," + yMove;
				 if(hashSet.contains(rememIndex)) {
					 
				 }else {
					 hashSet.add(rememIndex);
					 bfs( xMove, yMove );
				 }
			 }
		 }
		 
		 if(StringUtils.equals(code, "L")) {
			 int xMove = xIndex;
			 int yMove = yIndex - 1;
			 
			 if(yMove < 0) {
				 System.out.println("xIndex : " + xIndex + ", yIndex + : "+yIndex);
				 count ++;
			 }else {
				 String rememIndex = xMove + "," + yMove;
				 if(hashSet.contains(rememIndex)) {
					 
				 }else {
					 hashSet.add(rememIndex);
					 bfs( xMove, yMove );
				 }
			 }
		 }
		
	}

}
