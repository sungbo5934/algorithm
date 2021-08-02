package com.algorithm.run.programmers;

import java.util.*;
import java.util.Arrays;

public class TwoBit {

	 public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int index = 0;
        for(long number : numbers) {
        	String str = Long.toBinaryString(number);
        	
        	if(str.charAt(str.length() - 1) == '0') {
        		answer[index] = number+1;
        	}else {
        		str = "0" + str;
        		int strIndex = str.lastIndexOf("01");
        		char[] strChar = new char[str.toCharArray().length];
        		for(int i = 0 ; i < str.toCharArray().length ; i++) {
        			if(strIndex == i) {
        				strChar[i] = '1';
        			}else if(strIndex+1 == i) {
        				strChar[i] = '0';
        			}else {
        				strChar[i] = str.toCharArray()[i];
        			}
        		}
        		str = new String(strChar);
        		answer[index] = Long.parseLong(str, 2);
        	}
        	
        	index++;	
        }
        
        return answer;
    }
 
	public static void main(String[] args) {
		List<Long> list = new ArrayList<Long>();
		for(int i = 0 ; i < 1016 ; i++) {
			list.add((long)i);
			
		}
		System.out.println(Arrays.toString(solution(list.stream().mapToLong(data -> data).toArray())));

	}

}
