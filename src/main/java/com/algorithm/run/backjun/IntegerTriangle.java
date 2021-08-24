package com.algorithm.run.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IntegerTriangle {
	
	static int[][] arr;
	static int[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1][n+1];
		dp = new int[n+1][n+1];
		
		for(int i = 1 ; i <= n ; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0 ; j < str.length ; j++) {
				arr[i][j+1] = Integer.parseInt(str[j]);
			}
			
		}
		
		dp[1][1] = arr[1][1];
		
		for(int i = 1 ; i < n ; i++) {
			for(int j = 1 ; j <= i ; j++) {
				dp[i+1][j]  = Math.max(dp[i][j] + arr[i+1][j], dp[i+1][j]);
				dp[i+1][j+1] = dp[i][j] + arr[i+1][j+1];
			}
		}
		
		System.out.println(Arrays.stream(dp[n]).max().getAsInt());

	}

}
