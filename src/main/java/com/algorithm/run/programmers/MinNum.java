package com.algorithm.run.programmers;

import java.util.Arrays;

	public class MinNum {
		
		public static int solution(int []A, int []B){
			int answer = 0;
		    Arrays.sort(A);
		    Arrays.sort(B);
		    for(int i = 0 ; i < A.length ; i++) {
		    	answer += A[i] * B[A.length - 1 -i];
		    }
		    
		    return answer;
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int []A = {1,2};
			int []B = { 4, 3};
			System.out.println(solution(A,B));
	
		}

}
