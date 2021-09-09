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
		List<Integer> list = new ArrayList<Integer>();
		int[] dp = new int[cnt];
		list.add(arr[0]);
		dp[0] = 1;
		for(int i = 1 ; i < cnt; i++) {
			if(arr[i-1] > arr[i]) {
				if(dp[i-1] > 1) {
					
				}else {
					list = new ArrayList<Integer>();
					list.add(arr[i]);
				}
			}else if(arr[i-1] < arr[i]) {
				list.add(arr[i]);
				dp[i] = dp[i - 1] + 1;
			}else {
				dp[i] = dp[i - 1];
			}

		}
	}

}
