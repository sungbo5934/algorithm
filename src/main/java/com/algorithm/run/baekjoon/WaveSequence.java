package com.algorithm.run.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaveSequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		long[] answer = new long[cnt];
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		dp[6] = 3;
		dp[7] = 4;
		dp[8] = 5;
		dp[9] = 7;
		dp[10] = 9;
		for(int i = 11 ; i <= 100 ; i++) {
			dp[i] = dp[i - 1] + dp[i - 5];
		}
		for(int i = 0 ; i < cnt ; i++) {
			int index = Integer.parseInt(br.readLine());
			answer[i] = dp[index];
		}
		
		for(int i = 0 ; i < cnt ; i++) {
			System.out.println(answer[i]);
		}

	}

}
