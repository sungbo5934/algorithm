package com.algorithm.run.programmers;

import java.util.Arrays;

public class ArrayMultyple {
	
	
	public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i = 0 ; i < arr1.length ; i++) {
        	for(int k =0 ; k < arr2[0].length ; k++) {
        		int num = 0;
        		for(int j = 0 ; j < arr1[0].length ; j++) {
        			//System.out.println("i : " + i + ", k : "+k+", j : " + j);
        			num += arr1[i][j] * arr2[j][k];
                }
        		//System.out.println(num);
        		answer[i][k] = num;
        	}
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] num1 = {{1, 4}, {3, 2}, {4, 1}};		
		int[][] num12 = {{3, 3}, {3, 3}};				
		int[][] num2 = {{2, 3, 2 ,2}, {4, 2, 4,2}, {3, 1, 4,2}};	
		int[][] num22 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}, {3, 1, 1}};	
		System.out.println(Arrays.deepToString(solution(num1,num12 )));
	}

}
