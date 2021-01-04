package com.algorithm.run.git;

import java.io.IOException;
import java.util.*;


public class StringStreet {
	static String O;
	static String N;
	static char[] oArr;
	static char[] nArr;
	static boolean[][] visited;
	static boolean[] visitedCnt;
	static int cnt = 0;

	public static void main(String[] args) throws IOException{
		
		Scanner sc = new Scanner(System.in);

		O = sc.nextLine();
		N = sc.nextLine();
		oArr = O.toCharArray();
		nArr = N.toCharArray();
		
		visited = new boolean[oArr.length][nArr.length];
		visitedCnt = new boolean[nArr.length];
		
		for(int i = 0 ; i < oArr.length ; i++) {
			
			for(int j = 0 ; j < nArr.length ; j++) {
				if(oArr[i] == nArr[j]) {
					visited[i][j] = true;
				}
			}

		}
		int k = 0;
		for(int i = 0 ; i < visited.length ; i++) {
			for(int j = 0 ; j < visited[i].length ; j++) {
				if(visited[0][j]) {
					
				}else if(visited[i][j] && j > k) {
					
				}
				
			}
		}
		
		
		for(int i = 0 ; i < visitedCnt.length ; i++) {
			if(i == 0 && visitedCnt[i] == false) {
				cnt++;
			}else if(i == 0 && visitedCnt[i] == true) {
				
			}else {
				if(visitedCnt[i - 1] == true && visitedCnt[i] == false) {
					cnt++;
				}
			}
		}
		

	}


}

