package com.algorithm.run.programmers;
import java.util.*;
public class BankDp {


    static int answer = 0;;

    public static int solution(int[] T, int[][] R, int k) {
    	int[] dp = new int[T.length + 1];
    	dp[1] = T[0];
    	for(int i = 2 ; i <= k ; i++) {
    		List<Integer> list = new ArrayList<Integer>();
    		for(int j = 0 ; j < R.length ; j++) {
    			if(R[j][1] == i) {
                    list.add(R[j][0]);
                }
    		}
    		int total = 0 ;
    		for(int l = 0 ; l < list.size() ; l++) {
    			total = Math.max(total, dp[list.get(l)] + T[i -1]) ;
            }
    		dp[i] = total;
            
        }
    	
    	
        return dp[k];
    }

	public static void main(String[] args) {
		int[] T = {5,4,6,8,1};
		int[][] R = {{2,4},{1,4},{4,5},{3,5},{2,3}};
		int k = 5;
		System.out.println(solution(T,R,k));
	}

}
