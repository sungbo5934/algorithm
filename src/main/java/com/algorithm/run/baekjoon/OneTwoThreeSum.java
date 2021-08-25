package com.algorithm.run.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneTwoThreeSum {
	
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] answerArr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			int num = Integer.parseInt(br.readLine());
			dp(num, 0, 1);
			dp(num, 0, 2);
			dp(num, 0, 3);
			answerArr[i] = answer;
			answer = 0;
		}
		
		for(int i = 0 ; i < n ; i++) {
			System.out.println(answerArr[i]);
		}

	}
	
	public static void dp(int num, int cur, int sum) {
		int total = cur + sum;
		if(total == num) {
			answer++;
			return;
		}else if(total < num) {
			dp(num, total, 1);
			dp(num, total, 2);
			dp(num, total, 3);
		}else {
			return;
		}
	}

}
