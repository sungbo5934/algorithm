package com.algorithm.run.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Wine {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] liter = new int[cnt];
		for(int i = 0 ; i < cnt ; i ++) {
			liter[i] = Integer.parseInt(br.readLine());
		}
		map.put(0, 0);
		map.put(1, liter[0]);
		
		for(int i = 1 ; i < cnt ; i++) {
			int cnt0 = 0;
			int cnt1 = 0;
			int cnt2 = 0;
			for(Integer key : map.keySet()) {
				
				if(key == 0) {
					cnt1 = Math.max(cnt1, map.get(key) + liter[i]);
					cnt0 = Math.max(cnt0, map.get(key)); 
				}else if(key == 1) {
					cnt2 = Math.max(cnt2, map.get(key) + liter[i]);
					cnt0 = Math.max(cnt0, map.get(key));
				}else if(key == 2) {
					cnt0 = Math.max(cnt0, map.get(key));
				}
			}
			map.put(0, cnt0);
			map.put(1, cnt1);
			map.put(2, cnt2);
		}
		
		int answer = 0;
		for(Integer key : map.keySet()) {
			answer =  Math.max(answer, map.get(key));
		}
		
		System.out.println(answer);

	}

}
