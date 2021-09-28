package com.algorithm.run.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;

public class ClimbNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		BigDecimal[][] dp = new BigDecimal[n+1][11];
		if(n == 1) {
			System.out.println(10);
		}else if(n == 2) {
			System.out.println(55);
		}else {

			for(int i = 10 ; i  > 0 ; i--) {
				dp[2][10 - i] = BigDecimal.valueOf(i);
			}
			dp[2][10] = BigDecimal.valueOf(55);
			
			for(int i = 3 ; i <= n ; i++) {
				BigDecimal sum = BigDecimal.valueOf(0);
				dp[i][0] = dp[i -1][10];
				sum = sum.add(dp[i][0]);
				for(int j = 1 ; j < 10 ; j++) {
					BigDecimal cnt = dp[i][j - 1].subtract(dp[i-1][j-1]);
					dp[i][j] = cnt;
					sum = sum.add(cnt);
				}
				dp[i][10] = sum;
			}
			System.out.println(dp[n][10].remainder(BigDecimal.valueOf(10007)));
		}
		

	}

}
