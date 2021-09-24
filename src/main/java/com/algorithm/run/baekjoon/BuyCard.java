package com.algorithm.run.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuyCard {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int[] num = new int[cnt + 1];
		int[] dp = new int[cnt + 1];
		String[] str = br.readLine().split(" ");
		for(int i = 1 ; i <= cnt ; i++) {
			num[i]  = Integer.parseInt(str[i-1]);
		}
		
		for(int i = 1 ; i <= cnt ; i++) {
			for(int j = 1 ; j <= i ; j++) {
				dp[i] = Math.max(dp[i], dp[i - j] + num[j]);
			}
		}
		
		System.out.println(dp[cnt]);

	}

}
