package com.algorithm.run.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciNumber2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		long[] dp = new long[91];
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2 ; i <= 90; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[cnt]);
	}

}
