package com.algorithm.run.programmers;

import java.math.BigInteger;

public class Fibonacci {
	
	
	public static int solution(int n) {
		BigInteger[] dp =  new BigInteger[n+1];
        
        dp[0] = BigInteger.valueOf(0);
        dp[1] = BigInteger.valueOf(1);
        for(int i =2 ; i <= n ; i++) {
        	dp[i] = dp[i-2].add(dp[i-1]);
        	
        }
        return dp[n].remainder(BigInteger.valueOf(1234567)).intValue();
    }

	public static void main(String[] args) {
		
		System.out.println(solution(100000));
	}

}
