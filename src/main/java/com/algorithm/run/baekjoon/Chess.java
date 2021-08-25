package com.algorithm.run.backjun;

import java.util.*;

public class Chess {
	
	static int y;
	static int x;
	static String[][] arr;
	
	public static int find(int yIndex, int xIndex, String type, String reType) {
		//왼쪽위 W
		int cnt1 = 0;
		for(int i  = yIndex ; i < yIndex + 8 ; i++) {
			for(int j  = xIndex ; j < xIndex + 8 ; j++) {
				String color = arr[i][j];
				if(i % 2 == 0) {
					if(j % 2 == 0) {
						if(!color.equals(type)) {
							cnt1++;
						}
					}else {
						if(!color.equals(reType)) {
							cnt1++;
						}
					}
				}else {
					if(j % 2 == 0) {
						if(!color.equals(reType)) {
							cnt1++;
						}
					}else {
						if(!color.equals(type)) {
							cnt1++;
						}
					}
				}
			}
		}
		return cnt1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = Integer.MAX_VALUE;
		String yx = sc.nextLine();
		String yStr = yx.split(" ")[0];
		String xStr = yx.split(" ")[1];
		y = Integer.parseInt(yStr);
		x = Integer.parseInt(xStr);
		arr = new String[y][x];
		
		for(int i  = 0 ; i < y ; i++) {
			String str = sc.nextLine();
			for(int j  = 0 ; j < x ; j++) {
				arr[i][j] = str.split("")[j];
			}
		}
		for(int i = 0 ; i <= y - 8 ; i++) {
			for(int j = 0 ; j <= x - 8 ; j++) {
				int cnt1 = find(i, j, "W", "B");
				int cnt2 = find(i, j, "B", "W");
				answer = Math.min(answer, Math.min(cnt1, cnt2));
			}
		}
		
		
		System.out.println(answer);
	}

}
