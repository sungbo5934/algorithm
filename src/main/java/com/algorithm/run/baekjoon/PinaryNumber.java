package com.algorithm.run.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PinaryNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		long dp[][] = new long[cnt+1][2];
		if(cnt == 1 || cnt == 2) {
			System.out.println(1);
		}else {
			dp[2][0] = 1;
			dp[2][1] = 0;
			for(int i = 3 ; i <= cnt ; i++) {
				dp[i][0] = dp[i-1][0] + dp[i-1][1];
				dp[i][1] = dp[i-1][0];
			}
			System.out.println(dp[cnt][0] + dp[cnt][1]);
		}
	}

}
