package com.algorithm.run.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class SortingWord {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<String>();
		for(int i = 0 ; i < n ; i++) {
			String str = br.readLine();
			set.add(str);
		}
		List<String> list = set.stream().sorted(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() < o2.length()) {
					return -1;
				}else if(o1.length() > o2.length()) {
					return 1;
				}else {
					return o1.compareTo(o2);
				}
			}
		}).collect(Collectors.toList());
		
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}

	}

}
/**
 * 
13
but
i
wont
hesitate
no
more
no
more
it
cannot
wait
im
yours
 */