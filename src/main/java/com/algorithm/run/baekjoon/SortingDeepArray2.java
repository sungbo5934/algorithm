package com.algorithm.run.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class SortingDeepArray2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[][] arr =  new Integer[n][2];
		for(int i = 0 ; i < n ; i++) {
			String str = br.readLine();
			arr[i][0] = Integer.parseInt(str.split(" ")[0]);
			arr[i][1] = Integer.parseInt(str.split(" ")[1]);
		}
		
		Arrays.sort(arr, new Comparator<Integer[]>() {

			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				if(o1[1] > o2[1]) {
					return 1;
				}else if(o1[1] < o2[1]) {
					return -1;
				}else {
					if(o1[0] > o2[0]) {
						return 1;
					}else if(o1[0] < o2[0]) {
						return -1;
					}else {
						return 0;
					}
				}
			}
		});
		
		for(int i = 0 ; i < n ; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}

	}

}
