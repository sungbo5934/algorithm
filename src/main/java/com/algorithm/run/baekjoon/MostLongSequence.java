package com.algorithm.run.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MostLongSequence {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(data -> Integer.valueOf(data)).toArray();
		int[] dp = new int[cnt];
		
		dp[0] = 1;
		
		for(int i = 1; i < cnt ; i++) {
			dp[i] = 1;
			int total = 0;
			for(int j = 0; j < i ; j++) {
				if(arr[i] > arr[j]) {
					total = Math.max(total, dp[j]);
				}
			}
			dp[i] = total + dp[i];
		}
		int answer = 0;
		for(int i = 0; i < cnt ; i++) {
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}

}
