package com.algorithm.run.backjun;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Statistics {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr =  new int[n];
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int min = Integer.MAX_VALUE;
		int max = -Integer.MAX_VALUE;
		
		double total = 0;
		for(int i = 0 ; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num; 
			
			total += (double) num;
			
			map.put(num, map.getOrDefault(num, 0) + 1);
			
			min = Math.min(num, min);
			max = Math.max(num, max);
		}
		
		//산술평균
		int result1 = (int)Math.round(total / n);
		System.out.println(result1);
		//중앙값
		Arrays.sort(arr);
		int result2 = arr[n/2];
		System.out.println(result2);
		//최빈값
		List<Integer> list = map.keySet().stream().sorted((o1, o2) ->{
			if( map.get(o2) > map.get(o1)) {
				return 1;
			}else if( map.get(o2) == map.get(o1)) {
				if( o1 > o2) {
					return 1;
				}else if( o1 < o2) {
					return -1;
				}else {
					return 0;
				}
			}else {
				return -1;
			}
		}).collect(Collectors.toList());
		
		if(list.size() > 1 && map.get(list.get(0)) == map.get(list.get(1))) {
			System.out.println(list.get(1));
		}else {
			System.out.println(list.get(0));
		}
		//범위
		int result4 = max - min;
		System.out.println(result4);
		
	}

}
