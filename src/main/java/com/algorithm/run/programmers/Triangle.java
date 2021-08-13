package com.algorithm.run.programmers;

import java.util.Arrays;

public class Triangle {

    public static int solution(int[][] triangle) {
        int[][] original = new int[triangle.length][];
        
        for(int i = 0 ; i < original.length ; i++) {
        	original[i] = new int[triangle[i].length];
        	for(int j = 0 ; j < triangle[i].length ; j++) {
        		original[i][j] = triangle[i][j];
            }
        }
        
        int x = 0;
        for(int i = 0 ; i < triangle.length - 1; i++) {
        	for(int j = 0 ; j <= x ; j++) {
        		int num = original[i][j];
        		original[i+1][j]   = Math.max(original[i+1][j], triangle[i+1][j] + num);
        		original[i+1][j+1] = Math.max(original[i+1][j+1], triangle[i+1][j+1] + num);
        	}
        	x++;
        }
        return Arrays.stream( original[original.length - 1]).max().getAsInt();
    }
    
	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(triangle));;

	}

}
