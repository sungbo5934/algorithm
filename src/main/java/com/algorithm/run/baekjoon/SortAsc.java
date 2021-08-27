package com.algorithm.run.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SortAsc {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine()); 
		}
		Arrays.sort(arr);
		StringBuilder b = new StringBuilder();
		for(int i = 0 ; i < n; i++) {
			b.append(arr[i] + "\n");
		}
		System.out.println(b);
		//System.out.println( Arrays.stream(arr).collect(Collectors.joining("\n")));
		
	}

}
