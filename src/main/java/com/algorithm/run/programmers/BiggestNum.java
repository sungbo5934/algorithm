package com.algorithm.run.programmers;

import java.util.*;
import java.util.Comparator;
import java.util.stream.Collectors;

public class BiggestNum {
	
	public static String solution(int[] numbers) {
        String[] arr = Arrays.stream(numbers).mapToObj(data -> String.valueOf(data)).toArray(data -> new String[data]);
        Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo((o1 +o2));
			}
		});
        String answer = Arrays.stream(arr).collect(Collectors.joining(""));
        return answer.charAt(0) == '0' ? "0" : answer;
    }

	public static void main(String[] args) {
		int[] arr = {0,3, 30, 34, 5, 9};
		System.out.println(solution(arr));

	}

}
