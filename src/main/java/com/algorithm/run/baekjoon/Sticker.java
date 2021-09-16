package com.algorithm.run.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sticker {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int answer[] = new int[cnt];
		for(int i = 0 ; i < cnt ; i++) {
			int arrCnt = Integer.parseInt(br.readLine());
			int num[][] = new int[arrCnt][2];
			int dp[][] = new int[arrCnt][2];
			
			int[] str1 = Arrays.stream(br.readLine().split(" ")).mapToInt(data -> Integer.valueOf(data)).toArray();
			int[] str2 = Arrays.stream(br.readLine().split(" ")).mapToInt(data -> Integer.valueOf(data)).toArray();
			
			for(int j = 0 ; j < arrCnt ; j++) {
				num[j][0] = str1[j];
				num[j][1] = str2[j];
			}
			
			for(int j = 0 ; j < arrCnt ; j++) {
				if(j == 0) {
					dp[j][0] = num[j][0];
					dp[j][1] = num[j][1];
				}else if(j == 1) {
					dp[j][0] = num[j-1][1] + num[j][0];
					dp[j][1] = num[j-1][0] + num[j][1];
				}else {
					dp[j][0] = Math.max(dp[j-2][0]+ num[j-1][1] + num[j][0], dp[j-2][1] + num[j][0]);
					dp[j][1] = Math.max(dp[j-2][1]+ num[j-1][0] + num[j][1], dp[j-2][0] + num[j][1]);
				}
			}
			
			answer[i] = Math.max(dp[arrCnt -1][0], dp[arrCnt - 1][1]);
		}
		for(int i = 0 ; i < cnt ; i++) {
			System.out.println(answer[i]);
		}

	}

}
