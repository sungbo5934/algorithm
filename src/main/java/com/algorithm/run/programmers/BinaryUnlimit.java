package com.algorithm.run.programmers;

import java.util.Arrays;

public class BinaryUnlimit {
	
	static int cnt0;
	static int transCnt;
	public static int[] solution(String s) {
		
        int[] answer = new int[2];
        if(!s.equals("1")) {
        	trans(s);
        }
        answer[0] = transCnt;
        answer[1] = cnt0;
        return answer;
    }
	
	public static void trans(String s) {
		
		transCnt++;
		int oriLength = s.length();
		s = s.replace("0", "");
		int transLength = s.length();
		
		cnt0 += (oriLength - transLength);
		
        String transStr = Long.toBinaryString(transLength);
        
        if(transStr.equals("1")) {
        	return;
        }else {
        	trans(transStr);
        	return;
        }
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("1111111")));

	}

}
