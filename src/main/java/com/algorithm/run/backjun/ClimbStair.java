package com.algorithm.run.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ClimbStair {

	static int[] arr;
	static boolean[] dp;
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		dp = new boolean[n+1];
		dp(1,0);
		dp(2,0);
		
	}
	
	public static void dp(int index, int cnt) {
		if(index >= n) {
			System.out.println(Arrays.toString(dp));
			return;
		}else {
			if(cnt < 2) {
				dp[index + 1] = true;
				dp(index + 1, cnt + 1);
				
				dp[index + 1] = false;
				dp[index + 2] = true;
				dp(index + 2, 1);
			}else {
				dp[index+2] = true;
				dp(index+2, 1);
			}
		}
	}

}
