package com.algorithm.run.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		
		if(n == 0) {
			System.out.println(0);
			return;
		}
		
		if(n == 1) {
			System.out.println(1);
			return;
		}
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2; i <= n ; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[n]);

	}

}
