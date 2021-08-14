package com.algorithm.run.programmers;

import java.util.Arrays;

public class MaxMin {
	
	
	public static String solution(String s) {
        String answer = "";
        int[] arr = Arrays.stream(s.split(" ")).mapToInt(data -> Integer.parseInt(data)).toArray();
        Arrays.sort(arr);
        return arr[0] + " "+ arr[arr.length - 1];
    }

	public static void main(String[] args) {
		System.out.println(solution("-1 -2 -3 -4"));

	}

}
