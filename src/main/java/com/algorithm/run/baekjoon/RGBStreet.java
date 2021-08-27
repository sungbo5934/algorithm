package com.algorithm.run.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RGBStreet {
	
	static int n = 0;
	static int answer = Integer.MAX_VALUE;
	static int[][] arr;
	static int[][] rgbArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][3];
		rgbArr = new int[n+1][3];
		
		for(int i = 1 ; i <= n ; i++) {
			String[] str = br.readLine().split(" ");
			rgbArr[i][0] = Integer.parseInt(str[0]);
			rgbArr[i][1] = Integer.parseInt(str[1]);
			rgbArr[i][2] = Integer.parseInt(str[2]);
			
		}
		arr[1][0] = rgbArr[1][0];
		arr[1][1] = rgbArr[1][1];
		arr[1][2] = rgbArr[1][2];
		for(int i = 2 ; i <= n ; i++) {
			arr[i][0] = Math.min(arr[i-1][1] + rgbArr[i][0], arr[i-1][2] + rgbArr[i][0]);
			arr[i][1] = Math.min(arr[i-1][0] + rgbArr[i][1], arr[i-1][2] + rgbArr[i][1]);
			arr[i][2] = Math.min(arr[i-1][0] + rgbArr[i][2], arr[i-1][1] + rgbArr[i][2]);
		}
		
		System.out.println(Arrays.stream(arr[n]).min().getAsInt());
		
	}
	


}
