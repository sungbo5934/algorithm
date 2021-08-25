package com.algorithm.run.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Tiling {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n == 1) {
			System.out.println(1);
			return;
		}
		if(n == 2) {
			System.out.println(2);
			return;
		}
		BigInteger[] dp = new BigInteger[n+1];
		dp[1] = BigInteger.valueOf(1);
		dp[2] = BigInteger.valueOf(2);;
		for(int i = 3 ; i <= n ; i ++) {
			dp[i] = dp[i-1].add(dp[i-2]);
		}
		System.out.println(dp[n].mod(BigInteger.valueOf(10007)));
		//System.out.println(dp[n] % 10007);
	}

}
