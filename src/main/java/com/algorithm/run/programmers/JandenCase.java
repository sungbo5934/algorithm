package com.algorithm.run.programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class JandenCase {
	
	
	public static String solution(String s) {
        s = s.toLowerCase();
        char[] answerArr = new char[s.toCharArray().length];
        boolean chk =false;
        for(int i = 0 ; i < s.toCharArray().length ; i++) {
        	if(!chk) {
        		answerArr[i] = String.valueOf(s.toCharArray()[i]).toUpperCase().charAt(0);
        		chk = true;
        	}else {
        		answerArr[i] = s.toCharArray()[i];
        	}
        	
        	if(s.toCharArray()[i] == ' ') {
        		chk = false;
        	}
        }
        
        return String.valueOf(answerArr);
    }

	public static void main(String[] args) {
		System.out.println(solution("3people  7 mefa5 ada"));

	}

}
