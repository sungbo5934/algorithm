package com.algorithm.run.baekjoon;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class SortInside {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		Integer[] arr = new Integer[n.length()];
		for(int i = 0 ; i < n.length() ; i++) {
			arr[i] = Integer.valueOf(String.valueOf(n.charAt(i)));
		}
		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		System.out.println(Arrays.stream(arr).map(data -> data.toString()).collect(Collectors.joining("")));
		
	}

}
