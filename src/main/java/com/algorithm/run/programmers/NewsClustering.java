package com.algorithm.run.programmers;

import java.util.*;
import java.util.Map;

public class NewsClustering {
	
	public static int solution(String str1, String str2) {
        int min = 0;
        int max = 0;
        
        str1 = str1.toLowerCase();
        Map<String, Integer> str1Map = new HashMap<String, Integer>();
        
        str2 = str2.toLowerCase();
        Map<String, Integer> str2Map = new HashMap<String, Integer>();
        
        if(str1.equals(str2)) {
        	return 65536;
        }
        
        for(int i = 0  ; i < str1.length() ; i++) {
        	if(i + 1 < str1.length()) {
        		String str = String.valueOf(str1.charAt(i)) + String.valueOf(str1.charAt(i + 1));
        		if(str.replaceAll("[^a-z]", "").length() != str.length()) {
        			continue;
        		}
        		str1Map.put(str, str1Map.getOrDefault(str, 0) + 1);
        	}
        }
        
        for(int i = 0  ; i < str2.length() ; i++) {
        	if(i + 1 < str2.length()) {
        		String str = String.valueOf(str2.charAt(i)) + String.valueOf(str2.charAt(i + 1));
        		if(str.replaceAll("[^a-z]", "").length() != str.length()) {
        			continue;
        		}
        		str2Map.put(str, str2Map.getOrDefault(str, 0) + 1);
        	}
        }
        //교집합
        for(String key : str1Map.keySet()) {
        	int str1Cnt = str1Map.getOrDefault(key, 0);
        	int str2Cnt = str2Map.getOrDefault(key, 0);
        	if(str1Cnt !=  0 && str2Cnt != 0) {
        		min += Math.min(str1Cnt, str2Cnt);
        	}	
        }
        
        //합집함
        for(String key : str1Map.keySet()) {
        	int str1Cnt = str1Map.getOrDefault(key, 0);
        	int str2Cnt = str2Map.getOrDefault(key, 0);
        	if(str1Cnt !=  0 && str2Cnt != 0) {
        		max += Math.max(str1Cnt, str2Cnt);
        	}else{	
        		max += str1Cnt;
        	}
        }
        
        for(String key : str2Map.keySet()) {
        	int str1Cnt = str1Map.getOrDefault(key, 0);
        	int str2Cnt = str2Map.getOrDefault(key, 0);
        	if(str1Cnt !=  0 && str2Cnt != 0) {
        	}else{	
        		max += str2Cnt;
        	}	
        }
        
        //System.out.println("min : " + min);
        //System.out.println("max : " + max);
        //System.out.println( (int)((double )min /max * 65536));
        return (int)((double )min /max * 65536);
    }

	public static void main(String[] args) {
		System.out.println(solution("E=M*C^2", "e=m*c^2"));;
	}

}
