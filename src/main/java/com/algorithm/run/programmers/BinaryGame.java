package com.algorithm.run.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryGame {
	
	public static String solution(int n, int t, int m, int p) {
        Map<String, List<String>> list = new HashMap<String, List<String>>();
        int index = 1 ;
        for(int i = 0 ; ; i ++) {
        	String str = Integer.toUnsignedString(i, n);
        	for(int j = 0; j < str.length() ; j++) {
        		if(index > m) {
        			index = 1;
        		}
        		String binaryStr = String.valueOf(str.toCharArray()[j]);
        		List<String> indexList = list.getOrDefault(String.valueOf(index), new ArrayList<String>());
        		indexList.add(binaryStr.toUpperCase());
        		list.put(String.valueOf(index), indexList);
        		index++;
        	}
        	int size = list.getOrDefault(String.valueOf(p), new ArrayList<String>()).size();
        	if(size >= t) {
        		break;
        	}
        }
        
        return list.get(String.valueOf(p)).stream().limit(t).collect(Collectors.joining(""));
    }

	public static void main(String[] args) {
		System.out.println(solution(2,4,2,1));
	}

}
