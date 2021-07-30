package com.algorithm.run.programmers;

import java.util.*;

public class Endtalk {
	
	public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = 0;
        boolean failChk = false;
        Set<String> set = new HashSet<String>();
        String lastWord = "";
        int index = 0;
        for(int i = 0 ; i < words.length ; i++) {
        	if(i != 0 ) {
        		if(!String.valueOf(words[i].charAt(0)).equals(lastWord)) {
        			failChk = true;
        			index = i;
        			break;
        		}
        	}
        	if(set.contains(words[i])) {
        		failChk = true;
        		index = i;
        		break;
        	}else {
        		set.add(words[i]);
        	}
        	lastWord = String.valueOf(words[i].charAt(words[i].length() -1));
        }
        
        int fail = (index + 1)  % n;
        int cnt = (int) Math.ceil((double)(index + 1) / n);
    	if(fail == 0 ) {
    		fail = n;
    	}
    	
    	if(!failChk) {
	   		 answer[0] = 0;
	   	     answer[1] = 0;
	   	     return answer;
    	}else {
    		answer[0] = fail;
    		answer[1] = cnt;
    	}

        return answer;
    }

	public static void main(String[] args) {
		String[] str = {"hello", "one", "even", "never", "now", "world", "draw"};
		System.out.println(Arrays.toString(solution(2, str)));

	}

}
