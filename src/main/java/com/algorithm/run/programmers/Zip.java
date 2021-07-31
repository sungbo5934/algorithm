package com.algorithm.run.programmers;

import java.util.*;

public class Zip {
	static List<String> list = new ArrayList<String>();
	
	public static void init() {
		for(int i = 0 ; i < 26  ; i++) {
			list.add(String.valueOf((char)(65 + i)));
		}
	}
	
	public static int[] solution(String msg) {
		init();
        List<Integer> anserList = new  ArrayList<Integer>();
        loof1:
        for(int i = 0 ; i < msg.toCharArray().length ; i++) {
        	int start = i;
        	int end = i + 1;
        	int answerIndex = 0;
        	for(;;) {
        		String str = msg.substring(start, end);
        		int index = list.indexOf(str);
        		if(index > -1) {
        			answerIndex = index ;
        			if(end == msg.toCharArray().length) {
        				anserList.add(answerIndex + 1);
        				break loof1;
        			}else {
            			end++;
        			}
        		}else {
        			list.add(str);
        			anserList.add(answerIndex +1 );
        			i  = end - 2;
        			break;
        		}
        	}
        	
        }
        return anserList.stream().mapToInt(data -> data).toArray();
    }

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("ABABABABABABABAB")));;
	}

}
