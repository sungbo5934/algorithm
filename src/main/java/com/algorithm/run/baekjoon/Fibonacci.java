package com.algorithm.run.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Fibonacci {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] answerArr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			int num = Integer.parseInt(br.readLine());
			answerArr[i] = num;
		}
		
		int max = Arrays.stream(answerArr).max().getAsInt();
		String[] dp = new String[max + 1]; 
		dp[0] = "1,0";
		dp[1] = "0,1";
		for(int i = 2 ; i <= max ; i++) {
			dp[i] = (Integer.parseInt(dp[i -1].split(",")[0]) + Integer.parseInt(dp[i -2].split(",")[0])) +"," + (Integer.parseInt(dp[i -1].split(",")[1]) + Integer.parseInt(dp[i -2].split(",")[1]));
		}
		
		for(int i = 0 ; i < n ; i++) {
			System.out.println(dp[answerArr[i]].split(",")[0] + " " + dp[answerArr[i]].split(",")[1]);
		}

	}


}
